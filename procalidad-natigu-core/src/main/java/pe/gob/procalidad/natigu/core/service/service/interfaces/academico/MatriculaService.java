package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;
 
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

@Transactional(readOnly = true)
public interface MatriculaService extends BaseService<MatriculaBean> {
	
	public List<MatriculaBean> listarCuposXAsignar(MatriculaBean matriculaBean) throws ServiceException;  
	
	public List<MatriculaBean> listarSeguimientoAlumno(MatriculaBean matriculaBean) throws ServiceException;  
	
	public boolean actualizarNumCuposRest(MatriculaBean matriculaBean) throws ServiceException;
	
	public List<MatriculaBean> getBuscarPorFiltrosxPerfil(MatriculaBean matriculaBean, UsuarioBean usu) throws ServiceException;  
}

 