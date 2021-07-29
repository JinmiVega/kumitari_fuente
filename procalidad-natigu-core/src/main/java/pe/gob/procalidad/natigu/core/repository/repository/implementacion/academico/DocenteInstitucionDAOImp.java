package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;  
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteInstitucionBean; 
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcDocenteinsti;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.DocenteInstitucionDAO;
 
@Transactional
@Repository("docenteInstitucionDAODAO")
public class DocenteInstitucionDAOImp implements DocenteInstitucionDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(DocenteInstitucionBean docenteInstitucionBean) throws DAOException {
	 
		System.out.println("DocenteInstitucionBean DAO "+docenteInstitucionBean);
		Object id= null; 
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_docenteinsti.insertar");
			
		
			spq.setParameter("p_coddocen", 	docenteInstitucionBean.getDocenteBean().getCodigo());
			spq.setParameter("p_codinsti", 	docenteInstitucionBean.getInstitucionBean().getCodigo());
			spq.setParameter("p_codusureg", docenteInstitucionBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", 	docenteInstitucionBean.getIpCreacion()); 
			
			spq.execute();
			
			id = spq.getOutputParameterValue(1);
			if (id != null) {
				docenteInstitucionBean.setCodigo(Integer.valueOf(id.toString()));
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
	public boolean actualizar(DocenteInstitucionBean docenteInstitucionBean) throws DAOException {
	 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_docenteinsti.actualizar");
			
			spq.setParameter("p_coddoceninst", docenteInstitucionBean.getCodigo());
			spq.setParameter("p_coddocen", 	docenteInstitucionBean.getDocenteBean().getCodigo());
			spq.setParameter("p_codinsti", 	docenteInstitucionBean.getInstitucionBean().getCodigo());
			spq.setParameter("p_tm1sitinsdoc", docenteInstitucionBean.getSituacion().getCodigoRegistro());
			
			spq.setParameter("p_codusumod", docenteInstitucionBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", 	docenteInstitucionBean.getIpModificacion()); 
			
			spq.execute();
			sw = true;
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(DocenteInstitucionBean docenteInstitucionBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_docenteinsti.eliminar");
			
			spq.setParameter("p_coddocen", docenteInstitucionBean.getDocenteBean().getCodigo());
			spq.setParameter("p_codinsti", docenteInstitucionBean.getInstitucionBean().getCodigo());
			spq.setParameter("p_codusumod", docenteInstitucionBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", 	docenteInstitucionBean.getIpModificacion()); 
			
			spq.execute();
			sw = true;
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public DocenteInstitucionBean getBuscarPorObjecto(DocenteInstitucionBean docenteInstitucionBean)
			throws DAOException {
		DocenteInstitucionBean oDocenteInstitucionBean = null;
		List<LeotbcDocenteinsti> lstLeotbcDocenteinsti = null;
		System.out.println("alumnoBean getBuscarPorObjecto " + docenteInstitucionBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_docenteinsti.buscar_por_codigo");			
			spq.setParameter("p_codalumno", docenteInstitucionBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcDocenteinsti = spq.getResultList();			
			}
			
			if (	lstLeotbcDocenteinsti != null
				&&	lstLeotbcDocenteinsti.size() > 0) {
				oDocenteInstitucionBean = deDocenteInstitucionADocenteInstitucionBean(lstLeotbcDocenteinsti.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oDocenteInstitucionBean;
	}

	@Override
	public List<DocenteInstitucionBean> getBuscarPorFiltros(
			DocenteInstitucionBean t) throws DAOException { 
		List<LeotbcDocenteinsti> lstLeotbcDocenteinsti = null;	
		List<DocenteInstitucionBean> lstDocenteInstitucionBean= null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_docenteinsti.listar_por_filtro");
			
			
			spq.setParameter("p_coddocen", t.getDocenteBean().getCodigo());  
			spq.setParameter("p_codinsti", t.getInstitucionBean().getCodigo());  
			
			if (spq.execute()) {
				lstLeotbcDocenteinsti =  spq.getResultList(); 
			} 
			if (lstLeotbcDocenteinsti != null && lstLeotbcDocenteinsti.size() > 0) {
				
				lstDocenteInstitucionBean = deListaDocenteInstitucionAListaDocenteInstitucionBean(lstLeotbcDocenteinsti);
			}
	} catch (Exception e) {
		e.printStackTrace();
		throw new DAOException(e);
	}finally{
		em.close();
	}
			
		   
		return lstDocenteInstitucionBean;
	}
	
	
	
	
	

private List<DocenteInstitucionBean> deListaDocenteInstitucionAListaDocenteInstitucionBean(List<LeotbcDocenteinsti> lstLeotbcDocenteinsti) {
		
		List<DocenteInstitucionBean> lstDocenteInstitucionBean = null;
		
		if (lstLeotbcDocenteinsti != null && lstLeotbcDocenteinsti.size() > 0) {
			
			lstDocenteInstitucionBean = new ArrayList<DocenteInstitucionBean>();
			
			for (int i = 0; i < lstLeotbcDocenteinsti.size(); i++) { 
				LeotbcDocenteinsti entity = lstLeotbcDocenteinsti.get(i);
				DocenteInstitucionBean bean = deDocenteInstitucionADocenteInstitucionBean(entity);
				
				lstDocenteInstitucionBean.add(bean);
			}
		}
		
		return lstDocenteInstitucionBean;
	}

private DocenteInstitucionBean deDocenteInstitucionADocenteInstitucionBean(LeotbcDocenteinsti entity) {
	
	DocenteInstitucionBean bean = null;
	
	if (entity != null) {
		
		bean = new DocenteInstitucionBean();
		
		bean.setCodigo(entity.getnCoddocenins()); 
		bean.setSituacion(new MaestraBean());
		bean.getSituacion().setCodigo(entity.getnTm1sitdocins());
		
		bean.setDocenteBean(new DocenteBean());
		bean.getDocenteBean().setCodigo(entity.getnCoddocen());
		bean.getDocenteBean().getPersonaBean().setNombrePersona(entity.getvNombrePer());
		bean.getDocenteBean().getPersonaBean().setApellidoPaterno(entity.getvApePatPer());
		bean.getDocenteBean().getPersonaBean().setApellidoMaterno(entity.getvApeMatPer());
		bean.getDocenteBean().getPersonaBean().getTipoDocumento().setCodigoRegistro(entity.getnTm1TpDoPe());;
		bean.getDocenteBean().getPersonaBean().setNumeroDocumento(entity.getvNumDocum());
		bean.setInstitucionBean(new InstitucionBean());
		bean.getInstitucionBean().setCodigo(entity.getN_codinsti());
		bean.getInstitucionBean().setNombreInstitucion(entity.getV_nominsti());

	}
	
	return bean;
}


	@Override
	public boolean existe(DocenteInstitucionBean docenteInstitucionBean) throws DAOException {
		Boolean sw = true;
		List<LeotbcLengua> lstLeotbcLengua = null; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_docenteinsti.existe");			
			spq.setParameter("p_coddoceninst", docenteInstitucionBean.getCodigo()); 
			spq.setParameter("p_coddocen", docenteInstitucionBean.getDocenteBean().getCodigo()); 
			spq.setParameter("p_codinsti", docenteInstitucionBean.getInstitucionBean().getCodigo());
			
		
			if (spq.execute()) {
				lstLeotbcLengua = spq.getResultList();			
			}
			
			if (	lstLeotbcLengua != null
				&&	lstLeotbcLengua.size() > 0) {
				
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

	 
}
