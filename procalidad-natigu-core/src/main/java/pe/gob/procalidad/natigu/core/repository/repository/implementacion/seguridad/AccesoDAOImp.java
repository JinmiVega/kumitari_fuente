package pe.gob.procalidad.natigu.core.repository.repository.implementacion.seguridad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PerfilBean;
import pe.gob.procalidad.natigu.core.entity.entity.seguridad.LeotbcAcceso;
import pe.gob.procalidad.natigu.core.entity.entity.seguridad.LeotbcPerfil;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.seguridad.AccesoDAO;

@Transactional
@Repository("accesoDAO")
public class AccesoDAOImp implements AccesoDAO {

	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public boolean insertar(AccesoBean t) throws DAOException {
		
		/*Object id= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_acceso.insertar");
	       // spq.setParameter("p_codacceso", t.getp_codacceso());
            spq.setParameter("p_codperfil", t.getPerfil()!=null? t.getPerfil().getCodigoPerfil():null);
            spq.setParameter("p_codcompo", t.getComponente()!=null? t.getComponente().getCodigoComponente():null);
            spq.setParameter("p_flgasi", t.getFlgAsignado());
            spq.setParameter("p_codusureg", t.getAudCodigoUsuario());
            spq.setParameter("p_hostreg", t.getAudHostIP());
            spq.setParameter("p_flgread", t.isFlgRead()? "1":"0");
            spq.setParameter("p_flgwrite", t.isFlgWrite()? "1":"0");
            spq.setParameter("p_flgdelete", t.isFlgDelete()? "1":"0");
	        
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
		}*/
		return false;//sw;
	}

	@Override
	public boolean actualizar(AccesoBean t) throws DAOException {
		
		/*boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_acceso.actualizar");
			spq.setParameter("p_codacceso", t.getCodigoAcceso());
            spq.setParameter("p_flgasi", t.getFlgAsignado());
            spq.setParameter("p_codusumod", t.getAudCodigoUsuario());
            spq.setParameter("p_hostmod", t.getAudHostIP());
            spq.setParameter("p_flgread", t.isFlgRead()? "1":"0");
            spq.setParameter("p_flgwrite", t.isFlgWrite()? "1":"0");
            spq.setParameter("p_flgdelete", t.isFlgDelete()? "1":"0");
	        
	        spq.execute();
			sw=true;
				
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}*/
		return false;//sw;
	}

	@Override
	public boolean eliminar(AccesoBean t) throws DAOException {
		
		/*boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_acceso.eliminar");
			spq.setParameter("p_codacceso", t.getCodigoAcceso());
            spq.setParameter("p_codusumod", t.getAudCodigoUsuario());
            spq.setParameter("p_hostmod", t.getAudHostIP());
	        
	        spq.execute();
			sw=true;
				
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}*/
		return false;//sw;
	}

	@Override
	public AccesoBean getBuscarPorObjecto(AccesoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccesoBean> getBuscarPorFiltros(AccesoBean accesoBean)
			throws DAOException {
		List<AccesoBean> lstAccesoBean = new ArrayList<AccesoBean>();
		List<LeotbcAcceso> lstEntity = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_acceso.listar");
			spq.setParameter("p_codperfil", accesoBean.getPerfil().getCodigo());
	        spq.setParameter("p_codcompadre", accesoBean.getComponente().getCodigoComponentePadre()); 
		
			if (spq.execute()) {
				lstEntity = spq.getResultList();			
			}
			
			if (	lstEntity != null
				&&	lstEntity.size() > 0) {
				for (LeotbcAcceso leotbcAcceso : lstEntity) {
					lstAccesoBean.add(deAccesoToAccesoBean(leotbcAcceso));
				}
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return lstAccesoBean;
	}

	@Override
	public boolean existe(AccesoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean asignar(AccesoBean bean) throws DAOException {
		Object id  = null; 
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_acceso.asignar");
	        spq.setParameter("p_codacceso", bean.getCodigo());
            spq.setParameter("p_flgasi", bean.getFlgAsignado());
            spq.setParameter("p_flgread", bean.isFlgRead()? "1":"0");
            spq.setParameter("p_flgwrite", bean.isFlgRead()? "1":"0");
            spq.setParameter("p_flgdelete", bean.isFlgDelete()? "1":"0");
            spq.setParameter("p_flgexport", bean.isFlgExport()? "1":"0");
            spq.setParameter("p_codperfil", bean.getPerfil().getCodigo());
            spq.setParameter("p_codcompo",  bean.getComponente().getCodigo());
            spq.setParameter("p_codusu", 1);
            spq.setParameter("p_host", "192.168.1.140");
	        
	        spq.execute();
			
			id = spq.getOutputParameterValue(1);
			if (id != null) {
				bean.setCodigo(Integer.valueOf(id.toString()));
				sw = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw = false; 
		}finally{
			em.close();
		}
		return sw;
	}
	
	private AccesoBean deAccesoToAccesoBean(LeotbcAcceso entity){
		AccesoBean bean = null;
		
		if(entity!=null){
			bean = new AccesoBean();
			bean.setItem(entity.getnItem());
			bean.setCodigo(entity.getnCodacceso());
			bean.getComponente().setCodigo(entity.getnCodcompo());
			bean.getComponente().setNombreComponente(entity.getvNomcompo());
			bean.getComponente().setDescripcion(entity.getvDescompo());
			bean.getComponente().setCodigoComponentePadre(entity.getnCodcompa());
			bean.setFlgAsignado(entity.getvFlgasi());
			bean.setFlgRead(entity.getvFlgread()!= null && entity.getvFlgread().equals("1") ? true : false);
			bean.setFlgWrite(entity.getvFlgwrite()!= null && entity.getvFlgwrite().equals("1") ? true : false);
			bean.setFlgDelete(entity.getvFlgdelete()!= null && entity.getvFlgdelete().equals("1") ? true : false);
			bean.setFlgExport(entity.getvFlgexport()!= null && entity.getvFlgexport().equals("1") ? true : false);
		}
		
		return bean;
	}

}