package pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioConfiguracionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface PremioConfiguracionService extends BaseService<PremioConfiguracionBean> {
	
	public List<PremioConfiguracionBean> listarTodos() throws ServiceException;

}
