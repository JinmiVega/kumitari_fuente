package pe.gob.procalidad.natigu.core.repository.repository.interfaces.seguridad;


import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioPerfilBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface UsuarioPerfilDAO extends BaseDAO<UsuarioPerfilBean> {
	public UsuarioPerfilBean buscarXcodigoUsu(UsuarioPerfilBean usuarioPerfilBean) throws DAOException;
}
