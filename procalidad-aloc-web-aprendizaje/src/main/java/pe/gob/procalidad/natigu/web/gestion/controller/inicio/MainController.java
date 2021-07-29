package pe.gob.procalidad.natigu.web.gestion.controller.inicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.ModalBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.SliderDetalleBean;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.ModalService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.SliderDetalleService;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;

@Controller
@RequestMapping(value="")
public class MainController{
	
	@Autowired
	private SliderDetalleService sliderDetalleService;
	
	@Autowired
	private ModalService modalService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		
		LoginVo prmLogin = new LoginVo();
		ModelAndView mav = new ModelAndView("../home", "command",prmLogin);
		
		this.cargarContenido(mav);
		
		return mav;
	}
	
	private void cargarContenido(ModelAndView mav){
		
		try {
			/** CARGAR LISTADO SLIDER **/
			List<SliderDetalleBean> listaSliderDetalleBean = sliderDetalleService.buscarPorSliderActivo();
			mav.addObject("listaSliderDetalleBean", listaSliderDetalleBean);
			
			/** CARGAR MODAL INICIAL **/
			ModalBean prmModalBean = new ModalBean();
			ModalBean prmFiltro = new ModalBean();
			prmFiltro.getSituacion().setCodigoRegistro(1); //Activo
			List<ModalBean> listaModal  = modalService.getBuscarPorFiltros(prmFiltro);
			if(!VO.isEmptyList(listaModal)){
				prmModalBean = listaModal.get(0);
			}
			mav.addObject("modalBean",prmModalBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}