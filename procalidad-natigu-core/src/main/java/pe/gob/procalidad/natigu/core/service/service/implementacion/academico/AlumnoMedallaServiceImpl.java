package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMedallaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMonedaGBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionDocenteBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.AlumnoMedallaDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoMedallaService;

@Service("alumnoMedallaService")
@Transactional (readOnly = true)
public class AlumnoMedallaServiceImpl implements AlumnoMedallaService{

	@Autowired
	AlumnoMedallaDAO alumnoMedallaDAO;
	
	@Override
	public boolean insertar(AlumnoMedallaBean bean)
			throws ServiceException {
			boolean sw = false;
			try {
				sw = this.alumnoMedallaDAO.insertar(bean);
			} catch (Exception e) {
				sw = false;
				e.printStackTrace();
			}
			return sw;
	}

	@Override
	public boolean actualizar(AlumnoMedallaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(AlumnoMedallaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AlumnoMedallaBean getBuscarPorObjecto(AlumnoMedallaBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlumnoMedallaBean> getBuscarPorFiltros(AlumnoMedallaBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(AlumnoMedallaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<AlumnoMedallaBean> getBuscarPorAlumno(AlumnoMedallaBean alumnoMedallaBean)throws ServiceException {
		List<AlumnoMedallaBean> lstAlumnoMedallaBean=null;
		try {
			
			lstAlumnoMedallaBean=(List<AlumnoMedallaBean>) alumnoMedallaDAO.getBuscarPorAlumno(alumnoMedallaBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstAlumnoMedallaBean;
	}

}
