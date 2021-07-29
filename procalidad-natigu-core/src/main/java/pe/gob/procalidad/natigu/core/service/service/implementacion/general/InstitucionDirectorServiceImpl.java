package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionDirectorBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.InstitucionDirectorDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionDirectorService;
@Service("institucionDirectorService")
@Transactional (readOnly = true)
public class InstitucionDirectorServiceImpl implements InstitucionDirectorService {

	@Autowired
	private InstitucionDirectorDAO institucionDirectorDAO;
	
	@Override
	public boolean insertar(InstitucionDirectorBean institucionDirectorBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getInstitucionDirectorDAO().insertar(institucionDirectorBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(InstitucionDirectorBean institucionDirectorBean)throws ServiceException {
		boolean sw =  false;
		try {
			sw =  this.getInstitucionDirectorDAO().actualizar(institucionDirectorBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(InstitucionDirectorBean institucionDirectorBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getInstitucionDirectorDAO().eliminar(institucionDirectorBean);
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public InstitucionDirectorBean getBuscarPorObjecto(InstitucionDirectorBean institucionDirectorBean)
			throws ServiceException {
		InstitucionDirectorBean oInstitucionDirectorBean = null;
		try {
			oInstitucionDirectorBean = this.getInstitucionDirectorDAO().getBuscarPorObjecto(institucionDirectorBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oInstitucionDirectorBean;
	}

	@Override
	public List<InstitucionDirectorBean> getBuscarPorFiltros(InstitucionDirectorBean institucionDirectorBean) throws ServiceException {
		List<InstitucionDirectorBean> lstInstitucionDirectorBean = null;
		try {
			lstInstitucionDirectorBean = institucionDirectorDAO.getBuscarPorFiltros(institucionDirectorBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstInstitucionDirectorBean;
	}

	@Override
	public boolean existe(InstitucionDirectorBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public InstitucionDirectorDAO getInstitucionDirectorDAO() {
		return institucionDirectorDAO;
	}

	public void setInstitucionDirectorDAO(
			InstitucionDirectorDAO institucionDirectorDAO) {
		this.institucionDirectorDAO = institucionDirectorDAO;
	}
	
	
}
