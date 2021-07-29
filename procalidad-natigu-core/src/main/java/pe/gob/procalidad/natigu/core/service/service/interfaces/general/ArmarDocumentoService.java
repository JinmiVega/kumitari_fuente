package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.ArmarDocumentoBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface ArmarDocumentoService extends BaseService<ArmarDocumentoBean>  {

	public List<ArmarDocumentoBean> listarArmarDocuCabDetTodo(ArmarDocumentoBean armarDocumentoBean) throws ServiceException;
	
}
