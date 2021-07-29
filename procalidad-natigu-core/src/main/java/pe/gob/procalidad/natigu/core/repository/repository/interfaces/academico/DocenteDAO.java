 package pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionDocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;


public interface DocenteDAO  extends BaseDAO<DocenteBean>  {
	 
	
	public List<DocenteBean> getBuscarxCodigoInstitucion(DocenteBean docenteBean) throws DAOException;
	
	public DocenteBean getBuscarxdni(DocenteBean docenteBean) throws DAOException;
	
	public List<DocenteBean> getBuscarXInstitucionNombreNumeroDocumentoTipoDocumento(InscripcionDocenteBean docenteBean) throws DAOException;
	
	public List<DocenteBean> listarDocenteXCodigoInstitucionYCodigoLengua(MatriculaBean matriculaBean) throws DAOException;
	
	public List<DocenteBean> getBuscarPorNumeroDocumento(DocenteBean docenteBean) throws DAOException;
	
	public List<DocenteBean> getBuscarxCodigoInstitucionDetalleNombreDocum(DocenteBean docenteBean) throws DAOException;
	
	public DocenteBean getBuscar_por_codigopersona(PersonaBean personaBean) throws DAOException;
	
}
