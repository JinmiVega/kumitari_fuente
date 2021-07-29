package pe.gob.procalidad.natigu.web.gestion.controller.configuracion;

import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.io.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.EtiquetaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.TraduccionBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaNivelBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.TraduccionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;

@Controller
@Scope(value="session")
@RequestMapping(value = "traduccionController")
public class TraduccionController extends BaseController{
	
	private TraduccionBean traduccionBean;
	private List<MaestraBean> lstTipoEtiqueta;
	private List<TraduccionBean> lstTraduccionBean;
	private List<LenguaBean> lstLenguaBean;
	private Integer cantidad = 0;
	
	@Autowired
	private LenguaService  lenguaService;
	
	@Autowired
	private TraduccionService traduccionService;
	
	@Autowired
	private Maestra1Service maestra1Service;
	
	@Autowired
	private PeticionService peticionService;
	
	@PostConstruct
	public void init(){
		this.setTraduccionBean(new TraduccionBean());
		this.setLstTipoMensaje(new ArrayList<MaestraBean>());
		this.setLstTraduccionBean(new ArrayList<TraduccionBean>());
		this.setLstLenguaBean(new ArrayList<LenguaBean>());
	}

	public TraduccionController() {
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("traduccionBean") TraduccionBean traduccionBean)throws Exception {
		System.out.println("----Ingreso al listado Traduccion----");
		System.out.println("traduccionBean"+traduccionBean);
		ModelAndView mav = new ModelAndView("configuracion/listado-traduccion", "command",traduccionBean);
		mav.addObject("lstTraduccionBean", new ArrayList<TraduccionBean>());
		mav.addObject("traduccionBean", traduccionBean);
		this.listarCombos(mav);
		return mav;
	}
	private void listarCombos(ModelAndView mav){
		System.out.println("lstTipoEtiqueta"+lstTipoEtiqueta);
		System.out.println("lstLenguaBean"+lstLenguaBean);
			try {
				lstTipoEtiqueta = this.maestra1Service.listarPorCodigoTabla("tipoEtiqueta", 0);
				lstLenguaBean = this.getLenguaService().cargarCombo();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		mav.addObject("lstLenguaBean",lstLenguaBean);
		mav.addObject("lstTipoEtiqueta",lstTipoEtiqueta);
	}
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView nuevo() throws Exception {
		traduccionBean = new TraduccionBean();

		ModelAndView mav = new ModelAndView("configuracion/registro-traduccion", "command", new TraduccionBean());

		mav.addObject("lstLenguaBean", lstLenguaBean);
		
		mav.addObject("traduccionBean", new TraduccionBean());
		

		return mav;
	}
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	
	public ModelAndView doGrabarMensaje(@RequestBody TraduccionBean[] lstTraduccion,
			 					 HttpServletResponse response,
			 					  HttpServletRequest request ){
		System.out.println("-----Ingreso a traduccion ----");

		Long valor = null;
		
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		Boolean validatePeticion = false;
		
		if(u != null) {
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("TraduccionController/grabar");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	validatePeticion = true;
		        }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			try {
				if(validatePeticion) {
					
					if(lstTraduccion!=null){
						for (int i = 0; i < lstTraduccion.length; i++) {
							traduccionBean = lstTraduccion[i];
							traduccionBean.setLengua(new LenguaBean());
							traduccionBean.getLengua().setCodigo(traduccionBean.getCodigoLengua());
							this.setAuditoria(traduccionBean, request, true);
							this.getTraduccionService().insertar(traduccionBean);
							valor = traduccionBean.getCodigoTraduccion();
						}
						traduccionBean = new TraduccionBean();
						traduccionBean.setLengua(new LenguaBean());
						traduccionBean.getLengua().setCodigo(lstTraduccion[0].getCodigoLengua());
						traduccionBean.setEtiqueta(new EtiquetaBean());
						traduccionBean.getEtiqueta().setTipoEtiqueta(new MaestraBean());
						traduccionBean.getEtiqueta().getTipoEtiqueta().setCodigoRegistro(lstTraduccion[0].getTipoEtiqueta());
						lstTraduccionBean = (List<TraduccionBean>) this.getTraduccionService().getBuscarPorFiltros(traduccionBean);
						
						if (lstTraduccionBean != null && lstTraduccionBean.size()>0) {
							cantidad = lstTraduccionBean.size();
						}else{
							System.out.println("lista vacia");
							cantidad = 0;
						}
					}

				}
					
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			
			ModelAndView mav = new ModelAndView("configuracion/ajax/listado-traduccion", "command",traduccionBean);
			
			mav.addObject("lstTraduccionBean", lstTraduccionBean);
	
			return mav;
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesión no es valida, por favor inicie sesión nuevamente");
			return mav;
		}
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscarListado(@ModelAttribute("traduccionBean") TraduccionBean traduccionBean)
			throws Exception {
		return this.getLista(traduccionBean);
	}
	private ModelAndView getLista(TraduccionBean traduccionBean) {
		
		List<TraduccionBean> lstTraduccionBean = new ArrayList<TraduccionBean>();
		
		try {
			lstTraduccionBean = (List<TraduccionBean>) this.getTraduccionService().getBuscarPorFiltros(traduccionBean);
			
			if (lstTraduccionBean != null && lstTraduccionBean.size()>0) {
				cantidad = lstTraduccionBean.size();
			}else{
				System.out.println("lista vacia");
				cantidad = 0;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView("configuracion/listado-traduccion", "command",traduccionBean);
		
		mav.addObject("lstTraduccionBean", lstTraduccionBean);
		mav.addObject("traduccionBean", traduccionBean);
		mav.addObject("cantidad", cantidad);
		this.listarCombos(mav);
		return mav;
	}
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	@ResponseBody
	public String eliminar(@RequestParam("codigo") Long codigo, HttpServletRequest request) {
		boolean sw = false;
		TraduccionBean traduccionBean = new TraduccionBean();
		String valor = "";
		
		try {	
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("TraduccionController/eliminar");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	traduccionBean.setCodigoTraduccion(codigo);
	        	this.setAuditoria(traduccionBean, request, false);
	        	sw = (this.getTraduccionService().eliminar(traduccionBean));	        	
	        }

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("sw "+ sw);
		if (sw) {
			valor = "1";
		}else{
			valor = "0";
		}
		return valor;
	}
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doModificar(@RequestParam("codigo") Long codigo ,HttpServletRequest request) {
		TraduccionBean oTraduccionBean = new TraduccionBean();
		oTraduccionBean.setCodigoTraduccion(codigo);
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try {
				traduccionBean = this.getTraduccionService().getBuscarPorObjecto(oTraduccionBean);
				if (traduccionBean != null) {
					
				}else{
					System.out.println("obj vacio");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			ModelAndView mav = new ModelAndView("configuracion/registro-traduccion", "command", traduccionBean);
			mav.addObject("traduccionBean", traduccionBean);
	
			this.listarCombos(mav);
	
			return mav;
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesión no es valida, por favor inicie sesión nuevamente");
			return mav;
		}
	}
	@RequestMapping(value = "/listadoTraduccion", method = RequestMethod.GET)
	public ModelAndView listarLenguas()
			throws Exception {
		
		ModelAndView mav = new ModelAndView("configuracion/listado-tabla-traduccion");
		List<TraduccionBean> lstTraduccionBean =new ArrayList<TraduccionBean>(); 
		try {
			lstTraduccionBean = (List<TraduccionBean>) this.getTraduccionService().getBuscarPorFiltros(new TraduccionBean());
			if (lstTraduccionBean != null && lstTraduccionBean.size()>0) {
				System.out.println("lstLenguaBean actual :: "+lstTraduccionBean.size());

			}else{
				
			}
					} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}  
		mav.addObject("lstTraduccionBean", lstTraduccionBean); 
		return mav;
	}
	
	@RequestMapping(value = "/recargarListado", method = RequestMethod.POST)
	public ModelAndView recargarListadoxLengua(@ModelAttribute("traduccionBean") TraduccionBean traduccionBean) {

		
		ModelAndView mav = new ModelAndView("configuracion/ajax/listado-traduccion"); 
	
		cargarEstructura(mav,traduccionBean);
		return mav;
	}
	
	private void cargarEstructura(ModelAndView mav, TraduccionBean traduccionBean){ 
		
		try { 
			lstTraduccionBean = traduccionService.getBuscarPorFiltros(traduccionBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}

		mav.addObject("lstTraduccionBean", lstTraduccionBean);
	
	}
	
	public TraduccionBean getTraduccionBean() {
		return traduccionBean;
	}



	public void setTraduccionBean(TraduccionBean traduccionBean) {
		this.traduccionBean = traduccionBean;
	}



	public List<MaestraBean> getLstTipoMensaje() {
		return lstTipoEtiqueta;
	}



	public void setLstTipoMensaje(List<MaestraBean> lstTipoEtiqueta) {
		this.lstTipoEtiqueta = lstTipoEtiqueta;
	}

	public List<TraduccionBean> getLstTraduccionBean() {
		return lstTraduccionBean;
	}

	public void setLstTraduccionBean(List<TraduccionBean> lstTraduccionBean) {
		this.lstTraduccionBean = lstTraduccionBean;
	}


	public List<LenguaBean> getLstLenguaBean() {
		return lstLenguaBean;
	}

	public void setLstLenguaBean(List<LenguaBean> lstLenguaBean) {
		this.lstLenguaBean = lstLenguaBean;
	}

	public LenguaService getLenguaService() {
		return lenguaService;
	}

	public void setLenguaService(LenguaService lenguaService) {
		this.lenguaService = lenguaService;
	}

	public TraduccionService getTraduccionService() {
		return traduccionService;
	}

	public void setTraduccionService(TraduccionService traduccionService) {
		this.traduccionService = traduccionService;
	}

	private String getRootPath() {    	
		return ResourceUtil.getKey("ruta.natigu.archivos.configuracion.traduccion");
     }
	
}
