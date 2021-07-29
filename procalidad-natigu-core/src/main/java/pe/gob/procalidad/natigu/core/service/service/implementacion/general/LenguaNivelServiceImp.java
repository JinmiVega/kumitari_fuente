package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaNivelBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException; 
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.LenguaNivelDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaEstructuraService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaNivelService; 

 
@Service("lenguaNivelService")
@Transactional (readOnly = true)
public class LenguaNivelServiceImp implements LenguaNivelService {
	
	@Autowired
	private LenguaNivelDAO lenguaEstructuraDAO; 
	

	@Override
	public boolean insertar(LenguaNivelBean lenguaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  lenguaEstructuraDAO.insertar(lenguaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(LenguaNivelBean lenguaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  lenguaEstructuraDAO.actualizar(lenguaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(LenguaNivelBean lenguaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  lenguaEstructuraDAO.eliminar(lenguaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public LenguaNivelBean getBuscarPorObjecto(LenguaNivelBean lenguaBean) throws ServiceException {
		LenguaNivelBean oLenguaNivelBean = null;
		try {
			oLenguaNivelBean = lenguaEstructuraDAO.getBuscarPorObjecto(lenguaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oLenguaNivelBean;
	}

	@Override
	public List<LenguaNivelBean> getBuscarPorFiltros(LenguaNivelBean lengua)
			throws ServiceException {
		List<LenguaNivelBean> lstAlmacen=null;
		try {
			System.out.println("en listado lengua service imp");
			lstAlmacen=(List<LenguaNivelBean>) lenguaEstructuraDAO.getBuscarPorFiltros(lengua);
		} catch (Exception e) {
			 
		} 
		 
		return lstAlmacen;
	}

	@Override
	public boolean existe(LenguaNivelBean t) throws ServiceException {
		Boolean sw = true;
		try {
			sw =  lenguaEstructuraDAO.existe(t) ;
		} catch (DAOException e) { 
		}
		return sw;
	}

	@Override
	public List<LenguaNivelBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws ServiceException {
		List<LenguaNivelBean> lstAlmacen=null;
		try {
			System.out.println("en listado lengua listarPorCodigoLengua imp");
			lstAlmacen=(List<LenguaNivelBean>) lenguaEstructuraDAO.listarPorCodigoLengua(lenguaBean);
		} catch (Exception e) {
			 
		} 
		 
		return lstAlmacen;
	}

	 
}
	
	 
