package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Store;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSInput;

import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionDetalleBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcEvaluacion;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbdEvaluacionDetalle;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.EvaluacionDetalleDAO;
@Transactional(readOnly = true)
@Repository("evaluacionDetalleDAO")
public class EvaluacionDetalleDAOImp implements EvaluacionDetalleDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(EvaluacionDetalleBean evaluacionDetalleBean) throws DAOException {

		Object idEvaluacionDetalle = null; 
		
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_evaldetalle.insertarEjercicioAdional");
			
			spq.setParameter("p_codlengua",evaluacionDetalleBean.getLeccionMaterialBean().getUnidadLeccionBean().getLenguaLeccionBean().getLenguaBean().getCodigo());
			spq.setParameter("p_tm2subnivel",(long) evaluacionDetalleBean.getEvaluacionBean().getSubNivel().getCodigoRegistro());
			spq.setParameter("p_codevalua", evaluacionDetalleBean.getEvaluacionBean().getCodigo());
			spq.setParameter("p_tm2tpejer", (long) evaluacionDetalleBean.getTipoEjercicio().getCodigoRegistro()); 
			spq.setParameter("p_codusureg", evaluacionDetalleBean.getCodigoUsuarioCreacion());						
			spq.setParameter("p_hostreg", evaluacionDetalleBean.getIpCreacion());
			

			
			spq.execute();
			
			idEvaluacionDetalle = spq.getOutputParameterValue(1);
			
