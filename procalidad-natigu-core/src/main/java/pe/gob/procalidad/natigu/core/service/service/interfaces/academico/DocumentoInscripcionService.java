package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;
 
import java.util.List;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocumentoInscripcionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface DocumentoInscripcionService extends BaseService<DocumentoInscripcionBean> {
	  
	public List<DocumentoInscripcionBean> listarDocumentoInscripcionBeanxCodInsc(DocumentoInscripcionBean documentoInscripcionBean) throws ServiceException;
}

 