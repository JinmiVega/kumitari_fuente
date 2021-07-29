package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraciBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.ArrastraOraciDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.ArrastraOraciService;

@Service("arrastraOraciService")
@Transactional (readOnly = true)
public class ArrastraOraciServiceImpl implements ArrastraOraciService{

	@Autowired
	private ArrastraOraciDAO oracionCompletardao;
	
	public ArrastraOraciDAO getArrastraOracidao() {
		return oracionCompletardao;
	}

	@Override
	public boolean insertar(ArrastraOraciBean arrastraOraciBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getArrastraOracidao().insertar(arrastraOraciBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(ArrastraOraciBean oracionCompletarBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getArrastraOracidao().actualizar(oracionCompletarBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(ArrastraOraciBean oracionCompletarBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = getArrastraOracidao().eliminar(oracionCompletarBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public ArrastraOraciBean getBuscarPorObjecto(ArrastraOraciBean oracionCompletarBean) throws ServiceException {
		ArrastraOraciBean bean = null;
		try {
			bean = getArrastraOracidao().getBuscarPorObjecto(oracionCompletarBean);
		}catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public  ArrastraOraciBean  getBuscarPorTEM(ArrastraOraciBean arrastraOraciBean) throws ServiceException {
		ArrastraOraciBean bean = null;
		try {
			bean = getArrastraOracidao().getBuscarPorTEM(arrastraOraciBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public boolean existe(ArrastraOraciBean oracionCompletarBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ArrastraOraciBean> getBuscarPorFiltros(ArrastraOraciBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
