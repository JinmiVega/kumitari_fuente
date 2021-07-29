package pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaAccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaDetalleBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaTablaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.seguridad.AuditoriaDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.AuditoriaService;

@Service("auditoriaService")
@Transactional (readOnly = true)
public class AuditoriaServiceImp implements AuditoriaService {

	@Autowired
	AuditoriaDAO auditoriaDAO;
	
	@Override
	public boolean insertar(AuditoriaBean t) throws ServiceException {
		return false;
	}

	@Override
	public boolean actualizar(AuditoriaBean t) throws ServiceException {
		return false;
	}

	@Override
	public boolean eliminar(AuditoriaBean t) throws ServiceException {
		return false;
	}

	@Override
	public AuditoriaBean getBuscarPorObjecto(AuditoriaBean t) throws ServiceException {
		return null;
	}

	@Override
	public List<AuditoriaBean> getBuscarPorFiltros(AuditoriaBean t)
			throws ServiceException {
		List<AuditoriaBean> lstBean = null;
		try {
			lstBean =  auditoriaDAO.getBuscarPorFiltros(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	@Override
	public boolean existe(AuditoriaBean t) throws ServiceException {
		return false;
	}

	@Override
	public List<AuditoriaTablaBean> listarTablas(AuditoriaTablaBean prmAuditoriaTablaBean) throws ServiceException {
		List<AuditoriaTablaBean> lstBean = null;
		try {
			lstBean =  auditoriaDAO.listarTablas(prmAuditoriaTablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	@Override
	public List<AuditoriaDetalleBean> listarAuditoriaDetalle(AuditoriaDetalleBean prmAuditoriaDetalleBean)
			throws ServiceException {
		List<AuditoriaDetalleBean> lstBean = null;
		try {
			lstBean =  auditoriaDAO.listarAuditoriaDetalle(prmAuditoriaDetalleBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	@Override
	public boolean insertarAuditoriaAcceso(AuditoriaAccesoBean prmAuditoriaAccesoBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  auditoriaDAO.insertarAuditoriaAcceso(prmAuditoriaAccesoBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public List<AuditoriaAccesoBean> listarAuditoriaAcceso(AuditoriaAccesoBean prmAuditoriaAccesoBean)
			throws ServiceException {
		List<AuditoriaAccesoBean> lstBean = null;
		try {
			lstBean =  auditoriaDAO.listarAuditoriaAcceso(prmAuditoriaAccesoBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}
	
}