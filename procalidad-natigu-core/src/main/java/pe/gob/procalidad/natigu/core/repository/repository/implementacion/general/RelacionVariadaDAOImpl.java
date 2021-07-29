package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraDetBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean; 
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionVariadaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionCabeceraBean;  
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdArrastraOraDet;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdRelacionVariada;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException; 
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.RelacionVariadaDAO;

@Transactional
@Repository("relacionVariadaDAO")
public class RelacionVariadaDAOImpl implements RelacionVariadaDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(RelacionVariadaBean relacionVariadaBean) throws DAOException {
		Object idRelacion = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdrelacion.insertar");
			spq.setParameter("p_codrelcab", 	relacionVariadaBean.getRelacionCabeceraBean().getCodigo()); 
			spq.setParameter("p_texto1", 		relacionVariadaBean.getTexto());
			spq.setParameter("p_texto2", 		relacionVariadaBean.getTexto2());
			spq.setParameter("p_nombimag", 		relacionVariadaBean.getImagen()); 
//			spq.setParameter("p_orden", 		relacionVariadaBean.getOrden());
			spq.setParameter("p_tiporelaci", 	relacionVariadaBean.getTipoRelacion());
			spq.setParameter("p_codusureg", 	relacionVariadaBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", 		relacionVariadaBean.getIpCreacion()); 
			
			spq.execute();
			
			idRelacion = spq.getOutputParameterValue(1);
			if(idRelacion != null)
			{
				relacionVariadaBean.setCodigo(Integer.valueOf(idRelacion.toString()));
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
	public boolean actualizar(RelacionVariadaBean relacionVariadaBean) throws DAOException {
		boolean sw=false;
		System.out.println("RelacionVariadaBean actualizar " + relacionVariadaBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdrelacion.actualizar");
			
			spq.setParameter("p_codrelaci", relacionVariadaBean.getCodigo());
			spq.setParameter("p_codrelcab", relacionVariadaBean.getRelacionCabeceraBean().getCodigo()); 
			spq.setParameter("p_texto1", relacionVariadaBean.getTexto());
			spq.setParameter("p_texto2", relacionVariadaBean.getTexto2());
			spq.setParameter("p_nombimag", relacionVariadaBean.getImagen());  
			spq.setParameter("p_tiporelaci", relacionVariadaBean.getTipoRelacion());
			spq.setParameter("p_codusumod", relacionVariadaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", relacionVariadaBean.getIpModificacion()); 
			
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
	public boolean eliminar(RelacionVariadaBean relacionVariadaBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdrelacion.eliminar");
			spq.setParameter("p_codrelaci", relacionVariadaBean.getCodigo());
			spq.setParameter("p_codusumod", relacionVariadaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", relacionVariadaBean.getIpModificacion());
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
	public List<RelacionVariadaBean> getBuscarTodoxMTE(
			RelacionVariadaBean  Bean) throws DAOException {
		List<LeotbdRelacionVariada> lstLeotbc = null;
		List<RelacionVariadaBean> lstBean = null;  
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdrelacion.buscar_TodoxTEM");
		
		spq.setParameter("p_codmatpej", 	Bean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().getCodigo());
		 
		if (spq.execute()) {
			
			lstLeotbc = spq.getResultList();
		}
		if (lstLeotbc != null && lstLeotbc.size() > 0) {
			
			lstBean = deListaRelacionAListaRelacionVariadaBean(lstLeotbc);
		}
		
		return lstBean;
	}
	

	@Override
	public RelacionVariadaBean getBuscarPorObjecto(RelacionVariadaBean relacionVariadaBean) throws DAOException {
		List<LeotbdRelacionVariada> 	lstRelacions 	= null;
		RelacionVariadaBean 	bean = null;
		try {
			System.out.println("Ingreso a getBuscarPorObjecto");
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdrelacion.buscar_por_codrelacion");
			
			spq.setParameter("p_codrelaci", 	relacionVariadaBean.getCodigo());
			
			if (spq.execute()) 
			{
				lstRelacions =  spq.getResultList(); 
			} 
			if (lstRelacions != null && lstRelacions.size() > 0) 
			{
				bean = deRelacionARelacionVariadaBean(lstRelacions.get(0));
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
	public List<RelacionVariadaBean> getBuscarPorFiltros(RelacionVariadaBean relacionVariadaBean) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(RelacionVariadaBean relacionVariadaBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RelacionVariadaBean> buscarPorRelacionCabecera(RelacionVariadaBean relacionVariadaBean) throws DAOException 
	{
		List<LeotbdRelacionVariada> 	lstPregunta 	= null;
		List<RelacionVariadaBean> 	lstPreguntaBean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdrelacion.buscar_por_codrelcab");
		spq.setParameter("p_codrelcab", relacionVariadaBean.getRelacionCabeceraBean().getCodigo());
		
		if (spq.execute()) 
		{
			lstPregunta =  spq.getResultList(); 
		} 
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{			
			lstPreguntaBean = deListaRelacionAListaRelacionVariadaBean(lstPregunta);
		}
		return lstPreguntaBean;
	}
	
	private List<RelacionVariadaBean> deListaRelacionAListaRelacionVariadaBean(List<LeotbdRelacionVariada> lstPregunta) 
	{
		List<RelacionVariadaBean> lstPreguntaBean = null;
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{
			lstPreguntaBean = new ArrayList<RelacionVariadaBean>();
			for (int i = 0; i < lstPregunta.size(); i++) 
			{ 
				LeotbdRelacionVariada entity = lstPregunta.get(i);
				RelacionVariadaBean bean = deRelacionARelacionVariadaBean(entity);
				lstPreguntaBean.add(bean);
			}
		}
		return lstPreguntaBean;
	}
	

	private RelacionVariadaBean deRelacionARelacionVariadaBean(LeotbdRelacionVariada entity) {
		
		RelacionVariadaBean bean = null;
		
		if (entity != null) {
			bean = new RelacionVariadaBean();
			
			bean.setCodigo(entity.getnCodrelaci());
			bean.setRelacionCabeceraBean(new RelacionCabeceraBean());
			bean.getRelacionCabeceraBean().setCodigo(entity.getnCodrelcab()); 
			bean.setTexto(entity.getvTexto1());
			bean.setTexto2(entity.getvTexto2());
			bean.setImagen(entity.getvNombimag()); 
			bean.setOrden(entity.getnOrden());
			bean.setTipoRelacion(entity.getnTiporelaci()); 
			
			
			
			bean.getRelacionCabeceraBean().setTitulo(entity.getV_titulocab()); 
			
			bean.getRelacionCabeceraBean().setMaterialTipoEjercicioBean(new  MaterialTipoEjercicioBean());
			
			bean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().setTitulo(entity.getV_tituloTipo());
			if(entity.getN_codmatpej()!=null){
			bean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().setCodigo(entity.getN_codmatpej());
			}
			
			
		}
		return bean;
	}

 

	 
	
}