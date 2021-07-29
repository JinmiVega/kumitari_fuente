package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.AlumnoDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.InscripcionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionService;


 
@Service("alumnoService")
@Transactional (readOnly = true)
public class AlumnoServiceImp implements AlumnoService {
	
	@Autowired
	private AlumnoDAO alumnoDAO; 
	

	@Override
	public boolean insertar(AlumnoBean alumnoBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  alumnoDAO.insertar(alumnoBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(AlumnoBean alumnoBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  alumnoDAO.actualizar(alumnoBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(AlumnoBean alumnoBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  alumnoDAO.eliminar(alumnoBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public AlumnoBean getBuscarPorObjecto(AlumnoBean alumnoBean) throws ServiceException {
		AlumnoBean oAlumnoBean = null;
		try {
			oAlumnoBean = alumnoDAO.getBuscarPorObjecto(alumnoBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oAlumnoBean;
	}

	@Override
	public List<AlumnoBean> getBuscarPorFiltros(AlumnoBean alumnoBean)
			throws ServiceException {
		List<AlumnoBean> lstAlumnoBean=null;
		try {
			System.out.println("en listado Alumno service imp");
			lstAlumnoBean=(List<AlumnoBean>) alumnoDAO.getBuscarPorFiltros(alumnoBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstAlumnoBean;
	}

	@Override
	public boolean existe(AlumnoBean alumnoBean) throws ServiceException {
		
		return false;
	}

	@Override
	public List<AlumnoBean> getBuscarxCodigoInstitucion(AlumnoBean alumnoBean) throws ServiceException {
		List<AlumnoBean> lstAlumnoBean=null;
		try {
			System.out.println("en listado Alumno service imp");
			lstAlumnoBean=(List<AlumnoBean>) alumnoDAO.getBuscarxCodigoInstitucion(alumnoBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstAlumnoBean;
	}
	 
	
}
	
	 
