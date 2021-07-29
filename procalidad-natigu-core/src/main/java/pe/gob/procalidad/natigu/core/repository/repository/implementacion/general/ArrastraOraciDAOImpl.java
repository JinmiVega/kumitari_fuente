package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

 

import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraciBean; 
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcArrastraOraci;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException; 
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.ArrastraOraciDAO;

@Transactional
@Repository("arrastraoraciDAO")
public class ArrastraOraciDAOImpl implements ArrastraOraciDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(ArrastraOraciBean arrastraOraciBean) throws DAOException {
		Object idOracion = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarrastraOraci.insertar");
			spq.setParameter("p_codmatpej", arrastraOraciBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_titulo", arrastraOraciBean.getTitulo());
			spq.setParameter("p_oracion", arrastraOraciBean.getOracion()); 
			spq.setParameter("p_codusureg", arrastraOraciBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", arrastraOraciBean.getIpCreacion()); 
			
			spq.execute();
			
			idOracion = spq.getOutputParameterValue(1);
			if(idOracion != null)
			{
				arrastraOraciBean.setCodigo(Integer.valueOf(idOracion.toString()));
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
	public boolean actualizar(ArrastraOraciBean arrastraOraciBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarrastraOraci.actualizar");
			spq.setParameter("p_codarrastraora", arrastraOraciBean.getCodigo());
			spq.setParameter("p_codmatpej", arrastraOraciBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_titulo", arrastraOraciBean.getTitulo());
			spq.setParameter("p_oracion", arrastraOraciBean.getOracion());   
			spq.setParameter("p_codusumod", arrastraOraciBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", arrastraOraciBean.getIpModificacion()); 
			
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
	public boolean eliminar(ArrastraOraciBean arrastraOraciBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarrastraOraci.eliminar");
			spq.setParameter("p_codarrastraora", arrastraOraciBean.getCodigo());
			spq.setParameter("p_codusumod", arrastraOraciBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", arrastraOraciBean.getIpModificacion()); 
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
	public ArrastraOraciBean getBuscarPorObjecto(ArrastraOraciBean arrastraOraciBean) throws DAOException {
		List<LeotbcArrastraOraci> 	lstOracion 	= null;
		ArrastraOraciBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarrastraOraci.buscar_por_codigo");
		spq.setParameter("p_codarrastraora", 	arrastraOraciBean.getCodigo());
		
		if (spq.execute()) 
		{
			lstOracion =  spq.getResultList(); 
		} 
		if (lstOracion != null && lstOracion.size() > 0) 
		{
			bean = deOracionAOracionBean(lstOracion.get(0));
		}
		return bean;

	}

	@Override
	public ArrastraOraciBean getBuscarPorTEM(ArrastraOraciBean arrastraOraciBean) throws DAOException {
		List<LeotbcArrastraOraci> 	lstOracion 	= null;
		 ArrastraOraciBean  	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarrastraOraci.buscar_por_Matejercicio");
		spq.setParameter("p_codmatpej", 	arrastraOraciBean.getMaterialTipoEjercicioBean().getCodigo());
		 
		
		if (spq.execute()) {
			lstOracion =  spq.getResultList(); 
		} 
		if (lstOracion != null && lstOracion.size() > 0) {			
			bean = deOracionAOracionBean(lstOracion.get(0));
		}
		
		return bean;
	}

	@Override
	public boolean existe(ArrastraOraciBean arrastraOraciBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private List<ArrastraOraciBean> deListaOracionAListaOracionBean(List<LeotbcArrastraOraci> lstOracion) {
		
		List<ArrastraOraciBean> lstOracionBean = null;
	
		if (lstOracion != null && lstOracion.size() > 0) {
			
			lstOracionBean = new ArrayList<ArrastraOraciBean>();
			
			for (int i = 0; i < lstOracion.size(); i++) { 
				LeotbcArrastraOraci entity = lstOracion.get(i);
				ArrastraOraciBean bean = deOracionAOracionBean(entity);
				
				lstOracionBean.add(bean);
			}
		}
		
		return lstOracionBean;
	}
	

	private ArrastraOraciBean deOracionAOracionBean(LeotbcArrastraOraci entity) {
		
		ArrastraOraciBean bean = null;
		
		if (entity != null) {
			bean = new ArrastraOraciBean();
			bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
			bean.setCodigo(entity.getnCodarrastraora());
			bean.getMaterialTipoEjercicioBean().setCodigo(entity.getnCodmatpej());
			bean.setTitulo(entity.getvTitulo());
			bean.setOracion(entity.getvOracion()); 
 
		}
		return bean;
	}

	@Override
	public List<ArrastraOraciBean> getBuscarPorFiltros(ArrastraOraciBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

 
 

 
	 
	
}