/*package pe.gob.procalidad.natigu.web.gestion.controller.academico;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EspecialidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionDocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonalBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.DocenteService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.EspecialidadService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionDocenteService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UbigeoService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
 
@Controller
//@Scope(value="session")
@RequestMapping(value = "docenteController")
public class DocenteController extends BaseController {

	private DocenteBean 			docenteBean;
	private EspecialidadBean 		especialidadBean;
	
	private List<DocenteBean> 	lstDocenteBean;

	private UbigeoBean ubigeoBean;
	
	private List<MaestraBean>	lstSituacion;
	private List<MaestraBean> lstTipoDocumento;
	private List<MaestraBean> lstNacionalidad;
	private List<MaestraBean> lstGrado;
	private List<MaestraBean> lstCargo;
	private List<MaestraBean> lstSexo;
	private List<MaestraBean> lstCarrera;
	private List<LenguaBean> 	lstLengua;
	private List<MaestraBean> 	lstNivel;
	private List<InstitucionBean> lstInstitucion;
	private List<EspecialidadBean> lstEspecialidad;
	

	private List<UbigeoBean> lstRegion;
	private List<UbigeoBean> lstProvincia;
	private List<UbigeoBean> lstDistrito;

	@Autowired
	private InstitucionService 		institucionService;
	@Autowired
	private EspecialidadService 	especialidadService;
	
	@Autowired
	private InscripcionDocenteService inscripcionDocenteService;
	
	@Autowired
	private Maestra1Service maestra1Service;
	
	@Autowired 
	private PersonaService personaService;
//	
	@Autowired
	private Maestra2Service maestra2Service;

	@Autowired
	private DocenteService docenteService;
	
	@Autowired
	private LenguaService 		lenguaService;

	@Autowired
	private UbigeoService ubigeoService;
	
	public DocenteController(){
//		lstSituacion= new ArrayList<MaestraBean>();
//		
//		lstSituacion.add(new MaestraBean(1,"Activo"));
//		lstSituacion.add(new MaestraBean(2,"Inactivo"));
		
	}
	
	@PostConstruct
	public void init(){
		this.setDocenteBean(new DocenteBean());
		this.setLstDocenteBean(new ArrayList<DocenteBean>());
//		this.setLstSituacion(new ArrayList<MaestraBean>());
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("docenteBean") DocenteBean docenteBean)throws Exception {
		return this.getLista(docenteBean);
	}
	
	
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("docenteBean") DocenteBean docenteBean)
			throws Exception {
		DocenteBean prmDocenteBean = new DocenteBean();
		prmDocenteBean= docenteBean;
		if (docenteBean.getLenguaBean().getNombre().length() == 0) {
			docenteBean.getLenguaBean().setNombre(null);
		}
		return this.getLista(docenteBean);
	}

	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		docenteBean = new DocenteBean();
		docenteBean.setCodigo(codigo);
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
				sw =  (this.getDocenteService().eliminar(docenteBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		docenteBean.setCodigo(0);
		this.setValoresPredeterminados(docenteBean);
		ModelAndView mav = this.getLista(docenteBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}
	
	
	@RequestMapping(value = "/refrescarEspecialidad", method = RequestMethod.GET)
	public @ResponseBody List<EspecialidadBean> refrescarEspecialidad(@RequestParam("codigo") Integer codigo) {
		System.out.println("listarPorCodigoDocente");
		System.out.println("codigo -------------- " + codigo);
		DocenteBean prmDocenteBean = new DocenteBean();
		prmDocenteBean.setCodigo(codigo);
		lstEspecialidad = null;
		try {
			docenteBean = this.getDocenteService().getBuscarPorObjecto(prmDocenteBean);
			lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().listarPorCodigoDocente(prmDocenteBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		return lstEspecialidad;
	}
	
	
	
	@RequestMapping(value ="/eliminarEspecialidad", method = RequestMethod.GET)
	public @ResponseBody String eliminarEspecialidad(@RequestParam("codigo") Integer codigo,@RequestParam("codigoEspecialidad") Integer codigoEspecialidad,HttpServletRequest request){
		boolean sw=false;
		especialidadBean= new EspecialidadBean();
		especialidadBean.setDocenteBean(new DocenteBean());
		especialidadBean.getDocenteBean().setCodigo(codigo);
		especialidadBean.setLenguaBean(new LenguaBean());
		especialidadBean.getLenguaBean().setCodigo(codigoEspecialidad);
		
		especialidadBean.setAudCodigoUsuario(1);
		especialidadBean.setAudHostIP("192.168.1.140");
		System.out.println("entra asi "+sw);
		
		try { 
			sw =  (this.getEspecialidadService().eliminar(especialidadBean));
			
		} catch (Exception e) { 
			e.printStackTrace();
		} 	
		System.out.println("sale asi "+sw);
		return sw?"1":"0";
	}
	
	public void setValoresPredeterminados(DocenteBean docenteBean){
//		 personalBean.setNombre(""); 
//		 personalBean.getSituacion().setCodigoRegistro(0);
	    }
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("academico/registro-docente", "command",new DocenteBean());
//		mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("docenteBean", new DocenteBean());
		this.cargarUbigeo(mav, null);
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {
		System.out.println("listarPorCodigoDocente");
		System.out.println("codigo " + codigo);
		DocenteBean prmDocenteBean = new DocenteBean();
		prmDocenteBean.setCodigo(codigo);
		try {
			docenteBean = this.getDocenteService().getBuscarPorObjecto(prmDocenteBean);
			lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().listarPorCodigoDocente(prmDocenteBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		
		if(docenteBean.getPersonaBean().getFechaNac()!=null){
			String fechaConFormato = sdf.format(docenteBean.getPersonaBean().getFechaNac()); 
			System.out.println("fechaConFormato");
//			Date nuevaFecha=null;
//				nuevaFecha = sdf.parse(fechaConFormato);
			docenteBean.getPersonaBean().setStrFechaNac(fechaConFormato);
			System.out.println("prmAlumnoBean.getPersonaBean().getStrFechaNac()"+docenteBean.getPersonaBean().getStrFechaNac());
		}
		
		
		ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
		mav.addObject("docenteBean", docenteBean);
		mav.addObject("lstEspecialidad", lstEspecialidad);
		this.cargarUbigeo(mav, docenteBean);
		this.cargarCombos(mav);	
		return mav;
	}

	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("docenteBean") DocenteBean docenteBean) {
		
		System.out.println("docenteBean"+docenteBean);
		PersonaBean prmPersona = new PersonaBean();
		
		boolean sw = false;
		try {
			if (docenteBean.getCodigo()==0) {
				
				prmPersona=docenteBean.getPersonaBean();
				prmPersona = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona);
				

				if(prmPersona==null){
					prmPersona=docenteBean.getPersonaBean();
					
					prmPersona.setCodigoUbigeo(docenteBean.getUbigeoBean().getCodigoRegion()+docenteBean.getUbigeoBean().getCodigoProvincia()+docenteBean.getUbigeoBean().getCodigoDistrito());
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
					
					if(docenteBean.getPersonaBean().getStrFechaNac()!=null){
						Date fechaConFormato = sdf.parse(docenteBean.getPersonaBean().getStrFechaNac().toString()); 
						prmPersona.setFechaNac(fechaConFormato);
						
					}
					sw = (this.getPersonaService().insertar(prmPersona));
					
				}
				
				docenteBean.setAudCodigoUsuario(1);
				docenteBean.setAudHostIP("192.168.1.1");
				
				docenteBean.setPersonaBean(prmPersona);
				
				sw =  (this.getDocenteService().insertar(docenteBean)); 
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
				
				if(docenteBean.getPersonaBean().getStrFechaNac()!=null){
					Date fechaConFormato = sdf.parse(docenteBean.getPersonaBean().getStrFechaNac().toString()); 
					
					prmPersona.setFechaNac(fechaConFormato);
					docenteBean.getPersonaBean().setFechaNac(prmPersona.getFechaNac());
					
				}
				docenteBean.getPersonaBean().setCodigoUbigeo(docenteBean.getUbigeoBean().getCodigoRegion()+docenteBean.getUbigeoBean().getCodigoProvincia()+docenteBean.getUbigeoBean().getCodigoDistrito());
				
				docenteBean.setAudCodigoUsuario(1);
				docenteBean.setAudHostIP("192.168.1.140");

				sw = (this.getDocenteService().actualizar(docenteBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			docenteBean = new DocenteBean() ;
			//return this.getLista(docenteBean);
			ModelAndView mav = this.getLista(docenteBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
			
		} else {
			ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		}

	}
	
	@RequestMapping(value = "/grabarEspecialidad", method = RequestMethod.POST)
	public @ResponseBody String doGrabarEspecialidad(@ModelAttribute("docenteBean") DocenteBean docenteBean) {

		System.out.println("grabarEspecialidad codigo de docente "+docenteBean.getCodigo());
	    especialidadBean = docenteBean.getEspecialidadBean();
	    especialidadBean.setDocenteBean(docenteBean);
		
	    DocenteBean prmDocenteBean = new DocenteBean(); 
	    
		boolean sw = false;
		try {
			//if (especialidadBean.getCodigo()==0) {
			
				especialidadBean.setAudCodigoUsuario(1);
				especialidadBean.setAudHostIP("192.168.1.1");
				
				sw =  (this.getEspecialidadService().insertar(especialidadBean));
				
				prmDocenteBean = this.getDocenteService().getBuscarPorObjecto(docenteBean);
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
				
				if(prmDocenteBean.getPersonaBean().getFechaNac()!=null){
					String fechaConFormato = sdf.format(prmDocenteBean.getPersonaBean().getFechaNac()); 
					System.out.println("fechaConFormato");
//					Date nuevaFecha=null;
//						nuevaFecha = sdf.parse(fechaConFormato);
					prmDocenteBean.getPersonaBean().setStrFechaNac(fechaConFormato);
					System.out.println("prmAlumnoBean.getPersonaBean().getStrFechaNac()"+prmDocenteBean.getPersonaBean().getStrFechaNac());
				}
				
				
				lstEspecialidad = new ArrayList<EspecialidadBean>();
				lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().listarPorCodigoDocente(docenteBean);
			//} else {
			//	sw = (this.getDocenteService().actualizar(docenteBean));
			//}

		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView("academico/registro-docente", "command",prmDocenteBean);
		mav.addObject("docenteBean", prmDocenteBean);
		mav.addObject("lstEspecialidad", lstEspecialidad);
		mav.addObject("swMensaje",sw?"1":"0");
		this.cargarUbigeo(mav, docenteBean);
		this.cargarCombos(mav);	
		return mav;
		
		return sw?"1":"0";
	}
	
	@RequestMapping(value = "/insertarEspecialidad", method = RequestMethod.GET)
	public String doInsertarEspecialidad(@ModelAttribute("docenteBean") DocenteBean docenteBean) {

		System.out.println("grabarEspecialidad codigo de docente "+docenteBean.getCodigo());
	    especialidadBean = docenteBean.getEspecialidadBean();
	    especialidadBean.setDocenteBean(docenteBean);
		
	    //DocenteBean prmDocenteBean = new DocenteBean(); 
	    
		boolean sw = false;
		try {
			//if (especialidadBean.getCodigo()==0) {
			
				especialidadBean.setAudCodigoUsuario(1);
				especialidadBean.setAudHostIP("192.168.1.1");
				
				sw =  (this.getEspecialidadService().insertar(especialidadBean));
			
				
				lstEspecialidad = new ArrayList<EspecialidadBean>();
				lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().listarPorCodigoDocente(docenteBean);
			//} else {
			//	sw = (this.getDocenteService().actualizar(docenteBean));
			//}

		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		if(sw){
			return "1";
		}else{
			return "0";
		}
	
	}

	
	

	private ModelAndView getLista(DocenteBean docenteBean) {

		//List<DocenteBean> lstDocenteBean =null;
		lstDocenteBean = new ArrayList<DocenteBean>();
		try {
			lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarPorFiltros(docenteBean);
			this.especialidadBean = new EspecialidadBean();
			this.especialidadBean.setDocenteBean(docenteBean);
			this.especialidadBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
			//System.out.println("lstLenguaBean "+lstDocenteBean.size());
		
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("academico/listado-docente", "command",docenteBean);
		System.out.println("lstDocenteBean "+lstDocenteBean);
		mav.addObject("lstDocenteBean", lstDocenteBean);
		this.cargarUbigeo(mav, null);
		this.cargarCombos(mav);
		return mav;
	}
	//this.cargarUbigeo(mav, null);
	private void cargarUbigeo(ModelAndView mav,DocenteBean docenteBean){

		ubigeoBean = new UbigeoBean();
		if(docenteBean!=null){
			ubigeoBean = docenteBean.getUbigeoBean();
		}
		
		try {
			lstRegion = this.getUbigeoService().listarRegion();
			lstProvincia = this.getUbigeoService().listarProvincia(ubigeoBean);
			lstDistrito = this.getUbigeoService().listarDistrito(ubigeoBean);
			
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}		
	
		
		mav.addObject("lstRegion",lstRegion); 
		mav.addObject("lstProvincia",lstProvincia);
		mav.addObject("lstDistrito",lstDistrito); 
	}
          
	private void cargarCombos(ModelAndView mav)	{
//		lstSituacion = new ArrayList<MaestraBean>();

		InstitucionBean institucionBean = new InstitucionBean();
		
		
		LenguaBean lenguaBean = new LenguaBean();
		if (lstSituacion==null) {
			try {
				lstInstitucion = (List<InstitucionBean>) this.getInstitucionService().getBuscarPorFiltros(institucionBean);
				
				lstLengua = (List<LenguaBean>) this.getLenguaService().getBuscarPorFiltros(lenguaBean);
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionLengua");
				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento");
				lstNacionalidad = maestra2Service.listarPorCodigoTabla("nacionalidad");
						lstGrado=  maestra2Service.listarPorCodigoTabla("grado");
						lstCargo= maestra2Service.listarPorCodigoTabla("cargo");
						lstSexo= maestra2Service.listarPorCodigoTabla("sexo");
						lstCarrera =maestra2Service.listarPorCodigoTabla("carrera");
						lstNivel = maestra2Service.listarPorCodigoTabla("nivel");
//				lstRegion = this.getUbigeoService().listarRegion();
//				lstProvincia = this.getUbigeoService().listarProvincia(ubigeoBean);
//				lstDistrito = this.getUbigeoService().listarDistrito(ubigeoBean);
				
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
  
		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstTipoDocumento",lstTipoDocumento); 
		mav.addObject("lstNacionalidad",lstNacionalidad); 
		mav.addObject("lstGrado",lstGrado); 
		mav.addObject("lstCargo",lstCargo); 
		mav.addObject("lstSexo",lstSexo);
		mav.addObject("lstCarrera",lstCarrera); 
		mav.addObject("lstLengua",lstLengua); 
		mav.addObject("lstInstitucion",lstInstitucion); 
		mav.addObject("lstNivel",lstNivel); 
		mav.addObject("lstEspecialidad",lstEspecialidad);
	}
	
	
	*//***********************************************************************//*
	
	
	
	
	*//***********************************************************************//*
	
	
	@RequestMapping(value = "/listadodocente", method = RequestMethod.GET)
	public ModelAndView doListadoDocente(@ModelAttribute("docenteBean") DocenteBean docenteBean)throws Exception {
		DocenteBean prmDocenteBean = new DocenteBean();
		prmDocenteBean= docenteBean;
		//prmDocenteBean.setNombre("");
		return this.getListaDocente(prmDocenteBean);
	}
	
	
	

	@RequestMapping(value = "/buscardocente", method = RequestMethod.GET)
	public @ResponseBody List<DocenteBean> doBuscarDocente(@RequestParam("codigoInst") int codigoInst, @RequestParam("nombreDocente") String nombreDocente, @RequestParam("numeroDocumento") String numeroDocumento,@RequestParam("codigoinsclengua") int codigoinsclengua)throws Exception {
		List<DocenteBean> lstDocente = new ArrayList<DocenteBean>();
		
		InscripcionDocenteBean prmDocenteBean = new InscripcionDocenteBean();
		prmDocenteBean.getDocenteBean().getInstitucionBean().setCodigo(codigoInst);
		prmDocenteBean.getDocenteBean().getPersonaBean().setNombrePersona(nombreDocente);
		prmDocenteBean.getDocenteBean().getPersonaBean().setNumeroDocumento(numeroDocumento);
		prmDocenteBean.getInscripcionLenguaBean().setCodigo(codigoinsclengua);
		lstDocente = docenteService.getBuscarXInstitucionNombreNumeroDocumentoTipoDocumento(prmDocenteBean);
		//prmDocenteBean.setNombre("");
		
		return lstDocente;
	}
	
	
	private ModelAndView getListaDocente(DocenteBean docenteBean) {

		//List<DocenteBean> lstDocenteBean =null;
		lstDocenteBean = new ArrayList<DocenteBean>();
		try {
			lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarPorFiltros(docenteBean);
			this.especialidadBean = new EspecialidadBean();
			this.especialidadBean.setDocenteBean(docenteBean);
			this.especialidadBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
			//System.out.println("lstLenguaBean "+lstDocenteBean.size());
		
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("../layout/docente-registro-modal-view", "command",docenteBean);
		System.out.println("lstDocenteBean "+lstDocenteBean);
		mav.addObject("lstDocenteBean", lstDocenteBean);
		this.cargarCombos(mav);
		return mav;
	}
	
	
	@RequestMapping(value = "/grabardocente", method = RequestMethod.POST)
	@ResponseBody
	public  String doGrabarDocente(@ModelAttribute("docenteBean") DocenteBean docenteBean) {
		
		System.out.println("docenteBean"+docenteBean);
		PersonaBean prmPersona = new PersonaBean();
		String n ="";
		boolean sw = false;
		
		try {
			if (docenteBean.getCodigo()==0) {
				
				
				prmPersona=docenteBean.getPersonaBean();
				prmPersona = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona);
				if(prmPersona==null){
					prmPersona=docenteBean.getPersonaBean();
					
//					if(docenteBean.getUbigeoBean()==null || docenteBean.getUbigeoBean().equals("") ){
//						docenteBean.getUbigeoBean().setCodigoRegion("00");
//						docenteBean.getUbigeoBean().setCodigoProvincia("00");
//						docenteBean.getUbigeoBean().setCodigoDistrito("00");
//						
//					}
					
					
					
					docenteBean.getUbigeoBean().setCodigoRegion("00");
					docenteBean.getUbigeoBean().setCodigoProvincia("00");
					docenteBean.getUbigeoBean().setCodigoDistrito("00");
					
					
					prmPersona.setCodigoUbigeo(docenteBean.getUbigeoBean().getCodigoRegion()+docenteBean.getUbigeoBean().getCodigoProvincia()+docenteBean.getUbigeoBean().getCodigoDistrito());
					System.out.println(prmPersona.getCodigoUbigeo());
					sw = (this.getPersonaService().insertar(prmPersona));
					docenteBean.setAudCodigoUsuario(1);
					docenteBean.setAudHostIP("192.168.1.1");
				}
				docenteBean.setPersonaBean(prmPersona);
				
				sw =  (this.getDocenteService().insertar(docenteBean)); 
			} else {
				sw = (this.getDocenteService().actualizar(docenteBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if(sw){
			n="exito";
		}else{
			n="false";
		}
//		if (sw) {
//			docenteBean = new DocenteBean() ;
//			return this.getListaDocente(docenteBean);
//		} else {
//			ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
//			return mav;
//		}
		return n;

	}
	
	
	*//*************************************************************************************//*
	
	
	@RequestMapping(value = "/asignardocente", method = RequestMethod.POST)
	public @ResponseBody String doAsignarDocente(@RequestParam("codigoinsclen") int codigoinsclen, @RequestParam("coddocente") int coddocente )throws Exception {
		
		boolean sw = false;
		String data="";
		InscripcionDocenteBean inscripcionDocenteBean = new InscripcionDocenteBean();
		inscripcionDocenteBean.getInscripcionLenguaBean().setCodigo(codigoinsclen);
		inscripcionDocenteBean.getDocenteBean().setCodigo(coddocente);
		inscripcionDocenteBean.getSituacionInscripcionDocente().setCodigoRegistro(1);
	    sw = inscripcionDocenteService.insertar(inscripcionDocenteBean);
		//prmDocenteBean.setNombre("");
		
	    if(sw){
	    	sw=true;
	    	data="Exito";
	    }else{
	    	data="Error";
	    }
		return data;
	}
	
	
	
	@RequestMapping(value = "/listadocentesasignados", method = RequestMethod.GET)
	public @ResponseBody List<InscripcionDocenteBean> doListaDocentesAsignados(@RequestParam("codigoInst") int codigoInst, @RequestParam("codigoinsclen") int codigoInscLen, @RequestParam("codigoinsc") int codigoInsc, @RequestParam("situacion") int situ)throws Exception {
		List<InscripcionDocenteBean> lstInscripcionDocenteBean= new ArrayList<InscripcionDocenteBean>();
		InscripcionDocenteBean inscripcionDocenteBean = new InscripcionDocenteBean();
		inscripcionDocenteBean.getInscripcionLenguaBean().getInstitucion().setCodigo(codigoInst);
		inscripcionDocenteBean.getInscripcionLenguaBean().setCodigo(codigoInscLen);
		inscripcionDocenteBean.getInscripcionLenguaBean().getInscripcionBean().setCodigo(codigoInsc);
		inscripcionDocenteBean.getSituacionInscripcionDocente().setCodigoRegistro(situ);
		lstInscripcionDocenteBean = inscripcionDocenteService.getBuscarPorFiltros(inscripcionDocenteBean);
		//prmDocenteBean.setNombre("");
		if(lstInscripcionDocenteBean==null){
			lstInscripcionDocenteBean= new ArrayList<InscripcionDocenteBean>();
		}
		
		return lstInscripcionDocenteBean;
	}
	
	
	
	
	

	@RequestMapping(value = "/darbajadocenteasignado", method = RequestMethod.POST)
	public @ResponseBody String doDarBajaDocenteAsignado(@RequestParam("codinscdocente") int codinscdocente)throws Exception {
		
		boolean sw=false;
		String data="";
		InscripcionDocenteBean inscripcionDocenteBean = new InscripcionDocenteBean();
		inscripcionDocenteBean.setCodigo(codinscdocente);

		
		sw = inscripcionDocenteService.dar_baja_docente_x_InscripcionDocente(inscripcionDocenteBean);
		//prmDocenteBean.setNombre("");
		if(sw){
			data ="Docente Se dio de Baja";
		}else{
			data ="Error al dar De Baja Docente";
		}
		
		return data;
	}
	
		
	public DocenteBean getDocenteBean() {
		return docenteBean;
	}

	public void setDocenteBean(DocenteBean docenteBean) {
		this.docenteBean = docenteBean;
	}

	public List<DocenteBean> getLstDocenteBean() {
		return lstDocenteBean;
	}

	public void setLstDocenteBean(List<DocenteBean> lstDocenteBean) {
		this.lstDocenteBean = lstDocenteBean;
	}

	public List<MaestraBean> getLstSituacion() {
		return lstSituacion;
	}

	public void setLstSituacion(List<MaestraBean> lstSituacion) {
		this.lstSituacion = lstSituacion;
	}

	public DocenteService getDocenteService() {
		return docenteService;
	}

	public void setDocenteService(DocenteService docenteService) {
		this.docenteService = docenteService;
	}

	public Maestra1Service getMaestra1Service() {
		return maestra1Service;
	}

	public void setMaestra1Service(Maestra1Service maestra1Service) {
		this.maestra1Service = maestra1Service;
	}

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	public Maestra2Service getMaestra2Service() {
		return maestra2Service;
	}

	public void setMaestra2Service(Maestra2Service maestra2Service) {
		this.maestra2Service = maestra2Service;
	}

	public LenguaService getLenguaService() {
		return lenguaService;
	}

	public void setLenguaService(LenguaService lenguaService) {
		this.lenguaService = lenguaService;
	}

	public InstitucionService getInstitucionService() {
		return institucionService;
	}

	public void setInstitucionService(InstitucionService institucionService) {
		this.institucionService = institucionService;
	}

	public EspecialidadService getEspecialidadService() {
		return especialidadService;
	}

	public void setEspecialidadService(EspecialidadService especialidadService) {
		this.especialidadService = especialidadService;
	}

	public EspecialidadBean getEspecialidadBean() {
		return especialidadBean;
	}

	public void setEspecialidadBean(EspecialidadBean especialidadBean) {
		this.especialidadBean = especialidadBean;
	}
	
	public UbigeoService getUbigeoService() {
		return ubigeoService;
	}
	public void setUbigeoService(UbigeoService ubigeoService) {
		this.ubigeoService = ubigeoService;
	}


}
*/