package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.OrdenarParrafoBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.OrdenarParrafoDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.OrdenarParrafoService;

@Service("ordenarParrafoService")
@Transactional (readOnly = true)
public class OrdenarParrafoServiceImpl implements OrdenarParrafoService{
	
	@Autowired
	private OrdenarParrafoDAO ordenarParrafoDAO;

	@Override
	public boolean insertar(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getOrdenarParrafoDAO().insertar(ordenarParrafoBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getOrdenarParrafoDAO().actualizar(ordenarParrafoBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}
	
	@Override
	public boolean actualizarOrden(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getOrdenarParrafoDAO().actualizarOrden(ordenarParrafoBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace(); 
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getOrdenarParrafoDAO().eliminar(ordenarParrafoBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public OrdenarParrafoBean getBuscarPorObjecto(OrdenarParrafoBean ordenarParrafoBean)
			throws ServiceException {
		OrdenarParrafoBean ordenarParrafoBean2 = null;
		try {
			ordenarParrafoBean2 =this.getOrdenarParrafoDAO().getBuscarPorObjecto(ordenarParrafoBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ordenarParrafoBean2;
	}

	@Override
	public List<OrdenarParrafoBean> getBuscarPorFiltros(OrdenarParrafoBean ordenarParrafoBean)throws ServiceException {
		List<OrdenarParrafoBean> lstOrdenarParrafoBeans = null;
		try {
			lstOrdenarParrafoBeans = ordenarParrafoDAO.getBuscarPorFiltros(ordenarParrafoBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstOrdenarParrafoBeans;
	}

	@Override
	public boolean existe(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public OrdenarParrafoDAO getOrdenarParrafoDAO() {
		return ordenarParrafoDAO;
	}

	public void setOrdenarParrafoDAO(OrdenarParrafoDAO ordenarParrafoDAO) {
		this.ordenarParrafoDAO = ordenarParrafoDAO;
	}

	@Override
	public List<OrdenarParrafoBean> listarTodosParrafos(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException {
		List<OrdenarParrafoBean> lstOrdenarParrafoBeans = null;
		try {
			lstOrdenarParrafoBeans = this.getOrdenarParrafoDAO().listarTodosParrafos(ordenarParrafoBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstOrdenarParrafoBeans;
	}

	@Override
	public boolean actualizarDoc(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getOrdenarParrafoDAO().actualizarDoc(ordenarParrafoBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean insertarDoc(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getOrdenarParrafoDAO().insertarDoc(ordenarParrafoBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizarArras(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getOrdenarParrafoDAO().actualizarArras(ordenarParrafoBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean insertarArras(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getOrdenarParrafoDAO().insertarArras(ordenarParrafoBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	

}
