package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaLeccionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.LenguaLeccionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaLeccionService;
@Transactional(readOnly = true)
@Service("lenguaLeccionService")
public class LenguaLeccionServiceImpl implements LenguaLeccionService{

	@Autowired
	private LenguaLeccionDAO lenguaLeccionDAO;
	
	@Override
	public boolean insertar(LenguaLeccionBean lenguaLeccionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getLenguaLeccionDAO().insertar(lenguaLeccionBean);
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(LenguaLeccionBean lenguaLeccionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getLenguaLeccionDAO().actualizar(lenguaLeccionBean);
			
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(LenguaLeccionBean lenguaLeccionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getLenguaLeccionDAO().eliminar(lenguaLeccionBean);
			
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public LenguaLeccionBean getBuscarPorObjecto(LenguaLeccionBean lenguaLeccionBean)
			throws ServiceException {
		LenguaLeccionBean oLeccionBean = null;
		try {
			oLeccionBean = this.getLenguaLeccionDAO().getBuscarPorObjecto(lenguaLeccionBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		return oLeccionBean;
	}

	@Override
	public List<LenguaLeccionBean> getBuscarPorFiltros(LenguaLeccionBean lenguaLeccionBean)
			throws ServiceException {
		List<LenguaLeccionBean> lstLenguaLeccionBeans = null;
		try {
			lstLenguaLeccionBeans = this.getLenguaLeccionDAO().getBuscarPorFiltros(lenguaLeccionBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstLenguaLeccionBeans;
	}

	@Override
	public boolean existe(LenguaLeccionBean lenguaLeccionBean) throws ServiceException {
		Boolean sw = true;
		try {
			sw =   lenguaLeccionDAO.existe(lenguaLeccionBean) ;
		} catch (DAOException e) { 
		}
		return sw;
	}

	public LenguaLeccionDAO getLenguaLeccionDAO() {
		return lenguaLeccionDAO;
	}

	public void setLenguaLeccionDAO(LenguaLeccionDAO lenguaLeccionDAO) {
		this.lenguaLeccionDAO = lenguaLeccionDAO;
	}

	@Override
	public boolean actualizarimgxcod(LenguaLeccionBean lenguaLeccionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getLenguaLeccionDAO().actualizarimgxcod(lenguaLeccionBean);
			
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
		}
		return sw;
	}
	

}
