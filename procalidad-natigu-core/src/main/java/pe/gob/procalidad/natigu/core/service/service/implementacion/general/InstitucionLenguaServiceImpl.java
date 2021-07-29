package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionLenguaBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.InstitucionLenguaDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionLenguaService;

@Service("institucionLenguaService")
@Transactional (readOnly = true)
public class InstitucionLenguaServiceImpl implements InstitucionLenguaService {
	
	@Autowired
	private InstitucionLenguaDAO institucionLenguaDAO;
	
	@Override
	public boolean insertar(InstitucionLenguaBean institucionLenguaBean) throws ServiceException {
		boolean sw =  false;
		try {
			
			sw =  this.getInstitucionLenguaDAO().insertar(institucionLenguaBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(InstitucionLenguaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(InstitucionLenguaBean institucionLenguaBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getInstitucionLenguaDAO().eliminar(institucionLenguaBean);
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public InstitucionLenguaBean getBuscarPorObjecto(InstitucionLenguaBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InstitucionLenguaBean> getBuscarPorFiltros(InstitucionLenguaBean institucionLenguaBean) throws ServiceException {
		List<InstitucionLenguaBean> lstInstitucionLenguaBean =  null;
		try {
			lstInstitucionLenguaBean = this.institucionLenguaDAO.getBuscarPorFiltros(institucionLenguaBean);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServiceException(e);
			
		}
		return lstInstitucionLenguaBean;
	}

	@Override
	public boolean existe(InstitucionLenguaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public InstitucionLenguaDAO getInstitucionLenguaDAO() {
		return institucionLenguaDAO;
	}

	public void setInstitucionLenguaDAO(InstitucionLenguaDAO institucionLenguaDAO) {
		this.institucionLenguaDAO = institucionLenguaDAO;
	}

	@Override
	public List<InstitucionLenguaBean> existeLengua(InstitucionLenguaBean institucionLenguaBean)
			throws ServiceException {
		List<InstitucionLenguaBean> lstInstitucionLenguaBean =  null;
		try {
			lstInstitucionLenguaBean = this.institucionLenguaDAO.existeLengua(institucionLenguaBean);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServiceException(e);
			
		}
		return lstInstitucionLenguaBean;
	}

	@Override
	public List<InstitucionLenguaBean> reporteAlumLengInst(InstitucionLenguaBean institucionLenguaBean)
			throws ServiceException {
		List<InstitucionLenguaBean> lstInstitucionLenguaBean =  null;
		try {
			lstInstitucionLenguaBean = this.institucionLenguaDAO.reporteAlumLengInst(institucionLenguaBean);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServiceException(e);
			
		}
		return lstInstitucionLenguaBean;
	}

	
}