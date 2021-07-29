package pe.gob.procalidad.natigu.web.gestion.controller.seguridad.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SameSiteFilter implements javax.servlet.Filter {
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    	addSameSiteCookieAttribute(response, httpServletRequest); // add SameSite=strict cookie attribute
        chain.doFilter(request, response);
        
    }

    private void addSameSiteCookieAttribute(ServletResponse response, HttpServletRequest httpRequest) {
    	String sessionId = "JSESSIONID";
    	Cookie[] cookies = httpRequest.getCookies();
    	HttpServletResponse httpResponse = (HttpServletResponse) response;
    	if(cookies != null) {
    		for(Cookie cookie : cookies) {
    			if(sessionId.equals(cookie.getName())) {
    				HttpServiceCookie.addCookie(httpResponse, cookie, "Strict");
    			}
    		}
    	}
    	
    }

    @Override
    public void destroy() {

    }
}