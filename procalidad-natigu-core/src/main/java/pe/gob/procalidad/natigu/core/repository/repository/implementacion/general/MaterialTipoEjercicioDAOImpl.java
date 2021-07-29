package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcInstitucion;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcMaterialTipoEje;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.MaterialTipoEjercicioDAO;
@Transactional (readOnly = true)
@Repository("lenguaMaterialTipoEjercicioDAO")
public class MaterialTipoEjercicioDAOImpl implements MaterialTipoEjercicioDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(MaterialTipoEjercicioBean materialTipoEjercicioBean)
			throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("lenguaMaterialTipoEjercicioBean DAO "+materialTipoEjercicioBean);
		Object codigoMaterialEjercicio= null; 
		
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlematxtipoej.insertar");
			
			spq.setParameter("p_codlesmat", materialTipoEjercicioBean.getLeccionMaterialBean().getCodigo());
			spq.setParameter("p_tm2tpejer", materialTipoEjercicioBean.getTipoEjercicio().getCodigoRegistro());
			spq.setParameter("p_tm1sittip", materialTipoEjercicioBean.getSituacionTipo().getCodigoRegistro());
			spq.setParameter("p_codusureg", materialTipoEjercicioBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", materialTipoEjercicioBean.getIpCreacion()); 
			spq.setParameter("p_titulo", materialTipoEjercicioBean.getTitulo());
			spq.setParameter("p_subtitulo", materialTipoEjercicioBean.getSubTitulo());
			spq.setParameter("p_comprension", materialTipoEjercicioBean.getComprension());
			spq.setParameter("p_expgram", materialTipoEjercicioBean.getExpresionGramatical());
			spq.setParameter("p_flgpregu", materialTipoEjercicioBean.getFlgPregu());
			
			spq.execute();
			
			codigoMaterialEjercicio = spq.getOutputParameterValue(1);
			
			if (codigoMaterialEjercicio != null) {
				System.out.println("Ingreso a Insertar MaterialTipoEjercicioBean");
				
				materialTipoEjercicioBean.setCodigo(Long.valueOf(codigoMaterialEjercicio.toString()));
				System.out.println("materialTipoEjercicioBean.getCodigo()"+materialTipoEjercicioBean.getCodigo());

				
				sw = true;
				
			}else{
				System.out.println("obj llego vacio.");
				sw = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw = false; 
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean actualizar(MaterialTipoEjercicioBean materialTipoEjercicioBean)
			throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("lenguaMaterialTipoEjercicioBean DAO "+materialTipoEjercicioBean);
	
		
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlematxtipoej.actualizar");
			
			spq.setParameter("p_codmatpej", materialTipoEjercicioBean.getCodigo());
			spq.setParameter("p_codlesmat", materialTipoEjercicioBean.getLeccionMaterialBean().getCodigo());
			spq.setParameter("p_tm2tpejer", materialTipoEjercicioBean.getTipoEjercicio().getCodigoRegistro());
			spq.setParameter("p_tm1sittip", materialTipoEjercicioBean.getSituacionTipo().getCodigoRegistro());
			spq.setParameter("p_codusumod", materialTipoEjercicioBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", materialTipoEjercicioBean.getIpModificacion()); 
			spq.setParameter("p_titulo", materialTipoEjercicioBean.getTitulo());
			spq.setParameter("p_subtitulo", materialTipoEjercicioBean.getSubTitulo());
			spq.setParameter("p_comprension", materialTipoEjercicioBean.getComprension());
			spq.setParameter("p_expgram", materialTipoEjercicioBean.getExpresionGramatical());
			spq.setParameter("p_flgpregu", materialTipoEjercicioBean.getFlgPregu());
			
			spq.execute();
			
			sw =  true;
			System.out.println("----- paso  modificar MaterialTipoEjercicioBean ----");
			

		} catch (Exception e) {
			e.printStackTrace();
			sw = false; 
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(MaterialTipoEjercicioBean materialTipoEjercicioBean)
			throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("lenguaMaterialTipoEjercicioBean DAO "+materialTipoEjercicioBean);
	
		
		boolean sw=false;
		
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlematxtipoej.eliminar");
			
			spq.setParameter("p_codmatpej", materialTipoEjercicioBean.getCodigo());
			spq.setParameter("p_codusumod", materialTipoEjercicioBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", materialTipoEjercicioBean.getIpModificacion());
			
			spq.execute();
			
			sw =  true;
			System.out.println("----- paso  eliminar MaterialTipoEjercicioBean ----");
			

		} catch (Exception e) {
			e.printStackTrace();
			sw = false; 
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return sw;
	}
	
	public boolean actualizarOrden(MaterialTipoEjercicioBean materialTipoEjercicioBean)
			throws DAOException {
		boolean sw=false;
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlematxtipoej.actualizarOrden");
			spq.setParameter("p_codmatpej", materialTipoEjercicioBean.getCodigo());
			spq.setParameter("p_orden", materialTipoEjercicioBean.getOrden()); 
			spq.setParameter("p_codusumod", materialTipoEjercicioBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", materialTipoEjercicioBean.getIpModificacion());
			spq.execute();
			sw =  true;
		} catch (Exception e) {
			e.printStackTrace();
			sw = false; 
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public MaterialTipoEjercicioBean getBuscarPorObjecto(
			MaterialTipoEjercicioBean materialTipoEjercicioBean) throws DAOException {
		MaterialTipoEjercicioBean oMaterialTipoEjercicioBean = null;
		List<LeotbcMaterialTipoEje> lstMaterialTipoEjes = null;
		System.out.println("--- ingreso a buscar por codigo ----");
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlematxtipoej.buscarPorCodigo");
			
			spq.setParameter("p_codmatpej", materialTipoEjercicioBean.getCodigo());

			if (spq.execute()) {
				lstMaterialTipoEjes = spq.getResultList();
			}
			if (lstMaterialTipoEjes != null && 
					lstMaterialTipoEjes.size() > 0) {
				oMaterialTipoEjercicioBean = deMaterialTipoEjercicioAMaterialTipoEjercicioBean(lstMaterialTipoEjes.get(0));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oMaterialTipoEjercicioBean;
	}

	@Override
	public List<MaterialTipoEjercicioBean> getBuscarPorFiltros(
			MaterialTipoEjercicioBean materialTipoEjercicioBean) throws DAOException {
		List<LeotbcMaterialTipoEje> lstLeotbcMaterialTipoEjes = null;
		List<MaterialTipoEjercicioBean> lstMaterialTipoEjercicioBeans = null;
		
		System.out.println("---- getBuscarPorFiltros ---");
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlematxtipoej.buscarPorFiltros");
		
		spq.setParameter("p_codlesmat",materialTipoEjercicioBean.getLeccionMaterialBean().getCodigo());
		spq.setParameter("p_tm2tpejer", materialTipoEjercicioBean.getTipoEjercicio().getCodigoRegistro());
		spq.setParameter("p_tm1sittip", materialTipoEjercicioBean.getSituacionTipo().getCodigoRegistro());
		
		if (spq.execute()) {
			
			lstLeotbcMaterialTipoEjes = spq.getResultList();
		}
		if (lstLeotbcMaterialTipoEjes != null && lstLeotbcMaterialTipoEjes.size() > 0) {
			
			lstMaterialTipoEjercicioBeans = deListaMaterialTipoEjercicioAListaMaterialTipoEjercicioBean2(lstLeotbcMaterialTipoEjes);
		}
		
		return lstMaterialTipoEjercicioBeans;
	}
	
	private List<MaterialTipoEjercicioBean> deListaMaterialTipoEjercicioAListaMaterialTipoEjercicioBean(List<LeotbcMaterialTipoEje> lstLeotbcMaterialTipoEjes) {
		
		List<MaterialTipoEjercicioBean> lstMaterialTipoEjercicioBean = null;
		
		if (lstLeotbcMaterialTipoEjes != null && lstLeotbcMaterialTipoEjes.size() > 0) {
			
			lstMaterialTipoEjercicioBean = new ArrayList<MaterialTipoEjercicioBean>();
			
			for (int i = 0; i < lstLeotbcMaterialTipoEjes.size(); i++) { 
				LeotbcMaterialTipoEje entity = lstLeotbcMaterialTipoEjes.get(i);
				MaterialTipoEjercicioBean bean = deMaterialTipoEjercicioAMaterialTipoEjercicioBean(entity);
				
				lstMaterialTipoEjercicioBean.add(bean);
			}
		}
		
		return lstMaterialTipoEjercicioBean;
	}
	
	private List<MaterialTipoEjercicioBean> deListaMaterialTipoEjercicioAListaMaterialTipoEjercicioBean2(List<LeotbcMaterialTipoEje> lstLeotbcMaterialTipoEjes) {
		
		List<MaterialTipoEjercicioBean> lstMaterialTipoEjercicioBean = null;
		
		if (lstLeotbcMaterialTipoEjes != null && lstLeotbcMaterialTipoEjes.size() > 0) {
			
			lstMaterialTipoEjercicioBean = new ArrayList<MaterialTipoEjercicioBean>();
			
			for (int i = 0; i < lstLeotbcMaterialTipoEjes.size(); i++) { 
				LeotbcMaterialTipoEje entity = lstLeotbcMaterialTipoEjes.get(i);
				MaterialTipoEjercicioBean bean = deMaterialTipoEjercicioAMaterialTipoEjercicioBean2(entity);
				
				lstMaterialTipoEjercicioBean.add(bean);
			}
		}
		
		return lstMaterialTipoEjercicioBean;
	}

	private MaterialTipoEjercicioBean deMaterialTipoEjercicioAMaterialTipoEjercicioBean(LeotbcMaterialTipoEje entity) {
		
		MaterialTipoEjercicioBean bean = null;
		
		if (entity != null) {
			
			bean = new MaterialTipoEjercicioBean();
			
			bean.setCodigo(entity.getnCodmatpej());
			bean.setTitulo(entity.getvTitulo());
			bean.getTipoEjercicio().setCodigoRegistro(entity.getnTm2tpejer());
			bean.getLeccionMaterialBean().setCodigo(entity.getnCodlesmat());
			bean.setSubTitulo(entity.getV_subtitulo());
			bean.setComprension((entity.getvComprension()!=null && entity.getvComprension().length()>0) ? entity.getvComprension() : "");
			bean.setExpresionGramatical(entity.getvExpGramatical());
			bean.setFlgPregu(entity.getnFlgpregu()!=null ? entity.getnFlgpregu() : 0);
		}
		
		return bean;
	}

	private MaterialTipoEjercicioBean deMaterialTipoEjercicioAMaterialTipoEjercicioBean2(LeotbcMaterialTipoEje entity) {
		
		MaterialTipoEjercicioBean bean = null;
		
		if (entity != null) {
			
			bean = new MaterialTipoEjercicioBean();
			
			bean.setCodigo(entity.getnCodmatpej());
			bean.setTitulo(entity.getvTitulo());
			bean.getTipoEjercicio().setCodigoRegistro(entity.getnTm2tpejer());
			bean.getTipoEjercicio().setNombreLargo(entity.getV_nomLargo());
			bean.getLeccionMaterialBean().setCodigo(entity.getnCodlesmat());
			bean.setComprension(entity.getvComprension());
			bean.setExpresionGramatical(entity.getvExpGramatical());
			bean.setFlgPregu(entity.getnFlgpregu()!=null ? entity.getnFlgpregu() : 0);
		}
		
		return bean;
	}

	@Override
	public boolean existe(MaterialTipoEjercicioBean materialTipoEjercicioBean)
			throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}