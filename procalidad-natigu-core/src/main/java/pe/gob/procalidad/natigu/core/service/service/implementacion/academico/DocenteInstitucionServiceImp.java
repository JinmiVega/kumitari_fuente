package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteInstitucionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.DocenteInstitucionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.DocenteInstitucionService;

 
@Service("docenteInstitucionService")
@Transactional (readOnly = true)
public class DocenteInstitucionServiceImp implements DocenteInstitucionService {
	
	@Autowired
	private DocenteInstitucionDAO docenteDAO; 
	

	@Override
	public boolean insertar(DocenteInstitucionBean docenteBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  docenteDAO.insertar(docenteBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(DocenteInstitucionBean docenteBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  docenteDAO.actualizar(docenteBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(DocenteInstitucionBean docenteBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  docenteDAO.eliminar(docenteBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public DocenteInstitucionBean getBuscarPorObjecto(DocenteInstitucionBean docenteBean) throws ServiceException {
		DocenteInstitucionBean oDocenteInstitucionBean = null;
		try {
			oDocenteInstitucionBean = docenteDAO.getBuscarPorObjecto(docenteBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oDocenteInstitucionBean;
	}

	@Override
	public List<DocenteInstitucionBean> getBuscarPorFiltros(DocenteInstitucionBean docenteBean)
			throws ServiceException {
		List<DocenteInstitucionBean> lstDocenteInstitucionBean=null;
		try {
			System.out.println("en listado lengua service imp");
			lstDocenteInstitucionBean=(List<DocenteInstitucionBean>) docenteDAO.getBuscarPorFiltros(docenteBean);
		} catch (Exception e) {
			 
		} 
		 
		return lstDocenteInstitucionBean;
	}
	
	

	@Override
	public boolean existe(DocenteInstitucionBean docenteBean) throws ServiceException {
		Boolean sw = true;
		try {
			sw =  docenteDAO.existe(docenteBean) ;
		} catch (DAOException e) { 
		}
		return sw;
	}
 
}
	
	 
