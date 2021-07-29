package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.OrdenarParrafoBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;

public interface OrdenarParrafoDAO extends BaseDAO<OrdenarParrafoBean>{

	public List<OrdenarParrafoBean> listarTodosParrafos(OrdenarParrafoBean ordenarParrafoBean) throws DAOException;
	public boolean actualizarOrden(OrdenarParrafoBean ordenarParrafoBean) throws DAOException;
	public boolean actualizarDoc(OrdenarParrafoBean ordenarParrafoBean) throws DAOException;
	public boolean insertarDoc(OrdenarParrafoBean ordenarParrafoBean) throws DAOException;
	public boolean actualizarArras(OrdenarParrafoBean ordenarParrafoBean) throws DAOException;
	public boolean insertarArras(OrdenarParrafoBean ordenarParrafoBean) throws DAOException;
}
