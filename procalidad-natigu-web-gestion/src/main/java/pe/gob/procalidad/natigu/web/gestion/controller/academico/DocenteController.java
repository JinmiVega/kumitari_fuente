package pe.gob.procalidad.natigu.web.gestion.controller.academico;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.net.*;
import java.nio.file.Files;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteInstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EspecialidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionDocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaNacionalidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonalBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.DocenteInstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.DocenteService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.EspecialidadService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionDocenteService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaNacionalidadService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UbigeoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.CodeUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ValidatorField;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.Encrypt;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.EncryptHability;
 
@Controller
//@Scope(value="session")
@RequestMapping(value = "docenteController")
public class DocenteController extends BaseController {

	private DocenteBean 			docenteBean;
	private DocenteBean 			docenteBeanTmp;
	private DocenteBean 			docenteBeanFiltro;
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
	private List<DocenteInstitucionBean> lstDocenteInstitucionBean;
	private List<String> listadoInstitutoVo;
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
	
	@Autowired
	private Maestra2Service maestra2Service;

	@Autowired
	private DocenteService docenteService;
	
	@Autowired
	private LenguaService 	lenguaService;

	@Autowired
	private UbigeoService ubigeoService;
	
	@Autowired
	private DocenteInstitucionService docenteInstitucionService;
	
	@Autowired
	private PeticionService peticionService;
	
	public DocenteController(){
		
	}
	
	@PostConstruct
	public void init(){
//		this.usuarioBean = null;
		this.docenteBeanFiltro = new DocenteBean();
		this.setDocenteBean(new DocenteBean());
		this.setLstDocenteBean(new ArrayList<DocenteBean>());
//		this.setLstSituacion(new ArrayList<MaestraBean>());
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("docenteBean") DocenteBean docenteBean,HttpServletRequest request)throws Exception {
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		/* UsuarioBean */
		docenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		docenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		ModelAndView mav = new ModelAndView("academico/listado-docente", "command",docenteBean);
		System.out.println("lstDocenteBean "+lstDocenteBean);
		mav.addObject("lstDocenteBean", new ArrayList<DocenteBean>());
		this.cargarUbigeo(mav, null);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscarListado(HttpServletRequest request) throws Exception {
		return this.doBuscar(docenteBeanFiltro, request);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("docenteBean") DocenteBean docenteBean,HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		/* UsuarioBean */
		docenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		docenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		//docenteBean.setSituacion(docenteBean.getSituacion().getCodigoRegistro());
		System.out.println("docentebean"+docenteBean.getSituacion());
		System.out.println("usuarioBean.getCodPerfilUsuSelec() " + usuarioBean.getCodPerfilUsuSelec());
//		DocenteBean prmDocenteBean = new DocenteBean();
//		prmDocenteBean= docenteBean;
		if (docenteBean.getLenguaBean().getNombre().length() == 0) {
			docenteBean.getLenguaBean().setNombre(null);
		}
		
		
		
		return this.getLista(docenteBean);
	}

	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			boolean sw=false;
			docenteBean = new DocenteBean();
			docenteBean.setCodigo(codigo);
		//	this.setAuditoria(lenguaBean, request, false);
			try { 
					this.setAuditoria(docenteBean, request, false);
					sw =  (this.getDocenteService().eliminar(docenteBean));  
	
			} catch (Exception e) { 
				e.printStackTrace();
			} 		
			
			docenteBean.setCodigo(0);
			/* UsuarioBean */
			docenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
			docenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
			
	//		this.setValoresPredeterminados(docenteBean);
			//List<DocenteBean> lstDocenteBean =null;
			List<InstitucionBean> lstinstixTipoUsu = new ArrayList<InstitucionBean>();
			lstDocenteBean = new ArrayList<DocenteBean>();
			try {
				lstinstixTipoUsu = (List<InstitucionBean>) getInstitucionService().listarInstitucionxTipoUsuario(usuarioBean);
				System.out.println("lstinstixTipoUsu.get(0).getCodigo() " + lstinstixTipoUsu.get(0).getCodigo());
				docenteBean.getInstitucionBean().setCodigo(lstinstixTipoUsu.get(0).getCodigo());
				lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarPorFiltros(docenteBean);
				this.especialidadBean = new EspecialidadBean();
				this.especialidadBean.setDocenteBean(docenteBean);
				this.especialidadBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
				//System.out.println("lstLenguaBean "+lstDocenteBean.size());
			
			} catch (Exception e) {
				System.out.println("getLista " + e.getMessage());
			}
	
			ModelAndView mav = new ModelAndView("academico/ajax/listado-tabla-docente", "command",docenteBean);
			System.out.println("lstDocenteBean "+lstDocenteBean);
			mav.addObject("lstDocenteBean", lstDocenteBean);
			this.cargarUbigeo(mav, null);
			this.cargarCombos(mav);
			return mav;
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesi�n no es valida, por favor inicie sesi�n nuevamente");
			return mav;
		}
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
	
