package pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion;
  
import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.FondoBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface MascotaService extends BaseService<MascotaBean> {
	public List<MascotaBean> getBuscarPorFiltrosAlumno(MascotaBean mascotaBean) throws ServiceException ;
	
	public MascotaBean getlistarMasctoSwPredetAlumno(MascotaBean mascotaBean) throws ServiceException ;
	
	public MascotaBean getlistarMasctoSwPredetSist(MascotaBean mascotaBean) throws ServiceException ;

	List<MascotaBean> getBuscarPorTiendaAlumno(MascotaBean mascotaBean)
			throws ServiceException;
}
 
