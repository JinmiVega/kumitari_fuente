package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;
 


import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionAlterBean; 
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionCompletarBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface OracionAlterService extends BaseService<OracionAlterBean>{

	List<OracionAlterBean> buscarPorCodigoOracion(
			OracionCompletarBean oracionCompletarBean) throws ServiceException;

	List<OracionAlterBean> getBuscarPorOracion(OracionAlterBean Bean)
			throws ServiceException;

	List<OracionAlterBean> buscarPorEspacioOracion(
			OracionAlterBean oracionAterBean) throws ServiceException;

	List<OracionAlterBean> getBuscarTodoxMTE(OracionAlterBean Bean)
			throws ServiceException;

}
