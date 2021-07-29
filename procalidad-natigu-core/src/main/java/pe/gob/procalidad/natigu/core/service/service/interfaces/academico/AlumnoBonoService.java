package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBonoBean;  
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

 


public interface AlumnoBonoService extends BaseService<AlumnoBonoBean>{
	public List<AlumnoBonoBean> getBuscarPorAlumno(AlumnoBonoBean alumnoBonoBean)throws ServiceException;
}

