package pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion;


import pe.gob.procalidad.natigu.core.bean.bean.configuracion.AdquisicionUsuarioBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface AdquisicionUsuarioDAO extends BaseDAO<AdquisicionUsuarioBean>{
	public Integer realizarCompra(AdquisicionUsuarioBean prmObject) throws DAOException;
	
	public boolean actualizarSwPredeterminadoMasc(AdquisicionUsuarioBean prmObject) throws DAOException;
	
	public boolean actualizarSwPredeterminadoFond(AdquisicionUsuarioBean prmObject) throws DAOException;
	
	public boolean actualizarSwPredeterminadoCombo(AdquisicionUsuarioBean prmObject) throws DAOException;
}
