 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;


import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaDocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;


public interface UsuarioMatriculaDAO  extends BaseDAO<UsuarioMatriculaBean>  {
	 
	public boolean asignarUsuario(UsuarioMatriculaBean t) throws DAOException;
	
	public boolean darBajaUsuarioMatricula(UsuarioMatriculaBean t) throws DAOException;
	
	public List<UsuarioMatriculaBean> buscarXTipoCuposXinscrLengua(UsuarioMatriculaBean usuarioMatriculaBean)throws DAOException;
	
	public boolean deleteUsumat(UsuarioMatriculaBean t) throws DAOException;
	


}
