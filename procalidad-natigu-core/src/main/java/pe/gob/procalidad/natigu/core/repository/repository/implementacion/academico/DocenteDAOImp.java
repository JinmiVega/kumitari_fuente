package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionDocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcAlumno;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcDocente;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.DocenteDAO;
 
@Transactional
@Repository("docenteDAO")
public class DocenteDAOImp implements DocenteDAO{
	
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
				AlumnoBean bean = deInscripcionAInscripcionBean(entity);
				
				lstAlumnoBean.add(bean);
			}
		}
		
		return lstAlumnoBean;
	}
	
	private AlumnoBean deInscripcionAInscripcionBean(LeotbcAlumno entity) {
		
		AlumnoBean bean = null;
		
		if (entity != null) {
			
			bean = new AlumnoBean();
			
			bean.setCodigo(entity.getNCodalumno()); 
			//Falta
		}
		
		return bean;
	}


	@Override
	public boolean insertar(DocenteBean docenteBean) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("docenteBean DAO "+docenteBean);
		Object idDocente= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcDocente.insertar");
			
			spq.setParameter("p_coddocen", docenteBean.getCodigo());
			spq.setParameter("p_codperso", docenteBean.getPersonaBean().getCodigo());
			spq.setParameter("p_codinsti", docenteBean.getInstitucionBean().getCodigo());
			spq.setParameter("p_codlengua", docenteBean.getPersonaBean().getLenguaBean().getCodigo());
			spq.setParameter("p_tm2grado", docenteBean.getGradoDocente().getCodigoRegistro());
			spq.setParameter("p_tm2carrera", docenteBean.getCarreraDocente().getCodigoRegistro());
			spq.setParameter("p_tm1sitdoc", docenteBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_codusureg", docenteBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", docenteBean.getIpCreacion()); 
			
			spq.execute();
			
			idDocente = spq.getOutputParameterValue(1);
			if (idDocente != null) {
				docenteBean.setCodigo(Integer.valueOf(idDocente.toString()));
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
	public boolean actualizar(DocenteBean docenteBean) throws DAOException {
		//LenguaBean lengua= this.getLenguaBean(objeto);
		System.out.println("em :: " + em);
		System.out.println("docente DAO "+docenteBean);
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcDocente.actualizar");
			
			
			spq.setParameter("p_codperso", docenteBean.getPersonaBean().getCodigo());
			spq.setParameter("p_apepatper", docenteBean.getPersonaBean().getApellidoPaterno());
			spq.setParameter("p_apematper", docenteBean.getPersonaBean().getApellidoMaterno());
			spq.setParameter("p_nombreper", docenteBean.getPersonaBean().getNombrePersona());
			spq.setParameter("p_tm1tpdope", docenteBean.getPersonaBean().getTipoDocumento().getCodigoRegistro()); 
			spq.setParameter("p_numdocum", docenteBean.getPersonaBean().getNumeroDocumento());
			spq.setParameter("p_tm1tipper", docenteBean.getPersonaBean().getTipoPersona().getCodigoRegistro());
			spq.setParameter("p_codubigeo", docenteBean.getPersonaBean().getCodigoUbigeo());
			spq.setParameter("p_direcpers", docenteBean.getPersonaBean().getDireccionPersona()); 
			spq.setParameter("p_tm1sitper", docenteBean.getPersonaBean().getSituacionPersona().getCodigoRegistro());
			spq.setParameter("p_fechnacim", docenteBean.getPersonaBean().getFechaNac());
			spq.setParameter("p_tm2pais", docenteBean.getPersonaBean().getNacionalidad().getCodigoRegistro());
			spq.setParameter("p_tm2estciv", docenteBean.getPersonaBean().getEstadoCivil().getCodigoRegistro()); 
			spq.setParameter("p_tm2sexo", docenteBean.getPersonaBean().getSexo().getCodigoRegistro());
			spq.setParameter("p_codlengua", docenteBean.getPersonaBean().getLenguaBean().getCodigo());
			spq.setParameter("p_telefono", docenteBean.getPersonaBean().getTelefono());
			spq.setParameter("p_correo", docenteBean.getPersonaBean().getCorreo()); 

			
			spq.setParameter("p_coddocen", docenteBean.getCodigo());
			spq.setParameter("p_codinsti", docenteBean.getInstitucionBean().getCodigo());
			spq.setParameter("p_tm2grado", docenteBean.getGradoDocente().getCodigoRegistro()); 
			spq.setParameter("p_tm2carrera", docenteBean.getCarreraDocente().getCodigoRegistro());
			spq.setParameter("p_tm1sitdoc", docenteBean.getSituacion().getCodigoRegistro());
			
			spq.setParameter("p_codusumod", docenteBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", docenteBean.getIpModificacion());
		
		
			
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
	public boolean eliminar(DocenteBean docenteBean) throws DAOException {
		//LenguaBean lengua= this.getLenguaBean(objeto);
		System.out.println("em :: " + em);
		System.out.println("docente DAO "+docenteBean);
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcDocente.eliminar");
			
		

			
			spq.setParameter("p_coddocen", docenteBean.getCodigo());
			spq.setParameter("p_codusumod", docenteBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", docenteBean.getIpModificacion());
		
		
			
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
	public DocenteBean getBuscarPorObjecto(DocenteBean docenteBean) throws DAOException { 
		List<LeotbcDocente> lstDocente = null;	
		DocenteBean oDocenteBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcDocente.buscar_por_codigo");
			spq.setParameter("p_coddocen", docenteBean.getCodigo()); 
			
			if (spq.execute()) {
				lstDocente =  spq.getResultList(); 
			} 
			if (lstDocente != null && lstDocente.size() > 0) {
				
				oDocenteBean = deDocenteADocenteBean(lstDocente.get(0));
			}
			//em.close();
			
		   
		return oDocenteBean;
	}


	@Override
	public List<DocenteBean> getBuscarPorFiltros(DocenteBean docenteBean) throws DAOException { 
		List<LeotbcDocente> lstDocente = null;	
		List<DocenteBean> lstDocenteBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcDocente.buscar_por_filtros");
			System.out.println("p_coddocen"+ docenteBean.getCodigo());  
			System.out.println("p_nombredoc"+ docenteBean.getPersonaBean().getNombrePersona());  
			System.out.println("p_especdoc"+ docenteBean.getLenguaBean().getNombre());  
			System.out.println("p_codinsti"+ docenteBean.getInstitucionBean().getCodigo()); 
			System.out.println("p_nominsti"+ docenteBean.getInstitucionBean().getNombreInstitucion());  
			System.out.println("p_tm1sitdoc"+ docenteBean.getSituacion().getCodigoRegistro());   
			System.out.println("p_codperso"+ docenteBean.getAudCodigoUsuario());   
			System.out.println("p_codperfil"+ Integer.parseInt(docenteBean.getAudTipo())); 
			
			spq.setParameter("p_coddocen", docenteBean.getCodigo());  
			spq.setParameter("p_nombredoc", docenteBean.getPersonaBean().getNombrePersona());  
			spq.setParameter("p_especdoc", docenteBean.getLenguaBean().getNombre());  
			spq.setParameter("p_codinsti", docenteBean.getInstitucionBean()!=null ? docenteBean.getInstitucionBean().getCodigo() :0); 
			spq.setParameter("p_nominsti", docenteBean.getInstitucionBean().getNombreInstitucion());  
			spq.setParameter("p_tm1sitdoc", docenteBean.getSituacion().getCodigoRegistro());   
			spq.setParameter("p_codperso", docenteBean.getAudCodigoUsuario());   
			spq.setParameter("p_codperfil", Integer.parseInt(docenteBean.getAudTipo())); 
			if (spq.execute()) {
				lstDocente =  spq.getResultList(); 
			} 
			if (lstDocente != null && lstDocente.size() > 0) {
				
				lstDocenteBean = deListaDocenteAListaDocenteBean(lstDocente);
			}
			//em.close();
			
		   
		return lstDocenteBean;
	}

	@Override
	public List<DocenteBean> getBuscarPorNumeroDocumento(DocenteBean docenteBean) throws DAOException { 
		List<LeotbcDocente> lstDocente = null;	
		List<DocenteBean> lstDocenteBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcDocente.buscar_por_numerodocumento");
			spq.setParameter("p_numdocum", docenteBean.getPersonaBean().getNumeroDocumento());  
			spq.setParameter("p_especdoc", docenteBean.getLenguaBean().getNombre());  
			spq.setParameter("p_codperso", docenteBean.getAudCodigoUsuario());   
			spq.setParameter("p_codperfil", Integer.parseInt(docenteBean.getAudTipo())); 
			if (spq.execute()) {
				lstDocente =  spq.getResultList(); 
			} 
			if (lstDocente != null && lstDocente.size() > 0) {
				
				lstDocenteBean = deListaDocenteAListaDocenteBean(lstDocente);
			}
			//em.close();
			
		   
		return lstDocenteBean;
	}
	
	
private List<DocenteBean> deListaDocenteAListaDocenteBean(List<LeotbcDocente> lstHorarioExcepcion) {
		
		List<DocenteBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<DocenteBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				LeotbcDocente entity = lstHorarioExcepcion.get(i);
				DocenteBean bean = deDocenteADocenteBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}


private DocenteBean deDocenteADocenteBean(LeotbcDocente entity) {
	
	DocenteBean bean = null;
	
	if (entity != null) {
		
		bean = new DocenteBean();
		
		bean.setCodigo(entity.getnCoddocen()); 
		bean.getSituacion().setCodigoRegistro(entity.getnTm1sitdoc());
		bean.getCarreraDocente().setCodigoRegistro(entity.getnTm2carrera());
		bean.getGradoDocente().setCodigoRegistro(entity.getnTm2grado());
		bean.getInstitucionBean().setCodigo(entity.getnCodinsti()!=null?entity.getnCodinsti():0);
		bean.getInstitucionBean().setNombreInstitucion((entity.getvNombreinsti()!=null)?entity.getvNombreinsti():"");
		//bean.getLenguaBean().setNombre((entity.getvNombreespe()!=null)?entity.getvNombreespe():"");
		bean.getLenguaBean().setNombre(entity.getvNombreespe());
		//System.out.println("bean.getLenguaBean().getNombre() - "+bean.getLenguaBean().getNombre());
		//bean.getInstitucionBean().setNombreInstitucion(entity.getvNombreinsti());
//		bean.setNombre(entity.getVNomDocente()); 
		
		bean.getPersonaBean().setCodigo(entity.getnCodperso());
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
		bean.getPersonaBean().getLenguaBean().setCodigo(entity.getvCodLenguaper());
		bean.getPersonaBean().setTelefono(entity.getvTelefono());
		bean.getPersonaBean().setCorreo(entity.getvCorreo());
		bean.setInscripcionLenguaBean(new InscripcionLenguaBean());
		bean.getInscripcionLenguaBean().setCodigo(entity.getnCodinslen());
//		
		
		if (entity.getvCodUbigeo() != null) {
			bean.getUbigeoBean().setCodigoRegion(""+entity.getvCodUbigeo().charAt(0)+entity.getvCodUbigeo().charAt(1));
			bean.getUbigeoBean().setCodigoProvincia(""+entity.getvCodUbigeo().charAt(2)+entity.getvCodUbigeo().charAt(3));
			bean.getUbigeoBean().setCodigoDistrito(""+entity.getvCodUbigeo().charAt(4)+entity.getvCodUbigeo().charAt(5));
		}
		bean.getSituacion().setNombreCorto(entity.getvNombreTm1SitDoc());
	}
	
	return bean;
}
	

	@Override
	public boolean existe(DocenteBean docenteBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<DocenteBean> getBuscarxCodigoInstitucion(DocenteBean docenteBean) throws DAOException {
		List<LeotbcDocente> lstDocente = null;	
		List<DocenteBean> lstDocenteBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcDocente.buscarXcodigoInstitucion");
					spq.setParameter("p_codinsclen", docenteBean.getInscripcionLenguaBean().getCodigo());
			if (spq.execute()) {
				lstDocente =  spq.getResultList(); 
			} 
			if (lstDocente != null && lstDocente.size() > 0) {
				
				lstDocenteBean = deListaDocenteAListaDocenteBean(lstDocente);
			}
			//em.close();
			
		   
		return lstDocenteBean;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DocenteBean> getBuscarxCodigoInstitucionDetalleNombreDocum(DocenteBean docenteBean) throws DAOException {
		List<LeotbcDocente> lstDocente = null;	
		List<DocenteBean> lstDocenteBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcDocente.buscarXcodigoInstitucionYNomYnumD");
				spq.setParameter("p_codinsclen", docenteBean.getInscripcionLenguaBean().getCodigo());
				spq.setParameter("p_nombreper", docenteBean.getPersonaBean().getNombrePersona());
				spq.setParameter("p_numdocum", docenteBean.getPersonaBean().getNumeroDocumento());
			if (spq.execute()) {
				lstDocente =  spq.getResultList(); 
			} 
			if (lstDocente != null && lstDocente.size() > 0) {
				
				lstDocenteBean = deListaDocenteAListaDocenteBean(lstDocente);
			}
			//em.close();
			
		   
		return lstDocenteBean;
	}


	@Override
	public List<DocenteBean> getBuscarXInstitucionNombreNumeroDocumentoTipoDocumento(
			InscripcionDocenteBean docenteBean) throws DAOException { 
		List<LeotbcDocente> lstDocente = null;	
		List<DocenteBean> lstDocenteBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcDocente.buscar_inst_docente_documento_tipodoc");
			spq.setParameter("p_codinst", docenteBean.getDocenteBean().getInstitucionBean().getCodigo());  
			spq.setParameter("p_nombredoc", docenteBean.getDocenteBean().getPersonaBean().getNombrePersona());  
			spq.setParameter("p_numdoc", docenteBean.getDocenteBean().getPersonaBean().getNumeroDocumento());  
			spq.setParameter("p_tm1tipdoc", docenteBean.getDocenteBean().getPersonaBean().getTipoDocumento().getCodigoRegistro());  
			spq.setParameter("p_codinsclen", docenteBean.getInscripcionLenguaBean().getCodigo());
			if (spq.execute()) {
				lstDocente =  spq.getResultList(); 
			} 
			if (lstDocente != null && lstDocente.size() > 0) {
				
				lstDocenteBean = deListaDocenteAListaDocenteBean(lstDocente);
			}
			//em.close();
			
		   
		return lstDocenteBean;
	}
	
	@Override
	public List<DocenteBean> listarDocenteXCodigoInstitucionYCodigoLengua(MatriculaBean matriculaBean) throws DAOException { 
		List<LeotbcDocente> lstDocente = null;	
		List<DocenteBean> lstDocenteBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcDocente.listarPorCodigoInstitucionYCodigoLengua");
			System.out.println("listarPorCodigoInstitucionYCodigoLengua");
			System.out.println("matriculaBean.getInsti().getCodigo()"+matriculaBean.getInsti().getCodigo());
			System.out.println("matriculaBean.getLengua().getCodigo()"+matriculaBean.getLengua().getCodigo());
			spq.setParameter("p_codinsti", matriculaBean.getInsti().getCodigo());  
			spq.setParameter("p_codlengua", matriculaBean.getLengua().getCodigo()); 
			if (spq.execute()) {
				lstDocente =  spq.getResultList(); 
			} 
			if (lstDocente != null && lstDocente.size() > 0) {
				System.out.println("----------------------DOCENTE-------------------------");
				System.out.println(lstDocente);
				lstDocenteBean = deListaDocenteAListaDocenteBean(lstDocente);
				System.out.println("----------------------DOCENTE BEAN-------------------------");
				System.out.println(lstDocenteBean);
			}
			em.close();
			
		   
		return lstDocenteBean;
	}


	@Override
	public DocenteBean getBuscarxdni(DocenteBean docenteBean)
			throws DAOException { 
		List<LeotbcDocente> lstDocente = null;	
		DocenteBean oDocenteBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcDocente.buscar_por_dni");
			spq.setParameter("p_dnidocente", docenteBean.getPersonaBean().getNumeroDocumento()); 
			
			if (spq.execute()) {
				lstDocente =  spq.getResultList(); 
			} 
			if (lstDocente != null && lstDocente.size() > 0) {
				
				oDocenteBean = deDocenteADocenteBean(lstDocente.get(0));
			}
			//em.close();
			
		   
		return oDocenteBean;
	}


	@Override
	public DocenteBean getBuscar_por_codigopersona(PersonaBean personaBean) throws DAOException {
		List<LeotbcDocente> lstDocente = null;	
		DocenteBean oDocenteBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcDocente.buscar_por_codigopersona");
			spq.setParameter("p_codperso", personaBean.getCodigo()); 
			
			if (spq.execute()) {
				lstDocente =  spq.getResultList(); 
			} 
			if (lstDocente != null && lstDocente.size() > 0) {
				
				oDocenteBean = deDocenteADocenteBean(lstDocente.get(0));
			}
			//em.close();
			
		   
		return oDocenteBean;
	}
	
}
