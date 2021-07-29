package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMonedaGBean;  
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.alumnoMonedaGDAO; 
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoMonedaGService; 
@Transactional(readOnly = true)
@Service("alumnoMonedaGService")
public class AlumnoMonedaGServiceImpl implements AlumnoMonedaGService{
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private alumnoMonedaGDAO alMonedaGDAO;
	@Override
	public boolean insertar(AlumnoMonedaGBean bean)
			throws ServiceException {
			boolean sw = false;
			try {
				sw = this.alMonedaGDAO.insertar(bean);
			} catch (Exception e) {
				sw = false;
				e.printStackTrace();
			}
			return sw;
	}

	@Override
	public boolean actualizar(AlumnoMonedaGBean bean)
			throws ServiceException {
		boolean sw = false;
		try {
			sw = this.alMonedaGDAO.actualizar(bean);
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		}
		return sw;
	}

	@Override
	public boolean eliminar(AlumnoMonedaGBean bean)
			throws ServiceException {
		boolean sw = false;
		try {
			sw = this.alMonedaGDAO.eliminar(bean);
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		}
		return sw;
	}

	@Override
	public AlumnoMonedaGBean getBuscarPorObjecto(
			AlumnoMonedaGBean bean) throws ServiceException {
		AlumnoMonedaGBean oBean = null;
		try {
			oBean = alMonedaGDAO.getBuscarPorObjecto(bean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oBean;
	}

	@Override
	public List<AlumnoMonedaGBean> getBuscarPorFiltros(
			AlumnoMonedaGBean bean) throws ServiceException {
		List<AlumnoMonedaGBean> lstAlumnoMonedaGBeans = null;
		try {
			lstAlumnoMonedaGBeans = this.alMonedaGDAO.getBuscarPorFiltros(bean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstAlumnoMonedaGBeans;
	}
	

	@Override
	public boolean existe(AlumnoMonedaGBean bean)
			throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public alumnoMonedaGDAO getAlMonedaGDAO() {
		return alMonedaGDAO;
	}

	public void setAlMonedaGDAO(alumnoMonedaGDAO alMonedaGDAO) {
		this.alMonedaGDAO = alMonedaGDAO;
	}

	@Override
	public boolean actualizarmonedaxcompra(AlumnoMonedaGBean bean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.alMonedaGDAO.actualizarmonedaxcompra(bean);
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		}
		return sw;
	}

 

 
 

}
