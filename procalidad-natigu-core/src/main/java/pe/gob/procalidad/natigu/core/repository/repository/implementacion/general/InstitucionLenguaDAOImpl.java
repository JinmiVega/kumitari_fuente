package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionLenguaBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdInstlengua;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.InstitucionLenguaDAO;
@Transactional
@Repository("institucionLenguaDAO")
public class InstitucionLenguaDAOImpl implements InstitucionLenguaDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(InstitucionLenguaBean institucionLenguaBean) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("institucionLenguaBean DAO "+institucionLenguaBean);
		Object codigoInstitucionLengua= null; 
		
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstlengua.insertar");
			
			spq.setParameter("p_codlengua", institucionLenguaBean.getLenguaBean().getCodigo());
			spq.setParameter("p_codisnti", institucionLenguaBean.getInstitucionBean().getCodigo());
			
			spq.setParameter("p_codusureg", institucionLenguaBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", 	institucionLenguaBean.getIpCreacion()); 
	
			
			spq.execute();
			
			codigoInstitucionLengua = spq.getOutputParameterValue(1);
			
			if (codigoInstitucionLengua != null) {
				System.out.println("Ingreso a Insertar institucion");
				
				institucionLenguaBean.setCodigo(Long.valueOf(codigoInstitucionLengua.toString()));
				System.out.println("institucion.getCodigo()"+institucionLenguaBean.getCodigo());
				
				sw = true;
				
			}else{
				System.out.println("institucion.getCodigo()"+institucionLenguaBean.getCodigo());
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
	public boolean actualizar(InstitucionLenguaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(InstitucionLenguaBean institucionLenguaBean) throws DAOException {
		System.out.println("institucionLenguaBean DAO eliminar "+institucionLenguaBean);
	
		
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstlengua.eliminar");
			
			spq.setParameter("p_codinleng", institucionLenguaBean.getCodigo());
						
			spq.setParameter("p_codusumod", institucionLenguaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", 	institucionLenguaBean.getIpModificacion()); 
		
			spq.execute();
			sw =  true;		
			
		} catch (Exception e) {
			e.printStackTrace();
			sw = false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public InstitucionLenguaBean getBuscarPorObjecto(InstitucionLenguaBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InstitucionLenguaBean> getBuscarPorFiltros(
			InstitucionLenguaBean institucionLenguaBean) throws DAOException {
		List<LeotbdInstlengua> lstLeotbdInstlengua = null;	
		List<InstitucionLenguaBean> lstInstitucionLenguaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstlengua.buscarPorCodigoInstitucion");
			spq.setParameter("p_codisnti", institucionLenguaBean.getInstitucionBean().getCodigo()); 

			if (spq.execute()) {
				lstLeotbdInstlengua =  spq.getResultList(); 
				System.out.println("lstLeotbdInstlengua.size() "+lstLeotbdInstlengua.size());
			} 
			if (lstLeotbdInstlengua != null && lstLeotbdInstlengua.size() > 0) {
				
				lstInstitucionLenguaBean = deListaInstitucionLenguAListaInstitucionLenguaBean(lstLeotbdInstlengua);
			}
			//em.close();
		   
		return lstInstitucionLenguaBean;
	}

private List<InstitucionLenguaBean> deListaInstitucionLenguAListaInstitucionLenguaBean(List<LeotbdInstlengua> lstLeotbdInstlengua) {
		
		List<InstitucionLenguaBean> lstInstitucionLenguaBean = null;
		
		if (lstLeotbdInstlengua != null && lstLeotbdInstlengua.size() > 0) {
			
			lstInstitucionLenguaBean = new ArrayList<InstitucionLenguaBean>();
			
			for (int i = 0; i < lstLeotbdInstlengua.size(); i++) { 
				LeotbdInstlengua entity = lstLeotbdInstlengua.get(i);
				InstitucionLenguaBean bean = deInstitucionLenguaAInstitucionLenguaBean(entity);
				
				lstInstitucionLenguaBean.add(bean);
			}
		}
		
		return lstInstitucionLenguaBean;
	}
	
	private InstitucionLenguaBean deInstitucionLenguaAInstitucionLenguaBean(LeotbdInstlengua entity) {
		
		InstitucionLenguaBean bean = null;
		
		if (entity != null) {
			
			bean = new InstitucionLenguaBean();
			System.out.println("entity.getnCodinleng()"+ entity.getnCodinleng());
			bean.setCodigo(entity.getnCodinleng());
			System.out.println("entity.getnCodlengua() " +entity.getnCodlengua());
			bean.getLenguaBean().setCodigo(entity.getnCodlengua());
			bean.getLenguaBean().setNombre(entity.getNombreLengua());
			bean.setFechaCreacion(entity.getdFecreg());
			System.out.println("entity.getdFecreg()"+entity.getdFecreg());
		}
		return bean;
	}

	@Override
	public boolean existe(InstitucionLenguaBean t) throws DAOException {
		
		return false;
	}

	@Override
	public List<InstitucionLenguaBean> existeLengua(InstitucionLenguaBean institucionLenguaBean) throws DAOException {
		List<LeotbdInstlengua> lstLeotbdInstlengua = null;	
		List<InstitucionLenguaBean> lstInstitucionLenguaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstlengua.existeLenguaInstitucion");
			spq.setParameter("p_codlengua", institucionLenguaBean.getLenguaBean().getCodigo());
			spq.setParameter("p_codisnti", institucionLenguaBean.getInstitucionBean().getCodigo());

			if (spq.execute()) {
				lstLeotbdInstlengua =  spq.getResultList(); 
				System.out.println("lstLeotbdInstlengua "+ lstLeotbdInstlengua);
			} 
			if (lstLeotbdInstlengua != null && lstLeotbdInstlengua.size() > 0) {
				
				lstInstitucionLenguaBean = deListaInstitucionLenguAListaInstitucionLenguaBean(lstLeotbdInstlengua);
			}
			//em.close();
		   
		return lstInstitucionLenguaBean;
	}

	@Override
	public List<InstitucionLenguaBean> reporteAlumLengInst(InstitucionLenguaBean institucionLenguaBean)
			throws DAOException {
		List<LeotbdInstlengua> lstLeotbdInstlengua = null;	
		List<InstitucionLenguaBean> lstInstitucionLenguaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstlengua.reporte_alum_leng_inst");
			spq.setParameter("p_codisnti", institucionLenguaBean.getInstitucionBean().getCodigo());

			if (spq.execute()) {
				lstLeotbdInstlengua =  spq.getResultList();
			} 
			if (lstLeotbdInstlengua != null && lstLeotbdInstlengua.size() > 0) {
				
				lstInstitucionLenguaBean = new ArrayList<InstitucionLenguaBean>();
				
				for (int i = 0; i < lstLeotbdInstlengua.size(); i++) { 
					LeotbdInstlengua entity = lstLeotbdInstlengua.get(i);
					InstitucionLenguaBean bean = new InstitucionLenguaBean();
					bean.setCodigo(entity.getnCodinleng());
					bean.getLenguaBean().setCodigo(entity.getnCodlengua());
					bean.getLenguaBean().setNombre(entity.getNombreLengua());
					bean.getLenguaBean().setImagenNombre(entity.getNombreImgLengua());
					bean.getInstitucionBean().setCodigo(entity.getnCodisnti());
					bean.setFechaCreacion(entity.getdFecreg());
					bean.setTotalBasico(entity.getN_totalbasico());
					bean.setTotalIntermedio(entity.getN_totalintermedio());
					bean.setTotalAvanzado(entity.getN_totalavanzado());
					
					lstInstitucionLenguaBean.add(bean);
				}
			}
			//em.close();
		   
		return lstInstitucionLenguaBean;
	}

}