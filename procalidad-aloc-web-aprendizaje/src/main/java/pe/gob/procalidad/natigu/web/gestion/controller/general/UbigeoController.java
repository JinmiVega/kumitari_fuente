package pe.gob.procalidad.natigu.web.gestion.controller.general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UbigeoService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;



@Controller
@RequestMapping(value = "baseController")
public class UbigeoController extends BaseController {

	@Autowired
	public UbigeoService ubigeoService;
	public UbigeoBean ubigeobean;
//	@RequestMapping(value = "/listardepartamento", method = RequestMethod.GET)
//	public List<UbigeoBean> doListaDepartamento(@ModelAttribute("docenteBean") DocenteBean docenteBean)throws Exception {
//		List<UbigeoBean> lstProvincia = new ArrayList<UbigeoBean>();
//		DocenteBean prmDocenteBean = new DocenteBean();
//		prmDocenteBean= docenteBean;
//		//prmDocenteBean.setNombre("");
////		return this.getLista(prmDocenteBean);
//		
//		
//		return lstProvincia;
//	}
//	
	
	
	@RequestMapping(value = "/buscarProvincia", method = RequestMethod.GET)
	public @ResponseBody List<UbigeoBean> doBuscarProvincia(@RequestParam("codigodepartamento") String codigo)throws Exception {
		System.out.println("gua gua.. :"+codigo);
		List<UbigeoBean> lstProvincia = new ArrayList<UbigeoBean>();
		if (!codigo.equals("00")){
			ubigeobean = new UbigeoBean();
			ubigeobean.setCodigoRegion(codigo);
			lstProvincia = ubigeoService.listarProvincia(ubigeobean);
		}
		return lstProvincia;
	}
	
	

	
	
	@RequestMapping(value = "/buscarDistrito", method = RequestMethod.GET)
	public @ResponseBody  List<UbigeoBean> doBuscarDistrito(@RequestParam("codigodepartamento") String codigo,@RequestParam("codigoprovincia") String codigoprovincia)throws Exception {
		List<UbigeoBean> lstProvincia = new ArrayList<UbigeoBean>();
		if (!codigoprovincia.equals("00")){
		ubigeobean = new UbigeoBean();
		ubigeobean.setCodigoRegion(codigo);
		ubigeobean.setCodigoProvincia(codigoprovincia);
		lstProvincia = ubigeoService.listarDistrito(ubigeobean);
		}
		return lstProvincia;
	}

	
}
