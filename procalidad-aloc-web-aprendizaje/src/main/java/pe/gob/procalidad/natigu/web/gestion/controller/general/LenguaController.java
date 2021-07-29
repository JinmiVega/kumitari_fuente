package pe.gob.procalidad.natigu.web.gestion.controller.general;
  
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView; 

import com.google.gson.Gson;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBonoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMedallaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionDetalleBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumIntentoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumnoEjerDetBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumnoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumnoLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
 
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMonedaGBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.GlosarioBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.IntentoConfiguracionBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MensajesBean; 
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean; 
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioConfiguracionBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.TraduccionBean; 
import pe.gob.procalidad.natigu.core.bean.bean.generico.AlterTextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.AlterTextoPalabraEncerradaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.AlternativaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.ArmarDocumentoBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.ArmarDocumentoCabBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraDetBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraciBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.CrucigramaDetBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LeccionMaterialBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionAlterBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionCompletarBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OrdenarParrafoBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionCabeceraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionVariadaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraEncerradaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.Encrypt; 
 





import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping(value = "lengua")
@SessionAttributes("usuarioEstudiante")
@Scope(value="session")
public class LenguaController extends BaseController {

	private LenguaBean 				lenguaBean;
	private LenguaEstructuraBean 	lenguaEstructuraBean;
	private LenguaEstructuraBean 	lenguaEstructuraMayorBean;
	private UnidadLeccionBean 		ultimaleccionxlenest;  
	private UnidadLeccionBean 		ultimaleccionxunidad; 
	private UnidadBean 				unidadBean;
	private UnidadLeccionBean		unidadLeccionBean;
	private LeccionMaterialBean		leccionMaterialBean;
	private GlosarioBean 			glosario;
	private EvaluacionBean			evaluacionBean;
	private List<LeccionMaterialBean>	lstMaterialBean;
	private List<MaterialTipoEjercicioBean> lstMaterialTipoEjBean;
	List<MensajesBean> lstMensajes = new ArrayList<MensajesBean>();
	private List<TraduccionBean> lstTraduccion = new ArrayList<TraduccionBean>();
	private int  posicionMaterial = 0;
	private boolean swEsUltimoEj = false;
	private int posEjercicio = 0;
	
	@PostConstruct
	public void init(){
		this.setLenguaBean(new LenguaBean());
		this.setLenguaEstructuraBean(new LenguaEstructuraBean());
		this.setUnidadBean(new UnidadBean());
		this.setUnidadLeccionBean(new UnidadLeccionBean());
		this.setLeccionMaterialBean(new LeccionMaterialBean());
		this.setEvaluacionBean(new EvaluacionBean());
	}
	
	
	@RequestMapping(value = "/detalle/{codigo}", method = RequestMethod.GET)
	public ModelAndView doLengua(@PathVariable("codigo") String codigoLengua, HttpServletRequest request) {
		
		List<LenguaEstructuraBean> lstLenguaEstructuraBeanSubNivel = null;
		List<List<?>> listaLenguaEstructura = new ArrayList<List<?>>();
		
		MascotaBean beanMascota= null;
		UsuarioMatriculaBean usuarioMatriBean =null;
		AlumnoMonedaGBean AlumnoMonedaGemaBean = null;
		GlosarioBean glosario = new GlosarioBean();
		MensajesBean mensajeExito = new MensajesBean();
		MensajesBean mensajeFallo = new MensajesBean();
		int swActivoMascotaAnim   = 0;
		
		UsuarioBean usuario = this.getUsuarioSesion(request);

		Encrypt.init("KEY_ENCRYPT_REL");
		
		try {
			/** OBTENER DATOS DE LA LENGUA **/
			LenguaBean prmLenguaBean = new LenguaBean();
			//prmLenguaBean.setCodigo(VO.toLong(codigoLengua));
			prmLenguaBean.setCodigo(VO.toLong(Encrypt.decrypt(codigoLengua.replace("$", "/"))));
			
			lenguaBean = this.fs.getLenguaService().getBuscarPorObjecto(prmLenguaBean);
			lenguaBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(lenguaBean.getCodigo())).replace("/", "$"));
			
			/** OBTENER USUARIO MATRICULA **/  
			usuarioMatriBean =  obtenerUsuarioMatricula((usuario.getCodigo()) ,(prmLenguaBean.getCodigo())); 
			/** OBTENER CODUSUARIOXMONEDASGEMAS **/ 
			if(!VO.isNull(usuarioMatriBean)){
				AlumnoMonedaGemaBean =  monedasGemasObtenidas(usuarioMatriBean.getCodigo());
			}
			
			/** OBTENER MASCOTA **/
			MascotaBean	prMascotaBean = new MascotaBean();
			prMascotaBean.setAudCodigoUsuario(usuario.getCodigoUsuario());
			beanMascota = this.fs.getMascotaService().getlistarMasctoSwPredetAlumno(prMascotaBean);
			
			swActivoMascotaAnim = (!VO.isNull(request.getSession().getAttribute("swActivoMascotaAnim"))) ? (Integer) request.getSession().getAttribute("swActivoMascotaAnim") : 0;
			 
			if (VO.isNotNull(beanMascota)) {
				System.out.println(" beanMascota.getImagenTienda() " + beanMascota.getImagenTienda());
			}
			
			/** OBTENER MENSAJES **/
			MensajesBean filtroMsj = new MensajesBean();
			filtroMsj.setLenguaBean(prmLenguaBean);
			lstMensajes = this.fs.getMensajeService().getBuscarPorFiltros(filtroMsj);
			
			/**Obtener Glosario**/
			GlosarioBean filtroGlosario = new GlosarioBean();
			filtroGlosario.setLenguaBean(prmLenguaBean);
			glosario = this.fs.getGlosarioService().getBuscarPorObjecto(filtroGlosario);
			
			/**Traducciones**/
			TraduccionBean filtroTraduccion = new TraduccionBean();
			filtroTraduccion.setLengua(prmLenguaBean);
			
			lstTraduccion = this.fs.getTraduccionService().getBuscarPorFiltros(filtroTraduccion);
			
			/** CARGAR LOS NIVELES Y SUBNIVELES **/
			if( usuario.getCodPerfilUsuSelec() == 4 ){ // ESTUDIANTE
				SeguimientoAlumnoLenguaBean filtro = new SeguimientoAlumnoLenguaBean(); 
				UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
				//unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getLenguaBean().setCodigo(Long.valueOf(codigoLengua));
				unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getLenguaBean().setCodigo(Long.valueOf(Encrypt.decrypt(codigoLengua.replace("$", "/"))));
				
				UsuarioMatriculaBean usuarioMatriculaBean  = new UsuarioMatriculaBean();
				usuarioMatriculaBean.setUsuarioBean(usuario);
				filtro.setUnidadLeccionBean(unidadLeccionBean);
				filtro.setUsuarioMatriculaBean(usuarioMatriculaBean);
				lstLenguaEstructuraBeanSubNivel = this.fs.getSeguimientoAlumnoLenguaService().listarSubNivel(filtro);
			}else{
				LenguaEstructuraBean filtro = new LenguaEstructuraBean();
				//filtro.getLenguaBean().setCodigo(VO.toLong(codigoLengua));
				filtro.getLenguaBean().setCodigo(VO.toLong(Encrypt.decrypt(codigoLengua.replace("$", "/"))));
				filtro.getNivel().setCodigoRegistro(0);
				lstLenguaEstructuraBeanSubNivel = this.fs.getLenguaEstructuraService().listarSubNiveles(filtro);
			}
			
			/*if(!VO.isEmptyList(lstLenguaEstructuraBeanSubNivel)){
				listaLenguaEstructura = VO.splitList(lstLenguaEstructuraBeanSubNivel, 3);
			}*/
			//Encriptar codigo
			for (LenguaEstructuraBean item : lstLenguaEstructuraBeanSubNivel) {
				item.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(item.getCodigo())).replace("/", "$"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		/***PagePerfil****/
		request.getSession().setAttribute("unidadLeccionBean", null);
		request.getSession().setAttribute("lenguaBean", lenguaBean);
		request.getSession().setAttribute("lenguaEstructuraBean", null);
		request.getSession().setAttribute("unidadBean", null);
		request.getSession().setAttribute("lstTraduccion", lstTraduccion);
		/***PagePerfil****/
		 
		ModelAndView mav = new ModelAndView("lengua/lengua", "command",lenguaBean);
		mav.addObject("lenguaBean", lenguaBean);
		mav.addObject("beanMascota", beanMascota);
		mav.addObject("listaLenguaEstructura", lstLenguaEstructuraBeanSubNivel);
		mav.addObject("usuarioMatriculaBean", usuarioMatriBean);
		mav.addObject("alumnoMonedaGBean", AlumnoMonedaGemaBean);
		mav.addObject("glosarioBean", glosario);
		mav.addObject("lstMensajes",lstMensajes);
		mav.addObject("swActivoMascotaAnim",swActivoMascotaAnim);
		mav.addObject("lstTraduccion", lstTraduccion);
		posicionMaterial = 0;
		swEsUltimoEj = false;
		posEjercicio = 0;
		return mav;
	}
	
	@RequestMapping(value = "/detalle/{codlengua}/nivel/{codlenest}", method = RequestMethod.GET)
	public ModelAndView cargarUnidades(	@PathVariable("codlengua") String codlengua,
										@PathVariable("codlenest") String codigoLE, 
										HttpServletRequest request) {
		
		List<UnidadBean> lstUnidadBean = null;
		List<List<?>> listaUnidad = new ArrayList<List<?>>();
		UsuarioBean usuario = this.getUsuarioSesion(request);
		MascotaBean beanMascota= null;
		EvaluacionBean evaluacionBean = null;
		UsuarioMatriculaBean usuarioMatriBean =null;
		AlumnoMonedaGBean AlumnoMonedaGemaBean = null;
		int swActivoMascotaAnim = 0;

		Encrypt.init("KEY_ENCRYPT_REL");
		
		try {
			/** OBTENER DATOS DE LA ESTRUCTURA DE LA LENGUA (NIVEL - SUBNIVEL) **/
			LenguaEstructuraBean prmLenguaEstBean = new LenguaEstructuraBean();
			//prmLenguaEstBean.setCodigo(VO.toLong(codigoLE));
			prmLenguaEstBean.setCodigo(VO.toLong(Encrypt.decrypt(codigoLE.replace("$", "/"))));
			lenguaEstructuraBean = this.fs.getLenguaEstructuraService().getBuscarPorObjecto(prmLenguaEstBean);
			lenguaEstructuraBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(lenguaEstructuraBean.getCodigo())).replace("/", "$"));
			
			/** OBTENER DATOS DE LA LENGUA **/
			LenguaBean prmLenguaBean = new LenguaBean();
			//prmLenguaBean.setCodigo(VO.toLong(codlengua));
			prmLenguaBean.setCodigo(VO.toLong(Encrypt.decrypt(codlengua.replace("$", "/"))));
			lenguaBean = this.fs.getLenguaService().getBuscarPorObjecto(prmLenguaBean);
			lenguaBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(lenguaBean.getCodigo())).replace("/", "$"));


			/** OBTENER DATOS DE LA ESTRUCTURA DE LA LENGUA (MAYOR) **/
			LenguaEstructuraBean prmLenguaEstMayorBean = new LenguaEstructuraBean();
			//prmLenguaEstMayorBean.getLenguaBean().setCodigo(VO.toLong(codlengua));
			prmLenguaEstMayorBean.getLenguaBean().setCodigo(VO.toLong(Encrypt.decrypt(codlengua.replace("$", "/"))));
			prmLenguaEstMayorBean.getNivel().setCodigoRegistro(lenguaEstructuraBean.getNivel().getCodigoRegistro());
			lenguaEstructuraMayorBean = this.fs.getLenguaEstructuraService().getBuscarMayorSubnivel(prmLenguaEstMayorBean);
			
			
			/** OBTENER USUARIO MATRICULA **/  
			usuarioMatriBean =  obtenerUsuarioMatricula((usuario.getCodigo()) ,(prmLenguaBean.getCodigo())); 
			/** SI EXISTE MATRICULA **/ 
			if(!VO.isNull(usuarioMatriBean)){
				/** OBTENER CODUSUARIOXMONEDASGEMAS **/
				AlumnoMonedaGemaBean =  monedasGemasObtenidas(usuarioMatriBean.getCodigo());
				
				/** OBTENER EVALUACION **/
				EvaluacionBean oEvaluacionBean = new EvaluacionBean();
				
				oEvaluacionBean.getUsuarioMatriculaBean().setCodigo(usuarioMatriBean.getCodigo());
				oEvaluacionBean.getSubNivel().setCodigoRegistro(lenguaEstructuraBean.getSubNivel().getCodigoRegistro());
				//oEvaluacionBean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().setCodigo(VO.toLong(codlengua));
				oEvaluacionBean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().setCodigo(VO.toLong(Encrypt.decrypt(codlengua.replace("$", "/"))));
				oEvaluacionBean.getSituacionEvaluacion().setCodigoRegistro(1);
				
				evaluacionBean = new EvaluacionBean();
				
				evaluacionBean = this.fs.getEvaluacionService().iniciarEvaluacion(oEvaluacionBean);
				if (VO.isNotNull(evaluacionBean)) {
					evaluacionBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(evaluacionBean.getCodigo())).replace("/", "$"));
					System.out.println(" evaluacionBean.getCodigo() " + evaluacionBean.getCodigo());
				}
			}
			
			/** OBTENER MENSAJES **/
			MensajesBean filtroMsj = new MensajesBean();
			filtroMsj.setLenguaBean(prmLenguaBean);
			lstMensajes = this.fs.getMensajeService().getBuscarPorFiltros(filtroMsj);
			
			/** OBTENER MASCOTA **/
			MascotaBean	prMascotaBean = new MascotaBean();
			prMascotaBean.setAudCodigoUsuario(usuario.getCodigoUsuario());
			beanMascota = this.fs.getMascotaService().getlistarMasctoSwPredetAlumno(prMascotaBean);
			
			swActivoMascotaAnim = (!VO.isNull(request.getSession().getAttribute("swActivoMascotaAnim"))) ? (Integer) request.getSession().getAttribute("swActivoMascotaAnim") : 0;
			
			if (VO.isNotNull(beanMascota)) {
				System.out.println(" beanMascota.getImagenTienda() " + beanMascota.getImagenTienda());
			}
			
			/** CARGAR LAS UNIDADES **/
			if( usuario.getCodPerfilUsuSelec() == 4 ){ // ESTUDIANTE
				
				SeguimientoAlumnoLenguaBean filtro = new SeguimientoAlumnoLenguaBean(); 
				UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
				//unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getLenguaBean().setCodigo(Long.valueOf(codlengua));
				unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getLenguaBean().setCodigo(Long.valueOf(Encrypt.decrypt(codlengua.replace("$", "/"))));
				//unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().setCodigo(Long.valueOf(codigoLE));
				unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().setCodigo(Long.valueOf(Encrypt.decrypt(codigoLE.replace("$", "/"))));
				UsuarioMatriculaBean usuarioMatriculaBean  = new UsuarioMatriculaBean();
				usuarioMatriculaBean.setUsuarioBean(usuario);
				filtro.setUnidadLeccionBean(unidadLeccionBean);
				filtro.setUsuarioMatriculaBean(usuarioMatriculaBean);
				lstUnidadBean = this.fs.getSeguimientoAlumnoLenguaService().listarUnidad(filtro);
				
				
			}else{
				UnidadBean filtro = new UnidadBean();
				//filtro.getLenguaEstructuraBean().setCodigo(VO.toLong(codigoLE));
				filtro.getLenguaEstructuraBean().setCodigo(VO.toLong(Encrypt.decrypt(codigoLE.replace("$", "/"))));
				lstUnidadBean = this.fs.getUnidadService().getBuscarPorFiltros(filtro);
			}
			
			if(!VO.isEmptyList(lstUnidadBean)){
				for (UnidadBean objUnidad : lstUnidadBean) {
					if(!VO.isEmpty(objUnidad.getDescripcion())){
						if(objUnidad.getDescripcion().length()>90){
							objUnidad.setDescripcion(objUnidad.getDescripcion().substring(0, 90) + "...");
						}
					}
					objUnidad.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(objUnidad.getCodigo())).replace("/", "$"));
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/***PagePerfil****/
		request.getSession().setAttribute("unidadLeccionBean", null);
		request.getSession().setAttribute("lenguaBean", lenguaBean);
		request.getSession().setAttribute("lenguaEstructuraBean", lenguaEstructuraBean);
		request.getSession().setAttribute("unidadBean", null);
		/***PagePerfil****/
		
		lstTraduccion = (List<TraduccionBean>)request.getSession().getAttribute("lstTraduccion");
		
		ModelAndView mav = new ModelAndView("lengua/basico", "command",lenguaEstructuraBean);
		mav.addObject("lenguaEstructuraBean", lenguaEstructuraBean);
		mav.addObject("lenguaEstructuraMayorBean", lenguaEstructuraMayorBean);
		mav.addObject("listaUnidad", lstUnidadBean);
		mav.addObject("lenguaBean", lenguaBean);
		mav.addObject("beanMascota", beanMascota);
		mav.addObject("usuarioMatriculaBean", usuarioMatriBean);
		mav.addObject("alumnoMonedaGBean", AlumnoMonedaGemaBean);
		mav.addObject("evaluacionBean", evaluacionBean);
		mav.addObject("swActivoMascotaAnim", swActivoMascotaAnim);
		mav.addObject("lstTraduccion", lstTraduccion);
		mav.addObject("lstMensajes", lstMensajes);
		
		posicionMaterial = 0;
		swEsUltimoEj = false;
		posEjercicio = 0;
		return mav;
	}
	
	
		
	@RequestMapping(value = "/detalle/{codlengua}/nivel/{codlenest}/unidad/{codunidad}", method = RequestMethod.GET)
	public ModelAndView cargarLecciones(@PathVariable("codlengua") String codlengua,
										@PathVariable("codlenest") String codigoLE,
										@PathVariable("codunidad") String codigoUnidad,
										HttpServletRequest request) {
		
		List<UnidadLeccionBean> lstUnidadLeccionBean = null;
		List<List<?>> listaUnidadLeccion = new ArrayList<List<?>>();
		//System.out.println("cargarLecciones codlengua " + codlengua +	"codigoLE " + codigoLE + 	"codigoUnidad " + codigoUnidad );
		UsuarioBean usuario = this.getUsuarioSesion(request);
		MascotaBean beanMascota= null;
		UsuarioMatriculaBean usuarioMatriBean =null;
		AlumnoMonedaGBean AlumnoMonedaGemaBean = null;
		int swActivoMascotaAnim = 0;

		Encrypt.init("KEY_ENCRYPT_REL");
		
		try {
			/** OBTENER DATOS DE LA UNIDAD **/
			UnidadBean prmUnidadBean = new UnidadBean();
//			prmUnidadBean.setCodigo(VO.toLong(codigoUnidad));
			prmUnidadBean.setCodigo(VO.toLong(Encrypt.decrypt(codigoUnidad.replace("$", "/"))));
			unidadBean = this.fs.getUnidadService().getBuscarPorObjecto(prmUnidadBean);
			unidadBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(unidadBean.getCodigo())).replace("/", "$"));
			
			/** OBTENER DATOS DE LA ESTRUCTURA DE LA LENGUA (NIVEL - SUBNIVEL) **/
			LenguaEstructuraBean prmLenguaEstBean = new LenguaEstructuraBean();
