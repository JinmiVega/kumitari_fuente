package pe.gob.procalidad.natigu.core.service.service.interfaces.general;
 
import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaNivelBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface LenguaEstructuraService extends BaseService<LenguaEstructuraBean> {
	
	public List<LenguaEstructuraBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws ServiceException; 
	
	public List<LenguaEstructuraBean> listarNiveles(LenguaBean lenguaBean) throws ServiceException;
	
	public List<LenguaEstructuraBean> listarMaterial(LenguaEstructuraBean lenguaEstructuraBean) throws ServiceException;  
	
	public List<LenguaEstructuraBean> listarPorCodigoNivelLengua(LenguaNivelBean lenguaNivelBean) throws ServiceException;  
	
	public List<LenguaEstructuraBean> listarSubNiveles(LenguaEstructuraBean lenguaEstructuraBean) throws ServiceException;
	
	public boolean insertarLenguaEstrucTemporal(LenguaBean lenguaBean)  throws ServiceException; 
	
	public List<LenguaEstructuraBean> listarNivelesxLenguaAll(LenguaBean lenguaBean) throws ServiceException;

	LenguaEstructuraBean getBuscarMayorSubnivel(LenguaEstructuraBean lenguaBean)
			throws ServiceException;
	 
}
 
