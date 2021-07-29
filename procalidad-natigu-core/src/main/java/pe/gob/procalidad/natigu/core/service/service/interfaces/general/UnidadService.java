package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List; 
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface UnidadService extends BaseService<UnidadBean>{

	public UnidadBean buscarLengua(LenguaEstructuraBean lenguaEstructuraBean) throws ServiceException;
	
	public List<UnidadBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws ServiceException;
	
}
