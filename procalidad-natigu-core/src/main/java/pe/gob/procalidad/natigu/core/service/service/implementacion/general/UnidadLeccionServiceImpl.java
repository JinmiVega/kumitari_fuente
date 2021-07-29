package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.UnidadLeccionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UnidadLeccionService;

@Service("unidadLeccionService")
@Transactional (readOnly = true)
public class UnidadLeccionServiceImpl implements UnidadLeccionService{

	@Autowired
	private UnidadLeccionDAO unidadLeccionDAO;
	
	@Override
	public boolean insertar(UnidadLeccionBean unidadLeccionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = unidadLeccionDAO.insertar(unidadLeccionBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(UnidadLeccionBean unidadLeccionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = unidadLeccionDAO.actualizar(unidadLeccionBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(UnidadLeccionBean unidadLeccionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = unidadLeccionDAO.eliminar(unidadLeccionBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public UnidadLeccionBean getBuscarPorObjecto(UnidadLeccionBean unidadLeccionBean) throws ServiceException {
		UnidadLeccionBean bean = null;
		try {
			bean = unidadLeccionDAO.getBuscarPorObjecto(unidadLeccionBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@Override
	public UnidadLeccionBean getBuscarultLecXlenest(UnidadLeccionBean unidadLeccionBean) throws ServiceException {
		UnidadLeccionBean bean = null;
		try {
			bean = unidadLeccionDAO.getBuscarultLecXlenest(unidadLeccionBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@Override
	public UnidadLeccionBean getBuscarultLecXunidad(UnidadLeccionBean unidadLeccionBean) throws ServiceException {
		UnidadLeccionBean bean = null;
		try {
			bean = unidadLeccionDAO.getBuscarultLecXunidad(unidadLeccionBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<UnidadLeccionBean> getBuscarPorFiltros(UnidadLeccionBean unidadLeccionBean) throws ServiceException {
		List<UnidadLeccionBean> lstUnidadBean = null;
		try {
			lstUnidadBean = unidadLeccionDAO.getBuscarPorFiltros(unidadLeccionBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return lstUnidadBean;
	}
	
	@Override
	public List<UnidadLeccionBean> getBuscarPorLenNiv(UnidadLeccionBean unidadLeccionBean) throws ServiceException {
		List<UnidadLeccionBean> lstUnidadBean = null;
		try {
			lstUnidadBean = unidadLeccionDAO.getBuscarPorLenNiv(unidadLeccionBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return lstUnidadBean;
	}

	@Override
	public boolean existe(UnidadLeccionBean unidadLeccionBean) throws ServiceException {
		Boolean sw = true;
		try {
			sw =  unidadLeccionDAO.existe(unidadLeccionBean) ;
		} catch (DAOException e) { 
		}
		return sw;
	}

	@Override
	public List<UnidadLeccionBean> listarPorLengua(LenguaBean lenguaBean) throws ServiceException {
		List<UnidadLeccionBean> lstUnidadBean = null;
		try {
			lstUnidadBean = unidadLeccionDAO.listarPorLengua(lenguaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return lstUnidadBean;
	}

	@Override
	public List<UnidadLeccionBean> listarPorUnidad(UnidadBean unidadBean) throws ServiceException {
		List<UnidadLeccionBean> lstUnidadBean = null;
		try {
			lstUnidadBean = unidadLeccionDAO.listarPorUnidad(unidadBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return lstUnidadBean;
	}

}
