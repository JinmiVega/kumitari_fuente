package pe.gob.procalidad.natigu.web.gestion.controller.general;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMedallaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraDetBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraciBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.CargaMaterialBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LeccionMaterialBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionCabeceraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoMedallaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.RelacionService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;

@Controller
@Scope(value="session")
@RequestMapping(value = "cargaMaterialController")
public class CargaMaterialController  extends BaseController{
	
	private CargaMaterialBean 	cargaMaterialBean;
	
	private MaestraBean 		subNivel 		= new MaestraBean();
	private LenguaBean 			lengua 			= new LenguaBean();
	private MaestraBean 		situacion  		= new MaestraBean();
	private MaestraBean 		nivel 			= new MaestraBean();
	private MaestraBean 		unidad 			= new MaestraBean();
	private MaestraBean 		tipoEjercicio 	= new MaestraBean();
	private RelacionBean		relacion		= new RelacionBean();
	private RelacionCabeceraBean relacionCabeceraBean = new RelacionCabeceraBean();
	private UnidadLeccionBean 	leccion			= new UnidadLeccionBean();
	private LeccionMaterialBean material 		= new LeccionMaterialBean();
	private PreguntaBean 		pregunta 		= new PreguntaBean();
	
	private List<RelacionBean> lstRelacionBean;
	
	
	@Autowired
	private Maestra1Service 	maestra1Service;
	
	@Autowired
	private Maestra2Service 	maestra2Service;
	
	@Autowired
	private LenguaService 		lenguaService;
	
	@Autowired
	private RelacionService 	relacionService;
	
	/** MedallaPorAlumno **/
	@Autowired
	private AlumnoMedallaService alumnoMedallaService;
	
	private List<AlumnoMedallaBean> lstAlumnoMedallaBeans;
	

	public CargaMaterialController() 
	{

	}
	
	@PostConstruct
	public void init()
	{
		this.setCargaMaterialBean(new CargaMaterialBean());
		this.setLstAlumnoMedallaBeans(new ArrayList<AlumnoMedallaBean>());
	}


	@RequestMapping(value = "/ejercicio-04", method = RequestMethod.GET)
	private ModelAndView cargarContenido() 
	{
		RelacionBean relacionBean = new RelacionBean();
		relacionBean.setRelacionCabeceraBean(new RelacionCabeceraBean());
		relacionBean.getRelacionCabeceraBean().setCodigo(75);
		try {
			lstRelacionBean = relacionService.buscarPorRelacionCabecera(relacionBean);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		System.out.println("----------------------------------->");
		ModelAndView mav = new ModelAndView("ejercicios/ejercicio-04", "command", new CargaMaterialBean());
		mav.addObject("lstRelacionBean", lstRelacionBean);
		return mav;
	}
	/** Listar Medalla por alumno**/
	@RequestMapping(value = "/ListarAlumnoMedalla", method = RequestMethod.POST)
	@ResponseBody 
	public List<AlumnoMedallaBean> doListaAlumnoMedallaBean(@RequestParam("codLengua") Integer codLengua)
	{
		AlumnoMedallaBean  alumnoMedallaBean = new AlumnoMedallaBean ();
		alumnoMedallaBean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().setCodigo(codLengua);
		
		
		List<AlumnoMedallaBean> lstAlumnoMedallaBeans  = new ArrayList<AlumnoMedallaBean>();
		try{
			lstAlumnoMedallaBeans =  this.getAlumnoMedallaService().getBuscarPorFiltros(alumnoMedallaBean);
			
			if (lstAlumnoMedallaBeans != null && lstAlumnoMedallaBeans.size() >0) {
				
				System.out.println("--------------------------->"+ lstAlumnoMedallaBeans.size());
			}else{
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstAlumnoMedallaBeans;
	}	

	public CargaMaterialBean getCargaMaterialBean() {
		return cargaMaterialBean;
	}

	public void setCargaMaterialBean(CargaMaterialBean cargaMaterialBean) {
		this.cargaMaterialBean = cargaMaterialBean;
	}

	public List<RelacionBean> getLstRelacionBean() {
		return lstRelacionBean;
	}

	public void setLstRelacionBean(List<RelacionBean> lstRelacionBean) {
		this.lstRelacionBean = lstRelacionBean;
	}

	public AlumnoMedallaService getAlumnoMedallaService() {
		return alumnoMedallaService;
	}

	public void setAlumnoMedallaService(AlumnoMedallaService alumnoMedallaService) {
		this.alumnoMedallaService = alumnoMedallaService;
	}

	public List<AlumnoMedallaBean> getLstAlumnoMedallaBeans() {
		return lstAlumnoMedallaBeans;
	}

	public void setLstAlumnoMedallaBeans(List<AlumnoMedallaBean> lstAlumnoMedallaBeans) {
		this.lstAlumnoMedallaBeans = lstAlumnoMedallaBeans;
	}
	
}
