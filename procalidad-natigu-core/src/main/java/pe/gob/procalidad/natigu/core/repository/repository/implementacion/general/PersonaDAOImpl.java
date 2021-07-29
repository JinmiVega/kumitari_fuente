package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonalBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcPersona;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcPersonal;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.PersonaDAO;

@Transactional
@Repository("personaDAO")
public class PersonaDAOImpl implements PersonaDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(PersonaBean persona) throws DAOException {
		//LenguaBean lengua= this.getLenguaBean(objeto);
		System.out.println("em :: " + em);
		System.out.println("persona DAO "+persona);
		Object idPersona= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpersona.insertar");
			
			spq.setParameter("p_apepatper", persona.getApellidoPaterno());
			spq.setParameter("p_apematper", persona.getApellidoMaterno());
			spq.setParameter("p_nombreper", persona.getNombrePersona());
			spq.setParameter("p_tm1tpdope", persona.getTipoDocumento().getCodigoRegistro()); 
			spq.setParameter("p_numdocum", persona.getNumeroDocumento());
			spq.setParameter("p_tm1tipper", persona.getTipoPersona().getCodigoRegistro());
			spq.setParameter("p_codubigeo", persona.getCodigoUbigeo());
			spq.setParameter("p_direcpers", persona.getDireccionPersona()); 
			spq.setParameter("p_tm1sitper", persona.getSituacionPersona().getCodigoRegistro());
			spq.setParameter("p_fechnacim", persona.getFechaNac());
			spq.setParameter("p_tm2pais", persona.getNacionalidad().getCodigoRegistro());
			spq.setParameter("p_tm2estciv", persona.getEstadoCivil().getCodigoRegistro()); 
			spq.setParameter("p_tm2sexo", persona.getSexo().getCodigoRegistro());
			spq.setParameter("p_codlengua", persona.getLenguaBean().getCodigo());
			spq.setParameter("p_telefono", persona.getTelefono());
			spq.setParameter("p_correo", persona.getCorreo()); 
			spq.setParameter("p_codusureg", Integer.valueOf(String.valueOf(persona.getCodigoUsuarioCreacion())));
			spq.setParameter("p_hostreg", persona.getIpCreacion());

			
			spq.execute();
			
