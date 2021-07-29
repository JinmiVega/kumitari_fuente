 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoInstitucionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
 


public interface AlumnoInstitucionDAO  extends BaseDAO<AlumnoInstitucionBean>  {
	public List<AlumnoInstitucionBean> getBuscarPorCodigoAlumno(AlumnoInstitucionBean alumnoInstitucionBean) throws DAOException;
}
