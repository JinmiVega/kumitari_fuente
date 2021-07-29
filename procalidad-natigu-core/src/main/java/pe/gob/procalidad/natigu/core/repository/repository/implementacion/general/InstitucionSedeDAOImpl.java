package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionSedeBean; 
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdInstSede;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.InstitucionSedeDAO;

@Transactional
@Repository("institucionSedeDAO")
public class InstitucionSedeDAOImpl implements InstitucionSedeDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(InstitucionSedeBean institucionSede)
			throws DAOException {
		System.out.println("InstitucionSede DAO "+institucionSede);
		Object codigoInstSede= null; 
		
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstsede.insertar");
			
			//spq.setParameter("p_codsede", institucionSede.getCodigo());
			spq.setParameter("p_codinsti", institucionSede.getInstitucionBean().getCodigo());
			spq.setParameter("p_nomsede", institucionSede.getNombreSede());
			spq.setParameter("p_telefono", institucionSede.getTelefono());
			spq.setParameter("p_correo", institucionSede.getCorreo());
			spq.setParameter("p_dirinstit", institucionSede.getDireccionInstitucion());
			spq.setParameter("p_contacto", institucionSede.getContacto());
			spq.setParameter("p_codubigeo", institucionSede.getCodigoRegion() + institucionSede.getCodigoProvincia() + institucionSede.getCodigoDistrito());
			spq.setParameter("p_codusureg", institucionSede.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", institucionSede.getIpCreacion());
			spq.execute();
			codigoInstSede = spq.getOutputParameterValue(1);
			
			if (codigoInstSede != null) {	
				institucionSede.setCodigo(Long.valueOf(codigoInstSede.toString()));
				System.out.println("codSede:"+institucionSede.getCodigo());
				sw = true;	
			}else{
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
	public boolean actualizar(InstitucionSedeBean institucionSede)
			throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em
					.createNamedStoredProcedureQuery("leotbdinstsede.actualizar");
			spq.setParameter("p_codsede", institucionSede.getCodigo());
			spq.setParameter("p_codisnti", institucionSede.getInstitucionBean().getCodigo());
			spq.setParameter("p_nomsede", institucionSede.getNombreSede());
			spq.setParameter("p_telefono", institucionSede.getTelefono());
			spq.setParameter("p_correo", institucionSede.getCorreo());
			spq.setParameter("p_dirinstit", institucionSede.getDireccionInstitucion());
			spq.setParameter("p_contacto", institucionSede.getContacto());
			spq.setParameter("p_codubigeo", institucionSede.getCodigoRegion() + institucionSede.getCodigoProvincia() + institucionSede.getCodigoDistrito());
			//spq.setParameter("p_codprovin", institucionSede.getCodigoProvincia());
			//spq.setParameter("p_coddistri", institucionSede.getCodigoDistrito());
			spq.setParameter("p_codusumod", institucionSede.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", institucionSede.getIpModificacion());
			spq.execute();
			sw = true;
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(InstitucionSedeBean institucionSede)
			throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em
					.createNamedStoredProcedureQuery("leotbdinstsede.eliminar");
			spq.setParameter("p_codsede", institucionSede.getCodigo());
			spq.setParameter("p_codusumod", institucionSede.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", institucionSede.getIpModificacion());
			spq.execute();
			sw = true;
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public InstitucionSedeBean getBuscarPorObjecto(
			InstitucionSedeBean institucionSede) throws DAOException {
		InstitucionSedeBean oInstitucionSedeBean = null;
		List<LeotbdInstSede> lstInstitucionSede = null;
		System.out.println("lenguaBean getBuscarPorObjecto " + institucionSede.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstsede.listar_x_codigo");			
			/*spq.setParameter("p_codinsti",(int) institucionSede.getCodigo()); 
			spq.setParameter("p_codsede", (int) institucionSede.getCodigo());*/
			//spq.setParameter("p_codisnti",(int) institucionSede.getInstitucionBean().getCodigo()); 
			spq.setParameter("p_codsede",  institucionSede.getCodigo());
			if (spq.execute()) {
				lstInstitucionSede = spq.getResultList();			
			}
			if (	lstInstitucionSede != null
				&&	lstInstitucionSede.size() > 0) {
				oInstitucionSedeBean = deInstitucionSedeAInstitucionSedeBean(lstInstitucionSede.get(0));
			} 
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oInstitucionSedeBean;
	}

	@Override
	public List<InstitucionSedeBean> getBuscarPorFiltros(
			InstitucionSedeBean institucionSede) throws DAOException {
		System.out.println("em " + em);
		List<LeotbdInstSede> lstInstSede = null;
		List<InstitucionSedeBean> lstInstSedeBean = null;
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstsede.listar");
		spq.setParameter("p_codisnti", institucionSede.getInstitucionBean().getCodigo());
		if (spq.execute()) {
			lstInstSede = spq.getResultList();
		}
		if (lstInstSede != null && lstInstSede.size() > 0) {
			lstInstSedeBean = deListaInstitucionSedeAListaInstitucionSedeBean(lstInstSede);
		}
		// em.close();
		return lstInstSedeBean;
	}

	@Override
	public boolean existe(InstitucionSedeBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	private List<InstitucionSedeBean> deListaInstitucionSedeAListaInstitucionSedeBean(
			List<LeotbdInstSede> lstInstitucionSede) {
		List<InstitucionSedeBean> lstInstitucionSedeBean = null;
		if (lstInstitucionSede != null && lstInstitucionSede.size() > 0) {
			lstInstitucionSedeBean = new ArrayList<InstitucionSedeBean>();
			for (int i = 0; i < lstInstitucionSede.size(); i++) {
				LeotbdInstSede entity = lstInstitucionSede.get(i);
				InstitucionSedeBean bean = deInstitucionSedeAInstitucionSedeBean(entity);
				lstInstitucionSedeBean.add(bean);
			}
		}
		return lstInstitucionSedeBean;
	}

	private InstitucionSedeBean deInstitucionSedeAInstitucionSedeBean(
			LeotbdInstSede entity) {
		InstitucionSedeBean bean = null;
		if (entity != null) {
			bean = new InstitucionSedeBean();
			bean.setCodigo(entity.getnCodsede());
			bean.setNombreSede(entity.getvNomsede());
			bean.setDireccionInstitucion(entity.getvDirinstit());
			bean.setTelefono(entity.getvTelefono());
			bean.setCorreo(entity.getvCorreo());
			bean.setContacto(entity.getvContacto());
			bean.getInstitucionBean().setCodigo(entity.getnCodisnti());
			bean.getUbigeoRegionBean().setNombreUbigeo(entity.getnDesregion());
			bean.getUbigeoProvinBean().setNombreUbigeo(entity.getnDesprovin());
			bean.getUbigeoDistriBean().setNombreUbigeo(entity.getnDesdistri());
			bean.setCodigoRegion(entity.getnCodregion());
			bean.setCodigoProvincia(entity.getnCodprovin());
			bean.setCodigoDistrito(entity.getnCoddistri());
			
		}
		return bean;
	}

	@Override
	public List<InstitucionSedeBean> listaInsticionSedes() throws DAOException {
		List<LeotbdInstSede> lstInstitucionSede = null;	
		List<InstitucionSedeBean> lstInstitucionSedeBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdinstsede.listar");			
			if (spq.execute()) {
				lstInstitucionSede =  spq.getResultList(); 
			} 
			if (lstInstitucionSede != null && lstInstitucionSede.size() > 0) {
				
				lstInstitucionSedeBean = deListaInstitucionSedeAListaInstitucionSedeBean(lstInstitucionSede);
			}
			//em.close();
		   
		return lstInstitucionSedeBean;
	}

}
