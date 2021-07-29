package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionDocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.InscripcionDocenteDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionDocenteService;

@Service("inscripcionDocenteService")
@Transactional (readOnly = true)
public class InscripcionDocenteServiceImpl implements InscripcionDocenteService {

	@Autowired
	private InscripcionDocenteDAO inscripcionDocenteDAO;
	
	@Override
	public boolean insertar(InscripcionDocenteBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  inscripcionDocenteDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(InscripcionDocenteBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  inscripcionDocenteDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(InscripcionDocenteBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InscripcionDocenteBean getBuscarPorObjecto(InscripcionDocenteBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InscripcionDocenteBean> getBuscarPorFiltros(
			InscripcionDocenteBean t) throws ServiceException {
		List<InscripcionDocenteBean> lstInscripcionDocenteBean=null;
		try {
			System.out.println("en listado InscripcionDocenteBean service imp");
			lstInscripcionDocenteBean=(List<InscripcionDocenteBean>) inscripcionDocenteDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstInscripcionDocenteBean;
	}

	@Override
	public boolean existe(InscripcionDocenteBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dar_baja_docente_x_InscripcionDocente(
			InscripcionDocenteBean inscripcionDocenteBean)
			throws ServiceException {
		Boolean sw = false;
		try {
			sw =  inscripcionDocenteDAO.dar_baja_docente_x_InscripcionDocente(inscripcionDocenteBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	

}
