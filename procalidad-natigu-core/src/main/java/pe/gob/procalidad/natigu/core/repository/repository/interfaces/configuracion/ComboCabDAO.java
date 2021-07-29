package pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.CombosCabBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.FondoBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface ComboCabDAO  extends BaseDAO<CombosCabBean> {
	public List<CombosCabBean> getBuscarPorCombosAlumno(CombosCabBean comboBean) throws DAOException;
	public CombosCabBean getBuscarPorComboAlumno(CombosCabBean comboCabBean) throws DAOException;
	public List<CombosCabBean> getBuscarTodos(CombosCabBean comboCabBean) throws DAOException;
}
