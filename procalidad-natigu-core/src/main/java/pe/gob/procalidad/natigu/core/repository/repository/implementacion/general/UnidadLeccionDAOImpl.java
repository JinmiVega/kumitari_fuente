package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaLeccionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdLeUndLeccion;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdLestunidad;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.UnidadLeccionDAO;

@Transactional
@Repository("unidadLeccionDAO")
public class UnidadLeccionDAOImpl implements UnidadLeccionDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(UnidadLeccionBean unidadLeccionBean) throws DAOException {
		Object idUnidadLeccion = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdleundleccion.insertar");
			spq.setParameter("p_codlesuni", unidadLeccionBean.getUnidadBean().getCodigo());
			spq.setParameter("p_tm2leccion", unidadLeccionBean.getLeccion().getCodigoRegistro());
//			spq.setParameter("p_nomleccion", unidadLeccionBean.getNombre());
			spq.setParameter("p_nomleccion", unidadLeccionBean.getNombre());
			spq.setParameter("p_desleccion", unidadLeccionBean.getDescripcion());
			spq.setParameter("p_tm1sitlec", unidadLeccionBean.getSituacion().getCodigoRegistro()); 
			spq.setParameter("p_codusureg", unidadLeccionBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", 	unidadLeccionBean.getIpCreacion());
			spq.setParameter("p_nombimag", 	unidadLeccionBean.getNombreImagen());
			
			spq.execute();
			
			idUnidadLeccion = spq.getOutputParameterValue(1);
			if(idUnidadLeccion != null)
			{
				unidadLeccionBean.setCodigo(Long.valueOf(idUnidadLeccion.toString()));
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
	public boolean actualizar(UnidadLeccionBean unidadLeccionBean) throws DAOException {
		boolean sw=false;
		System.out.println("unidadLeccionBean actualizar " + unidadLeccionBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdleundleccion.actualizar");
			spq.setParameter("p_codleslec", unidadLeccionBean.getCodigo()); 
			spq.setParameter("p_codlesuni", unidadLeccionBean.getUnidadBean().getCodigo()); 
			spq.setParameter("p_tm2leccion", unidadLeccionBean.getLeccion().getCodigoRegistro());
			spq.setParameter("p_nomleccion", unidadLeccionBean.getNombre());
			spq.setParameter("p_desleccion", unidadLeccionBean.getDescripcion());
			spq.setParameter("p_tm1sitlec", unidadLeccionBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_codusumod", unidadLeccionBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", unidadLeccionBean.getIpModificacion()); 
			
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
	public boolean eliminar(UnidadLeccionBean unidadLeccionBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdleundleccion.eliminar");
			spq.setParameter("p_codleslec", unidadLeccionBean.getCodigo()); 
			spq.setParameter("p_codusumod", unidadLeccionBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", unidadLeccionBean.getIpModificacion());
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
	public UnidadLeccionBean getBuscarPorObjecto(UnidadLeccionBean unidadLeccionBean) throws DAOException {
		UnidadLeccionBean oUnidadLeccionBean = null;
		List<LeotbdLeUndLeccion> lstUnidadLeccion = null;
		System.out.println("unidadLeccionBean getBuscarPorObjecto " + unidadLeccionBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdleundleccion.buscar_por_codigo");			
			spq.setParameter("p_codundlec", unidadLeccionBean.getCodigo()); 
		
			if (spq.execute()) {
				lstUnidadLeccion = spq.getResultList();			
			}
			
			if (	lstUnidadLeccion != null
				&&	lstUnidadLeccion.size() > 0) {
				
				oUnidadLeccionBean = deUnidadLeccionAUnidadLeccionBean(lstUnidadLeccion.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oUnidadLeccionBean;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public UnidadLeccionBean getBuscarultLecXlenest(UnidadLeccionBean unidadLeccionBean) throws DAOException {
		UnidadLeccionBean oUnidadLeccionBean = null;
		List<LeotbdLeUndLeccion> lstUnidadLeccion = null;
		System.out.println("unidadLeccionBean mayor lec x lenest " + unidadLeccionBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdleundleccion.buscar_ultLeccionXlenest");			
			spq.setParameter("p_codlenest", unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getCodigo()); 
		
			if (spq.execute()) {
				lstUnidadLeccion = spq.getResultList();			
			}
			
			if (	lstUnidadLeccion != null
				&&	lstUnidadLeccion.size() > 0) {
				
				oUnidadLeccionBean = deUnidadLeccionAUnidadLeccionBean(lstUnidadLeccion.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oUnidadLeccionBean;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public UnidadLeccionBean getBuscarultLecXunidad(UnidadLeccionBean unidadLeccionBean) throws DAOException {
		UnidadLeccionBean oUnidadLeccionBean = null;
		List<LeotbdLeUndLeccion> lstUnidadLeccion = null;
		System.out.println("unidadLeccionBean mayor lec x lenest " + unidadLeccionBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdleundleccion.buscar_ultLeccionXunidad");			
			spq.setParameter("p_codlesuni", unidadLeccionBean.getUnidadBean().getCodigo()); 
		
			if (spq.execute()) {
				lstUnidadLeccion = spq.getResultList();			
			}
			
			if (	lstUnidadLeccion != null
				&&	lstUnidadLeccion.size() > 0) {
				
				oUnidadLeccionBean = deUnidadLeccionAUnidadLeccionBean(lstUnidadLeccion.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oUnidadLeccionBean;
	}
	

	@Override
	public List<UnidadLeccionBean> getBuscarPorFiltros(UnidadLeccionBean unidadLeccionBean) throws DAOException {
		List<LeotbdLeUndLeccion> 	lstUnidad	= null;
		List<UnidadLeccionBean> 	lstUnidadBean = null;

		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdleundleccion.buscar_por_filtros");
		spq.setParameter("p_codlesuni", unidadLeccionBean.getUnidadBean().getCodigo());
		//spq.setParameter("p_tgm2nivel", unidadLeccionBean.getUnidadBean(). getLenguaEstructuraBean().getNivel().getCodigoRegistro()); 
		
		if (spq.execute()) {
			lstUnidad =  spq.getResultList(); 
		} 
		if (lstUnidad != null && lstUnidad.size() > 0) {			
			lstUnidadBean = deLstUnidadLeccionALstUnidadLeccionBean(lstUnidad);
		}
		
		return lstUnidadBean;
	}
	
	
	@Override
	public List<UnidadLeccionBean> getBuscarPorLenNiv(UnidadLeccionBean unidadLeccionBean) throws DAOException {
		List<LeotbdLeUndLeccion> 	lstUnidad	= null;
		List<UnidadLeccionBean> 	lstUnidadBean = null;

		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdleundleccion.buscar_por_NivelLengua");
		spq.setParameter("p_codlengua", unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getLenguaBean().getCodigo());
//		spq.setParameter("p_tm2nivel", unidadLeccionBean.getUnidadBean(). getLenguaEstructuraBean().getNivel().getCodigoRegistro()); 
		spq.setParameter("p_tm2subnivel", unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getSubNivel().getCodigoRegistro());
		
		if (spq.execute()) {
			lstUnidad =  spq.getResultList(); 
		} 
		if (lstUnidad != null && lstUnidad.size() > 0) {			
			lstUnidadBean = deLstUnidadLeccionALstUnidadLeccionBean(lstUnidad);
		}
		
		return lstUnidadBean;
	}
	
	

	@Override
	public boolean existe(UnidadLeccionBean unidadLeccionBean) throws DAOException {
		Boolean sw = true;
		List<LeotbdLeUndLeccion> lstLeotbdLestunidad = null; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdleundleccion.existe");			
			spq.setParameter("p_codundlec", unidadLeccionBean.getCodigo());  
			spq.setParameter("p_nomleccion", unidadLeccionBean.getNombre()); 
			spq.setParameter("p_codlesuni", unidadLeccionBean.getUnidadBean().getCodigo()); 
			spq.setParameter("p_tm2leccion", unidadLeccionBean.getLeccion().getCodigoRegistro()); 
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
	
	public UnidadLeccionBean deUnidadLeccionAUnidadLeccionBean(LeotbdLeUndLeccion entity) {
		
		UnidadLeccionBean bean = null;
		
		if (entity != null) {
			
			bean = new UnidadLeccionBean(); 
			bean.setCodigo(entity.getnCodundlec());
 
			bean.setUnidadBean(new UnidadBean());
			bean.getUnidadBean().setCodigo(entity.getnCodlesuni());
			bean.getUnidadBean().setLenguaEstructuraBean(new LenguaEstructuraBean());
			bean.getUnidadBean().getLenguaEstructuraBean().getNivel().setNombreCorto(entity.getV_nomnivel());
			bean.getUnidadBean().getLenguaEstructuraBean().getNivel().setCodigoRegistro(entity.getN_tm2nivel());
			bean.getUnidadBean().getLenguaEstructuraBean().getSubNivel().setNombreCorto(entity.getV_nomsubnivel());
			bean.getUnidadBean().setNombre(entity.getV_unidad());
			bean.getUnidadBean().getUnidad().setNombreCorto(entity.getV_nombrecortounidad());
			bean.setNombre(entity.getvNomleccion());
			bean.setDescripcion(entity.getvDesleccion());
			bean.setLeccion(new MaestraBean());
			bean.getLeccion().setCodigoRegistro(entity.getnTm2leccion());
			bean.setSituacion(new MaestraBean());
			bean.getSituacion().setCodigoRegistro(entity.getnTm1sitlec());
			
			bean.setCodigoUsuarioCreacion(entity.getnCodusureg());
			bean.setFechaCreacion(entity.getdFecreg());
			//bean.setAudHostIP(entity.getvHostreg());
			bean.setCodigoUsuarioModificacion(entity.getnCodusureg());
			bean.setFechaModificacion(entity.getdFecreg());
			bean.setItem(entity.getnItem());
			bean.setLenguaLeccionBean(new LenguaLeccionBean());
			bean.getLenguaLeccionBean().setInicialNombre(entity.getV_inicnombre());
			bean.getLenguaLeccionBean().setNombreImagen(entity.getvNombimagLeccion());
			bean.getLenguaLeccionBean().setNombreImagenBloq(entity.getvNombimagBloqueadoLeccion());
			
		}
		
		return bean;
	}
	
	public List<UnidadLeccionBean> deLstUnidadLeccionALstUnidadLeccionBean(List<LeotbdLeUndLeccion> lstEntity)
	{
		List<UnidadLeccionBean> lstBean = null;
		lstBean = new ArrayList<UnidadLeccionBean>();
		
		for (int i = 0; i < lstEntity.size(); i++) { 
			LeotbdLeUndLeccion entity = lstEntity.get(i);
			UnidadLeccionBean bean = deUnidadLeccionAUnidadLeccionBean(entity);
			
			lstBean.add(bean);
		}
		return lstBean;
	}

	@Override
	public List<UnidadLeccionBean> listarPorLengua(LenguaBean lenguaBean) throws DAOException {
		List<LeotbdLeUndLeccion> 	lstUnidad	= null;
		List<UnidadLeccionBean> 	lstUnidadBean = null;

		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdleundleccion.buscar_por_codigolengua");
		spq.setParameter("p_codlengua", lenguaBean.getCodigo());
		 	
		if (spq.execute()) {
			lstUnidad =  spq.getResultList(); 
		} 
		if (lstUnidad != null && lstUnidad.size() > 0) {			
			lstUnidadBean = deLstUnidadLeccionALstUnidadLeccionBean(lstUnidad);
		}
		
		return lstUnidadBean;
	}

	@Override
	public List<UnidadLeccionBean> listarPorUnidad(UnidadBean unidadBean) throws DAOException {
		List<LeotbdLeUndLeccion> 	lstUnidad	= null;
		List<UnidadLeccionBean> 	lstUnidadBean = null;

		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdleundleccion.buscar_por_codigounidad");
		spq.setParameter("p_codlesuni", unidadBean.getCodigo());
		 	
		if (spq.execute()) {
			lstUnidad =  spq.getResultList(); 
		} 
		if (lstUnidad != null && lstUnidad.size() > 0) {			
			lstUnidadBean = deLstUnidadLeccionALstUnidadLeccionBean(lstUnidad);
		}
		
		return lstUnidadBean;
	}
	

}
