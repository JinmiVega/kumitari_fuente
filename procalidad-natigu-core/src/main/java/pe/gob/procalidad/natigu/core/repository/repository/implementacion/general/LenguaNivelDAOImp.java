package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaNivelBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLenguaEstruc;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLenguaNivel;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdLeUndLeccion;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.LenguaNivelDAO;
 
@Transactional
@Repository("lenguaNivelDAO")
public class LenguaNivelDAOImp implements LenguaNivelDAO {
	
	
	@PersistenceContext
	private EntityManager em; 
	 
	
	@Override
	public boolean insertar(LenguaNivelBean LenguaNivelBean) throws DAOException {   
		Object idLengua= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaNivel.insertar"); 
			spq.setParameter("p_codlengua", LenguaNivelBean.getLenguaBean().getCodigo());
			spq.setParameter("p_tm2nivel", LenguaNivelBean.getNivel().getCodigoRegistro());
			spq.setParameter("p_nombnivel", LenguaNivelBean.getNombreNivel()); 
			spq.setParameter("p_nombimag", LenguaNivelBean.getNombreImagen()); 
			spq.setParameter("p_tm1sitleniv", LenguaNivelBean.getSituacion().getCodigoRegistro()); 
			spq.setParameter("p_codusureg", LenguaNivelBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", LenguaNivelBean.getIpCreacion());  
			spq.execute();
			sw=true;
			idLengua = spq.getOutputParameterValue(1);
			if (idLengua != null) {
				LenguaNivelBean.setCodigo(Integer.valueOf(idLengua.toString()));
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
	public boolean actualizar(LenguaNivelBean LenguaNivelBean) throws DAOException {
		boolean sw=false;
		System.out.println("LenguaNivelBean actualizar " + LenguaNivelBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaNivel.actualizar");
			spq.setParameter("p_codlenniv", LenguaNivelBean.getCodigo());
			spq.setParameter("p_codlengua", LenguaNivelBean.getLenguaBean().getCodigo());
			spq.setParameter("p_tm2nivel", LenguaNivelBean.getNivel().getCodigoRegistro());
			spq.setParameter("p_nombnivel", LenguaNivelBean.getNombreNivel()); 
			spq.setParameter("p_nombimag", LenguaNivelBean.getNombreImagen()); 
			spq.setParameter("p_tm1sitleniv", LenguaNivelBean.getSituacion().getCodigoRegistro()); 
			spq.setParameter("p_codusumod", LenguaNivelBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", LenguaNivelBean.getIpModificacion()); 
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
	public boolean eliminar(LenguaNivelBean LenguaNivelBean) throws DAOException { 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaNivel.eliminar");
			spq.setParameter("p_codlengua", LenguaNivelBean.getCodigo()); 
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


	@SuppressWarnings("unchecked")
	@Override
	public LenguaNivelBean getBuscarPorObjecto(LenguaNivelBean LenguaNivelBean) throws DAOException {
		LenguaNivelBean oLenguaNivelBean = null;
		List<LeotbcLenguaNivel> lstLeotbcLenguaEstruc = null;
		System.out.println("LenguaNivelBean getBuscarPorObjecto " + LenguaNivelBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaNivel.buscar_por_codigo");			
			spq.setParameter("p_codlenniv", LenguaNivelBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcLenguaEstruc = spq.getResultList();			
			}
			
			if (	lstLeotbcLenguaEstruc != null
				&&	lstLeotbcLenguaEstruc.size() > 0) {
				
				oLenguaNivelBean = deLenguaALenguaNivelBean(lstLeotbcLenguaEstruc.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oLenguaNivelBean;
	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<LenguaNivelBean> getBuscarPorFiltros(LenguaNivelBean lengua) throws DAOException { 
		List<LeotbcLenguaNivel> lstLengua = null;	
		List<LenguaNivelBean> lstLenguaNivelBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaNivel.buscar_por_filtros");   
			spq.setParameter("p_tm1sitlen", lengua.getSituacion().getCodigoRegistro());  
			if (spq.execute()) {
				lstLengua =  spq.getResultList(); 
			} 
			if (lstLengua != null && lstLengua.size() > 0) {
				
				lstLenguaNivelBean = deListaLenguaAListaLenguaNivelBean(lstLengua);
			}
			em.close();
			
		   
		return lstLenguaNivelBean;
	}


	@Override
	public boolean existe(LenguaNivelBean leotbcLenguaNivel) throws DAOException { 
		Boolean sw = true;
		List<LeotbdLeUndLeccion> lstLeotbdLestunidad = null; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaNivel.existe");
			spq.setParameter("p_codlenniv", leotbcLenguaNivel.getCodigo()); 
			spq.setParameter("p_codlengua", leotbcLenguaNivel.getLenguaBean().getCodigo()); 
			spq.setParameter("p_tm2nivel", leotbcLenguaNivel.getNivel().getCodigoRegistro()); 
	
			if (spq.execute()) {
				lstLeotbdLestunidad = spq.getResultList();			
			}
			
			if (	lstLeotbdLestunidad != null
				&&	lstLeotbdLestunidad.size() > 0) {
				
				sw = true;
			}else{
				sw = false;
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return sw;
	}
	
	private List<LenguaNivelBean> deListaLenguaAListaLenguaNivelBean(List<LeotbcLenguaNivel> lstHorarioExcepcion) {
		
		List<LenguaNivelBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<LenguaNivelBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				LeotbcLenguaNivel entity = lstHorarioExcepcion.get(i);
				LenguaNivelBean bean = deLenguaALenguaNivelBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private LenguaNivelBean deLenguaALenguaNivelBean(LeotbcLenguaNivel entity) {
		
		LenguaNivelBean bean = null;
		
		if (entity != null) {
			
			bean = new LenguaNivelBean(); 
			bean.setCodigo(entity.getnCodlenniv()); 
			bean.setNombreNivel(entity.getvNombnivel());
			bean.setSubNiveles(entity.getV_nomsubnivel());
			bean.getNivel().setCodigoRegistro(entity.getnTm2nivel());  
			bean.getNivel().setNombreCorto(entity.getV_nomcortonivel());  
			bean.getNivel().setValor4(entity.getV_valor4());  
			bean.getLenguaBean().setCodigo(entity.getnCodlengua());  
			bean.getLenguaBean().setNombre(entity.getV_nomlengua()); 
			bean.getLenguaBean().setImagenNombre(entity.getvNombimag()); 
			 
			bean.getSituacion().setCodigoRegistro(entity.getnTm1sitleniv()); 
			bean.getSituacion().setNombreCorto(entity.getV_nomcortoSituacion());  
		}
		
		return bean;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<LenguaNivelBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws DAOException {
		List<LeotbcLenguaNivel> lstLeotbcLenguaEstruc = null;	
		List<LenguaNivelBean> lstLenguaNivelBean = null;
		System.out.println("lenguaBean getCodigo " + lenguaBean.getCodigo());
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaNivel.listarPorCodigoLengua");   
			spq.setParameter("p_codlengua", lenguaBean.getCodigo());  
			if (spq.execute()) {
				lstLeotbcLenguaEstruc =  spq.getResultList(); 
			} 
			System.out.println("lstLeotbcLenguaEstruc.size() DAO "+lstLeotbcLenguaEstruc.size());
			if (lstLeotbcLenguaEstruc != null && lstLeotbcLenguaEstruc.size() > 0) { 
				lstLenguaNivelBean = deListaLenguaAListaLenguaNivelBean(lstLeotbcLenguaEstruc);
			}
		     em.close();
			
		   
		return lstLenguaNivelBean;
	}
 
}
