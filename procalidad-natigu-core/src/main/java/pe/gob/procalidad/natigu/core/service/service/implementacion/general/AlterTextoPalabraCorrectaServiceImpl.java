package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.AlterTextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionAlterBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.AlterTextoPalabraCorrectaDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.AlterTextoPalabraCorrectaService;

@Service("alterTextoPalabraCorrectaService")
@Transactional (readOnly = true)
public class AlterTextoPalabraCorrectaServiceImpl implements AlterTextoPalabraCorrectaService{

	@Autowired
	private AlterTextoPalabraCorrectaDAO alterTextoPalabraCorrectaDAO;

	@Override
	public boolean insertar(AlterTextoPalabraCorrectaBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = alterTextoPalabraCorrectaDAO.insertar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(AlterTextoPalabraCorrectaBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = alterTextoPalabraCorrectaDAO.actualizar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(AlterTextoPalabraCorrectaBean t) throws ServiceException {
		boolean sw = false;
		try {
			sw = alterTextoPalabraCorrectaDAO.eliminar(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public AlterTextoPalabraCorrectaBean getBuscarPorObjecto(AlterTextoPalabraCorrectaBean t) throws ServiceException {
		AlterTextoPalabraCorrectaBean bean = null;
		try 
		{
			bean = alterTextoPalabraCorrectaDAO.getBuscarPorObjecto(t);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<AlterTextoPalabraCorrectaBean> getBuscarPorFiltros(AlterTextoPalabraCorrectaBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(AlterTextoPalabraCorrectaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AlterTextoPalabraCorrectaBean> buscarPorCodigoOracion(TextoPalabraCorrectaBean textoPalabraCorrectaBean)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlterTextoPalabraCorrectaBean> getBuscarPorTextoPalabraCorrecta(
			AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws ServiceException {
		// TODO Auto-generated method stub
		List<AlterTextoPalabraCorrectaBean> lstBean = null;
		try {
			lstBean = this.alterTextoPalabraCorrectaDAO.getBuscarPorTextoPalabraCorrecta(alterTextoPalabraCorrectaBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstBean;
	}

	@Override
	public List<AlterTextoPalabraCorrectaBean> buscarxPalabraxTexto(
			AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws ServiceException {
		List<AlterTextoPalabraCorrectaBean> lst = null;
		try {
			lst = alterTextoPalabraCorrectaDAO.buscarxPalabraxTexto(alterTextoPalabraCorrectaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public List<AlterTextoPalabraCorrectaBean> getBuscarTodoxMTE(AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws ServiceException {
		List<AlterTextoPalabraCorrectaBean> lstBean = null;
		try {
			lstBean = this.alterTextoPalabraCorrectaDAO.getBuscarTodoxMTE(alterTextoPalabraCorrectaBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstBean;
	}

	@Override
	public List<AlterTextoPalabraCorrectaBean> getlistarNombrePalabraCorrectaYcodigoCab(
			AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws ServiceException {
		List<AlterTextoPalabraCorrectaBean> lstBean = null;
		try {
			lstBean = this.alterTextoPalabraCorrectaDAO.getlistarNombrePalabraCorrectaYcodigoCab(alterTextoPalabraCorrectaBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstBean;
	}
	
	
	
}
