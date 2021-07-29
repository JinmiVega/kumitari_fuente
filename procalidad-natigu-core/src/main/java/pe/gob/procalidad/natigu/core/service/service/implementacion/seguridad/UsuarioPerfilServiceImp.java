package pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioPerfilBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.seguridad.UsuarioPerfilDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.UsuarioPerfilService;

@Service("usuarioPerfilService")
@Transactional (readOnly = true)
public class UsuarioPerfilServiceImp implements UsuarioPerfilService{

	@Autowired
	UsuarioPerfilDAO usuarioPerfilDAO;
	
	@Override
	public boolean insertar(UsuarioPerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioPerfilDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(UsuarioPerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioPerfilDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(UsuarioPerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioPerfilDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public UsuarioPerfilBean getBuscarPorObjecto(UsuarioPerfilBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioPerfilBean> getBuscarPorFiltros(UsuarioPerfilBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<UsuarioPerfilBean> lstBean = null;
		try {
			lstBean =  usuarioPerfilDAO.getBuscarPorFiltros(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	@Override
	public boolean existe(UsuarioPerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UsuarioPerfilBean buscarXcodigoUsu(UsuarioPerfilBean usuarioPerfilBean) throws ServiceException {
		UsuarioPerfilBean oUsuarioBean = null;
		try {
			oUsuarioBean =  usuarioPerfilDAO.buscarXcodigoUsu(usuarioPerfilBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return oUsuarioBean;
	}

	
}
