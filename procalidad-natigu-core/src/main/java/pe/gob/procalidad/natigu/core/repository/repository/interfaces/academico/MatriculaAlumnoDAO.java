 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
 

@Transactional(readOnly = true)
public interface MatriculaAlumnoDAO  extends BaseDAO<MatriculaAlumnoBean>  {
	

	public List<MatriculaAlumnoBean> listarAlumnosxMatricula(MatriculaAlumnoBean t)throws DAOException;
	
	public List<MatriculaAlumnoBean> getBuscarMatriculaXAlumno(MatriculaAlumnoBean matriculaAlumnoBean) throws DAOException;
	
	public List<MatriculaAlumnoBean> validarMatriculaAlumnoXInscrLengua(InscripcionLenguaBean inscripcionLenguaBean) throws DAOException;

	public List<MatriculaAlumnoBean> listarSeguimientoMatAlu(MatriculaAlumnoBean matriculaAlumnoBean) throws DAOException;
	
	public boolean calcularPromedioEva(MatriculaAlumnoBean matriculaAlumnoBean) throws DAOException; 
}
