package pe.gob.procalidad.natigu.web.gestion.controller.seguridad;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServerTransversal implements Filter {

    private FilterConfig fcgConfFiltr_t;

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ServerTransversal.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        fcgConfFiltr_t = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String strUrlPetici_t = req.getRequestURL().toString();
        String strUrlBase___t = strUrlPetici_t.substring(0, strUrlPetici_t.indexOf(fcgConfFiltr_t.getServletContext().getContextPath()) + fcgConfFiltr_t.getServletContext().getContextPath().length());
       
        System.out.println();
        
        
        try {

            res.addHeader("X-Frame-Options", "SAMEORIGIN");
            System.out.println("------ FILTRO SERVER TRANSVERSAL -------");
            
            System.out.println("strUrlPetici_t: "+strUrlPetici_t);
            System.out.println("strUrlBase___t: "+strUrlBase___t);
                    
            if(strUrlPetici_t.toLowerCase().contains("/.%252e")   ) {
            	System.out.println("*****   DIRECTORIO NO PERMITIDO ******");
            	 sendErrorRedirect(req, res, "/404.jsf", new Exception("DirectoryTransversalRequired"));
            	
            }
            
                        
            if (strUrlPetici_t.toLowerCase().contains("%co") || strUrlPetici_t.toLowerCase().contains("%ae") || strUrlPetici_t.toLowerCase().contains("%252e")) {
                sendErrorRedirect(req, res, "/404.jsf", new Exception("DirectoryTransversalRequired"));
            } else {
                try {
                    fcgConfFiltr_t.getServletContext().getRequestDispatcher(strUrlPetici_t).forward(request, response);
                } catch (IllegalArgumentException e) {
                    chain.doFilter(request, response);
                }
            }
            
            //fcgConfFiltr_t.getServletContext().getRequestDispatcher(strUrlPetici_t).forward(request, response);

        } catch (Exception e) {
            log.error("", e);
            sendErrorRedirect(req, res, "/404.jsf", e);

        }
    }

    protected void sendErrorRedirect(HttpServletRequest request, HttpServletResponse response, String errorPageURL, Throwable e) throws ServletException, IOException {
        request.setAttribute("exception", e);
        fcgConfFiltr_t.getServletContext().getRequestDispatcher(errorPageURL).forward(request, response);
    }

    @Override
    public void destroy() {
        fcgConfFiltr_t = null;
    }

}
