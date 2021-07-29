package pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.ExamenConfiguracionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface ExamenConfiguracionService extends BaseService<ExamenConfiguracionBean>{
	public List<ExamenConfiguracionBean> listarTodos() throws ServiceException;

}
