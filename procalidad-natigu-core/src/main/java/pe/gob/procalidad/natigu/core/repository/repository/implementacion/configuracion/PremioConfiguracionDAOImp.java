package pe.gob.procalidad.natigu.core.repository.repository.implementacion.configuracion;

import java.util.ArrayList;
import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery; 

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioConfiguracionBean; 
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcPreConfig; 
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcPremio;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.PremioConfiguracionDAO;

@Transactional
@Repository("premioConfiguracionDAO")
public class PremioConfiguracionDAOImp  implements PremioConfiguracionDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	public PremioConfiguracionBean getPremioConfigBean(Object object){
		return (PremioConfiguracionBean)object;
	}

	@Override
	public boolean insertar(PremioConfiguracionBean premioConfigBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(PremioConfiguracionBean premioConfigBean) throws DAOException {
    boolean sw =  false;
		
		System.out.println("Ingreso a modificar");
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_preconfig.actualizar");
			
			spq.setParameter("p_codconfp",premioConfigBean.getCodigo()); 
			spq.setParameter("p_flgbas", premioConfigBean.getFlagBasico());
			spq.setParameter("p_flghom", premioConfigBean.getFlagHonorifico());
			spq.setParameter("p_flgprem",premioConfigBean.getFlagPremium());
			spq.setParameter("p_cntmone", premioConfigBean.getMonedas()); 	
			spq.setParameter("p_cntgema", premioConfigBean.getGemas());
			spq.setParameter("p_codusumod", 1);	
			spq.setParameter("p_hostmod", "");
			
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
	public boolean eliminar(PremioConfiguracionBean premioConfigBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PremioConfiguracionBean getBuscarPorObjecto(PremioConfiguracionBean premioBean) throws DAOException {
		PremioConfiguracionBean oPremioBean = null;
		List<LeotbcPreConfig> lstLeotbcPremio = null; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_preconfig.buscar_por_categoria");			
			spq.setParameter("p_tm2categ", premioBean.getCategoria().getCodigoRegistro()); 
			
		
			if (spq.execute()) {
				lstLeotbcPremio = spq.getResultList();			
			}
			
			if (	lstLeotbcPremio != null
				&&	lstLeotbcPremio.size() > 0) {
				
				oPremioBean = dePreConfigAPremioConfiguracionBean(lstLeotbcPremio.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oPremioBean;
	}

	private PremioConfiguracionBean dePreConfigAPremioConfiguracionBean(LeotbcPreConfig entity) {
		
		PremioConfiguracionBean bean = null;
		
		if (entity != null) {
			
			bean = new PremioConfiguracionBean();
			bean.setCodigo(entity.getnCodconfp());
			bean.getCategoria().setCodigoRegistro(entity.getnTm2categ());
			bean.getCategoria().setNombreCorto(entity.getvNombreCategoria());
			bean.getSituacion().setCodigoRegistro(entity.getnTm1sitcfg());
			bean.setFlagBasico(entity.getvFlgbas());
			bean.setFlagHonorifico(entity.getvFlghon());
			bean.setFlagPremium(entity.getvFlgprem());
			bean.setMonedas(entity.getiCntmone());
			bean.setGemas(entity.getiCntgema()); 
			bean.setEstado(entity.getvFlgest());
			bean.setCodigoUsuarioCreacion(entity.getnCodusureg()==null? 0 : entity.getnCodusureg());
			bean.setCodigoUsuarioModificacion(entity.getnCodusumod()==null? 0 : entity.getnCodusumod());
			
		}
		
		return  bean;
	}
	
  private List<PremioConfiguracionBean> deListaPreConfigAListaPremioConfiguracionBean(List<LeotbcPreConfig> lstLeotbcPreConfig) {
		
		List<PremioConfiguracionBean> lstPremioConfiguracionBean = null;
		
		if (lstLeotbcPreConfig != null && lstLeotbcPreConfig.size() > 0) {
			
			lstPremioConfiguracionBean = new ArrayList<PremioConfiguracionBean>();
			
			for (int i = 0; i < lstLeotbcPreConfig.size(); i++) { 
				LeotbcPreConfig entity = lstLeotbcPreConfig.get(i);
				PremioConfiguracionBean bean = dePreConfigAPremioConfiguracionBean(entity);
				
				lstPremioConfiguracionBean.add(bean);
			}
		}
		
		return lstPremioConfiguracionBean;
	}
	


	@Override
	public boolean existe(PremioConfiguracionBean premioConfigBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PremioConfiguracionBean> listarTodos() throws DAOException {
		List<LeotbcPreConfig> lstpremioConfig = null;	
		List<PremioConfiguracionBean> lstpremioConfigBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_preconfig.listar");			
			if (spq.execute()) {
				lstpremioConfig =  spq.getResultList(); 
			} 
			if (lstpremioConfig != null && lstpremioConfig.size() > 0) {
				
				lstpremioConfigBean = deListaPreConfigAListaPremioConfiguracionBean(lstpremioConfig);
			}
			//em.close();
		   
		return lstpremioConfigBean;
	}

	@Override
	public List<PremioConfiguracionBean> getBuscarPorFiltros(PremioConfiguracionBean t) throws DAOException {
		
		/* public List<PremioConfiguracionBean> getBuscarPorFiltros(PremioConfiguracionBean prmPremioConfigBean) throws DAOException {
			System.out.println("em " + em);
			List<LeotbcPreConfig> lstpremioConfig = null;	
			List<PremioConfiguracionBean> lstpremioConfigBean = null;
			
				StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_preconfig.listar");			 
				lstpremioConfig =  spq.getResultList(); 
				 
				if (lstpremioConfig != null && lstpremioConfig.size() > 0) {
					
					lstpremioConfigBean = deListaPreConfigAListaPremioConfiguracionBean(lstpremioConfig);
				}
				
			   
			return lstpremioConfigBean; 
			
		} */
		return null;
	}

}
