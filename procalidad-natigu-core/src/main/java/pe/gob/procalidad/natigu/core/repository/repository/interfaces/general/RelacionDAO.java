package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;

//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface RelacionDAO extends BaseDAO<RelacionBean>
{
	public List<RelacionBean> buscarPorRelacionCabecera(RelacionBean relacionBean) throws DAOException;
	public List<RelacionBean> listarTextoTexto(RelacionBean relacionBean) throws DAOException;
	public List<RelacionBean> listarCrucigrama(RelacionBean relacionBean) throws DAOException;
	public List<RelacionBean> listarTextoTextoImagen(RelacionBean relacionBean) throws DAOException;
	public List<RelacionBean> listarRelacionTodo(RelacionBean relacionBean) throws DAOException;
	public List<RelacionBean> listarTextoParrafo(RelacionBean relacionBean)throws DAOException;
}
