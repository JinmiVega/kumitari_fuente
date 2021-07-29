package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 

import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EspecialidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotmdDocenespeci;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.EspecialidadDAO;
 
@Transactional
@Repository("especialidadDAO")
public class EspecialidadDAOImp implements EspecialidadDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	public EspecialidadBean getAlumnoBean(Object object){
		return (EspecialidadBean)object;
	}


	private List<EspecialidadBean> deListaEspecialidadAListaEspecialidadBean(List<LeotmdDocenespeci> lstEspecialidad) {
		
		List<EspecialidadBean> lstEspecialidadBean = null;
		
		if (lstEspecialidad != null && lstEspecialidad.size() > 0) {
			
			lstEspecialidadBean = new ArrayList<EspecialidadBean>();
			
			for (int i = 0; i < lstEspecialidad.size(); i++) { 
				LeotmdDocenespeci entity = lstEspecialidad.get(i);
				EspecialidadBean bean = deEspecialidadAEspecialidadBean(entity);
				
				lstEspecialidadBean.add(bean);
			}
		}
		return lstEspecialidadBean;
	}
	
	private EspecialidadBean deEspecialidadAEspecialidadBean(LeotmdDocenespeci entity) {
		
		EspecialidadBean bean = null;
		
		if (entity != null) {
			
			bean = new EspecialidadBean();
			bean.setCodigo(entity.getNCoddocesp());
			
			bean.setDocenteBean(new DocenteBean());
			bean.getDocenteBean().setCodigo(entity.getNCoddocen());
			
			bean.setLenguaBean(new LenguaBean());
			bean.getLenguaBean().setCodigo(entity.getNCodlengua());
			bean.getLenguaBean().setNombre(entity.getVNomlengua());
			
			bean.setTm2Nivel(new MaestraBean());
			bean.getTm2Nivel().setCodigo(entity.getNTm2nivel());
			bean.getTm2Nivel().setNombreCorto(entity.getVNombretm2nivel());
			
			bean.setRutaDocumento(entity.getvRutadocu());
			
		}
		
		return bean;
	}


	@Override
	public boolean insertar(EspecialidadBean especialidadBean) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("especialidadBean DAO "+especialidadBean);
		Object idEspecialidad= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotmd_docenespeci.insertar");
			spq.setParameter("p_coddocesp", especialidadBean.getCodigo());
			spq.setParameter("p_coddocen", especialidadBean.getDocenteBean().getCodigo());
			spq.setParameter("p_codlengua", especialidadBean.getLenguaBean().getCodigo());
			spq.setParameter("p_tm2nivel", especialidadBean.getTm2Nivel().getCodigoRegistro());
			spq.setParameter("p_numdocum", especialidadBean.getNumeroDocumento());
			spq.setParameter("p_rutadocu", especialidadBean.getRutaDocumento());
			spq.setParameter("p_codusureg", especialidadBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", especialidadBean.getIpCreacion());
			
			spq.execute();
			
			idEspecialidad = spq.getOutputParameterValue(1);
			if (idEspecialidad != null) {
				especialidadBean.setCodigo(Integer.valueOf(idEspecialidad.toString()));
				if (especialidadBean.getCodigo()!=0) {
					sw=true;
				}
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
	public boolean actualizar(EspecialidadBean especialidadBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean eliminar(EspecialidadBean especialidadBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotmd_docenespeci.eliminar");
			spq.setParameter("p_coddocen", especialidadBean.getDocenteBean().getCodigo()); 
			spq.setParameter("p_codlengua", especialidadBean.getLenguaBean().getCodigo()); 
			spq.setParameter("p_codusumod", especialidadBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", especialidadBean.getIpModificacion());
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
	public EspecialidadBean getBuscarPorObjecto(EspecialidadBean especialidadBean) throws DAOException {
		// TODO Auto-generated method stub
		return especialidadBean;
	}


	@Override
	public List<EspecialidadBean> getBuscarPorFiltros(EspecialidadBean especialidadBean) throws DAOException {
		System.out.println("em " + em);
		/*
		List<LeotmdDocenespeci> lstEspecialidad= null;	
		List<EspecialidadBean> lstEspecialidadBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotmd_docenespeci.buscar_por_codigodocente");
			spq.setParameter("p_coddocen", especialidadBean.getDocenteBean().getCodigo());  
			
			if (spq.execute()) {
				lstEspecialidad =  spq.getResultList(); 
			} 
			if (lstEspecialidad != null && lstEspecialidad.size() > 0) {
				
				lstEspecialidadBean = deListaEspecialidadAListaEspecialidadBean(lstEspecialidad);
			}
			em.close();
		  */ 
		return null;
	}


	@Override
	public boolean existe(EspecialidadBean especialidadBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<EspecialidadBean> listarPorCodigoDocente(DocenteBean docenteBean) throws DAOException {
		List<LeotmdDocenespeci> lstEspecialidad= null;	
		List<EspecialidadBean> lstEspecialidadBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotmd_docenespeci.buscar_por_codigodocente");
			spq.setParameter("p_coddocen", docenteBean.getCodigo());  
			
			if (spq.execute()) {
				lstEspecialidad =  spq.getResultList(); 
			} 
			if (lstEspecialidad != null && lstEspecialidad.size() > 0) {
				
				lstEspecialidadBean = deListaEspecialidadAListaEspecialidadBean(lstEspecialidad);
			}
			em.close();
		   
		return lstEspecialidadBean;
	}
}
