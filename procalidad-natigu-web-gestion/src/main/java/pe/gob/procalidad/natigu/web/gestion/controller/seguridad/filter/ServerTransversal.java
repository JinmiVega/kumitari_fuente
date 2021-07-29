package pe.gob.procalidad.natigu.web.gestion.controller.seguridad.filter;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        
        HttpSession session = req.getSession();
        //---------------------------------
      
    
        
        //-------------------------------
        
        try {

            res.addHeader("X-Frame-Options", "SAMEORIGIN");
            Date fecha_actual = new Date();
            // log.info("URL Req: " + strUrlPetici_t);
            // verificamos si es un archivo de descaraga de inscripcion y es un .pdf
            
            
            if(strUrlPetici_t.toLowerCase().contains("/inscripcion/") && strUrlPetici_t.toLowerCase().contains(".pdf")) {
            	
            	String uri_ins_dow = (String) session.getAttribute("uri_dowload_inscripcion");
            	
            	if(uri_ins_dow != null){
            		// comparamos tiempo de la peticion
                    Date date_in = (Date) session.getAttribute("date_uri_dow_ins");
                    Date date_now= fecha_actual;
                   
                    long milliseconds = date_now.getTime() - date_in.getTime();
                    int seconds = (int) (milliseconds / 1000) % 60;
                   
                    if(seconds <5) {
                    	
                    	 sendErrorRedirect(req, res, "/404.jsf", new Exception("DirectoryTransversalRequired"));
                    }else {
                    	
                    	session.setAttribute("date_uri_dow_ins", fecha_actual);
                    	
                    }
            	}
            	else
            	{
            		// es la primera vez emtonces registramos en la session
            		session.setAttribute("uri_dowload_inscripcion", strUrlPetici_t.toLowerCase());
                	session.setAttribute("date_uri_dow_ins", fecha_actual);
                	
                	
            	};
            	
            	            	
            }
            
         	//  validacio descarga docente
       	 if(strUrlPetici_t.toLowerCase().contains("/docente/") && 
       			 (strUrlPetici_t.toLowerCase().contains(".pdf") || 
       			 strUrlPetici_t.toLowerCase().contains(".doc") || 
       			 strUrlPetici_t.toLowerCase().contains(".docx")|| 
       			 strUrlPetici_t.toLowerCase().contains(".odt"))
       		) 
			{
                	String uri_docent_dow=(String) session.getAttribute("uri_dowload_docente");
                	
                	if(uri_docent_dow != null){
                		// comparamos tiempo de la peticion
                        Date date_in = (Date) session.getAttribute("date_uri_dow_docente");
                        Date date_now= fecha_actual;
                       
                        long milliseconds = date_now.getTime() - date_in.getTime();
                        int seconds = (int) (milliseconds / 1000) % 60;
                       
                        if(seconds <5) {
                        	
                        	 sendErrorRedirect(req, res, "/404.jsf", new Exception("DirectoryTransversalRequired"));
                        }else {
                        	
                        	session.setAttribute("date_uri_dow_docente", fecha_actual);
                        	
                        }
                	}
                	else
                	{
                		// es la primera vez emtonces registramos en la session
                		session.setAttribute("uri_dowload_docente", strUrlPetici_t.toLowerCase());
                    	session.setAttribute("date_uri_dow_docente", fecha_actual);
                    	
                    	
                	};
			};
       	
       	
            
            if(strUrlPetici_t.toLowerCase().contains("/.%252e")   ) {
            	//System.out.println("*****   DIRECTORIO NO PERMITIDO ******");
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