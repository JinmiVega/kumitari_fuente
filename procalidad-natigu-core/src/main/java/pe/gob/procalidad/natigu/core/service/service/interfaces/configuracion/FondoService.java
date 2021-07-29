package pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.FondoBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface FondoService extends BaseService<FondoBean> {
	public List<FondoBean> getBuscarPorFiltrosAlumno(FondoBean fondoBean)
			throws ServiceException;
	
	public FondoBean getlistarFondoSwPredetAlumno(FondoBean fondoBean) throws ServiceException;

}
