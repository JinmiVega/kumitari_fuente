package pe.gob.procalidad.natigu.web.gestion.controller.general;
  
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.ResponseBody; 
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView; 

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaLeccionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaNivelBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaUnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.SesionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaEstructuraService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaLeccionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaNivelService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaUnidadService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UnidadLeccionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UnidadService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.SessionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.UsuarioService; 
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.controller.general.view.LenguaForm;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.FileValidator;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo; 
 
@Controller
@Scope(value="session")
@RequestMapping(value = "lenguaController")

public class LenguaController extends BaseController {
	
	private LenguaForm 			lenguaForm;

	private LenguaBean 			lenguaBean;
	
	private LenguaBean 			lenguaBeanFiltro;
	
	private LenguaEstructuraBean lenguaEstructuraBean;
	
	private List<LenguaBean> 	lstLenguaBean;
	
	private List<LenguaEstructuraBean> 	lstLenguaEstructuraBean;
	
	private List<LenguaNivelBean> 	lstLenguaNivelBean;
	
	private List<UnidadLeccionBean>	lstUnidadLeccionBean;
	
	private List<UnidadBean>	lstUnidadBean;
	
	private List<MaestraBean> 	lstUnidad;
	
	private List<MaestraBean> 	lstLeccion;
	
	private UnidadBean unidadBean;
	
	private LenguaNivelBean lenguaNivelBean;
	
	private UnidadLeccionBean unidadLeccionBean;
	
	private List<MaestraBean>	lstSituacion;
	
	private List<MaestraBean>	lstSituacionLeccion;
	
	private List<MaestraBean>	lstNivel;
	
	private List<MaestraBean>	lstSubNivel;
	
	private Integer codigoFiltro;

	@Autowired
	private LenguaService 		lenguaService;
	
	@Autowired
	private LenguaEstructuraService	lenguaEstructuraService;
	
	@Autowired
	private LenguaNivelService	lenguaNivelService;
	
	@Autowired
	private UnidadService			unidadService;
	
	@Autowired
	private UnidadLeccionService	unidadLeccionService;
	
	@Autowired
	private Maestra1Service 	maestra1Service;
	
	@Autowired
	private Maestra2Service 	maestra2Service;
	
	private String				tmpUrlImagen;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private LenguaUnidadService lenguaUnidadService;
	
	@Autowired
	private LenguaLeccionService lenguaLeccionService;
	
	@Autowired
	private PeticionService peticionService;
	@Autowired
	private SessionService sessionService;
	
	/*temporalmente*/
	List<MaestraBean>	lstSubNivel1 = new ArrayList<MaestraBean>();
	List<MaestraBean>	lstSubNivel2 = new ArrayList<MaestraBean>();
	List<MaestraBean>	lstSubNivel3 = new ArrayList<MaestraBean>();
	
	List<MaestraBean>  lstLecciones = new ArrayList<MaestraBean>();
	
	private LenguaUnidadBean     lenguaUnidadBean;
	private LenguaLeccionBean    lenguaLeccionBean;
	HttpSession sessionToken;
	
