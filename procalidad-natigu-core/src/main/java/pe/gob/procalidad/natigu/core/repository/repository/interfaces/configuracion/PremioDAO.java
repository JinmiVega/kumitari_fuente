 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion;

 
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;


public interface PremioDAO  extends BaseDAO<PremioBean>  {

	PremioBean getBuscarPorAluMedalla(PremioBean premioBean)
			throws DAOException;
	 

}
