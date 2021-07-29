package pe.gob.procalidad.natigu.core.service.service.implementacion.configuracion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MensajesBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.MensajesDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.MensajesService;
@Service("mensajesService")
@Transactional(readOnly = true)
public class MensajesServiceImp implements MensajesService{
	
	@Autowired
	private MensajesDAO mensajesDAO;

	@Override
	public boolean insertar(MensajesBean mensajesBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getMensajesDAO().insertar(mensajesBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(MensajesBean mensajesBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getMensajesDAO().actualizar(mensajesBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(MensajesBean mensajesBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getMensajesDAO().eliminar(mensajesBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public MensajesBean getBuscarPorObjecto(MensajesBean mensajesBean)
			throws ServiceException {
		MensajesBean mensajesBean2 = null;
		try {
			mensajesBean2 = this.getMensajesDAO().getBuscarPorObjecto(mensajesBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mensajesBean2;
	}

	@Override
	public List<MensajesBean> getBuscarPorFiltros(MensajesBean mensajesBean)
			throws ServiceException {
		List<MensajesBean> lstMensajesBeans = null;
		try {
			lstMensajesBeans = this.getMensajesDAO().getBuscarPorFiltros(mensajesBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstMensajesBeans;
	}

	@Override
	public boolean existe(MensajesBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public MensajesDAO getMensajesDAO() {
		return mensajesDAO;
	}

	public void setMensajesDAO(MensajesDAO mensajesDAO) {
		this.mensajesDAO = mensajesDAO;
	}
	

}
