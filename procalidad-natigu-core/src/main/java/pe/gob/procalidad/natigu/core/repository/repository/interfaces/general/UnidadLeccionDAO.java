package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface UnidadLeccionDAO extends BaseDAO<UnidadLeccionBean>{
	
	public List<UnidadLeccionBean> listarPorLengua(LenguaBean lenguaBean) throws DAOException;
	
	public List<UnidadLeccionBean> listarPorUnidad(UnidadBean unidadBean) throws DAOException;

 
	List<UnidadLeccionBean> getBuscarPorLenNiv(
			UnidadLeccionBean unidadLeccionBean) throws DAOException;

	UnidadLeccionBean getBuscarultLecXlenest(UnidadLeccionBean unidadLeccionBean)
			throws DAOException;

	UnidadLeccionBean getBuscarultLecXunidad(UnidadLeccionBean unidadLeccionBean)
			throws DAOException;
	

}
