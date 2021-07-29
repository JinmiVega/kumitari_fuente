package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaNacionalidadBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.LenguaDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.PersonaLenguaDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.PersonaNacionalidadDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaLenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaNacionalidadService;

 
@Service("personaNacionalidadService")
@Transactional (readOnly = true)
public class PersonaNacionalidadServiceImp implements PersonaNacionalidadService {
	
	@Autowired
	private PersonaNacionalidadDAO personaNacionalidadDAO; 
	

	@Override
	public boolean insertar(PersonaNacionalidadBean personaNacionalidadBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  getPersonaNacionalidadDAO().insertar(personaNacionalidadBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PersonaNacionalidadBean personaNacionalidadBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  getPersonaNacionalidadDAO().actualizar(personaNacionalidadBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PersonaNacionalidadBean personaNacionalidadBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  getPersonaNacionalidadDAO().eliminar(personaNacionalidadBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public PersonaNacionalidadBean getBuscarPorObjecto(PersonaNacionalidadBean personaNacionalidadBean) throws ServiceException {
		PersonaNacionalidadBean oPersonaNacionalidadBean = null;
		try {
			oPersonaNacionalidadBean = getPersonaNacionalidadDAO().getBuscarPorObjecto(personaNacionalidadBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPersonaNacionalidadBean;
	}

	@Override
	public List<PersonaNacionalidadBean> getBuscarPorFiltros(PersonaNacionalidadBean personaNacionalidadBean) throws ServiceException {
		List<PersonaNacionalidadBean> lstAlmacen=null;
		try {
			lstAlmacen=(List<PersonaNacionalidadBean>) getPersonaNacionalidadDAO().getBuscarPorFiltros(personaNacionalidadBean);
		} catch (Exception e) {
			 
		}
		return lstAlmacen;
	}

	@Override
	public boolean existe(PersonaNacionalidadBean personaNacionalidadBean) throws ServiceException {
		Boolean sw = true;
		try {
			sw =  getPersonaNacionalidadDAO().existe(personaNacionalidadBean) ;
		} catch (DAOException e) { 
		}
		return sw;
	}

	public PersonaNacionalidadDAO getPersonaNacionalidadDAO() {
		return personaNacionalidadDAO;
	}
	
	@Override
	public List<PersonaNacionalidadBean> getBuscarPorCodigoPersona(PersonaNacionalidadBean personaNacionalidadBean) throws ServiceException {
		List<PersonaNacionalidadBean> lstAlmacen=null;
		try {
			lstAlmacen=(List<PersonaNacionalidadBean>) getPersonaNacionalidadDAO().getBuscarPorCodigoPersona(personaNacionalidadBean);
		} catch (Exception e) {
			 
		}
		return lstAlmacen;
	}

	
}
	
	 
