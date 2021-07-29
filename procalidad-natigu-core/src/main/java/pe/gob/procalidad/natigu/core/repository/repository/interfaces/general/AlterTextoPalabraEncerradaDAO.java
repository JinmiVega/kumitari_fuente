package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.AlterTextoPalabraEncerradaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

@Transactional(readOnly = true)
public interface AlterTextoPalabraEncerradaDAO extends BaseDAO<AlterTextoPalabraEncerradaBean>
{
 
	public List<AlterTextoPalabraEncerradaBean> getBuscarPorTextoPalabraCorrecta(AlterTextoPalabraEncerradaBean alterTextoPalabraEncerradaBean) throws DAOException;

	public AlterTextoPalabraEncerradaBean buscarxPalabraxTexto(AlterTextoPalabraEncerradaBean alterTextoPalabraEncerradaBean)throws DAOException;

	public List<AlterTextoPalabraEncerradaBean> buscarxCabeceraxDetalle(AlterTextoPalabraEncerradaBean alterTextoPalabraEncerradaBean) throws DAOException;
	
}
