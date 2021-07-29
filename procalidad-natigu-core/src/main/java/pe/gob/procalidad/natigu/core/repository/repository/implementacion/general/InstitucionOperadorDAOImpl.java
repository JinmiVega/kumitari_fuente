package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionOperadorBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcPersona;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdInstOperador;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.InstitucionOperadorDAO;

@Transactional
@Repository("institucionOperadorDAO")
public class InstitucionOperadorDAOImpl implements InstitucionOperadorDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(InstitucionOperadorBean institucion) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("InstitucionOperador DAO "+institucion);
		Object codigoOperador = null; 
		
		boolean sw = false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstoperador.insertar");
			
			spq.setParameter("p_codperso", 	institucion.getCodigoPersona());
			spq.setParameter("p_codisnti", 	institucion.getCodigoInstitucion());
			spq.setParameter("p_tm1sitope", institucion.getSituacionOperador());
			
			spq.setParameter("p_codusureg", institucion.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", 	institucion.getIpCreacion()); 
	
			
			spq.execute();
			
			codigoOperador = spq.getOutputParameterValue(1);
			
			if (codigoOperador != null) {
				System.out.println("Ingreso a Insertar institucion operador");
				
				institucion.setCodigo(Long.valueOf(codigoOperador.toString()));
				System.out.println("institucion.getCodigo()"+institucion.getCodigo());

				sw = true;
				
			}else{
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
	public boolean actualizar(InstitucionOperadorBean institucion) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstoperador.actualizar");
			
			spq.setParameter("p_codopera",  institucion.getCodigo());
			spq.setParameter("p_codperso",  institucion.getCodigoPersona());
			spq.setParameter("p_codisnti",  institucion.getCodigoInstitucion());
			spq.setParameter("p_tm1sitope", institucion.getSituacionOperador());
			
			spq.setParameter("p_codusumod", institucion.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod",   institucion.getIpModificacion()); 

			spq.execute();
			
			sw = true;
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(InstitucionOperadorBean institucion) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstoperador.eliminar");
			spq.setParameter("p_codopera", institucion.getCodigo());

			spq.setParameter("p_codusumod", institucion.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", institucion.getIpModificacion()); 

			spq.execute();
			
			sw = true;
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public InstitucionOperadorBean getBuscarPorObjecto(InstitucionOperadorBean institucionBean)
			throws DAOException {

		InstitucionOperadorBean objInstitucionOperadorBean = null;
		List<LeotbdInstOperador> lstLeotbdInstOperador= null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstoperador.buscarPorCodigo");
			spq.setParameter("p_codopera", institucionBean.getCodigo());
		
			if (spq.execute()) {
				lstLeotbdInstOperador = spq.getResultList();			
			}
			
			if (	lstLeotbdInstOperador != null
				&&	lstLeotbdInstOperador.size() > 0) {
				
				objInstitucionOperadorBean = deInstitucionOperadorAInstitucionOperadorBean(lstLeotbdInstOperador.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return objInstitucionOperadorBean;
		
	}

	@Override
	public List<InstitucionOperadorBean> getBuscarPorFiltros(InstitucionOperadorBean institucion) throws DAOException {
		List<LeotbdInstOperador> lstLeotbdInstOperador = null;	
		List<InstitucionOperadorBean> lstInstitucionOperadorBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstoperador.listar");
			spq.setParameter("p_codisnti", institucion.getCodigoInstitucion()); 
			spq.setParameter("p_codperso", institucion.getPersonaBean().getCodigo()); 
			
			if (spq.execute()) {
				lstLeotbdInstOperador =  spq.getResultList(); 
			} 
			if (lstLeotbdInstOperador != null && lstLeotbdInstOperador.size() > 0) {
				
				lstInstitucionOperadorBean = deListaInstitucionOperadorAListaInstitucionOperadorBean(lstLeotbdInstOperador);
			}
			//em.close();
		   
		return lstInstitucionOperadorBean;
	}

	@Override
	public boolean existe(InstitucionOperadorBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private List<InstitucionOperadorBean> deListaInstitucionOperadorAListaInstitucionOperadorBean(List<LeotbdInstOperador> lstLeotbdInstOperador) {
		
		List<InstitucionOperadorBean> lstInstitucionOperadorBean = null;
		
		if (lstLeotbdInstOperador != null && lstLeotbdInstOperador.size() > 0) {
			
			lstInstitucionOperadorBean = new ArrayList<InstitucionOperadorBean>();
			
			for (int i = 0; i < lstLeotbdInstOperador.size(); i++) { 
				LeotbdInstOperador entity = lstLeotbdInstOperador.get(i);
				InstitucionOperadorBean bean = deInstitucionOperadorAInstitucionOperadorBean(entity);
				
				lstInstitucionOperadorBean.add(bean);
			}
		}
		
		return lstInstitucionOperadorBean;
	}
	
	private InstitucionOperadorBean deInstitucionOperadorAInstitucionOperadorBean(LeotbdInstOperador entity) {
		
		InstitucionOperadorBean bean = null;
		
		if (entity != null) {
			
			bean = new InstitucionOperadorBean();
			
			bean.setCodigo(entity.getnCodopera());
			bean.setCodigoInstitucion(entity.getnCodinsti());
			bean.setCodigoPersona(entity.getnCodperso());
			bean.setSituacionOperador(entity.getnTm1sitope());
			bean.setFechaCreacion(entity.getdFecreg());
			
			bean.setNombreSituacion(entity.getvNomSituacion());
			
			bean.setPersonaBean(new PersonaBean());
			bean.getPersonaBean().setCodigo(entity.getnCodperso());
			bean.getPersonaBean().setNombrePersona(entity.getvNombrePer());
			bean.getPersonaBean().setApellidoPaterno(entity.getvApePatPer());
			bean.getPersonaBean().setApellidoMaterno(entity.getvApeMatPer());
			bean.getPersonaBean().setNombreCompleto(bean.getPersonaBean().getNombreCompleto());
			bean.getPersonaBean().getTipoDocumento().setCodigoRegistro(entity.getnTm1TpDoPe());
			bean.getPersonaBean().setNumeroDocumento(entity.getvNumDocum());
			bean.getPersonaBean().setTelefono(entity.getvTelefono());
			bean.getPersonaBean().setCorreo(entity.getvCorreo());
			
			bean.getCargo().setNombreCorto(entity.getNombreCargo());

		}
		return bean;
	}

}