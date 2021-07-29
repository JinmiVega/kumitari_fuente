package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

 

import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionCompletarBean; 
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcOracionCompletar;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException; 
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.OracionCompletarDAO;

@Transactional
@Repository("oracionCompletarDAO")
public class OracionCompletarDAOImpl implements OracionCompletarDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(OracionCompletarBean oracionCompletarBean) throws DAOException {
		Object idOracion = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcoracioncompletar.insertar");
			spq.setParameter("p_codmatpej", oracionCompletarBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_titulo", oracionCompletarBean.getTitulo());
			spq.setParameter("p_oracion", oracionCompletarBean.getOracion()); 
			spq.setParameter("p_codusureg", oracionCompletarBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", oracionCompletarBean.getIpCreacion()); 
			
			spq.execute();
			
			idOracion = spq.getOutputParameterValue(1);
			if(idOracion != null)
			{
				oracionCompletarBean.setCodigo(Integer.valueOf(idOracion.toString()));
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
	public boolean actualizar(OracionCompletarBean oracionCompletarBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcoracioncompletar.actualizar");
			spq.setParameter("p_codcomporacion", oracionCompletarBean.getCodigo());
			spq.setParameter("p_codmatpej", oracionCompletarBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_titulo", oracionCompletarBean.getTitulo());
			spq.setParameter("p_oracion", oracionCompletarBean.getOracion()); 
			spq.setParameter("p_codusumod", oracionCompletarBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", oracionCompletarBean.getIpModificacion()); 
			
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
	public boolean eliminar(OracionCompletarBean oracionCompletarBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcoracioncompletar.eliminar");
			spq.setParameter("p_codcomporacion", oracionCompletarBean.getCodigo());
			spq.setParameter("p_codusumod", oracionCompletarBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", oracionCompletarBean.getIpModificacion()); 
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
	public OracionCompletarBean getBuscarPorObjecto(OracionCompletarBean oracionCompletarBean) throws DAOException {
		List<LeotbcOracionCompletar> 	lstOracion 	= null;
		OracionCompletarBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcoracioncompletar.buscar_por_codigo");
		spq.setParameter("p_codcomporacion", 	oracionCompletarBean.getCodigo());
		
		if (spq.execute()) 
		{
			lstOracion =  spq.getResultList(); 
		} 
		if (lstOracion != null && lstOracion.size() > 0) 
		{
			bean = deOracionAOracionBean(lstOracion.get(0));
		}
		return bean;

	}

	@Override
	public OracionCompletarBean getBuscarPorTEM(OracionCompletarBean oracionCompletarBean) throws DAOException {
		List<LeotbcOracionCompletar> 	lstOracion 	= null;
		 OracionCompletarBean  	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcoracioncompletar.buscar_por_Filtros");
		spq.setParameter("p_codmatpej", 	oracionCompletarBean.getMaterialTipoEjercicioBean().getCodigo());
		 
		
		if (spq.execute()) {
			lstOracion =  spq.getResultList(); 
		} 
		if (lstOracion != null && lstOracion.size() > 0) {			
			bean = deOracionAOracionBean(lstOracion.get(0));
		}
		
		return bean;
	}

	@Override
	public boolean existe(OracionCompletarBean oracionCompletarBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private List<OracionCompletarBean> deListaOracionAListaOracionBean(List<LeotbcOracionCompletar> lstOracion) {
		
		List<OracionCompletarBean> lstOracionBean = null;
	
		if (lstOracion != null && lstOracion.size() > 0) {
			
			lstOracionBean = new ArrayList<OracionCompletarBean>();
			
			for (int i = 0; i < lstOracion.size(); i++) { 
				LeotbcOracionCompletar entity = lstOracion.get(i);
				OracionCompletarBean bean = deOracionAOracionBean(entity);
				
				lstOracionBean.add(bean);
			}
		}
		
		return lstOracionBean;
	}
	

	private OracionCompletarBean deOracionAOracionBean(LeotbcOracionCompletar entity) {
		
		OracionCompletarBean bean = null;
		
		if (entity != null) {
			bean = new OracionCompletarBean();
			bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
			bean.setCodigo(entity.getnCodcomporacion());
			bean.getMaterialTipoEjercicioBean().setCodigo(entity.getnCodmatpej());
			bean.setTitulo(entity.getvTitulo());
			bean.setOracion(entity.getvOracion()); 
 
		}
		return bean;
	} 
	 

	 

 

	@Override
	public List<OracionCompletarBean> buscarPorMaterialEjercicio(
			MaterialEjercicioBean materialEjercicioBean) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OracionCompletarBean> getBuscarPorFiltros(OracionCompletarBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

 
	 
	
}