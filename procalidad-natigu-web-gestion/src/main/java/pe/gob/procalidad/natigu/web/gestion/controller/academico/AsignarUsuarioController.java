package pe.gob.procalidad.natigu.web.gestion.controller.academico;

import java.util.ArrayList;
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

import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EspecialidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.MatriculaAlumnoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.MatriculaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.UsuarioMatriculaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
 
@Controller
@Scope(value="session")
@RequestMapping(value = "asignarUsuarioController")
public class AsignarUsuarioController extends BaseController {

	private UsuarioMatriculaBean usuarioMatriculaBean;
	
	private List<MaestraBean>	lstSituacion;
	private LenguaBean 			lenguaBean;
	private List<LenguaBean> 	lstLenguaBean;
	private List<MatriculaAlumnoBean> lstMatriculaAlumnoBean;
	private List<InstitucionBean> lstInstitucion;
	
	@Autowired
	private InstitucionService 		institucionService;
	
	@Autowired
	private LenguaService 		lenguaService;
	
	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private UsuarioMatriculaService usuarioMatriculaService;
	
	@Autowired
	private MatriculaAlumnoService matriculaAlumnoService;
	
	@Autowired
	private Maestra1Service maestra1Service;
	
	public AsignarUsuarioController (){
		
		
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("usuarioMatriculaBean") UsuarioMatriculaBean usuarioMatriculaBean)throws Exception {
		UsuarioMatriculaBean prmusuarioMatriculaBean = new UsuarioMatriculaBean();
		
		
		
		if(usuarioMatriculaBean != null){
			prmusuarioMatriculaBean = usuarioMatriculaBean;
		}
		
//		prmMatriculaBean.setNombre("");
		return this.getLista(prmusuarioMatriculaBean);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("usuarioMatriculaBean") UsuarioMatriculaBean usuarioMatriculaBean)
			throws Exception {
		return this.getLista(usuarioMatriculaBean);
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("general/registro-lengua", "command",new LenguaBean());
//		mav.addObject("lstSituacion",lstSituacion);
//		mav.addObject("lenguaBean", new LenguaBean());
		return mav;
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {

		System.out.println("codigo " + codigo);

		LenguaBean prmLenguaBean = new LenguaBean();
		prmLenguaBean.setCodigo(1);

		ModelAndView mav = new ModelAndView("lengua_registro", "command",
				prmLenguaBean);

		return mav;
	}

//	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
//	public ModelAndView doGrabar(@ModelAttribute("usuarioMatriculaBean") UsuarioMatriculaBean usuarioMatriculaBean) {
//		
//		System.out.println("lenguaBean"+lenguaBean);
//		
//		boolean sw = false;
//		try {
//			if (lenguaBean.getCodigo()==0) {
//				sw =  (this.getLenguaService().insertar(lenguaBean)); 
//			} else {
//				sw = (this.getLenguaService().actualizar(lenguaBean));
//			}
//
//		} catch (Exception e) { 
//			e.printStackTrace();
//		}
//
//		if (sw) {
//			lenguaBean = new LenguaBean() ;
//			return this.getLista(usuarioMatriculaBean);
//		} else {
//			ModelAndView mav = new ModelAndView("general/registro-lengua", "command",lenguaBean);
//			return mav;
//		}
//
//	}
	
	
	@RequestMapping(value = "/asignarusuario", method = RequestMethod.GET)
	public ModelAndView doAsignarUsuario(@RequestParam("codigoalumno") Integer codigoalumno, @RequestParam("codigoinst") Integer codigoInst) {
		
//		System.out.println("lenguaBean"+lenguaBean);
		usuarioMatriculaBean = new UsuarioMatriculaBean();
		usuarioMatriculaBean.getAlumnoBean().setCodigo(codigoalumno);
		usuarioMatriculaBean.setAudCodigoUsuario(Long.valueOf(1));
		usuarioMatriculaBean.setAudHostIP("192.168.1.1");
	
	
		boolean sw = false;
		try {
//			if (lenguaBean.getCodigo()==0) {
//				sw =  (this.getLenguausuService().insertar(lenguaBean)); 
//			} else {
				sw = (this.usuarioMatriculaService.asignarUsuario(usuarioMatriculaBean));
//			}

		} catch (Exception e) { 
			e.printStackTrace();
		}
		

		if (sw) {
			usuarioMatriculaBean = new UsuarioMatriculaBean() ;
			usuarioMatriculaBean.getInscripcionLenguaBean().getInscripcionBean().getInstitucion().setCodigo(codigoInst);
			return this.getLista(usuarioMatriculaBean);
		} else {
			ModelAndView mav = new ModelAndView("academico/asignar-usuario", "command",usuarioMatriculaBean);
			return mav;
		}

	}

	
	
	@RequestMapping(value ="/bajausuarioasignado", method = RequestMethod.GET)
	public @ResponseBody String  bajaUsuarioAsignado(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		String data="";
		UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
		
		usuarioMatriculaBean.setCodigo(codigo);
		//usuarioMatriculaBean.setAudCodigoUsuario(Long.valueOf(1));
		//usuarioMatriculaBean.setAudHostIP("192.168.1.1");
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
									this.setAuditoria(usuarioMatriculaBean, request, false);
				sw =  (this.usuarioMatriculaService.darBajaUsuarioMatricula(usuarioMatriculaBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		
	
		if(sw==true){
			data ="1";
		}else
		{
			data ="0";
			
		}
		return data;		
	}
	
	@RequestMapping(value = "/listadousuarios", method = RequestMethod.GET)
	public @ResponseBody List<UsuarioMatriculaBean> listadoUsuariosAlumnos(@RequestParam("codigoInst") int codigoInst, @RequestParam("situacion") int situacion, @RequestParam("codinscrlen") int codigoInscLen)throws Exception {
		usuarioMatriculaBean= new UsuarioMatriculaBean();
		List<UsuarioMatriculaBean> lstUsuarioMatricula =null;
//		List<MatriculaAlumnoBean> lstMatriculaAlumno =null;
//		MatriculaAlumnoBean matriculaAlumnoBean = new MatriculaAlumnoBean();
		usuarioMatriculaBean.getInscripcionLenguaBean().getInscripcionBean().getInstitucion().setCodigo(codigoInst);
		usuarioMatriculaBean.getSituacion().setCodigoRegistro(situacion);
		usuarioMatriculaBean.getInscripcionLenguaBean().setCodigo(codigoInscLen);
			lstUsuarioMatricula = (List<UsuarioMatriculaBean>) usuarioMatriculaService.getBuscarPorFiltros(usuarioMatriculaBean);
			if(lstUsuarioMatricula==null){
				lstUsuarioMatricula =new ArrayList<UsuarioMatriculaBean>();
			}
		
		
		return lstUsuarioMatricula;
	}
	
	@RequestMapping(value = "/recargarlistadousuarios", method = RequestMethod.GET)
	public ModelAndView recargarListadoxInscripcion(@RequestParam("codigoInst") int codigoInst, @RequestParam("situacion") int situacion, @RequestParam("codinscrlen") int codigoInscLen) {
		System.out.println("-------+recargarlistadousuarios+-------");
		System.out.println("codigoInst ::" + codigoInst);
		System.out.println("situacion ::" + situacion);
		System.out.println("codigoInscLen ::" + codigoInscLen);

		usuarioMatriculaBean= new UsuarioMatriculaBean();
		List<UsuarioMatriculaBean> lstUsuarioMatricula =null;
		usuarioMatriculaBean.getInscripcionLenguaBean().getInscripcionBean().getInstitucion().setCodigo(codigoInst);
		usuarioMatriculaBean.getSituacion().setCodigoRegistro(situacion);
		usuarioMatriculaBean.getInscripcionLenguaBean().setCodigo(codigoInscLen);
			try {
				lstUsuarioMatricula = (List<UsuarioMatriculaBean>) usuarioMatriculaService.getBuscarPorFiltros(usuarioMatriculaBean);
				System.out.println("lstUsuarioMatricula.size() :::" + lstUsuarioMatricula.size());
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(lstUsuarioMatricula==null){
				lstUsuarioMatricula =new ArrayList<UsuarioMatriculaBean>();
			}
			ModelAndView mav = new ModelAndView("academico/listado-detalle-matAlumno");
			mav.addObject("lstUsuarioMatricula",lstUsuarioMatricula); 
		return mav;
	}
	
	

	private ModelAndView getLista(UsuarioMatriculaBean usuarioMatriculaBean) {
		List<UsuarioMatriculaBean> lstUsuarioMatricula =null;
		List<MatriculaAlumnoBean> lstMatriculaAlumno =null;
		MatriculaAlumnoBean matriculaAlumnoBean = new MatriculaAlumnoBean();
		try {
			lstUsuarioMatricula = (List<UsuarioMatriculaBean>) usuarioMatriculaService.getBuscarPorFiltros(usuarioMatriculaBean);
			if(lstUsuarioMatricula==null){
				lstUsuarioMatricula =new ArrayList<UsuarioMatriculaBean>();
			}
			System.out.println("lstLenguaBean "+lstUsuarioMatricula.size());
			matriculaAlumnoBean.getMatriculaBean().getInsti().setCodigo(usuarioMatriculaBean.getInscripcionLenguaBean().getInscripcionBean().getInstitucion().getCodigo());
			lstMatriculaAlumno = (List<MatriculaAlumnoBean>) matriculaAlumnoService.listarAlumnosxMatricula(matriculaAlumnoBean);
			if(lstMatriculaAlumno==null){
				lstMatriculaAlumno=new ArrayList<MatriculaAlumnoBean>();
			}
//			for(int i =0 ;lstMatriculaAlumnoBean.size()){
//				
		
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}
//		usuarioMatriculaBean.getInscripcionBean().getInstitucion().setCodigo(1);
		ModelAndView mav = new ModelAndView("academico/asignar-usuario", "command",usuarioMatriculaBean);
		System.out.println("lstUsuarioMatricula "+lstUsuarioMatricula);
		mav.addObject("lstUsuarioMatricula", lstUsuarioMatricula);
		mav.addObject("lstMatriculaAlumno", lstMatriculaAlumno);
		cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
		
		usuarioMatriculaBean.setCodigo(codigo);
		usuarioMatriculaBean.setAudCodigoUsuario(Long.valueOf(1));
		usuarioMatriculaBean.setAudHostIP("192.168.1.1");
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
				sw =  (this.usuarioMatriculaService.eliminar(usuarioMatriculaBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		usuarioMatriculaBean.setCodigo(0);
//		this.setValoresPredeterminados(usuarioMatriculaBean);
		ModelAndView mav = this.getLista(usuarioMatriculaBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}
	
	
	
	
	@RequestMapping(value ="/buscaralumnosxinst", method = RequestMethod.GET)
	public @ResponseBody List<MatriculaAlumnoBean> buscarAlumnosXMatricula(@RequestParam("nombrealumno")String nombrealumno, @RequestParam("codigoinst")int codigoinst ,HttpServletRequest request){
		boolean sw=false;
		
		List<MatriculaAlumnoBean> lstMatriculaAlumno = new ArrayList<MatriculaAlumnoBean>();
		MatriculaAlumnoBean matriculaAlumnoBean = new MatriculaAlumnoBean();
		
		matriculaAlumnoBean.getAlumnoBean().getPersonaBean().setNombrePersona(nombrealumno);
		matriculaAlumnoBean.getMatriculaBean().getInsti().setCodigo(codigoinst);
		
		
		try {
			lstMatriculaAlumno = (List<MatriculaAlumnoBean>) matriculaAlumnoService.listarAlumnosxMatricula(matriculaAlumnoBean);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lstMatriculaAlumno==null){
			 lstMatriculaAlumno = new ArrayList<MatriculaAlumnoBean>();
		}

		return lstMatriculaAlumno;		
	}
	
	
	
	@RequestMapping(value ="/numerocupos", method = RequestMethod.GET)
	public @ResponseBody List<Integer> validarCupos(@RequestParam("codigoinst")int codigoinst ,HttpServletRequest request){
		boolean sw=false;
		
		List<UsuarioMatriculaBean> lstUsuarioMatricula = new ArrayList<UsuarioMatriculaBean>();
		UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
		
		
		usuarioMatriculaBean.getInscripcionLenguaBean().getInscripcionBean().getInstitucion().setCodigo(codigoinst);
		
		List<Integer> lstnumeros =new ArrayList<Integer>();
		
		int cuposTotal=0;
		int cuposAsignados=0;
		int cuposLibres=0;
		
		try {
			lstUsuarioMatricula = (List<UsuarioMatriculaBean>) usuarioMatriculaService.getBuscarPorFiltros(usuarioMatriculaBean);

				if(lstUsuarioMatricula!=null){
	
					cuposTotal=lstUsuarioMatricula.size();
					
						for(int i=0;i<lstUsuarioMatricula.size();i++){
							
							if(lstUsuarioMatricula.get(i).getSituacion().getCodigoRegistro()==1){
								
								cuposAsignados = cuposAsignados+1; 
								
							}
							
						}
					
					}
				
				cuposLibres=cuposTotal -cuposAsignados;
				
				lstnumeros.add(cuposTotal);
				lstnumeros.add(cuposAsignados);
				lstnumeros.add(cuposLibres);

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstnumeros;
		
	}
	
	
	
	private void cargarCombos(ModelAndView mav){
//		lstSituacion = new ArrayList<MaestraBean>();

		InstitucionBean institucionBean = new InstitucionBean();
		
		
//		LenguaBean lenguaBean = new LenguaBean();
		if (lstInstitucion==null) {
			try {
				lstInstitucion = (List<InstitucionBean>) this.getInstitucionService().getBuscarPorFiltros(institucionBean);
//				lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().getBuscarPorFiltros(this.especialidadBean);
//				lstLengua = (List<LenguaBean>) this.getLenguaService().getBuscarPorFiltros(lenguaBean);
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionasignarusuario",0);
//				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento");
//				lstNacionalidad = maestra2Service.listarPorCodigoTabla("nacionalidad");
//						lstGrado=  maestra2Service.listarPorCodigoTabla("grado");
//						lstCargo= maestra2Service.listarPorCodigoTabla("cargo");
//						lstSexo= maestra2Service.listarPorCodigoTabla("sexo");
//						lstCarrera =maestra2Service.listarPorCodigoTabla("carrera");
//						lstNivel = maestra2Service.listarPorCodigoTabla("nivel");
//				lstRegion = this.getUbigeoService().listarRegion();
//				lstProvincia = this.getUbigeoService().listarProvincia(ubigeoBean);
//				lstDistrito = this.getUbigeoService().listarDistrito(ubigeoBean);
				
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
//  
		mav.addObject("lstSituacion",lstSituacion); 
//		mav.addObject("lstTipoDocumento",lstTipoDocumento); 
//		mav.addObject("lstNacionalidad",lstNacionalidad); 
//		mav.addObject("lstGrado",lstGrado); 
//		mav.addObject("lstCargo",lstCargo); 
//		mav.addObject("lstSexo",lstSexo);
//		mav.addObject("lstCarrera",lstCarrera); 
//		mav.addObject("lstLengua",lstLengua); 
		mav.addObject("lstInstitucion",lstInstitucion); 
//		mav.addObject("lstNivel",lstNivel); 
//		mav.addObject("lstEspecialidad",lstEspecialidad);
//		mav.addObject("lstRegion",lstRegion); 
//		mav.addObject("lstProvincia",lstProvincia);
//		mav.addObject("lstDistrito",lstDistrito); 
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

	public InstitucionService getInstitucionService() {
		return institucionService;
	}

	public void setInstitucionService(InstitucionService institucionService) {
		this.institucionService = institucionService;
	}
 

}
