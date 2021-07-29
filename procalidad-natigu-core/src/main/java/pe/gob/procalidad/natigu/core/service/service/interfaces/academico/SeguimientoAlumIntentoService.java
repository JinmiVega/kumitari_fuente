package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumIntentoBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface SeguimientoAlumIntentoService extends BaseService<SeguimientoAlumIntentoBean>{

	boolean actualizarDet(SeguimientoAlumIntentoBean bean)
			throws ServiceException;

	boolean insertarDet(SeguimientoAlumIntentoBean bean)
			throws ServiceException;

	SeguimientoAlumIntentoBean getBuscarPorObjectoDet(
			SeguimientoAlumIntentoBean bean) throws ServiceException;

 
}
