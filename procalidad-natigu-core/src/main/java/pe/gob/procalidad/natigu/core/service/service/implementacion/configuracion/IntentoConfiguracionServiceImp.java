package pe.gob.procalidad.natigu.core.service.service.implementacion.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.IntentoConfiguracionBean; 
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.IntentoConfiguracionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.IntentoConfiguracionService; 

@Service("intentoConfiguracionService")
@Transactional (readOnly = true)
public class IntentoConfiguracionServiceImp implements IntentoConfiguracionService{
	
	@Autowired
	private IntentoConfiguracionDAO intentoConfiguracionDAO;

	@Override
	public boolean insertar(IntentoConfiguracionBean preConfigBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  intentoConfiguracionDAO.insertar(preConfigBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(IntentoConfiguracionBean preConfigBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  intentoConfiguracionDAO.actualizar(preConfigBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(IntentoConfiguracionBean preConfigBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  intentoConfiguracionDAO.eliminar(preConfigBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public IntentoConfiguracionBean getBuscarPorObjecto(IntentoConfiguracionBean preConfigBean) throws ServiceException {
		IntentoConfiguracionBean oPremioConfigBean = null;
		try {
			oPremioConfigBean = intentoConfiguracionDAO.getBuscarPorObjecto(preConfigBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPremioConfigBean;
	}


	@Override
	public boolean existe(IntentoConfiguracionBean preConfigBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<IntentoConfiguracionBean> listarTodos() throws ServiceException {
		List<IntentoConfiguracionBean> lstPremioConfigBean=null;
		try {
			System.out.println("en listado premio configuracion");
			lstPremioConfigBean= intentoConfiguracionDAO.listarTodos();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstPremioConfigBean;
	}

	@Override
	public List<IntentoConfiguracionBean> getBuscarPorFiltros(IntentoConfiguracionBean t) throws ServiceException {
		/*public List<IntentoConfiguracionBean> getBuscarPorFiltros(IntentoConfiguracionBean preConfigBean) throws ServiceException {
		List<IntentoConfiguracionBean> lstPremioConfigBean=null;
		try {
			System.out.println("en listado premio service imp");
			lstPremioConfigBean=(List<IntentoConfiguracionBean>) intentoConfiguracionDAO.getBuscarPorFiltros(preConfigBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstPremioConfigBean;
	} */
		return null;
	}

}
