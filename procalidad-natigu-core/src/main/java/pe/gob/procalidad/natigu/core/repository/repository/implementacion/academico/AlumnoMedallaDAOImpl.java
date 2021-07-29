package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMedallaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMonedaGBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbcAlumno;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbdAlumnoMedalla;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.AlumnoMedallaDAO;
@Transactional(readOnly = true)
@Repository("alumnoMedallaDAO")
public class AlumnoMedallaDAOImpl implements AlumnoMedallaDAO{

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(AlumnoMedallaBean Bean)
			throws DAOException {
		System.out.println("AlumnoMedallaBean" + Bean);
		boolean sw = false;
		Object cod = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_alumnoxmedalla.insertar");
			spq.setParameter("p_codusumat", Bean.getUsuarioMatriculaBean().getCodigo());
			spq.setParameter("p_codcateg", Bean.getCodcateg()); 
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
	public boolean actualizar(AlumnoMedallaBean alumnoMedallaBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(AlumnoMedallaBean alumnoMedallaBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AlumnoMedallaBean getBuscarPorObjecto(AlumnoMedallaBean alumnoMedallaBean)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlumnoMedallaBean> getBuscarPorFiltros(AlumnoMedallaBean alumnoMedallaBean)
			throws DAOException {
		System.out.println("em " + em);
		List<LeotbdAlumnoMedalla> lstLeotbdAlumnoMedalla = null;	
		List<AlumnoMedallaBean> lstAlumnoMedallaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_alumnoxmedalla.buscarPorFiltros");
			spq.setParameter("p_codlengua", alumnoMedallaBean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().getCodigo());  
 			
			if (spq.execute()) {
				lstLeotbdAlumnoMedalla =  spq.getResultList(); 
			} 
			if (lstLeotbdAlumnoMedalla != null && lstLeotbdAlumnoMedalla.size() > 0) {
				
				lstAlumnoMedallaBean = deListaAlumnoMedallaAListaAlumnoMedallaBean(lstLeotbdAlumnoMedalla);
			}
			//em.close();
		   
		return lstAlumnoMedallaBean;
	}
	private List<AlumnoMedallaBean> deListaAlumnoMedallaAListaAlumnoMedallaBean(List<LeotbdAlumnoMedalla> lstLeotbdAlumnoMedalla) {
		
		List<AlumnoMedallaBean> lstAlumnoMedallaBean = null;
		
		if (lstLeotbdAlumnoMedalla != null && lstLeotbdAlumnoMedalla.size() > 0) {
			
			lstAlumnoMedallaBean = new ArrayList<AlumnoMedallaBean>();
			
			for (int i = 0; i < lstLeotbdAlumnoMedalla.size(); i++) { 
				LeotbdAlumnoMedalla entity = lstLeotbdAlumnoMedalla.get(i);
				AlumnoMedallaBean bean = deAlumnoMedallaAAlumnoMedallaBean(entity);
				
				lstAlumnoMedallaBean.add(bean);
			}
		}
		return lstAlumnoMedallaBean;
	}
	private AlumnoMedallaBean deAlumnoMedallaAAlumnoMedallaBean(LeotbdAlumnoMedalla entity) {
		
		AlumnoMedallaBean bean = null;
		if (entity != null) {
			bean = new AlumnoMedallaBean();
			bean.setCodigo(entity.getnCodaluxmeda());
			bean.getUsuarioMatriculaBean().setCodigo(entity.getnCodusumat());
			bean.getPremioBean().setNombre(entity.getvNomimag());	
			bean.getPremioBean().getTipo().setCodigoRegistro(entity.getnTm1tpprem());
			bean.getPremioBean().setImagenNombre(entity.getvNomimag());
			
		}
		
		return bean;
	}
	@Override
	public boolean existe(AlumnoMedallaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AlumnoMedallaBean> getBuscarPorAlumno(
			AlumnoMedallaBean alumnoMedallaBean) throws DAOException {
		System.out.println("em " + em);
		List<LeotbdAlumnoMedalla> lstLeotbdAlumnoMedalla = null;	
		List<AlumnoMedallaBean> lstAlumnoMedallaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_alumnoxmedalla.buscarPorAlumno");
			spq.setParameter("p_codlengua", alumnoMedallaBean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().getCodigo());  
			spq.setParameter("p_codusumat", alumnoMedallaBean.getUsuarioMatriculaBean().getCodigo()); 
			
			if (spq.execute()) {
				lstLeotbdAlumnoMedalla =  spq.getResultList(); 
			} 
			if (lstLeotbdAlumnoMedalla != null && lstLeotbdAlumnoMedalla.size() > 0) {
				
				lstAlumnoMedallaBean = deListaAlumnoMedallaAListaAlumnoMedallaBean(lstLeotbdAlumnoMedalla);
			}
			//em.close();
		   
		return lstAlumnoMedallaBean;
	}
	




}
