package pe.gob.procalidad.natigu.core.service.service.interfaces.general;
  
import java.util.List;
 
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface Maestra2Service extends BaseService<MaestraBean> {
	
	public List<MaestraBean> listarPorCodigoTabla(String codTabla,long tipo) throws ServiceException;  
	
	public List<MaestraBean> listarPorValor1(MaestraBean maestraBean)  throws ServiceException; 
	
}
 
