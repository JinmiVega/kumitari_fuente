package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List; 

import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface TextoPalabraCorrectaDAO extends BaseDAO<TextoPalabraCorrectaBean>
{
	public List<TextoPalabraCorrectaBean> buscarPorMaterialEjercicio(MaterialEjercicioBean materialEjercicioBean) throws DAOException;

	TextoPalabraCorrectaBean getBuscarPorTEM(TextoPalabraCorrectaBean textoPalabraCorrectaBean) throws DAOException;

 
	
}
