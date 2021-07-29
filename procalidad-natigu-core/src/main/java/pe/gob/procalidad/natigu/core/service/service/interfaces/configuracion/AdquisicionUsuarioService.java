package pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.AdquisicionUsuarioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface AdquisicionUsuarioService extends BaseService<AdquisicionUsuarioBean> {
	public Integer realizarCompra(AdquisicionUsuarioBean prmObject) throws ServiceException;
	
	public boolean actualizarSwPredeterminadoMasc(AdquisicionUsuarioBean prmObject) throws ServiceException;
	
	public boolean actualizarSwPredeterminadoFond(AdquisicionUsuarioBean prmObject) throws ServiceException;
	
	public boolean actualizarSwPredeterminadoCombo(AdquisicionUsuarioBean prmObject) throws ServiceException;

}
