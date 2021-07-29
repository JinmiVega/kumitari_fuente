package pe.gob.procalidad.natigu.core.service.service.implementacion.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.AdquisicionUsuarioBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.AdquisicionUsuarioDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.AdquisicionUsuarioService;


@Service("adquisicionUsuarioService")
@Transactional (readOnly = true)
public class AdquisicionUsuarioServiceImp implements AdquisicionUsuarioService {
	
	@Autowired
	private AdquisicionUsuarioDAO adquisicionUsuarioDAO; 

	@Override
	public boolean insertar(AdquisicionUsuarioBean prmObject) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  adquisicionUsuarioDAO.insertar(prmObject);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(AdquisicionUsuarioBean prmObject) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  adquisicionUsuarioDAO.actualizar(prmObject);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(AdquisicionUsuarioBean prmObject) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  adquisicionUsuarioDAO.eliminar(prmObject);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public AdquisicionUsuarioBean getBuscarPorObjecto(AdquisicionUsuarioBean prmObject) throws ServiceException {
		AdquisicionUsuarioBean oAdquisicionUsuarioBean = null;
		try {
			oAdquisicionUsuarioBean = adquisicionUsuarioDAO.getBuscarPorObjecto(prmObject);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oAdquisicionUsuarioBean;
	}
	@Override
	public List<AdquisicionUsuarioBean> getBuscarPorFiltros(AdquisicionUsuarioBean prmObject)
			throws ServiceException {
		List<AdquisicionUsuarioBean> lstAdquisicionUsuarioBean=null;
		try {
			
			lstAdquisicionUsuarioBean=(List<AdquisicionUsuarioBean>) adquisicionUsuarioDAO.getBuscarPorFiltros(prmObject);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstAdquisicionUsuarioBean;
	}
	@Override
	public boolean existe(AdquisicionUsuarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer realizarCompra(AdquisicionUsuarioBean prmObject)
			throws ServiceException {
		Integer result = -1;
		try {
			result= adquisicionUsuarioDAO.realizarCompra(prmObject);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean actualizarSwPredeterminadoMasc(AdquisicionUsuarioBean prmObject) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  adquisicionUsuarioDAO.actualizarSwPredeterminadoMasc(prmObject);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizarSwPredeterminadoFond(AdquisicionUsuarioBean prmObject) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  adquisicionUsuarioDAO.actualizarSwPredeterminadoFond(prmObject);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizarSwPredeterminadoCombo(AdquisicionUsuarioBean prmObject) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  adquisicionUsuarioDAO.actualizarSwPredeterminadoCombo(prmObject);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

}
