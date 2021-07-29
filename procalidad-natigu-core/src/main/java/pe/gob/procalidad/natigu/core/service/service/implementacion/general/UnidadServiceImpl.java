package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.UnidadDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UnidadService;

@Service("unidadService")
@Transactional (readOnly = true)
public class UnidadServiceImpl implements UnidadService{

	@Autowired
	private UnidadDAO unidadDAO;

	
	public UnidadDAO getUnidadDAO() {
		return unidadDAO;
	}

	@Override
	public boolean insertar(UnidadBean unidadBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getUnidadDAO().insertar(unidadBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(UnidadBean unidadBean) throws ServiceException {
		boolean sw =  false;
		try { 
			sw =getUnidadDAO().actualizar(unidadBean);
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(UnidadBean unidadBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = getUnidadDAO().eliminar(unidadBean);
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public UnidadBean getBuscarPorObjecto(UnidadBean unidadBean) throws ServiceException {
		UnidadBean bean = null;
		try 
		{
			bean = getUnidadDAO().getBuscarPorObjecto(unidadBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<UnidadBean> getBuscarPorFiltros(UnidadBean unidadBean) throws ServiceException {
		List<UnidadBean> lstUnidadBean = null;
		try {
			lstUnidadBean = getUnidadDAO().getBuscarPorFiltros(unidadBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return lstUnidadBean;
	}

	@Override
	public boolean existe(UnidadBean unidadBean) throws ServiceException {
		Boolean sw = true;
		try {
			sw =  getUnidadDAO().existe(unidadBean) ;
		} catch (DAOException e) { 
		}
		return sw;
	}

	@Override
	public UnidadBean buscarLengua(LenguaEstructuraBean lenguaEstructuraBean) throws ServiceException {
		UnidadBean bean = null;
		try 
		{
			bean = getUnidadDAO().buscarLengua(lenguaEstructuraBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<UnidadBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws ServiceException {
		List<UnidadBean> lstUnidadBean = null;
		try {
			lstUnidadBean = getUnidadDAO().listarPorCodigoLengua(lenguaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return lstUnidadBean;
	}


}
