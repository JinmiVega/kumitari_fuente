//package pe.gob.procalidad.natigu.web.gestion.controller.general;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonalBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
//import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PerfilBean;
//import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
//import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
//import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
//import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
//import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;
//import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonalService;
//import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UbigeoService;
//import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PerfilService;
//import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
//
//
//@Controller
//@RequestMapping(value = "personalController")
//public class PersonalController extends BaseController {
//	
//	PersonalBean personalBean = new PersonalBean();
//
//	private UbigeoBean ubigeoBean;
//
//	private List<UbigeoBean> lstRegion;
//	private List<UbigeoBean> lstProvincia;
//	private List<UbigeoBean> lstDistrito;
//
//	List<PersonalBean> lstpersonalBean= new ArrayList<PersonalBean>();
//	private List<MaestraBean>	lstSituacion;
//	private List<MaestraBean> lstTipoDocumento;
//	private List<MaestraBean> lstNacionalidad;
//	private List<MaestraBean> lstGrado;
//	private List<MaestraBean> lstCargo;
//	private List<MaestraBean> lstSexo;
//	private List<LenguaBean> 	lstLengua;
//	
//	private List<PerfilBean> 	lstPerfilBean;
//	@Autowired
//	private PerfilService perfilService;
//	
//	@Autowired
//	private LenguaService 		lenguaService;
//	
//	@Autowired
//	private UbigeoService ubigeoService;
//	
//	@Autowired
//	private Maestra1Service maestra1Service;
//	
//	@Autowired 
//	private PersonaService personaService;
////	
//	@Autowired
//	private Maestra2Service maestra2Service;
//	
//	@Autowired
//	private PersonalService personalService;
//	
//	
//	@PostConstruct
//	public void init(){
//		this.setPersonalBean(new PersonalBean());
//		this.setLstpersonalBean(new ArrayList<PersonalBean>());
////		this.setLstSituacion(new ArrayList<MaestraBean>());
//	}
//	
//	public PersonalController(){
///**		
////		List<MaestraBean> situacion = new ArrayList<MaestraBean>();
////		situacion = maestra1Service.listarPorCodigoTabla("situacionPersonal");
//		lstSituacion= new ArrayList<MaestraBean>();
//		lstTipoDocumento= new ArrayList<MaestraBean>();
//		try {
//			lstSituacion = maestra1Service.listarPorCodigoTabla("situacionPersonal");
//			lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento");
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//*/
//	}
//	
//	
//	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
//	public ModelAndView doNuevo() {
//		
//		ModelAndView mav = new ModelAndView("general/registro-administrativo", "command",new PersonalBean());
//		mav.addObject("lstSituacion",lstSituacion);
////		mav.addObject("lstTipoDocumento",lstTipoDocumento);
//		mav.addObject("personalBean", new PersonalBean());
//		cargarUbigeo(mav, null);
//		this.cargarCombos(mav);
//		return mav;
//	}
//	
//	
//	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
//	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {
//
//		System.out.println("modificar codigo: " + codigo);
//
//		PersonalBean prmPersonalBean = new PersonalBean();
//		prmPersonalBean.setCodigo(codigo); 
//		try {
//			personalBean = this.getPersonalService().getBuscarPorObjecto(prmPersonalBean);
//		} catch (ServiceException e) { 
//			e.printStackTrace();
//		}
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
//		
//		if(personalBean.getPersonaBean().getFechaNac()!=null){
//			String fechaConFormato = sdf.format(personalBean.getPersonaBean().getFechaNac()); 
////			Date nuevaFecha=null;
//			
//		
////				nuevaFecha = sdf.parse(fechaConFormato);
//				personalBean.getPersonaBean().setStrFechaNac(fechaConFormato);
//			
//			
//		}
//		System.out.println("modificar lenguaBean: " + personalBean);
//		ModelAndView mav = new ModelAndView("general/registro-administrativo", "command", personalBean);
//		mav.addObject("personalBean", personalBean);
//	//	mav.addObject("idUsuario",usuarioBean.getCodigo());	
//		this.cargarUbigeo(mav, personalBean);
//		this.cargarCombos(mav);	
//		return mav;
//	}
//	
//	
//	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
//	public ModelAndView doGrabar(@ModelAttribute("personalBean") PersonalBean personalBean) {
//		
//		System.out.println("personalBean"+personalBean);
//		PersonaBean prmPersona = new PersonaBean();
//		
//		boolean sw = false;
//		try {
//			
//			
//			if (personalBean.getCodigo()==0) {
//				
//				prmPersona=personalBean.getPersonaBean();
//				
//				prmPersona = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona);
//				if(prmPersona==null){
//					prmPersona=personalBean.getPersonaBean();
//					
//					prmPersona.setCodigoUbigeo(prmPersona.getUbigeoBean().getCodigoRegion()+prmPersona.getUbigeoBean().getCodigoProvincia()+prmPersona.getUbigeoBean().getCodigoDistrito());
//					
//					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
//					
//					if(personalBean.getPersonaBean().getStrFechaNac()!=null){
//						Date fechaConFormato = sdf.parse(personalBean.getPersonaBean().getStrFechaNac().toString()); 
////						
//						prmPersona.setFechaNac(fechaConFormato);
//						
//						
//					}
//					
//					
//					sw = (this.getPersonaService().insertar(prmPersona));
//					
//					
//					
//				}
//				
//				personalBean.setAudCodigoUsuario(1);
//				personalBean.setAudHostIP("192.168.1.1");
//				personalBean.setPersonaBean(prmPersona);
//				
//				
//				sw =  (this.getPersonalService().insertar(personalBean)); 
//				
//			} else {
//				
//				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
//				
//				if(personalBean.getPersonaBean().getStrFechaNac()!=null){
//					Date fechaConFormato = sdf.parse(personalBean.getPersonaBean().getStrFechaNac().toString()); 
////					
//					prmPersona.setFechaNac(fechaConFormato);
//					personalBean.getPersonaBean().setFechaNac(prmPersona.getFechaNac());
//					
//				}
//				
//				personalBean.getPersonaBean().setCodigoUbigeo(personalBean.getPersonaBean().getUbigeoBean().getCodigoRegion()+personalBean.getPersonaBean().getUbigeoBean().getCodigoProvincia()+personalBean.getPersonaBean().getUbigeoBean().getCodigoDistrito());
//				
//				sw = (this.getPersonalService().actualizar(personalBean));
//			}
//
//		} catch (Exception e) { 
//			e.printStackTrace();
//		}
//
//		if (sw) {
//			personalBean = new PersonalBean() ;
//			return this.getLista(personalBean);
//		} else {
//			ModelAndView mav = new ModelAndView("general/registro-administrativo", "command",personalBean);
//			return mav;
//		}
//
//	}
//	
//	
//	@RequestMapping(value = "/listado", method = RequestMethod.GET)
//	public ModelAndView doListado(@ModelAttribute("personalBean") PersonalBean personalBean)throws Exception {
//	
//		PersonalBean personalBean2 = new PersonalBean();
////		personalBean.getPersonaBean().setNombrePersona(personalBean.getPersonaBean().getNombrePersona().trim());
//		personalBean2 = personalBean;
//
//		return this.getLista(personalBean2);
//	}
//	
//	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
//	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
//		boolean sw=false;
//		personalBean= new PersonalBean();
//		personalBean.setCodigo(codigo);
//	//	this.setAuditoria(lenguaBean, request, false);
//		try { 
//				sw =  (this.getPersonalService().eliminar(personalBean));  
//
//		} catch (Exception e) { 
//			e.printStackTrace();
//		} 		
//		personalBean.setCodigo(0);
//		this.setValoresPredeterminados(personalBean);
//		ModelAndView mav = this.getLista(personalBean);
//		mav.addObject("swMensaje",sw?"1":"0");
//		return mav;		
//	}
//	
//	 public void setValoresPredeterminados(PersonalBean personalBean){
////		 personalBean.setNombre(""); 
////		 personalBean.getSituacion().setCodigoRegistro(0);
//	    }
//	 
//	 private void cargarUbigeo(ModelAndView mav,PersonalBean PersonalBean){
//
//			ubigeoBean = new UbigeoBean();
//			if(PersonalBean!=null){
//				
//				//ubigeoBean = PersonalBean.getc.getUbigeoBean();
//				//ubigeoBean.setCodigoUbigeo(PersonalBean.getPersonaBean().getUbigeoBean());
//				ubigeoBean = PersonalBean.getPersonaBean().getUbigeoBean();
//			}
//			
//			try {
//				lstRegion = this.getUbigeoService().listarRegion();
//				lstProvincia = this.getUbigeoService().listarProvincia(ubigeoBean);
//				lstDistrito = this.getUbigeoService().listarDistrito(ubigeoBean);
//				
//			} catch (ServiceException e) {
//				System.out.println("printStackTrace");
//				e.printStackTrace();
//			}		
//		
//			
//			mav.addObject("lstRegion",lstRegion); 
//			mav.addObject("lstProvincia",lstProvincia);
//			mav.addObject("lstDistrito",lstDistrito); 
//		}
//	 
//	 
//	 
//	private void cargarCombos(ModelAndView mav){
////		lstSituacion = new ArrayList<MaestraBean>();
//		
//	
//		LenguaBean lenguaBean = new LenguaBean();
//		PerfilBean perfilBean = new PerfilBean();
//		if (lstSituacion==null) {
//			try {
//				lstLengua = (List<LenguaBean>) this.getLenguaService().getBuscarPorFiltros(lenguaBean);
//				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionLengua");
//				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento");
//				lstNacionalidad = maestra2Service.listarPorCodigoTabla("nacionalidad");
//						lstGrado=  maestra2Service.listarPorCodigoTabla("grado");
//						lstCargo= maestra2Service.listarPorCodigoTabla("cargo");
//						lstSexo= maestra2Service.listarPorCodigoTabla("sexo");
//						lstPerfilBean=perfilService.getBuscarPorFiltros(perfilBean);
//						//lstRegion = this.ubigeoService.listarRegion();
//			} catch (ServiceException e) {
//				System.out.println("printStackTrace");
//				e.printStackTrace();
//			}		
//		}
//  
//		mav.addObject("lstSituacion",lstSituacion); 
//		mav.addObject("lstTipoDocumento",lstTipoDocumento); 
//		mav.addObject("lstNacionalidad",lstNacionalidad); 
//		mav.addObject("lstGrado",lstGrado); 
//		mav.addObject("lstCargo",lstCargo); 
//		mav.addObject("lstSexo",lstSexo);
//		mav.addObject("lstLengua",lstLengua); 
//		mav.addObject("lstPerfilBean",lstPerfilBean); 
//		//mav.addObject("lstRegion",lstRegion); 
//	}
//	
//private ModelAndView getLista(PersonalBean personalBean) {
//		
//		List<PersonalBean> lstPersonalBean = new ArrayList<PersonalBean>();
//		
//		try {
//			lstPersonalBean = (List<PersonalBean>) this.getPersonalService().getBuscarPorFiltros(personalBean);
//			System.out.println("lstLenguaBean "+lstPersonalBean.size());
//		} catch (Exception e) {
//			System.out.println("getLista " + e.getMessage());
//		}
//
//		
////	PersonalBean prmPersonalBean = new PersonalBean();
////		
////		prmPersonalBean.getPersonaBean().setApellidoPaterno("Prueba");
////		prmPersonalBean.getPersonaBean().setApellidoMaterno("Prueba");
////		prmPersonalBean.getPersonaBean().setNombrePersona("Prueba");
////		prmPersonalBean.getCargoPersonal().setNombreCorto("PruebaCargo");
////		prmPersonalBean.getPersonaBean().setDireccionPersona("PruebaDireccion");
//		
////		lstPersonalBean.add(prmPersonalBean);
//		
//		ModelAndView mav = new ModelAndView("general/listado-administrativo", "command",personalBean);
//		System.out.println("lstPersonalBean "+lstPersonalBean);
//		mav.addObject("lstPersonalBean", lstPersonalBean);
//		this.cargarCombos(mav);
//		return mav;
//	}
//
//	@RequestMapping(value = "/validaPersonal", method = RequestMethod.POST)
//	private @ResponseBody PersonalBean validaPersonal(@RequestParam("numerodocumento")String numeroDocumento){
//		List<PersonalBean> lstPersonalBeans=new ArrayList<PersonalBean>();
//		PersonalBean personalBean = new PersonalBean();
//		personalBean.getPersonaBean().setNumeroDocumento(numeroDocumento);
//		PersonalBean prmpersonal=new PersonalBean();
//		
//		
//		try {
//			lstPersonalBeans = personalService.getBuscarPorFiltros(personalBean);
//			if(lstPersonalBeans!=null){
//				prmpersonal=personalService.getBuscarPorObjecto(lstPersonalBeans.get(0));
//				
//				
//			}
//			
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		return prmpersonal;
//		
//	}
//
//public PersonalBean getPersonalBean() {
//	return personalBean;
//}
//
//
//public void setPersonalBean(PersonalBean personalBean) {
//	this.personalBean = personalBean;
//}
//
//
//public List<PersonalBean> getLstpersonalBean() {
//	return lstpersonalBean;
//}
//
//
//public void setLstpersonalBean(List<PersonalBean> lstpersonalBean) {
//	this.lstpersonalBean = lstpersonalBean;
//}
//
//
//public List<MaestraBean> getLstSituacion() {
//	return lstSituacion;
//}
//
//public void setLstSituacion(List<MaestraBean> lstSituacion) {
//	this.lstSituacion = lstSituacion;
//}
//
//public List<MaestraBean> getLstTipoDocumento() {
//	return lstTipoDocumento;
//}
//
//public void setLstTipoDocumento(List<MaestraBean> lstTipoDocumento) {
//	this.lstTipoDocumento = lstTipoDocumento;
//}
//
//public PersonalService getPersonalService() {
//	return personalService;
//}
//
//
//public void setPersonalService(PersonalService personalService) {
//	this.personalService = personalService;
//}
//
//public PersonaService getPersonaService() {
//	return personaService;
//}
//
//public void setPersonaService(PersonaService personaService) {
//	this.personaService = personaService;
//}
//
//public LenguaService getLenguaService() {
//	return lenguaService;
//}
//
//public void setLenguaService(LenguaService lenguaService) {
//	this.lenguaService = lenguaService;
//}
//	
////	@RequestMapping(value = "/listado", method = RequestMethod.GET)
////	public ModelAndView doNuevo() {
////		
////		ModelAndView mav = new ModelAndView("general/listado-administrativo", "command",new PersonalBean());
//////		mav.addObject("lstSituacion",lstSituacion);
//////		mav.addObject("lenguaBean", new LenguaBean());
////		return mav;
////	}
//
//		
////		@RequestMapping(value = "/lista-Personal", method = RequestMethod.GET)
////		public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {
////
//////			System.out.println("codigo " + codigo);
//////
//////			LenguaBean prmLenguaBean = new LenguaBean();
//////			prmLenguaBean.setCodigo(1);
////
////			ModelAndView mav = new ModelAndView("listado-administrativo", "command",
////					prmLenguaBean);
////
////			return mav;
////		}
////		
//		
//		
//	public UbigeoService getUbigeoService() {
//		return ubigeoService;
//	}
//	public void setUbigeoService(UbigeoService ubigeoService) {
//		this.ubigeoService = ubigeoService;
//	}
//	
//	
//	
//	
//	
//		
//	
//}
