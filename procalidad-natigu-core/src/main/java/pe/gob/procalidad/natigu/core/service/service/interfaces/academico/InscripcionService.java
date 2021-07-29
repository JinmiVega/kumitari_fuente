package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;
 
import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface InscripcionService extends BaseService<InscripcionBean> {
	  
	public InscripcionBean getNumcuposXcodInstiCodLengua(InscripcionBean inscripcionBean) throws ServiceException;
	
	public List<InscripcionBean> getBuscarPorFiltrosxperfil(InscripcionBean inscripcion, UsuarioBean usu) throws ServiceException;
	
}

 