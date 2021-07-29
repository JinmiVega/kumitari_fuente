package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumnoLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaUnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.SeguimientoAlumnoLenguaDAO; 
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.SeguimientoAlumnoLenguaService; 


@Service("seguimientoAlumnoLenguaService")
@Transactional (readOnly = true)
public class SeguimientoAlumnoLenguaServiceImp implements SeguimientoAlumnoLenguaService {

	@Autowired
	private SeguimientoAlumnoLenguaDAO seguimientoAlumnoLenguaDAO;
	
	@Override
	public boolean insertar(SeguimientoAlumnoLenguaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  seguimientoAlumnoLenguaDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	
	@Override
	public boolean insertar_sigLec(SeguimientoAlumnoLenguaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  seguimientoAlumnoLenguaDAO.insertar_sigLec(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}
	
	
	@Override
	public boolean actualizar(SeguimientoAlumnoLenguaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(SeguimientoAlumnoLenguaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  seguimientoAlumnoLenguaDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public SeguimientoAlumnoLenguaBean getBuscarPorObjecto(SeguimientoAlumnoLenguaBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeguimientoAlumnoLenguaBean> getBuscarPorFiltros(SeguimientoAlumnoLenguaBean t)
			throws ServiceException {
		List<SeguimientoAlumnoLenguaBean> lstSeguimientoAlumnoLenguaBean=null;
		try {
			System.out.println("en listado SeguimientoAlumnoLenguaBean service imp");
			lstSeguimientoAlumnoLenguaBean=(List<SeguimientoAlumnoLenguaBean>) seguimientoAlumnoLenguaDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstSeguimientoAlumnoLenguaBean;
	}

	@Override
	public boolean existe(SeguimientoAlumnoLenguaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LenguaEstructuraBean> listarSubNivel(SeguimientoAlumnoLenguaBean seguimientoAlumnoLenguaBean)
			throws ServiceException {
		List<LenguaEstructuraBean> lstLenguaEstructuraBean=null;
		try {
			System.out.println("en listado listarSubNivel service imp");
			lstLenguaEstructuraBean=(List<LenguaEstructuraBean>) seguimientoAlumnoLenguaDAO.listarSubNivel(seguimientoAlumnoLenguaBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstLenguaEstructuraBean;
	}

	@Override
	public List<UnidadBean> listarUnidad(SeguimientoAlumnoLenguaBean seguimientoAlumnoLenguaBean)
			throws ServiceException {
		List<UnidadBean> lstLenguaEstructuraBean=null;
		try {
			System.out.println("en listado LenguaUnidadBean service imp");
			lstLenguaEstructuraBean=(List<UnidadBean>) seguimientoAlumnoLenguaDAO.listarUnidad(seguimientoAlumnoLenguaBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstLenguaEstructuraBean;
	}

	@Override
	public List<UnidadLeccionBean> listarLeccion(SeguimientoAlumnoLenguaBean seguimientoAlumnoLenguaBean)
			throws ServiceException {
		List<UnidadLeccionBean> lstLenguaEstructuraBean=null;
		try {
			System.out.println("en listado UnidadLeccionBean service imp");
			lstLenguaEstructuraBean=(List<UnidadLeccionBean>) seguimientoAlumnoLenguaDAO.listarLeccion(seguimientoAlumnoLenguaBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstLenguaEstructuraBean;
	}
 
	 
}
