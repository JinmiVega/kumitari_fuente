 package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionDocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface InscripcionDocenteService  extends BaseService<InscripcionDocenteBean>  {
	 

	public boolean dar_baja_docente_x_InscripcionDocente(InscripcionDocenteBean inscripcionDocenteBean) throws ServiceException;

	
	
}
