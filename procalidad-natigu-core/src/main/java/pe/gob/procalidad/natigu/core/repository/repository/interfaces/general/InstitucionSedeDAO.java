package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionSedeBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface InstitucionSedeDAO extends BaseDAO<InstitucionSedeBean> {
	public List<InstitucionSedeBean> listaInsticionSedes() throws DAOException;
}
