package pe.gob.procalidad.natigu.core.service.service.implementacion.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioConfiguracionBean; 
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.PremioConfiguracionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.PremioConfiguracionService;

@Service("premioConfiguracionService")
@Transactional (readOnly = true)
public class PremioConfiguracionServiceImp implements PremioConfiguracionService{
	
	@Autowired
	private PremioConfiguracionDAO premioConfiguracionDAO;

	@Override
	public boolean insertar(PremioConfiguracionBean preConfigBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  premioConfiguracionDAO.insertar(preConfigBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PremioConfiguracionBean preConfigBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  premioConfiguracionDAO.actualizar(preConfigBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PremioConfiguracionBean preConfigBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  premioConfiguracionDAO.eliminar(preConfigBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public PremioConfiguracionBean getBuscarPorObjecto(PremioConfiguracionBean preConfigBean) throws ServiceException {
		PremioConfiguracionBean oPremioConfigBean = null;
		try {
			oPremioConfigBean = premioConfiguracionDAO.getBuscarPorObjecto(preConfigBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPremioConfigBean;
	}


	@Override
	public boolean existe(PremioConfiguracionBean preConfigBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PremioConfiguracionBean> listarTodos() throws ServiceException {
		List<PremioConfiguracionBean> lstPremioConfigBean=null;
		try {
			System.out.println("en listado premio configuracion");
			lstPremioConfigBean= premioConfiguracionDAO.listarTodos();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstPremioConfigBean;
	}

	@Override
	public List<PremioConfiguracionBean> getBuscarPorFiltros(PremioConfiguracionBean t) throws ServiceException {
		/*public List<PremioConfiguracionBean> getBuscarPorFiltros(PremioConfiguracionBean preConfigBean) throws ServiceException {
		List<PremioConfiguracionBean> lstPremioConfigBean=null;
		try {
			System.out.println("en listado premio service imp");
			lstPremioConfigBean=(List<PremioConfiguracionBean>) premioConfiguracionDAO.getBuscarPorFiltros(preConfigBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstPremioConfigBean;
	} */
		return null;
	}

}
