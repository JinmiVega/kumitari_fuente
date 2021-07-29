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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.SliderBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.SliderDetalleBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.SliderService;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.SliderDetalleService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.CodeUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.controller.configuracion.view.SliderForm;;

@Controller
@Scope(value="session")
@RequestMapping(value = "sliderController")
public class SliderController extends BaseController{
	
	private SliderForm 			sliderForm;
	private SliderBean 			sliderBean;
	private SliderBean 			sliderBeanTmp;
	private SliderDetalleBean 	sliderDetalleBean;
	private SliderBean 			sliderBeanFiltro;
	
	private List<SliderBean> 	lstSliderBean;
	private List<MaestraBean>	lstSituacion;
	private List<SliderDetalleBean> 	lstSliderDetalleBean;
	 
	@Autowired
	private SliderService 		sliderService;
	@Autowired
	private Maestra1Service 	maestra1Service;
	@Autowired
	private Maestra2Service 	maestra2Service;
	@Autowired
	private SliderDetalleService 	sliderDetalleService;
	@Autowired
	private PeticionService peticionService;
	
	@PostConstruct
	public void init(){
		this.setSliderBean(new SliderBean());
		this.setSliderBeanFiltro(new SliderBean());
		this.setSliderDetalleBean(new SliderDetalleBean());
		this.setLstSliderBean(new ArrayList<SliderBean>());
		this.setSliderForm(new SliderForm());
		this.setLstSituacion(new ArrayList<MaestraBean>());
		this.setLstSliderDetalleBean(new ArrayList<SliderDetalleBean>());
	} 
	
