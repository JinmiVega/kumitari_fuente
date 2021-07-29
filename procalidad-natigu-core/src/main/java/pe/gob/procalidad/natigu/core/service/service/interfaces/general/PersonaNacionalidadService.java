package pe.gob.procalidad.natigu.core.service.service.interfaces.general;
 
import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaNacionalidadBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface PersonaNacionalidadService extends BaseService<PersonaNacionalidadBean> {
	public List<PersonaNacionalidadBean> getBuscarPorCodigoPersona(PersonaNacionalidadBean personaNacionalidadBean) throws ServiceException;
}
 
