/*package pe.gob.procalidad.natigu.web.gestion.controller.academico;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UbigeoService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
 
@Controller
@Scope(value="session")
@RequestMapping(value = "alumnoController")
public class AlumnoController extends BaseController {

	private AlumnoBean 			alumnoBean;
	private List<AlumnoBean> 	lstAlumnoBean;


	private List<MaestraBean>	lstSituacion,lstTipoDocumento,lstNacionalidad,lstSexo;
	private List<MaestraBean>	lstNivel,lstGrado,lstCarrera;

	private UbigeoBean ubigeoBean;
	private List<UbigeoBean> lstRegion;
	private List<UbigeoBean> lstProvincia;
	private List<UbigeoBean> lstDistrito;

	private UbigeoBean ubigeoBeanIntitucion;
	private List<UbigeoBean> lstRegionInstitucion;
	private List<UbigeoBean> lstProvinciaInstitucion;
	private List<UbigeoBean> lstDistritoInstitucion;
	
	private List<InstitucionBean>	lstInstitucionBean;
	private List<LenguaBean> lstLenguaBean;
	
	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private Maestra1Service maestra1Service;
	@Autowired
	private Maestra2Service maestra2Service;
	@Autowired 
	private PersonaService personaService;
    @Autowired
	private InstitucionService	institucionService;
	@Autowired
	private LenguaService 	lenguaService;
	@Autowired
	private UbigeoService ubigeoService;
	
	public AlumnoController (){
		//lstSituacion = null;
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("alumnoBean") AlumnoBean alumnoBean)throws Exception {
		System.out.println("alumnoBean : "+alumnoBean);
		if (alumnoBean.getPersonaBean() == null) {
			alumnoBean.setPersonaBean(new PersonaBean());
			alumnoBean.getPersonaBean().setNombrePersona("");
			alumnoBean.getPersonaBean().setNumeroDocumento("");
		}
		if (alumnoBean.getInstitucionBean() == null) {
			alumnoBean.setInstitucionBean(new InstitucionBean());
			alumnoBean.getInstitucionBean().setNombreInstitucion("");
		}
		if (alumnoBean.getTm1Situacion() == null) {
			alumnoBean.setTm1Situacion(new MaestraBean());
			alumnoBean.getTm1Situacion().setCodigoRegistro(0);
		}
		return this.getLista(alumnoBean);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("alumnoBean") AlumnoBean alumnoBean)
			throws Exception {
		return this.getLista(alumnoBean);
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		ModelAndView mav = new ModelAndView("academico/registro-alumno", "command",new AlumnoBean());
		mav.addObject("alumnoBean", new AlumnoBean());
		this.cargarUbigeoIntitucion(mav, null);
		this.cargarUbigeo(mav,null);
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {

		AlumnoBean prmAlumnoBean = new AlumnoBean();
		prmAlumnoBean.setCodigo(codigo);
		
		try {
			prmAlumnoBean = this.getAlumnoService().getBuscarPorObjecto(prmAlumnoBean);
			System.out.println(prmAlumnoBean.getCodigo());
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		
		if(prmAlumnoBean.getPersonaBean().getFechaNac()!=null){
			String fechaConFormato = sdf.format(prmAlumnoBean.getPersonaBean().getFechaNac()); 
			System.out.println("fechaConFormato");
//			Date nuevaFecha=null;
//				nuevaFecha = sdf.parse(fechaConFormato);
			prmAlumnoBean.getPersonaBean().setStrFechaNac(fechaConFormato);
			System.out.println("prmAlumnoBean.getPersonaBean().getStrFechaNac()"+prmAlumnoBean.getPersonaBean().getStrFechaNac());
		}
		
		if(prmAlumnoBean.getTm2Nivel()!=null){
			try {
				if (prmAlumnoBean.getTm2Nivel().getCodigoRegistro()==1) {
					lstGrado = maestra2Service.listarPorCodigoTabla("gradoAlumno");
				}else if(prmAlumnoBean.getTm2Nivel().getCodigoRegistro()==2){
					lstGrado = maestra2Service.listarPorCodigoTabla("gradoAlumnoSecundaria");
				}
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		ModelAndView mav = new ModelAndView("academico/registro-alumno", "command", prmAlumnoBean);
		mav.addObject("alumnoBean", prmAlumnoBean);
		this.cargarUbigeoIntitucion(mav, prmAlumnoBean);
		this.cargarUbigeo(mav,prmAlumnoBean);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		alumnoBean= new AlumnoBean();
		alumnoBean.setCodigo(codigo);
		alumnoBean.setAudCodigoUsuario(1);
		alumnoBean.setAudHostIP("192.168.1.140");
		try { 
			sw =  (this.getAlumnoService().eliminar(alumnoBean));  
			System.out.println("sw es : "+sw);
		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		this.setValoresPredeterminados(alumnoBean);
		ModelAndView mav = this.getLista(alumnoBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}

	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("alumnoBean") AlumnoBean alumnoBean) {
		
		PersonaBean prmPersona = new PersonaBean();
		boolean sw = false;

		
		try {
			if (alumnoBean.getCodigo() == 0) {
				prmPersona = alumnoBean.getPersonaBean();
				
				prmPersona = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona);
				
				if(prmPersona==null){
					prmPersona= alumnoBean.getPersonaBean();
					
					prmPersona.setCodigoUbigeo(alumnoBean.getUbigeoBean().getCodigoRegion()+alumnoBean.getUbigeoBean().getCodigoProvincia()+alumnoBean.getUbigeoBean().getCodigoDistrito());

					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
					
					if(alumnoBean.getPersonaBean().getStrFechaNac()!=null){
						Date fechaConFormato = sdf.parse(alumnoBean.getPersonaBean().getStrFechaNac().toString()); 
//						
						prmPersona.setFechaNac(fechaConFormato);
						
					}
					sw = (this.getPersonaService().insertar(prmPersona));
					
				}
				
				alumnoBean.setAudCodigoUsuario(1);
				alumnoBean.setAudHostIP("192.168.1.1");
				sw =  (this.getAlumnoService().insertar(alumnoBean));
				
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
				
				if(alumnoBean.getPersonaBean().getStrFechaNac()!=null){
					Date fechaConFormato = sdf.parse(alumnoBean.getPersonaBean().getStrFechaNac().toString()); 
					
					prmPersona.setFechaNac(fechaConFormato);
					alumnoBean.getPersonaBean().setFechaNac(prmPersona.getFechaNac());
					
				}
				
				alumnoBean.getPersonaBean().setCodigoUbigeo(alumnoBean.getUbigeoBean().getCodigoRegion()+alumnoBean.getUbigeoBean().getCodigoProvincia()+alumnoBean.getUbigeoBean().getCodigoDistrito());
				alumnoBean.getInstitucionBean().getUbigeoBean().setCodigoUbigeo(alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoRegion()+alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoProvincia()+alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoDistrito());
				
				alumnoBean.setAudCodigoUsuario(1);
				alumnoBean.setAudHostIP("192.168.1.140");

				sw =  (this.getAlumnoService().actualizar(alumnoBean));

			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			alumnoBean = new AlumnoBean() ;
			//return this.getLista(alumnoBean);
			ModelAndView mav = this.getLista(alumnoBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("academico/listado-alumno", "command",alumnoBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		}

	}

	private ModelAndView getLista(AlumnoBean alumnoBean) {
		//List<AlumnoBean> lstAlumnoBean = null
		List<AlumnoBean> lstAlumnoBean = new ArrayList<AlumnoBean>();
		try {
			//modificar despues
			lstAlumnoBean = (List<AlumnoBean>) this.getAlumnoService().getBuscarPorFiltros(alumnoBean);
			
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView("academico/listado-alumno", "command",alumnoBean);
		System.out.println("lstAlumnoBean "+lstAlumnoBean);
		mav.addObject("lstAlumnoBean", lstAlumnoBean);
		this.cargarUbigeoIntitucion(mav, null);
		this.cargarUbigeo(mav,null);
		this.cargarCombos(mav);
		return mav;
	}
	
	private void cargarUbigeo(ModelAndView mav,AlumnoBean alumnoBean){

		ubigeoBean = new UbigeoBean();
		if(alumnoBean!=null){
			ubigeoBean = alumnoBean.getUbigeoBean();
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
	
	private void cargarUbigeoIntitucion(ModelAndView mav,AlumnoBean alumnoBean){
		
		ubigeoBeanIntitucion = new UbigeoBean();
		if(alumnoBean!=null){
			ubigeoBeanIntitucion = alumnoBean.getInstitucionBean().getUbigeoBean();
		}
		
		try {
			lstRegionInstitucion = this.getUbigeoService().listarRegion();
			lstProvinciaInstitucion = this.getUbigeoService().listarProvincia(ubigeoBeanIntitucion);
			lstDistritoInstitucion = this.getUbigeoService().listarDistrito(ubigeoBeanIntitucion);
			
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}		
	
		
		mav.addObject("lstRegionInstitucion",lstRegionInstitucion); 
		mav.addObject("lstProvinciaInstitucion",lstProvinciaInstitucion);
		mav.addObject("lstDistritoInstitucion",lstDistritoInstitucion); 
	}
	
	private void cargarCombos(ModelAndView mav){

		InstitucionBean inst = new InstitucionBean();
		LenguaBean lenguaBean = new LenguaBean();
		ubigeoBean = new UbigeoBean();
		
		if (lstSituacion==null){
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionAlumno");
				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento");
				lstNacionalidad = maestra2Service.listarPorCodigoTabla("nacionalidad");
				lstSexo = maestra2Service.listarPorCodigoTabla("sexo");
				lstInstitucionBean = institucionService.getListarCombo(inst);
				lstLenguaBean = (List<LenguaBean>) this.lenguaService.getBuscarPorFiltros(lenguaBean);
				lstNivel = maestra2Service.listarPorCodigoTabla("nivelAlumno");
				//lstGrado = maestra2Service.listarPorCodigoTabla("gradoAlumno");
				lstCarrera = maestra2Service.listarPorCodigoTabla("carreraAlumno");
				
				
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstTipoDocumento",lstTipoDocumento); 
		mav.addObject("lstNacionalidad",lstNacionalidad);
		mav.addObject("lstSexo",lstSexo); 
		mav.addObject("lstInstitucionBean",lstInstitucionBean); 
		mav.addObject("lstLenguaBean",lstLenguaBean); 
		
		mav.addObject("lstNivel",lstNivel); 
		mav.addObject("lstGrado",lstGrado); 
		mav.addObject("lstCarrera",lstCarrera); 
		
	}
	
	@RequestMapping(value = "/buscarGrado", method = RequestMethod.GET)
	public @ResponseBody  List<MaestraBean> doBuscarGrado(@RequestParam("codigonivel") String codigo)throws Exception {
		List<MaestraBean> prmGrado = new ArrayList<MaestraBean>();
			if (codigo.equals("1")) {
				prmGrado = maestra2Service.listarPorCodigoTabla("gradoAlumno");
			}else if(codigo.equals("2")){
				prmGrado = maestra2Service.listarPorCodigoTabla("gradoAlumnoSecundaria");
			}
		return prmGrado;
	}
	

	@RequestMapping(value = "/validaralumno", method = RequestMethod.POST)
	public @ResponseBody AlumnoBean validarAlumno(@RequestParam("numerodocumento") String numeroDocumento) {
		
		AlumnoBean alumnoBean2 = new AlumnoBean();
		alumnoBean2.getPersonaBean().setNumeroDocumento(numeroDocumento);
		AlumnoBean alum = new AlumnoBean();
		lstAlumnoBean = new ArrayList<AlumnoBean>();
		try {
			lstAlumnoBean = (List<AlumnoBean>) this.getAlumnoService().getBuscarPorFiltros(alumnoBean2);
			
			if(lstAlumnoBean!=null){
				
				alum = this.getAlumnoService().getBuscarPorObjecto(lstAlumnoBean.get(0));
				
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return alum;

	}
	
	public PersonaService getPersonaService() {
		return personaService;
	}
	
	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}
	public AlumnoBean getAlumnoBean() {
		return alumnoBean;
	}

	public void setAlumnoBean(AlumnoBean alumnoBean) {
		this.alumnoBean = alumnoBean;
	}

	public List<AlumnoBean> getLstAlumnoBean() {
		return lstAlumnoBean;
	}

	public void setLstAlumnoBean(List<AlumnoBean> lstAlumnoBean) {
		this.lstAlumnoBean = lstAlumnoBean;
	}

	public AlumnoService getAlumnoService() {
		return alumnoService;
	}

	public void setAlumnoService(AlumnoService alumnoService) {
		this.alumnoService = alumnoService;
	}

	public UbigeoService getUbigeoService() {
		return ubigeoService;
	}
	public void setUbigeoService(UbigeoService ubigeoService) {
		this.ubigeoService = ubigeoService;
	}
	
	public void setValoresPredeterminados(AlumnoBean alumnoBean){
		alumnoBean.setCodigo(0);
		alumnoBean.setPersonaBean(new PersonaBean());
		alumnoBean.getPersonaBean().setNombrePersona(""); 
		alumnoBean.setTm1Situacion(new MaestraBean());
		alumnoBean.getTm1Situacion().setCodigoRegistro(0);
	 }
	
}
*/