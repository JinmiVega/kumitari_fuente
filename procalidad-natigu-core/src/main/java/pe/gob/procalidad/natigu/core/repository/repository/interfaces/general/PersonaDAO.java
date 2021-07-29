 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;


import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
 


public interface PersonaDAO  extends BaseDAO<PersonaBean>  {
	
	public PersonaBean buscarxTipoDocumentoNumeroDocumento(PersonaBean personaBean)throws DAOException;
	 
	public boolean actualizardatosuser(PersonaBean personaBean)throws DAOException;
	
	public boolean actualizardatosfotouser(PersonaBean personaBean)throws DAOException;
}
