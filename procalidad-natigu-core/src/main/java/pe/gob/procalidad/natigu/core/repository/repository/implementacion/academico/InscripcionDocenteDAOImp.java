package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;  
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionDocenteBean; 
import pe.gob.procalidad.natigu.core.entity.entity.academico.Leotbdinscdocente;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.InscripcionDocenteDAO;

@Transactional
@Repository("inscripcionDocenteDAO")
public class InscripcionDocenteDAOImp implements InscripcionDocenteDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(InscripcionDocenteBean t) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("docenteBean DAO "+t);
		Object id= null; 
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinscdocente.insertar");
			
		
			spq.setParameter("p_codinslen", 	t.getInscripcionLenguaBean().getCodigo());
			spq.setParameter("p_coddocen", 	t.getDocenteBean().getCodigo());
			spq.setParameter("p_tm1sitinsdoc", t.getSituacionInscripcionDocente().getCodigoRegistro());
			
			spq.setParameter("p_codusureg", t.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", 	t.getIpCreacion()); 
			
			spq.execute();
			
			id = spq.getOutputParameterValue(1);
			if (id != null) {
				t.setCodigo(Integer.valueOf(id.toString()));
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
	public boolean actualizar(InscripcionDocenteBean t) throws DAOException {
		System.out.println("em :: " + em);
//		System.out.println("docenteBean DAO "+t);
//		Object id= null; 
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinscdocente.actualizar");
			
			spq.setParameter("p_codinsdoc", 	t.getCodigo());
			spq.setParameter("p_codinslen", 	t.getInscripcionLenguaBean().getCodigo());
			spq.setParameter("p_coddocen", 	t.getDocenteBean().getCodigo());
			spq.setParameter("p_tm1sitinsdoc", t.getSituacionInscripcionDocente().getCodigoRegistro());
			
			spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", 	t.getIpModificacion()); 
			
			spq.execute();
			sw = true;
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(InscripcionDocenteBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InscripcionDocenteBean getBuscarPorObjecto(InscripcionDocenteBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InscripcionDocenteBean> getBuscarPorFiltros(
			InscripcionDocenteBean t) throws DAOException { 
		List<Leotbdinscdocente> lstInscripcionDocente = null;	
		List<InscripcionDocenteBean> lstInscripcionDocenteBean= null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinscdocente.buscar_por_filtros");
			
			spq.setParameter("p_codinsdoc", t.getCodigo());  
			spq.setParameter("p_coddocen", t.getDocenteBean().getCodigo());  
			spq.setParameter("p_codinslen", t.getInscripcionLenguaBean().getCodigo()); 
			spq.setParameter("p_nombredoc", t.getDocenteBean().getPersonaBean().getNombrePersona());  
			spq.setParameter("p_especdoc", "");  
			spq.setParameter("p_codinst", t.getInscripcionLenguaBean().getInscripcionBean().getInstitucion().getCodigo()); 
			spq.setParameter("p_tm1sitinsdoc", t.getSituacionInscripcionDocente().getCodigoRegistro()); 
			
			if (spq.execute()) {
				lstInscripcionDocente =  spq.getResultList(); 
			} 
			if (lstInscripcionDocente != null && lstInscripcionDocente.size() > 0) {
				
				lstInscripcionDocenteBean = deListaInscripcionDocenteAListaInscripcionDocenteBean(lstInscripcionDocente);
			}
			//em.close();
			
		   
		return lstInscripcionDocenteBean;
	}
	
	
	
	
	

private List<InscripcionDocenteBean> deListaInscripcionDocenteAListaInscripcionDocenteBean(List<Leotbdinscdocente> lstHorarioExcepcion) {
		
		List<InscripcionDocenteBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<InscripcionDocenteBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				Leotbdinscdocente entity = lstHorarioExcepcion.get(i);
				InscripcionDocenteBean bean = deInscripcionDocenteAInscripcionDocenteBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}

private InscripcionDocenteBean deInscripcionDocenteAInscripcionDocenteBean(Leotbdinscdocente entity) {
	
	InscripcionDocenteBean bean = null;
	
	if (entity != null) {
		
		bean = new InscripcionDocenteBean();
		
		bean.setCodigo(entity.getnCodInsDoc()); 
		bean.getInscripcionLenguaBean().setCodigo(entity.getnCodInsLen());
		bean.getDocenteBean().setCodigo(entity.getnCodDocen());
		bean.getSituacionInscripcionDocente().setCodigo(entity.getnTm1SitInsDoc());
		
		bean.getDocenteBean().getPersonaBean().setNombrePersona(entity.getvNombrePer());
		bean.getDocenteBean().getPersonaBean().setApellidoPaterno(entity.getvApePatPer());
		bean.getDocenteBean().getPersonaBean().setApellidoMaterno(entity.getvApeMatPer());
		bean.getDocenteBean().getPersonaBean().getTipoDocumento().setCodigoRegistro(entity.getnTm1TpDoPe());;
		bean.getDocenteBean().getPersonaBean().setNumeroDocumento(entity.getvNumDocum());
		bean.setFechaCreacion(entity.getdFecReg());
		bean.setFechaBaja(entity.getdFecBaj());
		
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
	public boolean existe(InscripcionDocenteBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dar_baja_docente_x_InscripcionDocente(
			InscripcionDocenteBean inscripcionDocenteBean) throws DAOException {
		System.out.println("em :: " + em);
//		System.out.println("docenteBean DAO "+t);
//		Object id= null; 
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinscdocente.dar_baja");
			
			spq.setParameter("p_codinsdoc", 	inscripcionDocenteBean.getCodigo());
		
			
			spq.setParameter("p_codusumod", inscripcionDocenteBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", 	inscripcionDocenteBean.getIpModificacion()); 
			
			spq.execute();
			sw = true;
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

}
