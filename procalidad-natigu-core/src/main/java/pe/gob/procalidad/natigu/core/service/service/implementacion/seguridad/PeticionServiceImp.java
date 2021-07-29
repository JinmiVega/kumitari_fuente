package pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.seguridad.PeticionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;

@Service("peticionService")
@Transactional (readOnly = true)
public class PeticionServiceImp implements PeticionService {

	@Autowired
	PeticionDAO peticionDao;
	
	@Override
	public boolean insertar(PeticionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  peticionDao.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PeticionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(PeticionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PeticionBean getBuscarPorObjecto(PeticionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeticionBean> getBuscarPorFiltros(PeticionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(PeticionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  peticionDao.existe(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}
}
