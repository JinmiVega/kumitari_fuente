package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 
import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumnoLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaUnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbdSegalumlen;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLenguaEstruc;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdLeUndLeccion;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdLestunidad;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.implementacion.general.UnidadDAOImpl;
import pe.gob.procalidad.natigu.core.repository.repository.implementacion.general.UnidadLeccionDAOImpl;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.SeguimientoAlumnoLenguaDAO;
 

@Transactional
@Repository("seguimientoAlumnoLenguaDAO")
public class SeguimientoAlumnoLenguaDAOImp implements SeguimientoAlumnoLenguaDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public boolean insertar(SeguimientoAlumnoLenguaBean t) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("SeguimientoAlumnoLenguaBean DAO INSERT "+t);
		Object idcodsegalu= null; 
//		Object idcodundlec= null; 
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdSegalumlen.insertar");
			
			spq.setParameter("p_codalumno",	t.getUsuarioMatriculaBean().getAlumnoBean().getCodigo());
			spq.setParameter("p_codmatri",	t.getUsuarioMatriculaBean().getMatriculaBean().getCodigo()); 	
			spq.setParameter("p_codusureg", t.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", 	t.getIpCreacion()); 
			
			spq.execute();
			//System.out.println("spq.getOutputParameterValue(p_codsegalu)1 "+ spq.getOutputParameterValue("p_codsegalu"));
			idcodsegalu = spq.getOutputParameterValue(1);
			if (idcodsegalu != null) {
				
				t.setCodigo(Integer.valueOf(idcodsegalu.toString()));
				sw=true;
			}
			
//			idcodundlec = spq.getOutputParameterValue("var_codundlec");
//			if (idcodundlec != null) {
//				System.out.println("spq.getOutputParameterValue(p_codsegalu)2 "+ spq.getOutputParameterValue("p_codsegalu"));
//				t.getUnidadLeccionBean().setCodigo(Integer.valueOf(idcodundlec.toString()));
//				sw=true;
//			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}
	
	@Override
	public boolean insertar_sigLec(SeguimientoAlumnoLenguaBean t) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("SeguimientoAlumnoLenguaBean DAO INSERT "+t);
		Object idcodsegalu= null; 
//		Object idcodundlec= null; 
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdSegalumlen.insertar_SigLeccion");
			
			spq.setParameter("p_codusumat",	t.getUsuarioMatriculaBean().getCodigo());
			spq.setParameter("p_codundlec",	t.getUnidadLeccionBean().getCodigo()); 	
			spq.setParameter("p_codundlecAct",	t.getLeccionActual()); 
			spq.setParameter("p_codusureg", t.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", 	t.getIpCreacion()); 
			
			spq.execute();
			//System.out.println("spq.getOutputParameterValue(p_codsegalu)1 "+ spq.getOutputParameterValue("p_codsegalu"));
			idcodsegalu = spq.getOutputParameterValue(1);
			if (idcodsegalu != null) {
				
				t.setCodigo(Integer.valueOf(idcodsegalu.toString()));
				sw=true;
			}
			
//			idcodundlec = spq.getOutputParameterValue("var_codundlec");
//			if (idcodundlec != null) {
//				System.out.println("spq.getOutputParameterValue(p_codsegalu)2 "+ spq.getOutputParameterValue("p_codsegalu"));
//				t.getUnidadLeccionBean().setCodigo(Integer.valueOf(idcodundlec.toString()));
//				sw=true;
//			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}
	

	@Override
	public boolean actualizar(SeguimientoAlumnoLenguaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(SeguimientoAlumnoLenguaBean t) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("docenteBean DAO "+t);
	
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdSegalumlen.eliminar");
			
			spq.setParameter("p_codusumat", 	t.getCodigo());
		
			spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", 	t.getIpModificacion()); 
			
			spq.execute();
			sw=true;
//			idusuma = spq.getOutputParameterValue(1);
//			if (idusuma != null) {
//				t.setCodigo(Integer.valueOf(idusuma.toString()));
//				sw=true;
//			}
//			
//			idusuario = spq.getOutputParameterValue(2);
//			if (idusuario != null) {
//				t.getUsuarioBean().setCodigo(Integer.valueOf(idusuario.toString()));
//				sw=true;
//			}
//			
		
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public SeguimientoAlumnoLenguaBean getBuscarPorObjecto(SeguimientoAlumnoLenguaBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeguimientoAlumnoLenguaBean> getBuscarPorFiltros(SeguimientoAlumnoLenguaBean t)
			throws DAOException { 
		List<LeotbdSegalumlen> lstUsuarioMatricula = null;	
		List<SeguimientoAlumnoLenguaBean> lstSeguimientoAlumnoLenguaBean= null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdusumatricula.buscar_x_filtros");
			
			spq.setParameter("p_codusumat", t.getCodigo());  
		 	
			if (spq.execute()) {
				lstUsuarioMatricula =  spq.getResultList(); 
			} 
			if (lstUsuarioMatricula != null && lstUsuarioMatricula.size() > 0) {
				
				lstSeguimientoAlumnoLenguaBean = deListaSeguimientoAlumnoAListaLenguaEstructuraBeanBean(lstUsuarioMatricula);
			}
			//em.close();
			
		   
		return lstSeguimientoAlumnoLenguaBean;
	}
	
	
	
private List<SeguimientoAlumnoLenguaBean> deListaSeguimientoAlumnoAListaLenguaEstructuraBeanBean(List<LeotbdSegalumlen> lstHorarioExcepcion) {
		
		List<SeguimientoAlumnoLenguaBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<SeguimientoAlumnoLenguaBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				LeotbdSegalumlen entity = lstHorarioExcepcion.get(i);
				SeguimientoAlumnoLenguaBean bean = deUsuarioMatriculaASeguimientoAlumnoLenguaBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}



	private SeguimientoAlumnoLenguaBean deUsuarioMatriculaASeguimientoAlumnoLenguaBean(LeotbdSegalumlen entity) {
		
		SeguimientoAlumnoLenguaBean bean = null;
		
		if (entity != null) {
			
			bean = new SeguimientoAlumnoLenguaBean();
			bean.setCodigo(entity.getnCodsegalu()); 
			
			bean.setUnidadLeccionBean(new UnidadLeccionBean()); 
			bean.getUnidadLeccionBean().getUnidadBean().getLenguaEstructuraBean().getSubNivel().setCodigoRegistro(entity.getN_tm2subnivel());
			bean.getUnidadLeccionBean().getUnidadBean().getLenguaEstructuraBean().setSwActivo(entity.getV_swactivo());;
			  
		}
		
		return bean;
	}

	@Override
	public boolean existe(SeguimientoAlumnoLenguaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LenguaEstructuraBean> listarSubNivel(SeguimientoAlumnoLenguaBean seguimientoAlumnoLenguaBean){
	List<LeotbcLenguaEstruc> lstLeotbcLenguaEstruc = null;	
	List<LenguaEstructuraBean> lstSeguimientoAlumnoLenguaBean= null;
	
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdSegalumlen.listarSubNivel");
		
		spq.setParameter("p_codusuari", seguimientoAlumnoLenguaBean.getUsuarioMatriculaBean().getUsuarioBean().getCodigo());  
		spq.setParameter("p_codlengua", seguimientoAlumnoLenguaBean.getUnidadLeccionBean().getUnidadBean().getLenguaEstructuraBean().getLenguaBean().getCodigo());  
		
		if (spq.execute()) {
			lstLeotbcLenguaEstruc =  spq.getResultList(); 
		} 
		if (lstLeotbcLenguaEstruc != null && lstLeotbcLenguaEstruc.size() > 0) {
			
			lstSeguimientoAlumnoLenguaBean = deListaLenguaAListaLenguaEstructuraBean(lstLeotbcLenguaEstruc);
		}
		em.close();
		
	   
	return lstSeguimientoAlumnoLenguaBean;
	}

private List<LenguaEstructuraBean> deListaLenguaAListaLenguaEstructuraBean(List<LeotbcLenguaEstruc> lstHorarioExcepcion) {
		
		List<LenguaEstructuraBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<LenguaEstructuraBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				LeotbcLenguaEstruc entity = lstHorarioExcepcion.get(i);
				LenguaEstructuraBean bean = deLenguaALenguaEstructuraBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private LenguaEstructuraBean deLenguaALenguaEstructuraBean(LeotbcLenguaEstruc entity) {
		
		LenguaEstructuraBean bean = null;
		
		if (entity != null) {
			
			bean = new LenguaEstructuraBean();
			bean.setCodigo(entity.getNcodlenest());
			bean.getSubNivel().setCodigoRegistro(entity.getnTm2subnivel()); 
			bean.getSubNivel().setValor1(entity.getV_valor1()); 
			bean.getNivel().setCodigoRegistro(entity.getnTm2nivel()); 
			bean.getSubNivel().setNombreCorto(entity.getV_nomsubnivel());  
			bean.setSwActivo(entity.getV_swactivo());
			bean.setNombreImagen(entity.getV_nombimag());
		}
		
		return bean;
	}

	@Override
	public List<UnidadBean> listarUnidad(SeguimientoAlumnoLenguaBean seguimientoAlumnoLenguaBean)
			throws DAOException {
		List<LeotbdLestunidad> lstLeotbcLenguaEstruc = null;	
		List<UnidadBean> lstSeguimientoAlumnoLenguaBean= null;
			UnidadDAOImpl daoImpl = new UnidadDAOImpl();
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdSegalumlen.listarUnidad");
			
			spq.setParameter("p_codusuari", seguimientoAlumnoLenguaBean.getUsuarioMatriculaBean().getUsuarioBean().getCodigo());
			spq.setParameter("p_codlenest", seguimientoAlumnoLenguaBean.getUnidadLeccionBean().getUnidadBean().getLenguaEstructuraBean() .getCodigo()); 
			spq.setParameter("p_codlengua", seguimientoAlumnoLenguaBean.getUnidadLeccionBean().getUnidadBean().getLenguaEstructuraBean().getLenguaBean().getCodigo());  
			
			if (spq.execute()) {
				lstLeotbcLenguaEstruc =  spq.getResultList(); 
			} 
			if (lstLeotbcLenguaEstruc != null && lstLeotbcLenguaEstruc.size() > 0) {
				
				lstSeguimientoAlumnoLenguaBean = daoImpl.deListaUnidadAListaUnidadBean(lstLeotbcLenguaEstruc) ;
			}
			em.close();
			
		   
		return lstSeguimientoAlumnoLenguaBean;
	}

	@Override
	public List<UnidadLeccionBean> listarLeccion(SeguimientoAlumnoLenguaBean seguimientoAlumnoLenguaBean)
			throws DAOException {
		List<LeotbdLeUndLeccion> lstLeotbcLenguaEstruc = null;	
		List<UnidadLeccionBean> lstSeguimientoAlumnoLenguaBean= null;
			UnidadLeccionDAOImpl daoImpl = new UnidadLeccionDAOImpl();
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdSegalumlen.listarLeccion");
			
			spq.setParameter("p_codusuari", seguimientoAlumnoLenguaBean.getUsuarioMatriculaBean().getUsuarioBean().getCodigo());
			spq.setParameter("p_codlesuni", seguimientoAlumnoLenguaBean.getUnidadLeccionBean().getUnidadBean().getCodigo()); 
			spq.setParameter("p_codlengua", seguimientoAlumnoLenguaBean.getUnidadLeccionBean().getUnidadBean().getLenguaEstructuraBean().getLenguaBean().getCodigo());  
			
			if (spq.execute()) {
				lstLeotbcLenguaEstruc =  spq.getResultList(); 
			} 
			if (lstLeotbcLenguaEstruc != null && lstLeotbcLenguaEstruc.size() > 0) {
				
				lstSeguimientoAlumnoLenguaBean = daoImpl.deLstUnidadLeccionALstUnidadLeccionBean(lstLeotbcLenguaEstruc) ;
			}
			em.close();
			
		   
		return lstSeguimientoAlumnoLenguaBean;
	}
 
}
