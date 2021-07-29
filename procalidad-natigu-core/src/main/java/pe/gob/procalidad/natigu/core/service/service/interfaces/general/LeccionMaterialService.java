package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LeccionMaterialBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface LeccionMaterialService extends BaseService<LeccionMaterialBean>{

	public List<LeccionMaterialBean> buscarPorLeccion(LeccionMaterialBean materialBean) throws ServiceException;
	public boolean actualizarOrden(LeccionMaterialBean t) throws ServiceException;
}
