package pe.gob.procalidad.natigu.web.gestion.controller.academico;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.net.*;
import java.io.*;

import javax.persistence.StoredProcedureQuery;
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
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoInstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaNacionalidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoInstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaLenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaNacionalidadService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UbigeoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.CodeUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ValidatorField;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.EncryptHability;
 
@Controller
@Scope(value="session")
@RequestMapping(value = "alumnoController")
public class AlumnoController extends BaseController {

	protected UsuarioBean usuarioBean;
	 
	private AlumnoBean 			alumnoBean;
	private AlumnoBean 			alumnoBeanTmp;
	private AlumnoBean 			alumnoBeanFiltro;
	private List<AlumnoBean> 	lstAlumnoBean;


	private List<MaestraBean>	lstSituacion,lstTipoDocumento,lstNacionalidad,lstSexo;
	private List<MaestraBean>	lstNivel,lstGrado,lstCarrera,lstTipoLengua,lstEstadoCivil;

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

	private List<PersonaNacionalidadBean> lstPersonaNacionalidadBean;
	private List<PersonaLenguaBean> lstPersonaLenguaBean;
	private List<AlumnoInstitucionBean> lstAlumnoInstitucionBean;

	/******************** Vo **********************/
	private List<String> listadoNacionalidadVo;
	private List<String> listadoLenguaVo;
	private List<String> listadoInstitucionVo;
	
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
	

	@Autowired
	private PersonaLenguaService personaLenguaService;
	@Autowired
	private PersonaNacionalidadService personaNacionalidadService;
	
	@Autowired
	private AlumnoInstitucionService alumnoInstitucionService;
	
	@Autowired
	private PeticionService peticionService;
	
