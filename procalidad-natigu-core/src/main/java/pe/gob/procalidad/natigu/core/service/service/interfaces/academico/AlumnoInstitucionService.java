package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;
 
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoInstitucionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface AlumnoInstitucionService extends BaseService<AlumnoInstitucionBean> {
	public List<AlumnoInstitucionBean> getBuscarPorCodigoAlumno(AlumnoInstitucionBean alumnoInstitucionBean) throws ServiceException;
}
 
