package pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.IntentoConfiguracionBean; 
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface IntentoConfiguracionDAO extends BaseDAO<IntentoConfiguracionBean> {
	
	public List<IntentoConfiguracionBean> listarTodos() throws DAOException;

}
