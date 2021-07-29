package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumnoEjercicioBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.SeguimientoAlumnoEjercicioDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.SeguimientoAlumnoEjercicioService;
@Transactional(readOnly = true)
@Service("seguimientoAlumnoEjercicioService")
public class SeguimientoAlumnoEjercicioServiceImpl implements SeguimientoAlumnoEjercicioService{
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private SeguimientoAlumnoEjercicioDAO seguimientoAlumnoEjercicioDAO;
	@Override
	public boolean insertar(SeguimientoAlumnoEjercicioBean seguimientoAlumnoEjercicioBean)
			throws ServiceException {
			boolean sw = false;
			try {
				sw = this.getSeguimientoAlumnoEjercicioDAO().insertar(seguimientoAlumnoEjercicioBean);
			} catch (Exception e) {
				sw = false;
				e.printStackTrace();
			}
			return sw;
	}

	@Override
	public boolean actualizar(SeguimientoAlumnoEjercicioBean seguimientoAlumnoEjercicioBean)
			throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getSeguimientoAlumnoEjercicioDAO().actualizar(seguimientoAlumnoEjercicioBean);
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		}
		return sw;
	}

	@Override
	public boolean eliminar(SeguimientoAlumnoEjercicioBean seguimientoAlumnoEjercicioBean)
			throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getSeguimientoAlumnoEjercicioDAO().eliminar(seguimientoAlumnoEjercicioBean);
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		}
		return sw;
	}

	@Override
	public SeguimientoAlumnoEjercicioBean getBuscarPorObjecto(
			SeguimientoAlumnoEjercicioBean seguimientoAlumnoEjercicioBean) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeguimientoAlumnoEjercicioBean> getBuscarPorFiltros(
			SeguimientoAlumnoEjercicioBean seguimientoAlumnoEjercicioBean) throws ServiceException {
		List<SeguimientoAlumnoEjercicioBean> lstSeguimientoAlumnoEjercicioBeans = null;
		try {
			lstSeguimientoAlumnoEjercicioBeans = this.getSeguimientoAlumnoEjercicioDAO().getBuscarPorFiltros(seguimientoAlumnoEjercicioBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstSeguimientoAlumnoEjercicioBeans;
	}
	

	@Override
	public boolean existe(SeguimientoAlumnoEjercicioBean seguimientoAlumnoEjercicioBean)
			throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public SeguimientoAlumnoEjercicioDAO getSeguimientoAlumnoEjercicioDAO() {
		return seguimientoAlumnoEjercicioDAO;
	}

	public void setSeguimientoAlumnoEjercicioDAO(
			SeguimientoAlumnoEjercicioDAO seguimientoAlumnoEjercicioDAO) {
		this.seguimientoAlumnoEjercicioDAO = seguimientoAlumnoEjercicioDAO;
	}
	
	

}
