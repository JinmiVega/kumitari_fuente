 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
 

@Transactional(readOnly = true)
public interface InscripcionLenguaDAO  extends BaseDAO<InscripcionLenguaBean>  {
	
	public List<InscripcionLenguaBean> listarInscripcionLengua(InscripcionLenguaBean inscripcionLenguaBean)throws DAOException;

	public InscripcionLenguaBean getBuscarPorObjectoDetalleMatricula(InscripcionLenguaBean inscripcionLenguaBean) throws DAOException;
	
 
	public List<InscripcionLenguaBean> listarMatriculasHechas(MatriculaAlumnoBean matriculaAlumnoBean, InscripcionLenguaBean inscripcionLenguaBean)throws DAOException;
 
	public boolean updatenumcupos(InscripcionLenguaBean inscripcionLenguaBean) throws DAOException;
	
 
	public List<InscripcionLenguaBean> listarInscripcionLenguaxNombre(InscripcionLenguaBean inscripcionLenguaBean)throws DAOException;
}
