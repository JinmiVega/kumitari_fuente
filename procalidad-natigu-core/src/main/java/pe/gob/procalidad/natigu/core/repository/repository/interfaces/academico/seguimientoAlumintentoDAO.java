package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumIntentoBean; 
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface seguimientoAlumintentoDAO extends BaseDAO<SeguimientoAlumIntentoBean>{

	boolean insertarDet(SeguimientoAlumIntentoBean Bean) throws DAOException;

	boolean actualizarDet(SeguimientoAlumIntentoBean Bean) throws DAOException;

	SeguimientoAlumIntentoBean getBuscarPorObjectoDet(
			SeguimientoAlumIntentoBean Bean) throws DAOException;

 
}
