package pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion;


import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.FondoBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface FondoDAO extends BaseDAO<FondoBean>{
	public List<FondoBean> getBuscarPorFiltrosAlumno(FondoBean fondoBean) throws DAOException;
	
	public FondoBean getlistarFondoSwPredetAlumno(FondoBean fondoBean) throws DAOException;

}
