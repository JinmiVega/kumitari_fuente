package pe.gob.procalidad.natigu.core.service.service.implementacion.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.ExamenConfiguracionBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.ExamenConfiguracionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.ExamenConfiguracionService;

@Service("examenConfiguracionService")
@Transactional (readOnly = true)
public class ExamenConfiguracionServiceImp implements ExamenConfiguracionService{

	@Autowired
	private ExamenConfiguracionDAO examenConfiguracionDAO;
	
	@Override
	public boolean insertar(ExamenConfiguracionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(ExamenConfiguracionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(ExamenConfiguracionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ExamenConfiguracionBean getBuscarPorObjecto(ExamenConfiguracionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamenConfiguracionBean> getBuscarPorFiltros(ExamenConfiguracionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(ExamenConfiguracionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ExamenConfiguracionBean> listarTodos() throws ServiceException {
		List<ExamenConfiguracionBean> lstExamenConfigBean=null;
		try {
			System.out.println("en listado premio configuracion");
			lstExamenConfigBean= examenConfiguracionDAO.listarTodos();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstExamenConfigBean;
	}

}
