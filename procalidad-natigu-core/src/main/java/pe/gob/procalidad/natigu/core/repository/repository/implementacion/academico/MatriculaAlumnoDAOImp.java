package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeomvcMatricula;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeomvdMatriculaAlumno;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbdUsuMatricula;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.MatriculaAlumnoDAO;

@Transactional
@Repository("matriculaAlumnoDAO")
public class MatriculaAlumnoDAOImp implements MatriculaAlumnoDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(MatriculaAlumnoBean matriculaBean) throws DAOException {
		Object idMatriculaAlu= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvd_matalumno.insertar");
			

//			spq.setParameter("p_codmatalu", 	matriculaBean.getCodigo());
			spq.setParameter("p_codmatri", 		matriculaBean.getMatriculaBean().getCodigo());
			spq.setParameter("p_codalumno",	 	matriculaBean.getAlumnoBean().getCodigo());
			
			spq.setParameter("p_codinst", matriculaBean.getMatriculaBean().getInscripcionLenguaBean().getInscripcionBean().getInstitucion().getCodigo()); 
			spq.setParameter("p_codinscrlen", matriculaBean.getMatriculaBean().getInscripcionLenguaBean().getCodigo()); 
			
			spq.setParameter("p_codusureg", 	matriculaBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", 		matriculaBean.getIpCreacion()); 
			
			spq.execute();
			
			idMatriculaAlu = spq.getOutputParameterValue(1);
			if (idMatriculaAlu != null) {
				matriculaBean.setCodigo(Integer.valueOf(idMatriculaAlu.toString()));
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
	public boolean actualizar(MatriculaAlumnoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(MatriculaAlumnoBean matriculaBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvd_matalumno.eliminar");
			spq.setParameter("p_codmatalu", 	matriculaBean.getCodigo()); 
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

	@Override
	public MatriculaAlumnoBean getBuscarPorObjecto(MatriculaAlumnoBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MatriculaAlumnoBean> getBuscarPorFiltros(MatriculaAlumnoBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(MatriculaAlumnoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MatriculaAlumnoBean> listarAlumnosxMatricula(
			MatriculaAlumnoBean t) throws DAOException { 
		List<LeomvdMatriculaAlumno> lstMatriculaAlumno = null;	
		List<MatriculaAlumnoBean> lstMatriculaAlumnoBean= null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvd_matalumno.listar_alumnos");
			
			spq.setParameter("p_codalumno", t.getAlumnoBean().getCodigo());  
			spq.setParameter("p_nomalumn", t.getAlumnoBean().getPersonaBean().getNombrePersona());  
			spq.setParameter("p_numdocum", t.getAlumnoBean().getPersonaBean().getNumeroDocumento());  
			spq.setParameter("p_codinsti", t.getMatriculaBean().getInsti().getCodigo());  
			spq.setParameter("p_tm1sitalu", t.getSituacionMatriculaAlumno().getCodigoRegistro()); 
		
			
			if (spq.execute()) {
				lstMatriculaAlumno =  spq.getResultList(); 
			} 
			if (lstMatriculaAlumno != null && lstMatriculaAlumno.size() > 0) {
				
				lstMatriculaAlumnoBean = deListaMatriculaAlumnoAListaMatriculaAlumnoBean(lstMatriculaAlumno);
			}
			//em.close();
			
		   
		return lstMatriculaAlumnoBean;
	}
	

private List<MatriculaAlumnoBean> deListaMatriculaAlumnoAListaMatriculaAlumnoBean(List<LeomvdMatriculaAlumno> lstHorarioExcepcion) {
		
		List<MatriculaAlumnoBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<MatriculaAlumnoBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				LeomvdMatriculaAlumno entity = lstHorarioExcepcion.get(i);
				MatriculaAlumnoBean bean = deMatriculaAlumnoAMatriculaAlumnoBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}



private MatriculaAlumnoBean deMatriculaAlumnoAMatriculaAlumnoBean(LeomvdMatriculaAlumno entity) {
	
	MatriculaAlumnoBean bean = null;
	
	if (entity != null) {
		
		bean = new MatriculaAlumnoBean();
		
		bean.setCodigo(entity.getnCodMatAlu()); 
		
		bean.getAlumnoBean().setCodigo(entity.getnCodAlumno());
		bean.getAlumnoBean().getPersonaBean().setCodigo(entity.getnCodPerso());
		bean.getMatriculaBean().getInsti().setCodigo(entity.getnCodInsti());
		bean.getMatriculaBean().getInsti().setNombreInstitucion(entity.getvNominsti());
		bean.getMatriculaBean().getDocenteBean().getPersonaBean().setNombreCompleto(entity.getvNomdocente() != null ? entity.getvNomdocente() : "");
		bean.getAlumnoBean().getPersonaBean().setNombreCompleto(entity.getvNomalumno() != null ? entity.getvNomalumno() : "");
		//bean.getMatriculaBean().getLengua().setNombre(entity.getvNomlengua());
		bean.getMatriculaBean().getNivel().setNombreCorto(entity.getvNomtm2nivel()!=null ? entity.getvNomtm2nivel() : "");
		bean.getMatriculaBean().getSubNivel().setNombreCorto(entity.getvTm2subniv()!=null ? entity.getvTm2subniv() : "");
		bean.getMatriculaBean().getDocenteBean().setCodigo(entity.getnCoddocen());
		bean.getMatriculaBean().getSituacion().setNombreLargo(entity.getvTm1sitmat());
		bean.getMatriculaBean().getCiclo().setNombreCorto(entity.getvTm2ciclo()!= null ? entity.getvTm2ciclo() : "");
		
		bean.getMatriculaBean().getInscripcion().setFechaRegistro(entity.getdFecReg()!=null?entity.getdFecReg():new Date());
		bean.getMatriculaBean().getInscripcion().setFechaModificacion(entity.getdFecMod()!=null?entity.getdFecMod():new Date());
		
		bean.getAlumnoBean().setUsuario(entity.getvNomusuari()!= null ? entity.getvNomusuari() : "");
		bean.getAlumnoBean().getTm2Grado().setCodigoRegistro(entity.getnTm2Grado());
		bean.getAlumnoBean().getTm1Situacion().setCodigoRegistro(entity.getnTm1SitAlu());
		
		bean.getMatriculaBean().setCodigo(entity.getnCodMatri());
		bean.getMatriculaBean().getLengua().setCodigo(entity.getnCodLengua());
		bean.getMatriculaBean().getNivel().setCodigoRegistro(entity.getnTm2Nivel());
		bean.getMatriculaBean().getSubNivel().setCodigoRegistro(entity.getnTm2Subniv());
 		bean.getMatriculaBean().getPeriodo().setCodigoRegistro(entity.getnPeriodo());
		bean.getMatriculaBean().getCiclo().setCodigoRegistro(entity.getnTm2Ciclo());
		
		bean.getMatriculaBean().getSituacion().setCodigoRegistro(entity.getnTm1SitMat());
		bean.getMatriculaBean().getTipoMatricula().setCodigoRegistro(entity.getnTm1TipmaT());
		bean.getMatriculaBean().setvObservaci(entity.getvObservaci());
		bean.getMatriculaBean().getLengua().setNombre(entity.getvNomLengua());
		
		bean.getAlumnoBean().getPersonaBean().setNombrePersona(entity.getvNombreper());
		bean.getAlumnoBean().getPersonaBean().setApellidoPaterno(entity.getvApepatper());
		bean.getAlumnoBean().getPersonaBean().setApellidoMaterno(entity.getvApematper());
		bean.getAlumnoBean().getPersonaBean().setNumeroDocumento(entity.getvNumdocum());
	    bean.setNota(entity.getnNota());
		//bean.setFechaCreacion(entity.getdFecReg());
//		bean.getMatriculaBean().getNivel().setNombreCorto(entity.getvNombreNivel());
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
public List<MatriculaAlumnoBean> getBuscarMatriculaXAlumno(MatriculaAlumnoBean matriculaAlumnoBean) throws DAOException {
	
	List<LeomvdMatriculaAlumno> lstLeomvdMatriculaAlumno = null;	
	List<MatriculaAlumnoBean> lstMatriculaAlumnoBean = null;
	
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvd_matalumno.buscarMatriculaXAlumno");
		spq.setParameter("p_codmatri", matriculaAlumnoBean.getMatriculaBean().getCodigo());   
		if (spq.execute()) {
			lstLeomvdMatriculaAlumno =  spq.getResultList(); 
		} 
		if (lstLeomvdMatriculaAlumno != null && lstLeomvdMatriculaAlumno.size() > 0) {
			
			lstMatriculaAlumnoBean = deListaMatriculaAlumnoAListaMatriculaAlumnoBean(lstLeomvdMatriculaAlumno);
		}
	em.close();
		
	   
	return lstMatriculaAlumnoBean;
}

@Override
public List<MatriculaAlumnoBean> validarMatriculaAlumnoXInscrLengua(InscripcionLenguaBean inscripcionLenguaBean)
		throws DAOException {
	
	List<LeomvdMatriculaAlumno> lstLeomvdMatriculaAlumno = null;	
	List<MatriculaAlumnoBean> lstMatriculaAlumnoBean = null;
	
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvd_matalumno.validarMatriculaAlumnoXInscrLen");
		spq.setParameter("p_inscrlen", inscripcionLenguaBean.getCodigo());   
		if (spq.execute()) {
			lstLeomvdMatriculaAlumno =  spq.getResultList(); 
		} 
		if (lstLeomvdMatriculaAlumno != null && lstLeomvdMatriculaAlumno.size() > 0) {
			
			lstMatriculaAlumnoBean = deListaMatriculaAlumnoAListaMatriculaAlumnoBean(lstLeomvdMatriculaAlumno);
		}
	em.close();
		
	   
	return lstMatriculaAlumnoBean;
}
@Override
public List<MatriculaAlumnoBean> listarSeguimientoMatAlu(MatriculaAlumnoBean matriculaAlumnoBean)
		throws DAOException {
	System.out.println("em getBuscarPorFiltros " + em);

	List<LeomvdMatriculaAlumno> lstMatriculaAlumno = null;	
	List<MatriculaAlumnoBean> lstMatriculaAlumnoBean = null;
	
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvc_matricula.listarSeguimientoAlumno");
		System.out.println("listarSeguimientoAlumno");
		System.out.println("p_codisnti"+matriculaAlumnoBean.getMatriculaBean().getInsti().getCodigo() );
		System.out.println("p_codlengua"+matriculaAlumnoBean.getMatriculaBean().getLengua().getCodigo() );
		System.out.println("p_coddocen"+matriculaAlumnoBean.getMatriculaBean().getDocenteBean().getCodigo() );
		
		spq.setParameter("p_codisnti", matriculaAlumnoBean.getMatriculaBean().getInsti().getCodigo() );  
		spq.setParameter("p_codlengua", matriculaAlumnoBean.getMatriculaBean().getLengua().getCodigo());  
		spq.setParameter("p_coddocen", matriculaAlumnoBean.getMatriculaBean().getDocenteBean().getCodigo());  
		spq.setParameter("p_tm2nivel",matriculaAlumnoBean.getMatriculaBean().getNivel().getCodigoRegistro()); 
		spq.setParameter("p_periodo", matriculaAlumnoBean.getMatriculaBean().getPeriodo().getCodigoRegistro()); 
		spq.setParameter("p_tm1sitmat", matriculaAlumnoBean.getMatriculaBean().getSituacion().getCodigoRegistro());  
		
		
		if (spq.execute()) {
			lstMatriculaAlumno =  spq.getResultList(); 
		} 
		if (lstMatriculaAlumno != null && lstMatriculaAlumno.size() > 0) {
			lstMatriculaAlumnoBean = deListaMatriculaAlumnoAListaMatriculaAlumnoBean(lstMatriculaAlumno);
		}
	em.close();
		
	   
	return lstMatriculaAlumnoBean;
}

@Override
public boolean calcularPromedioEva(MatriculaAlumnoBean matriculaAlumnoBean)
		throws DAOException {
	boolean sw=false;
	Object respuesta = null;
	try {
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvc_matricula.calcularPromedioNotaEva");
		spq.setParameter("p_tm2nivel", 	matriculaAlumnoBean.getMatriculaBean().getNivel().getCodigoRegistro()); 
		spq.setParameter("p_codusumat", matriculaAlumnoBean.getUsuarioMatriculaBean().getCodigo()); 
		spq.setParameter("p_codusumod", matriculaAlumnoBean.getCodigoUsuarioModificacion());
		spq.setParameter("p_hostmod",	matriculaAlumnoBean.getIpModificacion());
		spq.execute();  
		
		respuesta = spq.getOutputParameterValue(1);
		
		if (respuesta != null) {
			matriculaAlumnoBean.setRespuesta(Integer.valueOf(respuesta.toString()));
			sw=true;
		}else{
			System.out.println("Error");
		}
		
		 
	} catch (Exception e) {
		e.printStackTrace();
		sw=false; 
	}finally{
		em.close();
	}
	return sw;
	
}


}
