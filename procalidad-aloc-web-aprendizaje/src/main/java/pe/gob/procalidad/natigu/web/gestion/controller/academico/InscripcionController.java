/*package pe.gob.procalidad.natigu.web.gestion.controller.academico;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionDirectorBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.DocenteService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionLenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.MatriculaAlumnoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.UsuarioMatriculaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;
import pe.gob.procalidad.natigu.web.gestion.controller.academico.view.InscripcionForm;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.controller.general.view.InstitucionForm;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.NetUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
 
@Controller
@RequestMapping(value = "inscripcionController")
public class InscripcionController extends BaseController {
	
	private InscripcionForm			inscripcionForm;
	private InscripcionBean 		inscripcionaBean;
	private InscripcionLenguaBean	inscripcionLenguaBean;
	private List<InscripcionBean> 	lstInscripcionBean;
	
	private List<MaestraBean>		lstSituacion;
	private List<MaestraBean>		lstPeriodo;
	private List<MaestraBean>		lstCiclo;

	
	private List<InstitucionBean>	lstInstitucionBean;
	
	private List<LenguaBean> 		lstLenguaBean; 
	
	
	
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
	private InscripcionLenguaService 	inscripcionLenguaService;
	

	
	
	*//***************************************//*

	
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
	private List<DocenteBean> 	lstDocenteBean;
	

	private List<LenguaBean> 	lstlenguaBeanCombo;
	
	
	@Autowired
	private Maestra1Service maestra1Service;
	
	@Autowired
	private DocenteService docenteService;
	
	@Autowired 
	private PersonaService personaService;
	*//******************************************//*
	
	public InscripcionController (){
		
	}
	
	@PostConstruct
	public void init(){
		this.setInscripcionaBean(new InscripcionBean());
		this.setLstInscripcionBean(new ArrayList<InscripcionBean>());
		this.setInscripcionForm(new InscripcionForm());
		this.setInscripcionLenguaBean(new InscripcionLenguaBean());
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("inscripcionBean") InscripcionBean inscripcionBean)throws Exception {
		//this.setValoresPredeterminados(new InscripcionBean());
		InscripcionBean prmInscripcionBean = new InscripcionBean();
		System.out.println("inscripcionBean.getCodigo() " + inscripcionBean.getInstitucion().getCodigo());
		System.out.println("inscripcionBean.getSituacion().getCodigoRegistro() " + inscripcionBean.getSituacion().getCodigoRegistro());
		prmInscripcionBean.getInstitucion().setCodigo(inscripcionBean.getCodigo());
		prmInscripcionBean.getSituacion().setCodigoRegistro(inscripcionBean.getSituacion().getCodigoRegistro());
		return this.getLista(prmInscripcionBean);
	}
	  
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("inscripcionBean") InscripcionBean inscripcionBean)
			throws Exception {
		//this.setValoresPredeterminados(new InscripcionBean());
		InscripcionBean prmInscripcionBean = new InscripcionBean();
		System.out.println("inscripcionBean.getCodigo() " + inscripcionBean.getInstitucion().getCodigo());
		System.out.println("inscripcionBean.getSituacion().getCodigoRegistro() " + inscripcionBean.getSituacion().getCodigoRegistro());
		prmInscripcionBean.getInstitucion().setCodigo(inscripcionBean.getInstitucion().getCodigo());
		prmInscripcionBean.getSituacion().setCodigoRegistro(inscripcionBean.getSituacion().getCodigoRegistro());
		return this.getLista(prmInscripcionBean);
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",new InscripcionForm());//new InscripcionBean()
		
		*//*****************************************************************//*
//		docenteBean = new DocenteBean();
//		try {
//			lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarPorFiltros(docenteBean);
//			System.out.println("lstDocenteBean "+lstDocenteBean.size());
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		*//********************************************************************//*

		mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("lstPeriodo",lstPeriodo); 
		mav.addObject("lstInstitucionBean",lstInstitucionBean);
		mav.addObject("lstLenguaBean",lstLenguaBean);
		mav.addObject("lstCiclo",lstCiclo);
		mav.addObject("inscripcionBean", new InscripcionBean());
		mav.addObject("inscripcionLenguaBean", new InscripcionLenguaBean());
//		mav.addObject("lstDocenteBean", lstDocenteBean);
		
//		mav.addObject("docenteBean", new DocenteBean());
		this.cargarCombosDocente(mav);
		return mav;
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {

		System.out.println("codigo " + codigo);

		InscripcionBean prmInscripcionBean = new InscripcionBean();
		prmInscripcionBean.setCodigo(codigo);
		try {
			inscripcionaBean = this.getInscripcionService().getBuscarPorObjecto(prmInscripcionBean);
			inscripcionForm.setInscripcionBean(inscripcionaBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		System.out.println("modificar lenguaBean: " + inscripcionaBean);
		ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",inscripcionForm);
		mav.addObject("inscripcionForm", inscripcionForm);
		this.cargarCombos(mav);
		this.cargarCombosInstitucion(mav);
		this.cargarCombosLengua(mav);
		System.out.println("inscripcionForm.getInscripcionBean().getCodigo() " + inscripcionForm.getInscripcionBean().getCodigo());
		cargarInscripcionXLengua(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
		return mav;
	}
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		inscripcionaBean= new InscripcionBean();
		inscripcionaBean.setCodigo(codigo);
		System.out.println("codigocodigocodigo eliminar " + codigo);
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
				sw =  (this.getInscripcionService().eliminar(inscripcionaBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		inscripcionaBean.setCodigo(0);
		this.setValoresPredeterminados(inscripcionaBean);
		ModelAndView mav = this.getLista(inscripcionaBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}

	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView doGrabar(@ModelAttribute("inscripcionForm") InscripcionForm inscripcionForm,@RequestParam("file") MultipartFile file) {
		
		System.out.println("inscripcionBean "+inscripcionForm);
		System.out.println("inscripcionBean.getCodigo() "+inscripcionForm.getInscripcionBean().getCodigo());
		boolean sw = false;
		try {
			if (inscripcionForm.getInscripcionBean().getCodigo()==0) {
				String ruta="";
				String nombreDoc="";
				if (!file.isEmpty()) {
					try {
						byte[] bytes = file.getBytes();
						System.out.println("file.getName() "+ file.getName());
						System.out.println("file.getOriginalFilename() "+ file.getOriginalFilename());
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

//						logger.info("Server File Location="
//								+ serverFile.getAbsolutePath());
						ruta=String.valueOf(serverFile);
						nombreDoc=file.getOriginalFilename();
						System.out.println("serverFile " +serverFile);
						System.out.println("file.getName() "+ file.getName());
						System.out.println("You successfully uploaded file=" +file.getOriginalFilename()); 
					} catch (Exception e) {
						 e.getMessage();
					}
				} else {
					System.out.println("You failed to upload " + file.getOriginalFilename()+ " because the file was empty.");
					
				}
				System.out.println("insertar ");
				inscripcionForm.getInscripcionBean().setNombreDocumento(nombreDoc);
				
				inscripcionForm.getInscripcionBean().setRutaDocumento(ruta);
				sw =  (this.getInscripcionService().insertar(inscripcionForm.getInscripcionBean())); 
			
		
				
				
				
			} else {
				System.out.println("actualizar ");
				if (file.isEmpty()) {
						System.out.println("no paso");
				}else {
					System.out.println("inscripcionForm.getInscripcionBean().getRutaDocumento() " + inscripcionForm.getInscripcionBean().getRutaDocumento());
					inscripcionForm.getInscripcionBean().setRutaDocumento(inscripcionForm.getInscripcionBean().getRutaDocumento());
				}
				sw = (this.getInscripcionService().actualizar(inscripcionForm.getInscripcionBean()));
			}

		} catch (Exception e) { 
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
			this.cargarCombosInstitucion(mav);
			this.cargarCombosLengua(mav);
			cargarInscripcionXLengua(mav,(int)inscripcionForm.getInscripcionBean().getCodigo());
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("academico/registro-inscripcion", "command",inscripcionForm);
			this.setValoresPredeterminados(inscripcionaBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		}

	}

	@RequestMapping(value = "/grabarDocente", method = RequestMethod.POST)
	public ModelAndView doGrabarDocente(@ModelAttribute("inscripcionBean") InscripcionBean inscripcionBean) {
		
		System.out.println("docenteBean"+docenteBean);
		PersonaBean prmPersona = new PersonaBean();
		docenteBean = new DocenteBean();
		docenteBean = inscripcionBean.getDocenteBean();
		boolean sw = false;
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
				
				sw =  (this.docenteService.insertar(docenteBean)); 
			} else {
				sw = (this.docenteService.actualizar(docenteBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			docenteBean = new DocenteBean() ;
			inscripcionBean.setDocenteBean(docenteBean);
			return this.getLista(inscripcionBean);
		} else {
			ModelAndView mav = new ModelAndView("academico/registro-docente", "command",docenteBean);
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
				lstSituacionDoc = maestra1Service.listarPorCodigoTabla("situacionPersonal");
				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento");
				lstNacionalidad = maestra2Service.listarPorCodigoTabla("nacionalidad");
						lstGrado=  maestra2Service.listarPorCodigoTabla("grado");
						lstCargo= maestra2Service.listarPorCodigoTabla("cargo");
						lstSexo= maestra2Service.listarPorCodigoTabla("sexo");
						lstCarrera =maestra2Service.listarPorCodigoTabla("carrera");
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
	
	
	private ModelAndView getLista(InscripcionBean inscripcionBean) {
		
		List<InscripcionBean> lstInscripcionBean =null;
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
		this.cargarCombosInstitucion(mav);
		this.cargarCombosLengua(mav);
	
		return mav;
	}
          
	private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra2Service.listarPorCodigoTabla("situacionInscripcion");
				setLstPeriodo(maestra2Service.listarPorCodigoTabla("periodo"));
				lstCiclo = maestra2Service.listarPorCodigoTabla("ciclo");
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		mav.addObject("lstCiclo",lstCiclo);
		mav.addObject("lstPeriodo",lstPeriodo); 
		mav.addObject("lstSituacion",lstSituacion); 
	} 
	
	private void cargarCombosInstitucion(ModelAndView mav){
		InstitucionBean inst = new InstitucionBean();
		if (lstInstitucionBean==null) {
			try {
				lstInstitucionBean = institucionService.getListarCombo(inst);
				System.out.println("stInstitucionBean.size() "+ lstInstitucionBean.size());
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}else {
			System.out.println("no listo combo lstInstitucionBean");
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
	
	
	protected void setAuditoria(BaseBean baseBean,HttpServletRequest request,boolean swInsert){
		UsuarioBean usuario= (UsuarioBean) request.getSession().getAttribute("usuarioBean");
		long idUsuario=usuario.getCodigo();	
		//System.out.println("strIdUsuario "+strIdUsuario);
		this.setAuditoriaLocal(baseBean, idUsuario, request, swInsert);		
	}
	private void setAuditoriaLocal(BaseBean baseBean,long iddUsuario,HttpServletRequest request,boolean swInsert){
		if (swInsert) {
			baseBean.setCodigoUsuarioCreacion(iddUsuario);
			baseBean.setIpCreacion(NetUtil.getClientIpAddr(request));			
			
		} else {
			baseBean.setCodigoUsuarioModificacion(iddUsuario);
			baseBean.setIpModificacion(NetUtil.getClientIpAddr(request));			
		}

	}

		
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
		public ModelAndView doLenguaCargarModal(@RequestParam("codigoinst") Integer codigoinst) {

			System.out.println("codigoinst " + codigoinst);	


			InstitucionBean inscripcionaBean = new InstitucionBean();
			inscripcionaBean.setCodigo(codigoinst);
			try {
				lstlenguaBeanCombo = lenguaService.listarComboxInstitucion(inscripcionaBean);
				if (VO.isNotEmptyList(lstlenguaBeanCombo)) {
					System.out.println("lstlenguaBeanCombo.size() " +lstlenguaBeanCombo.size());
				}
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ModelAndView mav = new ModelAndView("../layout/inscripcion-lengua-registro-modal-view", "command", inscripcionLenguaBean);
			mav.addObject("inscripcionLenguaBean", inscripcionLenguaBean);
			mav.addObject("lstlenguaBeanCombo", lstlenguaBeanCombo);
		
			return mav;
		}
	
		@RequestMapping(value = "/agregarlengua", method = RequestMethod.POST)
		@ResponseBody
		public String doAgregarlengua(@RequestParam("numCupos") String numCupos,@RequestParam("codigolengua") Integer codigolengua,@RequestParam("codigoinscri") Integer codigoinscri) {
			
			String cant="";
			System.out.println("-------------------------agregarlengua-------------------------");
			System.out.println("numCupos " + numCupos);		
			System.out.println("codigolengua " + codigolengua);
			System.out.println("inscripcionaBean.getCodigo() agregarlengua " + codigoinscri);
		

			InscripcionLenguaBean insLen = new InscripcionLenguaBean();
			insLen.setNumeroCuposInsc(numCupos);
			insLen.getLenguainscr().setCodigo(codigolengua);
			insLen.getInscripcionBean().setCodigo(codigoinscri);
		
			System.out.println("inscripcionLenguaBean.getCodigo() ins " + inscripcionLenguaBean.getCodigo());
			boolean sw = false;
			try {
				if (inscripcionLenguaBean.getCodigo()==0) {
							System.out.println("insert agregarlengua");
					sw =  (this.inscripcionLenguaService.insertar(insLen)); 
					cant="1";
					
					if(sw){
						UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
						usuarioMatriculaBean.getInscripcionLenguaBean().setCodigo(insLen.getCodigo());
						usuarioMatriculaBean.getSituacion().setCodigoRegistro(2);
						usuarioMatriculaBean.setAudCodigoUsuario(1);
						usuarioMatriculaBean.setAudHostIP("192.168.1.1");
						if(numCupos!=null && numCupos!="" ){
							
							for(int i=0;i<Integer.valueOf(numCupos);i++){
								
								usuarioMatriculaService.insertar(usuarioMatriculaBean);
								
							}
						}
						
						
					}
					
				} else {
					System.out.println("actualizasar agregarlengua");
					System.out.println("insLen.getCodigo() "+ insLen.getCodigo());
					insLen.setCodigo(inscripcionLenguaBean.getCodigo());
					
					sw = (this.inscripcionLenguaService.actualizar(insLen));
					cant="2";
				}

			} catch (Exception e) { 
				return "0";
			}

			if (sw) {
				if (cant=="1") {
					System.out.println("cant 1 " + cant);
					return "1";
				}else if (cant=="2"){
					System.out.println("cant 2 " + cant);
					return "2";
					
				}else {
					System.out.println("cant 0 " + cant);
					return "0";
				}
				
			} else {
				return "0";
			}
		
			

		}
		
		@RequestMapping(value = "/recargarListadoxInscripcion", method = RequestMethod.GET)
		public ModelAndView recargarListadoxInscripcion(@RequestParam("codigo") Integer codigo) {

			System.out.println("codigo recargarListadoxInscripcion " + codigo);
			
			ModelAndView mav = new ModelAndView("academico/listado-detalle-inscripcion");
		
			cargarInscripcionXLengua(mav,codigo);
			return mav;
		}
		
		@RequestMapping(value = "/modificarInscripcionxLengua", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView doModificarInscripcionxLengua(@RequestParam("codigo") Integer codigo,@RequestParam("codigoinst") Integer codigoinst) {

			System.out.println("codigo " + codigo);
			System.out.println("codigoinst " + codigoinst);
			InstitucionBean inscripcionaBean = new InstitucionBean();
			inscripcionaBean.setCodigo(codigoinst);
			try {
				lstlenguaBeanCombo = lenguaService.listarComboxInstitucion(inscripcionaBean);
				if (VO.isNotEmptyList(lstlenguaBeanCombo)) {
					System.out.println("lstlenguaBeanCombo.size() " +lstlenguaBeanCombo.size());
				}
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			InscripcionLenguaBean inle =  new InscripcionLenguaBean();
			inle.setCodigo(codigo);
			try {
				inle= inscripcionLenguaService.getBuscarPorObjecto(inle);
				setInscripcionLenguaBean(inle);
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			System.out.println("inscripcionLenguaBean.getCodigo() mod " + inscripcionLenguaBean.getCodigo());
			ModelAndView mav = new ModelAndView("../layout/inscripcion-lengua-registro-modal-view", "command", inscripcionLenguaBean);
			mav.addObject("inscripcionLenguaBean", inscripcionLenguaBean);
			mav.addObject("lstlenguaBeanCombo", lstlenguaBeanCombo);
			return mav;
		}
	
		@RequestMapping(value ="/eliminarInscripcionxLengua", method = RequestMethod.POST)
		@ResponseBody
		public String eliminarInscripcionxLengua(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
			boolean sw=false;
			inscripcionLenguaBean= new InscripcionLenguaBean();
			inscripcionLenguaBean.setCodigo(codigo);
			System.out.println("codigocodigocodigo eliminar " + codigo);
		
			try { 
			sw =  (this.inscripcionLenguaService.eliminar(inscripcionLenguaBean));  
			
			} catch (Exception e) { 
				e.printStackTrace();
			} 		
			if (sw) {
				inscripcionLenguaBean.setCodigo(0);
				return "1";		
			}else {
				return "0";
			}
			
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


 

}
*/