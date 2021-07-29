package pe.gob.procalidad.natigu.web.gestion.controller.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.ExamenConfiguracionBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioConfiguracionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionSedeBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.ExamenConfiguracionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.PremioConfiguracionService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
 
@Controller
@Scope(value="session")
@RequestMapping(value = "fichaPuntajeController")
public class FichaPuntajeController extends BaseController {
   
   private PremioConfiguracionBean 		premioConfigBean;
   private ExamenConfiguracionBean      examenConfigBean;
   private List<PremioConfiguracionBean> 	lstPremioConfigBean;
   private List<ExamenConfiguracionBean>    lstExamenConfigBean;
	
	@Autowired
	private PremioConfiguracionService 		premioConfiguracionService;
	
	@Autowired
	private ExamenConfiguracionService     examenConfiguracionService;
	
	
	public ExamenConfiguracionBean getExamenConfigBean() {
		return examenConfigBean;
	}

	public void setExamenConfigBean(ExamenConfiguracionBean examenConfigBean) {
		this.examenConfigBean = examenConfigBean;
	}

	public List<ExamenConfiguracionBean> getLstExamenConfigBean() {
		return lstExamenConfigBean;
	}

	public void setLstExamenConfigBean(List<ExamenConfiguracionBean> lstExamenConfigBean) {
		this.lstExamenConfigBean = lstExamenConfigBean;
	}

	public ExamenConfiguracionService getExamenConfiguracionService() {
		return examenConfiguracionService;
	}

	public void setExamenConfiguracionService(ExamenConfiguracionService examenConfiguracionService) {
		this.examenConfiguracionService = examenConfiguracionService;
	}

	public List<PremioConfiguracionBean> getLstPremioConfigBean() {
		return lstPremioConfigBean;
	}

	public void setLstPremioConfigBean(List<PremioConfiguracionBean> lstPremioConfigBean) {
		this.lstPremioConfigBean = lstPremioConfigBean;
	}

	public PremioConfiguracionService getPremioConfiguracionService() {
		return premioConfiguracionService;
	}

	public void setPremioConfiguracionService(PremioConfiguracionService premioConfiguracionService) {
		this.premioConfiguracionService = premioConfiguracionService;
	}
	
	
	public PremioConfiguracionBean getPremioConfigBean() {
		return premioConfigBean;
	}

	public void setPremioConfigBean(PremioConfiguracionBean premioConfigBean) {
		this.premioConfigBean = premioConfigBean;
	}
	
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public @ResponseBody String doactualizar(@RequestParam("p_codconfp") Integer p_codconfp,@RequestParam("p_flgbas") String p_flgbas,@RequestParam("p_flghom") String p_flghom, @RequestParam("p_flgprem") String p_flgprem , @RequestParam("p_cntmone") Integer p_cntmone, @RequestParam("p_cntgema") Integer p_cntgema,HttpServletRequest request){
		
		System.out.println("modificar codigo: " + p_codconfp);
		System.out.println("modificar codigo: " + p_flgbas);
		
		PremioConfiguracionBean prmpremioConfiguracionBean = new PremioConfiguracionBean();
		prmpremioConfiguracionBean.setCodigo(p_codconfp); 
		prmpremioConfiguracionBean.setFlagBasico(p_flgbas); 
		prmpremioConfiguracionBean.setFlagHonorifico(p_flghom); 
		prmpremioConfiguracionBean.setFlagPremium(p_flgprem);
		prmpremioConfiguracionBean.setMonedas(p_cntmone); 
		prmpremioConfiguracionBean.setGemas(p_cntgema);
		
		boolean sw = true;
		try {
			if (prmpremioConfiguracionBean.getCodigo()!=0) { 
				sw = (this.getPremioConfiguracionService().actualizar(prmpremioConfiguracionBean));
			}else{
					System.out.println("no ingreso a  actulizar ");		
				}
				if (sw) {
					return "1";
				}else{
					return "0";
				}
			

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			prmpremioConfiguracionBean = new PremioConfiguracionBean() ;
			
			
	
		}
//		boolean sw = true;
//		try {
//			premioConfigBean = this.getPremioConfiguracionService().actualizar(prmpremioConfiguracionBean);
//		} catch (ServiceException e) { 
//			e.printStackTrace();
//		}
//		System.out.println("modificar maestraBean: " + premioConfigBean);
//		ModelAndView mav = new ModelAndView("configuracion/registro-tabla-maestra", "command", premioConfigBean);
//		mav.addObject("premioBean", premioConfigBean);
// 
////		System.out.println("modificar codigot2: " + p_codtabla);
////		System.out.println("modificar codigor2: " + p_codregis);
//		return mav;
		
		return "Exito";
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping(value = "/datos", method = RequestMethod.GET)
	public ModelAndView doModificar() {

		System.out.println("modificar codigo: ");
		ModelAndView mav = new ModelAndView("configuracion/ficha-puntajes");
		/*
		 new ModelAndView(
				"configuracion/ficha-puntajes", "command",
				premioConfigBean); 
		 **/
		List<PremioConfiguracionBean> lstPremioConfig = getListaPremioConfiguracion();
		mav.addObject("lstPremioConfig", lstPremioConfig);
		
		List<ExamenConfiguracionBean> lstExamenConfig = getListaExamenConfiguracion();
		mav.addObject("lstExamenConfig", lstExamenConfig);
		
		
		return mav;
	}
	
	private List<PremioConfiguracionBean> getListaPremioConfiguracion() {

		List<PremioConfiguracionBean> lstPremioConfig = new ArrayList<PremioConfiguracionBean>();

		try {
			lstPremioConfig = this.getPremioConfiguracionService().listarTodos();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getListaPremioConfiguracion " + e.getMessage());
		}

		return lstPremioConfig;
	}
	
	private List<ExamenConfiguracionBean> getListaExamenConfiguracion() {

		List<ExamenConfiguracionBean> lstExamenConfig = new ArrayList<ExamenConfiguracionBean>();

		try {
			lstExamenConfig = this.getExamenConfiguracionService().listarTodos();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getListaExamenConfiguracion " + e.getMessage());
		}

		return lstExamenConfig;
	}

}
