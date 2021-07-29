package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.Maestra1DAO; 
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;

 
@Service("maestra1Service")
@Transactional (readOnly = true)
public class Maestra1ServiceImp implements Maestra1Service {
	
	@Autowired
	private Maestra1DAO maestra1DAO; 
	

	@Override
	public boolean insertar(MaestraBean maestraBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra1DAO.insertar(maestraBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(MaestraBean maestraBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra1DAO.actualizar(maestraBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(MaestraBean maestraBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra1DAO.eliminar(maestraBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public MaestraBean getBuscarPorObjecto(MaestraBean maestraBean) throws ServiceException {
		MaestraBean oMaestraBean = null;
		try {
			oMaestraBean = maestra1DAO.getBuscarPorObjecto(maestraBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oMaestraBean;
	}
	
	@Override
	public MaestraBean getBuscarPorTablaYRegistro(MaestraBean maestraBean) throws ServiceException {
		MaestraBean oMaestraBean = null;
		try {
			oMaestraBean = maestra1DAO.getBuscarPorTablaYRegistro(maestraBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oMaestraBean;
	}
	

	@Override
	public List<MaestraBean> getBuscarPorFiltros(MaestraBean maestraBean)
			throws ServiceException {
		List<MaestraBean> lstMaestraBean=null;
		try {
			System.out.println("en listado maestra service imp");
			lstMaestraBean=(List<MaestraBean>) maestra1DAO.getBuscarPorFiltros(maestraBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstMaestraBean;
	}

	@Override
	public boolean existe(MaestraBean t) throws ServiceException {
		
		return false;
	}

	@Override
	public List<MaestraBean> listarPorCodigoTabla(String codTabla,long tipo)
			throws  ServiceException { 
		List<MaestraBean> lstMaestraBean=null;
		try { 
			lstMaestraBean=(List<MaestraBean>) maestra1DAO.listarPorCodigoTabla(codTabla,tipo);
		} catch (Exception e) {
			 
		}  
		return lstMaestraBean;
	}
	 
	@Override
	public List<MaestraBean> listarComboGeneral(String codTabla)
			throws  ServiceException { 
		List<MaestraBean> lstMaestraBean=null;
		try { 
			lstMaestraBean=(List<MaestraBean>) maestra1DAO.listarComboGeneral(codTabla);
		} catch (Exception e) {
			 
		}  
		return lstMaestraBean;
	}
	
}
	
	 
