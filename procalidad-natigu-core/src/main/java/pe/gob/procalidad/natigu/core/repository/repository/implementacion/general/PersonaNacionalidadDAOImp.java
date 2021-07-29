package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaNacionalidadBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdPernacio;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.PersonaNacionalidadDAO;
 
@Transactional
@Repository("personaNacionalidadDAO")
public class PersonaNacionalidadDAOImp implements PersonaNacionalidadDAO {


	@PersistenceContext
	private EntityManager em; 
	
	public PersonaNacionalidadBean getPersonaNacionalidadBean(Object object){
		return (PersonaNacionalidadBean)object;
	}
	
	@Override
	public boolean insertar(PersonaNacionalidadBean personaNacionalidadBean) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("personaNacionalidadBean DAO "+personaNacionalidadBean);
		Object idPersonaNacionalidad= null; 
		boolean sw=false;
		try {
			//insertar nacionalidad
			System.out.println("codigo de alumno : "+personaNacionalidadBean.getCodigo());
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdpernacio.insertar");
		//  spq1.setParameter("p_codpernac", personaNacionalidadBean.getCodigo());
			spq.setParameter("p_codperso", personaNacionalidadBean.getPersonaBean().getCodigo());
			spq.setParameter("p_tm2pais", personaNacionalidadBean.getNacionalidad().getCodigo());
			spq.setParameter("p_codusureg", personaNacionalidadBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", personaNacionalidadBean.getIpCreacion());
			spq.execute();
			idPersonaNacionalidad = spq.getOutputParameterValue(1);
			if (idPersonaNacionalidad != null) {
				personaNacionalidadBean.setCodigo(Integer.valueOf(idPersonaNacionalidad.toString()));
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
	public boolean actualizar(PersonaNacionalidadBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(PersonaNacionalidadBean personaNacionalidadBean) throws DAOException {
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdpernacio.eliminar");
			spq.setParameter("p_codperso", personaNacionalidadBean.getPersonaBean().getCodigo()); 
			spq.setParameter("p_tm2pais", personaNacionalidadBean.getNacionalidad().getCodigo()); 
			spq.setParameter("p_codusumod", personaNacionalidadBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", personaNacionalidadBean.getIpModificacion());
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
	public PersonaNacionalidadBean getBuscarPorObjecto(PersonaNacionalidadBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonaNacionalidadBean> getBuscarPorFiltros(
			PersonaNacionalidadBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<PersonaNacionalidadBean> getBuscarPorCodigoPersona(PersonaNacionalidadBean personaNacionalidadBean) throws DAOException {
		List<LeotbdPernacio>  lstPersonaNacionalidad = null;
		List<PersonaNacionalidadBean> lstPersonaNacionalidadBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdpernacio.buscarPorcodigoPersona");	
			System.out.println(personaNacionalidadBean.getPersonaBean().getCodigo());
			spq.setParameter("p_codperso", personaNacionalidadBean.getPersonaBean().getCodigo()); 
			System.out.println("ss");
			if (spq.execute()) {
				lstPersonaNacionalidad =  spq.getResultList(); 			
			}
			
			if (	lstPersonaNacionalidad != null	&&	lstPersonaNacionalidad.size() > 0) {
				
				lstPersonaNacionalidadBean = dePersonaNacionalidadAListaPersonaNacionalidadBean(lstPersonaNacionalidad);
			} 

			
		return lstPersonaNacionalidadBean;
	}

	

	@Override
	public boolean existe(PersonaNacionalidadBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	
	private List<PersonaNacionalidadBean> dePersonaNacionalidadAListaPersonaNacionalidadBean(
			List<LeotbdPernacio> lstPersonaNacionalidad) {

		List<PersonaNacionalidadBean> lstPersonaNacionalidadBean = null;
		
		if (lstPersonaNacionalidad != null && lstPersonaNacionalidad.size() > 0) {
			
			lstPersonaNacionalidadBean = new ArrayList<PersonaNacionalidadBean>();
			
			for (int i = 0; i < lstPersonaNacionalidad.size(); i++) { 
				LeotbdPernacio entity = lstPersonaNacionalidad.get(i);
				PersonaNacionalidadBean bean = dePersonaNacionalidadAPersonaNacionalidadBean(entity);
				
				lstPersonaNacionalidadBean.add(bean);
			}
		}
		
		return lstPersonaNacionalidadBean;
	}

	private PersonaNacionalidadBean dePersonaNacionalidadAPersonaNacionalidadBean(
			LeotbdPernacio entity) {

		PersonaNacionalidadBean bean = null;
		
		if (entity != null) {
			
			bean = new PersonaNacionalidadBean();
			bean.setCodigo(entity.getNCodpernac()); 
			
			bean.setPersonaBean(new PersonaBean());
			bean.getPersonaBean().setCodigo(entity.getNCodperso());
			
			bean.setNacionalidad(new MaestraBean());
			bean.getNacionalidad().setCodigo(entity.getNTm2pais());
			bean.getNacionalidad().setNombreCorto(entity.getVTm2pais());
			
		}
		
		return bean;
	}
	

}
