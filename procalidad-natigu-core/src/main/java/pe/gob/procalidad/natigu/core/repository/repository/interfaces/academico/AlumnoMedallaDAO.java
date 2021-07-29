package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;


import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMedallaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface AlumnoMedallaDAO extends BaseDAO<AlumnoMedallaBean> {
	public List<AlumnoMedallaBean> getBuscarPorAlumno(AlumnoMedallaBean alumnoMedallaBean)
			throws DAOException;
}
