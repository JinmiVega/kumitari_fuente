package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaUnidadBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.LenguaUnidadDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaUnidadService;
@Transactional(readOnly = true)
@Service("lenguaUnidadService")
public class LenguaUnidadServiceImpl implements LenguaUnidadService{

	@Autowired
	private LenguaUnidadDAO lenguaUnidadDAO;
	
	@Override
	public boolean insertar(LenguaUnidadBean lenguaUnidadBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getLenguaUnidadDAO().insertar(lenguaUnidadBean);
			
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
			
		}
		return sw;
	}

	@Override
	public boolean actualizar(LenguaUnidadBean lenguaUnidadBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getLenguaUnidadDAO().actualizar(lenguaUnidadBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		}
		return sw;
	}

	@Override
	public boolean eliminar(LenguaUnidadBean lenguaUnidadBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getLenguaUnidadDAO().eliminar(lenguaUnidadBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		}
		return sw;
	}

	@Override
	public LenguaUnidadBean getBuscarPorObjecto(LenguaUnidadBean lenguaUnidadBean)
			throws ServiceException {
		LenguaUnidadBean oLenguaUnidadBean = null;
		try {
			oLenguaUnidadBean = this.getLenguaUnidadDAO().getBuscarPorObjecto(lenguaUnidadBean);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return oLenguaUnidadBean;
	}

	@Override
	public List<LenguaUnidadBean> getBuscarPorFiltros(LenguaUnidadBean lenguaUnidadBean)
			throws ServiceException {
		List<LenguaUnidadBean> lstLenguaUnidadBeans = null;
		try {
			lstLenguaUnidadBeans = this.getLenguaUnidadDAO().getBuscarPorFiltros(lenguaUnidadBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstLenguaUnidadBeans;
	}

	@Override
	public boolean existe(LenguaUnidadBean lenguaUnidadBean) throws ServiceException {
		Boolean sw = true;
		try {
			sw =   this.getLenguaUnidadDAO().existe(lenguaUnidadBean) ;
		} catch (DAOException e) { 
		}
		return sw;
	}

	public LenguaUnidadDAO getLenguaUnidadDAO() {
		return lenguaUnidadDAO;
	}

	public void setLenguaUnidadDAO(LenguaUnidadDAO lenguaUnidadDAO) {
		this.lenguaUnidadDAO = lenguaUnidadDAO;
	}

	@Override
	public boolean actualizarimgxcod(LenguaUnidadBean lenguaUnidadBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getLenguaUnidadDAO().actualizarimgxcod(lenguaUnidadBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		}
		return sw;
	}
	
	

}
