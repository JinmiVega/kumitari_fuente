 package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumnoLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaUnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface SeguimientoAlumnoLenguaService  extends BaseService<SeguimientoAlumnoLenguaBean>  {
	 
	public List<LenguaEstructuraBean> listarSubNivel(SeguimientoAlumnoLenguaBean seguimientoAlumnoLenguaBean) throws ServiceException;
	
	public List<UnidadBean> listarUnidad(SeguimientoAlumnoLenguaBean seguimientoAlumnoLenguaBean) throws ServiceException;
	
	public List<UnidadLeccionBean> listarLeccion(SeguimientoAlumnoLenguaBean seguimientoAlumnoLenguaBean)  throws ServiceException;
 
	boolean insertar_sigLec(SeguimientoAlumnoLenguaBean t)
			throws ServiceException;

}
