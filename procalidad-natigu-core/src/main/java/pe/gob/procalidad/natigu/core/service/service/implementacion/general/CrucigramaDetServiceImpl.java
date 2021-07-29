package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import pe.gob.procalidad.natigu.core.bean.bean.generico.CrucigramaDetBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.CrucigramaDetDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.RelacionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.CrucigramaDetService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.RelacionService;

@Service("crucigramaDetService")
@Transactional (readOnly = true)
public class CrucigramaDetServiceImpl implements CrucigramaDetService{

	@Autowired
	private CrucigramaDetDAO crucigramaDetDAO;
	
	@Override
	public boolean insertar(CrucigramaDetBean relacionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = crucigramaDetDAO.insertar(relacionBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(CrucigramaDetBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(CrucigramaDetBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CrucigramaDetBean getBuscarPorObjecto(CrucigramaDetBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CrucigramaDetBean> getBuscarPorFiltros(CrucigramaDetBean t)
			throws ServiceException {
		List<CrucigramaDetBean> lstPreguntas = null;
		try 
		{
			lstPreguntas = crucigramaDetDAO.getBuscarPorFiltros(t);
		} 
		catch (DAOException e) 
		{
			e.printStackTrace();
		}
		return lstPreguntas;
	}

	@Override
	public boolean existe(CrucigramaDetBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public CrucigramaDetDAO getCrucigramaDetDAO() {
		return crucigramaDetDAO;
	}

	public void setCrucigramaDetDAO(CrucigramaDetDAO crucigramaDetDAO) {
		this.crucigramaDetDAO = crucigramaDetDAO;
	}
 
	
	
	
	
}
