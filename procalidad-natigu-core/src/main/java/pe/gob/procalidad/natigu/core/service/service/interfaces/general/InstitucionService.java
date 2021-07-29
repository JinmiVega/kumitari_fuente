package pe.gob.procalidad.natigu.core.service.service.interfaces.general;
 
import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface InstitucionService extends BaseService<InstitucionBean> {

	
	public List<InstitucionBean> getListarCombo(InstitucionBean InstitucionBean) throws ServiceException;
	public boolean actulizarUbicacion(InstitucionBean institucionBean)throws ServiceException;
	public boolean actulizarDirector(InstitucionBean institucionBean) throws ServiceException;
	public List<InstitucionBean> lsitarDirectores() throws ServiceException;
	//public List<InstitucionBean> listarInstitucionxCodigoPersona(int codigoPerson) throws ServiceException;
	public List<InstitucionBean> listarInstitucionxTipoUsuario(UsuarioBean usuarioBean) throws ServiceException;
}
 