//			prmLenguaEstBean.setCodigo(VO.toLong(codigoLE));
			prmLenguaEstBean.setCodigo(VO.toLong(Encrypt.decrypt(codigoLE.replace("$", "/"))));
			lenguaEstructuraBean = this.fs.getLenguaEstructuraService().getBuscarPorObjecto(prmLenguaEstBean);
			lenguaEstructuraBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(lenguaEstructuraBean.getCodigo())).replace("/", "$"));
			
			/** OBTENER DATOS DE LA LENGUA **/
			LenguaBean prmLenguaBean = new LenguaBean();
//			prmLenguaBean.setCodigo(VO.toLong(codlengua));
			prmLenguaBean.setCodigo(VO.toLong(Encrypt.decrypt(codlengua.replace("$", "/"))));
			lenguaBean = this.fs.getLenguaService().getBuscarPorObjecto(prmLenguaBean);
			lenguaBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(lenguaBean.getCodigo())).replace("/", "$"));
			
			/** OBTENER USUARIO MATRICULA **/  
			usuarioMatriBean =  obtenerUsuarioMatricula((usuario.getCodigo()) ,(prmLenguaBean.getCodigo())); 
			/** OBTENER CODUSUARIOXMONEDASGEMAS **/ 
			if(!VO.isNull(usuarioMatriBean)){
				AlumnoMonedaGemaBean =  monedasGemasObtenidas(usuarioMatriBean.getCodigo());
			}
			
			/** OBTENER MASCOTA **/
			MascotaBean	prMascotaBean = new MascotaBean();
			prMascotaBean.setAudCodigoUsuario(usuario.getCodigoUsuario());
			beanMascota = this.fs.getMascotaService().getlistarMasctoSwPredetAlumno(prMascotaBean);
			
			swActivoMascotaAnim = (!VO.isNull(request.getSession().getAttribute("swActivoMascotaAnim"))) ? (Integer) request.getSession().getAttribute("swActivoMascotaAnim") : 0;
			
			if (VO.isNotNull(beanMascota)) {
				System.out.println(" beanMascota.getImagenTienda() " + beanMascota.getImagenTienda());
			}
			
			/** CARGAR LAS LECCIONES **/
			if( usuario.getCodPerfilUsuSelec() == 4 ){ // ESTUDIANTE
				SeguimientoAlumnoLenguaBean filtro = new SeguimientoAlumnoLenguaBean(); 
				UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
//				unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getLenguaBean().setCodigo(Long.valueOf(codlengua));
				unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getLenguaBean().setCodigo(Long.valueOf(Encrypt.decrypt(codlengua.replace("$", "/"))));
//				unidadLeccionBean.getUnidadBean().setCodigo(Long.valueOf(codigoUnidad));
				unidadLeccionBean.getUnidadBean().setCodigo(Long.valueOf(Encrypt.decrypt(codigoUnidad.replace("$", "/"))));
				UsuarioMatriculaBean usuarioMatriculaBean  = new UsuarioMatriculaBean();
				usuarioMatriculaBean.setUsuarioBean(usuario);
				filtro.setUnidadLeccionBean(unidadLeccionBean);
				filtro.setUsuarioMatriculaBean(usuarioMatriculaBean);
				lstUnidadLeccionBean = this.fs.getSeguimientoAlumnoLenguaService().listarLeccion(filtro);
				 
			}else{
				UnidadBean filtro = new UnidadBean();
//				filtro.setCodigo(VO.toLong(codigoUnidad));
				filtro.setCodigo(VO.toLong(Encrypt.decrypt(codigoUnidad.replace("$", "/"))));
				lstUnidadLeccionBean = this.fs.getUnidadLeccionService().listarPorUnidad(filtro);
			}
			
			for (UnidadLeccionBean item : lstUnidadLeccionBean) {
				item.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(item.getCodigo())).replace("/", "$"));
			}
			/*
			if(!VO.isEmptyList(lstUnidadLeccionBean)){
				listaUnidadLeccion = VO.splitList(lstUnidadLeccionBean, 2);
			}
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/***PagePerfil****/
		request.getSession().setAttribute("unidadLeccionBean", null);
		request.getSession().setAttribute("lenguaBean", lenguaBean);
		request.getSession().setAttribute("lenguaEstructuraBean", lenguaEstructuraBean);
		request.getSession().setAttribute("unidadBean", unidadBean);
		/***PagePerfil****/
		
		lstTraduccion = (List<TraduccionBean>)request.getSession().getAttribute("lstTraduccion");
		
		ModelAndView mav = new ModelAndView("lengua/unidad", "command",unidadBean);
		mav.addObject("unidadBean", unidadBean);
		mav.addObject("listaLeccion", lstUnidadLeccionBean);
		mav.addObject("lenguaBean", lenguaBean);
		mav.addObject("beanMascota", beanMascota);
		mav.addObject("lenguaEstructuraBean", lenguaEstructuraBean);
		mav.addObject("usuarioMatriculaBean", usuarioMatriBean);
		mav.addObject("alumnoMonedaGBean", AlumnoMonedaGemaBean);
		mav.addObject("swActivoMascotaAnim", swActivoMascotaAnim);
		mav.addObject("lstTraduccion", lstTraduccion);
		posicionMaterial = 0;
		swEsUltimoEj = false;
		posEjercicio = 0;
		return mav;
	}
	
	@RequestMapping(value = "/detalle/{codlengua}/nivel/{codlenest}/unidad/{codunidad}/leccion/{codleccion}", method = RequestMethod.GET)
	public ModelAndView cargarMaterial(	@PathVariable("codlengua") String codlengua,
										@PathVariable("codlenest") String codigoLE,
										@PathVariable("codunidad") String codigoUnidad,
										@PathVariable("codleccion") String codigoLeccion, 
										HttpServletRequest request,
										HttpServletResponse response) {
		
		//List<LeccionMaterialBean> lstMaterialBean = null;
		ModelAndView mav = null;
		UsuarioBean usuario = this.getUsuarioSesion(request);
		MascotaBean beanMascota= null;
		UsuarioMatriculaBean usuarioMatriBean =null;
		AlumnoMonedaGBean AlumnoMonedaGemaBean = null;
		swEsUltimoEj = false;
		posEjercicio = 0;
		int swActivoMascotaAnim = 0;
		Encrypt.init("KEY_ENCRYPT_REL");
		try {
			/** OBTENER DATOS DE LA LECCION DE LA UNIDAD **/
			UnidadLeccionBean prmUnidadLeccionBean = new UnidadLeccionBean();
//			prmUnidadLeccionBean.setCodigo(VO.toLong(codigoLeccion));
			prmUnidadLeccionBean.setCodigo(VO.toLong(Encrypt.decrypt(codigoLeccion.replace("$", "/"))));
			unidadLeccionBean = this.fs.getUnidadLeccionService().getBuscarPorObjecto(prmUnidadLeccionBean);
			unidadLeccionBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(unidadLeccionBean.getCodigo())).replace("/", "$"));
			/** OBTENER DATOS DE LA UNIDAD **/
			UnidadBean prmUnidadBean = new UnidadBean();
//			prmUnidadBean.setCodigo(VO.toLong(codigoUnidad));
			prmUnidadBean.setCodigo(VO.toLong(Encrypt.decrypt(codigoUnidad.replace("$", "/"))));
			unidadBean = this.fs.getUnidadService().getBuscarPorObjecto(prmUnidadBean);
			unidadBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(unidadBean.getCodigo())).replace("/", "$"));
			/** OBTENER DATOS DE LA ESTRUCTURA DE LA LENGUA (NIVEL - SUBNIVEL) **/
			LenguaEstructuraBean prmLenguaEstBean = new LenguaEstructuraBean();
//			prmLenguaEstBean.setCodigo(VO.toLong(codigoLE));
			prmLenguaEstBean.setCodigo(VO.toLong(Encrypt.decrypt(codigoLE.replace("$", "/"))));
			lenguaEstructuraBean = this.fs.getLenguaEstructuraService().getBuscarPorObjecto(prmLenguaEstBean);
			lenguaEstructuraBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(lenguaEstructuraBean.getCodigo())).replace("/", "$"));
			/** OBTENER DATOS DE LA LENGUA **/
			LenguaBean prmLenguaBean = new LenguaBean();
//			prmLenguaBean.setCodigo(VO.toLong(codlengua));
			prmLenguaBean.setCodigo(VO.toLong(Encrypt.decrypt(codlengua.replace("$", "/"))));
			lenguaBean = this.fs.getLenguaService().getBuscarPorObjecto(prmLenguaBean);
			lenguaBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(lenguaBean.getCodigo())).replace("/", "$"));
			/** OBTENER USUARIO MATRICULA **/  
			usuarioMatriBean =  obtenerUsuarioMatricula((usuario.getCodigo()) ,(prmLenguaBean.getCodigo())); 
			
			/** OBTENER CODUSUARIOXMONEDASGEMAS **/ 
			if(!VO.isNull(usuarioMatriBean)){
				AlumnoMonedaGemaBean =  monedasGemasObtenidas(usuarioMatriBean.getCodigo());
			}
			
			/** OBTENER MASCOTA **/
			MascotaBean	prMascotaBean = new MascotaBean();
			prMascotaBean.setAudCodigoUsuario(usuario.getCodigoUsuario());
			beanMascota = this.fs.getMascotaService().getlistarMasctoSwPredetAlumno(prMascotaBean);
			
			swActivoMascotaAnim = (!VO.isNull(request.getSession().getAttribute("swActivoMascotaAnim"))) ? (Integer) request.getSession().getAttribute("swActivoMascotaAnim") : 0;
			
			if (VO.isNotNull(beanMascota)) {
				System.out.println(" beanMascota.getImagenTienda() " + beanMascota.getImagenTienda());
			}
			
			/** OBTENER MENSAJES **/
			MensajesBean filtroMsj = new MensajesBean();
			filtroMsj.setLenguaBean(prmLenguaBean);
			lstMensajes = this.fs.getMensajeService().getBuscarPorFiltros(filtroMsj);
			
			/**Obtener Glosario**/
			GlosarioBean filtroGlosario = new GlosarioBean();
			filtroGlosario.setLenguaBean(prmLenguaBean);
			glosario = this.fs.getGlosarioService().getBuscarPorObjecto(filtroGlosario);
			
			/** CARGAR MATERIAL **/
			LeccionMaterialBean filtro = new LeccionMaterialBean();
