package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraciBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionCabeceraBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcArrastraOraci;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcPregunta;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcRelacion;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcRelacionCab;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.RelacionCabeceraDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.RelacionDAO;

@Transactional
@Repository("relacionCabeceraDAO")
public class RelacionCabeceraDAOImpl implements RelacionCabeceraDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(RelacionCabeceraBean relacionCabeceraBean) throws DAOException {
		Object idRelacionCcabecera = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacioncab.insertar");
			spq.setParameter("p_codmatpej", relacionCabeceraBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_titulo", relacionCabeceraBean.getTitulo());
			spq.setParameter("p_codusureg", relacionCabeceraBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", relacionCabeceraBean.getIpCreacion());
			
			spq.execute();
			
			idRelacionCcabecera = spq.getOutputParameterValue(1);
			if(idRelacionCcabecera != null)
			{
				relacionCabeceraBean.setCodigo(Integer.valueOf(idRelacionCcabecera.toString()));
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
	public boolean actualizar(RelacionCabeceraBean relacionCabeceraBean) throws DAOException {
		boolean sw=false;
		System.out.println("RelacionCabeceraBean actualizar " + relacionCabeceraBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacioncab.actualizar");
			spq.setParameter("p_codrelcab", relacionCabeceraBean.getCodigo());
			spq.setParameter("p_titulo", relacionCabeceraBean.getTitulo());
			spq.setParameter("p_codusumod", relacionCabeceraBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", relacionCabeceraBean.getIpModificacion());
			
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
	public boolean eliminar(RelacionCabeceraBean relacionCabeceraBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacioncab.eliminar");
			spq.setParameter("p_codrelcab", relacionCabeceraBean.getCodigo());
			spq.setParameter("p_codusumod", relacionCabeceraBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", relacionCabeceraBean.getIpModificacion());
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
	public RelacionCabeceraBean getBuscarPorObjecto(RelacionCabeceraBean relacionCabeceraBean) throws DAOException {
		List<LeotbcRelacionCab> 	lstPregunta 	= null;
		RelacionCabeceraBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacioncab.buscar_por_codrelacion");
		spq.setParameter("p_codrelacion", 	relacionCabeceraBean.getCodigo());
		
		if (spq.execute()) 
		{
			lstPregunta =  spq.getResultList(); 
		} 
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{
			bean = deRelacionCabeceraARelacionCabeceraBean(lstPregunta.get(0));
		}
		return bean;

	}

	@Override
	public List<RelacionCabeceraBean> getBuscarPorFiltros(RelacionCabeceraBean relacionCabeceraBean) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(RelacionCabeceraBean relacionCabeceraBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RelacionCabeceraBean> buscarPorEjercicio(RelacionCabeceraBean relacionCabeceraBean) throws DAOException 
	{
		List<LeotbcRelacionCab> 	lstPregunta 	= null;
		List<RelacionCabeceraBean> 	lstPreguntaBean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacioncab.buscar_por_ejercicio");
		spq.setParameter("p_codmatpej", relacionCabeceraBean.getMaterialTipoEjercicioBean().getCodigo());
		
		if (spq.execute()) 
		{
			lstPregunta =  spq.getResultList(); 
		} 
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{			
			lstPreguntaBean = deListaRelacionCabeceraAListaRelacionCabeceraBean(lstPregunta);
		}
		return lstPreguntaBean;
	}
	
	
	@Override
	public RelacionCabeceraBean getBuscarPorTEM(RelacionCabeceraBean beBean) throws DAOException {
		List<LeotbcRelacionCab> 	lstOracion 	= null;
		RelacionCabeceraBean  	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacioncab.buscar_por_ejercicio");
		spq.setParameter("p_codmatpej", 	beBean.getMaterialTipoEjercicioBean().getCodigo());
		 
		
		if (spq.execute()) {
			lstOracion =  spq.getResultList(); 
		} 
		if (lstOracion != null && lstOracion.size() > 0) {			
			bean = deRelacionCabeceraARelacionCabeceraBean(lstOracion.get(0));
		}
		
		return bean;
	}
	
	
	
	private List<RelacionCabeceraBean> deListaRelacionCabeceraAListaRelacionCabeceraBean(List<LeotbcRelacionCab> lstPregunta) 
	{
		List<RelacionCabeceraBean> lstPreguntaBean = null;
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{
			lstPreguntaBean = new ArrayList<RelacionCabeceraBean>();
			for (int i = 0; i < lstPregunta.size(); i++) 
			{ 
				LeotbcRelacionCab entity = lstPregunta.get(i);
				RelacionCabeceraBean bean = deRelacionCabeceraARelacionCabeceraBean(entity);
				lstPreguntaBean.add(bean);
			}
		}
		return lstPreguntaBean;
	}
	

	private RelacionCabeceraBean deRelacionCabeceraARelacionCabeceraBean(LeotbcRelacionCab entity) 
	{
		RelacionCabeceraBean bean = null;
		
		if (entity != null) {
			bean = new RelacionCabeceraBean();
			bean.setCodigo(entity.getnCodrelaci());
			bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
			bean.getMaterialTipoEjercicioBean().setCodigo(entity.getnCodmatpej());
			bean.setTitulo(entity.getvTitulo());
		}
		return bean;
	}

	@Override
	public List<RelacionCabeceraBean> buscarPorMatTEjerRelacionCab(RelacionCabeceraBean relacionCabeceraBean)
			throws DAOException {
		List<LeotbcRelacionCab> 	lstRelacionCab 	= null;
		List<RelacionCabeceraBean> 	lstRelacionCabBean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcrelacioncab.buscar_matxejer_relacioncab_buscar");
		spq.setParameter("p_codlesmat", 	relacionCabeceraBean.getMaterialTipoEjercicioBean().getLeccionMaterialBean().getCodigo());
		spq.setParameter("p_tm2tpejer", 	relacionCabeceraBean.getMaterialTipoEjercicioBean().getCodigo());
		
		if (spq.execute()) 
		{
			lstRelacionCab =  spq.getResultList(); 
		} 
		if (lstRelacionCab != null && lstRelacionCab.size() > 0) 
		{			
			lstRelacionCabBean = deListaMatTEjerRelacionCabeceraAListaRelacionCabeceraBean(lstRelacionCab);
		}
		return lstRelacionCabBean;
	}
	
	private List<RelacionCabeceraBean> deListaMatTEjerRelacionCabeceraAListaRelacionCabeceraBean(List<LeotbcRelacionCab> lstPregunta) 
	{
		List<RelacionCabeceraBean> lstPreguntaBean = null;
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{
			lstPreguntaBean = new ArrayList<RelacionCabeceraBean>();
			for (int i = 0; i < lstPregunta.size(); i++) 
			{ 
				LeotbcRelacionCab entity = lstPregunta.get(i);
				RelacionCabeceraBean bean = deMatTEjerRelacionCabeceraARelacionCabeceraBean(entity);
				lstPreguntaBean.add(bean);
			}
		}
		return lstPreguntaBean;
	}
	

	private RelacionCabeceraBean deMatTEjerRelacionCabeceraARelacionCabeceraBean(LeotbcRelacionCab entity) 
	{
		RelacionCabeceraBean bean = null;
		
		if (entity != null) {
			bean = new RelacionCabeceraBean();
			bean.getMaterialTipoEjercicioBean().setCodigo(entity.getnCodmatpej());
			bean.getMaterialTipoEjercicioBean().setTitulo(entity.getV_destmat());
			bean.setCodigo(entity.getnCodrelaci());
			bean.setTitulo(entity.getvTitulo());
		}
		return bean;
	}
	
}