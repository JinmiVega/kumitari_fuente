package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;
import pe.gob.procalidad.natigu.core.bean.bean.generico.AlterTextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionAlterBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface AlterTextoPalabraCorrectaDAO extends BaseDAO<AlterTextoPalabraCorrectaBean>
{
 
	public List<AlterTextoPalabraCorrectaBean> getBuscarPorTextoPalabraCorrecta(AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws DAOException;

	public List<AlterTextoPalabraCorrectaBean> buscarxPalabraxTexto(AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean)throws DAOException;
	
	public List<AlterTextoPalabraCorrectaBean> getBuscarTodoxMTE(AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws DAOException;
	
	public List<AlterTextoPalabraCorrectaBean> getlistarNombrePalabraCorrectaYcodigoCab(AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws DAOException;

}
