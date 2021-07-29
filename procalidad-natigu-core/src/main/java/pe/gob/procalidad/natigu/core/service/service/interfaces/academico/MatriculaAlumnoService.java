 package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;
 

@Transactional(readOnly = true)
public interface MatriculaAlumnoService  extends BaseService<MatriculaAlumnoBean>  {
	

	public List<MatriculaAlumnoBean> listarAlumnosxMatricula(MatriculaAlumnoBean t)throws ServiceException;
	
	public List<MatriculaAlumnoBean> getBuscarMatriculaXAlumno(MatriculaAlumnoBean matriculaAlumnoBean) throws ServiceException;

	public List<MatriculaAlumnoBean> validarMatriculaAlumnoXInscrLengua(InscripcionLenguaBean inscripcionLenguaBean) throws DAOException;

	public List<MatriculaAlumnoBean> listarSeguimientoMatAlu(MatriculaAlumnoBean matriculaAlumnoBean) throws ServiceException; 
	
	public boolean calcularPromedioEva(MatriculaAlumnoBean matriculaAlumnoBean) throws ServiceException;
}
