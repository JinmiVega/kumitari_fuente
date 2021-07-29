package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumIntentoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcAlumno;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcEvaluacion;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbdSeguimientoAluIntento;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.EvaluacionDAO;
@Repository("evaluacionDAO")
@Transactional(readOnly = true)
public class EvaluacionDAOImp implements EvaluacionDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(EvaluacionBean evaluacionBean) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("evaluacionBean DAO "+evaluacionBean);
		Object idEvaluacion= null; 
		
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_evaluacion.insertar");
			
			spq.setParameter("p_codlengua",evaluacionBean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().getCodigo());
			spq.setParameter("p_codusumat", evaluacionBean.getUsuarioMatriculaBean().getCodigo());
			spq.setParameter("p_tm2subnivel", evaluacionBean.getSubNivel().getCodigoRegistro()); 
			spq.setParameter("p_codundlec", evaluacionBean.getUnidadLeccionBean().getCodigo());			
			spq.setParameter("p_tm2nivel", evaluacionBean.getNivel().getCodigoRegistro());
			spq.setParameter("p_codusureg", evaluacionBean.getCodigoUsuarioCreacion());						
			spq.setParameter("p_hostreg", evaluacionBean.getIpCreacion());
			

			
			spq.execute();
			
			idEvaluacion = spq.getOutputParameterValue(1);
			
			if (idEvaluacion != null) {
				System.out.println("Ingreso a Insertar evaluacion");
				
				evaluacionBean.setCodigo(Long.valueOf(idEvaluacion.toString()));
				System.out.println("evaluacionBean.setCodigo()"+evaluacionBean.getCodigo());

				
				sw = true;
				
			}else{
				System.out.println("obj llego vacio.");
				sw = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw = false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean actualizar(EvaluacionBean evaluacionBean) throws DAOException {

		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_evaluacion.actulizar");
			
			spq.setParameter("p_codevalua",evaluacionBean.getCodigo());
			spq.setParameter("p_tm1siteva",(long) evaluacionBean.getSituacionEvaluacion().getCodigoRegistro());
			spq.setParameter("p_codusumod", evaluacionBean.getCodigoUsuarioModificacion());


			spq.setParameter("p_hostmod", evaluacionBean.getIpModificacion());						
			
			

			
			spq.execute();
			sw = true;
				
		
		} catch (Exception e) {
			e.printStackTrace();
			sw = false; 
		}finally{
			em.close();
		}
		return sw;
	}


	@Override
	public boolean actualizarFechaEvaluacion(EvaluacionBean evaluacionBean) throws DAOException {

		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_evaluacion.actulizarFechaEvaluacion");
			
			spq.setParameter("p_codevalua",evaluacionBean.getCodigo());
						
			spq.execute();
			sw = true;
				
		
		} catch (Exception e) {
			e.printStackTrace();
			sw = false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(EvaluacionBean evaluacionBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EvaluacionBean getBuscarPorObjecto(EvaluacionBean evaluacionBean) throws DAOException {
		EvaluacionBean oEvaluacionBean = null;
		List<LeotbcEvaluacion> lstLeotbcEvaluacion = null;
		System.out.println("evaluacionBean getBuscarPorObjecto " + evaluacionBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_evaluacion.buscarxcodEvaluacion");			
			spq.setParameter("p_codevalua", evaluacionBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcEvaluacion = spq.getResultList();			
			}
			
			if (	lstLeotbcEvaluacion != null
				&&	lstLeotbcEvaluacion.size() > 0) {
				oEvaluacionBean = deLeotbcEvaluacionAEvaluacionBean(lstLeotbcEvaluacion.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oEvaluacionBean;
	}

	@Override
	public List<EvaluacionBean> getBuscarPorFiltros(EvaluacionBean  Bean)
			throws DAOException {
		System.out.println("em " + em);
		List<LeotbcEvaluacion> lstLeotbd  = null;	
		List<EvaluacionBean> lstAlumnoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_evaluacion.reporte");
			spq.setParameter("p_codlengua", Bean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().getCodigo());  
			spq.setParameter("p_codusuari", Bean.getUsuarioMatriculaBean().getUsuarioBean().getCodigo());  
 			
			if (spq.execute()) {
				lstLeotbd =  spq.getResultList(); 
			} 
			if (lstLeotbd != null && lstLeotbd.size() > 0) {
				
				lstAlumnoBean = deListaAlumnoAListaAlumnoBean(lstLeotbd);
			}
			//em.close();
		   
		return lstAlumnoBean;
	}
	

	@Override
	public boolean existe(EvaluacionBean evaluacionBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private List<EvaluacionBean> deListaAlumnoAListaAlumnoBean(List<LeotbcEvaluacion> lstLeotbcEvaluacion) {
		
		List<EvaluacionBean> lstEvaluacionBean = null;
		
		if (lstLeotbcEvaluacion != null && lstLeotbcEvaluacion.size() > 0) {
			
			lstEvaluacionBean = new ArrayList<EvaluacionBean>();
			
			for (int i = 0; i < lstLeotbcEvaluacion.size(); i++) { 
				LeotbcEvaluacion entity = lstLeotbcEvaluacion.get(i);
				EvaluacionBean bean = deLeotbcEvaluacionAEvaluacionBean(entity);
				
				lstEvaluacionBean.add(bean);
			}
		}
		return lstEvaluacionBean;
	}
	
	private EvaluacionBean deLeotbcEvaluacionAEvaluacionBean(LeotbcEvaluacion entity) {
		
		EvaluacionBean bean = null;
		
		if (entity != null) {
			bean = new EvaluacionBean();
			bean.setInstitucionBean(new InstitucionBean());
			bean.setNivel(new MaestraBean());
			bean.setSubNivel(new MaestraBean());
			
			bean.getUsuarioMatriculaBean().setMatriculaBean(new MatriculaBean());
			bean.getUsuarioMatriculaBean().getMatriculaBean().setLengua(new LenguaBean()); 
			bean.getUsuarioMatriculaBean().setUsuarioBean(new UsuarioBean());
			bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
			
			bean.setNomAlumno(entity.getV_nombreper());
			bean.setNomNivel(entity.getV_nomnivel());
			bean.setNomSubnivel(entity.getV_nomsubnivel());
			bean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().setNombre(entity.getV_nomlengua());
			bean.getInstitucionBean().setNombreInstitucion(entity.getV_nominsti());
			bean.getNivel().setCodigoRegistro(entity.getnTm2nivel());
			bean.getSubNivel().setCodigoRegistro(entity.getnTm2subnivel());
			
			if(entity.getvNomlargo() == null){ 
				bean.getSubNivel().setNombreLargo("");
			}else{
				bean.getSubNivel().setNombreLargo(entity.getvNomlargo());
			}
			
			
			 
		
			if(entity.getnCodevalua() == null){ 
				bean.setCodigo(0);	
			}else{
				bean.setCodigo(entity.getnCodevalua());	
			}
			 
			if(entity.getnCodusumat() != null){ 
				bean.getUsuarioMatriculaBean().setCodigo(entity.getnCodusumat());
			}else{
				
				bean.getUsuarioMatriculaBean().setCodigo(0);	
			}
			
			if(entity.getnTotejercio()== null){ 
				bean.setTotalEjercicio(0);
			}else{
				bean.setTotalEjercicio(entity.getnTotejercio());
			}
			
			if (entity.getnCorrectos() == null) {
				bean.setCorrectos(0);
			}else{
				bean.setCorrectos(entity.getnCorrectos());
			}
			if (entity.getnErrados() == null) {
				bean.setErradas(0);
			}else{
				bean.setErradas(entity.getnErrados());
			}
			if (entity.getN_nota() == null) {
				bean.setNota(0);
			}else{
				bean.setNota(entity.getN_nota());
			}
			if (entity.getnCodmedalla() == null) {
				bean.getMedalla().setCodigo(0);
			}else{
				bean.getMedalla().setCodigo(entity.getnCodmedalla());
			}
			if (entity.getdFechahoraeve() != null) {
				System.out.println("entity.getdFechahoraeve() "+ entity.getdFechahoraeve());
				bean.setFechaHoraEvaluacion(entity.getdFechahoraeve());
			}
			if (entity.getdFechahoraini()!= null) {
				System.out.println("entity.getdFechahoraini() "+ entity.getdFechahoraini());
				bean.setFechaHoraInicio(entity.getdFechahoraini());
			}
			if (entity.getdFechahorafin()!=null) {
				System.out.println("entity.getdFechahorafin() " + entity.getdFechahorafin());
				bean.setFechaHoraTermino(entity.getdFechahorafin());
			}
			if (entity.getvNomimag() == null) {
				bean.getMedalla().setImagenNombre("");
			}else{
				bean.getMedalla().setImagenNombre(entity.getvNomimag());
			}
			if (entity.getvNompremio() == null) {
				bean.getMedalla().setNombre("");
			}else{
				bean.getMedalla().setNombre(entity.getvNompremio());
			}
			
			
			if (entity.getnTm1siteva() == null) {
				bean.getSituacionEvaluacion().setCodigoRegistro(0);
			}else{
				bean.getSituacionEvaluacion().setCodigoRegistro((int)(long)(entity.getnTm1siteva()));
			}
			
			if (entity.getvFechaactual()!=null) {
				System.out.println("entity.getvFechaactual() " + entity.getvFechaactual());
				bean.setVfechaactual(entity.getvFechaactual());
			}
			
			if (entity.getvFechahoraeve()!=null) {
				System.out.println("entity.getvFechaactual() " + entity.getvFechahoraeve());
				bean.setVfechaeve(entity.getvFechahoraeve());
			}
			
			if (entity.getvFechahoraini()!=null) {
				System.out.println("entity.getvFechaactual() " + entity.getvFechahoraini());
				bean.setVfechaini(entity.getvFechahoraini());
			}
			
			if (entity.getvFechahorafin()!=null) {
				System.out.println("entity.getvFechaactual() " + entity.getvFechahorafin());
				bean.setVfechafin(entity.getvFechahorafin());
			}
			if (entity.getnTm2tipoevalucion() != null) {
				bean.getTipoEvaluacion().setCodigoRegistro((int) (long) entity.getnTm2tipoevalucion());
			}else{
				bean.getTipoEvaluacion().setCodigoRegistro(0);
			}
			
		}
		
		return bean;
	}

	@Override
	public EvaluacionBean iniciarEvaluacion(EvaluacionBean evaluacionBean)throws DAOException {
		EvaluacionBean oEvaluacionBean = null;
		List<LeotbcEvaluacion> lstLeotbcEvaluacion = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_evaluacion.iniciarEvaluacion");			
			spq.setParameter("p_codlengua", evaluacionBean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().getCodigo()); 
			spq.setParameter("p_codusumat", evaluacionBean.getUsuarioMatriculaBean().getCodigo()); 
			spq.setParameter("p_tm1siteva", (long) evaluacionBean.getSituacionEvaluacion().getCodigoRegistro());
			spq.setParameter("p_tm2subnivel", (long) evaluacionBean.getSubNivel().getCodigoRegistro());
		
			if (spq.execute()) {
				lstLeotbcEvaluacion = spq.getResultList();			
			}
			
			if (	lstLeotbcEvaluacion != null
				&&	lstLeotbcEvaluacion.size() > 0) {
				oEvaluacionBean = deLeotbcEvaluacionAEvaluacionBean(lstLeotbcEvaluacion.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oEvaluacionBean;
	}

	@Override
	public boolean obtenerNota(EvaluacionBean evaluacionBean)throws DAOException {
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_evaldetalle.obtenerNota");
			
			spq.setParameter("p_codevalua",evaluacionBean.getCodigo());
			
			spq.setParameter("p_codusumod", evaluacionBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", evaluacionBean.getIpModificacion());						
			
			spq.execute();
			sw = true;
				
		
		} catch (Exception e) {
			e.printStackTrace();
			sw = false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean pasarHistorico(EvaluacionBean evaluacionBean)
			throws DAOException {
		boolean sw=false;
		Object resp = null;
		try {	
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_evaluacion.historico");
			
			
			spq.setParameter("p_codevalua",evaluacionBean.getCodigo());
			spq.setParameter("p_codusumat", evaluacionBean.getUsuarioMatriculaBean().getCodigo());
			spq.setParameter("p_tm2subnivel", (long) evaluacionBean.getSubNivel().getCodigoRegistro());			
			spq.setParameter("p_codusumod", evaluacionBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", evaluacionBean.getIpModificacion());						
			
			spq.execute();
			resp = spq.getOutputParameterValue(1);
			if (resp != null) {
				evaluacionBean.setRespuesta(Integer.valueOf(resp.toString()));
				sw = true;
			}else{
				System.out.println("Respuesta  null");
				sw = false;
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			sw = false; 
		}finally{
			em.close();
		}
		return sw;
	}
	@Override
	public List<EvaluacionBean> listarNotas(UsuarioMatriculaBean usuarioMatriculaBean) throws DAOException {
		List<LeotbcEvaluacion> lstEvaluacion= null;	
		List<EvaluacionBean> lstEvaluacionBean = null;
	 
		//UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
//		System.out.println("codigo" + alumnoBean.getCodigo() );
//		System.out.println("nota" + alumnoBean.getCodigo() );
		System.out.println("codigoregistro" + usuarioMatriculaBean.getCodigo() );
	 
		 
		
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_evaluacion.listar_notas");
			spq.setParameter("p_codusumat", usuarioMatriculaBean.getCodigo());
			 
			if (spq.execute()) {
				lstEvaluacion =  spq.getResultList(); 
			} 
			if (lstEvaluacion != null && lstEvaluacion.size() > 0) {
				
				lstEvaluacionBean = deListaAlumnoAListaAlumnoBean(lstEvaluacion);
			}
			//em.close();
		   
		return lstEvaluacionBean;
	}

	@Override
	public boolean insertarEvaluacionFinal(EvaluacionBean evaluacionBean)
			throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("evaluacionBean DAO "+evaluacionBean);
		Object idEvaluacion= null; 
		
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_evaluacion.insertarEvaluacionFinal");
			
			spq.setParameter("p_codlengua",evaluacionBean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().getCodigo());
			spq.setParameter("p_codusumat", evaluacionBean.getUsuarioMatriculaBean().getCodigo());			
			spq.setParameter("p_tm2nivel", evaluacionBean.getNivel().getCodigoRegistro());
			spq.setParameter("p_codundlec", evaluacionBean.getUnidadLeccionBean().getCodigo());					
			spq.setParameter("p_codusureg", evaluacionBean.getCodigoUsuarioCreacion());						
			spq.setParameter("p_hostreg", evaluacionBean.getIpCreacion());
			

			
			spq.execute();
			
			idEvaluacion = spq.getOutputParameterValue(1);
			
			if (idEvaluacion != null) {
				System.out.println("Ingreso a Insertar evaluacion");
				
				evaluacionBean.setCodigo(Long.valueOf(idEvaluacion.toString()));
				System.out.println("evaluacionBean.setCodigo()"+evaluacionBean.getCodigo());

				
				sw = true;
				
			}else{
				System.out.println("obj llego vacio.");
				sw = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw = false; 
		}finally{
			em.close();
		}
		return sw;
	}

}