	public SliderController (){  
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("sliderBean") SliderBean sliderBean)throws Exception {
		
		SliderBean prmSliderBean = new SliderBean(); 
		prmSliderBean.setNombre(""); 
		prmSliderBean.setSituacion(new MaestraBean()); 
		prmSliderBean.getSituacion().setCodigoRegistro(0);
		
		ModelAndView mav = new ModelAndView("configuracion/listado-slider", "command",sliderBean);
		mav.addObject("lstSliderBean", new ArrayList<SliderBean>());
		this.cargarCombos(mav);
		return mav;
	}
	 
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscar(@ModelAttribute("sliderBean") SliderBean sliderBean)
			throws Exception {
		 return this.doBuscarListado(sliderBeanFiltro);
		//return this.getLista(sliderBean);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscarListado(@ModelAttribute("sliderBean") SliderBean sliderBean)
			throws Exception {
		
		sliderBeanFiltro = sliderBean;
		
		List<SliderBean> lstSliderBean = new ArrayList<SliderBean>();
		try {  
			lstSliderBean = (List<SliderBean>) this.getSliderService().getBuscarPorFiltros(sliderBean); 
		} catch (Exception e) {
			System.out.println("getLista fall�" + e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView("configuracion/listado-slider", "command", sliderBean);
		mav.addObject("lstSliderBean", lstSliderBean );
		this.cargarCombos(mav);
		return mav;
		
	}
	
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		sliderBean= new SliderBean();
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try { 
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("SliderController/eliminar");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	sliderBean.setCodigo(codigo);
		        	this.setAuditoria(sliderBean, request, false);
		        	sw =  (this.getSliderService().eliminar(sliderBean));  		        	
		        }
	
			} catch (Exception e) { 
				e.printStackTrace();
			} 		
			sliderBean.setCodigo(0);
		 	this.setValoresPredeterminados(sliderBean);
			ModelAndView mav = this.getLista(sliderBean);
			mav.addObject("swMensaje",sw?"1":"0");
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

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
		public ModelAndView doNuevo() {
	 
		sliderBeanTmp = new SliderBean();
		
		ModelAndView mav = new ModelAndView("configuracion/registro-slider", "command",new SliderForm());//new SliderBean()
		 
		mav.addObject("lstSituacion",lstSituacion);		 
		mav.addObject("sliderBean", new SliderBean());
		mav.addObject("sliderDetalleBean", new SliderDetalleBean());

		this.cargarCombos(mav);
		return mav;
	} 
	 
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {
 		
		SliderBean prmSliderBean = new SliderBean();
		prmSliderBean.setCodigo(codigo); 
		
		sliderBeanTmp = prmSliderBean;
		
		try {
			sliderBean = this.getSliderService().getBuscarPorObjecto(prmSliderBean);
			sliderForm.setSliderBean(sliderBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
 
		if ((sliderBean != null ) && ( sliderBean.getEstado() != null) && (sliderBean.getEstado().equals("1"))) {
		
			ModelAndView mav = new ModelAndView("configuracion/registro-slider", "command", sliderForm);  
		
			List<SliderDetalleBean> lstSliderDetalleBean = new ArrayList<SliderDetalleBean>();
				try { 
					SliderDetalleBean sliderDetalleBean = new SliderDetalleBean();
					sliderDetalleBean.getSliderBean().setCodigo(codigo);
					lstSliderDetalleBean = (List<SliderDetalleBean>) this.getSliderDetalleService().getlistarSliderDetalleXCodigoSlider(sliderDetalleBean); 
				} catch (Exception e) {
					System.out.println("getLista fall�" + e.getMessage());
				}
			mav.addObject("lstSliderDetalleBean", lstSliderDetalleBean);   
			mav.addObject("sliderForm", sliderForm); 
			this.cargarCombos(mav);
			return mav;
		}else{
			ModelAndView mav = this.getLista(new SliderBean());
			mav.addObject("swMensaje","0");
			mav.addObject("sliderBean",new SliderBean());  
			return mav;
		}
		
	}
	

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar() {
 		
		if(sliderBeanTmp != null){

			SliderBean prmSliderBean = new SliderBean();
			prmSliderBean.setCodigo(sliderBeanTmp.getCodigo()); 
			
			try {
				sliderBean = this.getSliderService().getBuscarPorObjecto(prmSliderBean);
				sliderForm.setSliderBean(sliderBean);
			} catch (ServiceException e) { 
				e.printStackTrace();
			}
	 
			if ((sliderBean != null ) && ( sliderBean.getEstado() != null) && (sliderBean.getEstado().equals("1"))) {
			
				ModelAndView mav = new ModelAndView("configuracion/registro-slider", "command", sliderForm);  
			
				List<SliderDetalleBean> lstSliderDetalleBean = new ArrayList<SliderDetalleBean>();
					try { 
						SliderDetalleBean sliderDetalleBean = new SliderDetalleBean();
						sliderDetalleBean.getSliderBean().setCodigo(sliderBeanTmp.getCodigo());
						lstSliderDetalleBean = (List<SliderDetalleBean>) this.getSliderDetalleService().getlistarSliderDetalleXCodigoSlider(sliderDetalleBean); 
					} catch (Exception e) {
						System.out.println("getLista fall�" + e.getMessage());
					}
				mav.addObject("lstSliderDetalleBean", lstSliderDetalleBean);   
				mav.addObject("sliderForm", sliderForm); 
				this.cargarCombos(mav);
				return mav;
			}else{
				ModelAndView mav = this.getLista(new SliderBean());
				mav.addObject("swMensaje","0");
				mav.addObject("sliderBean",new SliderBean());  
				return mav;
			}
			
		}else{

			ModelAndView mav = this.getLista(new SliderBean());
			mav.addObject("swMensaje","2");
			mav.addObject("sliderBean",new SliderBean());  
			return mav;
		}
		
	}
	
	@RequestMapping(value = "/agregarSlider", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView doAgregarSlider(@RequestParam("sliderBean.codigo") Integer codSli,
										@RequestParam("sliderDetalleBean.file") MultipartFile[] files,
										HttpServletRequest request) {
		
		SliderDetalleBean sliderDetalleBean = new SliderDetalleBean();
		SliderBean sliderBean = new SliderBean();
		sliderBean.setCodigo(!VO.isNull(codSli) ? Long.valueOf(codSli) : 0);
		boolean sw = true;
		boolean swNuevaUrlImagen = false;
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
				try { 
					if (files.length > 0) {
						swNuevaUrlImagen = (files[0] != null) && (files[0].getOriginalFilename() != null)
								&& (files[0].getOriginalFilename().trim().length() > 0);
						System.out.println(swNuevaUrlImagen);
						System.out.println(files[0].getOriginalFilename());
					}
					
					if (swNuevaUrlImagen) {
						sliderDetalleBean.setFileImagen(files[0]);
						if (files[0].getOriginalFilename() != null) {
							sliderDetalleBean.setImagen(files[0].getOriginalFilename());
							System.out.println(sliderDetalleBean.getImagen());
						}
					}
						
					sliderDetalleBean.getSituacion().setCodigoRegistro(1);// activo
					sliderDetalleBean.setSliderBean(sliderBean);
					
					//ip
					boolean habilitadoIp = true;
					PeticionBean prmIntento = new PeticionBean();
					prmIntento.setIpConexion(request.getRemoteAddr());
					prmIntento.setUrlPeticion("SliderController/agregarSlider");
					//habilitadoIp = peticionService.existe(prmIntento);
			        if(habilitadoIp) {
			        	if (sliderDetalleBean.getCodigo()==0) {
							
							this.setAuditoria(sliderDetalleBean, request, true);
							sw =  (this.sliderDetalleService.insertar(sliderDetalleBean)); 
						
							System.out.println("sliderForm detalle codSlider" + codSli);
							System.out.println(files[0].getOriginalFilename());
							System.out.println(sliderDetalleBean.getImagen());
							System.out.println(sliderDetalleBean.getNombreSlider());
							System.out.println(sliderDetalleBean.getCodigo());
							System.out.println(sliderDetalleBean.getFile());
			 
						} else { 
							
						} 
			        } else {
			        	sw = false;
			        }
					 
						
					if (sw) {
		
						SliderBean objActualSliderBean = this.fs.getSliderService().getBuscarPorObjecto(sliderBean);
						sliderForm.setSliderBean(objActualSliderBean);
						
						if (swNuevaUrlImagen) {
							super.cargarArchivo(this.getRootPath(), sliderDetalleBean.getImagen(), sliderDetalleBean.getFileImagen());
							
						}		
					}
					
					SliderDetalleBean filtroSliderDetalle = new SliderDetalleBean();
					filtroSliderDetalle.getSliderBean().setCodigo(!VO.isNull(codSli) ? Long.valueOf(codSli) : 0);
					lstSliderDetalleBean = (List<SliderDetalleBean>) this.getSliderDetalleService().getlistarSliderDetalleXCodigoSlider(filtroSliderDetalle);
		 
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesión no es valida, por favor inicie sesión nuevamente");
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("configuracion/registro-slider", "command", sliderForm);
		
		mav.addObject("swMensaje",sw?"1":"0");	
		mav.addObject("sliderForm",sliderForm);
		mav.addObject("lstSliderDetalleBean", lstSliderDetalleBean);  
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("sliderForm") SliderForm sliderForm,
  								 HttpServletRequest request) {
		
 		boolean sw = false;
 		List<SliderDetalleBean> lstSliderDetalleBean = new ArrayList<SliderDetalleBean>();
 	 
 		sliderForm.getSliderBean().setNombre(CodeUtil.parseEncode(sliderForm.getSliderBean().getNombre()));
 		sliderForm.getSliderBean().setDescripcion(CodeUtil.parseEncode(sliderForm.getSliderBean().getDescripcion()));
 		
 		HttpSession sessionToken = request.getSession();
 		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
 		if(u != null) {
 			
			try {
				
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("SliderController/grabar");
				//habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	if(sliderForm.getSliderBean().getNombre()!=null&&sliderForm.getSliderBean().getNombre()!="") {
		        		if (sliderForm.getSliderBean().getCodigo()==0) {
		        			this.setAuditoria(sliderForm.getSliderBean(), request, true);
		        			sw =  (this.getSliderService().insertar(sliderForm.getSliderBean())); 
		        		} else {
		        			this.setAuditoria(sliderForm.getSliderBean(), request, false);
		        			sw = (this.getSliderService().actualizar(sliderForm.getSliderBean()));
		        		}		        		
		        	}
		        }
				
				if(sw){
					if(	!VO.isNull(sliderForm) 
						&& !VO.isNull(sliderForm.getSliderBean()) 
						&& !VO.isNull(sliderForm.getSliderBean().getCodigo())
						&& sliderForm.getSliderBean().getCodigo()>0 ){
						
						SliderDetalleBean sliderDetalleBean = new SliderDetalleBean();
						sliderDetalleBean.getSliderBean().setCodigo(sliderForm.getSliderBean().getCodigo());
						lstSliderDetalleBean = (List<SliderDetalleBean>) this.getSliderDetalleService().getlistarSliderDetalleXCodigoSlider(sliderDetalleBean); 
						
					}
				}
				
			}catch (Exception e) { 
				e.printStackTrace();
			}
			
			SliderBean prmSliderBean = new SliderBean(); 
			prmSliderBean.setNombre(""); 
			prmSliderBean.setSituacion(new MaestraBean()); 
			prmSliderBean.getSituacion().setCodigoRegistro(null);
			
			//ModelAndView mav = new ModelAndView("configuracion/listado-slider", "command",prmSliderBean);
			ModelAndView mav = this.getLista(prmSliderBean);
			//mav.addObject("lstSliderBean", new ArrayList<SliderBean>());
			mav.addObject("swMensaje",sw?"1":"0");
			//this.cargarCombos(mav);
				/*
				ModelAndView mav = new ModelAndView("configuracion/registro-slider", "command",sliderForm);
				mav.addObject("sliderBean",sliderForm);
				mav.addObject("lstSliderDetalleBean", lstSliderDetalleBean);
				this.cargarCombos(mav);*/
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
	
	private String getRootPath() {    	
		return ResourceUtil.getKey("ruta.natigu.archivos.configuracion.slider");
     }
	
	@RequestMapping(value = "/cargarModal", method = RequestMethod.POST)
	public ModelAndView cargarModal() {
		ModelAndView mav = new ModelAndView("../layout/upload-img-modal-view", "command",new SliderForm());
		mav.addObject("SliderForm", new SliderForm());
		return mav;
	} 
	
	
	private ModelAndView getLista(SliderBean sliderBean) {
		
		List<SliderBean> lstSliderBean = new ArrayList<SliderBean>();
		try {  
			lstSliderBean = (List<SliderBean>) this.getSliderService().getBuscarPorFiltros(sliderBean); 
		} catch (Exception e) {
			System.out.println("getLista fall�" + e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView("configuracion/listado-slider", "command", sliderBean);
		mav.addObject("lstSliderBean", lstSliderBean );
		this.cargarCombos(mav);
		return mav;
	}
	private void cargarCombos(ModelAndView mav){
		 	
			lstSituacion = null;
		 
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionSlider", 1);
			} catch (ServiceException e) {
				e.printStackTrace();
			}		
		 
		 
		mav.addObject("lstSituacion",lstSituacion); 
	}
	
	@RequestMapping(value = "/eliminarSliderDetalle", method = RequestMethod.GET)
	public @ResponseBody String eliminarSliderDetalle(@RequestParam("codigo") String codigo){		
		 
		boolean sw = false;
		try { 
			SliderDetalleBean sliderDetalleBean = new SliderDetalleBean();
			sliderDetalleBean.setCodigo(VO.toLong(codigo));
			
			sw = this.getSliderDetalleService().eliminar(sliderDetalleBean); 
			
			if(sw){
				return "1";
			}else{
				return "0";
			}
			
		} catch (Exception e) {
			System.out.println("eliminar detalle slider fall�" + e.getMessage());
			return null;
		}
	}
	
	@RequestMapping(value = "/refrescarListaSliderDetalle", method = RequestMethod.GET)
	public @ResponseBody List<SliderDetalleBean> refrescarListaSliderDetalle(@RequestParam("codigo") String codigo){		
		 
		List<SliderDetalleBean> lstSliderDetalleBean = new ArrayList<SliderDetalleBean>();
		try { 
			SliderDetalleBean sliderDetalleBean = new SliderDetalleBean();
			sliderDetalleBean.getSliderBean().setCodigo(VO.toLong(codigo));
			lstSliderDetalleBean = (List<SliderDetalleBean>) this.getSliderDetalleService().getlistarSliderDetalleXCodigoSlider(sliderDetalleBean);
		} catch (Exception e) {
			System.out.println("getLista fall�" + e.getMessage());
			return null;
		}
		return lstSliderDetalleBean;
	}
         
	public SliderService getSliderService() {
		return sliderService;
	}

	public void setSliderService(SliderService sliderService) {
		this.sliderService = sliderService;
	}

	public SliderBean getSliderBean() {
		return sliderBean;
	}

	public void setSliderBean(SliderBean sliderBean) {
		this.sliderBean = sliderBean;
	}

	public List<SliderBean> getLstSliderBean() {
		return lstSliderBean;
	}

	public void setLstSliderBean(List<SliderBean> lstSliderBean) {
		this.lstSliderBean = lstSliderBean;
	}

	public Maestra1Service getMaestra1Service() {
		return maestra1Service;
	}

	public void setMaestra1Service(Maestra1Service maestra1Service) {
		this.maestra1Service = maestra1Service;
	}

	public Maestra2Service getMaestra2Service() {
		return maestra2Service;
	}

	public void setMaestra2Service(Maestra2Service maestra2Service) {
		this.maestra2Service = maestra2Service;
	}

	public List<MaestraBean> getLstSituacion() {
		return lstSituacion;
	}

	public void setLstSituacion(List<MaestraBean> lstSituacion) {
		this.lstSituacion = lstSituacion;
	}

	public SliderDetalleBean getSliderDetalleBean() {
		return sliderDetalleBean;
	}

	public void setSliderDetalleBean(SliderDetalleBean sliderDetalleBean) {
		this.sliderDetalleBean = sliderDetalleBean;
	}

	public SliderForm getSliderForm() {
		return sliderForm;
	}

	public void setSliderForm(SliderForm sliderForm) {
		this.sliderForm = sliderForm;
	}
	
	public void setValoresPredeterminados(SliderBean sliderBean){
		sliderBean.setNombre(""); 
		sliderBean.getSituacion().setCodigoRegistro(0);
	    }

	public List<SliderDetalleBean> getLstSliderDetalleBean() {
		return lstSliderDetalleBean;
	}

	public void setLstSliderDetalleBean(List<SliderDetalleBean> lstSliderDetalleBean) {
		this.lstSliderDetalleBean = lstSliderDetalleBean;
	} 
	public SliderDetalleService getSliderDetalleService() {
		return sliderDetalleService;
	}

	public void setSliderDetalleService(SliderDetalleService sliderDetalleService) {
		this.sliderDetalleService = sliderDetalleService;
	}

	public SliderBean getSliderBeanFiltro() {
		return sliderBeanFiltro;
	}

	public void setSliderBeanFiltro(SliderBean sliderBeanFiltro) {
		this.sliderBeanFiltro = sliderBeanFiltro;
	}
	
	
}