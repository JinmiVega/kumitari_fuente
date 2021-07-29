package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.AlterTextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.AlterTextoPalabraEncerradaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionAlterBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraEncerradaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.AlterTextoPalabraCorrectaDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.AlterTextoPalabraEncerradaDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.AlterTextoPalabraCorrectaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.AlterTextoPalabraEncerradaService;

@Service("alterTextoPalabraEncerradaService")
@Transactional (readOnly = true)
public class AlterTextoPalabraEncerradaServiceImpl implements AlterTextoPalabraEncerradaService{

	@Autowired
	private AlterTextoPalabraEncerradaDAO alterTextoPalabraEncerradaDAO;

	@Override
	public boolean insertar(AlterTextoPalabraEncerradaBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = alterTextoPalabraEncerradaDAO.insertar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(AlterTextoPalabraEncerradaBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = alterTextoPalabraEncerradaDAO.actualizar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(AlterTextoPalabraEncerradaBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = alterTextoPalabraEncerradaDAO.eliminar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public AlterTextoPalabraEncerradaBean getBuscarPorObjecto(AlterTextoPalabraEncerradaBean t)
			throws ServiceException {
		AlterTextoPalabraEncerradaBean bean = null;
		try 
		{
			bean = alterTextoPalabraEncerradaDAO.getBuscarPorObjecto(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<AlterTextoPalabraEncerradaBean> getBuscarPorFiltros(AlterTextoPalabraEncerradaBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(AlterTextoPalabraEncerradaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AlterTextoPalabraEncerradaBean> buscarPorCodigoOracion(
			TextoPalabraEncerradaBean textoPalabraEncerradaBean) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlterTextoPalabraEncerradaBean> getBuscarPorTextoPalabraCorrecta(AlterTextoPalabraEncerradaBean alterTextoPalabraEncerradaBean) throws ServiceException {
		List<AlterTextoPalabraEncerradaBean> lstBean = null;
		try {
			lstBean = this.alterTextoPalabraEncerradaDAO.getBuscarPorTextoPalabraCorrecta(alterTextoPalabraEncerradaBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstBean;
	}

	@Override
	public AlterTextoPalabraEncerradaBean buscarxPalabraxTexto(AlterTextoPalabraEncerradaBean alterTextoPalabraEncerradaBean) throws ServiceException {
		AlterTextoPalabraEncerradaBean lst = null;
		try {
			lst = alterTextoPalabraEncerradaDAO.buscarxPalabraxTexto(alterTextoPalabraEncerradaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public List<AlterTextoPalabraEncerradaBean> buscarxCabeceraxDetalle(AlterTextoPalabraEncerradaBean alterTextoPalabraEncerradaBean) throws ServiceException {
		List<AlterTextoPalabraEncerradaBean> lstBean = null;
		try {
			lstBean = this.alterTextoPalabraEncerradaDAO.buscarxCabeceraxDetalle(alterTextoPalabraEncerradaBean);
			System.out.println("lstBean ITD");
			System.out.println(lstBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstBean;
	}

	
}
