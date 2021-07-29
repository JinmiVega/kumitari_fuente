//package pe.gob.procalidad.natigu.web.gestion.controller.seguridad;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.support.SessionStatus;
//import org.springframework.web.servlet.ModelAndView;
//
//import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
//import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PerfilBean;
//import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
//import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioPerfilBean;
//import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
//import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
//import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;
//import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PerfilService;
//import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.UsuarioPerfilService;
//import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.UsuarioService;
//import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
//import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;
//
//@Controller
//@Scope(value="session")
//@RequestMapping(value = "usuarioController")
//public class UsuarioController extends BaseController{
//	@Autowired
//	UsuarioService usuarioService;
//	
//	@Autowired
//	UsuarioPerfilService usuarioPerfilService;
//	
//	@Autowired 
//	private PersonaService personaService;
//	
//	@Autowired
//	private Maestra1Service 	maestra1Service;
//	
//	@Autowired
//	PerfilService perfilService;
//	
//	private UsuarioBean usuarioBean;
//	private PerfilBean perfilBean;
//	private List<MaestraBean>	lstSituacion;
//	private List<MaestraBean>	lstTipoDocumento;
//	private List<PerfilBean>	lstPerfiles;
//	
//	@PostConstruct
//	public void init(){
//		this.setUsuarioBean(new UsuarioBean());
//		this.perfilBean= new PerfilBean();
//	}
//	
//	@RequestMapping(value = "/listado", method = RequestMethod.GET)
//	public ModelAndView doListado(@ModelAttribute("usuarioBean") UsuarioBean bean)throws Exception {
//		
//		return this.getLista(bean);
//	}
//	
//	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
//	public ModelAndView doNuevo() {
//		
//		ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",new UsuarioBean());
//		//mav.addObject("lstSituacion",lstSituacion);
//		mav.addObject("usuarioBean", new UsuarioBean());
//		this.cargarCombos(mav);
//		this.cargarComboPerfiles(mav);
//		return mav;
//	}
//	
//	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
//	public ModelAndView doGrabar(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean) {
//		
//		//System.out.println("lenguaBean Grabar"+lenguaBean);
//		boolean sw = true;
//		try {
//			if (usuarioBean.getCodigoUsuario()!=null && usuarioBean.getCodigoUsuario()!=0) {
//				sw = (usuarioService.actualizar(usuarioBean));
//			} else {
//				sw =  (usuarioService.insertar(usuarioBean)); 
//				
//			}
//
//		} catch (Exception e) { 
//			e.printStackTrace();
//		}
//
//		if (sw) {
//			usuarioBean = new UsuarioBean() ;
//			return this.getLista(usuarioBean);
//		} else {
//			ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
//			return mav;
//		}
//
//	}
//	
//	@RequestMapping(value = "/asignar", method = RequestMethod.POST)
//	public ModelAndView dAsignar(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean) {
//		
//		//System.out.println("lenguaBean Grabar"+lenguaBean);
//		List<UsuarioBean> lstUsuario = new ArrayList<UsuarioBean>();
//		boolean sw = true;
//		try {
//			if (usuarioBean.getCodigoUsuario()!=null && usuarioBean.getCodigoUsuario()!=0) {
//				//sw = (usuarioService.actualizar(usuarioBean));
//			} else {
//				usuarioBean.setNombreUsuario(usuarioBean.getPersona().getNumeroDocumento());
//				usuarioBean.setPasswordUsuario(usuarioBean.getPersona().getNumeroDocumento());
//				sw =  (usuarioService.insertar(usuarioBean)); 
//				if(sw){
//					lstUsuario = usuarioService.getBuscarPorFiltros(usuarioBean);
//					if(lstUsuario!=null && lstUsuario.size()>0){
//						usuarioBean = lstUsuario.get(0);
//						if(usuarioBean.getPersona()!=null){
//							usuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(usuarioBean.getPersona()));
//						}
//					}
//				}
//				
//				
//			}
//
//		} catch (Exception e) { 
//			e.printStackTrace();
//		}
//
//		/*if (sw) {
//			usuarioBean = new UsuarioBean() ;
//			return this.getLista(usuarioBean);
//		} else {*/
//			ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
//			mav.addObject("usuarioBean", usuarioBean);
//			mav.addObject("lstUsuarioPerfil", new ArrayList<UsuarioPerfilBean>());
//			this.cargarCombos(mav);
//			this.cargarComboPerfiles(mav);
//			return mav;
//		//}
//
//	}
//	
//	@RequestMapping(value = "/asignarPerfil", method = RequestMethod.POST)
//	public ModelAndView dAsignarPerfil(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean) {
//		
//		//System.out.println("lenguaBean Grabar"+lenguaBean);
//		List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
//		List<UsuarioBean> lstUsuario = new ArrayList<UsuarioBean>();
//		boolean sw = true;
//		try {
//			
//			UsuarioPerfilBean usuarioPerfilBean = new UsuarioPerfilBean();
//			usuarioPerfilBean.setUsuario(new UsuarioBean());
//			usuarioPerfilBean.getUsuario().setCodigoUsuario(usuarioBean.getCodigoUsuario());
//			usuarioPerfilBean.setPerfil(new PerfilBean());
//			usuarioPerfilBean.getPerfil().setCodigoPerfil(usuarioBean.getCodigoPerfil());
//			usuarioPerfilBean.setCodigoUsuarioCreacion(usuarioBean.getCodigoUsuarioCreacion());
//			usuarioPerfilBean.setAudHostIP(usuarioBean.getAudHostIP());
//			
//			sw = usuarioPerfilService.insertar(usuarioPerfilBean);
//			lstUsuario = usuarioService.getBuscarPorFiltros(usuarioBean);
//			if(lstUsuario!=null && lstUsuario.size()>0){
//				usuarioBean = lstUsuario.get(0);
//				if(usuarioBean.getPersona()!=null){
//					usuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(usuarioBean.getPersona()));
//				}
//			}
//			if (sw) {
//				UsuarioPerfilBean filtroUP = new UsuarioPerfilBean();
//				filtroUP.setUsuario(new UsuarioBean());
//				filtroUP.getUsuario().setCodigoUsuario(usuarioBean.getCodigoUsuario());
//				lstUsuarioPerfil =usuarioPerfilService.getBuscarPorFiltros(filtroUP);
//			} else {
//				
//				
//			}
//
//		} catch (Exception e) { 
//			e.printStackTrace();
//		}
//
//		/*if (sw) {
//			usuarioBean = new UsuarioBean() ;
//			return this.getLista(usuarioBean);
//		} else {*/
//			ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
//			mav.addObject("usuarioBean", usuarioBean);
//			mav.addObject("lstUsuarioPerfil", lstUsuarioPerfil);
//			this.cargarCombos(mav);
//			this.cargarComboPerfiles(mav);
//			return mav;
//		//}
//
//	}
//	
//	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
//	public ModelAndView doEliminar(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean) {
//		
//		//System.out.println("lenguaBean Grabar"+lenguaBean);
//		boolean sw = true;
//		try {
//			if (usuarioBean.getCodigoUsuario()!=null && usuarioBean.getCodigoUsuario()!=0) {
//				sw = (usuarioService.eliminar(usuarioBean));
//			}
//
//		} catch (Exception e) { 
//			e.printStackTrace();
//		}
//
//		//if (sw) {
//			usuarioBean = new UsuarioBean() ;
//			return this.getLista(usuarioBean);
//		/*} else {
//			ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
//			return mav;
//		}*/
//
//	}
//	
//	@RequestMapping(value = "/buscarPersona", method = RequestMethod.POST)
//	public ModelAndView doObtenerPersona(@ModelAttribute("usuarioBean") UsuarioBean bean) {
//
//		
//			PersonaBean rslPersonaBean =new PersonaBean(); 
//			List<UsuarioBean> lstUsuarioBean = new ArrayList<UsuarioBean>();
//			List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
//			try {
//				rslPersonaBean = personaService.buscarxTipoDocumentoNumeroDocumento(bean.getPersona());
//				if(rslPersonaBean != null){
//					UsuarioBean filtro = new UsuarioBean();
//					filtro.setPersona(new PersonaBean());
//					filtro.getPersona().setCodigo(rslPersonaBean.getCodigo());
//					lstUsuarioBean = usuarioService.getBuscarPorFiltros(filtro);
//					if(lstUsuarioBean!=null && lstUsuarioBean.size()>0){
//						usuarioBean = lstUsuarioBean.get(0);
//						usuarioBean.setPersona(rslPersonaBean);
//						UsuarioPerfilBean filtroUP = new UsuarioPerfilBean();
//						filtroUP.setUsuario(new UsuarioBean());
//						filtroUP.getUsuario().setCodigoUsuario(usuarioBean.getCodigoUsuario());
//						lstUsuarioPerfil = usuarioPerfilService.getBuscarPorFiltros(filtroUP);
//					}else{
//						usuarioBean = new UsuarioBean();
//						usuarioBean.setPersona(rslPersonaBean);
//					}
//				}
//			} catch (ServiceException e) {
//				
//				e.printStackTrace();
//			}
//			
//		
//		
//		ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
//		mav.addObject("usuarioBean", usuarioBean);
//		mav.addObject("lstUsuarioPerfil", lstUsuarioPerfil);
//		this.cargarCombos(mav);
//		this.cargarComboPerfiles(mav);
//		return mav;
//	}
//	
//	@RequestMapping(value = "/obtener", method = RequestMethod.POST)
//	public ModelAndView doObtener(@ModelAttribute("usuarioBean") UsuarioBean bean) {
//		
//		List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
//		if(bean.getCodigoUsuario()!=null && bean.getCodigoUsuario()>0){
//			List<UsuarioBean> lstUsuarioBean =new ArrayList<UsuarioBean>(); 
//			try {
//				lstUsuarioBean = usuarioService.getBuscarPorFiltros(bean);
//				if(lstUsuarioBean != null && lstUsuarioBean.size()>0){
//					usuarioBean = (UsuarioBean)lstUsuarioBean.get(0);
//					usuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(usuarioBean.getPersona()));
//					UsuarioPerfilBean filtroUP = new UsuarioPerfilBean();
//					filtroUP.setUsuario(new UsuarioBean());
//					filtroUP.getUsuario().setCodigoUsuario(usuarioBean.getCodigoUsuario());
//					lstUsuarioPerfil = usuarioPerfilService.getBuscarPorFiltros(filtroUP);
//					
//				}
//			} catch (ServiceException e) {
//				
//				e.printStackTrace();
//			}
//			
//		}else{
//			usuarioBean = new UsuarioBean();
//		}
//		
//		ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
//		mav.addObject("usuarioBean", usuarioBean);
//		mav.addObject("lstUsuarioPerfil", lstUsuarioPerfil);
//		this.cargarCombos(mav);
//		this.cargarComboPerfiles(mav);
//		return mav;
//	}
//	
//	@RequestMapping(value = "/eliminarPerfil", method = RequestMethod.POST)
//	public ModelAndView doEliminarPerfil(@ModelAttribute UsuarioPerfilBean bean) {
//		List<UsuarioBean> lstUsuarioBean =new ArrayList<UsuarioBean>();
//		List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
//		if(bean.getCodigoUsuarioPerfil()!=null && bean.getCodigoUsuarioPerfil()>0){
//			
//			try {
//				boolean result = usuarioPerfilService.eliminar(bean);
//				if(result){
//					UsuarioBean usBean = new UsuarioBean();
//					usBean.setCodigoUsuario(bean.getCodigoUsuario());
//					lstUsuarioBean = usuarioService.getBuscarPorFiltros(usBean);
//					
//					
//					if(lstUsuarioBean != null && lstUsuarioBean.size()>0){
//						usuarioBean = (UsuarioBean)lstUsuarioBean.get(0);
//						if(usuarioBean.getPersona()!=null){
//							usuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(usuarioBean.getPersona()));
//						}
//						UsuarioPerfilBean filtroUP = new UsuarioPerfilBean();
//						filtroUP.setUsuario(new UsuarioBean());
//						filtroUP.getUsuario().setCodigoUsuario(usuarioBean.getCodigoUsuario());
//						lstUsuarioPerfil = usuarioPerfilService.getBuscarPorFiltros(filtroUP);
//					}
//				}
//				
//			} catch (ServiceException e) {
//				
//				e.printStackTrace();
//			}
//			
//		}else{
//			usuarioBean = new UsuarioBean();
//		}
//		
//		ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
//		mav.addObject("usuarioBean", usuarioBean);
//		mav.addObject("lstUsuarioPerfil", lstUsuarioPerfil);
//		this.cargarCombos(mav);
//		this.cargarComboPerfiles(mav);
//		return mav;
//	}
//	
//	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
//	public ModelAndView doCambiarPassword(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean) {
//		
//		//System.out.println("lenguaBean Grabar"+lenguaBean);
//		List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
//		List<UsuarioBean> lstUsuario = new ArrayList<UsuarioBean>();
//		Integer sw = -1;
//		String msg="";
//		try {
//			usuarioBean.setNewPassword(usuarioBean.getNombreUsuario());
//			usuarioBean.setFlgRestPass("1");
//			sw = usuarioService.cambiarPassword(usuarioBean);
//			UsuarioBean bean = new UsuarioBean();
//			bean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
//			lstUsuario = usuarioService.getBuscarPorFiltros(bean);
//			if(lstUsuario!=null && lstUsuario.size()>0){
//				usuarioBean = lstUsuario.get(0);
//				if(usuarioBean.getPersona()!=null){
//					usuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(usuarioBean.getPersona()));
//				}
//			}
//			if (sw==1) {
//				UsuarioPerfilBean filtroUP = new UsuarioPerfilBean();
//				filtroUP.setUsuario(new UsuarioBean());
//				filtroUP.getUsuario().setCodigoUsuario(usuarioBean.getCodigoUsuario());
//				lstUsuarioPerfil =usuarioPerfilService.getBuscarPorFiltros(filtroUP);
//			} else{
//				msg= "No se reestablecio contraseña, "
//						+ "por favor coordine con el administrador del sistema";
//				
//			}
//
//		} catch (Exception e) { 
//			e.printStackTrace();
//		}
//
//		/*if (sw) {
//			usuarioBean = new UsuarioBean() ;
//			return this.getLista(usuarioBean);
//		} else {*/
//		ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
//			mav.addObject("usuarioBean", usuarioBean);
//			mav.addObject("lstUsuarioPerfil", lstUsuarioPerfil);
//			mav.addObject("msgError",msg);
//			this.cargarCombos(mav);
//			this.cargarComboPerfiles(mav);
//			return mav;
//		//}
//
//	}
//	
//	@RequestMapping(value = "/cambiarPassUsuario", method = RequestMethod.GET)
//	public ModelAndView doCambiarPassInicio() {
//		
//		ModelAndView mav = new ModelAndView("seguridad/usuario/cambiar-contrasenia-usuario", "command",new UsuarioBean());
//		//mav.addObject("lstSituacion",lstSituacion);
//		mav.addObject("usuarioBean", new UsuarioBean());
//		
//		return mav;
//	}
//	
//	@RequestMapping(value = "/cambiarPass", method = RequestMethod.POST)
//	public ModelAndView doCambiarPass(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean,
//			BindingResult result, SessionStatus status,
//			HttpServletRequest request){
//				List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
//				List<UsuarioBean> lstUsuario = new ArrayList<UsuarioBean>();
//				Integer sw = -1;
//				String msg="";
//				try {
//					UsuarioBean usuario = this.getUsuarioSesion(request);
//					usuarioBean.setCodigoUsuario(usuario.getCodigoUsuario());
//					usuarioBean.setFlgRestPass("0");
//					sw = usuarioService.cambiarPassword(usuarioBean);
//					
//					if (sw==1) {
//						HttpSession session = request.getSession();
//						
//						session.removeAttribute("usuarioSesion");
//						session.invalidate();
//						LoginVo prmLogin = new LoginVo();
//						return  new ModelAndView("seguridad/login/login-admin", "command",prmLogin);
//					} else if(sw==0){
//						msg= "No se reestablecio contrase&ntilde;a, "
//								+ "La contrase&ntilde;a no coincide con la actual";
//					}else{
//						msg= "No se reestablecio contraseña, "
//								+ "por favor coordine con el administrador del sistema";
//					}
//
//				} catch (Exception e) { 
//					e.printStackTrace();
//				}
//
//				
//				ModelAndView mav = new ModelAndView("seguridad/usuario/cambiar-contrasenia-usuario", "command",usuarioBean);
//				mav.addObject("usuarioBean", usuarioBean);
//				mav.addObject("msgError",msg);
//				this.cargarCombos(mav);
//				this.cargarComboPerfiles(mav);
//				return mav;
//				
//	}
//	
//	private ModelAndView getLista(UsuarioBean usuarioBean) {
//		
//		List<UsuarioBean> lstUsuarioBean =new ArrayList<UsuarioBean>(); 
//		try {
//			lstUsuarioBean =  usuarioService.getBuscarPorFiltros(usuarioBean);
//			
//		} catch (Exception e) {
//			System.out.println("getLista " + e.getMessage());
//		}
//
//		ModelAndView mav = new ModelAndView("seguridad/usuario/listado-usuario", "command",usuarioBean);
//		
//		mav.addObject("lstUsuarioBean", lstUsuarioBean);
//		this.cargarCombos(mav);
//		this.cargarComboPerfiles(mav);
//		return mav;
//	}
//	
//	private void cargarCombos(ModelAndView mav){
//		
//		if (lstSituacion==null) {
//			try {
//				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionUsuario");
//			} catch (ServiceException e) {
//				e.printStackTrace();
//			}		
//		}
//		
//		if (lstTipoDocumento==null) {
//			try {
//				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento");
//			} catch (ServiceException e) {
//				e.printStackTrace();
//			}		
//		}
//		
//		mav.addObject("lstSituacion",lstSituacion); 
//		mav.addObject("lstTipoDocumento",lstTipoDocumento);
//	}  
//	
//	private void cargarComboPerfiles(ModelAndView mav){
//		
//		if (lstPerfiles==null) {
//			try {
//				lstPerfiles = perfilService.getBuscarPorFiltros(perfilBean);
//			} catch (ServiceException e) {
//				e.printStackTrace();
//			}		
//		}
//  
//		mav.addObject("lstPerfiles",lstPerfiles); 
//	}  
//
//	public UsuarioBean getUsuarioBean() {
//		return usuarioBean;
//	}
//
//	public void setUsuarioBean(UsuarioBean usuarioBean) {
//		this.usuarioBean = usuarioBean;
//	}
//	
//}
