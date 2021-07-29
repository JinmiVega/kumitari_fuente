package pe.gob.procalidad.natigu.core.repository.repository.interfaces.seguridad;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AccesoBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface AccesoDAO extends BaseDAO<AccesoBean> {

	public boolean asignar(AccesoBean bean) throws DAOException;
	
}