	@PostConstruct
	public void init(){
		this.setLenguaBean(new LenguaBean());
		this.setLenguaForm(new LenguaForm());
		this.setLstLenguaBean(new ArrayList<LenguaBean>()); 
		this.setLstLenguaEstructuraBean(new ArrayList<LenguaEstructuraBean>());  
		this.setLstLenguaNivelBean(new ArrayList<LenguaNivelBean>());
		this.setLstUnidadLeccionBean(new ArrayList<UnidadLeccionBean>());
		this.setLstUnidadBean(new ArrayList<UnidadBean>());
		this.setLstNivel(new ArrayList<MaestraBean>());
		this.setLstLecciones(new ArrayList<MaestraBean>());
		this.codigoFiltro = 0;
	}
	 
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("lenguaBean") LenguaBean lenguaBean,
			HttpServletRequest request	)throws Exception {  
//		return this.getLista(lenguaBean);
		ModelAndView mav = new ModelAndView("general/lengua/listado-lengua", "command",lenguaBean);
		
		
		SesionBean _sesionBean=new SesionBean();
		UsuarioBean usuario = this.getUsuarioSesion(request);
		String session_id=request.getSession().getId();
		long user_id=usuario.getCodigo();
		_sesionBean.setUser_id((int)user_id);
		_sesionBean.setSession_id(session_id);
		
		
		try {
			boolean flag_v=sessionService.sessionGestor(_sesionBean, "VALIDAR");
			
			if(flag_v) {
					System.out.println("========= CERRAR CESSION : >1 >direccionar al login ");
					sessionService.sessionGestor(_sesionBean, "CERRAR_SESSION");
					request.getSession().removeAttribute("usuarioSesion");
					request.getSession().invalidate();
					
					ModelAndView mav_v = new ModelAndView("seguridad/login/login-admin", "command",new LoginVo());
					mav_v.addObject("msgErrorLogin", "Acceso no permitido");
					mav_v.addObject("usuarioBean", usuarioBean);
					return mav_v;
					
				}else{
				//---- flujo normal
					mav.addObject("lstLenguaBean", new ArrayList<LenguaBean>());
					this.cargarCombos(mav);
					return mav;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return mav;
			}
		
		
		

		
	}
	@RequestMapping(value = "/lenguaCargarModal", method = RequestMethod.POST)
	@ResponseBody 
	public ModelAndView doListadoEstructura(@RequestParam("codigo") Integer codigo) {
		LenguaBean lenguaBean = new LenguaBean();
		lenguaBean.setCodigo(codigo);
		System.out.println("listaEstructura codigo "+ codigo);
		List<LenguaEstructuraBean>	lstLenguaEstructuraBean=null; 
		LenguaBean prmLenguaBean = new LenguaBean();
		prmLenguaBean.setCodigo(codigo); 
		 
		try { 
			if (lenguaEstructuraService.insertarLenguaEstrucTemporal(prmLenguaBean)) {
				lstLenguaEstructuraBean = lenguaEstructuraService.listarPorCodigoLengua(prmLenguaBean);
				this.setLstLenguaEstructuraBean(lstLenguaEstructuraBean);
			} 
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("general/lengua/ajax/registro-estructura-lengua-modal", "command",lenguaBean);
		 
		System.out.println("lstLenguaEstructuraBean.");
		mav.addObject("lstLenguaEstructuraBean", lstLenguaEstructuraBean);
		this.cargarNivelSubNivel(mav,lenguaBean); 
		return mav; 
	}
	
	@RequestMapping(value = "/lenguaCargarModalUnidadLeccion", method = RequestMethod.POST)
	@ResponseBody 
	public ModelAndView lenguaCargarModalUnidadLeccion(@RequestParam("codigo") Integer codigo) {
		LenguaEstructuraBean lenguaEstructuraBean = new LenguaEstructuraBean();
		lenguaEstructuraBean.setCodigo(codigo);
		 
		UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
		unidadLeccionBean.getUnidadBean().setCodigo(codigo);
		System.out.println("lenguaCargarModalUnidadLeccion codigo "+ codigo);
		
		ModelAndView mav = new ModelAndView("general/lengua/ajax/registro-unidad-estructura-lengua-modal", "command",unidadLeccionBean);
		List<MaestraBean> lstMaestra = new ArrayList<MaestraBean>();
		
		
		try {
			unidadBean =  unidadService.getBuscarPorObjecto(unidadLeccionBean.getUnidadBean());
			MaestraBean maestraBean = new MaestraBean();
			maestraBean.setCodigoTabla("leccion");
			maestraBean.setValor1(""+unidadBean.getUnidad().getCodigoRegistro());
			
			MaestraBean  prmMaestraBean = new MaestraBean();
			prmMaestraBean.setCodigoTabla("leccion");
			prmMaestraBean.setValor1("0");
			lstMaestra = maestra2Service.listarPorValor1(prmMaestraBean);
			
			lstSituacionLeccion = maestra1Service.listarPorCodigoTabla("situacionLeccion",0); 
			
			lstLeccion = maestra2Service.listarPorValor1(maestraBean);
			for (MaestraBean oMaestraBean : lstMaestra) {
				lstLeccion.add(oMaestraBean);
			}
			
			
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}	 
		try {  
			
			lstUnidadLeccionBean = unidadLeccionService
					.listarPorUnidad(unidadLeccionBean.getUnidadBean());
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		mav.addObject("lstUnidadLeccionBean",lstUnidadLeccionBean); 
		mav.addObject("lstLeccion",lstLeccion);
		mav.addObject("lstSituacionLeccion",lstSituacionLeccion); 
		mav.addObject("unidadLeccionBean", unidadLeccionBean);  
		return mav; 
	} 
	
	@RequestMapping(value = "/lenguaCargarModalSubNivel", method = RequestMethod.POST)
	@ResponseBody 
	public ModelAndView lenguaCargarModalSubNivel(@RequestParam("codigo") Integer codigo,
												  @RequestParam("codigoNivel") String codigoNivel) { 
		System.out.println("lenguaCargarModalSubNivel codigo "+ codigo);
		System.out.println("lenguaCargarModalSubNivel codigoNivel "+ codigoNivel);
		lenguaEstructuraBean  =new LenguaEstructuraBean();
		List<LenguaEstructuraBean> lstLenguaEstructuraBean = new ArrayList<LenguaEstructuraBean>();
		lenguaNivelBean = new LenguaNivelBean();
		lenguaNivelBean.setCodigo(codigo);
		lenguaEstructuraBean.setLenguaNivelBean(lenguaNivelBean);
		lenguaEstructuraBean.getNivel().setCodigoRegistro(Integer.valueOf(codigoNivel));
		ModelAndView mav = new ModelAndView("general/lengua/ajax/registro-lengua-subnivel-modal", "command",lenguaEstructuraBean);
	 	List<MaestraBean>  lstSubNivel = null;
	 	MaestraBean maestraBean = new MaestraBean();
	 	maestraBean.setCodigoTabla("subNivel");
	 	maestraBean.setValor1(codigoNivel);
		try {   
			lstSubNivel = maestra2Service.listarPorValor1(maestraBean);
			lstLenguaEstructuraBean = lenguaEstructuraService.listarPorCodigoNivelLengua(lenguaNivelBean);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		} 
		System.out.println("lstSubNivel codigo "+ lstSubNivel);
		System.out.println("lstLenguaEstructuraBean codigo "+ lstLenguaEstructuraBean);
		mav.addObject("lstSubNivel",lstSubNivel);  
	 	mav.addObject("lstLenguaEstructuraBean", lstLenguaEstructuraBean);  
		return mav; 
	}
	
	
	private void cargarNivelSubNivel(ModelAndView mav, LenguaBean lenguaBean ){ 
		MaestraBean prmMaestra = new MaestraBean();
		prmMaestra.setCodigoTabla("subNivel"); 
		lstNivel = new ArrayList<MaestraBean>();
		lstSubNivel = new ArrayList<MaestraBean>();
		lstSubNivel1 = new ArrayList<MaestraBean>();
		lstSubNivel2 = new ArrayList<MaestraBean>();
		lstSubNivel3 = new ArrayList<MaestraBean>();
		mav.addObject("I","none"); 
		mav.addObject("A","none"); 
		 
		if (lstNivel.size() == 0) {
			try {
				lstNivel = maestra2Service.listarPorCodigoTabla("nivel",1);
			} catch (ServiceException e) { 
				 
			} 
		}
			  
			try {
				lstSubNivel = maestra2Service.listarPorCodigoTabla("subNivel",0);
				///for (MaestraBean oNivel :lstNivel ) {
					for (MaestraBean osubNivel :lstSubNivel ) {
						if (osubNivel.getValor1().equals("1")) { 
							lstSubNivel1.add(osubNivel);
						}else if(osubNivel.getValor1().equals("2")){
							lstSubNivel2.add(osubNivel);
						}else if(osubNivel.getValor1().equals("3")){
							lstSubNivel3.add(osubNivel);
						}
				//	}
				}
			} catch (ServiceException e) { 
				 
			}   
		if (lstLenguaEstructuraBean != null) {
			if (lstLenguaEstructuraBean.size() > 0) {
				LenguaEstructuraBean prmLenguaEstructuraBean = new LenguaEstructuraBean();
				prmLenguaEstructuraBean.setLenguaBean(lenguaBean);
				List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = null;
				try {
					lstLenguaEstructuraBeanNivel = lenguaEstructuraService.listarNiveles(lenguaBean);
				} catch (ServiceException e1) {
					e1.printStackTrace();
				} 
					try { 
						if (lstLenguaEstructuraBeanNivel != null) {
							for (LenguaEstructuraBean oLenguaEstructuraBean :lstLenguaEstructuraBeanNivel) {
								for(MaestraBean oMaestraBean :lstNivel){
									 if(oMaestraBean.getCodigoRegistro() == oLenguaEstructuraBean.getNivel().getCodigoRegistro()){
										 	mav.addObject(oMaestraBean.getNombreLargo(),""); 
										 	oMaestraBean.setValor1("checked");
										 	oMaestraBean.setValor4(oLenguaEstructuraBean.getNivel().getValor4());
										}else{
										//	oMaestraBean.setValor1(""); 
										//	mav.addObject(oMaestraBean.getNombreLargo(),"none"); 
										}
									 this.setLstNivel(lstNivel);
								 }
							}
							// GENERAR DINAMICO//
							prmLenguaEstructuraBean.getNivel().setCodigoRegistro(1); 
							List<LenguaEstructuraBean> lstLenguaEstructuraBeanSubNivel = 
										lenguaEstructuraService.listarSubNiveles(prmLenguaEstructuraBean);
							if (lstLenguaEstructuraBeanSubNivel != null) {
								for (LenguaEstructuraBean oLenguaEstructuraSubNivelBean :lstLenguaEstructuraBeanSubNivel) {
									for(MaestraBean oMaestraBean :lstSubNivel1){
										if(oMaestraBean.getCodigoRegistro() == oLenguaEstructuraSubNivelBean.getSubNivel().getCodigoRegistro()){ 
										 	oMaestraBean.setValor1("checked");
										}else{ 
										}
										this.setLstSubNivel1(lstSubNivel1);
									}
								}
							}
							prmLenguaEstructuraBean.getNivel().setCodigoRegistro(2); 
							List<LenguaEstructuraBean> lstLenguaEstructuraBeanSubNivel2 = 
									lenguaEstructuraService.listarSubNiveles(prmLenguaEstructuraBean);
							if (lstLenguaEstructuraBeanSubNivel2 != null) { 
								for (LenguaEstructuraBean oLenguaEstructuraSubNivelBean :lstLenguaEstructuraBeanSubNivel2) {
									for(MaestraBean oMaestraBean :lstSubNivel2){
										if(oMaestraBean.getCodigoRegistro() == oLenguaEstructuraSubNivelBean.getSubNivel().getCodigoRegistro()){ 
										 	oMaestraBean.setValor1("checked");
										}else{
										}
										this.setLstSubNivel2(lstSubNivel2);
									}
								}  
							}
							prmLenguaEstructuraBean.getNivel().setCodigoRegistro(3); 
							List<LenguaEstructuraBean> lstLenguaEstructuraBeanSubNivel3 = 
									lenguaEstructuraService.listarSubNiveles(prmLenguaEstructuraBean);
							if (lstLenguaEstructuraBeanSubNivel3 != null) { 
								for (LenguaEstructuraBean oLenguaEstructuraSubNivelBean :lstLenguaEstructuraBeanSubNivel3) {
									for(MaestraBean oMaestraBean :lstSubNivel3){
										if(oMaestraBean.getCodigoRegistro() == oLenguaEstructuraSubNivelBean.getSubNivel().getCodigoRegistro()){ 
										 	oMaestraBean.setValor1("checked");
										}else{
										}
										this.setLstSubNivel3(lstSubNivel3);
									}
								 }
							 } 
						} 
					} catch (ServiceException e) {
						System.out.println("printStackTrace");
						e.printStackTrace();
					}	  
			} 
		} 
		System.out.println("lstNivel "+ lstNivel.size());
		mav.addObject("lstNivel",lstNivel); 
	//	mav.addObject("lstSubNivel",lstSubNivel);  
		mav.addObject("lstSubNivel1",lstSubNivel1);  
		mav.addObject("lstSubNivel2",lstSubNivel2);  
		mav.addObject("lstSubNivel3",lstSubNivel3);  
		
	
	}  
	
	
	/*
	@RequestMapping(value = "/grabarEstructura", method = RequestMethod.POST) 
	@ResponseBody
	public String grabarEstructura(@RequestParam("codigo") Integer codigo, @RequestParam("subNiveles") String[] subNiveles,
			  @RequestParam("nombreNivel") String[] nombreNiveles) {
		String mensage=  "";
		LenguaEstructuraBean lenguaEstructuraBean = new LenguaEstructuraBean();
		LenguaBean lenguaBean = new LenguaBean();
		lenguaBean.setCodigo(codigo);
		lenguaEstructuraBean.setLenguaBean(lenguaBean);
		System.out.println("grabarEstructura codigo "+ codigo);
		System.out.println("listaEstructura subNiveles "+ subNiveles.toString());
		 
		List<MaestraBean> lstSubNiveles = null; 
		Boolean sw = true;		
		
		try {
			lstSubNiveles = maestra2Service.listarPorCodigoTabla("subNivel",0);
			for (MaestraBean oSubNivel : lstSubNiveles) {
				lenguaEstructuraBean.setSubNivel(oSubNivel);
				lenguaEstructuraBean.getSituacion().setCodigoRegistro(1);
				lenguaEstructuraBean.getNivel().setCodigoRegistro(Integer.valueOf(oSubNivel.getValor1()));
				lenguaEstructuraBean.setSwActivo("0");
				for (String dataNombre : nombreNiveles) {
					System.out.println("oNivel getValor4" + dataNombre.substring(0,1));
					if (Integer.valueOf(dataNombre.substring(0,1)) == Integer.valueOf(oSubNivel.getValor1())) {
						lenguaEstructuraBean.setNombreNivel(dataNombre.substring(1,dataNombre.length()));
						System.out.println("oNivel getValor4" + dataNombre);
						break;
					}
					
				}
				for (String data : subNiveles) {
					if (data.equals(oSubNivel.getCodigoRegistro().toString())) {
						lenguaEstructuraBean.setSwActivo("1");
						System.out.println("subNiveles == >" + data);
					} 
		        }
				sw = lenguaEstructuraService.insertar(lenguaEstructuraBean);
				
			}
			
			mensage ="1";
		} catch (ServiceException e1) { 
			e1.printStackTrace();
		}
		 
		System.out.println("sw ::: " + sw);  
		System.out.println("modificar lenguaBean: " + lenguaBean); 
		return mensage;
	}
	*/
	@RequestMapping(value = "/grabarUnidad", method = RequestMethod.POST) 
	@ResponseBody
	public String grabarUnidad(@ModelAttribute("lenguaForm") LenguaForm lenguaForm, 
			 HttpServletRequest request) {
		System.out.println("grabarUnidad lenguaForm " +lenguaForm.getUnidadBean().getCodigo());
		String mensage=  ""; 
		//UnidadBean unidadBean = new  UnidadBean();
		//unidadBean.setLenguaEstructuraBean(lenguaForm.getLenguaEstructuraBean());
		lenguaForm.getUnidadBean().setLenguaEstructuraBean(lenguaForm.getLenguaEstructuraBean());
		System.out.println("lenguaForm.getLenguaEstructuraBean().getCodigo() " + lenguaForm.getLenguaEstructuraBean().getCodigo());
	 
		this.setUnidadBean(lenguaForm.getUnidadBean()); 
		if (lenguaForm.getLenguaEstructuraBean().getCodigo() == 0
				//&& lenguaForm.getUnidadBean().getUnidad().getCodigoRegistro() == 0 
			//	&& lenguaForm.getUnidadBean().getNombre() !=""
				
				) {
			mensage ="2";
		}else{  
			try {
					
					if (unidadService.existe(unidadBean)) {
						mensage ="3";
					}else{
					if (unidadBean.getCodigo() == 0) {
						System.out.println("insertar unidadBean: " + unidadBean);
						this.setAuditoria(unidadBean, request, true);
						unidadService.insertar(unidadBean);
						 
					}else{
						System.out.println("modificar unidadBean: " + unidadBean);
						this.setAuditoria(unidadBean, request, false);
						unidadService.actualizar(unidadBean);
					} 
					mensage ="1";
					}
				} catch (ServiceException e1) { 
					e1.printStackTrace();
				} 
		}
		 
		return mensage;
		 
	}
	
	@RequestMapping(value = "/grabarEstructuraSinImg", method = RequestMethod.POST) 
	@ResponseBody
	public String grabarEstructuraSinImg(
			 					   @RequestParam("codigo") Integer codigo,
			 					   @RequestParam("codNivelBean") Integer codigoNivelBean,
								   @RequestParam("codLengua") Integer codLengua,
								   @RequestParam("codRegNivel") Integer codRegNivel,
								   @RequestParam("codRegSubNivel") Integer codRegSubNivel,    
								   HttpServletRequest request) {
		String mensage=  "";
		LenguaEstructuraBean lenguaEstructuraBean = new LenguaEstructuraBean();
		LenguaBean lenguaBean = new LenguaBean();
		lenguaBean.setCodigo(codLengua);
		LenguaNivelBean lenguaNivelBean = new LenguaNivelBean();
		lenguaNivelBean.setCodigo(codigoNivelBean);
		lenguaEstructuraBean.setCodigo(codigo);
		lenguaEstructuraBean.setLenguaBean(lenguaBean); 
		lenguaEstructuraBean.setLenguaNivelBean(lenguaNivelBean);
		System.out.println("codRegNivel " + codRegNivel);
		lenguaEstructuraBean.getNivel().setCodigoRegistro(codRegNivel); 
		lenguaEstructuraBean.getSubNivel().setCodigoRegistro(codRegSubNivel);
		lenguaEstructuraBean.setSwActivo("1");
		
		System.out.println("grabarEstructura codigo " +codigo); 
 

		this.setLenguaEstructuraBean(lenguaEstructuraBean);;
		 
			try {
					
					if (lenguaEstructuraService.existe(lenguaEstructuraBean)) {
						mensage ="3";
					}else{
					if (lenguaEstructuraBean.getCodigo() == 0) {
						
						System.out.println("insertar lenguaEstructuraBean: " + lenguaEstructuraBean);
						this.setAuditoria(lenguaEstructuraBean, request, true);
						lenguaEstructuraService.insertar(lenguaEstructuraBean);
						 
						 
					}else{
						
						System.out.println("modificar lenguaEstructuraBean: " + lenguaEstructuraBean);
						this.setAuditoria(lenguaEstructuraBean, request, false);
						lenguaEstructuraService.actualizar(lenguaEstructuraBean);
						 
					  } 
					mensage ="1";
					}
					
//					}
				} catch (ServiceException e1) { 
					e1.printStackTrace();
				}
		 
		 
		return mensage;
	}

	@RequestMapping(value = "/grabarEstructura", method = RequestMethod.POST) 
	@ResponseBody
	public String grabarEstructura(
			 					   @RequestParam("codigo") Integer codigo,
			 					   @RequestParam("codNivelBean") Integer codigoNivelBean,
								   @RequestParam("codLengua") Integer codLengua,
								   @RequestParam("codRegNivel") Integer codRegNivel,
								   @RequestParam("codRegSubNivel") Integer codRegSubNivel,  
								   @RequestParam("files") MultipartFile[] files, 
								   HttpServletRequest request) {
		String mensage=  "";
		LenguaEstructuraBean lenguaEstructuraBean = new LenguaEstructuraBean();
		LenguaBean lenguaBean = new LenguaBean();
		lenguaBean.setCodigo(codLengua);
		LenguaNivelBean lenguaNivelBean = new LenguaNivelBean();
		lenguaNivelBean.setCodigo(codigoNivelBean);
		lenguaEstructuraBean.setCodigo(codigo);
		lenguaEstructuraBean.setLenguaBean(lenguaBean); 
		lenguaEstructuraBean.setLenguaNivelBean(lenguaNivelBean);
		System.out.println("codRegNivel " + codRegNivel);
		lenguaEstructuraBean.getNivel().setCodigoRegistro(codRegNivel); 
		lenguaEstructuraBean.getSubNivel().setCodigoRegistro(codRegSubNivel);
		lenguaEstructuraBean.setSwActivo("1");
		
		System.out.println("grabarEstructura codigo " +codigo);
		Boolean sw = true;		
		boolean swNuevaUrlImagen = false;
		 
		if (files.length > 0 && files != null) {
			swNuevaUrlImagen = (files[0] != null) && (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "")
					&& (files[0].getOriginalFilename().trim().length() > 0);
			System.out.println(swNuevaUrlImagen);	
			System.out.println(files[0].getOriginalFilename());
		}
		if (swNuevaUrlImagen) 
		{

			lenguaEstructuraBean.setFileImagen(files[0]);
			if (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "") 
			{
				lenguaEstructuraBean.setNombreImagen(VO.convertirCaracteresEsp(files[0].getOriginalFilename()));
				System.out.println(lenguaEstructuraBean.getNombreImagen());
			}
		}

		this.setLenguaEstructuraBean(lenguaEstructuraBean);;
		 
			try {
					
					if (lenguaEstructuraService.existe(lenguaEstructuraBean)) {
						mensage ="3";
					}else{
					if (lenguaEstructuraBean.getCodigo() == 0) {
						
						System.out.println("insertar lenguaEstructuraBean: " + lenguaEstructuraBean);
						this.setAuditoria(lenguaEstructuraBean, request, true);
						lenguaEstructuraService.insertar(lenguaEstructuraBean);
						
						if (swNuevaUrlImagen) {
							super.cargarArchivo(this.getRootPathSubNivel(), renombrarImagen2(files, lenguaEstructuraBean.getCodigo()), lenguaEstructuraBean.getFileImagen());
						}
						
						 
					}else{
						
						System.out.println("modificar lenguaEstructuraBean: " + lenguaEstructuraBean);
						this.setAuditoria(lenguaEstructuraBean, request, false);
						lenguaEstructuraService.actualizar(lenguaEstructuraBean);
						if (swNuevaUrlImagen) {
							super.cargarArchivo(this.getRootPathSubNivel(), renombrarImagen2(files, lenguaEstructuraBean.getCodigo()), lenguaEstructuraBean.getFileImagen());
						} 
					  } 
					mensage ="1";
					}
					
//					}
				} catch (ServiceException e1) { 
					e1.printStackTrace();
				}
		 
		 
		return mensage;
	}
	
	@RequestMapping(value = "/grabarUnidad_Img", method = RequestMethod.POST) 
	@ResponseBody
	public String grabarUnidad_Img(@RequestParam("codLengua") Integer codLengua,
							   @RequestParam("codSubNivel") Integer codSubNivel,
							   @RequestParam("unidad") Integer unidad,
							   @RequestParam("nombreUnidad") String nombreUnidad,
							   @RequestParam("files") MultipartFile[] files,
							   @RequestParam("descripcion") String descripcion,
							   @RequestParam("codUnidadBean") Integer codUnidadBean,
							   HttpServletRequest request) {
		System.out.println("grabarUnidad");
		String mensage=  ""; 
		
		UnidadBean oUnidadBean = new UnidadBean();
		oUnidadBean.setCodigo(codUnidadBean);
		oUnidadBean.getLenguaEstructuraBean().setCodigo(codLengua);
		oUnidadBean.getUnidad().setCodigoRegistro(unidad);
		oUnidadBean.setDescripcion(VO.convertirCaracteresEsp(descripcion));
		oUnidadBean.getSituacion().setCodigoRegistro(1);
		oUnidadBean.setNombre(VO.convertirCaracteresEsp(nombreUnidad));
		
		boolean swNuevaUrlImagen = false;
		 
		if (files.length > 0 && files != null) {
			swNuevaUrlImagen = (files[0] != null) && (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "")
					&& (files[0].getOriginalFilename().trim().length() > 0);
			System.out.println(swNuevaUrlImagen);	
			System.out.println(files[0].getOriginalFilename());
		}
		if (swNuevaUrlImagen) 
		{

			oUnidadBean.setFileImagen(files[0]);
			if (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "") 
			{
				oUnidadBean.setNombreImagen(VO.convertirCaracteresEsp(files[0].getOriginalFilename()));
				System.out.println(oUnidadBean.getNombreImagen());
			}
		}

		this.setUnidadBean(oUnidadBean);
		
		if (oUnidadBean.getLenguaEstructuraBean().getCodigo() == 0) {
			mensage ="2";
		}else{
			try {
					
//					if (unidadService.existe(unidadBean)) {
//						mensage ="3";
//					}else{
					if (oUnidadBean.getCodigo() == 0) {
						
						System.out.println("insertar unidadBean: " + unidadBean);
						this.setAuditoria(unidadBean, request, true);
						unidadService.insertar(unidadBean);
						
						if (swNuevaUrlImagen) {
							super.cargarArchivo(this.getRootPathUnidad(), renombrarImagen(files, unidadBean.getCodigo()), unidadBean.getFileImagen());
						}
						
						 
					}else{
						
						System.out.println("modificar unidadBean: " + unidadBean);
						this.setAuditoria(unidadBean, request, false);
						unidadService.actualizar(unidadBean);
						if (swNuevaUrlImagen) {
							super.cargarArchivo(this.getRootPathUnidad(), renombrarImagen(files, unidadBean.getCodigo()), unidadBean.getFileImagen());
						}
						
					} 
					mensage ="1";
//					}
				} catch (ServiceException e1) { 
					e1.printStackTrace();
				}
		}
		
		 
		return mensage;
		 
	}
	   
	@RequestMapping(value = "/eliminarUnidad", method = RequestMethod.GET) 
	@ResponseBody
	public String eliminarUnidad(@RequestParam("codigo") Integer codigo,
			 HttpServletRequest request) {
		System.out.println("eliminarUnidad  " + codigo);
		UnidadBean unidadBean = new UnidadBean();
		unidadBean.setCodigo(codigo);
		String mensage=  "";  	
		try { 
				this.setAuditoria(unidadBean, request, false);
				unidadService.eliminar(unidadBean);
			  
			mensage ="1";
		} catch (ServiceException e1) { 
			mensage ="2";
			e1.printStackTrace();
		} 
		  
		return mensage;
		 
	}
	
	@RequestMapping(value = "/eliminarLeccion", method = RequestMethod.GET) 
	@ResponseBody
	public String eliminarLeccion(@RequestParam("codigo") Integer codigo,
			 HttpServletRequest request) {
		System.out.println("eliminarUnidad  " + codigo);
		UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
		unidadLeccionBean.setCodigo(codigo);
		String mensage=  "";  	
		try { 
				this.setAuditoria(unidadLeccionBean, request, false);
				unidadLeccionService.eliminar(unidadLeccionBean);
			  
			mensage ="1";
		} catch (ServiceException e1) { 
			mensage ="2";
			e1.printStackTrace();
		} 
		  
		return mensage;
		 
	}
	@RequestMapping(value = "/grabarNivel", method = RequestMethod.POST) 
	@ResponseBody
	public String grabarNivel(@ModelAttribute("lenguaForm") LenguaForm lenguaForm,
			 HttpServletRequest request) {
		System.out.println("grabarNivel");
		String mensage=  ""; 
		this.setLenguaNivelBean(lenguaForm.getLenguaNivelBean()); 
		lenguaNivelBean.setLenguaBean(lenguaForm.getLenguaBean());
		System.out.println("lenguaForm.getLenguaNivelBean().getCodigo() " + lenguaForm.getLenguaNivelBean().getCodigo());
		if (lenguaForm.getLenguaBean().getCodigo() == 0 
				
				) {
			mensage ="2";
		}else{  
			try {
					
				if (lenguaNivelService.existe(lenguaNivelBean)) {
					mensage ="3";
				}else{
					if (lenguaNivelBean.getCodigo() == 0) {
						System.out.println("insertar lenguaNivelBean: " + lenguaNivelBean);
						this.setAuditoria(lenguaNivelBean, request, true);
						lenguaNivelService.insertar(lenguaNivelBean);
						 
					}else{
						System.out.println("modificar lenguaNivelBean: " + lenguaNivelBean);
						this.setAuditoria(lenguaNivelBean, request, false);
						lenguaNivelService.actualizar(lenguaNivelBean);
					} 
					mensage ="1";
				}
			} catch (ServiceException e1) { 
				e1.printStackTrace();
			} 
		}
		 
		return mensage;
		 
	}
	
	@RequestMapping(value = "/modificarNivel", method = RequestMethod.GET)
	@ResponseBody
	public  LenguaNivelBean modificarNivel( @RequestParam("codigo") Integer codLenguaNivel) throws Exception {
		
		System.out.println("modificarNivel codigo " + codLenguaNivel);
		LenguaNivelBean lenguaNivelBean = null;
		LenguaNivelBean prmLenguaNivelBean = new LenguaNivelBean();
		prmLenguaNivelBean.setCodigo(codLenguaNivel); 
		if (codLenguaNivel > 0) {
			lenguaNivelBean =  lenguaNivelService.getBuscarPorObjecto(prmLenguaNivelBean);
			if (lenguaNivelBean != null) {
				System.out.println("lenguaNivelBean is not null" + lenguaNivelBean);
			}else{
				System.out.println("lenguaNivelBean is  null");
			}
		}
		return lenguaNivelBean;
	}
	
	@RequestMapping(value = "/modificarUnidad", method = RequestMethod.GET)
	@ResponseBody
	public  UnidadBean modificarUnidad( @RequestParam("codigo") Integer codUnidad) throws Exception {
		
		System.out.println("modificarUnidad codigo " + codUnidad);
		UnidadBean unidadBean = null;
		UnidadBean prmUnidad = new UnidadBean();
		prmUnidad.setCodigo(codUnidad); 
		if (codUnidad > 0) {
			unidadBean =  unidadService.getBuscarPorObjecto(prmUnidad);
			if (unidadBean != null) {
				System.out.println("unidadBean is not null" + unidadBean);
			}else{
				System.out.println("unidadBean is  null");
			}
		}
		return unidadBean;
	}
	
	@RequestMapping(value = "/grabarLeccion", method = RequestMethod.POST) 
	@ResponseBody
	public String grabarLeccion(@ModelAttribute("unidadLeccionBean") UnidadLeccionBean unidadLeccionBean,
			 HttpServletRequest request) {
		 
		System.out.println("grabarLeccion " + unidadLeccionBean );
		System.out.println("grabarLeccion codigo " + unidadLeccionBean.getCodigo() );
		System.out.println("grabarLeccion nombre " + unidadLeccionBean.getNombre());
		String mensage=  "";  
		if (!unidadLeccionBean.getNombre().equals("") ) {
			try {
				if(!unidadLeccionService.existe(unidadLeccionBean)){
					if (unidadLeccionBean.getCodigo() == 0) {
						this.setAuditoria(unidadLeccionBean, request, true);
						unidadLeccionService.insertar(unidadLeccionBean);
						 
					}else{
						this.setAuditoria(unidadLeccionBean, request, false);
						unidadLeccionService.actualizar(unidadLeccionBean);
					} 
					mensage ="1";
				}else{
					mensage ="3";
				}
				
			} catch (ServiceException e1) { 
				e1.printStackTrace();
			} 
			 
		}else{
			mensage ="2";
		}	
	
		System.out.println("modificar lenguaBean: " + lenguaBean); 
		return mensage;
		 
	}
	
	/***
	@RequestMapping(value = "/grabarLeccion", method = RequestMethod.POST) 
	@ResponseBody
	public String grabarLeccion(@RequestParam("idUnidad") Integer idUnidad,
								@RequestParam("nombreLeccion") String nombreLeccion,
								@RequestParam("sitLeccion") Integer sitLeccion,
								@RequestParam("leccion") Integer leccion,
								@RequestParam("files") MultipartFile[] files,
								@RequestParam("idLeccion") Integer idLeccion,
			 HttpServletRequest request) {
		UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
		boolean swNuevaUrlImagen = false;
		
		unidadLeccionBean.setCodigo(idLeccion);
		unidadLeccionBean.setNombre(nombreLeccion);
		unidadLeccionBean.getSituacion().setCodigoRegistro(sitLeccion);
		unidadLeccionBean.setDescripcion("");
		System.out.println("leccion"+ leccion);
		unidadLeccionBean.setLeccion( new MaestraBean());
		unidadLeccionBean.getLeccion().setCodigoRegistro(leccion);
		unidadLeccionBean.getUnidadBean().setCodigo(idUnidad);
		
		System.out.println("grabarLeccion " + unidadLeccionBean );
		System.out.println("grabarLeccion codigo " + unidadLeccionBean.getCodigo() );
		System.out.println("grabarLeccion nombre " + unidadLeccionBean.getNombre());
		String mensage=  "";  
		
		if (files.length > 0 && files != null   ) 
		{
			swNuevaUrlImagen = (files[0] != null) && (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "")
							&& (files[0].getOriginalFilename().trim().length() > 0);
			System.out.println(swNuevaUrlImagen);
			System.out.println(files[0].getOriginalFilename());
		}
		if (swNuevaUrlImagen) 
		{
			unidadLeccionBean.setFileImagen(files[0]);
			if (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "") 
			{
				unidadLeccionBean.setNombreImagen(files[0].getOriginalFilename());
				System.out.println(unidadLeccionBean.getNombreImagen());
			}
		}		
		
		if (!unidadLeccionBean.getNombre().equals("") && unidadLeccionBean.getSituacion().getCodigoRegistro() > 0) {
			try {
//				if(!unidadLeccionService.existe(unidadLeccionBean)){
					if (unidadLeccionBean.getCodigo() == 0) {
						this.setAuditoria(unidadLeccionBean, request, true);
						unidadLeccionService.insertar(unidadLeccionBean);
						
						super.cargarArchivo(this.getRootPathLeccion(), renombrarImagen(files, unidadLeccionBean.getCodigo()), unidadLeccionBean.getFileImagen());
						 
					}else{
						this.setAuditoria(unidadLeccionBean, request, false);
						unidadLeccionService.actualizar(unidadLeccionBean);
						super.cargarArchivo(this.getRootPathLeccion(), renombrarImagen(files, unidadLeccionBean.getCodigo()), unidadLeccionBean.getFileImagen());
					} 
					mensage ="1";
//				}else{
//					mensage ="3";
//				}
				
			} catch (ServiceException e1) { 
				e1.printStackTrace();
			} 
			 
		}else{
			mensage ="2";
		}	
	
		System.out.println("modificar lenguaBean: " + lenguaBean); 
		return mensage;
		 
	}
	*/
	@RequestMapping(value = "/modificarLeccion", method = RequestMethod.GET)
	@ResponseBody
	public  UnidadLeccionBean modificarLeccion( @RequestParam("codigo") Integer codUnidadLeccion) throws Exception {
		
		System.out.println("UnidadLeccionBean codigo " + codUnidadLeccion);
		UnidadLeccionBean unidadLeccionBean = null;
		UnidadLeccionBean prmUnidadLeccion = new UnidadLeccionBean();
		prmUnidadLeccion.setCodigo(codUnidadLeccion); 
		if (codUnidadLeccion > 0) {
			unidadLeccionBean =  unidadLeccionService.getBuscarPorObjecto(prmUnidadLeccion);
			if (unidadLeccionBean != null) {
				System.out.println("unidadLeccionBean is not null" + unidadLeccionBean);
				System.out.println("unidadLeccionBean.getLeccion() " + unidadLeccionBean.getLeccion().getCodigoRegistro());
			}else{
				System.out.println("unidadLeccionBean is  null");
			}
		}
		return unidadLeccionBean;
	}
	
	@RequestMapping(value = "/recargarListadoxLengua", method = RequestMethod.GET)
	public ModelAndView recargarListadoxLengua(@RequestParam("codigo") Integer codigo) {

		System.out.println("codigo recargarListadoxInscripcion " + codigo);
		
		ModelAndView mav = new ModelAndView("general/lengua/listado-estructura-lengua"); 
	
		cargarEstructuraXLengua(mav,codigo);
		return mav;
	}
	
	private void cargarEstructuraXLengua(ModelAndView mav, int codigo){ 
		System.out.println("cargarInscripcionXLengua codigoMatcodigoMatcodigoMat " + codigo);
		List<LenguaNivelBean>	lstLenguaNivelBean=null; 
		LenguaBean prmLenguaBean = new LenguaBean();
		prmLenguaBean.setCodigo(codigo); 
		 
		try { 
			lstLenguaNivelBean = lenguaNivelService.listarPorCodigoLengua(prmLenguaBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}

		System.out.println("mav " + mav); 
		mav.addObject("lstLenguaNivelBean", lstLenguaNivelBean);
	
	} 
	
	@RequestMapping(value = "/listarLenguas", method = RequestMethod.GET)
	public ModelAndView listarLenguas(@RequestParam("codigo") Integer codigo)
			throws Exception {
		System.out.println("/listarLenguas");
		ModelAndView mav = new ModelAndView("general/lengua/ajax/listado-tabla-lenguas");
		List<LenguaBean> lstLenguaBean =new ArrayList<LenguaBean>(); 
		try {
			lstLenguaBean = (List<LenguaBean>) this.getLenguaService().getBuscarPorFiltros(new LenguaBean());
			System.out.println("lstLenguaBean actual :: "+lstLenguaBean.size());
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		} 
		System.out.println("lstLenguaBean "+lstLenguaBean);
		mav.addObject("lstLenguaBean", lstLenguaBean); 
		return mav;
	}
/***	
	@RequestMapping(value = "/listarUnidades", method = RequestMethod.GET)
	public ModelAndView listarUnidades(@RequestParam("codigo") Integer codigo)
			throws Exception {
		System.out.println("/listarUnidades");
		ModelAndView mav = new ModelAndView("general/lengua/ajax/listado-lengua-unidades"); 
		LenguaBean prmLenguaBean = new LenguaBean();
		prmLenguaBean.setCodigo(codigo); 
		try { 
			lstUnidadBean = unidadService.listarPorCodigoLengua(prmLenguaBean);
 
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		
		System.out.println("lstLenguaBean "+lstLenguaBean);
		mav.addObject("lstUnidadBean", lstUnidadBean);
		return mav;
	}
*/	
 
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscarListado(@ModelAttribute("lenguaBean") LenguaBean lenguaBean)
			throws Exception { 
		return this.doBuscar(lenguaBeanFiltro);
	}
	
 
	@RequestMapping(value = "/listarUnidades", method = RequestMethod.POST)
	@ResponseBody
	public  List<UnidadBean>  listarUnidades(@RequestParam("codigo") Integer codigo)
			throws Exception {
		System.out.println("/listarUnidades");
		//ModelAndView mav = new ModelAndView("general/lengua/ajax/listado-lengua-unidades"); 
		LenguaBean prmLenguaBean = new LenguaBean();
		prmLenguaBean.setCodigo(codigo); 
		System.out.println("codigo: "+codigo);
		try { 
			lstUnidadBean = unidadService.listarPorCodigoLengua(prmLenguaBean);
//			System.out.println("lstUnidadBean.size " + lstUnidadBean.size());
		} catch (ServiceException e) {
//			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		
		System.out.println("lstLenguaBean "+lstLenguaBean);
	//	mav.addObject("lstUnidadBean", lstUnidadBean);
		return lstUnidadBean;
	}
	 
 
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("lenguaBean") LenguaBean lenguaBean)
			throws Exception { 
		lenguaBeanFiltro = lenguaBean;
		return this.getLista(lenguaBean);
	}
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ModelAndView buscar(@ModelAttribute("lenguaBean") LenguaBean lenguaBean)
			throws Exception { 
		return this.getLista(lenguaBean);
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		cargarComboLeccion();
		ModelAndView mav = new ModelAndView("general/lengua/registro-lengua", "command",new LenguaForm());
		List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = new ArrayList<LenguaEstructuraBean>() ; 
		System.out.println("lstLenguaEstructuraBeanNivel ES NULL" ); 
		for (MaestraBean oNivel :lstNivel ) {
			lenguaEstructuraBean = new LenguaEstructuraBean();
			System.out.println("oNivel " + oNivel.getNombreCorto());
			lenguaEstructuraBean.setNivel(oNivel);
			lstLenguaEstructuraBeanNivel.add(lenguaEstructuraBean);
		} 
		cargarCombos(mav);
		mav.addObject("lstNivel",lstLenguaEstructuraBeanNivel);
		System.out.println("lstNivel " + lstNivel.size());
		mav.addObject("lstLecciones",lstLecciones);
		 
		mav.addObject("lenguaForm", new LenguaForm());
		this.setLstLenguaNivelBean(new ArrayList<LenguaNivelBean>());  
		this.setLstUnidadBean(new ArrayList<UnidadBean>());  
		tmpUrlImagen = "";
		return mav;
	}
	private void cargarComboLeccion(){
		
		try {
			lstLecciones = this.maestra2Service.listarPorCodigoTabla("leccion", 0);
			lstNivel = maestra2Service.listarPorCodigoTabla("nivel",1);
			if (lstLecciones != null && lstLecciones.size() >0) {
				System.out.println("lstLecciones"+lstLecciones);
			}else{
				System.out.println("lst vacia.");
			}
			if (lstNivel != null && lstLecciones.size() >0) {
				System.out.println("lstNivel"+lstNivel.size());
			}else{
				System.out.println("lstNivel vacia.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/cargarEstructura", method = RequestMethod.GET)
	public ModelAndView cargarEstructura() { 
		ModelAndView mav = new ModelAndView("general/lengua/registro-estructura-lengua", "command",new LenguaBean());
		mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("lstNivel",lstNivel);
		mav.addObject("lenguaBean", new LenguaBean());
		return mav;
	}
	
	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificarGET(HttpServletRequest request) {
		
		return this.doModificar(codigoFiltro, request);
	}
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo, HttpServletRequest request) {
		codigoFiltro = codigo;
		System.out.println("modificar codigo: " + codigo);
		List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = new ArrayList<LenguaEstructuraBean>() ;
		LenguaEstructuraBean lenguaEstructuraBean  ;
		LenguaBean prmLenguaBean = new LenguaBean();
		prmLenguaBean.setCodigo(codigo);
		cargarComboLeccion();
		System.out.println("modificar lenguaBean: " + lenguaBean);
		ModelAndView mav = new ModelAndView("general/lengua/registro-lengua", "command", lenguaForm);
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try {
				lenguaBean = this.getLenguaService().getBuscarPorObjecto(prmLenguaBean); 
				lstLenguaNivelBean = lenguaNivelService.listarPorCodigoLengua(prmLenguaBean);
					
				 
				lenguaForm.setLenguaBean(lenguaBean);
				tmpUrlImagen = lenguaBean.getImagenNombre();
				
			} catch (ServiceException e) { 
				e.printStackTrace();
			}
			 
				try { 
					lstUnidadBean = unidadService.listarPorCodigoLengua(prmLenguaBean);
					lstLenguaEstructuraBeanNivel = lenguaEstructuraService
							.listarNiveles(lenguaBean);
				} catch (ServiceException e) {
					System.out.println("printStackTrace");
					e.printStackTrace();
				}
				/*	if (lstLenguaEstructuraBeanNivel != null && lstLenguaEstructuraBeanNivel.size() >0) {
					
					System.out.println("lstLenguaEstructuraBeanNivel"+lstLenguaEstructuraBeanNivel.size());
				}else{*/
					lstLenguaEstructuraBeanNivel = new ArrayList<LenguaEstructuraBean>();
					System.out.println("lstLenguaEstructuraBeanNivel ES NULL" ); 
					for (MaestraBean oNivel :lstNivel ) {
						lenguaEstructuraBean = new LenguaEstructuraBean();
						System.out.println("oNivel " + oNivel.getNombreCorto());
						lenguaEstructuraBean.setNivel(oNivel);
						lstLenguaEstructuraBeanNivel.add(lenguaEstructuraBean);
					} 
					System.out.println("lenguaEstructuraBean cantidad " + lstLenguaEstructuraBeanNivel.size());
				//}
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mavLocal = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mavLocal.addObject("msgErrorLogin","Su sesión no es valida, por favor inicie sesión nuevamente");
			return mavLocal;
		}

		mav.addObject("lenguaForm", lenguaForm);
		mav.addObject("lstLenguaNivelBean", lstLenguaNivelBean);
		mav.addObject("lstUnidadBean", lstUnidadBean);
		mav.addObject("lstLecciones", lstLecciones);
		mav.addObject("lstNivel", lstLenguaEstructuraBeanNivel);
	//	mav.addObject("idUsuario",usuarioBean.getCodigo());	
		this.cargarCombos(mav);	 
		return mav;
	}
	
/****
	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {

		System.out.println("modificar codigo: " + codigo);
		List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = new ArrayList<LenguaEstructuraBean>() ;
		LenguaEstructuraBean lenguaEstructuraBean  ;
		LenguaBean prmLenguaBean = new LenguaBean();
		prmLenguaBean.setCodigo(codigo);
		cargarComboLeccion();
		System.out.println("modificar lenguaBean: " + lenguaBean);
		ModelAndView mav = new ModelAndView("general/lengua/registro-lengua", "command", lenguaForm);
		try {
			lenguaBean = this.getLenguaService().getBuscarPorObjecto(prmLenguaBean); 
			lstLenguaNivelBean = lenguaNivelService.listarPorCodigoLengua(prmLenguaBean);
				
			 
			lenguaForm.setLenguaBean(lenguaBean);
			tmpUrlImagen = lenguaBean.getImagenNombre();
			
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		 
			try { 
				lstUnidadBean = unidadService.listarPorCodigoLengua(prmLenguaBean);
				lstLenguaEstructuraBeanNivel = lenguaEstructuraService
						.listarNiveles(lenguaBean);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}
			/*	if (lstLenguaEstructuraBeanNivel != null && lstLenguaEstructuraBeanNivel.size() >0) {
				
				System.out.println("lstLenguaEstructuraBeanNivel"+lstLenguaEstructuraBeanNivel.size());
			}else{*/
			/*	lstLenguaEstructuraBeanNivel = new ArrayList<LenguaEstructuraBean>();
				System.out.println("lstLenguaEstructuraBeanNivel ES NULL" ); 
				for (MaestraBean oNivel :lstNivel ) {
					lenguaEstructuraBean = new LenguaEstructuraBean();
					System.out.println("oNivel " + oNivel.getNombreCorto());
					lenguaEstructuraBean.setNivel(oNivel);
					lstLenguaEstructuraBeanNivel.add(lenguaEstructuraBean);
				} 
				System.out.println("lenguaEstructuraBean cantidad " + lstLenguaEstructuraBeanNivel.size());
			//}

		mav.addObject("lenguaForm", lenguaForm);
		mav.addObject("lstLenguaNivelBean", lstLenguaNivelBean);
		mav.addObject("lstUnidadBean", lstUnidadBean);
		mav.addObject("lstLecciones", lstLecciones);
		mav.addObject("lstNivel", lstLenguaEstructuraBeanNivel);
	//	mav.addObject("idUsuario",usuarioBean.getCodigo());	
		this.cargarCombos(mav);	 
		return mav;
	}*/
	
	
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	@ResponseBody
	public void eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		lenguaBean= new LenguaBean();
		lenguaBean.setCodigo(codigo);
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
				sw =  (this.getLenguaService().eliminar(lenguaBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		lenguaBean.setCodigo(0);
		//this.setValoresPredeterminados(lenguaBean);
	//	ModelAndView mav = this.getLista(lenguaBean);
		//mav.addObject("swMensaje",sw?"1":"0");
		//return mav;		
	}
	
	
	@RequestMapping(value ="/eliminarEstructura", method = RequestMethod.GET)
	public ModelAndView eliminarEstructura(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		lenguaEstructuraBean= new LenguaEstructuraBean();
		lenguaEstructuraBean.getLenguaBean().setCodigo(codigo);
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
				sw =  (lenguaEstructuraService.eliminar(lenguaEstructuraBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		lenguaBean.setCodigo(0);
		this.setValoresPredeterminados(lenguaBean);
		ModelAndView mav = this.getLista(lenguaBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	} 
	
	@RequestMapping(value = "/grabarLengua", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView doGrabar(@ModelAttribute("lenguaForm") LenguaForm lenguaForm,  
						 @RequestParam("lenguaBean.file") MultipartFile[] files,
						 HttpServletRequest request
						 ) { 
		System.out.println("lenguaBean Grabar"+lenguaForm);
		lenguaForm.getLenguaBean().setNombre(VO.convertirCaracteresEsp(lenguaForm.getLenguaBean().getNombre()));
		lenguaForm.getLenguaBean().setDescripcion(VO.convertirCaracteresEsp(lenguaForm.getLenguaBean().getDescripcion()));
		this.setLenguaBean(lenguaForm.getLenguaBean());
		System.out.println("lenguaBean Grabar"+lenguaForm.getLenguaBean().getCodigo());
		boolean sw = true;
		boolean swNuevaUrlImagen = false; 
		//lenguaBean.setNombre(VO.convertirCaracteresEsp(lenguaBean.getNombre()));
		//lenguaBean.setDescripcion(VO.convertirCaracteresEsp(lenguaBean.getDescripcion()));
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("LenguaController/grabarLengua");
				//habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	
		        	if(lenguaBean.getNombre()!=null&&lenguaBean.getNombre()!="") {
		        		if(files != null && files.length != 0) {
		        			String[] imagen2 = files[0].getOriginalFilename().toString().split("\\.");
		        			String extencion=imagen2[imagen2.length-1].toLowerCase();
		        			if(!extencion.equals("jpg") 
		        					&& !extencion.equals("jpeg")
		        					&& !extencion.equals("png")) {
		        				ModelAndView mav = new ModelAndView("general/lengua/registro-lengua", "command",lenguaForm);
		        				mav.addObject("swMensaje","2");
			        			return mav; 
		        			}
		        			//------
		        			byte[] bytes_file = files[0].getBytes();
		        			String rootPath = "C:/ruta/";
		        			File dir = new File(rootPath + File.separator + "tmpFiles");
		        			if (!dir.exists())
		        				dir.mkdirs();

		        			// Create the file on server
		        			File serverFile = new File(dir.getAbsolutePath()
		        					+ File.separator + files[0].getOriginalFilename());
		        			BufferedOutputStream stream = new BufferedOutputStream(
		        					new FileOutputStream(serverFile));
		        			stream.write(bytes_file);
		        			stream.close();
		        			String ruta=String.valueOf(serverFile);
		        			if(!FileValidator.validFileHeadImagen(ruta)) {
		        				if(serverFile.delete()) {
		        					System.out.println("El fichero ha sido borrado satisfactoriamente");
		        				}else {
		        					System.out.println("El fichero no puede ser borrado");
		        				}
		        				ModelAndView mav = new ModelAndView("general/lengua/registro-lengua", "command",lenguaForm);
		        				mav.addObject("swMensaje","2");
			        			return mav; 
		        			}else {
		        				if(serverFile.delete()) {
		        					System.out.println("El fichero ha sido borrado satisfactoriamente");
		        				}else {
		        					System.out.println("El fichero no puede ser borrado");
		        				}
		        			}
		        			
		        			//------
		        			
		        			
		        			
		        			
		        		}else {
		        			ModelAndView mav = new ModelAndView("general/lengua/registro-lengua", "command",lenguaForm);
	        				mav.addObject("swMensaje","2");
		        			return mav; 
		        		}
		        		
		        		if (files.length>0) {
		        			swNuevaUrlImagen = (files[0]!=null) && (files[0].getOriginalFilename()!=null ) && (files[0].getOriginalFilename().trim().length()>0 );		
		        		}
		        		
		        		if (swNuevaUrlImagen) {
		        			lenguaBean.setFileImagen(files[0]);
		        			if (files[0].getOriginalFilename()!=null) {
		        				lenguaBean.setImagenNombre(files[0].getOriginalFilename());
		        			}	    					
		        		}else {				
		        			lenguaBean.setImagenNombre(tmpUrlImagen);
		        		} 
		        		
		        		if (this.getLenguaService().existe(lenguaBean)) {
		        			ModelAndView mav = new ModelAndView("general/lengua/registro-lengua", "command",lenguaForm);
		        			mav.addObject("swMensaje","3");
		        			mav.addObject("lstSituacion",lstSituacion); 
		        			return mav; 
		        		}else{
		        			if (lenguaBean.getCodigo()==0) {
		        				System.out.println("insertar "+lenguaBean);
		        				this.setAuditoria(lenguaBean, request, true);
		        				sw =  (this.getLenguaService().insertar(lenguaBean)); 
		        			} else {
		        				System.out.println("actualizar "+lenguaBean);
		        				this.setAuditoria(lenguaBean, request, false);
		        				sw = (this.getLenguaService().actualizar(lenguaBean));
		        			}	
		        		}    	
		        		
		        	}
		        	
		        }
			} catch (Exception e) { 
				e.printStackTrace();
			}
	
			if (sw) {
				cargarComboLeccion();
				
				if (swNuevaUrlImagen) {
					super.cargarArchivo(this.getRootPath(), lenguaBean.getImagenNombre(), lenguaBean.getFileImagen());    			    	
					tmpUrlImagen = lenguaBean.getImagenNombre();
				} 
				ModelAndView mav = new ModelAndView("general/lengua/registro-lengua", "command",lenguaForm);
				mav.addObject("swMensaje","1"); 
				List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = new ArrayList<LenguaEstructuraBean>() ; 
		 
				for (MaestraBean oNivel :lstNivel ) {
					lenguaEstructuraBean = new LenguaEstructuraBean();
					System.out.println("oNivel " + oNivel.getNombreCorto());
					lenguaEstructuraBean.setNivel(oNivel);
					lstLenguaEstructuraBeanNivel.add(lenguaEstructuraBean);
				}
	  			mav.addObject("lstNivel", lstLenguaEstructuraBeanNivel);  
				cargarCombos(mav);
				mav.addObject("lstLecciones", lstLecciones);
				mav.addObject("lenguaForm", lenguaForm);
				mav.addObject("lstLenguaNivelBean", lstLenguaNivelBean);
				mav.addObject("lstUnidadBean", lstUnidadBean);
				mav.addObject("lstLecciones", lstLecciones); 
				return mav; 
			} else {
				ModelAndView mav = new ModelAndView("general/lengua/registro-lengua", "command",lenguaForm);
				List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = new ArrayList<LenguaEstructuraBean>() ; 
				 
				for (MaestraBean oNivel :lstNivel ) {
					lenguaEstructuraBean = new LenguaEstructuraBean();
					System.out.println("oNivel " + oNivel.getNombreCorto());
					lenguaEstructuraBean.setNivel(oNivel);
					lstLenguaEstructuraBeanNivel.add(lenguaEstructuraBean);
				}
	  			mav.addObject("lstNivel", lstLenguaEstructuraBeanNivel);   
				mav.addObject("swMensaje", "0");
				cargarCombos(mav);
				mav.addObject("lstUnidadBean", lstUnidadBean);
				mav.addObject("lstLecciones", lstLecciones);  
			    return mav;
			} 
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesión no es valida, por favor inicie sesión nuevamente");
			return mav;
		}
	}
	
	private ModelAndView getLista(LenguaBean lenguaBean) {
		
		List<LenguaBean> lstLenguaBean =new ArrayList<LenguaBean>(); 
		try {
			lstLenguaBean = (List<LenguaBean>) this.getLenguaService().getBuscarPorFiltros(lenguaBean);
			System.out.println("lstLenguaBean "+lstLenguaBean.size());
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("general/lengua/listado-lengua", "command",lenguaBean);
		System.out.println("lstLenguaBean "+lstLenguaBean);
		mav.addObject("lstLenguaBean", lstLenguaBean);
		this.cargarCombos(mav);
		return mav;
	}
	/*
	@RequestMapping(value = "/cargarNiveles", method = RequestMethod.GET)
	public @ResponseBody List<MaestraBean> cargarNiveles(
			@RequestParam("codigo") Integer codigo) throws Exception {
		System.out.println("cargarNiveles " + lenguaBean.getCodigo());
		List<MaestraBean> lista_response = new ArrayList<MaestraBean>();
		if (codigo > 0) {
			LenguaBean filtro = new LenguaBean();
			filtro.setCodigo(codigo);
			List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = lenguaEstructuraService
					.listarNiveles(lenguaBean);

			if (!VO.isEmptyList(lstLenguaEstructuraBeanNivel)) {
				for (LenguaEstructuraBean objLenEstNivel : lstLenguaEstructuraBeanNivel) {
					if (!VO.isEmptyList(lstNivel)) {
						for (MaestraBean objMaestroNivel : lstNivel) {
							if (objMaestroNivel.getCodigoRegistro() == objLenEstNivel
									.getNivel().getCodigoRegistro()) {
								lista_response.add(objMaestroNivel);
								break;
							}
						}
					}
				}
			}
		}
		return lista_response;
	}
*/
	@RequestMapping(value = "/cargarSubNiveles", method = RequestMethod.GET)
	public @ResponseBody List<LenguaEstructuraBean> cargarSubNiveles(
			@RequestParam("codigo") Integer codlengua,
			@RequestParam("codnivel") Integer codnivel) throws Exception {
		List<LenguaEstructuraBean> lstLenguaEstructuraBeanSubNivel = new ArrayList<LenguaEstructuraBean>();
		lenguaBean.setCodigo(codlengua);
		LenguaEstructuraBean prmLenguaEstructuraBean = new LenguaEstructuraBean();
		prmLenguaEstructuraBean.getNivel().setCodigoRegistro(codnivel); 
		prmLenguaEstructuraBean.setLenguaBean(lenguaBean);
		System.out.println("cargarSubNiveles codlengua " + codlengua);
		System.out.println("cargarSubNiveles codnivel " + codnivel); 
		if (!codlengua.equals("0") && !codnivel.equals("0")) { 
			lstLenguaEstructuraBeanSubNivel = 
						lenguaEstructuraService.listarSubNiveles(prmLenguaEstructuraBean);
 
		}
		return lstLenguaEstructuraBeanSubNivel;
	}
	
	@RequestMapping(value = "/eliminarLenguaEstructura", method = RequestMethod.GET) 
	@ResponseBody
	public String eliminarLenguaEstructura(@RequestParam("codigo") Integer codigo,
			 HttpServletRequest request) {
		System.out.println("eliminarUnidad  " + codigo);
		LenguaEstructuraBean lenguaEstructuraBean = new LenguaEstructuraBean();
		lenguaEstructuraBean.setCodigo(codigo);
		System.out.println("p_hostmod: "+lenguaEstructuraBean.getAudHostIP());
		System.out.println("p_codusumod: "+lenguaEstructuraBean.getAudCodigoUsuario());
		
		String mensage=  "";  	
		try { 
				this.setAuditoria(lenguaEstructuraBean, request, false);
				Boolean a =  lenguaEstructuraService.eliminar(lenguaEstructuraBean);
				System.out.println("a: "+a);
			mensage ="1";
		} catch (ServiceException e1) { 
			mensage ="2";
			e1.printStackTrace();
		} 
		  
		return mensage;
		 
	}
	
	@RequestMapping(value = "/modificarLenguaEstructura", method = RequestMethod.GET)
	@ResponseBody
	public  LenguaEstructuraBean modificarLenguaEstructura( @RequestParam("codigo") Integer codigo) throws Exception {
		
		System.out.println("modificarLenguaEstructura codigo " + codigo);
		LenguaEstructuraBean lenguaEstructuraBean = null;
		LenguaEstructuraBean prmLenguaEstructuraBean = new LenguaEstructuraBean();
		prmLenguaEstructuraBean.setCodigo(codigo); 
		if (codigo > 0) {
			lenguaEstructuraBean =  lenguaEstructuraService.getBuscarPorObjecto(prmLenguaEstructuraBean);
			if (lenguaEstructuraBean != null) {
				System.out.println("lenguaEstructuraBean is not null" + lenguaEstructuraBean);
				
			}else{
				System.out.println("lenguaEstructuraBean is  null");
			}
		}
		return lenguaEstructuraBean;
	}
	
	private void cargarCombos(ModelAndView mav){
		 
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionLengua",0);
				lstUnidad = maestra2Service.listarPorCodigoTabla("unidad",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}	 

		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstUnidad",lstUnidad); 
	
	}
	
	private   String renombrarImagen(MultipartFile files[],Long codUnidad){
		boolean swNuevaUrlImagen = false;
		String nombreImagen = null;
		if (files!=null) {
		if (files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				swNuevaUrlImagen = (files[i]!=null) && (files[i].getOriginalFilename()!=null ) && (files[i].getOriginalFilename().trim().length()>0 );
				
				MultipartFile fileImagen = null;
				if (swNuevaUrlImagen) {
					fileImagen = files[i];
			    	if (files[i].getOriginalFilename()!=null) {
			    		nombreImagen = files[i].getOriginalFilename();
			    	}					
				}
				System.out.println("busca ::"+ nombreImagen.indexOf("_"));
				
				if (nombreImagen.indexOf("_")== -1) {
					
					nombreImagen =   String.valueOf(codUnidad)+"_"+VO.convertirCaracteresEsp(nombreImagen);
					
				}else{
//					
					nombreImagen=	String.valueOf(codUnidad)+"_"+nombreImagen.substring(nombreImagen.indexOf("_") + 1, nombreImagen.length());
//					
				}
							
				System.out.println("nombreImagen"+nombreImagen);
			}
		}else{
			System.out.println("files menor a 0");
		}
	}
		
		return nombreImagen;
	}

	private   String renombrarImagen2(MultipartFile files[],Long codUnidad){
		boolean swNuevaUrlImagen = false;
		String nombreImagen = null;
		if (files!=null) {
		if (files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				swNuevaUrlImagen = (files[i]!=null) && (files[i].getOriginalFilename()!=null ) && (files[i].getOriginalFilename().trim().length()>0 );
				
				MultipartFile fileImagen = null;
				if (swNuevaUrlImagen) {
					fileImagen = files[i];
			    	if (files[i].getOriginalFilename()!=null) {
			    		nombreImagen = files[i].getOriginalFilename();
			    	}					
				}
				System.out.println("busca ::"+ nombreImagen.indexOf("_"));
				
				if (nombreImagen.indexOf("_")== -1) {
					
					nombreImagen =   String.valueOf(codUnidad)+"_"+VO.convertirCaracteresEsp(nombreImagen);
					
				}else{
//					
					nombreImagen=	String.valueOf(codUnidad)+"_"+nombreImagen;
//					
				}
							
				System.out.println("nombreImagen"+nombreImagen);
			}
		}else{
			System.out.println("files menor a 0");
		}
	}
		
		return nombreImagen;
	}
	/**Mantenimiento LenguaUnidad **/
	@RequestMapping(value = "/grabarLenguaUnidad", method = RequestMethod.POST) 
	@ResponseBody
	public Long grabarLenguaUnidad(@RequestParam("codLengua") Integer codLengua,
									   @RequestParam("nombreLenguaUnidad") String nombreLenguaUnidad,
									   @RequestParam("nomlenun") String nomlenun,
									   @RequestParam("nomlenunb") String nomlenunb,
									   @RequestParam("lenguaUnidad") Integer lenguaUnidad,	
//									   @RequestParam("files") MultipartFile[] files,
//									   @RequestParam("fileBloq") MultipartFile[] fileBloq,
									   @RequestParam (value="files",required=false) MultipartFile[] files,
									   @RequestParam(value="fileBloq",required=false) MultipartFile[] fileBloq,
									   @RequestParam("idLenguaUnidad") Integer idLenguaUnidad,
							   HttpServletRequest request) {
		System.out.println("grabarUnidad");
		 
		
		LenguaUnidadBean lenguaUnidadBean = new LenguaUnidadBean();
		lenguaUnidadBean.setCodigo(idLenguaUnidad);
		lenguaUnidadBean.setNombreUnidad(VO.convertirCaracteresEsp(nombreLenguaUnidad));
		lenguaUnidadBean.getLenguaBean().setCodigo(codLengua);
		lenguaUnidadBean.getUnidad().setCodigoRegistro(lenguaUnidad);
		long  data = 0;
		boolean swNuevaUrlImagen = false;
		boolean swNuevaUrlImagenBloq = false;
		boolean validatePeticion = false;
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("LenguaController/grabarLenguaUnidad");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	validatePeticion = true;
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//-------- validacion por cabeceras
		
		try {
			
			
			byte[] bytes_file = files[0].getBytes();
			String rootPath = "C:/ruta/";
			File dir = new File(rootPath + File.separator + "tmpFiles");
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator + files[0].getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes_file);
			stream.close();
			String ruta=String.valueOf(serverFile);
			if(!FileValidator.validFileHeadImagen(ruta)) {
				if(serverFile.delete()) {
					System.out.println("El fichero ha sido borrado satisfactoriamente");
				}else {
					System.out.println("El fichero no puede ser borrado");
				}
				data=-1;
				return data;
			}else {
				if(serverFile.delete()) {
					System.out.println("El fichero ha sido borrado satisfactoriamente");
				}else {
					System.out.println("El fichero no puede ser borrado");
				}
			}
			//----
			byte[] bytes_file2 = fileBloq[0].getBytes();
			
			File dir2 = new File(rootPath + File.separator + "tmpFiles");
			if (!dir2.exists())
				dir2.mkdirs();

			File serverFile2 = new File(dir2.getAbsolutePath()
					+ File.separator + fileBloq[0].getOriginalFilename());
			BufferedOutputStream stream2 = new BufferedOutputStream(
					new FileOutputStream(serverFile2));
			stream2.write(bytes_file2);
			stream2.close();
			String ruta2=String.valueOf(serverFile2);
			if(!FileValidator.validFileHeadImagen(ruta2)) {
				if(serverFile2.delete()) {
					System.out.println("El fichero ha sido borrado satisfactoriamente");
				}else {
					System.out.println("El fichero no puede ser borrado");
				}
				data=-1;
				return data;
			}else {
				if(serverFile2.delete()) {
					System.out.println("El fichero ha sido borrado satisfactoriamente");
				}else {
					System.out.println("El fichero no puede ser borrado");
				}
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
		
		
		
		//-----------------------------
		
		
		
		
		
		if(files != null && files.length != 0 && fileBloq != null && fileBloq.length != 0) {
			String[] imagen1 = files[0].getOriginalFilename().toString().split("\\.");
			String[] imagen2 = fileBloq[0].getOriginalFilename().toString().split("\\.");
			String extencion1=imagen1[imagen1.length-1].toLowerCase();
			String extencion2=imagen2[imagen2.length-1].toLowerCase();
			if(!extencion1.equals("jpg") && !extencion1.equals("jpeg")
					&& !extencion1.equals("png") && !extencion2.equals("jpg") 
					&& !extencion2.equals("jpeg")
					&& !extencion2.equals("png")) {
				data = -1;
				return data;
			}
			System.out.println(files[0].getOriginalFilename().toString());
			
		}else {
			data = -1;
			return data;
		}
		 
		if ( files != null) {
			if(files.length > 0){
			swNuevaUrlImagen = (files[0] != null) && (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "")
					&& (files[0].getOriginalFilename().trim().length() > 0);
			System.out.println(swNuevaUrlImagen);	
			System.out.println(files[0].getOriginalFilename());
			}
		}
		if (swNuevaUrlImagen  ) 
		{

			lenguaUnidadBean.setFileImagen(files[0]);
			if (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "") 
			{
				lenguaUnidadBean.setNombreImagen(VO.convertirCaracteresEsp(files[0].getOriginalFilename()));
				System.out.println(lenguaUnidadBean.getNombreImagen());
			}
		}
		
		
		if (fileBloq != null) {
			if(fileBloq.length > 0){
			swNuevaUrlImagenBloq = (fileBloq[0] != null) && (fileBloq[0].getOriginalFilename() != null && fileBloq[0].getOriginalFilename() != "")
					&& (fileBloq[0].getOriginalFilename().trim().length() > 0);
			System.out.println(swNuevaUrlImagenBloq);	
			System.out.println(fileBloq[0].getOriginalFilename());
		}
		}
		if (swNuevaUrlImagenBloq ) 
		{

			lenguaUnidadBean.setFileImagenBloq(fileBloq[0]);
			if (fileBloq[0].getOriginalFilename() != null && fileBloq[0].getOriginalFilename() != "") 
			{
				lenguaUnidadBean.setNombreImagenBloqueado(VO.convertirCaracteresEsp(fileBloq[0].getOriginalFilename()));
				System.out.println(lenguaUnidadBean.getNombreImagenBloqueado());
			}
		}
	 
			try {
					if(validatePeticion) {
						if(lenguaUnidadBean.getNombreUnidad()!=null&&lenguaUnidadBean.getNombreUnidad()!="") {
							if (lenguaUnidadBean.getCodigo() == 0) {
								
								System.out.println("insertar lenguaUnidadBean: " + lenguaUnidadBean);
								this.setAuditoria(lenguaUnidadBean, request, true);
								this.getLenguaUnidadService().insertar(lenguaUnidadBean);
								data = lenguaUnidadBean.getCodigo();
								if (swNuevaUrlImagen) {
									super.cargarArchivo(this.getRootPathUnidad(), renombrarImagen(files, lenguaUnidadBean.getCodigo()), lenguaUnidadBean.getFileImagen());
									lenguaUnidadBean.setNombreImagen(renombrarImagen(files, lenguaUnidadBean.getCodigo()));
									this.getLenguaUnidadService().actualizarimgxcod(lenguaUnidadBean);
								}
								if (swNuevaUrlImagenBloq) {
									super.cargarArchivo(this.getRootPathUnidad(), renombrarImagen(fileBloq, lenguaUnidadBean.getCodigo()), lenguaUnidadBean.getFileImagenBloq());
									lenguaUnidadBean.setNombreImagenBloqueado(renombrarImagen(files, lenguaUnidadBean.getCodigo()));
									this.getLenguaUnidadService().actualizarimgxcod(lenguaUnidadBean);
								}						
								
							}else{
								
								System.out.println("modificar lenguaUnidadBean: " + lenguaUnidadBean);
								this.setAuditoria(lenguaUnidadBean, request, false);
								if(!this.getLenguaUnidadService().existe(lenguaUnidadBean)){
									if (!(swNuevaUrlImagen && files != null)) {
										lenguaUnidadBean.setNombreImagen(nomlenun);
									}
									if (!(swNuevaUrlImagenBloq && fileBloq != null)) {
										lenguaUnidadBean.setNombreImagenBloqueado(nomlenunb);
									}
									this.getLenguaUnidadService().actualizar(lenguaUnidadBean);
									data = lenguaUnidadBean.getCodigo();
									if (swNuevaUrlImagen && files != null) {
										super.cargarArchivo(this.getRootPathUnidad(), renombrarImagen(files, lenguaUnidadBean.getCodigo()), lenguaUnidadBean.getFileImagen());
										lenguaUnidadBean.setNombreImagen(renombrarImagen(files, lenguaUnidadBean.getCodigo()));
										this.getLenguaUnidadService().actualizarimgxcod(lenguaUnidadBean);
									}
									
									if (swNuevaUrlImagenBloq && fileBloq != null) {
										super.cargarArchivo(this.getRootPathUnidad(), renombrarImagen(fileBloq, lenguaUnidadBean.getCodigo()), lenguaUnidadBean.getFileImagenBloq());
										lenguaUnidadBean.setNombreImagenBloqueado(renombrarImagen(files, lenguaUnidadBean.getCodigo()));
										this.getLenguaUnidadService().actualizarimgxcod(lenguaUnidadBean);
									}	
								}
								
								
							} 
							
						}
						
					}
					

				} catch (ServiceException e) { 
					e.printStackTrace();
				}
		
		
		 System.out.println("data " + data);
		return data;
		 
	}
	
	@RequestMapping(value = "/grabarLenguaUnidadImg", method = RequestMethod.POST) 
	@ResponseBody
	public Long grabarLenguaUnidadImg(@RequestParam("codLengua") Integer codLengua,
									   @RequestParam("nombreLenguaUnidad") String nombreLenguaUnidad,
									   @RequestParam("nomlenun") String nomlenun,
									   @RequestParam("nomlenunb") String nomlenunb,
									   @RequestParam("lenguaUnidad") Integer lenguaUnidad,	 
									   @RequestParam (value="files",required=false) MultipartFile[] files, 
									   @RequestParam("idLenguaUnidad") Integer idLenguaUnidad,
							   HttpServletRequest request) {
		System.out.println("grabarUnidad");
		 
		
		LenguaUnidadBean lenguaUnidadBean = new LenguaUnidadBean();
		lenguaUnidadBean.setCodigo(idLenguaUnidad);
		lenguaUnidadBean.setNombreUnidad(VO.convertirCaracteresEsp(nombreLenguaUnidad));
		lenguaUnidadBean.getLenguaBean().setCodigo(codLengua);
		lenguaUnidadBean.getUnidad().setCodigoRegistro(lenguaUnidad);
		long  data = 0;
		boolean swNuevaUrlImagen = false; 
		boolean validatePeticion = false;
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("LenguaController/grabarLenguaUnidadImg");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	validatePeticion = true;
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(files != null && files.length != 0) {
			String[] imagen1 = files[0].getOriginalFilename().toString().split("\\.");
			if(!imagen1[imagen1.length-1].toLowerCase().equals("jpg") && !imagen1[imagen1.length-1].toLowerCase().equals("jpeg")
					&& !imagen1[imagen1.length-1].toLowerCase().equals("png")) {
				data = -1;
				return data;
			}
		}else {
			data = -1;
			return data;
		}
		
		if ( files != null) {
			if(files.length > 0){
			swNuevaUrlImagen = (files[0] != null) && (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "")
					&& (files[0].getOriginalFilename().trim().length() > 0);
			System.out.println(swNuevaUrlImagen);	
			System.out.println(files[0].getOriginalFilename());
			}
		}
		if (swNuevaUrlImagen  ) 
		{

			lenguaUnidadBean.setFileImagen(files[0]);
			if (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "") 
			{
				lenguaUnidadBean.setNombreImagen(VO.convertirCaracteresEsp(files[0].getOriginalFilename()));
				System.out.println(lenguaUnidadBean.getNombreImagen());
			}
		} 
			try { 
				if(validatePeticion) {
					if(lenguaUnidadBean.getNombreUnidad()!=null&&lenguaUnidadBean.getNombreUnidad()!="") {
						System.out.println("modificar lenguaUnidadBean: " + lenguaUnidadBean);
						this.setAuditoria(lenguaUnidadBean, request, false);
						if(!this.getLenguaUnidadService().existe(lenguaUnidadBean)){							 
							lenguaUnidadBean.setNombreImagenBloqueado("");
							this.getLenguaUnidadService().actualizar(lenguaUnidadBean);
							data = lenguaUnidadBean.getCodigo();
							if (swNuevaUrlImagen && files != null) {
								super.cargarArchivo(this.getRootPathUnidad(), renombrarImagen(files, lenguaUnidadBean.getCodigo()), lenguaUnidadBean.getFileImagen());
								lenguaUnidadBean.setNombreImagen(renombrarImagen(files, lenguaUnidadBean.getCodigo()));
								this.getLenguaUnidadService().actualizarimgxcod(lenguaUnidadBean);
							}
							
						}
						
					}
				}
				} catch (ServiceException e) { 
					e.printStackTrace();
				}
		
		
		 System.out.println("data " + data);
		return data;
		 
	}
	
	@RequestMapping(value = "/grabarLenguaUnidadImgb", method = RequestMethod.POST) 
	@ResponseBody
	public Long grabarLenguaUnidadImgb(@RequestParam("codLengua") Integer codLengua,
									   @RequestParam("nombreLenguaUnidad") String nombreLenguaUnidad,
									   @RequestParam("nomlenun") String nomlenun,
									   @RequestParam("nomlenunb") String nomlenunb,
									   @RequestParam("lenguaUnidad") Integer lenguaUnidad, 
									   @RequestParam(value="fileBloq",required=false) MultipartFile[] fileBloq,
									   @RequestParam("idLenguaUnidad") Integer idLenguaUnidad,
							   HttpServletRequest request) {
		System.out.println("grabarUnidad");
		 
		
		LenguaUnidadBean lenguaUnidadBean = new LenguaUnidadBean();
		lenguaUnidadBean.setCodigo(idLenguaUnidad);
		lenguaUnidadBean.setNombreUnidad(VO.convertirCaracteresEsp(nombreLenguaUnidad));
		lenguaUnidadBean.getLenguaBean().setCodigo(codLengua);
		lenguaUnidadBean.getUnidad().setCodigoRegistro(lenguaUnidad);
		long  data = 0; 
		boolean swNuevaUrlImagenBloq = false; 
		
		boolean validatePeticion = false;
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("LenguaController/grabarLenguaUnidadImgb");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	validatePeticion = true;
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(fileBloq != null && fileBloq.length != 0) {
			String[] imagen2 = fileBloq[0].getOriginalFilename().toString().split("\\.");
			if(!imagen2[imagen2.length-1].equals("jpg") 
					&& !imagen2[imagen2.length-1].equals("jpeg")
					&& !imagen2[imagen2.length-1].equals("png")) {
				data = -1;
				return data;
			}
		}else {
			data = -1;
			return data;
		}
		
		if (fileBloq != null) {
			if(fileBloq.length > 0){
			swNuevaUrlImagenBloq = (fileBloq[0] != null) && (fileBloq[0].getOriginalFilename() != null && fileBloq[0].getOriginalFilename() != "")
					&& (fileBloq[0].getOriginalFilename().trim().length() > 0);
			System.out.println(swNuevaUrlImagenBloq);	
			System.out.println(fileBloq[0].getOriginalFilename());
		}
		}
		if (swNuevaUrlImagenBloq ) 
		{

			lenguaUnidadBean.setFileImagenBloq(fileBloq[0]);
			if (fileBloq[0].getOriginalFilename() != null && fileBloq[0].getOriginalFilename() != "") 
			{
				lenguaUnidadBean.setNombreImagenBloqueado(VO.convertirCaracteresEsp(fileBloq[0].getOriginalFilename()));
				System.out.println(lenguaUnidadBean.getNombreImagenBloqueado());
			}
		}
	 
			try { 
				if(validatePeticion) {
					if(lenguaUnidadBean.getNombreUnidad()!=null&&lenguaUnidadBean.getNombreUnidad()!="") {
						
						System.out.println("modificar lenguaUnidadBean: " + lenguaUnidadBean);
						this.setAuditoria(lenguaUnidadBean, request, false);
						if(!this.getLenguaUnidadService().existe(lenguaUnidadBean)){
							
							lenguaUnidadBean.setNombreImagen("");
							
							
							this.getLenguaUnidadService().actualizar(lenguaUnidadBean);
							data = lenguaUnidadBean.getCodigo();
							
							
							if (swNuevaUrlImagenBloq && fileBloq != null) {
								super.cargarArchivo(this.getRootPathUnidad(), renombrarImagen(fileBloq, lenguaUnidadBean.getCodigo()), lenguaUnidadBean.getFileImagenBloq());
								lenguaUnidadBean.setNombreImagenBloqueado(renombrarImagen(fileBloq, lenguaUnidadBean.getCodigo()));
								this.getLenguaUnidadService().actualizarimgxcod(lenguaUnidadBean);
							}	
						}
					}
				}
												
 
				 

				} catch (ServiceException e) { 
					e.printStackTrace();
				}
		
		
		 System.out.println("data " + data);
		return data;
		 
	}
	
	@RequestMapping(value = "/grabarLenguaUnidadSinImg", method = RequestMethod.POST) 
	@ResponseBody
	public Long grabarLenguaUnidadSinImg(@RequestParam("codLengua") Integer codLengua,
									   @RequestParam("nombreLenguaUnidad") String nombreLenguaUnidad,
									   @RequestParam("nomlenun") String nomlenun,
									   @RequestParam("nomlenunb") String nomlenunb,
									   @RequestParam("lenguaUnidad") Integer lenguaUnidad,	 
									   @RequestParam("idLenguaUnidad") Integer idLenguaUnidad,
							   HttpServletRequest request) {
		System.out.println("grabarUnidad");
		LenguaUnidadBean lenguaUnidadBean = new LenguaUnidadBean();
		lenguaUnidadBean.setCodigo(idLenguaUnidad);
		lenguaUnidadBean.setNombreUnidad(VO.convertirCaracteresEsp(nombreLenguaUnidad));
		lenguaUnidadBean.getLenguaBean().setCodigo(codLengua);
		lenguaUnidadBean.getUnidad().setCodigoRegistro(lenguaUnidad);
		long  data = 0;
		boolean validatePeticion = false;
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("LenguaController/grabarLenguaUnidadSinImg");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	validatePeticion = true;
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			try {  
				if(validatePeticion) {
					if(lenguaUnidadBean.getNombreUnidad()!=null&&lenguaUnidadBean.getNombreUnidad()!="") {
					
						System.out.println("modificar lenguaUnidadBean: " + lenguaUnidadBean);
						this.setAuditoria(lenguaUnidadBean, request, false);
						if(!this.getLenguaUnidadService().existe(lenguaUnidadBean)){ 
							lenguaUnidadBean.setNombreImagen(""); 
							lenguaUnidadBean.setNombreImagenBloqueado("");
							
							this.getLenguaUnidadService().actualizar(lenguaUnidadBean);
							data = lenguaUnidadBean.getCodigo();							 
						} 	 
					}
				}
			} catch (ServiceException e) { 
				e.printStackTrace();
			}
		 System.out.println("data " + data);
		return data;
		 
	}
	
	@RequestMapping(value = "/listarLenguaUnidad", method = RequestMethod.POST)
	@ResponseBody
	public List<LenguaUnidadBean> listarLenguaUnidad(@RequestParam("codLengua") Integer codLengua)
			throws Exception {
		System.out.println("listarLenguaUnidad");
		LenguaUnidadBean oLenguaUnidadBean = new LenguaUnidadBean();
		oLenguaUnidadBean.getLenguaBean().setCodigo(codLengua);
		
		List<LenguaUnidadBean> lstLenguaUnidadBeans =new ArrayList<LenguaUnidadBean>(); 
		try {
							
				lstLenguaUnidadBeans = this.getLenguaUnidadService().getBuscarPorFiltros(oLenguaUnidadBean);
			if (lstLenguaUnidadBeans != null && lstLenguaUnidadBeans.size() > 0) {
				System.out.println("lstLenguaUnidadBeans actual :: "+lstLenguaUnidadBeans.size());				
			
			}else{
				System.out.println("lista vacia");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return lstLenguaUnidadBeans;
	}
	@RequestMapping(value = "/editarLenguaUnidad", method = RequestMethod.POST)
	@ResponseBody
	public LenguaUnidadBean editarLenguaUnidad(@RequestParam("codLenguaUnidad") Integer codLenguaUnidad)
			throws Exception {
		System.out.println("editarLenguaUnidad");
		LenguaUnidadBean oLenguaUnidadBean = new LenguaUnidadBean();
		oLenguaUnidadBean.setCodigo(codLenguaUnidad);
				 
		try {
							
			lenguaUnidadBean = this.getLenguaUnidadService().getBuscarPorObjecto(oLenguaUnidadBean);
			if (lenguaUnidadBean != null ) {
				System.out.println("lstLenguaUnidadBeans actual :: "+lenguaUnidadBean);				
			
			}else{
				System.out.println("lista vacia");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return lenguaUnidadBean;
	}
	
	@RequestMapping(value = "/eliminarLenguaUnidad", method = RequestMethod.POST)
	@ResponseBody
	public String eliminarLenguaUnidad(@RequestParam("codLenguaUnidad") Integer codLenguaUnidad)
			throws Exception {
		System.out.println("listarLenguaUnidad");
		String  data = "";
		LenguaUnidadBean oLenguaUnidadBean = new LenguaUnidadBean();
		oLenguaUnidadBean.setCodigo(codLenguaUnidad);
		
		
		try {
							
				if (oLenguaUnidadBean.getCodigo() != 0) {
					this.getLenguaUnidadService().eliminar(oLenguaUnidadBean);
					data = "1";
				}else{
					System.out.println("Error");
				}


		} catch (Exception e) {
			e.printStackTrace();
		} 
		return data;
	}
	/** Mantenimiento LenguaLeccion **/
	@RequestMapping(value = "/grabarLenguaLeccion", method = RequestMethod.POST) 
	@ResponseBody
	public Long grabarLenguaLeccion(@RequestParam("codLengua") Integer codLengua,
									   @RequestParam("nombreLenguaLeccion") String nombreLenguaLeccion,
									   @RequestParam("lenguaLeccion") Integer lenguaLeccion,									   
									   @RequestParam(value="file",required=false) MultipartFile[] file,
									   @RequestParam(value="files",required=false) MultipartFile[] files,
									   @RequestParam("idLenguaLeccion") Integer idLenguaLeccion,
									   HttpServletRequest request) {
		System.out.println("grabarLenguaLeccion");
		 
		
		LenguaLeccionBean lenguaLeccionBean = new LenguaLeccionBean();
		lenguaLeccionBean.setCodigo(idLenguaLeccion);
		lenguaLeccionBean.setNombreLeccion(VO.convertirCaracteresEsp(nombreLenguaLeccion));
		lenguaLeccionBean.getLenguaBean().setCodigo(codLengua);
		lenguaLeccionBean.getLeccion().setCodigoRegistro(lenguaLeccion);
		long  data = 0;
		boolean swNuevaUrlImagen = false;
		boolean swNuevaUrlImagenBloq = false;
		System.out.println("probando .....2");
		boolean validatePeticion = false;
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("LenguaController/grabarLenguaLeccion");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	validatePeticion = true;
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//-------- validacion por cabeceras
		
		try {
			
			
			byte[] bytes_file = file[0].getBytes();
			String rootPath = "C:/ruta/";
			File dir = new File(rootPath + File.separator + "tmpFiles");
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator + file[0].getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes_file);
			stream.close();
			String ruta=String.valueOf(serverFile);
			if(!FileValidator.validFileHeadImagen(ruta)) {
				if(serverFile.delete()) {
					System.out.println("El fichero ha sido borrado satisfactoriamente");
				}else {
					System.out.println("El fichero no puede ser borrado");
				}
				data=-1;
				return data;
			}else {
				if(serverFile.delete()) {
					System.out.println("El fichero ha sido borrado satisfactoriamente");
				}else {
					System.out.println("El fichero no puede ser borrado");
				}
			}
			//----
			byte[] bytes_file2 = files[0].getBytes();
			
			File dir2 = new File(rootPath + File.separator + "tmpFiles");
			if (!dir2.exists())
				dir2.mkdirs();

			File serverFile2 = new File(dir2.getAbsolutePath()
					+ File.separator + files[0].getOriginalFilename());
			BufferedOutputStream stream2 = new BufferedOutputStream(
					new FileOutputStream(serverFile2));
			stream2.write(bytes_file2);
			stream2.close();
			String ruta2=String.valueOf(serverFile2);
			if(!FileValidator.validFileHeadImagen(ruta2)) {
				if(serverFile2.delete()) {
					System.out.println("El fichero ha sido borrado satisfactoriamente");
				}else {
					System.out.println("El fichero no puede ser borrado");
				}
				data=-1;
				return data;
			}else {
				if(serverFile2.delete()) {
					System.out.println("El fichero ha sido borrado satisfactoriamente");
				}else {
					System.out.println("El fichero no puede ser borrado");
				}
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
			
		
		
		
		if(file != null && file.length != 0 && files != null && files.length != 0) {
			String[] imagen1 = file[0].getOriginalFilename().toString().split("\\.");
			String[] imagen2 = files[0].getOriginalFilename().toString().split("\\.");
			String ext01=imagen1[imagen1.length-1].toLowerCase();
			String ext02=imagen1[imagen2.length-1].toLowerCase();
			if(!ext01.equals("jpg") && !ext01.equals("jpeg")
					&& !ext01.equals("png") && !ext02.equals("jpg") 
					&& !ext02.equals("jpeg")
					&& !ext02.equals("png")) {
				data = -1;
				return data;
			}
		}else {
			data = -1;
			return data;
		}
		
		if (file != null  ) {
		if (file.length > 0) {
			swNuevaUrlImagen = (file[0] != null) && (file[0].getOriginalFilename() != null && file[0].getOriginalFilename() != "")
					&& (file[0].getOriginalFilename().trim().length() > 0);
			System.out.println(swNuevaUrlImagen);	
			System.out.println(file[0].getOriginalFilename());
			}	
		}
		if (swNuevaUrlImagen) 
		{

			lenguaLeccionBean.setFileImagen(file[0]);
			if (file[0].getOriginalFilename() != null && file[0].getOriginalFilename() != "") 
			{
				lenguaLeccionBean.setNombreImagen(VO.convertirCaracteresEsp(file[0].getOriginalFilename()));
				System.out.println(lenguaLeccionBean.getNombreImagen());
			}
		}
		
		if (files != null  ) {
		if (files.length > 0 && files != null) {
			swNuevaUrlImagenBloq = (files[0] != null) && (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "")
					&& (files[0].getOriginalFilename().trim().length() > 0);
			System.out.println(swNuevaUrlImagenBloq);	
			System.out.println(files[0].getOriginalFilename());
		}
	}
		if (swNuevaUrlImagenBloq) 
		{

			lenguaLeccionBean.setFileImagenBloq(files[0]);
			if (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "") 
			{
				lenguaLeccionBean.setNombreImagenBloq(VO.convertirCaracteresEsp(files[0].getOriginalFilename()));
				System.out.println(lenguaLeccionBean.getNombreImagenBloq());
			}
		}

	
			try {

				if(validatePeticion) {
					if(lenguaLeccionBean.getNombreLeccion()!=null&&lenguaLeccionBean.getNombreLeccion()!="") {
						if (lenguaLeccionBean.getCodigo() == 0) {
							
							System.out.println("insertar lenguaLeccionBean: " + lenguaLeccionBean);
							this.setAuditoria(lenguaLeccionBean, request, true);
							if(!this.getLenguaLeccionService().existe(lenguaLeccionBean)){
								this.getLenguaLeccionService().insertar(lenguaLeccionBean);
								data = lenguaLeccionBean.getCodigo();
								if (swNuevaUrlImagen) {
									super.cargarArchivo(this.getRootPathLeccion(), renombrarImagen(file, lenguaLeccionBean.getCodigo()), lenguaLeccionBean.getFileImagen());
									lenguaLeccionBean.setNombreImagen(renombrarImagen(file, lenguaLeccionBean.getCodigo()));
									this.getLenguaLeccionService().actualizarimgxcod(lenguaLeccionBean);
								}
								if (swNuevaUrlImagenBloq) {
									super.cargarArchivo(this.getRootPathLeccion(), renombrarImagen(files, lenguaLeccionBean.getCodigo()), lenguaLeccionBean.getFileImagenBloq());
									lenguaLeccionBean.setNombreImagenBloq(renombrarImagen(file, lenguaLeccionBean.getCodigo()));
									this.getLenguaLeccionService().actualizarimgxcod(lenguaLeccionBean);
								}
							}
																		 
						}else{
							
							System.out.println("modificar lenguaUnidadBean: " + lenguaLeccionBean);
							this.setAuditoria(lenguaLeccionBean, request, false);
							if(!this.getLenguaLeccionService().existe(lenguaLeccionBean)){
								
								this.getLenguaLeccionService().actualizar(lenguaLeccionBean);
								//this.getLenguaLeccionService().actualizar(lenguaLeccionBean);
								data = lenguaLeccionBean.getCodigo();
								if (swNuevaUrlImagen) {

									super.cargarArchivo(this.getRootPathLeccion(), renombrarImagen(files, lenguaLeccionBean.getCodigo()), lenguaLeccionBean.getFileImagen());
									lenguaLeccionBean.setNombreImagen(renombrarImagen(file, lenguaLeccionBean.getCodigo()));
									this.getLenguaLeccionService().actualizarimgxcod(lenguaLeccionBean);
								}	
								if (swNuevaUrlImagenBloq) {
									super.cargarArchivo(this.getRootPathLeccion(), renombrarImagen(files, lenguaLeccionBean.getCodigo()), lenguaLeccionBean.getFileImagenBloq());
									lenguaLeccionBean.setNombreImagenBloq(renombrarImagen(file, lenguaLeccionBean.getCodigo()));
									this.getLenguaLeccionService().actualizarimgxcod(lenguaLeccionBean);
								}							

									super.cargarArchivo(this.getRootPathLeccion(), renombrarImagen(file, lenguaLeccionBean.getCodigo()), lenguaLeccionBean.getFileImagen());
									lenguaLeccionBean.setNombreImagen(renombrarImagen(file, lenguaLeccionBean.getCodigo()));
									this.getLenguaLeccionService().actualizarimgxcod(lenguaLeccionBean);
								}
								if (swNuevaUrlImagenBloq) {
									super.cargarArchivo(this.getRootPathLeccion(), renombrarImagen(files, lenguaLeccionBean.getCodigo()), lenguaLeccionBean.getFileImagenBloq());
									lenguaLeccionBean.setNombreImagenBloq(renombrarImagen(file, lenguaLeccionBean.getCodigo()));
									this.getLenguaLeccionService().actualizarimgxcod(lenguaLeccionBean);
								}	
							}
							
					}
				}
					

										
				} catch (ServiceException e) { 
					e.printStackTrace();
				}

		return data;		 
	}
	
	@RequestMapping(value = "/grabarLenguaLeccionImg", method = RequestMethod.POST) 
	@ResponseBody
	public Long grabarLenguaLeccionImg(@RequestParam("codLengua") Integer codLengua,
									   @RequestParam("nombreLenguaLeccion") String nombreLenguaLeccion,
									   @RequestParam("lenguaLeccion") Integer lenguaLeccion,									   
									   @RequestParam(value="file",required=false) MultipartFile[] file,
									   
									   @RequestParam("idLenguaLeccion") Integer idLenguaLeccion,
									   HttpServletRequest request) {
		System.out.println("grabarLenguaLeccion");
		 
		
		LenguaLeccionBean lenguaLeccionBean = new LenguaLeccionBean();
		lenguaLeccionBean.setCodigo(idLenguaLeccion);
		lenguaLeccionBean.setNombreLeccion(VO.convertirCaracteresEsp(nombreLenguaLeccion));
		lenguaLeccionBean.getLenguaBean().setCodigo(codLengua);
		lenguaLeccionBean.getLeccion().setCodigoRegistro(lenguaLeccion);
		long  data = 0;
		boolean swNuevaUrlImagen = false; 
		System.out.println("probando .....2");
		boolean validatePeticion = false;
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("LenguaController/grabarLenguaLeccionImg");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	validatePeticion = true;
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(file != null && file.length != 0) {
			String[] imagen1 = file[0].getOriginalFilename().toString().split("\\.");
			String ext1=imagen1[imagen1.length-1].toLowerCase();
			if(!ext1.equals("jpg") && !ext1.equals("jpeg")
					&& !ext1.equals("png")) {
				data = -1;
				return data;
			}
		}else {
			data = -1;
			return data;
		}
		
		if (file != null  ) {
		if (file.length > 0) {
			swNuevaUrlImagen = (file[0] != null) && (file[0].getOriginalFilename() != null && file[0].getOriginalFilename() != "")
					&& (file[0].getOriginalFilename().trim().length() > 0);
			System.out.println(swNuevaUrlImagen);	
			System.out.println(file[0].getOriginalFilename());
		}	
	}
		if (swNuevaUrlImagen) 
		{

			lenguaLeccionBean.setFileImagen(file[0]);
			if (file[0].getOriginalFilename() != null && file[0].getOriginalFilename() != "") 
			{
				lenguaLeccionBean.setNombreImagen(VO.convertirCaracteresEsp(file[0].getOriginalFilename()));
				System.out.println(lenguaLeccionBean.getNombreImagen());
			}
		}
		
		 
		 

	
			try { 
				
				if(validatePeticion) {
					if(lenguaLeccionBean.getNombreLeccion()!=null&&lenguaLeccionBean.getNombreLeccion()!="") {
						this.setAuditoria(lenguaLeccionBean, request, false);
						if(!this.getLenguaLeccionService().existe(lenguaLeccionBean)){
							lenguaLeccionBean.setNombreImagenBloq("");
							this.getLenguaLeccionService().actualizar(lenguaLeccionBean);
							//this.getLenguaLeccionService().actualizar(lenguaLeccionBean);
							data = lenguaLeccionBean.getCodigo();
							if (swNuevaUrlImagen) {
								
								super.cargarArchivo(this.getRootPathLeccion(), renombrarImagen(file, lenguaLeccionBean.getCodigo()), lenguaLeccionBean.getFileImagen());
								lenguaLeccionBean.setNombreImagen(renombrarImagen(file, lenguaLeccionBean.getCodigo()));
								this.getLenguaLeccionService().actualizarimgxcod(lenguaLeccionBean);
							}	 
						}
						
						System.out.println("modificar lenguaUnidadBean: " + lenguaLeccionBean);						
					}
				}
					 
						

										
				} catch (ServiceException e) { 
					e.printStackTrace();
				}

		return data;		 
	}
	
	@RequestMapping(value = "/grabarLenguaLeccionSinImg", method = RequestMethod.POST) 
	@ResponseBody
	public Long grabarLenguaLeccionSinImg(@RequestParam("codLengua") Integer codLengua,
									   @RequestParam("nombreLenguaLeccion") String nombreLenguaLeccion,
									   @RequestParam("lenguaLeccion") Integer lenguaLeccion,	
									   @RequestParam("idLenguaLeccion") Integer idLenguaLeccion,
									   HttpServletRequest request) {
		System.out.println("grabarLenguaLeccion");
		 
		
		LenguaLeccionBean lenguaLeccionBean = new LenguaLeccionBean();
		lenguaLeccionBean.setCodigo(idLenguaLeccion);
		lenguaLeccionBean.setNombreLeccion(VO.convertirCaracteresEsp(nombreLenguaLeccion));
		lenguaLeccionBean.getLenguaBean().setCodigo(codLengua);
		lenguaLeccionBean.getLeccion().setCodigoRegistro(lenguaLeccion);
		long  data = 0;
		boolean validatePeticion = false;
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("LenguaController/grabarLenguaLeccionImg");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	validatePeticion = true;
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
			try { 
						 
				if(validatePeticion) {
					if(lenguaLeccionBean.getNombreLeccion()!=null&&lenguaLeccionBean.getNombreLeccion()!="") {
					
						this.setAuditoria(lenguaLeccionBean, request, false);
						if(!this.getLenguaLeccionService().existe(lenguaLeccionBean)){
							lenguaLeccionBean.setNombreImagen("");
							lenguaLeccionBean.setNombreImagenBloq("");
							this.getLenguaLeccionService().actualizar(lenguaLeccionBean);
							//this.getLenguaLeccionService().actualizar(lenguaLeccionBean);
							data = lenguaLeccionBean.getCodigo();
							
						} 
						
					}
				}
			} catch (ServiceException e) { 
				e.printStackTrace();
			}

		return data;		 
	}
	
	@RequestMapping(value = "/grabarLenguaLeccionImgb", method = RequestMethod.POST) 
	@ResponseBody
	public Long grabarLenguaLeccionImgb(@RequestParam("codLengua") Integer codLengua,
									   @RequestParam("nombreLenguaLeccion") String nombreLenguaLeccion,
									   @RequestParam("lenguaLeccion") Integer lenguaLeccion,									   
									   
									   @RequestParam(value="files",required=false) MultipartFile[] files,
									   @RequestParam("idLenguaLeccion") Integer idLenguaLeccion,
									   HttpServletRequest request) {
		System.out.println("grabarLenguaLeccion");
		 
		
		LenguaLeccionBean lenguaLeccionBean = new LenguaLeccionBean();
		lenguaLeccionBean.setCodigo(idLenguaLeccion);
		lenguaLeccionBean.setNombreLeccion(VO.convertirCaracteresEsp(nombreLenguaLeccion));
		lenguaLeccionBean.getLenguaBean().setCodigo(codLengua);
		lenguaLeccionBean.getLeccion().setCodigoRegistro(lenguaLeccion);
		long  data = 0; 
		boolean swNuevaUrlImagenBloq = false;
		System.out.println("probando .....2");
		boolean validatePeticion = false;
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("LenguaController/grabarLenguaLeccionImgb");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	validatePeticion = true;
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
		if(files != null && files.length != 0) {
			String[] imagen2 = files[0].getOriginalFilename().toString().split("\\.");
			if(!imagen2[imagen2.length-1].equals("jpg") && !imagen2[imagen2.length-1].equals("jpeg")
					&& !imagen2[imagen2.length-1].equals("png")) {
				data = -1;
				return data;
			}
		}else {
			data = -1;
			return data;
		}
		
		if (files != null  ) {
		if (files.length > 0 && files != null) {
			swNuevaUrlImagenBloq = (files[0] != null) && (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "")
					&& (files[0].getOriginalFilename().trim().length() > 0);
			System.out.println(swNuevaUrlImagenBloq);	
			System.out.println(files[0].getOriginalFilename());
		}
	}
		if (swNuevaUrlImagenBloq) 
		{

			lenguaLeccionBean.setFileImagenBloq(files[0]);
			if (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "") 
			{
				lenguaLeccionBean.setNombreImagenBloq(VO.convertirCaracteresEsp(files[0].getOriginalFilename()));
				System.out.println(lenguaLeccionBean.getNombreImagenBloq());
			}
		} 
	
			try { 	
				if(validatePeticion) {
					if(lenguaLeccionBean.getNombreLeccion()!=null&&lenguaLeccionBean.getNombreLeccion()!="") {
						System.out.println("modificar lenguaUnidadBean: " + lenguaLeccionBean);
						this.setAuditoria(lenguaLeccionBean, request, false);
						if(!this.getLenguaLeccionService().existe(lenguaLeccionBean)){
							lenguaLeccionBean.setNombreImagen("");
							this.getLenguaLeccionService().actualizar(lenguaLeccionBean);
							//this.getLenguaLeccionService().actualizar(lenguaLeccionBean);
							data = lenguaLeccionBean.getCodigo();
							
							if (swNuevaUrlImagenBloq) {
								super.cargarArchivo(this.getRootPathLeccion(), renombrarImagen(files, lenguaLeccionBean.getCodigo()), lenguaLeccionBean.getFileImagenBloq());
								lenguaLeccionBean.setNombreImagenBloq(renombrarImagen(files, lenguaLeccionBean.getCodigo()));
								this.getLenguaLeccionService().actualizarimgxcod(lenguaLeccionBean);
							}							
							
							
						}
						if (swNuevaUrlImagenBloq) {
							super.cargarArchivo(this.getRootPathLeccion(), renombrarImagen(files, lenguaLeccionBean.getCodigo()), lenguaLeccionBean.getFileImagenBloq());
							lenguaLeccionBean.setNombreImagenBloq(renombrarImagen(files, lenguaLeccionBean.getCodigo()));
							this.getLenguaLeccionService().actualizarimgxcod(lenguaLeccionBean);
						}	
						
					
					}
				}
						

										
				} catch (ServiceException e) { 
					e.printStackTrace();
				}

		return data;		 
	}
	
	
	@RequestMapping(value = "/listarLenguaLeccion", method = RequestMethod.POST)
	@ResponseBody
	public List<LenguaLeccionBean> listarLenguaLeccion(@RequestParam("codLengua") Integer codLengua)
			throws Exception {
		System.out.println("listarLenguaLeccion");
		LenguaLeccionBean oLenguaLeccionBean = new LenguaLeccionBean();
		oLenguaLeccionBean.getLenguaBean().setCodigo(codLengua);
		
		List<LenguaLeccionBean> lstLenguaLeccionBean =new ArrayList<LenguaLeccionBean>(); 
		try {
							
			lstLenguaLeccionBean = this.getLenguaLeccionService().getBuscarPorFiltros(oLenguaLeccionBean);
			if (lstLenguaLeccionBean != null && lstLenguaLeccionBean.size() > 0) {
				System.out.println("lstLenguaUnidadBeans actual :: "+lstLenguaLeccionBean.size());				
			
			}else{
				System.out.println("lista vacia");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return lstLenguaLeccionBean;
	}
	@RequestMapping(value = "/eliminarLenguaLeccion", method = RequestMethod.POST)
	@ResponseBody
	public String eliminarLenguaLeccion(@RequestParam("codLenguaLeccion") Integer codLenguaLeccion)
			throws Exception {
		System.out.println("eliminarLenguaLeccion");
		String  data = "";
		LenguaLeccionBean oLenguaLeccionBean = new LenguaLeccionBean();
		oLenguaLeccionBean.setCodigo(codLenguaLeccion);				
		try {							
				if (oLenguaLeccionBean.getCodigo() != 0) {
					this.getLenguaLeccionService().eliminar(oLenguaLeccionBean);
					data = "1";
				}else{
					System.out.println("Error");
				}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return data;
	}
	@RequestMapping(value = "/editarLenguaLeccion", method = RequestMethod.POST)
	@ResponseBody
	public LenguaLeccionBean editarLenguaLeccion(@RequestParam("codLenguaLeccion") Integer codLenguaLeccion)
			throws Exception {
		System.out.println("editarLenguaLeccion");
		LenguaLeccionBean oLenguaLeccionBean = new LenguaLeccionBean();
		oLenguaLeccionBean.setCodigo(codLenguaLeccion);
				 
		try {
							
			lenguaLeccionBean = this.getLenguaLeccionService().getBuscarPorObjecto(oLenguaLeccionBean);
			
			if (lenguaLeccionBean != null ) {				
				System.out.println("lstLenguaUnidadBeans actual :: "+lenguaLeccionBean);							
			}else{
				System.out.println("lista vacia");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return lenguaLeccionBean;
	}
	public LenguaService getLenguaService() {
		return lenguaService;
	}

	public void setLenguaService(LenguaService lenguaService) {
		this.lenguaService = lenguaService;
	}
	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	public List<LenguaBean> getLstLenguaBean() {
		return lstLenguaBean;
	}

	public void setLstLenguaBean(List<LenguaBean> lstLenguaBean) {
		this.lstLenguaBean = lstLenguaBean;
	}

	public List<MaestraBean> getLstSituacion() {
		return lstSituacion;
	}

	public void setLstSituacion(List<MaestraBean> lstSituacion) {
		this.lstSituacion = lstSituacion;
	}
 
	 public List<MaestraBean> getLstSituacionLeccion() {
		return lstSituacionLeccion;
	}

	public void setLstSituacionLeccion(List<MaestraBean> lstSituacionLeccion) {
		this.lstSituacionLeccion = lstSituacionLeccion;
	}

	public List<MaestraBean> getLstUnidad() {
		return lstUnidad;
	}

	public void setLstUnidad(List<MaestraBean> lstUnidad) {
		this.lstUnidad = lstUnidad;
	}

	public List<MaestraBean> getLstNivel() {
		return lstNivel;
	}

	public void setLstNivel(List<MaestraBean> lstNivel) {
		this.lstNivel = lstNivel;
	}

	public List<MaestraBean> getLstSubNivel() {
		return lstSubNivel;
	}

	public void setLstSubNivel(List<MaestraBean> lstSubNivel) {
		this.lstSubNivel = lstSubNivel;
	}

	public void setValoresPredeterminados(LenguaBean lenguaBean){
		 lenguaBean.setNombre(""); 
		 lenguaBean.getSituacion().setCodigoRegistro(0);
	 }
	 
	 public String getRootPath() {    	
		return ResourceUtil.getKey("ruta.natigu.archivos.general.lengua");
     }
	 public String getRootPathUnidad(){
		 return ResourceUtil.getKey("ruta.natigu.archivos.general.unidad");
	 }
	 public String getRootPathSubNivel(){
		 return ResourceUtil.getKey("ruta.natigu.archivos.general.subNivel");
	 }
	 public String getRootPathLeccion(){
		 return ResourceUtil.getKey("ruta.natigu.archivos.general.leccion");
	 }

	public List<LenguaEstructuraBean> getLstLenguaEstructuraBean() {
		return lstLenguaEstructuraBean;
	}

	public void setLstLenguaEstructuraBean(List<LenguaEstructuraBean> lstLenguaEstructuraBean) {
		this.lstLenguaEstructuraBean = lstLenguaEstructuraBean;
	}

	public LenguaEstructuraBean getLenguaEstructuraBean() {
		return lenguaEstructuraBean;
	}

	public void setLenguaEstructuraBean(LenguaEstructuraBean lenguaEstructuraBean) {
		this.lenguaEstructuraBean = lenguaEstructuraBean;
	}

	public List<MaestraBean> getLstSubNivel1() {
		return lstSubNivel1;
	}

	public void setLstSubNivel1(List<MaestraBean> lstSubNivel1) {
		this.lstSubNivel1 = lstSubNivel1;
	}

	public List<MaestraBean> getLstSubNivel2() {
		return lstSubNivel2;
	}

	public void setLstSubNivel2(List<MaestraBean> lstSubNivel2) {
		this.lstSubNivel2 = lstSubNivel2;
	}

	public List<MaestraBean> getLstSubNivel3() {
		return lstSubNivel3;
	}

	public void setLstSubNivel3(List<MaestraBean> lstSubNivel3) {
		this.lstSubNivel3 = lstSubNivel3;
	}

	public List<UnidadLeccionBean> getLstUnidadLeccionBean() {
		return lstUnidadLeccionBean;
	}

	public void setLstUnidadLeccionBean(List<UnidadLeccionBean> lstUnidadLeccionBean) {
		this.lstUnidadLeccionBean = lstUnidadLeccionBean;
	}

	public LenguaForm getLenguaForm() {
		return lenguaForm;
	}

	public void setLenguaForm(LenguaForm lenguaForm) {
		this.lenguaForm = lenguaForm;
	}

	public UnidadBean getUnidadBean() {
		return unidadBean;
	}

	public void setUnidadBean(UnidadBean unidadBean) {
		this.unidadBean = unidadBean;
	}

	public List<UnidadBean> getLstUnidadBean() {
		return lstUnidadBean;
	}

	public void setLstUnidadBean(List<UnidadBean> lstUnidadBean) {
		this.lstUnidadBean = lstUnidadBean;
	}

	public UnidadLeccionBean getUnidadLeccionBean() {
		return unidadLeccionBean;
	}

	public void setUnidadLeccionBean(UnidadLeccionBean unidadLeccionBean) {
		this.unidadLeccionBean = unidadLeccionBean;
	}

	public List<MaestraBean> getLstLeccion() {
		return lstLeccion;
	}

	public void setLstLeccion(List<MaestraBean> lstLeccion) {
		this.lstLeccion = lstLeccion;
	}

	public List<LenguaNivelBean> getLstLenguaNivelBean() {
		return lstLenguaNivelBean;
	}

	public void setLstLenguaNivelBean(List<LenguaNivelBean> lstLenguaNivelBean) {
		this.lstLenguaNivelBean = lstLenguaNivelBean;
	}

	public LenguaNivelBean getLenguaNivelBean() {
		return lenguaNivelBean;
	}

	public void setLenguaNivelBean(LenguaNivelBean lenguaNivelBean) {
		this.lenguaNivelBean = lenguaNivelBean;
	}

	public LenguaUnidadBean getLenguaUnidadBean() {
		return lenguaUnidadBean;
	}

	public void setLenguaUnidadBean(LenguaUnidadBean lenguaUnidadBean) {
		this.lenguaUnidadBean = lenguaUnidadBean;
	}

	public LenguaUnidadService getLenguaUnidadService() {
		return lenguaUnidadService;
	}

	public void setLenguaUnidadService(LenguaUnidadService lenguaUnidadService) {
		this.lenguaUnidadService = lenguaUnidadService;
	}

	public LenguaLeccionBean getLenguaLeccionBean() {
		return lenguaLeccionBean;
	}

	public void setLenguaLeccionBean(LenguaLeccionBean lenguaLeccionBean) {
		this.lenguaLeccionBean = lenguaLeccionBean;
	}

	public LenguaLeccionService getLenguaLeccionService() {
		return lenguaLeccionService;
	}

	public void setLenguaLeccionService(LenguaLeccionService lenguaLeccionService) {
		this.lenguaLeccionService = lenguaLeccionService;
	}

	public List<MaestraBean> getLstLecciones() {
		return lstLecciones;
	}

	public void setLstLecciones(List<MaestraBean> lstLecciones) {
		this.lstLecciones = lstLecciones;
	}

	public LenguaBean getLenguaBeanFiltro() {
		return lenguaBeanFiltro;
	}

	public void setLenguaBeanFiltro(LenguaBean lenguaBeanFiltro) {
		this.lenguaBeanFiltro = lenguaBeanFiltro;
	}

	public Integer getCodigoFiltro() {
		return codigoFiltro;
	}

	public void setCodigoFiltro(Integer codigoFiltro) {
		this.codigoFiltro = codigoFiltro;
	} 
	
	
}