package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionDirectorBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdInstdirector;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.InstitucionDirectorDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;

@Transactional
@Repository("institucionDirectorDAO")
public class InstitucionDirectorDAOImpl implements InstitucionDirectorDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(InstitucionDirectorBean institucion) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("InstitucionDirector DAO "+institucion);
		Object codigoDirector= null; 
		
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstdirector.insertar");
			
			spq.setParameter("p_codperso", institucion.getPersonaBean().getCodigo());
			spq.setParameter("p_codisnti", institucion.getInstitucion().getCodigo());
			spq.setParameter("p_tm1sitdir", institucion.getSituacionDirector().getCodigoRegistro());
			spq.setParameter("p_urlwebins", institucion.getUrlWeb());
			spq.setParameter("p_telefono",institucion.getTelefono()); 
			spq.setParameter("p_correo",institucion.getCorreo());
			spq.setParameter("p_descrip", institucion.getDescripcion()); 
			
			spq.setParameter("p_codusureg", institucion.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", institucion.getIpCreacion()); 
	
			
			spq.execute();
			
			codigoDirector = spq.getOutputParameterValue(1);
			
			if (codigoDirector != null) {
				System.out.println("Ingreso a Insertar institucion");
				
				institucion.setCodigo(Long.valueOf(codigoDirector.toString()));
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
	public boolean actualizar(InstitucionDirectorBean institucion) throws DAOException {
		boolean sw=false;
		System.out.println("InstitucionDirectorBean " + institucion.getCodigo());
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstdirector.actulizar");
			spq.setParameter("p_coddirec", institucion.getCodigo());
			spq.setParameter("p_codperso", institucion.getPersonaBean().getCodigo());
			spq.setParameter("p_codisnti", institucion.getInstitucion().getCodigo());
			spq.setParameter("p_tm1sitdir", institucion.getSituacionDirector().getCodigoRegistro());
			spq.setParameter("p_urlwebins", institucion.getUrlWeb());
			spq.setParameter("p_telefono",institucion.getTelefono()); 
			spq.setParameter("p_correo",institucion.getCorreo());
			spq.setParameter("p_descrip", institucion.getDescripcion()); 
			
			spq.setParameter("p_codusumod", institucion.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", institucion.getIpModificacion()); 

			spq.execute();
			
			sw = true;
			
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(InstitucionDirectorBean institucion) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstdirector.eliminar");
			spq.setParameter("p_coddirec", institucion.getCodigo());

			spq.setParameter("p_codusumod", institucion.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod",  	institucion.getIpModificacion()); 

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
	public InstitucionDirectorBean getBuscarPorObjecto(InstitucionDirectorBean institucionBean)
			throws DAOException {
		InstitucionDirectorBean oInstitucionDirectorBean = null;
		List<LeotbdInstdirector> lstLeotbdInstdirector= null;
		System.out.println("lstInstitucionDirectorBean getBuscarPorObjecto " + institucionBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstdirector.buscarPorCodigoDirector");			
			spq.setParameter("p_coddirec", institucionBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbdInstdirector = spq.getResultList();			
			}
			
			if (	lstLeotbdInstdirector != null
				&&	lstLeotbdInstdirector.size() > 0) {
				
				oInstitucionDirectorBean = deInstitucionDirectorAInstitucionDirectorBean(lstLeotbdInstdirector.get(0));
			} 
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oInstitucionDirectorBean;
	}
private List<InstitucionDirectorBean> deListaInstitucionDirectorAListaInstitucionDirectorBean(List<LeotbdInstdirector> lstLeotbdInstdirector) {
		
		List<InstitucionDirectorBean> lstInstitucionDirectorBean = null;
		
		if (lstLeotbdInstdirector != null && lstLeotbdInstdirector.size() > 0) {
			
			lstInstitucionDirectorBean = new ArrayList<InstitucionDirectorBean>();
			
			for (int i = 0; i < lstLeotbdInstdirector.size(); i++) { 
				LeotbdInstdirector entity = lstLeotbdInstdirector.get(i);
				InstitucionDirectorBean bean = deInstitucionDirectorAInstitucionDirectorBean(entity);
				
				lstInstitucionDirectorBean.add(bean);
			}
		}
		
		return lstInstitucionDirectorBean;
	}
	
	private InstitucionDirectorBean deInstitucionDirectorAInstitucionDirectorBean(LeotbdInstdirector entity) {
		
		InstitucionDirectorBean bean = null;
		
		if (entity != null) {
			
			bean = new InstitucionDirectorBean();
			
			bean.getInstitucion().setCodigo(entity.getnCodisnti());
			bean.setCodigo(entity.getnCoddirec());
			bean.getPersonaBean().setCodigo(entity.getnCodperso());
			bean.getSituacionDirector().setCodigoRegistro(entity.getnTm1sitdir());
			bean.setUrlWeb(entity.getvUrlwebins());
			bean.setCorreo(entity.getvCorreo());
			bean.setTelefono(entity.getvTelefono());
			bean.getPersonaBean().setApellidoPaterno(entity.getvApepatper());
			bean.getPersonaBean().setApellidoMaterno(entity.getvApematper());
			bean.getPersonaBean().setNombrePersona(entity.getvNombreper());
			bean.setDescripcion(entity.getvDescrip());
			bean.setFechaCreacion(entity.getdFecreg());
 
		}
		return bean;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<InstitucionDirectorBean> getBuscarPorFiltros(InstitucionDirectorBean institucionDirectorBean) throws DAOException {
		List<LeotbdInstdirector> lstLeotbdInstdirector = null;	
		List<InstitucionDirectorBean> lstInstitucionDirectorBean = null;
		System.out.println("institucionDirectorBean.getInstitucion().getCodigo() " + institucionDirectorBean.getInstitucion().getCodigo());
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstdirector.listarPorCodigoInstitucion");
			spq.setParameter("p_codisnti", institucionDirectorBean.getInstitucion().getCodigo()); 

			if (spq.execute()) {
				lstLeotbdInstdirector =  spq.getResultList(); 
				System.out.println("lstLeotbdInstdirector.size() "+lstLeotbdInstdirector.size());
			} 
			if (lstLeotbdInstdirector != null && lstLeotbdInstdirector.size() > 0) {
				
				lstInstitucionDirectorBean = deListaInstitucionDirectorAListaInstitucionDirectorBean(lstLeotbdInstdirector);
			}
			em.close();
		   
		return lstInstitucionDirectorBean;
	}

	@Override
	public boolean existe(InstitucionDirectorBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
