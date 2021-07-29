package pe.gob.procalidad.natigu.web.gestion.controller.inicio;

import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaAccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.IntentoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PerfilBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.SesionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioPerfilBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.generatoken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.AccesoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.IntentoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.SessionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.UsuarioPerfilService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.UsuarioService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.NetUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.AccesoMenuVo;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.PermisoVo;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.Encrypt;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.EncryptHability;

@Controller
@RequestMapping(value = "inicioController")
@SessionAttributes("usuarioSesion")
@Scope(value="session")
public class InicioController extends BaseController{
	
	@Autowired
	AccesoService accesoService;
	
	@Autowired
	private UsuarioService usuarioService; 
	
	@Autowired
	private UsuarioPerfilService usuarioPerfilService;
	
	@Autowired
	private IntentoService intentoService;
	@Autowired
	private SessionService sessionService;
	
	@RequestMapping(value = "/controlAcceso", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login") LoginVo prmLogin,
		BindingResult result, SessionStatus status,
		HttpServletRequest request) throws Exception {
		
		
	     String key =  prmLogin.getKey().toString();
	     String token_captcha = (String) request.getSession().getAttribute("token_captcha") ;
	   
		 if(!token_captcha.equals(key)) {
			
			 ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command", prmLogin);
			mav.addObject("msgErrorLogin","Key no valido");
				return mav;
			 
		 }else {
			request.getSession().removeAttribute("token_captcha");
		 }
		
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("usuarioSesion");
		session.invalidate();
		
		session.setMaxInactiveInterval(1500);
		
		this.setUsuarioBean(new UsuarioBean());
		
		//encrypt front - back
		String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    EncryptHability aesUtil = new EncryptHability(128, 1000);
        String plaintextUser = aesUtil.decrypt(salt, iv, "usuario", prmLogin.getNombreUsuario().toString());
        prmLogin.setNombreUsuario(plaintextUser);
        String plaintextPass = aesUtil.decrypt(salt, iv, "clave", prmLogin.getContrasena().toString());
        prmLogin.setContrasena(plaintextPass);
        
        
   
	    
		//Inicializando el Encrypt
		Encrypt.init("KEY_ENCRYPT_PASS");
		
		
		
		
		if (prmLogin != null) {
			boolean habilitadoIp = true;
			IntentoBean prmIntento = new IntentoBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			habilitadoIp = intentoService.existe(prmIntento);
			prmIntento.setPlataforma("gestion");
	        if(habilitadoIp) {
	        	UsuarioBean prmUsuario = new UsuarioBean();
				//Encriptando la clave ingresada
				prmUsuario.setPasswordUsuario(Encrypt.encrypt(prmLogin.getContrasena()));
				//prmUsuario.setPasswordUsuario(prmLogin.getContrasena());
				prmUsuario.setNombreUsuario(prmLogin.getNombreUsuario());
				
				UsuarioBean oUsuario = usuarioService.autenticar(prmUsuario);
				
				//validar contraseña
				String pass = prmLogin.getContrasena();
				
				String messagePass = "La contraseña debe: ";
				if((pass.length() < 8)) {
			    	messagePass+= "tener mínimo 8 dígitos, ";
				} 
			    if(!pass.matches(".*[a-z].*")){
					messagePass+= "contener al menos una minúscula, ";
				} 
			    if(!pass.matches(".*[A-Z].*")){
					messagePass+= "contener al menos una mayúscula, ";
				} 
			    if(!pass.matches(".*[0-9].*")){
					messagePass+= "contener al menos un número, ";
				} 
			    if(messagePass == "La contraseña debe: ") {
					messagePass = "";
				} else {
					messagePass = messagePass.substring(0,messagePass.length()-2);
				}
				
			    //System.out.println("contraseña correcta "+pass);
			    //System.out.println("messagePass "+messagePass);
				
				
				if (oUsuario != null) {
					intentoService.eliminar(prmIntento);
					if (oUsuario.getSituacion().getCodigoRegistro()!= 1) {//Activo
						this.registrarAudAcceso(prmLogin.getNombreUsuario(), 5, request);
						ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command", prmLogin);
						mav.addObject("msgErrorLogin","Su usuario no se encuentra activo, "
								+ "por favor coordine con el administrador del sistema");
						return mav;
					}
					
					if(oUsuario.getFlgRestPass()!=null && "1".equals(oUsuario.getFlgRestPass())){
						request.getSession().setMaxInactiveInterval(1500);
						request.getSession().setAttribute("usuarioSesion", oUsuario);
						oUsuario.setPasswordUsuario("");
						oUsuario.setNewPassword("");
					
						//if(oUsuario.getCodigoPerfil() != null && oUsuario.getCodigoPerfil() != 4) {
							ModelAndView mav = new ModelAndView("seguridad/login/cambiar-contrasenia", "command",oUsuario);
							mav.addObject("usuarioBean", oUsuario);
							return mav;
						/*} else {
							ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command", prmLogin);
							mav.addObject("msgErrorLogin","Usuario no permitido, "
									+ "por favor coordine con el administrador del sistema");
							return mav;
						}*/
						
					} else if(oUsuario.getCodigoPerfil() != null && oUsuario.getCodigoPerfil() != 4){
						ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command", prmLogin);
						mav.addObject("msgErrorLogin","Usuario no permitido, por favor coordine con el administrador del sistema");
						return mav;
					} 
					
					//validar contraseña
					if(messagePass != null && messagePass != ""){
						ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command", prmLogin);
						mav.addObject("msgErrorLogin",messagePass);
						return mav;
					}
					
					/* BUSCAR LOS PERFILES DEL USUARIO */
					List<UsuarioPerfilBean> lstUsuarioPerfilBean = new ArrayList<UsuarioPerfilBean>();
					UsuarioPerfilBean filtroUsuarioPerfilBean = new UsuarioPerfilBean();
					filtroUsuarioPerfilBean.setUsuario(new UsuarioBean());
					filtroUsuarioPerfilBean.getUsuario().setCodigoUsuario(oUsuario.getCodigoUsuario());
					lstUsuarioPerfilBean = usuarioPerfilService.getBuscarPorFiltros(filtroUsuarioPerfilBean);
					
					long codPerfilSelecc = 0;
					
					if( !VO.isEmptyList(lstUsuarioPerfilBean) ){
						UsuarioPerfilBean prmUP = lstUsuarioPerfilBean.get(0);
						codPerfilSelecc = prmUP.getPerfil().getCodigoPerfil();
					}
					
					oUsuario.setCodPerfilUsuSelec(codPerfilSelecc);
					oUsuario.setLstUsuarioPerfil(lstUsuarioPerfilBean);
						
					this.registrarAudAcceso(prmLogin.getNombreUsuario(), 4, request);
										
					if(codPerfilSelecc!=4) {
						return this.getLista(oUsuario, request);
						
						
					} else {
						request.getSession().setAttribute("usuarioSesion", oUsuario);
						//ModelAndView mav = new ModelAndView("seguridad/login/cambiar-contrasenia", "command",usuarioBean);
						ModelAndView mav = new ModelAndView("seguridad/login/login-admin", "command",prmLogin);
						mav.addObject("msgErrorLogin", "Acceso no permitido");
						mav.addObject("usuarioBean", usuarioBean);
						return mav;
					}
				} else {
					UsuarioBean tmpUsuario = new UsuarioBean();
					tmpUsuario.setNombreUsuario("NV");
					this.setUsuarioBean(tmpUsuario);
					this.registrarAudAcceso(prmLogin.getNombreUsuario(), 6, request);
					
					ModelAndView mav = new ModelAndView("seguridad/login/login-admin", "command",prmLogin);
					
					intentoService.insertar(prmIntento);
					
					String message = "Usuario y/o contraseña incorrecta. Vuelva a intentarlo.";
					
					//validar contraseña
					if(messagePass != null && messagePass != ""){
						message+=", además "+messagePass;
					}
					mav.addObject("msgErrorLogin", message);
					mav.addObject("usuarioSesion", tmpUsuario);
					return mav;
				}
	        }else {
	        	ModelAndView mav = new ModelAndView("seguridad/login/login-admin", "command",prmLogin);
	        	String message = "Has intentado más de 3 veces, inicio de sesión se habilitará en 30 minutos";
	        	mav.addObject("msgErrorLogin", message);
				return mav;
	        }
		}else{
			return  new ModelAndView("seguridad/login/login-admin", "command",prmLogin);
		}
	}
	
