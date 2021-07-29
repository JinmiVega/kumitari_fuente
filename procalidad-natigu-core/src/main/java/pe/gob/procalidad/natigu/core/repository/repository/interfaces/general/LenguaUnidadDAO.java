package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaUnidadBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface LenguaUnidadDAO extends BaseDAO<LenguaUnidadBean>{
	
	public boolean actualizarimgxcod(LenguaUnidadBean t) throws DAOException;
}
