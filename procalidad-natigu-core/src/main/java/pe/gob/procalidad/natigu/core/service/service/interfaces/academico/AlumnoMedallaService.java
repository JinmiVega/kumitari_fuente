package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMedallaBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface AlumnoMedallaService extends BaseService<AlumnoMedallaBean>{
	public List<AlumnoMedallaBean> getBuscarPorAlumno(AlumnoMedallaBean alumnoMedallaBean)throws ServiceException;
}
