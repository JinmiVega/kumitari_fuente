package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionSedeBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcPregunta;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdInstSede;
//import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdEjercicio;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.PreguntaDAO;

@Transactional
@Repository("preguntaDAO")
public class PreguntaDAOImpl implements PreguntaDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(PreguntaBean preguntaBean) throws DAOException {
		Object idPregunta = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpregunta.insertar");
			spq.setParameter("p_despregunta", preguntaBean.getDescripcion());
			spq.setParameter("p_codmatpej", preguntaBean.getMaterialEjercicioBean().getCodigo()); 
			spq.setParameter("p_codusureg", preguntaBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", preguntaBean.getIpCreacion()); 
			spq.setParameter("p_tippregunta", preguntaBean.getTipoPregunta());
			
			
			spq.execute();
			
			idPregunta = spq.getOutputParameterValue(1);
			if(idPregunta != null)
			{
				preguntaBean.setCodigo(Integer.valueOf(idPregunta.toString()));
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
	public boolean actualizar(PreguntaBean preguntaBean) throws DAOException {
		boolean sw=false;
		System.out.println("PreguntaBean actualizar " + preguntaBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpregunta.actualizar");
			spq.setParameter("p_codpregun", preguntaBean.getCodigo());
			spq.setParameter("p_despregunta", preguntaBean.getDescripcion());
			spq.setParameter("p_codmatpej", preguntaBean.getMaterialEjercicioBean().getCodigo());
		 
			spq.setParameter("p_codusumod", preguntaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", preguntaBean.getIpModificacion());  
			spq.setParameter("p_tippregunta", preguntaBean.getTipoPregunta()); 
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
	public boolean eliminar(PreguntaBean preguntaBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em
					.createNamedStoredProcedureQuery("leotbcpregunta.eliminar");
			spq.setParameter("p_codpregun", preguntaBean.getCodigo());
//			spq.setParameter("p_codejerci", preguntaBean.getEjercicioBean().getCodigo());
			spq.setParameter("p_codusumod", preguntaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", preguntaBean.getIpModificacion()); 
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
	public PreguntaBean getBuscarPorObjecto(PreguntaBean preguntaBean) throws DAOException {
		List<LeotbcPregunta> 	lstPregunta 	= null;
		PreguntaBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpregunta.buscar_por_codpregunta");
		spq.setParameter("p_codpregun", 	preguntaBean.getCodigo());
		
		if (spq.execute()) 
		{
			lstPregunta =  spq.getResultList(); 
		} 
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{
			bean = dePreguntaAPreguntaBean(lstPregunta.get(0));
		}
		return bean;
	}

	@Override
	public List<PreguntaBean> getBuscarPorFiltros(PreguntaBean preguntaBean) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(PreguntaBean preguntaBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<PreguntaBean> buscarPorEjercicio(EjercicioBean ejercicioBean) throws DAOException {
//		List<LeotbcPregunta> 	lstPregunta 	= null;
//		List<PreguntaBean> 	lstPreguntaBean = null;
//		
//		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpregunta.buscar_por_ejercicio");
//		spq.setParameter("p_codejerci", 	ejercicioBean.getCodigo());
//		
//		if (spq.execute()) {
//			lstPregunta =  spq.getResultList(); 
//		} 
//		if (lstPregunta != null && lstPregunta.size() > 0) {
//			
//			lstPreguntaBean = deListaPreguntaAListaPreguntaBean(lstPregunta);
//		}
//		
//		return lstPreguntaBean;
//	}
	
	private List<PreguntaBean> deListaPreguntaAListaPreguntaBean(List<LeotbcPregunta> lstPregunta) {
		List<PreguntaBean> lstPreguntaBean = null;
		if (lstPregunta != null && lstPregunta.size() > 0) {
			lstPreguntaBean = new ArrayList<PreguntaBean>();	
			for (int i = 0; i < lstPregunta.size(); i++) { 
				LeotbcPregunta entity = lstPregunta.get(i);
				PreguntaBean bean = dePreguntaAPreguntaBean(entity);		
				lstPreguntaBean.add(bean);
			}
		}	
		return lstPreguntaBean;
	}
	
	private PreguntaBean dePreguntaAPreguntaBean(LeotbcPregunta entity) {	
		PreguntaBean bean = null;	
		if (entity != null) {	
			bean = new PreguntaBean();	
			bean.setCodigo(entity.getnCodpregun());
			bean.setDescripcion(entity.getvDescpregunta());
//			bean.getEjercicioBean().setCodigo(entity.getnCodejercici());
			bean.setTipoPregunta(entity.getnTippregunta());
		}
		return bean;
	}

	@Override
	public List<PreguntaBean> buscarPorMatTEjerPregunta(PreguntaBean preguntaBean) throws DAOException {
		List<LeotbcPregunta> 	lstPregunta 	= null;
		List<PreguntaBean> 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpregunta.buscar_matxejer_pregunta_buscar_x_filtros");
		spq.setParameter("p_codlesmat", 	preguntaBean.getMaterialEjercicioBean().getLeccionMaterialBean().getCodigo());
		spq.setParameter("p_tm2tpejer", 	preguntaBean.getMaterialEjercicioBean().getTipoEjercicio().getCodigoRegistro());
		if (spq.execute()) {
			lstPregunta =  spq.getResultList(); 
		} 
		if (lstPregunta != null && lstPregunta.size() > 0) {
			bean = deListaMatTEjerPreguntaAListaPreguntaBean(lstPregunta);
		} else{
			bean = new ArrayList<PreguntaBean>();
		}
		return bean;
		
	}
	
	
	
	private List<PreguntaBean> deListaMatTEjerPreguntaAListaPreguntaBean(List<LeotbcPregunta> lstPregunta) {
		List<PreguntaBean> lstPreguntaBean = null;
		if (lstPregunta != null && lstPregunta.size() > 0) {
			lstPreguntaBean = new ArrayList<PreguntaBean>();	
			for (int i = 0; i < lstPregunta.size(); i++) { 
				LeotbcPregunta entity = lstPregunta.get(i);
				PreguntaBean bean = deMatTEjerPreguntaAPreguntaBean(entity);		
				lstPreguntaBean.add(bean);
			}
		}	
		return lstPreguntaBean;
	}
	
	private PreguntaBean deMatTEjerPreguntaAPreguntaBean(LeotbcPregunta entity) {	
		PreguntaBean bean = null;	
		if (entity != null) {	
			bean = new PreguntaBean();	
			bean.getMaterialEjercicioBean().setCodigo(entity.getnCodmatpej());
			//bean.getMaterialEjercicioBean().setTitulo(entity.getV_titulo());
			bean.setCodigo(entity.getnCodpregun());
			bean.setDescripcion(entity.getvDescpregunta());
		}
		return bean;
	}

	@Override
	public List<PreguntaBean> buscarPregunta(PreguntaBean preguntaBean) throws DAOException {
		List<LeotbcPregunta> 	lstPregunta 	= null;
		List<PreguntaBean> 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcpregunta.buscar_pregunta_buscar_x_filtros");
		spq.setParameter("p_codmatpej", 	preguntaBean.getMaterialEjercicioBean().getCodigo());

		if (spq.execute()) {
			lstPregunta =  spq.getResultList(); 
		} 
		if (lstPregunta != null && lstPregunta.size() > 0) {
			bean = deListaMatTEjerPreguntaAListaPreguntaBean(lstPregunta);
		} else{
			bean = new ArrayList<PreguntaBean>();
		}
		return bean;
		
	}
	
//	private MaestraBean deTablaATablaBean(int codigoRegistro, String nombreCorto)
//	{
//		MaestraBean bean = new MaestraBean();
//		
//		bean.setCodigoRegistro(codigoRegistro);
//		
//		if (!nombreCorto.equals(null)) {
//			bean.setNombreCorto(nombreCorto);
//		}
//		
//		return bean;
//	}

}
