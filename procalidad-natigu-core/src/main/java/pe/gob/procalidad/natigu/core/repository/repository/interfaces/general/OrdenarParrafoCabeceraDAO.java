package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import pe.gob.procalidad.natigu.core.bean.bean.generico.OrdenarParrafoCabeceraBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface OrdenarParrafoCabeceraDAO extends BaseDAO<OrdenarParrafoCabeceraBean>{

	public OrdenarParrafoCabeceraBean listarCodigoTipoEjercicio(OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean) throws DAOException;
}
