 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;
 
import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaNivelBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
 


public interface LenguaNivelDAO  extends BaseDAO<LenguaNivelBean>  {
	 
	public List<LenguaNivelBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws DAOException;
	 
	
}
