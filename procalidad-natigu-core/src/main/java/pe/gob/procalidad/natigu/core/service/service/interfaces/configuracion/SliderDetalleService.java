package pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.SliderDetalleBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.BaseService;

@Transactional(readOnly = true)
public interface SliderDetalleService extends BaseService<SliderDetalleBean>{

	public List<SliderDetalleBean> getlistarSliderDetalleXCodigoSlider(SliderDetalleBean sliderDetalleBean)  throws ServiceException;

	public List<SliderDetalleBean> buscarPorSliderActivo() throws ServiceException;
}
