package pe.gob.procalidad.natigu.web.gestion.controller.academico;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Map.Entry;
import java.text.DecimalFormat;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMonedaGBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.SeguimientoAlumIntentoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionCabeceraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioPerfilBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.factory.interfaces.FactoryService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.EvaluacionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.SeguimientoAlumIntentoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.UsuarioPerfilService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.UsuarioService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.controller.ruta.lengua;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.FileUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.Row;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.Encrypt;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.EncryptException;

@Controller
@Scope(value="session")
@SessionAttributes("usuarioEstudiante")

@RequestMapping(value = "seguimiento")
public class SeguimientoController extends BaseController{
	
	@Autowired
	private SeguimientoAlumIntentoService		seguimientoAlumIntentoService; 
	private SeguimientoAlumIntentoBean 			seguimientoAlumIntentoBean; 
	
	
	@Autowired
	private EvaluacionService  evaluacionService ;
	
	private EvaluacionBean  evaluacionBean  ; 
	
	
	public EvaluacionBean getEvaluacionBean() {
		return evaluacionBean;
	}

	public void setEvaluacionBean(EvaluacionBean evaluacionBean) {
		this.evaluacionBean = evaluacionBean;
	}
	private String NombreSubni = "";
	public List<SeguimientoAlumIntentoBean> 	lstSeguimientoBean;
	public List<EvaluacionBean> 	lstEvaluacionBean;
	public List<EvaluacionBean> getLstEvaluacionBean() {
		return lstEvaluacionBean;
	}

	public void setLstEvaluacionBean(List<EvaluacionBean> lstEvaluacionBean) {
		this.lstEvaluacionBean = lstEvaluacionBean;
	}

	private UsuarioMatriculaBean 			usuarioMatriculaBean; 
	
	public UsuarioMatriculaBean getUsuarioMatriculaBean() {
		return usuarioMatriculaBean;
	}

	public void setUsuarioMatriculaBean(UsuarioMatriculaBean usuarioMatriculaBean) {
		this.usuarioMatriculaBean = usuarioMatriculaBean;
	}

	private MatriculaBean 			matriculaBean; 
	
	public MatriculaBean getMatriculaBean() {
		return matriculaBean;
	}

	public void setMatriculaBean(MatriculaBean matriculaBean) {
		this.matriculaBean = matriculaBean;
	}

	private LenguaBean 			lenguaBean;  
	
	
	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	public List<SeguimientoAlumIntentoBean> getLstSeguimientoBean() {
		return lstSeguimientoBean;
	}

	public void setLstSeguimientoBean(
			List<SeguimientoAlumIntentoBean> lstSeguimientoBean) {
		this.lstSeguimientoBean = lstSeguimientoBean;
	}

	private UsuarioPerfilBean perfilBean;
	private String			  tmpUrlImagen;
	
	public static final String SEPARATOR = ";";
	public static final String QUOTE = "\"";
	public static final String QUOTEA = "<<'";
	public static final String QUOTEB = "'>>";
	private List<String> resultado = new ArrayList<String>();
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet resultSet = null;
	String lsConsult = "";
	ResultSetMetaData metadata = null;
	int columnCount = 0;
	String lsColName = "";
	List<Row> table = new ArrayList<Row>();
	FileWriter fichero = null;
	PrintWriter pw = null;
	String lsServLoc = "";
	// Conexion Local
	String lsLoclURL = "";
	String lsLoclUSR = "";
	String lsLoclPWD = "";
	
	// Conexi贸n Externa
	String lsExteURL = "";
	String lsExteUSR = "";
	String lsExtePWD = "";
	UsuarioBean usuario = new UsuarioBean();
	List<String> lsCadena=new ArrayList<String>();
	SimpleDateFormat simpleDateFormat =   new SimpleDateFormat("MMddhhmmss");
	String dateAsString = simpleDateFormat.format(new Date());
	File lmDirFile = null;
	@PostConstruct
	public void init(){
		leerProperties();
		this.setPerfilBean(new UsuarioPerfilBean());
	}
	
	DecimalFormat formateador = new DecimalFormat("####.##");
	
