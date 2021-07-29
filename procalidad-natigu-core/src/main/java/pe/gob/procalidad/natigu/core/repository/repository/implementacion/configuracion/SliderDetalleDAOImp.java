package pe.gob.procalidad.natigu.core.repository.repository.implementacion.configuracion;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

 
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.SliderBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.SliderDetalleBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
 
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcSlider;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbdSlidetalle;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.PremioConfiguracionDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.SliderDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.SliderDetalleDAO;

@Transactional
@Repository("sliderDetalleDAO")
	public class SliderDetalleDAOImp implements SliderDetalleDAO{
	
	@PersistenceContext
	private EntityManager em; 
	
	

	private List<SliderDetalleBean> deListaSliderAListaSliderBean(List<LeotbdSlidetalle> lstSliderDetalle) {
		
		List<SliderDetalleBean> lstSliderDetalleBean = null;
		
		if (lstSliderDetalle != null && lstSliderDetalle.size() > 0) {
			
			lstSliderDetalleBean = new ArrayList<SliderDetalleBean>();
			
			for (int i = 0; i < lstSliderDetalle.size(); i++) { 
				LeotbdSlidetalle entity = lstSliderDetalle.get(i);
				SliderDetalleBean bean = deSliderDetalleASliderDetalleBean(entity);
				
				lstSliderDetalleBean.add(bean);
			}
		}
		
		return lstSliderDetalleBean;
	}
	
		private SliderDetalleBean deSliderDetalleASliderDetalleBean(LeotbdSlidetalle entity) {
		
			SliderDetalleBean bean = null;
		
		if (entity != null) {
			
			bean = new SliderDetalleBean();
			
			bean.setCodigo(entity.getNCodslidet()); 
			bean.setNombreSlider(entity.getVNomslidet());
			bean.getSituacion().setCodigoRegistro((int)entity.getNTm1sitslidet());
			bean.setEstado(entity.getVFlgest());
			bean.setFechaCreacion(entity.getDFecreg());
			
			bean.getSliderBean().setCodigo(entity.getnCodslide());
		 
			bean.setItem(entity.getnItem());
		}
		
		return  bean;
	}

		@Override
		public boolean insertar(SliderDetalleBean sliderBean) throws DAOException {
			Object idSliderDetalle= null; 
			boolean sw=false;
			try {
				StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_slidetalle.insertar");
				
				spq.setParameter("p_codslide", sliderBean.getSliderBean().getCodigo());
				spq.setParameter("p_nomslide", sliderBean.getImagen());
				 
				spq.setParameter("p_hostreg", "1"); 
		 
			
				
				spq.execute();
				sw=true;
				System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
				
				idSliderDetalle = spq.getOutputParameterValue(1);
				if (idSliderDetalle != null) {
					sliderBean.setCodigo(Integer.valueOf(idSliderDetalle.toString()));
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

		@Override
		public boolean actualizar(SliderDetalleBean t) throws DAOException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean eliminar(SliderDetalleBean sliderBean) throws DAOException {
			Object idSliderDetalle= null; 
			boolean sw=false;
			try {
				StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_slidetalle.eliminar");
				spq.setParameter("p_codslidet", sliderBean.getCodigo()); 
				spq.setParameter("p_codusumod", sliderBean.getCodigoUsuarioModificacion());
				spq.setParameter("p_hostmod", sliderBean.getIpModificacion());
				spq.execute();   
				sw=true;
				System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
				idSliderDetalle = spq.getOutputParameterValue(1);
				if (idSliderDetalle != null) {
					sliderBean.setRetorno(Integer.valueOf(idSliderDetalle.toString()));
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

		@Override
		public SliderDetalleBean getBuscarPorObjecto(SliderDetalleBean t) throws DAOException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<SliderDetalleBean> getBuscarPorFiltros(SliderDetalleBean t) throws DAOException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean existe(SliderDetalleBean t) throws DAOException {
			// TODO Auto-generated method stub
			return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<SliderDetalleBean> getlistarSliderDetalleXCodigoSlider(SliderDetalleBean sliderbean) throws DAOException {
			List<LeotbdSlidetalle> lstSliderDetalle = null;	
			List<SliderDetalleBean> lstSliderDetalleBean = null;
			try {
					StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_slidetalle.listado_buscar_por_codigoslider");
					spq.setParameter("p_codslide", sliderbean.getSliderBean().getCodigo());  
					
					if (spq.execute()) {
						lstSliderDetalle =  spq.getResultList();			
					}  
				 
					if (lstSliderDetalle != null && lstSliderDetalle.size() > 0) {
						lstSliderDetalleBean = deListaSliderAListaSliderBean(lstSliderDetalle);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					throw new DAOException(e);
				}finally{
					em.close();
				}
				
			   
			return lstSliderDetalleBean;
		}
		
		@Override
		public List<SliderDetalleBean> buscarPorSliderActivo() throws DAOException{
			List<LeotbdSlidetalle> lstSliderDetalle = null;	
			List<SliderDetalleBean> lstSliderDetalleBean = null;
			try {
					StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_slidetalle.buscar_x_slider_activo"); 
					 
					if (spq.execute()) {
						lstSliderDetalle =  spq.getResultList();			
					} 
				 
					if (lstSliderDetalle != null && lstSliderDetalle.size() > 0) {
						lstSliderDetalleBean = deListaSliderAListaSliderBean(lstSliderDetalle);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					throw new DAOException(e);
				}finally{
					em.close();
				}
				
			   
			return lstSliderDetalleBean;
		}
	
}