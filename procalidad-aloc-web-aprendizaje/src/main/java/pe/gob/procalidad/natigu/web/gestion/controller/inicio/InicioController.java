package pe.gob.procalidad.natigu.web.gestion.controller.inicio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.io.*;

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

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBonoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMedallaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EspecialidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionDetalleBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.AdquisicionUsuarioBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.BonoBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.CombosCabBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.FondoBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.ModalBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LeccionMaterialBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaLeccionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaAccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.IntentoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.SesionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioPerfilBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.IntentoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.SessionService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.NetUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.AccesoMenuVo;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.PermisoVo;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.Encrypt;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.EncryptHability;


@Controller
@RequestMapping(value = "inicio")
@SessionAttributes("usuarioEstudiante")
@Scope(value="session")
public class InicioController extends BaseController{
	
	@Autowired
	private IntentoService intentoService;
	@Autowired
	private SessionService sessionService;

	@RequestMapping(value = "/acceso", method = RequestMethod.GET)
	public ModelAndView listarLogin(@ModelAttribute("usuarioEstudiante") UsuarioBean usuario,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		   response.setDateHeader ("Expires", 0);
		   response.setHeader("Pragma","no-cache");
		return this.getLista(usuario, request);
	}

	@RequestMapping(value = "/acceso", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login") LoginVo prmLogin,
		BindingResult result, SessionStatus status,
		HttpServletRequest request, HttpServletResponse response) throws Exception {

	   response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	   response.setDateHeader ("Expires", 0);
	   response.setHeader("Pragma","no-cache");
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("usuarioEstudiante");
		session.invalidate();
		
		request.getSession().setMaxInactiveInterval(1500);
		this.setUsuarioBean(new UsuarioBean());
		
		//Inicializando el Encrypt
		Encrypt.init("KEY_ENCRYPT_PASS");
		
		String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    EncryptHability aesUtil = new EncryptHability(128, 1000);
		
		if (prmLogin != null) {
			UsuarioBean prmUsuario = new UsuarioBean();
		    prmLogin.setNombreUsuario(aesUtil.decrypt(salt, iv, "usuario", prmLogin.getNombreUsuario()));
		    prmLogin.setContrasena(aesUtil.decrypt(salt, iv, "clave", prmLogin.getContrasena()));
			//Encriptando la clave ingresada
			prmUsuario.setPasswordUsuario(Encrypt.encrypt(prmLogin.getContrasena()));
			//prmUsuario.setPasswordUsuario(prmLogin.getContrasena());
			prmUsuario.setNombreUsuario(prmLogin.getNombreUsuario());
			
			UsuarioBean oUsuario = this.fs.getUsuarioService().autenticar(prmUsuario);
			
			if (oUsuario != null) {
				/** BUSCAR LOS PERFILES DEL USUARIO **/
				List<UsuarioPerfilBean> lstUsuarioPerfilBean = new ArrayList<UsuarioPerfilBean>();
				UsuarioPerfilBean filtroUsuarioPerfilBean = new UsuarioPerfilBean();
				filtroUsuarioPerfilBean.setUsuario(new UsuarioBean());
				filtroUsuarioPerfilBean.getUsuario().setCodigoUsuario(oUsuario.getCodigoUsuario());
				lstUsuarioPerfilBean = this.fs.getUsuarioPerfilService().getBuscarPorFiltros(filtroUsuarioPerfilBean);
				oUsuario.setLstUsuarioPerfil(lstUsuarioPerfilBean);
				
				this.registrarAudAcceso(prmLogin.getNombreUsuario(), 4, request);
				
				return this.getLista(oUsuario, request);
			} else {
				UsuarioBean tmpUsuario = new UsuarioBean();
				tmpUsuario.setNombreUsuario("NV");
				this.setUsuarioBean(tmpUsuario);
				this.registrarAudAcceso(prmLogin.getNombreUsuario(), 6, request);
				ModelAndView mav = new ModelAndView("../home", "command",prmLogin);
				//mav.addObject("msgErrorLogin", "El usuario y/o contrase�a no coinciden");
				mav.addObject("usuarioEstudiante", tmpUsuario);
				return mav;
			}
		}else{
			return  new ModelAndView("../home", "command",prmLogin);
		}
	}
	
		
	@RequestMapping(value = "/autenticar", method = RequestMethod.POST)
	public @ResponseBody String autenticar(HttpServletRequest request) throws Exception {
		
		this.setUsuarioBean(new UsuarioBean());
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String key = request.getParameter("key");
		String token_captcha = (String) request.getSession().getAttribute("token_captcha") ;
		System.out.println("--------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------");
		
		
		System.out.println(key);
		System.out.println(token_captcha);
		
		/** VERIFICAR INPUT USUARIO **/
		if(VO.isEmpty(username)){
			return "1";
		}
		
		/** VERIFICAR INPUT CLAVE **/
		if(VO.isEmpty(password)){
			return "2";
		}
		/** VERIFICAR INPUT token **/
		if(!token_captcha.equals(key)){
			
			return "Key no valido";
		}else {
			request.getSession().removeAttribute("token_captcha");
		}
		
		/** VERIFICAR USUARIO EXISTENTE **/
		String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    EncryptHability aesUtil = new EncryptHability(128, 1000);
	    username = aesUtil.decrypt(salt, iv, "usuario", username);
        password = aesUtil.decrypt(salt, iv, "clave", password);
	    
		//Inicializando el Encrypt
		Encrypt.init("KEY_ENCRYPT_PASS");
		
		boolean habilitadoIp = true;
		IntentoBean prmIntento = new IntentoBean();
		prmIntento.setIpConexion(request.getRemoteAddr());
		prmIntento.setPlataforma("aprendizaje");
		habilitadoIp = intentoService.existe(prmIntento);
        if(habilitadoIp) {
        	UsuarioBean prmUsuario = new UsuarioBean();
    		//Encriptando la clave ingresada
    		//prmUsuario.setPasswordUsuario(password);
    		prmUsuario.setPasswordUsuario(Encrypt.encrypt(password));
    		prmUsuario.setNombreUsuario(username);
    		
    		UsuarioBean oUsuario = this.fs.getUsuarioService().autenticar(prmUsuario);
    		
    		String pass = password;
    		/*
    		String messagePass = "La contrase�a debe: ";
    		if((pass.length() < 8)) {
    	    	messagePass+= "tener m�nimo 8 d�gitos, ";
    		} 
    	    if(!pass.matches(".*[a-z].*")){
    			messagePass+= "contener al menos una min�scula, ";
    		} 
    	    if(!pass.matches(".*[A-Z].*")){
    			messagePass+= "contener al menos una may�scula, ";
    		} 
    	    if(!pass.matches(".*[0-9].*")){
    			messagePass+= "contener al menos un n�mero, ";
    		}
    	    if(messagePass == "La contrase�a debe: ") {
    			messagePass = "";
    		} else {
    			messagePass = messagePass.substring(0,messagePass.length()-2);
    		}
    	    
    	    if(messagePass != null && messagePass != ""){
    			return messagePass;
    		}
    		*/
    		if (oUsuario != null) {
    			intentoService.eliminar(prmIntento);
    			/** VERIFICAR USUARIO ACTIVO **/
    			if (oUsuario.getSituacion().getCodigoRegistro()!= 1) {//Activo
    				this.registrarAudAcceso(username, 5, request);
    				return "3";
    			}
    			
    			/** VERIFICAR USUARIO CAMBIO CLAVE **/
    			/*if(oUsuario.getFlgRestPass()!=null && "1".equals(oUsuario.getFlgRestPass())){
    				return "4";
    			}*/ // comentado temporalmente
    			
    			/** BUSCAR LOS PERFILES DEL USUARIO **/
    			List<UsuarioPerfilBean> lstUsuarioPerfilBean = new ArrayList<UsuarioPerfilBean>();
    			UsuarioPerfilBean filtroUsuarioPerfilBean = new UsuarioPerfilBean();
    			filtroUsuarioPerfilBean.setUsuario(new UsuarioBean());
    			filtroUsuarioPerfilBean.getUsuario().setCodigoUsuario(oUsuario.getCodigoUsuario());
    			lstUsuarioPerfilBean = this.fs.getUsuarioPerfilService().getBuscarPorFiltros(filtroUsuarioPerfilBean);
    			
    			/** VERIFICAR USUARIO DE PERFIL ESTUDIANTE O DOCENTE **/
    			boolean swEsAlumno = false;
    			
    			if( !VO.isEmptyList(lstUsuarioPerfilBean) ){
    				for (int i = 0; i < lstUsuarioPerfilBean.size(); i++) {
    					UsuarioPerfilBean prmUP = lstUsuarioPerfilBean.get(i);
    					if(!VO.isNull(prmUP.getPerfil())){
    						/** 2: Docente | 4: Estudiante **/
    						if(prmUP.getPerfil().getCodigoPerfil() == 2 || prmUP.getPerfil().getCodigoPerfil() == 4|| prmUP.getPerfil().getCodigoPerfil() == 9){
    							swEsAlumno = true;
    							break;
    						}else{
    							swEsAlumno = false;
    						}
    					}
    				}
    				
    				if(swEsAlumno){
    					return "6"; // validado usuario y perfil estudiante o docente
    				}else{
    					this.registrarAudAcceso(username, 7, request);
    					return "7";
    				}
    				
    			}else{
    				return "5";
    			}
    					
    		} else {
				intentoService.insertar(prmIntento);
    			prmUsuario.setPasswordUsuario(null);
    			boolean  tried = this.fs.getUsuarioService().existe(prmUsuario);
    			System.out.println("tried: "+tried);
    			this.registrarAudAcceso(username, 6, request);
    			return "8";
    		}
        }else {
        	return "9";
        }
	}
	
