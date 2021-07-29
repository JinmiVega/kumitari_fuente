package pe.gob.procalidad.natigu.core.service.service.implementacion.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

 



import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
 
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.MascotaDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.MascotaService;
 

 
@Service("mascotaService")
@Transactional (readOnly = true)
public class MascotaServiceImp implements MascotaService {
	
	@Autowired
	private MascotaDAO mascotaDAO; 
	

	@Override
	public boolean insertar(MascotaBean mascotaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  mascotaDAO.insertar(mascotaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(MascotaBean mascotaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  mascotaDAO.actualizar(mascotaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(MascotaBean mascotaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  mascotaDAO.eliminar(mascotaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public MascotaBean getBuscarPorObjecto(MascotaBean mascotaBean) throws ServiceException {
		MascotaBean oMascotaBean = null;
		try {
			oMascotaBean = mascotaDAO.getBuscarPorObjecto(mascotaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oMascotaBean;
	}

	@Override
	public List<MascotaBean> getBuscarPorFiltros(MascotaBean mascotaBean)
			throws ServiceException {
		List<MascotaBean> lstMascotaBean=null;
		try {
			System.out.println("en listado mascota service imp");
			lstMascotaBean=(List<MascotaBean>) mascotaDAO.getBuscarPorFiltros(mascotaBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstMascotaBean;
	}
	
	@Override
	public List<MascotaBean> getBuscarPorFiltrosAlumno(MascotaBean mascotaBean)
			throws ServiceException {
		List<MascotaBean> lstMascotaBean=null;
		try {
			System.out.println("en listado mascota service imp");
			lstMascotaBean=(List<MascotaBean>) mascotaDAO.getBuscarPorFiltrosAlumno(mascotaBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstMascotaBean;
	}
	
	@Override
	public List<MascotaBean> getBuscarPorTiendaAlumno(MascotaBean mascotaBean)
			throws ServiceException {
		List<MascotaBean> lstMascotaBean=null;
		try { 
			lstMascotaBean=(List<MascotaBean>) mascotaDAO.getBuscarPorTiendaAlumno(mascotaBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstMascotaBean;
	}

	@Override
	public boolean existe(MascotaBean t) throws ServiceException {
		
		return false;
	}

	@Override
	public MascotaBean getlistarMasctoSwPredetAlumno(MascotaBean mascotaBean) throws ServiceException {
		MascotaBean oMascotaBean = null;
		try {
			oMascotaBean = mascotaDAO.getlistarMasctoSwPredetAlumno(mascotaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oMascotaBean;
	}

	@Override
	public MascotaBean getlistarMasctoSwPredetSist(MascotaBean mascotaBean) throws ServiceException {
		MascotaBean oMascotaBean = null;
		try {
			oMascotaBean = mascotaDAO.getlistarMasctoSwPredetSist(mascotaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oMascotaBean;
	}
	 
	
}
	
	 
