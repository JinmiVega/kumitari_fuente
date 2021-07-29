package pe.gob.procalidad.natigu.core.service.service.interfaces.general;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.generico.AlterTextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

public interface AlterTextoPalabraCorrectaService extends BaseService<AlterTextoPalabraCorrectaBean>{

	public List<AlterTextoPalabraCorrectaBean> buscarPorCodigoOracion(TextoPalabraCorrectaBean textoPalabraCorrectaBean) throws ServiceException;

	public List<AlterTextoPalabraCorrectaBean> getBuscarPorTextoPalabraCorrecta(AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws ServiceException;

	public List<AlterTextoPalabraCorrectaBean> buscarxPalabraxTexto(AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws ServiceException;

	public List<AlterTextoPalabraCorrectaBean> getBuscarTodoxMTE(AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws ServiceException;
	
	public List<AlterTextoPalabraCorrectaBean> getlistarNombrePalabraCorrectaYcodigoCab(AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws ServiceException;


}
