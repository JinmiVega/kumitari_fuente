package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.InscripcionDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.InscripcionLenguaDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionLenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionService;


 
@Service("inscripcionLenguaService")
@Transactional (readOnly = true)
public class InscripcionLenguaServiceImp implements InscripcionLenguaService {
	
	@Autowired
	private InscripcionLenguaDAO institucionDAO; 
	

	@Override
	public boolean insertar(InscripcionLenguaBean  inscripcionBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  institucionDAO.insertar(inscripcionBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(InscripcionLenguaBean inscripcionBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  institucionDAO.actualizar(inscripcionBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(InscripcionLenguaBean inscripcionBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  institucionDAO.eliminar(inscripcionBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public InscripcionLenguaBean getBuscarPorObjecto(InscripcionLenguaBean inscripcionBean) throws ServiceException {
		InscripcionLenguaBean oInscripcionBean = null;
		try {
			oInscripcionBean = institucionDAO.getBuscarPorObjecto(inscripcionBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oInscripcionBean;
	}

	@Override
	public List<InscripcionLenguaBean> getBuscarPorFiltros(InscripcionLenguaBean inscripcionBean)
			throws ServiceException {
		List<InscripcionLenguaBean> lstInscripcionBean=null;
		try {
			System.out.println("en listado Institucion service imp");
			lstInscripcionBean=(List<InscripcionLenguaBean>) institucionDAO.getBuscarPorFiltros(inscripcionBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstInscripcionBean;
	}

	@Override
	public boolean existe(InscripcionLenguaBean t) throws ServiceException {
		
		return false;
	}

	@Override
	public List<InscripcionLenguaBean> listarInscripcionLengua(InscripcionLenguaBean inscripcionLenguaBean)
			throws ServerException {
		List<InscripcionLenguaBean> lstInscripcionBean=null;
		try {
			System.out.println("en listado Institucion service imp");
			lstInscripcionBean=(List<InscripcionLenguaBean>) institucionDAO.listarInscripcionLengua(inscripcionLenguaBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstInscripcionBean;
	}
			
			@Override
			public List<InscripcionLenguaBean> listarInscripcionLenguaxNombre(InscripcionLenguaBean inscripcionLenguaBean)
					throws ServerException {
				List<InscripcionLenguaBean> lstInscripcionBean=null;
				try {
					System.out.println("en listarInscripcionLenguaxNombre service imp");
					lstInscripcionBean=(List<InscripcionLenguaBean>) institucionDAO.listarInscripcionLenguaxNombre(inscripcionLenguaBean);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
				 
				return lstInscripcionBean;
			}		
			
	@Override
	public InscripcionLenguaBean getBuscarPorObjectoDetalleMatricula(InscripcionLenguaBean inscripcionLenguaBean) throws ServerException {
		InscripcionLenguaBean oInscripcionBean = null;
		try {
			oInscripcionBean = institucionDAO.getBuscarPorObjectoDetalleMatricula(inscripcionLenguaBean);
		} catch (Exception e) {
			
		}
		return oInscripcionBean;
	}

	@Override
	public boolean updatenumcupos(InscripcionLenguaBean inscripcionLenguaBean) throws ServerException {
		Boolean sw = false;
		try {
			sw =  institucionDAO.updatenumcupos(inscripcionLenguaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

//	@Override
//	public boolean actualizarNumCuposDisp(InscripcionLenguaBean inscripcionLenguaBean) throws ServerException {
//		Boolean sw = false;
//		try {
//			sw =  institucionDAO.actualizarNumCuposDisp(inscripcionLenguaBean);
//			
//		} catch (DAOException e) { 
//			e.printStackTrace();
//		}
//		return sw;
//	}
	@Override
	public List<InscripcionLenguaBean> listarMatriculasHechas(MatriculaAlumnoBean matriculaAlumnoBean, InscripcionLenguaBean inscripcionLenguaBean)
			throws ServerException {
		List<InscripcionLenguaBean> lstInscripcionBean=null;
		try {
			System.out.println("en listado Institucion service imp");
			lstInscripcionBean=(List<InscripcionLenguaBean>) institucionDAO.listarMatriculasHechas(matriculaAlumnoBean, inscripcionLenguaBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstInscripcionBean;
	}
	 
	
}
	
	 
