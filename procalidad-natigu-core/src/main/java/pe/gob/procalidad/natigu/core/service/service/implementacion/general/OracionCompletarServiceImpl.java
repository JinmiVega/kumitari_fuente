package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionCompletarBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.OracionCompletarDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.OracionCompletarService;

@Service("oracionCompletarService")
@Transactional (readOnly = true)
public class OracionCompletarServiceImpl implements OracionCompletarService{

	@Autowired
	private OracionCompletarDAO oracionCompletardao;
	
	public OracionCompletarDAO getOracionCompletardao() {
		return oracionCompletardao;
	}

	@Override
	public boolean insertar(OracionCompletarBean oracionCompletarBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getOracionCompletardao().insertar(oracionCompletarBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(OracionCompletarBean oracionCompletarBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getOracionCompletardao().actualizar(oracionCompletarBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(OracionCompletarBean oracionCompletarBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getOracionCompletardao().eliminar(oracionCompletarBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public OracionCompletarBean getBuscarPorObjecto(OracionCompletarBean oracionCompletarBean) throws ServiceException {
		OracionCompletarBean bean = null;
		try {
			bean = getOracionCompletardao().getBuscarPorObjecto(oracionCompletarBean);
		}catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public  OracionCompletarBean  getBuscarPorTEM(OracionCompletarBean oracionCompletarBean) throws ServiceException {
		OracionCompletarBean bean = null;
		try {
			bean = getOracionCompletardao().getBuscarPorTEM(oracionCompletarBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public boolean existe(OracionCompletarBean oracionCompletarBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OracionCompletarBean> getBuscarPorFiltros(OracionCompletarBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
