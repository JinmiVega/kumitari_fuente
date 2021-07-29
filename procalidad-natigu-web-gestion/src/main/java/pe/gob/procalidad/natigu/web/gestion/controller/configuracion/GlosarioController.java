package pe.gob.procalidad.natigu.web.gestion.controller.configuracion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.GlosarioBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaNivelBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.GlosarioService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;

@Controller
@Scope(value="session")
@RequestMapping(value = "glosarioController")
public class GlosarioController extends BaseController{

	private GlosarioBean glosarioBean;
	private GlosarioBean glosarioBeanTmp;
	private GlosarioBean glosarioBeanFilter;
	private List<MaestraBean> lstTipoMensaje;
	private List<GlosarioBean> lstGlosarioBean;
	private List<LenguaBean> lstLenguaBean;
	
	
	@Autowired
	private LenguaService  lenguaService;
	
	@Autowired
	private GlosarioService glosarioService;
	
	@Autowired
	private PeticionService peticionService;
	
	@PostConstruct
	public void init(){
		this.glosarioBeanFilter = new GlosarioBean();
		this.setGlosarioBean(new GlosarioBean());
		this.setLstTipoMensaje(new ArrayList<MaestraBean>());
		this.setLstGlosarioBean(new ArrayList<GlosarioBean>());
		this.setLstLenguaBean(new ArrayList<LenguaBean>());
	}