			idPersona = spq.getOutputParameterValue(1);
			if (idPersona != null) {
				persona.setCodigo(Integer.valueOf(idPersona.toString()));
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
	public boolean actualizar(PersonaBean persona) throws DAOException {
		//LenguaBean lengua= this.getLenguaBean(objeto);
		System.out.println("em :: " + em);
		System.out.println("persona DAO "+persona);
 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpersona.actualizar");
			
			spq.setParameter("p_codperso", persona.getCodigo());
			spq.setParameter("p_apepatper", persona.getApellidoPaterno());
			spq.setParameter("p_apematper", persona.getApellidoMaterno());
			spq.setParameter("p_nombreper", persona.getNombrePersona());
			
			spq.setParameter("p_tm1tpdope", persona.getTipoDocumento().getCodigoRegistro()); 
			spq.setParameter("p_numdocum", persona.getNumeroDocumento());
			spq.setParameter("p_codubigeo", persona.getCodigoUbigeo());
			spq.setParameter("p_direcpers", persona.getDireccionPersona()); 
			spq.setParameter("p_tm1sitper", persona.getSituacionPersona().getCodigoRegistro());
			
			spq.setParameter("p_fechnacim", persona.getFechaNac());
			spq.setParameter("p_tm2pais", persona.getNacionalidad().getCodigoRegistro());
			spq.setParameter("p_tm2estciv", persona.getEstadoCivil().getCodigoRegistro()); 
			spq.setParameter("p_tm2sexo", persona.getSexo().getCodigoRegistro());
			spq.setParameter("p_codlengua", persona.getLenguaBean().getCodigo());
			spq.setParameter("p_telefono", persona.getTelefono());
			spq.setParameter("p_correo", persona.getCorreo()); 
			spq.setParameter("p_codusumod", Integer.valueOf(String.valueOf(persona.getCodigoUsuarioCreacion())));
			spq.setParameter("p_hostmod", persona.getIpCreacion());

			
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
	public boolean eliminar(PersonaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PersonaBean getBuscarPorObjecto(PersonaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonaBean> getBuscarPorFiltros(PersonaBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(PersonaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PersonaBean buscarxTipoDocumentoNumeroDocumento(
			PersonaBean personaBean) throws DAOException { 
		List<LeotbcPersona> lstpersona = null;	
		PersonaBean oPersonaBean = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpersona.buscar_x_tipodocumento_numero_documento");
			spq.setParameter("p_tm1tpdope", personaBean.getTipoDocumento().getCodigoRegistro()); 
			spq.setParameter("p_numdocum", personaBean.getNumeroDocumento()); 
			
			if (spq.execute()) {
				lstpersona =  spq.getResultList(); 
			} 
			if (lstpersona != null && lstpersona.size() > 0) {
				
				oPersonaBean = dePersonaAPersonaBean(lstpersona.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
			
			//em.close();
			
		   
		return oPersonaBean;
	}
	
	private PersonaBean dePersonaAPersonaBean(LeotbcPersona entity) {
		
		PersonaBean bean = null;
		
		if (entity != null) {
			
			bean = new PersonaBean();
			

			
			bean.setCodigo(entity.getnCodPerso());
			bean.setNombrePersona(entity.getvNombrePer());
			bean.setApellidoPaterno(entity.getvApePatPer());
			bean.setApellidoMaterno(entity.getvApeMatPer());
			bean.getTipoDocumento().setCodigoRegistro(entity.getnTm1TpDoPe());
			bean.setNumeroDocumento(entity.getvNumDocum());
			bean.getTipoPersona().setCodigoRegistro(entity.getnTm1TipPer());
			bean.setCodigoUbigeo(entity.getvCodUbigeo());
			bean.setDireccionPersona(entity.getvDirecPers());
			bean.getSituacionPersona().setCodigoRegistro(entity.getnTm1SitPer());
			bean.setFechaNac(entity.getdFechNacim());
			bean.getNacionalidad().setCodigoRegistro(entity.getnTm2Pais());
			bean.getEstadoCivil().setCodigoRegistro(entity.getnTm2EstCiv());
			bean.getSexo().setCodigoRegistro(entity.getnTm2Sexo());
			bean.getLenguaBean().setCodigo(entity.getvCodLengua());
			bean.setTelefono(entity.getvTelefono());
			bean.setCorreo(entity.getvCorreo());
			
			if (entity.getvCodUbigeo() != null) {
				bean.getUbigeoBean().setCodigoRegion(""+entity.getvCodUbigeo().charAt(0)+entity.getvCodUbigeo().charAt(1));
				bean.getUbigeoBean().setCodigoProvincia(""+entity.getvCodUbigeo().charAt(2)+entity.getvCodUbigeo().charAt(3));
				bean.getUbigeoBean().setCodigoDistrito(""+entity.getvCodUbigeo().charAt(4)+entity.getvCodUbigeo().charAt(5));
			}
//			bean.getSituacionPersona().setNombreCorto(entity.getvNombreTm1SitPer());
		}
		
		return bean;
	}

	@Override
	public boolean actualizardatosuser(PersonaBean persona) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("persona DAO "+persona);
 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpersona.actualizaruser");
			
			spq.setParameter("p_codperso", persona.getCodigo());

			spq.setParameter("p_telefono", persona.getTelefono());
			spq.setParameter("p_correo", persona.getCorreo()); 
			spq.setParameter("p_codusumod", persona.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", persona.getIpModificacion());

			
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
	public boolean actualizardatosfotouser(PersonaBean persona) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("persona DAO "+persona);
 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpersona.actualizarfotouser");
			
			spq.setParameter("p_codperso", persona.getCodigo());
			
			spq.setParameter("p_nombfotop", persona.getNombrefotouser()); 
			spq.setParameter("p_codusumod", persona.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", persona.getIpModificacion());

			
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
