package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumIntentoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionDetalleBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.EvaluacionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.EvaluacionService;
@Service("evaluacionService")
@Transactional(readOnly = true)
public class EvaluacionServiceImp implements EvaluacionService{

	@Autowired
	private EvaluacionDAO evaluacionDAO;
	
	@Override
	public boolean insertar(EvaluacionBean evaluacionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getEvaluacionDAO().insertar(evaluacionBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(EvaluacionBean evaluacionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getEvaluacionDAO().actualizar(evaluacionBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizarFechaEvaluacion(EvaluacionBean evaluacionBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getEvaluacionDAO().actualizarFechaEvaluacion(evaluacionBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}
	
	@Override
	public boolean eliminar(EvaluacionBean evaluacionBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EvaluacionBean getBuscarPorObjecto(EvaluacionBean evaluacionBean)
			throws ServiceException {
		EvaluacionBean oEvaluacionBean = null;
		try {
			oEvaluacionBean = this.getEvaluacionDAO().getBuscarPorObjecto(evaluacionBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oEvaluacionBean;
	}

	@Override
	public List<EvaluacionBean> getBuscarPorFiltros(
			EvaluacionBean bean) throws ServiceException {
		List<EvaluacionBean> lstBeans = null;
		try {
			lstBeans = this.evaluacionDAO.getBuscarPorFiltros(bean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstBeans;
	}
	

	@Override
	public boolean existe(EvaluacionBean evaluacionBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public EvaluacionDAO getEvaluacionDAO() {
		return evaluacionDAO;
	}

	public void setEvaluacionDAO(EvaluacionDAO evaluacionDAO) {
		this.evaluacionDAO = evaluacionDAO;
	}

	@Override
	public EvaluacionBean iniciarEvaluacion(EvaluacionBean evaluacionBean)throws ServiceException {
		EvaluacionBean oEvaluacionBean = null;
		try {
			oEvaluacionBean = this.getEvaluacionDAO().iniciarEvaluacion(evaluacionBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oEvaluacionBean;
	}

	@Override
	public boolean obtenerNota(EvaluacionBean evaluacionBean)throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getEvaluacionDAO().obtenerNota(evaluacionBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
		}
		return sw;
	}
	@Override
	public boolean pasarHistorico(EvaluacionBean evaluacionBean)
			throws ServiceException {
		boolean sw =  false;
		try {
			sw =  this.getEvaluacionDAO().pasarHistorico(evaluacionBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	
	@Override
	public List<EvaluacionBean> listarNotas(UsuarioMatriculaBean usuarioMatriculaBean) throws ServiceException {
		List<EvaluacionBean> lstEvaluacionBean=null;
		try {
			System.out.println("en listado Alumno service imp");
			lstEvaluacionBean=(List<EvaluacionBean>) evaluacionDAO.listarNotas(usuarioMatriculaBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstEvaluacionBean;
	}

	@Override
	public boolean insertarEvaluacionFinal(EvaluacionBean evaluacionBean)
			throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getEvaluacionDAO().insertarEvaluacionFinal(evaluacionBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
		}
		return sw;
	}
	
	
}
