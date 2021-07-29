package pe.gob.procalidad.natigu.core.service.service.interfaces.general;


import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface TextoPalabraCorrectaService extends BaseService<TextoPalabraCorrectaBean>{

	TextoPalabraCorrectaBean getBuscarPorTEM(TextoPalabraCorrectaBean textoPalabraCorrectaBean) throws ServiceException;

 
}
