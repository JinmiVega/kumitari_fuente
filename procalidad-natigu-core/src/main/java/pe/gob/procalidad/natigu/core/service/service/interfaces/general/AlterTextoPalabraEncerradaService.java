package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.AlterTextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.AlterTextoPalabraEncerradaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraEncerradaBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface AlterTextoPalabraEncerradaService extends BaseService<AlterTextoPalabraEncerradaBean>{

	public List<AlterTextoPalabraEncerradaBean> buscarPorCodigoOracion(TextoPalabraEncerradaBean textoPalabraEncerradaBean) throws ServiceException;

	public List<AlterTextoPalabraEncerradaBean> getBuscarPorTextoPalabraCorrecta(AlterTextoPalabraEncerradaBean alterTextoPalabraEncerradaBean) throws ServiceException;

	public AlterTextoPalabraEncerradaBean buscarxPalabraxTexto(AlterTextoPalabraEncerradaBean alterTextoPalabraEncerradaBean) throws ServiceException;

	public List<AlterTextoPalabraEncerradaBean> buscarxCabeceraxDetalle(AlterTextoPalabraEncerradaBean alterTextoPalabraEncerradaBean) throws ServiceException;

}
