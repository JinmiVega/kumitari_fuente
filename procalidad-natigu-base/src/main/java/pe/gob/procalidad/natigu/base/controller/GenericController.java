package pe.gob.procalidad.natigu.base.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value="usuario")
@Scope(value="session")
public class GenericController {

	
	
}
