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
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaUnidadBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLenguaNivel;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdLenguaUnidad;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.LenguaUnidadDAO;
@Repository("lenguaUnidadDAO")
@Transactional(readOnly = true)
public class LenguaUnidadDAOImpl 
implements LenguaUnidadDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(LenguaUnidadBean lenguaUnidadBean) throws DAOException {
		Object idLenguaUnidad = null;
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_lenguaunidad.insertar"); 
			spq.setParameter("p_codlengua", lenguaUnidadBean.getLenguaBean().getCodigo());
			spq.setParameter("p_tm2unidad", lenguaUnidadBean.getUnidad().getCodigoRegistro());
			spq.setParameter("p_nombimag", lenguaUnidadBean.getNombreImagen()); 
			spq.setParameter("p_codusureg", lenguaUnidadBean.getCodigoUsuarioCreacion()); 
			spq.setParameter("p_hostreg", lenguaUnidadBean.getIpCreacion()); 
			spq.setParameter("p_nomunidad", lenguaUnidadBean.getNombreUnidad());
			spq.setParameter("p_nombimagbloq", lenguaUnidadBean.getNombreImagenBloqueado());
 
			spq.execute();
	
			idLenguaUnidad = spq.getOutputParameterValue(1);
			if (idLenguaUnidad != null) {
				lenguaUnidadBean.setCodigo(Long.valueOf(idLenguaUnidad.toString()));
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
	public boolean actualizar(LenguaUnidadBean lenguaUnidadBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_lenguaunidad.actulizar"); 
			spq.setParameter("p_codlenunidad", lenguaUnidadBean.getCodigo());
			spq.setParameter("p_codlengua", lenguaUnidadBean.getLenguaBean().getCodigo());
			spq.setParameter("p_tm2unidad", lenguaUnidadBean.getUnidad().getCodigoRegistro());
			spq.setParameter("p_nombimag", lenguaUnidadBean.getNombreImagen()); 
			spq.setParameter("p_codusumod", lenguaUnidadBean.getCodigoUsuarioCreacion()); 
			spq.setParameter("p_hostmod", lenguaUnidadBean.getIpCreacion()); 
			spq.setParameter("p_nomunidad", lenguaUnidadBean.getNombreUnidad()); 
			spq.setParameter("p_nombimagbloq", lenguaUnidadBean.getNombreImagenBloqueado());
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
	public boolean eliminar(LenguaUnidadBean lenguaUnidadBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_lenguaunidad.eliminar"); 
			spq.setParameter("p_codlenunidad", lenguaUnidadBean.getCodigo());
			spq.setParameter("p_codusumod", lenguaUnidadBean.getCodigoUsuarioCreacion()); 
			spq.setParameter("p_hostmod", lenguaUnidadBean.getIpCreacion()); 
 
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
	public LenguaUnidadBean getBuscarPorObjecto(LenguaUnidadBean lenguaUnidadBean)
			throws DAOException {
		LenguaUnidadBean oLenguaUnidadBean = null;
		List<LeotbdLenguaUnidad> lstLenguaUnidads = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_lenguaunidad.buscarPorCodigo");			
			spq.setParameter("p_codlenunidad", lenguaUnidadBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLenguaUnidads = spq.getResultList();			
			}
			
			if (	lstLenguaUnidads != null
				&&	lstLenguaUnidads.size() > 0) {
				
				oLenguaUnidadBean = deLenguaUnidadALenguaUnidadBean(lstLenguaUnidads.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oLenguaUnidadBean;
	}

	@Override
	public List<LenguaUnidadBean> getBuscarPorFiltros(LenguaUnidadBean lenguaUnidadBean)
			throws DAOException {
		List<LeotbdLenguaUnidad> lstLenguaUnidads = null;	
		List<LenguaUnidadBean> lstLenguaUnidadBeans = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_lenguaunidad.buscarPorFiltros");   
			spq.setParameter("p_codlengua", lenguaUnidadBean.getLenguaBean().getCodigo());  
			if (spq.execute()) {
				lstLenguaUnidads =  spq.getResultList(); 
			} 
			if (lstLenguaUnidads != null && lstLenguaUnidads.size() > 0) {
				
				lstLenguaUnidadBeans = deListaLenguaUnidadAListaLenguaUnidadBean(lstLenguaUnidads);
			}
			em.close();
			
		   
		return lstLenguaUnidadBeans;
	}
	private List<LenguaUnidadBean> deListaLenguaUnidadAListaLenguaUnidadBean(List<LeotbdLenguaUnidad> lstLenguaUnidads) {
		
		List<LenguaUnidadBean> lstLenguaUnidadBeans = null;
		
		if (lstLenguaUnidads != null && lstLenguaUnidads.size() > 0) {
			
			lstLenguaUnidadBeans = new ArrayList<LenguaUnidadBean>();
			
			for (int i = 0; i < lstLenguaUnidads.size(); i++) { 
				LeotbdLenguaUnidad entity = lstLenguaUnidads.get(i);
				LenguaUnidadBean bean = deLenguaUnidadALenguaUnidadBean(entity);
				
				lstLenguaUnidadBeans.add(bean);
			}
		}
		
		return lstLenguaUnidadBeans;
	}
	private LenguaUnidadBean deLenguaUnidadALenguaUnidadBean(LeotbdLenguaUnidad entity) {
		
		LenguaUnidadBean bean = null;
		
		if (entity != null) {
			bean = new LenguaUnidadBean();
			bean.setNombreImagen(entity.getvNombimag());
			bean.setNombreUnidad(entity.getvNomunidad());
			bean.setCodigo(entity.getnCodlenunidad());
			bean.getUnidad().setNombreCorto(entity.getvNomcorto());
			bean.getUnidad().setCodigoRegistro(entity.getnTm2unidad());
			bean.setNombreImagenBloqueado(entity.getvNombimagbloq());
		}
		
		return bean;
	}
	@Override
	public boolean existe(LenguaUnidadBean lenguaUnidadBean) throws DAOException { 
		Boolean sw = true;
		List<LeotbdLenguaUnidad> lstLeotbcLengua = null; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_lenguaunidad.existe");	
			spq.setParameter("p_codlenunidad", lenguaUnidadBean.getCodigo()); 
			spq.setParameter("p_codlengua", lenguaUnidadBean.getLenguaBean().getCodigo()); 
			spq.setParameter("p_tm2unidad", lenguaUnidadBean.getUnidad().getCodigoRegistro());
			
		
			if (spq.execute()) {
				lstLeotbcLengua = spq.getResultList();			
			}
			
			if (	lstLeotbcLengua != null
				&&	lstLeotbcLengua.size() > 0) {
				
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

	@Override
	public boolean actualizarimgxcod(LenguaUnidadBean lenguaUnidadBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_lenguaunidad.actulizarnombrefotoxcod"); 
			spq.setParameter("p_codlenunidad", lenguaUnidadBean.getCodigo());
			spq.setParameter("p_nombimag", lenguaUnidadBean.getNombreImagen()); 
			spq.setParameter("p_nombimagbloq", lenguaUnidadBean.getNombreImagenBloqueado());
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
}
