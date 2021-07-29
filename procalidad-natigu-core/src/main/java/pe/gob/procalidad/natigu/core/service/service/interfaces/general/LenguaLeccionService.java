package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaLeccionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface LenguaLeccionService extends BaseService<LenguaLeccionBean>{
	
	public boolean actualizarimgxcod(LenguaLeccionBean lenguaLeccionBean) throws ServiceException;
}
