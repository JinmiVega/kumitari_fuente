 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface Maestra1DAO  extends BaseDAO<MaestraBean>  {
	
	public List<MaestraBean> listarPorCodigoTabla(String codTabla,long tipo) throws DAOException;
	
	public List<MaestraBean> listarComboGeneral(String codTabla) throws DAOException;

	public MaestraBean getBuscarPorTablaYRegistro(MaestraBean maestraBean) throws DAOException;
	
 
	
}
