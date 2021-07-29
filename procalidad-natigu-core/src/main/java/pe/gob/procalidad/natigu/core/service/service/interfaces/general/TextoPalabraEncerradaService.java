package pe.gob.procalidad.natigu.core.service.service.interfaces.general;



import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraEncerradaBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface TextoPalabraEncerradaService extends BaseService<TextoPalabraEncerradaBean>{

	public TextoPalabraEncerradaBean getBuscarPorTEM(TextoPalabraEncerradaBean textoPalabraEncerradaBean) throws ServiceException;

 
}
