package pe.gob.procalidad.natigu.core.repository.repository.implementacion.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.CombosCabBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.FondoBean;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcComboCab;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcFondo;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.ComboCabDAO;

@Transactional
@Repository("comboCabDAO")
public class ComboCabDAOImpl implements ComboCabDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(CombosCabBean comboCabBean) throws DAOException {
		Object idArmarDocumentoCab = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbccombocab.insertar");
			//spq.setParameter("p_combocab", comboCabBean.getCodigo());
			spq.setParameter("p_titulo", comboCabBean.getTitulo());
			spq.setParameter("p_descripcion", comboCabBean.getDescripcion());
			spq.setParameter("p_nomimg", comboCabBean.getNombreImagen());
			spq.setParameter("p_monto", comboCabBean.getMonto());
			spq.setParameter("p_codmasco", comboCabBean.getMascotaBean().getCodigo());
			spq.setParameter("p_codfond", comboCabBean.getFondoBean().getCodigo());
			spq.setParameter("p_monedas", comboCabBean.getMonedas());
			spq.setParameter("p_gemas", comboCabBean.getGemas());
			spq.setParameter("p_tm1sitcombo", comboCabBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_codusureg", comboCabBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", comboCabBean.getIpCreacion());
			
			spq.execute();
			sw=true;
			idArmarDocumentoCab = spq.getOutputParameterValue(1);
			if(idArmarDocumentoCab != null)
			{	 
				comboCabBean.setCodigo(Integer.valueOf(idArmarDocumentoCab.toString()));
				if (comboCabBean.getCodigo()==0) {
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
	public boolean actualizar(CombosCabBean comboCabBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbccombocab.actualizar");
			spq.setParameter("p_combocab", comboCabBean.getCodigo());
			spq.setParameter("p_titulo", comboCabBean.getTitulo());
			spq.setParameter("p_descripcion", comboCabBean.getDescripcion());
			spq.setParameter("p_nomimg", comboCabBean.getNombreImagen());
			spq.setParameter("p_monto", comboCabBean.getMonto());
			spq.setParameter("p_codmasco", comboCabBean.getMascotaBean().getCodigo());
			spq.setParameter("p_codfond", comboCabBean.getFondoBean().getCodigo());
			spq.setParameter("p_monedas", comboCabBean.getMonedas());
			spq.setParameter("p_gemas", comboCabBean.getGemas());
			spq.setParameter("p_tm1sitcombo", comboCabBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_codusumod", comboCabBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", comboCabBean.getIpModificacion());
			
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
	public boolean eliminar(CombosCabBean comboCabBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbccombocab.eliminar");
			spq.setParameter("p_combocab", comboCabBean.getCodigo());
			spq.setParameter("p_codusumod", comboCabBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", comboCabBean.getIpModificacion());
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
	public CombosCabBean getBuscarPorObjecto(CombosCabBean comboCabBean) throws DAOException {
		List<LeotbcComboCab> 	lstPregunta 	= null;
		CombosCabBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbccombocab.buscar_por_codigo");
		spq.setParameter("p_combocab", 	comboCabBean.getCodigo());
		if (spq.execute()) {
			lstPregunta =  spq.getResultList(); 
		} 
		if (lstPregunta != null && lstPregunta.size() > 0) {
			bean = deComboCabeceraAComboCabeceraBean(lstPregunta.get(0));
		}
		return bean;

	}

	@Override
	public List<CombosCabBean> getBuscarPorFiltros(CombosCabBean comboCabBean) throws DAOException {
		List<LeotbcComboCab> 	lstEntity 	= null;
		List<CombosCabBean> 	lstBean = null;
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbccombocab.buscar_x_filtros");
		spq.setParameter("p_titulo", comboCabBean.getTitulo());
		spq.setParameter("p_tm1sitcombo", comboCabBean.getEstado());
		if (spq.execute()) {
			lstEntity =  spq.getResultList(); 
		} 
		if (lstEntity != null && lstEntity.size() > 0) 
		{			
			lstBean = deListaCombosCabeceraAListaCombosCabeceraBean(lstEntity);
		}
		return lstBean;
	}

	@Override
	public boolean existe(CombosCabBean comboCabBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private List<CombosCabBean> deListaCombosCabeceraAListaCombosCabeceraBean(List<LeotbcComboCab> lstPregunta) 
	{
		List<CombosCabBean> lstPreguntaBean = null;
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{
			lstPreguntaBean = new ArrayList<CombosCabBean>();
			for (int i = 0; i < lstPregunta.size(); i++) 
			{ 
				LeotbcComboCab entity = lstPregunta.get(i);
				CombosCabBean bean = deComboCabeceraAComboCabeceraBean(entity);
				lstPreguntaBean.add(bean);
			}
		}
		return lstPreguntaBean;
	}
	

	private CombosCabBean deComboCabeceraAComboCabeceraBean(LeotbcComboCab entity) {
		CombosCabBean bean = null;
		if (entity != null) {
			bean = new CombosCabBean();
			bean.setCodigo(entity.getnCmbocab());
			bean.setTitulo(entity.getvTitulo());
			bean.setDescripcion(entity.getvDescripcion());
			bean.setNombreImagen(entity.getvNomimg());
			bean.setMonto(entity.getvMonto());
			bean.getMascotaBean().setCodigo(entity.getnCodmasco());
			bean.getFondoBean().setCodigo(entity.getnCodfond());
			bean.setMonedas(entity.getnMonedas());
			bean.setGemas(entity.getnGemas());
			bean.setEstado(entity.getvFlgest());
			bean.getSituacion().setNombreCorto(entity.getV_nomcorto());
			bean.getMascotaBean().setNombre(entity.getV_nommasco());
			bean.getFondoBean().setNombre(entity.getV_nomfond());
			bean.getSituacion().setCodigoRegistro(entity.getnTm1sitcombo());	
			bean.setCantidadComprado(entity.getV_cantcomprada());
		}
		return bean;
	}
	private CombosCabBean deComboCabeceraAComboCabeceraBean2(LeotbcComboCab entity) {
		CombosCabBean bean = null;
		if (entity != null) {
			bean = new CombosCabBean();
			bean.setCodigo(entity.getnCmbocab());
			bean.setTitulo(entity.getvTitulo());
			bean.setDescripcion(entity.getvDescripcion());
			bean.setNombreImagen(entity.getvNomimg());
			bean.setMonto(entity.getvMonto());
			bean.getMascotaBean().setCodigo(entity.getnCodmasco());
			bean.getFondoBean().setCodigo(entity.getnCodfond());
			bean.setMonedas(entity.getnMonedas());
			bean.setGemas(entity.getnGemas());
			bean.setEstado(entity.getvFlgest());
			bean.getSituacion().setNombreCorto(entity.getV_nomcorto());
			bean.getMascotaBean().setNombre(entity.getV_nommasco());
			bean.getFondoBean().setNombre(entity.getV_nomfond());
			bean.getSituacion().setCodigoRegistro(entity.getnTm1sitcombo());
			bean.setCantidadComprado(entity.getV_cantcomprada());
			
		}
		return bean;
	}

	@Override
	public List<CombosCabBean> getBuscarTodos(CombosCabBean comboCabBean) throws DAOException {
		List<LeotbcComboCab> 	lstEntity 	= null;
		List<CombosCabBean> 	lstBean = null;
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbccombocab.buscar_todos");
		spq.setParameter("p_codusuari", comboCabBean.getCodigoUsuarioCreacion());
		if (spq.execute()) {
			lstEntity =  spq.getResultList(); 
		} 
		if (lstEntity != null && lstEntity.size() > 0) 
		{			
			lstBean = deListaCombosCabeceraAListaCombosCabeceraBean(lstEntity);
		}
		return lstBean;
	}



	@Override
	public CombosCabBean getBuscarPorComboAlumno(CombosCabBean comboCabBean) throws DAOException {
		List<LeotbcComboCab> 	lstPregunta 	= null;
		CombosCabBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbccombocab.buscar_x_alumno");
		spq.setParameter("p_codusuari", 	comboCabBean.getCodigo());
		if (spq.execute()) {
			lstPregunta =  spq.getResultList(); 
		} 
		if (lstPregunta != null && lstPregunta.size() > 0) {
			bean = deComboCabeceraAComboCabeceraBean2(lstPregunta.get(0));
		}
		return bean;
	}

	@Override
	public List<CombosCabBean> getBuscarPorCombosAlumno(CombosCabBean comboBean) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
