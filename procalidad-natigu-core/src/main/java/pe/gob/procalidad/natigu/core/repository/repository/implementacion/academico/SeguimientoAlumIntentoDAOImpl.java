package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMedallaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumIntentoBean; 
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbdAlumnoMedalla;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbdSeguimientoAluIntento; 
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.seguimientoAlumintentoDAO;; 
@Repository("seguimientoAlumintentoDAO")
@Transactional(readOnly = true)
public class SeguimientoAlumIntentoDAOImpl 
implements seguimientoAlumintentoDAO{
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(SeguimientoAlumIntentoBean Bean)
			throws DAOException {
		System.out.println("SeguimientoAlumIntentoBean" + Bean);
		boolean sw = false;
		Object cod = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_seguimientoAluIntento.insertar");
			spq.setParameter("p_codsegaluinten", Bean.getCodigo());
			spq.setParameter("p_codusumat", Bean.getUsuarioMatriculaBean().getCodigo());
			spq.setParameter("p_codmatpej", Bean.getMaterialTipoEjercicioBean().getCodigo()); 
			spq.setParameter("p_codusureg", Bean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", Bean.getIpCreacion());
			
			spq.execute();
			
			cod = spq.getOutputParameterValue(1);
			
			if (cod != null) {
				Bean.setCodigo(Long.valueOf(cod.toString()));
				sw = true;
			}else{
				System.out.println("obj es  null");
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
	public boolean insertarDet(SeguimientoAlumIntentoBean Bean)
			throws DAOException {
		System.out.println("SeguimientoAlumIntentoBean" + Bean);
		boolean sw = false;
		Object cod = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_seguimientoAluIntentoDet.insertar");
			spq.setParameter("p_codsegaluinten", Bean.getCodigo());
			spq.setParameter("p_codusumat", Bean.getUsuarioMatriculaBean().getCodigo());
			spq.setParameter("p_codmatpej", Bean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_codpregun", Bean.getPreguntaBean().getCodigo());
			spq.setParameter("p_codusureg", Bean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", Bean.getIpCreacion());
			
			spq.execute();
			
			cod = spq.getOutputParameterValue(1);
			
			if (cod != null) {
				Bean.setCodigo(Long.valueOf(cod.toString()));
				sw = true;
			}else{
				System.out.println("obj es  null");
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
	public boolean actualizar(SeguimientoAlumIntentoBean Bean)
			throws DAOException { 
		boolean sw=false; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_seguimientoAluIntento.actualizar");
			spq.setParameter("p_codsegaluinten", Bean.getCodigo());   
			spq.setParameter("p_codusumat",  Bean.getUsuarioMatriculaBean().getCodigo());
			spq.setParameter("p_codmatpej", Bean.getMaterialTipoEjercicioBean().getCodigo());   
			spq.setParameter("p_codusumod", Bean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", Bean.getIpModificacion());
			
			spq.execute();   
//			sw=true;  
		  
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}
	
	
	@Override
	public boolean actualizarDet(SeguimientoAlumIntentoBean Bean)
			throws DAOException { 
		boolean sw=false; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_seguimientoAluIntentoDet.actualizar");
			spq.setParameter("p_codsegaluinten", Bean.getCodigo());   
			spq.setParameter("p_codusumat",  Bean.getUsuarioMatriculaBean().getCodigo());
			spq.setParameter("p_codmatpej", Bean.getMaterialTipoEjercicioBean().getCodigo());  
			spq.setParameter("p_codpregun", Bean.getPreguntaBean().getCodigo());  
			spq.setParameter("p_codusumod", Bean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", Bean.getIpModificacion());
			
			spq.execute();   
//			sw=true;  
		  
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}
	
	

	@Override
	public boolean eliminar(SeguimientoAlumIntentoBean Bean)
			throws DAOException {
		System.out.println("SeguimientoAlumIntentoBean" + Bean);
		boolean sw = false;
		
		try { 
			
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public SeguimientoAlumIntentoBean getBuscarPorObjecto(
			SeguimientoAlumIntentoBean Bean) throws DAOException {
		SeguimientoAlumIntentoBean oBean = null;
		List<LeotbdSeguimientoAluIntento> lstLeotbd = null;
		System.out.println(" Bean getBuscarPorObjecto " + Bean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_seguimientoAluIntento.buscarXAlumEjer");			
			spq.setParameter("p_codusumat", Bean.getUsuarioMatriculaBean().getCodigo()); 
			spq.setParameter("p_codmatpej", Bean.getMaterialTipoEjercicioBean().getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbd = spq.getResultList();			
			}
			
			if (	lstLeotbd != null
				&&	lstLeotbd.size() > 0) {
				
				oBean = deLeotbdSeguimientoAluIntentoABean(lstLeotbd.get(0));
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
	public List<SeguimientoAlumIntentoBean> getBuscarPorFiltros(SeguimientoAlumIntentoBean  Bean)
			throws DAOException {
		System.out.println("em " + em);
		List<LeotbdSeguimientoAluIntento> lstLeotbd  = null;	
		List<SeguimientoAlumIntentoBean> lstAlumnoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_seguimientoAluIntentoDet.intentosXsubnivel");
			spq.setParameter("p_codlengua", Bean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().getCodigo());  
			spq.setParameter("p_codusuari", Bean.getUsuarioMatriculaBean().getUsuarioBean().getCodigo());  
 			
			if (spq.execute()) {
				lstLeotbd =  spq.getResultList(); 
			} 
			if (lstLeotbd != null && lstLeotbd.size() > 0) {
				
				lstAlumnoBean = deListaAlumnoMedallaAListaAlumnoMedallaBean(lstLeotbd);
			}
			//em.close();
		   
		return lstAlumnoBean;
	}
	
	
	
	@Override
	public SeguimientoAlumIntentoBean getBuscarPorObjectoDet(
			SeguimientoAlumIntentoBean Bean) throws DAOException {
		SeguimientoAlumIntentoBean oBean = null;
		List<LeotbdSeguimientoAluIntento> lstLeotbd = null;
		System.out.println(" Bean getBuscarPorObjecto " + Bean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_seguimientoAluIntentoDet.buscarXAlumEjer");			
			spq.setParameter("p_codusumat", Bean.getUsuarioMatriculaBean().getCodigo()); 
			spq.setParameter("p_codmatpej", Bean.getMaterialTipoEjercicioBean().getCodigo()); 
			spq.setParameter("p_codpregun", Bean.getPreguntaBean().getCodigo()); 
		
			if (spq.execute()) {
				lstLeotbd = spq.getResultList();			
			}
			
			if (	lstLeotbd != null
				&&	lstLeotbd.size() > 0) {
				
				oBean = deLeotbdSeguimientoAluIntentoABean(lstLeotbd.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oBean;
	}
	
	
private List<SeguimientoAlumIntentoBean> deListaAlumnoMedallaAListaAlumnoMedallaBean(List<LeotbdSeguimientoAluIntento> lstLeotbd) {
		
		List<SeguimientoAlumIntentoBean> lstAlumnoMedallaBean = null;
		
		if (lstLeotbd != null && lstLeotbd.size() > 0) {
			
			lstAlumnoMedallaBean = new ArrayList<SeguimientoAlumIntentoBean>();
			
			for (int i = 0; i < lstLeotbd.size(); i++) { 
				LeotbdSeguimientoAluIntento entity = lstLeotbd.get(i);
				SeguimientoAlumIntentoBean bean = deLeotbdSeguimientoAluIntentoABean(entity);
				
				lstAlumnoMedallaBean.add(bean);
			}
		}
		return lstAlumnoMedallaBean;
	}


		private SeguimientoAlumIntentoBean deLeotbdSeguimientoAluIntentoABean(LeotbdSeguimientoAluIntento entity) {
		
			SeguimientoAlumIntentoBean bean = null;
		
		if (entity != null) {
			
			bean = new SeguimientoAlumIntentoBean();
			bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
			bean.setLenguaBean(new LenguaBean());
			bean.setInstitucionBean(new InstitucionBean());
			bean.getUsuarioMatriculaBean().getMatriculaBean().setLengua(new LenguaBean());
			bean.getUsuarioMatriculaBean().setMatriculaBean(new MatriculaBean());
			bean.getUsuarioMatriculaBean().setUsuarioBean(new UsuarioBean());
			bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
			bean.setPreguntaBean(new PreguntaBean());
			bean.setCodigo(entity.getnCodsegaluinten());
			bean.setNumeroIntento(entity.getnNumIntento()); 
			bean.getUsuarioMatriculaBean().setCodigo(entity.getnCodusumat()); 
			bean.getMaterialTipoEjercicioBean().setCodigo(entity.getnCodmatpej()); 
			bean.setEstado(entity.getvFlgest());
			bean.setCantidadIntentos(entity.getN_cantinten());
			bean.setCodigoUsuarioCreacion(entity.getnCodUsuRegistro());
			bean.setCodigoUsuarioModificacion(entity.getnCodUsuModificado());
			bean.setNivel(entity.getV_nomcorto());
			bean.setNombreAlumno(entity.getV_nomalumno());
			bean.getLenguaBean().setNombre(entity.getV_nomlengua());
			bean.getInstitucionBean().setNombreInstitucion(entity.getV_nominsti());
			
			
//			v_nominsti;
//			 v_nomlengua;
//			 v_nomalumno;
			
			
			
		}
		
		return  bean;
	}
	
	@Override
	public boolean existe(SeguimientoAlumIntentoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	 
}