	@RequestMapping(value = "/autenticarload", method = RequestMethod.POST)
	public @ResponseBody ModelAndView  autenticarsession(HttpServletRequest request) throws Exception {
		
		
		
		String cod = request.getParameter("cod");
		System.out.println("===================== "+cod);
		HttpSession session = request.getSession();
			session.removeAttribute("usuarioEstudiante");
					
			session.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("../home", "command",prmLogin);
	
		
		return mav;
	}

	@RequestMapping(value = "/autenticartoken_in", method = RequestMethod.POST)
	public @ResponseBody String  autenticartoken(HttpServletRequest request) throws Exception {
		
		
		
		String cod = request.getParameter("cod");
		System.out.println("===================== "+cod);
		HttpSession session = request.getSession();
		session.setAttribute("token_captcha", cod);
		
		
		return "1";
	}
	
	
	@RequestMapping(value = "/inicio", method = RequestMethod.POST)
	public ModelAndView incio(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean,
		BindingResult result, SessionStatus status,
		HttpServletRequest request) throws Exception {
		
		UsuarioBean usuario = this.getUsuarioSesion(request);
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("usuarioEstudiante");
		
		session.invalidate();
		
		session.setMaxInactiveInterval(30);
		
		//this.setUsuarioBean(new UsuarioBean());
		
		//Inicializando el Encrypt
		//Encrypt.init();
		
		
		if (usuarioBean != null) {
			UsuarioBean prmUsuario = new UsuarioBean();
			//Encriptando la clave ingresada
			//prmUsuario.setPasswordUsuario(Encrypt.encrypt(prmLogin.getPasswordUsuario()));
			prmUsuario.setCodigoUsuario(usuarioBean.getCodigoUsuario());
			prmUsuario.setPasswordUsuario(usuarioBean.getPasswordUsuario());
			prmUsuario.setNewPassword(usuarioBean.getNewPassword());
			prmUsuario.setAudCodigoUsuario(usuarioBean.getCodigoUsuario());
			prmUsuario.setFlgRestPass("0");
			Integer resultI = this.fs.getUsuarioService().cambiarPassword(prmUsuario);
			//UsuarioBean oUsuario = usuarioService.autenticar(prmUsuario);
			
			if (resultI != null && resultI>0) {
				
				
				
				usuario.setPasswordUsuario(usuarioBean.getPasswordUsuario());
				usuario.setFlgRestPass("0");
				/** BUSCAR LOS PERFILES DEL USUARIO **/
				List<UsuarioPerfilBean> lstUsuarioPerfilBean = new ArrayList<UsuarioPerfilBean>();
				UsuarioPerfilBean filtroUsuarioPerfilBean = new UsuarioPerfilBean();
				filtroUsuarioPerfilBean.setUsuario(new UsuarioBean());
				filtroUsuarioPerfilBean.getUsuario().setCodigoUsuario(usuarioBean.getCodigoUsuario());
				lstUsuarioPerfilBean = this.fs.getUsuarioPerfilService().getBuscarPorFiltros(filtroUsuarioPerfilBean);
				
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
				List<UsuarioBean> lstUsuarioBean = this.fs.getUsuarioService().getBuscarPorFiltros(filtro);
				if(lstUsuarioBean.size()>0){
					usuario = lstUsuarioBean.get(0);
				}
				request.getSession().setMaxInactiveInterval(1500);
				request.getSession().setAttribute("usuarioEstudiante", usuario);
				
				ModelAndView mav = new ModelAndView("seguridad/login/cambiar-contrasenia", "command",usuarioBean);
				mav.addObject("msgErrorLogin", "La contrase&nacute;a no coincide con la actual");
				mav.addObject("usuarioBean", usuarioBean);
				return mav;
			}
		}else{
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav_ = new ModelAndView("../home", "command",prmLogin);
			
			return  mav_;
		}
	}
	
