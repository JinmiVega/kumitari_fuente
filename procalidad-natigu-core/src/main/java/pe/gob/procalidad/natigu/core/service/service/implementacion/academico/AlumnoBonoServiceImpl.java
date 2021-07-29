package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBonoBean; 
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMedallaBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.AlumnoBonoDAO; 
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoBonoService; 

@Service("alumnoBonoService")
@Transactional (readOnly = true)
public class AlumnoBonoServiceImpl implements AlumnoBonoService{

	@Autowired
	AlumnoBonoDAO alumnoBonoDAO;
	
	@Override
	public boolean insertar(AlumnoBonoBean bean)
			throws ServiceException {
			boolean sw = false;
			try {
				sw = this.alumnoBonoDAO.insertar(bean);
			} catch (Exception e) {
				sw = false;
				e.printStackTrace();
			}
			return sw;
	} 
 
	@Override
	public boolean actualizar(AlumnoBonoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(AlumnoBonoBean alumnoBonoBean) throws ServiceException {
		boolean sw =  false;
		
		try {
			
			sw = this.getAlumnoBonoDAO().eliminar(alumnoBonoBean);
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public AlumnoBonoBean getBuscarPorObjecto(AlumnoBonoBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlumnoBonoBean> getBuscarPorFiltros(AlumnoBonoBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(AlumnoBonoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AlumnoBonoBean> getBuscarPorAlumno(AlumnoBonoBean alumnoBonoBean)throws ServiceException {
	List<AlumnoBonoBean> lstBean=null;
	try {
		
		lstBean=(List<AlumnoBonoBean>) alumnoBonoDAO.getBuscarPorAlumno(alumnoBonoBean);
	} catch (Exception e) {
		e.printStackTrace(); 
	}
	 
	return lstBean;
}

	public AlumnoBonoDAO getAlumnoBonoDAO() {
		return alumnoBonoDAO;
	}

	public void setAlumnoBonoDAO(AlumnoBonoDAO alumnoBonoDAO) {
		this.alumnoBonoDAO = alumnoBonoDAO;
	}
	 

}
