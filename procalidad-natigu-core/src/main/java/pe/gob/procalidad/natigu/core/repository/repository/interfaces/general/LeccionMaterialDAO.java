package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LeccionMaterialBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface LeccionMaterialDAO extends BaseDAO<LeccionMaterialBean>{

	public List<LeccionMaterialBean> buscarPorLeccion(LeccionMaterialBean materialBean) throws DAOException;
	public boolean actualizarOrden(LeccionMaterialBean t) throws DAOException;
}
