package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcPregunta;
//import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdEjercicio;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdMatejercicio;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.MaterialEjercicioDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.PreguntaDAO;

@Transactional
@Repository("materialEjercicioDAO")
public class MaterialEjercicioDAOImpl implements MaterialEjercicioDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(MaterialEjercicioBean materialEjercicioBean) throws DAOException {
		Object idMaterialEjercicio = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdmatejercicio.insertar");
			spq.setParameter("p_codmatpej", materialEjercicioBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_tituloeje", materialEjercicioBean.getTitulo());
			spq.setParameter("p_desejerci", materialEjercicioBean.getDescripcion());
			spq.setParameter("p_tm1siteje", materialEjercicioBean.getSituacionEjercicio().getCodigo());
			spq.setParameter("p_codusureg", materialEjercicioBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", materialEjercicioBean.getIpCreacion()); 
			
			
			spq.execute();
			
			idMaterialEjercicio = spq.getOutputParameterValue(1);
			if(idMaterialEjercicio != null)
			{
				materialEjercicioBean.setCodigo(Integer.valueOf(idMaterialEjercicio.toString()));
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
	public boolean actualizar(MaterialEjercicioBean materialEjercicioBean) throws DAOException {
		boolean sw=false;

		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdmatejercicio.actualizar");
			spq.setParameter("p_codejerci", materialEjercicioBean.getCodigo());
			spq.setParameter("p_codmatpej", materialEjercicioBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_tituloeje", materialEjercicioBean.getTitulo());
			spq.setParameter("p_desejerci", materialEjercicioBean.getDescripcion());
			spq.setParameter("p_tm1siteje", materialEjercicioBean.getSituacionEjercicio().getCodigo());
			spq.setParameter("p_codusumod", materialEjercicioBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", materialEjercicioBean.getIpModificacion()); 
			
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
	public boolean eliminar(MaterialEjercicioBean materialEjercicioBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdmatejercicio.eliminar");
			spq.setParameter("p_codejerci", materialEjercicioBean.getCodigo());
			spq.setParameter("p_codusumod", materialEjercicioBean.getAudCodigoUsuario());
			spq.setParameter("p_hostmod", materialEjercicioBean.getAudHostIP());
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
	public MaterialEjercicioBean getBuscarPorObjecto(MaterialEjercicioBean materialEjercicioBean) throws DAOException {
		List<LeotbdMatejercicio> 	lstMaterialEjercicio 	= null;
		MaterialEjercicioBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdmatejercicio.buscar_por_codigo");
		spq.setParameter("p_codejerci", materialEjercicioBean.getCodigo());
		
		if (spq.execute()) 
		{
			lstMaterialEjercicio =  spq.getResultList(); 
		} 
		if (lstMaterialEjercicio != null && lstMaterialEjercicio.size() > 0) 
		{
			bean = deMaterialEjercicioAMaterialEjercicioBean(lstMaterialEjercicio.get(0));
		}
		return bean;	
	}

	@Override
	public List<MaterialEjercicioBean> getBuscarPorFiltros(MaterialEjercicioBean materialEjercicioBean) throws DAOException {
		List<LeotbdMatejercicio> 	lstMaterialEjercicio 	= null;
		List<MaterialEjercicioBean> 	lstMaterialEjercicioBean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdmatejercicio.buscar_por_filtros");
		spq.setParameter("p_codmatpej", 	materialEjercicioBean.getMaterialTipoEjercicioBean().getCodigo());
		spq.setParameter("p_tituloeje", 	materialEjercicioBean.getTitulo());
		spq.setParameter("p_desejerci", 	materialEjercicioBean.getDescripcion());
		spq.setParameter("p_tm1siteje", 	materialEjercicioBean.getSituacionEjercicio().getCodigo());
		
		
		if (spq.execute()) {
			lstMaterialEjercicio =  spq.getResultList(); 
		} 
		if (lstMaterialEjercicio != null && lstMaterialEjercicio.size() > 0) {
			
			lstMaterialEjercicioBean = deListaMaterialEjercicioAListaMaterialEjercicioBean(lstMaterialEjercicio);
		}
		
		return lstMaterialEjercicioBean;
	}

	@Override
	public boolean existe(MaterialEjercicioBean materialEjercicioBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private List<MaterialEjercicioBean> deListaMaterialEjercicioAListaMaterialEjercicioBean(List<LeotbdMatejercicio> lstMaterialEjercicio) {
		
		
		List<MaterialEjercicioBean> lstMaterialEjercicioBean = null;
	
		if (lstMaterialEjercicio != null && lstMaterialEjercicio.size() > 0) {
			
			lstMaterialEjercicioBean = new ArrayList<MaterialEjercicioBean>();
			
			for (int i = 0; i < lstMaterialEjercicio.size(); i++) { 
				LeotbdMatejercicio entity = lstMaterialEjercicio.get(i);
				MaterialEjercicioBean bean = deMaterialEjercicioAMaterialEjercicioBean(entity);
				
				lstMaterialEjercicioBean.add(bean);
			}
		}
		
		return lstMaterialEjercicioBean;
	}
	
	private MaterialEjercicioBean deMaterialEjercicioAMaterialEjercicioBean(LeotbdMatejercicio entity) {
		
		MaterialEjercicioBean bean = null;
		
		if (entity != null) {
			
			bean = new MaterialEjercicioBean();
			
			bean.setCodigo(entity.getNCodejerci());
			bean.setTitulo(entity.getVTituloeje());
			bean.setDescripcion(entity.getVDesejerci());
			
			bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
			bean.getMaterialTipoEjercicioBean().setCodigo(entity.getNCodmatpej());
			
			bean.setSituacionEjercicio(new MaestraBean());
			bean.getSituacionEjercicio().setCodigo(entity.getNTm1siteje());
		
		}
		
		return bean;
	}
	
}
