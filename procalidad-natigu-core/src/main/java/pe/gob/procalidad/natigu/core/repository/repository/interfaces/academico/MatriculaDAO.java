 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
 

@Transactional(readOnly = true)
public interface MatriculaDAO  extends BaseDAO<MatriculaBean>  {
	
	public List<MatriculaBean> listarCuposXAsignar(MatriculaBean matriculaBean) throws DAOException;
	 
	public List<MatriculaBean> listarSeguimientoAlumno(MatriculaBean matriculaBean) throws DAOException;
	
	public boolean actualizarNumCuposRest(MatriculaBean matriculaBean) throws DAOException;
	 
	public List<MatriculaBean> getBuscarPorFiltrosxPerfil(MatriculaBean matriculaBean,UsuarioBean usu) throws DAOException;
}
