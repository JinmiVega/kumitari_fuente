package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;
 

import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraciBean; 
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface ArrastraOraciService extends BaseService<ArrastraOraciBean>{

	ArrastraOraciBean getBuscarPorTEM(
			ArrastraOraciBean arrastraOraciBean) throws ServiceException;

 
}
