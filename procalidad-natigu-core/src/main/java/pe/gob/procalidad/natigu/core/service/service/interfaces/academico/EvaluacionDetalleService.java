package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;

import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionDetalleBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface EvaluacionDetalleService extends BaseService<EvaluacionDetalleBean>{
	
	public EvaluacionDetalleBean getBuscarPorEjercicioEvaluacion(EvaluacionDetalleBean evaluacionDetalleBean) throws ServiceException;

}
