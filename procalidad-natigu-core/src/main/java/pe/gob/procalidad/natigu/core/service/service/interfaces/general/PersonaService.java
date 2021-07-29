package pe.gob.procalidad.natigu.core.service.service.interfaces.general;
 

import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface PersonaService extends BaseService<PersonaBean> {
	  
	public PersonaBean buscarxTipoDocumentoNumeroDocumento(PersonaBean personaBean)throws ServiceException;
	
	public boolean actualizardatosuser(PersonaBean personaBean)throws ServiceException;
	
	public boolean actualizardatosfotouser(PersonaBean personaBean)throws ServiceException;
}
 
