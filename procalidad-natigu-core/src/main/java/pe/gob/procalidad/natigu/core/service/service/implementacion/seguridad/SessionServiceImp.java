package pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.SesionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.seguridad.SessionDao;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.SessionService;

@Service("sessionService")
@Transactional (readOnly = true)
public class SessionServiceImp implements SessionService {
	@Autowired
	SessionDao sessionDao;

	@Override
	public boolean insertar(SesionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(SesionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(SesionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SesionBean getBuscarPorObjecto(SesionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SesionBean> getBuscarPorFiltros(SesionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(SesionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sessionGestor(SesionBean sesionBean, String operacion) throws DAOException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  sessionDao.sessionGestor(sesionBean,operacion);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

}
