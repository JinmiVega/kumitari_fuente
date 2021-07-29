package pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion;
  
 
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface PremioService extends BaseService<PremioBean> {

	PremioBean getBuscarPoraluMedalla(PremioBean premioBean)
			throws ServiceException;
	  
}
 
