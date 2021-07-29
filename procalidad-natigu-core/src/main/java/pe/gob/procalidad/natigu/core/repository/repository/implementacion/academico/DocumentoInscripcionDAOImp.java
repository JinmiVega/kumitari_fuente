package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery; 

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.DocumentoInscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaDocenteBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeomvdMatdocente;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcDocinscripcion;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcInscripcion; 
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.DocumentoInscripcionDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.InscripcionDAO; 
 
@Transactional
@Repository("documentoinscripcionDAO")
public class DocumentoInscripcionDAOImp implements DocumentoInscripcionDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	

	private List<DocumentoInscripcionBean> deListaDocumentoInscripcionAListaDocumentoInscripcionBean(List<LeotbcDocinscripcion> lstLeotbcDocinscripcion) {
		
		List<DocumentoInscripcionBean> lstDocumentoInscripcionBean = null;
		
		if (lstLeotbcDocinscripcion != null && lstLeotbcDocinscripcion.size() > 0) {
			
			lstDocumentoInscripcionBean = new ArrayList<DocumentoInscripcionBean>();
			
			for (int i = 0; i < lstLeotbcDocinscripcion.size(); i++) { 
				LeotbcDocinscripcion entity = lstLeotbcDocinscripcion.get(i);
				DocumentoInscripcionBean bean = deDocumentoInscripcionADocumentoInscripcionBean(entity);
				
				lstDocumentoInscripcionBean.add(bean);
			}
		}
		
		return lstDocumentoInscripcionBean;
	}
	
	private DocumentoInscripcionBean deDocumentoInscripcionADocumentoInscripcionBean(LeotbcDocinscripcion entity) {
		
		DocumentoInscripcionBean bean = null;
		
		if (entity != null) {
			
			bean = new DocumentoInscripcionBean();
			
			bean.setCodigo(entity.getnCoddocinscri()); 
			bean.getInscripcion().setCodigo(entity.getnCodinscr());
			bean.setRutadocu(entity.getvRutadocu());
			bean.setNombdocu(entity.getvNombdocu());
			bean.setNumedocu(entity.getvNumedocu());
		
			bean.getSituacion().setCodigoRegistro(entity.getnSitdocinscri());
//			bean.getSituacion().setNombreCorto(entity.getVnomcorto());
		
		}
		
		return bean;
	}

	@Override
	public boolean insertar(DocumentoInscripcionBean documentoInscripcionBean) throws DAOException {
		Object idDocumentoInscripcionBean= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_docinscripcion.insertar");
			

//			spq.setParameter("p_coddocinscri", 		documentoInscripcionBean.getCodigo());
			spq.setParameter("p_codinscr", 		documentoInscripcionBean.getInscripcion().getCodigo());
			spq.setParameter("p_rutadocu",	 	documentoInscripcionBean.getRutadocu());
			spq.setParameter("p_numedocu",	 	documentoInscripcionBean.getNumedocu());
			spq.setParameter("p_nombdocu",	 	documentoInscripcionBean.getNombdocu());
			
			spq.setParameter("p_codusureg", 	documentoInscripcionBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", 		documentoInscripcionBean.getIpCreacion()); 
			
			spq.execute();
			
			idDocumentoInscripcionBean = spq.getOutputParameterValue(1);
			if (idDocumentoInscripcionBean != null) {
				documentoInscripcionBean.setCodigo(Integer.valueOf(idDocumentoInscripcionBean.toString()));
				sw=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean actualizar(DocumentoInscripcionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(DocumentoInscripcionBean documentoInscripcionBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_docinscripcion.eliminar");
			spq.setParameter("p_coddocinscri", 	documentoInscripcionBean.getCodigo()); 
			spq.setParameter("p_codusumod", documentoInscripcionBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod",	documentoInscripcionBean.getIpModificacion());
			spq.execute();  
			sw=true;
			 
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public DocumentoInscripcionBean getBuscarPorObjecto(DocumentoInscripcionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocumentoInscripcionBean> getBuscarPorFiltros(DocumentoInscripcionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(DocumentoInscripcionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DocumentoInscripcionBean> listarDocumentoInscripcionBeanxCodInsc(DocumentoInscripcionBean documentoInscripcionBean) throws DAOException {
		List<LeotbcDocinscripcion> lstLeotbcDocinscripcion = null;	
		List<DocumentoInscripcionBean> lstDocumentoInscripcionBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_docinscripcion.listar_por_codigoisncrip");
			spq.setParameter("p_codinscr", documentoInscripcionBean.getInscripcion().getCodigo());   
			if (spq.execute()) {
				lstLeotbcDocinscripcion =  spq.getResultList(); 
			} 
			if (lstLeotbcDocinscripcion != null && lstLeotbcDocinscripcion.size() > 0) {
				
				lstDocumentoInscripcionBean = deListaDocumentoInscripcionAListaDocumentoInscripcionBean(lstLeotbcDocinscripcion);
			}
		em.close();
			
		   
		return lstDocumentoInscripcionBean;
	}



}
