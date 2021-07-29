package pe.gob.procalidad.natigu.core.service.service.interfaces.general;
 
import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaNacionalidadBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface PersonaLenguaService extends BaseService<PersonaLenguaBean> {
	public List<PersonaLenguaBean> getBuscarPorCodigoPersona(PersonaLenguaBean personaLenguaBean) throws ServiceException;
}
 
