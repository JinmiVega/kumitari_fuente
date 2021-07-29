package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;
 
import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EspecialidadBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface EspecialidadService extends BaseService<EspecialidadBean> {
	  
	public List<EspecialidadBean> listarPorCodigoDocente(DocenteBean docenteBean) throws ServiceException; 
}

 