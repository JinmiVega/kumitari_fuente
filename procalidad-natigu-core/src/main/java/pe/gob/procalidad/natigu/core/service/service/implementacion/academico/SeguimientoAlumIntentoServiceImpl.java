package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumIntentoBean; 
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.seguimientoAlumintentoDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.SeguimientoAlumIntentoService; 
@Transactional(readOnly = true)
@Service("SeguimientoAlumInentoService")
public class SeguimientoAlumIntentoServiceImpl implements SeguimientoAlumIntentoService{
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private seguimientoAlumintentoDAO SegIntentoDAO;
	@Override
	public boolean insertar(SeguimientoAlumIntentoBean bean)
			throws ServiceException {
			boolean sw = false;
			try {
				sw = this.SegIntentoDAO.insertar(bean);
			} catch (Exception e) {
				sw = false;
				e.printStackTrace();
			}
			return sw;
	}

	@Override
	public boolean actualizar(SeguimientoAlumIntentoBean bean)
			throws ServiceException {
		boolean sw = false;
		try {
			sw = this.SegIntentoDAO.actualizar(bean);
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		}
		return sw;
	}
	
	@Override
	public boolean insertarDet(SeguimientoAlumIntentoBean bean)
			throws ServiceException {
			boolean sw = false;
			try {
				sw = this.SegIntentoDAO.insertarDet(bean);
			} catch (Exception e) {
				sw = false;
				e.printStackTrace();
			}
			return sw;
	}

	@Override
	public boolean actualizarDet(SeguimientoAlumIntentoBean bean)
			throws ServiceException {
		boolean sw = false;
		try {
			sw = this.SegIntentoDAO.actualizarDet(bean);
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		}
		return sw;
	}
	

	@Override
	public boolean eliminar(SeguimientoAlumIntentoBean bean)
			throws ServiceException {
		boolean sw = false;
		try {
			sw = this.SegIntentoDAO.eliminar(bean);
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		}
		return sw;
	}

	@Override
	public SeguimientoAlumIntentoBean getBuscarPorObjecto(
			SeguimientoAlumIntentoBean bean) throws ServiceException {
		SeguimientoAlumIntentoBean oBean = null;
		try {
			oBean = SegIntentoDAO.getBuscarPorObjecto(bean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oBean;
	}

	
	@Override
	public SeguimientoAlumIntentoBean getBuscarPorObjectoDet(
			SeguimientoAlumIntentoBean bean) throws ServiceException {
		SeguimientoAlumIntentoBean oBean = null;
		try {
			oBean = SegIntentoDAO.getBuscarPorObjectoDet(bean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oBean;
	}

	
	
	@Override
	public List<SeguimientoAlumIntentoBean> getBuscarPorFiltros(
			SeguimientoAlumIntentoBean bean) throws ServiceException {
		List<SeguimientoAlumIntentoBean> lstSeguimientoAlumIntentoBeans = null;
		try {
			lstSeguimientoAlumIntentoBeans = this.SegIntentoDAO.getBuscarPorFiltros(bean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstSeguimientoAlumIntentoBeans;
	}
	

	@Override
	public boolean existe(SeguimientoAlumIntentoBean bean)
			throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	 

 
 

}
