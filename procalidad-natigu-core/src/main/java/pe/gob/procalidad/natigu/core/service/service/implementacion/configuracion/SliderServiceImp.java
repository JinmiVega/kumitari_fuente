package pe.gob.procalidad.natigu.core.service.service.implementacion.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

 



import pe.gob.procalidad.natigu.core.bean.bean.configuracion.SliderBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
 
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.SliderDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.SliderService;
 

@Service("sliderService")
@Transactional (readOnly = true)
public class SliderServiceImp implements SliderService{
	@Autowired
	private SliderDAO sliderDAO; 
	

	@Override
	public boolean insertar(SliderBean sliderBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  sliderDAO.insertar(sliderBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(SliderBean sliderBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  sliderDAO.actualizar(sliderBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(SliderBean sliderBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  sliderDAO.eliminar(sliderBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public SliderBean getBuscarPorObjecto(SliderBean sliderBean) throws ServiceException {
		SliderBean oSliderBean = null;
		try {
			oSliderBean = sliderDAO.getBuscarPorObjecto(sliderBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oSliderBean;
	}

	@Override
	public List<SliderBean> getBuscarPorFiltros(SliderBean sliderBean)
			throws ServiceException {
		List<SliderBean> lstSliderBean=null;
		try {
			System.out.println("en listado slider service imp");
			lstSliderBean=(List<SliderBean>) sliderDAO.getBuscarPorFiltros(sliderBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstSliderBean;
	}

	@Override
	public boolean existe(SliderBean t) throws ServiceException {
		
		return false;
}
}