	@RequestMapping(value = "/controlAccesoTk", method = RequestMethod.POST)
	public String loginTk(HttpServletRequest request) throws Exception {
		
		
	    
	   
		 String cod = request.getParameter("cod");
		 
		HttpSession session = request.getSession();
		session.setAttribute("token_captcha", cod);
		 
        
        return "1";
        
    
	}

	@RequestMapping(value = "/controlAcceso", method = RequestMethod.GET)
	public ModelAndView controlAcceso(@ModelAttribute("usuarioSesion") UsuarioBean usuario,
			HttpServletRequest request) throws Exception {
		return this.getLista(usuario, request);
	}
	
	@RequestMapping(value = "/autenticartoken", method = RequestMethod.POST)
	public @ResponseBody String  autenticartoken(HttpServletRequest request) throws Exception {
		
		String cod = request.getParameter("cod");
		
		HttpSession session = request.getSession();
		session.setAttribute("token_captcha", cod);
		
		
		return "1";
	}
	
	@RequestMapping(value = "/inicio", method = RequestMethod.POST)
	public ModelAndView incio(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean,
		BindingResult result, SessionStatus status,
		HttpServletRequest request) throws Exception {
		
		UsuarioBean usuario = this.getUsuarioSesion(request);
		UsuarioBean oUsuarioBean = new UsuarioBean();
		/*HttpSession session = request.getSession();
		session.removeAttribute("usuarioSesion");
		session.invalidate();
		*/
		//this.setUsuarioBean(new UsuarioBean());
	
		//Inicializando el Encrypt
		Encrypt.init("KEY_ENCRYPT_PASS");
		
		String passActual = "";
		String passNew = "";
		
		if (usuarioBean != null) {
			UsuarioBean prmUsuario = new UsuarioBean();
			//Encriptando la clave ingresada
			passActual = Encrypt.encrypt(usuarioBean.getPasswordUsuario());
			passNew    = Encrypt.encrypt(usuarioBean.getNewPassword());
			
			prmUsuario.setCodigoUsuario(usuarioBean.getCodigoUsuario());
			prmUsuario.setPasswordUsuario(passActual);
			prmUsuario.setNewPassword(passNew);
			prmUsuario.setFlgRestPass("0");
			this.setAuditoria(prmUsuario, request, false);
			Integer resultI = usuarioService.cambiarPassword(prmUsuario);
			
			if (resultI != null && resultI>0) {
				UsuarioBean filtro = new UsuarioBean();
				filtro.setCodigoUsuario(usuarioBean.getCodigoUsuario());
				
			  oUsuarioBean = usuarioService.buscarxcodigousua(filtro);
				if(oUsuarioBean != null){
					usuario = oUsuarioBean;
				}
				usuario.setPasswordUsuario(passActual);
				usuario.setFlgRestPass("0");
				/** BUSCAR LOS PERFILES DEL USUARIO **/
				List<UsuarioPerfilBean> lstUsuarioPerfilBean = new ArrayList<UsuarioPerfilBean>();
				UsuarioPerfilBean filtroUsuarioPerfilBean = new UsuarioPerfilBean();
				filtroUsuarioPerfilBean.setUsuario(new UsuarioBean());
				filtroUsuarioPerfilBean.getUsuario().setCodigoUsuario(usuarioBean.getCodigoUsuario());
				lstUsuarioPerfilBean = usuarioPerfilService.getBuscarPorFiltros(filtroUsuarioPerfilBean);
				
				long codPerfilSelecc = 0;
				
				if( !VO.isEmptyList(lstUsuarioPerfilBean) ){
					UsuarioPerfilBean prmUP = lstUsuarioPerfilBean.get(0);
					codPerfilSelecc = prmUP.getPerfil().getCodigoPerfil();
				}
				
				usuario.setCodPerfilUsuSelec(codPerfilSelecc);
				usuario.setLstUsuarioPerfil(lstUsuarioPerfilBean);
						
				return this.getLista(usuario, request);
			} else {
				UsuarioBean filtro = new UsuarioBean();
				filtro.setCodigoUsuario(usuarioBean.getCodigoUsuario());
				 oUsuarioBean = usuarioService.buscarxcodigousua(filtro);
				
				if(oUsuarioBean != null){
					usuario = oUsuarioBean;
				}
				request.getSession().setAttribute("usuarioSesion", usuario);
				ModelAndView mav = new ModelAndView("seguridad/login/cambiar-contrasenia", "command",usuarioBean);
				mav.addObject("msgErrorLogin", "La contrase&nacute;a no coincide con la actual");
				mav.addObject("usuarioBean", usuarioBean);
				return mav;
			}
		}else{
			
			return  new ModelAndView("seguridad/login/login-admin", "command",new LoginVo());
		}
	}
	
