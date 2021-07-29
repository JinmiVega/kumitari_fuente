package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraEncerradaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.TextoPalabraCorrectaDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.TextoPalabraEncerradaDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.TextoPalabraCorrectaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.TextoPalabraEncerradaService;

@Service("textoPalabraEncerradaService")
@Transactional (readOnly = true)
public class TextoPalabraEncerradaServiceImpl implements TextoPalabraEncerradaService {

	@Autowired
	private TextoPalabraEncerradaDAO textoPalabraEncerradaDAO;

	@Override
	public boolean insertar(TextoPalabraEncerradaBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = textoPalabraEncerradaDAO.insertar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(TextoPalabraEncerradaBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = textoPalabraEncerradaDAO.actualizar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(TextoPalabraEncerradaBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = textoPalabraEncerradaDAO.eliminar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public TextoPalabraEncerradaBean getBuscarPorObjecto(TextoPalabraEncerradaBean t) throws ServiceException {
		TextoPalabraEncerradaBean bean = null;
		try {
			bean = textoPalabraEncerradaDAO.getBuscarPorObjecto(t);
		}catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<TextoPalabraEncerradaBean> getBuscarPorFiltros(TextoPalabraEncerradaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(TextoPalabraEncerradaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TextoPalabraEncerradaBean getBuscarPorTEM(TextoPalabraEncerradaBean textoPalabraEncerradaBean)
			throws ServiceException {
		TextoPalabraEncerradaBean bean = null;
		try {
			bean = textoPalabraEncerradaDAO.getBuscarPorTEM(textoPalabraEncerradaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	
	
	
}
