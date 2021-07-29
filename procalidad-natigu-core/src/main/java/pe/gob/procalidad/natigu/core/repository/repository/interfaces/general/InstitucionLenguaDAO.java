package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionLenguaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface InstitucionLenguaDAO extends BaseDAO<InstitucionLenguaBean>{
	
	public List<InstitucionLenguaBean> existeLengua(InstitucionLenguaBean institucionLenguaBean)throws DAOException;
	
	public List<InstitucionLenguaBean> reporteAlumLengInst(InstitucionLenguaBean institucionLenguaBean)throws DAOException;
}
