package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;

//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface PreguntaService extends BaseService<PreguntaBean>{

	public List<PreguntaBean> buscarPorMatTEjerPregunta(PreguntaBean preguntaBean) throws ServiceException;
	public List<PreguntaBean> buscarPregunta(PreguntaBean preguntaBean) throws ServiceException;
	
}
