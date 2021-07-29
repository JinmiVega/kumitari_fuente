package pe.gob.procalidad.natigu.core.repository.repository.implementacion.configuracion;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

 
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.SliderBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
 
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcSlider;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.PremioConfiguracionDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.SliderDAO;

@Transactional
@Repository("sliderDAO")
	public class SliderDAOImp implements SliderDAO{
	@PersistenceContext
	private EntityManager em; 
	
	public SliderBean getSliderBean(Object object){
		return (SliderBean)object;
	}

	private List<SliderBean> deListaSliderAListaSliderBean(List<LeotbcSlider> lstSlider) {
		
		List<SliderBean> lstSliderBean = null;
		
		if (lstSlider != null && lstSlider.size() > 0) {
			
			lstSliderBean = new ArrayList<SliderBean>();
			
			for (int i = 0; i < lstSlider.size(); i++) { 
				LeotbcSlider entity = lstSlider.get(i);
				SliderBean bean = deSliderASliderBean(entity);
				
				lstSliderBean.add(bean);
			}
		}
		
		return lstSliderBean;
	}
	
	private SliderBean deSliderASliderBean(LeotbcSlider entity) {
		
		 SliderBean bean = null;
		
		if (entity != null) {
			
			bean = new SliderBean();
			
			bean.setCodigo(entity.getnCodslide()); 
			bean.setNombre(entity.getvNomslide());
			bean.setDescripcion(entity.getvDesslide());

			bean.getSituacion().setCodigoRegistro(entity.getnTm1sitsli());
			bean.getSituacion().setNombreCorto(entity.getV_nomcortoSituacion());  

			bean.setEstado(entity.getvFlgest());
			bean.setFechaCreacion(entity.getdFecreg());
		}
		
		return  bean;
	}

	@Override
	public boolean insertar(SliderBean sliderBean) throws DAOException {   
		Object idSlider= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcSlider.insertar");
			spq.setParameter("p_nomslide", sliderBean.getNombre());
			spq.setParameter("p_desslide", sliderBean.getDescripcion());
			spq.setParameter("p_tm1sitsli", sliderBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_codusureg", sliderBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", sliderBean.getIpCreacion()); 
	 
			spq.execute();
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			
			idSlider = spq.getOutputParameterValue(1);
			if (idSlider != null) {
				sliderBean.setCodigo(Integer.valueOf(idSlider.toString()));
				if (sliderBean.getCodigo()==0) {
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


//	@Override
//	public boolean actualizar(LenguaBean lenguaBean) throws DAOException {
//		boolean sw=false;
//		try {
//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.actualizar");
//			spq.setParameter("p_nomlengua", lenguaBean.getNombre());
//			spq.setParameter("p_tm1sitlen", lenguaBean.getSituacion().getCodigoRegistro());
//			spq.setParameter("p_codusumod", 1);
//			spq.setParameter("p_hostmod", ""); 
//			
//			spq.execute();   
//			sw=true;
//			 
//		} catch (Exception e) {
//			e.printStackTrace();
//			sw=false; 
//		}finally{
//			em.close();
//		}
//		return sw;
//	}


	@Override
	public boolean eliminar(SliderBean sliderBean) throws DAOException { 
		Object idSlider= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcSlider.eliminar");
			spq.setParameter("p_codslide", sliderBean.getCodigo()); 
			spq.setParameter("p_codusumod", 12);
			spq.setParameter("p_hostmod", "");
			spq.execute();   
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idSlider = spq.getOutputParameterValue(1);
			if (idSlider != null) {
				sliderBean.setRetorno(Integer.valueOf(idSlider.toString()));
				if (sliderBean.getRetorno()==0) {
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


//	@SuppressWarnings("unchecked")
//	@Override
//	public MascotaBean getBuscarPorObjecto(MascotaBean mascotaBean) throws DAOException {
//		MascotaBean oLenguaBean = null;
//		List<LeotbcMascota> lstLeotbcMascota = null;
//		try {
//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcLengua.buscar_por_codigo");
//			
//			spq.setParameter("p_codlengua", mascotaBean.getCodigo()); 
//			
//		
//			if (spq.execute()) {
//				lstLeotbcLengua = spq.getResultList();			
//			}
//			
//			if (	lstLeotbcLengua != null
//				&&	lstLeotbcLengua.size() > 0) {
//				
//				oLenguaBean = deLenguaALenguaBean(lstLeotbcLengua.get(0));
//			} 
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new DAOException(e);
//		}finally{
//			em.close();
//		}
//		return oLenguaBean;
//	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<SliderBean> getBuscarPorFiltros(SliderBean sliderbean) throws DAOException { 
		System.out.println("em " + em);
		List<LeotbcSlider> lstSlider = null;	
		List<SliderBean> lstSliderBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_slider.listar");
			spq.setParameter("p_nomslide", sliderbean.getNombre());  
			spq.setParameter("p_tm1sitsli", sliderbean.getSituacion().getCodigoRegistro());  
			 
				lstSlider =  spq.getResultList(); 
			 
			if (lstSlider != null && lstSlider.size() > 0) {
				
				lstSliderBean = deListaSliderAListaSliderBean(lstSlider);
			}
//			em.close();
			
		   
		return lstSliderBean;
	}


	@Override
	public boolean existe(SliderBean t) throws DAOException { 
		return false;
	}

	@Override
	public boolean actualizar(SliderBean sliderBean) throws DAOException {
		Object idSlider= null;
		boolean sw=false;
		System.out.println("sliderBean actualizar " + sliderBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcSlider.actualizar");
			spq.setParameter("p_codslide", sliderBean.getCodigo()); 
			spq.setParameter("p_nomslide", sliderBean.getNombre());
			spq.setParameter("p_desslide", sliderBean.getDescripcion());
			spq.setParameter("p_tm1sitsli", sliderBean.getSituacion().getCodigoRegistro()); 
			spq.setParameter("p_codusumod", sliderBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", sliderBean.getIpModificacion()); 
	 
			spq.execute();   
			sw=true;

			idSlider = spq.getOutputParameterValue(1);
			if (idSlider != null) {
				sliderBean.setRetorno(Integer.valueOf(idSlider.toString()));
				if (sliderBean.getRetorno()==0) {
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

	@SuppressWarnings("unchecked")
	@Override
	public SliderBean getBuscarPorObjecto(SliderBean sliderBean) throws DAOException {
		SliderBean oSliderBean = null;
		List<LeotbcSlider> lstLeotbcSlider = null;
		System.out.println("sliderBean getBuscarPorObjecto " + sliderBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcSlider.buscar_por_codigo");			
			spq.setParameter("p_codslide", sliderBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcSlider = spq.getResultList();			
			}
			
			if (	lstLeotbcSlider != null
				&&	lstLeotbcSlider.size() > 0) {
				
				oSliderBean = deSliderASliderBean(lstLeotbcSlider.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oSliderBean;
	}

}
