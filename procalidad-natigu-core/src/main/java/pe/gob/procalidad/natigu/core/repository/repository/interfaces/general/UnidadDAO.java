package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface UnidadDAO extends BaseDAO<UnidadBean>
{
	public UnidadBean buscarLengua(LenguaEstructuraBean lenguaEstructuraBean) throws DAOException;
	
	public List<UnidadBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws DAOException;
}
