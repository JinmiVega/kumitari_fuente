package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface UnidadLeccionService extends BaseService<UnidadLeccionBean>{
	
	public List<UnidadLeccionBean> listarPorLengua(LenguaBean lenguaBean) throws ServiceException; 
	
	public List<UnidadLeccionBean> listarPorUnidad(UnidadBean unidadBean) throws ServiceException;

 
	List<UnidadLeccionBean> getBuscarPorLenNiv(
			UnidadLeccionBean unidadLeccionBean) throws ServiceException;

	UnidadLeccionBean getBuscarultLecXlenest(UnidadLeccionBean unidadLeccionBean)
			throws ServiceException;

	UnidadLeccionBean getBuscarultLecXunidad(UnidadLeccionBean unidadLeccionBean)
			throws ServiceException; 
	
}