//			filtro.getUnidadLeccionBean().setCodigo(VO.toLong(codigoLeccion));
			filtro.getUnidadLeccionBean().setCodigo(VO.toLong(Encrypt.decrypt(codigoLeccion.replace("$", "/"))));
			lstMaterialBean = this.fs.getLeccionMaterialService().buscarPorLeccion(filtro);
			
			for (LeccionMaterialBean leccionMaterialBean : lstMaterialBean) {
				leccionMaterialBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(leccionMaterialBean.getCodigo())).replace("/", "$"));
			}
			
			/***PagePerfil****/
			request.getSession().setAttribute("unidadLeccionBean", unidadLeccionBean);
			request.getSession().setAttribute("lenguaBean", lenguaBean);
			request.getSession().setAttribute("lenguaEstructuraBean", lenguaEstructuraBean);
			request.getSession().setAttribute("unidadBean", unidadBean);
			/***PagePerfil****/
			
			
			if(!VO.isEmptyList(lstMaterialBean)){
				
				if(posicionMaterial < lstMaterialBean.size()){
					mav = new ModelAndView("material/material-contenedor", "command",unidadLeccionBean);
					mav.addObject("unidadLeccionBean", unidadLeccionBean);
					mav.addObject("listaMaterial", lstMaterialBean);
					mav.addObject("posMaterialActual", posicionMaterial);
					mav.addObject("lenguaBean", lenguaBean);
					mav.addObject("lenguaEstructuraBean", lenguaEstructuraBean);
					mav.addObject("unidadBean", unidadBean);
					mav.addObject("beanMascota", beanMascota); 
					mav.addObject("usuarioMatriculaBean", usuarioMatriBean);
					mav.addObject("alumnoMonedaGBean", AlumnoMonedaGemaBean);
					mav.addObject("glosarioBean", glosario);
					mav.addObject("lstMensajes",lstMensajes);
					mav.addObject("swActivoMascotaAnim",swActivoMascotaAnim);
					lstTraduccion = (List<TraduccionBean>)request.getSession().getAttribute("lstTraduccion");
					mav.addObject("lstTraduccion", lstTraduccion);
					
				}else{
					posicionMaterial = 0;
					posEjercicio = 0;
					String path = request.getContextPath();
					path+="/lengua/detalle/"+codlengua+"/nivel/"+codigoLE+"/unidad/"+codigoUnidad;
					//path+="/lengua/detalle/"+Encrypt.decrypt(codlengua)+"/nivel/"+Encrypt.decrypt(codigoLE)+"/unidad/"+Encrypt.decrypt(codigoUnidad);
					response.sendRedirect(path);

				}
			
			}else{
				posicionMaterial = 0;
				posEjercicio = 0;
				String path = request.getContextPath();
				path+="/lengua/detalle/"+codlengua+"/nivel/"+codigoLE+"/unidad/"+codigoUnidad;
				//path+="/lengua/detalle/"+Encrypt.decrypt(codlengua)+"/nivel/"+Encrypt.decrypt(codigoLE)+"/unidad/"+Encrypt.decrypt(codigoUnidad);
				response.sendRedirect(path);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return mav;
	}
	
	@RequestMapping(value = "/cargarMaterialActual", method = RequestMethod.GET)
	public ModelAndView cargarMaterialActual(	@RequestParam("codmaterial") String codmaterial, 
												HttpServletRequest request,
												HttpServletResponse response) {
		
		LeccionMaterialBean materialBean_Actual = null;
		ModelAndView mav = null;
		
		try {
			/** CARGAR MATERIAL **/
			LeccionMaterialBean filtro = new LeccionMaterialBean();
			filtro.setCodigo(VO.toLong(codmaterial));
			materialBean_Actual = this.fs.getLeccionMaterialService().getBuscarPorObjecto(filtro);
			materialBean_Actual.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(materialBean_Actual.getCodigo())).replace("/", "$"));
			
			if(!VO.isNull(materialBean_Actual)){
					String url = this.verificarUrlMaterial(materialBean_Actual);
					if(!VO.isNull(url)){
						mav = new ModelAndView(url, "command",materialBean_Actual);
						mav.addObject("material", materialBean_Actual);
					}else{
						/** CARGAR EJERCICIOS SIN MATERIAL **/
						/*String path = request.getContextPath();
						path+="/lengua/detalle/"+lenguaBean.getCodigo()+"/nivel/"+lenguaEstructuraBean.getCodigo()+"/unidad/"+unidadBean.getCodigo()+"/leccion/"+unidadLeccionBean.getCodigo()+"/material/"+codmaterial;
						response.sendRedirect(path);*/
					}
			}else{
				/*String path = request.getContextPath();
				path+="/lengua/detalle/"+lenguaBean.getCodigo()+"/nivel/"+lenguaEstructuraBean.getCodigo()+"/unidad/"+unidadBean.getCodigo()+"/leccion/"+unidadLeccionBean.getCodigo();
				response.sendRedirect(path);*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	private String verificarUrlMaterial(LeccionMaterialBean material){
		
		String url = null;
		
			if(material.getSituacionLeccionMaterial().getCodigoRegistro() == 1){ // TEXTO - AUDIO - IMAGEN
				url = "material/material-01";
			}else if(material.getSituacionLeccionMaterial().getCodigoRegistro() == 2){ // TEXTO - AUDIO
				url = "material/material-02";
			}else if(material.getSituacionLeccionMaterial().getCodigoRegistro() == 6){ // TEXTO - IMAGEN
				url = "material/material-04";
			}else if(material.getSituacionLeccionMaterial().getCodigoRegistro() == 3){ // TEXTO
				url = "material/material-03";
			}else if(material.getSituacionLeccionMaterial().getCodigoRegistro() == 5){ // TAREA
				url = "material/material-05";
			}else{ // SIN MATERIAL
				url = null;
			}
		
		return url;
	}
	
	// Jason  
	
	@RequestMapping(value = "/MTE", method = RequestMethod.GET)
	@ResponseBody 
	public List<MaterialTipoEjercicioBean> doListMTE(@RequestParam("p_codmatpej") Integer  codmatpej,@RequestParam ("p_tipo") Integer  tipo)
	{   
		MaterialTipoEjercicioBean filtro = new MaterialTipoEjercicioBean();
		filtro.setLeccionMaterialBean(new LeccionMaterialBean());
		filtro.setTipoEjercicio(new MaestraBean());
		System.out.println("tipo " + tipo);
		System.out.println("codmatpej " + codmatpej);
		
		filtro.getLeccionMaterialBean().setCodigo(codmatpej);
		filtro.getTipoEjercicio().setCodigoRegistro(tipo);
		
		List<MaterialTipoEjercicioBean> lstBean  = new ArrayList<MaterialTipoEjercicioBean>();
		try{
			lstBean = this.fs.getMaterialTipoEjercicioService().getBuscarPorFiltros(filtro);
			if (lstBean != null && lstBean.size() >0) {
				
				System.out.println("--------------------------->"+ lstBean.size());
			}else{
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstBean;
	} 
	 
	@RequestMapping(value = "/ListArrastrar", method = RequestMethod.GET)
	@ResponseBody 
	public List<ArrastraOraDetBean> doListArrastrar(@RequestParam("p_codmatpej") Integer codmatpej)
	{
		ArrastraOraDetBean  Bean = new ArrastraOraDetBean ();
		Bean.setArrastraOraciBean(new ArrastraOraciBean());  
		Bean.getArrastraOraciBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		Bean.getArrastraOraciBean().getMaterialTipoEjercicioBean().setCodigo(codmatpej);
		
		List<ArrastraOraDetBean> lstBean  = new ArrayList<ArrastraOraDetBean>();
		try{
			lstBean =  this.fs.getArrastraOraDetService().getBuscarTodoxMTE(Bean);
			if (lstBean != null && lstBean.size() >0) {
				System.out.println("Lista _:" + lstBean.size());
				Encrypt.init("KEY_ENCRYPT_PREGU");
				for (int i = 0; i <lstBean.size(); i++) {
					lstBean.get(i).setValPreguEncrypt(Encrypt.encrypt((lstBean.get(i).getOrden())));
				}
				Encrypt.init("KEY_ENCRYPT_ALTER");
				for (int i = 0; i <lstBean.size(); i++) {
					lstBean.get(i).setValAlterEncrypt(Encrypt.encrypt((lstBean.get(i).getOrden())));
				} 
			}else{
				System.out.println("Lista vacia");
			}  
		
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstBean;
	}
	

	@RequestMapping(value = "/listarCrucigrama", method = RequestMethod.GET)
	@ResponseBody 
	public List<RelacionBean> dolistarCrucigrama(@RequestParam("idEjercicio") Integer idEjercicio){
		 
		RelacionBean relacionBean =  new RelacionBean();
		relacionBean.setRelacionCabeceraBean(new RelacionCabeceraBean());
		relacionBean.getRelacionCabeceraBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		System.out.println("idEjercicio"+idEjercicio);
		relacionBean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().setCodigo(idEjercicio);
			
		List<RelacionBean> lstRelacionBean = new ArrayList<RelacionBean>();
		try {
			lstRelacionBean = this.fs.getRelacionService().listarCrucigrama(relacionBean);
			if (lstRelacionBean != null && lstRelacionBean.size() >0) {
				
				System.out.println("--------------------------->"+ lstRelacionBean.size());
			}else{
				
				
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstRelacionBean;
	}
	
	@RequestMapping(value = "/listarCrucigramaDetalle", method = RequestMethod.GET)
	@ResponseBody 
	public List<CrucigramaDetBean> dolistarCrucigramaDetalle(@RequestParam("p_codrelcab") Long p_codrelcab){
		 
		CrucigramaDetBean relacionBean =  new CrucigramaDetBean();
		relacionBean.setRelacionCabeceraBean(new RelacionCabeceraBean());  
		relacionBean.getRelacionCabeceraBean().setCodigo(p_codrelcab);
			
		List<CrucigramaDetBean> lstRelacionBean = new ArrayList<CrucigramaDetBean>();
		Encrypt.init("KEY_ENCRYPT_REL");
		try {
			lstRelacionBean = this.fs.getCrucigramaDetService().getBuscarPorFiltros(relacionBean);
			if (lstRelacionBean != null && lstRelacionBean.size() >0) {
				
				for (CrucigramaDetBean crucigramaDetBean : lstRelacionBean) {
					crucigramaDetBean.setPalabraEncrypt(Encrypt.encrypt(crucigramaDetBean.getPalabra()));
				}
			}else{
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstRelacionBean;
	}
	
	
//	@RequestMapping(value = "/desencriptarLetra", method = RequestMethod.POST)
//	@ResponseBody 
//	public List<LetraEncriptada> desencriptarLetra(@RequestParam("listado") List<LetraEncriptada> listado){
	@ResponseBody 
	@RequestMapping(value = "/desencriptarLetra", method = RequestMethod.POST)
	public List<LetraEncriptada> desencriptarLetra(@RequestParam("listado") String prmListado){
		
//		Gson gson = new Gson();
		Type listaLetraType = new TypeToken<ArrayList<LetraEncriptada>>(){}.getType();
		List<LetraEncriptada> listaLetraVo = new Gson().fromJson(prmListado, listaLetraType);
		
		Encrypt.init("KEY_ENCRYPT_REL");
		try {
			if (listaLetraVo != null && listaLetraVo.size() >0) {
			
				for (LetraEncriptada letraEncriptada : listaLetraVo) {
					letraEncriptada.setLetra(Encrypt.decrypt(letraEncriptada.getLetraEncriptada()));
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return listaLetraVo;
	}
	
	
	@RequestMapping(value = "/ArrastrarTexto", method = RequestMethod.GET)
	@ResponseBody 
	public List<RelacionBean> doArrastrarTexto(@RequestParam("p_codmatpej") Integer codmatpej)
	{
 
		RelacionBean relacionBean = new RelacionBean();
		relacionBean.setRelacionCabeceraBean(new RelacionCabeceraBean());
		relacionBean.getRelacionCabeceraBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		relacionBean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().setCodigo(codmatpej);
		System.out.println("titulos "+ relacionBean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().getTitulo());
 
		
		List<RelacionBean> lstRelacionBean= new ArrayList<RelacionBean>();
		try{
			
			lstRelacionBean =  this.fs.getRelacionService().listarTextoTexto(relacionBean);
			if (lstRelacionBean != null && lstRelacionBean.size() >0) { 
				Encrypt.init("KEY_ENCRYPT_PREGU");
				for (int i = 0; i <lstRelacionBean.size(); i++) {
					lstRelacionBean.get(i).setValPreguEncrypt(Encrypt.encrypt(VO.toString(lstRelacionBean.get(i).getCodigo())));
				} 
				Encrypt.init("KEY_ENCRYPT_ALTER");
				for (int i = 0; i <lstRelacionBean.size(); i++) {
					lstRelacionBean.get(i).setValAlterEncrypt(Encrypt.encrypt(VO.toString(lstRelacionBean.get(i).getCodigo())));
				}
				Encrypt.init("KEY_ENCRYPT_REL");
				for (int i = 0; i <lstRelacionBean.size(); i++) {
					lstRelacionBean.get(i).setValRelEncrypt(Encrypt.encrypt(VO.toString(lstRelacionBean.get(i).getCodigo())));
				}
			}else{
				System.out.println("Lista vacia");
			} 
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstRelacionBean;
	}
	
			@RequestMapping(value = "/ListTodoxTE", method = RequestMethod.GET)
			@ResponseBody 
			public List<OracionAlterBean> doListTodoxTE(@RequestParam("p_codmatpej") Integer  codmatpej)
			{   
				OracionAlterBean  Bean = new OracionAlterBean();
				Bean.setOracionCompletarBean(new OracionCompletarBean()); 
				Bean.getOracionCompletarBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
				Bean.getOracionCompletarBean().getMaterialTipoEjercicioBean().setCodigo(codmatpej);
				
				List<OracionAlterBean> lstBean  = new ArrayList<OracionAlterBean>();
				try{
					lstBean = this.fs.getOracionAlterService().getBuscarTodoxMTE(Bean);
					if (lstBean != null && lstBean.size() >0) {
						System.out.println("--------------------------->"+ lstBean);
						System.out.println("--------------------------->"+ lstBean.size());
					}else{
						System.out.println("Lista vacia");
					}
					
				} catch (Exception e) {
					e.printStackTrace();

				}

				return lstBean;
			}
			
			@RequestMapping(value = "/ListAlternTextoPalabraCorrectaTodoxTE", method = RequestMethod.GET)
			@ResponseBody 
			public List<AlterTextoPalabraCorrectaBean> doListAlternTextoPalabraCorrectaTodoxTE(@RequestParam("p_codmatpej") Integer  codmatpej)
			{   
				AlterTextoPalabraCorrectaBean  Bean = new AlterTextoPalabraCorrectaBean();
				Bean.setTextoPalabraCorrectaBean(new TextoPalabraCorrectaBean()); 
				Bean.getTextoPalabraCorrectaBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
				Bean.getTextoPalabraCorrectaBean().getMaterialTipoEjercicioBean().setCodigo(codmatpej);
				
				List<AlterTextoPalabraCorrectaBean> lstBean  = new ArrayList<AlterTextoPalabraCorrectaBean>();
				try{
					lstBean = this.fs.getalterTextoPalabraCorrectaService().getBuscarTodoxMTE(Bean);
					if (lstBean != null && lstBean.size() >0) {
						
						System.out.println("--------------------------->"+ lstBean.size());
					}else{
						System.out.println("Lista vacia");
					}
					
				} catch (Exception e) {
					e.printStackTrace();

				}

				return lstBean;
			}
			
			@RequestMapping(value = "/ListAlternTextoPalabraCorrectaXNombrePCYcodigoCab", method = RequestMethod.GET)
			@ResponseBody 
			public List<AlterTextoPalabraCorrectaBean> doListAlternTextoPalabraCorrectaXNombrePCYcodigoCab(@RequestParam("p_palabracorrecta") int  palabraClave,@RequestParam("p_codtextopalabracorrec") Integer  codCab)
			{   
				System.out.println("codCab " + codCab);
				System.out.println("palabraClave " + palabraClave);

				AlterTextoPalabraCorrectaBean  Bean = new AlterTextoPalabraCorrectaBean();
				Bean.setTextoPalabraCorrectaBean(new TextoPalabraCorrectaBean()); 
				Bean.getTextoPalabraCorrectaBean().setCodigo(codCab);
				Bean.setNroOrden(palabraClave);
				
				List<AlterTextoPalabraCorrectaBean> lstBean  = new ArrayList<AlterTextoPalabraCorrectaBean>();
				try{
					lstBean = this.fs.getalterTextoPalabraCorrectaService().getlistarNombrePalabraCorrectaYcodigoCab(Bean);
					if (lstBean != null && lstBean.size() >0) {
						
						System.out.println("--------------------------->"+ lstBean.size());
					}else{
						System.out.println("Lista vacia");
					}
					
				} catch (Exception e) {
					e.printStackTrace();

				}

				return lstBean;
			}
			
			@RequestMapping(value = "/ListAlternTextoPalabraEncerradaTodoxTE", method = RequestMethod.GET)
			@ResponseBody 
			public List<AlterTextoPalabraEncerradaBean> doListAlternTextoPalabraEncerradaTodoxTE(@RequestParam("p_codmatpej") Integer  codmatpej)
			{   
				System.out.println("ListAlternTextoPalabraEncerradaTodoxTE codmatpej " + codmatpej);
				AlterTextoPalabraEncerradaBean  Bean = new AlterTextoPalabraEncerradaBean();
				Bean.setTextoPalabraEncerradaBean(new TextoPalabraEncerradaBean()); 
				Bean.getTextoPalabraEncerradaBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
				Bean.getTextoPalabraEncerradaBean().getMaterialTipoEjercicioBean().setCodigo(codmatpej);
				
				List<AlterTextoPalabraEncerradaBean> lstBean  = new ArrayList<AlterTextoPalabraEncerradaBean>();
				List<OracionCompletarBean> lstorac  = new ArrayList<OracionCompletarBean>();
				try{
					lstBean = this.fs.getAlterTextoPalabraEncerradaService().buscarxCabeceraxDetalle(Bean);
					if (lstBean != null && lstBean.size() >0) {
						
						System.out.println("AlterTextoPalabraEncerradaBean---------------------------> "+ lstBean.size());
						System.out.println("lstBean.get(0).getTextoPalabraEncerradaBean().getComentario() " + lstBean.get(0).getTextoPalabraEncerradaBean().getComentario());
					}else{
						System.out.println("AlterTextoPalabraEncerradaBean Lista vacia");
						//OracionCompletarBean  	bean = null;
						//bean.getMaterialTipoEjercicioBean().setCodigo(codmatpej);
						//System.out.println("bean"+bean);
					}
					
				} catch (Exception e) {
					e.printStackTrace();

				}

				return lstBean;
			}
			
			@RequestMapping(value = "/listarCompletarPalabrasInputTodoxTE", method = RequestMethod.GET)
			@ResponseBody 
			public List<AlterTextoPalabraEncerradaBean> doListarCompletarPalabrasInputTodoxTE(@RequestParam("p_codmatpej") Integer  codmatpej)
			{   
				AlterTextoPalabraEncerradaBean  Bean = new AlterTextoPalabraEncerradaBean();
				Bean.setTextoPalabraEncerradaBean(new TextoPalabraEncerradaBean()); 
				Bean.getTextoPalabraEncerradaBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
				Bean.getTextoPalabraEncerradaBean().getMaterialTipoEjercicioBean().setCodigo(codmatpej);
				
				List<AlterTextoPalabraEncerradaBean> lstBean  = new ArrayList<AlterTextoPalabraEncerradaBean>();
				try{
					lstBean = this.fs.getAlterTextoPalabraEncerradaService().buscarxCabeceraxDetalle(Bean);
					if (lstBean != null && lstBean.size() >0) {
						Encrypt.init("KEY_ENCRYPT_PREGU");
						for (int i = 0; i < lstBean.size(); i++) {
							AlterTextoPalabraEncerradaBean valBean = lstBean.get(i);
							if(!VO.isEmpty(valBean.getPalabraRpta())){
								valBean.setValPreguEncrypt(Encrypt.encrypt(valBean.getPalabraRpta()));
							}
						}
						
					}else{
						System.out.println("AlterTextoPalabraEncerradaBean Lista vacia");
					}
					
				} catch (Exception e) {
					e.printStackTrace();

				}

				return lstBean;
			}
			
			@RequestMapping(value = "/ListRelacionVariada", method = RequestMethod.GET)
			@ResponseBody 
			public List<RelacionVariadaBean> doListrelavariada(@RequestParam("p_codmatpej") Integer codmatpej)
			{
				RelacionVariadaBean  Bean = new RelacionVariadaBean ();
				Bean.setRelacionCabeceraBean(new RelacionCabeceraBean());  
				Bean.getRelacionCabeceraBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
				Bean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().setCodigo(codmatpej);
				
				List<RelacionVariadaBean> lstBean  = new ArrayList<RelacionVariadaBean>();
				try{
					lstBean =  this.fs.getRelacionVariadaService().getBuscarTodoxMTE(Bean);
					if (lstBean != null && lstBean.size() >0) {
						
						System.out.println("--------------------------->"+ lstBean.size() + "CODIGO  idOracion " + codmatpej + "WE" +  lstBean);
					}else{
						System.out.println("Lista vacia");
					}
					
				} catch (Exception e) {
					e.printStackTrace();

				}

				return lstBean;
			}
			
	@RequestMapping(value = "/detalle/{codlengua}/nivel/{codlenest}/unidad/{codunidad}/leccion/{codleccion}/material/{codmaterial}", method = RequestMethod.GET)
	public ModelAndView cargarEjercicios( @PathVariable("codlengua") String codlengua,
										  @PathVariable("codlenest") String codigoLE,
										  @PathVariable("codunidad") String codigoUnidad,
										  @PathVariable("codleccion") String codigoLeccion,
										  @PathVariable("codmaterial") String codigoMaterial,
										  HttpServletRequest request,
										  HttpServletResponse response) {
		
		ModelAndView mav = null;
		UsuarioBean usuario = this.getUsuarioSesion(request);
		MascotaBean beanMascota= null;
		int swActivoMascotaAnim = 0;
		int posmaterialactual = 0; 
		
		Encrypt.init("KEY_ENCRYPT_REL");
		
		try {
			
			/** CARGAR MATERIAL **/
			LeccionMaterialBean filtroMaterial = new LeccionMaterialBean();
//			filtroMaterial.getUnidadLeccionBean().setCodigo(VO.toLong(codigoLeccion));
			filtroMaterial.getUnidadLeccionBean().setCodigo(VO.toLong(Encrypt.decrypt(codigoLeccion.replace("$", "/"))));
			lstMaterialBean = this.fs.getLeccionMaterialService().buscarPorLeccion(filtroMaterial);
			
			if(!VO.isEmptyList(lstMaterialBean)){
				for (int i = 0; i < lstMaterialBean.size(); i++) {
					LeccionMaterialBean material_actual = lstMaterialBean.get(i);
//					if(material_actual.getCodigo() == VO.toLong(codigoMaterial)){
					if(material_actual.getCodigo() == VO.toLong(Encrypt.decrypt(codigoMaterial.replace("$", "/")))){
							posmaterialactual = i;
						posicionMaterial = i+1;
						break;
					}
				}
			}
			
			/** OBTENER DATOS DEL MATERIAL DE LA LECCION **/
			LeccionMaterialBean prmLeccionMaterialBean = new LeccionMaterialBean();
//			prmLeccionMaterialBean.setCodigo(VO.toLong(codigoMaterial));
			prmLeccionMaterialBean.setCodigo(VO.toLong(Encrypt.decrypt(codigoMaterial.replace("$", "/"))));
			leccionMaterialBean = this.fs.getLeccionMaterialService().getBuscarPorObjecto(prmLeccionMaterialBean);
			leccionMaterialBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(leccionMaterialBean.getCodigo())).replace("/", "$"));
			
			/** OBTENER DATOS DE LA LECCION DE LA UNIDAD **/
			UnidadLeccionBean prmUnidadLeccionBean = new UnidadLeccionBean();
