package pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.SesionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface SessionService extends BaseService<SesionBean> {
	public boolean sessionGestor(SesionBean sesionBean,String operacion) throws DAOException;
}
