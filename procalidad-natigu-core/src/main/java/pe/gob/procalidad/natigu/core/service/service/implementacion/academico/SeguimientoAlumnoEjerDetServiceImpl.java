package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumnoEjerDetBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumnoEjercicioBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.SeguimientoAlumnoEjerDetDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.SeguimientoAlumnoEjercicioDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.SeguimientoAlumnoEjerDetService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.SeguimientoAlumnoEjercicioService;
@Transactional(readOnly = true)
@Service("seguimientoAlumnoEjerDetService")
public class SeguimientoAlumnoEjerDetServiceImpl implements SeguimientoAlumnoEjerDetService{
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private SeguimientoAlumnoEjerDetDAO seguimientoAlumnoEjerDetDAO;
	@Override
	public boolean insertar(SeguimientoAlumnoEjerDetBean seguimientoAlumnoEjercicioBean)
			throws ServiceException {
			boolean sw = false;
			try {
				sw = this.getSeguimientoAlumnoEjerDetDAO().insertar(seguimientoAlumnoEjercicioBean);
			} catch (Exception e) {
				sw = false;
				e.printStackTrace();
			}
			return sw;
	}

 

 

	@Override
	public boolean actualizar(SeguimientoAlumnoEjerDetBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(SeguimientoAlumnoEjerDetBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SeguimientoAlumnoEjerDetBean getBuscarPorObjecto(
			SeguimientoAlumnoEjerDetBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeguimientoAlumnoEjerDetBean> getBuscarPorFiltros(
			SeguimientoAlumnoEjerDetBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(SeguimientoAlumnoEjerDetBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}





	public SeguimientoAlumnoEjerDetDAO getSeguimientoAlumnoEjerDetDAO() {
		return seguimientoAlumnoEjerDetDAO;
	}





	public void setSeguimientoAlumnoEjerDetDAO(
			SeguimientoAlumnoEjerDetDAO seguimientoAlumnoEjerDetDAO) {
		this.seguimientoAlumnoEjerDetDAO = seguimientoAlumnoEjerDetDAO;
	}
	
	

}
