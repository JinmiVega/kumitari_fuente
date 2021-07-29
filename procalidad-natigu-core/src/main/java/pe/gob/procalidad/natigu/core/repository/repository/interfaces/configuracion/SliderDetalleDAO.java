package pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion;


import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.SliderDetalleBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;

public interface SliderDetalleDAO extends BaseDAO<SliderDetalleBean>{
	
	public List<SliderDetalleBean> getlistarSliderDetalleXCodigoSlider(SliderDetalleBean sliderDetalleBean)  throws DAOException;

	public List<SliderDetalleBean> buscarPorSliderActivo() throws DAOException;
}