	private ModelAndView getLista(UsuarioBean usuario, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("lengua/inicio");
		
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
				
				LoginVo prmLogin = new LoginVo();
				ModelAndView mav_ = new ModelAndView("../home", "command",prmLogin);
				
				return  mav_;

				
			}else {
				//---------------------------------------------------------------------------
				List<LenguaBean> listaLenguaBean = null;
				List<EspecialidadBean> lstEspecialidad = null;;
				boolean esEstudiante = false;
				
				if( !VO.isEmptyList(usuario.getLstUsuarioPerfil()) ){
					for (UsuarioPerfilBean usuperfbean : usuario.getLstUsuarioPerfil()) {
						if(!VO.isNull(usuperfbean.getPerfil())){
							System.out.println("usuperfbean.getPerfil().getCodigoPerfil() " + usuperfbean.getPerfil().getCodigoPerfil());
							if(usuperfbean.getPerfil().getCodigoPerfil() == 4){ // ESTUDIANTE
								/** CARGAR LAS LENGUAS A LAS QUE ESTA MATRICULADO **/
								esEstudiante = true;
								usuario.setCodPerfilUsuSelec(new Long(4)); // ESTUDIANTE
								UsuarioBean usuarioBean = new UsuarioBean();
								usuarioBean.setCodigo(usuario.getCodigoUsuario());
								listaLenguaBean = this.fs.getLenguaService().listarValidaLenguasxMatricula(usuarioBean);
								break;
							}else
							if(usuperfbean.getPerfil().getCodigoPerfil() == 2){ // DOCENTE
								esEstudiante = false;
								usuario.setCodPerfilUsuSelec(new Long(2)); // DOCENTE
								listaLenguaBean = this.fs.getLenguaService().getBuscarPorFiltros(new LenguaBean());
								DocenteBean prmDocenteBean = null;
								PersonaBean personaBean = new PersonaBean();
								personaBean.setCodigo(usuario.getPersona().getCodigo()); 
								try { 
									prmDocenteBean = fs.getDocenteService().getBuscar_por_codigopersona(personaBean);
									if(!VO.isNull(prmDocenteBean)){ 
										lstEspecialidad = (List<EspecialidadBean>) fs.getEspecialidadService().listarPorCodigoDocente(prmDocenteBean);
										if(!VO.isNull(listaLenguaBean)){
											for (LenguaBean oLenguaBean : listaLenguaBean) {
												oLenguaBean.getSituacion().setCodigoRegistro(0);
												System.out.println("oLenguaBean.getCodigo() " + oLenguaBean.getCodigo());
												for (EspecialidadBean oeEspecialidadBean : lstEspecialidad) {
													System.out.println("oeEspecialidadBean.getCodigo() " + oeEspecialidadBean.getLenguaBean().getCodigo());
													if (oeEspecialidadBean.getLenguaBean().getCodigo() == oLenguaBean.getCodigo()) {
														oLenguaBean.getSituacion().setCodigoRegistro(1);
													}
													
												  }
												oLenguaBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(oLenguaBean.getCodigo())).replace("/", "$"));
											   }
											} 
									}
									
								} catch (ServiceException e) { 
									
									e.printStackTrace();
								}
								
								break;
							}
							else if(usuperfbean.getPerfil().getCodigoPerfil() == 9){ // ESPECIALISTA
								esEstudiante = false;
								usuario.setCodPerfilUsuSelec(new Long(9)); // ADMIN
								listaLenguaBean = this.fs.getLenguaService().getBuscarPorFiltros(new LenguaBean());
							}
						}
					}
				} 

				/******* INI : ENCRIPTAR CODIGO **********/
				Encrypt.init("KEY_ENCRYPT_REL");
				for (LenguaBean itemLengua : listaLenguaBean) {
					//itemLengua.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(itemLengua.getCodigo())));
					itemLengua.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(itemLengua.getCodigo())).replace("/", "$"));
				}
				/******* FIN : ENCRIPTAR CODIGO **********/
				/***PagePerfil****/
				request.getSession().setAttribute("unidadLeccionBean", null);
				request.getSession().setAttribute("lenguaBean", null);
				request.getSession().setAttribute("lenguaEstructuraBean", null);
				request.getSession().setAttribute("unidadBean", null);
				/***PagePerfil****/
				
				this.setUsuarioBean(usuario);
				request.getSession().setMaxInactiveInterval(1500);
				request.getSession().setAttribute("usuarioEstudiante", usuario);
				request.getSession().setAttribute("swActivoMascotaAnim", 0);
				
				boolean flag=sessionService.sessionGestor(_sesionBean, "CREAR_SESSION");
				if(flag) {
					System.out.println("========= CERRAR CESSIO : 1");
				}else {
					System.out.println("========= NO CERRAR CESSIO : 0");
					
				}
				
				System.out.println("========= VALIDAR LENGUAS ==============");
				System.out.println(listaLenguaBean);
				System.out.println("========= VALIDAR LENGUAS ==============");

				
				mav.addObject("usuarioEstudiante", usuario); 
				mav.addObject("listaLenguaBean", listaLenguaBean);
				mav.addObject("esEstudiante", esEstudiante);
				//-----------------------------------------------------------------------------------------------------------------
				
				
				
			}
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/listarTienda", method = RequestMethod.GET)
	public @ResponseBody List<?> refrescarListaTienda(@RequestParam("usuarioMatricula") Long usuarioMatricula,@RequestParam("valor") String valor,@RequestParam("tipo") String tipo,@RequestParam("lengua") Long lengua, HttpServletRequest request){		

		UsuarioBean usuario = this.getUsuarioSesion(request);
		
		List<MascotaBean> listaMascota = null;
		List<FondoBean> listaFondo = null;
		List<CombosCabBean> lstCombo = null;
		
		try {
			
			if(tipo.equals("1") && valor.equals("1")){
				/** TAB MASCOTAS **/
				MascotaBean filtroMascota = new MascotaBean();
				filtroMascota.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
				filtroMascota.setAudCodigoUsuario(usuario.getCodigoUsuario());
				filtroMascota.getUsuarioMatriculaBean().setCodigo(Long.valueOf(usuarioMatricula)); 
				listaMascota = this.fs.getMascotaService().getBuscarPorTiendaAlumno(filtroMascota);
				return listaMascota;
			}else if(!tipo.equals("1") && valor.equals("1")){
				/** TAB MASCOTAS **/
				MascotaBean filtroMascota = new MascotaBean();
				filtroMascota.setAudCodigoUsuario(usuario.getCodigoUsuario());
				listaMascota = this.fs.getMascotaService().getBuscarPorFiltrosAlumno(filtroMascota);
				return listaMascota;
			}else if(valor.equals("2")){
				/** TAB FONDOS **/
				FondoBean filtroFondo = new FondoBean();
				filtroFondo.setAudCodigoUsuario(usuario.getCodigoUsuario());
				filtroFondo.getSituacion().setCodigoRegistro(1);
				listaFondo = this.fs.getFondoService().getBuscarPorFiltrosAlumno(filtroFondo);
				return listaFondo;
			}else if(valor.equals("3")){
				/** TAB COMBOS **/
				CombosCabBean filtroCombo = new CombosCabBean();
				filtroCombo.getSituacion().setCodigoRegistro(1);
				filtroCombo.setCodigoUsuarioCreacion(usuario.getCodigoUsuario());
				lstCombo = this.fs.getComboService().getBuscarTodos(filtroCombo);
				return lstCombo;
			}else if(valor.equals("4")){
				/** TAB BONOS **/
				List<AlumnoBonoBean> lista = null;
				AlumnoBonoBean amBean = new AlumnoBonoBean();
				amBean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
				
				amBean.getUsuarioMatriculaBean().getMatriculaBean().setLengua(new LenguaBean());
				amBean.getUsuarioMatriculaBean().setCodigo(usuario.getCodigoUsuario());
				amBean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().setCodigo(lengua);
				lista = this.fs.getAlumnoBonoService().getBuscarPorAlumno(amBean);
				return lista;
			}else if(valor.equals("5")){
				/** TAB MEDALLAS **/
				List<AlumnoMedallaBean> lista = null;
				AlumnoMedallaBean amBean = new AlumnoMedallaBean();
				amBean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
				amBean.getUsuarioMatriculaBean().getMatriculaBean().setLengua(new LenguaBean());
				amBean.getUsuarioMatriculaBean().setCodigo(usuario.getCodigoUsuario());
				amBean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().setCodigo(lengua);
				lista = this.fs.getAlumnoMedallaService().getBuscarPorAlumno(amBean);
				return lista;
			}else{
				return null;
			}

		} catch (Exception e) { 
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView listar(@ModelAttribute("usuarioEstudiante") UsuarioBean usuario,
			HttpServletRequest request) throws Exception {
		return this.getLista(usuario, request);
	}
	

	@RequestMapping(value = "/obtenerAccesos", method = RequestMethod.GET)
	public ModelAndView obtenerAccesos(@RequestParam("codperfil") String codperfil,
			HttpServletRequest request) throws Exception {
		
		UsuarioBean usuario = this.getUsuarioSesion(request);
		
		usuario.setCodPerfilUsuSelec(VO.toLong(codperfil));
		
		return this.getLista(usuario, request);
	}
	
	@RequestMapping(value = "/mostrarModal", method = RequestMethod.GET)
	public ModelAndView mostrarModal() throws Exception {

		ModalBean prmModalBean = new ModalBean();
		
		try {
			/** BUSCAR MODAL PRINCIPAL **/
			ModalBean prmFiltro = new ModalBean();
			prmFiltro.getSituacion().setCodigoRegistro(1); //Activo
			
			List<ModalBean> lista  = this.fs.getModalService().getBuscarPorFiltros(prmFiltro);
			
			if(!VO.isEmptyList(lista)){
				prmModalBean = lista.get(0);
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		ModelAndView mav = new ModelAndView("../layouts/index-modal-view", "command",prmModalBean);
		mav.addObject("modalBean",prmModalBean);
		return mav;
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
					
					/** PERSONAL **/
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
					
					/** ALUMNO **/
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
					}
					
				}
				
			}
		}
	
		return accesoMenuVo;
	}
	
	
	@RequestMapping(value = "/actualizarAdquisicionSwPredeterMasc", method = RequestMethod.POST)
	@ResponseBody
	public String doActualizarAdquisicionSwPredeterMasc(@RequestParam("codMasc") Integer codMasc, HttpServletRequest request) {
		
		UsuarioBean usuario = this.getUsuarioSesion(request);
		System.out.println("usuario.getCodigoUsuario() " + usuario.getCodigoUsuario());
		Boolean sw = false;
//		System.out.println("codUsu " + codUsu);		
		System.out.println("codMasc " + codMasc);
		String cantidad="";

		AdquisicionUsuarioBean prmAdquisicionUsuarioBean = new AdquisicionUsuarioBean();
		prmAdquisicionUsuarioBean.setMascota(new MascotaBean());
		prmAdquisicionUsuarioBean.setUsuario(new UsuarioBean());
		prmAdquisicionUsuarioBean.getMascota().setCodigo(codMasc);
		prmAdquisicionUsuarioBean.getUsuario().setCodigoUsuario(usuario.getCodigoUsuario());
		prmAdquisicionUsuarioBean.setAudHostIP(request.getRemoteAddr());
		prmAdquisicionUsuarioBean.setAudCodigoUsuario(usuario.getCodigoUsuario());
		
		try {
			sw = this.fs.getAdquisicionUsuarioService().actualizarSwPredeterminadoMasc(prmAdquisicionUsuarioBean);
		} catch (ServiceException e) { 
		
			e.printStackTrace();
			return "0";
		}
		
		if (sw) {
			System.out.println("todo Ok");
			return cantidad="1";
		}else {
			return cantidad="2";
		}
	
		
	}
	
	@RequestMapping(value = "/actualizarAdquisicionSwPredeterFond", method = RequestMethod.POST)
	@ResponseBody
	public String doActualizarAdquisicionSwPredeterFond(@RequestParam("codFond") Integer codFond, HttpServletRequest request) {
		
		UsuarioBean usuario = this.getUsuarioSesion(request);
		System.out.println("usuario.getCodigoUsuario() " + usuario.getCodigoUsuario());
		Boolean sw = false;
//		System.out.println("codUsu " + codUsu);		
		System.out.println("codFond " + codFond);
		String cantidad="";

		AdquisicionUsuarioBean prmAdquisicionUsuarioBean = new AdquisicionUsuarioBean();
		prmAdquisicionUsuarioBean.setFondo(new FondoBean());
		prmAdquisicionUsuarioBean.setUsuario(new UsuarioBean());
		prmAdquisicionUsuarioBean.getFondo().setCodigo(codFond);
		prmAdquisicionUsuarioBean.getUsuario().setCodigoUsuario(usuario.getCodigoUsuario());
		prmAdquisicionUsuarioBean.setAudHostIP(request.getRemoteAddr());
		prmAdquisicionUsuarioBean.setAudCodigoUsuario(usuario.getCodigoUsuario());
		
		try {
			sw = this.fs.getAdquisicionUsuarioService().actualizarSwPredeterminadoFond(prmAdquisicionUsuarioBean);
		} catch (ServiceException e) { 
		
			e.printStackTrace();
			return "0";
		}
		
		if (sw) {
			System.out.println("todo Ok");
			return cantidad="1";
		}else {
			return cantidad="2";
		}
	
		
	}
	
	@RequestMapping(value = "/listarFondoBeanSwPredet", method = RequestMethod.GET)
	@ResponseBody 
	public FondoBean doListarFondoBeanSwPredet(HttpServletRequest request)
	{
		UsuarioBean usuario = this.getUsuarioSesion(request);
		FondoBean beanFondoBean= null;
		/** OBTENER MASCOTA **/
		FondoBean	prFondoBean = new FondoBean();
		prFondoBean.setAudCodigoUsuario(usuario.getCodigoUsuario());
		
		
		try {
			beanFondoBean = this.fs.getFondoService().getlistarFondoSwPredetAlumno(prFondoBean);
			if (!VO.isNotNull(beanFondoBean)) {
				beanFondoBean=null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beanFondoBean;
	}
	
	private void registrarAudAcceso(String nomUsuario, Integer tipoAccion, HttpServletRequest request){
		try {
			AuditoriaAccesoBean bean = new AuditoriaAccesoBean();
			bean.getTipoAccion().setCodigoRegistro(tipoAccion);
			bean.setNomUsuario(nomUsuario);
			bean.setIpCreacion(NetUtil.getClientIpAddr(request));
			bean.getTipoSistema().setCodigoRegistro(2);
			
			this.fs.getAuditoriaService().insertarAuditoriaAcceso(bean);
			/*
			if(!VO.isNull(bean.getIpCreacion()) && !bean.getIpCreacion().equals("0:0:0:0:0:0:0:1")){
				this.fs.getAuditoriaService().insertarAuditoriaAcceso(bean);
				
			}*/
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	@RequestMapping(value = "/obtenerBono", method = RequestMethod.GET)
	@ResponseBody 
	public BonoBean doObtenerBono(@RequestParam("codBono") Long  codBono)
	{   
		BonoBean oBonoBean = new BonoBean();
		BonoBean bonoBean =  new BonoBean();
		bonoBean.setCodigo(codBono);
		
		
		try{
			
			oBonoBean = this.fs.getBonoService().getBuscarPorObjecto(bonoBean);
			
			if (oBonoBean != null) {				
				System.out.println("oBono es diferente de  null");
			}else{
				System.out.println("oBono es null");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return oBonoBean;
	}
	@RequestMapping(value = "/alumnobonoEliminar", method = RequestMethod.GET)
	@ResponseBody
	public String doAlumnobonoEliminar(@RequestParam("p_codaluxbono") Long p_codaluxbono, 
			HttpServletRequest request){
		boolean sw = false;
		String data = "0";
		
		AlumnoBonoBean alumnoBonoBean =  new AlumnoBonoBean();
		alumnoBonoBean.setCodigo(p_codaluxbono);
		
		try {
			this.setAuditoria(alumnoBonoBean, request, false);
			sw = this.fs.getAlumnoBonoService().eliminar(alumnoBonoBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			sw =  false;
		}
		if (sw) {
			data = "1";
		}else{
			data ="0"; 
		}
		return data;
	}

	@RequestMapping(value = "/insertarEjercicioAdicional", method = RequestMethod.GET)
	@ResponseBody
	public Long doInsertarEjercicioAdicional(@RequestParam("p_codBono") Long p_codBono,
											   @RequestParam("p_codlengua") Long p_codlengua, 
											   @RequestParam("p_tm2SubNivel") int p_tm2SubNivel,
											   @RequestParam("p_codEva") Long p_codEva,
											   HttpServletRequest request){
	
		long data = 0;
		
		/** Obtener  Datos  bono **/
		BonoBean bonoBean =  new BonoBean();
		bonoBean.setCodigo(p_codBono);
		
		BonoBean oBonoBean =  new BonoBean();
		
		/** Datos para EavaluacionDetalle**/
		EvaluacionDetalleBean evaluacionDetalleBean =  new EvaluacionDetalleBean();
		evaluacionDetalleBean.setLeccionMaterialBean(new LeccionMaterialBean());
		evaluacionDetalleBean.getLeccionMaterialBean().setUnidadLeccionBean(new UnidadLeccionBean());
		evaluacionDetalleBean.getLeccionMaterialBean().getUnidadLeccionBean().setLenguaLeccionBean(new LenguaLeccionBean());
		evaluacionDetalleBean.getLeccionMaterialBean().getUnidadLeccionBean().getLenguaLeccionBean().setLenguaBean(new LenguaBean());
		
		evaluacionDetalleBean.getLeccionMaterialBean().getUnidadLeccionBean().getLenguaLeccionBean().getLenguaBean().setCodigo(p_codlengua);
		evaluacionDetalleBean.setEvaluacionBean(new EvaluacionBean());
		evaluacionDetalleBean.getEvaluacionBean().setSubNivel(new MaestraBean());
		evaluacionDetalleBean.getEvaluacionBean().getSubNivel().setCodigoRegistro(p_tm2SubNivel);
		
		evaluacionDetalleBean.getEvaluacionBean().setCodigo(p_codEva);
		
		
		
		try {
			/** Obtener  Datos  bono **/
		oBonoBean = this.fs.getBonoService().getBuscarPorObjecto(bonoBean);
		if (oBonoBean != null) {
			
			evaluacionDetalleBean.getTipoEjercicio().setCodigoRegistro(oBonoBean.getTipoEjercicio().getCodigoRegistro());
			
		}else{
			System.out.println("Bono es  nulll");
		}
			this.setAuditoria(evaluacionDetalleBean, request, true);
			this.fs.getEvaluacionDetalleService().insertar(evaluacionDetalleBean);
			data = evaluacionDetalleBean.getCodigo();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return data;
	}
	
	@RequestMapping(value = "/buscarEjercicio", method = RequestMethod.GET)
	@ResponseBody
	public EvaluacionDetalleBean doBuscarEjercicio(@RequestParam("p_codEvaDet") Long p_codEvaDet, 
			HttpServletRequest request){
		
		
		
		EvaluacionDetalleBean evaluacionDetalleBean = new EvaluacionDetalleBean();
		evaluacionDetalleBean.setCodigo(p_codEvaDet);
		
		EvaluacionDetalleBean oEvaluacionDetalleBean = new EvaluacionDetalleBean();
		try {
			oEvaluacionDetalleBean = this.fs.getEvaluacionDetalleService().getBuscarPorObjecto(evaluacionDetalleBean);
			
			if (oEvaluacionDetalleBean != null) {
				System.out.println("oEvaluacionDetalleBean.getCodigo()"+oEvaluacionDetalleBean.getCodigo());
			}else{
				System.out.println("Obj null");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return oEvaluacionDetalleBean;
	}
}