package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcUbigeo;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.UbigeoDAO;
@Transactional
@Repository("ubigeoDAO")
public class UbigeoDAOImpl implements UbigeoDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(UbigeoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(UbigeoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(UbigeoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UbigeoBean getBuscarPorObjecto(UbigeoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UbigeoBean> getBuscarPorFiltros(UbigeoBean t)
			throws DAOException {
		List<LeotbcUbigeo> lstUbigeo = null;	
		List<UbigeoBean> lstUbigeoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcUbigeo.buscarXNombreCodigoUbigeo");
			spq.setParameter("p_nomdept", t.getCodigoRegion());  
			spq.setParameter("p_nomprov", t.getCodigoProvincia()); 
			spq.setParameter("p_nomdist", t.getCodigoDistrito());  
			spq.setParameter("p_codubigeo", t.getCodigoUbigeo());  
			if (spq.execute()) {
				lstUbigeo =  spq.getResultList(); 
			} 
			if (lstUbigeo != null && lstUbigeo.size() > 0) {
				
				lstUbigeoBean = deListaUbigeoAListaUbigeoBean(lstUbigeo);
			}
			//em.close();
			
		   
		return lstUbigeoBean;
	}

	@Override
	public boolean existe(UbigeoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UbigeoBean> listarRegion()
			throws pe.gob.procalidad.natigu.base.repository.exception.DAOException {
		List<LeotbcUbigeo> lstUbigeo = null;	
		List<UbigeoBean> lstUbigeoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcUbigeo.listarComboRegion");

			if (spq.execute()) {
				lstUbigeo =  spq.getResultList(); 
			} 
			if (lstUbigeo != null && lstUbigeo.size() > 0) {
				
				lstUbigeoBean = deListaUbigeoAListaUbigeoBean(lstUbigeo);
			}
			//em.close();
			
		   
		return lstUbigeoBean;
	}
	private List<UbigeoBean> deListaUbigeoAListaUbigeoBean(List<LeotbcUbigeo> lstLeotbcUbigeo) {
		
		List<UbigeoBean> lstUbigeoBean= null;
		
		if (lstLeotbcUbigeo != null && lstLeotbcUbigeo.size() > 0) {
			
			lstUbigeoBean = new ArrayList<UbigeoBean>();
			
			for (int i = 0; i < lstLeotbcUbigeo.size(); i++) { 
				LeotbcUbigeo entity = lstLeotbcUbigeo.get(i);
				UbigeoBean bean = deUbigeoAUbigeoBean(entity);
				
				lstUbigeoBean.add(bean);
			}
		}
		
		return lstUbigeoBean;
	}
	private UbigeoBean deUbigeoAUbigeoBean(LeotbcUbigeo entity) {
		
		UbigeoBean bean = null;
		
		if (entity != null) {
			
			bean = new UbigeoBean();
			bean.setCodigo(entity.getnCodubigre());
			bean.setNombreUbigeo(entity.getvNombreubi());
			bean.setCodigoRegion(entity.getvCodregion());
			bean.setCodigoProvincia(entity.getvCodprovin());
			bean.setCodigoDistrito(entity.getvCoddistrito());
			bean.setCodigoUbigeo(entity.getvCodubigeo());
			bean.setCodigoPais(entity.getnCodpais());

		}
		
		return bean;
	}

	@Override
	public List<UbigeoBean> listarProvincia(UbigeoBean ubigeoBean)
			throws pe.gob.procalidad.natigu.base.repository.exception.DAOException {
		List<LeotbcUbigeo> lstUbigeo = null;	
		List<UbigeoBean> lstUbigeoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcUbigeo.listarComboProvincia");
			spq.setParameter("p_codregion",ubigeoBean.getCodigoRegion());  
			if (spq.execute()) {
				lstUbigeo =  spq.getResultList(); 
			} 
			if (lstUbigeo != null && lstUbigeo.size() > 0) {
				
				lstUbigeoBean = deListaUbigeoAListaUbigeoBean(lstUbigeo);
			}
			//em.close();
			
		   
		return lstUbigeoBean;
	}

	@Override
	public List<UbigeoBean> listarDistrito(UbigeoBean ubigeoBean)
			throws pe.gob.procalidad.natigu.base.repository.exception.DAOException {
		List<LeotbcUbigeo> lstUbigeo = null;	
		List<UbigeoBean> lstUbigeoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcUbigeo.listarComboDistrito");
			spq.setParameter("p_codregion", ubigeoBean.getCodigoRegion());  
			spq.setParameter("p_codprovin", ubigeoBean.getCodigoProvincia());  
			if (spq.execute()) {
				lstUbigeo =  spq.getResultList(); 
			} 
			if (lstUbigeo != null && lstUbigeo.size() > 0) {
				
				lstUbigeoBean = deListaUbigeoAListaUbigeoBean(lstUbigeo);
			}
			//em.close();
			
		   
		return lstUbigeoBean;
	}

}
