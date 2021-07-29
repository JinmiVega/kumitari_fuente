 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaDocenteBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
 

@Transactional(readOnly = true)
public interface MatriculaDocenteDAO  extends BaseDAO<MatriculaDocenteBean>  {
	

	public List<MatriculaDocenteBean> listarDocentexMatricula(MatriculaDocenteBean matriculaDocenteBean)throws DAOException;
	
	public MatriculaDocenteBean       validarDocentexMatricula(MatriculaDocenteBean matriculaDocenteBean)throws DAOException;
}
