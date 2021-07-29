package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery; 

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;  

import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcInscripcion; 
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.InscripcionDAO; 
 
@Transactional
@Repository("inscripcionDAO")
public class InscripcionDAOImp implements InscripcionDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	public InscripcionBean getInscripcionBean(Object object){
		return (InscripcionBean)object;
	}


	private List<InscripcionBean> deListaInscripcionAListaInscripcionBean(List<LeotbcInscripcion> lstInscripcion) {
		
		List<InscripcionBean> lstInscripcionBean = null;
		
		if (lstInscripcion != null && lstInscripcion.size() > 0) {
			
			lstInscripcionBean = new ArrayList<InscripcionBean>();
			
			for (int i = 0; i < lstInscripcion.size(); i++) { 
				LeotbcInscripcion entity = lstInscripcion.get(i);
				InscripcionBean bean = deInscripcionAInscripcionBean(entity);
				
				lstInscripcionBean.add(bean);
			}
		}
		
		return lstInscripcionBean;
	}
	
	private InscripcionBean deInscripcionAInscripcionBean(LeotbcInscripcion entity) {
		
		InscripcionBean bean = null;
		
		if (entity != null) {
			
			bean = new InscripcionBean();
			
			bean.setCodigo(entity.getnCodinscr()); 
			bean.setNumCupos(entity.getvNumcupos()); 
			bean.getInstitucion().setCodigo(entity.getnCodinsti());
			bean.getInstitucion().setNombreInstitucion(entity.getvNominsti());
			bean.getLengua().setCodigo(entity.getnCodlengua());
			bean.getLengua().setNombre(entity.getvNomlengua());
			bean.getSituacion().setCodigoRegistro(entity.getnTm2sitin());
			bean.getSituacion().setNombreCorto(entity.getVnomcorto());
			bean.getPeriodo().setCodigoRegistro(entity.getvPeriodo()!= null ? Integer.valueOf(entity.getvPeriodo()): 0);
			bean.setNombreDocumento(entity.getvNomdocum());
			bean.setNumeroDocumento(entity.getvNumdocum());
			bean.setRutaDocumento(entity.getvRutadocu());
			System.out.println("entity.getnTm2ciclo() " +entity.getnTm2ciclo());
			bean.getCiclo().setCodigoRegistro((int)entity.getnTm2ciclo());
			bean.getCiclo().setNombreCorto(entity.getVnombreciclo());
			bean.setRutaDocumento(entity.getvRutadocu());
			System.out.println("entity.getDfecharegistro() " +entity.getDfecharegistro());
			
			bean.setFechaRegistro(entity.getDfecharegistro());
			bean.setFechavdRegistro(entity.getVd_fecreg());
			bean.setFechavdSincronizacion(entity.getVd_fecsincro());
			bean.setTipoAcceso(entity.getnTipoacceso());
			bean.setNomtipoAcceso(entity.getvTipoacceso());
		}
		
		return bean;
	}


	@Override
	public boolean insertar(InscripcionBean inscripcion) throws DAOException {

		Object idInstitucion= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_inscripcion.insertar");
			spq.setParameter("p_codinsti", inscripcion.getInstitucion().getCodigo());
			spq.setParameter("p_numcupos", inscripcion.getNumCupos());
			spq.setParameter("p_codlengua", inscripcion.getLengua().getCodigo());
			spq.setParameter("p_tm2sitin", inscripcion.getSituacion().getCodigoRegistro());
			spq.setParameter("p_periodo", String.valueOf(inscripcion.getPeriodo().getCodigoRegistro()));
			spq.setParameter("p_numdocum", "");
			spq.setParameter("p_nomdocum", "");
			spq.setParameter("p_rutadocu", "");
			spq.setParameter("p_tm2ciclo", inscripcion.getCiclo().getCodigoRegistro());
			spq.setParameter("p_codusureg", inscripcion.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", inscripcion.getIpCreacion()); 
			spq.setParameter("p_fecharegistro", inscripcion.getFechaRegistro());
			spq.setParameter("p_tipoacceso", inscripcion.getTipoAcceso());
			
			System.out.println("inscripcion.getFechaRegistro() " + inscripcion.getFechaRegistro());
			spq.execute();
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			
			idInstitucion = spq.getOutputParameterValue(1);
			if (idInstitucion != null) {
				inscripcion.setCodigo(Integer.valueOf(idInstitucion.toString()));
				if (inscripcion.getCodigo()==0) {
					sw=false;
				}
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
	public boolean actualizar(InscripcionBean inscripcion) throws DAOException {
		Object idInscripcion= null;
		boolean sw=false;
		System.out.println("lenguaBean actualizar " + inscripcion );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_inscripcion.actualizar");
			spq.setParameter("p_codinscri", inscripcion.getCodigo());
			spq.setParameter("p_codinsti", inscripcion.getInstitucion().getCodigo());
			spq.setParameter("p_periodo", String.valueOf(inscripcion.getPeriodo().getCodigoRegistro()));
			spq.setParameter("p_numcupos", inscripcion.getNumCupos());
			spq.setParameter("p_codlengua", inscripcion.getLengua().getCodigo());
			spq.setParameter("p_tm2sitin", Integer.valueOf(inscripcion.getSituacion().getCodigoRegistro()));
			spq.setParameter("p_tm2ciclo", inscripcion.getCiclo().getCodigoRegistro());
			spq.setParameter("p_codusumod", inscripcion.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", inscripcion.getIpModificacion()); 
			spq.setParameter("p_fecharegistro", inscripcion.getFechaRegistro()); 
			spq.setParameter("p_tipoacceso", inscripcion.getTipoAcceso());

			spq.execute();   
			sw=true;
			 
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idInscripcion = spq.getOutputParameterValue(1);
			if (idInscripcion != null) {
				inscripcion.setRetorno(Integer.valueOf(idInscripcion.toString()));
				if (inscripcion.getRetorno()==0) {
					sw=false;
				}
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
	public boolean eliminar(InscripcionBean inscripcion) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_inscripcion.eliminar");
			spq.setParameter("p_codinscr", inscripcion.getCodigo()); 
			spq.setParameter("p_codusumod", inscripcion.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", inscripcion.getIpModificacion());
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
	public InscripcionBean getBuscarPorObjecto(InscripcionBean inscripcion) throws DAOException {
		InscripcionBean oInscripcionBean = null;
		List<LeotbcInscripcion> lstLeotbcInscripcion = null;
		System.out.println("inscripcion getBuscarPorObjecto " + inscripcion.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_inscripcion.buscar_por_codigo");			
			spq.setParameter("p_codinscr", inscripcion.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcInscripcion = spq.getResultList();			
			}
			
			if (	lstLeotbcInscripcion != null
				&&	lstLeotbcInscripcion.size() > 0) {
				System.out.println("lstLeotbcInscripcion.size() " + lstLeotbcInscripcion.size());
				oInscripcionBean = deInscripcionAInscripcionBean(lstLeotbcInscripcion.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oInscripcionBean;
	}


	@Override
	public List<InscripcionBean> getBuscarPorFiltros(InscripcionBean inscripcion) throws DAOException {
		System.out.println("em " + em);
		List<LeotbcInscripcion> lstInscripcion= null;	
		List<InscripcionBean> lstInscripcionBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_inscripcion.buscar_por_filtros");
			spq.setParameter("p_codisnti", inscripcion.getInstitucion().getCodigo());  
			spq.setParameter("p_tm2sitin", inscripcion.getSituacion().getCodigoRegistro());  
			spq.setParameter("p_codusuario", inscripcion.getAudCodigoUsuario()); 
			if (spq.execute()) {
				lstInscripcion =  spq.getResultList(); 
			} 
			if (lstInscripcion != null && lstInscripcion.size() > 0) {
				
				lstInscripcionBean = deListaInscripcionAListaInscripcionBean(lstInscripcion);
			}
			//em.close();
		   
		return lstInscripcionBean;
	}
	
	@Override
	public List<InscripcionBean> getBuscarPorFiltrosxperfil(InscripcionBean inscripcion, UsuarioBean usu) throws DAOException {
		System.out.println("em " + em);
		List<LeotbcInscripcion> lstInscripcion= null;	
		List<InscripcionBean> lstInscripcionBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_inscripcion.buscar_por_filtrosxperfil");
			spq.setParameter("p_codisnti", inscripcion.getInstitucion().getCodigo());  
			spq.setParameter("p_tm2sitin", inscripcion.getSituacion().getCodigoRegistro());  
			spq.setParameter("p_codusuario", inscripcion.getAudCodigoUsuario()); 
			spq.setParameter("p_codperfil", usu.getCodigoPerfil()); 
			if (spq.execute()) {
				lstInscripcion =  spq.getResultList(); 
			} 
			if (lstInscripcion != null && lstInscripcion.size() > 0) {
				
				lstInscripcionBean = deListaInscripcionAListaInscripcionBean(lstInscripcion);
			}
			//em.close();
		   
		return lstInscripcionBean;
	}


	@Override
	public boolean existe(InscripcionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public InscripcionBean getNumcuposXcodInstiCodLengua(InscripcionBean inscripcionBean) throws DAOException {
		InscripcionBean oMatriculaBean = null;
		List<LeotbcInscripcion> lstLeotbcInscripcion = null;
		System.out.println("matriculaBean getBuscarPorObjecto " + inscripcionBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_inscripcion.getNumcuposXcodInsti_codLengua");			
			spq.setParameter("p_codisnti", inscripcionBean.getInstitucion().getCodigo()); 
			spq.setParameter("p_codlengua", inscripcionBean.getLengua().getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcInscripcion = spq.getResultList();			
			}
			
			if (	lstLeotbcInscripcion != null
				&&	lstLeotbcInscripcion.size() > 0) {
				System.out.println("lstLeotbcInscripcion.size() " + lstLeotbcInscripcion.size());
				oMatriculaBean = deInscripcionAInscripcionBean(lstLeotbcInscripcion.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oMatriculaBean;
	}
}
