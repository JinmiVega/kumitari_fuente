package pe.gob.procalidad.natigu.web.gestion.controller.configuracion;

import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.io.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.CombosCabBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.FondoBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.ComboCabService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.FondoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.MascotaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;

@Controller
@Scope(value="session")
@RequestMapping(value = "comboController")
public class ComboController extends BaseController {
	
	
	//private FondoBean 		fondoBean;
	private CombosCabBean comboBean;
	private CombosCabBean comboBeanTmp;
	private CombosCabBean comboBeanFiltro;
	
	private List<CombosCabBean> lstComboBeans;
	
	private List<MaestraBean>	lstSituacion;
	private List<MascotaBean> lstMascota;
	private List<FondoBean> lstFondo;
	
	
	@Autowired
	private ComboCabService comboService;
	@Autowired
	private Maestra1Service 	maestra1Service;
	@Autowired
	private MascotaService mascotaService;
	@Autowired 
	private FondoService fondoService;
	@Autowired
	private PeticionService peticionService;
	
	@PostConstruct
	public void init(){
		this.setComboBean(new CombosCabBean());
		this.setComboBeanFiltro(new CombosCabBean());
		this.setLstComboBeans(new ArrayList<CombosCabBean>());
	//	this.setLstSituacion(new ArrayList<MaestraBean>());
	} 
	
