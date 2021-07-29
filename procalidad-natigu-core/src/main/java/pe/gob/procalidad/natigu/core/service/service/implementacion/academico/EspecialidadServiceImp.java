package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EspecialidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.AlumnoDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.EspecialidadDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.InscripcionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.EspecialidadService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionService;


 
@Service("especialidadService")
@Transactional (readOnly = true)
public class EspecialidadServiceImp implements EspecialidadService {
	
	@Autowired
	private EspecialidadDAO especialidadDAO; 
	

	@Override
	public boolean insertar(EspecialidadBean especialidadBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  especialidadDAO.insertar(especialidadBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(EspecialidadBean especialidadBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  especialidadDAO.actualizar(especialidadBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(EspecialidadBean especialidadBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  especialidadDAO.eliminar(especialidadBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public EspecialidadBean getBuscarPorObjecto(EspecialidadBean especialidadBean) throws ServiceException {
		EspecialidadBean oEspecialidadBean = null;
		try {
			oEspecialidadBean = especialidadDAO.getBuscarPorObjecto(especialidadBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oEspecialidadBean;
	}

	@Override
	public List<EspecialidadBean> getBuscarPorFiltros(EspecialidadBean especialidadBean)
			throws ServiceException {
		/*
		List<EspecialidadBean> lstEspecialidadBean=null;
		try {
			System.out.println("en listado Alumno service imp");
			lstEspecialidadBean=(List<EspecialidadBean>) especialidadDAO.getBuscarPorFiltros(especialidadBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 */
		return null;
	}

	@Override
	public boolean existe(EspecialidadBean especialidadBean) throws ServiceException {
		
		return false;
	}

	@Override
	public List<EspecialidadBean> listarPorCodigoDocente(DocenteBean docenteBean) throws ServiceException {
		List<EspecialidadBean> lstEspecialidadBean=null;
		try {
			System.out.println("especialidadDAO....!");
			lstEspecialidadBean=(List<EspecialidadBean>) especialidadDAO.listarPorCodigoDocente(docenteBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstEspecialidadBean;
	}
	 
	
}
	
	 
