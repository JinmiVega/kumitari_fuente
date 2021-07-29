package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumnoEjerDetBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumnoEjercicioBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcSeguimientoAlumnoEjer;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.SeguimientoAlumnoEjerDetDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.SeguimientoAlumnoEjercicioDAO;
@Repository("seguimientoAlumnoEjerDetDAO")
@Transactional(readOnly = true)
public class SeguimientoAlumnoEjerDetDAOImpl 
implements SeguimientoAlumnoEjerDetDAO{
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(SeguimientoAlumnoEjerDetBean seguimientoAlumnoEjercicioBean)
			throws DAOException {
		System.out.println("SeguimientoAlumnoEjercicioBean" + seguimientoAlumnoEjercicioBean);
		boolean sw = false;
		Object codSeguimiento = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_segaluejercicioDet.insertar");
			spq.setParameter("p_nummonedas", seguimientoAlumnoEjercicioBean.getNumeroMonedas());
			spq.setParameter("p_codusumat", seguimientoAlumnoEjercicioBean.getUsuarioBean().getCodigo());
			spq.setParameter("p_codlengua", seguimientoAlumnoEjercicioBean.getLenguaBean().getCodigo());
			spq.setParameter("p_codmatpej", seguimientoAlumnoEjercicioBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_codpregun", seguimientoAlumnoEjercicioBean.getPreguntaBean().getCodigo());
			spq.setParameter("p_codusureg", seguimientoAlumnoEjercicioBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", seguimientoAlumnoEjercicioBean.getIpCreacion());
			
			spq.execute();
			
			codSeguimiento = spq.getOutputParameterValue(1);
			
			if (codSeguimiento != null) {
				seguimientoAlumnoEjercicioBean.setCodigo(Long.valueOf(codSeguimiento.toString()));
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
	public boolean actualizar(SeguimientoAlumnoEjerDetBean seguimientoAlumnoEjercicioBean)
			throws DAOException {
		
//		System.out.println("SeguimientoAlumnoEjercicioBean" + seguimientoAlumnoEjercicioBean);
 		boolean sw = false;
//		
//		try {
//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_segaluejercicio.actulizar");
//			spq.setParameter("p_codsegaluejer", seguimientoAlumnoEjercicioBean.getCodigo());
//			spq.setParameter("p_nummonedas", seguimientoAlumnoEjercicioBean.getNumeroMonedas());
//			spq.setParameter("p_codusuari", seguimientoAlumnoEjercicioBean.getUsuarioBean().getCodigo());
//			spq.setParameter("p_codlengua", seguimientoAlumnoEjercicioBean.getLenguaBean().getCodigo());
//			spq.setParameter("p_codmatpej", seguimientoAlumnoEjercicioBean.getMaterialTipoEjercicioBean().getCodigo());
//			spq.setParameter("p_codusureg", seguimientoAlumnoEjercicioBean.getCodigoUsuarioCreacion());
//			spq.setParameter("p_hostreg", seguimientoAlumnoEjercicioBean.getIpCreacion());
//			
//			spq.execute();
//						
//			sw = true;
//
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			sw = false;
//		}finally{
//			em.close();
//		}
		return sw;
	}

	@Override
	public boolean eliminar(SeguimientoAlumnoEjerDetBean seguimientoAlumnoEjercicioBean)
			throws DAOException {
		System.out.println("SeguimientoAlumnoEjercicioBean" + seguimientoAlumnoEjercicioBean);
		boolean sw = false;
		
//		try {
//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_segaluejercicio.eliminar");
//			spq.setParameter("p_codsegaluejer", seguimientoAlumnoEjercicioBean.getCodigo());
//			spq.setParameter("p_codusureg", seguimientoAlumnoEjercicioBean.getCodigoUsuarioCreacion());
//			spq.setParameter("p_hostreg", seguimientoAlumnoEjercicioBean.getIpCreacion());
//			
//			spq.execute();
//						
//			sw = true;
//
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			sw = false;
//		}finally{
//			em.close();
//		}
		return sw;
	}

 
 
	private SeguimientoAlumnoEjercicioBean deSeguimientoAlumnoEjercicioASeguimientoAlumnoEjercicioBean(LeotbcSeguimientoAlumnoEjer entity){
		SeguimientoAlumnoEjercicioBean bean = null;
		if (entity != null) {
			bean = new SeguimientoAlumnoEjercicioBean();
		}
		return bean;
	}
	
	@Override
	public boolean existe(SeguimientoAlumnoEjerDetBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

 

	@Override
	public SeguimientoAlumnoEjerDetBean getBuscarPorObjecto(
			SeguimientoAlumnoEjerDetBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeguimientoAlumnoEjerDetBean> getBuscarPorFiltros(
			SeguimientoAlumnoEjerDetBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

 

}
