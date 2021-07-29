package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.CrucigramaBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcCrucigrama;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.CrucigramaDAO;

@Transactional
@Repository("crucigramaDAO")
public class CrucigramaDAOImpl implements CrucigramaDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(CrucigramaBean crucigramaBean) throws DAOException {
		Object idCrucigrama = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbccrucigrama.insertar");
//			spq.setParameter("p_codejercicio", crucigramaBean.getEjercicioBean().getCodigo());
			spq.setParameter("p_palabra", crucigramaBean.getPalabra());
			spq.setParameter("p_definicion", crucigramaBean.getDefinicion());
			spq.setParameter("p_orientacion", crucigramaBean.getOrientacion());
			spq.setParameter("p_orden", crucigramaBean.getOrden());
//			spq.setParameter("p_codusureg", crucigramaBean.getAudCodigoUsuario());
//			spq.setParameter("p_hostreg", crucigramaBean.getAudHostIP()); 
			
			spq.execute();
			
			idCrucigrama = spq.getOutputParameterValue(1);
			if(idCrucigrama != null)
			{
				crucigramaBean.setCodigo(Integer.valueOf(idCrucigrama.toString()));
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
	public boolean actualizar(CrucigramaBean crucigramaBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbccrucigrama.actualizar");
			spq.setParameter("p_codcrucigrama", crucigramaBean.getCodigo());
			spq.setParameter("p_palabra", crucigramaBean.getPalabra());
			spq.setParameter("p_definicion", crucigramaBean.getDefinicion());
			spq.setParameter("p_orientacion", crucigramaBean.getOrientacion());
			spq.setParameter("p_orden", crucigramaBean.getOrden());
//			spq.setParameter("p_codusumod", crucigramaBean.getAudCodigoUsuario());
//			spq.setParameter("p_hostmod", crucigramaBean.getAudHostIP()); 
			
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
	public boolean eliminar(CrucigramaBean crucigramaBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbccrucigrama.eliminar");
			spq.setParameter("p_codrelacion", crucigramaBean.getCodigo());
//			spq.setParameter("p_codusumod", crucigramaBean.getAudCodigoUsuario());
//			spq.setParameter("p_hostmod", crucigramaBean.getAudHostIP());
			spq.execute();
			sw = true;
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public CrucigramaBean getBuscarPorObjecto(CrucigramaBean crucigramaBean) throws DAOException {
		List<LeotbcCrucigrama> 	lstCrucigrama 	= null;
		CrucigramaBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbccrucigrama.buscar_por_codigo");
		spq.setParameter("p_codcrucigrama", 	crucigramaBean.getCodigo());
		
		if (spq.execute()) 
		{
			lstCrucigrama =  spq.getResultList(); 
		} 
		if (lstCrucigrama != null && lstCrucigrama.size() > 0) 
		{
			bean = deCrucigramaACrucigramaBean(lstCrucigrama.get(0));
		}
		return bean;

	}

	@Override
	public List<CrucigramaBean> getBuscarPorFiltros(CrucigramaBean crucigramaBean) throws DAOException {
		List<LeotbcCrucigrama> 	lstCrucigrama 	= null;
		List<CrucigramaBean> 	lstCrucigramaBean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbccrucigrama.buscar_por_filtro");
//		spq.setParameter("p_codejercicio", 	crucigramaBean.getEjercicioBean().getCodigo());
		spq.setParameter("p_palabra", 	crucigramaBean.getPalabra());
		spq.setParameter("p_definicion", 	crucigramaBean.getPalabra());
		spq.setParameter("p_orientacion", 	crucigramaBean.getOrientacion());
		spq.setParameter("p_orden", 	crucigramaBean.getOrden());
		
		if (spq.execute()) {
			lstCrucigrama =  spq.getResultList(); 
		} 
		if (lstCrucigrama != null && lstCrucigrama.size() > 0) {			
			lstCrucigramaBean = deListaCrucigramaAListaCrucigramaBean(lstCrucigrama);
		}
		
		return lstCrucigramaBean;
	}

	@Override
	public boolean existe(CrucigramaBean crucigramaBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private List<CrucigramaBean> deListaCrucigramaAListaCrucigramaBean(List<LeotbcCrucigrama> lstCrucigrama) {
		
		List<CrucigramaBean> lstCrucigramaBean = null;
	
		if (lstCrucigrama != null && lstCrucigrama.size() > 0) {
			
			lstCrucigramaBean = new ArrayList<CrucigramaBean>();
			
			for (int i = 0; i < lstCrucigrama.size(); i++) { 
				LeotbcCrucigrama entity = lstCrucigrama.get(i);
				CrucigramaBean bean = deCrucigramaACrucigramaBean(entity);
				
				lstCrucigramaBean.add(bean);
			}
		}
		
		return lstCrucigramaBean;
	}
	

	private CrucigramaBean deCrucigramaACrucigramaBean(LeotbcCrucigrama entity) {
		
		CrucigramaBean bean = null;
		
		if (entity != null) {
			bean = new CrucigramaBean();
			bean.setCodigo(entity.getNCodcrucigrama());
//			bean.getEjercicioBean().setCodigo(entity.getNCodejercicio());
			bean.setPalabra(entity.getVPalabra());
			bean.setDefinicion(entity.getVDefinicion());
			bean.setOrientacion(entity.getNOrientacion());
			bean.setOrden(entity.getNOrden());
		}
		return bean;
	}
	
}