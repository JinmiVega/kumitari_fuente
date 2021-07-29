package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;

//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface PreguntaDAO extends BaseDAO<PreguntaBean>
{

	public List<PreguntaBean> buscarPorMatTEjerPregunta(PreguntaBean preguntaBean) throws DAOException;
	public List<PreguntaBean> buscarPregunta(PreguntaBean preguntaBean) throws DAOException;
	
}
