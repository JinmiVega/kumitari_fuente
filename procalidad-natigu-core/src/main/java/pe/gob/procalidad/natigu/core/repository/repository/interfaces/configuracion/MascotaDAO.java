 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.FondoBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean; 
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;


public interface MascotaDAO  extends BaseDAO<MascotaBean>  {
	public List<MascotaBean> getBuscarPorFiltrosAlumno(MascotaBean mascotaBean) throws DAOException;
	
	public MascotaBean getlistarMasctoSwPredetAlumno(MascotaBean mascotaBean) throws DAOException;
	
	public MascotaBean getlistarMasctoSwPredetSist(MascotaBean mascotaBean) throws DAOException;

	List<MascotaBean> getBuscarPorTiendaAlumno(MascotaBean mascotabean)
			throws DAOException;

}
