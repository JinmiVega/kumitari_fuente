package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionSedeBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.LeccionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LeccionMaterialBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.LeccionMaterialDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LeccionMaterialService;

@Service("leccionMaterialService")
@Transactional (readOnly = true)
public class LeccionMaterialServiceImpl implements LeccionMaterialService {

	@Autowired
	private LeccionMaterialDAO leccionMaterialDAO;
	
	@Override
	public boolean insertar(LeccionMaterialBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw = leccionMaterialDAO.insertar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(LeccionMaterialBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw = leccionMaterialDAO.actualizar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}
	
	public boolean actualizarOrden(LeccionMaterialBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw = leccionMaterialDAO.actualizarOrden(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(LeccionMaterialBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw = leccionMaterialDAO.eliminar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public LeccionMaterialBean getBuscarPorObjecto(LeccionMaterialBean t) throws ServiceException {
		LeccionMaterialBean oLeccionMaterialBean = null;
		try {
			oLeccionMaterialBean = this.leccionMaterialDAO.getBuscarPorObjecto(t);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return oLeccionMaterialBean;
	}

	@Override
	public List<LeccionMaterialBean> getBuscarPorFiltros(LeccionMaterialBean t) throws ServiceException {
		List<LeccionMaterialBean> lstLeccionMaterialBean = null;
		try 
		{
			lstLeccionMaterialBean = leccionMaterialDAO.getBuscarPorFiltros(t);
		} 
		catch (DAOException e) 
		{
			e.printStackTrace();
		}
		return lstLeccionMaterialBean;
	}

	@Override
	public boolean existe(LeccionMaterialBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LeccionMaterialBean> buscarPorLeccion(LeccionMaterialBean materialBean) throws ServiceException {
		List<LeccionMaterialBean> lstLeccionMaterialBean = null;
		try 
		{
			lstLeccionMaterialBean = leccionMaterialDAO.buscarPorLeccion(materialBean);
		} 
		catch (DAOException e) 
		{
			e.printStackTrace();
		}
		return lstLeccionMaterialBean;
	}

}
