package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;


//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionVariadaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface RelacionVariadaDAO extends BaseDAO<RelacionVariadaBean>
{
	public List<RelacionVariadaBean> buscarPorRelacionCabecera(RelacionVariadaBean relacionVariadaBean) throws DAOException;

	List<RelacionVariadaBean> getBuscarTodoxMTE(RelacionVariadaBean Bean)
			throws DAOException;
 
}
