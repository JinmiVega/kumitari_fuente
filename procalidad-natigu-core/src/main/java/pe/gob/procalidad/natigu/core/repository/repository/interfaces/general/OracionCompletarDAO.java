package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List; 

import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionCompletarBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface OracionCompletarDAO extends BaseDAO<OracionCompletarBean>
{
	public List<OracionCompletarBean> buscarPorMaterialEjercicio(MaterialEjercicioBean materialEjercicioBean) throws DAOException;

	OracionCompletarBean getBuscarPorTEM(
			OracionCompletarBean oracionCompletarBean) throws DAOException;

 
	
}
