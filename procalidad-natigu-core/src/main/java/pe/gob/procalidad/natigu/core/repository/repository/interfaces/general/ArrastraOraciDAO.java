package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List; 

import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraciBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialEjercicioBean; 
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface ArrastraOraciDAO extends BaseDAO<ArrastraOraciBean>
{ 
	ArrastraOraciBean getBuscarPorTEM(
			ArrastraOraciBean arrastraOraciBean) throws DAOException;

 
	
}
