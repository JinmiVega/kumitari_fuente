package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeomvcMatricula;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcInscripcion;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.MatriculaDAO;
 
@Transactional
@Repository("matriculaDAO")
public class MatriculaDAOImp implements MatriculaDAO {
	
	
	@PersistenceContext
	private EntityManager em;

	
	public MatriculaBean getMatriculaBean(Object object){
		return (MatriculaBean)object;
	}


	@Override
	public boolean insertar(MatriculaBean matriculaBean) throws DAOException {
		Object idMatricula= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvc_matricula.insertar");
			
//			spq.setParameter("p_codmatri", 		matriculaBean.getCodigo());
			spq.setParameter("p_codisnti", 		0);
			spq.setParameter("p_codlengua", 	0);
			spq.setParameter("p_tm2nivel",	 	0);
			spq.setParameter("p_tm2subniv", 	0);
			spq.setParameter("p_periodo", 		String.valueOf(matriculaBean.getPeriodo().getCodigoRegistro()));
			spq.setParameter("p_tm2ciclo", 		0);
			spq.setParameter("p_tm1sitmat", 	matriculaBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_tm1tipmat", 	matriculaBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_observaci", 	matriculaBean.getvObservaci());
			spq.setParameter("p_flgmat", 		matriculaBean.getFlagEstado().getCodigoRegistro());
			spq.setParameter("p_flgest", 		String.valueOf(1));
		
			
			spq.setParameter("p_codusureg", 	matriculaBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", 		matriculaBean.getIpCreacion()); 
			spq.setParameter("p_codinsclen", 	matriculaBean.getInscripcionLenguaBean().getCodigo());
			
			spq.execute();
			
			idMatricula = spq.getOutputParameterValue(1);
			if (idMatricula != null) {
				matriculaBean.setCodigo(Integer.valueOf(idMatricula.toString()));
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
	public boolean actualizar(MatriculaBean matriculaBean) throws DAOException {
		boolean sw=false;
		System.out.println("MatriculaBean actualizar " + matriculaBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvc_matricula.actualizar");
			spq.setParameter("p_codmatri", 		matriculaBean.getCodigo());
			spq.setParameter("p_codisnti", 		0);
			spq.setParameter("p_codlengua", 	0);
			spq.setParameter("p_tm2nivel",	 	0);
			spq.setParameter("p_tm2subniv", 	0);//matriculaBean.getSubNivel().getCodigoRegistro()
			spq.setParameter("p_periodo", 		String.valueOf(matriculaBean.getPeriodo().getCodigoRegistro()));
			spq.setParameter("p_tm2ciclo", 		0);//matriculaBean.getCiclo().getCodigoRegistro()
			spq.setParameter("p_tm1sitmat", 	matriculaBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_tm1tipmat", 	matriculaBean.getSituacion().getCodigoRegistro());//matriculaBean.getTipoMatricula().getCodigoRegistro()
			spq.setParameter("p_observaci", 	matriculaBean.getvObservaci());
			spq.setParameter("p_flgmat", 		matriculaBean.getFlagEstado().getCodigoRegistro());
			spq.setParameter("p_flgest", 		String.valueOf(1));
			
			
			spq.setParameter("p_codusumod", 	matriculaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", 		matriculaBean.getIpModificacion()); 
			spq.setParameter("p_codinsclen", 	matriculaBean.getInscripcionLenguaBean().getCodigo());
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
	public boolean eliminar(MatriculaBean matriculaBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvc_matricula.eliminar");
			spq.setParameter("p_codmatri", 	matriculaBean.getCodigo()); 
			spq.setParameter("p_codusumod", matriculaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod",	matriculaBean.getIpModificacion());
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


	@SuppressWarnings("unchecked")
	@Override
	public MatriculaBean getBuscarPorObjecto(MatriculaBean matriculaBean) throws DAOException {
		MatriculaBean oMatriculaBean = null;
		List<LeomvcMatricula> lstLeomvcMatricula = null;
		System.out.println("matriculaBean getBuscarPorObjecto " + matriculaBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvc_matricula.buscar_por_codigo");			
			spq.setParameter("p_codmatri", matriculaBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeomvcMatricula = spq.getResultList();			
			}
			
			if (	lstLeomvcMatricula != null
				&&	lstLeomvcMatricula.size() > 0) {
				System.out.println("lstLeotbcInscripcion.size() " + lstLeomvcMatricula.size());
				oMatriculaBean = deMatriculaAMatriculaBean(lstLeomvcMatricula.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oMatriculaBean;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<MatriculaBean> getBuscarPorFiltros(MatriculaBean t) throws DAOException {
		System.out.println("em getBuscarPorFiltros " + em);

		List<LeomvcMatricula> lstMatricula = null;	
		List<MatriculaBean> lstMatriculaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvc_matricula.listar");
			//spq.setParameter("p_codmatri", t.getCodigo());  
			spq.setParameter("p_codisnti", t.getInsti().getCodigo());  
			spq.setParameter("p_codlengua", t.getLengua().getCodigo());  
			spq.setParameter("p_tm1sitmat", t.getSituacion().getCodigoRegistro());  
			spq.setParameter("p_tm2nivel", t.getNivel().getCodigoRegistro());  
			spq.setParameter("p_codusuario", t.getAudCodigoUsuario()); 
			//spq.setParameter("p_tm2subniv", t.getSubNivel().getCodigoRegistro());  
			if (spq.execute()) {
				lstMatricula =  spq.getResultList(); 
			} 
			if (lstMatricula != null && lstMatricula.size() > 0) {
				
				lstMatriculaBean = deListaMatriculaAListaMatriculaBean(lstMatricula);
			}
		em.close();
			
		   
		return lstMatriculaBean;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MatriculaBean> getBuscarPorFiltrosxPerfil(MatriculaBean t,UsuarioBean usu) throws DAOException {
		System.out.println("em getBuscarPorFiltrosxPerfil " + em);

		List<LeomvcMatricula> lstMatricula = null;	
		List<MatriculaBean> lstMatriculaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvc_matricula.listarxPerfil");
	
			spq.setParameter("p_codisnti", t.getInsti().getCodigo());  
			spq.setParameter("p_codlengua", t.getLengua().getCodigo());  
			spq.setParameter("p_tm1sitmat", t.getSituacion().getCodigoRegistro());  
			spq.setParameter("p_tm2nivel", t.getNivel().getCodigoRegistro());  
			spq.setParameter("p_codusuario", t.getAudCodigoUsuario()); 
			spq.setParameter("p_codperfil", usu.getCodPerfilUsuSelec());  
			if (spq.execute()) {
				lstMatricula =  spq.getResultList(); 
			} 
			if (lstMatricula != null && lstMatricula.size() > 0) {
				
				lstMatriculaBean = deListaMatriculaAListaMatriculaBean(lstMatricula);
			}
		em.close();
			
		   
		return lstMatriculaBean;
	}

	@Override
	public boolean existe(MatriculaBean t) throws DAOException {
		
		return false;
	}

	
	private List<MatriculaBean> deListaMatriculaAListaMatriculaBean(List<LeomvcMatricula> lstMatriculaExcepcion) {
	
		List<MatriculaBean> lstHorarioExcepcionBean = null;
		
		if (lstMatriculaExcepcion != null && lstMatriculaExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<MatriculaBean>();
			
			for (int i = 0; i < lstMatriculaExcepcion.size(); i++) { 
				LeomvcMatricula entity = lstMatriculaExcepcion.get(i);
				MatriculaBean bean = deMatriculaAMatriculaBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private MatriculaBean deMatriculaAMatriculaBean(LeomvcMatricula entity) {
		
		MatriculaBean bean = null;
		
		if (entity != null) {
			
			bean = new MatriculaBean();
			
			bean.setCodigo((int) entity.getNCodmatri()); 
			bean.getInsti().setCodigo(entity.getNCodisnti());
			bean.getInsti().setNombreInstitucion(entity.getvNominsti());
			bean.getLengua().setCodigo(entity.getNCodlengua());
			bean.getLengua().setNombre(entity.getvNomlengua());
			bean.getNivel().setCodigoRegistro(entity.getNTm2nivel());
			bean.getNivel().setNombreCorto(entity.getvNomtm2nivel()!=null ? entity.getvNomtm2nivel() : "");
			bean.getSubNivel().setCodigoRegistro(entity.getNTm2subniv());
			bean.getSubNivel().setNombreCorto(entity.getVtm2subniv()!=null ? entity.getVtm2subniv() : "");
			bean.getPeriodo().setCodigoRegistro(entity.getNPeriodo()!= null ? Integer.valueOf(entity.getNPeriodo()): 0);
			System.out.println("entity.getNTm1tipmat() " + entity.getNTm1tipmat());
			bean.getTipoMatricula().setCodigoRegistro(entity.getNTm1tipmat());
			bean.getSituacion().setCodigoRegistro(entity.getNTm1sitmat());
			bean.getSituacion().setNombreCorto(entity.getVnomcorto());
			bean.getSituacion().setNombreLargo(entity.getVtm1sitmat());
			bean.setvObservaci(entity.getVObservaci());
			bean.getInscripcion().setNumCupos(entity.getVnumcupos());
			bean.getCiclo().setCodigoRegistro(entity.getnTm2ciclo());
			bean.getCiclo().setNombreCorto(entity.getVtm2ciclo()!= null ? entity.getVtm2ciclo() : "");
			System.out.println("entity.getNFlgmat() " + entity.getNFlgmat());
			bean.getFlagEstado().setCodigoRegistro(entity.getNFlgmat());
			
			bean.getDocenteBean().getPersonaBean().setNombreCompleto(entity.getVnomdocente() != null ? entity.getVnomdocente() : "");
			bean.getAlumnoBean().setUsuario(entity.getvNomusuari()!= null ? entity.getvNomusuari() : "");
			bean.getAlumnoBean().getPersonaBean().setNombreCompleto(entity.getVnomalumno() != null ? entity.getVnomalumno() : "");
			bean.setNumeroAlumnosMatri(entity.getVnumalum());
			bean.getInscripcion().setFechaRegistro(entity.getDFecreg()!=null?entity.getDFecreg():new Date());
			bean.getInscripcion().setFechaModificacion(entity.getDFecmod()!=null?entity.getDFecmod():new Date());
			bean.getInscripcionLenguaBean().setCodigo(entity.getnCodinsclen());
			bean.getInscripcionLenguaBean().setNumeroCuposDisp(entity.getvNumcuposdisp());
			bean.setvNumcuposrest(entity.getvNumcuposrest());
			//bean.setni
			//bean.getTipoMatricula()
			
		}
		
		return bean;
	}


	@Override
	public List<MatriculaBean> listarCuposXAsignar(MatriculaBean matriculaBean)
			throws DAOException {
		System.out.println("em getBuscarPorFiltros " + em);

		List<LeomvcMatricula> lstMatricula = null;	
		List<MatriculaBean> lstMatriculaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvc_matricula.listarCuposXAsignar");
			spq.setParameter("p_codmatri", matriculaBean.getCodigo());  
			spq.setParameter("p_codisnti", matriculaBean.getInsti().getCodigo());  
			spq.setParameter("p_codlengua", matriculaBean.getLengua().getCodigo());  
			spq.setParameter("p_tm1sitmat", matriculaBean.getSituacion().getCodigoRegistro());  
			spq.setParameter("p_tm2nivel", matriculaBean.getNivel().getCodigoRegistro());  
			spq.setParameter("p_tm2subniv", matriculaBean.getSubNivel().getCodigoRegistro());  
			spq.setParameter("p_codusu", matriculaBean.getSubNivel().getCodigoRegistro());  
			spq.setParameter("p_nombreusu", matriculaBean.getSubNivel().getCodigoRegistro());  
			if (spq.execute()) {
				lstMatricula =  spq.getResultList(); 
			} 
			if (lstMatricula != null && lstMatricula.size() > 0) {
				
				lstMatriculaBean = deListaMatriculaAListaMatriculaBean(lstMatricula);
			}
		em.close();
			
		   
		return lstMatriculaBean;
	}
	
	
	@Override
	public List<MatriculaBean> listarSeguimientoAlumno(MatriculaBean matriculaBean)
			throws DAOException {
		System.out.println("em getBuscarPorFiltros " + em);

		List<LeomvcMatricula> lstMatricula = null;	
		List<MatriculaBean> lstMatriculaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvc_matricula.listarSeguimientoAlumnov2");
			System.out.println("listarSeguimientoAlumnov2");
			System.out.println("p_codisnti"+ matriculaBean.getInsti().getCodigo());
			System.out.println("p_codlengua"+ matriculaBean.getLengua().getCodigo());
			System.out.println("p_coddocen"+ matriculaBean.getDocenteBean().getCodigo());
			
			spq.setParameter("p_codisnti", matriculaBean.getInsti().getCodigo());  
			spq.setParameter("p_codlengua", matriculaBean.getLengua().getCodigo());  
			spq.setParameter("p_coddocen", matriculaBean.getDocenteBean().getCodigo());  
			spq.setParameter("p_tm2nivel", matriculaBean.getNivel().getCodigoRegistro()); 
			spq.setParameter("p_periodo", matriculaBean.getPeriodo().getCodigoRegistro()); 
			spq.setParameter("p_tm1sitmat", matriculaBean.getSituacion().getCodigoRegistro());  
			
			
			if (spq.execute()) {
				lstMatricula =  spq.getResultList(); 
			} 
			if (lstMatricula != null && lstMatricula.size() > 0) {
				lstMatriculaBean = deListaMatriculaAListaMatriculaBean(lstMatricula);
			}
		em.close();
			
		   
		return lstMatriculaBean;
	}


	@Override
	public boolean actualizarNumCuposRest(MatriculaBean matriculaBean) throws DAOException {
		boolean sw=false;
		System.out.println("MatriculaBean actualizarNumCuposRest " + matriculaBean );
		System.out.println("matriculaBean.getvNumcuposrest() DAO" + matriculaBean.getvNumcuposrest());
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvc_matricula.actualizarNumCuposRest");
			spq.setParameter("p_codmatri", 	matriculaBean.getCodigo()); 
			spq.setParameter("p_codusumod", matriculaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod",	matriculaBean.getIpModificacion());
			spq.setParameter("p_numcuposrest",	matriculaBean.getvNumcuposrest());
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

	
}
