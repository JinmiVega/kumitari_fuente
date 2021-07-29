package pe.gob.procalidad.natigu.web.gestion.controller.academico;

import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.io.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocumentoInscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionOperadorBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.DocenteService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.DocumentoInscripcionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionLenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.MatriculaAlumnoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.UsuarioMatriculaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaEstructuraService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.web.gestion.controller.academico.view.InscripcionForm;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.FileValidator;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.NetUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.Encrypt;
 
@Controller
@RequestMapping(value = "inscripcionController")
public class InscripcionController extends BaseController {
	
	private InscripcionForm				inscripcionForm;
	private InscripcionBean 			inscripcionaBean;
	private InscripcionBean 			inscripcionaBeanTmp;
	private InscripcionBean 			inscripcionaBeanFilter;
	private InscripcionLenguaBean		inscripcionLenguaBean;
	private DocumentoInscripcionBean 	documentoInscripcionBean;
	private List<InscripcionBean> 		lstInscripcionBean;
	
	private List<MaestraBean>		lstSituacion;
	private List<MaestraBean>		lstPeriodo;
	private List<MaestraBean>		lstCiclo;

	
	private List<InstitucionBean>	lstInstitucionBean;
	
	private List<LenguaBean> 		lstLenguaBean; 
	
	private String 					swcod;
	private String				tmpUrlImagen;
	
	@Autowired
	private InscripcionService 		inscripcionService;
	
	@Autowired
	private UsuarioMatriculaService usuarioMatriculaService;
	
	@Autowired
	private Maestra2Service 		maestra2Service;
	
    @Autowired
	private InstitucionService		institucionService;
    
	@Autowired
	private LenguaService 		lenguaService;
	
	@Autowired
	private InscripcionLenguaService 		inscripcionLenguaService;
	
	@Autowired
	private MatriculaAlumnoService 			matriculaAlumnoService;
	
	@Autowired
	private LenguaEstructuraService			lenguaEstructuraService;
	
	@Autowired
	private DocumentoInscripcionService 	documentoInscripcionService;
	
	@Autowired
	private PeticionService peticionService;
	/***************************************/

	
	private List<MaestraBean>	lstSituacionDoc;
	private List<MaestraBean> lstTipoDocumento;
	private List<MaestraBean> lstNacionalidad;
	private List<MaestraBean> lstGrado;
	private List<MaestraBean> lstCargo;
	private List<MaestraBean> lstSexo;
	private List<MaestraBean> lstCarrera;
	private List<LenguaBean> 	lstLengua;
	List<InstitucionBean> lstInstitucion;
	
	//private FileFormBean fileFormBean;
	
	
	private DocenteBean 			docenteBean;
	private List<DocenteBean> 		lstDocenteBean;
	
	private List<MaestraBean> 		lstNivel;
	private List<LenguaBean> 		lstlenguaBeanCombo;
	
	
	@Autowired
	private Maestra1Service 		maestra1Service;
	
	@Autowired
	private DocenteService 			docenteService;
	
	@Autowired 
	private PersonaService 			personaService;
	/******************************************/
	
	public InscripcionController (){
		
	}
	
