package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface MaterialTipoEjercicioDAO extends BaseDAO<MaterialTipoEjercicioBean> {
	public boolean actualizarOrden(MaterialTipoEjercicioBean t) throws DAOException;
}
