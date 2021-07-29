 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaNacionalidadBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
 


public interface PersonaNacionalidadDAO  extends BaseDAO<PersonaNacionalidadBean>  {
	public List<PersonaNacionalidadBean> getBuscarPorCodigoPersona(PersonaNacionalidadBean personaNacionalidadBean) throws DAOException ;
}
