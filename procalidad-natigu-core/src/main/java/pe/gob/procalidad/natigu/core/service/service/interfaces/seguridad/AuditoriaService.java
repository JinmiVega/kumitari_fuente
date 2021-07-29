package pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaAccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaDetalleBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaTablaBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface AuditoriaService extends BaseService<AuditoriaBean>{
	
	public List<AuditoriaTablaBean> listarTablas(AuditoriaTablaBean prmAuditoriaTablaBean) throws ServiceException;
	
	public List<AuditoriaDetalleBean> listarAuditoriaDetalle(AuditoriaDetalleBean prmAuditoriaDetalleBean) throws ServiceException;
	
	public boolean insertarAuditoriaAcceso(AuditoriaAccesoBean prmAuditoriaAccesoBean) throws ServiceException;
	
	public List<AuditoriaAccesoBean> listarAuditoriaAcceso(AuditoriaAccesoBean prmAuditoriaAccesoBean) throws ServiceException;
	
}