	@RequestMapping(value = "/refrescarInstituciones", method = RequestMethod.GET)
	public @ResponseBody List<InstitucionBean> refrescarInstituciones(@RequestParam("codigo") Integer codigo) {
		DocenteInstitucionBean prDocInsti = new DocenteInstitucionBean();
		DocenteBean prmDocenteBean = new DocenteBean();
		prmDocenteBean.setCodigo(codigo);
		prDocInsti.setDocenteBean(prmDocenteBean);
		prDocInsti.setInstitucionBean(new InstitucionBean());
		prDocInsti.getInstitucionBean().setCodigo(0);
		//lstEspecialidad = null;
		List<DocenteInstitucionBean> lstDocInst = new ArrayList<DocenteInstitucionBean>();
		List<InstitucionBean> lstInst = null;
		
		try {
			docenteBean = this.getDocenteService().getBuscarPorObjecto(prmDocenteBean);
			lstDocInst	= this.docenteInstitucionService.getBuscarPorFiltros(prDocInsti);
			//lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().listarPorCodigoDocente(prmDocenteBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		if(lstDocInst != null){
			lstInst = new ArrayList<InstitucionBean>();
			for(int i=0;i<lstDocInst.size();i++){
				lstInst.add(lstDocInst.get(i).getInstitucionBean());
			}
		}
		
		
		return lstInst;
	}
	
	
	@RequestMapping(value ="/eliminarEspecialidad", method = RequestMethod.GET)
	public @ResponseBody String eliminarEspecialidad(@RequestParam("codigo") Integer codigo,@RequestParam("codigoEspecialidad") Integer codigoEspecialidad,HttpServletRequest request){
		boolean sw=false;
		especialidadBean= new EspecialidadBean();
		especialidadBean.setDocenteBean(new DocenteBean());
		especialidadBean.getDocenteBean().setCodigo(codigo);
		especialidadBean.setLenguaBean(new LenguaBean());
		especialidadBean.getLenguaBean().setCodigo(codigoEspecialidad);
		
		
		try { 
			this.setAuditoria(docenteBean, request, false);
			sw =  (this.getEspecialidadService().eliminar(especialidadBean));
			
		} catch (Exception e) { 
			e.printStackTrace();
		} 	
		System.out.println("sale asi "+sw);
		return sw?"1":"0";
	}
	
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		// request.getRemoteAddr();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		ModelAndView mav = new ModelAndView("academico/registro-docente", "command",new DocenteBean());
//		mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("docenteBean", new DocenteBean());
		this.cargarUbigeo(mav, null);
		this.cargarCombos(mav);
		return mav;
	}

	@ResponseBody 
	@RequestMapping(value = "/registrarInstitucion", method = RequestMethod.POST)
	public String desencriptarLetra(@RequestParam("listado") String prmListado,HttpServletRequest request){
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("DocenteController/registrarInstitucion");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
//	    		Gson gson = new Gson();
	    		Type listaLetraType = new TypeToken<ArrayList<InstitucionTemporal>>(){}.getType();
	    		List<InstitucionTemporal> listaLetraVo = new Gson().fromJson(prmListado, listaLetraType);
	    		
	    		try {
	    			if (listaLetraVo != null && listaLetraVo.size() >0) {
	    			
	    				for (InstitucionTemporal letraEncriptada : listaLetraVo) {
	    				
	    				}
	    			}
	    			
	    		} catch (Exception e) {
	    			e.printStackTrace();

	    		}
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "1";
	}
	


	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificarGet(HttpServletRequest request) {


		ModelAndView mav = new ModelAndView();

		DocenteBean prmDocenteBean = new DocenteBean();
		prmDocenteBean.setCodigo(docenteBeanTmp.getCodigo());
		
		if(docenteBeanTmp != null){
			HttpSession session = request.getSession();
			this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
			
			try {
				docenteBean = this.getDocenteService().getBuscarPorObjecto(prmDocenteBean);
				lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().listarPorCodigoDocente(prmDocenteBean);
			} catch (ServiceException e) { 
				e.printStackTrace();
			}
			DocenteInstitucionBean prmdocenteinst = new DocenteInstitucionBean();
			prmdocenteinst.setInstitucionBean(new InstitucionBean());
			prmdocenteinst.setDocenteBean(docenteBean);
			try {
				this.lstDocenteInstitucionBean = (List<DocenteInstitucionBean>) 
						docenteInstitucionService.getBuscarPorFiltros(prmdocenteinst);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			
			//Almacenar las listas de nacionalidad y lenguas en alumno
			docenteBean.setLstDocenteInstitucionBean(this.getLstDocenteInstitucionBean());
			
			listadoInstitutoVo = new ArrayList<String>();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
			if (docenteBean != null) {
				if(docenteBean.getPersonaBean().getFechaNac()!=null){
					String fechaConFormato = sdf.format(docenteBean.getPersonaBean().getFechaNac()); 
					System.out.println("fechaConFormato"); 
					docenteBean.getPersonaBean().setStrFechaNac(fechaConFormato);
					System.out.println("prmAlumnoBean.getPersonaBean().getStrFechaNac()"+docenteBean.getPersonaBean().getStrFechaNac());
					
					if (docenteBean.getLstDocenteInstitucionBean() != null	&&	docenteBean.getLstDocenteInstitucionBean().size() > 0 ) {
						for (DocenteInstitucionBean prmDocenteInstitucionBean : docenteBean.getLstDocenteInstitucionBean()) {
							listadoInstitutoVo.add(String.valueOf(prmDocenteInstitucionBean.getInstitucionBean().getCodigo()));
							listadoInstitutoVo.add(prmDocenteInstitucionBean.getInstitucionBean().getNombreInstitucion());
						}			
					}
				}
				mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
				mav.addObject("docenteBean", docenteBean);
				mav.addObject("listadoInstitutoVo", listadoInstitutoVo);
				mav.addObject("lstEspecialidad", lstEspecialidad);
				this.cargarUbigeo(mav, docenteBean);
				this.cargarCombos(mav);	
			
			}else{//Encaso quieran ingresar por la url se redireciona a listado.
				/* UsuarioBean */
				prmDocenteBean.setCodigo(0);
				prmDocenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
				prmDocenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
				mav = this.getLista(prmDocenteBean);
				mav.addObject("swMensaje","0");
			}
		}else{	/* UsuarioBean */
			prmDocenteBean.setCodigo(0);
			prmDocenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
			prmDocenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
			mav = this.getLista(prmDocenteBean);
			mav.addObject("swMensaje","0");
		}
		return mav;
	}


	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo,HttpServletRequest request) {

		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		DocenteBean prmDocenteBean = new DocenteBean();
		prmDocenteBean.setCodigo(codigo);
		
		docenteBeanTmp = new DocenteBean();
		docenteBeanTmp.setCodigo(codigo);
		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
	        	try {
					docenteBean = this.getDocenteService().getBuscarPorObjecto(prmDocenteBean);
					lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().listarPorCodigoDocente(prmDocenteBean);
				} catch (ServiceException e) { 
					e.printStackTrace();
				}
				DocenteInstitucionBean prmdocenteinst = new DocenteInstitucionBean();
				prmdocenteinst.setInstitucionBean(new InstitucionBean());
				prmdocenteinst.setDocenteBean(docenteBean);
				try {
					this.lstDocenteInstitucionBean = (List<DocenteInstitucionBean>) 
							docenteInstitucionService.getBuscarPorFiltros(prmdocenteinst);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				
				//Almacenar las listas de nacionalidad y lenguas en alumno
				docenteBean.setLstDocenteInstitucionBean(this.getLstDocenteInstitucionBean());
				
				listadoInstitutoVo = new ArrayList<String>();
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
				ModelAndView mav = new ModelAndView();
				if (docenteBean != null) {
					if(docenteBean.getPersonaBean().getFechaNac()!=null){
						String fechaConFormato = sdf.format(docenteBean.getPersonaBean().getFechaNac()); 
						System.out.println("fechaConFormato"); 
						docenteBean.getPersonaBean().setStrFechaNac(fechaConFormato);
						System.out.println("prmAlumnoBean.getPersonaBean().getStrFechaNac()"+docenteBean.getPersonaBean().getStrFechaNac());
						
						if (docenteBean.getLstDocenteInstitucionBean() != null	&&	docenteBean.getLstDocenteInstitucionBean().size() > 0 ) {
							for (DocenteInstitucionBean prmDocenteInstitucionBean : docenteBean.getLstDocenteInstitucionBean()) {
								listadoInstitutoVo.add(String.valueOf(prmDocenteInstitucionBean.getInstitucionBean().getCodigo()));
								listadoInstitutoVo.add(prmDocenteInstitucionBean.getInstitucionBean().getNombreInstitucion());
							}			
						}
					}
					//encrypt front - back
					String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
				    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
				    EncryptHability aesUtil = new EncryptHability(128, 1000);
			        String plaintextNDoc = aesUtil.encrypt(salt, iv, "numeroDocumentoDocente", docenteBean.getPersonaBean().getNumeroDocumento().toString());
			        docenteBean.getPersonaBean().setNumeroDocumento(plaintextNDoc);
			        
					mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
					mav.addObject("docenteBean", docenteBean);
					mav.addObject("listadoInstitutoVo", listadoInstitutoVo);
					mav.addObject("lstEspecialidad", lstEspecialidad);
					this.cargarUbigeo(mav, docenteBean);
					this.cargarCombos(mav);	
				
				}else{//Encaso quieran ingresar por la url se redireciona a listado.
					/* UsuarioBean */
					prmDocenteBean.setCodigo(0);
					prmDocenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
					prmDocenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
					mav = this.getLista(prmDocenteBean);
					mav.addObject("swMensaje","0");
				}
				return mav;
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesi�n no es valida, por favor inicie sesi�n nuevamente");
			return mav;
		}
	}

	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("docenteBean") DocenteBean docenteBean, HttpServletRequest request) {
		System.out.println("doGrabar");
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		PersonaBean prmPersona = new PersonaBean();
		
		/** CARACTERES ESPECIALES **/
//		docenteBean.getPersonaBean().setNombrePersona(CodeUtil.parseEncode(docenteBean.getPersonaBean().getNombrePersona()));
//		docenteBean.getPersonaBean().setApellidoPaterno(CodeUtil.parseEncode(docenteBean.getPersonaBean().getApellidoPaterno()));
//		docenteBean.getPersonaBean().setApellidoMaterno(CodeUtil.parseEncode(docenteBean.getPersonaBean().getApellidoMaterno()));
//		docenteBean.getPersonaBean().setDireccionPersona(CodeUtil.parseEncode(docenteBean.getPersonaBean().getDireccionPersona()));
//		docenteBean.getPersonaBean().setCorreo(CodeUtil.parseEncode(docenteBean.getPersonaBean().getCorreo()));
		
		//encrypt front - back
		String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    EncryptHability aesUtil = new EncryptHability(128, 1000);
	    
        String plaintextNDoc = aesUtil.decrypt(salt, iv, "numeroDocumentoDocente", docenteBean.getPersonaBean().getNumeroDocumento().toString());
        String plaintextNom = aesUtil.decrypt(salt, iv, "nombreDocente", docenteBean.getPersonaBean().getNombrePersona().toString());
        String plaintextApePat = aesUtil.decrypt(salt, iv, "apellidoPaternoDocente", docenteBean.getPersonaBean().getApellidoPaterno().toString());
        String plaintextApeMat = aesUtil.decrypt(salt, iv, "apellidoMaternoDocente", docenteBean.getPersonaBean().getApellidoMaterno().toString());
        String plaintextFecNac = aesUtil.decrypt(salt, iv, "fechaNacimientoDocente", docenteBean.getPersonaBean().getStrFechaNac().toString());
        String plaintextTelef = aesUtil.decrypt(salt, iv, "telefonoDocente", docenteBean.getPersonaBean().getTelefono().toString());
        String plaintextCorreo = aesUtil.decrypt(salt, iv, "correoDocente", docenteBean.getPersonaBean().getCorreo().toString());
        String plaintextDirec = aesUtil.decrypt(salt, iv, "direccionDocente", docenteBean.getPersonaBean().getDireccionPersona().toString());
        
        docenteBean.getPersonaBean().setNumeroDocumento(plaintextNDoc);
        docenteBean.getPersonaBean().setNombrePersona(plaintextNom);
        docenteBean.getPersonaBean().setApellidoPaterno(plaintextApePat);
        docenteBean.getPersonaBean().setApellidoMaterno(plaintextApeMat);
        docenteBean.getPersonaBean().setStrFechaNac(plaintextFecNac);
        docenteBean.getPersonaBean().setTelefono(plaintextTelef);
        docenteBean.getPersonaBean().setCorreo(plaintextCorreo);
        docenteBean.getPersonaBean().setDireccionPersona(plaintextDirec);
        
		boolean sw = false;
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try {
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("DocenteController/grabar");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	try {
		        		if(docenteBean.getPersonaBean().getNumeroDocumento()!=null&&docenteBean.getPersonaBean().getNumeroDocumento()!=""&&
		        				docenteBean.getPersonaBean().getNombrePersona()!=null&&docenteBean.getPersonaBean().getNombrePersona()!=""&&
		        				(docenteBean.getPersonaBean().getApellidoPaterno()!=null&&docenteBean.getPersonaBean().getApellidoPaterno()!=""||
		        				docenteBean.getPersonaBean().getApellidoMaterno()!=null&&docenteBean.getPersonaBean().getApellidoMaterno()!="")&&
		        				docenteBean.getPersonaBean().getTelefono()!=""&&docenteBean.getPersonaBean().getTelefono()!=null&&ValidatorField.validarMascaraTelefono(docenteBean.getPersonaBean().getTelefono())&&
		        				docenteBean.getPersonaBean().getCorreo()!=""&&docenteBean.getPersonaBean().getCorreo()!=null&&ValidatorField.validarCorreo((docenteBean.getPersonaBean().getCorreo()))&&
		        				docenteBean.getPersonaBean().getDireccionPersona()!=""&&docenteBean.getPersonaBean().getDireccionPersona()!=null&&
		        				ValidatorField.validarFecha(docenteBean.getPersonaBean().getStrFechaNac())) {
		        			
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
		        					this.setAuditoria(prmPersona, request, true);
		        					sw = (this.getPersonaService().insertar(prmPersona));
		        					
		        				}
		        				
		        				docenteBean.setPersonaBean(prmPersona);
		        				docenteBean.setLstDocenteInstitucionBean(this.lstDocenteInstitucionBean); 
		        				
		        				this.setAuditoria(docenteBean, request, true);				
		        				sw =  (this.getDocenteService().insertar(docenteBean)); 
		        				//				setDocenteBean(new DocenteBean());
		        				//				setDocenteBean(docenteBean);
		        				//				
		        				
		        				
		        				// almacenar los datos de las Instituciones asignadas
		        				
		        				System.out.println("this.lstDocenteInstitucionBean " + this.lstDocenteInstitucionBean.size()); 
		        				//insertar las Instituciones
		        				if (docenteBean.getLstDocenteInstitucionBean() != null && docenteBean.getLstDocenteInstitucionBean().size() != 0) {
		        					for (DocenteInstitucionBean docenteInstitucionBean : docenteBean.getLstDocenteInstitucionBean()) {
		        						System.out.println("docenteInstitucionBean.size " + docenteBean.getLstDocenteInstitucionBean().size());
		        						docenteInstitucionBean.setDocenteBean(new DocenteBean());
		        						docenteInstitucionBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
		        						this.setAuditoria(docenteInstitucionBean, request, true);
		        						sw = (docenteInstitucionService.insertar(docenteInstitucionBean));
		        					}
		        				} 
		        				
		        			} else {
		        				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		        				
		        				if(docenteBean.getPersonaBean().getStrFechaNac()!=null){
		        					Date fechaConFormato = sdf.parse(docenteBean.getPersonaBean().getStrFechaNac().toString()); 
		        					
		        					prmPersona.setFechaNac(fechaConFormato);
		        					docenteBean.getPersonaBean().setFechaNac(prmPersona.getFechaNac());
		        					
		        				}
		        				docenteBean.getPersonaBean().setCodigoUbigeo(docenteBean.getUbigeoBean().getCodigoRegion()+docenteBean.getUbigeoBean().getCodigoProvincia()+docenteBean.getUbigeoBean().getCodigoDistrito());
		        				
		        				this.setAuditoria(docenteBean, request, false);
		        				sw = (this.getDocenteService().actualizar(docenteBean));
		        				
		        				List<DocenteInstitucionBean> lstDocenteInstitucionBeanEliminar = new ArrayList<DocenteInstitucionBean>(); 
		        				
		        				/************* inicio Instituto *****************************/
		        				if (listadoInstitutoVo != null	&&	listadoInstitutoVo.size() > 0 ) {
		        					for (int i = 0; i < listadoInstitutoVo.size();i=i+2) {
		        						boolean seEliminoInstituto = true;
		        						DocenteInstitucionBean  prmDocenteInstitucionBean;
		        						for (DocenteInstitucionBean docenteInstitucionBean : this.lstDocenteInstitucionBean) {
		        							
		        							System.out.println(listadoInstitutoVo.get(i).trim()+"  vs  "+String.valueOf(docenteInstitucionBean.getInstitucionBean().getCodigo()).trim());
		        							if (listadoInstitutoVo.get(i).trim().equals(String.valueOf(docenteInstitucionBean.getInstitucionBean().getCodigo()).trim())) {
		        								seEliminoInstituto = false;
		        							}
		        							
		        						}
		        						
		        						if (seEliminoInstituto) {
		        							//Se eliminar esa nacionalidad
		        							prmDocenteInstitucionBean = new DocenteInstitucionBean();
		        							
		        							prmDocenteInstitucionBean.setDocenteBean(new DocenteBean());
		        							prmDocenteInstitucionBean.setInstitucionBean(new InstitucionBean());
		        							
		        							prmDocenteInstitucionBean.getInstitucionBean().setCodigo(Long.parseLong(listadoInstitutoVo.get(i)));
		        							prmDocenteInstitucionBean.getInstitucionBean().setNombreCorto(listadoInstitutoVo.get(i+1));
		        							lstDocenteInstitucionBeanEliminar.add(prmDocenteInstitucionBean);
		        							
		        						}
		        					}
		        					
		        				}
		        				System.out.println("Datos nuevos");
		        				if (this.lstDocenteInstitucionBean != null && this.lstDocenteInstitucionBean.size() != 0) {
		        					for (DocenteInstitucionBean docenteInstitucionBean : this.lstDocenteInstitucionBean) {
		        						docenteInstitucionBean.setDocenteBean(new DocenteBean());
		        						docenteInstitucionBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
		        						this.setAuditoria(docenteInstitucionBean, request, true);
		        						sw = (docenteInstitucionService.insertar(docenteInstitucionBean));
		        						
		        					}//System.out.println(this.lstPersonaNacionalidadBean);
		        				}
		        				System.out.println("Fin");
		        				
		        				System.out.println("Datos Eliminar");
		        				for (DocenteInstitucionBean docenteInstitucionBean : lstDocenteInstitucionBeanEliminar) {
		        					docenteInstitucionBean.setDocenteBean(new DocenteBean());
		        					docenteInstitucionBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
		        					this.setAuditoria(docenteInstitucionBean, request, false);
		        					sw = (docenteInstitucionService.eliminar(docenteInstitucionBean));
		        					
		        				}
		        				
		        			}
		        		}
			
					} catch (Exception e) { 
						e.printStackTrace();
					}
		        }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
	
			if (sw) {
	//			DocenteBean prmDocente = new DocenteBean();
	//		
	//			prmDocente = docenteBean;
				
				//docenteBean = new DocenteBean() ;
				
	
				/* UsuarioBean */
				docenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
				docenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
				
				//return this.getLista(docenteBean);
				//ModelAndView mav = this.getLista(docenteBean);
				
				ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
				//mav.addObject("swMensaje",sw?"1":"0");
				
				String plaintextNDocum = aesUtil.encrypt(salt, iv, "numeroDocumentoDocente", docenteBean.getPersonaBean().getNumeroDocumento().toString());
		        docenteBean.getPersonaBean().setNumeroDocumento(plaintextNDocum);
				
				mav.addObject("docenteBean", docenteBean);
				//mav.addObject("docenteBean", prmDocente);
				mav.addObject("listadoInstitutoVo", listadoInstitutoVo);
				mav.addObject("lstEspecialidad", lstEspecialidad);
				this.cargarUbigeo(mav, docenteBean);
				this.cargarCombos(mav);	
				
				mav.addObject("swMensaje",sw?"1":"0");
				return mav;
				
			} else {
				ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
				mav.addObject("swMensaje",sw?"1":"0");
				return mav;
			}
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesi�n no es valida, por favor inicie sesi�n nuevamente");
			return mav;
		}
	}
	
	@RequestMapping(value = "/grabarListar", method = RequestMethod.POST)
	public @ResponseBody DocenteBean doGrabarListar(@ModelAttribute("docenteBean") DocenteBean docenteBean, HttpServletRequest request) {
		System.out.println("doGrabar");
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		PersonaBean prmPersona = new PersonaBean();
		
		/** CARACTERES ESPECIALES **/
//		docenteBean.getPersonaBean().setNombrePersona(CodeUtil.parseEncode(docenteBean.getPersonaBean().getNombrePersona()));
//		docenteBean.getPersonaBean().setApellidoPaterno(CodeUtil.parseEncode(docenteBean.getPersonaBean().getApellidoPaterno()));
//		docenteBean.getPersonaBean().setApellidoMaterno(CodeUtil.parseEncode(docenteBean.getPersonaBean().getApellidoMaterno()));
//		docenteBean.getPersonaBean().setDireccionPersona(CodeUtil.parseEncode(docenteBean.getPersonaBean().getDireccionPersona()));
//		docenteBean.getPersonaBean().setCorreo(CodeUtil.parseEncode(docenteBean.getPersonaBean().getCorreo()));
		
		boolean sw = false;
		try {
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("DocenteController/grabarListar");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
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
	        				this.setAuditoria(prmPersona, request, true);
	        				sw = (this.getPersonaService().insertar(prmPersona));
	        				
	        			}
	        			
	        			docenteBean.setPersonaBean(prmPersona);
	        			docenteBean.setLstDocenteInstitucionBean(this.lstDocenteInstitucionBean); 
	        			
	        			this.setAuditoria(docenteBean, request, true);				
	        			sw =  (this.getDocenteService().insertar(docenteBean)); 
	        			//				setDocenteBean(new DocenteBean());
	        			//				setDocenteBean(docenteBean);
	        			//				
	        			
	        			
	        			// almacenar los datos de las Instituciones asignadas
	        			
	        			System.out.println("this.lstDocenteInstitucionBean " + this.lstDocenteInstitucionBean.size()); 
	        			//insertar las Instituciones
	        			if (docenteBean.getLstDocenteInstitucionBean() != null && docenteBean.getLstDocenteInstitucionBean().size() != 0) {
	        				for (DocenteInstitucionBean docenteInstitucionBean : docenteBean.getLstDocenteInstitucionBean()) {
	        					System.out.println("docenteInstitucionBean.size " + docenteBean.getLstDocenteInstitucionBean().size());
	        					docenteInstitucionBean.setDocenteBean(new DocenteBean());
	        					docenteInstitucionBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
	        					this.setAuditoria(docenteInstitucionBean, request, true);
	        					sw = (docenteInstitucionService.insertar(docenteInstitucionBean));
	        				}
	        			} 
	        			
	        		} else {
	        			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
	        			
	        			if(docenteBean.getPersonaBean().getStrFechaNac()!=null){
	        				Date fechaConFormato = sdf.parse(docenteBean.getPersonaBean().getStrFechaNac().toString()); 
	        				
	        				prmPersona.setFechaNac(fechaConFormato);
	        				docenteBean.getPersonaBean().setFechaNac(prmPersona.getFechaNac());
	        				
	        			}
	        			docenteBean.getPersonaBean().setCodigoUbigeo(docenteBean.getUbigeoBean().getCodigoRegion()+docenteBean.getUbigeoBean().getCodigoProvincia()+docenteBean.getUbigeoBean().getCodigoDistrito());
	        			
	        			this.setAuditoria(docenteBean, request, false);
	        			sw = (this.getDocenteService().actualizar(docenteBean));
	        			
	        			List<DocenteInstitucionBean> lstDocenteInstitucionBeanEliminar = new ArrayList<DocenteInstitucionBean>(); 
	        			
	        			/************* inicio Instituto *****************************/
	        			if (listadoInstitutoVo != null	&&	listadoInstitutoVo.size() > 0 ) {
	        				for (int i = 0; i < listadoInstitutoVo.size();i=i+2) {
	        					boolean seEliminoInstituto = true;
	        					DocenteInstitucionBean  prmDocenteInstitucionBean;
	        					for (DocenteInstitucionBean docenteInstitucionBean : this.lstDocenteInstitucionBean) {
	        						
	        						System.out.println(listadoInstitutoVo.get(i).trim()+"  vs  "+String.valueOf(docenteInstitucionBean.getInstitucionBean().getCodigo()).trim());
	        						if (listadoInstitutoVo.get(i).trim().equals(String.valueOf(docenteInstitucionBean.getInstitucionBean().getCodigo()).trim())) {
	        							seEliminoInstituto = false;
	        						}
	        						
	        					}
	        					
	        					if (seEliminoInstituto) {
	        						//Se eliminar esa nacionalidad
	        						prmDocenteInstitucionBean = new DocenteInstitucionBean();
	        						
	        						prmDocenteInstitucionBean.setDocenteBean(new DocenteBean());
	        						prmDocenteInstitucionBean.setInstitucionBean(new InstitucionBean());
	        						
	        						prmDocenteInstitucionBean.getInstitucionBean().setCodigo(Long.parseLong(listadoInstitutoVo.get(i)));
	        						prmDocenteInstitucionBean.getInstitucionBean().setNombreCorto(listadoInstitutoVo.get(i+1));
	        						lstDocenteInstitucionBeanEliminar.add(prmDocenteInstitucionBean);
	        						
	        					}
	        				}
	        				
	        			}
	        			System.out.println("Datos nuevos");
	        			if (this.lstDocenteInstitucionBean != null && this.lstDocenteInstitucionBean.size() != 0) {
	        				for (DocenteInstitucionBean docenteInstitucionBean : this.lstDocenteInstitucionBean) {
	        					docenteInstitucionBean.setDocenteBean(new DocenteBean());
	        					docenteInstitucionBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
	        					this.setAuditoria(docenteInstitucionBean, request, true);
	        					sw = (docenteInstitucionService.insertar(docenteInstitucionBean));
	        					
	        				}//System.out.println(this.lstPersonaNacionalidadBean);
	        			}
	        			System.out.println("Fin");
	        			
	        			System.out.println("Datos Eliminar");
	        			for (DocenteInstitucionBean docenteInstitucionBean : lstDocenteInstitucionBeanEliminar) {
	        				docenteInstitucionBean.setDocenteBean(new DocenteBean());
	        				docenteInstitucionBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
	        				this.setAuditoria(docenteInstitucionBean, request, false);
	        				sw = (docenteInstitucionService.eliminar(docenteInstitucionBean));
	        				
	        			}
	        			
	        		}
	        		
	        	} catch (Exception e) { 
	        		e.printStackTrace();
	        	}
	        	
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if (sw) {
//			DocenteBean prmDocente = new DocenteBean();
//		
//			prmDocente = docenteBean;
			
			//docenteBean = new DocenteBean() ;
			

			/* UsuarioBean */
			docenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
			docenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
			
			//return this.getLista(docenteBean);
			//ModelAndView mav = this.getLista(docenteBean);
			
			ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
			//mav.addObject("swMensaje",sw?"1":"0");
			
			
			mav.addObject("docenteBean", docenteBean);
			//mav.addObject("docenteBean", prmDocente);
			mav.addObject("listadoInstitutoVo", listadoInstitutoVo);
			mav.addObject("lstEspecialidad", lstEspecialidad);
			this.cargarUbigeo(mav, docenteBean);
			this.cargarCombos(mav);	
			
			
			return docenteBean;
			
		} else {
			ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return docenteBean;
		}

	}
	
	@RequestMapping(value = "/grabarEspecialidad", method = RequestMethod.POST)
	public @ResponseBody Integer doGrabarEspecialidad(
			@RequestParam("idDocente") Long idDocente,
			@RequestParam("codlengua") Integer codlengua,
			@RequestParam("codnivel") Integer codnivel,
			@RequestParam("codnumdoc") String codnumdoc,
			@RequestParam(value="file",required=false) MultipartFile file,
			HttpServletRequest request) {
		
		especialidadBean = new EspecialidadBean();
		DocenteBean prDocenteBean = new DocenteBean();
	 
		prDocenteBean.setCodigo(idDocente);
		try{
			docenteBean = this.getDocenteService().getBuscarPorObjecto(prDocenteBean);
			
		}catch (Exception e) { 
			e.printStackTrace();
		}

		
		
		
		especialidadBean = docenteBean.getEspecialidadBean();

		especialidadBean.setLenguaBean(new LenguaBean());
		especialidadBean.getLenguaBean().setCodigo(codlengua);
		
		especialidadBean.setTm2Nivel(new MaestraBean());
		especialidadBean.getTm2Nivel().setCodigoRegistro(codnivel);
		
		especialidadBean.setNumeroDocumento(codnumdoc);
		
	    especialidadBean.setDocenteBean(docenteBean);
		
	    DocenteBean prmDocenteBean = new DocenteBean(); 
	    
		boolean sw = false;
		Integer respuesta = 0;
		
		String ruta="";
		String nombreDoc="";
		if (VO.isNotNull(file)) {
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					System.out.println("file.getName() "+ file.getName());
					System.out.println("file.getOriginalFilename() "+ file.getOriginalFilename());
					
					

					
					
					if(file.getOriginalFilename()!=null) {
						String[] formats = file.getOriginalFilename().toString().split("\\.");
						if(!formats[formats.length-1].equals("pdf") && !formats[formats.length-1].equals("doc") && !formats[formats.length-1].equals("docx") &&
								!formats[formats.length-1].equals("odt")) {
							respuesta = 3;
							return respuesta;
						}
						
					}
					
					// Creating the directory to store file
					String rootPath = "C:/ruta/";
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists())
						dir.mkdirs();
		
					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + file.getOriginalFilename());
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
		
		//			logger.info("Server File Location="
		//					+ serverFile.getAbsolutePath());
					ruta=String.valueOf(serverFile);
					nombreDoc=file.getOriginalFilename();
					System.out.println("serverFile " +serverFile);
					System.out.println("file.getName() "+ file.getName());
					System.out.println("You successfully uploaded file=" +file.getOriginalFilename()); 
					
					///--------------------------
					System.out.println("----- Ruta:  "+ruta);
			
					
					
					if(!validFileHead(ruta)) {
						respuesta = 3;
						System.out.println("-------> NO es un formato aceptado  ");
						return respuesta;
						
					}
	
					
					
				} catch (Exception e) {
					System.out.println("-------> ERROR:  "+e.getMessage());
					 //e.getMessage();
				}
				especialidadBean.setRutaDocumento(nombreDoc);
		//		especialidadBean.setRutaDocumento(ruta);
				
			}
		}		

		try {
			
	        	try {
	    			//if (especialidadBean.getCodigo()==0) {
	    				this.setAuditoria(especialidadBean, request, true);
	    				sw =  (this.getEspecialidadService().insertar(especialidadBean));
	    				if (sw) {
	    					super.cargarArchivo(this.getRootPath(), file.getOriginalFilename(), file);
	    					System.out.println("-------> this.getRootPath():  "+this.getRootPath());
	    					System.out.println("-------> file.getOriginalFilename():  "+file.getOriginalFilename());
	    					
//	    					tmpUrlImagen = documentoInscripcionBean.getNumedocu();
	    				} 
	    				
	    				prmDocenteBean = this.getDocenteService().getBuscarPorObjecto(docenteBean);
	    				
	    				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
	    				
	    				if(prmDocenteBean.getPersonaBean().getFechaNac()!=null){
	    					
	    					String fechaConFormato = sdf.format(prmDocenteBean.getPersonaBean().getFechaNac()); 
	    					System.out.println("fechaConFormato");
//	    					Date nuevaFecha=null;
//	    						nuevaFecha = sdf.parse(fechaConFormato);
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
	        
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return respuesta!=3?(sw?1:0):0;
	}
	
	private String getRootPath() {    	
		return ResourceUtil.getKey("ruta.natigu.archivos.academico.docente");
     }
	
	//--------------------------
	
	 
	 public  boolean isPng(File filename) throws Exception {
		 int MAGIC[] = new int[] {  0x89, 0x50, 0x4e, 0x47, 0x0d, 0x0a, 0x1a, 0x0a };
	        FileInputStream ins = new FileInputStream(filename);
	        try {
	            for(int i = 0; i < MAGIC.length; ++i) {
	                if(ins.read() != MAGIC[i]) {
	                    return false;
	                }
	            }
	            return true;
	        } finally {
	            ins.close();
	        }
	    };
	 
	 public  boolean isPdf(String ruta) throws Exception {
		 FileInputStream ins = new FileInputStream(ruta);
		 int MAGIC_pdf[] = new int[] { 0x25, 0x50, 0x44, 0x46 }; // pdf
		 boolean resp=true;
		 try {
	         for(int i = 0; i < MAGIC_pdf.length; ++i){
	        	 System.out.println(ins.read()+" | "+ MAGIC_pdf[i]);
	        	 
	             if(ins.read() != MAGIC_pdf[i]) {
	            	 resp= false;
	             }
	         	}
	         return resp;
		 } finally {
	            ins.close();
	        }
		 
         
	    };
	  
		 public  boolean isDoc(String ruta) throws Exception {
			 FileInputStream ins = new FileInputStream(ruta);
			 //int MAGIC[] = new int[] { 0xD0, 0xCF, 0x11, 0xE0 }; // doc
			 int MAGIC[] = new int[] { 20, 6, 8,0 }; // doc
			 	boolean resp=true;
			 	 try {
		         for(int i = 0; i < MAGIC.length; ++i){
		        	 System.out.println(ins.read()+" | "+ MAGIC[i]);
		        	 String n=String.valueOf(ins.read()) ;
		             if(!n.equals(String.valueOf(MAGIC[i])) ) {
		            	 resp= false;
		             }
		         	}
		         return resp;
			 	} finally {
		            ins.close();
		        }
			
	         
		    };
		    
		    public  boolean isDocx(String ruta) throws Exception {
		    	 FileInputStream ins_ = new FileInputStream(ruta);
				 int MAGIC[] = new int[]{ 80,75,3,4 }; // docx
				 boolean resp=true;
				 try {
			         for(int i = 0; i < MAGIC.length; ++i){
			        	 String read=String.valueOf(ins_.read());
			        	 int num = Integer.valueOf(read,10);
			        	 
			        	 System.out.println("read: "+read);
			        	 System.out.println("num: "+num);
			        	 System.out.println("MAGIC[i]: "+MAGIC[i]);
			        	 
			        	 System.out.println(num +" | "+MAGIC[i]+" -- " +(num +MAGIC[i]));
			             if(num !=  MAGIC[i]) {
			            	 resp = false;
			             }
			         	}
			         return resp;
				 } finally {
					 ins_.close();
			        }
			
		         
			    };
			    
			    public  boolean validFileHead(String ruta) throws Exception {
			    	 
			    	 FileInputStream ins_ = new FileInputStream(ruta);
			    	 try {
			    	 int readHead[]=new int[4];
					 //int MAGIC[] = new int[]{80,75,3,4}; // docx
					 String headFile="";
					 String headFilePdf="37806870";
					 String headFileDoc="20820717224";
					 String headFileDocx="807534";
					 
					 boolean resp=true;
					 
					
				         for(int i = 0; i <readHead.length; ++i){
				        	 String read=String.valueOf(ins_.read());
				        	 int num = Integer.valueOf(read,10);
				        	 readHead[i]=num;	
				        	 headFile+=String.valueOf(num);
				         	}
				         System.out.println("headFile: "+headFile);
				         
				         if(!headFile.equals(headFilePdf)&&!headFile.equals(headFileDoc)&&!headFile.equals(headFileDocx)) {
				        	 resp=false;
				         }
						 return resp;
				        
					 } finally {
						 ins_.close();
				       }
					 
					 
					
				    };
	
	
//	@RequestMapping(value = "/validaDocente", method = RequestMethod.POST)
//	public @ResponseBody DocenteBean validaDocente(@RequestParam("numerodni") String numerodni)
//			throws Exception {
//		DocenteBean prmDocenteBean = new DocenteBean();
//		
//		prmDocenteBean.getPersonaBean().setNumeroDocumento(numerodni);
//		prmDocenteBean= docenteBean;
//		if (docenteBean.getLenguaBean().getNombre().length() == 0) {
//			docenteBean.getLenguaBean().setNombre(null);
//		}
//		return this.getLista(docenteBean);
//	}
	
	/*
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
	
	}*/

	private ModelAndView getEspecialidad(DocenteBean docenteBean) {
 
		List<InstitucionBean> lstinstixTipoUsu = new ArrayList<InstitucionBean>();
		lstDocenteBean = new ArrayList<DocenteBean>(); 
		try {
			lstinstixTipoUsu = (List<InstitucionBean>) getInstitucionService().listarInstitucionxTipoUsuario(usuarioBean);
			System.out.println("lstinstixTipoUsu.get(0).getCodigo() " + lstinstixTipoUsu.get(0).getCodigo());
			docenteBean.getInstitucionBean().setCodigo(lstinstixTipoUsu.get(0).getCodigo());
			lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarPorFiltros(docenteBean);
			this.especialidadBean = new EspecialidadBean();
			this.especialidadBean.setDocenteBean(docenteBean);
			this.especialidadBean.getDocenteBean().setCodigo(docenteBean.getCodigo()); 
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
	

	private ModelAndView getLista(DocenteBean docenteBean) {

		//List<DocenteBean> lstDocenteBean =null;
		List<InstitucionBean> lstinstixTipoUsu = new ArrayList<InstitucionBean>();
		lstDocenteBean = new ArrayList<DocenteBean>();
//		List<EspecialidadBean> lstEspecialidadesDoc = new ArrayList<EspecialidadBean>();
//		String lenguas = "";
		try {
			/*p_coddocen0
			p_nombredoc
			p_especdocnull
			p_codinsti70
			p_nominsti
			p_tm1sitdoc2
			p_codperso924
			p_codperfil1*/
			System.out.println("usuaio"+usuarioBean);
			lstinstixTipoUsu = (List<InstitucionBean>) getInstitucionService().listarInstitucionxTipoUsuario(usuarioBean);
			System.out.println("lstinstixTipoUsu.get(0).getCodigo() " + lstinstixTipoUsu.get(0).getCodigo());
			docenteBean.getInstitucionBean().setCodigo(lstinstixTipoUsu.get(0).getCodigo());
			System.out.println("docenteBean"+docenteBean.getSituacion());
			lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarPorFiltros(docenteBean);
			System.out.println("lstDocenteBean"+docenteBean.getSituacion());
			this.especialidadBean = new EspecialidadBean();
			this.especialidadBean.setDocenteBean(docenteBean);
			this.especialidadBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
			//System.out.println("lstLenguaBean "+lstDocenteBean.size());
			
			 
			
//			if(lstDocenteBean != null){
//				for(int i=0;i<lstDocenteBean.size();i++){
//					lstEspecialidadesDoc = (List<EspecialidadBean>) this.fs.getEspecialidadService().listarPorCodigoDocente(lstDocenteBean.get(i));
//					lenguas = "";
//					if(lstEspecialidadesDoc != null){
//						for(int j=0;j<lstEspecialidadesDoc.size();j++){
//							
//							if(lenguas.length()>0){
//								lenguas = lenguas + ", ";
//							}
//							lenguas = lenguas + lstEspecialidadesDoc.get(j).getLenguaBean().getNombre();
//						}
//						lstDocenteBean.get(0).getLenguaBean().setNombre(lenguas);
//					}
//				}
//			 
//			}
			
			
		 
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
		
		LenguaBean lenguaBean = new LenguaBean();
		
		if (usuarioBean != null) {
			try {
				//lstInstitucion = (List<InstitucionBean>) this.getInstitucionService().getBuscarPorFiltros(institucionBean);
				this.lstInstitucion = (List<InstitucionBean>) getInstitucionService().listarInstitucionxTipoUsuario(usuarioBean);
				
				lstLengua = (List<LenguaBean>) this.getLenguaService().getBuscarPorFiltros(lenguaBean);
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionLengua",0);
				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento",1);
				lstNacionalidad = maestra2Service.listarPorCodigoTabla("nacionalidad",0);
						lstGrado=  maestra2Service.listarPorCodigoTabla("grado",0);
						lstCargo= maestra2Service.listarPorCodigoTabla("cargo",0);
						lstSexo= maestra2Service.listarPorCodigoTabla("sexo",0);
						lstCarrera =maestra2Service.listarPorCodigoTabla("carrera",0);
						lstNivel = maestra2Service.listarPorCodigoTabla("nivel",1);
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
	
	
	/***********************************************************************/
	
	
	
	
	/***********************************************************************/
	
	
	@RequestMapping(value = "/listadodocente", method = RequestMethod.GET)
	public ModelAndView doListadoDocente(@ModelAttribute("docenteBean") DocenteBean docenteBean,HttpServletRequest request)throws Exception {
		
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		DocenteBean prmDocenteBean = new DocenteBean();
		prmDocenteBean= docenteBean;
		
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
//		prmDocenteBean.setNombre("");
		if(lstDocente==null){
			lstDocente=new ArrayList<DocenteBean>();
		}
		
		//encrypted DNI
		String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    EncryptHability aesUtil = new EncryptHability(128, 1000);
	    
		
		for (DocenteBean item : lstDocente) {
			String plaintextNDoc = aesUtil.encrypt(salt, iv, "numeroDocumento", item.getPersonaBean().getNumeroDocumento().toString());
			String plaintextPaterno = aesUtil.encrypt(salt, iv, "apellidoPaterno", item.getPersonaBean().getApellidoPaterno().toString());
			String plaintextMaterno = aesUtil.encrypt(salt, iv, "apellidoMaterno", item.getPersonaBean().getApellidoPaterno().toString());
			String plaintextDireccion = aesUtil.encrypt(salt, iv, "direccionPersona", item.getPersonaBean().getDireccionPersona().toString());
			String plaintextNombrePer = aesUtil.encrypt(salt, iv, "nombrePersona", item.getPersonaBean().getNombrePersona().toString());
			String plaintextNomCompleto = aesUtil.encrypt(salt, iv, "nombreCompleto", item.getPersonaBean().getNombreCompleto().toString());
			
			item.getPersonaBean().setNumeroDocumento(plaintextNDoc);
			item.getPersonaBean().setApellidoPaterno(plaintextPaterno);
			item.getPersonaBean().setApellidoMaterno(plaintextMaterno);
			item.getPersonaBean().setDireccionPersona(plaintextDireccion);
			item.getPersonaBean().setNombrePersona(plaintextNombrePer);
			item.getPersonaBean().setNombreCompleto(plaintextNomCompleto);
		}
	
		return lstDocente;
	}
	
	
	private ModelAndView getListaDocente(DocenteBean docenteBean) {

		//lstDocenteBean = new ArrayList<DocenteBean>();

		if (usuarioBean != null) {
			try {
				this.lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarPorFiltros(docenteBean);
				this.especialidadBean = new EspecialidadBean();
				this.especialidadBean.setDocenteBean(docenteBean);
				this.especialidadBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
			} catch (Exception e) {
				System.out.println("getLista " + e.getMessage());
			}
		}
		
		ModelAndView mav = new ModelAndView("../layout/docente-registro-modal-view", "command",docenteBean);
		mav.addObject("lstDocenteBean", lstDocenteBean);
		this.cargarCombos(mav);
		this.cargarUbigeo(mav, new DocenteBean());
		return mav;
	}
	
	
	@RequestMapping(value = "/grabardocente", method = RequestMethod.POST)
	@ResponseBody
	public  String doGrabarDocente(@ModelAttribute("docenteBean") DocenteBean docenteBean,HttpServletRequest request) {
		
		System.out.println("docenteBean"+docenteBean);
		PersonaBean prmPersona = new PersonaBean();
		String n ="";
		boolean sw = false;
		
		try {
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("DocenteController/grabardocente");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	try {
	        		if(docenteBean.getPersonaBean().getNumeroDocumento()!=null&&docenteBean.getPersonaBean().getNumeroDocumento()!=""&&
	        				docenteBean.getPersonaBean().getNombrePersona()!=null&&docenteBean.getPersonaBean().getNombrePersona()!=""&&
	        				docenteBean.getPersonaBean().getApellidoPaterno()!=null&&docenteBean.getPersonaBean().getApellidoPaterno()!=""&&
	        				docenteBean.getPersonaBean().getApellidoMaterno()!=null&&docenteBean.getPersonaBean().getApellidoMaterno()!=""&&
	        				docenteBean.getPersonaBean().getFechaNac()!=null&&docenteBean.getPersonaBean().getTelefono()!=""&&docenteBean.getPersonaBean().getTelefono()!=null&&
	        				docenteBean.getPersonaBean().getCorreo()!=""&&docenteBean.getPersonaBean().getCorreo()!=null&&
	        				docenteBean.getPersonaBean().getDireccionPersona()!=""&&docenteBean.getPersonaBean().getDireccionPersona()!=null) {
	        			
	        			if (docenteBean.getCodigo()==0) {
	        				
	        				
	        				prmPersona=docenteBean.getPersonaBean();
	        				prmPersona = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona);
	        				if(prmPersona==null){
	        					prmPersona=docenteBean.getPersonaBean();
	        					
//	    					if(docenteBean.getUbigeoBean()==null || docenteBean.getUbigeoBean().equals("") ){
//	    						docenteBean.getUbigeoBean().setCodigoRegion("00");
//	    						docenteBean.getUbigeoBean().setCodigoProvincia("00");
//	    						docenteBean.getUbigeoBean().setCodigoDistrito("00");
//	    						
//	    					}
//	    					docenteBean.getUbigeoBean().setCodigoRegion("00");
//	    					docenteBean.getUbigeoBean().setCodigoProvincia("00");
//	    					docenteBean.getUbigeoBean().setCodigoDistrito("00");
//	    					
//	    					
//	    					prmPersona.setCodigoUbigeo(docenteBean.getUbigeoBean().getCodigoRegion()+docenteBean.getUbigeoBean().getCodigoProvincia()+docenteBean.getUbigeoBean().getCodigoDistrito());
	        					
	        					this.setAuditoria(docenteBean, request, true);
	        					sw = (this.getPersonaService().insertar(prmPersona));
	        					docenteBean.setAudCodigoUsuario(1);
	        					docenteBean.setAudHostIP("192.168.1.1");
	        				}
	        				docenteBean.setPersonaBean(prmPersona);
	        				
	        				this.setAuditoria(docenteBean, request, true);
	        				sw =  (this.getDocenteService().insertar(docenteBean)); 
	        			} else {
	        				this.setAuditoria(docenteBean, request, false);
	        				sw = (this.getDocenteService().actualizar(docenteBean));
	        			}
	        		}

	    		} catch (Exception e) { 
	    			e.printStackTrace();
	    		}
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if(sw){
			n=String.valueOf(docenteBean.getCodigo());
		}else{
			n="0";
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
	
	
	/*************************************************************************************/
	@RequestMapping(value = "/grabardocenteV2", method = RequestMethod.POST)
	@ResponseBody
	public  String doGrabarDocenteV2(
			//@ModelAttribute("docenteBean") DocenteBean docenteBean,
			@ModelAttribute("docenteBean") DocenteBean docenteBean,
//			@RequestParam("codigodocente") int codigoDocente,
//			
//			@RequestParam("codigolengua") int codigoLengua,
//			@RequestParam("codigonivel") int codigoNivel,
			HttpServletRequest request) {
		System.out.println("doGrabar");
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		String n ="";
		PersonaBean prmPersona = new PersonaBean();
		
		
//		especialidadBean=new EspecialidadBean();
//	    especialidadBean.setDocenteBean(new DocenteBean());
//	    especialidadBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
//	    especialidadBean.setLenguaBean(new LenguaBean());
//	    especialidadBean.getLenguaBean().setCodigo(docenteBean.getLenguaBean().getCodigo());
//	    especialidadBean.setTm2Nivel(new MaestraBean());
//		especialidadBean.getTm2Nivel().setCodigoRegistro(docenteBean.getEspecialidadBean().getTm2Nivel().getCodigoRegistro());
		
	    DocenteBean prmDocenteBean = new DocenteBean();  
		// boolean sw = false; 
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		/** CARACTERES ESPECIALES **/
//		docenteBean.getPersonaBean().setNombrePersona(CodeUtil.parseEncode(docenteBean.getPersonaBean().getNombrePersona()));
//		docenteBean.getPersonaBean().setApellidoPaterno(CodeUtil.parseEncode(docenteBean.getPersonaBean().getApellidoPaterno()));
//		docenteBean.getPersonaBean().setApellidoMaterno(CodeUtil.parseEncode(docenteBean.getPersonaBean().getApellidoMaterno()));
//		docenteBean.getPersonaBean().setDireccionPersona(CodeUtil.parseEncode(docenteBean.getPersonaBean().getDireccionPersona()));
//		docenteBean.getPersonaBean().setCorreo(CodeUtil.parseEncode(docenteBean.getPersonaBean().getCorreo()));
		
		boolean sw = false;
		try {
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("DocenteController/grabardocenteV2");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	try {
	        		if(docenteBean.getPersonaBean().getNumeroDocumento()!=null&&docenteBean.getPersonaBean().getNumeroDocumento()!=""&&
        				docenteBean.getPersonaBean().getNombrePersona()!=null&&docenteBean.getPersonaBean().getNombrePersona()!=""&&
        				(docenteBean.getPersonaBean().getApellidoPaterno()!=null&&docenteBean.getPersonaBean().getApellidoPaterno()!=""||
        				docenteBean.getPersonaBean().getApellidoMaterno()!=null&&docenteBean.getPersonaBean().getApellidoMaterno()!="")&&
        				docenteBean.getPersonaBean().getTelefono()!=""&&docenteBean.getPersonaBean().getTelefono()!=null&&
        				docenteBean.getPersonaBean().getCorreo()!=""&&docenteBean.getPersonaBean().getCorreo()!=null&&
        				docenteBean.getPersonaBean().getDireccionPersona()!=""&&docenteBean.getPersonaBean().getDireccionPersona()!=null) {
	        			
	        			if (docenteBean.getCodigo()==0) {
	        				
	        				prmPersona=docenteBean.getPersonaBean();
	        				prmPersona = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona);
	        				
	        				
	        				if(prmPersona==null){
	        					prmPersona=docenteBean.getPersonaBean();
	        					
	        					prmPersona.setCodigoUbigeo(docenteBean.getUbigeoBean().getCodigoRegion()+docenteBean.getUbigeoBean().getCodigoProvincia()+docenteBean.getUbigeoBean().getCodigoDistrito());
	        					
//	    					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
	        					
	        					if(docenteBean.getPersonaBean().getStrFechaNac()!=null){
	        						Date fechaConFormato = sdf.parse(docenteBean.getPersonaBean().getStrFechaNac().toString()); 
	        						prmPersona.setFechaNac(fechaConFormato);
	        						
	        					}
	        					this.setAuditoria(prmPersona, request, true);
	        					sw = (this.getPersonaService().insertar(prmPersona));
	        					
	        				}
	        				
	        				docenteBean.setPersonaBean(prmPersona);
	        				docenteBean.setLstDocenteInstitucionBean(this.lstDocenteInstitucionBean); 
	        				
	        				this.setAuditoria(docenteBean, request, true);				
	        				sw =  (this.getDocenteService().insertar(docenteBean)); 
//	    				setDocenteBean(new DocenteBean());
//	    				setDocenteBean(docenteBean);
//	    				
	        				
	        				
	        				// almacenar los datos de las Instituciones asignadas
	        				
//	    				System.out.println("this.lstDocenteInstitucionBean " + this.lstDocenteInstitucionBean.size()); 
	        				//insertar las Instituciones
	        				if (docenteBean.getLstDocenteInstitucionBean() != null && docenteBean.getLstDocenteInstitucionBean().size() != 0) {
	        					for (DocenteInstitucionBean docenteInstitucionBean : docenteBean.getLstDocenteInstitucionBean()) {
	        						System.out.println("docenteInstitucionBean.size " + docenteBean.getLstDocenteInstitucionBean().size());
	        						docenteInstitucionBean.setDocenteBean(new DocenteBean());
	        						docenteInstitucionBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
	        						this.setAuditoria(docenteInstitucionBean, request, true);
	        						sw = (docenteInstitucionService.insertar(docenteInstitucionBean));
	        					}
	        				} 
	        				/////AGREGAR LENGUAS
//	    				try { 
//	    					this.setAuditoria(especialidadBean, request, false);
//	    					sw =  (this.getEspecialidadService().insertar(especialidadBean));
//	    					docenteBean=especialidadBean.getDocenteBean();
//	    					prmDocenteBean = this.getDocenteService().getBuscarPorObjecto(docenteBean);
//	    					
//	    					
//	    					
//	    					if(prmDocenteBean.getPersonaBean().getFechaNac()!=null){
//	    						String fechaConFormato = sdf.format(prmDocenteBean.getPersonaBean().getFechaNac()); 
//	    						System.out.println("fechaConFormato"); 
//	    						prmDocenteBean.getPersonaBean().setStrFechaNac(fechaConFormato);
//	    						System.out.println("prmAlumnoBean.getPersonaBean().getStrFechaNac()"+prmDocenteBean.getPersonaBean().getStrFechaNac());
//	    					} 
//	    					lstEspecialidad = new ArrayList<EspecialidadBean>();
//	    					lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().listarPorCodigoDocente(docenteBean);
//	    				 
//	    			} catch (Exception e) { 
//	    				e.printStackTrace();
//	    			}
	        				///
	        				
	        				
	        			} else {
	        				
	        				
	        				if(docenteBean.getPersonaBean().getStrFechaNac()!=null){
	        					Date fechaConFormato = sdf.parse(docenteBean.getPersonaBean().getStrFechaNac().toString()); 
	        					
	        					prmPersona.setFechaNac(fechaConFormato);
	        					docenteBean.getPersonaBean().setFechaNac(prmPersona.getFechaNac());
	        					
	        				}
	        				docenteBean.getPersonaBean().setCodigoUbigeo(docenteBean.getUbigeoBean().getCodigoRegion()+docenteBean.getUbigeoBean().getCodigoProvincia()+docenteBean.getUbigeoBean().getCodigoDistrito());
	        				
	        				this.setAuditoria(docenteBean, request, false);
	        				sw = (this.getDocenteService().actualizar(docenteBean));
	        				
	        				List<DocenteInstitucionBean> lstDocenteInstitucionBeanEliminar = new ArrayList<DocenteInstitucionBean>(); 
	        				
	        				/************* inicio Instituto *****************************/
	        				if (listadoInstitutoVo != null	&&	listadoInstitutoVo.size() > 0 ) {
	        					for (int i = 0; i < listadoInstitutoVo.size();i=i+2) {
	        						boolean seEliminoInstituto = true;
	        						DocenteInstitucionBean  prmDocenteInstitucionBean;
	        						for (DocenteInstitucionBean docenteInstitucionBean : this.lstDocenteInstitucionBean) {
	        							
	        							System.out.println(listadoInstitutoVo.get(i).trim()+"  vs  "+String.valueOf(docenteInstitucionBean.getInstitucionBean().getCodigo()).trim());
	        							if (listadoInstitutoVo.get(i).trim().equals(String.valueOf(docenteInstitucionBean.getInstitucionBean().getCodigo()).trim())) {
	        								seEliminoInstituto = false;
	        							}
	        							
	        						}
	        						
	        						if (seEliminoInstituto) {
	        							//Se eliminar esa nacionalidad
	        							prmDocenteInstitucionBean = new DocenteInstitucionBean();
	        							
	        							prmDocenteInstitucionBean.setDocenteBean(new DocenteBean());
	        							prmDocenteInstitucionBean.setInstitucionBean(new InstitucionBean());
	        							
	        							prmDocenteInstitucionBean.getInstitucionBean().setCodigo(Long.parseLong(listadoInstitutoVo.get(i)));
	        							prmDocenteInstitucionBean.getInstitucionBean().setNombreCorto(listadoInstitutoVo.get(i+1));
	        							lstDocenteInstitucionBeanEliminar.add(prmDocenteInstitucionBean);
	        							
	        						}
	        					}
	        					
	        				}
	        				System.out.println("Datos nuevos");
	        				if (this.lstDocenteInstitucionBean != null && this.lstDocenteInstitucionBean.size() != 0) {
	        					for (DocenteInstitucionBean docenteInstitucionBean : this.lstDocenteInstitucionBean) {
	        						docenteInstitucionBean.setDocenteBean(new DocenteBean());
	        						docenteInstitucionBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
	        						this.setAuditoria(docenteInstitucionBean, request, true);
	        						sw = (docenteInstitucionService.insertar(docenteInstitucionBean));
	        						
	        					}//System.out.println(this.lstPersonaNacionalidadBean);
	        				}
	        				System.out.println("Fin");
	        				
	        				System.out.println("Datos Eliminar");
	        				for (DocenteInstitucionBean docenteInstitucionBean : lstDocenteInstitucionBeanEliminar) {
	        					docenteInstitucionBean.setDocenteBean(new DocenteBean());
	        					docenteInstitucionBean.getDocenteBean().setCodigo(docenteBean.getCodigo());
	        					this.setAuditoria(docenteInstitucionBean, request, false);
	        					sw = (docenteInstitucionService.eliminar(docenteInstitucionBean));
	        					
	        				}
	        				
	        				
	        				//AGREGAR LENGUAS
//	    				try { 
//	    					this.setAuditoria(especialidadBean, request, false);
//	    					sw =  (this.getEspecialidadService().insertar(especialidadBean));
//	    					docenteBean=especialidadBean.getDocenteBean();
//	    					prmDocenteBean = this.getDocenteService().getBuscarPorObjecto(docenteBean);
//	    					
//	    					 
//	    					
//	    					if(prmDocenteBean.getPersonaBean().getFechaNac()!=null){
//	    						String fechaConFormato = sdf.format(prmDocenteBean.getPersonaBean().getFechaNac()); 
//	    						System.out.println("fechaConFormato"); 
//	    						prmDocenteBean.getPersonaBean().setStrFechaNac(fechaConFormato);
//	    						System.out.println("prmAlumnoBean.getPersonaBean().getStrFechaNac()"+prmDocenteBean.getPersonaBean().getStrFechaNac());
//	    					} 
//	    					lstEspecialidad = new ArrayList<EspecialidadBean>();
//	    					lstEspecialidad = (List<EspecialidadBean>) this.getEspecialidadService().listarPorCodigoDocente(docenteBean);
//	    				 
//	    			} catch (Exception e) { 
//	    				e.printStackTrace();
//	    			}
	        				///
	        				
	        			}
	        		}

	    		} catch (Exception e) { 
	    			e.printStackTrace();
	    		}
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(sw){
			n=String.valueOf(docenteBean.getCodigo());
		}else{
			n="0";
		}
//		if (sw) {
//			docenteBean = new DocenteBean() ;
//			return this.getListaDocente(docenteBean);
//		} else {
//			ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
//			return mav;
//		}
		return n;
		
//		
//		
//		if (sw) {
////			DocenteBean prmDocente = new DocenteBean();
////		
////			prmDocente = docenteBean;
//			
//			//docenteBean = new DocenteBean() ;
//			
//
//			/* UsuarioBean */
//			docenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
//			docenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
//			
//			//return this.getLista(docenteBean);
//			//ModelAndView mav = this.getLista(docenteBean);
//			
//			ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
//			//mav.addObject("swMensaje",sw?"1":"0");
//			
//			
//			mav.addObject("docenteBean", docenteBean);
//			//mav.addObject("docenteBean", prmDocente);
//			mav.addObject("listadoInstitutoVo", listadoInstitutoVo);
//			mav.addObject("lstEspecialidad", lstEspecialidad);
//			this.cargarUbigeo(mav, docenteBean);
//			this.cargarCombos(mav);	
//			
//			if(sw){
//				n=String.valueOf(docenteBean.getCodigo());
//			}else{
//				n="0";
//			}
// 
//			return n;
//			
//		} else {
//			ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
//			mav.addObject("swMensaje",sw?"1":"0");
//			if(sw){
//				n=String.valueOf(docenteBean.getCodigo());
//			}else{
//				n="0";
//			}
// 
//			return n;
//		}

	}
	
	@RequestMapping(value = "/asignardocente", method = RequestMethod.POST)
	public @ResponseBody String doAsignarDocente(@RequestParam("codigoinsclen") int codigoinsclen, @RequestParam("coddocente") int coddocente ,HttpServletRequest request)throws Exception {
		String data="";
		boolean sw = false;
				
	    try {
	    	boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("DocenteController/asignardocente");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	    		InscripcionDocenteBean inscripcionDocenteBean = new InscripcionDocenteBean();
	    		inscripcionDocenteBean.getInscripcionLenguaBean().setCodigo(codigoinsclen);
	    		inscripcionDocenteBean.getDocenteBean().setCodigo(coddocente);
	    		inscripcionDocenteBean.getSituacionInscripcionDocente().setCodigoRegistro(1);
	    	    sw = inscripcionDocenteService.insertar(inscripcionDocenteBean);
	    		//prmDocenteBean.setNombre("");
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
	    
	    if(sw){
	    	sw=true;
	    	data="Exito";
	    }else{
	    	data="Error";
	    }
		return data;
	}
	
	
	
	@RequestMapping(value = "/listadocentesasignados", method = RequestMethod.POST)
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
		
		if(lstInscripcionDocenteBean!=null) {
			//encrypted DNI
			String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
			String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
			EncryptHability aesUtil = new EncryptHability(128, 1000);
			
			
			for (InscripcionDocenteBean item : lstInscripcionDocenteBean) {
				String plaintextNDoc = aesUtil.encrypt(salt, iv, "numeroDocumento", item.getDocenteBean().getPersonaBean().getNumeroDocumento());
				String plaintextNombre = aesUtil.encrypt(salt, iv, "nombrePersona", item.getDocenteBean().getPersonaBean().getNombrePersona());
				String plaintextApeMat = aesUtil.encrypt(salt, iv, "apeMatPersona", item.getDocenteBean().getPersonaBean().getApellidoMaterno());
				String plaintextApePat = aesUtil.encrypt(salt, iv, "apePatPersona", item.getDocenteBean().getPersonaBean().getApellidoPaterno());
				item.getDocenteBean().getPersonaBean().setNumeroDocumento(plaintextNDoc);
				item.getDocenteBean().getPersonaBean().setNombrePersona(plaintextNombre);
				item.getDocenteBean().getPersonaBean().setApellidoMaterno(plaintextApeMat);
				item.getDocenteBean().getPersonaBean().setApellidoPaterno(plaintextApePat);
			}
			
		}
		
		return lstInscripcionDocenteBean;
	}
	
	
	
	
	@RequestMapping(value = "/grabarEspecialidadDocente", method = RequestMethod.POST)
	public @ResponseBody String doGrabarEspecialidadDocente(@RequestParam("codigodocente") int codigoDocente,
															
															@RequestParam("codigolengua") int codigoLengua,
															@RequestParam("codigonivel") int codigoNivel,HttpServletRequest request) {
		
		especialidadBean=new EspecialidadBean();
	    especialidadBean.setDocenteBean(new DocenteBean());
	    especialidadBean.getDocenteBean().setCodigo(codigoDocente);
	    especialidadBean.setLenguaBean(new LenguaBean());
	    especialidadBean.getLenguaBean().setCodigo(codigoLengua);
	    especialidadBean.setTm2Nivel(new MaestraBean());
		especialidadBean.getTm2Nivel().setCodigoRegistro(codigoNivel);
		
	    DocenteBean prmDocenteBean = new DocenteBean(); 
	    
		boolean sw = false;
		
		try {
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("DocenteController/grabarEspecialidadDocente");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	try {
	    			//if (especialidadBean.getCodigo()==0) {
		        		//leer token		
		        		//HttpSession sessionToken = request.getSession();
		        		//String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
	    				//especialidadBean.setAudCodigoUsuario(Long.parseLong(u));
	    				especialidadBean.setAudHostIP(prmIntento.getIpConexion());
	    				especialidadBean.setIpCreacion(prmIntento.getIpConexion());
	    				this.setAuditoria(especialidadBean, request, false);
	    				sw =  (this.getEspecialidadService().insertar(especialidadBean));
	    				docenteBean=especialidadBean.getDocenteBean();
	    				prmDocenteBean = this.getDocenteService().getBuscarPorObjecto(docenteBean);
	    				
	    				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
	    				
	    				if(prmDocenteBean.getPersonaBean().getFechaNac()!=null){
	    					String fechaConFormato = sdf.format(prmDocenteBean.getPersonaBean().getFechaNac()); 
	    					System.out.println("fechaConFormato");
//	    					Date nuevaFecha=null;
//	    						nuevaFecha = sdf.parse(fechaConFormato);
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
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		/*
		ModelAndView mav = new ModelAndView("academico/registro-docente", "command",prmDocenteBean);
		mav.addObject("docenteBean", prmDocenteBean);
		mav.addObject("lstEspecialidad", lstEspecialidad);
		mav.addObject("swMensaje",sw?"1":"0");
		this.cargarUbigeo(mav, docenteBean);
		this.cargarCombos(mav);	
		return mav;
		*/
		return sw?"1":"0";
	}

	@RequestMapping(value = "/darbajadocenteasignado", method = RequestMethod.POST)
	public @ResponseBody String doDarBajaDocenteAsignado(@RequestParam("codinscdocente") int codinscdocente,HttpServletRequest request)throws Exception {
		
		boolean sw=false;
		String data="";
		

		try {
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("DocenteController/darbajadocenteasignado");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	InscripcionDocenteBean inscripcionDocenteBean = new InscripcionDocenteBean();
	    		inscripcionDocenteBean.setCodigo(codinscdocente);
	    		sw = inscripcionDocenteService.dar_baja_docente_x_InscripcionDocente(inscripcionDocenteBean);
	    		//prmDocenteBean.setNombre("");
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(sw){
			data ="Docente Se dio de Baja";
		}else{
			data ="Error al dar De Baja Docente";
		}
		
		return data;
	}
	
		
	
	
	@RequestMapping(value = "/validarDocente", method = RequestMethod.POST)
	public @ResponseBody DocenteBean validarDocente(@RequestParam("numerodocumento") String numeroDocumento) {
	
	
		DocenteBean prmDocenteBean = new DocenteBean();

		/* UsuarioBean */
		prmDocenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		prmDocenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		prmDocenteBean.getPersonaBean().setNumeroDocumento(numeroDocumento);
		

		DocenteBean docente = new DocenteBean();
		lstDocenteBean = new ArrayList<DocenteBean>();
		
		try {
			lstDocenteBean = (List<DocenteBean>) this.getDocenteService().getBuscarPorNumeroDocumento(prmDocenteBean);
			
			if(lstDocenteBean!=null){
				lstDocenteBean.get(0).setAudTipo("0");
				lstDocenteBean.get(0).setAudCodigoUsuario(0);
				
				docente = this.getDocenteService().getBuscarPorObjecto(lstDocenteBean.get(0));
				
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		ubigeoBean=new UbigeoBean();
		List<UbigeoBean>  lstubigeo;
		try {
			docenteBean = this.getDocenteService().getBuscarxdni(prmDocenteBean);
			
			if(docenteBean!=null){
				if(docenteBean.getPersonaBean().getCodigoUbigeo()!="" && docenteBean.getPersonaBean().getCodigoUbigeo()!=null){
					ubigeoBean.setCodigoUbigeo(docenteBean.getPersonaBean().getCodigoUbigeo());
					lstubigeo =(List<UbigeoBean>)ubigeoService.getBuscarPorFiltros(ubigeoBean);
					if(lstubigeo!=null){
						docenteBean.getPersonaBean().setUbigeoBean(lstubigeo.get(0));
					}
					
				}
				
			}
			
			
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		 if(docenteBean==null){
			 docenteBean=new DocenteBean();
		 }
		return docenteBean;
		*/
		return docente;
	}
	
	
	
	
	@RequestMapping(value = "/validarDocenteinscr", method = RequestMethod.POST)
	public @ResponseBody DocenteBean validarDocenteinscr(@RequestParam("numerodocumento") String numeroDocumento) {
	

		DocenteBean prmDocenteBean = new DocenteBean();
		/*
		prmDocenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		prmDocenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		prmDocenteBean.getPersonaBean().setNumeroDocumento(numeroDocumento);
		

		DocenteBean docente = new DocenteBean();
		lstDocenteBean = new ArrayList<DocenteBean>();
		
		try {
			lstDocenteBean = (List<DocenteBean>) this.getDocenteService().getBuscarPorNumeroDocumento(prmDocenteBean);
			
			if(lstDocenteBean!=null){
				lstDocenteBean.get(0).setAudTipo("0");
				lstDocenteBean.get(0).setAudCodigoUsuario(0);
				
				docente = this.getDocenteService().getBuscarPorObjecto(lstDocenteBean.get(0));
				
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
		ubigeoBean=new UbigeoBean();
		List<UbigeoBean>  lstubigeo;
		try {
			docenteBean = this.getDocenteService().getBuscarxdni(prmDocenteBean);
			
			if(docenteBean!=null){
				if(docenteBean.getPersonaBean().getCodigoUbigeo()!="" && docenteBean.getPersonaBean().getCodigoUbigeo()!=null){
					ubigeoBean.setCodigoUbigeo(docenteBean.getPersonaBean().getCodigoUbigeo());
					lstubigeo =(List<UbigeoBean>)ubigeoService.getBuscarPorFiltros(ubigeoBean);
					if(lstubigeo!=null){
						docenteBean.getPersonaBean().setUbigeoBean(lstubigeo.get(0));
					}
					
				}
				
			}
			
			
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		 if(docenteBean==null){
			 docenteBean=new DocenteBean();
		 }
		return docenteBean;
	
	}
	
	@RequestMapping(value = "/refrescarInstitucion", method = RequestMethod.GET)
	public @ResponseBody String refrescarInstitucion(@RequestParam("listadoInstitucion") List<String> listadoInstitucion) {

		// TODO Auto-generated catch block
		System.out.println("----------------------");
		System.out.println(listadoInstitucion);
		this.setLstDocenteInstitucionBean(new ArrayList<DocenteInstitucionBean>());
		
		DocenteInstitucionBean  docenteInstitucionBean;
		
		if (listadoInstitucion != null && listadoInstitucion.size() != 0) {
			for (int i = 0; i < listadoInstitucion.size();i=i+2) {
				
				docenteInstitucionBean = new DocenteInstitucionBean();
				docenteInstitucionBean.setDocenteBean(new DocenteBean());
				docenteInstitucionBean.setInstitucionBean(new InstitucionBean());
					
				System.out.println("codigo setInstitucionBean "+listadoInstitucion.get(i));
				System.out.println("nombre setInstitucionBean "+listadoInstitucion.get(i+1));
				docenteInstitucionBean.getInstitucionBean().setCodigo(Long.parseLong(listadoInstitucion.get(i)));
				docenteInstitucionBean.getInstitucionBean().setNombreCorto(listadoInstitucion.get(i+1));
				this.lstDocenteInstitucionBean.add(docenteInstitucionBean);
			}
		}
		return "1";

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

	public List<DocenteInstitucionBean> getLstDocenteInstitucionBean() {
		return lstDocenteInstitucionBean;
	}

	public void setLstDocenteInstitucionBean(List<DocenteInstitucionBean> lstDocenteInstitucionBean) {
		this.lstDocenteInstitucionBean = lstDocenteInstitucionBean;
	}

	public class InstitucionTemporal{
		private String identificador;
		private String nombreInstitucion;
		public String getIdentificador() {
			return identificador;
		}
		public void setIdentificador(String identificador) {
			this.identificador = identificador;
		}
		public String getNombreInstitucion() {
			return nombreInstitucion;
		}
		public void setNombreInstitucion(String nombreInstitucion) {
			this.nombreInstitucion = nombreInstitucion;
		}
	}

}
