package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.ArmarDocumentoCabBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.ArmarDocumentoCabDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.ArmarDocumentoCabService;
@Service("armarDocCabService")
@Transactional (readOnly = true)
public class ArmarDocumentoCabServiceImpl implements ArmarDocumentoCabService{

	@Autowired
	private ArmarDocumentoCabDAO armarDocCabDAO;
	
	public ArmarDocumentoCabDAO getArmarDocCabDAO() {
		return armarDocCabDAO;
	}


	@Override
	public boolean insertar(ArmarDocumentoCabBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = armarDocCabDAO.insertar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(ArmarDocumentoCabBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = armarDocCabDAO.actualizar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(ArmarDocumentoCabBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = armarDocCabDAO.eliminar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public ArmarDocumentoCabBean getBuscarPorObjecto(ArmarDocumentoCabBean t) throws ServiceException {
		ArmarDocumentoCabBean armarDocCabnBean = null;
		try {
			armarDocCabnBean = armarDocCabDAO.getBuscarPorObjecto(t);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return armarDocCabnBean;
	}

	@Override
	public List<ArmarDocumentoCabBean> getBuscarPorFiltros(ArmarDocumentoCabBean t) throws ServiceException {
		List<ArmarDocumentoCabBean> armarDocCabnBean = null;
		try {
			armarDocCabnBean = armarDocCabDAO.getBuscarPorFiltros(t);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return armarDocCabnBean;
	}

	@Override
	public boolean existe(ArmarDocumentoCabBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
