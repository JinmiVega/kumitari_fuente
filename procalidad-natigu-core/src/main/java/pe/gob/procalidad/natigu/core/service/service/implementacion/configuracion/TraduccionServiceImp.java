package pe.gob.procalidad.natigu.core.service.service.implementacion.configuracion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.TraduccionBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.TraduccionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.TraduccionService;
@Service("traduccionService")
@Transactional(readOnly = true)
public class TraduccionServiceImp implements TraduccionService{
	
	@Autowired
	private TraduccionDAO traduccionDAO;

	@Override
	public boolean insertar(TraduccionBean traduccionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getTraduccionDAO().insertar(traduccionBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(TraduccionBean traduccionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getTraduccionDAO().actualizar(traduccionBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(TraduccionBean traduccionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getTraduccionDAO().eliminar(traduccionBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public TraduccionBean getBuscarPorObjecto(TraduccionBean traduccionBean)
			throws ServiceException {
		TraduccionBean traduccionBean2 = null;
		try {
			traduccionBean2 = this.getTraduccionDAO().getBuscarPorObjecto(traduccionBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return traduccionBean2;
	}

	@Override
	public List<TraduccionBean> getBuscarPorFiltros(TraduccionBean traduccionBean)
			throws ServiceException {
		List<TraduccionBean> lstTraduccionBeans = null;
		try {
			lstTraduccionBeans = this.getTraduccionDAO().getBuscarPorFiltros(traduccionBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstTraduccionBeans;
	}

	@Override
	public boolean existe(TraduccionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public TraduccionDAO getTraduccionDAO() {
		return traduccionDAO;
	}

	public void setTraduccionDAO(TraduccionDAO traduccionDAO) {
		this.traduccionDAO = traduccionDAO;
	}
	

}
