package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.ArmarDocumentoBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.ArmarDocumentoCabBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.ArmarDocumentoCabDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.ArmarDocumentoDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.ArmarDocumentoService;

@Service("armarDocumentoService")
@Transactional (readOnly = true)
public class ArmarDocumentoServiceImpl  implements ArmarDocumentoService  {

	@Autowired
	private ArmarDocumentoDAO armarDocDAO;
	
	public ArmarDocumentoDAO getArmarDocDAO() {
		return armarDocDAO;
	}

	@Override
	public boolean insertar(ArmarDocumentoBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = armarDocDAO.insertar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(ArmarDocumentoBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = armarDocDAO.actualizar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(ArmarDocumentoBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = armarDocDAO.eliminar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public ArmarDocumentoBean getBuscarPorObjecto(ArmarDocumentoBean t) throws ServiceException {
		ArmarDocumentoBean armarDocBean = null;
		try {
			armarDocBean = armarDocDAO.getBuscarPorObjecto(t);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return armarDocBean;
	}

	@Override
	public List<ArmarDocumentoBean> getBuscarPorFiltros(ArmarDocumentoBean t) throws ServiceException {
		List<ArmarDocumentoBean> armarDocBean = null;
		try {
			armarDocBean = armarDocDAO.getBuscarPorFiltros(t);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return armarDocBean;
	}

	@Override
	public boolean existe(ArmarDocumentoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ArmarDocumentoBean> listarArmarDocuCabDetTodo(ArmarDocumentoBean armarDocumentoBean)
			throws ServiceException {
		List<ArmarDocumentoBean> listaArmarDocBean = null;
		try {
			listaArmarDocBean = armarDocDAO.listarArmarDocuCabDetTodo(armarDocumentoBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return listaArmarDocBean;
	}

}