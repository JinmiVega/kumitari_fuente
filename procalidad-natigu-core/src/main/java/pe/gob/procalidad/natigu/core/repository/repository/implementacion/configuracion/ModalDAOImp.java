package pe.gob.procalidad.natigu.core.repository.repository.implementacion.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.ModalBean;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcModal;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.ModalDAO;

@Transactional
@Repository("modalDAO")
public class ModalDAOImp implements ModalDAO{
		
	@PersistenceContext
	private EntityManager em; 
	
	public ModalBean getModalBean(Object object){
		return (ModalBean)object;
	}
	
private List<ModalBean> deListaModalAListaModalBean(List<LeotbcModal> lstModal) {
		
		List<ModalBean> lstModalBean = null;
		
		if (lstModal != null && lstModal.size() > 0) {
			
			lstModalBean = new ArrayList<ModalBean>();
			
			for (int i = 0; i < lstModal.size(); i++) { 
				LeotbcModal entity = lstModal.get(i);
				ModalBean bean = deInscripcionAInscripcionBean(entity);
				
				lstModalBean.add(bean);
			}
		}
		
		return lstModalBean;
	}

	

	private ModalBean deInscripcionAInscripcionBean(LeotbcModal entity) {
		ModalBean bean = null;
		
		if(entity !=null){
			 bean = new ModalBean();
			 
				bean.setEstado(entity.getvFlgest());
				bean.setCodigo(entity.getnCodmoda()); 
				bean.setImagenNombre(entity.getvNomimagm());
				bean.setNombre(entity.getvNommoda());
				System.out.println("entity.getnTm1sitfond() "+ entity.getnTm1sitmoda());
				bean.getSituacion().setCodigoRegistro(entity.getnTm1sitmoda());
				bean.getSituacion().setNombreCorto(entity.getV_nomcortoSituacion());
		}
	return bean;
}

	@Override
	public boolean insertar(ModalBean modalBean) throws DAOException {
		Object idModal= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_modal.insertar");
			spq.setParameter("p_nommoda", modalBean.getNombre());
			System.out.println("modal.getSituacion().getCodigoRegistro() " + modalBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_tm1sitmoda", modalBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_nomimagm", modalBean.getImagenNombre());
			spq.setParameter("p_hostreg", "");
			spq.setParameter("p_codusureg", "1"); 
			
			
			spq.execute();
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			
			idModal = spq.getOutputParameterValue(1);
			if (idModal != null) {
				modalBean.setCodigo(Integer.valueOf(idModal.toString()));
				if (modalBean.getCodigo()==0) {
					sw=false;
				}
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
	public boolean actualizar(ModalBean modalBean) throws DAOException {

		boolean sw=false;
		System.out.println("modalBean actualizar " + modalBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_modal.actualizar");
			spq.setParameter("p_codmoda", modalBean.getCodigo()); 
			spq.setParameter("p_nommoda", modalBean.getNombre());
			spq.setParameter("p_tm1sitmoda", modalBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_nomimagm", modalBean.getImagenNombre());
			spq.setParameter("p_codusumod", 12);
			spq.setParameter("p_hostmod", ""); 
			spq.setParameter("p_nomimagm", modalBean.getImagenNombre());
			
			
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
	public boolean eliminar(ModalBean modalBean) throws DAOException {

		Object idModal= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_modal.eliminar");
			spq.setParameter("p_codmoda", modalBean.getCodigo()); 
			spq.setParameter("p_codusumod", 12);
			spq.setParameter("p_hostmod", "");
			spq.execute();   
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idModal = spq.getOutputParameterValue(1);
			if (idModal != null) {
				modalBean.setRetorno(Integer.valueOf(idModal.toString()));
				if (modalBean.getRetorno()==0) {
					sw=false;
				}
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
	public ModalBean getBuscarPorObjecto(ModalBean modalBean) throws DAOException {
		ModalBean oModalBean = null;
		List<LeotbcModal> lstLeotbcModal = null;
		System.out.println("modalBean getBuscarPorObjecto " + modalBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_modal.buscar_por_codigo");
			spq.setParameter("p_codmoda", modalBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcModal = spq.getResultList();			
			}
			
			if (	lstLeotbcModal != null
				&&	lstLeotbcModal.size() > 0) {
				
				oModalBean = deInscripcionAInscripcionBean(lstLeotbcModal.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oModalBean;
	}
	


	@Override
	public List<ModalBean> getBuscarPorFiltros(ModalBean modalBean) throws DAOException {

		System.out.println("em " + em);
		List<LeotbcModal> lstModal = null;	
		List<ModalBean> lstModalBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_modal.listar");
																			
			spq.setParameter("p_nommoda", modalBean.getNombre());  
			spq.setParameter("p_tm1sitmoda", modalBean.getSituacion().getCodigoRegistro());
			
			
			 if (spq.execute()) {
				 lstModal =  spq.getResultList(); 
			}
			if (lstModal != null && lstModal.size() > 0) {
				
				lstModalBean = deListaModalAListaModalBean(lstModal);
			}
//			em.close();
			
		   
		return lstModalBean;
		
	}

	@Override
	public boolean existe(ModalBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
}
