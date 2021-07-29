package pe.gob.procalidad.natigu.core.service.service.implementacion.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.CombosCabBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.FondoBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.ComboCabDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.ComboCabService;

@Service("comboCabService")
@Transactional (readOnly = true)
public class ComboCabServiceImpl implements ComboCabService {

	@Autowired
	private ComboCabDAO comboCabDAO; 
	@Override
	public boolean insertar(CombosCabBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw =  comboCabDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(CombosCabBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw =  comboCabDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(CombosCabBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw =  comboCabDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public CombosCabBean getBuscarPorObjecto(CombosCabBean t) throws ServiceException {
		CombosCabBean bean = null;
		try {
			bean = comboCabDAO.getBuscarPorObjecto(t);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return bean;
	}

	@Override
	public List<CombosCabBean> getBuscarPorFiltros(CombosCabBean t) throws ServiceException {
		List<CombosCabBean> lstBean=null;
		try {
			lstBean=comboCabDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstBean;
	}

	@Override
	public boolean existe(CombosCabBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CombosCabBean> getBuscarTodos(CombosCabBean comboCabBean) throws ServiceException {
		List<CombosCabBean> lstBean=null;
		try {
			lstBean=comboCabDAO.getBuscarTodos(comboCabBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstBean;
	}

	@Override
	public List<CombosCabBean> getBuscarPorCombosAlumno(CombosCabBean comboBean) throws ServiceException {
		List<CombosCabBean> lstBean=null;
		try {
			lstBean=comboCabDAO.getBuscarPorCombosAlumno(comboBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstBean;
	}

	@Override
	public CombosCabBean getBuscarPorComboAlumno(CombosCabBean comboCabBean) throws ServiceException {
		CombosCabBean bean = null;
		try {
			bean = comboCabDAO.getBuscarPorComboAlumno(comboCabBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return bean;
	}

}
