package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;  
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionAlterBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionCompletarBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface OracionAlterDAO extends BaseDAO<OracionAlterBean>
{
 
	List<OracionAlterBean> getBuscarPorOracion(
			OracionAlterBean materialTipoEjercicioBean) throws DAOException;

	public List<OracionAlterBean> buscarEspacioOracion(
			OracionAlterBean oracionAlterBean)throws DAOException;

	List<OracionAlterBean> getBuscarTodoxMTE(OracionAlterBean Bean)
			throws DAOException;
	
}
