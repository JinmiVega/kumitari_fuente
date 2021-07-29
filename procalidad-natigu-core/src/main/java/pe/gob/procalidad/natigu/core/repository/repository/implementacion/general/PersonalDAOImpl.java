package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonalBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcPersonal;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.PersonalDAO;

@Transactional
@Repository("personalDAO")
public class PersonalDAOImpl implements PersonalDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(PersonalBean personal) throws DAOException {
		//LenguaBean lengua= this.getLenguaBean(objeto);
		System.out.println("em :: " + em);
		System.out.println("personal DAO "+personal);
		Object idpersonal= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpersonal.insertar");
			
//			spq.setParameter("p_codpersonal", personal.getCodigo());
			spq.setParameter("p_codpersona", personal.getPersonaBean().getCodigo());
			spq.setParameter("p_tm1sitper", personal.getSituacionPersonal().getCodigoRegistro());
			spq.setParameter("p_tm2cargo", personal.getCargoPersonal().getCodigoRegistro()); 
			spq.setParameter("p_tm2grado", personal.getGradoPersonal().getCodigoRegistro());
			spq.setParameter("p_codusureg", personal.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", personal.getIpCreacion());
		
		
			
			spq.execute();
			
			idpersonal = spq.getOutputParameterValue(1);
			if (idpersonal != null) {
				personal.setCodigo(Integer.valueOf(idpersonal.toString()));
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
	public boolean actualizar(PersonalBean personal) throws DAOException {
		//LenguaBean lengua= this.getLenguaBean(objeto);
		System.out.println("em :: " + em);
		System.out.println("personal DAO "+personal);
		Object idpersonal= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpersonal.actualizar");
			
			
			spq.setParameter("p_codperso", personal.getPersonaBean().getCodigo());
			spq.setParameter("p_apepatper", personal.getPersonaBean().getApellidoPaterno());
			spq.setParameter("p_apematper", personal.getPersonaBean().getApellidoMaterno());
			spq.setParameter("p_nombreper", personal.getPersonaBean().getNombrePersona());
			spq.setParameter("p_tm1tpdope", personal.getPersonaBean().getTipoDocumento().getCodigoRegistro()); 
			spq.setParameter("p_numdocum", personal.getPersonaBean().getNumeroDocumento());
			spq.setParameter("p_tm1tipper", personal.getPersonaBean().getTipoPersona().getCodigoRegistro());
			spq.setParameter("p_codubigeo", personal.getPersonaBean().getCodigoUbigeo());
			spq.setParameter("p_direcpers", personal.getPersonaBean().getDireccionPersona()); 
			spq.setParameter("p_tm1sitper", personal.getPersonaBean().getSituacionPersona().getCodigoRegistro());
			spq.setParameter("p_fechnacim", personal.getPersonaBean().getFechaNac());
			spq.setParameter("p_tm2pais", personal.getPersonaBean().getNacionalidad().getCodigoRegistro());
			spq.setParameter("p_tm2estciv", personal.getPersonaBean().getEstadoCivil().getCodigoRegistro()); 
			spq.setParameter("p_tm2sexo", personal.getPersonaBean().getSexo().getCodigoRegistro());
			spq.setParameter("p_codlengua", personal.getPersonaBean().getLenguaBean().getCodigo());
			spq.setParameter("p_telefono", personal.getPersonaBean().getTelefono());
			spq.setParameter("p_correo", personal.getPersonaBean().getCorreo()); 

			
			spq.setParameter("p_codpersonal", personal.getCodigo());
		
			spq.setParameter("p_tm1sitpersonal", personal.getSituacionPersonal().getCodigoRegistro());
			spq.setParameter("p_tm2cargo", personal.getCargoPersonal().getCodigoRegistro()); 
			spq.setParameter("p_tm2grado", personal.getGradoPersonal().getCodigoRegistro());
			spq.setParameter("p_flgest", "1");
			spq.setParameter("p_codusumod", personal.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", personal.getIpModificacion());
		
		
			
			spq.execute();
			sw=true;
//			idpersonal = spq.getOutputParameterValue(1);
//			if (idpersonal != null) {
//				personal.setCodigo(Integer.valueOf(idpersonal.toString()));
//				sw=true;
//			}
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PersonalBean personal) throws DAOException {
		//LenguaBean lengua= this.getLenguaBean(objeto);
		System.out.println("em :: " + em);
		System.out.println("personal DAO "+personal);
//		Object idpersonal= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpersonal.eliminar");
		
			spq.setParameter("p_codpersonal", personal.getCodigo());
			spq.setParameter("p_codusumod", personal.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostmod", personal.getIpCreacion());
		
		
			
			spq.execute();
			sw=true;
//			idpersonal = spq.getOutputParameterValue(1);
//			if (idpersonal != null) {
//				personal.setCodigo(Integer.valueOf(idpersonal.toString()));
//				sw=true;
//			}
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public PersonalBean getBuscarPorObjecto(PersonalBean personal) throws DAOException { 
		List<LeotbcPersonal> lstPersonal = null;	
		PersonalBean oPersonaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpersonal.buscar_por_codigo");
			spq.setParameter("p_codpersonal", personal.getCodigo()); 
			
			if (spq.execute()) {
				lstPersonal =  spq.getResultList(); 
			} 
			if (lstPersonal != null && lstPersonal.size() > 0) {
				
				oPersonaBean = dePersonalAPersonalBean(lstPersonal.get(0));
			}
			//em.close();
			
		   
		return oPersonaBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonalBean> getBuscarPorFiltros(PersonalBean personal)
			throws DAOException { 
		List<LeotbcPersonal> lstPersonal = null;	
		List<PersonalBean> lstPersonalBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpersonal.buscar_por_filtros");
			spq.setParameter("p_codpersonal", personal.getCodigo());  
			spq.setParameter("p_nombreper", personal.getPersonaBean().getNombrePersona());  
			spq.setParameter("p_numdocum", personal.getPersonaBean().getNumeroDocumento());  
			spq.setParameter("p_codperfil", personal.getPersonaBean().getTipoPersona().getCodigoRegistro());  
			spq.setParameter("p_tm1sitper", personal.getSituacionPersonal().getCodigoRegistro());  
			if (spq.execute()) {
				lstPersonal =  spq.getResultList(); 
			} 
			if (lstPersonal != null && lstPersonal.size() > 0) {
				
				lstPersonalBean = deListaPersonalAListaPersonalBean(lstPersonal);
			}
			//em.close();
			
		   
		return lstPersonalBean;
	}

	
private List<PersonalBean> deListaPersonalAListaPersonalBean(List<LeotbcPersonal> lstHorarioExcepcion) {
		
		List<PersonalBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<PersonalBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				LeotbcPersonal entity = lstHorarioExcepcion.get(i);
				PersonalBean bean = dePersonalAPersonalBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	
private PersonalBean dePersonalAPersonalBean(LeotbcPersonal entity) {
	
	PersonalBean bean = null;
	
	if (entity != null) {
		
		bean = new PersonalBean();
		
		bean.setCodigo(entity.getnCodPersonal()); 
		bean.getSituacionPersonal().setCodigoRegistro(entity.getnTm1SitPer());
		bean.getCargoPersonal().setCodigoRegistro(entity.getnTm2Cargo());
		bean.getGradoPersonal().setCodigoRegistro(entity.getnTm2Grado());
//		bean.setNombre(entity.getVNomPersonal()); 
		
		bean.getPersonaBean().setCodigo(entity.getnCodPersona());
		bean.getPersonaBean().setNombrePersona(entity.getvNombrePer());
		bean.getPersonaBean().setApellidoPaterno(entity.getvApePatPer());
		bean.getPersonaBean().setApellidoMaterno(entity.getvApeMatPer());
		bean.getPersonaBean().getTipoDocumento().setCodigoRegistro(entity.getnTm1TpDoPe());
		bean.getPersonaBean().setNumeroDocumento(entity.getvNumDocum());
		bean.getPersonaBean().getTipoPersona().setCodigoRegistro(entity.getnTm1TipPer());
		bean.getPersonaBean().setCodigoUbigeo(entity.getvCodUbigeo());
		bean.getPersonaBean().setDireccionPersona(entity.getvDirecPers());
		bean.getPersonaBean().getSituacionPersona().setCodigoRegistro(entity.getnTm1SitPersona());
		bean.getPersonaBean().setFechaNac(entity.getdFechNacim());
		bean.getPersonaBean().getNacionalidad().setCodigoRegistro(entity.getnTm2Pais());
		bean.getPersonaBean().getEstadoCivil().setCodigoRegistro(entity.getnTm2EstCiv());
		bean.getPersonaBean().getSexo().setCodigoRegistro(entity.getnTm2Sexo());
		bean.getPersonaBean().getLenguaBean().setCodigo(entity.getvCodLengua());
		bean.getPersonaBean().setTelefono(entity.getvTelefono());
		bean.getPersonaBean().setCorreo(entity.getvCorreo());
		bean.getPersonaBean().getTipoPersona().setNombreCorto(entity.getvNomPerfil());
		bean.getSituacionPersonal().setNombreCorto(entity.getvNombreTm1SitPer());
		
		if (entity.getvCodUbigeo() != null) {
			bean.getPersonaBean().getUbigeoBean().setCodigoRegion(""+entity.getvCodUbigeo().charAt(0)+entity.getvCodUbigeo().charAt(1));
			bean.getPersonaBean().getUbigeoBean().setCodigoProvincia(""+entity.getvCodUbigeo().charAt(2)+entity.getvCodUbigeo().charAt(3));
			bean.getPersonaBean().getUbigeoBean().setCodigoDistrito(""+entity.getvCodUbigeo().charAt(4)+entity.getvCodUbigeo().charAt(5));
		}
	}
	
	return bean;
}



	@Override
	public boolean existe(PersonalBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
