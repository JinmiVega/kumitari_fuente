package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumnoLenguaBean; 
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaUnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO; 

public interface SeguimientoAlumnoLenguaDAO  extends BaseDAO<SeguimientoAlumnoLenguaBean> {
	
	public List<LenguaEstructuraBean> listarSubNivel(SeguimientoAlumnoLenguaBean seguimientoAlumnoLenguaBean) throws DAOException;

	public List<UnidadBean> listarUnidad(SeguimientoAlumnoLenguaBean seguimientoAlumnoLenguaBean) throws DAOException;

	public List<UnidadLeccionBean> listarLeccion(SeguimientoAlumnoLenguaBean seguimientoAlumnoLenguaBean) throws DAOException;
 
	boolean insertar_sigLec(SeguimientoAlumnoLenguaBean t) throws DAOException;

}
