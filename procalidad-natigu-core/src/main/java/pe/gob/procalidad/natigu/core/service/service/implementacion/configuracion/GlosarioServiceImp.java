package pe.gob.procalidad.natigu.core.service.service.implementacion.configuracion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.GlosarioBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.GlosarioDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.GlosarioService;
@Service("glosarioService")
@Transactional(readOnly = true)
public class GlosarioServiceImp implements GlosarioService{
	
	@Autowired
	private GlosarioDAO glosarioDAO;

	@Override
	public boolean insertar(GlosarioBean glosarioBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getGlosarioDAO().insertar(glosarioBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(GlosarioBean glosarioBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getGlosarioDAO().actualizar(glosarioBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(GlosarioBean glosarioBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getGlosarioDAO().eliminar(glosarioBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public GlosarioBean getBuscarPorObjecto(GlosarioBean glosarioBean)
			throws ServiceException {
		GlosarioBean glosarioBean2 = null;
		try {
			glosarioBean2 = this.getGlosarioDAO().getBuscarPorObjecto(glosarioBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return glosarioBean2;
	}

	@Override
	public List<GlosarioBean> getBuscarPorFiltros(GlosarioBean glosarioBean)
			throws ServiceException {
		List<GlosarioBean> lstGlosarioBeans = null;
		try {
			lstGlosarioBeans = this.getGlosarioDAO().getBuscarPorFiltros(glosarioBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstGlosarioBeans;
	}

	@Override
	public boolean existe(GlosarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public GlosarioDAO getGlosarioDAO() {
		return glosarioDAO;
	}

	public void setGlosarioDAO(GlosarioDAO glosarioDAO) {
		this.glosarioDAO = glosarioDAO;
	}
	

}
