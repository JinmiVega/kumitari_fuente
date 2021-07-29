package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;


//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface RelacionService extends BaseService<RelacionBean>{
	public List<RelacionBean> buscarPorRelacionCabecera(RelacionBean relacionBean) throws ServiceException;
	public List<RelacionBean> listarTextoTexto(RelacionBean relacionBean) throws ServiceException;
	public List<RelacionBean> listarCrucigrama(RelacionBean relacionBean) throws ServiceException;
	public List<RelacionBean> listarTextoTextoImagen(RelacionBean relacionBean) throws ServiceException;
	public List<RelacionBean> listarRelacionTodo(RelacionBean relacionBean) throws ServiceException;
	public List<RelacionBean> listarTextoParrafo(RelacionBean relacionBean) throws ServiceException;
}