	public GlosarioController() {
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("glosarioBean") GlosarioBean glosarioBean)throws Exception {
		System.out.println("----Ingreso al listado Glosario----");
		System.out.println("glosarioBean"+glosarioBean);
		ModelAndView mav = new ModelAndView("configuracion/listado-glosario", "command",glosarioBean);
		mav.addObject("lstGlosarioBean", new ArrayList<GlosarioBean>());
		mav.addObject("glosarioBean", glosarioBean);
		this.listarCombos(mav);
		return mav;
	}
	private void listarCombos(ModelAndView mav){
		System.out.println("lstTipoMensaje"+lstTipoMensaje);
		System.out.println("lstLenguaBean"+lstLenguaBean);
			try {
				
				lstLenguaBean = this.getLenguaService().cargarCombo();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		mav.addObject("lstLenguaBean",lstLenguaBean);
	}
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView nuevo() throws Exception {
		glosarioBean = new GlosarioBean();
		
		glosarioBeanTmp = null;

		ModelAndView mav = new ModelAndView("configuracion/registro-glosario", "command", new GlosarioBean());

		mav.addObject("lstLenguaBean", lstLenguaBean);
		
		mav.addObject("glosarioBean", new GlosarioBean());
		

		return mav;
	}
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	//@ResponseBody
	public ModelAndView doGrabarMensaje(@ModelAttribute("glosarioBean") GlosarioBean glosarioBean,
			 					 @RequestParam("file") MultipartFile[] file,
			 					 HttpServletResponse response,
			 					  HttpServletRequest request ){
		System.out.println("-----Ingreso a glosario ----");

		//GlosarioBean glosarioBean = new GlosarioBean();
		//glosarioBean.setCodigoGlosario(codGlosario);
		//glosarioBean.getLenguaBean().setCodigo(codLengua);
		
		Long valor = null;
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		Boolean activePeticion = false;
		if(u != null) {
			
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("GlosarioController/grabar");
				//habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	activePeticion = true;
		        } else {
		        	activePeticion = false;
		        }
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				
				if(activePeticion) {
					if(file!=null && file.length>0 && file[0].getOriginalFilename()!=null && file[0].getOriginalFilename().trim().length()>0){
						this.cargarArchivo(this.getRootPath(), glosarioBean.getLenguaBean().getCodigo() + "_" + VO.convertirCaracteresEsp(file[0].getOriginalFilename()), file[0]);
						glosarioBean.setMimmeType(file[0].getContentType());
						glosarioBean.setFileName(VO.convertirCaracteresEsp(file[0].getOriginalFilename()));
						glosarioBean.setPeso(VO.toInteger(VO.toString(file[0].getSize())));
						glosarioBean.setDetalle(this.getRootPath() + File.separator + glosarioBean.getLenguaBean().getCodigo() + "_" + VO.convertirCaracteresEsp(file[0].getOriginalFilename()));
						
						if (glosarioBean.getCodigoGlosario() != null && glosarioBean.getCodigoGlosario()>0) {
							this.setAuditoria(glosarioBean, request, false);
							this.getGlosarioService().actualizar(glosarioBean);
							valor = glosarioBean.getCodigoGlosario();
						}else{
							
							this.setAuditoria(glosarioBean, request, true);
							this.getGlosarioService().insertar(glosarioBean);
							valor = glosarioBean.getCodigoGlosario();
						}
					}					
				}
				
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			System.out.println("valor"+valor);
			
			if(valor != null && valor>0){
				GlosarioBean filtro = new GlosarioBean();
				return this.getLista(filtro);
				
			}else{
				return null;
			}
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
	public ModelAndView doBuscarListado(@ModelAttribute("glosarioBean") GlosarioBean glosarioBean)
			throws Exception {
		return this.getLista(glosarioBean);
	}
	private ModelAndView getLista(GlosarioBean glosarioBean) {
		
		glosarioBeanFilter = glosarioBean;
		
		List<GlosarioBean> lstGlosarioBean = new ArrayList<GlosarioBean>();
		
		try {
			lstGlosarioBean = (List<GlosarioBean>) this.getGlosarioService().getBuscarPorFiltros(glosarioBean);
			
			if (lstGlosarioBean != null && lstGlosarioBean.size()>0) {
				
			}else{
				System.out.println("lista vacia");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView("configuracion/listado-glosario", "command",glosarioBean);
		
		mav.addObject("lstGlosarioBean", lstGlosarioBean);
		mav.addObject("glosarioBean", glosarioBean);
		this.listarCombos(mav);
		return mav;
	}
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	@ResponseBody
	public String eliminar(@RequestParam("codigo") Long codigo, HttpServletRequest request) {
		boolean sw = false;
		GlosarioBean glosarioBean = new GlosarioBean();
		String valor = "";
		
		try {			
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("GlosarioController/eliminar");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	glosarioBean.setCodigoGlosario(codigo);
	        	this.setAuditoria(glosarioBean, request, false);
	        	sw = (this.getGlosarioService().eliminar(glosarioBean));	        	
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
	

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificarGet(HttpServletRequest request) {
		

		GlosarioBean oGlosarioBean = new GlosarioBean();
		
		ModelAndView mav = new ModelAndView();
		
		if(glosarioBeanTmp != null){

			oGlosarioBean.setCodigoGlosario(glosarioBeanTmp.getCodigoGlosario());
			
			try {
				glosarioBean = this.getGlosarioService().getBuscarPorObjecto(oGlosarioBean);
				if (glosarioBean != null) {
					
				}else{
					System.out.println("obj vacio");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			mav = new ModelAndView("configuracion/registro-glosario", "command", glosarioBean);
			mav.addObject("glosarioBean", glosarioBean);

			this.listarCombos(mav);
			
		}else{
			mav = this.getLista(glosarioBeanFilter);
		}
		return mav;
	}
	
	
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doModificar(@RequestParam("codigo") Long codigo ,HttpServletRequest request) {
		
		GlosarioBean oGlosarioBean = new GlosarioBean();
		oGlosarioBean.setCodigoGlosario(codigo);
		glosarioBeanTmp = oGlosarioBean;
		
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {

			try {
				glosarioBean = this.getGlosarioService().getBuscarPorObjecto(oGlosarioBean);
				if (glosarioBean != null) {
					
				}else{
					System.out.println("obj vacio");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			ModelAndView mav = new ModelAndView("configuracion/registro-glosario", "command", glosarioBean);
			mav.addObject("glosarioBean", glosarioBean);
	
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
	@RequestMapping(value = "/listadoGlosario", method = RequestMethod.GET)
	public ModelAndView listarLenguas()
			throws Exception {
		
		ModelAndView mav = new ModelAndView("configuracion/listado-tabla-glosario");
		List<GlosarioBean> lstGlosarioBean =new ArrayList<GlosarioBean>(); 
		try {
			lstGlosarioBean = (List<GlosarioBean>) this.getGlosarioService().getBuscarPorFiltros(new GlosarioBean());
			if (lstGlosarioBean != null && lstGlosarioBean.size()>0) {
				System.out.println("lstLenguaBean actual :: "+lstGlosarioBean.size());

			}else{
				
			}
					} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}  
		mav.addObject("lstGlosarioBean", lstGlosarioBean); 
		return mav;
	}
	
	@RequestMapping(value = "/recargarListado", method = RequestMethod.POST)
	public ModelAndView recargarListadoxLengua(@ModelAttribute("glosarioBean") GlosarioBean glosarioBean) {

		
		ModelAndView mav = new ModelAndView("configuracion/ajax/listado-glosario"); 
	
		cargarEstructura(mav,glosarioBean);
		return mav;
	}
	
	private void cargarEstructura(ModelAndView mav, GlosarioBean glosarioBean){ 
		
		try { 
			lstGlosarioBean = glosarioService.getBuscarPorFiltros(glosarioBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}

		mav.addObject("lstGlosarioBean", lstGlosarioBean);
	
	}
	
	public GlosarioBean getGlosarioBean() {
		return glosarioBean;
	}



	public void setGlosarioBean(GlosarioBean glosarioBean) {
		this.glosarioBean = glosarioBean;
	}



	public List<MaestraBean> getLstTipoMensaje() {
		return lstTipoMensaje;
	}



	public void setLstTipoMensaje(List<MaestraBean> lstTipoMensaje) {
		this.lstTipoMensaje = lstTipoMensaje;
	}

	public List<GlosarioBean> getLstGlosarioBean() {
		return lstGlosarioBean;
	}

	public void setLstGlosarioBean(List<GlosarioBean> lstGlosarioBean) {
		this.lstGlosarioBean = lstGlosarioBean;
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

	public GlosarioService getGlosarioService() {
		return glosarioService;
	}

	public void setGlosarioService(GlosarioService glosarioService) {
		this.glosarioService = glosarioService;
	}

	private String getRootPath() {    	
		return ResourceUtil.getKey("ruta.natigu.archivos.configuracion.glosario");
     }
	
}