//			prmUnidadLeccionBean.setCodigo(VO.toLong(codigoLeccion));
			prmUnidadLeccionBean.setCodigo(VO.toLong(Encrypt.decrypt(codigoLeccion.replace("$", "/"))));	
			unidadLeccionBean = this.fs.getUnidadLeccionService().getBuscarPorObjecto(prmUnidadLeccionBean);
			unidadLeccionBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(unidadLeccionBean.getCodigo())).replace("/", "$"));
				
			/** OBTENER DATOS DE LA UNIDAD **/
			UnidadBean prmUnidadBean = new UnidadBean();
//			prmUnidadBean.setCodigo(VO.toLong(codigoUnidad));
			prmUnidadBean.setCodigo(VO.toLong(Encrypt.decrypt(codigoUnidad.replace("$", "/"))));
			unidadBean = this.fs.getUnidadService().getBuscarPorObjecto(prmUnidadBean);
			unidadBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(unidadBean.getCodigo())).replace("/", "$"));
				
			/** OBTENER DATOS DE LA ESTRUCTURA DE LA LENGUA (NIVEL - SUBNIVEL) **/
			LenguaEstructuraBean prmLenguaEstBean = new LenguaEstructuraBean();
//			prmLenguaEstBean.setCodigo(VO.toLong(codigoLE));
			prmLenguaEstBean.setCodigo(VO.toLong(Encrypt.decrypt(codigoLE.replace("$", "/"))));
			lenguaEstructuraBean = this.fs.getLenguaEstructuraService().getBuscarPorObjecto(prmLenguaEstBean);
			lenguaEstructuraBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(lenguaEstructuraBean.getCodigo())).replace("/", "$"));
			
			/** OBTENER DATOS DE LA LENGUA **/
			LenguaBean prmLenguaBean = new LenguaBean();
//			prmLenguaBean.setCodigo(VO.toLong(codlengua));
			prmLenguaBean.setCodigo(VO.toLong(Encrypt.decrypt(codlengua.replace("$", "/"))));
			lenguaBean = this.fs.getLenguaService().getBuscarPorObjecto(prmLenguaBean);
			lenguaBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(lenguaBean.getCodigo())).replace("/", "$"));
			
			/** OBTENER ULTIMA LECCION POR LENGUA ESTRUCTURA **/
			UnidadLeccionBean prmultleclenestBean = new UnidadLeccionBean();
//			prmultleclenestBean.getUnidadBean().getLenguaEstructuraBean().setCodigo(VO.toLong(codigoLE));
			prmultleclenestBean.getUnidadBean().getLenguaEstructuraBean().setCodigo(VO.toLong(Encrypt.decrypt(codigoLE.replace("$", "/"))));
			ultimaleccionxlenest = this.fs.getUnidadLeccionService().getBuscarultLecXlenest(prmultleclenestBean);  
			ultimaleccionxlenest.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(ultimaleccionxlenest.getCodigo())).replace("/", "$"));
			
			/** OBTENER ULTIMA LECCION POR UNIDAD**/
			UnidadLeccionBean prmultlecunitBean = new UnidadLeccionBean();
//			prmultlecunitBean.getUnidadBean().setCodigo(VO.toLong(codigoUnidad));
			prmultlecunitBean.getUnidadBean().setCodigo(VO.toLong(Encrypt.decrypt(codigoUnidad.replace("$", "/"))));
			ultimaleccionxunidad = this.fs.getUnidadLeccionService().getBuscarultLecXunidad(prmultlecunitBean); 
			ultimaleccionxunidad.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(ultimaleccionxunidad.getCodigo())).replace("/", "$")); 
			
			
			/** OBTENER MASCOTA **/
			MascotaBean	prMascotaBean = new MascotaBean();
			prMascotaBean.setAudCodigoUsuario(usuario.getCodigoUsuario());
			beanMascota = this.fs.getMascotaService().getlistarMasctoSwPredetAlumno(prMascotaBean);
			
			swActivoMascotaAnim = (!VO.isNull(request.getSession().getAttribute("swActivoMascotaAnim"))) ? (Integer) request.getSession().getAttribute("swActivoMascotaAnim") : 0;
			
			if (VO.isNotNull(beanMascota)) {
				System.out.println(" beanMascota.getImagenTienda() " + beanMascota.getImagenTienda());
			}
			
			/** CARGAR EJERCICIOS **/
			MaterialTipoEjercicioBean filtro = new MaterialTipoEjercicioBean();
