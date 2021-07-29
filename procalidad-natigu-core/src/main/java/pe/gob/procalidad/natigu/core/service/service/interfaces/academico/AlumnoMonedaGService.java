package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMonedaGBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface AlumnoMonedaGService extends BaseService<AlumnoMonedaGBean>{
	public boolean actualizarmonedaxcompra(AlumnoMonedaGBean alumnoMonedaGBean) throws ServiceException;
}
