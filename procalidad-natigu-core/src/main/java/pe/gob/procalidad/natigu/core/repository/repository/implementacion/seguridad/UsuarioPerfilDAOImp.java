package pe.gob.procalidad.natigu.core.repository.repository.implementacion.seguridad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PerfilBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioPerfilBean;
import pe.gob.procalidad.natigu.core.entity.entity.seguridad.LeotbcPerfil;
import pe.gob.procalidad.natigu.core.entity.entity.seguridad.LeotbcUsuario;
import pe.gob.procalidad.natigu.core.entity.entity.seguridad.LeotbdUsuperfil;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.seguridad.UsuarioPerfilDAO;

@Transactional
@Repository("usuarioPerfilDAO")
public class UsuarioPerfilDAOImp implements UsuarioPerfilDAO{

	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public boolean insertar(UsuarioPerfilBean t) throws DAOException {
		Object id= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_usuperfil.insertar");
	       // spq.setParameter("p_codusuper", t.getp_codacceso());
            spq.setParameter("p_codperfil", t.getPerfil()!=null? t.getPerfil().getCodigoPerfil():null);
            spq.setParameter("p_codusuari", t.getUsuario()!=null? t.getUsuario().getCodigoUsuario():null);
            spq.setParameter("p_codusureg", t.getCodigoUsuarioCreacion());
            spq.setParameter("p_hostreg", t.getIpCreacion());
	        
	        spq.execute();
			
			id = spq.getOutputParameterValue(1);
			if (id != null) {
				t.setCodigo(Integer.valueOf(id.toString()));
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
	public boolean actualizar(UsuarioPerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(UsuarioPerfilBean t) throws DAOException {
		Object id= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_usuperfil.eliminar");
	        spq.setParameter("p_codusuper", t.getCodigoUsuarioPerfil());
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
	public UsuarioPerfilBean getBuscarPorObjecto(UsuarioPerfilBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioPerfilBean> getBuscarPorFiltros(UsuarioPerfilBean t)
			throws DAOException {
		List<UsuarioPerfilBean> lstBean = new ArrayList<UsuarioPerfilBean>();
		List<LeotbdUsuperfil> lstEntity = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_usuperfil.listar");
			
			spq.setParameter("p_codusuari", t.getUsuario()!=null? t.getUsuario().getCodigoUsuario():null);
			spq.setParameter("p_codperfil", t.getPerfil()!=null? t.getPerfil().getCodigoPerfil():null);
			
		
			if (spq.execute()) {
				lstEntity = spq.getResultList();			
			}
			
			if (	lstEntity != null
				&&	lstEntity.size() > 0) {
				for (LeotbdUsuperfil leotbdUsuperfil : lstEntity) {
					lstBean.add(deUsuarioPerfilToUsuarioPerfilBean(leotbdUsuperfil));
				}
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return lstBean;
	}

	@Override
	public boolean existe(UsuarioPerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private UsuarioPerfilBean deUsuarioPerfilToUsuarioPerfilBean(LeotbdUsuperfil entity){
		UsuarioPerfilBean bean = new UsuarioPerfilBean();
		if(entity!=null){
			bean.setCodigoUsuarioPerfil(entity.getNCodusuper());
			if(entity.getNCodperfil()!=null){
				bean.setPerfil(new PerfilBean());
				bean.getPerfil().setCodigoPerfil(entity.getNCodperfil());
				bean.getPerfil().setNombrePerfil(entity.getvNomperfil());
			}
			if(entity.getNCodusuari()!=null){
				bean.setUsuario(new UsuarioBean());
				bean.getUsuario().setCodigoUsuario(entity.getNCodusuari());
				bean.getUsuario().setNombreUsuario(entity.getvNomusuari());
				bean.getUsuario().setPasswordUsuario(entity.getvPassusuar());
			}
			bean.setEstado(entity.getVFlgest());
			
			/**/
			if (entity.getnCodperso()!=null) {
				bean.getUsuario().setPersona(new PersonaBean());
				bean.getUsuario().getPersona().setCodigo(entity.getnCodperso());
				bean.getUsuario().getPersona().getLenguaBean().setMatriculaBean(new MatriculaBean());
				bean.getUsuario().getPersona().setNombreCompleto(entity.getvNomperson());
				bean.getUsuario().getPersona().setCorreo(entity.getvCorreo());
				bean.getUsuario().getPersona().setTelefono(entity.getvTelefono());
				bean.getUsuario().getPersona().getLenguaBean().getMatriculaBean().getInsti().setNombreInstitucion(entity.getvNominsti());
				bean.getUsuario().getPersona().setNombrefotouser(entity.getvNombfotop());
				bean.getUsuario().setUltfechaAcceso(entity.getvFecacc());
				bean.getUsuario().getPersona().getLenguaBean().getMatriculaBean().setAlumnoBean(new AlumnoBean());
				bean.getUsuario().getPersona().getLenguaBean().getMatriculaBean().setDocenteBean(new DocenteBean());
				
				if(entity.getnCodalumno() != null){
					bean.getUsuario().getPersona().getLenguaBean().getMatriculaBean().getAlumnoBean().setCodigo(entity.getnCodalumno());
				}
				if(entity.getnCoddocen() != null){
					bean.getUsuario().getPersona().getLenguaBean().getMatriculaBean().getDocenteBean().setCodigo(entity.getnCoddocen());
				}
				
			}
			
		}
		return bean;
	}

	@Override
	public UsuarioPerfilBean buscarXcodigoUsu(UsuarioPerfilBean usuarioPerfilBean) throws DAOException {
		UsuarioPerfilBean objUsuarioBean = null;
		List<LeotbdUsuperfil> lstLeotbcUsuario = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_usuperfil.buscarxcodigo");
		
			spq.setParameter("p_codusuari", usuarioPerfilBean.getCodigoUsuario());
		
			if (spq.execute()) {
				lstLeotbcUsuario = spq.getResultList();			
			}
			
			if (	lstLeotbcUsuario != null
				&&	lstLeotbcUsuario.size() > 0) {
				
				objUsuarioBean = deUsuarioPerfilToUsuarioPerfilBean(lstLeotbcUsuario.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return objUsuarioBean;
	}

}
