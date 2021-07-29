package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoInstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaNacionalidadBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.AlumnoInstitucionDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.LenguaDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.PersonaLenguaDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoInstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaLenguaService;

 
@Service("alumnoInstitucionService")
@Transactional (readOnly = true)
public class AlumnoInstitucionServiceImp implements AlumnoInstitucionService {
	
	@Autowired
	private AlumnoInstitucionDAO alumnoInstitucionDAO;

	@Override
	public boolean insertar(AlumnoInstitucionBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  alumnoInstitucionDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(AlumnoInstitucionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(AlumnoInstitucionBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  alumnoInstitucionDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public AlumnoInstitucionBean getBuscarPorObjecto(AlumnoInstitucionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlumnoInstitucionBean> getBuscarPorFiltros(AlumnoInstitucionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(AlumnoInstitucionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AlumnoInstitucionBean> getBuscarPorCodigoAlumno(AlumnoInstitucionBean alumnoInstitucionBean)
			throws ServiceException {
		List<AlumnoInstitucionBean> lstAlmacen=null;
		try {
			lstAlmacen=(List<AlumnoInstitucionBean>) alumnoInstitucionDAO.getBuscarPorCodigoAlumno(alumnoInstitucionBean);
		} catch (Exception e) {
			 
		}
		return lstAlmacen;
	} 
	

	
	

}
	
	 
