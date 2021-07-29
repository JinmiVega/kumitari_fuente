package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraDetBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionVariadaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.RelacionDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.RelacionVariadaDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.RelacionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.RelacionVariadaService;

@Service("relacionVariadaService")
@Transactional (readOnly = true)
public class RelacionVariadaServiceImpl implements RelacionVariadaService{

	@Autowired
	private RelacionVariadaDAO relacionVariadaDAO;
	
	@Override
	public boolean insertar(RelacionVariadaBean relacionVariadaBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = relacionVariadaDAO.insertar(relacionVariadaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(RelacionVariadaBean relacionVariadaBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = relacionVariadaDAO.actualizar(relacionVariadaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(RelacionVariadaBean relacionVariadaBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = relacionVariadaDAO.eliminar(relacionVariadaBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}
	
	@Override
	public List<RelacionVariadaBean> getBuscarTodoxMTE(
			RelacionVariadaBean  Bean) throws ServiceException {
		List<RelacionVariadaBean> lstBean = null;
		try {
			lstBean = this.getRelacionVariadaDAO().getBuscarTodoxMTE(Bean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstBean;
	}
	

	@Override
	public RelacionVariadaBean getBuscarPorObjecto(RelacionVariadaBean relacionVariadaBean) throws ServiceException {
		RelacionVariadaBean oRelacionVariadaBean = null;
		try {
			oRelacionVariadaBean = this.getRelacionVariadaDAO().getBuscarPorObjecto(relacionVariadaBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return oRelacionVariadaBean;
	}

	@Override
	public List<RelacionVariadaBean> getBuscarPorFiltros(RelacionVariadaBean relacionVariadaBean) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(RelacionVariadaBean relacionVariadaBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RelacionVariadaBean> buscarPorRelacionCabecera(RelacionVariadaBean relacionVariadaBean) throws ServiceException {
		List<RelacionVariadaBean> lstPreguntas = null;
		try 
		{
			lstPreguntas = relacionVariadaDAO.buscarPorRelacionCabecera(relacionVariadaBean);
		} 
		catch (DAOException e) 
		{
			e.printStackTrace();
		}
		return lstPreguntas;
	}

	 
	 
	public RelacionVariadaDAO getRelacionVariadaDAO() {
		return relacionVariadaDAO;
	}

	public void setRelacionVariadaDAO(RelacionVariadaDAO relacionVariadaDAO) {
		this.relacionVariadaDAO = relacionVariadaDAO;
	}

	 
	
	
	
}
