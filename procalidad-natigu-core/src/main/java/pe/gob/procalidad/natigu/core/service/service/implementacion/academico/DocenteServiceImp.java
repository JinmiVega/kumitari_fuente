package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionDocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonalBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.AlumnoDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.DocenteDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.InscripcionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.DocenteService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionService;


 
@Service("docenteService")
@Transactional (readOnly = true)
public class DocenteServiceImp implements DocenteService {
	
	@Autowired
	private DocenteDAO docenteDAO; 
	

	@Override
	public boolean insertar(DocenteBean docenteBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  docenteDAO.insertar(docenteBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(DocenteBean docenteBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  docenteDAO.actualizar(docenteBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(DocenteBean docenteBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  docenteDAO.eliminar(docenteBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public DocenteBean getBuscarPorObjecto(DocenteBean docenteBean) throws ServiceException {
		DocenteBean oDocenteBean = null;
		try {
			oDocenteBean = docenteDAO.getBuscarPorObjecto(docenteBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oDocenteBean;
	}

	@Override
	public List<DocenteBean> getBuscarPorFiltros(DocenteBean docenteBean)
			throws ServiceException {
		List<DocenteBean> lstDocenteBean=null;
		try {
			System.out.println("en listado lengua service imp");
			lstDocenteBean=(List<DocenteBean>) docenteDAO.getBuscarPorFiltros(docenteBean);
		} catch (Exception e) {
			 
		} 
		 
		return lstDocenteBean;
	}
	
	

	@Override
	public boolean existe(DocenteBean docenteBean) throws ServiceException {
		
		return false;
	}

	@Override
	public List<DocenteBean> getBuscarxCodigoInstitucion(DocenteBean docenteBean) throws ServiceException {
		List<DocenteBean> lstDocenteBean=null;
		try {

			lstDocenteBean = docenteDAO.getBuscarxCodigoInstitucion(docenteBean);
		} catch (Exception e) {
			 
		} 
		 
		return lstDocenteBean;
	}

	@Override
	public List<DocenteBean> getBuscarXInstitucionNombreNumeroDocumentoTipoDocumento(
			InscripcionDocenteBean docenteBean) throws DAOException {
		List<DocenteBean> lstDocenteBean=null;
		try {
			System.out.println("en listado lengua service imp");
			lstDocenteBean=(List<DocenteBean>) docenteDAO.getBuscarXInstitucionNombreNumeroDocumentoTipoDocumento(docenteBean);
		} catch (Exception e) {
			 
		} 
		 
		return lstDocenteBean;
	}

	@Override
	public List<DocenteBean> listarDocenteXCodigoInstitucionYCodigoLengua(
			MatriculaBean matriculaBean) throws ServiceException {
		List<DocenteBean> lstDocenteBean=null;
		try {
			System.out.println("en listado docente	");
			lstDocenteBean=(List<DocenteBean>) docenteDAO.listarDocenteXCodigoInstitucionYCodigoLengua(matriculaBean);
		} catch (Exception e) {
			 
		} 
		 
		return lstDocenteBean;
	}

	@Override
	public DocenteBean getBuscarxdni(DocenteBean docenteBean)
			throws ServiceException {
		DocenteBean oDocenteBean = null;
		try {
			oDocenteBean = docenteDAO.getBuscarxdni(docenteBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oDocenteBean;
	}
	
	@Override
	public List<DocenteBean> getBuscarPorNumeroDocumento(DocenteBean docenteBean)
			throws ServiceException {
		List<DocenteBean> lstDocenteBean=null;
		try {
			System.out.println("en listado lengua service imp");
			lstDocenteBean=(List<DocenteBean>) docenteDAO.getBuscarPorNumeroDocumento(docenteBean);
		} catch (Exception e) {
			 
		} 
		 
		return lstDocenteBean;
	}

	@Override
	public List<DocenteBean> getBuscarxCodigoInstitucionDetalleNombreDocum(DocenteBean docenteBean)
			throws ServiceException {
		List<DocenteBean> lstDocenteBean=null;
		try {

			lstDocenteBean = docenteDAO.getBuscarxCodigoInstitucionDetalleNombreDocum(docenteBean);
		} catch (Exception e) {
			 
		} 
		 
		return lstDocenteBean;
	}

	@Override
	public DocenteBean getBuscar_por_codigopersona(PersonaBean personaBean) throws ServiceException {
		DocenteBean oDocenteBean = null;
		try {
			oDocenteBean = docenteDAO.getBuscar_por_codigopersona(personaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oDocenteBean;
	}

	 
	
}
	
	 
