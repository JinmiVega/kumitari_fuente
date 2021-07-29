 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;


public interface InscripcionDAO  extends BaseDAO<InscripcionBean>  {
	 
	public InscripcionBean getNumcuposXcodInstiCodLengua(InscripcionBean inscripcionBean) throws DAOException;
	public List<InscripcionBean> getBuscarPorFiltrosxperfil(InscripcionBean inscripcionBean, UsuarioBean usu) throws DAOException;
	
}
