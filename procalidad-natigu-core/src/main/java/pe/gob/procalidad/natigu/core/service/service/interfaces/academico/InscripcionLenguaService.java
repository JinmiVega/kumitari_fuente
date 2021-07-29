package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;
 
import java.rmi.ServerException;
import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionLenguaBean;
 
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
 
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface InscripcionLenguaService extends BaseService<InscripcionLenguaBean> {
	  
	public List<InscripcionLenguaBean> listarInscripcionLengua(InscripcionLenguaBean inscripcionLenguaBean)throws ServerException;
	
	public InscripcionLenguaBean getBuscarPorObjectoDetalleMatricula(InscripcionLenguaBean inscripcionLenguaBean) throws ServerException;
	
	public boolean updatenumcupos(InscripcionLenguaBean inscripcionLenguaBean) throws ServerException;

	public List<InscripcionLenguaBean>  listarMatriculasHechas(MatriculaAlumnoBean matriculaAlumnoBean, InscripcionLenguaBean inscripcionLenguaBean)throws ServerException;
	
	public List<InscripcionLenguaBean> listarInscripcionLenguaxNombre(InscripcionLenguaBean inscripcionLenguaBean)throws ServerException;
}

 