package pe.gob.procalidad.natigu.core.repository.repository.implementacion.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.BonoBean; 
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcBono; 
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.BonoDAO;
@Transactional (readOnly = true)
@Repository("bonoDAO")
public class BonoDAOImpl implements BonoDAO {

	@PersistenceContext
	private EntityManager em; 
	
	public BonoBean getBonoBean(Object object){
		return (BonoBean)object;
	}

	private List<BonoBean> deListaBonoAListaBonoBean(List<LeotbcBono> lstBono) {
		
		List<BonoBean> lstBonoBean = null;
		
		if (lstBono != null && lstBono.size() > 0) {
			
			lstBonoBean = new ArrayList<BonoBean>();
			
			for (int i = 0; i < lstBono.size(); i++) { 
				LeotbcBono entity = lstBono.get(i);
				BonoBean bean = deBonoABonoBean(entity);
				
				lstBonoBean.add(bean);
			}
		}
		
		return lstBonoBean;
	}
	
//		private BonoBean deBonoABean(LeotbcBono entity) {
//		
//			BonoBean bean = null;
//		
//		if (entity != null) {
//			
//			bean = new BonoBean();
//			bean.setEstado(entity.getvFlgest());
//			bean.setCodigo(entity.getnCodbono());  
//			bean.setNombre(entity.getvNombono());
//			bean.setDescripcion(entity.getvDesbono());   
//			bean.getSituacion().setCodigoRegistro(entity.getnTm1sitbono());
// 			bean.getSituacion().setNombreCorto(entity.getV_nomcortoSitu()); 
//			bean.getTipo().setCodigoRegistro(entity.getnTm1tpbono());
// 			bean.getTipo().setNombreCorto(entity.getV_nomcortoTipo());  
//			
//		}
//		
//		return  bean;
//	}
		
	@Override
	public boolean insertar(BonoBean bonoBean) throws DAOException {   
		Object idBono = null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_bono.insertar");
			spq.setParameter("p_nombono", bonoBean.getNombre());
			spq.setParameter("p_desbono", bonoBean.getDescripcion());
			spq.setParameter("p_tm1tpbono", bonoBean.getTipo().getCodigoRegistro());
			spq.setParameter("p_tm1sitbono", bonoBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_hostreg", bonoBean.getIpCreacion()); 
			spq.setParameter("p_codusureg",  bonoBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_tm2tpejer", bonoBean.getTipoEjercicio().getCodigoRegistro());
			spq.setParameter("p_tiempo", bonoBean.getTiempo());
			
			spq.execute();
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			
			idBono = spq.getOutputParameterValue(1);
			if (idBono != null) {
				bonoBean.setCodigo(Integer.valueOf(idBono.toString()));
				if (bonoBean.getCodigo()==0) {
					sw=false;
				}
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
	public boolean actualizar(BonoBean bonoBean) throws DAOException {
		Object idBono= null;
		boolean sw=false;
		System.out.println("Bono actualizar " + bonoBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_bono.actualizar");
			spq.setParameter("p_return",  bonoBean.getRetorno()); 
			spq.setParameter("p_codbono", bonoBean.getCodigo()); 
			spq.setParameter("p_nombono", bonoBean.getNombre());
			spq.setParameter("p_desbono", bonoBean.getDescripcion());
			spq.setParameter("p_tm1sitbono", bonoBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_tiempo", bonoBean.getTiempo());
			spq.setParameter("p_tm2tpejer", bonoBean.getTipoEjercicio().getCodigoRegistro());
			spq.setParameter("p_codusumod",bonoBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", bonoBean.getIpModificacion()); 
		 
			
			spq.execute();   
			sw=true;
			 
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idBono = spq.getOutputParameterValue(1);
			if (idBono != null) {
				bonoBean.setRetorno(Integer.valueOf(idBono.toString()));
				if (bonoBean.getRetorno()==0) {
					sw=false;
				}
			}  
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	
	
 

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<BonoBean> getBuscarPorFiltros(BonoBean bonobean) throws DAOException { 
		System.out.println("em " + em);
		List<LeotbcBono> lstBono = null;	
		List<BonoBean> lstBonoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_bono.listar");
			spq.setParameter("p_nombono", bonobean.getNombre());   
			spq.setParameter("p_tm1tpbono", bonobean.getTipo().getCodigoRegistro()); 
			spq.setParameter("p_tm1sitbono", bonobean.getSituacion().getCodigoRegistro()); 
			
			 
			lstBono =  spq.getResultList(); 
			 
			if (lstBono != null && lstBono.size() > 0) {
				
				lstBonoBean = deListaBonoAListaBonoBean(lstBono);
			}
//			em.close();
			
		   
		return lstBonoBean;
	}
	
	@Override
	public boolean eliminar(BonoBean bonoBean) throws DAOException {
		
		boolean  sw = false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_bono.eliminar");
			spq.setParameter("p_codbono", bonoBean.getCodigo()); 
			spq.setParameter("p_codusumod", bonoBean.getCodigoUsuarioModificacion()); 
			spq.setParameter("p_hostmod", bonoBean.getIpModificacion()); 
			
			spq.execute();
			sw =  true;
			
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public BonoBean getBuscarPorObjecto(BonoBean bonoBean) throws DAOException {
		BonoBean oBonoBean = null;
		List<LeotbcBono> lstBonoBeans = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_bono.buscarPorCodigo");			
			spq.setParameter("p_codbono", bonoBean.getCodigo()); 
			System.out.println("leotbc_bono.buscarPorCodigo:p_codbono " + bonoBean.getCodigo());
			
		
			if (spq.execute()) {
				lstBonoBeans = spq.getResultList();			
			}
			
			if (	lstBonoBeans != null
				&&	lstBonoBeans.size() > 0) {
				
				oBonoBean = deBonoABonoBean(lstBonoBeans.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oBonoBean;
	}

	private BonoBean deBonoABonoBean(LeotbcBono entity) { 
		BonoBean bean = null; 
		if (entity != null) { 
			bean = new BonoBean(); 
			bean.setEstado(entity.getvFlgest());  
			bean.getSituacion().setCodigoRegistro(entity.getnTm1sitbono());
 			bean.getSituacion().setNombreCorto(entity.getV_nomcortoSitu()); 
			bean.getTipo().setCodigoRegistro(entity.getnTm1tpbono());
 			bean.getTipo().setNombreCorto(entity.getV_nomcortoTipo());  
			bean.setCodigo(entity.getnCodbono());
			bean.setTiempo(entity.getvTiempo());
			bean.setNombre(entity.getvNombono());
			bean.setDescripcion(entity.getvDesbono());
			if (entity.getnTm2tpejer() == null) {
				bean.getTipoEjercicio().setCodigoRegistro(0);
			}else{
				bean.getTipoEjercicio().setCodigoRegistro((int) (long)entity.getnTm2tpejer());
			} 
		}
		
		return bean;
	}
//	@Override
//	public List<BonoBean> getBuscarPorFiltros(BonoBean bonoBean) throws DAOException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public boolean existe(BonoBean bonoBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
