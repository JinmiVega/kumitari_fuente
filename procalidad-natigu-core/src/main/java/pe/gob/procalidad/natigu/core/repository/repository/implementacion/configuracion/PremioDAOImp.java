package pe.gob.procalidad.natigu.core.repository.repository.implementacion.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean; 
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcPremio; 
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.PremioDAO; 
 
@Transactional
@Repository("premioDAO")
public class PremioDAOImp implements PremioDAO {
	@PersistenceContext
	private EntityManager em; 
	
	public PremioBean getPremioBean(Object object){
		return (PremioBean)object;
	}

	private List<PremioBean> deListaPremioAListaPremioBean(List<LeotbcPremio> lstPremio) {
		
		List<PremioBean> lstPremioBean = null;
		
		if (lstPremio != null && lstPremio.size() > 0) {
			
			lstPremioBean = new ArrayList<PremioBean>();
			
			for (int i = 0; i < lstPremio.size(); i++) { 
				LeotbcPremio entity = lstPremio.get(i);
				PremioBean bean = deInscripcionAInscripcionBean(entity);
				
				lstPremioBean.add(bean);
			}
		}
		
		return lstPremioBean;
	}
	
		private PremioBean deInscripcionAInscripcionBean(LeotbcPremio entity) {
		
		 PremioBean bean = null;
		
		if (entity != null) {
			
			bean = new PremioBean();
			bean.setEstado(entity.getvFlgest());
			bean.setCodigo(entity.getnCodpremio()); 
			bean.setImagenNombre(entity.getvNomimag());
			bean.setNombre(entity.getvNompremio());
			bean.setDescripcion(entity.getvDespremio());
			bean.getRegion().setCodigoRegistro(entity.getnCodregion());
			bean.setPuntos(entity.getiPuntos());
			bean.getRegion().setNombreCorto(entity.getV_nomcortoRegion()); 
			bean.getSituacion().setCodigoRegistro(entity.getnTm1sitpre());
			bean.getSituacion().setNombreCorto(entity.getV_nomcortoSituacion()); 
			bean.getTipo().setCodigoRegistro(entity.getnTm1tpprem());
			bean.getTipo().setNombreCorto(entity.getV_nomcortoTipo());  
			
		}
		
		return  bean;
	}
	
		
		
