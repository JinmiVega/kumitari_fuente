package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMonedaGBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcDocente;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbdAlumnoMonedaG;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbdUsuMatricula;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.UsuarioMatriculaDAO;

@Transactional
@Repository("usuarioMatriculaDAO")
public class UsuarioMatriculaDAOImp implements UsuarioMatriculaDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public boolean insertar(UsuarioMatriculaBean t) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("docenteBean DAO "+t);
		Object idusuma= null; 
		Object idusuario= null; 
		Object idusuper= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdusumatricula.insertar");
			
			spq.setParameter("p_codusuari",1);
			spq.setParameter("p_codusuper",1);
			spq.setParameter("p_codinsclen",t.getInscripcionLenguaBean().getCodigo());
			spq.setParameter("p_codmatri", 	t.getMatriculaBean().getCodigo());
			spq.setParameter("p_codalumno", t.getAlumnoBean().getCodigo());
			spq.setParameter("p_tm1situsu", t.getSituacion().getCodigoRegistro());		
			spq.setParameter("p_tm1tipocupo", t.getTipoCupo().getCodigoRegistro());		
			spq.setParameter("p_codusureg", t.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", 	t.getIpCreacion()); 
			spq.setParameter("p_passusuar", t.getUsuarioBean().getPasswordUsuario());
			
			spq.execute();
			
			idusuma = spq.getOutputParameterValue(1);
			if (idusuma != null) {
				t.setCodigo(Integer.valueOf(idusuma.toString()));
				sw=true;
			}
			
			idusuario = spq.getOutputParameterValue(2);
			if (idusuario != null) {
				t.getUsuarioBean().setCodigo(Integer.valueOf(idusuario.toString()));
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
	public boolean actualizar(UsuarioMatriculaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(UsuarioMatriculaBean t) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("docenteBean DAO "+t);
	
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdusumatricula.eliminar");
			
			spq.setParameter("p_codusumat", 	t.getCodigo());
		
			spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", 	t.getIpModificacion()); 
			
			spq.execute();
			sw=true;
//			idusuma = spq.getOutputParameterValue(1);
//			if (idusuma != null) {
//				t.setCodigo(Integer.valueOf(idusuma.toString()));
//				sw=true;
//			}
//			
//			idusuario = spq.getOutputParameterValue(2);
//			if (idusuario != null) {
//				t.getUsuarioBean().setCodigo(Integer.valueOf(idusuario.toString()));
//				sw=true;
//			}
//			
		
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public UsuarioMatriculaBean getBuscarPorObjecto(UsuarioMatriculaBean Bean)
			throws DAOException {
		UsuarioMatriculaBean oBean = null;
		List<LeotbdUsuMatricula> lstLeotbd = null;
		System.out.println(" Bean getBuscarPorObjecto " + Bean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdusumatricula.buscar_x_lengua_codusu");			
			spq.setParameter("p_codusuari", Bean.getUsuarioBean().getCodigo()); 
			spq.setParameter("p_codlengua", Bean.getInscripcionLenguaBean().getLenguainscr().getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbd = spq.getResultList();			
			}
			
			if (	lstLeotbd != null
				&&	lstLeotbd.size() > 0) {
				
				oBean = deUsuarioMatriculaAUsuarioMatriculaBean(lstLeotbd.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oBean;
	}

	@Override
	public List<UsuarioMatriculaBean> getBuscarPorFiltros(UsuarioMatriculaBean t)
			throws DAOException { 
		List<LeotbdUsuMatricula> lstUsuarioMatricula = null;	
		List<UsuarioMatriculaBean> lstUsuarioMatriculaBean= null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdusumatricula.buscar_x_filtros");
			
			spq.setParameter("p_codusumat", t.getCodigo());  
			spq.setParameter("p_codinscr", t.getInscripcionLenguaBean().getInscripcionBean().getCodigo());  
			spq.setParameter("p_codinst", t.getInscripcionLenguaBean().getInscripcionBean().getInstitucion().getCodigo()); 
			spq.setParameter("p_codusuari", t.getUsuarioBean().getCodigo());  
			spq.setParameter("p_nomalum", t.getAlumnoBean().getPersonaBean().getNombrePersona());  
			spq.setParameter("p_tm1sitau", t.getSituacion().getCodigoRegistro()); 
			spq.setParameter("p_codinscrlen", t.getInscripcionLenguaBean().getCodigo()); 
			
			if (spq.execute()) {
				lstUsuarioMatricula =  spq.getResultList(); 
			} 
			if (lstUsuarioMatricula != null && lstUsuarioMatricula.size() > 0) {
				
				lstUsuarioMatriculaBean = deListaUsuarioMatriculaAListaUsuarioMatriculaBean(lstUsuarioMatricula);
			}
			//em.close();
			
		   
		return lstUsuarioMatriculaBean;
	}
	
	
	
private List<UsuarioMatriculaBean> deListaUsuarioMatriculaAListaUsuarioMatriculaBean(List<LeotbdUsuMatricula> lstHorarioExcepcion) {
		
		List<UsuarioMatriculaBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<UsuarioMatriculaBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				LeotbdUsuMatricula entity = lstHorarioExcepcion.get(i);
				UsuarioMatriculaBean bean = deUsuarioMatriculaAUsuarioMatriculaBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}



private UsuarioMatriculaBean deUsuarioMatriculaAUsuarioMatriculaBean(LeotbdUsuMatricula entity) {
	
	UsuarioMatriculaBean bean = null;
	
	if (entity != null) {
		
		bean = new UsuarioMatriculaBean();
		
		bean.setCodigo(entity.getnCodUsuMat()); 
		bean.getInscripcionLenguaBean().setCodigo(entity.getnCodInscLen());
		bean.getInscripcionLenguaBean().getInscripcionBean().setCodigo(entity.getnCodInscr());
		bean.getMatriculaBean().setCodigo(entity.getnCodMatri());
		bean.getUsuarioBean().setCodigo(entity.getnCodUsuari());
		bean.getAlumnoBean().setCodigo(entity.getnCodAlumno());
		bean.getTipoCupo().setCodigoRegistro(entity.getnTm1TipoCupo());
		bean.getSituacion().setCodigoRegistro(entity.getnTm1SitUsu());
		bean.getInscripcionLenguaBean().getLenguainscr().setCodigo(entity.getnCodLengua());
		bean.getMatriculaBean().getLengua().setNombre(entity.getvNomLengua());
		bean.getInscripcionLenguaBean().getInscripcionBean().getInstitucion().setCodigo(entity.getnCodInsti());
		bean.getInscripcionLenguaBean().getInscripcionBean().getInstitucion().setNombreInstitucion(entity.getvNomInsti());
		bean.getSituacion().setNombreCorto(entity.getvNombreTm1SitUsu());
		bean.getAlumnoBean().getPersonaBean().setCodigo(entity.getnCodPerso());
		bean.getAlumnoBean().getPersonaBean().setNombrePersona(entity.getvNombrePer());
		bean.getAlumnoBean().getPersonaBean().setApellidoPaterno(entity.getvApePatPer());
		bean.getAlumnoBean().getPersonaBean().setApellidoMaterno(entity.getV_ApeMatPer());
		bean.getUsuarioBean().setNombreUsuario(entity.getvNomUsuari());
		
		if (Float.valueOf(entity.getnNota())!=null) {
			bean.setnNota(entity.getnNota());
		}	
		
		bean.setvCondicion(entity.getvCondicion());
		
		
		
//		bean.setNombre(entity.getVNomDocente()); 
		
//		bean.getAlumnoBean().getPersonaBean().setCodigo(entity.getnCodperso());
//		bean.getAlumnoBean().getPersonaBean().setNombrePersona(entity.getvNombrePer());
//		bean.getAlumnoBean().getPersonaBean().setApellidoPaterno(entity.getvApePatPer());
//		bean.getAlumnoBean().getPersonaBean().setApellidoMaterno(entity.getvApeMatPer());
//		bean.getAlumnoBean().getPersonaBean().getTipoDocumento().setCodigoRegistro(entity.getnTm1TpDoPe());
//		bean.getAlumnoBean().getPersonaBean().setNumeroDocumento(entity.getvNumDocum());
//		bean.getAlumnoBean().getPersonaBean().getTipoPersona().setCodigoRegistro(entity.getnTm1TipPer());
//		bean.getAlumnoBean().getPersonaBean().setCodigoUbigeo(entity.getvCodUbigeo());
//		bean.getAlumnoBean().getPersonaBean().setDireccionPersona(entity.getvDirecPers());
//		bean.getAlumnoBean().getPersonaBean().getSituacionPersona().setCodigoRegistro(entity.getnTm1SitPersona());
//		bean.getAlumnoBean().getPersonaBean().setFechaNac(entity.getdFechNacim());
//		bean.getAlumnoBean().getPersonaBean().getNacionalidad().setCodigoRegistro(entity.getnTm2Pais());
//		bean.getAlumnoBean().getPersonaBean().getEstadoCivil().setCodigoRegistro(entity.getnTm2EstCiv());
//		bean.getAlumnoBean().getPersonaBean().getSexo().setCodigoRegistro(entity.getnTm2Sexo());
//		bean.getAlumnoBean().getPersonaBean().getLenguaBean().setCodigo(entity.getvCodLenguaper());
//		bean.getAlumnoBean().getPersonaBean().setTelefono(entity.getvTelefono());
//		bean.getAlumnoBean().getPersonaBean().setCorreo(entity.getvCorreo());
//		
//		bean.getSituacion().setNombreCorto(entity.getvNombreTm1SitDoc());
	}
	
	return bean;
}

	@Override
	public boolean existe(UsuarioMatriculaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean asignarUsuario(UsuarioMatriculaBean t) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("docenteBean DAO "+t);
		Object idusuma= null; 
		Object idusuario= null; 
		Object idusuper= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdusumatricula.asignar_usuario");
			
			spq.setParameter("p_codusumat", 	t.getCodigo());
			spq.setParameter("p_codusuari", 	t.getUsuarioBean().getCodigo());
		
			spq.setParameter("p_codinsclen", 	t.getInscripcionLenguaBean().getCodigo());
			spq.setParameter("p_codmatri", 	t.getMatriculaBean().getCodigo());
			spq.setParameter("p_codalumno", t.getAlumnoBean().getCodigo());
			spq.setParameter("p_tm1situsu", t.getSituacion().getCodigoRegistro());
			
			spq.setParameter("p_codperso", 	t.getAlumnoBean().getPersonaBean().getCodigo());
			
			spq.setParameter("p_codusureg", t.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", 	t.getIpCreacion()); 
			
			spq.execute();
			sw=true;
//			idusuma = spq.getOutputParameterValue(1);
//			if (idusuma != null) {
//				t.setCodigo(Integer.valueOf(idusuma.toString()));
//				sw=true;
//			}
//			
//			idusuario = spq.getOutputParameterValue(2);
//			if (idusuario != null) {
//				t.getUsuarioBean().setCodigo(Integer.valueOf(idusuario.toString()));
//				sw=true;
//			}
//			
		
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean darBajaUsuarioMatricula(UsuarioMatriculaBean t) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("docenteBean DAO "+t);
	
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdusumatricula.darBajaAlumno");
			
			spq.setParameter("p_codusumat", 	t.getCodigo());
		
			spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", 	t.getIpModificacion()); 
			
			spq.execute();
			sw=true;
//			idusuma = spq.getOutputParameterValue(1);
//			if (idusuma != null) {
//				t.setCodigo(Integer.valueOf(idusuma.toString()));
//				sw=true;
//			}
//			
//			idusuario = spq.getOutputParameterValue(2);
//			if (idusuario != null) {
//				t.getUsuarioBean().setCodigo(Integer.valueOf(idusuario.toString()));
//				sw=true;
//			}
//			
		
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public List<UsuarioMatriculaBean> buscarXTipoCuposXinscrLengua(UsuarioMatriculaBean usuarioMatriculaBean)
			throws DAOException { 
		List<LeotbdUsuMatricula> lstUsuarioMatricula = null;	
		List<UsuarioMatriculaBean> lstUsuarioMatriculaBean= null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdusumatricula.buscarxTipoCuposXInscrLengua");
			
			spq.setParameter("p_codinsclen", usuarioMatriculaBean.getInscripcionLenguaBean().getCodigo());  
			spq.setParameter("p_tm1tipocupo", usuarioMatriculaBean.getTipoCupo().getCodigoRegistro());  

			
			if (spq.execute()) {
				lstUsuarioMatricula =  spq.getResultList(); 
			} 
			if (lstUsuarioMatricula != null && lstUsuarioMatricula.size() > 0) {
				
				lstUsuarioMatriculaBean = deListaUsuarioMatriculaAListaUsuarioMatriculaBean(lstUsuarioMatricula);
			}
			//em.close();
			
		   
		return lstUsuarioMatriculaBean;
	}

	@Override
	public boolean deleteUsumat(UsuarioMatriculaBean t) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("docenteBean DAO "+t);
	
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdusumatricula.eliminarusumat");
			
			spq.setParameter("p_codusumat", 	t.getCodigo());
		
			spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", 	t.getIpModificacion()); 
			
			spq.execute();
			sw=true;
//			idusuma = spq.getOutputParameterValue(1);
//			if (idusuma != null) {
//				t.setCodigo(Integer.valueOf(idusuma.toString()));
//				sw=true;
//			}
//			
//			idusuario = spq.getOutputParameterValue(2);
//			if (idusuario != null) {
//				t.getUsuarioBean().setCodigo(Integer.valueOf(idusuario.toString()));
//				sw=true;
//			}
//			
		
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

}
