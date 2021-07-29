 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.general;

import java.util.List;


import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
 


public interface LenguaDAO  extends BaseDAO<LenguaBean>  {
	 
	public List<LenguaBean> listarCombo() throws DAOException;
	
	public List<LenguaBean> listarComboxInstitucion(InstitucionBean institucionBean) throws DAOException;

	public List<LenguaBean> listarInstitucionxCodigoInstitucion(InstitucionBean institucionBean) throws DAOException;
	
	public List<LenguaBean> listarLenguaFaltantexCodigoInstitucion(InstitucionBean institucionBean) throws DAOException;
	
	public List<LenguaBean> listarValidaLenguasxMatricula(UsuarioBean usuarioBean) throws DAOException;

}
