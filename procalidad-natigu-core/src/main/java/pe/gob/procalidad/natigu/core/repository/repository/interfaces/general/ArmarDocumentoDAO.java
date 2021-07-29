package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.ArmarDocumentoBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface ArmarDocumentoDAO  extends BaseDAO<ArmarDocumentoBean> {

	public List<ArmarDocumentoBean> listarArmarDocuCabDetTodo(ArmarDocumentoBean armarDocumentoBean) throws DAOException;
	
}