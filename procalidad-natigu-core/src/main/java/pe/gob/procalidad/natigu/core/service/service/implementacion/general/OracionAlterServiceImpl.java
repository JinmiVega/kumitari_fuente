package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 


import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionAlterBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionCompletarBean; 
import pe.gob.procalidad.natigu.core.repository.exception.DAOException; 
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.OracionAlterDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException; 
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.OracionAlterService;

@Service("oracionAlterService")
@Transactional (readOnly = true)
public class OracionAlterServiceImpl implements OracionAlterService{

	@Autowired
	private OracionAlterDAO oracionAlterDAO;
	
	
	public OracionAlterDAO getOracionAlterDAO() {
		return oracionAlterDAO;
	}

	@Override
	public boolean insertar(OracionAlterBean oracionAlterBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getOracionAlterDAO().insertar(oracionAlterBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(OracionAlterBean oracionAlterBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getOracionAlterDAO().actualizar(oracionAlterBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(OracionAlterBean oracionAlterBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getOracionAlterDAO().eliminar(oracionAlterBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public OracionAlterBean getBuscarPorObjecto(OracionAlterBean alternativaBean) throws ServiceException {
		OracionAlterBean bean = null;
		try 
		{
			bean = getOracionAlterDAO().getBuscarPorObjecto(alternativaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@Override
	public List<OracionAlterBean> getBuscarPorOracion(
			OracionAlterBean  Bean) throws ServiceException {
		List<OracionAlterBean> lstBean = null;
		try {
			lstBean = this.getOracionAlterDAO().getBuscarPorOracion(Bean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstBean;
	}
	
	@Override
	public List<OracionAlterBean> getBuscarTodoxMTE(
			OracionAlterBean  Bean) throws ServiceException {
		List<OracionAlterBean> lstBean = null;
		try {
			lstBean = this.getOracionAlterDAO().getBuscarTodoxMTE(Bean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstBean;
	}

	@Override
	public List<OracionAlterBean> getBuscarPorFiltros(OracionAlterBean alternativaBean) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(OracionAlterBean alternativaBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OracionAlterBean> buscarPorEspacioOracion(OracionAlterBean oracionAlterBean) throws ServiceException 
	{
		List<OracionAlterBean> lst = null;
		try {
			lst = getOracionAlterDAO().buscarEspacioOracion(oracionAlterBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public List<OracionAlterBean> buscarPorCodigoOracion(
			OracionCompletarBean oracionCompletarBean) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
