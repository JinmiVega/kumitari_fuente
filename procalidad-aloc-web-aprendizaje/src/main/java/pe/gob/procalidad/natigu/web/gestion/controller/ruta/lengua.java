package pe.gob.procalidad.natigu.web.gestion.controller.ruta;

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
import pe.gob.procalidad.natigu.core.bean.bean.generico.LeccionMaterialBean;
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
@RequestMapping(value = "rutalengua")
public class lengua extends BaseController {

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
	
	public static final String nombre_ruta = "";
	public static final String parametro_ruta = "";
	
	public lengua (){
		//lstSituacion = null;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		ModelAndView mav = new ModelAndView("lengua/inicio", "command",new AlumnoBean());
		mav.addObject("alumnoBean", new AlumnoBean());
		return mav;
	}

	@RequestMapping(value = "/quechua", method = RequestMethod.GET)
	public ModelAndView doQuechua() {
		ModelAndView mav = new ModelAndView("lengua/quechua", "command",new AlumnoBean());
		mav.addObject("alumnoBean", new AlumnoBean());
		return mav;
	}
	
	@RequestMapping(value = "/quechua/basico/b1", method = RequestMethod.GET)
	public ModelAndView doBasico() {
		ModelAndView mav = new ModelAndView("lengua/basico", "command",new AlumnoBean());
		mav.addObject("alumnoBean", new AlumnoBean());
		return mav;
	}	

	@RequestMapping(value = "/quechua/basico/b1/u1", method = RequestMethod.GET)
	public ModelAndView doUnidad() {
		ModelAndView mav = new ModelAndView("lengua/unidad", "command",new AlumnoBean());
		mav.addObject("alumnoBean", new AlumnoBean());
		return mav;
	}	

	@RequestMapping(value = "/quechua/basico/b1/u1/l1", method = RequestMethod.GET)
	public ModelAndView doLeccion() {
		ModelAndView mav = new ModelAndView("lengua/leccion", "command",new AlumnoBean());
		mav.addObject("alumnoBean", new AlumnoBean());
		return mav;
	}	


	@RequestMapping(value = "/lengua/entrenamiento", method = RequestMethod.GET)
	public ModelAndView doEntrenamiento() {
		ModelAndView mav = new ModelAndView("entrenamiento/entrenamiento-lecciones", "command",new AlumnoBean());
		mav.addObject("alumnoBean", new AlumnoBean());
		return mav;
	}
	
	@RequestMapping(value = "/quechua/intro", method = RequestMethod.GET)
	public ModelAndView doIntro() {
		ModelAndView mav = new ModelAndView("lengua/intro", "command",new AlumnoBean());
		mav.addObject("alumnoBean", new AlumnoBean());
		return mav;
	}
	
	@RequestMapping(value = "/ejercicio-01", method = RequestMethod.GET)
	public ModelAndView doejercicio1() {
		ModelAndView mav = new ModelAndView("ejercicios/ejercicio-01", "command",new AlumnoBean());
		mav.addObject("alumnoBean", new AlumnoBean());
		return mav;
	}
	
	@RequestMapping(value = "/ejercicio-02", method = RequestMethod.GET)
	public ModelAndView doejercicio2() {
		ModelAndView mav = new ModelAndView("ejercicios/ejercicio-02", "command",new AlumnoBean());
		mav.addObject("alumnoBean", new AlumnoBean());
		return mav;
	}
	
	@RequestMapping(value = "/ejercicio-03", method = RequestMethod.GET)
	public ModelAndView doejercicio3() {
		ModelAndView mav = new ModelAndView("ejercicios/ejercicio-03", "command",new AlumnoBean());
		mav.addObject("alumnoBean", new AlumnoBean());
		return mav;
	}
	
	@RequestMapping(value = "/ejercicio-04", method = RequestMethod.GET)
	public ModelAndView doejercicio4() {
		ModelAndView mav = new ModelAndView("ejercicios/ejercicio-04", "command",new AlumnoBean());
		mav.addObject("alumnoBean", new AlumnoBean());
		return mav;
	}
	
	@RequestMapping(value = "/material-01", method = RequestMethod.GET)
	public ModelAndView doMaterial01() {
		LeccionMaterialBean prmLeccionMaterialBean = new LeccionMaterialBean();
		prmLeccionMaterialBean.setCodigo(41);
		prmLeccionMaterialBean.setDescripcionMaterial("Kay taqapiqa llaqtayta riqsisunchik");
		prmLeccionMaterialBean.setContexto("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod \n"+
										   "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, \n"+
										   "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo \n"+
										   "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse \n"+
										   "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non \n"+
										   "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		prmLeccionMaterialBean.setNombreImagen("U1_07.JPG");
		prmLeccionMaterialBean.setRutaAudio("U1_L2_02.WAV");
		ModelAndView mav = new ModelAndView("material/material-01", "command",prmLeccionMaterialBean);
		mav.addObject("material", prmLeccionMaterialBean);
		return mav;
	}
	
	@RequestMapping(value = "/material-02", method = RequestMethod.GET)
	public ModelAndView doMaterial02() {
		LeccionMaterialBean prmLeccionMaterialBean = new LeccionMaterialBean();
		prmLeccionMaterialBean.setCodigo(41);
		prmLeccionMaterialBean.setDescripcionMaterial("Kay taqapiqa llaqtayta riqsisunchik");
		prmLeccionMaterialBean.setContexto("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod \n"+
										   "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, \n"+
										   "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo \n"+
										   "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse \n"+
										   "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non \n"+
										   "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		ModelAndView mav = new ModelAndView("material/material-02", "command",prmLeccionMaterialBean);
		mav.addObject("material", prmLeccionMaterialBean);
		return mav;
	}
	
}