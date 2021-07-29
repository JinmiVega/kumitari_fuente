package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface EvaluacionDAO extends BaseDAO<EvaluacionBean>{
	public EvaluacionBean iniciarEvaluacion(EvaluacionBean evaluacionBean) throws DAOException;
	public boolean obtenerNota(EvaluacionBean evaluacionBean) throws DAOException;
	public boolean pasarHistorico(EvaluacionBean evaluacionBean) throws DAOException;
	public List<EvaluacionBean> listarNotas(UsuarioMatriculaBean usuarioMatriculaBean) throws DAOException; 
	public boolean insertarEvaluacionFinal(EvaluacionBean evaluacionBean) throws DAOException;
	public boolean actualizarFechaEvaluacion(EvaluacionBean evaluacionBean) throws DAOException;
}
