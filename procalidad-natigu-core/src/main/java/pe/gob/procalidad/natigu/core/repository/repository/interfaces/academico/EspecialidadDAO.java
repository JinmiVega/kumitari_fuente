 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EspecialidadBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;


public interface EspecialidadDAO  extends BaseDAO<EspecialidadBean>  {
	 
	public List<EspecialidadBean> listarPorCodigoDocente(DocenteBean docenteBean) throws DAOException;
}
