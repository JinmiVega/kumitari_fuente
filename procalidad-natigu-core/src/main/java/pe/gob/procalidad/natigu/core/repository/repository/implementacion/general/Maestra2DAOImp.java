package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;  
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean; 
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcMaestra2;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException; 
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.Maestra2DAO;
 
@Transactional
@Repository("maestra2DAO")
public class Maestra2DAOImp implements Maestra2DAO {
	
	
	@PersistenceContext
	private EntityManager em; 
	
	public MaestraBean getMaestraBean(Object object){
		return (MaestraBean)object;
	}


	
	@Override
	public boolean insertar(MaestraBean lenguaBean) throws DAOException {   
		Object idLengua= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra2.insertar"); 
			spq.setParameter("p_codusureg", 1);
			spq.setParameter("p_hostreg", ""); 
			
			spq.execute();
			
			idLengua = spq.getOutputParameterValue(1);
			if (idLengua != null) {
				lenguaBean.setId(Integer.valueOf(idLengua.toString()));
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
	public boolean actualizar(MaestraBean lenguaBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra2.actualizar"); 
			spq.setParameter("p_codusumod", 1);
			spq.setParameter("p_hostmod", ""); 
			
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
	public boolean eliminar(MaestraBean lenguaBean) throws DAOException { 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra2.insertar");
			spq.setParameter("p_codlengua", lenguaBean.getId()); 
			
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


	@SuppressWarnings("unchecked")
	@Override
	public MaestraBean getBuscarPorObjecto(MaestraBean maestraBean) throws DAOException {
		MaestraBean oMaestraBean = null;
		List<LeotbcMaestra2> lstMaestra = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra2.buscar_por_codigo");
			
			spq.setParameter("p_codlengua", maestraBean.getId()); 
			
		
			if (spq.execute()) {
				lstMaestra = spq.getResultList();			
			}
			
			if (	lstMaestra != null
				&&	lstMaestra.size() > 0) {
				
				oMaestraBean = deMaestraAMaestraBean(lstMaestra.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oMaestraBean;
	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<MaestraBean> getBuscarPorFiltros(MaestraBean maestraBean) throws DAOException { 
		List<LeotbcMaestra2> lstMaestra = null;	
		List<MaestraBean> lstMaestraBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra2.buscar_por_filtros");
			spq.setParameter("p_codtabla", maestraBean.getCodigoTabla()); 
			if (spq.execute()) {
				lstMaestra =  spq.getResultList(); 
			} 
			if (lstMaestra != null && lstMaestra.size() > 0) {
				
				lstMaestraBean = deListaMaestra1AListaMaestraBean(lstMaestra);
			}
			em.close();
			
		   
		return lstMaestraBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MaestraBean> listarPorCodigoTabla(String codTabla,long tipo) throws DAOException {
		List<LeotbcMaestra2> lstMaestra = null;	
		List<MaestraBean> lstMaestraBean = null;
			System.out.println("---- listado por codigo tabla maestra 2 ----");
			System.out.println("codTabla :"+ codTabla);
			System.out.println("tipo :"+ tipo);
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra2.listarPorCodigoTabla");
			spq.setParameter("p_codtabla", codTabla);
			spq.setParameter("p_tipo", tipo); 
			if (spq.execute()) {
				lstMaestra =  spq.getResultList(); 
			} 
			if (lstMaestra != null && lstMaestra.size() > 0) {
				
				lstMaestraBean = deListaMaestra1AListaMaestraBean(lstMaestra);
			}
			em.close();
			
		   System.out.println("lstMaestraBean " + lstMaestraBean);
		return lstMaestraBean;
	}
	
	@Override
	public boolean existe(MaestraBean t) throws DAOException { 
		return false;
	}
	
	private List<MaestraBean> deListaMaestra1AListaMaestraBean(List<LeotbcMaestra2> lstHorarioExcepcion) {
		
		List<MaestraBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<MaestraBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				LeotbcMaestra2 entity = lstHorarioExcepcion.get(i);
				MaestraBean bean = deMaestraAMaestraBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private MaestraBean deMaestraAMaestraBean(LeotbcMaestra2 entity) {
		
		MaestraBean bean = null;
		
		if (entity != null) {
			
			bean = new MaestraBean();
			
			bean.setCodigoRegistro(entity.getNCodregis().intValue()); 
			bean.setId(entity.getNCodmae()); 
			bean.setNombreCorto(entity.getVNomcorto()); 
			bean.setNombreLargo(entity.getVNomlargo()); 
			bean.setValor1(entity.getVValor1()); 
			bean.setValor2(entity.getVValor2()); 
			bean.setValor3(entity.getVValor3());  
			bean.setOrden(entity.getNOrden());
		}
		
		return bean;
	}



	@Override
	public List<MaestraBean> listarPorValor1(MaestraBean maestraBean) throws DAOException {
		List<LeotbcMaestra2> lstMaestra = null;	
		List<MaestraBean> lstMaestraBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra2.listarPorValor1");
			spq.setParameter("p_codtabla", maestraBean.getCodigoTabla()); 
			spq.setParameter("p_valor1", maestraBean.getValor1()); 
			if (spq.execute()) {
				lstMaestra =  spq.getResultList(); 
			} 
			if (lstMaestra != null && lstMaestra.size() > 0) {
				
				lstMaestraBean = deListaMaestra1AListaMaestraBean(lstMaestra);
			}
			em.close();
			
		   System.out.println("lstMaestraBean " + lstMaestraBean);
		return lstMaestraBean;
	}


}
