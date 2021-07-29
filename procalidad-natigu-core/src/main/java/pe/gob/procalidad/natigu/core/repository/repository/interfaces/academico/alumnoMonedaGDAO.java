package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMonedaGBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface alumnoMonedaGDAO extends BaseDAO<AlumnoMonedaGBean>{

	public boolean actualizarmonedaxcompra(AlumnoMonedaGBean alumnoMonedaGBean) throws DAOException;
}