	@RequestMapping(value = "/reporte", method = RequestMethod.GET)
	public ModelAndView doLenguaCarga(HttpServletRequest request) {
		usuario = this.getUsuarioSesion(request); //1265
		AccesoBean accesoBean = new AccesoBean();
		accesoBean.setFlgServer(lsServLoc);
		LenguaBean 				lenguaBean=(LenguaBean)request.getSession().getAttribute("lenguaBean");
		LenguaEstructuraBean 	lenguaEstructuraBean=(LenguaEstructuraBean)request.getSession().getAttribute("lenguaEstructuraBean");
		UnidadBean 				unidadBean=(UnidadBean)request.getSession().getAttribute("unidadBean");
		UnidadLeccionBean		unidadLeccionBean=(UnidadLeccionBean)request.getSession().getAttribute("unidadLeccionBean");
		
		System.out.println("lenguaBean.getsession" + lenguaBean);
		System.out.println("lenguaEstructuraBean.getsession" + lenguaEstructuraBean);
		
		int swActivoMascotaAnim = 0;
		
		UsuarioPerfilBean newUsuarioPerfilBean = new UsuarioPerfilBean();
		MascotaBean beanMascota= null;
		/** OBTENER MASCOTA **/
		MascotaBean	prMascotaBean = new MascotaBean();
		prMascotaBean.setAudCodigoUsuario(usuario.getCodigoUsuario());
		
		try {
			beanMascota = this.fs.getMascotaService().getlistarMasctoSwPredetAlumno(prMascotaBean);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		swActivoMascotaAnim = (!VO.isNull(request.getSession().getAttribute("swActivoMascotaAnim"))) ? (Integer) request.getSession().getAttribute("swActivoMascotaAnim") : 0;
		
		if (VO.isNotNull(beanMascota)) {
			System.out.println(" beanMascota.getImagenTienda() " + beanMascota.getImagenTienda());
		}else {
			beanMascota = new MascotaBean();
			try {
				beanMascota = this.fs.getMascotaService().getlistarMasctoSwPredetSist(prMascotaBean);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			System.out.println("-----getlistarMasctoSwPredetSist-----");
			System.out.println(" beanMascota.getImagenTienda() " + beanMascota.getImagenTienda());
		}
				
		System.out.println("modificar obtenerDatosUsuarioPerfil: " + newUsuarioPerfilBean);
		
		ModelAndView mav = new ModelAndView("lengua/reporte", "command",newUsuarioPerfilBean);
		mav.addObject("beanMascota", beanMascota);
		mav.addObject("persona",new PersonaBean());
		mav.addObject("accesoBean",accesoBean);
		mav.addObject("lenguaBean", lenguaBean);
		mav.addObject("lenguaEstructuraBean", lenguaEstructuraBean);
		mav.addObject("unidadBean", unidadBean);
		mav.addObject("unidadLeccionBean", unidadLeccionBean);
		mav.addObject("swActivoMascotaAnim", swActivoMascotaAnim);

		return mav;
	}
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView donuevo(HttpServletRequest request) {

		UsuarioBean usuario = this.getUsuarioSesion(request);
		
		LenguaBean 				lenguaBean=(LenguaBean)request.getSession().getAttribute("lenguaBean");
		LenguaEstructuraBean 	lenguaEstructuraBean=(LenguaEstructuraBean)request.getSession().getAttribute("lenguaEstructuraBean");
		UnidadBean 				unidadBean=(UnidadBean)request.getSession().getAttribute("unidadBean");
		UnidadLeccionBean		unidadLeccionBean=(UnidadLeccionBean)request.getSession().getAttribute("unidadLeccionBean");
		
		System.out.println("lenguaBean.getsession" + lenguaBean);
		System.out.println("lenguaEstructuraBean.getsession" + lenguaEstructuraBean);
		
		int swActivoMascotaAnim = 0;
		
		UsuarioPerfilBean newUsuarioPerfilBean = new UsuarioPerfilBean();
		MascotaBean beanMascota= null;
		/** OBTENER MASCOTA **/
		MascotaBean	prMascotaBean = new MascotaBean();
		prMascotaBean.setAudCodigoUsuario(usuario.getCodigoUsuario());
		
		try {
			beanMascota = this.fs.getMascotaService().getlistarMasctoSwPredetAlumno(prMascotaBean);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		swActivoMascotaAnim = (!VO.isNull(request.getSession().getAttribute("swActivoMascotaAnim"))) ? (Integer) request.getSession().getAttribute("swActivoMascotaAnim") : 0;
		
		if (VO.isNotNull(beanMascota)) {
			System.out.println(" beanMascota.getImagenTienda() " + beanMascota.getImagenTienda());
		}else {
			beanMascota = new MascotaBean();
			try {
				beanMascota = this.fs.getMascotaService().getlistarMasctoSwPredetSist(prMascotaBean);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			System.out.println("-----getlistarMasctoSwPredetSist-----");
			System.out.println(" beanMascota.getImagenTienda() " + beanMascota.getImagenTienda());
		}
				
		System.out.println("modificar obtenerDatosUsuarioPerfil: " + newUsuarioPerfilBean);
		
		ModelAndView mav = new ModelAndView("lengua/perfil", "command",newUsuarioPerfilBean);
		mav.addObject("beanMascota", beanMascota);
		mav.addObject("persona",new PersonaBean());
		
		mav.addObject("lenguaBean", lenguaBean);
		mav.addObject("lenguaEstructuraBean", lenguaEstructuraBean);
		mav.addObject("unidadBean", unidadBean);
		mav.addObject("unidadLeccionBean", unidadLeccionBean);
		mav.addObject("swActivoMascotaAnim", swActivoMascotaAnim);

		return mav;
	}
	
	@RequestMapping(value = "/obtenerDatosUsuarioPerfil", method = RequestMethod.GET)
	@ResponseBody
	public UsuarioPerfilBean doObtenerDatosUsuarioPerfil(@RequestParam("codigo") Integer codigo ,HttpServletRequest request) {
		System.out.println("codigo " + codigo);
		UsuarioPerfilBean newUsuarioPerfilBean = new UsuarioPerfilBean();
		
		UsuarioPerfilBean prmUsuarioPerfilBean = new UsuarioPerfilBean();		
		prmUsuarioPerfilBean.setCodigoUsuario((long)codigo);
		
		try {
			newUsuarioPerfilBean = this.fs.getUsuarioPerfilService().buscarXcodigoUsu(prmUsuarioPerfilBean);
			
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
				
		System.out.println("modificar obtenerDatosUsuarioPerfil: " + newUsuarioPerfilBean);
		
//		ModelAndView mav = new ModelAndView("lengua/perfil", "command",newUsuarioPerfilBean);

		return newUsuarioPerfilBean;
	}
	
	@RequestMapping(value ="/actualizarDatosuser", method = RequestMethod.POST)
	@ResponseBody
	public String doActualizarDatosuser(@RequestParam("codigo")Integer codigo,@RequestParam("correo")String correo,@RequestParam("telefono")String telefono,HttpServletRequest request){
		boolean sw=false;
		PersonaBean prmPersonaBean= new PersonaBean();
		prmPersonaBean.setCodigo(codigo);
		prmPersonaBean.setCorreo(correo);
		prmPersonaBean.setTelefono(telefono);
		System.out.println("codigocodigocodigo actualizarDatosuser " + codigo);
	
		try { 
				this.setAuditoria(prmPersonaBean, request, false);
				sw =  (this.fs.getPersonaService().actualizardatosuser(prmPersonaBean));  
		
		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		if (sw) {
			return "1";		
		}else {
			return "0";
		}
		
	}
	
	
	@RequestMapping(value ="/actualizarDatosFotoUser", method = RequestMethod.POST)
	@ResponseBody
	public String doActualizarDatosFotoUser(@RequestParam("codigo")Integer codigo,
			@RequestParam(value="files",required=false) MultipartFile[] files,
			HttpServletRequest request){
		boolean sw=false;
		boolean swNuevaUrlImagen = false; 
		
		PersonaBean prmPersonaBean= new PersonaBean();
		prmPersonaBean.setCodigo(codigo);
		System.out.println("codigocodigocodigo actualizarDatosuser " + codigo);
	
		try { 
			if (files.length>0) {
				swNuevaUrlImagen = (files[0]!=null) && (files[0].getOriginalFilename()!=null ) && (files[0].getOriginalFilename().trim().length()>0 );		
			}
			
			if (swNuevaUrlImagen) {
				prmPersonaBean.setFilefotouser(files[0]);
		    	if (files[0].getOriginalFilename()!=null) {
		    		prmPersonaBean.setNombrefotouser(files[0].getOriginalFilename());
		    		System.out.println("files[0].getOriginalFilename() "+ files[0].getOriginalFilename());
		    	}	    					
			}
				this.setAuditoria(prmPersonaBean, request, false);
				sw =  (this.fs.getPersonaService().actualizardatosfotouser(prmPersonaBean)); 
		
		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		if (sw) {
			if (swNuevaUrlImagen) {
				super.cargarArchivo(this.getRootPath(), prmPersonaBean.getNombrefotouser(), prmPersonaBean.getFilefotouser());    			    	
				tmpUrlImagen = prmPersonaBean.getNombrefotouser();
			} 
			return "1";		
		}else {
			return "0";
		}
		
	}
	
	@RequestMapping(value = "/actualizarDatosFotoUser2", method = RequestMethod.POST)
	public ModelAndView doActualizarDatosFotoUser2(@RequestParam("codigo")Integer codigo,
			@RequestParam(value="files",required=false) MultipartFile[] files,@RequestParam("codusu")Integer codigousu,
			HttpServletRequest request) {
		
		
		boolean sw=false;
		boolean swNuevaUrlImagen = false; 
		UsuarioBean newUsuarioPerfilBean=new UsuarioBean();
		PersonaBean prmPersonaBean= new PersonaBean();
		prmPersonaBean.setCodigo(codigo);
		System.out.println("codigocodigocodigo actualizarDatosuser " + codigo);
		System.out.println("codigousu " + codigousu);
		int swActivoMascotaAnim = 0;
	
		try { 
			if (files.length>0) {
				swNuevaUrlImagen = (files[0]!=null) && (files[0].getOriginalFilename()!=null ) && (files[0].getOriginalFilename().trim().length()>0 );		
			}
			
			if (swNuevaUrlImagen) {
				prmPersonaBean.setFilefotouser(files[0]);
		    	if (files[0].getOriginalFilename()!=null) {
		    		prmPersonaBean.setNombrefotouser(files[0].getOriginalFilename());
		    		System.out.println("files[0].getOriginalFilename() "+ files[0].getOriginalFilename());
		    	}	    					
			}
				this.setAuditoria(prmPersonaBean, request, false);
		sw =  (this.fs.getPersonaService().actualizardatosfotouser(prmPersonaBean)); 
		
		} catch (Exception e) { 
			e.printStackTrace();
		} 		

		if (sw) {
			
			if (swNuevaUrlImagen) {
				super.cargarArchivo(this.getRootPath(), prmPersonaBean.getNombrefotouser(), prmPersonaBean.getFilefotouser());    			    	
				tmpUrlImagen = prmPersonaBean.getNombrefotouser();
			} 
			UsuarioBean prmUsuarioPerfilBean = new UsuarioBean();		
			prmUsuarioPerfilBean.setCodigoUsuario((long)codigousu);
			try {
				newUsuarioPerfilBean = this.fs.getUsuarioService().buscarxcodigousua(prmUsuarioPerfilBean);
				System.out.println("newUsuarioPerfilBean.getPersona().getNombrefotouser() "+newUsuarioPerfilBean.getPersona().getNombrefotouser());
				//newUsuarioPerfilBean.getPersona().setNombrefotouser(newUsuarioPerfilBean.getPersona().getNombrefotouser());
				//System.out.println("newUsuarioPerfilBean---------  "+);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			LenguaBean 				lenguaBean=(LenguaBean)request.getSession().getAttribute("lenguaBean");
			LenguaEstructuraBean 	lenguaEstructuraBean=(LenguaEstructuraBean)request.getSession().getAttribute("lenguaEstructuraBean");
			UnidadBean 				unidadBean=(UnidadBean)request.getSession().getAttribute("unidadBean");
			UnidadLeccionBean		unidadLeccionBean=(UnidadLeccionBean)request.getSession().getAttribute("unidadLeccionBean");
			
			swActivoMascotaAnim = (!VO.isNull(request.getSession().getAttribute("swActivoMascotaAnim"))) ? (Integer) request.getSession().getAttribute("swActivoMascotaAnim") : 0;
			
			UsuarioBean usu = (UsuarioBean)request.getSession().getAttribute("usuarioEstudiante");
			usu.getPersona().setNombrefotouser(newUsuarioPerfilBean.getPersona().getNombrefotouser());
			System.out.println("if");
			System.out.println("usuarioEstudiante "+ request.getSession().getAttribute("usuarioEstudiante"));
			ModelAndView mav = new ModelAndView("lengua/perfil", "command",new UsuarioPerfilBean());
			mav.addObject("validasw","1");
			request.getSession().setAttribute("usuarioEstudiante", usu);
			//mav.addObject("usuarioEstudiante", usu.getPersona().getNombrefotouser());
			mav.addObject("lenguaBean", lenguaBean);
			mav.addObject("lenguaEstructuraBean", lenguaEstructuraBean);
			mav.addObject("unidadBean", unidadBean);
			mav.addObject("unidadLeccionBean", unidadLeccionBean);
			mav.addObject("swActivoMascotaAnim", swActivoMascotaAnim);
			
			return mav;
		} else {
			System.out.println("else");
			ModelAndView mav = new ModelAndView("lengua/perfil", "command",new UsuarioPerfilBean());
			mav.addObject("usuarioEstudiante",new UsuarioBean());
			return mav;
			
		}

	}
	
	@RequestMapping(value = "/cambiarPass", method = RequestMethod.POST)
	@ResponseBody
	public Integer doCambiarPass(@RequestParam("codigo")Integer codigo,@RequestParam("oldpass")String oldpass,@RequestParam("newpass")String newpass,
			
			HttpServletRequest request){
				
				Integer sw = -1;
				String msg="";
				String newpassEncrypt = "";
				
				try {
					//UsuarioBean usuario = this.getUsuarioSesion(request);
					
					usuarioBean.setCodigoUsuario((long)codigo);
					usuarioBean.setPasswordUsuario(oldpass);
					
					Encrypt.init("KEY_ENCRYPT_PASS");
					newpassEncrypt = Encrypt.encrypt(newpass);
					usuarioBean.setNewPassword(newpassEncrypt);
					usuarioBean.setFlgRestPass("0");
					
					sw=1;
					this.setAuditoria(usuarioBean, request, false);
					sw = this.fs.getUsuarioService().cambiarPassword(usuarioBean);
					
				} catch (Exception e) { 
					e.printStackTrace();
				}
				
				if (sw==1) {
					HttpSession session = request.getSession();
					
					session.removeAttribute("usuarioEstudiante");
					session.invalidate();
				
					return 1;
				} else if(sw==0){
					msg= "No se reestablecio contrase&ntilde;a, "
							+ "La contrase&ntilde;a no coincide con la actual";
					return 0;
				}else{
					msg= "No se reestablecio contrase锟絘, "
							+ "por favor coordine con el administrador del sistema";
					return 0;
				}
				
	}
	@RequestMapping(value = "/listarLenguaUsuario", method = RequestMethod.POST)
	@ResponseBody 
	public List<LenguaBean> listarLenguaUsuario(){   
		List<LenguaBean> lstInstLenguaBean = new ArrayList<LenguaBean>();
		try{
			lstInstLenguaBean = this.fs.getLenguaService().listarValidaLenguasxMatricula(usuario);
			if (lstInstLenguaBean != null && lstInstLenguaBean.size() >0) {
				
				System.out.println("--------------------------->"+ lstInstLenguaBean.size());
			}else{
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return lstInstLenguaBean;
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
	
	
	public void leerProperties(){
		Properties prop = new Properties();
		try {
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");
			prop.load(inputStream);
			lsLoclURL = ResourceUtil.getKey("jdbcLocal.url");//prop.getProperty("jdbcLocal.url");
			lsLoclUSR = ResourceUtil.getKey("jdbcLocal.username");//prop.getProperty("jdbcLocal.username");
			lsLoclPWD = ResourceUtil.getKey("jdbcLocal.password");//prop.getProperty("jdbcLocal.password");
			lsExteURL = ResourceUtil.getKey("jdbcOnline.url");//prop.getProperty("jdbcOnline.url");
			lsExteUSR = ResourceUtil.getKey("jdbcOnline.username");//prop.getProperty("jdbcOnline.username");
			lsExtePWD = ResourceUtil.getKey("jdbcOnline.password");//prop.getProperty("jdbcOnline.password");
			lsServLoc = ResourceUtil.getKey("SERVIDOR_LOCAL");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	@RequestMapping(value = "/descargarArchivoDatos", method = RequestMethod.POST)
//	@ResponseBody
//	public String descargarArchivoDatos(@RequestParam("liCodServ") int liCodServ,@RequestParam("liCodOpci") int liCodOpci,@RequestParam("liCodLeng") int liCodLeng) {
//		Connection con = null;
//		BufferedReader br = null;
//		BufferedWriter writer = null;
//		String lsPrefijo = "";
//		String lsTablSQL = "";
//		String lsTblUIns = "";
//		String lsArchivo = "";
//		String lsMimeTyp = "";
//		String lsRpta501 = "";
//		//System.out.println(dateAsString);
//		try {
//			if(liCodServ==1){
//				con = DriverManager.getConnection(lsLoclURL, lsLoclUSR, lsLoclPWD);
//				lsPrefijo = "local-";
//			} else if(liCodServ==2){
//				con = DriverManager.getConnection(lsExteURL, lsExteUSR, lsExtePWD);
//				lsPrefijo = "remoto-";
//			} else{
//				lsRpta501 = "No se encontr贸 el tipo de conexi贸n";
//				return lsRpta501;
//			}
//			UsuarioMatriculaBean usuarioMatriBean =  obtenerUsuarioMatricula((usuario.getCodigo()) ,liCodLeng); 
//			
//			File dir = FileUtil.fileExists(this.getRootPathFile()); // CREAR CARPETA
//			
//			switch (liCodOpci) {
//			case 2:
//				lsTablSQL = "acad.leotbd_segalumlen";
//				lsTblUIns = "acad.leotbc_segaluejercicio";
//				lsArchivo = dir.getAbsolutePath()+this.get2Diagonal()+lsPrefijo+liCodLeng+"seguimiento-usuario"+usuarioMatriBean.getCodigo()+dateAsString+".txt"; //"C:/natigu/"+lsPrefijo+"seguimiento-usuarios.txt";
//				lmDirFile = FileUtil.fileExists2(lsArchivo);
//				try{
//					lsConsult = "SELECT AM.n_codaluxmeda, AM.n_codusumat, AM.n_codpremio, AM.v_flgest,  "+
//								"		coalesce(AM.n_codusureg,0) n_codusureg, coalesce(AM.d_fecreg, current_date) d_fecreg, coalesce(AM.v_hostreg,'') v_hostreg,  "+
//								"		coalesce(AM.n_codusumod,0) n_codusumod, coalesce(AM.d_fecmod, current_date) d_fecmod ,coalesce(AM.v_hostmod,'') v_hostmod, "+ 
//								"		coalesce(AM.n_codundlec,0) n_codundlec "+ 
//								"FROM 	acad.leotbd_alumnoxmedalla AM  	"+
//								"	LEFT JOIN acad.leotbd_usumatricula acad		"+
//								"		ON acad.n_codusumat = AM.n_codusumat	"+
//								"			LEFT JOIN acad.leomvc_matricula mat	"+
//								"				ON mat.n_codmatri = acad.n_codmatri	"+
//								"					LEFT JOIN acad.leotbd_insclengua  insc 	"+
//								"						ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua = "+liCodLeng+			
//								" WHERE	AM.n_codusumat ="+ usuarioMatriBean.getCodigo();
//								//"	AND med.v_flgest = '1' ";
//					ps = con.prepareStatement(lsConsult);
//					resultSet = ps.executeQuery();
//					metadata = resultSet.getMetaData();
//					columnCount = metadata.getColumnCount();
//					lsColName = obtenerColumnas(metadata,columnCount);
//					table = new ArrayList<Row>();
//					fichero = null;
//					pw = null;
//					Row.formTable(resultSet, table);
//					writer = new BufferedWriter(new FileWriter(lmDirFile));
//					fichero = new FileWriter(lmDirFile);
//					pw = new PrintWriter(fichero);
//					System.out.println("Tabla>>acad.leotbd_alumnoxmedalla" );
//					pw.println("Tabla>>acad.leotbd_alumnoxmedalla" );
//					for (Row row : table) {
//						String lsCadena = "";
//						for (Entry<Object, Class> col : row.row) {
//							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
//						}
//						try {
//							lsCadena = Encrypt.encrypt(lsCadena);
//						} catch (EncryptException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
//					}
//					///////////////////////////////////////////////////////////
//					///////////////////////////////////////////////////////////
//					lsConsult = "SELECT	AM.n_codaluxmongem, AM.n_codusumat, coalesce(AM.n_cantmonedas,0), coalesce(AM.n_cantgemas,0) n_cantgemas, coalesce(AM.v_flgest,'0') v_flgest, "+ 
//							"		coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg, coalesce(AM.v_hostreg, '') v_hostreg,  "+
//							"		coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod, "+ 
//							"		coalesce(AM.n_cantbono,0) n_cantbono "+
//								"FROM	acad.leotbd_alumnoxmonegem AM "+
//								"		LEFT JOIN acad.leotbd_usumatricula acad	"+
//								"			ON acad.n_codusumat = AM.n_codusumat "+
//								"				LEFT JOIN acad.leomvc_matricula mat "+
//								"					ON mat.n_codmatri = acad.n_codmatri "+
//								"						LEFT JOIN acad.leotbd_insclengua  insc "+
//								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
//								"	WHERE	AM.n_codusumat =" + usuarioMatriBean.getCodigo();
//					ps = con.prepareStatement(lsConsult);
//					resultSet = ps.executeQuery();
//					metadata = resultSet.getMetaData();
//					columnCount = metadata.getColumnCount();
//					lsColName = obtenerColumnas(metadata,columnCount);
//					table = new ArrayList<Row>();
//					Row.formTable(resultSet, table);
//					System.out.println("Tabla>>acad.leotbd_alumnoxmonegem" );
//					pw.println("Tabla>>acad.leotbd_alumnoxmonegem" );
//					for (Row row : table) {
//						String lsCadena = "";
//						for (Entry<Object, Class> col : row.row) {
//							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
//						}
//						try {
//							lsCadena = Encrypt.encrypt(lsCadena);
//						} catch (EncryptException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
//					}
//					
//					
//					lsConsult = "SELECT	AM.n_codsegaluejer, coalesce(AM.n_nummonedas,0) n_nummonedas, AM.n_codusumat, AM.n_codlengua, AM.n_codmatpej, AM.v_flgest,  "+
//								"	coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg,  coalesce(AM.v_hostreg,'') v_hostreg, "+ 
//								"	coalesce(AM.n_codusumod,0) n_codusumod,coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod,'') v_hostmod "+  
//								"FROM	acad.leotbc_segaluejercicio   AM "+ 
//								"		LEFT JOIN acad.leotbd_usumatricula acad	"+
//								"			ON acad.n_codusumat = AM.n_codusumat "+
//								"				LEFT JOIN acad.leomvc_matricula mat "+
//								"					ON mat.n_codmatri = acad.n_codmatri "+
//								"						LEFT JOIN acad.leotbd_insclengua  insc "+
//								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
//								"	WHERE	   AM.n_codusumat =" + usuarioMatriBean.getCodigo();
//					ps = con.prepareStatement(lsConsult);
//					resultSet = ps.executeQuery();
//					metadata = resultSet.getMetaData();
//					columnCount = metadata.getColumnCount();
//					lsColName = obtenerColumnas(metadata,columnCount);
//					table = new ArrayList<Row>();
//					Row.formTable(resultSet, table);
//					System.out.println("Tabla>>acad.leotbc_segaluejercicio" );
//					pw.println("Tabla>>acad.leotbc_segaluejercicio" );
//					for (Row row : table) {
//						String lsCadena = "";
//						for (Entry<Object, Class> col : row.row) {
//							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
//						}
//						try {
//							lsCadena = Encrypt.encrypt(lsCadena);
//						} catch (EncryptException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
//					}
//					
//					//
//					//
//					lsConsult = "SELECT	AM.n_codsegaluejerdet, coalesce(AM.n_nummonedas,0) n_nummonedas, AM.n_codusumat, AM.n_codlengua, coalesce(AM.n_codmatpej,0) n_codmatpej, "+ 
//								"	coalesce(AM.n_codpregun,0) n_codpregun, AM.v_flgest,  "+
//								"	coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg,coalesce(AM.v_hostreg, '') v_hostreg,  "+
//								"	coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod "+ 
//								"FROM	acad.leotbd_segaluejerdet    AM "+ 
//								"		LEFT JOIN acad.leotbd_usumatricula acad	"+
//								"			ON acad.n_codusumat = AM.n_codusumat "+
//								"				LEFT JOIN acad.leomvc_matricula mat "+
//								"					ON mat.n_codmatri = acad.n_codmatri "+
//								"						LEFT JOIN acad.leotbd_insclengua  insc "+
//								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
//								"	WHERE	 AM.n_codusumat =" + usuarioMatriBean.getCodigo();
//					ps = con.prepareStatement(lsConsult);
//					resultSet = ps.executeQuery();
//					metadata = resultSet.getMetaData();
//					columnCount = metadata.getColumnCount();
//					lsColName = obtenerColumnas(metadata,columnCount);
//					table = new ArrayList<Row>();
//					Row.formTable(resultSet, table);
//					System.out.println("Tabla>>acad.leotbd_segaluejerdet" );
//					pw.println("Tabla>>acad.leotbd_segaluejerdet" );
//					for (Row row : table) {
//						String lsCadena = "";
//						for (Entry<Object, Class> col : row.row) {
//							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
//						}
//						try {
//							lsCadena = Encrypt.encrypt(lsCadena);
//						} catch (EncryptException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
//					}
//					
//					//
//					//
//					lsConsult = "SELECT	AM.n_codsegaluinten, AM.n_codusumat, AM.n_codmatpej, coalesce(AM.n_numintento,0) n_numintento, AM.v_flgest,  "+
//								"		coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg, coalesce(AM.v_hostreg, '') v_hostreg,  "+
//								"		coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod,  "+ 
//								"		coalesce(AM.n_codpregun,0) n_codpregun "+ 
//								"FROM	acad.leotbd_segaluintentos  AM  "+
//								"		LEFT JOIN acad.leotbd_usumatricula acad	"+
//								"			ON acad.n_codusumat = AM.n_codusumat "+
//								"				LEFT JOIN acad.leomvc_matricula mat "+
//								"					ON mat.n_codmatri = acad.n_codmatri "+
//								"						LEFT JOIN acad.leotbd_insclengua  insc "+
//								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
//								"	WHERE	 AM.n_codusumat =" + usuarioMatriBean.getCodigo();
//					ps = con.prepareStatement(lsConsult);
//					resultSet = ps.executeQuery();
//					metadata = resultSet.getMetaData();
//					columnCount = metadata.getColumnCount();
//					lsColName = obtenerColumnas(metadata,columnCount);
//					table = new ArrayList<Row>();
//					Row.formTable(resultSet, table);
//					System.out.println("Tabla>>acad.leotbd_segaluintentos" );
//					pw.println("Tabla>>acad.leotbd_segaluintentos" );
//					for (Row row : table) {
//						String lsCadena = "";
//						for (Entry<Object, Class> col : row.row) {
//							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
//						}
//						try {
//							lsCadena = Encrypt.encrypt(lsCadena);
//						} catch (EncryptException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
//					}
//					
//					//
//					//
//					lsConsult =  "SELECT	AM.n_codsegalu, AM.n_codusumat, AM.n_tm1sitseg, coalesce(AM.n_codundlec,0) n_codundlec, AM.v_flgest, "+
//								"		coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg, coalesce(AM.v_hostreg, '') v_hostreg,   "+
//								"		coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod, "+ 
//								"		coalesce(AM.n_codmatpej, 0) n_codmatpej, coalesce(AM.n_codlesmat,0) n_codlesmat  "+  
//								"FROM	acad.leotbd_segalumlen   AM "+ 
//								"		LEFT JOIN acad.leotbd_usumatricula acad	"+
//								"			ON acad.n_codusumat = AM.n_codusumat "+
//								"				LEFT JOIN acad.leomvc_matricula mat "+
//								"					ON mat.n_codmatri = acad.n_codmatri "+
//								"						LEFT JOIN acad.leotbd_insclengua  insc "+
//								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
//								"	WHERE	 AM.n_codusumat =" + usuarioMatriBean.getCodigo();
//					ps = con.prepareStatement(lsConsult);
//					resultSet = ps.executeQuery();
//					metadata = resultSet.getMetaData();
//					columnCount = metadata.getColumnCount();
//					lsColName = obtenerColumnas(metadata,columnCount);
//					table = new ArrayList<Row>();
//					Row.formTable(resultSet, table);
//					System.out.println("Tabla>>acad.leotbd_segalumlen" );
//					pw.println("Tabla>>acad.leotbd_segalumlen" );
//					for (Row row : table) {
//						String lsCadena = "";
//						for (Entry<Object, Class> col : row.row) {
//							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
//						}
//						try {
//							lsCadena = Encrypt.encrypt(lsCadena);
//						} catch (EncryptException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
//					}
//					
//					//
//					//
//					lsConsult = "SELECT	AM.n_codadquiusu, coalesce(AM.n_codfond,0) n_codfond , AM.n_codusuari, coalesce(AM.n_tm1sitfousuar,0) n_tm1sitfousuar, AM.v_flgest, "+ 
//								"	coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg,coalesce(AM.v_hostreg, '') v_hostreg,  "+
//								"	coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod,coalesce(AM.n_codregion,0) n_codregion,  "+
//								"	coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.n_codmasco,0) n_codmasco, coalesce(AM.n_tm1tipadqui,0) n_tm1tipadqui, "+ 
//								"	coalesce(AM.n_swpredeterminado,0) n_swpredeterminado, coalesce(AM.n_codcombo,0) n_codcombo "+ 
//								"FROM	conf.leotbc_adquiusu AM  "+ 
//								"		LEFT JOIN acad.leotbd_usumatricula acad	"+
//								"			ON acad.n_codusuari = AM.n_codusuari  "+
//								"				LEFT JOIN acad.leomvc_matricula mat "+
//								"					ON mat.n_codmatri = acad.n_codmatri "+
//								"						LEFT JOIN acad.leotbd_insclengua  insc "+
//								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
//								"	WHERE	 AM.n_codusuari =" + usuarioMatriBean.getUsuarioBean().getCodigo();
//					ps = con.prepareStatement(lsConsult);
//					resultSet = ps.executeQuery();
//					metadata = resultSet.getMetaData();
//					columnCount = metadata.getColumnCount();
//					lsColName = obtenerColumnas(metadata,columnCount);
//					table = new ArrayList<Row>();
//					Row.formTable(resultSet, table);
//					System.out.println("Tabla>>conf.leotbc_adquiusu" );
//					pw.println("Tabla>>conf.leotbc_adquiusu" );
//					for (Row row : table) {
//						String lsCadena = "";
//						for (Entry<Object, Class> col : row.row) {
//							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
//						}
//						try {
//							lsCadena = Encrypt.encrypt(lsCadena);
//						} catch (EncryptException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
//					}
//					
//					//
//					//
//					lsConsult = "SELECT	AM.n_codevalua, AM.n_codusumat, coalesce(AM.n_tm1siteva,0) n_tm1siteva, coalesce(AM.n_totejercio,0) n_totejercio, coalesce(AM.n_correctos,0) n_correctos, "+ 
//								"	coalesce(AM.n_errados,0) n_errados, coalesce(AM.n_nota,0.00) n_nota, coalesce(AM.n_codmedalla,0) n_codmedalla, AM.v_flgest,   "+
//								"	coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_timestamp) d_fecreg,coalesce(AM.v_hostreg, '') v_hostreg,   "+
//								"	coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_timestamp) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod, "+  
//								"	coalesce(AM.n_tm2duracion,0) n_tm2duracion, coalesce(AM.d_fechahoraini, current_timestamp) d_fechahoraini, "+  
//								"	coalesce(AM.d_fechahorafin,current_timestamp) d_fechahorafin, coalesce(AM.n_tm2nivel,0) n_tm2nivel, COALESCE(AM.n_tm2subnivel,0) n_tm2subnivel "+ 
//								"FROM	acad.leotbc_evaluacion  AM  "+ 
//								"		LEFT JOIN acad.leotbd_usumatricula acad	"+
//								"			ON acad.n_codusumat = am.n_codusumat "+
//								"				LEFT JOIN acad.leomvc_matricula mat "+
//								"					ON mat.n_codmatri = acad.n_codmatri "+
//								"						LEFT JOIN acad.leotbd_insclengua  insc "+
//								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
//								"	WHERE	 AM.n_codusumat =" + usuarioMatriBean.getCodigo();
//					ps = con.prepareStatement(lsConsult);
//					resultSet = ps.executeQuery();
//					metadata = resultSet.getMetaData();
//					columnCount = metadata.getColumnCount();
//					lsColName = obtenerColumnas(metadata,columnCount);
//					table = new ArrayList<Row>();
//					Row.formTable(resultSet, table);
//					System.out.println("Tabla>>acad.leotbc_evaluacion" );
//					pw.println("Tabla>>acad.leotbc_evaluacion" );
//					for (Row row : table) {
//						String lsCadena = "";
//						for (Entry<Object, Class> col : row.row) {
//							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
//						}
//						try {
//							lsCadena = Encrypt.encrypt(lsCadena);
//						} catch (EncryptException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
//					}
//					
//					//
//					//
//					lsConsult = "SELECT	AM.n_codevaldet, AM.n_codevalua, coalesce(AM.n_tm2tpejer,0) n_tm2tpejer, coalesce(AM.n_codmatpej,0) n_codmatpej, coalesce(AM.n_codlesmat,0) n_codlesmat, "+
//								"		coalesce(AM.n_tm1sitevdt,0) n_tm1sitevdt, coalesce(AM.v_swaprobad,'0') v_swaprobad, AM.v_flgest,  "+
//								"		coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_timestamp) d_fecreg, coalesce(AM.v_hostreg, '') v_hostreg,  "+
//								"		coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_timestamp) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod, coalesce(AM.n_tm2tpreg,0) n_tm2tpreg "+ 
//								"FROM	acad.leotbd_evaldetalle  AM "+
//								"	LEFT JOIN acad.leotbc_evaluacion eva  "+
//								"		ON eva.n_codevalua=AM.n_codevalua  "+
//								"		LEFT JOIN acad.leotbd_usumatricula acad	 "+
//								"			ON acad.n_codusumat = eva.n_codusumat  "+
//								"				LEFT JOIN acad.leomvc_matricula mat  "+
//								"					ON mat.n_codmatri = acad.n_codmatri  "+
//								"						LEFT JOIN acad.leotbd_insclengua  insc  "+
//								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+				
//								"WHERE	 EVA.n_codusumat =" + usuarioMatriBean.getCodigo();
//					ps = con.prepareStatement(lsConsult);
//					resultSet = ps.executeQuery();
//					metadata = resultSet.getMetaData();
//					columnCount = metadata.getColumnCount();
//					lsColName = obtenerColumnas(metadata,columnCount);
//					table = new ArrayList<Row>();
//					Row.formTable(resultSet, table);
//					System.out.println("Tabla>>acad.leotbd_evaldetalle" );
//					pw.println("Tabla>>acad.leotbd_evaldetalle" );
//					for (Row row : table) {
//						String lsCadena = "";
//						for (Entry<Object, Class> col : row.row) {
//							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
//						}
//						try {
//							lsCadena = Encrypt.encrypt(lsCadena);
//						} catch (EncryptException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
//					}
//					
//					
//					lsConsult = "SELECT	n_codbono, COALESCE(v_nombono,'') v_nombono, COALESCE(v_desbono,'') v_desbono, COALESCE(n_tm1tpbono,0) n_tm1tpbono, COALESCE(n_tm1sitbono,0) n_tm1sitbono,  "+
//								"	COALESCE(v_flgest,'0') v_flgest, COALESCE(d_fecreg,current_timestamp) d_fecreg, COALESCE(v_hostreg,'') v_hostreg, COALESCE(d_fecmod,current_timestamp) d_fecmod,  "+
//								"	COALESCE(v_hostmod,'') v_hostmod, COALESCE(n_codusumod,0) n_codusumod, COALESCE(v_tiempo,'') v_tiempo, COALESCE(n_tm2tpejer,0) n_tm2tpejer, COALESCE(n_codusureg,0) n_codusureg "+
//								"FROM	conf.leotbc_bono";
//					ps = con.prepareStatement(lsConsult);
//					resultSet = ps.executeQuery();
//					metadata = resultSet.getMetaData();
//					columnCount = metadata.getColumnCount();
//					lsColName = obtenerColumnas(metadata,columnCount);
//					table = new ArrayList<Row>();
//					Row.formTable(resultSet, table);
//					System.out.println("Tabla>>conf.leotbc_bono" );
//					pw.println("Tabla>>conf.leotbc_bono" );
//					for (Row row : table) {
//						String lsCadena = "";
//						for (Entry<Object, Class> col : row.row) {
//							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
//						}
//						try {
//							lsCadena = Encrypt.encrypt(lsCadena);
//						} catch (EncryptException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
//					}
//					
//					lsConsult = "SELECT	AM.n_codaluxbono, AM.n_codusumat, AM.n_codbono, AM.v_flgest, "+
//								"	coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg, coalesce(AM.v_hostreg, '') v_hostreg, "+ 
//								"	coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod, "+
//								"	COALESCE(AM.n_codundlec,0) n_codundlec "+
//								"FROM	acad.leotbd_alumnoxbono AM "+
//								"	LEFT JOIN acad.leotbd_usumatricula acad	"+
//								"			ON acad.n_codusumat = am.n_codusumat "+
//								"				LEFT JOIN acad.leomvc_matricula mat "+
//								"					ON mat.n_codmatri = acad.n_codmatri "+
//								"						LEFT JOIN acad.leotbd_insclengua  insc "+
//								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
//								"	WHERE	 AM.n_codusumat =" + usuarioMatriBean.getCodigo();
//					ps = con.prepareStatement(lsConsult);
//					resultSet = ps.executeQuery();
//					metadata = resultSet.getMetaData();
//					columnCount = metadata.getColumnCount();
//					lsColName = obtenerColumnas(metadata,columnCount);
//					table = new ArrayList<Row>();
//					Row.formTable(resultSet, table);
//					System.out.println("Tabla>>acad.leotbd_alumnoxbono" );
//					pw.println("Tabla>>acad.leotbd_alumnoxbono" );
//					for (Row row : table) {
//						String lsCadena = "";
//						for (Entry<Object, Class> col : row.row) {
//							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
//						}try {
//							lsCadena = Encrypt.encrypt(lsCadena);
//						} catch (EncryptException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						
//						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
//					}
//					
//					pw.close();
//				} catch (IOException e){
//					lsRpta501 = e.getMessage();
//					return lsRpta501;
//				} catch(NullPointerException e) {
//					lsRpta501 = e.getMessage();
//					return lsRpta501;
//				} finally {
//					if (null != ps)
//						ps.close();
//					if (null != con)
//						con.close();
//				}
//				break;
//			default:
//				break;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			lsRpta501 = e.getMessage();
//			return lsRpta501;
//		} /*finally {
//			if (null != br) {
//				try {
//					br.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}*/
//		lsRpta501 = "1";
//		return lsRpta501;
//	}
	
//	@RequestMapping(value = "/descargarArchivoGenerar", method = RequestMethod.GET)
//	public void descargarArchivoGenerar(HttpServletResponse response) {
//		
//		// ----
//		String lsMimeTyp = URLConnection.guessContentTypeFromName(lmDirFile.getName());
//		if (lsMimeTyp == null) {
//			System.out.println("No se obtuvo mimeType");
//			lsMimeTyp = "application/octet-stream";
//		}
//		try {
//			response.setContentType(lsMimeTyp);
//			response.setHeader("Content-Disposition",
//					String.format("inline; filename=\"" + lmDirFile.getName() + "\""));
//			response.setContentLength((int) lmDirFile.length());
//			InputStream inputStream = new BufferedInputStream(new FileInputStream(lmDirFile));
//			FileCopyUtils.copy(inputStream, response.getOutputStream());
//			lmDirFile = null;
//		} catch (IOException ex) {
//			System.out.println("Error writing file to output stream. Filename was '{}'");
//			throw new RuntimeException("IOError writing file to output stream");
//		}
//	}
	
	
	
	
	
	
	
	
	
	
	
	class MyFooter extends PdfPageEventHelper{
        Font fuente = new Font(Font.FontFamily.UNDEFINED, 7, Font.NORMAL);
 
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            Phrase header = new Phrase("", fuente);
            DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat formatoHora = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            String fecha = formatoFecha.format(date);
            String hora = formatoHora.format(date);
            
            
            Phrase footer = new Phrase(  
            		  "       Impresi髇   :  "+fecha+" "+hora     
            		+ "                                       "
            		+ "                         "
            		+ "                 " 
					+ "     KUMITSARI     "
            		+ "                                   "
            		+ "                           "
            		+ "                              "
            		+ " P醙ina "+String.valueOf(document.getPageNumber())+"                          " 
            		  , fuente);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    header,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.top() + 10, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    footer,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.bottom() - 4, 0);
        }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/descargarPDF", method = RequestMethod.POST, produces = "application/pdf")
    public @ResponseBody void descargarPDF(
    										@RequestParam("p_codlengua") Long codLen,
//			   							   @RequestParam("p_codusuari") Long codUsu,
			   							   HttpServletResponse response) throws IOException {
    	
    	File file = new File("reporte.pdf");
    	 
//    	codUsu=usuario.getCodigoUsuario();
    	System.out.println("usu " + usuario.getCodigoUsuario() + "cod "+usuario.getCodigo());
    	SeguimientoAlumIntentoBean Bean = new SeguimientoAlumIntentoBean();
    	Bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean()); 
    	Bean.setLenguaBean(new LenguaBean()); 
    	Bean.setInstitucionBean(new InstitucionBean()); 
    	Bean.getUsuarioMatriculaBean().setMatriculaBean(new MatriculaBean()); 
    	Bean.getUsuarioMatriculaBean().setUsuarioBean(new UsuarioBean()); 
    	Bean.getUsuarioMatriculaBean().getUsuarioBean().setCodigo(usuario.getCodigoUsuario());
    	Bean.getUsuarioMatriculaBean().getMatriculaBean().setLengua(new LenguaBean()); 
    	Bean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().setCodigo(codLen);
    	Bean.setPreguntaBean(new PreguntaBean());
    	
    	Bean.setCantidadIntentos(0);
    	

    	lstSeguimientoBean = new ArrayList<SeguimientoAlumIntentoBean>();
    	
		try {
		
			//lstSeguimientoBean = new ArrayList<SeguimientoAlumIntentoBean>();//seguimientoAlumIntentoService.getBuscarPorFiltros(Bean);
			lstSeguimientoBean = this.seguimientoAlumIntentoService.getBuscarPorFiltros(Bean);
			
			HttpHeaders responseHeaders = new HttpHeaders();
			//Document documento = new Document(PageSize.A4.rotate(),36,36,10,20);//
	        Document documento = new Document(PageSize.A4,36,36,10,20);
		
	        PdfWriter pdfw = PdfWriter.getInstance(documento, new FileOutputStream("reporte.pdf"));
	        MyFooter event = new MyFooter();
	        pdfw.setPageEvent(event);
			
			documento.open();
			//Fuentes
			Font fuente = new Font(Font.getFamily("ARIAL"),12, Font.BOLD);
			Font fuenteDatos = new Font(Font.getFamily("ARIAL"),8, Font.NORMAL);
			Font fuenteSubrayada = new Font(Font.getFamily("ARIAL"),8, Font.BOLD);
			fuenteSubrayada.setStyle(Font.UNDERLINE);
			Font fuenteListado = new Font(Font.getFamily("ARIAL"),8);
			Font fuenteItalic = new Font(Font.FontFamily.COURIER, 8, Font.ITALIC);
	
			//Cabecera // windows 
			
			//Image Imagen =  Image.getInstance("D://Reportes/Imagenes/logo_cabecera.png");
			Image Imagen =  Image.getInstance(ResourceUtil.getKey("ruta.natigu.archivos.academico.seguimiento")+this.get2Diagonal()+"logo_cabecerav2.png");
			
			//linux 
			//Image Imagen =  Image.getInstance("//opt//natigu//archivos//Reportes//Imagenes//logo_cabecera.png");
			//
            Imagen.scaleAbsolute(600,70);
            Imagen.setAlignment(Element.ALIGN_CENTER);
            documento.add(Imagen);
//			
            
            SeguimientoAlumIntentoBean  segBean = this.lstSeguimientoBean.get(0);
		
			
			/*consultas*/
			String strNomAlumno = segBean.getNombreAlumno();
			String strInstituto = segBean.getInstitucionBean().getNombreInstitucion();
			String strLengua = segBean.getLenguaBean().getNombre();
			
			
			
			Paragraph titulo = new Paragraph("REPORTE DE INTENTOS POR SUB - NIVEL", fuente);
			titulo.setAlignment(Element.ALIGN_CENTER);
			documento.add(titulo);
		
			Paragraph saltolinea = new Paragraph();
			saltolinea.add("\n");
			documento.add(saltolinea);
			
			
			Paragraph txtNombreAlumno = new Paragraph("ALUMNO      :  " + strNomAlumno, fuente);
			documento.add(txtNombreAlumno);

			Paragraph txtInstituto = new Paragraph("INSTITUTO   :  " +strInstituto, fuente);
			documento.add(txtInstituto);

			Paragraph txtLengua = new Paragraph("LENGUA       :  " +strLengua, fuente);
			documento.add(txtLengua);
			

			documento.add(saltolinea);
			//
			PdfPTable tabla = new PdfPTable(10);
			tabla.setWidthPercentage(100);
			
			// tabla cabecera
			PdfPCell celda1 =  new PdfPCell(new Paragraph("NRO",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
            PdfPCell celda2 =  new PdfPCell(new Paragraph("SUBNIVEL",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
            PdfPCell celda3 =  new PdfPCell(new Paragraph("INTENTO 1",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
            PdfPCell celda4 =  new PdfPCell(new Paragraph("INTENTO 2",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
            PdfPCell celda5 =  new PdfPCell(new Paragraph("INTENTO 3",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
//           PdfPCell celda11 =  new PdfPCell(new Paragraph("SITUACI锟絅",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
            
            //Color Plomo de fondo
            celda1.setBackgroundColor(BaseColor.RED);
            celda2.setBackgroundColor(BaseColor.RED);
            celda3.setBackgroundColor(BaseColor.RED);
            celda4.setBackgroundColor(BaseColor.RED);
            celda5.setBackgroundColor(BaseColor.RED);
//            celda6.setBackgroundColor(BaseColor.LIGHT_GRAY);
//            celda7.setBackgroundColor(BaseColor.LIGHT_GRAY);
//            celda8.setBackgroundColor(BaseColor.LIGHT_GRAY);
//            celda9.setBackgroundColor(BaseColor.LIGHT_GRAY);
//            celda10.setBackgroundColor(BaseColor.LIGHT_GRAY);
//            celda11.setBackgroundColor(BaseColor.LIGHT_GRAY);
//            celda12.setBackgroundColor(BaseColor.LIGHT_GRAY);
            //centar
            celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
//            celda6.setHorizontalAlignment(Element.ALIGN_CENTER);
//            celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
//            celda8.setHorizontalAlignment(Element.ALIGN_CENTER);
//            celda9.setHorizontalAlignment(Element.ALIGN_CENTER);
//            celda10.setHorizontalAlignment(Element.ALIGN_CENTER);
//            celda11.setHorizontalAlignment(Element.ALIGN_CENTER);
//            celda12.setHorizontalAlignment(Element.ALIGN_CENTER);

//            //tama锟給 de la celda
//            celda1.setColspan(1);
//            celda2.setColspan(4);
//            celda3.setColspan(4);
//            celda4.setColspan(4);//13
////            celda12.setColspan(4);//13
//            celda5.setColspan(5);
////            celda6.setColspan(2);
////            celda7.setColspan(2);
////            celda8.setColspan(1);//19
////            celda9.setColspan(3);
////            celda10.setColspan(3);
////            celda11.setColspan(2);

            celda1.setPaddingTop(5);
            celda2.setPaddingTop(5);
            celda3.setPaddingTop(5);
            celda4.setPaddingTop(5);
//            celda12.setPaddingTop(5);
            celda5.setPaddingTop(5);
//            celda6.setPaddingTop(5);
//            celda7.setPaddingTop(5);
//            celda8.setPaddingTop(5);
//            celda9.setPaddingTop(5);
//            celda10.setPaddingTop(5);
//            celda11.setPaddingTop(5);
            

            celda1.setPaddingBottom(5);
            celda2.setPaddingBottom(5);
            celda3.setPaddingBottom(5);
            celda4.setPaddingBottom(5);
//            celda12.setPaddingBottom(5);
            celda5.setPaddingBottom(5);
//            celda6.setPaddingBottom(5);
//            celda7.setPaddingBottom(5);
//            celda8.setPaddingBottom(5);
//            celda9.setPaddingBottom(5);
//            celda10.setPaddingBottom(5);
//            celda11.setPaddingBottom(5);

            celda1.setColspan(1);
            celda2.setColspan(3);
            celda3.setColspan(2);
            celda4.setColspan(2);
            celda5.setColspan(2);
            
            
            
            //agregar las celda
            tabla.addCell(celda1);
            tabla.addCell(celda2);
            tabla.addCell(celda3);
            tabla.addCell(celda4);
//            tabla.addCell(celda12);
            tabla.addCell(celda5);
//            tabla.addCell(celda6);
//            tabla.addCell(celda7);
//            tabla.addCell(celda8);
//            tabla.addCell(celda9);
//            tabla.addCell(celda10);
//            tabla.addCell(celda11);
            
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
            
    		List<Intentos> listIntentos = new ArrayList<Intentos>();
    		
    		String nomSubNivel = "";
    		
            for (int i = 0; i < this.lstSeguimientoBean.size(); i++) {
            	
            	SeguimientoAlumIntentoBean  SIBean = this.lstSeguimientoBean.get(i);
            	
            	Intentos prmIntentos = new Intentos();
            	
            	if (!nomSubNivel.equals(SIBean.getNivel())) {
            		//Ingresar una sola vez (primera)
            		nomSubNivel = SIBean.getNivel();
            		prmIntentos.setSubNivel(SIBean.getNivel());
            		
            		if (SIBean.getNumeroIntento() == 1) {
            			prmIntentos.setIntento1(SIBean.getCantidadIntentos());
					}
            		if (SIBean.getNumeroIntento() == 2) {
            			prmIntentos.setIntento2(SIBean.getCantidadIntentos());
					}
            		if (SIBean.getNumeroIntento() >= 3) {
						prmIntentos.setIntento3(prmIntentos.getIntento3() + SIBean.getCantidadIntentos());
					}
            		
            		listIntentos.add(prmIntentos);
            		
            	}else{
            		
            		for (Intentos intentos : listIntentos) {
						
            			if (intentos.getSubNivel().equals(SIBean.getNivel())) {
            				
            				if (SIBean.getNumeroIntento() == 1) {
        						intentos.setIntento1(SIBean.getCantidadIntentos());
        					}
                    		if (SIBean.getNumeroIntento() == 2) {
        						intentos.setIntento2(SIBean.getCantidadIntentos());
        					}
                    		if (SIBean.getNumeroIntento() >= 3) {
        						intentos.setIntento3(intentos.getIntento3() + SIBean.getCantidadIntentos());
        					}
						}
            			
					}
            	}
            	//Datos detalle
//                PdfPCell celd1 =  new PdfPCell(new Paragraph(String.valueOf((i+1)),fuenteDatos));
//                PdfPCell celd2 =  new PdfPCell(new Paragraph(SIBean.getNivel(),fuenteDatos));
//                PdfPCell celd3 =  new PdfPCell(new Paragraph(String.valueOf(SIBean.getCantidadIntentos()),fuenteDatos));
//                PdfPCell celd4 =  new PdfPCell(new Paragraph(String.valueOf(SIBean.getCantidadIntentos()),fuenteDatos));
//                PdfPCell celd5=  new PdfPCell(new Paragraph(String.valueOf(SIBean.getCantidadIntentos()),fuenteDatos));
//
//                celd1.setHorizontalAlignment(Element.ALIGN_CENTER);
//                celd2.setHorizontalAlignment(Element.ALIGN_CENTER);
//                celd3.setHorizontalAlignment(Element.ALIGN_CENTER);
//                celd4.setHorizontalAlignment(Element.ALIGN_CENTER);
//                celd5.setHorizontalAlignment(Element.ALIGN_CENTER);
//                
//                tabla.addCell(celd1);
//                tabla.addCell(celd2);
//                tabla.addCell(celd3);
//                tabla.addCell(celd4);
//                tabla.addCell(celd5);
//                
            }
            
            DecimalFormat df = new DecimalFormat("#.00");
             
			
            for (int i = 0; i < listIntentos.size(); i++) {
            	
            	Intentos intentos = listIntentos.get(i);
            	
	              PdfPCell celd1 =  new PdfPCell(new Paragraph(String.valueOf((i+1)),fuenteDatos));
	              PdfPCell celd2 =  new PdfPCell(new Paragraph(intentos.getSubNivel(),fuenteDatos)); 
	              PdfPCell celd3 =  new PdfPCell(new Paragraph(String.valueOf(df.format((Double.valueOf(intentos.getIntento1()))  *(100)/(Double.valueOf(intentos.getIntento1()+intentos.getIntento2()+intentos.getIntento3()))))+" %",fuenteDatos));
	              PdfPCell celd4 =  new PdfPCell(new Paragraph(String.valueOf(df.format((Double.valueOf(intentos.getIntento2()))*(100)/(Double.valueOf(intentos.getIntento1()+intentos.getIntento2()+intentos.getIntento3()))))+" %",fuenteDatos));
	              PdfPCell celd5=  new PdfPCell(new Paragraph(String.valueOf(df.format((Double.valueOf(intentos.getIntento3()))*(100)/(Double.valueOf(intentos.getIntento1()+intentos.getIntento2()+intentos.getIntento3()))))+" %",fuenteDatos));
	
	              celd1.setHorizontalAlignment(Element.ALIGN_CENTER);
	              celd2.setHorizontalAlignment(Element.ALIGN_CENTER);
	              celd3.setHorizontalAlignment(Element.ALIGN_CENTER);
	              celd4.setHorizontalAlignment(Element.ALIGN_CENTER);
	              celd5.setHorizontalAlignment(Element.ALIGN_CENTER);
	              
	              celd1.setColspan(1);
	              celd2.setColspan(3);
	              celd3.setColspan(2);
	              celd4.setColspan(2);
	              celd5.setColspan(2);
	              
	              tabla.addCell(celd1);
	              tabla.addCell(celd2);
	              tabla.addCell(celd3);
	              tabla.addCell(celd4);
	              tabla.addCell(celd5);
			}
            
            
            documento.add(tabla);
			
            documento.close();

			ByteArrayOutputStream pdf = new ByteArrayOutputStream();

			if (file.exists()){
				String nFile = "reporte.pdf";		
			    pdf.write(getBytesFromFile(file));
			    pdf.close();
			    responseHeaders.setContentType(MediaType.valueOf("application/pdf"));
			    responseHeaders.setContentLength(pdf.size());
			    responseHeaders.set("Content-Disposition","inline;filename="+nFile);  
			    
				InputStream in = new FileInputStream(file);
		        
		        response.setContentType("application/pdf");
		        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		        response.setHeader("Content-Length", String.valueOf(file.length()));
		        FileCopyUtils.copy(in, response.getOutputStream());
		 
			}
		
		//return new ResponseEntity<byte[]>(pdf.toByteArray(), responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		
   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/descargarReporteNotas", method = RequestMethod.POST, produces = "application/pdf")
    public @ResponseBody void descargarReporteNotas(
    										@RequestParam("p_codlengua") Long codLen,
//			   							   @RequestParam("p_codusuari") Long codUsu,
			   							   HttpServletResponse response) throws IOException {
    	
    	File file = new File("reporte.pdf");
    	  
//    	codUsu=usuario.getCodigoUsuario();
    	System.out.println("usu " + usuario.getCodigoUsuario() + "cod "+usuario.getCodigo());
    	EvaluacionBean Bean = new EvaluacionBean();
    	Bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean()); 
    	Bean.getUsuarioMatriculaBean().getMatriculaBean().setLengua(new LenguaBean()); 
    	Bean.setInstitucionBean(new InstitucionBean()); 
    	Bean.getUsuarioMatriculaBean().setMatriculaBean(new MatriculaBean()); 
    	Bean.getUsuarioMatriculaBean().setUsuarioBean(new UsuarioBean()); 
    	Bean.setNivel(new MaestraBean());
    	Bean.setSubNivel(new MaestraBean());
    	
    	
    	Bean.getUsuarioMatriculaBean().getUsuarioBean().setCodigo(usuario.getCodigoUsuario()); 
    	Bean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().setCodigo(codLen);
    	 
    	
 
    	

    	lstSeguimientoBean = new ArrayList<SeguimientoAlumIntentoBean>();
    	
		try {
		
			//lstSeguimientoBean = new ArrayList<SeguimientoAlumIntentoBean>();//seguimientoAlumIntentoService.getBuscarPorFiltros(Bean);
			lstEvaluacionBean = this.evaluacionService.getBuscarPorFiltros(Bean);
			
			HttpHeaders responseHeaders = new HttpHeaders();
			//Document documento = new Document(PageSize.A4.rotate(),36,36,10,20);//
	        Document documento = new Document(PageSize.A4,36,36,10,20);
		
	        PdfWriter pdfw = PdfWriter.getInstance(documento, new FileOutputStream("reporte.pdf"));
	        MyFooter event = new MyFooter();
	        pdfw.setPageEvent(event);
			
			documento.open();
			//Fuentes
			Font fuente = new Font(Font.getFamily("ARIAL"),12, Font.BOLD);
			Font fuenteDatos = new Font(Font.getFamily("ARIAL"),8, Font.NORMAL);
			Font fuenteSubrayada = new Font(Font.getFamily("ARIAL"),8, Font.BOLD);
			fuenteSubrayada.setStyle(Font.UNDERLINE);
			Font fuenteListado = new Font(Font.getFamily("ARIAL"),8);
			Font fuenteItalic = new Font(Font.FontFamily.COURIER, 8, Font.ITALIC);
	
			//Cabecera // windows 
			
			//Image Imagen =  Image.getInstance("D://Reportes/Imagenes/logo_cabecera.png");
			Image Imagen =  Image.getInstance(ResourceUtil.getKey("ruta.natigu.archivos.academico.seguimiento")+this.get2Diagonal()+"logo_cabecerav2.png");
			
			//linux 
			//Image Imagen =  Image.getInstance("//opt//natigu//archivos//Reportes//Imagenes//logo_cabecera.png");
			//
            Imagen.scaleAbsolute(600,70);
            Imagen.setAlignment(Element.ALIGN_CENTER);
            documento.add(Imagen);
//			
            
            EvaluacionBean  evaBean = this.lstEvaluacionBean.get(0);
		
			
			/*consultas*/
			String strNomAlumno = evaBean.getNomAlumno();
			String strInstituto = evaBean.getInstitucionBean().getNombreInstitucion();
			String strLengua = evaBean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().getNombre();
			
			
			
			Paragraph titulo = new Paragraph("REPORTE DE NOTAS", fuente);
			titulo.setAlignment(Element.ALIGN_CENTER);
			documento.add(titulo);
		
			Paragraph saltolinea = new Paragraph();
			saltolinea.add("\n");
			documento.add(saltolinea);
			
			
			Paragraph txtNombreAlumno = new Paragraph("ALUMNO      :  " + strNomAlumno, fuente);
			documento.add(txtNombreAlumno);

			Paragraph txtInstituto = new Paragraph("INSTITUTO   :  " +strInstituto, fuente);
			documento.add(txtInstituto);

			Paragraph txtLengua = new Paragraph("LENGUA       :  " +strLengua, fuente);
			documento.add(txtLengua);
			

			documento.add(saltolinea);
			//
			PdfPTable tabla = new PdfPTable(10);
			tabla.setWidthPercentage(100);
			
			// tabla cabecera
			PdfPCell celda1 =  new PdfPCell(new Paragraph("NRO",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
            PdfPCell celda2 =  new PdfPCell(new Paragraph("NIVEL",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
            PdfPCell celda3 =  new PdfPCell(new Paragraph("SUBNIVEL ",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
            PdfPCell celda4 =  new PdfPCell(new Paragraph("NOTA",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
//            PdfPCell celda5 =  new PdfPCell(new Paragraph("INTENTO 3",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
//           PdfPCell celda11 =  new PdfPCell(new Paragraph("SITUACI锟絅",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
            
            //Color Plomo de fondo
            celda1.setBackgroundColor(BaseColor.RED);
            celda2.setBackgroundColor(BaseColor.RED);
            celda3.setBackgroundColor(BaseColor.RED);
            celda4.setBackgroundColor(BaseColor.RED);
//            celda5.setBackgroundColor(BaseColor.RED);
 
            celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
//            celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
 

            celda1.setPaddingTop(5);
            celda2.setPaddingTop(5);
            celda3.setPaddingTop(5);
            celda4.setPaddingTop(5);
//            celda12.setPaddingTop(5);
//            celda5.setPaddingTop(5);
//            celda6.setPaddingTop(5);
//            celda7.setPaddingTop(5);
//            celda8.setPaddingTop(5);
//            celda9.setPaddingTop(5);
//            celda10.setPaddingTop(5);
//            celda11.setPaddingTop(5);
            

            celda1.setPaddingBottom(5);
            celda2.setPaddingBottom(5);
            celda3.setPaddingBottom(5);
            celda4.setPaddingBottom(5);
//            celda12.setPaddingBottom(5);
//            celda5.setPaddingBottom(5);
//            celda6.setPaddingBottom(5);
//            celda7.setPaddingBottom(5);
//            celda8.setPaddingBottom(5);
//            celda9.setPaddingBottom(5);
//            celda10.setPaddingBottom(5);
//            celda11.setPaddingBottom(5);

            celda1.setColspan(1);
            celda2.setColspan(3);
            celda3.setColspan(3);
            celda4.setColspan(3);
//            celda5.setColspan(2);
            
            
            
            //agregar las celda
            tabla.addCell(celda1);
            tabla.addCell(celda2);
            tabla.addCell(celda3);
            tabla.addCell(celda4);
//            tabla.addCell(celda12);
//            tabla.addCell(celda5);
//            tabla.addCell(celda6);
//            tabla.addCell(celda7);
//            tabla.addCell(celda8);
//            tabla.addCell(celda9);
//            tabla.addCell(celda10);
//            tabla.addCell(celda11);
            
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
            
//    		List<Intentos> listIntentos = new ArrayList<Intentos>();
//    		
//    		String nomSubNivel = "";
    		
            for (int i = 0; i < this.lstEvaluacionBean.size(); i++) {  
            	EvaluacionBean bean = this.lstEvaluacionBean.get(i);
            	
            	
            	
            	
	              PdfPCell celd1 =  new PdfPCell(new Paragraph(String.valueOf((i+1)),fuenteDatos));
	              PdfPCell celd2 =  new PdfPCell(new Paragraph(bean.getNomNivel(),fuenteDatos)); 
	            
	              if(bean.getSubNivel().getCodigoRegistro()==0){
	            	  NombreSubni=" PROMEDIO FINAL ";
	              }else{
	            	  NombreSubni=  bean.getNomSubnivel();
	              }
	              
	              PdfPCell celd3 =  new PdfPCell(new Paragraph(NombreSubni,fuenteDatos));
	              PdfPCell celd4 =  new PdfPCell(new Paragraph(String.valueOf(bean.getNota()),fuenteDatos));
//	              PdfPCell celd5=  new PdfPCell(new Paragraph(String.valueOf(df.format((Double.valueOf(intentos.getIntento3()))*(100)/(Double.valueOf(intentos.getIntento1()+intentos.getIntento2()+intentos.getIntento3()))))+" %",fuenteDatos));
	
	              celd1.setHorizontalAlignment(Element.ALIGN_CENTER);
	              celd2.setHorizontalAlignment(Element.ALIGN_CENTER);
	              celd3.setHorizontalAlignment(Element.ALIGN_CENTER);
	              celd4.setHorizontalAlignment(Element.ALIGN_CENTER);
//	              celd5.setHorizontalAlignment(Element.ALIGN_CENTER);
	              
	              celd1.setColspan(1);
	              celd2.setColspan(3);
	              celd3.setColspan(3);
	              celd4.setColspan(4);
//	              celd5.setColspan(2);
	              
	              tabla.addCell(celd1);
	              tabla.addCell(celd2);
	              tabla.addCell(celd3);
	              tabla.addCell(celd4);
//	              tabla.addCell(celd5); 
            }
            
            DecimalFormat df = new DecimalFormat("#.00");
             
			
//            for (int i = 0; i < listIntentos.size(); i++) {
//            	
//            	Intentos intentos = listIntentos.get(i);
//            	
//	              PdfPCell celd1 =  new PdfPCell(new Paragraph(String.valueOf((i+1)),fuenteDatos));
//	              PdfPCell celd2 =  new PdfPCell(new Paragraph(intentos.getSubNivel(),fuenteDatos)); 
//	              PdfPCell celd3 =  new PdfPCell(new Paragraph(String.valueOf(df.format((Double.valueOf(intentos.getIntento1()))  *(100)/(Double.valueOf(intentos.getIntento1()+intentos.getIntento2()+intentos.getIntento3()))))+" %",fuenteDatos));
//	              PdfPCell celd4 =  new PdfPCell(new Paragraph(String.valueOf(df.format((Double.valueOf(intentos.getIntento2()))*(100)/(Double.valueOf(intentos.getIntento1()+intentos.getIntento2()+intentos.getIntento3()))))+" %",fuenteDatos));
//	              PdfPCell celd5=  new PdfPCell(new Paragraph(String.valueOf(df.format((Double.valueOf(intentos.getIntento3()))*(100)/(Double.valueOf(intentos.getIntento1()+intentos.getIntento2()+intentos.getIntento3()))))+" %",fuenteDatos));
//	
//	              celd1.setHorizontalAlignment(Element.ALIGN_CENTER);
//	              celd2.setHorizontalAlignment(Element.ALIGN_CENTER);
//	              celd3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	              celd4.setHorizontalAlignment(Element.ALIGN_CENTER);
//	              celd5.setHorizontalAlignment(Element.ALIGN_CENTER);
//	              
//	              celd1.setColspan(1);
//	              celd2.setColspan(3);
//	              celd3.setColspan(2);
//	              celd4.setColspan(2);
//	              celd5.setColspan(2);
//	              
//	              tabla.addCell(celd1);
//	              tabla.addCell(celd2);
//	              tabla.addCell(celd3);
//	              tabla.addCell(celd4);
////	              tabla.addCell(celd5);
//			}
//            
              
            documento.add(tabla); 
            documento.close(); 
			ByteArrayOutputStream pdf = new ByteArrayOutputStream();

			if (file.exists()){
				String nFile = "reporte.pdf";		
			    pdf.write(getBytesFromFile(file));
			    pdf.close();
			    responseHeaders.setContentType(MediaType.valueOf("application/pdf"));
			    responseHeaders.setContentLength(pdf.size());
			    responseHeaders.set("Content-Disposition","inline;filename="+nFile);  
			    
				InputStream in = new FileInputStream(file);
		        
		        response.setContentType("application/pdf");
		        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		        response.setHeader("Content-Length", String.valueOf(file.length()));
		        FileCopyUtils.copy(in, response.getOutputStream());
		 
			}
		
		//return new ResponseEntity<byte[]>(pdf.toByteArray(), responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		
   }
	
	
	
	
	
	
	
	
	
	
	
	
	private byte[] getBytesFromFile(File file) throws IOException{
		InputStream is = new FileInputStream(file);
		// se obtiene el tama锟給 del archivo
		long length = file.length();
		// se vwerifica si el archivo es muy grande
		if (length > Integer.MAX_VALUE) {
			// directivas en caso el archivo sea muy pesado
		}
		// se crea la data en byte
		byte[] bytes = new byte[(int)length];
		// lectura de byte's
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
			   && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "+file.getName());
		}

		// se cierra el inputStream y se retorna los byte del archivo
		is.close();
		return bytes;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/leerArchivoOffline", method = RequestMethod.POST)
	@ResponseBody
	public String leerArchivoOffline(@RequestParam("fileOffline") MultipartFile[] fileOffline,@RequestParam("liCodServ") int liCodServ,@RequestParam("liAccions") int liAccions,	HttpServletRequest request) throws SQLException {
		Connection con= null;
		//Connection conLocal = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		BufferedReader br = null;
		String resultado = "";
		String lsPrefijo="";
		try {
			if(liCodServ==1){
				con = DriverManager.getConnection(lsLoclURL, lsLoclUSR, lsLoclPWD);
				lsPrefijo = "local-";
				//conExter = DriverManager.getConnection(lsExteURL, lsExteUSR, lsExtePWD);
			} else if(liCodServ==2){
				con = DriverManager.getConnection(lsExteURL, lsExteUSR, lsExtePWD);
				lsPrefijo = "remoto-";
				//conLocal = DriverManager.getConnection(lsLoclURL, lsLoclUSR, lsLoclPWD);
			} else{
				resultado = "No se escogi贸 el tipo de conexi贸n al servidor.";
				return  resultado;
			}
			File convFile = FileUtil.fileExists2(fileOffline[0].getOriginalFilename());
			String lsMimeTyp = URLConnection.guessContentTypeFromName(convFile.getName());
			System.out.println("mime+ " + lsMimeTyp);
			if(lsMimeTyp==null || !lsMimeTyp.equals("text/plain")){
				resultado = "El formato del archivo no es texto plano.";
				return resultado;
			}
			System.out.println(fileOffline[0].getOriginalFilename());
			if (convFile.exists()){
				//convFile.delete();
				//convFile.re
				//System.out.println("Archivo eliminado");
				//return "El archivo generado ya ha sido subido";
			}
			fileOffline[0].transferTo(convFile);	
			FileReader fileReader = new FileReader(convFile);
			br = new BufferedReader(fileReader);
			String line = br.readLine();
			int i = 0;
			String lsNomTabl = "";
			String rslt = "";
			if(liAccions == 1){
				while (null != line) {
					
					if (line.contains("Tabla>>")) {
						//Agrego el 2 para la inserci贸n de la tabla en el servidor en la nube que cre茅 como prueba, ejm: leotbc_material2
						//String idTabla = liCodServ==1 ? "": "2";
						lsNomTabl = line.split(">>")[1];//+idTabla ;
						st2 = con.prepareStatement("SELECT * FROM "+lsNomTabl+" limit 1");
						resultSet = st2.executeQuery();
						metadata = resultSet.getMetaData();
						columnCount = metadata.getColumnCount();
						System.out.println(lsNomTabl);//resultado.add("Ejecutando en tabla:" + lsNomTabl);
					}else{
						//line = line.replaceAll(">>", "\";").replaceAll("<<", "\"").concat(SEPARATOR);
						//line = line.concat(SEPARATOR);
						//System.out.println(lsNomTabl);
						//System.out.println("LINE" + line);
						//line = line.replaceAll("\"\"", "\"\"").concat(SEPARATOR);
						String[] fields = line.split("'>>");
						fields = removeTrailingQuotes(fields);
						String s = Arrays.toString(fields).replace("[", "").replace("]", "").concat(",1");;//.concat(",1");
						//System.out.println("System: " +s);
						
						String query = "INSERT INTO "+lsNomTabl+" VALUES(" + s + ")";
						//con.setAutoCommit(false);
						st = con.prepareStatement(query);
						int exito = 0;
						lsColName = metadata.getColumnName(1);
						try {
							exito = st.executeUpdate();
							System.out.println("Se insert贸 con 茅xito: "  + query );//String newNomTbl = liCodServ==2 ? lsNomTabl.substring(0,lsNomTabl.length()-1): lsNomTabl;
							//lsCadena.add("UPDATE " + lsNomTabl + " SET v_flgoffline = 1 WHERE " + lsColName + "="+ fields[0].replace("[", "").replace("]", ""));
							//rslt = "Consulta de inserci贸n ejecutada con 茅xito";
						} catch (SQLException e) {
							//ArrayList<String> columns = new ArrayList<String>();
							for (int j = 1; j < columnCount; j++) {
								String columnName = metadata.getColumnName(j);
								fields[j - 1] = columnName + "=" + fields[j - 1];
							}
	
							String updateConvert = Arrays.toString(fields).replace("[", "").replace("]", "");
							//updateConvert = updateConvert.concat(", v_flgoffline = 1");
							//System.out.println("for cols:" + updateConvert);
							String queryUpdate = "UPDATE "+lsNomTabl+"  set "
									+ Arrays.toString(fields).replace("[", "").replace("]", "") + " WHERE "
									+ fields[0].replace("[", "").replace("]", "");
							//System.out.println("qryUpdate: " + queryUpdate);
							//con.setAutoCommit(false);
							st2 = con.prepareStatement(queryUpdate);
							try {
								exito = st2.executeUpdate();
								System.out.println("Se actualiz贸 con 茅xito: "  + queryUpdate );//String newNomTbl = liCodServ==2 ? lsNomTabl.substring(0,lsNomTabl.length()-1): lsNomTabl;
								//lsCadena.add("UPDATE " +   lsNomTabl + " SET v_flgoffline = 1 WHERE "+ lsColName.split(",")[0] + "="+ fields[0].replace("[", "").replace("]", ""));
								//rslt = "Consulta de actualizaci贸n ejecutada con 茅xito";
							} catch (SQLException ex) {
								//con.rollback();
								exito = 0;
								System.out.println("Error al ejecutar script: " + e.getMessage());
								resultado = e.getMessage();
							}
						}
					}
					
					
					line = br.readLine();
					//resultado.add(rslt);
					i++;
	
				}
				resultado = "1";
			} else if(liAccions == 2){
				if (null != line) {
					String[] query = line.split(",");
					for (String q : query){
						System.out.println("qry:" + q);
						st = con.prepareStatement(q);
						try {
							st.executeUpdate();
							rslt = "Registro actualizado con 茅xito.";
						} catch (SQLException e) {
							resultado = e.getMessage();
						}
					}
					resultado="1";
					
					
				}
			}
			//st.executeBatch(); // insert remaining records
			//con.commit();
			br.close();
		} catch (IOException e) {
			//con.rollback();
			resultado =e.getMessage();
			e.printStackTrace();
		} catch (SQLException e) {
			//con.rollback();
			resultado = e.getMessage();
			e.printStackTrace();
		}  catch (NullPointerException e) {
			//con.rollback();
			resultado = e.getMessage();
			e.printStackTrace();
		}  finally {
			if (null != ps)
				ps.close();
			if (null != con)
				con.close();
		}
		return resultado;
	}
	
	
	
 
	@RequestMapping(value = "/listanotas", method = RequestMethod.GET)
	@ResponseBody 
	public List<EvaluacionBean> dolistanotas(@RequestParam("p_codlengua") Long lengua)  
	{ 
    	EvaluacionBean Bean = new EvaluacionBean();
    	Bean.setUsuarioMatriculaBean(new UsuarioMatriculaBean()); 
    	Bean.getUsuarioMatriculaBean().getMatriculaBean().setLengua(new LenguaBean()); 
    	Bean.setInstitucionBean(new InstitucionBean()); 
    	Bean.getUsuarioMatriculaBean().setMatriculaBean(new MatriculaBean()); 
    	Bean.getUsuarioMatriculaBean().setUsuarioBean(new UsuarioBean()); 
    	Bean.setNivel(new MaestraBean());
    	Bean.setSubNivel(new MaestraBean()); 
    	Bean.getUsuarioMatriculaBean().getUsuarioBean().setCodigo(usuario.getCodigoUsuario()); 
    	Bean.getUsuarioMatriculaBean().getMatriculaBean().getLengua().setCodigo(lengua);  
    	lstSeguimientoBean = new ArrayList<SeguimientoAlumIntentoBean>();  
		List<EvaluacionBean> lstEvaluacionBean = null;
		try {
			lstEvaluacionBean = this.evaluacionService.getBuscarPorFiltros(Bean);
			 
			if (lstEvaluacionBean != null && lstEvaluacionBean.size() >0) {
				System.out.println("Lista _:" + lstEvaluacionBean.size());
			}else{
				System.out.println("Lista vacia");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstEvaluacionBean;
	}
	
	
	@RequestMapping(value = "/1listanotas", method = RequestMethod.POST)
	@ResponseBody 
	public List<UnidadLeccionBean> do1listanotas(@RequestParam("p_codlengua") Long lengua 
			)
	{ 
		UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
		unidadLeccionBean.setUnidadBean(new UnidadBean());
		unidadLeccionBean.getUnidadBean().setLenguaEstructuraBean(new LenguaEstructuraBean());
		unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().setSubNivel(new MaestraBean());
	 
		unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getLenguaBean().setCodigo(lengua);
//		unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getNivel().setCodigoRegistro(nivel);
//		unidadLeccionBean.getUnidadBean().getLenguaEstructuraBean().getSubNivel().setCodigoRegistro(subNivel);
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
	
	
	
	@RequestMapping(value = "/leerDescargaArchivo", method = RequestMethod.GET)
	public void leerDescargaArchivo(HttpServletResponse response) throws SQLException {
		Connection con= null;
		//Connection conLocal = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		BufferedReader br = null;
		String lsPrefijo="";
		try {
				
			File dir = FileUtil.fileExists(this.getRootPathFile()); // CREAR CARPETA
			String lsArchivo = dir.getAbsolutePath()+this.get2Diagonal()+lsPrefijo+"update.txt";//"C:/natigu/"+lsPrefijo+"usuarios-inscritos.txt";
			
			File lmDirFile = FileUtil.fileExists2(lsArchivo);
			fichero = null;
			pw = null;
			fichero = new FileWriter(lmDirFile);
			pw = new PrintWriter(fichero);
			System.out.println("mi candea;" + lsCadena);
			pw.print(lsCadena);
			pw.close();	
			String lsMimeTyp = URLConnection.guessContentTypeFromName(lmDirFile.getName());
			if (lsMimeTyp == null) {
				System.out.println("No se obtuvo mimeType");
				lsMimeTyp = "application/octet-stream";
			}
			try {
				response.setContentType(lsMimeTyp);
				response.setHeader("Content-Disposition",
						String.format("inline; filename=\"" + lmDirFile.getName() + "\""));
				response.setContentLength((int) lmDirFile.length());
				InputStream inputStream = new BufferedInputStream(new FileInputStream(lmDirFile));
				FileCopyUtils.copy(inputStream, response.getOutputStream());
				inputStream.close();
				response.flushBuffer();
			} catch (IOException ex) {
				System.out.println("Error writing file to output stream. Filename was '{}'");
				throw new RuntimeException("IOError writing file to output stream");
			} 
		}catch (IOException e) {
			//con.rollback();
			e.printStackTrace();
		}  finally {
			if (null != ps)
				ps.close();
			if (null != con)
				con.close();
		}
	}
	
	
	private static String[] removeTrailingQuotes(String[] fields) {
		String result[] = new String[fields.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = fields[i].replaceAll("^" + QUOTEA, "").replaceAll(QUOTEB + "$", "");
			if (isNumeric(result[i])) {
				result[i] = result[i];
			} else {
				result[i] = "'" + result[i] + "'";
			}
		}
		return result;
	}

	public static boolean isNumeric(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}
	
	public String obtenerColumnas(ResultSetMetaData metadata, int columnCount){
		String lsColName="";
		try {
			for (int j = 1; j <= columnCount; j++) {	
					lsColName = lsColName.concat(metadata.getColumnName(j) + ",");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsColName;
	}
	
	 public String getRootPath() {    	
			return ResourceUtil.getKey("ruta.natigu.archivos.general.fotouser");
	     }

	public UsuarioPerfilBean getPerfilBean() {
		return perfilBean;
	}


	public void setPerfilBean(UsuarioPerfilBean perfilBean) {
		this.perfilBean = perfilBean;
	}
	private String getRootPathFile(){
		return ResourceUtil.getKey("ruta.natigu.archivos.offline");
	}

	public SeguimientoAlumIntentoBean getSeguimientoAlumIntentoBean() {
		return seguimientoAlumIntentoBean;
	}

	public void setSeguimientoAlumIntentoBean(SeguimientoAlumIntentoBean seguimientoAlumIntentoBean) {
		this.seguimientoAlumIntentoBean = seguimientoAlumIntentoBean;
	}

	public SeguimientoAlumIntentoService getSeguimientoAlumIntentoService() {
		return seguimientoAlumIntentoService;
	}

	public void setSeguimientoAlumIntentoService(
			SeguimientoAlumIntentoService seguimientoAlumIntentoService) {
		this.seguimientoAlumIntentoService = seguimientoAlumIntentoService;
	}
	
	
	public String getNombreSubni() {
		return NombreSubni;
	}

	public void setNombreSubni(String nombreSubni) {
		NombreSubni = nombreSubni;
	}

	class Intentos{
		
		private String subNivel;
		private int 	intento1 = 0; 
		private int 	intento2 = 0;
		private int 	intento3 = 0;		  
		
		
		public String getSubNivel() {
			return subNivel;
		}
		public void setSubNivel(String subNivel) {
			this.subNivel = subNivel;
		}
		public int getIntento1() {
			return intento1;
		}
		public void setIntento1(int intento1) {
			this.intento1 = intento1;
		}
		public int getIntento2() {
			return intento2;
		}
		public void setIntento2(int intento2) {
			this.intento2 = intento2;
		}
		public int getIntento3() {
			return intento3;
		}
		public void setIntento3(int intento3) {
			this.intento3 = intento3;
		}
	}
	
	
	
	
	
	
}