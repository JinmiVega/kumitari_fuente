package pe.gob.procalidad.natigu.web.gestion.controller.inicio;
import java.util.ArrayList;
import java.util.List;import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;

@Controller
@RequestMapping(value="")
public class MainController {

/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getdata() {
		System.out.println("controller");
		List<String> list = getList();

		//return back to index.jsp
		ModelAndView model = new ModelAndView("index");
		model.addObject("lists", list);
		System.out.println("list " + list.size());
		return model;

	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		LoginVo prmLogin = new LoginVo();
		return  new ModelAndView("seguridad/login/login-admin", "command",prmLogin);
	}
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ModelAndView getdataLista() {
		System.out.println("controller");
		List<String> list = getList();

		//return back to index.jsp
		ModelAndView model = new ModelAndView("index");
		model.addObject("lists", list);
		System.out.println("list x" + list.size());
		return model;

	}

	private List<String> getList() {

		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");

		return list;

	}
}
