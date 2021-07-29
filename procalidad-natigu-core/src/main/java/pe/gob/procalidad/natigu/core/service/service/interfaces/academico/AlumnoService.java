package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;
 
import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface AlumnoService extends BaseService<AlumnoBean> {
	
	public List<AlumnoBean> getBuscarxCodigoInstitucion(AlumnoBean alumnoBean) throws ServiceException;

}

 