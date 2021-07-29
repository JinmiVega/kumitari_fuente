package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.OrdenarParrafoBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface OrdenarParrafoService extends BaseService<OrdenarParrafoBean>{
	
	public List<OrdenarParrafoBean> listarTodosParrafos(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException;
	public boolean actualizarOrden(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException;
	public boolean actualizarDoc(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException;
	public boolean insertarDoc(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException;
	public boolean actualizarArras(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException;
	public boolean insertarArras(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException;
	/*public OrdenarParrafoBean getBuscarPorObjectoDoc(OrdenarParrafoBean ordenarParrafoBean) throws ServiceException;*/
}
