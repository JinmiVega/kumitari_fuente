package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.InscripcionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionService;


 
@Service("inscripcionService")
@Transactional (readOnly = true)
public class InscripcionServiceImp implements InscripcionService {
	
	@Autowired
	private InscripcionDAO institucionDAO; 
	

	@Override
	public boolean insertar(InscripcionBean inscripcionBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  institucionDAO.insertar(inscripcionBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(InscripcionBean inscripcionBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  institucionDAO.actualizar(inscripcionBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(InscripcionBean inscripcionBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  institucionDAO.eliminar(inscripcionBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public InscripcionBean getBuscarPorObjecto(InscripcionBean inscripcionBean) throws ServiceException {
		InscripcionBean oInscripcionBean = null;
		try {
			oInscripcionBean = institucionDAO.getBuscarPorObjecto(inscripcionBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oInscripcionBean;
	}

	@Override
	public List<InscripcionBean> getBuscarPorFiltros(InscripcionBean inscripcionBean)
			throws ServiceException {
		List<InscripcionBean> lstInscripcionBean=null;
		try {
			System.out.println("en listado Institucion service imp");
			lstInscripcionBean=(List<InscripcionBean>) institucionDAO.getBuscarPorFiltros(inscripcionBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstInscripcionBean;
	}
			
	@Override
			public List<InscripcionBean> getBuscarPorFiltrosxperfil(InscripcionBean inscripcion, UsuarioBean usu)
					throws ServiceException {
				List<InscripcionBean> lstInscripcionBean=null;
				try {
					System.out.println("en listado getBuscarPorFiltrosxperfil service imp");
					lstInscripcionBean=(List<InscripcionBean>) institucionDAO.getBuscarPorFiltrosxperfil(inscripcion,usu);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
				 
				return lstInscripcionBean;
			}				
			
	@Override
	public boolean existe(InscripcionBean t) throws ServiceException {
		
		return false;
	}
	
	@Override
	public InscripcionBean getNumcuposXcodInstiCodLengua(InscripcionBean inscripcionBean) throws ServiceException {
		InscripcionBean oInscripcionBean = null;
		try {
			oInscripcionBean = institucionDAO.getNumcuposXcodInstiCodLengua(inscripcionBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oInscripcionBean;

	} 
	 
	
}
	
	 
