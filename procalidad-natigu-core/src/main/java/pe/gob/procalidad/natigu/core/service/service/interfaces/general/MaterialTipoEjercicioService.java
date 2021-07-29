package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface MaterialTipoEjercicioService extends BaseService<MaterialTipoEjercicioBean>{
	public boolean actualizarOrden(MaterialTipoEjercicioBean t) throws ServiceException;
}
