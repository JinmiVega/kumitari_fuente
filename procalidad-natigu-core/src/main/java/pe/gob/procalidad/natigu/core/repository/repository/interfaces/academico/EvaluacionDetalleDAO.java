package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionDetalleBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface EvaluacionDetalleDAO extends BaseDAO<EvaluacionDetalleBean>{
	
	public EvaluacionDetalleBean getBuscarPorEjercicioEvaluacion(EvaluacionDetalleBean evaluacionDetalleBean) throws DAOException;

}
