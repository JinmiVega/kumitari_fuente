package pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AccesoBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface AccesoService extends BaseService<AccesoBean>{

	public boolean asignar(AccesoBean bean) throws ServiceException;
	
}