//			filtro.getLeccionMaterialBean().setCodigo(VO.toLong(codigoMaterial));
			filtro.getLeccionMaterialBean().setCodigo(VO.toLong(Encrypt.decrypt(codigoMaterial.replace("$", "/"))));
			//filtro.getSituacionTipo().setCodigoRegistro(1);
			lstMaterialTipoEjBean = this.fs.getMaterialTipoEjercicioService().getBuscarPorFiltros(filtro);			
			
			/** OBTENER MENSAJES **/
			MensajesBean filtroMsj = new MensajesBean();
			filtroMsj.setLenguaBean(prmLenguaBean);
			lstMensajes = this.fs.getMensajeService().getBuscarPorFiltros(filtroMsj);
			
			/**Obtener Glosario**/
			GlosarioBean filtroGlosario = new GlosarioBean();
			filtroGlosario.setLenguaBean(prmLenguaBean);
			glosario = this.fs.getGlosarioService().getBuscarPorObjecto(filtroGlosario);
			
			/***PagePerfil****/
			request.getSession().setAttribute("unidadLeccionBean", unidadLeccionBean);
			request.getSession().setAttribute("lenguaBean", lenguaBean);
			request.getSession().setAttribute("lenguaEstructuraBean", lenguaEstructuraBean);
			request.getSession().setAttribute("unidadBean", unidadBean);
			/***PagePerfil****/
			
			if(!VO.isEmptyList(lstMaterialTipoEjBean)){  
				/** OBTENER USUARIO MATRICULA **/
				UsuarioMatriculaBean usuarioMatriBean = new UsuarioMatriculaBean();	 
//				usuarioMatriBean =  obtenerUsuarioMatricula((usuario.getCodigo()) ,VO.toLong(codlengua)); 
				usuarioMatriBean =  obtenerUsuarioMatricula((usuario.getCodigo()) ,VO.toLong(Encrypt.decrypt(codlengua.replace("$", "/")))); 
				/** OBTENER CODUSUARIOXMONEDASGEMAS **/
				AlumnoMonedaGBean AlumnoMonedaGemaBean = new AlumnoMonedaGBean();	 
				if(!VO.isNull(usuarioMatriBean)){
					AlumnoMonedaGemaBean =  monedasGemasObtenidas(usuarioMatriBean.getCodigo());
				}
				
				mav = new ModelAndView("ejercicios/ejercicio-contenedor", "command",leccionMaterialBean);
				mav.addObject("material", leccionMaterialBean);
				mav.addObject("lstMaterialTipoEjBean", lstMaterialTipoEjBean);
				mav.addObject("lenguaBean", lenguaBean);
				mav.addObject("lenguaEstructuraBean", lenguaEstructuraBean);
				mav.addObject("unidadBean", unidadBean);
				mav.addObject("unidadLeccionBean", unidadLeccionBean);  
				mav.addObject("ultimaleccionxlenest", ultimaleccionxlenest);
				mav.addObject("ultimaleccionxunidad", ultimaleccionxunidad);
				mav.addObject("beanMascota", beanMascota);
				mav.addObject("usuarioMatriculaBean", usuarioMatriBean);
				mav.addObject("alumnoMonedaGBean", AlumnoMonedaGemaBean);
				mav.addObject("swEsUltimoEj", swEsUltimoEj);
				mav.addObject("posEjercicio", posEjercicio);
				mav.addObject("glosarioBean", glosario);
				mav.addObject("lstMensajes",lstMensajes);
				mav.addObject("swActivoMascotaAnim",swActivoMascotaAnim);
				mav.addObject("posMaterialActual", posmaterialactual);
					
			}else{
				String path = request.getContextPath();
				path+="/lengua/detalle/"+codlengua+"/nivel/"+codigoLE+"/unidad/"+codigoUnidad+"/leccion/"+codigoLeccion;
				//path+="/lengua/detalle/"+Encrypt.decrypt(codlengua)+"/nivel/"+Encrypt.decrypt(codigoLE)+"/unidad/"+Encrypt.decrypt(codigoUnidad)+"/leccion/"+Encrypt.decrypt(codigoLeccion);
				response.sendRedirect(path);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/MonedasYGemasObtenidas", method = RequestMethod.GET)
	@ResponseBody 
	public  AlumnoMonedaGBean  doListMTE(@RequestParam("usuariomatricula") Integer  usumat)
	{   
		AlumnoMonedaGBean  Bean = new AlumnoMonedaGBean();
		Bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
		Bean.getUsuarioMatriculaBean().setCodigo(Long.valueOf(usumat));
		AlumnoMonedaGBean alumnoMG = null;
		try{
			alumnoMG = this.fs.getAlumnoMonedaGService().getBuscarPorObjecto(Bean);
			if (alumnoMG != null) { 
				System.out.println("MONEDAS :: "+ alumnoMG.getNumeroMonedas());  
			}else{
				System.out.println("Obj vacio.");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} 
		return alumnoMG;
	}  
	
	@RequestMapping(value = "/listarLeccionesXlengNiv", method = RequestMethod.POST)
	@ResponseBody 
	public List<UnidadLeccionBean> dolistarLeccionesXlengest(@RequestParam("p_codlengua") Long lengua,@RequestParam("p_tm2SubNivel") Integer subNivel
			)
	{ 
		UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
		unidadLeccionBean.setUnidadBean(new UnidadBean());
		unidadLeccionBean.getUnidadBean().setLenguaEstructuraBean(new LenguaEstructuraBean());
		unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().setSubNivel(new MaestraBean());
	 
		unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getLenguaBean().setCodigo(lengua);
//		unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getNivel().setCodigoRegistro(nivel);
		unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getSubNivel().setCodigoRegistro(subNivel);
		List<UnidadLeccionBean> lstUnidadLeccionBean = null;
		try {
			lstUnidadLeccionBean = this.fs.getUnidadLeccionService().getBuscarPorLenNiv(unidadLeccionBean);
			if (lstUnidadLeccionBean != null && lstUnidadLeccionBean.size() >0) {
				System.out.println("Lista _:" + lstUnidadLeccionBean.size());
			}else{
				System.out.println("Lista vacia");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstUnidadLeccionBean;
	}
	
	@RequestMapping(value = "/agregarrMonedasGemas", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarMonedas(@RequestParam("p_codmatpej") Integer ejercicio, @RequestParam("p_codaluxmongem") Integer codigo, @RequestParam("p_cantgemas") Integer cantGemas,   @RequestParam("p_codusumat") Integer usuarioMatricula, @RequestParam("p_cantmonedas") Integer cantMonedas,HttpServletRequest request ) {
		AlumnoMonedaGBean  Bean = new AlumnoMonedaGBean();
		Bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
		Bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		Bean.getUsuarioMatriculaBean().setCodigo(Long.valueOf(usuarioMatricula)); 
		Bean.setNumeroGemas(cantGemas); 
		Bean.getMaterialTipoEjercicioBean().setCodigo(ejercicio); 
		Bean.setNumeroMonedas(cantMonedas); 
		Bean.setCodigo(codigo);
		  
			try {
				if (Bean.getCodigo() != 0) {
					this.setAuditoria(Bean, request, false);
					this.fs.getAlumnoMonedaGService().actualizar(Bean);
					System.out.println("Se actualizo moneda con exito");
				}else{ this.setAuditoria(Bean, request, true);
				this.fs.getAlumnoMonedaGService().insertar(Bean); 
					System.out.println("Se inserto moneda con exito");
				}

			 } catch (ServiceException e) {
			 e.printStackTrace();
			 }
 
			 return String.valueOf(Bean.getExiste());
 
		}
	
	
	@RequestMapping(value = "/agregarSiguienteLeccion", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doGrabarSiguienteLeccion(@RequestParam("p_codusumat") Long matricula, @RequestParam("p_codundlec") Long leccion, @RequestParam("p_codundlecAct") Integer leccionAct, HttpServletRequest request ) {
		Map<String,Object> map = new HashMap<String,Object>();
		AlumnoMonedaGBean filtro = null;
		SeguimientoAlumnoLenguaBean  Bean = new SeguimientoAlumnoLenguaBean();
		Bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
		Bean.setUnidadLeccionBean(new UnidadLeccionBean());
		Bean.getUsuarioMatriculaBean().setCodigo(matricula);  
		Bean.getUnidadLeccionBean().setCodigo(leccion); 
		Bean.setLeccionActual(leccionAct); 
			try {
				if (Bean.getCodigo() == 0) { 
					this.setAuditoria(Bean, request, true);
					this.fs.getSeguimientoAlumnoLenguaService().insertar_sigLec(Bean); 
					filtro = new AlumnoMonedaGBean();
					filtro.setUsuarioMatriculaBean(Bean.getUsuarioMatriculaBean());
					filtro = this.fs.getAlumnoMonedaGService().getBuscarPorObjecto(filtro);
					System.out.println("Se inserto siguiente leccion con exito");
				}else{  
						System.out.println("codigo diferente de 0, no se insert� siguiente lecci�n");
					}

			 } catch (ServiceException e) {
				 e.printStackTrace();
			 }
			map.put("codigo", Bean.getCodigo());
			map.put("alumnoMonedaGema", filtro);
			 return map;
 
		}
	
	
	
	@RequestMapping(value = "/cargarEjercicioActual", method = RequestMethod.GET)
	public ModelAndView cargarEjercicioActual(	@RequestParam("codmatipej") String codmatipej,
												HttpServletRequest request,
												HttpServletResponse response) {
		EvaluacionDetalleBean oeEvaluacionDetalleBean = new EvaluacionDetalleBean();
		EvaluacionDetalleBean prmEvaluacionDetalleBean = null;
		MaterialTipoEjercicioBean prmMaterialTipoEjercicio = null;
		ModelAndView mav = null;
		UsuarioBean usuario = this.getUsuarioSesion(request);
		
		try {
			prmMaterialTipoEjercicio = new MaterialTipoEjercicioBean();
			prmMaterialTipoEjercicio.setCodigo(VO.toLong(codmatipej));
			prmMaterialTipoEjercicio = this.fs.getMaterialTipoEjercicioService().getBuscarPorObjecto(prmMaterialTipoEjercicio);
			
			prmEvaluacionDetalleBean = new EvaluacionDetalleBean();
			prmEvaluacionDetalleBean.setEvaluacionBean(getEvaluacionBean());
			prmEvaluacionDetalleBean.getTipoEjercicio().setCodigoRegistro((prmMaterialTipoEjercicio.getTipoEjercicio().getCodigoRegistro()));
			
			oeEvaluacionDetalleBean = this.fs.getEvaluacionDetalleService().getBuscarPorEjercicioEvaluacion(prmEvaluacionDetalleBean);
			
			Integer tipoEjercicio = ( !VO.isNull(prmMaterialTipoEjercicio) 
							  		  && !VO.isNull(prmMaterialTipoEjercicio.getTipoEjercicio()) 
							        ) ? prmMaterialTipoEjercicio.getTipoEjercicio().getCodigoRegistro() : 0;
			
			Integer flgPregu = 	!VO.isNull(prmMaterialTipoEjercicio.getFlgPregu()) ? prmMaterialTipoEjercicio.getFlgPregu() : 0;			        
							        
			/** CARGAR EJERCICIO **/
			String urlEjercicio = this.getUrlEjercicio(tipoEjercicio,flgPregu);
			
			if(VO.isNull(urlEjercicio)){
				System.out.println("null urlEjercio" );
				/*String path = request.getContextPath();
				path+="/lengua/detalle/"+lenguaBean.getCodigo()+"/nivel/"+lenguaEstructuraBean.getCodigo()+"/unidad/"+unidadBean.getCodigo()+"/leccion/"+unidadLeccionBean.getCodigo();
				response.sendRedirect(path);*/
				
			}else{
				mav = new ModelAndView(urlEjercicio, "command", prmMaterialTipoEjercicio);
				mav.addObject("materialTipoEjercicioBean", prmMaterialTipoEjercicio);
				mav.addObject("material", leccionMaterialBean);
				
				if(tipoEjercicio == 2){

					List<PreguntaBean> lstPreguntaBean = null;
					
					/** BUSCAR PREGUNTAS **/
					PreguntaBean prmPreguntaBean = new PreguntaBean();
					prmPreguntaBean.setMaterialEjercicioBean(new MaterialTipoEjercicioBean());
					prmPreguntaBean.getMaterialEjercicioBean().setCodigo(prmMaterialTipoEjercicio.getCodigo());
					
					lstPreguntaBean = this.fs.getPreguntaService().buscarPregunta(prmPreguntaBean);
					
					if(!VO.isEmptyList(lstPreguntaBean)){
						for (PreguntaBean objPregunta : lstPreguntaBean) {
							List<AlternativaBean> listaAlternativa = new ArrayList<AlternativaBean>();
							listaAlternativa = this.fs.getAlternativaService().buscarPorCodigoPregunta(objPregunta);
							objPregunta.setListaAlternativa((List<AlternativaBean>) VO.randomElementList(listaAlternativa));
						}
					}
					
					mav.addObject("listaPreguntas",lstPreguntaBean);
					
				}else if(tipoEjercicio == 24){	
					System.out.println("Ingreso a ejercicio 24");
				}else if(tipoEjercicio == 12){
					System.out.println("Ingreso a ejercicio 12");
				}else if(tipoEjercicio == 1){
					System.out.println("Ingreso a ejercicio 1");
				}else if(tipoEjercicio == 13){
					System.out.println("Ingreso a ejercicio 13");
				}else if(tipoEjercicio == 31){
					System.out.println("Ingreso a ejercicio 31");
				}else if(tipoEjercicio == 26){
					System.out.println("Ingreso a ejercicio 31");
				}else if(tipoEjercicio == 18){
					System.out.println("Ingreso a ejercicio 18");
				}else if(tipoEjercicio == 27){
					System.out.println("Ingreso a ejercicio 27");
				}else if(tipoEjercicio == 19){
					System.out.println("Ingreso a ejercicio 19");
				}else if(tipoEjercicio == 22){
					System.out.println("Ingreso a ejercicio 22");
				}else if(tipoEjercicio == 30){
					System.out.println("Ingreso a 30: texto texto texto"); 
				}else if(tipoEjercicio == 9){
					System.out.println("Ingreso a 9: texto-palabras-encerradas"); 
				}else if(tipoEjercicio == 3){
					System.out.println("Ingreso a 3: texto-palabras-correcta"); 
				}else if (tipoEjercicio == 37) {
					System.out.println("Ingreso a 37: texto-parrafo");
					
				}
					
				IntentoConfiguracionBean intentoConfiguracionBean = new IntentoConfiguracionBean();	 
				intentoConfiguracionBean =  numeroIntentosEjercicio(tipoEjercicio);
				mav.addObject("intentoConfiguracionBean", intentoConfiguracionBean);
				  
				LenguaBean lengua = new LenguaBean();
				System.out.println("lenguaBean ::"+lenguaBean);
				lengua = this.fs.getLenguaService().getBuscarPorObjecto(lenguaBean);
				mav.addObject("lengua", lengua);
				
				mav.addObject("usuario", usuario);
				mav.addObject("evaluacionDetalle", oeEvaluacionDetalleBean);
				//mav.addObject("evaluacionBean",evaluacionBean);
				
//				UsuarioMatriculaBean uMBean = new UsuarioMatriculaBean();	 
//				System.out.println("BEAN USUARIO" + usuario );
//				System.out.println("BEAN LENGUA " + lengua );
//				uMBean =  obtenerUsuarioMatricula((usuario.getCodigo()) ,lengua.getCodigo() );
//				mav.addObject("usuarioMatriculaBean", uMBean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(mav);
		
		return mav;
	}
	
	@RequestMapping(value = "/deprimerejercicioamaterial/{codlengua}/{codlenest}/{codunidad}/{codleccion}", method = RequestMethod.GET)
	public void	dePrimerEjercicioAMaterial(	@PathVariable("codlengua") String codlengua,
											@PathVariable("codlenest") String codigoLE,
											@PathVariable("codunidad") String codigoUnidad,
											@PathVariable("codleccion") String codigoLeccion,
											HttpServletRequest request,HttpServletResponse response){
		try {
			posicionMaterial--;
			int tipoMaterial = 0;
			for (int i = 0; i < lstMaterialBean.size(); i++) {
				LeccionMaterialBean material_actual = lstMaterialBean.get(i);
				if(posicionMaterial == i){
					tipoMaterial = material_actual.getSituacionLeccionMaterial().getCodigoRegistro();
					break;
				}
			}
			
			String path = request.getContextPath();
				
			if(tipoMaterial == 4){ // SIN MATERIAL
				deMaterialAUltimoEjercicio(codlengua,codigoLE,codigoUnidad,codigoLeccion,request,response);
//				deMaterialAUltimoEjercicio(Encrypt.decrypt(codlengua),Encrypt.decrypt(codigoLE),Encrypt.decrypt(codigoUnidad),Encrypt.decrypt(codigoLeccion),request,response);
			}else{
				path+="/lengua/detalle/"+codlengua+"/nivel/"+codigoLE+"/unidad/"+codigoUnidad+"/leccion/"+codigoLeccion;
//				path+="/lengua/detalle/"+Encrypt.decrypt(codlengua)+"/nivel/"+Encrypt.decrypt(codigoLE)+"/unidad/"+Encrypt.decrypt(codigoUnidad)+"/leccion/"+Encrypt.decrypt(codigoLeccion);
				response.sendRedirect(path);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/dematerialaultimoejercicio/{codlengua}/{codlenest}/{codunidad}/{codleccion}", method = RequestMethod.GET)
	public void	deMaterialAUltimoEjercicio(	@PathVariable("codlengua") String codlengua,
											@PathVariable("codlenest") String codigoLE,
											@PathVariable("codunidad") String codigoUnidad,
											@PathVariable("codleccion") String codigoLeccion,
											HttpServletRequest request,HttpServletResponse response){
		
		try {
			String path = request.getContextPath();
			
			if(posicionMaterial<=0){ // Primer Material
				/** DIRIGIR AL LISTADO DE LECCIONES **/
				path+="/lengua/detalle/"+codlengua+"/nivel/"+codigoLE+"/unidad/"+codigoUnidad;
				//path+="/lengua/detalle/"+Encrypt.decrypt(codigoUnidad)+"/nivel/"+Encrypt.decrypt(codigoUnidad)+"/unidad/"+Encrypt.decrypt(codigoUnidad);
				response.sendRedirect(path);
			}else{
				/** CARGAR ULTIMO EJERCICIO DEL MATERIAL ANTERIOR **/
				swEsUltimoEj = true;
				long codMaterial = 0;
				posicionMaterial--;
				for (int i = 0; i < lstMaterialBean.size(); i++) {
					LeccionMaterialBean material_anterior = lstMaterialBean.get(i);
					if(posicionMaterial == i){
						codMaterial = material_anterior.getCodigo();
						break;
					}
				}
				
				if(codMaterial>0){
					MaterialTipoEjercicioBean filtro = new MaterialTipoEjercicioBean();
					filtro.getLeccionMaterialBean().setCodigo(codMaterial);
					filtro.getLeccionMaterialBean().setCodigoEncrypt(Encrypt.encrypt(String.valueOf(filtro.getLeccionMaterialBean().getCodigo())).replace("/", "$"));
					//filtro.getSituacionTipo().setCodigoRegistro(1);
					List<MaterialTipoEjercicioBean> listaEjercicios = this.fs.getMaterialTipoEjercicioService().getBuscarPorFiltros(filtro);			
					
					if(!VO.isEmptyList(listaEjercicios)){
						path+="/lengua/detalle/"+codlengua+"/nivel/"+codigoLE+"/unidad/"+codigoUnidad+"/leccion/"+codigoLeccion+"/material/"+filtro.getLeccionMaterialBean().getCodigoEncrypt();
					}else{
						path+="/lengua/detalle/"+codlengua+"/nivel/"+codigoLE+"/unidad/"+codigoUnidad+"/leccion/"+codigoLeccion;
					}
					
				}else{
					path+="/lengua/detalle/"+codlengua+"/nivel/"+codigoLE+"/unidad/"+codigoUnidad+"/leccion/"+codigoLeccion;
				}
				
				response.sendRedirect(path);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/haciaMaterial/{codlengua}/{codlenest}/{codunidad}/{codleccion}/{posicion}", method = RequestMethod.GET)
	public void	deLinkMaterialSelecciona(	@PathVariable("codlengua") String codlengua,
											@PathVariable("codlenest") String codigoLE,
											@PathVariable("codunidad") String codigoUnidad,
											@PathVariable("codleccion") String codigoLeccion,
											@PathVariable("posicion")  String posicion,
											HttpServletRequest request,HttpServletResponse response){
		try {
			posicionMaterial = VO.toInteger(posicion);
			posEjercicio = 0;
			String path = request.getContextPath();
			path+="/lengua/detalle/"+codlengua+"/nivel/"+codigoLE+"/unidad/"+codigoUnidad+"/leccion/"+codigoLeccion;
			response.sendRedirect(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/haciaEjercicio/{codlengua}/{codlenest}/{codunidad}/{codleccion}/{codmaterial}/{posicion}", method = RequestMethod.GET)
	public void	deLinkEjercicioSelecciona(	@PathVariable("codlengua") String codlengua,
											@PathVariable("codlenest") String codigoLE,
											@PathVariable("codunidad") String codigoUnidad,
											@PathVariable("codleccion") String codigoLeccion,
											@PathVariable("codmaterial") String codmaterial,
											@PathVariable("posicion")  String posicion,
											HttpServletRequest request,HttpServletResponse response){
		try {
			LeccionMaterialBean filtro = new LeccionMaterialBean();
			filtro.getUnidadLeccionBean().setCodigo(VO.toLong(Encrypt.decrypt(codigoLeccion.replace("$", "/"))));
			lstMaterialBean = this.fs.getLeccionMaterialService().buscarPorLeccion(filtro);
			
			for (int i = 0; i < lstMaterialBean.size(); i++) {
				if(lstMaterialBean.get(i).getCodigo() == VO.toLong(Encrypt.decrypt(codmaterial.replace("$", "/")))){
					posicionMaterial = i;
					break;
				}
			}
			
			posEjercicio = VO.toInteger(posicion);
			
			String path = request.getContextPath();
			path+="/lengua/detalle/"+codlengua+"/nivel/"+codigoLE+"/unidad/"+codigoUnidad+"/leccion/"+codigoLeccion+"/material/"+codmaterial;
			response.sendRedirect(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/activarAnimacionMascota", method = RequestMethod.GET)
	@ResponseBody
	public Integer activarAnimacionMascota(	@RequestParam("valor") String valor,
											HttpServletRequest request){
		Integer retorno =  VO.toInteger(valor);
		
		request.getSession().setAttribute("swActivoMascotaAnim", retorno);
		
		return retorno;
	}
	
	private String getUrlEjercicio(Integer tipo, Integer flgPregu){
		String url = null;
		
		switch (tipo) {
			 
			case 1: url = "ejercicios/texto-texto";
					break;
			case 2: if(flgPregu==1){
						url = "ejercicios/marcar-alternativas";
					}else{
						url = "ejercicios/preguntas-respuestas";
					}
		 			break;
			case 3: url = "ejercicios/texto-palabras-correctas";
					break;
			case 4: url = "ejercicios/ejercicio-03"; // NO ESTA ACTIVO PARA REGISTRO EN MAESTRA
					break;
			case 5: url = "ejercicios/ejercicio-05"; // NO ESTA ACTIVO PARA REGISTRO EN MAESTRA
					break;
			case 6: url = "ejercicios/ejercicio-06"; // NO ESTA ACTIVO PARA REGISTRO EN MAESTRA
					break;
			case 8: url = "ejercicios/ejercicio-07"; // NO ESTA ACTIVO PARA REGISTRO EN MAESTRA
					break;
			case 9: url = "ejercicios/texto-palabras-encerradas";
					break;
			case 18: url = "ejercicios/texto-imagen"; 
					break;
			case 19: url = "ejercicios/arrastrar-oracion";
					break;
			case 22: url = "ejercicios/ordenar-parrafos";
					break;
			case 24: url = "ejercicios/relacion-variada";
					break;
			case 26: url = "ejercicios/crucigrama";
					break;
			case 27: url = "ejercicios/completar-oracion";
					break;
			case 30: url = "ejercicios/texto-texto-texto";
					break;
			case 31: url = "ejercicios/texto-texto-imagen";
					break;
			case 35: url = "ejercicios/partes-documento-texto";
					break;
			case 37: url = "ejercicios/texto-parrafo";
					break;
			case 38: url = "ejercicios/input-texto-oracion";
					break;
			default:
				break;
		}
		
		return url;
	}
	 
	
	
	
	private UsuarioMatriculaBean obtenerUsuarioMatricula(long  codusuario,long codlengua){
		UsuarioMatriculaBean  Bean = new UsuarioMatriculaBean();
		Bean.setUsuarioBean(new  UsuarioBean());
		Bean.getUsuarioBean().setCodigo(Long.valueOf(codusuario));
		Bean.setInscripcionLenguaBean(new InscripcionLenguaBean());
		Bean.getInscripcionLenguaBean().setLenguainscr(new LenguaBean());
		Bean.getInscripcionLenguaBean().getLenguainscr().setCodigo(Long.valueOf(codlengua));
		UsuarioMatriculaBean alumnoMG = null;
		try {
			alumnoMG = this.fs.getUsuarioMatriculaService().getBuscarPorObjecto(Bean);
			if (alumnoMG != null) {
				System.out.println("getCodigo() :: "+ alumnoMG.getCodigo()); 
				 
				
			}else{
				System.out.println("Obj vacio.");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return alumnoMG;
	}
	
	
	//daniel listarParrafos	
	@RequestMapping(value = "/listarParrafos", method = RequestMethod.GET)
	@ResponseBody 
	public List<OrdenarParrafoBean> doListarParrafos(@RequestParam("p_codmatpej") Integer p_codmatpej)
	{
		OrdenarParrafoBean ordenarParrafoBean = new OrdenarParrafoBean();
		ordenarParrafoBean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());

		ordenarParrafoBean.getMaterialTipoEjercicioBean().setCodigo(p_codmatpej);
		
		List<OrdenarParrafoBean> lstOrdenarParrafoBean  = new ArrayList<OrdenarParrafoBean>();
		try{
			lstOrdenarParrafoBean =  this.fs.getOrdenarParrafoService().listarTodosParrafos(ordenarParrafoBean);
			if (lstOrdenarParrafoBean != null && lstOrdenarParrafoBean.size() >0) {
				
				System.out.println("lstOrdeCabeceraBeans"+lstOrdenarParrafoBean);
			}else{
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstOrdenarParrafoBean;
	}	
	//Daniel listarTextoImagen
	@RequestMapping(value = "/listarTextoImagen", method = RequestMethod.GET)
	@ResponseBody 
	public List<RelacionBean> doListarTextoImagen(@RequestParam("p_codmatpej") Integer p_codmatpej)
	{
		System.out.println("--- listarTextoImagen ---");
		RelacionBean relacionBean = new RelacionBean();
		relacionBean.setRelacionCabeceraBean(new RelacionCabeceraBean());
		relacionBean.getRelacionCabeceraBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		
		relacionBean.getRelacionCabeceraBean().getMaterialTipoEjercicioBean().setCodigo(p_codmatpej);
		
		List<RelacionBean> lstRelacionBeans = null;
		try {  
			lstRelacionBeans = this.fs.getRelacionService().listarRelacionTodo(relacionBean);
			if (lstRelacionBeans != null && lstRelacionBeans.size() >0) {
				System.out.println("Lista _:" + lstRelacionBeans.size());
				Encrypt.init("KEY_ENCRYPT_PREGU");
				for (int i = 0; i <lstRelacionBeans.size(); i++) {
					lstRelacionBeans.get(i).setValPreguEncrypt(Encrypt.encrypt(VO.toString(lstRelacionBeans.get(i).getCodigo())));
				}
				Encrypt.init("KEY_ENCRYPT_ALTER");
				for (int i = 0; i <lstRelacionBeans.size(); i++) {
					lstRelacionBeans.get(i).setValAlterEncrypt(Encrypt.encrypt(VO.toString(lstRelacionBeans.get(i).getCodigo())));
				}
				Encrypt.init("KEY_ENCRYPT_REL");
				for (int i = 0; i <lstRelacionBeans.size(); i++) {
					lstRelacionBeans.get(i).setValRelEncrypt(Encrypt.encrypt(VO.toString(lstRelacionBeans.get(i).getCodigo())));
				}
	 
			}else{
				System.out.println("Lista vacia");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstRelacionBeans;
	}
	
	private AlumnoMonedaGBean monedasGemasObtenidas(long  usuariomatricula){
		AlumnoMonedaGBean  Bean = new AlumnoMonedaGBean();
		Bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
		Bean.getUsuarioMatriculaBean().setCodigo(Long.valueOf(usuariomatricula));
		AlumnoMonedaGBean alumnoMG = null;
		try {
			alumnoMG = this.fs.getAlumnoMonedaGService().getBuscarPorObjecto(Bean);
			if (alumnoMG != null) {
				System.out.println("getCodigo() :: "+ alumnoMG.getCodigo());
				System.out.println("MONEDAS :: "+ alumnoMG.getNumeroMonedas());
				System.out.println("GEMAS :: "+ alumnoMG.getNumeroGemas());
				 
				
			}else{
				System.out.println("Obj vacio.");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return alumnoMG;
	}
	
	@RequestMapping(value = "/BuscarintentosRealizadosPorejercicio", method = RequestMethod.POST)
	@ResponseBody 
	public SeguimientoAlumIntentoBean doBuscarintentosRealizadosPorejercicio(@RequestParam("usuariomatricula") Long  usuariomatricula, @RequestParam("matejercicio") Long  matejercicio)
	{
		SeguimientoAlumIntentoBean  Bean = new SeguimientoAlumIntentoBean();
		Bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
		Bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		Bean.getUsuarioMatriculaBean().setCodigo(Long.valueOf(usuariomatricula));
		Bean.getMaterialTipoEjercicioBean().setCodigo(Long.valueOf(matejercicio));
		SeguimientoAlumIntentoBean segintento = null;  
		try {
			segintento = this.fs.getSeguimientoAlumIntentoService().getBuscarPorObjecto(Bean);
			if (segintento != null) {
				System.out.println("getCodigo() :: "+ segintento.getCodigo());
				System.out.println("intento 	:: "+ segintento.getNumeroIntento());  
			}else{
				System.out.println("Obj vacio.");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return segintento;
	} 
	
	
	@RequestMapping(value = "/BuscarGemasMonedasXcategoria", method = RequestMethod.POST)
	@ResponseBody 
	public PremioConfiguracionBean doBuscarGemasMonedasXcategoria(@RequestParam("p_tm2categ") Integer  categoria)
	{
		PremioConfiguracionBean  Bean = new PremioConfiguracionBean();
		Bean.setCategoria(new MaestraBean()); 
		Bean.getCategoria().setCodigoRegistro(categoria);
		PremioConfiguracionBean pcb = null;  
		try {
			pcb = this.fs.getPremioConfiguracionService().getBuscarPorObjecto(Bean);
			if (pcb != null) {
				System.out.println("getCodigo() :: "+ pcb.getCodigo()); 
			}else{
				System.out.println("Obj vacio.");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pcb;
	} 
	
	@RequestMapping(value = "/grabarBonoAlumno", method = RequestMethod.POST)
	@ResponseBody
	public String dograbarBonoAlumno(@RequestParam("p_codusumat") Integer usuarioMatricula, 
			@RequestParam("p_codundlec") Integer leccion, HttpServletRequest request ) {
		AlumnoBonoBean  Bean = new AlumnoBonoBean();
		Bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean()); 
		Bean.setUnidadLeccionBean(new UnidadLeccionBean()); 
		Bean.getUsuarioMatriculaBean().setCodigo(Long.valueOf(usuarioMatricula));  
		Bean.getUnidadLeccionBean().setCodigo(Long.valueOf(leccion));  
	  
		 long valor=0;
			try {  	this.setAuditoria(Bean, request, true);
					this.fs.getAlumnoBonoService().insertar(Bean); 
					System.out.println("Se inserto bono con exito");
					valor = Bean.getCodigo();
			 } catch (ServiceException e) {
			 e.printStackTrace();
			 } 
			 return String.valueOf(valor); 
		}
	 
	
	@RequestMapping(value = "/grabarMedallaAlumno", method = RequestMethod.POST)
	@ResponseBody
	public String dograbarMedallaAlumno(@RequestParam("p_codusumat") Integer usuarioMatricula, 
			@RequestParam("p_codcateg") Integer categoria,@RequestParam("p_codundlec") Integer leccion, HttpServletRequest request ) {
		AlumnoMedallaBean  Bean = new AlumnoMedallaBean();
		Bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean()); 
		Bean.setUnidadLeccionBean(new UnidadLeccionBean()); 
		Bean.getUsuarioMatriculaBean().setCodigo(Long.valueOf(usuarioMatricula));  
		Bean.getUnidadLeccionBean().setCodigo(Long.valueOf(leccion));  
		Bean.setCodcateg(categoria);  
		 long valor=0;
			try {  	this.setAuditoria(Bean, request, true);
					this.fs.getAlumnoMedallaService().insertar(Bean); 
					System.out.println("Se inserto medalla con exito");
					valor = Bean.getCodigo();
			 } catch (ServiceException e) {
			 e.printStackTrace();
			 } 
			 return String.valueOf(valor); 
		} 
	
	
	@RequestMapping(value = "/BuscarMedallaObtenida", method = RequestMethod.POST)
	@ResponseBody 
	public PremioBean doBuscarMedallaObtenida(@RequestParam("p_codaluxmeda") Long  codalumedalla)
	{
		PremioBean  Bean = new PremioBean();
		Bean.setAlumnoMedallaBean(new AlumnoMedallaBean()); 
		Bean.getAlumnoMedallaBean().setCodigo(Long.valueOf(codalumedalla)); 
		
		PremioBean prem = null;  
		try {
			prem = this.fs.getPremioService().getBuscarPoraluMedalla(Bean);
			if (prem != null) {
				System.out.println("getCodigo() :: "+ prem.getCodigo());  
			}else{
				System.out.println("Obj vacio.");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prem;
	}
	
	
	
	
	
	@RequestMapping(value = "/InsertarIntentoAlumnoEjercicio", method = RequestMethod.POST)
	@ResponseBody
	public String doInsertarIntentoAlumnoEjercicio(@RequestParam("p_codmatpej") Integer ejercicio,
		@RequestParam("p_codsegaluinten") Integer codigo, @RequestParam("p_codusumat") Integer usuarioMatricula,HttpServletRequest request ) {
		SeguimientoAlumIntentoBean  Bean = new SeguimientoAlumIntentoBean();
		Bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
		Bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		Bean.getUsuarioMatriculaBean().setCodigo(Long.valueOf(usuarioMatricula));  
		Bean.getMaterialTipoEjercicioBean().setCodigo(ejercicio);  
		Bean.setCodigo(codigo);
		  
			try {
				if (Bean.getCodigo() != 0) {
					this.setAuditoria(Bean, request, false);
					this.fs.getSeguimientoAlumIntentoService().actualizar(Bean);
					System.out.println("Se actualizo moneda con exito");
				}else{ 
					this.setAuditoria(Bean, request, true);
					this.fs.getSeguimientoAlumIntentoService().insertar(Bean); 
					System.out.println("Se inserto moneda con exito");
				}

			 } catch (ServiceException e) {
			 e.printStackTrace();
			 } 
			 return String.valueOf(Bean); 
		} 
	
	
	@RequestMapping(value = "/BuscarintentosRealizadosPorejerDet", method = RequestMethod.POST)
	@ResponseBody 
	public SeguimientoAlumIntentoBean doBuscarintentosRealizadosPorejerDet(@RequestParam("usuariomatricula") Long  usuariomatricula, @RequestParam("matejercicio") Long  matejercicio, @RequestParam("codpregun") Long  codpregun)
	{
		SeguimientoAlumIntentoBean  Bean = new SeguimientoAlumIntentoBean();
		Bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
		
		Bean.setPreguntaBean(new PreguntaBean());
		Bean.getPreguntaBean().setCodigo(Long.valueOf(codpregun));
		
		Bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		Bean.getUsuarioMatriculaBean().setCodigo(Long.valueOf(usuariomatricula));
		Bean.getMaterialTipoEjercicioBean().setCodigo(Long.valueOf(matejercicio));
		SeguimientoAlumIntentoBean segintento = null;  
		try {
			segintento = this.fs.getSeguimientoAlumIntentoService().getBuscarPorObjectoDet(Bean);
			if (segintento != null) {
				System.out.println("getCodigo() :: "+ segintento.getCodigo());
				System.out.println("intento 	:: "+ segintento.getNumeroIntento());  
			}else{
				System.out.println("Obj vacio.");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return segintento;
	}
	
	@RequestMapping(value = "/InsertarIntentoAlumnoEjercicioDet", method = RequestMethod.POST)
	@ResponseBody
	public String doInsertarIntentoAlumnoEjercicioDet(@RequestParam("p_codmatpej") String ejercicio,
													  @RequestParam("p_codsegaluinten") String codigo, 
													  @RequestParam("p_codusumat") Integer usuarioMatricula , 
													  @RequestParam("p_codpregun") String codpregun ,
													  HttpServletRequest request ) {
		SeguimientoAlumIntentoBean  Bean = new SeguimientoAlumIntentoBean();
		Bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
		Bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		Bean.setPreguntaBean(new PreguntaBean());
		Bean.getPreguntaBean().setCodigo(Long.valueOf(codpregun)); 
		//Bean.getPreguntaBean().setCodigo(Long.valueOf(Encrypt.decrypt(codpregun))); 
		Bean.getUsuarioMatriculaBean().setCodigo(Long.valueOf(usuarioMatricula)); 
		//Bean.getUsuarioMatriculaBean().setCodigo(Long.valueOf(Encrypt.decrypt(usuarioMatricula)));  
		Bean.getMaterialTipoEjercicioBean().setCodigo(Long.valueOf(ejercicio));  
		//Bean.getMaterialTipoEjercicioBean().setCodigo(Encrypt.decrypt(ejercicio));  
		Bean.setCodigo(Long.valueOf(codigo));
		  
			try {
				if (Bean.getCodigo() != 0) {
					this.setAuditoria(Bean, request, false);
					this.fs.getSeguimientoAlumIntentoService().actualizarDet(Bean);
					System.out.println("Se actualizo intento con exito");
				}else{ 
					this.setAuditoria(Bean, request, true);
					this.fs.getSeguimientoAlumIntentoService().insertarDet(Bean); 
					System.out.println("Se inserto intento con exito");
				}

			 } catch (ServiceException e) {
			 e.printStackTrace();
			 } 
			 return String.valueOf(Bean); 
		}
	
	
	@RequestMapping(value = "/grabarSeguimientoAlumnoEjerDet", method = RequestMethod.POST)
	@ResponseBody
	public Long doGrabarSeguimientoejerDet(@RequestParam("idEjercicio") Integer idEjercicio,@RequestParam("codpregunta") Integer pregunta,
			 					   @RequestParam("numeroMonedas") Integer numeroMonedas,
			 					   @RequestParam("idLengua") Integer idLengua,
		 	 					   @RequestParam("idUsuario") Integer idUsuario,HttpServletRequest request){
		System.out.println("-----Ingreso a grabarSeguimientoAlumnoEjercicio ----");
		SeguimientoAlumnoEjerDetBean seguimientoAlumnoEjercicioBean = new SeguimientoAlumnoEjerDetBean();
		seguimientoAlumnoEjercicioBean.setPreguntaBean(new PreguntaBean());
		seguimientoAlumnoEjercicioBean.getPreguntaBean().setCodigo(pregunta);
		//seguimientoAlumnoEjercicioBean.getPreguntaBean().setCodigo(Encrypt.decrypt(pregunta));
		seguimientoAlumnoEjercicioBean.getMaterialTipoEjercicioBean().setCodigo(idEjercicio);
		//seguimientoAlumnoEjercicioBean.getMaterialTipoEjercicioBean().setCodigo(Encrypt.decrypt(idEjercicio));
		seguimientoAlumnoEjercicioBean.getLenguaBean().setCodigo(idLengua);
		//seguimientoAlumnoEjercicioBean.getLenguaBean().setCodigo(Encrypt.decrypt(idLengua));
		seguimientoAlumnoEjercicioBean.getUsuarioBean().setCodigo(idUsuario);
		seguimientoAlumnoEjercicioBean.setNumeroMonedas(numeroMonedas);
		 
		
		long valor = 0;
		try {
				this.setAuditoria(seguimientoAlumnoEjercicioBean, request, true);
				this.fs.getSeguimientoAlumnoEjerDetService().insertar(seguimientoAlumnoEjercicioBean);
				valor = seguimientoAlumnoEjercicioBean.getCodigo();
				
							
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;
		}
	
	
	 
	
	/**Daniel número intentos por ejercicio.**/
	
	private IntentoConfiguracionBean numeroIntentosEjercicio(int  tipoEjercicio){
		IntentoConfiguracionBean intentoConfiguracionBean = new IntentoConfiguracionBean();
		intentoConfiguracionBean.setEjercicio(new MaestraBean());
		intentoConfiguracionBean.getEjercicio().setCodigo(Long.valueOf(tipoEjercicio));
		IntentoConfiguracionBean intento = null;
		try {
			intento = this.fs.getIntentoConfiguracionService().getBuscarPorObjecto(intentoConfiguracionBean);
			if (intento != null) {
				System.out.println("intento.getCodigo() :: "+ intento.getCodigo());
				System.out.println("intento.getIntento1() :: "+ intento.getIntento1());
				System.out.println("intento.getIntento2() :: "+ intento.getIntento2());
				System.out.println("intento.getIntento3() :: "+ intento.getIntento3());
				
			}else{
				System.out.println("Obj vacio.");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return intento;
	} 
	
	
	@RequestMapping(value = "/listarMascotaBeanSwPredet", method = RequestMethod.GET)
	@ResponseBody 
	public MascotaBean doListarMascotaBeanSwPredet(HttpServletRequest request)
	{
		UsuarioBean usuario = this.getUsuarioSesion(request);
		MascotaBean beanMascota= null;
		/** OBTENER MASCOTA **/
		MascotaBean	prMascotaBean = new MascotaBean();
		prMascotaBean.setAudCodigoUsuario(usuario.getCodigoUsuario());
		
		
		try {
			beanMascota = this.fs.getMascotaService().getlistarMasctoSwPredetAlumno(prMascotaBean);
			if (!VO.isNotNull(beanMascota)) {
				beanMascota=null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beanMascota;
	}	
	/**Daniel SeguimientoAlumnoPorEjercicio **/
	@RequestMapping(value = "/grabarSeguimientoAlumnoEjercicio", method = RequestMethod.POST)
	@ResponseBody
	public Long doGrabarTextoTexto(@RequestParam("idEjercicio") Integer idEjercicio,
			 					   @RequestParam("numeroMonedas") Integer numeroMonedas,
			 					   @RequestParam("idLengua") Integer idLengua,
		 	 					   @RequestParam("idUsuario") Integer idUsuario){
		System.out.println("-----Ingreso a grabarSeguimientoAlumnoEjercicio ----");
		SeguimientoAlumnoEjercicioBean seguimientoAlumnoEjercicioBean = new SeguimientoAlumnoEjercicioBean();
		seguimientoAlumnoEjercicioBean.getMaterialTipoEjercicioBean().setCodigo(idEjercicio);
		//seguimientoAlumnoEjercicioBean.getMaterialTipoEjercicioBean().setCodigo(Encrypt.decrypt(idEjercicio));
		seguimientoAlumnoEjercicioBean.getLenguaBean().setCodigo(idLengua);
		//seguimientoAlumnoEjercicioBean.getLenguaBean().setCodigo(Encrypt.decrypt(idLengua));
		seguimientoAlumnoEjercicioBean.getUsuarioBean().setCodigo(idUsuario);
		//seguimientoAlumnoEjercicioBean.getUsuarioBean().setCodigo(Encrypt.decrypt(idUsuario));
		seguimientoAlumnoEjercicioBean.setNumeroMonedas(numeroMonedas);
		seguimientoAlumnoEjercicioBean.setCodigoUsuarioCreacion(1);
		seguimientoAlumnoEjercicioBean.setIpCreacion("");
		
		long valor = 0;
		try {
			
				this.fs.getSeguimientoAlumnoEjercicioService().insertar(seguimientoAlumnoEjercicioBean);
				valor = seguimientoAlumnoEjercicioBean.getCodigo();
				
							
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;
		}
	
	@RequestMapping(value = "/ListArmarDocumentoTodoxTE", method = RequestMethod.GET)
	@ResponseBody 
	public List<ArmarDocumentoBean> doListArmarDocumentoTodoxTE(@RequestParam("p_codmatpej") Integer  codmatpej)
	{   
		ArmarDocumentoBean  filtro = new ArmarDocumentoBean();
		filtro.setArmarDocumentoCabBean(new ArmarDocumentoCabBean());
		filtro.getArmarDocumentoCabBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
		filtro.getArmarDocumentoCabBean().getMaterialTipoEjercicioBean().setCodigo(codmatpej);
		
		List<ArmarDocumentoBean> lstBean  = new ArrayList<ArmarDocumentoBean>();
		try{
			lstBean = this.fs.getArmarDocumentoService().listarArmarDocuCabDetTodo(filtro);
			if (lstBean != null && lstBean.size() >0) {
				
				System.out.println("lista ArmarDocumentoBean---------------------------> "+ lstBean.size());
				System.out.println("lstBean.get(0).getArmarDocumentoCabBean().getTitulo(): " + lstBean.get(0).getArmarDocumentoCabBean().getTitulo());
			}else{
				System.out.println("lista ArmarDocumentoBean: Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstBean;
	}
	/**Daniel  evalucion **/
	@RequestMapping(value = "/actulizarEjercicioEvaluacion", method = RequestMethod.POST)
	@ResponseBody
	public Long doActulizarEjercicioEvaluacion(@RequestParam("idEva") Integer idEva,
			 					   @RequestParam("correccionEva") String correccionEva,
			 					   HttpServletRequest request,
			 					   HttpServletResponse response){
		System.out.println("-----Ingreso a doActulizarEjercicioEvaluacion ----");		
		long valor = 0;
		try {
			EvaluacionDetalleBean evaluacionDetalleBean = new EvaluacionDetalleBean();
			evaluacionDetalleBean.setCodigo(idEva); 
			evaluacionDetalleBean.setAprobado(correccionEva);
			evaluacionDetalleBean.getSituacionEvaluacionDetalle().setCodigoRegistro(2);
			
			this.setAuditoria(evaluacionDetalleBean, request, false);
			this.fs.getEvaluacionDetalleService().actualizar(evaluacionDetalleBean);
			valor = evaluacionDetalleBean.getCodigo();
		
							
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;
		}
	@RequestMapping(value = "/actulizarEvaluacion", method = RequestMethod.POST)
	@ResponseBody
	public Long doActulizarEvaluacion(@RequestParam("p_codeva") Long p_codeva,
			 					   	  @RequestParam("p_tm1siteva") int p_tm1siteva,
			 					   HttpServletRequest request,
			 					   HttpServletResponse response){
		System.out.println("-----Ingreso a doActulizarEjercicioEvaluacion ----");		
		
		try {

			EvaluacionBean evaluacion = new EvaluacionBean();
			evaluacion.setCodigo(p_codeva);
			evaluacion.getSituacionEvaluacion().setCodigoRegistro(p_tm1siteva);
			
			this.setAuditoria(evaluacion, request, false);
			this.fs.getEvaluacionService().actualizar(evaluacion);
			
			this.getEvaluacionBean().setCodigo(p_codeva);
		
							
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return p_codeva;
		}
	@RequestMapping(value = "/{codigoLengua}/evaluacion/{codEvaluacion}", method = RequestMethod.GET)
	@ResponseBody 
	public ModelAndView cargarEjerciciosEvaluacion( 
										  @PathVariable("codigoLengua") String codigoLengua,
										  @PathVariable("codEvaluacion") String codEvaluacion,
										  HttpServletRequest request,
										  HttpServletResponse response) {
		
		ModelAndView mav = null;
		UsuarioBean usuario = this.getUsuarioSesion(request);
		MascotaBean beanMascota= null; 
		int swActivoMascotaAnim = 0;
		
		long hora = 0L;
		long minuto = 0L;
		long segundo = 0L;
		
		UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
		
		List<MaestraBean> lstMaestraBeans = new ArrayList<MaestraBean>();
		MaestraBean maestraBean =  new MaestraBean();
		try {
			EvaluacionDetalleBean evaluacionDetalleBean = new EvaluacionDetalleBean();
//			evaluacionDetalleBean.getEvaluacionBean().setCodigo(VO.toLong(codEvaluacion));
			evaluacionDetalleBean.getEvaluacionBean().setCodigo(VO.toLong(Encrypt.decrypt(codEvaluacion.replace("$", "/"))));
//			this.getEvaluacionBean().setCodigo(VO.toLong(codEvaluacion));
			this.getEvaluacionBean().setCodigo(VO.toLong(Encrypt.decrypt(codEvaluacion.replace("$", "/"))));
			
			
			EvaluacionBean eva = new EvaluacionBean();
			//eva.setCodigo(VO.toLong(codEvaluacion));//.replace("$", "/")
			eva.setCodigo(VO.toLong(Encrypt.decrypt(codEvaluacion.replace("$", "/"))));
			EvaluacionBean oEvaluacionBean = new EvaluacionBean();
			
			oEvaluacionBean = this.fs.getEvaluacionService().getBuscarPorObjecto(eva);
			
			if (oEvaluacionBean != null) {
				//DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				//Date date = new Date();
				if(oEvaluacionBean.getVfechaeve() == null || oEvaluacionBean.getVfechaeve().trim().length() == 0){
				//if(oEvaluacionBean.getFechaHoraEvaluacion() == null){
					//oEvaluacionBean.setFechaHoraEvaluacion(date);
					this.fs.getEvaluacionService().actualizarFechaEvaluacion(oEvaluacionBean);
					oEvaluacionBean = this.fs.getEvaluacionService().getBuscarPorObjecto(eva);
				}
				//convertir de String a Date
				SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				oEvaluacionBean.setFechaHoraEvaluacion(formato.parse(oEvaluacionBean.getVfechaeve()));
				
				Date fechaActual = formato.parse(oEvaluacionBean.getVfechaactual());
				//Calcular milisegundos hora de evaluacion
				Calendar cal = Calendar.getInstance();
				cal.setTime(oEvaluacionBean.getFechaHoraEvaluacion());
				long fechaHoraEvalacionMilisegundos = cal.getTimeInMillis();
				//Calcular milisegundos hora actual
				cal.setTime(fechaActual);
				long fechaHoraActualMilisegundos = cal.getTimeInMillis();
				//determinar la diferencia
				//long diferenciaMilisegundos = (fechaHoraActualMilisegundos - fechaHoraEvalacionMilisegundos) / 1000;
				long diferenciaMilisegundos = fechaHoraActualMilisegundos - fechaHoraEvalacionMilisegundos;
				
				hora = diferenciaMilisegundos/3600000;
				long restohora = diferenciaMilisegundos%3600000;
				minuto = restohora/60000;
				long restominuto = restohora%60000;
				segundo = restominuto/1000;
				long restosegundo = restominuto%1000;
				
				System.out.println(hora + ":" + minuto + ":" + segundo + "." + restosegundo);
				
				usuarioMatriculaBean.setCodigo(oEvaluacionBean.getUsuarioMatriculaBean().getCodigo());
			}else{
				System.out.println("obj null");
				
			}
			
			/** CARGAR MATERIAL **/
//			LeccionMaterialBean filtroMaterial = new LeccionMaterialBean();
//			filtroMaterial.getUnidadLeccionBean().setCodigo(VO.toLong(codigoLeccion));
//			lstMaterialBean = this.fs.getLeccionMaterialService().buscarPorLeccion(filtroMaterial);
//			
//			if(!VO.isEmptyList(lstMaterialBean)){
//				for (int i = 0; i < lstMaterialBean.size(); i++) {
//					LeccionMaterialBean material_actual = lstMaterialBean.get(i);
//					if(material_actual.getCodigo() == VO.toLong(codigoMaterial)){
//						posicionMaterial = i+1;
//						break;
//					}
//				}
//			}
			
			/** OBTENER DATOS DEL MATERIAL DE LA LECCION **/
//			LeccionMaterialBean prmLeccionMaterialBean = new LeccionMaterialBean();
//			prmLeccionMaterialBean.setCodigo(VO.toLong(codigoMaterial));
//			leccionMaterialBean = this.fs.getLeccionMaterialService().getBuscarPorObjecto(prmLeccionMaterialBean);
				
			/** OBTENER DATOS DE LA LECCION DE LA UNIDAD **/
//			UnidadLeccionBean prmUnidadLeccionBean = new UnidadLeccionBean();
//			prmUnidadLeccionBean.setCodigo(VO.toLong(codigoLeccion));
//			unidadLeccionBean = this.fs.getUnidadLeccionService().getBuscarPorObjecto(prmUnidadLeccionBean);
				
			/** OBTENER DATOS DE LA UNIDAD **/
//			UnidadBean prmUnidadBean = new UnidadBean();
//			prmUnidadBean.setCodigo(VO.toLong(codigoUnidad));
//			unidadBean = this.fs.getUnidadService().getBuscarPorObjecto(prmUnidadBean);
				
			/** OBTENER DATOS DE LA ESTRUCTURA DE LA LENGUA (NIVEL - SUBNIVEL) **/
//			LenguaEstructuraBean prmLenguaEstBean = new LenguaEstructuraBean();
//			prmLenguaEstBean.setCodigo(VO.toLong(codigoLE));
//			lenguaEstructuraBean = this.fs.getLenguaEstructuraService().getBuscarPorObjecto(prmLenguaEstBean);
			
			/** OBTENER DATOS DE LA LENGUA **/
//			LenguaBean prmLenguaBean = new LenguaBean();
//			prmLenguaBean.setCodigo(VO.toLong(codlengua));
//			lenguaBean = this.fs.getLenguaService().getBuscarPorObjecto(prmLenguaBean);
			
			/** OBTENER MASCOTA **/
			MascotaBean	prMascotaBean = new MascotaBean();
			prMascotaBean.setAudCodigoUsuario(usuario.getCodigoUsuario());
			beanMascota = this.fs.getMascotaService().getlistarMasctoSwPredetAlumno(prMascotaBean);
			
			swActivoMascotaAnim = (!VO.isNull(request.getSession().getAttribute("swActivoMascotaAnim"))) ? (Integer) request.getSession().getAttribute("swActivoMascotaAnim") : 0;
			
			if (VO.isNotNull(beanMascota)) {
				System.out.println(" beanMascota.getImagenTienda() " + beanMascota.getImagenTienda());
			}
			
			/** OBTENER MENSAJES **/
			MensajesBean filtroMsj = new MensajesBean();
			filtroMsj.setLenguaBean(new LenguaBean());
//			filtroMsj.getLenguaBean().setCodigo(VO.toLong(codigoLengua));
			filtroMsj.getLenguaBean().setCodigo(VO.toLong(Encrypt.decrypt(codigoLengua.replace("$", "/"))));
			lstMensajes = this.fs.getMensajeService().getBuscarPorFiltros(filtroMsj);
			
			/**Obtener Glosario**/
			GlosarioBean filtroGlosario = new GlosarioBean();
			filtroGlosario.setLenguaBean(new LenguaBean());
//			filtroGlosario.getLenguaBean().setCodigo(VO.toLong(codigoLengua));
			filtroGlosario.getLenguaBean().setCodigo(VO.toLong(Encrypt.decrypt(codigoLengua.replace("$", "/"))));
			glosario = this.fs.getGlosarioService().getBuscarPorObjecto(filtroGlosario);
			
			/** CARGAR EJERCICIOS **/
//			MaterialTipoEjercicioBean filtro = new MaterialTipoEjercicioBean();
//			filtro.getLeccionMaterialBean().setCodigo(VO.toLong(codigoMaterial));
//			//filtro.getSituacionTipo().setCodigoRegistro(1);
//			lstMaterialTipoEjBean = this.fs.getMaterialTipoEjercicioService().getBuscarPorFiltros(filtro);	
			
			List<EvaluacionDetalleBean> lstEvaluacionDetalleBeans = new ArrayList<EvaluacionDetalleBean>();
			lstEvaluacionDetalleBeans = this.fs.getEvaluacionDetalleService().getBuscarPorFiltros(evaluacionDetalleBean);
			if (lstEvaluacionDetalleBeans != null && lstEvaluacionDetalleBeans.size() > 0) {
				System.out.println("lstEvaluacionDetalleBeans.size()"+ lstEvaluacionDetalleBeans.size());
			}else{
				System.out.println("lst vacia");
			}
			
			lstMaestraBeans = this.fs.getMaestra2Service().listarPorCodigoTabla("notaAprobatoria", 0);
			
			if (lstMaestraBeans != null) {
				
				maestraBean = lstMaestraBeans.get(0);
				
				System.out.println("lstMaestraBeans.get(0).getNombreCorto()"+ lstMaestraBeans.get(0).getNombreCorto());
				
			}else{
				
				System.out.println("lstMaestraBeans es  null");
			}
				
				mav = new ModelAndView("ejercicios/ejercicio-contenedor-evaluacion", "command",lstEvaluacionDetalleBeans);
				mav.addObject("lstEvaluacionDetalleBeans", lstEvaluacionDetalleBeans);
//				mav.addObject("material", leccionMaterialBean);
//				mav.addObject("lstMaterialTipoEjBean", lstMaterialTipoEjBean);
//				mav.addObject("lenguaBean", lenguaBean);
//				mav.addObject("lenguaEstructuraBean", lenguaEstructuraBean);
//				mav.addObject("unidadBean", unidadBean);
//				mav.addObject("unidadLeccionBean", unidadLeccionBean);
//				mav.addObject("beanMascota", beanMascota);
//				mav.addObject("usuarioMatriculaBean", usuarioMatriBean);
//				mav.addObject("alumnoMonedaGBean", AlumnoMonedaGemaBean);
				mav.addObject("swEsUltimoEj", swEsUltimoEj);
				mav.addObject("posEjercicio", posEjercicio);
				mav.addObject("tipoEvaluacion",oEvaluacionBean.getTipoEvaluacion().getCodigoRegistro());
				mav.addObject("codEvaluacion", Encrypt.decrypt(codEvaluacion.replace("$", "/")));
				mav.addObject("codEncryptEvaluacion", codEvaluacion);
				mav.addObject("swActivoMascotaAnim", swActivoMascotaAnim);
				mav.addObject("lstMensajes",lstMensajes);
				mav.addObject("codigoLengua", Encrypt.decrypt(codigoLengua.replace("$", "/")));
//				mav.addObject("codigoEncryptLengua", Encrypt.encrypt(codigoLengua).replace("/", "$"));
				mav.addObject("codigoEncryptLengua", codigoLengua);
				mav.addObject("glosarioBean", glosario);
				mav.addObject("usuarioMatriculaBean", usuarioMatriculaBean);
				mav.addObject("maestraBean", maestraBean);
				mav.addObject("hora", hora);
				mav.addObject("minuto", minuto);
				mav.addObject("segundo", segundo);
				
					
//			}else{
//				String path = request.getContextPath();
//				path+="/evaluacion/"+codEvaluacion;
//				response.sendRedirect(path);
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/insertarEvaluacion", method = RequestMethod.POST)
	@ResponseBody
	public Long doinsertarEvaluacion(@RequestParam("p_codlengua") Integer p_codlengua,
								     @RequestParam("p_tm2SubNivel") Integer p_tm2SubNivel,
								     @RequestParam("p_codundlec") Integer leccion,
								     @RequestParam("p_codusumat") Integer p_codusumat,
								     @RequestParam("p_codnivel") Integer p_codnivel,
			 					     HttpServletRequest request,
			 					     HttpServletResponse response){
		System.out.println("-----Ingreso a insertarEvaluacion ----");		
		long valor = 0;
		try {
			
			EvaluacionBean evaluacionBean = new EvaluacionBean();
			
			evaluacionBean.setUnidadLeccionBean(new UnidadLeccionBean());
			evaluacionBean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().setCodigo(p_codlengua);
			evaluacionBean.getUsuarioMatriculaBean().setCodigo(p_codusumat);
			evaluacionBean.getNivel().setCodigoRegistro(p_codnivel);
			evaluacionBean.getSubNivel().setCodigoRegistro(p_tm2SubNivel);
			evaluacionBean.getUnidadLeccionBean().setCodigo(leccion);



			this.setAuditoria(evaluacionBean, request, true);
			this.fs.getEvaluacionService().insertar(evaluacionBean);
			valor = evaluacionBean.getCodigo();
//			getEvaluacionBean().setCodigo(evaluacionBean.getCodigo());
		
							
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;
		}
	@RequestMapping(value = "/obtenerEvaluacionxCod", method = RequestMethod.GET)
	@ResponseBody 
	public EvaluacionBean doObtenerEvaluacionxCod(@RequestParam("p_codevalua") Long  p_codevalua)
	{   
		System.out.println("p_codevalua " + p_codevalua);
		EvaluacionBean  filtro = new EvaluacionBean();
		filtro.setCodigo(p_codevalua);
		
		EvaluacionBean lstBean  = new EvaluacionBean();
		try{
			lstBean = this.fs.getEvaluacionService().getBuscarPorObjecto(filtro);
			if (VO.isNotNull(lstBean)) {
				
				System.out.println("lista EvaluacionBean---------------------------> "+ lstBean);
				System.out.println("EvaluacionBean codigo: " + lstBean.getCodigo());
				System.out.println("EvaluacionBean getNota: " + lstBean.getNota());
				System.out.println("EvaluacionBean getVfechaactual: " + lstBean.getVfechaactual());
				System.out.println("EvaluacionBean getVfechaini: " + lstBean.getVfechaini());
			}else{
				System.out.println("lista ArmarDocumentoBean: Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstBean;
	}
	

	@RequestMapping(value = "/obtenerLstEvaluacionxMsjNota", method = RequestMethod.GET)
	@ResponseBody 
	public List<MensajesBean> doObtenerLstEvaluacionxMsjNota(@RequestParam("p_codLengua") Long  p_codLengua,@RequestParam("p_codTipoMsj") int  p_codTipoMsj)
	{   
		System.out.println("p_codLengua " + p_codLengua);
		System.out.println("p_codTipoMsj " + p_codTipoMsj);
		
		/** OBTENER MENSAJES **/
		MensajesBean filtroMsj = new MensajesBean();
		filtroMsj.getLenguaBean().setCodigo(p_codLengua);
		filtroMsj.getTipoMensaje().setCodigoRegistro(p_codTipoMsj);
		
		List<MensajesBean> lstBean = new ArrayList<MensajesBean>();

		try{
			lstBean = this.fs.getMensajeService().getBuscarPorFiltros(filtroMsj);
			if (VO.isNotEmptyList(lstMensajes)) {
				
				System.out.println("lista EvaluacionBean---------------------------> "+ lstBean);
				System.out.println("EvaluacionBean codigo: " + lstBean.get(0).getMensajes());
			}else{
				System.out.println("lista EvaluacionBean: Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lstBean;
	}
	@RequestMapping(value = "/obtenerNota", method = RequestMethod.GET)
	@ResponseBody
	public Long doObtenerNota(@RequestParam("p_codeva") Long p_codeva,
			 					   HttpServletRequest request,
			 					   HttpServletResponse response){
		System.out.println("-----Ingreso a obtenerNota ----");		
		long valor = 0;
		try {

			EvaluacionBean evaluacion = new EvaluacionBean();
			evaluacion.setCodigo(p_codeva);
			
			this.setAuditoria(evaluacion, request, false);
			this.fs.getEvaluacionService().obtenerNota(evaluacion);
			this.setEvaluacionBean(evaluacion);
//			valor = evaluacion.getCodigo();
//			this.getEvaluacionBean().setCodigo(valor);
		
							
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;
		}
	
	@RequestMapping(value = "/pasarHistorico", method = RequestMethod.POST)
	@ResponseBody
	public int pasarHistorico(@RequestParam("p_codeva") Long p_codeva,
							   @RequestParam("p_codusumat") Long p_codusumat,
							   @RequestParam("p_tm2SubNivel") int p_tm2SubNivel,
			 					   HttpServletRequest request,
			 					   HttpServletResponse response){
		System.out.println("-----Ingreso a pasarHistorico ----");		
		int valor = 0;
		try {

			EvaluacionBean evaluacion = new EvaluacionBean();
			evaluacion.setCodigo(p_codeva);
			evaluacion.getUsuarioMatriculaBean().setCodigo(p_codusumat);
			evaluacion.getSubNivel().setCodigoRegistro(p_tm2SubNivel);
			
			this.setAuditoria(evaluacion, request, false);
			this.fs.getEvaluacionService().pasarHistorico(evaluacion);
			valor  = evaluacion.getRespuesta();
//			valor = evaluacion.getCodigo();
//			this.getEvaluacionBean().setCodigo(valor);
		
							
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;
		}
	@RequestMapping(value = "/calcularPromedioEva", method = RequestMethod.GET)
	@ResponseBody
	public int calcularPromedioEvaluacion(@RequestParam("p_codusumat") Long p_codusumat,
							   @RequestParam("p_codnivel") int p_codnivel,
			 					   HttpServletRequest request,
			 					   HttpServletResponse response){
		System.out.println("-----Ingreso a calcularPromedioEvaluacion ----");		
		
		int data = 0;
		try {

			MatriculaAlumnoBean matriculaAlumnoBean = new MatriculaAlumnoBean();
			
			matriculaAlumnoBean.setMatriculaBean(new MatriculaBean());
			matriculaAlumnoBean.getMatriculaBean().setNivel(new MaestraBean());
			
			matriculaAlumnoBean.getMatriculaBean().getNivel().setCodigoRegistro(p_codnivel);
			
			matriculaAlumnoBean.setUsuarioMatriculaBean(new UsuarioMatriculaBean());
			matriculaAlumnoBean.getUsuarioMatriculaBean().setCodigo(p_codusumat);
			
			this.setAuditoria(matriculaAlumnoBean, request, false);
			this.fs.getMatriculaAlumnoService().calcularPromedioEva(matriculaAlumnoBean);
			data = matriculaAlumnoBean.getRespuesta();
						
							
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return data;
		}
	
	@RequestMapping(value = "/insertarEvaluacionFinal", method = RequestMethod.GET)
	@ResponseBody
	public long insertarEvaluacionFinal(@RequestParam("p_codlengua") Integer p_codlengua,
								       
								       @RequestParam("p_codundlec") Integer leccion,
								       @RequestParam("p_codusumat") Integer p_codusumat,
								       @RequestParam("p_codnivel") Integer p_codnivel,
			 					       HttpServletRequest request,
			 					       HttpServletResponse response){
		System.out.println("-----Ingreso a insertar  evaluacion  final. ----");		
		long valor = 0;
		try {

			EvaluacionBean evaluacionBean = new EvaluacionBean();
			
			evaluacionBean.setUnidadLeccionBean(new UnidadLeccionBean());
			evaluacionBean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().setCodigo(p_codlengua);
			evaluacionBean.getUsuarioMatriculaBean().setCodigo(p_codusumat);
			evaluacionBean.getNivel().setCodigoRegistro(p_codnivel);
			//evaluacionBean.getSubNivel().setCodigoRegistro(p_tm2SubNivel);
			evaluacionBean.getUnidadLeccionBean().setCodigo(leccion);



			this.setAuditoria(evaluacionBean, request, true);
			this.fs.getEvaluacionService().insertarEvaluacionFinal(evaluacionBean);
			valor = evaluacionBean.getCodigo();
		
							
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return valor;
		}
	
	/** GETTER AND SETTER **/
	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	public LenguaEstructuraBean getLenguaEstructuraBean() {
		return lenguaEstructuraBean;
	}

	public void setLenguaEstructuraBean(LenguaEstructuraBean lenguaEstructuraBean) {
		this.lenguaEstructuraBean = lenguaEstructuraBean;
	}

	public UnidadBean getUnidadBean() {
		return unidadBean;
	}

	public void setUnidadBean(UnidadBean unidadBean) {
		this.unidadBean = unidadBean;
	}

	public UnidadLeccionBean getUnidadLeccionBean() {
		return unidadLeccionBean;
	}

	public void setUnidadLeccionBean(UnidadLeccionBean unidadLeccionBean) {
		this.unidadLeccionBean = unidadLeccionBean;
	}

	public LeccionMaterialBean getLeccionMaterialBean() {
		return leccionMaterialBean;
	}

	public void setLeccionMaterialBean(LeccionMaterialBean leccionMaterialBean) {
		this.leccionMaterialBean = leccionMaterialBean;
	}

	public EvaluacionBean getEvaluacionBean() {
		return evaluacionBean;
	}

	public void setEvaluacionBean(EvaluacionBean evaluacionBean) {
		this.evaluacionBean = evaluacionBean;
	}

	public LenguaEstructuraBean getLenguaEstructuraMayorBean() {
		return lenguaEstructuraMayorBean;
	}

	public void setLenguaEstructuraMayorBean(LenguaEstructuraBean lenguaEstructuraMayorBean) {
		this.lenguaEstructuraMayorBean = lenguaEstructuraMayorBean;
	}
	
	public UnidadLeccionBean getUltimaleccionxlenest() {
		return ultimaleccionxlenest;
	}

	public void setUltimaleccionxlenest(UnidadLeccionBean ultimaleccionxlenest) {
		this.ultimaleccionxlenest = ultimaleccionxlenest;
	}

	public UnidadLeccionBean getUltimaleccionxunidad() {
		return ultimaleccionxunidad;
	}

	public void setUltimaleccionxunidad(UnidadLeccionBean ultimaleccionxunidad) {
		this.ultimaleccionxunidad = ultimaleccionxunidad;
	}
	
	
	public  class LetraEncriptada{
		
		String letraEncriptada;
		int identificador;
		String letra;
		
		public String getLetraEncriptada() {
			return letraEncriptada;
		}
		public void setLetraEncriptada(String letraEncriptada) {
			this.letraEncriptada = letraEncriptada;
		}
		public int getIdentificador() {
			return identificador;
		}
		public void setIdentificador(int identificador) {
			this.identificador = identificador;
		}
		public String getLetra() {
			return letra;
		}
		public void setLetra(String letra) {
			this.letra = letra;
		}
		
	}	
	
}


