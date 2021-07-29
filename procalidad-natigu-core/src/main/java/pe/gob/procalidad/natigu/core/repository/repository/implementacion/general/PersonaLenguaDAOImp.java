package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaNacionalidadBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdPerlengua;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdPernacio;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.LenguaDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.PersonaLenguaDAO;
 
@Transactional
@Repository("personaLenguaDAO")
public class PersonaLenguaDAOImp implements PersonaLenguaDAO {



	@PersistenceContext
	private EntityManager em; 
	
	public PersonaLenguaBean getPersonaLenguaBean (Object object){
		return (PersonaLenguaBean)object;
	}
	
	
	@Override
	public boolean insertar(PersonaLenguaBean personaLenguaBean) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("personaLenguaBean DAO "+personaLenguaBean);
		Object idPersonaLengua= null; 
		boolean sw=false;
		try {
			//insertar codigoPersona, codigoLengua, codigoTipoLengua
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdperlengua.insertar");
			//spq.setParameter("p_codperlen", 0);
			spq.setParameter("p_codperso", personaLenguaBean.getPersonaBean().getCodigo());
			spq.setParameter("p_codlengua", personaLenguaBean.getLenguaBean().getCodigo());
			spq.setParameter("p_tm1tipolengua", personaLenguaBean.getTipoLengua().getCodigo());
			spq.setParameter("p_codusureg", personaLenguaBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", personaLenguaBean.getIpCreacion());
			spq.execute();
			idPersonaLengua = spq.getOutputParameterValue(1);
			if (idPersonaLengua != null) {
				personaLenguaBean.setCodigo(Integer.valueOf(idPersonaLengua.toString()));
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
	public boolean actualizar(PersonaLenguaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(PersonaLenguaBean personaLenguaBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdperlengua.eliminar");
			spq.setParameter("p_codperso", personaLenguaBean.getPersonaBean().getCodigo()); 
			spq.setParameter("p_codlengua", personaLenguaBean.getLenguaBean().getCodigo()); 
			spq.setParameter("p_tm1tipolengua", personaLenguaBean.getTipoLengua().getCodigo()); 
			spq.setParameter("p_codusumod", personaLenguaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", personaLenguaBean.getIpModificacion());
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
	public PersonaLenguaBean getBuscarPorObjecto(PersonaLenguaBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonaLenguaBean> getBuscarPorFiltros(PersonaLenguaBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(PersonaLenguaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<PersonaLenguaBean> getBuscarPorCodigoPersona(PersonaLenguaBean personaLenguaBean) throws DAOException {
		List<LeotbdPerlengua>  lstPersonaLengua = null;
		List<PersonaLenguaBean> lstPersonaLenguaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdperlengua.buscarPorcodigoPersona");	
			System.out.println(personaLenguaBean.getPersonaBean().getCodigo());
			spq.setParameter("p_codperso", personaLenguaBean.getPersonaBean().getCodigo()); 
			System.out.println("ss");
			if (spq.execute()) {
				lstPersonaLengua =  spq.getResultList(); 			
			}
			
			if (	lstPersonaLengua != null	&&	lstPersonaLengua.size() > 0) {
				
				lstPersonaLenguaBean = dePersonaLenguaAListaPersonaLenguaBean(lstPersonaLengua);
			} 

			
		return lstPersonaLenguaBean;
	}


	private List<PersonaLenguaBean> dePersonaLenguaAListaPersonaLenguaBean(
			List<LeotbdPerlengua> lstPersonaLengua) {
		List<PersonaLenguaBean> lstPersonaLenguaBean = null;
		
		if (lstPersonaLengua != null && lstPersonaLengua.size() > 0) {
			
			lstPersonaLenguaBean = new ArrayList<PersonaLenguaBean>();
			
			for (int i = 0; i < lstPersonaLengua.size(); i++) { 
				LeotbdPerlengua entity = lstPersonaLengua.get(i);
				PersonaLenguaBean bean = dePersonaLenguaAPersonaLenguaBean(entity);
				
				lstPersonaLenguaBean.add(bean);
			}
		}
		
		return lstPersonaLenguaBean;
	}

	private PersonaLenguaBean dePersonaLenguaAPersonaLenguaBean(
			LeotbdPerlengua entity) {

		PersonaLenguaBean bean = null;
		
		if (entity != null) {
			
			bean = new PersonaLenguaBean();
			bean.setCodigo(entity.getNCodperlen()); 
			
			bean.setPersonaBean(new PersonaBean());
			bean.getPersonaBean().setCodigo(entity.getNCodperso());
			
			bean.setLenguaBean(new LenguaBean());
			bean.getLenguaBean().setCodigo(entity.getNCodlengua());
			bean.getLenguaBean().setNombre(entity.getVNomlengua());
			
			bean.setTipoLengua(new MaestraBean());
			bean.getTipoLengua().setCodigo(entity.getNTm1tipolengua());
			bean.getTipoLengua().setNombreCorto(entity.getVTm1tipolengua());

			
		}
		
		return bean;
	}
	
}
