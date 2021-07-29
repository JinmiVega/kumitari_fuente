package pe.gob.procalidad.natigu.web.gestion.controller.inicio;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "logoutController")
public class LogoutController {
		
	@RequestMapping("/cerrarSesion")
	public void logout (HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		
		String path = request.getContextPath();
		
		session.removeAttribute("usuarioSesion");
		session.invalidate();
		
		try {
			//response.sendRedirect(response.encodeRedirectURL(path + "/pages/seguridad/redirectLogin.jsp"));
			response.sendRedirect(path+"/");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}