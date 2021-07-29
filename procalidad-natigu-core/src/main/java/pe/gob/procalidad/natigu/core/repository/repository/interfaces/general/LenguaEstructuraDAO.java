 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;
 
import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaNivelBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
 


public interface LenguaEstructuraDAO  extends BaseDAO<LenguaEstructuraBean>  {
	 
	public List<LenguaEstructuraBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws DAOException;
	
	public List<LenguaEstructuraBean> listarNiveles(LenguaBean lenguaBean) throws DAOException;
	
	public List<LenguaEstructuraBean> listarPorCodigoNivelLengua(LenguaNivelBean lenguaNivelBean)  throws DAOException;
	
	public List<LenguaEstructuraBean> listarMaterial(LenguaEstructuraBean lenguaEstructuraBean) throws DAOException;
	
	public List<LenguaEstructuraBean> listarSubNiveles(LenguaEstructuraBean lenguaEstructuraBean) throws DAOException;
	
	public boolean insertarLenguaEstrucTemporal(LenguaBean lenguaBean) throws DAOException;
	
	public List<LenguaEstructuraBean> listarNivelesxLenguaAll(LenguaBean lenguaBean) throws DAOException;

	LenguaEstructuraBean getBuscar_MayorSubnivel(
			LenguaEstructuraBean LenguaEstructuraBean) throws DAOException;
	
}
