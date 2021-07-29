package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.base.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface UbigeoDAO extends BaseDAO<UbigeoBean>{

	public List<UbigeoBean> listarRegion() throws DAOException;
	public List<UbigeoBean> listarProvincia(UbigeoBean ubigeoBean) throws DAOException;
	public List<UbigeoBean> listarDistrito(UbigeoBean ubigeoBean)throws DAOException;
}
