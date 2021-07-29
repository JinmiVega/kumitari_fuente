package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaLeccionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaUnidadBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdLenguaLeccion;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdLenguaUnidad;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.LenguaLeccionDAO;
@Transactional(readOnly = true)
@Repository("lenguaLeccionDAO")
public class LenguaLeccionDAOImpl implements LenguaLeccionDAO{

	
	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public boolean insertar(LenguaLeccionBean lenguaLeccionBean) throws DAOException {
		Object idLenguaLeccion = null;
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_lengualeccion.insertar"); 
			spq.setParameter("p_codlengua", lenguaLeccionBean.getLenguaBean().getCodigo());
			spq.setParameter("p_tm2leccion", lenguaLeccionBean.getLeccion().getCodigoRegistro());
			spq.setParameter("p_nombimag", lenguaLeccionBean.getNombreImagen()); 
			spq.setParameter("p_nomleccion", lenguaLeccionBean.getNombreLeccion());
			spq.setParameter("p_codusureg", lenguaLeccionBean.getCodigoUsuarioCreacion()); 
			spq.setParameter("p_hostreg", lenguaLeccionBean.getIpCreacion()); 
			spq.setParameter("p_nombimagbloq", lenguaLeccionBean.getNombreImagenBloq());
 
			spq.execute();
	
			idLenguaLeccion = spq.getOutputParameterValue(1);
			if (idLenguaLeccion != null) {
				lenguaLeccionBean.setCodigo(Long.valueOf(idLenguaLeccion.toString()));
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
	public boolean actualizar(LenguaLeccionBean lenguaLeccionBean) throws DAOException {	
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_lengualeccion.actulizar"); 
			
			spq.setParameter("p_codlenleccion", lenguaLeccionBean.getCodigo());
			spq.setParameter("p_codlengua", 	lenguaLeccionBean.getLenguaBean().getCodigo());
			spq.setParameter("p_tm2leccion", 	lenguaLeccionBean.getLeccion().getCodigoRegistro());
			spq.setParameter("p_nomleccion", 	lenguaLeccionBean.getNombreLeccion());
			spq.setParameter("p_nombimag", 		lenguaLeccionBean.getNombreImagen()); 			
			spq.setParameter("p_codusumod", 	lenguaLeccionBean.getCodigoUsuarioModificacion()); 
			spq.setParameter("p_hostmod", 		lenguaLeccionBean.getIpModificacion()); 
			spq.setParameter("p_nombimagbloq", 	lenguaLeccionBean.getNombreImagenBloq());
 
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
	public boolean eliminar(LenguaLeccionBean lenguaLeccionBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_lengualeccion.eliminar"); 
			
			spq.setParameter("p_codlenleccion", lenguaLeccionBean.getCodigo());
			spq.setParameter("p_codusumod", lenguaLeccionBean.getCodigoUsuarioModificacion()); 
			spq.setParameter("p_hostmod", lenguaLeccionBean.getIpModificacion()); 
			
 
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
	public LenguaLeccionBean getBuscarPorObjecto(LenguaLeccionBean lenguaLeccionBean)
			throws DAOException {
		LenguaLeccionBean oLenguaLeccionBean = null;
		List<LeotbdLenguaLeccion> lstLeotbdLenguaLeccion = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_lengualeccion.buscarPorCodigo");			
			spq.setParameter("p_codlenleccion", lenguaLeccionBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbdLenguaLeccion = spq.getResultList();			
			}
			
			if (	lstLeotbdLenguaLeccion != null
				&&	lstLeotbdLenguaLeccion.size() > 0) {
				
				oLenguaLeccionBean = deLenguaLeccionALenguaLeccionBean(lstLeotbdLenguaLeccion.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oLenguaLeccionBean;
	}

	@Override
	public List<LenguaLeccionBean> getBuscarPorFiltros(LenguaLeccionBean lenguaLeccionBean)
			throws DAOException {
		List<LeotbdLenguaLeccion> lstLenguaLeccions = null;	
		List<LenguaLeccionBean> lstLenguaLeccionBeans = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_lengualeccion.buscarPorFiltros");   
			spq.setParameter("p_codlengua", lenguaLeccionBean.getLenguaBean().getCodigo());  
			if (spq.execute()) {
				lstLenguaLeccions =  spq.getResultList(); 
			} 
			if (lstLenguaLeccions != null && lstLenguaLeccions.size() > 0) {
				
				lstLenguaLeccionBeans = deListaLenguaLeccionAListaLenguaLeccionUnidadBean(lstLenguaLeccions);
			}
			em.close();
			
		   
		return lstLenguaLeccionBeans;
	}
	private List<LenguaLeccionBean> deListaLenguaLeccionAListaLenguaLeccionUnidadBean(List<LeotbdLenguaLeccion> lstLeotbdLenguaLeccions) {
		
		List<LenguaLeccionBean> lstLenguaLeccionBeans = null;
		
		if (lstLeotbdLenguaLeccions != null && lstLeotbdLenguaLeccions.size() > 0) {
			
			lstLenguaLeccionBeans = new ArrayList<LenguaLeccionBean>();
			
			for (int i = 0; i < lstLeotbdLenguaLeccions.size(); i++) { 
				LeotbdLenguaLeccion entity = lstLeotbdLenguaLeccions.get(i);
				LenguaLeccionBean bean = deLenguaLeccionALenguaLeccionBean(entity);
				
				lstLenguaLeccionBeans.add(bean);
			}
		}
		
		return lstLenguaLeccionBeans;
	}
	private LenguaLeccionBean deLenguaLeccionALenguaLeccionBean(LeotbdLenguaLeccion entity) {
		
		LenguaLeccionBean bean = null;
		
		if (entity != null) {
			bean = new LenguaLeccionBean();
			bean.setCodigo(entity.getnCodlenleccion());
			bean.setNombreImagen(entity.getvNombimag());
			bean.setNombreImagenBloq(entity.getvNombimagbloq());
			bean.setNombreLeccion(entity.getvNomleccion());
			bean.getLeccion().setCodigoRegistro(entity.getnTm2leccion());
			bean.getLeccion().setNombreCorto(entity.getvNomcorto());
 
		}
		
		return bean;
	}
	@Override
	public boolean existe(LenguaLeccionBean lenguaLeccionBean) throws DAOException {
		Boolean sw = true;
		List<LeotbdLenguaLeccion> lstLeotbcLengua = null; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_lengualeccion.existe");	
			spq.setParameter("p_codlenleccion", lenguaLeccionBean.getCodigo()); 
			spq.setParameter("p_codlengua", lenguaLeccionBean.getLenguaBean().getCodigo()); 
			spq.setParameter("p_tm2leccion", lenguaLeccionBean.getLeccion().getCodigoRegistro());
			
		
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
	public boolean actualizarimgxcod(LenguaLeccionBean lenguaLeccionBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_lengualeccion.actulizarnombxcod"); 
			
			spq.setParameter("p_codlenleccion", lenguaLeccionBean.getCodigo());
			spq.setParameter("p_nombimag", 		lenguaLeccionBean.getNombreImagen()); 
			spq.setParameter("p_nombimagbloq", 	lenguaLeccionBean.getNombreImagenBloq());
 
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
