package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMonedaGBean;  
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbdAlumnoMonedaG; 
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.alumnoMonedaGDAO; 
@Repository("alumnoMonedaGDAO")
@Transactional(readOnly = true)
public class AlumnoMonedaGDAOImpl 
implements alumnoMonedaGDAO{
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(AlumnoMonedaGBean Bean)
			throws DAOException {
		System.out.println("AlumnoMonedaGBean" + Bean);
		boolean sw = false;
		Object cod = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_alumnoxmonedaG.insertar");
			spq.setParameter("p_codusumat", Bean.getUsuarioMatriculaBean().getCodigo());
			spq.setParameter("p_cantmonedas", Bean.getNumeroMonedas());
			spq.setParameter("p_cantgemas", Bean.getNumeroGemas());
			spq.setParameter("p_codusureg", Bean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", Bean.getIpCreacion());
			
			spq.execute();
			
			cod = spq.getOutputParameterValue(1);
			
			if (cod != null) {
				Bean.setCodigo(Long.valueOf(cod.toString()));
				sw = true;
			}else{
				System.out.println("obj es  null");
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
	public boolean actualizar(AlumnoMonedaGBean Bean)
			throws DAOException {
		Object idMoneGema= null;
		boolean sw=false; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_alumnoxmonedaG.actualizar");
			spq.setParameter("p_codaluxmongem", Bean.getCodigo());   
			spq.setParameter("p_codusumat",  Bean.getUsuarioMatriculaBean().getCodigo());
			spq.setParameter("p_codmatpej", Bean.getMaterialTipoEjercicioBean().getCodigo()); 
			spq.setParameter("p_cantmonedas", Bean.getNumeroMonedas());
			spq.setParameter("p_cantgemas", Bean.getNumeroGemas()); 
			spq.setParameter("p_codusumod", Bean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", Bean.getIpModificacion());
			
			spq.execute();   
//			sw=true;
			 
			idMoneGema = spq.getOutputParameterValue(1);
			if (idMoneGema != null) {
				Bean.setExiste(Integer.valueOf(idMoneGema.toString()));
				if (Bean.getExiste()==0) {
					sw=false;
				}
			}else{
				System.out.println(idMoneGema);
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
	public boolean eliminar(AlumnoMonedaGBean Bean)
			throws DAOException {
		System.out.println("AlumnoMonedaGBean" + Bean);
		boolean sw = false;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_alumnoxmonedaG.eliminar");
			spq.setParameter("p_codsegaluejer", Bean.getCodigo());
			spq.setParameter("p_codusureg", Bean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", Bean.getIpCreacion());
			
			spq.execute();
						
			sw = true;

			
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public AlumnoMonedaGBean getBuscarPorObjecto(
			AlumnoMonedaGBean Bean) throws DAOException {
		AlumnoMonedaGBean oBean = null;
		List<LeotbdAlumnoMonedaG> lstLeotbd = null;
		System.out.println(" Bean getBuscarPorObjecto " + Bean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_alumnoxmonedaG.buscarPorAlumno");			
			spq.setParameter("p_codusumat", Bean.getUsuarioMatriculaBean().getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbd = spq.getResultList();			
			}
			
			if (	lstLeotbd != null
				&&	lstLeotbd.size() > 0) {
				
				oBean = deLeotbdAlumnoMonedaGABean(lstLeotbd.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oBean;
	}

	@Override
	public List<AlumnoMonedaGBean> getBuscarPorFiltros(
			AlumnoMonedaGBean Bean) throws DAOException {
		return null;
	}
//	private List<AlumnoMonedaGBean> deListaSeguimientoAlumnoEjercicioAListaAlumnoMonedaGBean(List<LeotbcSeguimientoAlumnoEjer> lstLeotbcSeguimientoAlumnoEjers){
//		List<AlumnoMonedaGBean> lstAlumnoMonedaGBeans = null;
//		
//		if (lstLeotbcSeguimientoAlumnoEjers != null && 
//				lstLeotbcSeguimientoAlumnoEjers.size() > 0) {
//			lstAlumnoMonedaGBeans = new ArrayList<AlumnoMonedaGBean>();
//			for (int i = 0; i < lstAlumnoMonedaGBeans.size(); i++) {
//				LeotbcSeguimientoAlumnoEjer entity = lstLeotbcSeguimientoAlumnoEjers.get(i);
//				AlumnoMonedaGBean bean = deSeguimientoAlumnoEjercicioAAlumnoMonedaGBean(entity);
//				
//				lstAlumnoMonedaGBeans.add(bean);
//			}
//		}
//		
//		return lstAlumnoMonedaGBeans;
//	}
		private AlumnoMonedaGBean deLeotbdAlumnoMonedaGABean(LeotbdAlumnoMonedaG entity) {
		
			AlumnoMonedaGBean bean = null;
		
		if (entity != null) {
			
			bean = new AlumnoMonedaGBean();
			bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
			bean.setCodigo(entity.getnCodaluxmongem());
			bean.setNumeroMonedas(entity.getnCantmonedas());
			bean.setNumeroGemas(entity.getnCantgemas()); 
			bean.getUsuarioMatriculaBean().setCodigo(entity.getnCodusumat()); 		 
			bean.setEstado(entity.getvFlgest());
			bean.setCodigoUsuarioCreacion(entity.getnCodUsuRegistro());
			bean.setCodigoUsuarioModificacion(entity.getnCodUsuModificado());
			bean.setNumeroBono(entity.getnCantbono());
		}
		
		return  bean;
	}
	
	@Override
	public boolean existe(AlumnoMonedaGBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarmonedaxcompra(AlumnoMonedaGBean Bean) throws DAOException {
	
		boolean sw=false; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_alumnoxmonedaG.actualizarmonedaxcompra");
		
			spq.setParameter("p_codusumat",  Bean.getUsuarioMatriculaBean().getCodigo());
			spq.setParameter("p_cantmonedas", Bean.getNumeroMonedas());
			spq.setParameter("p_codusumod", Bean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", Bean.getIpModificacion());
			
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

}
