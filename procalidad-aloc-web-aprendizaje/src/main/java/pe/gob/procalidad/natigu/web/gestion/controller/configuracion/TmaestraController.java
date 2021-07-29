package pe.gob.procalidad.natigu.web.gestion.controller.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMonedaGBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.MascotaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service; 
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
 
@Controller
@Scope(value="session")
@RequestMapping(value ="tmaestraController")
public class TmaestraController extends BaseController { 
	
	private MaestraBean maestraBean;
	private List<MaestraBean> 	lstMaestraBean;
	private List<MaestraBean>	lstGeneral;
 
	@Autowired
	private Maestra1Service 	maestra1Service;
	@Autowired
	private Maestra2Service 	maestra2Service;
	 
	@PostConstruct
	public void init(){
		this.setMaestraBean(new MaestraBean());
		this.setLstMaestraBean(new ArrayList<MaestraBean>()); 
	}  
	public TmaestraController (){
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("maestraBean") MaestraBean maestraBean)throws Exception {
		
		MaestraBean prmMaestraBean = new MaestraBean(); 
		prmMaestraBean.setNombreCorto(""); 
		prmMaestraBean.setCodigoTabla("");   
		return this.getLista(prmMaestraBean);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("maestraBean") MaestraBean maestraBean)
			throws Exception {
		System.out.println("buscar maestraBean " + maestraBean);
		return this.getLista(maestraBean);
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() { 
		MaestraBean  prmMaestraBean = new MaestraBean ();
		prmMaestraBean.setCodigoRegistro(0);
		ModelAndView mav = new ModelAndView("configuracion/registro-tabla-maestra", "command",prmMaestraBean);
		mav.addObject("maestraBean",prmMaestraBean);
		this.cargarCombos(mav);
		return mav;
	}  
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("p_codtabla") String p_codtabla,@RequestParam("p_codregis") Integer p_codregis,HttpServletRequest request){
		boolean sw=false;
		maestraBean  = new MaestraBean();
		maestraBean.setCodigoTabla(p_codtabla); 
		maestraBean.setCodigoRegistro(p_codregis);
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
				sw =  (this.getMaestra1Service().eliminar(maestraBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		maestraBean.setCodigoRegistro(0);
		maestraBean.setCodigoTabla("");
		this.setValoresPredeterminados(maestraBean);
		ModelAndView mav = this.getLista(maestraBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}
	
	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("p_codtabla") String p_codtabla,@RequestParam("p_codregis") Integer p_codregis){
		
		System.out.println("modificar codigo: " + p_codtabla);
		System.out.println("modificar codigo: " + p_codregis);
		
		MaestraBean prmMaestraBean = new MaestraBean();
		prmMaestraBean.setCodigoTabla(p_codtabla); 
		prmMaestraBean.setCodigoRegistro(p_codregis); 
		
		try {
			maestraBean = this.getMaestra1Service().getBuscarPorTablaYRegistro(prmMaestraBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		System.out.println("modificar maestraBean: " + maestraBean);
		ModelAndView mav = new ModelAndView("configuracion/registro-tabla-maestra", "command", maestraBean);
		
		this.cargarCombos(mav);	
		mav.addObject("maestraBean", maestraBean); 
		System.out.println("modificar codigot2: " + p_codtabla);
		System.out.println("modificar codigor2: " + p_codregis);
		return mav;
	} 
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("maestraBean") MaestraBean maestraBean) {
		
		 System.out.println(" Bean Grabar"+maestraBean);
		System.out.println(" Bean Grabar"+maestraBean.getCodigoRegistro());
		System.out.println(" Bean Grabar"+maestraBean.getCodigoTabla());
		boolean sw = true;
		try {
			if (maestraBean.getCodigoRegistro()==0) {
				sw =  (this.getMaestra1Service().insertar(maestraBean)); 
			
			} else {
				sw = (this.getMaestra1Service().actualizar(maestraBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		if (sw) {
			maestraBean = new MaestraBean() ; 
			ModelAndView mav = this.getLista(maestraBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("configuracion/registro-tabla-maestra", "command",maestraBean);
			mav.addObject("swMensaje",sw?"1":"0");
			mav.addObject("maestraBean",maestraBean);
			this.cargarCombos(mav);
			return mav;
		}

	} 
		private ModelAndView getLista(MaestraBean maestraBean) {
				
		List<MaestraBean> lstMaestraBean = new ArrayList<MaestraBean>();
		try { 
			lstMaestraBean = (List<MaestraBean>) this.getMaestra1Service().getBuscarPorFiltros(maestraBean); 
			System.out.println("tama�o lst mascota bean "+lstMaestraBean.size());
		} catch (Exception e) {
			System.out.println("getLista fall�" + e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView("configuracion/listado-tabla-maestra", "command",maestraBean);
		System.out.println("lstMaestraBean "+lstMaestraBean);
		mav.addObject("lstMaestraBean", lstMaestraBean);
		this.cargarCombos(mav);
		return mav;
	}
	

	public Maestra1Service getMaestra1Service() {
		return maestra1Service;
	}

	public void setMaestra1Service(Maestra1Service maestra1Service) {
		this.maestra1Service = maestra1Service;
	}  
 
	
private void cargarCombos(ModelAndView mav){
		
		if (lstGeneral==null) {
			try {
				lstGeneral = maestra1Service.listarComboGeneral("7");
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		} 
		mav.addObject("lstGeneral",lstGeneral);
	}

@RequestMapping(value = "/listarhoraxnivel", method = RequestMethod.GET)
@ResponseBody
public  List<MaestraBean> doListarhoraxnivel(@RequestParam("p_nivellengua") String p_nivellengua,HttpServletRequest request){
	
	
	System.out.println("modificar p_nivellengua: " + p_nivellengua);
	
	List<MaestraBean> lstMaestraBean = new ArrayList<MaestraBean>();
	maestraBean = new MaestraBean();
	maestraBean.setCodigoTabla("duracionExamen");
	 maestraBean.setValor1(p_nivellengua);
	try { 
		lstMaestraBean = (List<MaestraBean>) this.getMaestra2Service().listarPorValor1(maestraBean); 
		System.out.println("tama�o lst listarPorValor1 bean "+lstMaestraBean.size());
	} catch (Exception e) {
		System.out.println("getLista fall�" + e.getMessage());
	}

	return lstMaestraBean;
} 

	public MaestraBean getMaestraBean() {
		return maestraBean;
	}
	
	public void setMaestraBean(MaestraBean maestraBean) {
		this.maestraBean = maestraBean;
	}




	public List<MaestraBean> getLstMaestraBean() {
		return lstMaestraBean;
	}




	public void setLstMaestraBean(List<MaestraBean> lstMaestraBean) {
		this.lstMaestraBean = lstMaestraBean;
	}




	public Maestra2Service getMaestra2Service() {
		return maestra2Service;
	}




	public void setMaestra2Service(Maestra2Service maestra2Service) {
		this.maestra2Service = maestra2Service;
	}




	public List<MaestraBean> getLstGeneral() {
		return lstGeneral;
	}




	public void setLstGeneral(List<MaestraBean> lstGeneral) {
		this.lstGeneral = lstGeneral;
	}
	public void setValoresPredeterminados(MaestraBean maestraBean){
		maestraBean.setCodigoTabla(""); 
		maestraBean.setCodigoRegistro(0);
	    }  

}