			if (idEvaluacionDetalle != null) {
				System.out.println("Ingreso a Insertar evaluacion");
				
				evaluacionDetalleBean.setCodigo(Long.valueOf(idEvaluacionDetalle.toString()));
				System.out.println("evaluacionDetalleBean.setCodigo()"+evaluacionDetalleBean.getCodigo());
				
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
	public boolean actualizar(EvaluacionDetalleBean evaluacionDetalleBean) throws DAOException {
	boolean sw =  false;
		
		System.out.println("Ingreso a modificar");
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_evaldetalle.actulizar");
			
			spq.setParameter("p_codevaldet", evaluacionDetalleBean.getCodigo());
			spq.setParameter("p_swaprobad", evaluacionDetalleBean.getAprobado());
			spq.setParameter("p_tm1sitevdt", evaluacionDetalleBean.getSituacionEvaluacionDetalle().getCodigoRegistro());

			spq.setParameter("p_codusumod", evaluacionDetalleBean.getCodigoUsuarioModificacion());						
			spq.setParameter("p_hostmod", evaluacionDetalleBean.getIpModificacion());
			
			spq.execute();
			sw =  true;
				
		} catch (Exception e) {
			
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return sw;
	}

	@Override
	public boolean eliminar(EvaluacionDetalleBean evaluacionDetalleBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EvaluacionDetalleBean getBuscarPorObjecto(EvaluacionDetalleBean evaluacionDetalleBean)
			throws DAOException {
		EvaluacionDetalleBean oEvaluacionDetalleBean = null;
		List<LeotbdEvaluacionDetalle> lstLeotbdEvaluacionDetalle = null;

		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_evaldetalle.buscarPorCodigo");			
			spq.setParameter("p_codevaldet", evaluacionDetalleBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbdEvaluacionDetalle = spq.getResultList();			
			}
			
			if (	lstLeotbdEvaluacionDetalle != null
				&&	lstLeotbdEvaluacionDetalle.size() > 0) {
				oEvaluacionDetalleBean = deEvaluacionDetalleAEvaluacionDetalleBean(lstLeotbdEvaluacionDetalle.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oEvaluacionDetalleBean;
	
	}

	@Override
	public List<EvaluacionDetalleBean> getBuscarPorFiltros(
			EvaluacionDetalleBean evaluacionDetalleBean) throws DAOException {
		List<LeotbdEvaluacionDetalle> lstLeotbdEvaluacionDetalle = null;
		List<EvaluacionDetalleBean> lstEvaluacionDetalleBeans = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_evaldetalle.buscarPorFiltros");
			spq.setParameter("p_codevalua", evaluacionDetalleBean.getEvaluacionBean().getCodigo());
			
			if (spq.execute()) {
				lstLeotbdEvaluacionDetalle = spq.getResultList();
			
				if (lstLeotbdEvaluacionDetalle != null && 
						lstLeotbdEvaluacionDetalle.size() > 0) {
					System.out.println("tamanio de  la  lista :"+ lstLeotbdEvaluacionDetalle.size());
					lstEvaluacionDetalleBeans = deListaEvaluacionDetalleAListaEvaluacionDetalleBean(lstLeotbdEvaluacionDetalle);
				}else{
					System.out.println("lst vacia");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstEvaluacionDetalleBeans;
	}

	private List<EvaluacionDetalleBean> deListaEvaluacionDetalleAListaEvaluacionDetalleBean(List<LeotbdEvaluacionDetalle> lstEvaluacionDetalles){
		List<EvaluacionDetalleBean> lstEvaluacionDetalleBeans = null;
		
		if (lstEvaluacionDetalles != null && 
				lstEvaluacionDetalles.size() > 0) {
			
			lstEvaluacionDetalleBeans = new ArrayList<EvaluacionDetalleBean>();
					
			for (int i = 0; i < lstEvaluacionDetalles.size(); i++) {
				LeotbdEvaluacionDetalle entity = lstEvaluacionDetalles.get(i);
				EvaluacionDetalleBean bean = deEvaluacionDetalleAEvaluacionDetalleBean(entity);
				
				lstEvaluacionDetalleBeans.add(bean);
			}
			
		}
		
		return lstEvaluacionDetalleBeans;
	}
	private EvaluacionDetalleBean deEvaluacionDetalleAEvaluacionDetalleBean(LeotbdEvaluacionDetalle entity){
		
		EvaluacionDetalleBean bean = null;
		
		if (entity != null) {
			bean = new EvaluacionDetalleBean();
			bean.setCodigo(entity.getnCodevaldet());
			bean.getEvaluacionBean().setCodigo(entity.getnCodevalua());
			bean.getMaterialTipoEjercicioBean().setCodigo(entity.getnCodmatpej());
			bean.getMaterialTipoEjercicioBean().getTipoEjercicio().setCodigoRegistro((int)(long)(entity.getnTm2tpejer()));
			if (entity.getnTm2nivel() == null) {
				bean.getEvaluacionBean().getUsuarioMatriculaBean().getMatriculaBean().getNivel().setCodigoRegistro(0);
			}else{
				bean.getEvaluacionBean().getUsuarioMatriculaBean().getMatriculaBean().getNivel().setCodigoRegistro(Integer.valueOf(entity.getnTm2nivel().toString()));
			}
			
			
		}
		return bean;
	}
	@Override
	public boolean existe(EvaluacionDetalleBean evaluacionDetalleBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EvaluacionDetalleBean getBuscarPorEjercicioEvaluacion(EvaluacionDetalleBean evaluacionDetalleBean) throws DAOException {
		System.out.println("getBuscarPorEjercicioEvaluacion" + evaluacionDetalleBean);
		EvaluacionDetalleBean oEvaluacionDetalleBean = null;
		List<LeotbdEvaluacionDetalle> lstLeotbdEvaluacionDetalle = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_evaldetalle.evaluacionPorEjercicio");
			spq.setParameter("p_codevalua", evaluacionDetalleBean.getEvaluacionBean().getCodigo());
			spq.setParameter("p_tm2tpejer", evaluacionDetalleBean.getTipoEjercicio().getCodigoRegistro());
			if (spq.execute()) {
				lstLeotbdEvaluacionDetalle = spq.getResultList();
			}
			if (lstLeotbdEvaluacionDetalle != null && lstLeotbdEvaluacionDetalle.size()>0) {
				System.out.println("lstLeotbdEvaluacionDetalle.size() " + lstLeotbdEvaluacionDetalle.size());
				oEvaluacionDetalleBean = deEvaluacionDetalleAEvaluacionDetalleBean(lstLeotbdEvaluacionDetalle.get(0));
			}else{
				System.out.println("lista lstLeotbdEvaluacionDetalle  es null ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oEvaluacionDetalleBean;
	}

}
