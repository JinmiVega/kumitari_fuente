package pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad;


import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioPerfilBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface UsuarioPerfilService extends BaseService<UsuarioPerfilBean>{
	
	public UsuarioPerfilBean buscarXcodigoUsu(UsuarioPerfilBean usuarioPerfilBean) throws ServiceException;
}