	@PostConstruct
	public void init(){
		inscripcionaBeanFilter = new InscripcionBean();
		this.setInscripcionaBean(new InscripcionBean());
		this.setLstInscripcionBean(new ArrayList<InscripcionBean>());
		this.setInscripcionForm(new InscripcionForm());
		this.setInscripcionLenguaBean(new InscripcionLenguaBean());
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("inscripcionBean") InscripcionBean inscripcionBean, HttpServletRequest request)throws Exception {
		//this.setValoresPredeterminados(new InscripcionBean());
		System.out.println("----Listado----");
		UsuarioBean usuarioActual = new UsuarioBean();
		InscripcionBean prmInscripcionBean = new InscripcionBean();
		System.out.println("inscripcionBean.getCodigo() " + inscripcionBean.getInstitucion().getCodigo());
		System.out.println("inscripcionBean.getSituacion().getCodigoRegistro() " + inscripcionBean.getSituacion().getCodigoRegistro());
		prmInscripcionBean.getInstitucion().setCodigo(inscripcionBean.getInstitucion().getCodigo());
		prmInscripcionBean.getSituacion().setCodigoRegistro(inscripcionBean.getSituacion().getCodigoRegistro());
//		return this.getLista(prmInscripcionBean);
		InstitucionOperadorBean instLocal = new InstitucionOperadorBean();
		List <InstitucionOperadorBean>  lst= new ArrayList<InstitucionOperadorBean>();
		
		ModelAndView mav = new ModelAndView("academico/listado-inscripcion", "command",inscripcionBean);
		try{
			
			UsuarioBean userActual = this.getUsuarioSesion(request);
			
			usuarioActual = userActual;
			
			instLocal.setPersonaBean(userActual.getPersona());
			
		    lst= this.fs.getInstitucionOperadorService().getBuscarPorFiltros(instLocal);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("lstInscripcionBean", new ArrayList<InscripcionBean>());
		this.cargarCombos(mav);
		this.cargarCombosInstitucion(mav,request);
		if(usuarioActual.getCodPerfilUsuSelec() == 6){
			if(lstInstitucionBean != null){
				List<InstitucionBean> lstInstitucionBeanTemp = new ArrayList<InstitucionBean>(); 
				for(int k=0; k<lstInstitucionBean.size();k++){ 
						if(lst != null){
							for(int l=0;l<lst.size();l++){
								if(lstInstitucionBean.get(k).getCodigo() == lst.get(l).getCodigoInstitucion()){
									lstInstitucionBeanTemp.add(lstInstitucionBean.get(k)); 
								}
							}
						} 
				} 
				lstInstitucionBean = lstInstitucionBeanTemp;
				mav.addObject("lstInstitucionBean",lstInstitucionBean); 
			}
		}
		
		this.cargarCombosLengua(mav);
//		inscripcionForm.getInscripcionBean().getSituacion().setCodigoRegistro(1); 
		
	
		return mav;
	}
	  
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("inscripcionBean") InscripcionBean inscripcionBean,HttpServletRequest request)
			throws Exception {
		inscripcionaBeanFilter = inscripcionBean;
		//this.setValoresPredeterminados(new InscripcionBean());
		InscripcionBean prmInscripcionBean = new InscripcionBean();
		System.out.println("inscripcionBean.getCodigo() " + inscripcionBean.getInstitucion().getCodigo());
		System.out.println("inscripcionBean.getSituacion().getCodigoRegistro() " + inscripcionBean.getSituacion().getCodigoRegistro());
		prmInscripcionBean.getInstitucion().setCodigo(inscripcionBean.getInstitucion().getCodigo());
		prmInscripcionBean.getSituacion().setCodigoRegistro(inscripcionBean.getSituacion().getCodigoRegistro());
		UsuarioBean usuario = this.getUsuarioSesion(request);
		prmInscripcionBean.setAudCodigoUsuario((usuario.getCodigoUsuario()));
		return this.getBuscar(prmInscripcionBean , request);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscar(HttpServletRequest request) throws Exception {
		//this.setValoresPredeterminados(new InscripcionBean());
		InscripcionBean prmInscripcionBean = new InscripcionBean();
		System.out.println("inscripcionBean.getCodigo() " + inscripcionaBeanFilter.getInstitucion().getCodigo());
		System.out.println("inscripcionBean.getSituacion().getCodigoRegistro() " + inscripcionaBeanFilter.getSituacion().getCodigoRegistro());
		prmInscripcionBean.getInstitucion().setCodigo(inscripcionaBeanFilter.getInstitucion().getCodigo());
		prmInscripcionBean.getSituacion().setCodigoRegistro(inscripcionaBeanFilter.getSituacion().getCodigoRegistro());
		UsuarioBean usuario = this.getUsuarioSesion(request);
		prmInscripcionBean.setAudCodigoUsuario((usuario.getCodigoUsuario()));
		return this.getBuscar(prmInscripcionBean, request);
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		inscripcionaBeanTmp = null;
		ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",new InscripcionForm());//new InscripcionBean()
		
		/*****************************************************************/
//		docenteBean = new DocenteBean();
//		try {
//			lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarPorFiltros(docenteBean);
//			System.out.println("lstDocenteBean "+lstDocenteBean.size());
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("ciclos 123");
		System.out.println(lstCiclo);
		/********************************************************************/
		mav.addObject("lstSituacion",new InscripcionForm());
		mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("lstPeriodo",lstPeriodo); 
		mav.addObject("lstInstitucionBean",lstInstitucionBean);
		mav.addObject("lstLenguaBean",lstLenguaBean);
		mav.addObject("lstCiclo",lstCiclo);
		mav.addObject("inscripcionBean", new InscripcionBean());
		mav.addObject("inscripcionLenguaBean", new InscripcionLenguaBean());
		mav.addObject("documentoInscripcionBean", new DocumentoInscripcionBean());
//		mav.addObject("lstDocenteBean", lstDocenteBean);
		
//		mav.addObject("docenteBean", new DocenteBean());
		this.cargarCombosDocente(mav);
		return mav;
	}

//	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo,HttpServletRequest request) {
		
		InscripcionBean prmInscripcionBean = new InscripcionBean();

		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("InscripcionController/modificar");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	try {
		        		prmInscripcionBean.setCodigo(codigo);
		        		inscripcionaBeanTmp = prmInscripcionBean;
						inscripcionaBean = this.getInscripcionService().getBuscarPorObjecto(prmInscripcionBean);
						inscripcionForm.setInscripcionBean(inscripcionaBean);
					} catch (ServiceException e) { 
						e.printStackTrace();
					}
		        }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			if (inscripcionaBean != null  && inscripcionaBean.getSituacion().getCodigoRegistro() != null ) {
				 
					 
					System.out.println("modificar lenguaBean: " + inscripcionaBean);
					ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",inscripcionForm);
					mav.addObject("inscripcionForm", inscripcionForm);
	//				mav.addObject("documentoInscripcionBean", new DocumentoInscripcionBean());
					this.cargarCombos(mav);
					this.cargarCombosInstitucion(mav,request);
					this.cargarCombosLengua(mav);
					System.out.println("inscripcionForm.getInscripcionBean().getCodigo() " + inscripcionForm.getInscripcionBean().getCodigo());
					cargarInscripcionXLengua(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
					listarDetalleDocumInscri(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
					return mav;
			}else{ 
				ModelAndView mav = this.getLista(new InscripcionBean(),request);
				mav.addObject("swMensaje","0");
				mav.addObject("inscripcionBean",new InscripcionBean());  
				return mav;
				
			}  
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesión no es valida, por favor inicie sesión nuevamente");
			return mav;
		}
//		System.out.println("modificar lenguaBean: " + inscripcionaBean);
//		ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",inscripcionForm);
//		mav.addObject("inscripcionForm", inscripcionForm);
//		this.cargarCombos(mav);
//		this.cargarCombosInstitucion(mav);
//		this.cargarCombosLengua(mav);
//		System.out.println("inscripcionForm.getInscripcionBean().getCodigo() " + inscripcionForm.getInscripcionBean().getCodigo());
//		cargarInscripcionXLengua(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
//		return mav;
	}
	
	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(HttpServletRequest request) {
		System.out.println("----Modificar----");
		if(inscripcionaBeanTmp != null){
			InscripcionBean prmInscripcionBean = new InscripcionBean();
			prmInscripcionBean.setCodigo(inscripcionaBeanTmp.getCodigo());
			try {
				inscripcionaBean = this.getInscripcionService().getBuscarPorObjecto(prmInscripcionBean);
				inscripcionForm.setInscripcionBean(inscripcionaBean);
			} catch (ServiceException e) { 
				e.printStackTrace();
			}
			
			if (inscripcionaBean != null  && inscripcionaBean.getSituacion().getCodigoRegistro() != null ) {
				 
					 
					System.out.println("modificar lenguaBean: " + inscripcionaBean);
					ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",inscripcionForm);
					mav.addObject("inscripcionForm", inscripcionForm);
//					mav.addObject("documentoInscripcionBean", new DocumentoInscripcionBean());
					this.cargarCombos(mav);
					this.cargarCombosInstitucion(mav,request);
					this.cargarCombosLengua(mav);
					System.out.println("inscripcionForm.getInscripcionBean().getCodigo() " + inscripcionForm.getInscripcionBean().getCodigo());
					cargarInscripcionXLengua(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
					listarDetalleDocumInscri(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
					return mav;
			}else{ 
				ModelAndView mav = this.getLista(new InscripcionBean(),request);
				mav.addObject("swMensaje","0");
				mav.addObject("inscripcionBean",new InscripcionBean());  
				return mav;
				
			}  
		}else{
			ModelAndView mav = this.getLista(new InscripcionBean(),request);
			mav.addObject("swMensaje","0");
			mav.addObject("inscripcionBean",new InscripcionBean());  
			return mav;
		}

//		System.out.println("modificar lenguaBean: " + inscripcionaBean);
//		ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",inscripcionForm);
//		mav.addObject("inscripcionForm", inscripcionForm);
//		this.cargarCombos(mav);
//		this.cargarCombosInstitucion(mav);
//		this.cargarCombosLengua(mav);
//		System.out.println("inscripcionForm.getInscripcionBean().getCodigo() " + inscripcionForm.getInscripcionBean().getCodigo());
//		cargarInscripcionXLengua(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
//		return mav;
	}
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		inscripcionaBean= new InscripcionBean();
		inscripcionaBean.setCodigo(codigo);
		System.out.println("codigocodigocodigo eliminar " + codigo);
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
					this.setAuditoria(inscripcionaBean, request, false);
				sw =  (this.getInscripcionService().eliminar(inscripcionaBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		inscripcionaBean.setCodigo(0);
		this.setValoresPredeterminados(inscripcionaBean);
		ModelAndView mav = this.getLista(inscripcionaBean,request);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}
	
	private String getRootPath() {    	
		return ResourceUtil.getKey("ruta.natigu.archivos.academico.inscripcion");
     }
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView doGrabar(@ModelAttribute("inscripcionForm") InscripcionForm inscripcionForm,HttpServletRequest request) {
		System.out.println("----Grabar----");
		System.out.println("inscripcionBean "+inscripcionForm);
		System.out.println("inscripcionForm.getInscripcionBean().getInstitucion().getCodigo() "+inscripcionForm.getInscripcionBean().getInstitucion().getCodigo());
		System.out.println("inscripcionBean.getCodigo() "+inscripcionForm.getInscripcionBean().getCodigo());
		System.out.println("inscripcionForm.getInscripcionBean().getFechaRegistro()1 " + inscripcionForm.getInscripcionBean().getFechaRegistro());
		System.out.println("inscripcionForm.getInscripcionBean().getTipoAcceso() " + inscripcionForm.getInscripcionBean().getTipoAcceso());
		boolean sw = false;
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("InscripcionController/grabar");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	try {
		        		if(inscripcionForm.getInscripcionBean().getFechaRegistro()!=null) {
		        			if (inscripcionForm.getInscripcionBean().getCodigo()==0) {
		        				//				String ruta="";
		        				//				String nombreDoc="";
		        				//				if (!file.isEmpty()) {
		        				//					try {
		        				//						byte[] bytes = file.getBytes();
		        				//						System.out.println("file.getName() "+ file.getName());
		        				//						System.out.println("file.getOriginalFilename() "+ file.getOriginalFilename());
		        				//						// Creating the directory to store file
		        				//						String rootPath = "C:/ruta/";
		        				//						File dir = new File(rootPath + File.separator + "tmpFiles");
		        				//						if (!dir.exists())
		        				//							dir.mkdirs();
		        				//
		        				//						// Create the file on server
		        				//						File serverFile = new File(dir.getAbsolutePath()
		        				//								+ File.separator + file.getOriginalFilename());
		        				//						BufferedOutputStream stream = new BufferedOutputStream(
		        				//								new FileOutputStream(serverFile));
		        				//						stream.write(bytes);
		        				//						stream.close();
		        				//
		        				////						logger.info("Server File Location="
		        				////								+ serverFile.getAbsolutePath());
		        				//						ruta=String.valueOf(serverFile);
		        				//						nombreDoc=file.getOriginalFilename();
		        				//						System.out.println("serverFile " +serverFile);
		        				//						System.out.println("file.getName() "+ file.getName());
		        				//						System.out.println("You successfully uploaded file=" +file.getOriginalFilename()); 
		        				//					} catch (Exception e) {
		        				//						 e.getMessage();
		        				//					}
		        				//				} else {
		        				//					System.out.println("You failed to upload " + file.getOriginalFilename()+ " because the file was empty.");
		        				//				}
		        				
		        				
		        				System.out.println("insertar ");
		        				//				System.out.println("inscripcionForm.getInscripcionBean().getFechaRegistro()2 " + inscripcionForm.getInscripcionBean().getFechaRegistro());
		        				//				inscripcionForm.getInscripcionBean().setNombreDocumento(nombreDoc);
		        				//				
		        				//				inscripcionForm.getInscripcionBean().setRutaDocumento(ruta);
		        				this.setAuditoria(inscripcionForm.getInscripcionBean(), request, true);
		        				sw =  (this.getInscripcionService().insertar(inscripcionForm.getInscripcionBean())); 
		        				
		        				
		        				
		        				
		        				
		        			} else {
		        				System.out.println("actualizar ");
		        				//				if (file.isEmpty()) {
		        				//						System.out.println("no paso");
		        				//				}else {
		        				//					System.out.println("inscripcionForm.getInscripcionBean().getRutaDocumento() " + inscripcionForm.getInscripcionBean().getRutaDocumento());
		        				//					inscripcionForm.getInscripcionBean().setRutaDocumento(inscripcionForm.getInscripcionBean().getRutaDocumento());
		        				//				}
		        				this.setAuditoria(inscripcionForm.getInscripcionBean(), request, false);
		        				sw = (this.getInscripcionService().actualizar(inscripcionForm.getInscripcionBean()));
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
				
	//			inscripcionBean = new InscripcionBean() ;
	//			this.setValoresPredeterminados(inscripcionaBean);
	//			return this.getLista(inscripcionBean);
				InscripcionBean prmInscripcionBean = new InscripcionBean();
				System.out.println("inscripcionBean.getCodigo() " +inscripcionForm.getInscripcionBean().getCodigo());
				prmInscripcionBean.setCodigo(inscripcionForm.getInscripcionBean().getCodigo());
				try {
					inscripcionaBean = this.getInscripcionService().getBuscarPorObjecto(prmInscripcionBean);
				} catch (ServiceException e) { 
					e.printStackTrace();
				}
				System.out.println("modificar lenguaBean: " + inscripcionaBean);
				ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",inscripcionForm);
	//			mav.addObject("inscripcionaBean", inscripcionaBean);
				
				this.cargarCombos(mav);
				this.cargarCombosInstitucion(mav,request);
				this.cargarCombosLengua(mav);
				cargarInscripcionXLengua(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
				listarDetalleDocumInscri(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
				mav.addObject("swMensaje",sw?"1":"0");
				inscripcionForm.getInscripcionBean().setCodigo(inscripcionForm.getInscripcionBean().getCodigo());
				inscripcionaBean.setCodigo(inscripcionForm.getInscripcionBean().getCodigo());
				return mav;
			} else {
				inscripcionForm.getInscripcionBean().setRutaDocumento(null);
				ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",inscripcionForm);
	//			
				this.cargarCombos(mav);
				this.cargarCombosInstitucion(mav,request);
				this.cargarCombosLengua(mav);
				cargarInscripcionXLengua(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
				mav.addObject("swMensaje","0");
				mav.addObject("inscripcionaBean",inscripcionForm);  
				return mav;
				
	//			ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",new InscripcionForm());//new InscripcionBean()
	//  			mav.addObject("lstSituacion",lstSituacion);
	//			mav.addObject("lstPeriodo",lstPeriodo); 
	//			mav.addObject("lstInstitucionBean",lstInstitucionBean);
	//			mav.addObject("lstLenguaBean",lstLenguaBean);
	//			mav.addObject("lstCiclo",lstCiclo);
	//			mav.addObject("inscripcionBean", new InscripcionBean());
	//			mav.addObject("inscripcionLenguaBean", new InscripcionLenguaBean()); 
	//			mav.addObject("swMensaje",sw?"1":"0");
	//			this.cargarCombosDocente(mav);
	//			return mav;
			}
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesión no es valida, por favor inicie sesión nuevamente");
			return mav;
		}

	}
	
	@RequestMapping(value = "/grabarDetDocumInscrip", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabarDetDocumInscrip(@RequestParam("codigo") Integer codigoInscrip,
											@RequestParam("numedocu") String numDocum,
											@RequestParam(value="file",required=false) MultipartFile[] files,
											HttpServletRequest request) {

//		Long size = file.getSize();
//	    String contentType = file.getContentType();
		DocumentoInscripcionBean documentoInscripcionBean = new DocumentoInscripcionBean();
		System.out.println("------------------grabarDetDocumInscrip--------------------");
		System.out.println("codigoInscrip "+codigoInscrip);
		System.out.println("numDocum "+numDocum);
		System.out.println("file "+files);
//		System.out.println("file size " + size);
//		System.out.println("file contentType " + contentType);
//		
		boolean swNuevaUrlImagen = false; 
		boolean sw = false;
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("InscripcionController/grabarDetDocumInscrip");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	try {
	        			
//					String ruta="";
//					String nombreDoc="";
//					if (!file.isEmpty()) {
//						try {
//							byte[] bytes = file.getBytes();
//							System.out.println("file.getName() "+ file.getName());
//							System.out.println("file.getOriginalFilename() "+ file.getOriginalFilename());
//							nombreDoc=file.getOriginalFilename();
//							System.out.println("nombreDoc1 " + nombreDoc);
//							// Creating the directory to store file
//							//String rootPath = "C:/ruta/";
//							File dir = new File(this.getRootPath());// + File.separator + "tmpFiles"
//							if (!dir.exists())
//								dir.mkdirs();
	        			//
//							// Create the file on server
//							File serverFile = new File(dir.getAbsolutePath()
//									+ File.separator + file.getOriginalFilename());
//							BufferedOutputStream stream = new BufferedOutputStream(
//									new FileOutputStream(serverFile));
//							stream.write(bytes);
//							stream.close();
	        			//
////							logger.info("Server File Location="
////									+ serverFile.getAbsolutePath());
//							ruta=String.valueOf(serverFile);
//							
//							System.out.println("serverFile " +serverFile);
//							System.out.println("file.getName() "+ file.getName());
//							System.out.println("You successfully uploaded file=" +file.getOriginalFilename());
//							System.out.println("nombreDoc2 " + nombreDoc);
//						} catch (Exception e) {
//							 e.getMessage();
//							 System.out.println("e.getMessage()"+ e.getMessage());
//						}
//					} else {
//						System.out.println("You failed to upload " + file.getOriginalFilename()+ " because the file was empty.");
//					}
	        			
	        			
	        			if (files.length>0) {
	        				swNuevaUrlImagen = (files[0]!=null) && (files[0].getOriginalFilename()!=null ) && (files[0].getOriginalFilename().trim().length()>0 );
	        				
	        				if(files[0].getOriginalFilename()!=null) {
	    						String[] formats = files[0].getOriginalFilename().toString().split("\\.");
	    						System.out.println("archivo: "+formats[formats.length-1]);
	    						if(!formats[formats.length-1].equals("pdf") && !formats[formats.length-1].equals("doc") && !formats[formats.length-1].equals("docx") &&
	    								!formats[formats.length-1].equals("odt")) {
	    							return "3";
	    						}
	    						
	    					}
	        			}
	        			String	ruta_p=this.getRootPath();
	        			System.out.println("--- Ruta:"+ ruta_p);
	        			
	        			// Creating the directory to store file
	        			byte[] bytes = files[0].getBytes();
						String rootPath = "C:/ruta/";
						File dir = new File(rootPath + File.separator + "tmpFiles");
						if (!dir.exists())
							dir.mkdirs();
			
						// Create the file on server
						File serverFile = new File(dir.getAbsolutePath()
								+ File.separator + files[0].getOriginalFilename());
						BufferedOutputStream stream = new BufferedOutputStream(
								new FileOutputStream(serverFile));
						stream.write(bytes);
						stream.close();
			
			//			logger.info("Server File Location="
			//					+ serverFile.getAbsolutePath());
						String ruta=String.valueOf(serverFile);
						if(!FileValidator.validFileHead(ruta)) {
							if(serverFile.delete()) {
								System.out.println("El fichero ha sido borrado satisfactoriamente");
							}else {
								System.out.println("El fichero no puede ser borrado");
							}
							return "3";
						}else {
							if(serverFile.delete()) {
								System.out.println("El fichero ha sido borrado satisfactoriamente");
							}else {
								System.out.println("El fichero no puede ser borrado");
							}
						}
	        		
	        			
	        			
	        			
	        			
	        			if (swNuevaUrlImagen) {
	        				documentoInscripcionBean.setFile(files[0]);
	        				if (files[0].getOriginalFilename()!=null) {
	        					documentoInscripcionBean.setNombdocu(files[0].getOriginalFilename());
	        					System.out.println("files[0].getOriginalFilename() "+ files[0].getOriginalFilename());
	        				}	    					
	        			}
	        			
	        			
	        			System.out.println("insertar ");
	        			
	        			documentoInscripcionBean.getInscripcion().setCodigo(Long.valueOf(codigoInscrip));
//					documentoInscripcionBean.setNombdocu(nombreDoc);				
	        			documentoInscripcionBean.setRutadocu("");
	        			documentoInscripcionBean.setNumedocu(numDocum);
	        			
//					documentoInscripcionBean.setCodigoUsuarioCreacion(1);
//					documentoInscripcionBean.setIpCreacion("");
	        			
	        			this.setAuditoria(documentoInscripcionBean, request, true);
	        			sw =  (this.documentoInscripcionService.insertar(documentoInscripcionBean)); 
	        			
	        			if (documentoInscripcionBean.getCodigo()==0) {
	        				System.out.println("entro 2");
	        				System.out.println("documentoInscripcionBean.getCodigo() "+ documentoInscripcionBean.getCodigo());
	        				return "2";
	        			}
	        			
	        			
	        			
//				} else {
//					sw=false;
//					return "0";
//					
//				}

				} catch (Exception e) { 
					
					e.printStackTrace();
					return "0";
				}
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "0";
		}
		

		if (sw) {
			if (swNuevaUrlImagen) {
				super.cargarArchivo(this.getRootPath(), documentoInscripcionBean.getNombdocu(), documentoInscripcionBean.getFile());    			    	
				tmpUrlImagen = documentoInscripcionBean.getNumedocu();
			} 
			System.out.println("entro 1");
			return "1";
		}else {
			System.out.println("entro 0");
			return "0";
		}
		
	}

	@RequestMapping(value = "/grabarDocente", method = RequestMethod.POST)
	public ModelAndView doGrabarDocente(@ModelAttribute("inscripcionBean") InscripcionBean inscripcionBean,HttpServletRequest request) {
		
		System.out.println("docenteBean"+docenteBean);
		PersonaBean prmPersona = new PersonaBean();
		docenteBean = new DocenteBean();
		docenteBean = inscripcionBean.getDocenteBean();
		boolean sw = false;
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("InscripcionController/grabarDocente");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	try {
						if (docenteBean.getCodigo()==0) {
							
							
							prmPersona=docenteBean.getPersonaBean();
							prmPersona = this.personaService.buscarxTipoDocumentoNumeroDocumento(prmPersona);
							if(prmPersona==null){
								prmPersona=docenteBean.getPersonaBean();
								sw = (this.personaService.insertar(prmPersona));
								
								docenteBean.setAudCodigoUsuario(1);
								docenteBean.setAudHostIP("192.168.1.1");
							}
							
							docenteBean.setPersonaBean(prmPersona);
								this.setAuditoria(docenteBean, request, true);
							sw =  (this.docenteService.insertar(docenteBean)); 
						} else {
								this.setAuditoria(docenteBean, request, false);
							sw = (this.docenteService.actualizar(docenteBean));
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
				docenteBean = new DocenteBean() ;
				inscripcionBean.setDocenteBean(docenteBean);
				return this.getLista(inscripcionBean,request);
			} else {
				ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
				return mav;
			}
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesión no es valida, por favor inicie sesión nuevamente");
			return mav;
		}
	}
	
	private void cargarCombosDocente(ModelAndView mav){
//		lstSituacion = new ArrayList<MaestraBean>();
		
		InstitucionBean institucionBean = new InstitucionBean();
		LenguaBean lenguaBean = new LenguaBean();
		if (lstSituacionDoc==null) {
			try {
				lstInstitucion = (List<InstitucionBean>) this.institucionService.getBuscarPorFiltros(institucionBean);
				lstLengua = (List<LenguaBean>) this.lenguaService.getBuscarPorFiltros(lenguaBean);
				lstSituacionDoc = maestra1Service.listarPorCodigoTabla("situacionPersonal",0);
				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento",1);
				lstNacionalidad = maestra2Service.listarPorCodigoTabla("nacionalidad",0);
						lstGrado=  maestra2Service.listarPorCodigoTabla("grado",0);
						lstCargo= maestra2Service.listarPorCodigoTabla("cargo",0);
						lstSexo= maestra2Service.listarPorCodigoTabla("sexo",0);
						lstCarrera =maestra2Service.listarPorCodigoTabla("carrera",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
  
		mav.addObject("lstSituacionDoc",lstSituacionDoc); 
		mav.addObject("lstTipoDocumento",lstTipoDocumento); 
		mav.addObject("lstNacionalidad",lstNacionalidad); 
		mav.addObject("lstGrado",lstGrado); 
		mav.addObject("lstCargo",lstCargo); 
		mav.addObject("lstSexo",lstSexo);
		mav.addObject("lstCarrera",lstCarrera); 
		mav.addObject("lstLengua",lstLengua); 
		mav.addObject("lstInstitucion",lstInstitucion); 
	}
	
	
	private ModelAndView getLista(InscripcionBean inscripcionBean,HttpServletRequest request) {

		List<InscripcionBean> lstInscripcionBean =null;
		inscripcionBean.getSituacion().setCodigoRegistro(1);
//		List<DocenteBean> lstDocenteBean = new ArrayList<DocenteBean>();
		try {
			lstInscripcionBean = this.getInscripcionService().getBuscarPorFiltros(inscripcionBean);
			System.out.println("lstInscripcionBean "+lstInscripcionBean.size());
			
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}
		

		ModelAndView mav = new ModelAndView("academico/listado-inscripcion", "command",inscripcionBean);
		System.out.println("lstInscripcionBean "+lstInscripcionBean);
		mav.addObject("lstInscripcionBean", lstInscripcionBean);
		this.cargarCombos(mav);
		this.cargarCombosInstitucion(mav,request);
		this.cargarCombosLengua(mav);
//		inscripcionForm.getInscripcionBean().getSituacion().setCodigoRegistro(1); 
	
		return mav;
	}
	
	private ModelAndView getBuscar(InscripcionBean inscripcionBean, HttpServletRequest request) {
		UsuarioBean usuarioActual = new  UsuarioBean();
		InstitucionOperadorBean instLocal = new InstitucionOperadorBean();
		List<InscripcionBean> lstInscripcionBean =null;
		List<InscripcionBean> lstInscripcionxOperadorBean =new ArrayList<InscripcionBean>();
		List <InstitucionOperadorBean>  lst= new ArrayList<InstitucionOperadorBean>();
//		List<DocenteBean> lstDocenteBean = new ArrayList<DocenteBean>();
		try {
			UsuarioBean userActual = this.getUsuarioSesion(request);
			
			usuarioActual = userActual;
			
			if(userActual.getCodPerfilUsuSelec() == 6){
				instLocal.setPersonaBean(userActual.getPersona());
		
				  lst= this.fs.getInstitucionOperadorService().getBuscarPorFiltros(instLocal);
				
				if(lst != null){
					for(int i=0;i<lst.size();i++){
						inscripcionBean.setInstitucion(new InstitucionBean());
						inscripcionBean.getInstitucion().setCodigo(lst.get(i).getCodigoInstitucion());
						lstInscripcionBean = this.getInscripcionService().getBuscarPorFiltros(inscripcionBean); 
						if(lstInscripcionBean != null){
							for(int j=0; j<lstInscripcionBean.size();j++){
								lstInscripcionxOperadorBean.add(lstInscripcionBean.get(i));
							}
							
						}
						
						//lstInscripcionxOperadorBean.(lstInscripcionBean)
						
						//lst.get(i).getCodigoInstitucion();
						
//						lstInscripcionBean()
//						if( lstInscripcionBean = lst.get(i).getCodigoInstitucion()){
//							
//						}
					}
					
				}
				lstInscripcionBean = lstInscripcionxOperadorBean;
			}else{

				lstInscripcionBean = this.getInscripcionService().getBuscarPorFiltros(inscripcionBean);
			}
			
			System.out.println("lstInscripcionBean "+lstInscripcionBean.size());
			
			
			
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}
		 
		ModelAndView mav = new ModelAndView("academico/listado-inscripcion", "command",inscripcionBean);
		System.out.println("lstInscripcionBean "+lstInscripcionBean);
		mav.addObject("lstInscripcionBean", lstInscripcionBean);
		this.cargarCombos(mav);
		this.cargarCombosInstitucion(mav,request);
		if(usuarioActual.getCodPerfilUsuSelec() == 6){
			if(lstInstitucionBean != null){
				List<InstitucionBean> lstInstitucionBeanTemp = new ArrayList<InstitucionBean>(); 
				for(int k=0; k<lstInstitucionBean.size();k++){ 
						if(lst != null){
							for(int l=0;l<lst.size();l++){
								if(lstInstitucionBean.get(k).getCodigo() == lst.get(l).getCodigoInstitucion()){
									lstInstitucionBeanTemp.add(lstInstitucionBean.get(k)); 
								}
							}
						} 
				} 
				lstInstitucionBean = lstInstitucionBeanTemp;
				mav.addObject("lstInstitucionBean",lstInstitucionBean); 
			}
		}
		
		
		this.cargarCombosLengua(mav);
//		inscripcionForm.getInscripcionBean().getSituacion().setCodigoRegistro(1); 
	
		return mav;
	}
	
          
	private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra2Service.listarPorCodigoTabla("situacionInscripcion",0);
				setLstPeriodo(maestra2Service.listarPorCodigoTabla("periodo",0));
				lstCiclo = maestra2Service.listarPorCodigoTabla("ciclo",1);
				System.out.println("ciclos 456");
				System.out.println(lstCiclo);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		mav.addObject("lstCiclo",lstCiclo);
		mav.addObject("lstPeriodo",lstPeriodo); 
		mav.addObject("lstSituacion",lstSituacion); 
	} 
	
	private void cargarCombosInstitucion(ModelAndView mav, HttpServletRequest request){
		InstitucionBean inst = new InstitucionBean();
		UsuarioBean prmUsuario = this.getUsuarioSesion(request);
		lstInstitucionBean = new ArrayList<InstitucionBean>();
		try {
			if(!VO.isNull(prmUsuario)){
				lstInstitucionBean = (List<InstitucionBean>) this.fs.getInstitucionService().listarInstitucionxTipoUsuario(prmUsuario);
			}else{
				lstInstitucionBean = institucionService.getListarCombo(inst);
			} 
		} catch (Exception e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}	
  
		mav.addObject("lstInstitucionBean",lstInstitucionBean); 
	} 
	
	private void cargarCombosLengua(ModelAndView mav){

		LenguaBean lenguaBean = new LenguaBean();
		try {
			lstLenguaBean = (List<LenguaBean>) this.lenguaService.getBuscarPorFiltros(lenguaBean);
			System.out.println("lstLenguaBean "+lstLenguaBean.size());
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}
  
		mav.addObject("lstLenguaBean",lstLenguaBean); 
	} 
	
	
	private void cargarInscripcionXLengua(ModelAndView mav, int codigoMat){
		InscripcionLenguaBean matAlum = new InscripcionLenguaBean();
		matAlum.getInscripcionBean().setCodigo(codigoMat);
		System.out.println("cargarInscripcionXLengua codigoMatcodigoMatcodigoMat " + codigoMat);
		List<InscripcionLenguaBean>	lstInscripcionLenguaBean=null;
		
		
			try {
				lstInscripcionLenguaBean = inscripcionLenguaService.getBuscarPorFiltros(matAlum);
				if (VO.isNotEmptyList(lstInscripcionLenguaBean)) {
					System.out.println(" lstInscripcionLenguaBean.size "+ lstInscripcionLenguaBean.size());
				}
				
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		


		
		mav.addObject("lstInscripcionLenguaBean",lstInscripcionLenguaBean); 
	
	} 
	
	private void listarDetalleDocumInscri(ModelAndView mav, int codigoInsc){
		DocumentoInscripcionBean prmDocumentoInscripcionBean = new DocumentoInscripcionBean();
		prmDocumentoInscripcionBean.getInscripcion().setCodigo(codigoInsc);
		System.out.println("codigoInsc " + codigoInsc);
		List<DocumentoInscripcionBean>	lstDocumentoInscripcionBean=null;
		
		this.cargarCombos(mav);
		
			try {
				lstDocumentoInscripcionBean = documentoInscripcionService.listarDocumentoInscripcionBeanxCodInsc(prmDocumentoInscripcionBean);
				if (VO.isNotEmptyList(lstDocumentoInscripcionBean)) {
					System.out.println(" lstDocumentoInscripcionBean.size "+ lstDocumentoInscripcionBean.size());
				}
				
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		


		
		mav.addObject("lstDocumentoInscripcionBean",lstDocumentoInscripcionBean); 
	
	} 
	
	
//	protected void setAuditoria(BaseBean baseBean,HttpServletRequest request,boolean swInsert){
//		UsuarioBean usuario= (UsuarioBean) request.getSession().getAttribute("usuarioBean");
//		long idUsuario=usuario.getCodigo();	
//		//System.out.println("strIdUsuario "+strIdUsuario);
//		this.setAuditoriaLocal(baseBean, idUsuario, request, swInsert);		
//	}
//	private void setAuditoriaLocal(BaseBean baseBean,long iddUsuario,HttpServletRequest request,boolean swInsert){
//		if (swInsert) {
//			baseBean.setCodigoUsuarioCreacion(iddUsuario);
//			baseBean.setIpCreacion(NetUtil.getClientIpAddr(request));			
//			
//		} else {
//			baseBean.setCodigoUsuarioModificacion(iddUsuario);
//			baseBean.setIpModificacion(NetUtil.getClientIpAddr(request));			
//		}
//
//	}

		
//		private static final Logger logger = LoggerFactory
//				.getLogger(InscripcionController.class);
		
		@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
		@ResponseBody
		public String uploadFileHandler(@RequestParam("name") String name,
				@RequestParam("file") MultipartFile file) {

			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = "C:/ruta/";
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

//					logger.info("Server File Location="
//							+ serverFile.getAbsolutePath());

					return "You successfully uploaded file=" + name;
				} catch (Exception e) {
					return "You failed to upload " + name + " => " + e.getMessage();
				}
			} else {
				return "You failed to upload " + name
						+ " because the file was empty.";
			}
		}
		
		@RequestMapping(value = "/lenguaCargarModal", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView doLenguaCargarModal(@RequestParam("codigoinst") Integer codigoinst,@RequestParam("codPerio") String codPerio,@RequestParam("codCiclo") Integer codCiclo) {
			
			System.out.println("codigoinst " + codigoinst);	
			System.out.println("codPerio " + codPerio);	
			System.out.println("codCiclo " + codCiclo);	

			InstitucionBean inscripcionaBean = new InstitucionBean();
			inscripcionaBean.setCodigo(codigoinst);
			inscripcionaBean.getTipoActividad().setValor1(String.valueOf(codPerio));
			inscripcionaBean.getTipoActividad().setCodigoRegistro(codCiclo);
			
			try {
				
				//System.out.println("carga itd");
				//System.out.println(lenguaService.listarComboxInstitucion(inscripcionaBean));
				lstlenguaBeanCombo = lenguaService.listarComboxInstitucion(inscripcionaBean);		
				
				lstNivel  = maestra2Service.listarPorCodigoTabla("nivel",1);
						
				if (VO.isNotEmptyList(lstlenguaBeanCombo)) {
					System.out.println("lstlenguaBeanCombo.size() " +lstlenguaBeanCombo.size());
				}
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			swcod="0";
			ModelAndView mav = new ModelAndView("../layout/inscripcion-lengua-registro-modal-view", "command", new InscripcionLenguaBean());
			System.out.println("InscripcionLenguaBean itd");
			System.out.println(new InscripcionLenguaBean());
			mav.addObject("inscripcionLenguaBean", new InscripcionLenguaBean());
			mav.addObject("lstlenguaBeanCombo", lstlenguaBeanCombo);
			mav.addObject("swcod", swcod);
			mav.addObject("lstnivelbean",lstNivel);
			
			return mav;
		}
	

		@RequestMapping(value = "/agregarlengua", method = RequestMethod.POST)
		@ResponseBody
		public String doAgregarlengua(@RequestParam("numCupos") String numCupos,@RequestParam("codigolengua") Integer codigolengua,@RequestParam("codigoinscri") Integer codigoinscri,@RequestParam("codigonivel") Integer codigonivel,HttpServletRequest request) {
			
			Encrypt.init("KEY_ENCRYPT_PASS");
			int cupos=Integer.valueOf(numCupos);
			//int cupos=100000;
			if( cupos >=1000) {
				return "10";
			}
			
			int cuposnuevos   = 0;
			int cuposantiguos = 0;
			
			
			if(codigonivel==1){
				cuposnuevos =Integer.valueOf(numCupos);
			}
			if(codigonivel!=1){
				cuposantiguos =Integer.valueOf(numCupos);
			}
			String cant="";
			System.out.println("-------------------------agregarlengua-------------------------");
			System.out.println("numCupos " + numCupos);		
			System.out.println("codigolengua " + codigolengua);
			System.out.println("codigonivel "+ codigonivel);
			System.out.println("inscripcionaBean.getCodigo() agregarlengua " + codigoinscri);
			
			
		if (swcod == "0") {
			 inscripcionLenguaBean = new InscripcionLenguaBean();
		}
		InscripcionLenguaBean insLen = new InscripcionLenguaBean();
			
			insLen.setNumeroCuposInsc(numCupos);
			insLen.getLenguainscr().setCodigo(codigolengua);
			insLen.getInscripcionBean().setCodigo(codigoinscri);
			insLen.getNivel().setCodigoRegistro(codigonivel);
		
			System.out.println("inscripcionLenguaBean.getCodigo() ins " + inscripcionLenguaBean.getCodigo());
			boolean sw = false;
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("InscripcionController/agregarlengua");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	try {
						if (inscripcionLenguaBean.getCodigo()==0) {
									System.out.println("insert agregarlengua");
									this.setAuditoria(insLen, request, true);
							sw =  (this.inscripcionLenguaService.insertar(insLen)); 
							cant="1";
							
							if(sw){
								
								
								
								UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
								usuarioMatriculaBean.getInscripcionLenguaBean().setCodigo(insLen.getCodigo());
								usuarioMatriculaBean.getSituacion().setCodigoRegistro(2);
//								usuarioMatriculaBean.setAudCodigoUsuario(1);
//								usuarioMatriculaBean.setAudHostIP("192.168.1.1");
								usuarioMatriculaBean.setUsuarioBean(new UsuarioBean());
								usuarioMatriculaBean.getUsuarioBean().setPasswordUsuario(Encrypt.encrypt("123456"));
								if(codigonivel==1){
									
									if(numCupos!=null && numCupos!="" ){
										
										for(int i=0;i<Integer.valueOf(cuposnuevos);i++){
											usuarioMatriculaBean.getTipoCupo().setCodigoRegistro(1);
											this.setAuditoria(usuarioMatriculaBean, request, true);
											usuarioMatriculaService.insertar(usuarioMatriculaBean);
											
										}
										
											for(int i=0;i<Integer.valueOf(cuposantiguos);i++){
												usuarioMatriculaBean.getTipoCupo().setCodigoRegistro(2);
												this.setAuditoria(usuarioMatriculaBean, request, true);
											usuarioMatriculaService.insertar(usuarioMatriculaBean);
											
										}
									}
									
								}else{
									
									
									if(numCupos!=null && numCupos!="" ){
										
									
										
											for(int i=0;i<Integer.valueOf(cuposantiguos);i++){
												usuarioMatriculaBean.getTipoCupo().setCodigoRegistro(2);
												this.setAuditoria(usuarioMatriculaBean, request, true);
											usuarioMatriculaService.insertar(usuarioMatriculaBean);
											
										}
									}
									
									
								}
							
								
								
							}
							
						} else {
							
							
							
							
//							System.out.println("actualizar");
//							System.out.println("actualizasar agregarlengua");
//							System.out.println("insLen.getCodigo() "+ insLen.getCodigo());
//							insLen.setCodigo(inscripcionLenguaBean.getCodigo());
//							List<MatriculaAlumnoBean> lstMatriculaAlumnoBean = null;
//							lstMatriculaAlumnoBean =  matriculaAlumnoService.validarMatriculaAlumnoXInscrLengua(insLen);
//							
//							if(lstMatriculaAlumnoBean==null){
//							
//								
//								InscripcionLenguaBean inscripcionLenguaBean =new InscripcionLenguaBean();
//								
//								inscripcionLenguaBean=inscripcionLenguaService.getBuscarPorObjecto(insLen);
//								
//								UsuarioMatriculaBean usuAlumnosNuevos = new UsuarioMatriculaBean();
//								usuAlumnosNuevos.setInscripcionLenguaBean(inscripcionLenguaBean);
//								usuAlumnosNuevos.getTipoCupo().setCodigoRegistro(1);
//								List<UsuarioMatriculaBean>lstUsuAlumnosNuevos = null;
//								lstUsuAlumnosNuevos = usuarioMatriculaService.buscarXTipoCuposXinscrLengua(usuAlumnosNuevos);
//								
//								if(lstUsuAlumnosNuevos==null){
//									lstUsuAlumnosNuevos = new ArrayList<UsuarioMatriculaBean>();
//								}
//								int numeroCuposAlumnosNuevos =lstUsuAlumnosNuevos.size();
//								
//								if(numeroCuposAlumnosNuevos!=cuposnuevos){
//									
//										if(cuposnuevos>numeroCuposAlumnosNuevos){
//											
//											int anadircuposNuevos =	cuposnuevos -numeroCuposAlumnosNuevos  ;
//										
//											for(int i =0;i<anadircuposNuevos;i++){
//												
//												
//												/*******************************/
//								
//												UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
//												usuarioMatriculaBean.getInscripcionLenguaBean().setCodigo(insLen.getCodigo());
//												usuarioMatriculaBean.getSituacion().setCodigoRegistro(2);
////												usuarioMatriculaBean.setAudCodigoUsuario(1);
////												usuarioMatriculaBean.setAudHostIP("192.168.1.1");
//												
//												if(codigonivel==1){
//													
//													
//															usuarioMatriculaBean.getTipoCupo().setCodigoRegistro(1);
//															this.setAuditoria(usuarioMatriculaBean, request, true);
//															usuarioMatriculaService.insertar(usuarioMatriculaBean);
//														
//												}
//											
//												
//												/**************************/
//												
//											}
//											
//										}else{
//											
//											int eliminarcuposNuevos =	numeroCuposAlumnosNuevos - cuposnuevos;
//										
//											for(int i =0;i<eliminarcuposNuevos;i++){
//										
//												/*******************************/
//								
//												if(codigonivel==1){
//																this.setAuditoria(lstUsuAlumnosNuevos.get(i), request, false);
//															usuarioMatriculaService.eliminar(lstUsuAlumnosNuevos.get(i));
//														
//												}
//											
//												
//												/**************************/
//												
//											}
//											
//										}
//										
//							
//								
//								}
//								else{
//									cant="4";
//								}
//								
//								
//								
//								
//								
//								
//								
//								
//								
//								
//								UsuarioMatriculaBean usuAlumnosMatriculados = new UsuarioMatriculaBean();
//								usuAlumnosMatriculados.setInscripcionLenguaBean(inscripcionLenguaBean);
//								usuAlumnosMatriculados.getTipoCupo().setCodigoRegistro(2);
//								List<UsuarioMatriculaBean>lstUsuAlumnosMatriculados = null;
//								lstUsuAlumnosMatriculados = usuarioMatriculaService.buscarXTipoCuposXinscrLengua(usuAlumnosMatriculados);
//								
//								if(lstUsuAlumnosMatriculados==null){
//									lstUsuAlumnosMatriculados= new ArrayList<UsuarioMatriculaBean>();
//								}
//								int numeroCuposAlumnosMatriculados =lstUsuAlumnosMatriculados.size();
//								if(numeroCuposAlumnosMatriculados!=cuposantiguos){
//									
//									
//									
//									
//									if(cuposantiguos>numeroCuposAlumnosMatriculados){
//										
//										UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
//										usuarioMatriculaBean.getInscripcionLenguaBean().setCodigo(insLen.getCodigo());
//										usuarioMatriculaBean.getSituacion().setCodigoRegistro(2);
////										usuarioMatriculaBean.setAudCodigoUsuario(1);
////										usuarioMatriculaBean.setAudHostIP("192.168.1.1");
//										int anadirCuposAlumnosMatriculados= cuposantiguos - numeroCuposAlumnosMatriculados;
//										
//										for(int i = 0; i<anadirCuposAlumnosMatriculados;i++){
//											
//											usuarioMatriculaBean.getTipoCupo().setCodigoRegistro(2);
//											this.setAuditoria(usuarioMatriculaBean, request, true);
//											usuarioMatriculaService.insertar(usuarioMatriculaBean);
//											
//										}
//									}else{
//										
//										int eliminarCuposAlumnosMatriculados = numeroCuposAlumnosMatriculados - cuposantiguos;
//										
//										
//											for(int i = 0; i<eliminarCuposAlumnosMatriculados;i++){
//											
//												this.setAuditoria(lstUsuAlumnosMatriculados.get(i), request, false);
//											usuarioMatriculaService.eliminar(lstUsuAlumnosMatriculados.get(i));
//											
//										}
//										
//										
//									}
//									
//									
//									
//									
//									
//															
//								}else{
//									cant="4";
//								}
//								
//								
//							
//								this.setAuditoria(insLen, request, false);
//								sw = (this.inscripcionLenguaService.actualizar(insLen));	
//								cant="2";
//							
////								
////								if(insLen.getNumeroCuposInsc()!=inscripcionLenguaBean.getNumeroCuposInsc()){
////									
////									
////									
////									
////									if(Integer.valueOf(insLen.getNumeroCuposInsc())<Integer.valueOf(inscripcionLenguaBean.getNumeroCuposInsc())){
////										
////										
////										UsuarioMatriculaBean usumateliminar = new UsuarioMatriculaBean();
////										
////										InscripcionBean inscripcionBean = new InscripcionBean();
////										inscripcionBean.setCodigo(codigoinscri);
////										inscripcionBean = inscripcionService.getBuscarPorObjecto(inscripcionBean);
////										
////										usumateliminar.getInscripcionLenguaBean().getInscripcionBean().setCodigo(inscripcionBean.getCodigo());
////										usumateliminar.getInscripcionLenguaBean().getInscripcionBean().getInstitucion().setCodigo(inscripcionBean.getInstitucion().getCodigo());
////										usumateliminar.setInscripcionLenguaBean(insLen);
////										
////										
////										List<UsuarioMatriculaBean> lstUsuarioMatriculaBean =null;
////										lstUsuarioMatriculaBean = usuarioMatriculaService.getBuscarPorFiltros(usumateliminar);
////										
////										if(lstUsuarioMatriculaBean == null){
////											
////											int numCuposact = Integer.valueOf(inscripcionLenguaBean.getNumeroCuposInsc())-Integer.valueOf(insLen.getNumeroCuposInsc());
////											
////											
////											for(int i=0;i<numCuposact;i++){
////												usuarioMatriculaService.eliminar(lstUsuarioMatriculaBean.get(0));
////												
////											}
////											
////											
////										}
////										
////										
////									}else{
////										
		////
////										
////										
////										UsuarioMatriculaBean usuMateAgregar = new UsuarioMatriculaBean();
////										
////										
////										usuMateAgregar.setInscripcionLenguaBean(insLen);
////										usuMateAgregar.getSituacion().setCodigoRegistro(2);
////										
////											int numCuposact = Integer.valueOf(insLen.getNumeroCuposInsc()) - Integer.valueOf(inscripcionLenguaBean.getNumeroCuposInsc());
////											
////											
////											for(int i=0;i<numCuposact;i++){
////												usuarioMatriculaService.insertar(usuMateAgregar);
////												
////											}
////											
		////
////										
////										
////									}
		////
////									
////									
////									
////								
////									
////									
////									
////									
////								}else{
////									cant="4";
////								}
		//
//								
//								
//								
//							}else{
//								cant="3";
//							}
//							
		//
//							
//							
							
							
						}

					} catch (Exception e) { 
						return "0";
					}
		        }
			} catch (Exception e) {
				// TODO: handle exception
				return "0";
			}	
		
			if (sw) {
				if (cant=="1") {
					System.out.println("cant 1 " + cant);
					return "1";
				}else if (cant=="2"){
					System.out.println("cant 2 " + cant);
					return "2";
					
				}else if (cant=="3"){
					System.out.println("cant 3 " + cant);
					return "3";
					
				}else if (cant=="4"){
					System.out.println("cant 4 " + cant);
					return "4";
					
				}else {
					System.out.println("cant 0 " + cant);
					return "0";
				}
				
			} else {
				return "0";
			}
		
			

		}
		
		@RequestMapping(value = "/agregarmaslengua", method = RequestMethod.POST)
		@ResponseBody
		public String doAgregarmaslengua(@RequestParam("codinslen") Integer codinslen,@RequestParam("numCupos") String numCupos,@RequestParam("numCupostot") String numCupostot,HttpServletRequest request) {//,@RequestParam("codigonivel") Integer codigonivel,
			
			Encrypt.init("KEY_ENCRYPT_PASS");
			int cuposnuevos   = 0;
			int cuposantiguos = 0;
			
//			if(codigonivel==1){
//				cuposnuevos =Integer.valueOf(numCupos);
//			}
//			if(codigonivel!=1){
//				cuposantiguos =Integer.valueOf(numCupos);
//			}
			String cant="";
			System.out.println("actualizar");
			System.out.println("actualizasar agregarlengua");
			System.out.println("numCupostot " + numCupostot);
			System.out.println("numCupos " + numCupos);
			InscripcionLenguaBean insLen = new InscripcionLenguaBean();
			insLen.setNumeroCuposInsc(numCupostot);
			insLen.setCodigo(codinslen);
			System.out.println("insLen.getCodigo() "+ insLen.getCodigo());
			System.out.println("inscripcionLenguaBean.getCodigo() ins " + inscripcionLenguaBean.getCodigo());
			boolean sw = false;
			
			int cupos=Integer.valueOf(numCupos);
			//int cupos=100000;
			if( cupos >=1000) {
				return "10";
			}
			
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("InscripcionController/agregarmaslengua");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	try {
		    			if(insLen.getNumeroCuposInsc()!=null&&insLen.getNumeroCuposInsc()!="") {
		    				System.out.println("insert agregarlengua agregarmaslengua");
		    				this.setAuditoria(insLen, request, true);
		    				sw =  (this.inscripcionLenguaService.updatenumcupos(insLen)); 
		    				
		    				
		    				if(sw){
		    					System.out.println("numCupos...." +numCupos);
		    					System.out.println("entro detalle agregarmaslengua");
		    					cant="1";
		    					
		    					
		    					UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
		    					usuarioMatriculaBean.getInscripcionLenguaBean().setCodigo(insLen.getCodigo());
		    					usuarioMatriculaBean.getSituacion().setCodigoRegistro(2);
		    					//				usuarioMatriculaBean.setAudCodigoUsuario(1);
		    					//				usuarioMatriculaBean.setAudHostIP("192.168.1.1");
		    					usuarioMatriculaBean.setUsuarioBean(new UsuarioBean());
		    					usuarioMatriculaBean.getUsuarioBean().setPasswordUsuario(Encrypt.encrypt("123456"));
		    					//				if(codigonivel==1){
		    					
		    					if(numCupos!=null && numCupos!="" ){
		    						
		    						for(int i=0;i<Integer.valueOf(numCupos);i++){
		    							usuarioMatriculaBean.getTipoCupo().setCodigoRegistro(1);
		    							this.setAuditoria(usuarioMatriculaBean, request, true);
		    							usuarioMatriculaService.insertar(usuarioMatriculaBean);
		    							
		    						}
		    						
		    						//							for(int i=0;i<Integer.valueOf(cuposantiguos);i++){
		    						//								usuarioMatriculaBean.getTipoCupo().setCodigoRegistro(2);
		    						//								this.setAuditoria(usuarioMatriculaBean, request, true);
		    						//							usuarioMatriculaService.insertar(usuarioMatriculaBean);
		    						//							
		    						//						}
		    					}
		    					
		    				}
		    				
		    			}
					} catch (Exception e) { 
						cant="0";
						return "0";
					}
		        }
			} catch (Exception e) {
				// TODO: handle exception
				cant="0";
				return "0";
			}
			
			return cant;
		}
		
		
		
		@RequestMapping(value = "/recargarListadoxInscripcion", method = RequestMethod.GET)
		public ModelAndView recargarListadoxInscripcion(@RequestParam("codigo") Integer codigo) {

			System.out.println("codigo recargarListadoxInscripcion " + codigo);
			
			ModelAndView mav = new ModelAndView("academico/listado-detalle-inscripcion");
		
			cargarInscripcionXLengua(mav,codigo);
			return mav;
		}
		
		@RequestMapping(value = "/recargarListadoDetalleDocumentoInscripcion", method = RequestMethod.GET)
		public ModelAndView recargarListadoDetalleDocumentoInscripcion(@RequestParam("codigo") Integer codigo) {

			System.out.println("recargarListadoDetalleDocumentoInscripcion codigo " + codigo);
			
			ModelAndView mav = new ModelAndView("academico/listado-detalle-documento-inscripcion");
		
			listarDetalleDocumInscri(mav,codigo);
			return mav;
		}
		
		@RequestMapping(value = "/modificarInscripcionxLengua", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView doModificarInscripcionxLengua(@RequestParam("codigo") Integer codigo,@RequestParam("codigoinst") Integer codigoinst,@RequestParam("tipo") Integer tipo) {

			System.out.println("codigo " + codigo);
			System.out.println("codigoinst " + codigoinst);
			InstitucionBean inscripcionaBean = new InstitucionBean();
			inscripcionaBean.setCodigo(codigoinst);
			List<LenguaBean> lstlenguaBean = new ArrayList<LenguaBean>();
			List<MaestraBean> lstnivelbean = new ArrayList<MaestraBean>();
		/*	try {
				lstlenguaBeanCombo = lenguaService.listarComboxInstitucion(inscripcionaBean);
				if (VO.isNotEmptyList(lstlenguaBeanCombo)) {
					System.out.println("lstlenguaBeanCombo.size() " +lstlenguaBeanCombo.size());
				}
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			InscripcionLenguaBean inle =  new InscripcionLenguaBean();
			inle.setCodigo(codigo);
			try {
				lstNivel  = maestra2Service.listarPorCodigoTabla("nivel",1);
				inle= inscripcionLenguaService.getBuscarPorObjecto(inle);
				
				LenguaBean oLengua= lenguaService.getBuscarPorObjecto(inle.getLenguainscr());
				System.out.println("inle.getLenguainscr() " + inle.getLenguainscr().getCodigo());
				
				System.out.println(oLengua.getNombre());
				lstlenguaBean.add(oLengua);
				lstnivelbean.add(inle.getNivel());
				
				
				setInscripcionLenguaBean(inle);
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			swcod="1";
			System.out.println("inscripcionLenguaBean.getCodigo() mod " + inscripcionLenguaBean.getCodigo());
			ModelAndView mav;
			if (tipo==1) {
				 mav = new ModelAndView("../layout/inscripcion-lengua-registro-modal-view", "command", inscripcionLenguaBean);
			}else {
				mav = new ModelAndView("../layout/inscripcion-plus-lengua-registro-modal-view", "command", inscripcionLenguaBean);
			}
			
			mav.addObject("inscripcionLenguaBean", inscripcionLenguaBean);
			mav.addObject("lstlenguaBeanCombo", lstlenguaBean);
			mav.addObject("swcod", swcod);
			mav.addObject("lstnivelbean",lstnivelbean);
			return mav;
		}
	
		@RequestMapping(value ="/eliminarInscripcionxLengua", method = RequestMethod.POST)
		@ResponseBody
		public String eliminarInscripcionxLengua(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
			boolean sw=false;
			inscripcionLenguaBean= new InscripcionLenguaBean();
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("InscripcionController/eliminarInscripcionxLengua");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	inscripcionLenguaBean.setCodigo(codigo);
					System.out.println("codigocodigocodigo eliminar " + codigo);
					try { 
						this.setAuditoria(inscripcionLenguaBean, request, false);
					sw =  (this.inscripcionLenguaService.eliminar(inscripcionLenguaBean));  
					
					} catch (Exception e) { 
						e.printStackTrace();
					} 	
		        }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
				
			if (sw) {
				inscripcionLenguaBean.setCodigo(0);
				return "1";		
			}else {
				return "0";
			}
			
		}
		
		@RequestMapping(value ="/eliminarDetalleDocumentoInscripcion", method = RequestMethod.POST)
		@ResponseBody
		public String doeliminarDetalleDocumentoInscripcion(@RequestParam("codigo")Integer codigo,@RequestParam("nombArch")String nombArch,HttpServletRequest request){
			boolean sw=false;
			documentoInscripcionBean= new DocumentoInscripcionBean();
			
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("InscripcionController/eliminarDetalleDocumentoInscripcion");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	documentoInscripcionBean.setCodigo(codigo);
		 			System.out.println("codigo eliminarDetalleDocumentoInscripcion " + codigo);
		 			System.out.println("nombArch " +nombArch);
		 			try { 
						this.setAuditoria(documentoInscripcionBean, request, false);
					sw =  (this.documentoInscripcionService.eliminar(documentoInscripcionBean));  
					
					} catch (Exception e) { 
						e.printStackTrace();
					} 	
		        }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
				
			if (sw) {
				documentoInscripcionBean.setCodigo(0);
				eliminarArchivo(getRootPath(), nombArch);
				return "1";		
			}else {
				return "0";
			}
			
		}
	
		@RequestMapping(value = "/cargarNivelesIns", method = RequestMethod.GET)
		public @ResponseBody List<MaestraBean> cargarNiveles(@RequestParam("codlengua") String codigo)throws Exception {
		
			List<MaestraBean> lista_response = new ArrayList<MaestraBean>();
			if (!codigo.equals("0")){
				LenguaBean filtro = new LenguaBean();
				filtro.setCodigo(VO.toLong(codigo));
				List<LenguaEstructuraBean> lstLenguaEstructuraBeanNivel = lenguaEstructuraService.listarNiveles(filtro);
			
				if(!VO.isEmptyList(lstLenguaEstructuraBeanNivel)){
					for (LenguaEstructuraBean objLenEstNivel : lstLenguaEstructuraBeanNivel) {
						if(!VO.isEmptyList(lstNivel)){
							for (MaestraBean objMaestroNivel : lstNivel) {
								if(objMaestroNivel.getCodigoRegistro() == objLenEstNivel.getNivel().getCodigoRegistro()){
									lista_response.add(objMaestroNivel);
									break;
								}
							}
						}
					}
				}
			}
			return lista_response;
		}	
		
	public InscripcionService getInscripcionService() {
		return inscripcionService;
	}

	public void setInscripcionService(InscripcionService inscripcionService) {
		this.inscripcionService = inscripcionService;
	}

	public InscripcionBean getInscripcionaBean() {
		return inscripcionaBean;
	}

	public void setInscripcionaBean(InscripcionBean inscripcionaBean) {
		this.inscripcionaBean = inscripcionaBean;
	}

	public List<InscripcionBean> getLstInscripcionBean() {
		return lstInscripcionBean;
	}

	public void setLstInscripcionBean(List<InscripcionBean> lstInscripcionBean) {
		this.lstInscripcionBean = lstInscripcionBean;
	}
	
	 public void setValoresPredeterminados(InscripcionBean inscripcionaBean){
		 inscripcionaBean.getInstitucion().setCodigo(0); 
		 inscripcionaBean.getSituacion().setCodigoRegistro(0);
	    }

	public List<MaestraBean> getLstSituacion() {
		return lstSituacion;
	}

	public void setLstSituacion(List<MaestraBean> lstSituacion) {
		this.lstSituacion = lstSituacion;
	}

	public List<InstitucionBean> getLstInstitucionBean() {
		return lstInstitucionBean;
	}

	public void setLstInstitucionBean(List<InstitucionBean> lstInstitucionBean) {
		this.lstInstitucionBean = lstInstitucionBean;
	}

	public List<LenguaBean> getLstLenguaBean() {
		return lstLenguaBean;
	}

	public void setLstLenguaBean(List<LenguaBean> lstLenguaBean) {
		this.lstLenguaBean = lstLenguaBean;
	}

	public List<MaestraBean> getLstPeriodo() {
		return lstPeriodo;
	}

	public void setLstPeriodo(List<MaestraBean> lstPeriodo) {
		this.lstPeriodo = lstPeriodo;
	}

	public List<MaestraBean> getLstCiclo() {
		return lstCiclo;
	}

	public void setLstCiclo(List<MaestraBean> lstCiclo) {
		this.lstCiclo = lstCiclo;
	}


	public List<LenguaBean> getLstlenguaBeanCombo() {
		return lstlenguaBeanCombo;
	}

	public void setLstlenguaBeanCombo(List<LenguaBean> lstlenguaBeanCombo) {
		this.lstlenguaBeanCombo = lstlenguaBeanCombo;
	}

	public InscripcionForm getInscripcionForm() {
		return inscripcionForm;
	}

	public void setInscripcionForm(InscripcionForm inscripcionForm) {
		this.inscripcionForm = inscripcionForm;
	}

	public InscripcionLenguaBean getInscripcionLenguaBean() {
		return inscripcionLenguaBean;
	}

	public void setInscripcionLenguaBean(InscripcionLenguaBean inscripcionLenguaBean) {
		this.inscripcionLenguaBean = inscripcionLenguaBean;
	}

	public DocumentoInscripcionBean getDocumentoInscripcionBean() {
		return documentoInscripcionBean;
	}

	public void setDocumentoInscripcionBean(DocumentoInscripcionBean documentoInscripcionBean) {
		this.documentoInscripcionBean = documentoInscripcionBean;
	}


 

}
