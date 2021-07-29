package pe.gob.procalidad.natigu.core.service.service.interfaces.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionDocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;


public interface DocenteService extends BaseService<DocenteBean> {
	
	public List<DocenteBean> getBuscarxCodigoInstitucion(DocenteBean docenteBean) throws ServiceException;

	public DocenteBean getBuscarxdni(DocenteBean docenteBean) throws ServiceException;
	
	public List<DocenteBean> getBuscarXInstitucionNombreNumeroDocumentoTipoDocumento(InscripcionDocenteBean docenteBean) throws DAOException;
	
	public List<DocenteBean> listarDocenteXCodigoInstitucionYCodigoLengua(MatriculaBean matriculaBean) throws ServiceException;
	
	public List<DocenteBean> getBuscarPorNumeroDocumento(DocenteBean docenteBean) throws ServiceException;
	
	public List<DocenteBean> getBuscarxCodigoInstitucionDetalleNombreDocum(DocenteBean docenteBean) throws ServiceException;

	public DocenteBean getBuscar_por_codigopersona(PersonaBean personaBean) throws ServiceException;
}

 