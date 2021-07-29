package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.LenguaDAO;
 
@Transactional
@Repository("lenguaDAO")
public class LenguaDAOImp implements LenguaDAO {
	
	
	@PersistenceContext
	private EntityManager em; 
	
	public LenguaBean getLenguaBean(Object object){
		return (LenguaBean)object;
	}


	
	@Override
	public boolean insertar(LenguaBean lenguaBean) throws DAOException {   
		Object idLengua= null; 
		System.out.println("lenguaBean.getCodigoUsuarioCreacion() " + lenguaBean.getCodigoUsuarioCreacion());
		System.out.println("lenguaBean.getIpCreacion() " + lenguaBean.getIpCreacion());
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.insertar");
			spq.setParameter("p_nomlengua", lenguaBean.getNombre());
			spq.setParameter("p_deslengua", lenguaBean.getDescripcion());
			spq.setParameter("p_tm1sitlen", Integer.valueOf(lenguaBean.getSituacion().getCodigoRegistro()));
			spq.setParameter("p_codusureg", lenguaBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", lenguaBean.getIpCreacion()); 
			spq.setParameter("p_exteimag", lenguaBean.getImagenExtension());
			spq.setParameter("p_ubicimag", lenguaBean.getImagenUbicacion());
			spq.setParameter("p_nombimag", lenguaBean.getImagenNombre());
			spq.setParameter("p_pesoimag", lenguaBean.getImagenPeso());
			spq.setParameter("p_tamaimag", lenguaBean.getImagenTamanio());
			
			spq.execute();
			
			idLengua = spq.getOutputParameterValue(1);
			if (idLengua != null) {
				lenguaBean.setCodigo(Integer.valueOf(idLengua.toString()));
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
	public boolean actualizar(LenguaBean lenguaBean) throws DAOException {
		boolean sw=false;
		System.out.println("lenguaBean actualizar " + lenguaBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.actualizar");
			spq.setParameter("p_codlengua", lenguaBean.getCodigo()); 
			spq.setParameter("p_nomlengua", lenguaBean.getNombre());
			spq.setParameter("p_deslengua", lenguaBean.getDescripcion());
			spq.setParameter("p_tm1sitlen", lenguaBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_codusumod", lenguaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", lenguaBean.getIpModificacion());
			spq.setParameter("p_exteimag", lenguaBean.getImagenExtension());
			spq.setParameter("p_ubicimag", lenguaBean.getImagenUbicacion());
			spq.setParameter("p_nombimag", lenguaBean.getImagenNombre());
			spq.setParameter("p_pesoimag", lenguaBean.getImagenPeso());
			spq.setParameter("p_tamaimag", lenguaBean.getImagenTamanio());
			
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
	public boolean eliminar(LenguaBean lenguaBean) throws DAOException { 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.eliminar");
			spq.setParameter("p_codlengua", lenguaBean.getCodigo()); 
			spq.setParameter("p_codusumod", lenguaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", lenguaBean.getIpModificacion());
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


	@SuppressWarnings("unchecked")
	@Override
	public LenguaBean getBuscarPorObjecto(LenguaBean lenguaBean) throws DAOException {
		LenguaBean oLenguaBean = null;
		List<LeotbcLengua> lstLeotbcLengua = null;
		System.out.println("lenguaBean getBuscarPorObjecto " + lenguaBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.buscar_por_codigo");			
			spq.setParameter("p_codlengua", lenguaBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcLengua = spq.getResultList();			
			}
			
			if (	lstLeotbcLengua != null
				&&	lstLeotbcLengua.size() > 0) {
				
				oLenguaBean = deLenguaALenguaBean(lstLeotbcLengua.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oLenguaBean;
	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<LenguaBean> getBuscarPorFiltros(LenguaBean lengua) throws DAOException { 
		List<LeotbcLengua> lstLengua = null;	
		List<LenguaBean> lstLenguaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.buscar_por_filtros");
			spq.setParameter("p_nomlengua", lengua.getNombre());  
			spq.setParameter("p_tm1sitlen", lengua.getSituacion().getCodigoRegistro());  
			if (spq.execute()) {
				lstLengua =  spq.getResultList(); 
			} 
			if (lstLengua != null && lstLengua.size() > 0) {
				
				lstLenguaBean = deListaLenguaAListaLenguaBean(lstLengua);
			}
			//em.close();
			
		   
		return lstLenguaBean;
	}


	@Override
	public boolean existe(LenguaBean lenguaBean) throws DAOException { 
		Boolean sw = true;
		List<LeotbcLengua> lstLeotbcLengua = null; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.existe");			
			spq.setParameter("p_codlengua", lenguaBean.getCodigo()); 
			spq.setParameter("p_nomlengua", lenguaBean.getNombre().trim());
			
		
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
	
	private List<LenguaBean> deListaLenguaAListaLenguaBean(List<LeotbcLengua> lstHorarioExcepcion) {
		
		List<LenguaBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<LenguaBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				LeotbcLengua entity = lstHorarioExcepcion.get(i);
				LenguaBean bean = deLenguaALenguaBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private LenguaBean deLenguaALenguaBean(LeotbcLengua entity) {
		
		LenguaBean bean = null;
		
		if (entity != null) {
			
			bean = new LenguaBean();
			
			bean.setMatriculaBean(new MatriculaBean());
			bean.setCodigo(entity.getNCodlengua()); 
			bean.setNombre(entity.getVNomlengua()); 
			bean.setDescripcion(entity.getvDeslengua()); 
			bean.getSituacion().setCodigoRegistro(entity.getNCodsitlen()); 
			bean.getSituacion().setNombreCorto(entity.getV_nomcortoSituacion());
			bean.setImagenExtension(entity.getvExteimag()); 
			bean.setImagenNombre(entity.getvNombimag()); 
			bean.setImagenUbicacion(entity.getvUbicimag()); 
			bean.setImagenPeso(entity.getvPesoimag()); 
			bean.setImagenTamanio(entity.getvTamaimag());
			bean.getMatriculaBean().setCodigo(entity.getN_codmatri());
		}
		
		return bean;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<LenguaBean> listarCombo() throws DAOException {
		List<LeotbcLengua> lstLengua = null;	
		List<LenguaBean> lstLenguaBean = null;
			System.out.println("-------:::  listarCombo----");
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.listarCombo");
		
			if (spq.execute()) {
				lstLengua =  spq.getResultList(); 
			} 
			if (lstLengua != null && lstLengua.size() > 0) {
				
				lstLenguaBean = deListaLenguaAListaLenguaBean(lstLengua);
			}
			
			em.close();
		   
		return lstLenguaBean;
	}



	@Override
	public List<LenguaBean> listarComboxInstitucion(InstitucionBean institucionBean) throws DAOException {
		List<LeotbcLengua> lstLengua = null;	
		List<LenguaBean> lstLenguaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.buscar_por_codigoInstitucion");
			
			System.out.println("variables ITD");
			System.out.println(institucionBean.getCodigo());
			System.out.println(institucionBean.getTipoActividad().getValor1());
			System.out.println(institucionBean.getTipoActividad().getCodigoRegistro());
			
			spq.setParameter("p_codinsti",institucionBean.getCodigo()); 
			// cambios
			spq.setParameter("p_periodo",institucionBean.getTipoActividad().getValor1()); 
			spq.setParameter("p_tm2ciclo",institucionBean.getTipoActividad().getCodigoRegistro());  
			
			if (spq.execute()) {
				lstLengua =  spq.getResultList();
				System.out.println("-------------------1-------------");
				System.out.println(lstLengua);
			} 
			if (lstLengua != null && lstLengua.size() > 0) {
				System.out.println("-------------------2-------------");
				System.out.println(lstLengua);
				
				lstLenguaBean = deListaLenguaAListaLenguaBean(lstLengua);
			}
			
			em.close();
		   
		return lstLenguaBean;
	}
	

	@Override
	public List<LenguaBean> listarInstitucionxCodigoInstitucion(InstitucionBean institucionBean) throws DAOException {
		List<LeotbcLengua> lstLengua = null;	
		List<LenguaBean> lstLenguaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.listarPorCodigoInstitucion");
			spq.setParameter("p_codinsti",institucionBean.getCodigo()); 
			if (spq.execute()) {
				lstLengua =  spq.getResultList(); 
			} 
			if (lstLengua != null && lstLengua.size() > 0) {
				
				lstLenguaBean = deListaLenguaAListaLenguaBean(lstLengua);
			}
			
			em.close();
		   
		return lstLenguaBean;
	}
	
	@Override
	public List<LenguaBean> listarLenguaFaltantexCodigoInstitucion(InstitucionBean institucionBean) throws DAOException {
		List<LeotbcLengua> lstLengua = null;	
		List<LenguaBean> lstLenguaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.listarFaltantePorCodigoInstitucion");
			spq.setParameter("p_codinsti",institucionBean.getCodigo()); 
			if (spq.execute()) {
				lstLengua =  spq.getResultList(); 
			} 
			if (lstLengua != null && lstLengua.size() > 0) {
				
				lstLenguaBean = deListaLenguaAListaLenguaBean(lstLengua);
			}
			
			em.close();
		   
		return lstLenguaBean;
	}
	
	@Override
	public List<LenguaBean> listarValidaLenguasxMatricula(UsuarioBean usuarioBean) throws DAOException {
//		List<LeotbcLengua> lstLengua = null;	
//		List<LenguaBean> lstLenguaBean = null;
//		
//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.validaLenguasPorMatricula");
//			spq.setParameter("p_codalumno",alumnoBean.getCodigo()); 
//			if (spq.execute()) {
//				lstLengua =  spq.getResultList(); 
//			} 
//			if (lstLengua != null && lstLengua.size() > 0) {
//				
//				lstLenguaBean = deListaLenguaAListaLenguaBean(lstLengua);
//			}
//			
//			em.close();
//		   
//		return lstLenguaBean;
		List<LeotbcLengua> lstLengua = null;	
		List<LenguaBean> lstLenguaBean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.validaLenguasPorMatricula");
		spq.setParameter("p_codusuari",usuarioBean.getCodigo()); 
		
			if (spq.execute()) {
				lstLengua =  spq.getResultList(); 
			} 
			if (lstLengua != null && lstLengua.size() > 0) {
				
				lstLenguaBean = deListaLenguaAListaLenguaBean(lstLengua);
			}
			//em.close();
			
		   
		return lstLenguaBean;
	}

}
