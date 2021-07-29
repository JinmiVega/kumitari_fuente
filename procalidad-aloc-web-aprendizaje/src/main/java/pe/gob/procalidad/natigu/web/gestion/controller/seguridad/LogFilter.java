package pe.gob.procalidad.natigu.web.gestion.controller.seguridad;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.NetUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;

public class LogFilter implements Filter{

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
			
			UsuarioBean usuario = (UsuarioBean) currentSession.getAttribute("usuarioEstudiante");
			
			String loginURL = path + "/inicio/autenticar";
			String accesoURL = path + "/inicio/acceso";
			String resourcesURL = path + "/resources";
			String assetsURL = path + "/assets";
			String modalURL = path + "/modal";
			String sliderURL = path + "/slider";
			String errorURL = path + "/error/NavegadorNoSoportado";
			
			boolean loginRequest = uri.startsWith(loginURL);
			boolean accesoRequest = uri.startsWith(accesoURL);
			boolean resourcesRequest = uri.startsWith(resourcesURL);
			boolean assetsRequest = uri.startsWith(assetsURL);
			boolean modalRequest = uri.startsWith(modalURL);
			boolean sliderRequest = uri.startsWith(sliderURL);
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
					|| loginRequest	
					|| accesoRequest
					|| resourcesRequest 
					|| assetsRequest
					|| modalRequest
					|| sliderRequest
					|| errorRequest
				) {
					
					String method = request.getMethod();
					
					if(resourcesRequest || assetsRequest || modalRequest || sliderRequest){
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

}