package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionCabeceraBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcPregunta;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcRelacion;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.RelacionDAO;

@Transactional
@Repository("relacionDAO")
public class RelacionDAOImpl implements RelacionDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(RelacionBean relacionBean) throws DAOException {
		Object idRelacion = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacion.insertar");
			spq.setParameter("p_codrelcab", 	relacionBean.getRelacionCabeceraBean().getCodigo());
			spq.setParameter("p_palabra", 		relacionBean.getPalabra());
			spq.setParameter("p_texto1", 		relacionBean.getTexto());
			spq.setParameter("p_texto2", 		relacionBean.getTexto2());
			spq.setParameter("p_nombimag", 		relacionBean.getImagen());
			spq.setParameter("p_orientacion", 	relacionBean.getOrientacion());
			spq.setParameter("p_orden", 		relacionBean.getOrden());
			spq.setParameter("p_tiporelaci", 	relacionBean.getTipoRelacion());
			spq.setParameter("p_codusureg", relacionBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", relacionBean.getIpCreacion()); 
			spq.setParameter("p_texto3", 		relacionBean.getTexto3());
			spq.setParameter("p_parrafo", 		relacionBean.getParrafo());
			spq.execute();
			
			idRelacion = spq.getOutputParameterValue(1);
			if(idRelacion != null)
			{
				relacionBean.setCodigo(Integer.valueOf(idRelacion.toString()));
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
	public boolean actualizar(RelacionBean relacionBean) throws DAOException {
		boolean sw=false;
		System.out.println("RelacionBean actualizar " + relacionBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacion.actualizar");
			
			spq.setParameter("p_codrelaci", relacionBean.getCodigo());
			spq.setParameter("p_codrelcab", relacionBean.getRelacionCabeceraBean().getCodigo());
			spq.setParameter("p_palabra", relacionBean.getPalabra());
			spq.setParameter("p_texto1", relacionBean.getTexto());
			spq.setParameter("p_texto2", relacionBean.getTexto2());
			spq.setParameter("p_nombimag", relacionBean.getImagen());
			spq.setParameter("p_orientacion", relacionBean.getOrientacion());
			spq.setParameter("p_orden", relacionBean.getOrden());
			spq.setParameter("p_tiporelaci", relacionBean.getTipoRelacion());
			spq.setParameter("p_codusumod", relacionBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", relacionBean.getIpModificacion());
			spq.setParameter("p_texto3", relacionBean.getTexto3());
			spq.setParameter("p_parrafo", 		relacionBean.getParrafo());
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
	public boolean eliminar(RelacionBean relacionBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacion.eliminar");
			spq.setParameter("p_codrelaci", relacionBean.getCodigo());
			spq.setParameter("p_codusumod", relacionBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", relacionBean.getIpModificacion());
			spq.execute();
			sw = true;
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public RelacionBean getBuscarPorObjecto(RelacionBean relacionBean) throws DAOException {
		List<LeotbcRelacion> 	lstRelacions 	= null;
		RelacionBean 	bean = null;
		try {
			System.out.println("Ingreso a getBuscarPorObjecto");
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacion.buscar_por_codrelacion");
			
			spq.setParameter("p_codrelaci", 	relacionBean.getCodigo());
			
			if (spq.execute()) 
			{
				lstRelacions =  spq.getResultList(); 
			} 
			if (lstRelacions != null && lstRelacions.size() > 0) 
			{
				bean = deRelacionARelacionBean(lstRelacions.get(0));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}

		return bean;

	}

	@Override
	public List<RelacionBean> getBuscarPorFiltros(RelacionBean relacionBean) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(RelacionBean relacionBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RelacionBean> buscarPorRelacionCabecera(RelacionBean relacionBean) throws DAOException 
	{
		List<LeotbcRelacion> 	lstPregunta 	= null;
		List<RelacionBean> 	lstPreguntaBean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacion.buscar_por_codrelcab");
		spq.setParameter("p_codrelcab", relacionBean.getRelacionCabeceraBean().getCodigo());
		spq.setParameter("p_tipo", relacionBean.getTipo());
		
		if (spq.execute()) 
		{
			lstPregunta =  spq.getResultList(); 
		} 
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{			
			lstPreguntaBean = deListaRelacionAListaRelacionBean(lstPregunta);
		}
		return lstPreguntaBean;
	}
	
	private List<RelacionBean> deListaRelacionAListaRelacionBean(List<LeotbcRelacion> lstPregunta) 
	{
		List<RelacionBean> lstPreguntaBean = null;
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{
			lstPreguntaBean = new ArrayList<RelacionBean>();
			for (int i = 0; i < lstPregunta.size(); i++) 
			{ 
				LeotbcRelacion entity = lstPregunta.get(i);
				RelacionBean bean = deRelacionARelacionBean(entity);
				lstPreguntaBean.add(bean);
			}
		}
		return lstPreguntaBean;
	}
	

	private RelacionBean deRelacionARelacionBean(LeotbcRelacion entity) {
		
		RelacionBean bean = null;
		
		if (entity != null) {
			bean = new RelacionBean();
			bean.setCantletras(entity.getN_cantletr());
			bean.setCodigo(entity.getnCodrelaci());
			bean.setRelacionCabeceraBean(new RelacionCabeceraBean());
			bean.getRelacionCabeceraBean().setCodigo(entity.getnCodrelcab());
			bean.getRelacionCabeceraBean().setTitulo(entity.getV_titulo());
			bean.setPalabra(entity.getvPalabra());
			bean.setTexto(entity.getvTexto1());
			bean.setTexto2(entity.getvTexto2());
			bean.setImagen(entity.getvNombimag());
			bean.setOrientacion(entity.getnOrientacion());
			bean.setOrden(entity.getnOrden());
			bean.setTipoRelacion(entity.getnTiporelaci());
			bean.setTexto3(entity.getVtexto3());
			bean.getRelacionCabeceraBean().setMaterialTipoEjercicioBean(new  MaterialTipoEjercicioBean());
			bean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().setTitulo(entity.getVtituloMatxTipoEje());
			bean.setParrafo(entity.getvParrafo());
			bean.setPalabraSeparada(entity.getV_palabraSeparada());
		}
		return bean;
	}

	@Override
	public List<RelacionBean> listarTextoTexto(RelacionBean relacionBean)throws DAOException {
		List<LeotbcRelacion> 	lstRelacions 	= null;
		List<RelacionBean> 	lstRelacionBeans 	= null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacion.listarTextoTexto");
		spq.setParameter("p_codmatpej", relacionBean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().getCodigo());
		spq.setParameter("p_tipo", relacionBean.getTipo());
		if (spq.execute()) 
		{
			lstRelacions =  spq.getResultList(); 
		} 
		if (lstRelacions != null && lstRelacions.size() > 0) 
		{			
			lstRelacionBeans = deListaRelacionAListaRelacionBean(lstRelacions);
		}
		return lstRelacionBeans;
	}
	
	@Override
	public List<RelacionBean> listarCrucigrama(RelacionBean relacionBean)throws DAOException {
		List<LeotbcRelacion> 	lstRelacions 	= null;
		List<RelacionBean> 	lstRelacionBeans 	= null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacion.listarCrucigrama");
		spq.setParameter("p_codmatpej", relacionBean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().getCodigo());
		
		if (spq.execute()) 
		{
			lstRelacions =  spq.getResultList(); 
		} 
		if (lstRelacions != null && lstRelacions.size() > 0) 
		{			
			lstRelacionBeans = deListaRelacionAListaRelacionBean(lstRelacions);
		}
		return lstRelacionBeans;
	}

	@Override
	public List<RelacionBean> listarTextoTextoImagen(RelacionBean relacionBean) throws DAOException {
		List<LeotbcRelacion> 	lstRelacions 	= null;
		List<RelacionBean> 	lstRelacionBeans 	= null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacion.listarTextoTexto");
		spq.setParameter("p_codmatpej", relacionBean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().getCodigo());
		spq.setParameter("p_tipo", relacionBean.getTipo());
		if (spq.execute()) 
		{
			lstRelacions =  spq.getResultList(); 
		} 
		if (lstRelacions != null && lstRelacions.size() > 0) 
		{			
			lstRelacionBeans = deListaRelacionAListaRelacionBean(lstRelacions);
		}
		return lstRelacionBeans;
	}

	@Override
	public List<RelacionBean> listarRelacionTodo(RelacionBean relacionBean)throws DAOException {
		List<LeotbcRelacion> 	lstRelacions 	= null;
		List<RelacionBean> 	lstRelacionBeans 	= null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacion.listarRelacionTodo");
		spq.setParameter("p_codmatpej", relacionBean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().getCodigo());
		if (spq.execute()) 
		{
			lstRelacions =  spq.getResultList(); 
		} 
		if (lstRelacions != null && lstRelacions.size() > 0) 
		{			
			lstRelacionBeans = deListaRelacionAListaRelacionBean(lstRelacions);
		}
		return lstRelacionBeans;
	}

	@Override
	public List<RelacionBean> listarTextoParrafo(RelacionBean relacionBean) throws DAOException {
		List<LeotbcRelacion> 	lstRelacions 	= null;
		List<RelacionBean> 	lstRelacionBeans 	= null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacion.listarTextoParrafo");
		spq.setParameter("p_codmatpej", relacionBean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().getCodigo());
		spq.setParameter("p_tipo", relacionBean.getTipo());
		if (spq.execute()) 
		{
			lstRelacions =  spq.getResultList(); 
		} 
		if (lstRelacions != null && lstRelacions.size() > 0) 
		{			
			lstRelacionBeans = deListaRelacionAListaRelacionBean(lstRelacions);
		}
		return lstRelacionBeans;
	}
	
}