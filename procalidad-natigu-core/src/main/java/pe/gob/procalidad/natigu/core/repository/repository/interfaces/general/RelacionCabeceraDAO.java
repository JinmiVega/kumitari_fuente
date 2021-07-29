package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;


import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraciBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionCabeceraBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface RelacionCabeceraDAO extends BaseDAO<RelacionCabeceraBean>
{
	public List<RelacionCabeceraBean> buscarPorEjercicio(RelacionCabeceraBean relacionCabeceraBean) throws DAOException;
	public List<RelacionCabeceraBean> buscarPorMatTEjerRelacionCab(RelacionCabeceraBean relacionCabeceraBean) throws DAOException;
	RelacionCabeceraBean getBuscarPorTEM(RelacionCabeceraBean beBean)
			throws DAOException;
	
}
