package pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface UsuarioService extends BaseService<UsuarioBean>{

	public UsuarioBean autenticar(UsuarioBean prmUsuarioBean) throws ServiceException;
	
	public Integer cambiarPassword(UsuarioBean prmUsuarioBean) throws ServiceException;
	
	public UsuarioBean buscarxcodigousua(UsuarioBean prmUsuarioBean) throws ServiceException;
	
	public UsuarioBean buscarxcodperso(UsuarioBean prmUsuarioBean) throws ServiceException;
}
