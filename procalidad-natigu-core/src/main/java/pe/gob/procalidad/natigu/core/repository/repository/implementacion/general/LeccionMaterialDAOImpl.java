package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LeccionMaterialBean;

import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialEjercicioBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdLecmaterial;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdMatejercicio;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdLecmaterial;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.LeccionMaterialDAO;

@Transactional
@Repository("leccionMaterialDAO")
public class LeccionMaterialDAOImpl implements LeccionMaterialDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(LeccionMaterialBean t) throws DAOException {
		Object id = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlecmaterial.insertar");
			spq.setParameter("p_codleslec", t.getUnidadLeccionBean().getCodigo());
			spq.setParameter("p_descmater", t.getDescripcionMaterial());
			spq.setParameter("p_contexto", t.getContexto());
			spq.setParameter("p_sweditable", t.getSwEditable());
			spq.setParameter("p_rutaaudio", t.getRutaAudio()); 
			spq.setParameter("p_ubiimag", t.getUbicacionImagen());
			spq.setParameter("p_nomimag", t.getNombreImagen());
			spq.setParameter("p_extimag", t.getExtencionImagen());
			spq.setParameter("p_comentario", t.getComentario());
			spq.setParameter("p_indicacion", t.getIndicacion());
			spq.setParameter("p_tm1sitmat", t.getSituacionLeccionMaterial().getCodigo());
			spq.setParameter("p_codusureg", t.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", t.getIpCreacion());
			spq.setParameter("p_tiptramdoc", t.getTipoTramDoc());
			spq.setParameter("p_comprension", t.getComprension());
			spq.setParameter("p_indicacion_extra", t.getIndicacionExtra());
			spq.execute();
			id = spq.getOutputParameterValue(1);
			if(id != null){
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
	public boolean actualizar(LeccionMaterialBean t) throws DAOException {
		boolean sw=false;

		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlecmaterial.actualizar");
			spq.setParameter("p_codlesmat", t.getCodigo());
			spq.setParameter("p_codleslec", t.getUnidadLeccionBean().getCodigo());
			spq.setParameter("p_descmater", t.getDescripcionMaterial());
			spq.setParameter("p_contexto", t.getContexto());
			spq.setParameter("p_sweditable", t.getSwEditable());
			spq.setParameter("p_rutaaudio", t.getRutaAudio()); 
			spq.setParameter("p_ubiimag", t.getUbicacionImagen());
			spq.setParameter("p_nomimag", t.getNombreImagen());
			spq.setParameter("p_comentario", t.getComentario());
			spq.setParameter("p_indicacion", t.getIndicacion());
			spq.setParameter("p_extimag", t.getExtencionImagen());
			spq.setParameter("p_tm1sitmat", t.getSituacionLeccionMaterial().getCodigo());
			spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", t.getIpModificacion()); 
			spq.setParameter("p_tiptramdoc", t.getTipoTramDoc());
			spq.setParameter("p_comprension", t.getComprension());
			spq.setParameter("p_indicacion_extra", t.getIndicacionExtra());
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
	public boolean eliminar(LeccionMaterialBean t) throws DAOException {
		boolean sw=false;

		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlecmaterial.eliminar");
			spq.setParameter("p_codlesmat", t.getCodigo());
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
	
	public boolean actualizarOrden(LeccionMaterialBean t) throws DAOException {
		boolean sw=false;

		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlecmaterial.actualizarOrden");
			spq.setParameter("p_codlesmat", t.getCodigo());
			spq.setParameter("p_orden", t.getOrden());
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
	public LeccionMaterialBean getBuscarPorObjecto(LeccionMaterialBean t) throws DAOException {
		List<LeotbdLecmaterial> 	lstLeccionMaterial 	= null;
		LeccionMaterialBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlecmaterial.buscar_por_codigo");
		spq.setParameter("p_codlesmat", t.getCodigo());
		
		if (spq.execute()) 
		{
			lstLeccionMaterial =  spq.getResultList(); 
		} 
		if (lstLeccionMaterial != null && lstLeccionMaterial.size() > 0) 
		{
			bean = deLeccionMaterialALeccionMaterialBean(lstLeccionMaterial.get(0));
		}
		return bean;	
	}
	
	
private LeccionMaterialBean deLeccionMaterialALeccionMaterialBean(LeotbdLecmaterial entity) {
		LeccionMaterialBean bean = null;
		if (entity != null) {
			bean = new LeccionMaterialBean();		
			bean.setCodigo(entity.getnCodlesmat());
			bean.getUnidadLeccionBean().setCodigo(entity.getnCodleslec());
			bean.setDescripcionMaterial(entity.getvDescmater());
			bean.setContexto(entity.getvContexto());
			bean.setSwEditable(entity.getvSweditable());
			bean.setRutaAudio(entity.getvRutaaudio());
			bean.setUbicacionImagen(entity.getvUbiimag());
			bean.setNombreImagen(entity.getvNomimag());
			bean.setExtencionImagen(entity.getvExtimag());
			bean.setComentario(entity.getvComentario());
			bean.setIndicacion(entity.getvIndicacion());
			bean.getSituacionLeccionMaterial().setCodigoRegistro(entity.getnTm1sitmat());	
			bean.setTipoTramDoc(entity.getnTiptramdoc());
			bean.setNomImgTipoTramDoc(entity.getvImgTiptram());
			bean.setValor1(entity.getvValor1());
			bean.setValor2(entity.getvValor2());
			bean.setComprension(entity.getvComprension());
			bean.setIndicacionExtra(entity.getvIndicacionExtra());
		}
		
		return bean;
	}

	@Override
	public List<LeccionMaterialBean> getBuscarPorFiltros(LeccionMaterialBean t) throws DAOException {
		List<LeotbdLecmaterial> 	lstLeccionMaterial 	= null;
		List<LeccionMaterialBean> 	lstLeccionMaterialBean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlecmaterial.buscar_por_filtros");
		spq.setParameter("p_codleslec", 	t.getCodigo());
		spq.setParameter("p_tm1sitmat", 	(int) t.getSituacionLeccionMaterial().getCodigo());

		
		
		if (spq.execute()) {
			lstLeccionMaterial =  spq.getResultList(); 
		} 
		if (lstLeccionMaterial != null && lstLeccionMaterial.size() > 0) {
			
			lstLeccionMaterialBean = deListaLeccionMaterialAListaLeccionMaterialBean(lstLeccionMaterial);
		}
		
		return lstLeccionMaterialBean;
	}
	
	
	
private List<LeccionMaterialBean> deListaLeccionMaterialAListaLeccionMaterialBean(List<LeotbdLecmaterial> lstLeccionMaterial) {
		
		
		List<LeccionMaterialBean> lstLeccionMaterialBean = null;
	
		if (lstLeccionMaterial != null && lstLeccionMaterial.size() > 0) {
			
			lstLeccionMaterialBean = new ArrayList<LeccionMaterialBean>();
			
			for (int i = 0; i < lstLeccionMaterial.size(); i++) { 
				LeotbdLecmaterial entity = lstLeccionMaterial.get(i);
				LeccionMaterialBean bean = deLeccionMaterialALeccionMaterialBean(entity);
				
				lstLeccionMaterialBean.add(bean);
			}
		}
		
		return lstLeccionMaterialBean;
	}
	

	@Override
	public boolean existe(LeccionMaterialBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LeccionMaterialBean> buscarPorLeccion(LeccionMaterialBean materialBean) throws DAOException {
		List<LeotbdLecmaterial> 	lstLeccionMaterial 	= null;
		List<LeccionMaterialBean> 	lstLeccionMaterialBean = null;
		try 
		{
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdlecmaterial.buscar_por_leccion");
			spq.setParameter("p_codleslec", 	materialBean.getUnidadLeccionBean().getCodigo());
			
			if (spq.execute()) 
			{
				lstLeccionMaterial =  spq.getResultList(); 
			} 
			if (lstLeccionMaterial != null && lstLeccionMaterial.size() > 0) 
			{
				lstLeccionMaterialBean = deListaLeccionMaterialAListaLeccionMaterialBean(lstLeccionMaterial);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return lstLeccionMaterialBean;
	}

}
