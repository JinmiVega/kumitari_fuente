package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;
 




import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraDetBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraciBean; 
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface ArrastraOraDetService extends BaseService<ArrastraOraDetBean>{

	List<ArrastraOraDetBean> buscarPorCodigoOracion(
			ArrastraOraDetBean  Bean) throws ServiceException;

	List<ArrastraOraDetBean> getBuscarTodoxMTE(ArrastraOraDetBean Bean)
			throws ServiceException;

 

}
