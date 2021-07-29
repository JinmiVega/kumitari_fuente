package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface EvaluacionService extends BaseService<EvaluacionBean>{
	
	public EvaluacionBean iniciarEvaluacion(EvaluacionBean evaluacionBean) throws ServiceException;
	public boolean obtenerNota(EvaluacionBean evaluacionBean) throws ServiceException;
	public boolean pasarHistorico(EvaluacionBean evaluacionBean) throws ServiceException;
	public List<EvaluacionBean> listarNotas(UsuarioMatriculaBean usuarioMatriculaBean) throws ServiceException;
	public boolean insertarEvaluacionFinal(EvaluacionBean evaluacionBean) throws ServiceException;
	public boolean actualizarFechaEvaluacion(EvaluacionBean evaluacionBean) throws ServiceException;
}
