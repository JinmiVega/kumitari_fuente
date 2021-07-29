 package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface UsuarioMatriculaService  extends BaseService<UsuarioMatriculaBean>  {
	 
	public boolean asignarUsuario(UsuarioMatriculaBean t) throws ServiceException;
	
	public boolean darBajaUsuarioMatricula(UsuarioMatriculaBean t) throws ServiceException;
	
	public List<UsuarioMatriculaBean> buscarXTipoCuposXinscrLengua(UsuarioMatriculaBean usuarioMatriculaBean)throws ServiceException;
	
	public boolean deleteUsumat(UsuarioMatriculaBean t) throws ServiceException;


}
