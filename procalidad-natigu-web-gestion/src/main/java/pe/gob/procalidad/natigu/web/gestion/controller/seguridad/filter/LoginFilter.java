package pe.gob.procalidad.natigu.web.gestion.controller.seguridad.filter;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PerfilBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.AccesoService;
import pe.gob.procalidad.natigu.web.gestion.controller.inicio.InicioController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.NetUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.PermisoVo;

public class LoginFilter implements Filter{
	
	@Autowired
	AccesoService accesoService;

	@Autowired
	InicioController inicioController;
	
	private int ajaxSessionExpiredErrorCode;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		//Log the IP address and current timestamp.
		System.out.println("IP "+ NetUtil.getClientIpAddr(request) + ", Time " + new Date().toString());
		
		HttpSession currentSession = request.getSession(false);
		String uri = ((HttpServletRequest) request).getRequestURI();
		String path = ((HttpServletRequest) request).getContextPath();
		String ajaxHeader = ((HttpServletRequest) request).getHeader("X-Requested-With");
		
		//System.out.println("path: "+path);
		System.out.println("uri: "+uri);
		
		Integer respuesta = null;
		try {
			respuesta = comprobarAccesos(uri,request);
			
			/*if(respuesta.equals(1)) {
				System.out.println("Permitido");
			} else if(respuesta.equals(2)){
				System.out.println("No consulta");	
			} else*/ 
			if(respuesta.equals(0)){
				//System.out.println("No Permitido");
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.sendRedirect(path+"/");
			}
		
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if (currentSession == null) {
			
			if (	uri.equalsIgnoreCase(path + "/") 	) {
				
				chain.doFilter(request, response);
			
			}else if ("XMLHttpRequest".equals(ajaxHeader)) {
				
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.sendError(this.ajaxSessionExpiredErrorCode);
	
			} else {
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.sendRedirect(path+"/");
			}
			
		} else {
			
			UsuarioBean usuario = (UsuarioBean) currentSession.getAttribute("usuarioSesion");
			
			String accesoURL = path + "/inicioController/controlAcceso";
			String resourcesURL = path + "/resources";
			String app_assetsURL = path + "/app-assets";
			String assetsURL = path + "/assets";
			
			String errorURL = path + "/errorController/NavegadorNoSoportado";
			
			boolean accesoRequest = uri.startsWith(accesoURL);
			boolean resourcesRequest = uri.startsWith(resourcesURL);
			boolean app_assetsRequest = uri.startsWith(app_assetsURL);
			boolean assetsRequest = uri.startsWith(assetsURL);
			boolean errorRequest = uri.startsWith(errorURL);
			
			if(usuario != null){
				if(!VO.isEmpty(usuario.getNombreUsuario())){
					if(usuario.getNombreUsuario().equals("NV")){
						usuario = null;
					}
				}
			}
			
			if (usuario == null) {
				
				if ( uri.equalsIgnoreCase(path + "/") 
					|| accesoRequest
					|| resourcesRequest 
					|| app_assetsRequest 
					|| assetsRequest
					|| errorRequest
				) {
					
					String method = request.getMethod();
					
					if(resourcesRequest || app_assetsRequest || assetsRequest){
						chain.doFilter(request, response);
					}else if(method.equals("GET") && accesoRequest){
						response.sendRedirect(path+"/");
					}else{
						chain.doFilter(request, response);
					}
					
				}else {
					response.sendRedirect(path+"/");
				}
				
			} else {
				
				chain.doFilter(request, response);	
			
			}
		}
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		String ajaxParam = filterConfig.getInitParameter("ajaxSessionExpiredErrorCode");
		
		System.out.println("Ajax Session Expired Param: " + ajaxParam);
		
		ajaxSessionExpiredErrorCode = !VO.isEmpty(ajaxParam) ? VO.toInteger(ajaxParam) : 901;
		
	}

	@Override
	public void destroy() {
		//add code to release any resource
	}

