package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import pe.gob.procalidad.natigu.core.bean.bean.generico.OrdenarParrafoCabeceraBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface OrdenarParrafoCabeceraService extends BaseService<OrdenarParrafoCabeceraBean>{
public OrdenarParrafoCabeceraBean listarCodigoTipoEjercicio(OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean) throws ServiceException;
}
