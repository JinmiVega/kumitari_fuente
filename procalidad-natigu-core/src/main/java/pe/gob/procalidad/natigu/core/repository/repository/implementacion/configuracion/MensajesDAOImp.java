package pe.gob.procalidad.natigu.core.repository.repository.implementacion.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MensajesBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcMensajes;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcInstitucion;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.MensajesDAO;
@Repository("mensajesDAO")
@Transactional(readOnly = true)
public class MensajesDAOImp implements MensajesDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(MensajesBean mensajesBean) throws DAOException {

		System.out.println("mensajesBean DAO "+mensajesBean);
		Object idMensaje= null; 
		
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_mensajes.insertar");
			
			spq.setParameter("p_codlengua",mensajesBean.getLenguaBean().getCodigo());
			spq.setParameter("p_mensaje", mensajesBean.getMensajes());
			spq.setParameter("p_tm2tipomensaje", mensajesBean.getTipoMensaje().getCodigoRegistro());
			spq.setParameter("p_codusureg", mensajesBean.getCodigoUsuarioCreacion());
						
			spq.setParameter("p_hostreg", mensajesBean.getIpCreacion());
			
			spq.execute();
			
			idMensaje = spq.getOutputParameterValue(1);
			
			if (idMensaje != null) {
				
				
				mensajesBean.setCodigo(Long.valueOf(idMensaje.toString()));
				System.out.println("mensajesBean.getCodigo()"+mensajesBean.getCodigo());

				
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
	public boolean actualizar(MensajesBean mensajesBean) throws DAOException {	
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_mensajes.actulizar");
			spq.setParameter("p_codmensajes",mensajesBean.getCodigo());
			spq.setParameter("p_codlengua",mensajesBean.getLenguaBean().getCodigo());
			spq.setParameter("p_mensaje", mensajesBean.getMensajes());
			spq.setParameter("p_tm2tipomensaje", mensajesBean.getTipoMensaje().getCodigoRegistro());
			spq.setParameter("p_codusumod", mensajesBean.getCodigoUsuarioModificacion());
						
			spq.setParameter("p_hostmod", mensajesBean.getIpModificacion());
			
			spq.execute();
			
			sw = true;

		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(MensajesBean mensajesBean) throws DAOException {
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_mensajes.eliminar");
			spq.setParameter("p_codmensajes",mensajesBean.getCodigo());			
			spq.setParameter("p_codusumod", mensajesBean.getCodigoUsuarioModificacion());
						
			spq.setParameter("p_hostmod", mensajesBean.getIpModificacion());
			
			spq.execute();
			
			sw = true;

		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public MensajesBean getBuscarPorObjecto(MensajesBean mensajesBean) throws DAOException {
		MensajesBean oMensajesBean = null;
		List<LeotbcMensajes> lstLeotbcMensajes = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_mensajes.buscarPorCodigo");			
			spq.setParameter("p_codmensajes", mensajesBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcMensajes = spq.getResultList();			
			}
			
			if (	lstLeotbcMensajes != null
				&&	lstLeotbcMensajes.size() > 0) {
				
				oMensajesBean = deMensajesAMensajesBean(lstLeotbcMensajes.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oMensajesBean;
	}

	@Override
	public List<MensajesBean> getBuscarPorFiltros(MensajesBean mensajesBean)
			throws DAOException {
		System.out.println("em " + em);
		List<LeotbcMensajes> lstLeotbcMensajes = null;	
		List<MensajesBean> lstMensajesBeans = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_mensajes.buscarPorFiltros");
			spq.setParameter("p_codlengua", mensajesBean.getLenguaBean().getCodigo());
			spq.setParameter("p_tm2tipomensaje", mensajesBean.getTipoMensaje()!=null? mensajesBean.getTipoMensaje().getCodigoRegistro():null);
 
			
			if (spq.execute()) {
				lstLeotbcMensajes =  spq.getResultList(); 
			} 
			if (lstLeotbcMensajes != null && lstLeotbcMensajes.size() > 0) {
				
				lstMensajesBeans = deListaMensajesAListaMensajesBean(lstLeotbcMensajes);
			}
			//em.close();
		   
		return lstMensajesBeans;
	}
	private List<MensajesBean> deListaMensajesAListaMensajesBean(List<LeotbcMensajes> lstLeotbcMensajes) {
		
		List<MensajesBean> lstMensajesBeans = null;
		
		if (lstLeotbcMensajes != null && lstLeotbcMensajes.size() > 0) {
			
			lstMensajesBeans = new ArrayList<MensajesBean>();
			
			for (int i = 0; i < lstLeotbcMensajes.size(); i++) { 
				LeotbcMensajes entity = lstLeotbcMensajes.get(i);
				MensajesBean bean = deMensajesAMensajesBean(entity);
				
				lstMensajesBeans.add(bean);
			}
		}
		
		return lstMensajesBeans;
	}
	private MensajesBean deMensajesAMensajesBean(LeotbcMensajes entity) {
		
		MensajesBean bean = null;
		
		if (entity != null) {
			
			bean = new MensajesBean();
			bean.setMensajes(entity.getVmensaje());
			bean.setCodigo(entity.getnCodmensajes());
			bean.getTipoMensaje().setCodigoRegistro(entity.getN_tm2tipomensaje());
			bean.getTipoMensaje().setNombreCorto(entity.getvNomcorto());
			bean.getLenguaBean().setCodigo(entity.getNcodlengua());
			bean.getLenguaBean().setNombre(entity.getvNomlengua());

			
			
		}
		
		return bean;
	}
	@Override
	public boolean existe(MensajesBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
