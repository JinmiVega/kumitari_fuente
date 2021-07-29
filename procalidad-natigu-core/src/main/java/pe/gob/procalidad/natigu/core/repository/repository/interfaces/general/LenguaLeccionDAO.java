package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaLeccionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface LenguaLeccionDAO extends BaseDAO<LenguaLeccionBean>{

	public boolean actualizarimgxcod(LenguaLeccionBean t) throws DAOException;
}
