package pe.gob.procalidad.natigu.web.gestion.controller.seguridad;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoInstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMonedaGBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteInstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.ModalBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.SliderDetalleBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.SesionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioPerfilBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.factory.interfaces.FactoryService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.SessionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.UsuarioPerfilService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.UsuarioService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.FileUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.Row;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ValidatorField;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.Encrypt;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.EncryptException;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.EncryptHability;

@Controller
@Scope(value="session")
@SessionAttributes("usuarioEstudiante")

@RequestMapping(value = "perfil")
public class PerfilController extends BaseController{
	@Autowired
	private SessionService sessionService;
	
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
	
	@RequestMapping(value = "/carga", method = RequestMethod.GET)
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
			//System.out.println(" beanMascota.getImagenTienda() " + beanMascota.getImagenTienda());
		}
				
		System.out.println("modificar obtenerDatosUsuarioPerfil: " + newUsuarioPerfilBean);
		
		ModelAndView mav = new ModelAndView("lengua/carga", "command",newUsuarioPerfilBean);
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
			//System.out.println(" beanMascota.getImagenTienda() " + beanMascota.getImagenTienda());
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
		List<AlumnoInstitucionBean> lstAlumnoInstitucionBean = new ArrayList<AlumnoInstitucionBean>();
		List<DocenteInstitucionBean> lstDocenteInstitucionBean  = new ArrayList<DocenteInstitucionBean>();
		UsuarioPerfilBean prmUsuarioPerfilBean = new UsuarioPerfilBean();		
		prmUsuarioPerfilBean.setCodigoUsuario((long)codigo);
		AlumnoBean prmAlumnoBean = new AlumnoBean();
		DocenteBean 			docenteBean = new DocenteBean();
		String nombreInstitucion = "";
		try {
			newUsuarioPerfilBean = this.fs.getUsuarioPerfilService().buscarXcodigoUsu(prmUsuarioPerfilBean);
			if (VO.isNotNull(newUsuarioPerfilBean)) {
				try {
					System.out.println("Encrypt.decrypt" + Encrypt.decrypt(newUsuarioPerfilBean.getUsuario().getPasswordUsuario()));
					newUsuarioPerfilBean.getUsuario().setDecryptpasswordUsuario(Encrypt.decrypt(newUsuarioPerfilBean.getUsuario().getPasswordUsuario()));
				} catch (EncryptException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		
		if(newUsuarioPerfilBean != null){
			if(newUsuarioPerfilBean.getPerfil().getCodigoPerfil() == 4){   //estudiante
				AlumnoInstitucionBean	prmAlumnoInstitucionBean = new AlumnoInstitucionBean();
				prmAlumnoInstitucionBean.setAlumnoBean(new AlumnoBean()); 
				prmAlumnoInstitucionBean.getAlumnoBean().setCodigo(newUsuarioPerfilBean.getUsuario().getPersona().getLenguaBean().getMatriculaBean().getAlumnoBean().getCodigo());
				 	try{ 
				 		lstAlumnoInstitucionBean = (List<AlumnoInstitucionBean>) this.fs.
							getAlumnoInstitucionService().getBuscarPorCodigoAlumno(prmAlumnoInstitucionBean);
				 	}catch(Exception e){
				 		e.printStackTrace();
				 	}
				
					if(lstAlumnoInstitucionBean != null){
						prmAlumnoBean.setLstAlumnoInstitucionBean(lstAlumnoInstitucionBean);
						
					} 
				
					if (prmAlumnoBean.getLstAlumnoInstitucionBean() != null	&&	prmAlumnoBean.getLstAlumnoInstitucionBean().size() > 0 ) {
						for (AlumnoInstitucionBean prmAlumnoInstitucionBeanlst : prmAlumnoBean.getLstAlumnoInstitucionBean()) {
							if(nombreInstitucion.length() > 0){
								nombreInstitucion = nombreInstitucion + ", ";
							}
							nombreInstitucion = nombreInstitucion + 
							prmAlumnoInstitucionBeanlst.getInstitucionBean().getNombreInstitucion() + "\n";; 
							
//									listadoInstitucionVo.add(String.valueOf(prmAlumnoInstitucionBeanlst.getInstitucionBean().getCodigo()));
//									listadoInstitucionVo.add(prmAlumnoInstitucionBeanlst.getInstitucionBean().getNombreInstitucion());
						}			
					}
					newUsuarioPerfilBean.getUsuario().getPersona().getLenguaBean().getMatriculaBean().getInsti().setNombreInstitucion(nombreInstitucion);
			}else if(newUsuarioPerfilBean.getPerfil().getCodigoPerfil() == 2){  //docente
				DocenteInstitucionBean prmdocenteinst = new DocenteInstitucionBean();
				prmdocenteinst.setInstitucionBean(new InstitucionBean());
				prmdocenteinst.setDocenteBean(newUsuarioPerfilBean.getUsuario().getPersona().getLenguaBean().getMatriculaBean().getDocenteBean());
				try {
					 lstDocenteInstitucionBean = (List<DocenteInstitucionBean>) 
							this.fs.getDocenteInstitucionService().getBuscarPorFiltros(prmdocenteinst);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				
				if(lstDocenteInstitucionBean != null){
					docenteBean.setLstDocenteInstitucionBean(lstDocenteInstitucionBean); 
				}
				if (docenteBean.getLstDocenteInstitucionBean() != null	&&	docenteBean.getLstDocenteInstitucionBean().size() > 0 ) {
					for (DocenteInstitucionBean prmDocenteInstitucionBean : docenteBean.getLstDocenteInstitucionBean()) {
						if(nombreInstitucion.length() > 0){
							nombreInstitucion = nombreInstitucion + ", ";
						}
						nombreInstitucion = nombreInstitucion + 
						prmDocenteInstitucionBean.getInstitucionBean().getNombreInstitucion() + "\n";
//						listadoInstitutoVo.add(String.valueOf(prmDocenteInstitucionBean.getInstitucionBean().getCodigo()));
//						listadoInstitutoVo.add(prmDocenteInstitucionBean.getInstitucionBean().getNombreInstitucion());
					}			
				}
				newUsuarioPerfilBean.getUsuario().getPersona().getLenguaBean().getMatriculaBean().getInsti().setNombreInstitucion(nombreInstitucion);
				 
				
				
			}
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
			
			System.out.println("VAL_CORREO " + ValidatorField.validarCorreo(correo));
			System.out.println("VAL_TELF " + ValidatorField.validarMascaraTelefono(telefono));
			if(ValidatorField.validarCorreo(correo) && ValidatorField.validarMascaraTelefono(telefono)) {
				this.setAuditoria(prmPersonaBean, request, false);
				sw =  (this.fs.getPersonaService().actualizardatosuser(prmPersonaBean)); 
			}
			 
		
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
					
					usuarioBean = this.fs.getUsuarioService().buscarxcodigousua(usuarioBean);
					

		    	    String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
		    	    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
		    	    EncryptHability aesUtil = new EncryptHability(128, 1000);
		    	    oldpass = aesUtil.decrypt(salt, iv, "oldPass", oldpass);
		    	    newpass = aesUtil.decrypt(salt, iv, "newPass", newpass);
		    	    
					Encrypt.init("KEY_ENCRYPT_PASS");
					String pass = newpass;
					String messagePass = "La contrase馻 debe: ";
		    		if((pass.length() < 8)) {
		    	    	messagePass+= "tener m韓imo 8 d韌itos, ";
		    		} 
		    	    if(!pass.matches(".*[a-z].*")){
		    			messagePass+= "contener al menos una min鷖cula, ";
		    		} 
		    	    if(!pass.matches(".*[A-Z].*")){
		    			messagePass+= "contener al menos una may鷖cula, ";
		    		} 
		    	    if(!pass.matches(".*[0-9].*")){
		    			messagePass+= "contener al menos un n鷐ero, ";
		    		}
		    	    if(messagePass == "La contrase馻 debe: ") {
		    			messagePass = "";
		    		} else {
		    			messagePass = messagePass.substring(0,messagePass.length()-2);
		    		}
		    	    
		    	    if(messagePass != null && messagePass != ""){
		    			return 2;
		    		}
		    	    
					
					if(Encrypt.encrypt(oldpass).equals(usuarioBean.getPasswordUsuario())){

						usuarioBean.setPasswordUsuario(Encrypt.encrypt(oldpass));
						
						newpassEncrypt = Encrypt.encrypt(newpass);
						usuarioBean.setNewPassword(newpassEncrypt);
						usuarioBean.setFlgRestPass("0");
						
						sw=1;
						this.setAuditoria(usuarioBean, request, false);
						sw = this.fs.getUsuarioService().cambiarPassword(usuarioBean);
						
					}else{
						sw=0;
					}
					
				} catch (Exception e) { 
					e.printStackTrace();
				}
				
				if (sw==1) {

					
					UsuarioBean usuario = this.getUsuarioSesion(request);
					SesionBean _sesionBean=new SesionBean();
					_sesionBean.setUser_id((int)usuario.getCodigo());
					_sesionBean.setSession_id(request.getSession().getId());
					
					try {
						boolean flag=sessionService.sessionGestor(_sesionBean, "UPD_PASS");
						if(flag) {
							System.out.println("========= CERRAR CESSIO : 1");
						}else {
							System.out.println("========= NO CERRAR CESSIO : 0");
						}
					} catch (DAOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//-----
					/*
					HttpSession session = request.getSession();
					session.removeAttribute("usuarioEstudiante");
					session.invalidate();
					
					LoginVo prmLogin = new LoginVo();
					ModelAndView mav = new ModelAndView("../home", "command",prmLogin);
					this.cargarContenido(mav);
					return mav;
					*/
					 
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
	@RequestMapping(value = "/descargarArchivoDatos", method = RequestMethod.POST)
	@ResponseBody
	public String descargarArchivoDatos(@RequestParam("liCodServ") int liCodServ,@RequestParam("liCodOpci") int liCodOpci,@RequestParam("liCodLeng") int liCodLeng) {
		Connection con = null;
		BufferedReader br = null;
		BufferedWriter writer = null;
		String lsPrefijo = "";
		String lsTablSQL = "";
		String lsTblUIns = "";
		String lsArchivo = "";
		String lsMimeTyp = "";
		String lsRpta501 = "";
		//System.out.println(dateAsString);
		try {
			if(liCodServ==1){
				con = DriverManager.getConnection(lsLoclURL, lsLoclUSR, lsLoclPWD);
				lsPrefijo = "local-";
			} else if(liCodServ==2){
				con = DriverManager.getConnection(lsExteURL, lsExteUSR, lsExtePWD);
				lsPrefijo = "remoto-";
			} else{
				lsRpta501 = "No se encontr贸 el tipo de conexi贸n";
				return lsRpta501;
			}
			UsuarioMatriculaBean usuarioMatriBean =  obtenerUsuarioMatricula((usuario.getCodigo()) ,liCodLeng); 
			
			File dir = FileUtil.fileExists(this.getRootPathFile()); // CREAR CARPETA
			
			switch (liCodOpci) {
			case 2:
				lsTablSQL = "acad.leotbd_segalumlen";
				lsTblUIns = "acad.leotbc_segaluejercicio";
				lsArchivo = dir.getAbsolutePath()+this.get2Diagonal()+lsPrefijo+liCodLeng+"seguimiento-usuario"+usuarioMatriBean.getCodigo()+dateAsString+".txt"; //"C:/natigu/"+lsPrefijo+"seguimiento-usuarios.txt";
				lmDirFile = FileUtil.fileExists2(lsArchivo);
				try{
					lsConsult = "SELECT AM.n_codaluxmeda, AM.n_codusumat, AM.n_codpremio, AM.v_flgest,  "+
								"		coalesce(AM.n_codusureg,0) n_codusureg, coalesce(AM.d_fecreg, current_date) d_fecreg, coalesce(AM.v_hostreg,'') v_hostreg,  "+
								"		coalesce(AM.n_codusumod,0) n_codusumod, coalesce(AM.d_fecmod, current_date) d_fecmod ,coalesce(AM.v_hostmod,'') v_hostmod, "+ 
								"		coalesce(AM.n_codundlec,0) n_codundlec "+ 
								"FROM 	acad.leotbd_alumnoxmedalla AM  	"+
								"	LEFT JOIN acad.leotbd_usumatricula acad		"+
								"		ON acad.n_codusumat = AM.n_codusumat	"+
								"			LEFT JOIN acad.leomvc_matricula mat	"+
								"				ON mat.n_codmatri = acad.n_codmatri	"+
								"					LEFT JOIN acad.leotbd_insclengua  insc 	"+
								"						ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua = "+liCodLeng+			
								" WHERE	AM.n_codusumat ="+ usuarioMatriBean.getCodigo();
								//"	AND med.v_flgest = '1' ";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					fichero = null;
					pw = null;
					Row.formTable(resultSet, table);
					writer = new BufferedWriter(new FileWriter(lmDirFile));
					fichero = new FileWriter(lmDirFile);
					pw = new PrintWriter(fichero);
					System.out.println("Tabla>>acad.leotbd_alumnoxmedalla" );
					pw.println("Tabla>>acad.leotbd_alumnoxmedalla" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						try {
							lsCadena = Encrypt.encrypt(lsCadena);
						} catch (EncryptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					///////////////////////////////////////////////////////////
					///////////////////////////////////////////////////////////
					lsConsult = "SELECT	AM.n_codaluxmongem, AM.n_codusumat, coalesce(AM.n_cantmonedas,0), coalesce(AM.n_cantgemas,0) n_cantgemas, coalesce(AM.v_flgest,'0') v_flgest, "+ 
							"		coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg, coalesce(AM.v_hostreg, '') v_hostreg,  "+
							"		coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod, "+ 
							"		coalesce(AM.n_cantbono,0) n_cantbono "+
								"FROM	acad.leotbd_alumnoxmonegem AM "+
								"		LEFT JOIN acad.leotbd_usumatricula acad	"+
								"			ON acad.n_codusumat = AM.n_codusumat "+
								"				LEFT JOIN acad.leomvc_matricula mat "+
								"					ON mat.n_codmatri = acad.n_codmatri "+
								"						LEFT JOIN acad.leotbd_insclengua  insc "+
								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
								"	WHERE	AM.n_codusumat =" + usuarioMatriBean.getCodigo();
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leotbd_alumnoxmonegem" );
					pw.println("Tabla>>acad.leotbd_alumnoxmonegem" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						try {
							lsCadena = Encrypt.encrypt(lsCadena);
						} catch (EncryptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					
					
					lsConsult = "SELECT	AM.n_codsegaluejer, coalesce(AM.n_nummonedas,0) n_nummonedas, AM.n_codusumat, AM.n_codlengua, AM.n_codmatpej, AM.v_flgest,  "+
								"	coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg,  coalesce(AM.v_hostreg,'') v_hostreg, "+ 
								"	coalesce(AM.n_codusumod,0) n_codusumod,coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod,'') v_hostmod "+  
								"FROM	acad.leotbc_segaluejercicio   AM "+ 
								"		LEFT JOIN acad.leotbd_usumatricula acad	"+
								"			ON acad.n_codusumat = AM.n_codusumat "+
								"				LEFT JOIN acad.leomvc_matricula mat "+
								"					ON mat.n_codmatri = acad.n_codmatri "+
								"						LEFT JOIN acad.leotbd_insclengua  insc "+
								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
								"	WHERE	   AM.n_codusumat =" + usuarioMatriBean.getCodigo();
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leotbc_segaluejercicio" );
					pw.println("Tabla>>acad.leotbc_segaluejercicio" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						try {
							lsCadena = Encrypt.encrypt(lsCadena);
						} catch (EncryptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					
					//
					//
					lsConsult = "SELECT	AM.n_codsegaluejerdet, coalesce(AM.n_nummonedas,0) n_nummonedas, AM.n_codusumat, AM.n_codlengua, coalesce(AM.n_codmatpej,0) n_codmatpej, "+ 
								"	coalesce(AM.n_codpregun,0) n_codpregun, AM.v_flgest,  "+
								"	coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg,coalesce(AM.v_hostreg, '') v_hostreg,  "+
								"	coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod "+ 
								"FROM	acad.leotbd_segaluejerdet    AM "+ 
								"		LEFT JOIN acad.leotbd_usumatricula acad	"+
								"			ON acad.n_codusumat = AM.n_codusumat "+
								"				LEFT JOIN acad.leomvc_matricula mat "+
								"					ON mat.n_codmatri = acad.n_codmatri "+
								"						LEFT JOIN acad.leotbd_insclengua  insc "+
								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
								"	WHERE	 AM.n_codusumat =" + usuarioMatriBean.getCodigo();
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leotbd_segaluejerdet" );
					pw.println("Tabla>>acad.leotbd_segaluejerdet" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						try {
							lsCadena = Encrypt.encrypt(lsCadena);
						} catch (EncryptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					
					//
					//
					lsConsult = "SELECT	AM.n_codsegaluinten, AM.n_codusumat, AM.n_codmatpej, coalesce(AM.n_numintento,0) n_numintento, AM.v_flgest,  "+
								"		coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg, coalesce(AM.v_hostreg, '') v_hostreg,  "+
								"		coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod,  "+ 
								"		coalesce(AM.n_codpregun,0) n_codpregun "+ 
								"FROM	acad.leotbd_segaluintentos  AM  "+
								"		LEFT JOIN acad.leotbd_usumatricula acad	"+
								"			ON acad.n_codusumat = AM.n_codusumat "+
								"				LEFT JOIN acad.leomvc_matricula mat "+
								"					ON mat.n_codmatri = acad.n_codmatri "+
								"						LEFT JOIN acad.leotbd_insclengua  insc "+
								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
								"	WHERE	 AM.n_codusumat =" + usuarioMatriBean.getCodigo();
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leotbd_segaluintentos" );
					pw.println("Tabla>>acad.leotbd_segaluintentos" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						try {
							lsCadena = Encrypt.encrypt(lsCadena);
						} catch (EncryptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					
					//
					//
					lsConsult =  "SELECT	AM.n_codsegalu, AM.n_codusumat, AM.n_tm1sitseg, coalesce(AM.n_codundlec,0) n_codundlec, AM.v_flgest, "+
								"		coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg, coalesce(AM.v_hostreg, '') v_hostreg,   "+
								"		coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod, "+ 
								"		coalesce(AM.n_codmatpej, 0) n_codmatpej, coalesce(AM.n_codlesmat,0) n_codlesmat  "+  
								"FROM	acad.leotbd_segalumlen   AM "+ 
								"		LEFT JOIN acad.leotbd_usumatricula acad	"+
								"			ON acad.n_codusumat = AM.n_codusumat "+
								"				LEFT JOIN acad.leomvc_matricula mat "+
								"					ON mat.n_codmatri = acad.n_codmatri "+
								"						LEFT JOIN acad.leotbd_insclengua  insc "+
								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
								"	WHERE	 AM.n_codusumat =" + usuarioMatriBean.getCodigo();
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leotbd_segalumlen" );
					pw.println("Tabla>>acad.leotbd_segalumlen" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						try {
							lsCadena = Encrypt.encrypt(lsCadena);
						} catch (EncryptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					
					//
					//
					lsConsult = "SELECT	AM.n_codadquiusu, coalesce(AM.n_codfond,0) n_codfond , AM.n_codusuari, coalesce(AM.n_tm1sitfousuar,0) n_tm1sitfousuar, AM.v_flgest, "+ 
								"	coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg,coalesce(AM.v_hostreg, '') v_hostreg,  "+
								"	coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod,coalesce(AM.n_codregion,0) n_codregion,  "+
								"	coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.n_codmasco,0) n_codmasco, coalesce(AM.n_tm1tipadqui,0) n_tm1tipadqui, "+ 
								"	coalesce(AM.n_swpredeterminado,0) n_swpredeterminado, coalesce(AM.n_codcombo,0) n_codcombo "+ 
								"FROM	conf.leotbc_adquiusu AM  "+ 
								"		LEFT JOIN acad.leotbd_usumatricula acad	"+
								"			ON acad.n_codusuari = AM.n_codusuari  "+
								"				LEFT JOIN acad.leomvc_matricula mat "+
								"					ON mat.n_codmatri = acad.n_codmatri "+
								"						LEFT JOIN acad.leotbd_insclengua  insc "+
								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
								"	WHERE	 AM.n_codusuari =" + usuarioMatriBean.getUsuarioBean().getCodigo();
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>conf.leotbc_adquiusu" );
					pw.println("Tabla>>conf.leotbc_adquiusu" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						try {
							lsCadena = Encrypt.encrypt(lsCadena);
						} catch (EncryptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					
					//
					//
					lsConsult = "SELECT	AM.n_codevalua, AM.n_codusumat, coalesce(AM.n_tm1siteva,0) n_tm1siteva, coalesce(AM.n_totejercio,0) n_totejercio, coalesce(AM.n_correctos,0) n_correctos, "+ 
								"	coalesce(AM.n_errados,0) n_errados, coalesce(AM.n_nota,0.00) n_nota, coalesce(AM.n_codmedalla,0) n_codmedalla, AM.v_flgest,   "+
								"	coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_timestamp) d_fecreg,coalesce(AM.v_hostreg, '') v_hostreg,   "+
								"	coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_timestamp) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod, "+  
								"	coalesce(AM.n_tm2duracion,0) n_tm2duracion, coalesce(AM.d_fechahoraini, current_timestamp) d_fechahoraini, "+  
								"	coalesce(AM.d_fechahorafin,current_timestamp) d_fechahorafin, coalesce(AM.n_tm2nivel,0) n_tm2nivel, COALESCE(AM.n_tm2subnivel,0) n_tm2subnivel "+ 
								"FROM	acad.leotbc_evaluacion  AM  "+ 
								"		LEFT JOIN acad.leotbd_usumatricula acad	"+
								"			ON acad.n_codusumat = am.n_codusumat "+
								"				LEFT JOIN acad.leomvc_matricula mat "+
								"					ON mat.n_codmatri = acad.n_codmatri "+
								"						LEFT JOIN acad.leotbd_insclengua  insc "+
								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
								"	WHERE	 AM.n_codusumat =" + usuarioMatriBean.getCodigo();
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leotbc_evaluacion" );
					pw.println("Tabla>>acad.leotbc_evaluacion" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						try {
							lsCadena = Encrypt.encrypt(lsCadena);
						} catch (EncryptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					
					//
					//
					lsConsult = "SELECT	AM.n_codevaldet, AM.n_codevalua, coalesce(AM.n_tm2tpejer,0) n_tm2tpejer, coalesce(AM.n_codmatpej,0) n_codmatpej, coalesce(AM.n_codlesmat,0) n_codlesmat, "+
								"		coalesce(AM.n_tm1sitevdt,0) n_tm1sitevdt, coalesce(AM.v_swaprobad,'0') v_swaprobad, AM.v_flgest,  "+
								"		coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_timestamp) d_fecreg, coalesce(AM.v_hostreg, '') v_hostreg,  "+
								"		coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_timestamp) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod, coalesce(AM.n_tm2tpreg,0) n_tm2tpreg "+ 
								"FROM	acad.leotbd_evaldetalle  AM "+
								"	LEFT JOIN acad.leotbc_evaluacion eva  "+
								"		ON eva.n_codevalua=AM.n_codevalua  "+
								"		LEFT JOIN acad.leotbd_usumatricula acad	 "+
								"			ON acad.n_codusumat = eva.n_codusumat  "+
								"				LEFT JOIN acad.leomvc_matricula mat  "+
								"					ON mat.n_codmatri = acad.n_codmatri  "+
								"						LEFT JOIN acad.leotbd_insclengua  insc  "+
								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+				
								"WHERE	 EVA.n_codusumat =" + usuarioMatriBean.getCodigo();
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leotbd_evaldetalle" );
					pw.println("Tabla>>acad.leotbd_evaldetalle" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						try {
							lsCadena = Encrypt.encrypt(lsCadena);
						} catch (EncryptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					
					
					lsConsult = "SELECT	n_codbono, COALESCE(v_nombono,'') v_nombono, COALESCE(v_desbono,'') v_desbono, COALESCE(n_tm1tpbono,0) n_tm1tpbono, COALESCE(n_tm1sitbono,0) n_tm1sitbono,  "+
								"	COALESCE(v_flgest,'0') v_flgest, COALESCE(d_fecreg,current_timestamp) d_fecreg, COALESCE(v_hostreg,'') v_hostreg, COALESCE(d_fecmod,current_timestamp) d_fecmod,  "+
								"	COALESCE(v_hostmod,'') v_hostmod, COALESCE(n_codusumod,0) n_codusumod, COALESCE(v_tiempo,'') v_tiempo, COALESCE(n_tm2tpejer,0) n_tm2tpejer, COALESCE(n_codusureg,0) n_codusureg "+
								"FROM	conf.leotbc_bono";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>conf.leotbc_bono" );
					pw.println("Tabla>>conf.leotbc_bono" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						try {
							lsCadena = Encrypt.encrypt(lsCadena);
						} catch (EncryptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					
					lsConsult = "SELECT	AM.n_codaluxbono, AM.n_codusumat, AM.n_codbono, AM.v_flgest, "+
								"	coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg, coalesce(AM.v_hostreg, '') v_hostreg, "+ 
								"	coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod, "+
								"	COALESCE(AM.n_codundlec,0) n_codundlec "+
								"FROM	acad.leotbd_alumnoxbono AM "+
								"	LEFT JOIN acad.leotbd_usumatricula acad	"+
								"			ON acad.n_codusumat = am.n_codusumat "+
								"				LEFT JOIN acad.leomvc_matricula mat "+
								"					ON mat.n_codmatri = acad.n_codmatri "+
								"						LEFT JOIN acad.leotbd_insclengua  insc "+
								"							ON insc.n_codinsclen = mat.n_codmatri and insc.n_codlengua  = "+liCodLeng+						
								"	WHERE	 AM.n_codusumat =" + usuarioMatriBean.getCodigo();
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leotbd_alumnoxbono" );
					pw.println("Tabla>>acad.leotbd_alumnoxbono" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}try {
							lsCadena = Encrypt.encrypt(lsCadena);
						} catch (EncryptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					
					pw.close();
				} catch (IOException e){
					lsRpta501 = e.getMessage();
					return lsRpta501;
				} catch(NullPointerException e) {
					lsRpta501 = e.getMessage();
					return lsRpta501;
				} finally {
					if (null != ps)
						ps.close();
					if (null != con)
						con.close();
				}
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			lsRpta501 = e.getMessage();
			return lsRpta501;
		} /*finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/
		lsRpta501 = "1";
		return lsRpta501;
	}
	
	@RequestMapping(value = "/descargarArchivoGenerar", method = RequestMethod.GET)
	public void descargarArchivoGenerar(HttpServletResponse response) {
		
		// ----
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
			lmDirFile = null;
		} catch (IOException ex) {
			System.out.println("Error writing file to output stream. Filename was '{}'");
			throw new RuntimeException("IOError writing file to output stream");
		}
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
	
}