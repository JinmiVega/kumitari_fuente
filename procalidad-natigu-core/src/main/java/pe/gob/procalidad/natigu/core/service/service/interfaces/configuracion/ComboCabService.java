package pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.CombosCabBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.FondoBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface ComboCabService extends BaseService<CombosCabBean>  {
	public List<CombosCabBean> getBuscarPorCombosAlumno(CombosCabBean comboBean)
			throws ServiceException;
	public CombosCabBean getBuscarPorComboAlumno(CombosCabBean comboCabBean) throws ServiceException; 
	public List<CombosCabBean> getBuscarTodos(CombosCabBean comboCabBean) throws ServiceException;
}
