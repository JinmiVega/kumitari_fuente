package pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioConfiguracionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface PremioConfiguracionDAO extends BaseDAO<PremioConfiguracionBean> {
	
	public List<PremioConfiguracionBean> listarTodos() throws DAOException;

}
