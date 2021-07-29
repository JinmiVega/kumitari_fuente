package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionAlterBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionCompletarBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcMaterialTipoEje;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcPregunta;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdOracionAlter;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.OracionAlterDAO;;

@Transactional
@Repository("oracionAlterDAO")
public class OracionAlterDAOImpl implements OracionAlterDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(OracionAlterBean Bean) throws DAOException 
	{
		Object idAlter = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdOracionAlter.insertar");
			spq.setParameter("p_codcomporacion", Bean.getOracionCompletarBean().getCodigo());
			spq.setParameter("p_numespacio", Bean.getEspacio());
			spq.setParameter("p_alternativa", Bean.getDescripcion());
			spq.setParameter("p_rptaestado", Bean.getRespuestaEstado());
			spq.setParameter("p_codusureg", Bean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", Bean.getIpCreacion()); 
			
			spq.execute();
			
			idAlter = spq.getOutputParameterValue(1);
			if(idAlter != null)
			{
				Bean.setCodigo(Integer.valueOf(idAlter.toString()));
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
	public boolean actualizar(OracionAlterBean Bean) throws DAOException {
		boolean sw = false;
		System.out.println("RespuestaBean actualizar " + Bean);
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdOracionAlter.actualizar");
			spq.setParameter("p_codaltern", Bean.getCodigo());
			spq.setParameter("p_numespacio", Bean.getEspacio());
			spq.setParameter("p_alternativa", Bean.getDescripcion());
			spq.setParameter("p_rptaestado", Bean.getRespuestaEstado()); 
			spq.setParameter("p_codusumod", Bean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", Bean.getIpModificacion()); 

			spq.execute();
			sw = true;

		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		} finally {
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(OracionAlterBean alternativaBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdOracionAlter.eliminar");
			spq.setParameter("p_codcomporacion", alternativaBean.getOracionCompletarBean().getCodigo());
			spq.setParameter("p_numespacio", alternativaBean.getEspacio());
			spq.setParameter("p_codusumod", alternativaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", alternativaBean.getIpModificacion()); 
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
	public OracionAlterBean getBuscarPorObjecto(OracionAlterBean alternativaBean) throws DAOException {
		List<LeotbdOracionAlter> 	lstAlternativa 	= null;
		OracionAlterBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdOracionAlter.buscar_x_Oracion");
		spq.setParameter("p_codcomporacion", 	alternativaBean.getOracionCompletarBean().getCodigo());
		
		if (spq.execute()) 
		{
			lstAlternativa =  spq.getResultList(); 
		} 
		if (lstAlternativa != null && lstAlternativa.size() > 0) 
		{
			bean = deAlternativaAAlternativaBean(lstAlternativa.get(0));
		}
		return bean;
	}
	
	
	
	@Override
	public List<OracionAlterBean> getBuscarPorOracion(
			OracionAlterBean  Bean) throws DAOException {
		List<LeotbdOracionAlter> lstLeotbc = null;
		List<OracionAlterBean> lstBean = null;
		
		System.out.println("---- getBuscarPorFiltros ---");
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdOracionAlter.buscar_x_Oracion");
		
		spq.setParameter("p_codcomporacion", 	Bean.getOracionCompletarBean().getCodigo());
		 
		if (spq.execute()) {
			
			lstLeotbc = spq.getResultList();
		}
		if (lstLeotbc != null && lstLeotbc.size() > 0) {
			
			lstBean = deListaAlternativaAListaAlternativaBean(lstLeotbc);
		}
		
		return lstBean;
	}
	
	
	
	@Override
	public List<OracionAlterBean> getBuscarTodoxMTE(
			OracionAlterBean  Bean) throws DAOException {
		List<LeotbdOracionAlter> lstLeotbc = null;
		List<OracionAlterBean> lstBean = null; 
		System.out.println("---- getBuscarPorFiltros ---");
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdOracionAlter.listar_todo");
		
		spq.setParameter("p_codmatpej", 	Bean.getOracionCompletarBean().getMaterialTipoEjercicioBean().getCodigo());
		 
		if (spq.execute()) {
			
			lstLeotbc = spq.getResultList();
		}
		if (lstLeotbc != null && lstLeotbc.size() > 0) {
			
			lstBean = deListaAlternativaAListaAlternativaBean(lstLeotbc);
		}
		
		return lstBean;
	}
	
	

	@Override
	public List<OracionAlterBean> getBuscarPorFiltros(OracionAlterBean alternativaBean) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(OracionAlterBean alternativaBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OracionAlterBean> buscarEspacioOracion(OracionAlterBean oracionAlterBean) throws DAOException {
		List<OracionAlterBean> 	lstBean = null;
		List<LeotbdOracionAlter> lstEntity = null;
		try 
		{																   
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdOracionAlter.buscar_x_ora_esp");
			spq.setParameter("p_codcomporacion", oracionAlterBean.getOracionCompletarBean().getCodigo());
			spq.setParameter("p_numespacio", oracionAlterBean.getEspacio());
			if (spq.execute()) 
			{
				lstEntity = spq.getResultList();
			}
			if (lstEntity != null && lstEntity.size() > 0) 
			{
				lstBean = deListaAlternativaAListaAlternativaBean(lstEntity);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return lstBean;
	}
	
	private List<OracionAlterBean> deListaAlternativaAListaAlternativaBean(List<LeotbdOracionAlter> lstAlternativa) {
		
		List<OracionAlterBean> lstAlternativaBean = null; 
		if (lstAlternativa != null && lstAlternativa.size() > 0) 
		{
			lstAlternativaBean = new ArrayList<OracionAlterBean>(); 
			for (int i = 0; i < lstAlternativa.size(); i++) 
			{ 
				LeotbdOracionAlter entity = lstAlternativa.get(i);
				OracionAlterBean bean = deAlternativaAAlternativaBean(entity);
				
				lstAlternativaBean.add(bean);
			}
		}
		return lstAlternativaBean;
	}
	
	private OracionAlterBean deAlternativaAAlternativaBean(LeotbdOracionAlter entity) 
	{
		OracionAlterBean bean = null;
		
		if (entity != null) 
		{  
			bean = new OracionAlterBean();
			bean.setOracionCompletarBean(new  OracionCompletarBean()); 
			
			bean.setCodigo(entity.getnCodaltern());
			bean.setEstado(entity.getvFlgest());
			bean.setEspacio(entity.getvNumespacio());
			bean.setDescripcion(entity.getvAlternativa()); 
			bean.getOracionCompletarBean().setCodigo(entity.getnCodcomporacion());
			bean.setRespuestaEstado(entity.getvRptaestado());
			
			bean.getOracionCompletarBean().setTitulo(entity.getV_tituloOra());
			bean.getOracionCompletarBean().setOracion(entity.getV_oracion());
			
			bean.getOracionCompletarBean().setMaterialTipoEjercicioBean(new  MaterialTipoEjercicioBean());
			
			bean.getOracionCompletarBean().getMaterialTipoEjercicioBean().setTitulo(entity.getV_tituloTipo());
			if (entity.getN_codmatpej()!= null){
			bean.getOracionCompletarBean().getMaterialTipoEjercicioBean().setCodigo(entity.getN_codmatpej());
			}
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
