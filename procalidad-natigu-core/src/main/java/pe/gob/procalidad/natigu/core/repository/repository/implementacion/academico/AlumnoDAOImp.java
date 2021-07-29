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

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaNacionalidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcAlumno;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcMascota;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.AlumnoDAO;
 
@Transactional
@Repository("alumnoDAO")
public class AlumnoDAOImp implements AlumnoDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	public AlumnoBean getAlumnoBean(Object object){
		return (AlumnoBean)object;
	}

	private List<AlumnoBean> deListaAlumnoAListaAlumnoBean(List<LeotbcAlumno> lstAlumno) {
		
		List<AlumnoBean> lstAlumnoBean = null;
		
		if (lstAlumno != null && lstAlumno.size() > 0) {
			
			lstAlumnoBean = new ArrayList<AlumnoBean>();
			
			for (int i = 0; i < lstAlumno.size(); i++) { 
				LeotbcAlumno entity = lstAlumno.get(i);
				AlumnoBean bean = deAlumnoAAlumnoBean(entity);
				
				lstAlumnoBean.add(bean);
			}
		}
		return lstAlumnoBean;
	}
	
	private AlumnoBean deAlumnoAAlumnoBean(LeotbcAlumno entity) {
		
		AlumnoBean bean = null;
		
		if (entity != null) {
			bean = new AlumnoBean();
			bean.setCodigo(entity.getNCodalumno());
			
			bean.setPersonaBean(new PersonaBean());
			bean.getPersonaBean().setCodigo(entity.getNCodperso());
			bean.getPersonaBean().setNombrePersona(entity.getVNombreper());
			bean.getPersonaBean().setApellidoPaterno(entity.getVApepatper());
			bean.getPersonaBean().setApellidoMaterno(entity.getVApematper());
			bean.getPersonaBean().setNumeroDocumento(entity.getVNumdocum());
			bean.getPersonaBean().setDireccionPersona(entity.getVDirecpers());
			bean.getPersonaBean().setTelefono(entity.getVTelefono());
			bean.getPersonaBean().setCorreo(entity.getVCorreo());
			bean.getPersonaBean().getSexo().setCodigoRegistro((entity.getNTm2sexo()!=null)?entity.getNTm2sexo():0);
			bean.getPersonaBean().setFechaNac(entity.getDFechnacim());
			bean.getPersonaBean().getTipoDocumento().setCodigoRegistro(entity.getNTm1tpdope());
			bean.getPersonaBean().getNacionalidad().setCodigoRegistro(entity.getNTm2pais());
			bean.getPersonaBean().getLenguaBean().setCodigo((entity.getNCodlengua()!=null)?entity.getNCodlengua():0);
			bean.getPersonaBean().setEstadoCivil(new MaestraBean());
			bean.getPersonaBean().getEstadoCivil().setCodigoRegistro(entity.getnTm2estciv());
			
			bean.setInstitucionBean(new InstitucionBean());
			bean.getInstitucionBean().setCodigo((entity.getNCodinsti()!=null)?entity.getNCodinsti():0);
			bean.getInstitucionBean().setNombreInstitucion(entity.getVNominsti());
			bean.getInstitucionBean().getUbigeoBean().setCodigoUbigeo(entity.getVCodubinst());
			if (entity.getVCodubinst() != null) {
				bean.getInstitucionBean().getUbigeoBean().setCodigoRegion(""+entity.getVCodubinst().charAt(0)+entity.getVCodubinst().charAt(1));
				bean.getInstitucionBean().getUbigeoBean().setCodigoProvincia(""+entity.getVCodubinst().charAt(2)+entity.getVCodubinst().charAt(3));
				bean.getInstitucionBean().getUbigeoBean().setCodigoDistrito(""+entity.getVCodubinst().charAt(4)+entity.getVCodubinst().charAt(5));
			}
			
			bean.setTm1Situacion(new MaestraBean());
			bean.getTm1Situacion().setCodigoRegistro(entity.getNTm1sitalu());
			bean.getTm1Situacion().setNombreCorto(entity.getVNomsitalu());
			
			bean.setTm2Programa(new MaestraBean());
			bean.getTm2Programa().setCodigoRegistro(entity.getNTm2progr());
			
			bean.setTm2Grado(new MaestraBean());
			bean.getTm2Grado().setCodigoRegistro(entity.getNTm2grado());
			
			bean.setTm2Nivel(new MaestraBean());
			bean.getTm2Nivel().setCodigoRegistro(entity.getNTm2nivel());
			
		
			
			bean.setUbigeoBean(new UbigeoBean());
			bean.getUbigeoBean().setCodigoUbigeo(entity.getVCodubigeo());
			if (entity.getVCodubigeo() != null) {
				bean.getUbigeoBean().setCodigoRegion(""+entity.getVCodubigeo().charAt(0)+entity.getVCodubigeo().charAt(1));
				bean.getUbigeoBean().setCodigoProvincia(""+entity.getVCodubigeo().charAt(2)+entity.getVCodubigeo().charAt(3));
				bean.getUbigeoBean().setCodigoDistrito(""+entity.getVCodubigeo().charAt(4)+entity.getVCodubigeo().charAt(5));
			}
			
		}
		
		return bean;
	}




	@Override
	public boolean insertar(AlumnoBean alumnoBean) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("alumnoBean DAO "+alumnoBean);
		Object idAlumno= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_alumno.insertar");
			spq.setParameter("p_codalumno", alumnoBean.getCodigo());
			spq.setParameter("p_codperso", alumnoBean.getPersonaBean().getCodigo());
			spq.setParameter("p_codinsti", alumnoBean.getInstitucionBean().getCodigo());
			spq.setParameter("p_codubinst", alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoUbigeo());
			spq.setParameter("p_tm2progr", (alumnoBean.getTm2Programa()!=null)?alumnoBean.getTm2Programa().getCodigoRegistro():0);
			spq.setParameter("p_tm2nivel", alumnoBean.getTm2Nivel().getCodigoRegistro());
			spq.setParameter("p_tm2grado", alumnoBean.getTm2Grado().getCodigoRegistro());
			spq.setParameter("p_tm1sitalu", (alumnoBean.getTm1Situacion() != null)?alumnoBean.getTm1Situacion().getCodigoRegistro():0);//spq.setParameter("p_tm1sitalu", alumnoBean.getTm1Situacion().getCodigoRegistro());
			spq.setParameter("p_codusureg", alumnoBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", alumnoBean.getIpCreacion());
			
			spq.execute();
			
			idAlumno = spq.getOutputParameterValue(1);
			if (idAlumno != null) {
				alumnoBean.setCodigo(Integer.valueOf(idAlumno.toString()));
				sw=true;
				
				
				
//				if (alumnoBean.getLstPersonaNacionalidadBean() != null && alumnoBean.getLstPersonaNacionalidadBean().size() != 0) {
//					for (PersonaNacionalidadBean personaNacionalidadBean : alumnoBean.getLstPersonaNacionalidadBean()) {
//						System.out.println("codigo de alumno : "+alumnoBean.getCodigo());
//						StoredProcedureQuery spq1 = em.createNamedStoredProcedureQuery("leotbdpernacio.insertar");
//						spq1.setParameter("p_codpernac", personaNacionalidadBean.getCodigo());
//						spq1.setParameter("p_codperso", alumnoBean.getCodigo());
//						spq1.setParameter("p_tm2pais", personaNacionalidadBean.getNacionalidad().getCodigo());
//						spq1.setParameter("p_codusureg", alumnoBean.getAudCodigoUsuario());
//						spq1.setParameter("p_hostreg", alumnoBean.getAudHostIP());
//						spq1.execute();
//					}
//				}
//				
//				
//				if (alumnoBean.getLstPersonaLenguaBean() != null && alumnoBean.getLstPersonaLenguaBean().size() != 0) {
//					//for (int i = 0; i < alumnoBean.getLstPersonaLenguaBean().size(); i++) {
//					for (PersonaLenguaBean personaLenguaBean : alumnoBean.getLstPersonaLenguaBean()) {
//						//insertar codigoPersona, codigoLengua, codigoTipoLengua
//
//						
//						StoredProcedureQuery spq2 = em.createNamedStoredProcedureQuery("leotbdperlengua.insertar");
//						//spq2.setParameter("p_codperlen", 0);
//						spq2.setParameter("p_codperso", alumnoBean.getCodigo());
//						spq2.setParameter("p_codlengua", personaLenguaBean.getLenguaBean().getCodigo());
//						spq2.setParameter("p_tm1tipolengua", personaLenguaBean.getTipoLengua().getCodigo());
//						spq2.setParameter("p_codusureg", alumnoBean.getAudCodigoUsuario());
//						spq2.setParameter("p_hostreg", alumnoBean.getAudHostIP());
//						spq2.execute();
//						
//						System.out.println(":V");
//						
//					}
//				}
			
				//insertar
				//alumnoBean.getLstLengua();
				//alumnoBean.getLstNacionalidad();
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
	public boolean actualizar(AlumnoBean alumnoBean) throws DAOException {
		boolean sw=false;
		System.out.println("alumnoBean actualizar " + alumnoBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_alumno.actualizar");
			spq.setParameter("p_codalumno", alumnoBean.getCodigo());
			spq.setParameter("p_codperso", alumnoBean.getPersonaBean().getCodigo());
			//Persona inico
			spq.setParameter("p_apepatper", alumnoBean.getPersonaBean().getApellidoPaterno());
			spq.setParameter("p_apematper", alumnoBean.getPersonaBean().getApellidoMaterno());
			spq.setParameter("p_nombreper", alumnoBean.getPersonaBean().getNombrePersona());
			spq.setParameter("p_tm1tpdope", alumnoBean.getPersonaBean().getTipoDocumento().getCodigoRegistro()); 
			spq.setParameter("p_numdocum", alumnoBean.getPersonaBean().getNumeroDocumento());
			spq.setParameter("p_tm1tipper", alumnoBean.getPersonaBean().getTipoPersona().getCodigoRegistro());
			spq.setParameter("p_codubigeo", alumnoBean.getPersonaBean().getCodigoUbigeo());
			spq.setParameter("p_direcpers", alumnoBean.getPersonaBean().getDireccionPersona()); 
			spq.setParameter("p_tm1sitper", alumnoBean.getPersonaBean().getSituacionPersona().getCodigoRegistro());
			spq.setParameter("p_fechnacim", alumnoBean.getPersonaBean().getFechaNac());
			spq.setParameter("p_tm2pais", alumnoBean.getPersonaBean().getNacionalidad().getCodigoRegistro());
			spq.setParameter("p_tm2estciv", alumnoBean.getPersonaBean().getEstadoCivil().getCodigoRegistro()); 
			spq.setParameter("p_tm2sexo", alumnoBean.getPersonaBean().getSexo().getCodigoRegistro());
			spq.setParameter("p_codlengua", alumnoBean.getPersonaBean().getLenguaBean().getCodigo());
			spq.setParameter("p_telefono", alumnoBean.getPersonaBean().getTelefono());
			spq.setParameter("p_correo", alumnoBean.getPersonaBean().getCorreo()); 
			//Persona Fin p_codubigeo character varying
			spq.setParameter("p_codinsti", alumnoBean.getInstitucionBean().getCodigo());
			spq.setParameter("p_codubinst", alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoUbigeo());
			spq.setParameter("p_tm2progr", alumnoBean.getTm2Programa().getCodigoRegistro());
			spq.setParameter("p_tm2nivel", alumnoBean.getTm2Nivel().getCodigoRegistro());
			spq.setParameter("p_tm2grado", alumnoBean.getTm2Grado().getCodigoRegistro());
			spq.setParameter("p_tm1sitalu", (alumnoBean.getTm1Situacion() != null)?alumnoBean.getTm1Situacion().getCodigoRegistro():0);//spq.setParameter("p_tm1sitalu", alumnoBean.getTm1Situacion().getCodigoRegistro());
			spq.setParameter("p_codusumod", alumnoBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", alumnoBean.getIpModificacion());
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
	public boolean eliminar(AlumnoBean alumnoBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_alumno.eliminar");
			spq.setParameter("p_codalumno", alumnoBean.getCodigo()); 
			spq.setParameter("p_codusumod", alumnoBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", alumnoBean.getIpModificacion());
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
	public AlumnoBean getBuscarPorObjecto(AlumnoBean alumnoBean) throws DAOException {
		AlumnoBean oAlumnoBean = null;
		List<LeotbcAlumno> lstLeotbcAlumno = null;
		System.out.println("alumnoBean getBuscarPorObjecto " + alumnoBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_alumno.buscar_por_codigo");			
			spq.setParameter("p_codalumno", alumnoBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcAlumno = spq.getResultList();			
			}
			
			if (	lstLeotbcAlumno != null
				&&	lstLeotbcAlumno.size() > 0) {
				oAlumnoBean = deAlumnoAAlumnoBean(lstLeotbcAlumno.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oAlumnoBean;
	}



	@Override
	public List<AlumnoBean> getBuscarPorFiltros(AlumnoBean alumnoBean) throws DAOException {
		System.out.println("em " + em);
		List<LeotbcAlumno> lstAlumno= null;	
		List<AlumnoBean> lstAlumnoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_alumno.listar");
			spq.setParameter("p_codalumno", alumnoBean.getCodigo());  
			spq.setParameter("p_nomalumn", (alumnoBean.getPersonaBean()!= null)?alumnoBean.getPersonaBean().getNombrePersona():"");  
			spq.setParameter("p_numdocum", (alumnoBean.getPersonaBean()!= null)?alumnoBean.getPersonaBean().getNumeroDocumento():"");  
			spq.setParameter("p_nominsti", (alumnoBean.getInstitucionBean()!= null)?alumnoBean.getInstitucionBean().getNombreInstitucion():"");  
			spq.setParameter("p_tm1sitalu",(alumnoBean.getTm1Situacion().getCodigoRegistro()!= null)?alumnoBean.getTm1Situacion().getCodigoRegistro():0);  
			spq.setParameter("p_codperso", alumnoBean.getAudCodigoUsuario());   
			spq.setParameter("p_codperfil", Integer.parseInt(alumnoBean.getAudTipo())); 
			
			if (spq.execute()) {
				lstAlumno =  spq.getResultList(); 
			} 
			if (lstAlumno != null && lstAlumno.size() > 0) {
				
				lstAlumnoBean = deListaAlumnoAListaAlumnoBean(lstAlumno);
			}
			//em.close();
		   
		return lstAlumnoBean;
	}


	@Override
	public boolean existe(AlumnoBean alumnoBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AlumnoBean> getBuscarxCodigoInstitucion(AlumnoBean alumnoBean) throws DAOException {
		List<LeotbcAlumno> lstAlumno= null;	
		List<AlumnoBean> lstAlumnoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_alumno.buscarXcodigoInstitucion");
			spq.setParameter("p_codinsti", alumnoBean.getInstitucionBean().getCodigo());  
			spq.setParameter("p_codinsclen", alumnoBean.getInscripcionLenguaBean().getCodigo());  
			spq.setParameter("p_tm1tiponivel", alumnoBean.getInscripcionLenguaBean().getNivel().getCodigoRegistro());  
			spq.setParameter("p_nombredoc", alumnoBean.getPersonaBean().getNombrePersona());
			
			if (spq.execute()) {
				lstAlumno =  spq.getResultList(); 
			} 
			if (lstAlumno != null && lstAlumno.size() > 0) {
				
				lstAlumnoBean = deListaAlumnoAListaAlumnoBean(lstAlumno);
			}
			//em.close();
		   
		return lstAlumnoBean;
	}

	
}
