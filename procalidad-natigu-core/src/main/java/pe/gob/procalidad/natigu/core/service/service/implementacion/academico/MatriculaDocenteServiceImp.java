package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaDocenteBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.MatriculaAlumnoDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.MatriculaDocenteDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.MatriculaAlumnoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.MatriculaDocenteService;

@Service("matriculaDocenteService")
@Transactional (readOnly = true)
public class MatriculaDocenteServiceImp implements MatriculaDocenteService {

	@Autowired
	private MatriculaDocenteDAO matriculaDocenteDAO;

	@Override
	public boolean insertar(MatriculaDocenteBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  matriculaDocenteDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(MatriculaDocenteBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  matriculaDocenteDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(MatriculaDocenteBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  matriculaDocenteDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public MatriculaDocenteBean getBuscarPorObjecto(MatriculaDocenteBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MatriculaDocenteBean> getBuscarPorFiltros(MatriculaDocenteBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(MatriculaDocenteBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MatriculaDocenteBean> listarDocentexMatricula(MatriculaDocenteBean matriculaDocenteBean)
			throws ServiceException {
		List<MatriculaDocenteBean> lstMatriculaDocenteBean=null;
		try {
			System.out.println("en listado matriculaDAO service imp");
			lstMatriculaDocenteBean= matriculaDocenteDAO.listarDocentexMatricula(matriculaDocenteBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstMatriculaDocenteBean;
	}

	@Override
	public MatriculaDocenteBean validarDocentexMatricula(MatriculaDocenteBean matriculaDocenteBean)
			throws DAOException {
		MatriculaDocenteBean oMatriculaDocenteBean=null;
		try {
			System.out.println("en listado matriculaDAO service imp");
			oMatriculaDocenteBean= matriculaDocenteDAO.validarDocentexMatricula(matriculaDocenteBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return oMatriculaDocenteBean;
	}
	
	
}
