package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBonoBean; 
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMedallaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.BonoBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbdAlumnoBono;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbdAlumnoMedalla;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.AlumnoBonoDAO; 
@Transactional(readOnly = true)
@Repository("alumnoBonoDAO")
public class AlumnoBonoDAOImpl implements AlumnoBonoDAO{

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(AlumnoBonoBean Bean)
			throws DAOException {
		System.out.println("AlumnoBonoBean" + Bean);
		boolean sw = false;
		Object cod = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_alumnoxbono.insertar");
			spq.setParameter("p_codusumat", Bean.getUsuarioMatriculaBean().getCodigo()); 
			spq.setParameter("p_codundlec", Bean.getUnidadLeccionBean().getCodigo()); 
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
	public List<AlumnoBonoBean> getBuscarPorAlumno(
			AlumnoBonoBean Bean) throws DAOException {
		System.out.println("em " + em);
		List<LeotbdAlumnoBono> lstLeotbd = null;	
		List<AlumnoBonoBean> lstAlumnoBonoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_alumnoxBono.buscarPorAlumno");
			spq.setParameter("p_codlengua", Bean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().getCodigo());  
			spq.setParameter("p_codusuari", Bean.getUsuarioMatriculaBean().getCodigo()); 
			
			if (spq.execute()) {
				lstLeotbd =  spq.getResultList(); 
			} 
			if (lstLeotbd!= null && lstLeotbd.size() > 0) {
				
				lstAlumnoBonoBean = deListaAlumnoBonoAListaAlumnoBonoBean(lstLeotbd);
			}
			//em.close();
		   
		return lstAlumnoBonoBean;
	}
	
	@Override
	public boolean actualizar(AlumnoBonoBean AlumnoBonoBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(AlumnoBonoBean AlumnoBonoBean) throws DAOException {
		boolean sw =  false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_alumnoxBono.eliminar");
			spq.setParameter("p_codaluxbono", AlumnoBonoBean.getCodigo());  
			spq.setParameter("p_codusumod", AlumnoBonoBean.getCodigoUsuarioModificacion()); 
			spq.setParameter("p_hostmod", AlumnoBonoBean.getIpModificacion());
			
			spq.execute();
			sw =  true;
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public AlumnoBonoBean getBuscarPorObjecto(AlumnoBonoBean AlumnoBonoBean)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	 
	private List<AlumnoBonoBean> deListaAlumnoBonoAListaAlumnoBonoBean(List<LeotbdAlumnoBono> lstLeotbdAlumnoBono) {
		
		List<AlumnoBonoBean> lstAlumnoBonoBean = null;
		
		if (lstLeotbdAlumnoBono != null && lstLeotbdAlumnoBono.size() > 0) {
			
			lstAlumnoBonoBean = new ArrayList<AlumnoBonoBean>();
			
			for (int i = 0; i < lstLeotbdAlumnoBono.size(); i++) { 
				 LeotbdAlumnoBono entity = lstLeotbdAlumnoBono.get(i);
				AlumnoBonoBean bean = deAlumnoBonoAAlumnoBonoBean(entity);
				
				lstAlumnoBonoBean.add(bean);
			}
		}
		return lstAlumnoBonoBean;
	}
	private AlumnoBonoBean deAlumnoBonoAAlumnoBonoBean(LeotbdAlumnoBono entity) {
		
		AlumnoBonoBean bean = null;
		if (entity != null) {
			bean = new AlumnoBonoBean();
			bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
			bean.setUnidadLeccionBean(new UnidadLeccionBean());
			bean.setBonoBean(new BonoBean());
			bean.getBonoBean().setNombre(entity.getvNombono());
			bean.setCodigo(entity.getnCodaluxbono());
			bean.getUsuarioMatriculaBean().setCodigo(entity.getnCodusumat());
			bean.getUsuarioMatriculaBean().setCodigo(entity.getnCodusumat()); 		 
			bean.setEstado(entity.getvFlgest());
			bean.setCodigoUsuarioCreacion(entity.getnCodUsuRegistro()); 
			bean.getUnidadLeccionBean().setCodigo(entity.getnCodundlec());
			bean.getBonoBean().setTiempo(entity.getvTiempo());
			bean.getBonoBean().setCodigo(entity.getnCodbono());
			bean.getBonoBean().setTipo(new MaestraBean());
			bean.getBonoBean().getTipo().setCodigoRegistro((int)entity.getnTm1tpbono());
			
		 
			
		}
		
		return bean;
	}
	@Override
	public boolean existe(AlumnoBonoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AlumnoBonoBean> getBuscarPorFiltros(AlumnoBonoBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	 




}
