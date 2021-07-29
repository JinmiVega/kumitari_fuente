package pe.gob.procalidad.natigu.core.service.service.implementacion.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;  
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException; 
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.PremioDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.PremioService;
 

 
@Service("premioService")
@Transactional (readOnly = true)
public class PremioServiceImp implements PremioService {
	
	@Autowired
	private PremioDAO premioDAO; 
	

	@Override
	public boolean insertar(PremioBean premioBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  premioDAO.insertar(premioBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PremioBean premioBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  premioDAO.actualizar(premioBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PremioBean premioBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  premioDAO.eliminar(premioBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public PremioBean getBuscarPorObjecto(PremioBean premioBean) throws ServiceException {
		PremioBean oPremioBean = null;
		try {
			oPremioBean = premioDAO.getBuscarPorObjecto(premioBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPremioBean;
	}
	
	@Override
	public PremioBean getBuscarPoraluMedalla(PremioBean premioBean) throws ServiceException {
		PremioBean oPremioBean = null;
		try {
			oPremioBean = premioDAO.getBuscarPorAluMedalla(premioBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPremioBean;
	}
	
	

	@Override
	public List<PremioBean> getBuscarPorFiltros(PremioBean premioBean)
			throws ServiceException {
		List<PremioBean> lstPremioBean=null;
		try {
			System.out.println("en listado premio service imp");
			lstPremioBean=(List<PremioBean>) premioDAO.getBuscarPorFiltros(premioBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstPremioBean;
	}

	@Override
	public boolean existe(PremioBean t) throws ServiceException {
		
		return false;
	}
	 
	
}
	
	 