	public ComboController (){  
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("comboBean") CombosCabBean comboBean)throws Exception {
		
		CombosCabBean prmComboBean = new CombosCabBean(); 
		prmComboBean.setTitulo(""); 
		prmComboBean.getSituacion().setCodigoRegistro(0);
		prmComboBean.getFondoBean().setCodigo(0);
		prmComboBean.getMascotaBean().setCodigo(0);
//		prmFondoBean.setTipo(new MaestraBean());
//		prmFondoBean.getTipo().setCodigoRegistro(0);
		
		ModelAndView mav = new ModelAndView("configuracion/listado-combos", "command",comboBean);
		mav.addObject("lstCombosBean", new ArrayList<CombosCabBean>());
		mav.addObject("comboBean", new CombosCabBean());
//		List<FondoBean> lstFondoBean = new ArrayList<FondoBean>();
//		
//		try { 
//			lstFondoBean = (List<FondoBean>) this.getFondoService().getBuscarPorFiltros(prmFondoBean); 
//			System.out.println("tama�o lst fondo bean "+lstFondoBean.size());
//		} catch (Exception e) {
//			System.out.println("getLista fall�" + e.getMessage());
//		}
		
		//2020-03-18 10:02:18 DEBUG DispatcherServlet:913 - Successfully completed request

		this.cargarCombos(mav);
		return mav;
	}
	private ModelAndView getListado(CombosCabBean comboBean) {
		
		List<CombosCabBean> lstComboBean = new ArrayList<CombosCabBean>();
		if(comboBean.getSituacion().getCodigoRegistro()==null){
			comboBean.setTitulo("");
			comboBean.setEstado("%");
		} else if(comboBean.getSituacion().getCodigoRegistro()==0){
			comboBean.setEstado("%");
		} else{
			comboBean.setEstado(Integer.toString(comboBean.getSituacion().getCodigoRegistro()));
		}
		try {
			lstComboBean = (List<CombosCabBean>) comboService.getBuscarPorFiltros(comboBean);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("configuracion/listado-combos", "command",comboBean);
		
		mav.addObject("lstCombosBean", lstComboBean);
		mav.addObject("comboBean", comboBean);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscar(@ModelAttribute("comboBean") CombosCabBean comboBean)
			throws Exception {
		return this.doBuscarListado(comboBeanFiltro);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscarListado(@ModelAttribute("comboBean") CombosCabBean comboBean)
			throws Exception {
		comboBeanFiltro = comboBean;
//		return this.getListado(comboBean);
		List<CombosCabBean> lstComboBean = new ArrayList<CombosCabBean>();
		if(comboBean.getSituacion().getCodigoRegistro()==null){
			comboBean.setTitulo("");
			comboBean.setEstado("%");
		} else if(comboBean.getSituacion().getCodigoRegistro()==0){
			comboBean.setEstado("%");
		} else{
			comboBean.setEstado(Integer.toString(comboBean.getSituacion().getCodigoRegistro()));
		}
		try {
			lstComboBean = (List<CombosCabBean>) comboService.getBuscarPorFiltros(comboBean);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("configuracion/listado-combos", "command",comboBean);
		
		mav.addObject("lstCombosBean", lstComboBean);
		mav.addObject("comboBean", comboBean);
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("liCodComb")Integer liCodComb,HttpServletRequest request){
		boolean sw=false;
		comboBean = new CombosCabBean();
		comboBean.setCodigo(liCodComb);
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try { 
					sw = comboService.eliminar(comboBean);
	
			} catch (Exception e) { 
				e.printStackTrace();
			} 		
			comboBean.setCodigo(0);
			this.setValoresPredeterminados(comboBean);
			ModelAndView mav = this.getLista(comboBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;	
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesión no es valida, por favor inicie sesión nuevamente");
			return mav;
		}	
	}
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		comboBeanTmp = null;
		ModelAndView mav = new ModelAndView("configuracion/registro-combo", "command",new CombosCabBean());
		
		mav.addObject("comboBean", new CombosCabBean());

		this.cargarCombos(mav);
		 
		return mav;
	} 
	
	
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doModificar(@RequestParam("codigo") Integer liCodComb) {

		System.out.println("modificar codigo: " + liCodComb);

		CombosCabBean prmComboBean = new CombosCabBean();
		prmComboBean.setCodigo(liCodComb); 
		comboBeanTmp = prmComboBean;
		try {
			comboBean = comboService.getBuscarPorObjecto(prmComboBean);
			//tmpUrlImagen = comboBean.getImagenNombre();
			//tmpUrlImagenTienda = fondoBean.getImagenNombreTienda();
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		
		comboBean.setMascota(comboBean.getMascotaBean().getCodigo()==0 ? false : true);
		comboBean.setFondo(comboBean.getFondoBean().getCodigo()==0 ? false : true);	
		comboBean.setMoneda(comboBean.getMonedas()==0 ? false : true);
		comboBean.setGema(comboBean.getGemas()==0 ? false : true);
		if (comboBean != null ) {
			if (comboBean.getEstado() != null)   {  
			if (comboBean.getEstado().equals("1") ){
				 System.out.println("entro m");
				ModelAndView mav = new ModelAndView("configuracion/registro-combo", "command", comboBean);  
				this.cargarCombos(mav);
				mav.addObject("comboBean", comboBean);
				return mav;
		}else{
			ModelAndView mav = this.getLista(new CombosCabBean());
			mav.addObject("swMensaje","0");
			mav.addObject("comboBean",new CombosCabBean());  
			return mav;
			
		} }
			else{
				ModelAndView mav = this.getLista(new CombosCabBean());
				mav.addObject("swMensaje","0");
				mav.addObject("comboBean",new CombosCabBean());  
				return mav;
		} 
		
		} 
		else { 
			ModelAndView mav = this.getLista(new CombosCabBean());
			mav.addObject("swMensaje","0");
			mav.addObject("comboBean",new CombosCabBean());  
			return mav;
		} 
	} 
	

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar() {

		
		if(comboBeanTmp != null){

			CombosCabBean prmComboBean = new CombosCabBean();
			prmComboBean.setCodigo(comboBeanTmp.getCodigo()); 
			try {
				comboBean = comboService.getBuscarPorObjecto(prmComboBean);
				//tmpUrlImagen = comboBean.getImagenNombre();
				//tmpUrlImagenTienda = fondoBean.getImagenNombreTienda();
			} catch (ServiceException e) { 
				e.printStackTrace();
			}
			
			comboBean.setMascota(comboBean.getMascotaBean().getCodigo()==0 ? false : true);
			comboBean.setFondo(comboBean.getFondoBean().getCodigo()==0 ? false : true);	
			comboBean.setMoneda(comboBean.getMonedas()==0 ? false : true);
			comboBean.setGema(comboBean.getGemas()==0 ? false : true);
			if (comboBean != null ) {
				if (comboBean.getEstado() != null)   {  
					if (comboBean.getEstado().equals("1") ){
						 System.out.println("entro m");
						ModelAndView mav = new ModelAndView("configuracion/registro-combo", "command", comboBean);  
						this.cargarCombos(mav);
						mav.addObject("comboBean", comboBean);
						return mav;
					}else{
						ModelAndView mav = this.getLista(new CombosCabBean());
						mav.addObject("swMensaje","0");
						mav.addObject("comboBean",new CombosCabBean());  
						return mav;
						
					} 
				}
				else{
					ModelAndView mav = this.getLista(new CombosCabBean());
					mav.addObject("swMensaje","0");
					mav.addObject("comboBean",new CombosCabBean());  
					return mav;
			} 
			
			} 
			else { 
				ModelAndView mav = this.getLista(new CombosCabBean());
				mav.addObject("swMensaje","0");
				mav.addObject("comboBean",new CombosCabBean());  
				return mav;
			}
		}else{
			ModelAndView mav = this.getLista(new CombosCabBean());
			mav.addObject("swMensaje","0");
			mav.addObject("comboBean",new CombosCabBean());  
			return mav;
		}
		 
	} 
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("comboBean") CombosCabBean comboBean, HttpServletRequest request) {
		boolean sw = true;
		
		if(!comboBean.isFondo()){
			comboBean.getFondoBean().setCodigo(0);
		}
		if(!comboBean.isMascota()){
			comboBean.getMascotaBean().setCodigo(0);
		}
		if(!comboBean.isMoneda()){
			comboBean.setMonedas(0);
		}
		if(!comboBean.isGema()){
			comboBean.setGemas(0);
		}
		comboBean.setCodigoUsuarioCreacion(1);
		comboBean.setIpCreacion("77dev");
		comboBean.setCodigoUsuarioModificacion(1);
		comboBean.setIpModificacion("77dev");
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("BonoController/grabar");
			//habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	if(comboBean.getTitulo()!=null&&comboBean.getTitulo()!="") {
	        		if (comboBean.getCodigo()==0) {
	        			System.out.println("insert ");
	        			sw = (comboService.insertar(comboBean));
	        		} else {
	        			sw = (comboService.actualizar(comboBean));
	        		}	        		
	        	}
	        	
	        }

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			comboBean = new CombosCabBean() ;
			ModelAndView mav = this.getLista(comboBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("configuracion/registro-combo", "command",comboBean);
			mav.addObject("swMensaje",sw?"1":"0");
			mav.addObject("comboBean",comboBean);
			this.cargarCombos(mav);
			return mav;
		}
		

	}
	
	private ModelAndView getLista(CombosCabBean combosBean) {
		List<CombosCabBean> lstCombosBean = new ArrayList<CombosCabBean>();
		try { 
			lstCombosBean = (List<CombosCabBean>) comboService.getBuscarTodos(combosBean); 
			
		} catch (Exception e) {
			System.out.println("Falló" + e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView("configuracion/listado-combos", "command",comboBean);
		mav.addObject("lstCombosBean", lstCombosBean);

		this.cargarCombos(mav);
		
		return mav;
		}
	
	


private String getRootPath() {
	return ResourceUtil.getKey("ruta.natigu.archivos.configuracion.fondo");
	}

private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionFondo",0);
				System.out.println("lstSituacion.size() "+ lstSituacion.size());
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
		if(lstMascota==null){
			try {
				MascotaBean mascotaBean = new MascotaBean();
				mascotaBean.setNombre("");
				mascotaBean.getRegion().setCodigoRegistro(0);
				mascotaBean.getSituacion().setCodigo(1);
				lstMascota = mascotaService.getBuscarPorFiltros(mascotaBean);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	
			try {
				FondoBean fondoBean = new FondoBean();
				fondoBean.setNombre(""); 
				fondoBean.setRegion(new MaestraBean());
				fondoBean.getRegion().setCodigoRegistro(0);
				fondoBean.setSituacion(new MaestraBean());
				fondoBean.getSituacion().setCodigoRegistro(1);
				lstFondo = fondoService.getBuscarPorFiltros(fondoBean);
				System.out.println("fondos"+lstFondo);
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		
//		if (lstTipo==null) {
//			try {
//				lstTipo = maestra1Service.listarPorCodigoTabla("tipofondo");
//				System.out.println("lstTipo.size() "+ lstTipo.size());
//			} catch (ServiceException e) {
//				System.out.println("printStackTrace");
//				e.printStackTrace();
//			}		
//		}
  
		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstMascota",lstMascota); 
		mav.addObject("lstFondo",lstFondo); 

	}

	public CombosCabBean getComboBean() {
		return comboBean;
	}

	public void setComboBean(CombosCabBean comboBean) {
		this.comboBean = comboBean;
	}

	public List<CombosCabBean> getLstComboBeans() {
		return lstComboBeans;
	}

	public void setLstComboBeans(List<CombosCabBean> lstComboBeans) {
		this.lstComboBeans = lstComboBeans;
	}

	public List<MaestraBean> getLstSituacion() {
		return lstSituacion;
	}

	public void setLstSituacion(List<MaestraBean> lstSituacion) {
		this.lstSituacion = lstSituacion;
	}

	public ComboCabService getComboService() {
		return comboService;
	}

	public void setComboService(ComboCabService comboService) {
		this.comboService = comboService;
	}

	@Autowired
	private Maestra2Service 	maestra2Service;
	
	private void setValoresPredeterminados(CombosCabBean comboBean2) {
		comboBean = new CombosCabBean();
		comboBean.setTitulo("");
		comboBean.setMascota(false);
		comboBean.setFondo(false);
		comboBean.setDescripcion("");
		comboBean.setMonto(0);
		comboBean.setMonedas(0);
		comboBean.setGemas(0);
		comboBean.getFondoBean().setCodigo(0);
		comboBean.getMascotaBean().setCodigo(0);
	}

	public List<MascotaBean> getLstMascota() {
		return lstMascota;
	}

	public void setLstMascota(List<MascotaBean> lstMascota) {
		this.lstMascota = lstMascota;
	}

	public List<FondoBean> getLstFondo() {
		return lstFondo;
	}

	public void setLstFondo(List<FondoBean> lstFondo) {
		this.lstFondo = lstFondo;
	}

	public CombosCabBean getComboBeanFiltro() {
		return comboBeanFiltro;
	}

	public void setComboBeanFiltro(CombosCabBean comboBeanFiltro) {
		this.comboBeanFiltro = comboBeanFiltro;
	}
	
	
}
