package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;



 
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionVariadaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface RelacionVariadaService extends BaseService<RelacionVariadaBean>{
	public List<RelacionVariadaBean> buscarPorRelacionCabecera(RelacionVariadaBean relacionVariadaBean) throws ServiceException;

	List<RelacionVariadaBean> getBuscarTodoxMTE(RelacionVariadaBean Bean)
			throws ServiceException;
	 
}
