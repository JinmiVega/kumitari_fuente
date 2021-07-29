package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionOperadorBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionSedeBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.InstitucionOperadorDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionOperadorService;

@Service("institucionOperadorService")
@Transactional (readOnly = true)
public class InstitucionOperadorServiceImpl implements InstitucionOperadorService {

	@Autowired
	private InstitucionOperadorDAO institucionOperadorDAO;
	
	@Override
	public boolean insertar(InstitucionOperadorBean institucionOperadorBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getInstitucionOperadorDAO().insertar(institucionOperadorBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(InstitucionOperadorBean institucionOperadorBean)throws ServiceException {
		boolean sw =  false;
		try {
			sw =  this.getInstitucionOperadorDAO().actualizar(institucionOperadorBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(InstitucionOperadorBean institucionOperadorBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getInstitucionOperadorDAO().eliminar(institucionOperadorBean);
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public InstitucionOperadorBean getBuscarPorObjecto(InstitucionOperadorBean institucionOperadorBean)
			throws ServiceException {
		InstitucionOperadorBean objInstitucionOperadorBean = null;
		try {
			objInstitucionOperadorBean = this.getInstitucionOperadorDAO().getBuscarPorObjecto(institucionOperadorBean);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return objInstitucionOperadorBean;
	}

	@Override
	public List<InstitucionOperadorBean> getBuscarPorFiltros(InstitucionOperadorBean institucionOperadorBean) throws ServiceException {
		List<InstitucionOperadorBean> lstInstitucionOperadorBean = null;
		try {
			lstInstitucionOperadorBean = institucionOperadorDAO.getBuscarPorFiltros(institucionOperadorBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstInstitucionOperadorBean;
	}

	@Override
	public boolean existe(InstitucionOperadorBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public InstitucionOperadorDAO getInstitucionOperadorDAO() {
		return institucionOperadorDAO;
	}

	public void setInstitucionOperadorDAO(
			InstitucionOperadorDAO institucionOperadorDAO) {
		this.institucionOperadorDAO = institucionOperadorDAO;
	}
	
}