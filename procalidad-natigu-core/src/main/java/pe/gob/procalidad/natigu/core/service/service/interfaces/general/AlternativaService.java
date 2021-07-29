package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.AlternativaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface AlternativaService extends BaseService<AlternativaBean>{

	public List<AlternativaBean> buscarPorCodigoPregunta(PreguntaBean preguntaBean) throws ServiceException;
	
}
