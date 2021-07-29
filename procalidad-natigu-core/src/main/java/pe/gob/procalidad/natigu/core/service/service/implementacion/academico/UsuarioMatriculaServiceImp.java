package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMonedaGBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.UsuarioMatriculaDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.UsuarioMatriculaService;


@Service("usuarioMatriculaService")
@Transactional (readOnly = true)
public class UsuarioMatriculaServiceImp implements UsuarioMatriculaService {

	@Autowired
	private UsuarioMatriculaDAO usuarioMatriculaDAO;
	
	@Override
	public boolean insertar(UsuarioMatriculaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  usuarioMatriculaDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(UsuarioMatriculaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(UsuarioMatriculaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  usuarioMatriculaDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public UsuarioMatriculaBean getBuscarPorObjecto(UsuarioMatriculaBean bean)
			throws ServiceException {
		UsuarioMatriculaBean oBean = null;
		try {
			oBean = usuarioMatriculaDAO.getBuscarPorObjecto(bean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oBean;
	}

	@Override
	public List<UsuarioMatriculaBean> getBuscarPorFiltros(UsuarioMatriculaBean t)
			throws ServiceException {
		List<UsuarioMatriculaBean> lstUsuarioMatriculaBean=null;
		try {
			System.out.println("en listado UsuarioMatriculaBean service imp");
			lstUsuarioMatriculaBean=(List<UsuarioMatriculaBean>) usuarioMatriculaDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstUsuarioMatriculaBean;
	}

	@Override
	public boolean existe(UsuarioMatriculaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean asignarUsuario(UsuarioMatriculaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  usuarioMatriculaDAO.asignarUsuario(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean darBajaUsuarioMatricula(UsuarioMatriculaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  usuarioMatriculaDAO.darBajaUsuarioMatricula(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public List<UsuarioMatriculaBean> buscarXTipoCuposXinscrLengua(UsuarioMatriculaBean usuarioMatriculaBean)
			throws ServiceException {
		List<UsuarioMatriculaBean> lstUsuarioMatriculaBean=null;
		try {
			System.out.println("en listado UsuarioMatriculaBean service imp");
			lstUsuarioMatriculaBean=(List<UsuarioMatriculaBean>) usuarioMatriculaDAO.buscarXTipoCuposXinscrLengua(usuarioMatriculaBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstUsuarioMatriculaBean;
	}

	@Override
	public boolean deleteUsumat(UsuarioMatriculaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  usuarioMatriculaDAO.deleteUsumat(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

}
