package pe.gob.procalidad.natigu.web.gestion.controller.general;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonalBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;


@Controller
@RequestMapping(value = "personaController")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	private PersonaBean personaBean;
	

	@RequestMapping(value = "/validapersona", method = RequestMethod.POST)
	public @ResponseBody PersonaBean validaPersona(@RequestParam("tipodocumento") Integer tipoDocumento, @RequestParam("numerodocumento") String numeroDocumento) {

		
		personaBean = new PersonaBean();
		personaBean.getTipoDocumento().setCodigoRegistro(tipoDocumento);
		personaBean.setNumeroDocumento(numeroDocumento);
	
		try {
			personaBean = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(personaBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		
		if(personaBean==null){
			personaBean=new  PersonaBean();
		}
		
		return personaBean;
	}


	public PersonaService getPersonaService() {
		return personaService;
	}


	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}


	public PersonaBean getPersonaBean() {
		return personaBean;
	}


	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

	
	
}
