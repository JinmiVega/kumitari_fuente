package pe.gob.procalidad.natigu.web.gestion.controller.seguridad;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonalBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PerfilBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.SesionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioPerfilBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PerfilService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.SessionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.UsuarioPerfilService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.UsuarioService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.Encrypt;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.EncryptHability;

@Controller
@Scope(value="session")
@RequestMapping(value = "usuarioController")
public class UsuarioController extends BaseController{
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioPerfilService usuarioPerfilService;
	
	@Autowired 
	private PersonaService personaService;
	
	@Autowired
	private Maestra1Service 	maestra1Service;
	
	@Autowired
	private PeticionService peticionService;
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	PerfilService perfilService;

	private UsuarioBean usuarioBean;
	private UsuarioBean usuarioBeanFiltro;
	private UsuarioBean usuarioBeanTmp;
	private PerfilBean perfilBean;
	private List<MaestraBean>	lstSituacion;
	private List<MaestraBean>	lstTipoDocumento;
	private List<PerfilBean>	lstPerfiles;
	
	private String tmpContrasena;
	
	@PostConstruct
	public void init(){
		this.setUsuarioBean(new UsuarioBean());
		this.setUsuarioBeanFiltro(new UsuarioBean());
		this.perfilBean= new PerfilBean();
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("usuarioBean") UsuarioBean bean, HttpServletRequest request)throws Exception {
		UsuarioBean usuarioBean = new UsuarioBean(); 
	 
		
//		return this.getLista(prmMascotaBean);
		ModelAndView mav = new ModelAndView("seguridad/usuario/listado-usuario", "command",usuarioBean);
		
		mav.addObject("lstUsuarioBean", new ArrayList<UsuarioBean>());
		this.cargarCombos(mav);
		this.cargarComboPerfiles(mav);
		return mav;
		//return this.getLista(bean,request);
	}
 
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",new UsuarioBean());
		//mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("usuarioBean", new UsuarioBean());
		this.cargarCombos(mav);
		this.cargarComboPerfiles(mav);
		return mav;
	}
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean, HttpServletRequest request) {
		
		//System.out.println("lenguaBean Grabar"+lenguaBean);
		boolean sw = true;
		String clave ="";
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("UsuarioController/grabar");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	if (usuarioBean.getCodigoUsuario()!=null && usuarioBean.getCodigoUsuario()!=0) {
	        		clave = usuarioBean.getPasswordUsuario();
	        		if (  VO.isEmpty(usuarioBean.getPasswordUsuario())  ) {			
	        			usuarioBean.setPasswordUsuario(tmpContrasena); //Manteniendo la clave del usuario
	        		}else{
	        			Encrypt.init("KEY_ENCRYPT_PASS");
	        			
	        			String passencrypt = Encrypt.encrypt(usuarioBean.getPasswordUsuario());
	        			if(!tmpContrasena.equals(passencrypt)){
	        				//Encriptando la clave principal
	        				usuarioBean.setPasswordUsuario(passencrypt);
	        			}
	        		}
	        		sw = (usuarioService.actualizar(usuarioBean));
	        	} else {
	        		clave = usuarioBean.getPasswordUsuario();
	        		//Encriptando la clave
	        		Encrypt.init("KEY_ENCRYPT_PASS");
	        		usuarioBean.setPasswordUsuario(Encrypt.encrypt(usuarioBean.getPasswordUsuario()));
	        		sw =  (usuarioService.insertar(usuarioBean)); 
	        		
	        	}
	        	
	        } else {
	        	sw = false;
	        }

		} catch (Exception e) { 
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

		if (sw) {
			usuarioBean = new UsuarioBean() ;
			return this.getLista(usuarioBean,request);
		} else {
			usuarioBean.setPasswordUsuario(clave);
			ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
			return mav;
		}

	}
	
	@RequestMapping(value = "/asignar", method = RequestMethod.POST)
	public ModelAndView dAsignar(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean) {
		
		//System.out.println("lenguaBean Grabar"+lenguaBean);
		List<UsuarioBean> lstUsuario = new ArrayList<UsuarioBean>();
		boolean sw = true;
		UsuarioBean oUsuarioBean = new UsuarioBean();
		try {
			if (usuarioBean.getCodigoUsuario()!=null && usuarioBean.getCodigoUsuario()!=0) {
				//sw = (usuarioService.actualizar(usuarioBean));
			} else {
				usuarioBean.setNombreUsuario(usuarioBean.getPersona().getNumeroDocumento());
				
				//usuarioBean.setPasswordUsuario(usuarioBean.getPersona().getNumeroDocumento());
				Encrypt.init("KEY_ENCRYPT_PASS");
				usuarioBean.setPasswordUsuario(Encrypt.encrypt(usuarioBean.getPersona().getNumeroDocumento()));
				
				sw =  (usuarioService.insertar(usuarioBean)); 
				
				if(sw){
					oUsuarioBean = usuarioService.buscarxcodperso(usuarioBean); 
					if(oUsuarioBean!=null && oUsuarioBean.getCodigoUsuario()!=0){
					//	oUsuarioBean = lstUsuario.get(0);
						tmpContrasena = oUsuarioBean.getPasswordUsuario();//Guardando la contrasena en una variable temporal.
						if(oUsuarioBean.getPersona()!=null){
							oUsuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(oUsuarioBean.getPersona()));
						}
					}else{
						oUsuarioBean = new UsuarioBean();
					}
				}
				
				
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		/*if (sw) {
			usuarioBean = new UsuarioBean() ;
			return this.getLista(usuarioBean);
		} else {*/
			ModelAndView mav = new ModelAndView("seguridad/usuario/filtroListaUsuario", "command",oUsuarioBean);//registro-usuario
			mav.addObject("usuarioBean", oUsuarioBean);
			mav.addObject("lstUsuarioPerfil", new ArrayList<UsuarioPerfilBean>());
			this.cargarCombos(mav);
			this.cargarComboPerfiles(mav);
			return mav;
		//}

	}
	
	@RequestMapping(value = "/asignarPerfil", method = RequestMethod.POST)
	public ModelAndView dAsignarPerfil(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean,HttpServletRequest request) {
		
		//System.out.println("lenguaBean Grabar"+lenguaBean);
		List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
		List<UsuarioBean> lstUsuario = new ArrayList<UsuarioBean>();
		boolean sw = true;
		 
		UsuarioBean OUsuarioBean = new UsuarioBean();
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("UsuarioController/asignarPerfil");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	UsuarioPerfilBean usuarioPerfilBean = new UsuarioPerfilBean();
	        	usuarioPerfilBean.setUsuario(new UsuarioBean());
	        	usuarioPerfilBean.getUsuario().setCodigoUsuario(usuarioBean.getCodigoUsuario());
	        	usuarioPerfilBean.setPerfil(new PerfilBean());
	        	usuarioPerfilBean.getPerfil().setCodigoPerfil(usuarioBean.getCodigoPerfil());
	        	usuarioPerfilBean.setCodigoUsuarioCreacion(usuarioBean.getCodigoUsuarioCreacion());
	        	usuarioPerfilBean.setAudHostIP(usuarioBean.getAudHostIP());
	        	
	        	sw = usuarioPerfilService.insertar(usuarioPerfilBean);
	        	UsuarioBean bean = new UsuarioBean();
	        	
	        	bean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
	        	
	        	OUsuarioBean = usuarioService.buscarxcodigousua(bean);
	        	if(OUsuarioBean!=null ){
	        		//OUsuarioBean = lstUsuario.get(0);
	        		tmpContrasena = OUsuarioBean.getPasswordUsuario();//Guardando la contrasena en una variable temporal.
	        		if(OUsuarioBean.getPersona()!=null){
	        			OUsuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(OUsuarioBean.getPersona()));
	        		}
	        	}	        	
	        } else {
	        	sw = false;
	        }
	        
			if (sw) {
				UsuarioPerfilBean filtroUP = new UsuarioPerfilBean();
				filtroUP.setUsuario(new UsuarioBean());
				filtroUP.getUsuario().setCodigoUsuario(OUsuarioBean.getCodigoUsuario());
				lstUsuarioPerfil =usuarioPerfilService.getBuscarPorFiltros(filtroUP);
			} else {
				
				
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		/*if (sw) {
			usuarioBean = new UsuarioBean() ;
			return this.getLista(usuarioBean);
		} else {*/
			ModelAndView mav = new ModelAndView("seguridad/usuario/filtroListaUsuario", "command",OUsuarioBean);//registro-usuario
			mav.addObject("usuarioBean", OUsuarioBean);
			mav.addObject("lstUsuarioPerfil", lstUsuarioPerfil);
			this.cargarCombos(mav);
			this.cargarComboPerfiles(mav);
			return mav;
		//}

	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public ModelAndView doEliminar(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean, HttpServletRequest request) {
		
		//System.out.println("lenguaBean Grabar"+lenguaBean);
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			boolean sw = true;
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("UsuarioController/eliminar");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	if (usuarioBean.getCodigoUsuario()!=null && usuarioBean.getCodigoUsuario()!=0) {
		        		sw = (usuarioService.eliminar(usuarioBean));
		        	}		        	
		        }
	
			} catch (Exception e) { 
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
		//if (sw) {
			usuarioBean = new UsuarioBean() ;
			return this.getLista(usuarioBean,request);
		/*} else {
			ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
			return mav;
		}*/

	}
	
	@RequestMapping(value = "/buscarPersona", method = RequestMethod.POST)
	public ModelAndView doObtenerPersona(@ModelAttribute("usuarioBean") UsuarioBean bean) {
			
		
			PersonaBean rslPersonaBean =new PersonaBean(); 
			List<UsuarioBean> lstUsuarioBean = new ArrayList<UsuarioBean>();
			List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
			UsuarioBean oUsuarioBean =  new UsuarioBean();
			try {
 				rslPersonaBean = personaService.buscarxTipoDocumentoNumeroDocumento(bean.getPersona());
				if(rslPersonaBean != null){
					UsuarioBean filtro = new UsuarioBean();
					
					filtro.setPersona(new PersonaBean());
					filtro.getPersona().setCodigo(rslPersonaBean.getCodigo());
					
					oUsuarioBean = usuarioService.buscarxcodperso(filtro);
					if(oUsuarioBean!=null ){
						//usuarioBean = lstUsuarioBean.get(0);
						tmpContrasena = oUsuarioBean.getPasswordUsuario();//Guardando la contrasena en una variable temporal.
						oUsuarioBean.setPersona(rslPersonaBean);
						UsuarioPerfilBean filtroUP = new UsuarioPerfilBean();
						filtroUP.setUsuario(new UsuarioBean());
						filtroUP.getUsuario().setCodigoUsuario(oUsuarioBean.getCodigoUsuario());
						lstUsuarioPerfil = usuarioPerfilService.getBuscarPorFiltros(filtroUP);
					}else{
						oUsuarioBean = new UsuarioBean();
						oUsuarioBean.setPersona(rslPersonaBean);
					}
				}else {
					oUsuarioBean= new UsuarioBean();
				}
			} catch (ServiceException e) {
				
				e.printStackTrace();
			}
			
		
		
		ModelAndView mav = new ModelAndView("seguridad/usuario/filtroListaUsuario", "command",oUsuarioBean);//registro-usuario
		mav.addObject("usuarioBean", oUsuarioBean);
		mav.addObject("lstUsuarioPerfil", lstUsuarioPerfil);
		this.cargarCombos(mav);
		this.cargarComboPerfiles(mav);
		return mav;
	}
	
 
	
	@RequestMapping(value = "/doObtenerxCodusu", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView doObtenerxCodusu(@ModelAttribute("codigo") Long codigoUsuarioBean) {
		UsuarioBean usuarioBean = new UsuarioBean();
		usuarioBean.setCodigoUsuario(codigoUsuarioBean);
		usuarioBeanTmp = usuarioBean;
		return this.doObtener(usuarioBean);
		
	}
	@RequestMapping(value = "/doObtenerxCodusu", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView doObtenerxCodusu(HttpServletRequest request) {
		UsuarioBean usuarioBean = new UsuarioBean();
		ModelAndView mav = new ModelAndView();
		if(usuarioBeanTmp != null){
			usuarioBean.setCodigoUsuario(usuarioBeanTmp.getCodigoUsuario());
			mav = this.doObtener(usuarioBean);
		}else{
			try {
				mav = this.doListado(usuarioBean,request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mav;
	}
	
	@RequestMapping(value = "/obtener", method = RequestMethod.GET)
	public ModelAndView doObtener(@ModelAttribute("usuarioBean") UsuarioBean bean) {
		UsuarioBean ousuarioBean = new UsuarioBean();
		List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
		if(bean.getCodigoUsuario()!=null && bean.getCodigoUsuario()>0){
			//List<UsuarioBean> lstUsuarioBean =new ArrayList<UsuarioBean>(); 
			
			
			
			try {
				//lstUsuarioBean = usuarioService.getBuscarPorFiltros(bean);
				ousuarioBean = usuarioService.buscarxcodigousua(bean);
				if(ousuarioBean != null){
					 
					tmpContrasena = ousuarioBean.getPasswordUsuario();//Guardando la contrasena en una variable temporal.
					ousuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(ousuarioBean.getPersona()));
					//usuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(usuarioBean.getPersona()));
					UsuarioPerfilBean filtroUP = new UsuarioPerfilBean();
					filtroUP.setUsuario(new UsuarioBean());
					filtroUP.getUsuario().setCodigoUsuario(ousuarioBean.getCodigoUsuario());
					lstUsuarioPerfil = usuarioPerfilService.getBuscarPorFiltros(filtroUP);
					
				}
			} catch (ServiceException e) {
				
				e.printStackTrace();
			}
			
		}else{
			usuarioBean = new UsuarioBean();
		}
		
		ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",ousuarioBean);
		mav.addObject("usuarioBean", ousuarioBean);
		mav.addObject("lstUsuarioPerfil", lstUsuarioPerfil);
		this.cargarCombos(mav);
		this.cargarComboPerfiles(mav);
		return mav;
	}
	
	@RequestMapping(value = "/eliminarPerfil", method = RequestMethod.POST)
	public ModelAndView doEliminarPerfil(@ModelAttribute UsuarioPerfilBean bean,HttpServletRequest request) {
		UsuarioBean OUsuarioBean=null;
		List<UsuarioBean> lstUsuarioBean =new ArrayList<UsuarioBean>();
		List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
		boolean result=false;
		if(bean.getCodigoUsuarioPerfil()!=null && bean.getCodigoUsuarioPerfil()>0){
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("UsuarioController/eliminarPerfil");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	result = usuarioPerfilService.eliminar(bean);
		        }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try {
				if(result){
//					UsuarioBean usBean = new UsuarioBean();
//					usBean.setCodigoUsuario(bean.getCodigoUsuario());
//					lstUsuarioBean = usuarioService.getBuscarPorFiltros(usBean);
//					
//					if(lstUsuarioBean != null && lstUsuarioBean.size()>0){
//						usuarioBean = (UsuarioBean)lstUsuarioBean.get(0);
//						tmpContrasena = usuarioBean.getPasswordUsuario();//Guardando la contrasena en una variable temporal.
//						if(usuarioBean.getPersona()!=null){
//							usuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(usuarioBean.getPersona()));
//						}
//						UsuarioPerfilBean filtroUP = new UsuarioPerfilBean();
//						filtroUP.setUsuario(new UsuarioBean());
//						filtroUP.getUsuario().setCodigoUsuario(usuarioBean.getCodigoUsuario());
//						lstUsuarioPerfil = usuarioPerfilService.getBuscarPorFiltros(filtroUP);
//					}
					UsuarioBean bean1 = new UsuarioBean();
					System.out.println("bean.getCodigoUsuario() " + bean.getCodigoUsuario());
					bean1.setCodigoUsuario(bean.getCodigoUsuario());
					
					OUsuarioBean = usuarioService.buscarxcodigousua(bean1);
					if(OUsuarioBean!=null ){
						//OUsuarioBean = lstUsuario.get(0);
						tmpContrasena = OUsuarioBean.getPasswordUsuario();//Guardando la contrasena en una variable temporal.
						if(OUsuarioBean.getPersona()!=null){
							OUsuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(OUsuarioBean.getPersona()));
						}
					}
				if (OUsuarioBean!=null) {
					UsuarioPerfilBean filtroUP = new UsuarioPerfilBean();
					filtroUP.setUsuario(new UsuarioBean());
					filtroUP.getUsuario().setCodigoUsuario(OUsuarioBean.getCodigoUsuario());
					lstUsuarioPerfil =usuarioPerfilService.getBuscarPorFiltros(filtroUP);
				}
						
			
				}
				
			} catch (ServiceException e) {
				
				e.printStackTrace();
			}
			
		}else{
			OUsuarioBean = new UsuarioBean();
		}
		
		ModelAndView mav = new ModelAndView("seguridad/usuario/filtroListaUsuario", "command",OUsuarioBean);//registro-usuario
		mav.addObject("usuarioBean", OUsuarioBean);//usuarioBean
		mav.addObject("lstUsuarioPerfil", lstUsuarioPerfil);
		this.cargarCombos(mav);
		this.cargarComboPerfiles(mav);
		return mav;
	}
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ModelAndView doCambiarPassword(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean) {
		UsuarioBean OUsuarioBean=null;
		//System.out.println("lenguaBean Grabar"+lenguaBean);
		
		List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
		List<UsuarioBean> lstUsuario = new ArrayList<UsuarioBean>();
		Integer sw = -1;
		String msg="";
		try {
			//usuarioBean.setNewPassword(usuarioBean.getNombreUsuario());
			Encrypt.init("KEY_ENCRYPT_PASS");
			usuarioBean.setNewPassword(Encrypt.encrypt(usuarioBean.getNombreUsuario()));
			usuarioBean.setFlgRestPass("1");
			sw = usuarioService.cambiarPassword(usuarioBean);
			UsuarioBean bean = new UsuarioBean();
			bean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
			lstUsuario = usuarioService.getBuscarPorFiltros(bean);
			if(lstUsuario!=null && lstUsuario.size()>0){
				usuarioBean = lstUsuario.get(0);
				tmpContrasena = usuarioBean.getPasswordUsuario();//Guardando la contrasena en una variable temporal.
				if(usuarioBean.getPersona()!=null){
					usuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(usuarioBean.getPersona()));
				}
			}
			if (sw==1) {
				msg="Se restableció correctamente la contraseña";
				UsuarioBean bean1 = new UsuarioBean();
				System.out.println("bean.getCodigoUsuario() " + bean.getCodigoUsuario());
				bean1.setCodigoUsuario(bean.getCodigoUsuario());
				
				OUsuarioBean = usuarioService.buscarxcodigousua(bean1);
				if(OUsuarioBean!=null ){
					//OUsuarioBean = lstUsuario.get(0);
					tmpContrasena = OUsuarioBean.getPasswordUsuario();//Guardando la contrasena en una variable temporal.
					if(OUsuarioBean.getPersona()!=null){
						OUsuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(OUsuarioBean.getPersona()));
					}
				}
			if (OUsuarioBean!=null) {
				UsuarioPerfilBean filtroUP = new UsuarioPerfilBean();
				filtroUP.setUsuario(new UsuarioBean());
				filtroUP.getUsuario().setCodigoUsuario(OUsuarioBean.getCodigoUsuario());
				lstUsuarioPerfil =usuarioPerfilService.getBuscarPorFiltros(filtroUP);
				
			}
			
			} else{
				usuarioBean.setNewPassword(tmpContrasena);
				msg= "No se reestablecio contraseña, "
						+ "por favor coordine con el administrador del sistema";
				
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		/*if (sw) {
			usuarioBean = new UsuarioBean() ;
			return this.getLista(usuarioBean);
		} else {*/
			ModelAndView mav = new ModelAndView("seguridad/usuario/filtroListaUsuario", "command",OUsuarioBean);//registro-usuario
			mav.addObject("usuarioBean", OUsuarioBean);
			mav.addObject("lstUsuarioPerfil", lstUsuarioPerfil);
			mav.addObject("msgError",msg);
			mav.addObject("msgconfir",msg);
			this.cargarCombos(mav);
			this.cargarComboPerfiles(mav);
			return mav;
		//}

	}
	
	@RequestMapping(value = "/cambiarPassUsuario", method = RequestMethod.GET)
	public ModelAndView doCambiarPassInicio() {
		
		ModelAndView mav = new ModelAndView("seguridad/usuario/cambiar-contrasenia-usuario", "command",new UsuarioBean());
		//mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("usuarioBean", new UsuarioBean());
		
		return mav;
	}
	
	@RequestMapping(value = "/cambiarPass", method = RequestMethod.POST)
	public ModelAndView doCambiarPass(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean,
			BindingResult result, SessionStatus status,
			HttpServletRequest request){
		
		List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
		List<UsuarioBean> lstUsuario = new ArrayList<UsuarioBean>();
		Integer sw = -1;
		String msg="";
		String oldPass = "";
		String newPass = "";
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try {
				
				String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
			    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
			    EncryptHability aesUtil = new EncryptHability(128, 1000);
		        String pass1 = aesUtil.decrypt(salt, iv, "password", usuarioBean.getPasswordUsuario());
		        String pass2 = aesUtil.decrypt(salt, iv, "newpassword", usuarioBean.getNewPassword());
		        usuarioBean.setPasswordUsuario(pass1);
		        usuarioBean.setNewPassword(pass2);
		        

		        
				UsuarioBean usuario = this.getUsuarioSesion(request);
				usuarioBean.setCodigoUsuario(usuario.getCodigoUsuario());
				usuarioBean.setFlgRestPass("0");
				Encrypt.init("KEY_ENCRYPT_PASS");
				oldPass = usuarioBean.getPasswordUsuario();
				newPass = usuarioBean.getNewPassword();
				usuarioBean.setPasswordUsuario(Encrypt.encrypt(usuarioBean.getPasswordUsuario()));
				usuarioBean.setNewPassword(Encrypt.encrypt(usuarioBean.getNewPassword()));
				sw = usuarioService.cambiarPassword(usuarioBean);
				
				if (sw==1) {
					HttpSession session = request.getSession();
					// activar flag para resetear las sessiones en otros navegadores
					SesionBean _sesionBean=new SesionBean();
					_sesionBean.setUser_id((int)usuario.getCodigo());
					_sesionBean.setSession_id(request.getSession().getId());
					
					boolean flag=sessionService.sessionGestor(_sesionBean, "UPD_PASS");
					if(flag) {
						System.out.println("========= CERRAR CESSIO : 1");
					}else {
						System.out.println("========= NO CERRAR CESSIO : 0");
					}
					
					session.removeAttribute("usuarioSesion");
					session.invalidate();
					LoginVo prmLogin = new LoginVo();
					return  new ModelAndView("seguridad/login/login-admin", "command",prmLogin);
				} else if(sw==0){
					usuarioBean.setPasswordUsuario(oldPass);
					usuarioBean.setNewPassword(newPass);
					msg= "No se reestablecio contrase&ntilde;a, "
							+ "La contrase&ntilde;a no coincide con la actual";
				}else{
					usuarioBean.setPasswordUsuario(oldPass);
					usuarioBean.setNewPassword(newPass);
					msg= "No se reestablecio contrase&ntilde;a, "
							+ "por favor coordine con el administrador del sistema";
				}
				
			} catch (Exception e) { 
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
		
		ModelAndView mav = new ModelAndView("seguridad/usuario/cambiar-contrasenia-usuario", "command",usuarioBean);
		mav.addObject("usuarioBean", usuarioBean);
		mav.addObject("msgError",msg);
		this.cargarCombos(mav);
		this.cargarComboPerfiles(mav);
		return mav;
	}
	
	private ModelAndView getLista(UsuarioBean usuarioBean, HttpServletRequest request) {
		UsuarioBean usuarioActual = new  UsuarioBean();
		List<UsuarioBean> lstUsuarioBean =new ArrayList<UsuarioBean>(); 
		try {
			
			UsuarioBean userActual = this.getUsuarioSesion(request);
			usuarioActual = userActual;
			if(	!VO.isNull(userActual) 
				&& !VO.isNull(userActual.getCodPerfilUsuSelec())
				&& userActual.getCodPerfilUsuSelec()==6){ //OPERADOR INSTITUCIONAL
				
				//usuarioBean.setCodigoPerfil(new Long(2)); //DOCENTE
				
			}
			usuarioBean.setAudCodigoUsuario(userActual.getCodigoUsuario());
			usuarioBean.setCodPerfilUsuSelec(userActual.getCodPerfilUsuSelec());
			lstUsuarioBean =  usuarioService.getBuscarPorFiltros(usuarioBean);
			System.out.println("getLista size " + lstUsuarioBean.size());
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("seguridad/usuario/listado-usuario", "command",usuarioBean);
		
		mav.addObject("lstUsuarioBean", lstUsuarioBean);
		if(usuarioActual.getCodPerfilUsuSelec() == 6 && usuarioBean.getCodigoPerfil() != 2 ){
			lstPerfiles = new ArrayList<PerfilBean>();
			mav.addObject("lstPerfiles",lstPerfiles); 
		}else{
			this.cargarComboPerfiles(mav);
		}
		
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscar(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean,
			HttpServletRequest request)
			throws Exception { 
		return this.doBuscarListado(usuarioBeanFiltro, request);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscarListado(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean,
			HttpServletRequest request)
			throws Exception { 
		usuarioBeanFiltro = usuarioBean;
		return this.getLista(usuarioBean, request);
	}
	
	private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionUsuario",0);
			} catch (ServiceException e) {
				e.printStackTrace();
			}		
		}
		
		if (lstTipoDocumento==null) {
			try {
				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento",1);
			} catch (ServiceException e) {
				e.printStackTrace();
			}		
		}
		
		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstTipoDocumento",lstTipoDocumento);
	}  
	
	private void cargarComboPerfiles(ModelAndView mav){
		lstPerfiles= null;
		if (lstPerfiles==null) {
			try {
				lstPerfiles = perfilService.getBuscarPorFiltros(perfilBean);
			} catch (ServiceException e) {
				e.printStackTrace();
			}		
		}
  
		mav.addObject("lstPerfiles",lstPerfiles); 
	}  

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public UsuarioBean getUsuarioBeanFiltro() {
		return usuarioBeanFiltro;
	}

	public void setUsuarioBeanFiltro(UsuarioBean usuarioBeanFiltro) {
		this.usuarioBeanFiltro = usuarioBeanFiltro;
	}
	
}
