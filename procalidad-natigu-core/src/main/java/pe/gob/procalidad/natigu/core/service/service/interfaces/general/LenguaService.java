package pe.gob.procalidad.natigu.core.service.service.interfaces.general;
 
import java.util.List;


import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface LenguaService extends BaseService<LenguaBean> {
	
	public List<LenguaBean> cargarCombo() throws ServiceException;
	 
	public List<LenguaBean> listarComboxInstitucion(InstitucionBean institucionBean) throws ServiceException;
	 
	public List<LenguaBean> listarInstitucionxCodigoInstitucion(InstitucionBean institucionBean) throws ServiceException;
	
	public List<LenguaBean> listarLenguaFaltantexCodigoInstitucion(InstitucionBean institucionBean) throws ServiceException;
	
	public List<LenguaBean> listarValidaLenguasxMatricula(UsuarioBean usuarioBean) throws ServiceException;

}
 
