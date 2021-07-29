package pe.gob.procalidad.natigu.core.service.service.interfaces.general;
 
import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaNivelBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface LenguaNivelService extends BaseService<LenguaNivelBean> {
	
	public List<LenguaNivelBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws ServiceException;  
	 
	 
	
	 
}
 
