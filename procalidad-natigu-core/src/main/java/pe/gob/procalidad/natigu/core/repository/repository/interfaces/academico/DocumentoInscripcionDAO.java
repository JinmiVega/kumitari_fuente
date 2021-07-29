 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;

import java.util.List;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocumentoInscripcionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;


public interface DocumentoInscripcionDAO  extends BaseDAO<DocumentoInscripcionBean>  {
	 
	public List<DocumentoInscripcionBean> listarDocumentoInscripcionBeanxCodInsc(DocumentoInscripcionBean documentoInscripcionBean) throws DAOException;
}