	private ModelAndView getLista(UsuarioBean usuario, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("inicio");
		HttpSession session = request.getSession();
		SesionBean _sesionBean=new SesionBean();
		
		
		String session_id=request.getSession().getId();
		long user_id=usuario.getCodigo();
		
		_sesionBean.setUser_id((int)user_id);
		_sesionBean.setSession_id(session_id);
		
		
		
		try {
			boolean flag_v=sessionService.sessionGestor(_sesionBean, "VALIDAR");
			if(flag_v) {
				System.out.println("========= CERRAR CESSION : >1 >direccionar al login ");
				sessionService.sessionGestor(_sesionBean, "CERRAR_SESSION");
				session.removeAttribute("usuarioSesion");
				session.invalidate();
				//ModelAndView mav_v = new ModelAndView("../home", "command","");
				ModelAndView mav_v = new ModelAndView("seguridad/login/login-admin", "command",new LoginVo());
				mav_v.addObject("msgErrorLogin", "Acceso no permitido");
				mav_v.addObject("usuarioBean", usuarioBean);
				
				return mav_v;
				
			}
			
			else {
				
				//-------------------------------------------
				int totalPerfiles = 0;
				
				/** TRAER ACCESOS **/
				if(!VO.isEmptyList(usuario.getLstUsuarioPerfil())){
					
					totalPerfiles = usuario.getLstUsuarioPerfil().size();
					
					AccesoBean filtroAccesoBean = new AccesoBean();
					filtroAccesoBean.setPerfil(new PerfilBean());
					filtroAccesoBean.getPerfil().setCodigo(usuario.getCodPerfilUsuSelec());
					
					List<AccesoBean> lstAccesoBean =  accesoService.getBuscarPorFiltros(filtroAccesoBean);
					
					request.getSession().setAttribute("lstAccesoBean", lstAccesoBean);
							
					/** verificar accesos **/
					AccesoMenuVo accesoMenuVo = verificarAccesos(lstAccesoBean);
					request.getSession().setAttribute("accesoMenu", accesoMenuVo);
					mav.addObject("accesoMenu", accesoMenuVo);		
					usuario.setLstAcceso(lstAccesoBean);
					
					//generar token
					String token = generatoken.createUserJWToken(usuario);
					System.out.println("token "+token);
					session.setAttribute("token", token);
				}
				
				this.setUsuarioBean(usuario);	
				request.getSession().setAttribute("totalPerfiles", totalPerfiles);
				mav.addObject("totalPerfiles",totalPerfiles);
				request.getSession().setMaxInactiveInterval(1500);
				request.getSession().setAttribute("usuarioSesion", usuario);
				mav.addObject("usuarioSesion", usuario);
					
				
				boolean flag=sessionService.sessionGestor(_sesionBean, "CREAR_SESSION");
				if(flag) {
					System.out.println("========= CERRAR CESSIO : 1");
				}else {
					System.out.println("========= NO CERRAR CESSIO : 0");
					
				}
				
				
				
				
				/** REPORTE INICIAL **/
				List<InstitucionBean> lstInstitucionBean = this.fs.getInstitucionService().listarInstitucionxTipoUsuario(usuario);
				
				/** Perfil de usuario 
				 * 1: Administrador
				 * 2: Docente
				 * 3: Supervisor,
				 * 5: Operador
				 * 6: Operador Institucional 
				**/
				long idInstitucion = !VO.isEmptyList(lstInstitucionBean) ? lstInstitucionBean.get(0).getCodigo() : 0; 
				mav.addObject("listaInstitucion", lstInstitucionBean);
				mav.addObject("idInstitucion", idInstitucion);
				//---------------------------------
				
			}
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar(@ModelAttribute("usuarioSesion") UsuarioBean usuario,
			HttpServletRequest request) throws Exception {
		return this.getLista(usuario, request);
	}
	
	@RequestMapping(value = "/obtenerAccesos", method = RequestMethod.GET)
	@ResponseBody
	public void obtenerAccesos(@RequestParam("codperfil") String codperfil,
			HttpServletRequest request) throws Exception {
		
		UsuarioBean usuario = this.getUsuarioSesion(request);
		usuario.setCodPerfilUsuSelec(VO.toLong(codperfil));
		
		request.getSession().setAttribute("usuarioSesion", usuario);
		
	}
	
	@RequestMapping(value = "/reporteLenguas", method = RequestMethod.GET)
	@ResponseBody
	public List<InstitucionLenguaBean> getReporteLenguas(@RequestParam("codinst") String codinst,
			HttpServletRequest request) throws Exception {
		
		List<InstitucionLenguaBean> lista = new ArrayList<InstitucionLenguaBean>();
		
		try {
			InstitucionLenguaBean filtro = new InstitucionLenguaBean();
			filtro.getInstitucionBean().setCodigo(VO.toLong(codinst));
			lista = this.fs.getInstitucionLenguaService().reporteAlumLengInst(filtro);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return lista;
	}
	
	private AccesoMenuVo verificarAccesos(List<AccesoBean> listaAcceso) {
		
		AccesoMenuVo accesoMenuVo = new AccesoMenuVo();
		
		if(!VO.isEmptyList(listaAcceso)){
			for (int i = 0; i < listaAcceso.size(); i++) {
				AccesoBean bean = listaAcceso.get(i);
				
				if(		!VO.isNull(bean.getComponente()) 
					&& 	!VO.isNull(bean.getComponente().getNombreComponente())
				  ){
					
					String nombreComponente = bean.getComponente().getNombreComponente();
					
					/** INDICADOR **/
					if (nombreComponente.equals("indicador")) {
						
						accesoMenuVo.setAloc_indicador(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}
					
					/** INSTITUCION **/
					if (nombreComponente.equals("institucion")) {
						
						accesoMenuVo.setAloc_institucion(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}
					
					/** LENGUA **/
					if (nombreComponente.equals("lengua")) {
						
						accesoMenuVo.setAloc_lengua(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}
					
					/** MATERIAL **/
					if (nombreComponente.equals("material")) {
						
						accesoMenuVo.setAloc_material(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}else if (nombreComponente.equals("material_carga_directa")) {
						accesoMenuVo.setAloc_material_carga_directa(new PermisoVo());
						accesoMenuVo.getAloc_material_carga_directa().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_material_carga_directa().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_material_carga_directa().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_material_carga_directa().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("material_carga_masiva")) {
						accesoMenuVo.setAloc_material_carga_masiva(new PermisoVo());
						accesoMenuVo.getAloc_material_carga_masiva().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_material_carga_masiva().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_material_carga_masiva().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_material_carga_masiva().setExportacion(bean.isFlgExport() ? true : false);
					
					}
					
					/** GESTOR **/
					if (nombreComponente.equals("personal")) {
						
						accesoMenuVo.setAloc_personal(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}
					
					/** INSCRIPCION **/
					if (nombreComponente.equals("inscripcion")) {
						
						accesoMenuVo.setAloc_inscripcion(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}
					
					/** MATRICULA **/
					if (nombreComponente.equals("matricula")) {
						
						accesoMenuVo.setAloc_matricula(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}else if (nombreComponente.equals("matricula_registro")) {
						accesoMenuVo.setAloc_matricula_registro(new PermisoVo());
						accesoMenuVo.getAloc_matricula_registro().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_matricula_registro().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_matricula_registro().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_matricula_registro().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("matricula_asignar_usuario")) {
						accesoMenuVo.setAloc_matricula_asignar_usuario(new PermisoVo());
						accesoMenuVo.getAloc_matricula_asignar_usuario().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_matricula_asignar_usuario().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_matricula_asignar_usuario().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_matricula_asignar_usuario().setExportacion(bean.isFlgExport() ? true : false);
					
					}
					
					/** DOCENTE **/
					if (nombreComponente.equals("docente")) {
						
						accesoMenuVo.setAloc_docente(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}
					
					/** ESTUDIANTE **/
					if (nombreComponente.equals("alumno")) {
						
						accesoMenuVo.setAloc_alumno(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}else if (nombreComponente.equals("alumno_registro")) {
						accesoMenuVo.setAloc_alumno_registro(new PermisoVo());
						accesoMenuVo.getAloc_alumno_registro().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_alumno_registro().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_alumno_registro().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_alumno_registro().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("alumno_seguimiento")) {
						accesoMenuVo.setAloc_alumno_seguimiento(new PermisoVo());
						accesoMenuVo.getAloc_alumno_seguimiento().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_alumno_seguimiento().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_alumno_seguimiento().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_alumno_seguimiento().setExportacion(bean.isFlgExport() ? true : false);
					
					}
					
					/** MODO OFFLINE **/
					if (nombreComponente.equals("offline")) {
						
						accesoMenuVo.setAloc_modo_offline(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}else if (nombreComponente.equals("offline_generar_archivo")) {
						accesoMenuVo.setAloc_modo_offline_genera_archivo(new PermisoVo());
						accesoMenuVo.getAloc_modo_offline_genera_archivo().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_modo_offline_genera_archivo().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_modo_offline_genera_archivo().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_modo_offline_genera_archivo().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("offline_sincronizar")) {
						accesoMenuVo.setAloc_modo_offline_sincronizar(new PermisoVo());
						accesoMenuVo.getAloc_modo_offline_sincronizar().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_modo_offline_sincronizar().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_modo_offline_sincronizar().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_modo_offline_sincronizar().setExportacion(bean.isFlgExport() ? true : false);
					
					}
					
					/** SEGURIDAD **/
					if (nombreComponente.equals("seguridad")) {
						
						accesoMenuVo.setAloc_seguridad(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}else if (nombreComponente.equals("seguridad_usuario")) {
						accesoMenuVo.setAloc_seguridad_usuario(new PermisoVo());
						accesoMenuVo.getAloc_seguridad_usuario().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_seguridad_usuario().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_seguridad_usuario().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_seguridad_usuario().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("seguridad_perfil")) {
						accesoMenuVo.setAloc_seguridad_perfil(new PermisoVo());
						accesoMenuVo.getAloc_seguridad_perfil().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_seguridad_perfil().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_seguridad_perfil().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_seguridad_perfil().setExportacion(bean.isFlgExport() ? true : false);
					
					}else if (nombreComponente.equals("seguridad_acceso")) {
						accesoMenuVo.setAloc_seguridad_acceso(new PermisoVo());
						accesoMenuVo.getAloc_seguridad_acceso().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_seguridad_acceso().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_seguridad_acceso().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_seguridad_acceso().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("seguridad_auditoria")) {
						accesoMenuVo.setAloc_seguridad_auditoria(new PermisoVo());
						accesoMenuVo.getAloc_seguridad_auditoria().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_seguridad_auditoria().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_seguridad_auditoria().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_seguridad_auditoria().setExportacion(bean.isFlgExport() ? true : false);
						
					}
					
					/** CONFIGURACION **/
					if (nombreComponente.equals("configuracion")) {
						
						accesoMenuVo.setAloc_configuracion(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}else if (nombreComponente.equals("configuracion_tabla_maestra")) {
						accesoMenuVo.setAloc_configuracion_tabla_maestra(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_tabla_maestra().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_tabla_maestra().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_tabla_maestra().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_tabla_maestra().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("configuracion_mascota")) {
						accesoMenuVo.setAloc_configuracion_mascota(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_mascota().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_mascota().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_mascota().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_mascota().setExportacion(bean.isFlgExport() ? true : false);
					
					}else if (nombreComponente.equals("configuracion_traduccion_general")) {
						accesoMenuVo.setAloc_configuracion_traduccion_general(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_traduccion_general().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_traduccion_general().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_traduccion_general().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_traduccion_general().setExportacion(bean.isFlgExport() ? true : false);
					
					}else if (nombreComponente.equals("configuracion_fondo")) {
						accesoMenuVo.setAloc_configuracion_fondo(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_fondo().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_fondo().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_fondo().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_fondo().setExportacion(bean.isFlgExport() ? true : false); 
						
					}else if (nombreComponente.equals("configuracion_modal")) {
						accesoMenuVo.setAloc_configuracion_modal(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_modal().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_modal().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_modal().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_modal().setExportacion(bean.isFlgExport() ? true : false); 
						
					}else if (nombreComponente.equals("configuracion_combo")) {
						accesoMenuVo.setAloc_configuracion_combo(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_combo().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_combo().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_combo().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_combo().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("configuracion_premio")) {
						accesoMenuVo.setAloc_configuracion_premio(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_premio().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_premio().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_premio().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_premio().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("configuracion_ficha_puntaje")) {
						accesoMenuVo.setAloc_configuracion_ficha_puntaje(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_ficha_puntaje().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_ficha_puntaje().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_ficha_puntaje().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_ficha_puntaje().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("configuracion_slider")) {
						accesoMenuVo.setAloc_configuracion_slider(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_slider().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_slider().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_slider().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_slider().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("configuracion_mensaje")) {
						accesoMenuVo.setAloc_configuracion_mensaje(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_mensaje().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_mensaje().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_mensaje().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_mensaje().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("configuracion_glosario")) {
						accesoMenuVo.setAloc_configuracion_glosario(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_glosario().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_glosario().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_glosario().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_glosario().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("configuracion_traduccion")) {
						accesoMenuVo.setAloc_configuracion_traduccion(new PermisoVo());
						accesoMenuVo.getAloc_configuracion_traduccion().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getAloc_configuracion_traduccion().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getAloc_configuracion_traduccion().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getAloc_configuracion_traduccion().setExportacion(bean.isFlgExport() ? true : false);
						
					}
					
				}
				
			}
		}
	
		return accesoMenuVo;
	}
	
	private void registrarAudAcceso(String nomUsuario, Integer tipoAccion, HttpServletRequest request){
		try {
			AuditoriaAccesoBean bean = new AuditoriaAccesoBean();
			bean.getTipoAccion().setCodigoRegistro(tipoAccion);
			bean.setNomUsuario(nomUsuario);
			bean.setIpCreacion(NetUtil.getClientIpAddr(request));
			bean.getTipoSistema().setCodigoRegistro(1);
			
			if(!VO.isNull(bean.getIpCreacion()) && !bean.getIpCreacion().equals("0:0:0:0:0:0:0:1")){
				this.fs.getAuditoriaService().insertarAuditoriaAcceso(bean);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@RequestMapping(value = "/encrypt", method = RequestMethod.GET)
    protected @ResponseBody String doGet(@RequestParam("passphrase") String passphrase, @RequestParam("iterationCount") int iterationCount,
		@RequestParam("keySize") String keySize, @RequestParam("salt") String salt, @RequestParam("ciphertext") String ciphertext,
		@RequestParam("iv") String iv) throws IOException {
        String passphrase_a = passphrase;
        int iterationCount_a = iterationCount;
        int keySize_a = Integer.parseInt(keySize);
        String salt_a = salt;
        String ciphertext_a = ciphertext;
        String iv_a = iv;
        
        EncryptHability aesUtil = new EncryptHability(keySize_a, iterationCount_a);
        String plaintext = aesUtil.decrypt(salt_a, iv_a, passphrase_a, ciphertext_a);
        
        System.out.println("aesUtil: "+aesUtil);
        System.out.println("plaintext: "+plaintext);
        
        return plaintext;
    }
	
}