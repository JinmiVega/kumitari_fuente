package pe.gob.procalidad.natigu.core.service.service.interfaces.general;
  
import java.util.List;
 

import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface Maestra1Service extends BaseService<MaestraBean> {
	
	public List<MaestraBean> listarPorCodigoTabla(String codTabla,long tipo) throws ServiceException;  
	
	public List<MaestraBean> listarComboGeneral(String codTabla) throws ServiceException;

	public MaestraBean getBuscarPorTablaYRegistro(MaestraBean maestraBean) throws ServiceException; 
}
 
