package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;




import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface UbigeoService extends BaseService<UbigeoBean>{
	public List<UbigeoBean> listarRegion() throws ServiceException;
	public List<UbigeoBean> listarProvincia(UbigeoBean ubigeoBean) throws ServiceException;
	public List<UbigeoBean> listarDistrito(UbigeoBean ubigeoBean)throws ServiceException;
}
