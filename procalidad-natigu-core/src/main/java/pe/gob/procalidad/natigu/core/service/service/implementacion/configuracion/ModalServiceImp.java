package pe.gob.procalidad.natigu.core.service.service.implementacion.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.ModalBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.ModalDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.ModalService;





@Service("modalService")
@Transactional (readOnly = true)
public class ModalServiceImp implements ModalService {
	
	@Autowired
	private ModalDAO modalDAO; 


	@Override
	public boolean insertar(ModalBean modalBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  modalDAO.insertar(modalBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(ModalBean modalBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  modalDAO.actualizar(modalBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(ModalBean modalBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  modalDAO.eliminar(modalBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public ModalBean getBuscarPorObjecto(ModalBean modalBean) throws ServiceException {
		ModalBean oModalBean = null;
		try {
			oModalBean = modalDAO.getBuscarPorObjecto(modalBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oModalBean;
	}
	@Override
	public List<ModalBean> getBuscarPorFiltros(ModalBean modalBean)
			throws ServiceException {
		List<ModalBean> lstModalBean=null;
		try {
			System.out.println("en listado modal service imp");
			lstModalBean=(List<ModalBean>) modalDAO.getBuscarPorFiltros(modalBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstModalBean;
	}

	@Override
	public boolean existe(ModalBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
