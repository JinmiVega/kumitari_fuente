package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;  

import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraDetBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionAlterBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionCompletarBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface ArrastraOraDetDAO extends BaseDAO<ArrastraOraDetBean>
{
 
	List<ArrastraOraDetBean> getBuscarPorOracion(
			ArrastraOraDetBean arrastraOraDetBean) throws DAOException;

	List<ArrastraOraDetBean> getBuscarTodoxMTE(ArrastraOraDetBean Bean)
			throws DAOException;

 
	
}
