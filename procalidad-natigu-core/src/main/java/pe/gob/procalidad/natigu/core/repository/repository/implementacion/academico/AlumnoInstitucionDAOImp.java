package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoInstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaNacionalidadBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbdAlumnoinsti;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdPerlengua;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdPernacio;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.AlumnoInstitucionDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.LenguaDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.PersonaLenguaDAO;
 
@Transactional
@Repository("alumnoInstitucionDAO")
public class AlumnoInstitucionDAOImp implements AlumnoInstitucionDAO {



	@PersistenceContext
	private EntityManager em; 
	
	public AlumnoInstitucionBean getAlumnoInstitucionBean (Object object){
		return (AlumnoInstitucionBean)object;
	}
	
	


	private List<AlumnoInstitucionBean> dePersonaLenguaAListaPersonaLenguaBean(List<LeotbdAlumnoinsti> lstLeotbdAlumnoinsti) {
		List<AlumnoInstitucionBean> lstPersonaLenguaBean = null;
		
		if (lstLeotbdAlumnoinsti != null && lstLeotbdAlumnoinsti.size() > 0) {
			
			lstPersonaLenguaBean = new ArrayList<AlumnoInstitucionBean>();
			
			for (int i = 0; i < lstLeotbdAlumnoinsti.size(); i++) { 
				LeotbdAlumnoinsti entity = lstLeotbdAlumnoinsti.get(i);
				AlumnoInstitucionBean bean = deAlumnoinstiAAlumnoInstitucionBean(entity);
				
				lstPersonaLenguaBean.add(bean);
			}
		}
		
		return lstPersonaLenguaBean;
	}

	private AlumnoInstitucionBean deAlumnoinstiAAlumnoInstitucionBean(
			LeotbdAlumnoinsti entity) {

		AlumnoInstitucionBean bean = null;
		
		if (entity != null) {
			
			bean = new AlumnoInstitucionBean();
			System.out.println("entity.getNCodalumninsti() " + entity.getNCodalumninsti());
			bean.setCodigo(entity.getNCodalumninsti()); 
			
			bean.setAlumnoBean(new AlumnoBean());
			bean.getAlumnoBean().setCodigo(entity.getNCodalumno());
			
			bean.setInstitucionBean(new InstitucionBean());
			bean.getInstitucionBean().setCodigo(entity.getNCodinsti());
			bean.getInstitucionBean().setNombreInstitucion(entity.getvNominsti());
			
			
			bean.getSituacion().setCodigo(entity.getNTm1sitaluminsti());

			
		}
		
		return bean;
	}




	@Override
	public boolean insertar(AlumnoInstitucionBean t) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("AlumnoInstitucionBean DAO "+t);
		Object idPersonaLengua= null; 
		boolean sw=false;
		try {
			System.out.println("insertar DAO");
			//insertar codigoPersona, codigoLengua, codigoTipoLengua
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_alumnoinsti.insertar");
			//spq.setParameter("p_codperlen", 0);
			spq.setParameter("p_codalumno", t.getAlumnoBean().getCodigo());
			System.out.println("t.getInstitucionBean().getCodigo() "+ t.getInstitucionBean().getCodigo());
			spq.setParameter("p_codinsti", t.getInstitucionBean().getCodigo());
			spq.setParameter("p_tm1sitaluminsti", 1);
			spq.setParameter("p_codusureg", t.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", t.getIpCreacion());
			spq.execute();
			idPersonaLengua = spq.getOutputParameterValue(1);
			if (idPersonaLengua != null) {
				t.setCodigo(Integer.valueOf(idPersonaLengua.toString()));
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
	public boolean actualizar(AlumnoInstitucionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean eliminar(AlumnoInstitucionBean t) throws DAOException {
		boolean sw=false;
		try {
			System.out.println("eliminar DAO");
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_alumnoinsti.eliminar");
			spq.setParameter("p_codalumno", t.getAlumnoBean().getCodigo()); 
			System.out.println("t.getInstitucionBean().getCodigo() "+ t.getInstitucionBean().getCodigo());
			spq.setParameter("p_codinsti", t.getInstitucionBean().getCodigo()); 
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
	public AlumnoInstitucionBean getBuscarPorObjecto(AlumnoInstitucionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<AlumnoInstitucionBean> getBuscarPorFiltros(AlumnoInstitucionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public boolean existe(AlumnoInstitucionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public List<AlumnoInstitucionBean> getBuscarPorCodigoAlumno(AlumnoInstitucionBean alumnoInstitucionBean)
			throws DAOException {
		List<LeotbdAlumnoinsti>  lstPersonaLengua = null;
		List<AlumnoInstitucionBean> lstPersonaLenguaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_alumnoinsti.buscarPorcodigoPersona");	
			System.out.println("alumnoInstitucionBean.getAlumnoBean().getCodigo() "+alumnoInstitucionBean.getAlumnoBean().getCodigo());
		
			spq.setParameter("p_codalumno", alumnoInstitucionBean.getAlumnoBean().getCodigo()); 
			System.out.println("ss");
			if (spq.execute()) {
				lstPersonaLengua =  spq.getResultList(); 			
			}
			
			if (	lstPersonaLengua != null	&&	lstPersonaLengua.size() > 0) {
				
				lstPersonaLenguaBean = dePersonaLenguaAListaPersonaLenguaBean(lstPersonaLengua);
			} 

			
		return lstPersonaLenguaBean;
	}
	
}
