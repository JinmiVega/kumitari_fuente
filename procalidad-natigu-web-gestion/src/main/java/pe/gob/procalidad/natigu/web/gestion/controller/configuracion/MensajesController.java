package pe.gob.procalidad.natigu.web.gestion.controller.configuracion;

import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.io.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MensajesBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionCabeceraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.MensajesService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.controller.general.view.InstitucionForm;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;

@Controller
@Scope(value="session")
@RequestMapping(value = "mensajesController")
public class MensajesController extends BaseController{

	private MensajesBean mensajesBean;
	private MensajesBean mensajesBeanTmp;
	private MensajesBean mensajesBeanFilter;
	private List<MaestraBean> lstTipoMensaje;
	private List<MensajesBean> lstMensajesBean;
	private List<LenguaBean> lstLenguaBean;
	
	@Autowired
	private Maestra2Service maestra2Service;
	
	@Autowired
	private LenguaService  lenguaService;
	
	@Autowired
	private MensajesService mensajesService;
	
	@Autowired
	private PeticionService peticionService;
	
	@PostConstruct
	public void init(){
		mensajesBeanFilter = new MensajesBean();
		this.setMensajesBean(new MensajesBean());
		this.setLstTipoMensaje(new ArrayList<MaestraBean>());
		this.setLstMensajesBean(new ArrayList<MensajesBean>());
		this.setLstLenguaBean(new ArrayList<LenguaBean>());
	}

