package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumnoEjercicioBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcSeguimientoAlumnoEjer;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.SeguimientoAlumnoEjercicioDAO;
@Repository("seguimientoAlumnoEjercicioDAO")
@Transactional(readOnly = true)
public class SeguimientoAlumnoEjercicioDAOImpl 
implements SeguimientoAlumnoEjercicioDAO{
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(SeguimientoAlumnoEjercicioBean seguimientoAlumnoEjercicioBean)
			throws DAOException {
		System.out.println("SeguimientoAlumnoEjercicioBean" + seguimientoAlumnoEjercicioBean);
		boolean sw = false;
		Object codSeguimiento = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_segaluejercicio.insertar");
			spq.setParameter("p_nummonedas", seguimientoAlumnoEjercicioBean.getNumeroMonedas());
			spq.setParameter("p_codusuari", seguimientoAlumnoEjercicioBean.getUsuarioBean().getCodigo());
			spq.setParameter("p_codlengua", seguimientoAlumnoEjercicioBean.getLenguaBean().getCodigo());
			spq.setParameter("p_codmatpej", seguimientoAlumnoEjercicioBean.getMaterialTipoEjercicioBean().getCodigo());
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
	public boolean actualizar(SeguimientoAlumnoEjercicioBean seguimientoAlumnoEjercicioBean)
			throws DAOException {
		System.out.println("SeguimientoAlumnoEjercicioBean" + seguimientoAlumnoEjercicioBean);
		boolean sw = false;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_segaluejercicio.actulizar");
			spq.setParameter("p_codsegaluejer", seguimientoAlumnoEjercicioBean.getCodigo());
			spq.setParameter("p_nummonedas", seguimientoAlumnoEjercicioBean.getNumeroMonedas());
			spq.setParameter("p_codusuari", seguimientoAlumnoEjercicioBean.getUsuarioBean().getCodigo());
			spq.setParameter("p_codlengua", seguimientoAlumnoEjercicioBean.getLenguaBean().getCodigo());
			spq.setParameter("p_codmatpej", seguimientoAlumnoEjercicioBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_codusureg", seguimientoAlumnoEjercicioBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", seguimientoAlumnoEjercicioBean.getIpCreacion());
			
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
	public boolean eliminar(SeguimientoAlumnoEjercicioBean seguimientoAlumnoEjercicioBean)
			throws DAOException {
		System.out.println("SeguimientoAlumnoEjercicioBean" + seguimientoAlumnoEjercicioBean);
		boolean sw = false;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_segaluejercicio.eliminar");
			spq.setParameter("p_codsegaluejer", seguimientoAlumnoEjercicioBean.getCodigo());
			spq.setParameter("p_codusureg", seguimientoAlumnoEjercicioBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", seguimientoAlumnoEjercicioBean.getIpCreacion());
			
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
	public SeguimientoAlumnoEjercicioBean getBuscarPorObjecto(
			SeguimientoAlumnoEjercicioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeguimientoAlumnoEjercicioBean> getBuscarPorFiltros(
			SeguimientoAlumnoEjercicioBean seguimientoAlumnoEjercicioBean) throws DAOException {
		List<LeotbcSeguimientoAlumnoEjer> lstLeotbcSeguimientoAlumnoEjers = null;
		List<SeguimientoAlumnoEjercicioBean> lstSeguimientoAlumnoEjercicioBeans = null;
		
	
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_segaluejercicio.buscarPorFiltros");
			spq.setParameter("p_codusuari", seguimientoAlumnoEjercicioBean.getUsuarioBean().getCodigo());
			if (spq.execute()) {
				lstLeotbcSeguimientoAlumnoEjers = spq.getResultList();
			}
			if (lstLeotbcSeguimientoAlumnoEjers != null && 
					lstLeotbcSeguimientoAlumnoEjers.size() > 0) {
				lstSeguimientoAlumnoEjercicioBeans = deListaSeguimientoAlumnoEjercicioAListaSeguimientoAlumnoEjercicioBean(lstLeotbcSeguimientoAlumnoEjers);
				
			}else {
				System.out.println("Lst vacia.");
			}

		return lstSeguimientoAlumnoEjercicioBeans;
	}
	private List<SeguimientoAlumnoEjercicioBean> deListaSeguimientoAlumnoEjercicioAListaSeguimientoAlumnoEjercicioBean(List<LeotbcSeguimientoAlumnoEjer> lstLeotbcSeguimientoAlumnoEjers){
		List<SeguimientoAlumnoEjercicioBean> lstSeguimientoAlumnoEjercicioBeans = null;
		
		if (lstLeotbcSeguimientoAlumnoEjers != null && 
				lstLeotbcSeguimientoAlumnoEjers.size() > 0) {
			lstSeguimientoAlumnoEjercicioBeans = new ArrayList<SeguimientoAlumnoEjercicioBean>();
			for (int i = 0; i < lstSeguimientoAlumnoEjercicioBeans.size(); i++) {
				LeotbcSeguimientoAlumnoEjer entity = lstLeotbcSeguimientoAlumnoEjers.get(i);
				SeguimientoAlumnoEjercicioBean bean = deSeguimientoAlumnoEjercicioASeguimientoAlumnoEjercicioBean(entity);
				
				lstSeguimientoAlumnoEjercicioBeans.add(bean);
			}
		}
		
		return lstSeguimientoAlumnoEjercicioBeans;
	}
	private SeguimientoAlumnoEjercicioBean deSeguimientoAlumnoEjercicioASeguimientoAlumnoEjercicioBean(LeotbcSeguimientoAlumnoEjer entity){
		SeguimientoAlumnoEjercicioBean bean = null;
		if (entity != null) {
			bean = new SeguimientoAlumnoEjercicioBean();
		}
		return bean;
	}
	
	@Override
	public boolean existe(SeguimientoAlumnoEjercicioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
