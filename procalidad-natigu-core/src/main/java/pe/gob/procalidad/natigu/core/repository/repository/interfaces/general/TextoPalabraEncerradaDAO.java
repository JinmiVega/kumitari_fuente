package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraEncerradaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

@Transactional(readOnly = true)
public interface TextoPalabraEncerradaDAO extends BaseDAO<TextoPalabraEncerradaBean>
{
	public List<TextoPalabraEncerradaBean> buscarPorMaterialEjercicio(MaterialEjercicioBean materialEjercicioBean) throws DAOException;

	public TextoPalabraEncerradaBean getBuscarPorTEM(TextoPalabraEncerradaBean textoPalabraEncerradaBean) throws DAOException;

 
	
}
