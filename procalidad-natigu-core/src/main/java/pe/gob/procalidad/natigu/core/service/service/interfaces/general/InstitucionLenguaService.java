package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionLenguaBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface InstitucionLenguaService extends BaseService<InstitucionLenguaBean> {
	public List<InstitucionLenguaBean> existeLengua(InstitucionLenguaBean institucionLenguaBean) throws ServiceException;
	public List<InstitucionLenguaBean> reporteAlumLengInst(InstitucionLenguaBean institucionLenguaBean) throws ServiceException;
}
