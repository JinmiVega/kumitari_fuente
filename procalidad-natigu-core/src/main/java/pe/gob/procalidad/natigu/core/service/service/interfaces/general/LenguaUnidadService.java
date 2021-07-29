package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaUnidadBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface LenguaUnidadService extends BaseService<LenguaUnidadBean>{
	
	public boolean actualizarimgxcod(LenguaUnidadBean lenguaUnidadBean) throws ServiceException;
}
