package pe.gob.procalidad.natigu.core.repository.repository.implementacion.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.EtiquetaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.TraduccionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbdTraduccion;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.TraduccionDAO;
@Repository("traduccionDAO")
@Transactional(readOnly = true)
public class TraduccionDAOImp implements TraduccionDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(TraduccionBean traduccionBean) throws DAOException {

		System.out.println("traduccionBean DAO "+traduccionBean);
		Object idTraduccion= null; 
		
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_traduccion.insertar");
			
			spq.setParameter("p_codetiqueta",traduccionBean.getEtiqueta().getCodigoEtiqueta());
			spq.setParameter("p_codlengua",traduccionBean.getLengua().getCodigo());
			spq.setParameter("p_traduccion", traduccionBean.getTraduccion());
			spq.setParameter("p_codusureg", traduccionBean.getCodigoUsuarioCreacion());
						
			spq.setParameter("p_hostreg", traduccionBean.getIpCreacion());
			
			
			
			spq.execute();
			
			idTraduccion = spq.getOutputParameterValue(1);
			
			if (idTraduccion != null) {
				
				
				traduccionBean.setCodigoTraduccion(Long.valueOf(idTraduccion.toString()));
				System.out.println("traduccionBean.getCodigo()"+traduccionBean.getCodigo());

				
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
	public boolean actualizar(TraduccionBean traduccionBean) throws DAOException {	
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_traduccion.actualizar");
			spq.setParameter("p_codtraduc",traduccionBean.getCodigoTraduccion());
			spq.setParameter("p_codetiqueta",traduccionBean.getEtiqueta().getCodigoEtiqueta());
			spq.setParameter("p_codlengua",traduccionBean.getLengua().getCodigo());
			spq.setParameter("p_traduccion", traduccionBean.getTraduccion());
			spq.setParameter("p_codusumod", traduccionBean.getCodigoUsuarioModificacion());
						
			spq.setParameter("p_hostmod", traduccionBean.getIpModificacion());
			
			
			spq.execute();
			
			sw = true;

		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(TraduccionBean traduccionBean) throws DAOException {
		boolean sw=false;
//		
//		try {
//			
//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_traduccion.eliminar");
//			spq.setParameter("p_codtraduccion",traduccionBean.getCodigoTraduccion());			
//			spq.setParameter("p_codusumod", traduccionBean.getCodigoUsuarioModificacion());
//			spq.setParameter("p_hostmod", traduccionBean.getIpModificacion());
//			
//			spq.execute();
//			
//			sw = true;
//
//		} catch (Exception e) {
//			sw = false;
//			e.printStackTrace();
//		}finally{
//			em.close();
//		}
		return sw;
	}

	@Override
	public TraduccionBean getBuscarPorObjecto(TraduccionBean traduccionBean) throws DAOException {
		TraduccionBean oTraduccionBean = null;
		List<LeotbdTraduccion> lstLeotbcTraduccion = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_traduccion.listar");			
			spq.setParameter("p_codtraduc",traduccionBean.getCodigoTraduccion());
			spq.setParameter("p_codetiqueta",traduccionBean.getEtiqueta().getCodigoEtiqueta());
			spq.setParameter("p_codlengua", traduccionBean.getLengua()!=null? traduccionBean.getLengua().getCodigo():null); 
			spq.setParameter("p_traduccion", traduccionBean.getTraduccion());
			spq.setParameter("p_tm1tipeti", traduccionBean.getEtiqueta()!=null? traduccionBean.getEtiqueta().getTipoEtiqueta().getCodigoRegistro():0);
			
			if (spq.execute()) {
				lstLeotbcTraduccion = spq.getResultList();			
			}
			
			if (	lstLeotbcTraduccion != null
				&&	lstLeotbcTraduccion.size() > 0) {
				
				oTraduccionBean = deTraduccionATraduccionBean(lstLeotbcTraduccion.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oTraduccionBean;
	}

	@Override
	public List<TraduccionBean> getBuscarPorFiltros(TraduccionBean traduccionBean)
			throws DAOException {
		System.out.println("em " + em);
		List<LeotbdTraduccion> lstLeotbcTraduccion = null;	
		List<TraduccionBean> lstTraduccionBeans = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_traduccion.listar");
			spq.setParameter("p_codtraduc",traduccionBean.getCodigoTraduccion());
			spq.setParameter("p_codetiqueta",traduccionBean.getEtiqueta()!=null? traduccionBean.getEtiqueta().getCodigoEtiqueta():null);
			spq.setParameter("p_codlengua", traduccionBean.getLengua()!=null? traduccionBean.getLengua().getCodigo():null); 
			spq.setParameter("p_traduccion", traduccionBean.getTraduccion());
			spq.setParameter("p_tm1tipeti", traduccionBean.getEtiqueta()!=null? traduccionBean.getEtiqueta().getTipoEtiqueta().getCodigoRegistro():0);
			
			if (spq.execute()) {
				lstLeotbcTraduccion =  spq.getResultList(); 
			} 
			if (lstLeotbcTraduccion != null && lstLeotbcTraduccion.size() > 0) {
				
				lstTraduccionBeans = deListaTraduccionAListaTraduccionBean(lstLeotbcTraduccion);
			}
			//em.close();
		   
		return lstTraduccionBeans;
	}
	private List<TraduccionBean> deListaTraduccionAListaTraduccionBean(List<LeotbdTraduccion> lstLeotbcTraduccion) {
		
		List<TraduccionBean> lstTraduccionBeans = null;
		
		if (lstLeotbcTraduccion != null && lstLeotbcTraduccion.size() > 0) {
			
			lstTraduccionBeans = new ArrayList<TraduccionBean>();
			
			for (int i = 0; i < lstLeotbcTraduccion.size(); i++) { 
				LeotbdTraduccion entity = lstLeotbcTraduccion.get(i);
				TraduccionBean bean = deTraduccionATraduccionBean(entity);
				
				lstTraduccionBeans.add(bean);
			}
		}
		
		return lstTraduccionBeans;
	}
	private TraduccionBean deTraduccionATraduccionBean(LeotbdTraduccion entity) {
		
		TraduccionBean bean = null;
		
		if (entity != null) {
			
			bean = new TraduccionBean();
			bean.setCodigoTraduccion(entity.getNCodtraduc());
			bean.setTraduccion(entity.getVTraduccion());
			bean.setLengua(new LenguaBean());
			bean.getLengua().setCodigo(entity.getNCodlengua()!=null?entity.getNCodlengua():0);
			bean.getLengua().setNombre(entity.getvNomlengua());
			bean.setEtiqueta(new EtiquetaBean());
			bean.getEtiqueta().setCodigoEtiqueta(entity.getnCodetiqueta());
			bean.getEtiqueta().setDescripcion(entity.getvDescripcion());
			bean.getEtiqueta().setTipoEtiqueta(new MaestraBean());
			bean.getEtiqueta().getTipoEtiqueta().setCodigoRegistro(entity.getnTm1tipeti());
			bean.getEtiqueta().getTipoEtiqueta().setNombreCorto(entity.getvNomtipeti());
			bean.getEtiqueta().setUrlImagen(entity.getvUrlimagen());
		}
		
		return bean;
	}
	@Override
	public boolean existe(TraduccionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
