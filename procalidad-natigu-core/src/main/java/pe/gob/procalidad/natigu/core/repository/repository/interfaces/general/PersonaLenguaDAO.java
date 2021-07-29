 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaLenguaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
 


public interface PersonaLenguaDAO  extends BaseDAO<PersonaLenguaBean>  {
	public List<PersonaLenguaBean> getBuscarPorCodigoPersona(PersonaLenguaBean personaLenguaBean) throws DAOException;
}
