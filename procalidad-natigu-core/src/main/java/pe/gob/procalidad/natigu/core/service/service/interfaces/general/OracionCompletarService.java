package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;
 
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionCompletarBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface OracionCompletarService extends BaseService<OracionCompletarBean>{

	OracionCompletarBean getBuscarPorTEM(
			OracionCompletarBean oracionCompletarBean) throws ServiceException;

 
}
