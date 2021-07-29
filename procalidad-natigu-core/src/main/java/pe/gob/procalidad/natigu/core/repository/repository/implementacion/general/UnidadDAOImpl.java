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
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaUnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdLestunidad;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.UnidadDAO;

@Transactional
@Repository("unidadDAO")
public class UnidadDAOImpl implements UnidadDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(UnidadBean unidadBean) throws DAOException {
		Object idunidad = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlestunidad.insertar");
			spq.setParameter("p_codlenest", unidadBean.getLenguaEstructuraBean().getCodigo());
			spq.setParameter("p_tm2unidad", unidadBean.getUnidad().getCodigoRegistro());
			spq.setParameter("p_desunidad", unidadBean.getDescripcion());
			spq.setParameter("p_tm1sitund", unidadBean.getSituacion().getCodigo());
			spq.setParameter("p_nomunidad", unidadBean.getNombre()); 
			spq.setParameter("p_codusureg", unidadBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", unidadBean.getIpCreacion());
			spq.setParameter("p_nombimag", unidadBean.getNombreImagen());
			
			
			spq.execute();
			
			idunidad = spq.getOutputParameterValue(1);
			if(idunidad != null)
			{
				unidadBean.setCodigo(Integer.valueOf(idunidad.toString()));
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
	public boolean actualizar(UnidadBean unidadBean) throws DAOException {
		boolean sw=false;

		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlestunidad.actualizar");
			spq.setParameter("p_codlesuni", unidadBean.getCodigo());
			spq.setParameter("p_codlenest", unidadBean.getLenguaEstructuraBean().getCodigo());
			spq.setParameter("p_tm2unidad", unidadBean.getUnidad().getCodigoRegistro());
			spq.setParameter("p_desunidad", unidadBean.getDescripcion());

			spq.setParameter("p_tm1sitund", unidadBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_nomunidad", unidadBean.getNombre()); 
			spq.setParameter("p_codusumod", unidadBean.getCodigoUsuarioModificacion()); 
			spq.setParameter("p_hostmod", unidadBean.getIpModificacion());
			spq.setParameter("p_nombimag", unidadBean.getNombreImagen());
			
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
	public boolean eliminar(UnidadBean unidadBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlestunidad.eliminar");
			spq.setParameter("p_codlesuni", unidadBean.getCodigo());
			spq.setParameter("p_codusumod", unidadBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", unidadBean.getIpModificacion());
			spq.execute();
			sw = true;
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UnidadBean getBuscarPorObjecto(UnidadBean unidadBean) throws DAOException {
		List<LeotbdLestunidad> 	lstUnidad 	= null;
		UnidadBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlestunidad.buscar_por_codigo");
		spq.setParameter("p_codlesuni", unidadBean.getCodigo());
		
		if (spq.execute()) 
		{
			lstUnidad =  spq.getResultList(); 
		} 
		if (lstUnidad != null && lstUnidad.size() > 0) 
		{  
			bean = deUnidadAUnidadBean(lstUnidad.get(0));
 
		}
		return bean;	
	}

	@Override
	public List<UnidadBean> getBuscarPorFiltros(UnidadBean unidadBean) throws DAOException {
		List<LeotbdLestunidad> 	lstUnidad	= null;
		List<UnidadBean> 	lstUnidadBean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlestunidad.buscar_por_filtros");
		spq.setParameter("p_codlenest", 	unidadBean.getLenguaEstructuraBean().getCodigo());
		spq.setParameter("p_tm2unidad", 	unidadBean.getUnidad().getCodigo());
		spq.setParameter("p_desunidad", 	unidadBean.getDescripcion());
		spq.setParameter("p_tm1sitund", 	unidadBean.getSituacion().getCodigo());
		spq.setParameter("p_nomunidad", 	unidadBean.getNombre());
		
		
		if (spq.execute()) {
			lstUnidad =  spq.getResultList(); 
		} 
		if (lstUnidad != null && lstUnidad.size() > 0) {			
			lstUnidadBean = deListaUnidadAListaUnidadBean(lstUnidad);
		}
		
		return lstUnidadBean;
	}

	@Override
	public boolean existe(UnidadBean unidadBean) throws DAOException {
		Boolean sw = true;
		List<LeotbdLestunidad> lstLeotbdLestunidad = null; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlestunidad.existe");			
			spq.setParameter("p_codlesuni", unidadBean.getCodigo()); 
			spq.setParameter("p_codlenest", unidadBean.getLenguaEstructuraBean().getCodigo());
			spq.setParameter("p_tm2unidad", unidadBean.getUnidad().getCodigoRegistro());
			spq.setParameter("p_nomunidad", unidadBean.getNombre()); 
			
		
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
	
	public List<UnidadBean> deListaUnidadAListaUnidadBean(List<LeotbdLestunidad> lstUnidad) {
		
		
		List<UnidadBean> lstUnidadBean = null;
	
		if (lstUnidad != null && lstUnidad.size() > 0) {
			
			lstUnidadBean = new ArrayList<UnidadBean>();
			
			for (int i = 0; i < lstUnidad.size(); i++) { 
				LeotbdLestunidad entity = lstUnidad.get(i);
				UnidadBean bean = deUnidadAUnidadBean(entity);
				
				lstUnidadBean.add(bean);
			}
		}
		return lstUnidadBean;
	}
	
	public UnidadBean deUnidadAUnidadBean(LeotbdLestunidad entity) {
		
		UnidadBean bean = null;
		
		if (entity != null) {
			
			bean = new UnidadBean();
			
			bean.setCodigo(entity.getnCodlesuni());
			bean.setNombre(entity.getvNomunidad());
			bean.setDescripcion(entity.getvDesunidad());
			
			bean.setUnidad(new MaestraBean());
			bean.getUnidad().setCodigoRegistro(entity.getnTm2unidad());
			bean.getUnidad().setNombreCorto(entity.getV_nomcortounidad());
			bean.setNombreLecciones(entity.getV_nomleccion());
			bean.setSituacion(new MaestraBean());
			bean.getSituacion().setCodigoRegistro(entity.getnTm1sitund());
			
			bean.setLenguaEstructuraBean(new LenguaEstructuraBean());
			bean.getLenguaEstructuraBean().setCodigo(entity.getnCodlenest());
			
			bean.getLenguaEstructuraBean().setLenguaBean(new LenguaBean());
			bean.getLenguaEstructuraBean().getLenguaBean().setCodigo(entity.getnCodlengua());
			bean.getLenguaEstructuraBean().getLenguaBean().setNombre(entity.getvNomlengua());
			bean.getLenguaEstructuraBean().getLenguaBean().setImagenNombre(entity.getvNombimag());
			bean.getLenguaEstructuraBean().getNivel().setCodigoRegistro(entity.getN_tm2nivel());
			bean.getLenguaEstructuraBean().getNivel().setNombreCorto(entity.getV_nomnivel());
			
			bean.getLenguaEstructuraBean().getSubNivel().setNombreCorto(entity.getV_nomsubnivel());
			bean.getLenguaEstructuraBean().getSubNivel().setNombreCorto(entity.getV_nomsubnivel());
			
			bean.setNombreImagen(entity.getvNombimag());
			 
			bean.setLenguaUnidadBean(new LenguaUnidadBean());
			bean.getLenguaUnidadBean().setNombreImagen(entity.getvNombimagUnidad());
			bean.getLenguaUnidadBean().setNombreImagenBloqueado(entity.getvNombimagBloqueadoUnidad());
			bean.getLenguaUnidadBean().setInicialNombre(entity.getV_inicnombre());
		}
		
		return bean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UnidadBean buscarLengua(LenguaEstructuraBean lenguaEstructuraBean) throws DAOException {
		List<LeotbdLestunidad> 	lstUnidad 	= null;
		UnidadBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlestunidad.buscar_lengua");
		spq.setParameter("p_codlengua", lenguaEstructuraBean.getLenguaBean().getCodigo());
		spq.setParameter("p_tm2nivel", lenguaEstructuraBean.getNivel().getCodigoRegistro());
		spq.setParameter("p_tm2subnivel", lenguaEstructuraBean.getSubNivel().getCodigoRegistro());
		
		if (spq.execute()) 
		{
			lstUnidad =  spq.getResultList(); 
		} 
		if (lstUnidad != null && lstUnidad.size() > 0) 
		{
			bean = deUnidadAUnidadBean(lstUnidad.get(0));
		}
		return bean;	
	}

	@Override
	public List<UnidadBean> listarPorCodigoLengua(LenguaBean lenguaBean) throws DAOException {
		List<LeotbdLestunidad> 	lstUnidad	= null;
		List<UnidadBean> 	lstUnidadBean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlestunidad.listar_por_codigolengua");
		spq.setParameter("p_codlengua", 	lenguaBean.getCodigo()); 
		
		
		if (spq.execute()) {
			lstUnidad =  spq.getResultList(); 
		} 
		if (lstUnidad != null && lstUnidad.size() > 0) {			
			lstUnidadBean = deListaUnidadAListaUnidadBean(lstUnidad);
		}
		
		return lstUnidadBean;
	}
	
}