	@Override
	public boolean insertar(PremioBean premioBean) throws DAOException {   
		Object idPremio= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcPremio.insertar");
			spq.setParameter("p_nompremio", premioBean.getNombre());
			spq.setParameter("p_despremio", premioBean.getDescripcion());
			spq.setParameter("p_codregion", premioBean.getRegion().getCodigoRegistro());
			spq.setParameter("p_puntos", premioBean.getPuntos());
			spq.setParameter("p_tm1sitpre", premioBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_tm1tpprem", premioBean.getTipo().getCodigoRegistro());
			spq.setParameter("p_hostreg", "");
			spq.setParameter("p_codusureg", "1"); 
			spq.setParameter("p_nomimag", premioBean.getImagenNombre());
			
			spq.execute();
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			
			idPremio = spq.getOutputParameterValue(1);
			if (idPremio != null) {
				premioBean.setCodigo(Integer.valueOf(idPremio.toString()));
				if (premioBean.getCodigo()==0) {
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


//	@Override
//	public boolean actualizar(LenguaBean lenguaBean) throws DAOException {
//		boolean sw=false;
//		try {
//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.actualizar");
//			spq.setParameter("p_nomlengua", lenguaBean.getNombre());
//			spq.setParameter("p_tm1sitlen", lenguaBean.getSituacion().getCodigoRegistro());
//			spq.setParameter("p_codusumod", 1);
//			spq.setParameter("p_hostmod", ""); 
//			
//			spq.execute();   
//			sw=true;
//			 
//		} catch (Exception e) {
//			e.printStackTrace();
//			sw=false; 
//		}finally{
//			em.close();
//		}
//		return sw;
//	}


	@Override
	public boolean eliminar(PremioBean premioBean) throws DAOException { 
		Object idPremio= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcPremio.eliminar");
			spq.setParameter("p_codpremio", premioBean.getCodigo()); 
			spq.setParameter("p_codusumod", 12);
			spq.setParameter("p_hostmod", "");
			spq.execute();   
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idPremio = spq.getOutputParameterValue(1);
			if (idPremio != null) {
				premioBean.setRetorno(Integer.valueOf(idPremio.toString()));
				if (premioBean.getRetorno()==0) {
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


//	@SuppressWarnings("unchecked")
//	@Override
//	public PremioBean getBuscarPorObjecto(PremioBean premioBean) throws DAOException {
//		PremioBean oLenguaBean = null;
//		List<LeotbcPremio> lstLeotbcPremio = null;
//		try {
//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.buscar_por_codigo");
//			
//			spq.setParameter("p_codlengua", premioBean.getCodigo()); 
//			
//		
//			if (spq.execute()) {
//				lstLeotbcLengua = spq.getResultList();			
//			}
//			
//			if (	lstLeotbcLengua != null
//				&&	lstLeotbcLengua.size() > 0) {
//				
//				oLenguaBean = deLenguaALenguaBean(lstLeotbcLengua.get(0));
//			} 
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new DAOException(e);
//		}finally{
//			em.close();
//		}
//		return oLenguaBean;
//	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<PremioBean> getBuscarPorFiltros(PremioBean premiobean) throws DAOException { 
		System.out.println("em " + em);
		List<LeotbcPremio> lstPremio = null;	
		List<PremioBean> lstPremioBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_premio.listar");
			spq.setParameter("p_nompremio", premiobean.getNombre());  
			spq.setParameter("p_codregion", premiobean.getRegion().getCodigoRegistro()); 
			spq.setParameter("p_tm1tpprem", premiobean.getTipo().getCodigoRegistro()); 
			spq.setParameter("p_tm1sitpre", premiobean.getSituacion().getCodigoRegistro()); 
			
			 
				lstPremio =  spq.getResultList(); 
			 
			if (lstPremio != null && lstPremio.size() > 0) {
				
				lstPremioBean = deListaPremioAListaPremioBean(lstPremio);
			}
//			em.close();
			
		   
		return lstPremioBean;
	}


	@Override
	public boolean existe(PremioBean t) throws DAOException { 
		return false;
	}
	 

 



	@Override
	public boolean actualizar(PremioBean premioBean) throws DAOException {
		Object idPremio= null;
		boolean sw=false;
		System.out.println("premioBean actualizar " + premioBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcPremio.actualizar");
			spq.setParameter("p_return",  premioBean.getRetorno()); 
			spq.setParameter("p_codpremio", premioBean.getCodigo()); 
			spq.setParameter("p_nompremio", premioBean.getNombre());
			spq.setParameter("p_despremio", premioBean.getDescripcion());
			spq.setParameter("p_tm1sitpre", premioBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_codregion", premioBean.getRegion().getCodigoRegistro());
			spq.setParameter("p_puntos", premioBean.getPuntos());
			spq.setParameter("p_tm1tpprem", premioBean.getTipo().getCodigoRegistro());
			spq.setParameter("p_codusumod", 12);
			spq.setParameter("p_hostmod", ""); 
			spq.setParameter("p_nomimag", premioBean.getImagenNombre());
			
			spq.execute();   
			sw=true;
			 
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idPremio = spq.getOutputParameterValue(1);
			if (idPremio != null) {
				premioBean.setRetorno(Integer.valueOf(idPremio.toString()));
				if (premioBean.getRetorno()==0) {
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

	 


	@SuppressWarnings("unchecked")
	@Override
	public PremioBean getBuscarPorObjecto(PremioBean premioBean) throws DAOException {
		PremioBean oPremioBean = null;
		List<LeotbcPremio> lstLeotbcPremio = null;
		System.out.println("premioBean getBuscarPorObjecto " + premioBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcPremio.buscar_por_codigo");			
			spq.setParameter("p_codpremio", premioBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcPremio = spq.getResultList();			
			}
			
			if (	lstLeotbcPremio != null
				&&	lstLeotbcPremio.size() > 0) {
				
				oPremioBean = deInscripcionAInscripcionBean(lstLeotbcPremio.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oPremioBean;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public PremioBean getBuscarPorAluMedalla(PremioBean premioBean) throws DAOException {
		PremioBean oPremioBean = null;
		List<LeotbcPremio> lstLeotbcPremio = null; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcPremio.buscar_por_alumnoxmedalla");			
			spq.setParameter("p_codaluxmeda", premioBean.getAlumnoMedallaBean().getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcPremio = spq.getResultList();			
			}
			
			if (	lstLeotbcPremio != null
				&&	lstLeotbcPremio.size() > 0) {
				
				oPremioBean = deInscripcionAInscripcionBean(lstLeotbcPremio.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oPremioBean;
	}
	


}
