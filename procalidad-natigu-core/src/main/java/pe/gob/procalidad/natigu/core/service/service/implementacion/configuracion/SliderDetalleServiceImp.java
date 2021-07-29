package pe.gob.procalidad.natigu.core.service.service.implementacion.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.SliderBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.SliderDetalleBean;
 
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.SliderDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.SliderDetalleDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.SliderDetalleService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.SliderService;
 

@Service("sliderDetalleService")
@Transactional (readOnly = true)
public class SliderDetalleServiceImp implements SliderDetalleService{
	
	@Autowired
	private SliderDetalleDAO sliderDetalleDAO;

	@Override
	public boolean insertar(SliderDetalleBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  sliderDetalleDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(SliderDetalleBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(SliderDetalleBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  sliderDetalleDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public SliderDetalleBean getBuscarPorObjecto(SliderDetalleBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SliderDetalleBean> getBuscarPorFiltros(SliderDetalleBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(SliderDetalleBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SliderDetalleBean> getlistarSliderDetalleXCodigoSlider(SliderDetalleBean sliderDetalleBean)
			throws ServiceException {
		List<SliderDetalleBean> lstSliderBean=null;
		try {
			System.out.println("en listado slider detalle service imp");
			lstSliderBean=sliderDetalleDAO.getlistarSliderDetalleXCodigoSlider(sliderDetalleBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstSliderBean;
	}

	@Override
	public List<SliderDetalleBean> buscarPorSliderActivo() throws ServiceException {
		List<SliderDetalleBean> lstSliderBean=null;
		try {
			lstSliderBean=sliderDetalleDAO.buscarPorSliderActivo();
		} catch (Exception e) {
			e.printStackTrace(); 	 
		}
		 
		return lstSliderBean;
	}

}