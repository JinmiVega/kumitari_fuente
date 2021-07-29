package pe.gob.procalidad.natigu.core.repository.repository.implementacion.configuracion;

import java.util.ArrayList;
import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery; 

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.IntentoConfiguracionBean; 
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean; 
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcMascota;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbdIntentoConfig;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.IntentoConfiguracionDAO; 

@Transactional
@Repository("intentoConfiguracionDAO")
public class IntentoConfiguracionDAOImp  implements IntentoConfiguracionDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	public IntentoConfiguracionBean getPremioConfigBean(Object object){
		return (IntentoConfiguracionBean)object;
	}

	@Override
	public boolean insertar(IntentoConfiguracionBean intentoConfigBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(IntentoConfiguracionBean intentoConfigBean) throws DAOException {
    boolean sw =  false;
		
		System.out.println("Ingreso a modificar");
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_intentoconfig.actualizar");
			
			spq.setParameter("p_codconf",intentoConfigBean.getCodigo()); 
			spq.setParameter("p_int1", intentoConfigBean.getIntento1());
			spq.setParameter("p_int2", intentoConfigBean.getIntento2());
			spq.setParameter("p_int3",intentoConfigBean.getIntento3()); 
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
	public boolean eliminar(IntentoConfiguracionBean intentoConfigBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IntentoConfiguracionBean getBuscarPorObjecto(IntentoConfiguracionBean Bean) throws DAOException {
		IntentoConfiguracionBean oBean = null;
		List<LeotbdIntentoConfig> lstLeotbd = null;
		System.out.println(" Bean getBuscarPorObjecto " + Bean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_intentoconfig.buscar_por_codigo");			
			spq.setParameter("p_tm2ejercicio", Bean.getEjercicio().getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbd = spq.getResultList();			
			}
			
			if (	lstLeotbd != null
				&&	lstLeotbd.size() > 0) {
				
				oBean = dePreConfigAIntentoConfiguracionBean(lstLeotbd.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oBean;
	}

	private IntentoConfiguracionBean dePreConfigAIntentoConfiguracionBean(LeotbdIntentoConfig entity) {
		
		IntentoConfiguracionBean bean = null;
		
		if (entity != null) {
			
			bean = new IntentoConfiguracionBean();
//			bean.setEjercicio(new MaestraBean());
			bean.setCodigo(entity.getnCodconf());
			bean.getEjercicio().setCodigoRegistro(entity.getnTm2ejercicio());
			bean.getEjercicio().setNombreLargo(entity.getvNombreEjercicio()); 
			 bean.getEjercicio().setValor1(entity.getvDescripcion()); 
			 
			bean.setIntento1(entity.getiInt1());
			bean.setIntento2(entity.getiInt2()); 
			bean.setIntento3(entity.getiInt3());
			bean.setEstado(entity.getvFlgest());
			bean.setCodigoUsuarioCreacion(entity.getnCodusureg()==null? 0 : entity.getnCodusureg());
			bean.setCodigoUsuarioModificacion(entity.getnCodusumod()==null? 0 : entity.getnCodusumod());
			
		}
		
		return  bean;
	}
	
  private List<IntentoConfiguracionBean> deListaPreConfigAListaIntentoConfiguracionBean(List<LeotbdIntentoConfig> lstLeotbdIntentoConfig) {
		
		List<IntentoConfiguracionBean> lstIntentoConfiguracionBean = null;
		
		if (lstLeotbdIntentoConfig != null && lstLeotbdIntentoConfig.size() > 0) {
			
			lstIntentoConfiguracionBean = new ArrayList<IntentoConfiguracionBean>();
			
			for (int i = 0; i < lstLeotbdIntentoConfig.size(); i++) { 
				LeotbdIntentoConfig entity = lstLeotbdIntentoConfig.get(i);
				IntentoConfiguracionBean bean = dePreConfigAIntentoConfiguracionBean(entity);
				
				lstIntentoConfiguracionBean.add(bean);
			}
		}
		
		return lstIntentoConfiguracionBean;
	}
	


	@Override
	public boolean existe(IntentoConfiguracionBean intentoConfigBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<IntentoConfiguracionBean> listarTodos() throws DAOException {
		List<LeotbdIntentoConfig> lstIntConfig = null;	
		List<IntentoConfiguracionBean> lstintentoConfigBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_intentoconfig.listar");			
			if (spq.execute()) {
				lstIntConfig =  spq.getResultList(); 
			} 
			if (lstIntConfig != null && lstIntConfig.size() > 0) {
				
				lstintentoConfigBean = deListaPreConfigAListaIntentoConfiguracionBean(lstIntConfig);
			}
			//em.close();
		   
		return lstintentoConfigBean;
	}

	@Override
	public List<IntentoConfiguracionBean> getBuscarPorFiltros(IntentoConfiguracionBean t) throws DAOException {
		
		/* public List<IntentoConfiguracionBean> getBuscarPorFiltros(IntentoConfiguracionBean prmPremioConfigBean) throws DAOException {
			System.out.println("em " + em);
			List<LeotbcPreConfig> lstpremioConfig = null;	
			List<IntentoConfiguracionBean> lstintentoConfigBean = null;
			
				StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_preconfig.listar");			 
				lstpremioConfig =  spq.getResultList(); 
				 
				if (lstpremioConfig != null && lstpremioConfig.size() > 0) {
					
					lstintentoConfigBean = deListaPreConfigAListaIntentoConfiguracionBean(lstpremioConfig);
				}
				
			   
			return lstintentoConfigBean; 
			
		} */
		return null;
	}

}
