package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionSedeBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.InstitucionSedeDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionSedeService;

@Service("institucionSedeService")
@Transactional (readOnly = true)
public class InstitucionSedeServiceImpl implements InstitucionSedeService {

	@Autowired
	private InstitucionSedeDAO institucionSedeDAO;
	
	@Override
	public boolean insertar(InstitucionSedeBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getInstitucionSedeDAO().insertar(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(InstitucionSedeBean t) throws ServiceException {
		boolean sw =  false;
		try { 
			sw = this.getInstitucionSedeDAO().actualizar(t);
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(InstitucionSedeBean t) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getInstitucionSedeDAO().eliminar(t);
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public InstitucionSedeBean getBuscarPorObjecto(InstitucionSedeBean t)
			throws ServiceException {
		InstitucionSedeBean oInstitucionSedeBean = null;
		try {
			oInstitucionSedeBean = this.getInstitucionSedeDAO().getBuscarPorObjecto(t);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return oInstitucionSedeBean;
	}

	@Override
	public List<InstitucionSedeBean> getBuscarPorFiltros(InstitucionSedeBean t)
			throws ServiceException {
		List<InstitucionSedeBean> lstInstitucionSedeBean=null;
		try {
			System.out.println("en listado Institucion service imp");
			lstInstitucionSedeBean= this.getInstitucionSedeDAO().getBuscarPorFiltros(t);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstInstitucionSedeBean;
	}

	@Override
	public boolean existe(InstitucionSedeBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<InstitucionSedeBean> listaInsticionSedes() throws ServiceException {
		List<InstitucionSedeBean> lstInstitucionBean=null;
		try {
			System.out.println("en listado Institucion Sedes");
			lstInstitucionBean= this.getInstitucionSedeDAO().listaInsticionSedes();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstInstitucionBean;
	}
	
	public InstitucionSedeDAO getInstitucionSedeDAO() {
		return institucionSedeDAO;
	}

	public void setInstitucionSedeDAO(InstitucionSedeDAO institucionSedeDAO) {
		this.institucionSedeDAO = institucionSedeDAO;
	}
	

	
}
