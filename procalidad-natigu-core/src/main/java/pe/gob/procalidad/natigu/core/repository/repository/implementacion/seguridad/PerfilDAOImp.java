package pe.gob.procalidad.natigu.core.repository.repository.implementacion.seguridad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PerfilBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeomvcMatricula;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;
import pe.gob.procalidad.natigu.core.entity.entity.seguridad.LeotbcPerfil;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.seguridad.PerfilDAO;

@Transactional
@Repository("perfilDAO")
public class PerfilDAOImp implements PerfilDAO{

	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public boolean insertar(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		Object id= null; 
		boolean sw=false;
		int response = 0;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_perfil.insertar");
	        spq.setParameter("p_codperfil", 0);
	        spq.setParameter("p_nomperfil", t.getNombrePerfil());
	        spq.setParameter("p_tm1sitprf", t.getSituacion()!=null? t.getSituacion().getCodigoRegistro() : null);
	        spq.setParameter("p_codusureg", t.getCodigoUsuarioCreacion());
	        spq.setParameter("p_hostreg", t.getIpCreacion()); 
	        spq.execute();	
	        response = Integer.valueOf(spq.getOutputParameterValue(1).toString());
	        if(response == 1) {
		        sw=true;
	        }else {
		        sw=false;
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
	public boolean actualizar(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		
		boolean sw=false;
		int response = 0;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_perfil.actualizar");
	        spq.setParameter("p_codperfil", t.getCodigoPerfil());
	        spq.setParameter("p_nomperfil", t.getNombrePerfil());
	        spq.setParameter("p_tm1sitprf", t.getSituacion()!=null? t.getSituacion().getCodigoRegistro() : null);
	        spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
	        spq.setParameter("p_hostmod", t.getIpModificacion());
	        
	        spq.execute();
	        response = Integer.valueOf(spq.getOutputParameterValue(1).toString());
	        if(response == 1) {
		        sw=true;
	        }else {
		        sw=false;
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
	public boolean eliminar(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_perfil.eliminar");
	        spq.setParameter("p_codperfil", t.getCodigoPerfil());
	        spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
	        spq.setParameter("p_hostmod", t.getIpModificacion());
	        
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
	public PerfilBean getBuscarPorObjecto(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PerfilBean> getBuscarPorFiltros(PerfilBean t)
			throws DAOException {
		List<PerfilBean> lstBean = new ArrayList<PerfilBean>();
		List<LeotbcPerfil> lstEntity = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_perfil.listar");
			
			spq.setParameter("p_nomperfil", t.getNombrePerfil());
	        spq.setParameter("p_codperfil", t.getCodigoPerfil());
	        spq.setParameter("p_tm1sitprf", t.getSituacion()!=null? t.getSituacion().getCodigoRegistro() : null); 
			
		
			if (spq.execute()) {
				lstEntity = spq.getResultList();			
			}
			
			if (	lstEntity != null
				&&	lstEntity.size() > 0) {
					lstBean=deListaMatriculaAListaMatriculaBean(lstEntity);
				
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return lstBean;
	}

	@Override
	public boolean existe(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private PerfilBean dePerfilToPerfilBean(LeotbcPerfil entity){
		PerfilBean bean = new PerfilBean();
		if(entity != null){
			bean.setCodigoPerfil(entity.getnCodperfil());
			bean.setEstado(entity.getvFlgest());
			if(entity.getnTm1sitprf()!=null){
				bean.setSituacion(new MaestraBean());
				bean.getSituacion().setCodigoRegistro(entity.getnTm1sitprf().intValue());
				bean.getSituacion().setNombreCorto(entity.getNombreSituacion());
			}
			bean.setNombrePerfil(entity.getvNomperfil());
			
		}
		return bean;
	}
	
	private List<PerfilBean> deListaMatriculaAListaMatriculaBean(List<LeotbcPerfil> lstMatriculaExcepcion) {
		
		List<PerfilBean> lstHorarioExcepcionBean = null;
		
		if (lstMatriculaExcepcion != null && lstMatriculaExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<PerfilBean>();
			
			for (int i = 0; i < lstMatriculaExcepcion.size(); i++) { 
				LeotbcPerfil entity = lstMatriculaExcepcion.get(i);
				PerfilBean bean = dePerfilToPerfilBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}

}