	public Integer comprobarAccesos(String uri,HttpServletRequest request) throws ServiceException {
		Integer respuesta = 0;
		//uri
		String[] textos = uri.toString().split("/");
		//leer token
		HttpSession sessionToken = request.getSession();
		if(sessionToken.getAttribute("token")!=null && textos.length>2 && textos[2]!=null && !textos[2].equals("resources") && !textos[2].equals("logoutController") &&
			!textos[2].equals("baseController") && !textos[2].equals("personaController") && !textos[2].equals("ubigeoController") && !textos[2].equals("mainController") &&
			!textos[2].equals("inicioController") && !textos[2].equals("app-assets") && !textos[2].equals("assets") && !textos[2].equals("errorController") &&
			!textos[2].equals("material") && !textos[2].equals("lengua") && !textos[2].equals("premio") && !textos[2].equals("mascota") && !textos[2].equals("glosario") && 
			!textos[2].equals("fondo") && !textos[2].equals("modal") && !textos[2].equals("slider") && !textos[2].equals("maestra") && !textos[2].equals("subNivel") && 
			!textos[2].equals("unidad") && !textos[2].equals("leccion") && !textos[2].equals("inscripcion") && !textos[2].equals("docente") && 
			!(textos[2].equals("usuarioController") && textos[3]!=null && textos[3].equals("cambiarPassUsuario")) && !(textos[2].equals("usuarioController") && textos[3]!=null && textos[3].equals("cambiarPass"))) {
		
			//iterar accesos
			List<AccesoBean> lstAccesoBean =  (List<AccesoBean>) request.getSession().getAttribute("lstAccesoBean");
			if(!VO.isEmptyList(lstAccesoBean)){
				for (int i = 0; i < lstAccesoBean.size(); i++) {
					AccesoBean bean = lstAccesoBean.get(i);
					
					if(		!VO.isNull(bean.getComponente()) 
						&& 	!VO.isNull(bean.getComponente().getNombreComponente())
					  ){
						
						String nombreComponente = bean.getComponente().getNombreComponente();
						
						 /**INDICADOR **/
						if (nombreComponente.equals("indicador") && textos[2].equals("indicadorController")) {
							if(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1")) {
								respuesta = 1;								
							}
							break;
						}
						
						/** INSTITUCION **/
						if (nombreComponente.equals("institucion") && textos[2].equals("institucionController")) {
							if(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1")) {
								respuesta = 1;								
							}
							break;
						}
						
						/** LENGUA **/
						if (nombreComponente.equals("lengua") && textos[2].equals("lenguaController")) {
							
							if(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1")) {
								respuesta = 1;								
							}
							break;
						}
						
						/** MATERIAL **/
						if (nombreComponente.equals("material") && textos[2].equals("materialController")) {
							
							if(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1")) {
								respuesta = 1;								
							}
							break;
							
						} else if (nombreComponente.equals("material_carga_directa") && textos[2].equals("cargaMaterialController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
							
						}else if (nombreComponente.equals("material_carga_masiva") && textos[2].equals("cargaMasivaController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}
						
						/** GESTOR **/
						if (nombreComponente.equals("personal") && textos[2].equals("personalController")) {
							
							if(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1")) {
								respuesta = 1;								
							}
							break;	
						}
						
						/** INSCRIPCION **/
						if (nombreComponente.equals("inscripcion") && textos[2].equals("inscripcionController")) {
							
							if(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1")) {
								respuesta = 1;								
							}
							break;	
						}
						
						/** MATRICULA **/
						if (nombreComponente.equals("matricula") && textos[2].equals("matriculaController")) {
							
							if(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1")) {
								respuesta = 1;								
							}
							break;	
						} else if (nombreComponente.equals("matricula_registro") && textos[2].equals("matriculaRegistroController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("matricula_asignar_usuario") && textos[2].equals("asignarUsuarioController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}
						
						/** DOCENTE **/
						if (nombreComponente.equals("docente") && textos[2].equals("docenteController")) {
							
							if(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1")) {
								respuesta = 1;								
							}
							break;	
						}
						
						/** ESTUDIANTE **/
						if (nombreComponente.equals("alumno") && textos[2].equals("alumnoController")) {
							
							if(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1")) {
								respuesta = 1;								
							}
							break;	
							
						} else if (nombreComponente.equals("alumno_registro") && textos[2].equals("alumnoController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("alumno_seguimiento") && textos[2].equals("seguimientoController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}
						
						/** MODO OFFLINE **/
						if (nombreComponente.equals("offline") && textos[2].equals("offlineController")) {
							
							if(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1")) {
								respuesta = 1;								
							}
							break;	
						}else if (nombreComponente.equals("offline_generar_archivo") && textos[2].equals("offlineKumitsari")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("offline_sincronizar") && textos[2].equals("offlineKumitsari")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}
						
						/** SEGURIDAD **/
						if (nombreComponente.equals("seguridad") && textos[2].equals("seguridadController")) {
							
							if(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1")) {
								respuesta = 1;								
							}
							break;
							
						}else if (nombreComponente.equals("seguridad_usuario") && textos[2].equals("usuarioController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("seguridad_perfil") && textos[2].equals("perfilController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("seguridad_acceso") && textos[2].equals("accesoController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("seguridad_auditoria") && textos[2].equals("auditoriaController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}
						
						/** CONFIGURACION **/
						if (nombreComponente.equals("configuracion") && textos[2].equals("configuracionController")) {
							
							if(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1")) {
								respuesta = 1;								
							}
							break;	
						} else if (nombreComponente.equals("configuracion_tabla_maestra") && textos[2].equals("tmaestraController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("configuracion_mascota") && textos[2].equals("mascotaController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("configuracion_traduccion_general") && textos[2].equals("traduccionController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("configuracion_fondo") && textos[2].equals("fondoController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("configuracion_modal") && textos[2].equals("modalController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("configuracion_combo") && textos[2].equals("comboController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
							
						}else if (textos[2].equals("bonoController")) {
							respuesta = 1;		
							break;
						}
						else if (nombreComponente.equals("configuracion_premio") && textos[2].equals("premioController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("configuracion_ficha_puntaje") && textos[2].equals("fichaPuntajeController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("configuracion_slider") && textos[2].equals("sliderController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("configuracion_mensaje") && textos[2].equals("mensajesController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("configuracion_glosario") && textos[2].equals("glosarioController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}else if (nombreComponente.equals("configuracion_traduccion") && textos[2].equals("traduccionController")) {
							if(bean.isFlgRead() || bean.isFlgWrite() || bean.isFlgDelete() || bean.isFlgExport()) {
								respuesta = 1;								
							}
							break;
						}
					}
				}
			}
		} else {
			respuesta = 2;
		}
		
		System.out.println("respeusta: "+respuesta);
		
		return respuesta;
	}
}