package pe.gob.procalidad.natigu.core.repository.repository.implementacion.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.GlosarioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcGlosario;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.GlosarioDAO;
@Repository("glosarioDAO")
@Transactional(readOnly = true)
public class GlosarioDAOImp implements GlosarioDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(GlosarioBean glosarioBean) throws DAOException {

		System.out.println("glosarioBean DAO "+glosarioBean);
		Object idGlosario= null; 
		
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_glosario.insertar");
			
			spq.setParameter("p_codlengua",glosarioBean.getLenguaBean().getCodigo());
			spq.setParameter("p_detalle", glosarioBean.getDetalle());
			spq.setParameter("p_codusureg", glosarioBean.getCodigoUsuarioCreacion());
						
			spq.setParameter("p_hostreg", glosarioBean.getIpCreacion());
			
			spq.setParameter("p_mimetype", glosarioBean.getMimmeType());
			spq.setParameter("p_peso", glosarioBean.getPeso());
			spq.setParameter("p_nomarchivo", glosarioBean.getFileName());
			
			spq.execute();
			
			idGlosario = spq.getOutputParameterValue(1);
			
			if (idGlosario != null) {
				
				
				glosarioBean.setCodigoGlosario(Long.valueOf(idGlosario.toString()));
				System.out.println("glosarioBean.getCodigo()"+glosarioBean.getCodigo());

				
				sw = true;
				
			}else{
				System.out.println("obj llego vacio.");
				sw = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw = false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean actualizar(GlosarioBean glosarioBean) throws DAOException {	
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_glosario.actualizar");
			spq.setParameter("p_codglosario",glosarioBean.getCodigoGlosario());
			spq.setParameter("p_codlengua",glosarioBean.getLenguaBean().getCodigo());
			spq.setParameter("p_detalle", glosarioBean.getDetalle());
			spq.setParameter("p_codusumod", glosarioBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", glosarioBean.getIpModificacion());
			spq.setParameter("p_mimetype", glosarioBean.getMimmeType());
			spq.setParameter("p_peso", glosarioBean.getPeso());
			spq.setParameter("p_nomarchivo", glosarioBean.getFileName());
			
			System.out.println("------------------------------");
			System.out.println("p_codglosario: "+glosarioBean.getCodigoGlosario());
			System.out.println("p_codlengua: "+glosarioBean.getLenguaBean().getCodigo());
			System.out.println("p_detalle: "+ glosarioBean.getDetalle());
			System.out.println("p_codusumod: "+ glosarioBean.getCodigoUsuarioModificacion());
			System.out.println("p_hostmod: "+ glosarioBean.getIpModificacion());
			System.out.println("p_mimetype: "+ glosarioBean.getMimmeType());
			System.out.println("p_peso: "+ glosarioBean.getPeso());
			System.out.println("p_nomarchivo: "+ glosarioBean.getFileName());
			System.out.println("------------------------------");
			
			spq.execute();
			
			sw = true;

		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(GlosarioBean glosarioBean) throws DAOException {
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_glosario.eliminar");
			spq.setParameter("p_codglosario",glosarioBean.getCodigoGlosario());			
			spq.setParameter("p_codlengua",glosarioBean.getLenguaBean().getCodigo());
			spq.setParameter("p_codusumod", glosarioBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", glosarioBean.getIpModificacion());
			
			spq.execute();
			
			sw = true;

		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public GlosarioBean getBuscarPorObjecto(GlosarioBean glosarioBean) throws DAOException {
		GlosarioBean oGlosarioBean = null;
		List<LeotbcGlosario> lstLeotbcGlosario = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_glosario.listar");			
			spq.setParameter("p_codglosario", glosarioBean.getCodigoGlosario()); 
			spq.setParameter("p_codlengua", glosarioBean.getLenguaBean()!=null? glosarioBean.getLenguaBean().getCodigo():null); 
		
			if (spq.execute()) {
				lstLeotbcGlosario = spq.getResultList();			
			}
			
			if (	lstLeotbcGlosario != null
				&&	lstLeotbcGlosario.size() > 0) {
				
				oGlosarioBean = deGlosarioAGlosarioBean(lstLeotbcGlosario.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oGlosarioBean;
	}

	@Override
	public List<GlosarioBean> getBuscarPorFiltros(GlosarioBean glosarioBean)
			throws DAOException {
		System.out.println("em " + em);
		List<LeotbcGlosario> lstLeotbcGlosario = null;	
		List<GlosarioBean> lstGlosarioBeans = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_glosario.listar");
			spq.setParameter("p_codglosario", glosarioBean.getCodigo()); 
			spq.setParameter("p_codlengua", glosarioBean.getLenguaBean()!=null? glosarioBean.getLenguaBean().getCodigo():null); 
		
 
			
			if (spq.execute()) {
				lstLeotbcGlosario =  spq.getResultList(); 
			} 
			if (lstLeotbcGlosario != null && lstLeotbcGlosario.size() > 0) {
				
				lstGlosarioBeans = deListaGlosarioAListaGlosarioBean(lstLeotbcGlosario);
			}
			//em.close();
		   
		return lstGlosarioBeans;
	}
	private List<GlosarioBean> deListaGlosarioAListaGlosarioBean(List<LeotbcGlosario> lstLeotbcGlosario) {
		
		List<GlosarioBean> lstGlosarioBeans = null;
		
		if (lstLeotbcGlosario != null && lstLeotbcGlosario.size() > 0) {
			
			lstGlosarioBeans = new ArrayList<GlosarioBean>();
			
			for (int i = 0; i < lstLeotbcGlosario.size(); i++) { 
				LeotbcGlosario entity = lstLeotbcGlosario.get(i);
				GlosarioBean bean = deGlosarioAGlosarioBean(entity);
				
				lstGlosarioBeans.add(bean);
			}
		}
		
		return lstGlosarioBeans;
	}
	private GlosarioBean deGlosarioAGlosarioBean(LeotbcGlosario entity) {
		
		GlosarioBean bean = null;
		
		if (entity != null) {
			
			bean = new GlosarioBean();
			bean.setCodigoGlosario(entity.getNCodglosario());
			bean.setDetalle(entity.getVDetalle());
			bean.setLenguaBean(new LenguaBean());
			bean.getLenguaBean().setCodigo(entity.getNCodlengua());
			bean.getLenguaBean().setNombre(entity.getvNomlengua());
			bean.setMimmeType(entity.getvMimeType());
			bean.setPeso(entity.getnPeso());
			bean.setFileName(entity.getvNomarchivo());
			
			
		}
		
		return bean;
	}
	@Override
	public boolean existe(GlosarioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
