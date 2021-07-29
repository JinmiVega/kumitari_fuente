package pe.gob.procalidad.natigu.core.repository.repository.implementacion.seguridad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaAccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaDetalleBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaTablaBean;
import pe.gob.procalidad.natigu.core.entity.entity.seguridad.LeotbcAuditoria;
import pe.gob.procalidad.natigu.core.entity.entity.seguridad.LeotbcAuditoriaAcceso;
import pe.gob.procalidad.natigu.core.entity.entity.seguridad.LeotbcAuditoriaTabla;
import pe.gob.procalidad.natigu.core.entity.entity.seguridad.LeotbdAuditoriaDetalle;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.seguridad.AuditoriaDAO;

@Transactional
@Repository("auditoriaDAO")
public class AuditoriaDAOImp implements AuditoriaDAO {

	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public boolean insertar(AuditoriaBean t) throws DAOException {
		return false;
	}

	@Override
	public boolean actualizar(AuditoriaBean t) throws DAOException {
		return false;
	}

	@Override
	public boolean eliminar(AuditoriaBean t) throws DAOException {
		return false;
	}

	@Override
	public AuditoriaBean getBuscarPorObjecto(AuditoriaBean t) throws DAOException {
		return null;
	}

	@Override
	public List<AuditoriaBean> getBuscarPorFiltros(AuditoriaBean auditoriaBean)
			throws DAOException {
		List<AuditoriaBean> lstAuditoriaBean = new ArrayList<AuditoriaBean>();
		List<LeotbcAuditoria> lstEntity = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_auditoria.listar");
			spq.setParameter("p_codusuari", auditoriaBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_tabla", auditoriaBean.getNomTabla());
			spq.setParameter("p_nomusuari", auditoriaBean.getNomUsuario());
			spq.setParameter("p_codperfil", auditoriaBean.getCodPerfil());
			spq.setParameter("p_codaccion", auditoriaBean.getTipoAccion().getCodigoRegistro());
			spq.setParameter("p_fecinicio", auditoriaBean.getStrFecInicio());
			spq.setParameter("p_fecfin", auditoriaBean.getStrFecFin());
			spq.setParameter("p_limite", auditoriaBean.getLimite());
		
			if (spq.execute()) {
				lstEntity = spq.getResultList();			
			}
			
			if (	lstEntity != null
				&&	lstEntity.size() > 0) {
				for (LeotbcAuditoria leotbcAuditoria : lstEntity) {
					lstAuditoriaBean.add(deAuditoriaToAuditoriaBean(leotbcAuditoria));
				}
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return lstAuditoriaBean;
	}

	@Override
	public boolean existe(AuditoriaBean t) throws DAOException {
		return false;
	}

	@Override
	public List<AuditoriaTablaBean> listarTablas(AuditoriaTablaBean prmAuditoriaTablaBean) throws DAOException {
		List<AuditoriaTablaBean> lstAuditoriaTablaBean = new ArrayList<AuditoriaTablaBean>();
		List<LeotbcAuditoriaTabla> lstEntity = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcaudtablas.listar_combo");
			spq.setParameter("p_flgoffline", prmAuditoriaTablaBean.getFlgoffline()); 
		
			if (spq.execute()) {
				lstEntity = spq.getResultList();			
			}
			
			if (	lstEntity != null
				&&	lstEntity.size() > 0) {
				for (LeotbcAuditoriaTabla leotbcAuditoriaTabla : lstEntity) {
					lstAuditoriaTablaBean.add(deAuditoriaTablaToAuditoriaTablaBean(leotbcAuditoriaTabla));
				}
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return lstAuditoriaTablaBean;
	}

	@Override
	public List<AuditoriaDetalleBean> listarAuditoriaDetalle(AuditoriaDetalleBean prmAuditoriaDetalleBean)
			throws DAOException {
		List<AuditoriaDetalleBean> lstAuditoriaBean = new ArrayList<AuditoriaDetalleBean>();
		List<LeotbdAuditoriaDetalle> lstEntity = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_auditoria_detalle.listar");
			spq.setParameter("p_codaud", prmAuditoriaDetalleBean.getAuditoriaBean().getCodigo()); 
		
			if (spq.execute()) {
				lstEntity = spq.getResultList();			
			}
			
			if (	lstEntity != null
				&&	lstEntity.size() > 0) {
				for (LeotbdAuditoriaDetalle leotbcAuditoriaDet : lstEntity) {
					lstAuditoriaBean.add(deAuditoriaDetalleToAuditoriaDetalleBean(leotbcAuditoriaDet));
				}
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return lstAuditoriaBean;
	}
	
	@Override
	public boolean insertarAuditoriaAcceso(AuditoriaAccesoBean prmAuditoriaAccesoBean) throws DAOException {
		Object  id = null; 
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcauditoriaacceso.insertar");
	        spq.setParameter("p_tm1accion", prmAuditoriaAccesoBean.getTipoAccion()!=null ? prmAuditoriaAccesoBean.getTipoAccion().getCodigoRegistro() : null);
	        spq.setParameter("p_usuacc", prmAuditoriaAccesoBean.getNomUsuario());
	        spq.setParameter("p_hostacc", prmAuditoriaAccesoBean.getIpCreacion());
	        spq.setParameter("p_tm1sistem", prmAuditoriaAccesoBean.getTipoSistema()!=null ? prmAuditoriaAccesoBean.getTipoSistema().getCodigoRegistro() : null);
	        
	        spq.execute();
			
			id = spq.getOutputParameterValue(1);
			
			if (id != null) {
				prmAuditoriaAccesoBean.setCodigo(Integer.valueOf(id.toString()));
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

	@Override
	public List<AuditoriaAccesoBean> listarAuditoriaAcceso(AuditoriaAccesoBean prmAuditoriaAccesoBean)
			throws DAOException {
		List<AuditoriaAccesoBean> lstBean = new ArrayList<AuditoriaAccesoBean>();
		List<LeotbcAuditoriaAcceso> lstEntity = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcauditoriaacceso.listar");
			spq.setParameter("p_codusuari", prmAuditoriaAccesoBean.getCodUsuAcc());
			spq.setParameter("p_codperfil", prmAuditoriaAccesoBean.getCodPerfil());
			spq.setParameter("p_codaccion", prmAuditoriaAccesoBean.getTipoAccion()!=null ? prmAuditoriaAccesoBean.getTipoAccion().getCodigoRegistro() : null);
			spq.setParameter("p_nomusuari", prmAuditoriaAccesoBean.getNomUsuario());
			spq.setParameter("p_fecinicio", prmAuditoriaAccesoBean.getStrFecInicio());
			spq.setParameter("p_fecfin", prmAuditoriaAccesoBean.getStrFecFin());
			spq.setParameter("p_limite", prmAuditoriaAccesoBean.getLimite());
			spq.setParameter("p_codsistem", prmAuditoriaAccesoBean.getTipoSistema()!=null ? prmAuditoriaAccesoBean.getTipoSistema().getCodigoRegistro() : null);
			
			if (spq.execute()) {
				lstEntity = spq.getResultList();			
			}
			
			if (	lstEntity != null
				&&	lstEntity.size() > 0) {
				for (LeotbcAuditoriaAcceso leotbcAuditoriaAcc : lstEntity) {
					lstBean.add(deAuditoriaAccesoToAuditoriaAccesoBean(leotbcAuditoriaAcc));
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
	
	private AuditoriaBean deAuditoriaToAuditoriaBean(LeotbcAuditoria entity){
		AuditoriaBean bean = null;
		
		if(entity!=null){
			bean = new AuditoriaBean();
			bean.setCodigo(entity.getnCodaudit());
			bean.setNomTabla(entity.getvTabla());
			bean.getTipoAccion().setCodigoRegistro(entity.getnTm1accion());
			bean.getTipoAccion().setNombreCorto(entity.getV_nomacc_aud());
			bean.setCodRegistroAud(entity.getnCodregaud()!=null ? entity.getnCodregaud() : 0);
			bean.setFechaCreacion(entity.getdFecaud());
			bean.setCodigoUsuarioCreacion(entity.getnCodusuaud()!=null ? entity.getnCodusuaud() : 0);
			bean.setIpCreacion(entity.getvHostaud());
			bean.setNomUsuario(entity.getV_nomusu_aud());
			bean.setNomPersonaUsu(entity.getV_nompers_aud());
		}
		
		return bean;
	}
	
	private AuditoriaTablaBean deAuditoriaTablaToAuditoriaTablaBean(LeotbcAuditoriaTabla entity){
		AuditoriaTablaBean bean = null;
		
		if(entity!=null){
			bean = new AuditoriaTablaBean();
			bean.setCodigo(entity.getnCodaudtab());
			bean.setNomEsquema(entity.getvEsquema());
			bean.setNomTabla(entity.getvTabla());
			bean.setNomCampo(entity.getvCampo());
			bean.setFlgauditar(entity.getvFlgauditar());
			bean.setFlgprincipal(entity.getvFlgprincipal());
			bean.setFlgoffline(entity.getvFlgoffline());
			bean.setDescEsquema(entity.getvDescesque());
			bean.setDescTabla(entity.getvDesctabla());
			bean.setDescCampo(entity.getvDesccampo());
			
			//bean.setNomEsqTabConcat1(entity.getNomEsqTabText_1());
			//bean.setNomEsqTabConcat2(entity.getNomEsqTabText_2());
			bean.setNomEsqTabConcat1(entity.getvEsquema()+"-"+entity.getvTabla());
			bean.setNomEsqTabConcat2(entity.getvEsquema()+"."+entity.getvTabla());
		}
		
		return bean;
	}
	
	private AuditoriaDetalleBean deAuditoriaDetalleToAuditoriaDetalleBean(LeotbdAuditoriaDetalle entity){
		AuditoriaDetalleBean bean = null;
		
		if(entity!=null){
			bean = new AuditoriaDetalleBean();
			bean.setCodigo(entity.getnCodauddet());
			bean.getAuditoriaBean().setCodigo(entity.getnCodaudit());
			bean.setNomCampo(entity.getvCampo());
			bean.setValorAnterior(entity.getvValorant());
			bean.setValorNuevo(entity.getvValornue());
			bean.setNomTabla(entity.getvTabla());
			bean.setNomEsquema(entity.getvEsquema());
		}
		
		return bean;
	}
	
	private AuditoriaAccesoBean deAuditoriaAccesoToAuditoriaAccesoBean(LeotbcAuditoriaAcceso entity){
		AuditoriaAccesoBean bean = null;
		
		if(entity!=null){
			bean = new AuditoriaAccesoBean();
			bean.setCodigo(entity.getnCodaudacc());
			bean.getTipoAccion().setCodigoRegistro(entity.getnTm1accion());
			bean.getTipoAccion().setNombreCorto(entity.getV_nomaccion());
			bean.setFechaCreacion(entity.getdFecacc());
			bean.setCodUsuAcc(entity.getN_codusuari());
			bean.setNomUsuario(entity.getVnomUsuacc());
			bean.setIpCreacion(entity.getvHostacc());
			bean.setNomTabla(entity.getV_tabla());
			bean.setNomPersonaUsu(entity.getV_nomperusu());
			bean.getTipoSistema().setCodigoRegistro(entity.getnTm1sistem());
			bean.getTipoSistema().setNombreCorto(entity.getV_nomsistem());
		}
		
		return bean;
	}

}