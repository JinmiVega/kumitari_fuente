package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonalBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.PersonalDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonalService;

@Service("personalService")
@Transactional (readOnly = true)
public class PersonalServiceImpl implements PersonalService {

	@Autowired
	private PersonalDAO personalDAO;
	
	
	
	public PersonalDAO getPersonalDAO() {
		return personalDAO;
	}

	public void setPersonalDAO(PersonalDAO personalDAO) {
		this.personalDAO = personalDAO;
	}

	@Override
	public boolean insertar(PersonalBean personalBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  personalDAO.insertar(personalBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PersonalBean personalBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  personalDAO.actualizar(personalBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PersonalBean personalBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  personalDAO.eliminar(personalBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public PersonalBean getBuscarPorObjecto(PersonalBean personal)
			throws ServiceException {
		PersonalBean oPersonalBean = null;
		try {
			oPersonalBean = personalDAO.getBuscarPorObjecto(personal);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPersonalBean;
	}

	@Override
	public List<PersonalBean> getBuscarPorFiltros(PersonalBean personal)
			throws ServiceException {
		List<PersonalBean> lstPersonal=null;
		try {
			System.out.println("en listado lengua service imp");
			lstPersonal=(List<PersonalBean>) personalDAO.getBuscarPorFiltros(personal);
		} catch (Exception e) {
			 
		} 
		 
		return lstPersonal;
	}

	@Override
	public boolean existe(PersonalBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
