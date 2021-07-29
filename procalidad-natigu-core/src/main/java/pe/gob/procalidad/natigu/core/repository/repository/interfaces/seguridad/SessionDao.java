package pe.gob.procalidad.natigu.core.repository.repository.interfaces.seguridad;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.SesionBean;

import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface SessionDao extends BaseDAO<SesionBean>{
	
	public boolean sessionGestor(SesionBean sesionBean,String operacion) throws DAOException;

}