	public MensajesController() {
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("mensajesBean") MensajesBean mensajesBean)throws Exception {
		System.out.println("----Ingreso al listado Mensajes----");
		System.out.println("mensajesBean"+mensajesBean);
		ModelAndView mav = new ModelAndView("configuracion/listado-mensajes", "command",mensajesBean);
		mav.addObject("lstMensajesBean", new ArrayList<MensajesBean>());
		mav.addObject("mensajesBean", mensajesBean);
		this.listarCombos(mav);
		return mav;
	}
	private void listarCombos(ModelAndView mav){
		System.out.println("lstTipoMensaje"+lstTipoMensaje);
		System.out.println("lstLenguaBean"+lstLenguaBean);
			try {
				
				lstTipoMensaje = this.getMaestra2Service().listarPorCodigoTabla("tipoMensaje", 0);
				lstLenguaBean = this.getLenguaService().cargarCombo();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		mav.addObject("lstLenguaBean",lstLenguaBean);
		mav.addObject("lstTipoMensaje",lstTipoMensaje);
	}
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView nuevo() throws Exception {
		mensajesBeanTmp = null;
		mensajesBean = new MensajesBean();
		ModelAndView mav = new ModelAndView("configuracion/registro-mensajes", "command", new MensajesBean());
		mav.addObject("lstTipoMensaje", lstTipoMensaje);
		mav.addObject("lstLenguaBean", lstLenguaBean);
		
		mav.addObject("mensajesBean", new MensajesBean());
		

		return mav;
	}
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	@ResponseBody
	public Long doGrabarMensaje(@RequestParam("codLengua") Integer codLengua,
			 					   @RequestParam("codMensajes") Integer codMensajes,
			 					   @RequestParam("codTipoMensajes") Integer codTipoMensajes,
			 					  @RequestParam("mensaje") String mensaje , 
			 					  HttpServletRequest request ){
		System.out.println("-----Ingreso a mensajes ----");
		MensajesBean mensajesBean = new MensajesBean();
		long valor = 0;
		mensajesBean.setCodigo(codMensajes);
		mensajesBean.setMensajes(mensaje);
		mensajesBean.getLenguaBean().setCodigo(codLengua);
		mensajesBean.getTipoMensaje().setCodigoRegistro(codTipoMensajes);
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("MensajesController/grabar");
			//chabilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	    		try {
	    			if(mensajesBean.getMensajes()!=null&&mensajesBean.getMensajes()!="") {
		        		
	    				if (mensajesBean.getCodigo() != 0) {
	    					
	    					this.setAuditoria(mensajesBean, request, false);
	    					this.getMensajesService().actualizar(mensajesBean);
	    					valor = mensajesBean.getCodigo();
	    				}else{
	    					
	    					this.setAuditoria(mensajesBean, request, true);
	    					this.getMensajesService().insertar(mensajesBean);
	    					valor = mensajesBean.getCodigo();
	    				}
		        	}
	    			
	    			
	    		} catch (ServiceException e) {
	    			e.printStackTrace();
	    		}
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		return valor;

	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscarListado(@ModelAttribute("mensajesBean") MensajesBean mensajesBean)
			throws Exception {
//		return this.getLista(mensajesBean);
		return this.doBuscar(mensajesBeanFilter);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("mensajesBean") MensajesBean mensajesBean)
			throws Exception {
		
		mensajesBeanFilter = mensajesBean;
		
		List<MensajesBean> lstMensajesBean = new ArrayList<MensajesBean>();
		
		try {
			lstMensajesBean = (List<MensajesBean>) this.getMensajesService().getBuscarPorFiltros(mensajesBean);
			
			if (lstMensajesBean != null && lstMensajesBean.size()>0) {
				
			}else{
				System.out.println("lista vacia");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView("configuracion/listado-mensajes", "command",mensajesBean);
		
		mav.addObject("lstMensajesBean", lstMensajesBean);
		mav.addObject("mensajesBean", mensajesBean);
		this.listarCombos(mav);
		return mav;
	}
	
	private ModelAndView getLista(MensajesBean mensajesBean) {
		
		mensajesBeanFilter = mensajesBean;
		
		List<MensajesBean> lstMensajesBean = new ArrayList<MensajesBean>();
		
		try {
			lstMensajesBean = (List<MensajesBean>) this.getMensajesService().getBuscarPorFiltros(mensajesBean);
			
			if (lstMensajesBean != null && lstMensajesBean.size()>0) {
				
			}else{
				System.out.println("lista vacia");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView("configuracion/listado-mensajes", "command",mensajesBean);
		
		mav.addObject("lstMensajesBean", lstMensajesBean);
		mav.addObject("mensajesBean", mensajesBean);
		this.listarCombos(mav);
		return mav;
	}
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	@ResponseBody
	public String eliminar(@RequestParam("codigo") Integer codigo, HttpServletRequest request) {
		boolean sw = false;
		MensajesBean mensajesBean = new MensajesBean();
		String valor = "";
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("MensajesController/eliminar");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	mensajesBean.setCodigo(codigo);
	        	this.setAuditoria(mensajesBean, request, false);
	        	sw = (this.getMensajesService().eliminar(mensajesBean));	        	
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
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo ,HttpServletRequest request) {
		MensajesBean oMensajesBean = new MensajesBean();
		oMensajesBean.setCodigo(codigo);
		
		mensajesBeanTmp = oMensajesBean;
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try {
				mensajesBean = this.getMensajesService().getBuscarPorObjecto(oMensajesBean);
				if (mensajesBean != null) {
					
				}else{
					System.out.println("obj vacio");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			ModelAndView mav = new ModelAndView("configuracion/registro-mensajes", "command", mensajesBean);
			mav.addObject("mensajesBean", mensajesBean);
	
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
	

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificarGet(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();

		MensajesBean oMensajesBean = new MensajesBean();
		
		if(mensajesBeanTmp != null){

			oMensajesBean.setCodigo(mensajesBeanTmp.getCodigo());
			
			try {
				mensajesBean = this.getMensajesService().getBuscarPorObjecto(oMensajesBean);
				if (mensajesBean != null) {
					
				}else{
					System.out.println("obj vacio");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			mav = new ModelAndView("configuracion/registro-mensajes", "command", mensajesBean);
			mav.addObject("mensajesBean", mensajesBean);

			this.listarCombos(mav);

		}else{
			mav = this.getLista(mensajesBeanFilter);
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/listadoMensajes", method = RequestMethod.GET)
	public ModelAndView listarLenguas()
			throws Exception {
		
		ModelAndView mav = new ModelAndView("configuracion/listado-tabla-mensajes");
		List<MensajesBean> lstMensajesBean =new ArrayList<MensajesBean>(); 
		try {
			lstMensajesBean = (List<MensajesBean>) this.getMensajesService().getBuscarPorFiltros(new MensajesBean());
			if (lstMensajesBean != null && lstMensajesBean.size()>0) {
				System.out.println("lstLenguaBean actual :: "+lstMensajesBean.size());

			}else{
				
			}
					} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}  
		mav.addObject("lstMensajesBean", lstMensajesBean); 
		return mav;
	}
	public MensajesBean getMensajesBean() {
		return mensajesBean;
	}



	public void setMensajesBean(MensajesBean mensajesBean) {
		this.mensajesBean = mensajesBean;
	}



	public List<MaestraBean> getLstTipoMensaje() {
		return lstTipoMensaje;
	}



	public void setLstTipoMensaje(List<MaestraBean> lstTipoMensaje) {
		this.lstTipoMensaje = lstTipoMensaje;
	}

	public List<MensajesBean> getLstMensajesBean() {
		return lstMensajesBean;
	}

	public void setLstMensajesBean(List<MensajesBean> lstMensajesBean) {
		this.lstMensajesBean = lstMensajesBean;
	}

	public Maestra2Service getMaestra2Service() {
		return maestra2Service;
	}

	public void setMaestra2Service(Maestra2Service maestra2Service) {
		this.maestra2Service = maestra2Service;
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

	public MensajesService getMensajesService() {
		return mensajesService;
	}

	public void setMensajesService(MensajesService mensajesService) {
		this.mensajesService = mensajesService;
	}

	
	
}
