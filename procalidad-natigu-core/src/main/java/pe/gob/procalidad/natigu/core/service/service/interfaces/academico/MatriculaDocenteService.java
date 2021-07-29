 package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaDocenteBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;
 

@Transactional(readOnly = true)
public interface MatriculaDocenteService  extends BaseService<MatriculaDocenteBean>  {
	

	public List<MatriculaDocenteBean> listarDocentexMatricula(MatriculaDocenteBean matriculaDocenteBean)throws ServiceException;
	
	public MatriculaDocenteBean       validarDocentexMatricula(MatriculaDocenteBean matriculaDocenteBean)throws DAOException;

}
