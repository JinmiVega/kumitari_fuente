package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;

//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionCabeceraBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface RelacionCabeceraService extends BaseService<RelacionCabeceraBean>{
	public List<RelacionCabeceraBean> buscarPorEjercicio(RelacionCabeceraBean relacionCabeceraBean) throws ServiceException;
	public List<RelacionCabeceraBean> busccarPorMatTEjerRelacionCab(RelacionCabeceraBean relacionCabeceraBean) throws ServiceException;
	RelacionCabeceraBean getBuscarPorTEM(RelacionCabeceraBean beBean)
			throws ServiceException;
}
