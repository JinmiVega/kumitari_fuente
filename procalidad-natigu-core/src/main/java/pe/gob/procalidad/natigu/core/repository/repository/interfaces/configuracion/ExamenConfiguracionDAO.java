package pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.ExamenConfiguracionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface ExamenConfiguracionDAO extends BaseDAO<ExamenConfiguracionBean> {
	public List<ExamenConfiguracionBean> listarTodos() throws DAOException;
}
