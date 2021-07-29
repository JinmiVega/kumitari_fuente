package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionDetalleBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.EvaluacionDetalleDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.EvaluacionDetalleService;
@Service("evaluacionDetalleService")
@Transactional(readOnly = true)
public class EvaluacionDetalleServiceImp implements EvaluacionDetalleService{

	@Autowired
	private EvaluacionDetalleDAO evaluacionDetalleDAO;
	
	@Override
	public boolean insertar(EvaluacionDetalleBean evaluacionDetalleBean) throws ServiceException {
		boolean sw =  false;
		try {
			sw = this.getEvaluacionDetalleDAO().insertar(evaluacionDetalleBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(EvaluacionDetalleBean evaluacionDetalleBean) throws ServiceException {
	    boolean sw = false;
	    try {
			sw = this.getEvaluacionDetalleDAO().actualizar(evaluacionDetalleBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(EvaluacionDetalleBean evaluacionDetalleBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EvaluacionDetalleBean getBuscarPorObjecto(EvaluacionDetalleBean evaluacionDetalleBean)
			throws ServiceException {
		EvaluacionDetalleBean oEvaluacionDetalleBean =  new EvaluacionDetalleBean();
		try {
			oEvaluacionDetalleBean = this.getEvaluacionDetalleDAO().getBuscarPorObjecto(evaluacionDetalleBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oEvaluacionDetalleBean;
	}

	@Override
	public List<EvaluacionDetalleBean> getBuscarPorFiltros(
			EvaluacionDetalleBean evaluacionDetalleBean) throws ServiceException {
		List<EvaluacionDetalleBean> lstEvaluacionDetalleBeans = null;
		try {
			lstEvaluacionDetalleBeans = this.getEvaluacionDetalleDAO().getBuscarPorFiltros(evaluacionDetalleBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstEvaluacionDetalleBeans;
	}

	@Override
	public boolean existe(EvaluacionDetalleBean evaluacionDetalleBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public EvaluacionDetalleDAO getEvaluacionDetalleDAO() {
		return evaluacionDetalleDAO;
	}

	public void setEvaluacionDetalleDAO(EvaluacionDetalleDAO evaluacionDetalleDAO) {
		this.evaluacionDetalleDAO = evaluacionDetalleDAO;
	}

	@Override
	public EvaluacionDetalleBean getBuscarPorEjercicioEvaluacion(EvaluacionDetalleBean evaluacionDetalleBean)
			throws ServiceException {
		EvaluacionDetalleBean oEvaluacionDetalleBean = null;
		try {
			oEvaluacionDetalleBean = this.getEvaluacionDetalleDAO().getBuscarPorEjercicioEvaluacion(evaluacionDetalleBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oEvaluacionDetalleBean;
	}

	
}
