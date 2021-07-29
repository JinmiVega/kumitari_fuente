package pe.gob.procalidad.natigu.web.gestion.controller.general;

import java.text.SimpleDateFormat;
import java.util.List;
import java.net.*;
import java.io.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonalBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UbigeoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;


@Controller
@RequestMapping(value = "personaController")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private UbigeoService ubigeoService;
	
	private PersonaBean personaBean;
	
	@Autowired
	private PeticionService peticionService;
	
	@RequestMapping(value = "/validapersona", method = RequestMethod.POST)
	public @ResponseBody PersonaBean validaPersona(@RequestParam("tipodocumento") Integer tipoDocumento, @RequestParam("numerodocumento") String numeroDocumento, HttpServletRequest request) {

		List<UbigeoBean> lstUbigeoBean;
		UbigeoBean ubigeoBean;
 		personaBean = new PersonaBean();
		
 		try {
 			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("PersonaController/validapersona");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	try {
	    			personaBean.getTipoDocumento().setCodigoRegistro(tipoDocumento);
	    			personaBean.setNumeroDocumento(numeroDocumento);
	    			personaBean = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(personaBean);
	    			
	    			if(personaBean!=null){
	    				ubigeoBean=new UbigeoBean();
	    				ubigeoBean.setCodigoUbigeo(personaBean.getCodigoUbigeo());
	    				lstUbigeoBean = (List<UbigeoBean>)ubigeoService.getBuscarPorFiltros(ubigeoBean);
	    				if(lstUbigeoBean!=null){
	    					ubigeoBean=lstUbigeoBean.get(0);
	    					personaBean.getUbigeoBean().setCodigoUbigeo(ubigeoBean.getCodigoUbigeo());
	    					personaBean.getUbigeoBean().setNombreUbigeo(ubigeoBean.getNombreUbigeo());
	    				}
	    			}
	    			
	    		} catch (ServiceException e) { 
	    			e.printStackTrace();
	    		}
	        }
		} catch (Exception e) {
			// TODO: handle exception
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
