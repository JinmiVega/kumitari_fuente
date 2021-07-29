package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaNivelBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLenguaEstruc;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdLeUndLeccion;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.LenguaEstructuraDAO;
 
@Transactional
@Repository("lenguaEstructuraDAO")
public class LenguaEstructuraDAOImp implements LenguaEstructuraDAO {
	
	
	@PersistenceContext
	private EntityManager em; 
	 
	
	@Override
	public boolean insertar(LenguaEstructuraBean lenguaEstructuraBean) throws DAOException {   
		Object idLengua= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaEstruc.insertar"); 
			spq.setParameter("p_codlenniv", lenguaEstructuraBean.getLenguaNivelBean().getCodigo());
			spq.setParameter("p_codlengua", lenguaEstructuraBean.getLenguaBean().getCodigo());
			spq.setParameter("p_tm2nivel", lenguaEstructuraBean.getNivel().getCodigoRegistro());
		//	spq.setParameter("p_nombnivel", lenguaEstructuraBean.getNombreNivel());
			spq.setParameter("p_tm2subnivel", lenguaEstructuraBean.getSubNivel().getCodigoRegistro());
			spq.setParameter("p_tm1sitest", 1);//Integer.valueOf(lenguaEstructuraBean.getSituacion().getCodigoRegistro()));
			spq.setParameter("p_nombimag", lenguaEstructuraBean.getNombreImagen());
			spq.setParameter("p_swactivo", lenguaEstructuraBean.getSwActivo());
			spq.setParameter("p_codusureg", lenguaEstructuraBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", lenguaEstructuraBean.getIpCreacion());  
			spq.execute();
			sw=true;
			idLengua = spq.getOutputParameterValue(1);
			if (idLengua != null) {
				lenguaEstructuraBean.setCodigo(Integer.valueOf(idLengua.toString()));
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
	public boolean actualizar(LenguaEstructuraBean LenguaEstructuraBean) throws DAOException {
		boolean sw=false;
		System.out.println("LenguaEstructuraBean actualizar " + LenguaEstructuraBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaEstruc.actualizar");
			spq.setParameter("p_codlenest", LenguaEstructuraBean.getCodigo());  
			spq.setParameter("p_tm2nivel", LenguaEstructuraBean.getNivel().getCodigoRegistro()); 
			spq.setParameter("p_tm2subnivel", LenguaEstructuraBean.getSubNivel().getCodigoRegistro()); 
			spq.setParameter("p_tm1sitest", LenguaEstructuraBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_nombimag", LenguaEstructuraBean.getNombreImagen());
			spq.setParameter("p_swactivo", LenguaEstructuraBean.getSwActivo());
			spq.setParameter("p_codusumod", LenguaEstructuraBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", LenguaEstructuraBean.getIpModificacion()); 
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
	public boolean eliminar(LenguaEstructuraBean LenguaEstructuraBean) throws DAOException { 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaEstruc.eliminar");
			spq.setParameter("p_codlengua", LenguaEstructuraBean.getCodigo()); 
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
	public LenguaEstructuraBean getBuscarPorObjecto(LenguaEstructuraBean LenguaEstructuraBean) throws DAOException {
		LenguaEstructuraBean oLenguaEstructuraBean = null;
		List<LeotbcLenguaEstruc> lstLeotbcLenguaEstruc = null;
		System.out.println("LenguaEstructuraBean getBuscarPorObjecto " + LenguaEstructuraBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaEstruc.buscar_por_codigo");			
			spq.setParameter("p_codlenest", LenguaEstructuraBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcLenguaEstruc = spq.getResultList();			
			}
			
			if (	lstLeotbcLenguaEstruc != null
				&&	lstLeotbcLenguaEstruc.size() > 0) {
				
				oLenguaEstructuraBean = deLenguaALenguaEstructuraBean(lstLeotbcLenguaEstruc.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oLenguaEstructuraBean;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public LenguaEstructuraBean getBuscar_MayorSubnivel(LenguaEstructuraBean LenguaEstructuraBean) throws DAOException {
		LenguaEstructuraBean oLenguaEstructuraBean = null;
		List<LeotbcLenguaEstruc> lstLeotbcLenguaEstruc = null;
		System.out.println("LenguaEstructuraBean getBuscarPorObjecto " + LenguaEstructuraBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaEstruc.buscarMayorSubnivel");			
			spq.setParameter("p_codlengua", LenguaEstructuraBean.getLenguaBean().getCodigo());
			spq.setParameter("p_tm2nivel", LenguaEstructuraBean.getNivel().getCodigoRegistro());  
		
			if (spq.execute()) {
				lstLeotbcLenguaEstruc = spq.getResultList();			
			}
			
			if (	lstLeotbcLenguaEstruc != null
				&&	lstLeotbcLenguaEstruc.size() > 0) {
				
				oLenguaEstructuraBean = deLenguaALenguaEstructuraBean(lstLeotbcLenguaEstruc.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oLenguaEstructuraBean;
	}
	


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<LenguaEstructuraBean> getBuscarPorFiltros(LenguaEstructuraBean lengua) throws DAOException { 
		List<LeotbcLenguaEstruc> lstLengua = null;	
		List<LenguaEstructuraBean> lstLenguaEstructuraBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaEstruc.buscar_por_filtros");   
			spq.setParameter("p_tm1sitlen", lengua.getSituacion().getCodigoRegistro());  
			if (spq.execute()) {
				lstLengua =  spq.getResultList(); 
			} 
			if (lstLengua != null && lstLengua.size() > 0) {
				
				lstLenguaEstructuraBean = deListaLenguaAListaLenguaEstructuraBean(lstLengua);
			}
			em.close();
			
		   
		return lstLenguaEstructuraBean;
	}


	@Override
	public boolean existe(LenguaEstructuraBean lenguaEstructuraBean) throws DAOException { 
		Boolean sw = true;
		List<LeotbdLeUndLeccion> lstLeotbdLestunidad = null; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaEstruc.existe");	
			System.out.println("---- leotbdlenguaestruc ---"+lenguaEstructuraBean.getCodigo()+", "+lenguaEstructuraBean.getLenguaNivelBean().getCodigo()+" , "+lenguaEstructuraBean.getSubNivel().getCodigoRegistro());
			spq.setParameter("p_codlenest", lenguaEstructuraBean.getCodigo());  
			spq.setParameter("p_codlenniv", lenguaEstructuraBean.getLenguaNivelBean().getCodigo()); 
			spq.setParameter("p_tm2subnivel", lenguaEstructuraBean.getSubNivel().getCodigoRegistro());  
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
	
	private List<LenguaEstructuraBean> deListaLenguaAListaLenguaEstructuraBean(List<LeotbcLenguaEstruc> lstHorarioExcepcion) {
		
		List<LenguaEstructuraBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<LenguaEstructuraBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				LeotbcLenguaEstruc entity = lstHorarioExcepcion.get(i);
				LenguaEstructuraBean bean = deLenguaALenguaEstructuraBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private LenguaEstructuraBean deLenguaALenguaEstructuraBean(LeotbcLenguaEstruc entity) {
		
		LenguaEstructuraBean bean = null;
		
		if (entity != null) {
			
			bean = new LenguaEstructuraBean();
			bean.getSubNivel().setCodigoRegistro(entity.getnTm2subnivel()); 
			bean.getNivel().setCodigoRegistro(entity.getnTm2nivel()); 
			bean.getSubNivel().setNombreCorto(entity.getV_nomsubnivel()); 
			bean.getSubNivel().setValor2(entity.getV_valor2());
			bean.getNivel().setNombreCorto(entity.getV_nomnivel());  
			bean.getNivel().setValor4(entity.getV_valor4()); 
			bean.setSwActivo(entity.getV_swactivo()); 
			bean.getLenguaBean().setCodigo(entity.getNCodlengua());  
			bean.getLenguaBean().setNombre(entity.getV_nomlengua()); 
			bean.getLenguaBean().setImagenNombre(entity.getV_nombimag()); 
			bean.setCodigo(entity.getNcodlenest());  
			bean.getSituacion().setCodigoRegistro(entity.getnTm1sitest()); 
			bean.getSituacion().setNombreCorto(entity.getV_nomcortoSituacion()); 
			bean.setBasico(entity.getBasico()); 
			bean.setIntermedio(entity.getIntermedio()); 
			bean.setAvanzado(entity.getAvanzado()); 
			bean.setCantidadUnidad(entity.getN_cant_unidad()); 
			bean.setCantidadLeccion(entity.getN_cant_leccion());
			bean.setNombreImagen(entity.getV_nombimag());
			bean.setLenguaNivelBean(new LenguaNivelBean());
			bean.getLenguaNivelBean().setNombreNivel(entity.getvNombnivel());
			bean.getLenguaNivelBean().setInicialNombre(entity.getV_ininomb());
		}
		
		return bean;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<LenguaEstructuraBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws DAOException {
		List<LeotbcLenguaEstruc> lstLeotbcLenguaEstruc = null;	
		List<LenguaEstructuraBean> lstLenguaEstructuraBean = null;
		System.out.println("lenguaBean getCodigo " + lenguaBean.getCodigo());
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaEstruc.listarPorCodigoLengua");   
			spq.setParameter("p_codlengua", lenguaBean.getCodigo());  
			if (spq.execute()) {
				lstLeotbcLenguaEstruc =  spq.getResultList(); 
			} 
			System.out.println("lstLeotbcLenguaEstruc.size() DAO "+lstLeotbcLenguaEstruc.size());
			if (lstLeotbcLenguaEstruc != null && lstLeotbcLenguaEstruc.size() > 0) { 
				lstLenguaEstructuraBean = deListaLenguaAListaLenguaEstructuraBean(lstLeotbcLenguaEstruc);
			}
		     em.close();
			
		   
		return lstLenguaEstructuraBean;
	}


	@Override
	public boolean insertarLenguaEstrucTemporal(LenguaBean lenguaBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaEstruc.insertarTemporal"); 
			spq.setParameter("p_codlengua", lenguaBean.getCodigo());
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
	public List<LenguaEstructuraBean> listarNiveles(LenguaBean lenguaBean) throws DAOException {
		List<LeotbcLenguaEstruc> lstLeotbcLenguaEstruc = null;	
		List<LenguaEstructuraBean> lstLenguaEstructuraBean = null;
		System.out.println("lenguaBean getCodigo " + lenguaBean.getCodigo());
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaEstruc.listarNiveles");   
			spq.setParameter("p_codlengua", lenguaBean.getCodigo());  
			if (spq.execute()) {
				lstLeotbcLenguaEstruc =  spq.getResultList(); 
			}  
			if (lstLeotbcLenguaEstruc != null && lstLeotbcLenguaEstruc.size() > 0) { 
				lstLenguaEstructuraBean = deListaLenguaAListaLenguaEstructuraBean(lstLeotbcLenguaEstruc);
			}
		     em.close();
			
		   
		return lstLenguaEstructuraBean;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<LenguaEstructuraBean> listarSubNiveles(LenguaEstructuraBean lenguaEstructuraBean) throws DAOException {
		List<LeotbcLenguaEstruc> lstLeotbcLenguaEstruc = null;	
		List<LenguaEstructuraBean> lstLenguaEstructuraBean = null; 
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaEstruc.listarSubNiveles");   
			spq.setParameter("p_codlengua", lenguaEstructuraBean.getLenguaBean().getCodigo());  
			spq.setParameter("p_tgm2Nivel", lenguaEstructuraBean.getNivel().getCodigoRegistro()); 
			if (spq.execute()) {
				lstLeotbcLenguaEstruc =  spq.getResultList(); 
			} 
			System.out.println("listarSubNiveles.size() DAO "+lstLeotbcLenguaEstruc.size());
			if (lstLeotbcLenguaEstruc != null && lstLeotbcLenguaEstruc.size() > 0) { 
				lstLenguaEstructuraBean = deListaLenguaAListaLenguaEstructuraBean(lstLeotbcLenguaEstruc);
			}
		     em.close();
			
		   
		return lstLenguaEstructuraBean;
	}


	@Override
	public List<LenguaEstructuraBean> listarMaterial(LenguaEstructuraBean lenguaEstructuraBean) throws DAOException {
		List<LeotbcLenguaEstruc> lstLengua = null;	
		List<LenguaEstructuraBean> lstLenguaEstructuraBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaEstruc.listarMateriales");   
			spq.setParameter("p_codlengua", lenguaEstructuraBean.getLenguaBean().getCodigo());  
			spq.setParameter("p_tm1sitlen", lenguaEstructuraBean.getSituacion().getCodigoRegistro());  
			if (spq.execute()) {
				lstLengua =  spq.getResultList(); 
			} 
			if (lstLengua != null && lstLengua.size() > 0) {
				System.out.println("lstLengua material " + lstLengua.size());
				lstLenguaEstructuraBean = deListaLenguaAListaLenguaEstructuraBean(lstLengua);
			}
			em.close();
			
		   
		return lstLenguaEstructuraBean;
	}


	@Override
	public List<LenguaEstructuraBean> listarNivelesxLenguaAll(LenguaBean lenguaBean) throws DAOException {
		List<LeotbcLenguaEstruc> lstLeotbcLenguaEstruc = null;	
		List<LenguaEstructuraBean> lstLenguaEstructuraBean = null;
		System.out.println("lenguaBean getCodigo " + lenguaBean.getCodigo());
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaEstruc.listarNivelesxlenguaall");   
			spq.setParameter("p_codlengua", lenguaBean.getCodigo());  
			if (spq.execute()) {
				lstLeotbcLenguaEstruc =  spq.getResultList(); 
			}  
			if (lstLeotbcLenguaEstruc != null && lstLeotbcLenguaEstruc.size() > 0) { 
				lstLenguaEstructuraBean = deListaLenguaAListaLenguaEstructuraBean(lstLeotbcLenguaEstruc);
			}
		     em.close();
			
		   
		return lstLenguaEstructuraBean;
	}


	@Override
	public List<LenguaEstructuraBean> listarPorCodigoNivelLengua(LenguaNivelBean lenguaNivelBean) throws DAOException {
		List<LeotbcLenguaEstruc> lstLeotbcLenguaEstruc = null;	
		List<LenguaEstructuraBean> lstLenguaEstructuraBean = null;
		System.out.println("lenguaBean getCodigo " + lenguaNivelBean.getCodigo());
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLenguaEstruc.listarPorCodigoNivelLengua");   
			spq.setParameter("p_codlenniv", lenguaNivelBean.getCodigo());  
			if (spq.execute()) {
				lstLeotbcLenguaEstruc =  spq.getResultList(); 
			}  
			if (lstLeotbcLenguaEstruc != null && lstLeotbcLenguaEstruc.size() > 0) { 
				lstLenguaEstructuraBean = deListaLenguaAListaLenguaEstructuraBean(lstLeotbcLenguaEstruc);
			}
		     em.close();
			
		   
		return lstLenguaEstructuraBean;
	}


}
