package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcInstitucion;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.InstitucionDAO;
 
@Transactional
@Repository("institucionDAO")
public class InstitucionDAOImp implements InstitucionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public InstitucionBean getInstitucionBean(Object object){
		return (InstitucionBean)object;
	}

 
	private List<InstitucionBean> deListaInstitucionAListaInstitucionBean(List<LeotbcInstitucion> lstInstitucion) {
		
		List<InstitucionBean> lstInstitucionBean = null;
		
		if (lstInstitucion != null && lstInstitucion.size() > 0) {
			
			lstInstitucionBean = new ArrayList<InstitucionBean>();
			
			for (int i = 0; i < lstInstitucion.size(); i++) { 
				LeotbcInstitucion entity = lstInstitucion.get(i);
				InstitucionBean bean = deInstitucionAInstitucionBean(entity);
				
				lstInstitucionBean.add(bean);
			}
		}
		
		return lstInstitucionBean;
	}
	
	private InstitucionBean deInstitucionAInstitucionBean(LeotbcInstitucion entity) {
		
		InstitucionBean bean = null;
		
		if (entity != null) {
			
			bean = new InstitucionBean();
			
			bean.setCodigo(entity.getnCodInstitucion()); 
			bean.setNombreInstitucion(entity.getvNomInstitucion()); 
			bean.setDescripcion(entity.getvDescripcion());
			bean.getTipoInstitucion().setCodigoRegistro(entity.getnTm1tpinst());
			bean.getTipoActividad().setCodigoRegistro(entity.getnTm1tpact());
			bean.getSituacion().setCodigoRegistro(entity.getnTm1sitinst());
			bean.setNumeroUgel(entity.getvNumUgel());
			bean.setCodigoModular(entity.getvCodModulo());
			bean.setCodigoLocal(entity.getvCodLocal());
			bean.getSituacion().setNombreCorto(entity.getNombreSituacion());
			bean.getTipoInstitucion().setNombreCorto(entity.getNombreTipoInstitucion());
			bean.setDireccionInstitucion(entity.getvDirinstit());
			bean.getTipoAreaGeografica().setCodigoRegistro(entity.getnTm1tParge());
			bean.setLatitud(entity.getvLatitud());
			bean.setLongitud(entity.getVlongitud());
			bean.setUrlPaginaWeb(entity.getvUrlPagWeb());
			bean.setCorreo(entity.getvCorreo());
			bean.setTelefono(entity.getvTelefono());
			bean.setNombreCorto(entity.getvNomcorto());
			
			if (entity.getvCodubigeo() != null) {
				
				bean.getUbigeoBean().setCodigoRegion(""+entity.getvCodubigeo().charAt(0)+entity.getvCodubigeo().charAt(1));
				System.out.println("bean.getUbigeoBean().getCodigoRegion()"+bean.getUbigeoBean().getCodigoRegion());
				bean.getUbigeoBean().setCodigoProvincia(""+entity.getvCodubigeo().charAt(2)+entity.getvCodubigeo().charAt(3));
				System.out.println("bean.getUbigeoBean().getCodigoProvincia()"+bean.getUbigeoBean().getCodigoProvincia());
				bean.getUbigeoBean().setCodigoDistrito(""+entity.getvCodubigeo().charAt(4)+entity.getvCodubigeo().charAt(5));
				System.out.println("bean.getUbigeoBean().getCodigoDistrito() "+bean.getUbigeoBean().getCodigoDistrito());
			}
//			System.out.println("entity.getvCodubigeo()"+ entity.getvCodubigeo());
//			System.out.println("entity.getvCodubigeo().substring(0, 2)"+entity.getvCodubigeo().substring(0, 2));
//			bean.getUbigeoBean().setCodigoRegion(entity.getvCodubigeo().substring(0, 2));
//			bean.getUbigeoBean().setCodigoProvincia(entity.getvCodubigeo().substring(2, 5));
//			bean.getUbigeoBean().setCodigoDistrito(entity.getvCodubigeo().substring(5, 7));
	
			/******/
			bean.getUbigeoBean().setCodigoUbigeo(entity.getvCodubigeo());
			bean.getUbigeoBean().setNombreUbigeo(entity.getNombreubigeo());
//			System.out.println("entity.getvNomInstitucion() :"+entity.getvNomInstitucion());
			
			
		}
		
		return bean;
	}


	@Override
	public boolean insertar(InstitucionBean institucion) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("institucion DAO "+institucion);
		Object idInstitucion= null; 
		
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcInstitucion.insertar");
			
			spq.setParameter("p_tm1sitinst",institucion.getSituacion().getCodigoRegistro());
			spq.setParameter("p_nomcorto", institucion.getNombreCorto());
			spq.setParameter("p_nominsti", institucion.getNombreInstitucion());
			spq.setParameter("p_descripc", institucion.getDescripcion());
			spq.setParameter("p_coddirec", 0);
			spq.setParameter("p_codsitins",institucion.getCodsitins()); 
			spq.setParameter("p_tm1tpinst",institucion.getTipoInstitucion().getCodigoRegistro());
			spq.setParameter("p_tm1tpact", institucion.getTipoActividad().getCodigoRegistro()); 
			
			spq.setParameter("p_numugel", institucion.getNumeroUgel());
			spq.setParameter("p_codmodul", institucion.getCodigoModular()); 
			spq.setParameter("p_codlocal", institucion.getCodigoLocal());
			spq.setParameter("p_codubigeo",institucion.getUbigeoBean().getCodigoUbigeo());
			
			spq.setParameter("p_dirinstit","");
			spq.setParameter("p_tm1tparge", 0);
			spq.setParameter("p_latitud", ""); 
			spq.setParameter("p_longitud", "");
			spq.setParameter("p_urlpagweb", "");
			
			spq.setParameter("p_telefono", "");
			spq.setParameter("p_correo", ""); 
			spq.setParameter("p_codusureg", institucion.getCodigoUsuarioCreacion());
						
			spq.setParameter("p_hostreg", institucion.getIpCreacion());
			
			spq.execute();
			
			idInstitucion = spq.getOutputParameterValue(1);
			
			if (idInstitucion != null) {
				System.out.println("Ingreso a Insertar institucion");
				
				institucion.setCodigo(Long.valueOf(idInstitucion.toString()));
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
	public boolean actualizar(InstitucionBean institucion) throws DAOException {
	boolean sw =  false;
		
		System.out.println("Ingreso a modificar");
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcInstitucion.actualizar");
			
			spq.setParameter("p_codisnti", institucion.getCodigo());
			spq.setParameter("p_nomcorto", institucion.getNombreCorto());
			spq.setParameter("p_nominsti", institucion.getNombreInstitucion());
			spq.setParameter("p_descripc", institucion.getDescripcion());
			spq.setParameter("p_tm1sitinst", institucion.getSituacion().getCodigoRegistro());
			spq.setParameter("p_tm1tpinst",institucion.getTipoInstitucion().getCodigoRegistro());
			spq.setParameter("p_tm1tpact", institucion.getTipoActividad().getCodigoRegistro()); 
			
			spq.setParameter("p_numugel", institucion.getNumeroUgel());
			spq.setParameter("p_codmodul", institucion.getCodigoModular()); 
			spq.setParameter("p_codlocal", institucion.getCodigoLocal() );
			spq.setParameter("p_codusumod", institucion.getCodigoUsuarioModificacion());
						
			spq.setParameter("p_hostmod", institucion.getIpModificacion());
			
			spq.execute();
			sw =  true;
				
		} catch (Exception e) {
			
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return sw;
	}


	@Override
	public boolean eliminar(InstitucionBean institucion) throws DAOException {
		boolean sw =  false;
		
		System.out.println("Ingreso a eliminar  institucion.");
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcInstitucion.eliminar");
			
			spq.setParameter("p_codinsti", institucion.getCodigo());

			spq.setParameter("p_codusumod", institucion.getCodigoUsuarioModificacion());						
			spq.setParameter("p_hostmod", institucion.getIpModificacion());
			
			spq.execute();
			sw = true;
			
			System.out.println("Se logro  a  eliminar exitosamente.");
			
		} catch (Exception e) {
			
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return sw;
	}


	@Override
	public InstitucionBean getBuscarPorObjecto(InstitucionBean institucionBean) throws DAOException {
		InstitucionBean oInstitucionBean = null;
		List<LeotbcInstitucion> lstInstitucion = null;
		System.out.println("lenguaBean getBuscarPorObjecto " + institucionBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcInstitucion.buscarPorCodigo");			
			spq.setParameter("p_codinsti", institucionBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstInstitucion = spq.getResultList();			
			}
			
			if (	lstInstitucion != null
				&&	lstInstitucion.size() > 0) {
				
				oInstitucionBean = deInstitucionAInstitucionBean(lstInstitucion.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oInstitucionBean;
	}


	@Override
	public List<InstitucionBean> getBuscarPorFiltros(InstitucionBean institucion) throws DAOException {
		System.out.println("em " + em);
		List<LeotbcInstitucion> lstInstitucion = null;	
		List<InstitucionBean> lstInstitucionBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcInstitucion.listar");
			spq.setParameter("p_nominsti", institucion.getNombreInstitucion()); 
			spq.setParameter("p_tm1sitinst",institucion.getSituacion().getCodigoRegistro()); 
			spq.setParameter("p_tm1tpinst", institucion.getTipoInstitucion().getCodigoRegistro()); 
			spq.setParameter("p_codregion", institucion.getUbigeoBean().getCodigoRegion()); 
 
			
			if (spq.execute()) {
				lstInstitucion =  spq.getResultList(); 
			} 
			if (lstInstitucion != null && lstInstitucion.size() > 0) {
				
				lstInstitucionBean = deListaInstitucionAListaInstitucionBean(lstInstitucion);
			}
			//em.close();
		   
		return lstInstitucionBean;
	}


	@Override
	public boolean existe(InstitucionBean inistiInstitucionBean) throws DAOException {
		List<LeotbcInstitucion> lstLeotbcInstitucions = null;
		System.out.println("Ingreso a validar si existe institucion");
		boolean sw = false;
		try {
			StoredProcedureQuery spq  = em.createNamedStoredProcedureQuery("leotbcInstitucion.listarExiste");
			spq.setParameter("p_codisnti", inistiInstitucionBean.getCodigo());
			spq.setParameter("p_nomcorto", inistiInstitucionBean.getNombreCorto());
						
			if (spq.execute()) {				
				lstLeotbcInstitucions = spq.getResultList();
				
				if (lstLeotbcInstitucions != null && lstLeotbcInstitucions.size() > 0) {
					System.out.println("Si  exisre una institucion cono ese nombre.");
					return true;
				}else{
					System.out.println("No existe institucion con ese  nombre.");
					return false;
				}				
			}else{
				
				System.out.println("Error al procesar funcion de validar.");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return sw;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<InstitucionBean> getListarCombo(InstitucionBean InstitucionBean) throws DAOException {
		List<LeotbcInstitucion> lstInstitucion = null;	
		List<InstitucionBean> lstInstitucionBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcInstitucion.listarCombo");
	 
			
			if (spq.execute()) {
				lstInstitucion =  spq.getResultList(); 
			} 
			if (lstInstitucion != null && lstInstitucion.size() > 0) {
				System.out.println("lstInstitucion.size() " + lstInstitucion.size());
				lstInstitucionBean = deListaInstitucionAListaInstitucionBean(lstInstitucion);
			}
			//em.close();
		   
		return lstInstitucionBean;
	}


	@Override
	public boolean actulizarUbicacion(InstitucionBean institucion)
			throws DAOException {
		boolean sw =  false;
		
		System.out.println("Ingreso a modificar  institucion.");
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcInstitucion.actulizarUbicacion");
			
			spq.setParameter("p_codisnti", institucion.getCodigo());
		
			spq.setParameter("p_codubigeo",institucion.getUbigeoBean().getCodigoUbigeo());
			
			spq.setParameter("p_dirinstit", institucion.getDireccionInstitucion());
			spq.setParameter("p_tm1tparge", institucion.getTipoAreaGeografica().getCodigoRegistro());
			spq.setParameter("p_latitud", institucion.getLatitud()); 
			spq.setParameter("p_longitud", institucion.getLongitud() );
			spq.setParameter("p_urlpagweb", institucion.getUrlPaginaWeb());
			
			spq.setParameter("p_telefono", institucion.getTelefono());
			spq.setParameter("p_correo", institucion.getCorreo()); 
			spq.setParameter("p_codusumod", institucion.getCodigoUsuarioModificacion());
						
			spq.setParameter("p_hostmod", institucion.getIpModificacion());
			
			spq.execute();
			sw =  true;
			
			System.out.println("Se logro  a  modificar exitosamente.");
			
		} catch (Exception e) {
			
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return sw;
	}


	@Override
	public boolean actulizarDirector(InstitucionBean institucion)throws DAOException {
		System.out.println("Ingreso a modificar  director.");
		boolean sw =  false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcInstitucion.actulizarDirector");
			
			spq.setParameter("p_codisnti", (int)(institucion.getCodigo()));
		
			spq.setParameter("p_coddirec", 1);
			spq.setParameter("p_urlpagweb", "");
			
			spq.setParameter("p_telefono","");
			spq.setParameter("p_correo", ""); 
			spq.setParameter("p_codusumod", 1);
						
			spq.setParameter("p_hostmod", "192.168.1.131");
			
			spq.execute();
			sw =  true;
			
			System.out.println("Se logro  a  modificar director exitosamente.");
			
		} catch (Exception e) {
			
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return sw;
	}


	@Override
	public List<InstitucionBean> lsitarDirectores() throws DAOException {
		List<LeotbcInstitucion> lstInstitucion = null;	
		List<InstitucionBean> lstInstitucionBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcInstitucion.listarDirectores");			
			
			if (spq.execute()) {
				lstInstitucion =  spq.getResultList(); 
			} 
			if (lstInstitucion != null && lstInstitucion.size() > 0) {
				
				lstInstitucionBean = deListaInstitucionAListaInstitucionBean(lstInstitucion);
			}
			//em.close();
		   
		return lstInstitucionBean;
	}
	

	@Override
	public List<InstitucionBean> listarInstitucionxTipoUsuario(UsuarioBean usuarioBean) throws DAOException {
		List<LeotbcInstitucion> lstInstitucion = null;	
		List<InstitucionBean> lstInstitucionBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcInstitucion.listarPorTipoUsuario");			
			spq.setParameter("p_codperso", usuarioBean.getPersona().getCodigo());			
			spq.setParameter("p_codperfil", usuarioBean.getCodPerfilUsuSelec());
			
			if (spq.execute()) {
				lstInstitucion =  spq.getResultList(); 
			} 
			if (lstInstitucion != null && lstInstitucion.size() > 0) {
				lstInstitucionBean = deListaInstitucionAListaInstitucionBean(lstInstitucion);
			}
			em.close();
		return lstInstitucionBean;
	}
}