	public AlumnoController (){
		this.alumnoBeanFiltro = new AlumnoBean();
		this.setLstPersonaNacionalidadBean(new ArrayList<PersonaNacionalidadBean>());
		this.setLstPersonaLenguaBean(new ArrayList<PersonaLenguaBean>());
		this.setLstAlumnoInstitucionBean(new ArrayList<AlumnoInstitucionBean>());
	}
	/*
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscarListado(@ModelAttribute("alumnoBean") AlumnoBean alumnoBean,HttpServletRequest request)throws Exception {
		return this.doListado(alumnoBean, request);
	}*/
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscarListado(HttpServletRequest request)throws Exception {
		return this.doBuscar(alumnoBeanFiltro, request);
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("alumnoBean") AlumnoBean alumnoBean,HttpServletRequest request)throws Exception {
		
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");

		alumnoBeanFiltro = alumnoBean;
		
		/* UsuarioBean */
		alumnoBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		alumnoBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		System.out.println("usuarioBean.getPersona().getCodigo():"+usuarioBean.getPersona().getCodigo());
		System.out.println("usuarioBean.getCodPerfilUsuSelec():"+String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		
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
		PersonaNacionalidadBean personaNacionalidadBean = new PersonaNacionalidadBean();
		personaNacionalidadBean.setPersonaBean(new PersonaBean());
		personaNacionalidadBean.getPersonaBean().setCodigo(0);
		alumnoBean.setLstPersonaNacionalidadBean(new ArrayList<PersonaNacionalidadBean>());
		alumnoBean.getLstPersonaNacionalidadBean().add(personaNacionalidadBean);
		
		ModelAndView mav = new ModelAndView("academico/listado-alumno", "command",alumnoBean);
		mav.addObject("lstAlumnoBean", new ArrayList<AlumnoBean>());
		this.cargarUbigeoIntitucion(mav, null);
		this.cargarUbigeo(mav,null);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("alumnoBean") AlumnoBean alumnoBean,HttpServletRequest request)
			throws Exception {

		alumnoBeanFiltro = alumnoBean;
		
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		/* UsuarioBean */
		
		System.out.println("Alumno ITD");
		System.out.println("codigo  "+usuarioBean.getPersona().getCodigo());
		System.out.println("perfil "+String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		alumnoBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		alumnoBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		
		return this.getLista(alumnoBean);
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		//nuevo codigo
		this.alumnoBeanTmp = null;
		
		ModelAndView mav = new ModelAndView("academico/registro-alumno", "command",new AlumnoBean());
		mav.addObject("alumnoBean", new AlumnoBean());
		this.cargarUbigeoIntitucion(mav, null);
		this.cargarUbigeo(mav,null);
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificarGet(HttpServletRequest request) {

		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");

		AlumnoBean prmAlumnoBean = new AlumnoBean();

		ModelAndView mav = new ModelAndView();
		
		if(this.alumnoBeanTmp != null){
			
			prmAlumnoBean.setCodigo(alumnoBeanTmp.getCodigo());
			
			try {
				prmAlumnoBean = this.getAlumnoService().getBuscarPorObjecto(prmAlumnoBean);
				
			} catch (ServiceException e) { 
				e.printStackTrace();
			}
			
			
			if (prmAlumnoBean != null) {
				//setear la lengua y la nacionalidad (old)
				prmAlumnoBean.getPersonaBean().getNacionalidad().setCodigoRegistro(0);
				prmAlumnoBean.getPersonaBean().getLenguaBean().setCodigo(0);
				prmAlumnoBean.getInstitucionBean().setCodigo(0);
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
				
				if(prmAlumnoBean.getPersonaBean().getFechaNac()!=null){
					String fechaConFormato = sdf.format(prmAlumnoBean.getPersonaBean().getFechaNac()); 
					
//					Date nuevaFecha=null;
//						nuevaFecha = sdf.parse(fechaConFormato);
					prmAlumnoBean.getPersonaBean().setStrFechaNac(fechaConFormato);
					System.out.println("prmAlumnoBean.getPersonaBean().getStrFechaNac()"+prmAlumnoBean.getPersonaBean().getStrFechaNac());
				}
				
//				if(prmAlumnoBean.getTm2Nivel()!=null){
//					try {
//						if (prmAlumnoBean.getTm2Nivel().getCodigoRegistro()==1) {
//							lstGrado = maestra2Service.listarPorCodigoTabla("gradoAlumno");
//						}else if(prmAlumnoBean.getTm2Nivel().getCodigoRegistro()==2){
//							lstGrado = maestra2Service.listarPorCodigoTabla("gradoAlumnoSecundaria");
//						}
//					} catch (ServiceException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
				try {
					lstGrado=  maestra2Service.listarPorCodigoTabla("grado",0);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				// Setar los listados de nacionalidad y lengua y Institucion
				this.setLstPersonaNacionalidadBean(new ArrayList<PersonaNacionalidadBean>());
				this.setLstPersonaLenguaBean(new ArrayList<PersonaLenguaBean>());
				this.setLstAlumnoInstitucionBean(new ArrayList<AlumnoInstitucionBean>());
				
				System.out.println(prmAlumnoBean.getPersonaBean().getCodigo());
				/*********************************************/
				PersonaNacionalidadBean personaNacionalidadBean = new PersonaNacionalidadBean();
				personaNacionalidadBean.setPersonaBean(new PersonaBean());
				personaNacionalidadBean.getPersonaBean().setCodigo(prmAlumnoBean.getPersonaBean().getCodigo());
				System.out.println("codigo de persona "+personaNacionalidadBean.getPersonaBean().getCodigo());
				
				AlumnoInstitucionBean	prmAlumnoInstitucionBean = new AlumnoInstitucionBean();
				prmAlumnoInstitucionBean.setAlumnoBean(new AlumnoBean());
				//System.out.println("codigo alumno" + codigo);
				prmAlumnoInstitucionBean.getAlumnoBean().setCodigo(alumnoBeanTmp.getCodigo());
				//Obtener el listado de las nacionalidades
				try {
					this.lstPersonaNacionalidadBean = (List<PersonaNacionalidadBean>) this.getPersonaNacionalidadService().getBuscarPorCodigoPersona(personaNacionalidadBean);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				/**********************************************/
			    PersonaLenguaBean personaLenguaBean = new PersonaLenguaBean();
			    personaLenguaBean.setPersonaBean(new PersonaBean());
			    personaLenguaBean.getPersonaBean().setCodigo(prmAlumnoBean.getPersonaBean().getCodigo());
				System.out.println("codigo de persona "+personaLenguaBean.getPersonaBean().getCodigo());
				//Obtener el listado de las lenguas
				try {
					this.lstPersonaLenguaBean = (List<PersonaLenguaBean>) this.getPersonaLenguaService().getBuscarPorCodigoPersona(personaLenguaBean);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				
				//Obtener el listado de las instituciones
//				if (prmAlumnoInstitucionBean.getAlumnoBean().getCodigo()>0) {
					try {
						this.lstAlumnoInstitucionBean = (List<AlumnoInstitucionBean>) this.getAlumnoInstitucionService().getBuscarPorCodigoAlumno(prmAlumnoInstitucionBean);
					} catch (ServiceException e) {
						e.printStackTrace();
					}
//				}
				
				if (VO.isNotEmptyList(lstAlumnoInstitucionBean)) {
					System.out.println("lstAlumnoInstitucionBean.get(0).getInstitucionBean().getNombreInstitucion() "+lstAlumnoInstitucionBean.get(0).getInstitucionBean().getNombreInstitucion());
				}
				
				//Almacenar las listas de nacionalidad y lenguas en alumno
				prmAlumnoBean.setLstPersonaNacionalidadBean(this.getLstPersonaNacionalidadBean());
				prmAlumnoBean.setLstPersonaLenguaBean(this.getLstPersonaLenguaBean());
				prmAlumnoBean.setLstAlumnoInstitucionBean(this.getLstAlumnoInstitucionBean());
//				System.out.println(prmAlumnoBean.getLstPersonaNacionalidadBean().size());
				System.out.println(":v");
				// VO
				listadoNacionalidadVo = new ArrayList<String>();
				listadoLenguaVo = new ArrayList<String>();
				listadoInstitucionVo = new ArrayList<String>();
				
				if (prmAlumnoBean.getLstPersonaNacionalidadBean() != null	&&	prmAlumnoBean.getLstPersonaNacionalidadBean().size() > 0 ) {
					for (PersonaNacionalidadBean prmPersonaNacionalidadBean : prmAlumnoBean.getLstPersonaNacionalidadBean()) {
						listadoNacionalidadVo.add(String.valueOf(prmPersonaNacionalidadBean.getNacionalidad().getCodigo()));
						listadoNacionalidadVo.add(prmPersonaNacionalidadBean.getNacionalidad().getNombreCorto());
					}			
				}
				
				if (prmAlumnoBean.getLstPersonaLenguaBean() != null	&&	prmAlumnoBean.getLstPersonaLenguaBean().size() > 0 ) {
					for (PersonaLenguaBean prmPersonaLenguaBean : prmAlumnoBean.getLstPersonaLenguaBean()) {
						listadoLenguaVo.add(String.valueOf(prmPersonaLenguaBean.getLenguaBean().getCodigo()));
						listadoLenguaVo.add(prmPersonaLenguaBean.getLenguaBean().getNombre());
						listadoLenguaVo.add(String.valueOf(prmPersonaLenguaBean.getTipoLengua().getCodigo()));
						listadoLenguaVo.add(prmPersonaLenguaBean.getTipoLengua().getNombreCorto());
					}			
				}
				
				if (prmAlumnoBean.getLstAlumnoInstitucionBean() != null	&&	prmAlumnoBean.getLstAlumnoInstitucionBean().size() > 0 ) {
					for (AlumnoInstitucionBean prmAlumnoInstitucionBeanlst : prmAlumnoBean.getLstAlumnoInstitucionBean()) {
						listadoInstitucionVo.add(String.valueOf(prmAlumnoInstitucionBeanlst.getInstitucionBean().getCodigo()));
						listadoInstitucionVo.add(prmAlumnoInstitucionBeanlst.getInstitucionBean().getNombreInstitucion());
					}			
				}
				
				//encrypt front - back
				String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
			    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
			    EncryptHability aesUtil = new EncryptHability(128, 1000);
		        String plaintextNDoc = aesUtil.encrypt(salt, iv, "numeroDocumentoPersona", alumnoBean.getPersonaBean().getNumeroDocumento().toString());
		        alumnoBean.getPersonaBean().setNumeroDocumento(plaintextNDoc);

				
				mav = new ModelAndView("academico/registro-alumno", "command", prmAlumnoBean);
				mav.addObject("alumnoBean", prmAlumnoBean);
				mav.addObject("listadoNacionalidadVo", listadoNacionalidadVo);
				mav.addObject("listadoLenguaVo", listadoLenguaVo);
				mav.addObject("listadoInstitucionVo", listadoInstitucionVo);
				this.cargarUbigeoIntitucion(mav, prmAlumnoBean);
				this.cargarUbigeo(mav,prmAlumnoBean);
				this.cargarCombos(mav);
			}else{//Encaso quieran ingresar por la url se redireciona a listado.
				/* UsuarioBean */
				prmAlumnoBean = new AlumnoBean();
				prmAlumnoBean.setCodigo(0);
				prmAlumnoBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
				prmAlumnoBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
				mav = this.getLista(prmAlumnoBean);
				mav.addObject("swMensaje","0");
			}
		}else{
			/* UsuarioBean */
			prmAlumnoBean = new AlumnoBean();
			prmAlumnoBean.setCodigo(0);
			prmAlumnoBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
			prmAlumnoBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
			mav = this.getLista(prmAlumnoBean);
			mav.addObject("swMensaje","0");
		}
		
		
		
		return mav;
		
	}
	
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo,HttpServletRequest request) {

		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		AlumnoBean prmAlumnoBean = new AlumnoBean();
		prmAlumnoBean.setCodigo(codigo);
	
		//INI:Nuevo codigo
		alumnoBeanTmp = new AlumnoBean();
		alumnoBeanTmp.setCodigo(codigo);
		
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
		        	try {
						prmAlumnoBean = this.getAlumnoService().getBuscarPorObjecto(prmAlumnoBean);
						
					} catch (ServiceException e) { 
						e.printStackTrace();
					}
					
					ModelAndView mav = new ModelAndView();
												        
					if (prmAlumnoBean != null) {
						//setear la lengua y la nacionalidad (old)
						prmAlumnoBean.getPersonaBean().getNacionalidad().setCodigoRegistro(0);
						prmAlumnoBean.getPersonaBean().getLenguaBean().setCodigo(0);
						prmAlumnoBean.getInstitucionBean().setCodigo(0);
						
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
						
						if(prmAlumnoBean.getPersonaBean().getFechaNac()!=null){
							String fechaConFormato = sdf.format(prmAlumnoBean.getPersonaBean().getFechaNac()); 
							
			//				Date nuevaFecha=null;
			//					nuevaFecha = sdf.parse(fechaConFormato);
							prmAlumnoBean.getPersonaBean().setStrFechaNac(fechaConFormato);
							System.out.println("prmAlumnoBean.getPersonaBean().getStrFechaNac()"+prmAlumnoBean.getPersonaBean().getStrFechaNac());
						}
						
			//			if(prmAlumnoBean.getTm2Nivel()!=null){
			//				try {
			//					if (prmAlumnoBean.getTm2Nivel().getCodigoRegistro()==1) {
			//						lstGrado = maestra2Service.listarPorCodigoTabla("gradoAlumno");
			//					}else if(prmAlumnoBean.getTm2Nivel().getCodigoRegistro()==2){
			//						lstGrado = maestra2Service.listarPorCodigoTabla("gradoAlumnoSecundaria");
			//					}
			//				} catch (ServiceException e) {
			//					// TODO Auto-generated catch block
			//					e.printStackTrace();
			//				}
			//			}
						try {
							lstGrado=  maestra2Service.listarPorCodigoTabla("grado",0);
						} catch (ServiceException e) {
							e.printStackTrace();
						}
						// Setar los listados de nacionalidad y lengua y Institucion
						this.setLstPersonaNacionalidadBean(new ArrayList<PersonaNacionalidadBean>());
						this.setLstPersonaLenguaBean(new ArrayList<PersonaLenguaBean>());
						this.setLstAlumnoInstitucionBean(new ArrayList<AlumnoInstitucionBean>());
						
						System.out.println(prmAlumnoBean.getPersonaBean().getCodigo());
						/*********************************************/
						PersonaNacionalidadBean personaNacionalidadBean = new PersonaNacionalidadBean();
						personaNacionalidadBean.setPersonaBean(new PersonaBean());
						personaNacionalidadBean.getPersonaBean().setCodigo(prmAlumnoBean.getPersonaBean().getCodigo());
						System.out.println("codigo de persona "+personaNacionalidadBean.getPersonaBean().getCodigo());
						
						AlumnoInstitucionBean	prmAlumnoInstitucionBean = new AlumnoInstitucionBean();
						prmAlumnoInstitucionBean.setAlumnoBean(new AlumnoBean());
						System.out.println("codigo alumno" + codigo);
						prmAlumnoInstitucionBean.getAlumnoBean().setCodigo(codigo);
						//Obtener el listado de las nacionalidades
						try {
							this.lstPersonaNacionalidadBean = (List<PersonaNacionalidadBean>) this.getPersonaNacionalidadService().getBuscarPorCodigoPersona(personaNacionalidadBean);
						} catch (ServiceException e) {
							e.printStackTrace();
						}
						/**********************************************/
					    PersonaLenguaBean personaLenguaBean = new PersonaLenguaBean();
					    personaLenguaBean.setPersonaBean(new PersonaBean());
					    personaLenguaBean.getPersonaBean().setCodigo(prmAlumnoBean.getPersonaBean().getCodigo());
						System.out.println("codigo de persona "+personaLenguaBean.getPersonaBean().getCodigo());
						//Obtener el listado de las lenguas
						try {
							this.lstPersonaLenguaBean = (List<PersonaLenguaBean>) this.getPersonaLenguaService().getBuscarPorCodigoPersona(personaLenguaBean);
						} catch (ServiceException e) {
							e.printStackTrace();
						}
						
						//Obtener el listado de las instituciones
			//			if (prmAlumnoInstitucionBean.getAlumnoBean().getCodigo()>0) {
							try {
								this.lstAlumnoInstitucionBean = (List<AlumnoInstitucionBean>) this.getAlumnoInstitucionService().getBuscarPorCodigoAlumno(prmAlumnoInstitucionBean);
							} catch (ServiceException e) {
								e.printStackTrace();
							}
			//			}
						
						if (VO.isNotEmptyList(lstAlumnoInstitucionBean)) {
							System.out.println("lstAlumnoInstitucionBean.get(0).getInstitucionBean().getNombreInstitucion() "+lstAlumnoInstitucionBean.get(0).getInstitucionBean().getNombreInstitucion());
						}
						
						//Almacenar las listas de nacionalidad y lenguas en alumno
						prmAlumnoBean.setLstPersonaNacionalidadBean(this.getLstPersonaNacionalidadBean());
						prmAlumnoBean.setLstPersonaLenguaBean(this.getLstPersonaLenguaBean());
						prmAlumnoBean.setLstAlumnoInstitucionBean(this.getLstAlumnoInstitucionBean());
			//			System.out.println(prmAlumnoBean.getLstPersonaNacionalidadBean().size());
						System.out.println(":v");
						// VO
						listadoNacionalidadVo = new ArrayList<String>();
						listadoLenguaVo = new ArrayList<String>();
						listadoInstitucionVo = new ArrayList<String>();
						
						if (prmAlumnoBean.getLstPersonaNacionalidadBean() != null	&&	prmAlumnoBean.getLstPersonaNacionalidadBean().size() > 0 ) {
							for (PersonaNacionalidadBean prmPersonaNacionalidadBean : prmAlumnoBean.getLstPersonaNacionalidadBean()) {
								listadoNacionalidadVo.add(String.valueOf(prmPersonaNacionalidadBean.getNacionalidad().getCodigo()));
								listadoNacionalidadVo.add(prmPersonaNacionalidadBean.getNacionalidad().getNombreCorto());
							}			
						}
						
						if (prmAlumnoBean.getLstPersonaLenguaBean() != null	&&	prmAlumnoBean.getLstPersonaLenguaBean().size() > 0 ) {
							for (PersonaLenguaBean prmPersonaLenguaBean : prmAlumnoBean.getLstPersonaLenguaBean()) {
								listadoLenguaVo.add(String.valueOf(prmPersonaLenguaBean.getLenguaBean().getCodigo()));
								listadoLenguaVo.add(prmPersonaLenguaBean.getLenguaBean().getNombre());
								listadoLenguaVo.add(String.valueOf(prmPersonaLenguaBean.getTipoLengua().getCodigo()));
								listadoLenguaVo.add(prmPersonaLenguaBean.getTipoLengua().getNombreCorto());
							}			
						}
						
						if (prmAlumnoBean.getLstAlumnoInstitucionBean() != null	&&	prmAlumnoBean.getLstAlumnoInstitucionBean().size() > 0 ) {
							for (AlumnoInstitucionBean prmAlumnoInstitucionBeanlst : prmAlumnoBean.getLstAlumnoInstitucionBean()) {
								listadoInstitucionVo.add(String.valueOf(prmAlumnoInstitucionBeanlst.getInstitucionBean().getCodigo()));
								listadoInstitucionVo.add(prmAlumnoInstitucionBeanlst.getInstitucionBean().getNombreInstitucion());
							}			
						}
			
						//encrypt front - back
						String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
					    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
					    EncryptHability aesUtil = new EncryptHability(128, 1000);
				        String plaintextNDoc = aesUtil.encrypt(salt, iv, "numeroDocumentoPersona", prmAlumnoBean.getPersonaBean().getNumeroDocumento().toString());
				        prmAlumnoBean.getPersonaBean().setNumeroDocumento(plaintextNDoc);
				        
						mav = new ModelAndView("academico/registro-alumno", "command", prmAlumnoBean);
						mav.addObject("alumnoBean", prmAlumnoBean);
						mav.addObject("listadoNacionalidadVo", listadoNacionalidadVo);
						mav.addObject("listadoLenguaVo", listadoLenguaVo);
						mav.addObject("listadoInstitucionVo", listadoInstitucionVo);
						this.cargarUbigeoIntitucion(mav, prmAlumnoBean);
						this.cargarUbigeo(mav,prmAlumnoBean);
						this.cargarCombos(mav);
						return mav;
						
					} else {//Encaso quieran ingresar por la url se redireciona a listado.
						/* UsuarioBean */
						prmAlumnoBean = new AlumnoBean();
						prmAlumnoBean.setCodigo(0);
						prmAlumnoBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
						prmAlumnoBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
						mav = this.getLista(prmAlumnoBean);
						mav.addObject("swMensaje","0");
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
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		boolean sw=false;
		alumnoBean= new AlumnoBean();
		alumnoBean.setCodigo(codigo);
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("AlumnoController/eliminar");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	try { 
						this.setAuditoria(alumnoBean, request, false);
						sw =  (this.getAlumnoService().eliminar(alumnoBean));  
						System.out.println("sw es : "+sw);
					} catch (Exception e) { 
						e.printStackTrace();
					} 		
					this.setValoresPredeterminados(alumnoBean);
					
					/* UsuarioBean */
					alumnoBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
					alumnoBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
					/*
					ModelAndView mav = this.getLista(alumnoBean);
					mav.addObject("swMensaje",sw?"1":"0");
					*/
					
					List<AlumnoBean> lstAlumnoBean = new ArrayList<AlumnoBean>();
					try {
						//modificar despues
						lstAlumnoBean = (List<AlumnoBean>) this.getAlumnoService().getBuscarPorFiltros(alumnoBean);
						
					} catch (Exception e) {
						System.out.println("getLista " + e.getMessage());
					}
							
					ModelAndView mav = new ModelAndView("academico/ajax/listado-tabla-alumno", "command",alumnoBean);
					System.out.println("lstAlumnoBean "+lstAlumnoBean);
					mav.addObject("lstAlumnoBean", lstAlumnoBean);
					this.cargarUbigeoIntitucion(mav, null);
					this.cargarUbigeo(mav,null);
					this.cargarCombos(mav);
					return mav;	
		        }
			} catch (Exception e) { 
				// TODO: handle finally clause
				e.printStackTrace();
			}
			AlumnoBean alumnoABean= new AlumnoBean();
			ModelAndView mav = new ModelAndView("academico/ajax/listado-tabla-alumno", "command",alumnoABean);
			mav.addObject("lstAlumnoBean", lstAlumnoBean);
			this.cargarUbigeoIntitucion(mav, null);
			this.cargarUbigeo(mav,null);
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

	@RequestMapping(value = "/grabar", method = RequestMethod.GET)
	public ModelAndView doGrabarListado(@ModelAttribute("alumnoBean") AlumnoBean alumnoBean,HttpServletRequest request)throws Exception {
		return this.doListado(alumnoBean, request);
	}
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("alumnoBean") AlumnoBean alumnoBean,HttpServletRequest request) {
		
		//Obtener la sesion
		HttpSession session = request.getSession();
		//Obtener el usuario Bean
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		PersonaBean prmPersona = new PersonaBean();
		
		/** CARACTERES ESPECIALES **/
//		alumnoBean.getPersonaBean().setNombrePersona(CodeUtil.parseEncode(alumnoBean.getPersonaBean().getNombrePersona()));
//		alumnoBean.getPersonaBean().setApellidoPaterno(CodeUtil.parseEncode(alumnoBean.getPersonaBean().getApellidoPaterno()));
//		alumnoBean.getPersonaBean().setApellidoMaterno(CodeUtil.parseEncode(alumnoBean.getPersonaBean().getApellidoMaterno()));
//		alumnoBean.getPersonaBean().setDireccionPersona(CodeUtil.parseEncode(alumnoBean.getPersonaBean().getDireccionPersona()));
//		alumnoBean.getPersonaBean().setCorreo(CodeUtil.parseEncode(alumnoBean.getPersonaBean().getCorreo()));
		
		boolean sw = false;
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		
		//encrypt front - back
		String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    EncryptHability aesUtil = new EncryptHability(128, 1000);
        String plaintextNDoc = aesUtil.decrypt(salt, iv, "numeroDocumentoPersonal", alumnoBean.getPersonaBean().getNumeroDocumento().toString());
        String plaintextNombrePersona = aesUtil.decrypt(salt, iv, "nombrePersonaPersonal", alumnoBean.getPersonaBean().getNombrePersona().toString());
        String plaintextApellidoPaterno = aesUtil.decrypt(salt, iv, "apellidoPaternoPersonal", alumnoBean.getPersonaBean().getApellidoPaterno().toString());
        String plaintextApellidoMaterno = aesUtil.decrypt(salt, iv, "apellidoMaternoPersonal", alumnoBean.getPersonaBean().getApellidoMaterno().toString());
        String plaintextStrFechaNac = aesUtil.decrypt(salt, iv, "fechaNacimientoPersonal", alumnoBean.getPersonaBean().getStrFechaNac().toString());
        String plaintextCodigoRegion = aesUtil.decrypt(salt, iv, "provinciaSelectPersonal", alumnoBean.getUbigeoBean().getCodigoRegion().toString());
        String plaintextCodigoProvincia = aesUtil.decrypt(salt, iv, "comboProvinciaPersonal", alumnoBean.getUbigeoBean().getCodigoProvincia().toString());
        String plaintextCodigoDistrito = aesUtil.decrypt(salt, iv, "comboDistritoPersonal", alumnoBean.getUbigeoBean().getCodigoDistrito().toString());
        String plaintextTelefono = aesUtil.decrypt(salt, iv, "telefonoUsuarioPersonal", alumnoBean.getPersonaBean().getTelefono().toString());
        String plaintextCorreo = aesUtil.decrypt(salt, iv, "correoElectronicoPersonal", alumnoBean.getPersonaBean().getCorreo().toString());
        String plaintextDireccion = aesUtil.decrypt(salt, iv, "direccionPersonal", alumnoBean.getPersonaBean().getDireccionPersona().toString());
        
        alumnoBean.getPersonaBean().setNumeroDocumento(plaintextNDoc);
        alumnoBean.getPersonaBean().setNombrePersona(plaintextNombrePersona);
        alumnoBean.getPersonaBean().setApellidoPaterno(plaintextApellidoPaterno);
        alumnoBean.getPersonaBean().setApellidoMaterno(plaintextApellidoMaterno);
        alumnoBean.getPersonaBean().setStrFechaNac(plaintextStrFechaNac);
        alumnoBean.getUbigeoBean().setCodigoRegion(plaintextCodigoRegion);
        alumnoBean.getUbigeoBean().setCodigoProvincia(plaintextCodigoProvincia);
        alumnoBean.getUbigeoBean().setCodigoDistrito(plaintextCodigoDistrito);
        alumnoBean.getPersonaBean().setTelefono(plaintextTelefono);
        alumnoBean.getPersonaBean().setCorreo(plaintextCorreo);
        alumnoBean.getPersonaBean().setDireccionPersona(plaintextDireccion);
		
		if(u != null) {
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("AlumnoController/grabar");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
					try {
						if(alumnoBean.getPersonaBean().getNumeroDocumento()!=null&&alumnoBean.getPersonaBean().getNumeroDocumento()!=""&&
						alumnoBean.getPersonaBean().getNombrePersona()!=null&&alumnoBean.getPersonaBean().getNombrePersona()!=""&&
						(alumnoBean.getPersonaBean().getApellidoMaterno()!=null&&alumnoBean.getPersonaBean().getApellidoMaterno()!=""||
						alumnoBean.getPersonaBean().getApellidoPaterno()!=null&&alumnoBean.getPersonaBean().getApellidoPaterno()!="")&&
						alumnoBean.getPersonaBean().getTelefono()!=""&&alumnoBean.getPersonaBean().getTelefono()!=null&&ValidatorField.validarMascaraTelefono(alumnoBean.getPersonaBean().getTelefono())&&
						alumnoBean.getPersonaBean().getCorreo()!=null&&alumnoBean.getPersonaBean().getCorreo()!=""&&ValidatorField.validarCorreo((alumnoBean.getPersonaBean().getCorreo()))&&
						alumnoBean.getPersonaBean().getDireccionPersona()!=null&&alumnoBean.getPersonaBean().getDireccionPersona()!=""&&
						ValidatorField.validarFecha(alumnoBean.getPersonaBean().getStrFechaNac())) {
							//Si codigo alumno es igual a cero entonces guarda nuevos datos
							if (alumnoBean.getCodigo() == 0) {/*** nuevo ***/
								prmPersona = alumnoBean.getPersonaBean();
								//Buscar si la persona ya existe por Tipo de documento y numero de documento
								prmPersona = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona);
								//Si persona es igual a null es que ya existe
								if(prmPersona==null){
									
									prmPersona= alumnoBean.getPersonaBean();
									
									prmPersona.setCodigoUbigeo(alumnoBean.getUbigeoBean().getCodigoRegion()+alumnoBean.getUbigeoBean().getCodigoProvincia()+alumnoBean.getUbigeoBean().getCodigoDistrito());
									alumnoBean.getInstitucionBean().getUbigeoBean().setCodigoUbigeo(alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoRegion()+alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoProvincia()+alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoDistrito());
									
									SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
									
									if(alumnoBean.getPersonaBean().getStrFechaNac()!=null){
										Date fechaConFormato = sdf.parse(alumnoBean.getPersonaBean().getStrFechaNac().toString()); 
										//						
										prmPersona.setFechaNac(fechaConFormato);
										
									} 
									/************************************************/
									sw = (this.getPersonaService().insertar(prmPersona));
									alumnoBean.setPersonaBean(prmPersona);
								}
								
								// almacenar los datos de las Nacionalidades y Leguas
								alumnoBean.setLstPersonaNacionalidadBean(this.lstPersonaNacionalidadBean);
								alumnoBean.setLstPersonaLenguaBean(this.lstPersonaLenguaBean);
								alumnoBean.setLstAlumnoInstitucionBean(this.lstAlumnoInstitucionBean);
								// Insertar datos al alumno
								/**************************************************/
								this.setAuditoria(alumnoBean, request, true);
								sw =  (this.getAlumnoService().insertar(alumnoBean));
								/****************************************************/
								//insertar las nacionalidad
								if (alumnoBean.getLstPersonaNacionalidadBean() != null && alumnoBean.getLstPersonaNacionalidadBean().size() != 0) {
									for (PersonaNacionalidadBean personaNacionalidadBean : alumnoBean.getLstPersonaNacionalidadBean()) {
										personaNacionalidadBean.setPersonaBean(new PersonaBean());
										personaNacionalidadBean.getPersonaBean().setCodigo(alumnoBean.getPersonaBean().getCodigo());
										this.setAuditoria(personaNacionalidadBean, request, true);
										sw = (this.getPersonaNacionalidadService().insertar(personaNacionalidadBean));
									}
								}
								/****************************************************/
								//insertar las lenguas
								if (alumnoBean.getLstPersonaLenguaBean() != null && alumnoBean.getLstPersonaLenguaBean().size() != 0) {
									//for (int i = 0; i < alumnoBean.getLstPersonaLenguaBean().size(); i++) {
									for (PersonaLenguaBean personaLenguaBean : alumnoBean.getLstPersonaLenguaBean()) {
										personaLenguaBean.setPersonaBean(new PersonaBean());
										personaLenguaBean.getPersonaBean().setCodigo(alumnoBean.getPersonaBean().getCodigo());
										this.setAuditoria(personaLenguaBean, request, true);
										sw = (this.getPersonaLenguaService().insertar(personaLenguaBean));
									}
								}
								//insetar instituciones
								if (VO.isNotEmptyList(alumnoBean.getLstAlumnoInstitucionBean())) {
									System.out.println("alumnoBean.getLstAlumnoInstitucionBean().size() " + alumnoBean.getLstAlumnoInstitucionBean().size());
								}
								
								if (alumnoBean.getLstAlumnoInstitucionBean() != null && alumnoBean.getLstAlumnoInstitucionBean().size() != 0) {
									System.out.println("inserto Institucion");
									for (AlumnoInstitucionBean alumnoInstitucionBean : alumnoBean.getLstAlumnoInstitucionBean()) {
										System.out.println("alumnoBean.getLstAlumnoInstitucionBean().size()"+ alumnoBean.getLstAlumnoInstitucionBean().size());
										System.out.println("alumnoInstitucionBean.getInstitucionBean().getCodigo() "+ alumnoBean.getLstAlumnoInstitucionBean().get(0).getInstitucionBean().getCodigo());
										
										alumnoInstitucionBean.setAlumnoBean(new AlumnoBean());
										alumnoInstitucionBean.getInstitucionBean().setCodigo(alumnoInstitucionBean.getInstitucionBean().getCodigo());
										System.out.println("alumnoInstitucionBean.getInstitucionBean().getCodigo() " + alumnoInstitucionBean.getInstitucionBean().getCodigo());
										System.out.println(" alumnoBean.getCodigo() "+alumnoBean.getCodigo());
										alumnoInstitucionBean.getAlumnoBean().setCodigo(alumnoBean.getCodigo());
										this.setAuditoria(alumnoInstitucionBean, request, true);
										sw = (this.getAlumnoInstitucionService().insertar(alumnoInstitucionBean));
									}
								}
								
							} else {/** modificar **/
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
								
								if(alumnoBean.getPersonaBean().getStrFechaNac()!=null){
									Date fechaConFormato = sdf.parse(alumnoBean.getPersonaBean().getStrFechaNac().toString()); 
									prmPersona.setFechaNac(fechaConFormato);
									alumnoBean.getPersonaBean().setFechaNac(prmPersona.getFechaNac());
								}
								
								alumnoBean.getPersonaBean().setCodigoUbigeo(alumnoBean.getUbigeoBean().getCodigoRegion()+alumnoBean.getUbigeoBean().getCodigoProvincia()+alumnoBean.getUbigeoBean().getCodigoDistrito());
								alumnoBean.getInstitucionBean().getUbigeoBean().setCodigoUbigeo(alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoRegion()+alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoProvincia()+alumnoBean.getInstitucionBean().getUbigeoBean().getCodigoDistrito());
								
								this.setAuditoria(alumnoBean, request, false);
								sw =  (this.getAlumnoService().actualizar(alumnoBean));
								
								System.out.println("alumnoBean.getPersonaBean().getCodigo():"+alumnoBean.getPersonaBean().getCodigo());
								
								/**********************************************************************/
								//Nacionalidad y Lengua y Institcion
								List<PersonaNacionalidadBean> lstPersonaNacionalidadBeanEliminar = new ArrayList<PersonaNacionalidadBean>();
								List<PersonaLenguaBean> lstPersonaLenguaBeanEliminar = new ArrayList<PersonaLenguaBean>();
								List<AlumnoInstitucionBean> lstAlumnoInstitucionBeanEliminar = new ArrayList<AlumnoInstitucionBean>();
								/************* inicio nacionalidad *****************************/
								if (listadoNacionalidadVo != null	&&	listadoNacionalidadVo.size() > 0 ) {
									for (int i = 0; i < listadoNacionalidadVo.size();i=i+2) {
										boolean seEliminoNacionalidad = true;
										PersonaNacionalidadBean  prmPersonaNacionalidadBeanEliminar;
										for (PersonaNacionalidadBean nacionalidadBean : this.lstPersonaNacionalidadBean) {
											
											System.out.println(listadoNacionalidadVo.get(i).trim()+"  vs  "+String.valueOf(nacionalidadBean.getNacionalidad().getCodigo()).trim());
											if (listadoNacionalidadVo.get(i).trim().equals(String.valueOf(nacionalidadBean.getNacionalidad().getCodigo()).trim())) {
												seEliminoNacionalidad = false;
											}
										}
										
										if (seEliminoNacionalidad) {
											//Se eliminar esa nacionalidad
											prmPersonaNacionalidadBeanEliminar = new PersonaNacionalidadBean();
											
											prmPersonaNacionalidadBeanEliminar.setPersonaBean(new PersonaBean());
											prmPersonaNacionalidadBeanEliminar.setNacionalidad(new MaestraBean());
											
											prmPersonaNacionalidadBeanEliminar.getNacionalidad().setCodigo(Long.parseLong(listadoNacionalidadVo.get(i)));
											prmPersonaNacionalidadBeanEliminar.getNacionalidad().setNombreCorto(listadoNacionalidadVo.get(i+1));
											lstPersonaNacionalidadBeanEliminar.add(prmPersonaNacionalidadBeanEliminar);
											
										}
									}
									
								}
								System.out.println("Datos nuevos");
								if (this.lstPersonaNacionalidadBean != null && this.lstPersonaNacionalidadBean.size() != 0) {
									for (PersonaNacionalidadBean nacionalidadBean : this.lstPersonaNacionalidadBean) {
										nacionalidadBean.setPersonaBean(new PersonaBean());
										nacionalidadBean.getPersonaBean().setCodigo(alumnoBean.getPersonaBean().getCodigo());
										this.setAuditoria(nacionalidadBean, request, true);
										sw = (this.getPersonaNacionalidadService().insertar(nacionalidadBean));
										
									}//System.out.println(this.lstPersonaNacionalidadBean);
								}
								System.out.println("Fin");
								
								System.out.println("Datos Eliminar");
								for (PersonaNacionalidadBean nacionalidadBean : lstPersonaNacionalidadBeanEliminar) {
									nacionalidadBean.setPersonaBean(new PersonaBean());
									nacionalidadBean.getPersonaBean().setCodigo(alumnoBean.getPersonaBean().getCodigo());
									this.setAuditoria(nacionalidadBean, request, false);
									sw = (this.getPersonaNacionalidadService().eliminar(nacionalidadBean));
									
								}//System.out.println(this.lstPersonaNacionalidadBean);
								/************* fin nacionalidad *****************************/
								/**********************************************************************/
								/************* inicio lengua *****************************/
								if (listadoLenguaVo != null	&&	listadoLenguaVo.size() > 0 ) {
									for (int i = 0; i < listadoLenguaVo.size();i=i+4) {
										boolean seEliminolistadoLenguaVo = true;
										PersonaLenguaBean  prmPersonaLenguaBeanEliminar;
										for (PersonaLenguaBean personaLenguaBean : this.lstPersonaLenguaBean) {
											
											System.out.println(listadoLenguaVo.get(i).trim ()+"  vs  "+String.valueOf(personaLenguaBean.getLenguaBean().getCodigo()).trim());
											//							if (listadoLenguaVo.get(i).trim().equals(String.valueOf(personaLenguaBean.getLenguaBean().getCodigo()).trim())) {
											//								seEliminolistadoLenguaVo = false;
											//							}
											if(listadoLenguaVo.get(i).trim().equals(String.valueOf(personaLenguaBean.getLenguaBean().getCodigo()).trim()) && (listadoLenguaVo.get(i+2).trim().equals(String.valueOf(personaLenguaBean.getTipoLengua().getCodigo()).trim()))){
												seEliminolistadoLenguaVo = false;
											}
										}
										
										if (seEliminolistadoLenguaVo) {
											//Se eliminar esa nacionalidad
											prmPersonaLenguaBeanEliminar = new PersonaLenguaBean();
											
											prmPersonaLenguaBeanEliminar.setPersonaBean(new PersonaBean());
											prmPersonaLenguaBeanEliminar.setLenguaBean(new LenguaBean());
											prmPersonaLenguaBeanEliminar.setTipoLengua(new MaestraBean());
											
											prmPersonaLenguaBeanEliminar.getLenguaBean().setCodigo(Long.parseLong(listadoLenguaVo.get(i)));
											prmPersonaLenguaBeanEliminar.getLenguaBean().setNombre(listadoLenguaVo.get(i+1));
											
											prmPersonaLenguaBeanEliminar.getTipoLengua().setCodigo(Long.parseLong(listadoLenguaVo.get(i+2)));
											prmPersonaLenguaBeanEliminar.getTipoLengua().setNombreCorto(listadoLenguaVo.get(i+3));
											
											lstPersonaLenguaBeanEliminar.add(prmPersonaLenguaBeanEliminar);
											
										}
									}
									
								}
								
								if (this.lstPersonaLenguaBean != null && this.lstPersonaNacionalidadBean.size() != 0) {
									for (PersonaLenguaBean personaLenguaBean : this.lstPersonaLenguaBean) {
										personaLenguaBean.setPersonaBean(new PersonaBean());
										personaLenguaBean.getPersonaBean().setCodigo(alumnoBean.getPersonaBean().getCodigo());
										this.setAuditoria(personaLenguaBean, request, true);
										sw = (this.getPersonaLenguaService().insertar(personaLenguaBean));
										
										
									}//System.out.println(this.lstPersonaNacionalidadBean);
								}
								System.out.println("Fin");
								
								System.out.println("Datos Eliminar");
								for (PersonaLenguaBean lenguaBean : lstPersonaLenguaBeanEliminar) {
									lenguaBean.setPersonaBean(new PersonaBean());
									lenguaBean.getPersonaBean().setCodigo(alumnoBean.getPersonaBean().getCodigo());
									this.setAuditoria(lenguaBean, request, false);
									sw = (this.getPersonaLenguaService().eliminar(lenguaBean));
								}
								/************* fin lengua *****************************/
								/***********************************************************/
								/************* inicio Institucion *****************************/
								
								if (listadoInstitucionVo != null	&&	listadoInstitucionVo.size() > 0 ) {
									for (int i = 0; i < listadoInstitucionVo.size();i=i+2) {
										boolean seEliminoInstitucion = true;
										AlumnoInstitucionBean  prmPersonaNacionalidadBeanEliminar;
										for (AlumnoInstitucionBean nacionalidadBean : this.lstAlumnoInstitucionBean) {
											
											System.out.println(listadoInstitucionVo.get(i).trim()+"  vs  "+String.valueOf(nacionalidadBean.getInstitucionBean().getCodigo()).trim());
											if (listadoInstitucionVo.get(i).trim().equals(String.valueOf(nacionalidadBean.getInstitucionBean().getCodigo()).trim())) {
												seEliminoInstitucion = false;
											}
											
										}
										
										if (seEliminoInstitucion) {
											//Se eliminar esa nacionalidad
											prmPersonaNacionalidadBeanEliminar = new AlumnoInstitucionBean();
											
											prmPersonaNacionalidadBeanEliminar.setInstitucionBean(new InstitucionBean());
											prmPersonaNacionalidadBeanEliminar.setAlumnoBean(new AlumnoBean());
											prmPersonaNacionalidadBeanEliminar.getAlumnoBean().setCodigo(alumnoBean.getCodigo());
											
											prmPersonaNacionalidadBeanEliminar.getInstitucionBean().setCodigo(Long.parseLong(listadoInstitucionVo.get(i)));
											prmPersonaNacionalidadBeanEliminar.getInstitucionBean().setNombreInstitucion(listadoInstitucionVo.get(i+1));
											System.out.println("prmPersonaNacionalidadBeanEliminar.getAlumnoBean().getCodigo() "+ prmPersonaNacionalidadBeanEliminar.getAlumnoBean().getCodigo());
											System.out.println(" prmPersonaNacionalidadBeanEliminar.getInstitucionBean().getCodigo() "+prmPersonaNacionalidadBeanEliminar.getInstitucionBean().getCodigo());
											lstAlumnoInstitucionBeanEliminar.add(prmPersonaNacionalidadBeanEliminar);
											
										}
									}
									
								}
								
								System.out.println("Datos nuevos");
								if (this.lstAlumnoInstitucionBean != null && this.lstAlumnoInstitucionBean.size() != 0) {
									for (AlumnoInstitucionBean nacionalidadBean : this.lstAlumnoInstitucionBean) {
										//nacionalidadBean.setInstitucionBean(new InstitucionBean());
										nacionalidadBean.setAlumnoBean(new AlumnoBean());
										System.out.println(" alumnoBean.getCodigo() "+ alumnoBean.getCodigo());
										System.out.println(" alumnoBean.nacionalidadBean().getCodigo() "+ nacionalidadBean.getInstitucionBean().getCodigo());
										nacionalidadBean.getInstitucionBean().setCodigo(nacionalidadBean.getInstitucionBean().getCodigo());
										nacionalidadBean.getAlumnoBean().setCodigo(alumnoBean.getCodigo());
										System.out.println(" nacionalidadBean.getInstitucionBean().getCodigo() "+nacionalidadBean.getInstitucionBean().getCodigo());
										this.setAuditoria(nacionalidadBean, request, true);
										
										sw = (this.getAlumnoInstitucionService().insertar(nacionalidadBean));
										
										
										
									}//System.out.println(this.lstPersonaNacionalidadBean);
								}
								System.out.println("Fin");
								
								System.out.println("Datos Eliminar");
								for (AlumnoInstitucionBean nacionalidadBean : lstAlumnoInstitucionBeanEliminar) {
									System.out.println("lstAlumnoInstitucionBeanEliminar.size() " + lstAlumnoInstitucionBeanEliminar.size());
									//nacionalidadBean.setInstitucionBean(new InstitucionBean());
									nacionalidadBean.setAlumnoBean(new AlumnoBean());
									System.out.println(" alumnoBean.getCodigo() "+ alumnoBean.getCodigo());
									//System.out.println(" alumnoBean.getInstitucionBean().getCodigo() "+ alumnoBean.getInstitucionBean().getCodigo());
									nacionalidadBean.getAlumnoBean().setCodigo(alumnoBean.getCodigo());
									nacionalidadBean.getInstitucionBean().setCodigo(nacionalidadBean.getInstitucionBean().getCodigo());
									System.out.println(" nacionalidadBean.getInstitucionBean().getCodigo() "+nacionalidadBean.getInstitucionBean().getCodigo());
									//nacionalidadBean.getInstitucionBean().setCodigo(alumnoBean.getInstitucionBean().getCodigo());
									this.setAuditoria(nacionalidadBean, request, false);
									sw = (this.getAlumnoInstitucionService().eliminar(nacionalidadBean));
									
								}
								/**/
								//				if (listadoInstitucionVo != null	&&	listadoInstitucionVo.size() > 0 ) {
								//					for (int i = 0; i < listadoInstitucionVo.size();i=i+2) {
								//						boolean seEliminoInstitucion = true;
								//						AlumnoInstitucionBean  prmAlumnoInstitucionBeanEliminar;
								//						for (AlumnoInstitucionBean alumnoInstitucionBean : this.lstAlumnoInstitucionBean) {
								//
								//							System.out.println(listadoInstitucionVo.get(i).trim()+"  vs  "+String.valueOf(alumnoInstitucionBean.getInstitucionBean().getCodigo()).trim());
								//							if (listadoNacionalidadVo.get(i).trim().equals(String.valueOf(alumnoInstitucionBean.getInstitucionBean().getCodigo()).trim())) {
								//								seEliminoInstitucion = false;
								//							}
								//							
								//						}
								//						
								//						if (seEliminoInstitucion) {
								//							//Se eliminar esa nacionalidad
								//							prmAlumnoInstitucionBeanEliminar = new AlumnoInstitucionBean();
								//							
								//							prmAlumnoInstitucionBeanEliminar.getInstitucionBean().setCodigo(Long.parseLong(listadoInstitucionVo.get(i)));
								//							prmAlumnoInstitucionBeanEliminar.getInstitucionBean().setNombreCorto(listadoInstitucionVo.get(i+1));
								//							lstAlumnoInstitucionBeanEliminar.add(prmAlumnoInstitucionBeanEliminar);
								//							
								//						}
								//					}
								//						
								//				}
								//				System.out.println("getAlumnoInstitucionService Datos nuevos");
								//				if (this.lstAlumnoInstitucionBean != null && this.lstAlumnoInstitucionBean.size() != 0) {
								//					for (AlumnoInstitucionBean nacionalidadBean : this.lstAlumnoInstitucionBean) {
								//					System.out.println(" alumnoBean.getCodigo() "+ alumnoBean.getCodigo());
								//					System.out.println(" alumnoBean.getInstitucionBean().getCodigo() "+ alumnoBean.getInstitucionBean().getCodigo());
								//						nacionalidadBean.getAlumnoBean().setCodigo(alumnoBean.getCodigo());
								//						nacionalidadBean.getInstitucionBean().setCodigo(alumnoBean.getInstitucionBean().getCodigo());
								//						this.setAuditoria(nacionalidadBean, request, true);
								//						sw = (this.getAlumnoInstitucionService().insertar(nacionalidadBean));
								//						
								//					}//System.out.println(this.lstPersonaNacionalidadBean);
								//				}
								//				System.out.println(" getAlumnoInstitucionService Fin");
								//				
								//				System.out.println("getAlumnoInstitucionService Datos Eliminar");
								//				for (AlumnoInstitucionBean nacionalidadBean : lstAlumnoInstitucionBeanEliminar) {
								//					System.out.println(" alumnoBean.getCodigo() "+ alumnoBean.getCodigo());
								//					System.out.println(" alumnoBean.getInstitucionBean().getCodigo() "+ alumnoBean.getInstitucionBean().getCodigo());
								//					nacionalidadBean.getAlumnoBean().setCodigo(alumnoBean.getCodigo());
								//					nacionalidadBean.getInstitucionBean().setCodigo(alumnoBean.getInstitucionBean().getCodigo());
								//					this.setAuditoria(nacionalidadBean, request, false);
								//					sw = (this.getAlumnoInstitucionService().eliminar(nacionalidadBean));
								//				
								//				}//System.out.println(this.lstPersonaNacionalidadBean);
								/************* fin nacionalidad *****************************/
							}
							
						}
			
					} catch (Exception e) { 
						sw = false;
						e.printStackTrace();
					}
				
		        } else {
		        	sw = false;
		        }
			} catch (Exception e) {
				// TODO: handle exception
				sw = false;
				e.printStackTrace();
			}
			
			if (sw) {
				alumnoBean = new AlumnoBean() ;
				/* UsuarioBean */
				alumnoBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
				alumnoBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
				
				//return this.getLista(alumnoBean);
				//ModelAndView mav = this.getLista(alumnoBean);
				ModelAndView mav = new ModelAndView("academico/listado-alumno", "command",alumnoBean);
				mav.addObject("swMensaje",sw?"1":"0");
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("academico/listado-alumno", "command",alumnoBean);
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

	private ModelAndView getLista(AlumnoBean alumnoBean) {
		//List<AlumnoBean> lstAlumnoBean = null
		List<AlumnoBean> lstAlumnoBean = new ArrayList<AlumnoBean>();
		try {
			//modificar despues
			lstAlumnoBean = (List<AlumnoBean>) this.getAlumnoService().getBuscarPorFiltros(alumnoBean);
			
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}

		if(lstAlumnoBean!=null) {
			//encrypted DNI
			String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
			String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
			EncryptHability aesUtil = new EncryptHability(128, 1000);
			
			
			for (AlumnoBean item : lstAlumnoBean) {
				String plaintextNDoc = aesUtil.encrypt(salt, iv, "numeroDocumento", item.getPersonaBean().getNumeroDocumento().toString());
				item.getPersonaBean().setNumeroDocumento(plaintextNDoc);
			}
			
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

		LenguaBean lenguaBean = new LenguaBean();
		ubigeoBean = new UbigeoBean();
		
		if (this.usuarioBean!=null){
			try {
				//lstInstitucionBean = institucionService.getListarCombo(inst);
				this.lstInstitucionBean = (List<InstitucionBean>) getInstitucionService().listarInstitucionxTipoUsuario(this.usuarioBean);
				
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionAlumno",0);
				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento",1);
				lstNacionalidad = maestra2Service.listarPorCodigoTabla("nacionalidad",0);
				lstSexo = maestra2Service.listarPorCodigoTabla("sexo",0);
				lstLenguaBean = (List<LenguaBean>) this.lenguaService.getBuscarPorFiltros(lenguaBean);
				//lstNivel = maestra2Service.listarPorCodigoTabla("nivelAlumno");
				lstTipoLengua = maestra1Service.listarPorCodigoTabla("tipoLengua",0);
				lstGrado = maestra2Service.listarPorCodigoTabla("grado",0);
				lstCarrera = maestra2Service.listarPorCodigoTabla("carreraAlumno",0);
				lstEstadoCivil = maestra2Service.listarPorCodigoTabla("estadoCivil",0);
				
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
		mav.addObject("lstTipoLengua",lstTipoLengua); 
		mav.addObject("lstEstadoCivil",lstEstadoCivil); 
		
	}
	
	@RequestMapping(value = "/buscarGrado", method = RequestMethod.GET)
	public @ResponseBody  List<MaestraBean> doBuscarGrado(@RequestParam("codigonivel") String codigo)throws Exception {
		List<MaestraBean> prmGrado = new ArrayList<MaestraBean>();
			if (codigo.equals("1")) {
				prmGrado = maestra2Service.listarPorCodigoTabla("gradoAlumno",0);
			}else if(codigo.equals("2")){
				prmGrado = maestra2Service.listarPorCodigoTabla("gradoAlumnoSecundaria",0);
			}
		return prmGrado;
	}
	

	@RequestMapping(value = "/validaralumno", method = RequestMethod.POST)
	public @ResponseBody AlumnoBean validarAlumno(@RequestParam("numerodocumento") String numeroDocumento) {
		
		AlumnoBean alumnoBean2 = new AlumnoBean();
		/* UsuarioBean */
		alumnoBean2.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		alumnoBean2.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		alumnoBean2.getPersonaBean().setNumeroDocumento(numeroDocumento);
		
		AlumnoBean alum = new AlumnoBean();
		lstAlumnoBean = new ArrayList<AlumnoBean>();
		try {
			lstAlumnoBean = (List<AlumnoBean>) this.getAlumnoService().getBuscarPorFiltros(alumnoBean2);
			
			if(lstAlumnoBean!=null){
				lstAlumnoBean.get(0).setAudTipo("0");
				lstAlumnoBean.get(0).setAudCodigoUsuario(0);
				
				alum = this.getAlumnoService().getBuscarPorObjecto(lstAlumnoBean.get(0));
				
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*********************************************/
		PersonaNacionalidadBean personaNacionalidadBean = new PersonaNacionalidadBean();
		personaNacionalidadBean.setPersonaBean(new PersonaBean());
		personaNacionalidadBean.getPersonaBean().setCodigo(alum.getPersonaBean().getCodigo());
		System.out.println("codigo de persona "+personaNacionalidadBean.getPersonaBean().getCodigo());
		//Obtener el listado de las nacionalidades
		try {
			this.lstPersonaNacionalidadBean = (List<PersonaNacionalidadBean>) this.getPersonaNacionalidadService().getBuscarPorCodigoPersona(personaNacionalidadBean);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		/**********************************************/
	    PersonaLenguaBean personaLenguaBean = new PersonaLenguaBean();
	    personaLenguaBean.setPersonaBean(new PersonaBean());
	    personaLenguaBean.getPersonaBean().setCodigo(alum.getPersonaBean().getCodigo());
		System.out.println("codigo de persona "+personaLenguaBean.getPersonaBean().getCodigo());
		//Obtener el listado de las lenguas
		try {
			this.lstPersonaLenguaBean = (List<PersonaLenguaBean>) this.getPersonaLenguaService().getBuscarPorCodigoPersona(personaLenguaBean);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		AlumnoInstitucionBean alumnoInstitucion = new AlumnoInstitucionBean();
		alumnoInstitucion.setAlumnoBean(new AlumnoBean());
		alumnoInstitucion.getAlumnoBean().setCodigo(alum.getCodigo());
		System.out.println("alumnoInstitucion.getAlumnoBean().getCodigo() " + alumnoInstitucion.getAlumnoBean().getCodigo());
		//Obtener el listado de las instituciones
//		if (alumnoInstitucion.getAlumnoBean().getCodigo()>0) {
			try {
				this.lstAlumnoInstitucionBean = this.getAlumnoInstitucionService().getBuscarPorCodigoAlumno(alumnoInstitucion);
			} catch (ServiceException e) {
				System.out.println("egetMessage "+ e.getMessage());
				e.printStackTrace();
			}
//		}
		
		
		
		//Almacenar las listas de nacionalidad, institucion y lenguas en alumno
		alum.setLstAlumnoInstitucionBean(this.getLstAlumnoInstitucionBean());
		alum.setLstPersonaNacionalidadBean(this.getLstPersonaNacionalidadBean());
		alum.setLstPersonaLenguaBean(this.getLstPersonaLenguaBean());
//		System.out.println(prmAlumnoBean.getLstPersonaNacionalidadBean().size());
		
		
		return alum;

	}
	
	@RequestMapping(value = "/refrescarLengua", method = RequestMethod.GET)
	public @ResponseBody String refrescarLengua(@RequestParam("listadoLengua") List<String> listadoLengua) {
		
		System.out.println("----------------------");
		System.out.println(listadoLengua);
		
		this.setLstPersonaLenguaBean(new ArrayList<PersonaLenguaBean>());
	    
		PersonaLenguaBean  personaLenguaBean;
		// TODO Auto-generated catch block
		
//		this.alumnoBean.setLstPersonaLenguaBean(new ArrayList<PersonaLenguaBean>());
		if (listadoLengua != null && listadoLengua.size() != 0) {
			System.out.println("cantidad : "+listadoLengua.size());
			for (int i = 0; i < listadoLengua.size();i=i+4) {
				
				personaLenguaBean = new PersonaLenguaBean();
				personaLenguaBean.setPersonaBean(new PersonaBean());
				personaLenguaBean.setLenguaBean(new LenguaBean());
				personaLenguaBean.setTipoLengua(new MaestraBean());
				
				personaLenguaBean.getLenguaBean().setCodigo(Long.parseLong(listadoLengua.get(i)));
				personaLenguaBean.getLenguaBean().setNombre(listadoLengua.get(i+1));
				
				personaLenguaBean.getTipoLengua().setCodigo(Long.parseLong(listadoLengua.get(i+2)));
				personaLenguaBean.getTipoLengua().setNombreCorto(listadoLengua.get(i+3));
				this.lstPersonaLenguaBean.add(personaLenguaBean);
				/*
				System.out.println("codigo Legunda "+listadoLengua.get(i));
				System.out.println("nombre lengua "+listadoLengua.get(i+1));
				System.out.println("codgio tipo lengua "+listadoLengua.get(i+2));
				System.out.println("tipo lengua "+listadoLengua.get(i+3));
				*/
			}
			//System.out.println(this.lstPersonaLenguaBean);
		}
		
		return "1";

	}
	
	@RequestMapping(value = "/refrescarNacionalidad", method = RequestMethod.GET)
	public @ResponseBody String refrescarNacionalidad(@RequestParam("listadoNacionalidad") List<String> listadoNacionalidad) {

		// TODO Auto-generated catch block
		System.out.println("----------------------");
		System.out.println(listadoNacionalidad);
		this.setLstPersonaNacionalidadBean(new ArrayList<PersonaNacionalidadBean>());
		
		PersonaNacionalidadBean  personaNacionalidadBean;
		
		if (listadoNacionalidad != null && listadoNacionalidad.size() != 0) {
			for (int i = 0; i < listadoNacionalidad.size();i=i+2) {
				
				personaNacionalidadBean = new PersonaNacionalidadBean();
				personaNacionalidadBean.setPersonaBean(new PersonaBean());
				personaNacionalidadBean.setNacionalidad(new MaestraBean());
					
				System.out.println("codigo Nacionalidad "+listadoNacionalidad.get(i));
				System.out.println("nombre Nacionalidad "+listadoNacionalidad.get(i+1));
				personaNacionalidadBean.getNacionalidad().setCodigo(Long.parseLong(listadoNacionalidad.get(i)));
				personaNacionalidadBean.getNacionalidad().setNombreCorto(listadoNacionalidad.get(i+1));
				this.lstPersonaNacionalidadBean.add(personaNacionalidadBean);
			}
		}
		return "1";

	}
	
	
	@RequestMapping(value = "/refrescarInstitucion", method = RequestMethod.GET)
	public @ResponseBody String refrescarInstitucion(@RequestParam("listadoInstitucion") List<String> listadoInstitucion) {

		// TODO Auto-generated catch block
		System.out.println("----------------------");
		System.out.println("listadoInstitucion "+listadoInstitucion);
		this.setLstAlumnoInstitucionBean(new ArrayList<AlumnoInstitucionBean>());
		
		AlumnoInstitucionBean  alumnoInstitucionBean;
		
		if (listadoInstitucion != null && listadoInstitucion.size() != 0) {
			for (int i = 0; i < listadoInstitucion.size();i=i+2) {
				
				alumnoInstitucionBean = new AlumnoInstitucionBean();
				alumnoInstitucionBean.setAlumnoBean(new AlumnoBean());
				alumnoInstitucionBean.setInstitucionBean(new InstitucionBean());
				
				System.out.println("codigo InstitucionBean "+listadoInstitucion.get(i));
				System.out.println("nombre InstitucionBean "+listadoInstitucion.get(i+1));
				alumnoInstitucionBean.getInstitucionBean().setCodigo(Long.parseLong(listadoInstitucion.get(i)));
				alumnoInstitucionBean.getInstitucionBean().setNombreInstitucion(listadoInstitucion.get(i+1));
				
				this.lstAlumnoInstitucionBean.add(alumnoInstitucionBean);
//				System.out.println("lstAlumnoInstitucionBean.get(i).getInstitucionBean().getCodigo() "+lstAlumnoInstitucionBean.get(i).getInstitucionBean().getCodigo());
			}
		}
		return "1";

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
	
	
	
	public InstitucionService getInstitucionService() {
		return institucionService;
	}
	
	public List<PersonaNacionalidadBean> getLstPersonaNacionalidadBean() {
		return lstPersonaNacionalidadBean;
	}

	public void setLstPersonaNacionalidadBean(
			List<PersonaNacionalidadBean> lstPersonaNacionalidadBean) {
		this.lstPersonaNacionalidadBean = lstPersonaNacionalidadBean;
	}

	public List<PersonaLenguaBean> getLstPersonaLenguaBean() {
		return lstPersonaLenguaBean;
	}

	public void setLstPersonaLenguaBean(List<PersonaLenguaBean> lstPersonaLenguaBean) {
		this.lstPersonaLenguaBean = lstPersonaLenguaBean;
	}

	
	
	public PersonaLenguaService getPersonaLenguaService() {
		return personaLenguaService;
	}

	public void setPersonaLenguaService(PersonaLenguaService personaLenguaService) {
		this.personaLenguaService = personaLenguaService;
	}

	public PersonaNacionalidadService getPersonaNacionalidadService() {
		return personaNacionalidadService;
	}

	public void setPersonaNacionalidadService(
			PersonaNacionalidadService personaNacionalidadService) {
		this.personaNacionalidadService = personaNacionalidadService;
	}

	public void setValoresPredeterminados(AlumnoBean alumnoBean){
		alumnoBean.setCodigo(0);
		alumnoBean.setPersonaBean(new PersonaBean());
		alumnoBean.getPersonaBean().setNombrePersona(""); 
		alumnoBean.setTm1Situacion(new MaestraBean());
		alumnoBean.getTm1Situacion().setCodigoRegistro(0);
	 }


	public List<String> getListadoInstitucionVo() {
		return listadoInstitucionVo;
	}


	public void setListadoInstitucionVo(List<String> listadoInstitucionVo) {
		this.listadoInstitucionVo = listadoInstitucionVo;
	}


	public AlumnoInstitucionService getAlumnoInstitucionService() {
		return alumnoInstitucionService;
	}


	public void setAlumnoInstitucionService(AlumnoInstitucionService alumnoInstitucionService) {
		this.alumnoInstitucionService = alumnoInstitucionService;
	}


	public List<AlumnoInstitucionBean> getLstAlumnoInstitucionBean() {
		return lstAlumnoInstitucionBean;
	}


	public void setLstAlumnoInstitucionBean(List<AlumnoInstitucionBean> lstAlumnoInstitucionBean) {
		this.lstAlumnoInstitucionBean = lstAlumnoInstitucionBean;
	}
	
	
}
