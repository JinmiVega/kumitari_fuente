package pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.IntentoConfiguracionBean; 
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface IntentoConfiguracionService extends BaseService<IntentoConfiguracionBean> {
	
	public List<IntentoConfiguracionBean> listarTodos() throws ServiceException;

}
