/*package pe.gob.procalidad.natigu.web.gestion.controller.academico;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaDocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.DocenteService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.MatriculaAlumnoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.MatriculaDocenteService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.MatriculaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.web.gestion.controller.academico.view.MatriculaForm;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;

 
@Controller
@RequestMapping(value = "matriculaController")
public class MatriculaController extends BaseController {

	private MatriculaBean 			matriculaBeanG;
	
	private MatriculaBean 			matriculaBeanA;
	
	private InscripcionBean 		inscripcionBean;
	
	private DocenteBean 			docenteBean;
	
	private AlumnoBean 				alumnoBean;
	
	private List<DocenteBean> 		lstDocenteBean;
	
	private List<MatriculaBean> 	lstMatriculaBean;
	
	private List<MaestraBean>		lstSituacion;
	private List<MaestraBean>		lstnivel;
	private List<MaestraBean>		lstsubNivel;
	private List<MaestraBean>		lstEstadoMatricula;
	private List<MaestraBean>		lstPeriodo;
	private List<MaestraBean>		lstCiclo;
	
	private List<MaestraBean>		lstTipoDocente;
	
	private List<InstitucionBean>	lstInstitucionBean;
	
	private List<LenguaBean> 		lstLenguaBean; 
	
	private List<MatriculaAlumnoBean>	lstmatriculaAlumno;
	
	@Autowired
	private MatriculaService 		matriculaService;
	
	@Autowired
	private Maestra1Service 		maestra1Service;
	
	@Autowired
	private Maestra2Service 		maestra2Service;
	
	@Autowired
	private InstitucionService		institucionService;
	
	@Autowired
	private InscripcionService		inscripcionService;
	
	@Autowired
	private LenguaService 			lenguaService;
	
	@Autowired
	private DocenteService 			docenteService;
	
	@Autowired
	private AlumnoService 			alumnoService;
	
	@Autowired
	private MatriculaAlumnoService 	matriculaAlumnoService;
	
	@Autowired
	private MatriculaDocenteService	matriculaDocenteService;
	
	*//****************//*
	
	private MatriculaForm 			matriculaForm;
	

	
	@PostConstruct
	public void init(){
		this.setMatriculaBeanG(new MatriculaBean());
		this.setLstMatriculaBean(new ArrayList<MatriculaBean>());
		this.setInscripcionBean(new InscripcionBean());
		this.setLstDocenteBean(new ArrayList<DocenteBean>());
		this.setMatriculaForm(new MatriculaForm());
	}
	
	public MatriculaController (){
				
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("matriculaBean") MatriculaBean matriculaBean)throws Exception {
		this.setValoresPredeterminados(matriculaBeanG);
		MatriculaBean prmMatriculaBean = new MatriculaBean();
		
//		prmMatriculaBean.setCodigo(1);
//		prmMatriculaBean.getInsti().setCodigo(8);
//		prmMatriculaBean.getLengua().setCodigo(3);
//		prmMatriculaBean.getSituacion().setCodigoRegistro(1);
//		prmMatriculaBean.getNivel().setCodigoRegistro(1);
//		prmMatriculaBean.getSubNivel().setCodigoRegistro(1);
				
		return this.getLista(prmMatriculaBean);
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("matriculaBean") MatriculaBean matriculaBean)	throws Exception {
		this.setValoresPredeterminados(matriculaBeanG);
		MatriculaBean prmMatriculaBean = new MatriculaBean();
		
//		prmMatriculaBean.setCodigo(1);
//		prmMatriculaBean.getInsti().setCodigo(8);
//		prmMatriculaBean.getLengua().setCodigo(3);
//		prmMatriculaBean.getSituacion().setCodigoRegistro(1);
//		prmMatriculaBean.getNivel().setCodigoRegistro(1);
//		prmMatriculaBean.getSubNivel().setCodigoRegistro(1);
		return this.getLista(prmMatriculaBean);
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("academico/registro-matricula", "command", new MatriculaForm());
		
//		docenteBean = new DocenteBean();
//		docenteBean.getInstitucionBean().setCodigo(3);
//		try {
//			lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarxCodigoInstitucion(docenteBean);
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		alumnoBean = new AlumnoBean();
//		alumnoBean.getTm1Situacion().setCodigoRegistro(1);
//		List<AlumnoBean> lstAlumnoBean = new ArrayList<AlumnoBean>();
//		try {
//			//modificar despues
//			lstAlumnoBean = (List<AlumnoBean>) this.alumnoService.getBuscarPorFiltros(alumnoBean);
//			
//			//System.out.println("lstAlumnoBean tamaño "+lstAlumnoBean.size());
//		} catch (Exception e) {
//			System.out.println("getLista " + e.getMessage());
//		}
//		
		

		mav.addObject("matriculaBean", new MatriculaBean());
		mav.addObject("matriculaDocenteBean", new MatriculaDocenteBean());
		mav.addObject("matriculaAlumnoBean", new MatriculaAlumnoBean());
		this.cargarCombos(mav);
		this.cargarCombosInstitucion(mav);
		this.cargarCombosLengua(mav);
		return mav;
	}
	
	@RequestMapping(value = "/nuevoModal", method = RequestMethod.GET)
	public ModelAndView doNuevoModal() {
		
		ModelAndView mav = new ModelAndView("../layout/docente-modal-view", "command",new MatriculaBean());
		
//		mav.addObject("lstMatriculaBean",lstMatriculaBean);
//		mav.addObject("matriculaBean", new MatriculaBean());
//		this.cargarCombos(mav);
//		this.cargarCombosInstitucion(mav);
//		this.cargarCombosLengua(mav);
		return mav;
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo ) {

		System.out.println("codigo " + codigo);

		MatriculaBean prmMatriculaBean = new MatriculaBean();
		prmMatriculaBean.setCodigo(codigo);
		try {
			matriculaBeanG = this.matriculaService.getBuscarPorObjecto(prmMatriculaBean);
			matriculaForm.setMatriculaBean(matriculaBeanG);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
				
		System.out.println("modificar matriculaBeanG: " + matriculaBeanG);
		
		ModelAndView mav = new ModelAndView("academico/registro-matricula", "command",matriculaForm);//matriculaBeanG
//		mav.addObject("matriculaBean", matriculaBeanG);
		mav.addObject("matriculaForm", matriculaForm);

		this.cargarCombos(mav);
		this.cargarCombosInstitucion(mav);
		this.cargarCombosLengua(mav);
		System.out.println("matriculaForm.getMatriculaBean().getCodigo() " + matriculaForm.getMatriculaBean().getCodigo());
		cargarAlumnosDocenteXMatricula(mav,(int)matriculaForm.getMatriculaBean().getCodigo());
		cargarDocenteXMatricula(mav, (int)matriculaForm.getMatriculaBean().getCodigo());
		return mav;
	}
	
	@RequestMapping(value = "/obtenerNumCupos", method = RequestMethod.POST)
	@ResponseBody
	public String doObtenerNumCupos(@RequestParam("codigoinst") Integer codigoinst,@RequestParam("codigolengua") Integer codigolengua) {

		System.out.println("codigoinst " + codigoinst);		
		System.out.println("codigolengua " + codigolengua);
		String cantidad="";

		InscripcionBean prmInscripcionBean = new InscripcionBean();
		prmInscripcionBean.getInstitucion().setCodigo(codigoinst);
		prmInscripcionBean.getLengua().setCodigo(codigolengua);
		
		
		try {
			inscripcionBean = this.inscripcionService.getNumcuposXcodInstiCodLengua(prmInscripcionBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		if (inscripcionBean!=null && inscripcionBean.getNumCupos()!=null) {
			cantidad=inscripcionBean.getNumCupos();
			System.out.println("cantidad " +cantidad);
		}
	
		return cantidad;

	}
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		matriculaBeanG= new MatriculaBean();
		matriculaBeanG.setCodigo(codigo);
		System.out.println("codigocodigocodigo eliminar " + codigo);

		try { 
				sw =  (this.matriculaService.eliminar(matriculaBeanG));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		matriculaBeanG.setCodigo(0);
		this.setValoresPredeterminados(matriculaBeanG);
		ModelAndView mav = this.getLista(matriculaBeanG);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}

	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("matriculaForm") MatriculaForm matriculaForm) {
		
		System.out.println("inscripcionBean "+matriculaForm);
		System.out.println("inscripcionBean.getCodigo() "+matriculaForm.getMatriculaBean().getCodigo());
		
		boolean sw = false;
		try {
			if (matriculaForm.getMatriculaBean().getCodigo()==0) {
				System.out.println("insertar "+matriculaForm.getMatriculaBean());
				sw =  (this.matriculaService.insertar(matriculaForm.getMatriculaBean())); 
			} else {
				System.out.println("actualizar "+matriculaForm.getMatriculaBean());
				sw = (this.matriculaService.actualizar(matriculaForm.getMatriculaBean()));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			
			MatriculaBean matriculaBeanInsr= null;
//			matriculaBean = new MatriculaBean() ;
//			this.setValoresPredeterminados(matriculaBeanG);
//			return this.getLista(matriculaBean);
			System.out.println("matriculaForm.getMatriculaBean().getCodigo() " +matriculaForm.getMatriculaBean().getCodigo());
			MatriculaBean prmMatriculaBean = new MatriculaBean();
			prmMatriculaBean.setCodigo(matriculaForm.getMatriculaBean().getCodigo());
			try {
				matriculaBeanInsr = this.matriculaService.getBuscarPorObjecto(prmMatriculaBean);
				matriculaForm.setMatriculaBean(matriculaBeanInsr);
				System.out.println("matriculaBeanInsrmatriculaBeanInsr " + matriculaBeanInsr.getFlagMatricula());
			} catch (ServiceException e) { 
				e.printStackTrace();
			}
			ModelAndView mav = new ModelAndView("academico/registro-matricula", "command",matriculaForm);
			System.out.println("matriculaForm.getMatriculaBean().getCodigo() " +matriculaForm.getMatriculaBean().getCodigo());
			mav.addObject("matriculaForm", matriculaForm);
			this.cargarCombos(mav);
			this.cargarCombosInstitucion(mav);
			this.cargarCombosLengua(mav);
			cargarAlumnosDocenteXMatricula(mav,(int)matriculaForm.getMatriculaBean().getCodigo());
			cargarDocenteXMatricula(mav, (int)matriculaForm.getMatriculaBean().getCodigo());
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("academico/registro-matricula", "command",matriculaForm);
			this.setValoresPredeterminados(matriculaBeanG);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		}


	}

	private ModelAndView getLista(MatriculaBean matriculaBean) {
		
		List<MatriculaBean> lstMatriculaBean =new ArrayList<MatriculaBean>(); 
		try {
			lstMatriculaBean = (List<MatriculaBean>) this.getMatriculaService().getBuscarPorFiltros(matriculaBean);
			System.out.println("lstMatriculaBean "+lstMatriculaBean.size());
		} catch (Exception e) {
			System.out.println("getLista lstMatriculaBean " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("academico/listado-matricula", "command",matriculaBean);
		System.out.println("lstMatriculaBean "+lstMatriculaBean);
		mav.addObject("lstMatriculaBean", lstMatriculaBean);
		this.cargarCombos(mav);
		this.cargarCombosInstitucion(mav);
		//this.cargarCombosLengua(mav);
		return mav;
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
	
	private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionMatricula");
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
		if (lstnivel==null) {
			try {
				lstnivel = maestra2Service.listarPorCodigoTabla("nivel");
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
		if (lstsubNivel==null) {
			try {
				lstsubNivel = maestra2Service.listarPorCodigoTabla("subNivel");
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}
		}
		if (lstEstadoMatricula==null) {
				try {
					lstEstadoMatricula = maestra1Service.listarPorCodigoTabla("estadoMatricula");
					System.out.println("lstEstadoMatricula.size() " + lstEstadoMatricula.size());
				} catch (ServiceException e) {
					System.out.println("printStackTrace");
					e.printStackTrace();
				}	
		}
		if (lstPeriodo==null) {
			try {
				lstPeriodo = maestra2Service.listarPorCodigoTabla("periodo");
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}	
		}
		if (lstCiclo==null) {
			try {
				lstCiclo = maestra2Service.listarPorCodigoTabla("ciclo");
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}	
		}
		
		
		
		
		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstsubNivel",lstsubNivel); 
		mav.addObject("lstnivel",lstnivel); 
		
		mav.addObject("lstEstadoMatricula",lstEstadoMatricula); 
		mav.addObject("lstPeriodo",lstPeriodo); 
		mav.addObject("lstCiclo",lstCiclo); 
		
	} 
	
	 public void setValoresPredeterminados(MatriculaBean matriculaBean){
		 matriculaBean.getInsti().setCodigo(0); 
		 matriculaBean.getLengua().setCodigo(0);
		 matriculaBean.getNivel().setCodigoRegistro(0);
		 matriculaBean.getSubNivel().setCodigoRegistro(0);
		 matriculaBean.getSituacion().setCodigoRegistro(0);
	    }
	
		@RequestMapping(value = "/listarDocenteCodigoInsti", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView doListarDocenteCodigoInsti(@RequestParam("codigoinst") Integer codigoinst) {

			System.out.println("codigoinst " + codigoinst);	
			

			docenteBean = new DocenteBean();
			docenteBean.getInstitucionBean().setCodigo(codigoinst);
			try {
				lstDocenteBean = (List<DocenteBean>)docenteService.getBuscarxCodigoInstitucion(docenteBean);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (lstTipoDocente==null) {
				try {
					lstTipoDocente = maestra2Service.listarPorCodigoTabla("TipoDocente");
				} catch (ServiceException e) {
					System.out.println("printStackTrace");
					e.printStackTrace();
				}	
			}
			
			ModelAndView mav = new ModelAndView("../layout/grupo-docente-modal-view", "command",docenteBean);
			mav.addObject("matriculaDocenteBean", new MatriculaDocenteBean());
			mav.addObject("lstDocenteBean", lstDocenteBean);
			mav.addObject("lstTipoDocente",lstTipoDocente); 
			return mav;
		}
		
		@RequestMapping(value = "/listarAlumnoCodigoInsti", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView doListarAlumnoCodigoInsti(@RequestParam("codigoinst") Integer codigoinst) {

			System.out.println("codigoinst " + codigoinst);	


			alumnoBean = new AlumnoBean();
			alumnoBean.getInstitucionBean().setCodigo(codigoinst);
			List<AlumnoBean> lstAlumnoBean = new ArrayList<AlumnoBean>();
			try {
				
				lstAlumnoBean = (List<AlumnoBean>) this.alumnoService.getBuscarxCodigoInstitucion(alumnoBean);
				
			} catch (Exception e) {
				System.out.println("getLista " + e.getMessage());
			}
			ModelAndView mav = new ModelAndView("../layout/alumno-modal-view", "command",alumnoBean);
			
			mav.addObject("lstAlumnoBean", lstAlumnoBean);
		
			return mav;
		}
	
		private void cargarAlumnosDocenteXMatricula(ModelAndView mav, int codigoMat){
			MatriculaAlumnoBean matAlum = new MatriculaAlumnoBean();
			matAlum.getMatriculaBean().setCodigo(codigoMat);
			List<MatriculaAlumnoBean>	lstMatriculaAlumnoBean=null;
		
				try {
					lstMatriculaAlumnoBean = matriculaAlumnoService.getBuscarMatriculaXAlumno(matAlum);
					if (VO.isNotEmptyList(lstMatriculaAlumnoBean)) {
						System.out.println(" lstMatriculaAlumnoBean "+ lstMatriculaAlumnoBean.size());
					}
					
				} catch (ServiceException e) {
					System.out.println("printStackTrace");
					e.printStackTrace();
				}		
		
	
			
			mav.addObject("lstmatriculaAlumno",lstMatriculaAlumnoBean); 
		
		} 
	
		@RequestMapping(value = "/LenguaxInstitucion", method = RequestMethod.GET)
		@ResponseBody
		public List<LenguaBean> doLenguaxInstitucion(@RequestParam("codigoinst") String codigoinst) {

			System.out.println("codigoinst " + codigoinst);	
			List<LenguaBean> lstLengua = new ArrayList<LenguaBean>();
			if (!codigoinst.equals("0")){
				InstitucionBean inscripcionaBean = new InstitucionBean();
				inscripcionaBean.setCodigo(Integer.valueOf(codigoinst));
				try {
					lstLengua = lenguaService.listarComboxInstitucion(inscripcionaBean);
					if (VO.isNotEmptyList(lstLengua)) {
						System.out.println("lstlenguaBeanCombo.size() " +lstLengua.size());
					}else {
						lstLengua=null;
					}
				} catch (ServiceException e) {
					
					e.printStackTrace();
				}
			}
		
	
			return lstLengua;
		}
	
		@RequestMapping(value = "/agregarAlumnoXMatricula", method = RequestMethod.POST)
		@ResponseBody
		public String doAgregarAlumnoXMatricula(@RequestParam("codMatri") Integer codMatri,@RequestParam("codAlu") Integer codAlu) {
			
			String cant="";
			System.out.println("-------------------------agregarAlumnoXMatricula-------------------------");
			System.out.println("codMatri " + codMatri);		
			System.out.println("codAlu " + codAlu);
		

			MatriculaAlumnoBean insLen = new MatriculaAlumnoBean();
			insLen.getMatriculaBean().setCodigo(codMatri);
			insLen.getAlumnoBean().setCodigo(codAlu);
			insLen.setCodigoUsuarioCreacion(1);
		
			
			boolean sw = false;
			try {
//				if (inscripcionLenguaBean.getCodigo()==0) {
							System.out.println("insert agregarlengua");
					sw =  (this.matriculaAlumnoService.insertar(insLen)); 
					cant="1";
					
								
//				} else {
//					System.out.println("actualizasar agregarlengua");
//					System.out.println("insLen.getCodigo() "+ insLen.getCodigo());
//					insLen.setCodigo(inscripcionLenguaBean.getCodigo());
//					
//					sw = (this.inscripcionLenguaService.actualizar(insLen));
//					cant="2";
//				}

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
		
		@RequestMapping(value ="/eliminarAlumnoXMatricula", method = RequestMethod.POST)
		@ResponseBody
		public String eliminarAlumnoXMatricula(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
			boolean sw=false;
			MatriculaAlumnoBean matriAlua= new MatriculaAlumnoBean();
			matriAlua.setCodigo(codigo);
			System.out.println("codigocodigocodigo eliminar " + codigo);
		
			try { 
			sw =  (this.matriculaAlumnoService.eliminar(matriAlua));  
			
			} catch (Exception e) { 
				e.printStackTrace();
			} 		
			if (sw) {
				matriAlua.setCodigo(0);
				return "1";		
			}else {
				return "0";
			}
			
		}
	
		@RequestMapping(value = "/recargarAlumnoXMatricula", method = RequestMethod.GET)
		public ModelAndView recargarAlumnoXMatricula(@RequestParam("codigo") Integer codigo) {

			System.out.println("codigo recargarAlumnoXMatricula " + codigo);
			
			ModelAndView mav = new ModelAndView("academico/listado-detalle-matricula-Alumno");
		
			cargarAlumnosDocenteXMatricula(mav,codigo);
			
			return mav;
		}
		
		private void cargarDocenteXMatricula(ModelAndView mav, int codigoMat){
			MatriculaDocenteBean matAlum = new MatriculaDocenteBean();
			matAlum.getMatriculaBean().setCodigo(codigoMat);
			List<MatriculaDocenteBean>	lstMatriculaDocenteBean=null;
		
				try {
					lstMatriculaDocenteBean = matriculaDocenteService.listarDocentexMatricula(matAlum);
					if (VO.isNotEmptyList(lstMatriculaDocenteBean)) {
						System.out.println(" lstMatriculaAlumnoBean "+ lstMatriculaDocenteBean.size());
					}
					
				} catch (ServiceException e) {
					System.out.println("printStackTrace");
					e.printStackTrace();
				}		
		
	
			
			mav.addObject("lstMatriculaDocenteBean",lstMatriculaDocenteBean); 
		
		}
		
		@RequestMapping(value = "/recargarDocenteXMatricula", method = RequestMethod.GET)
		public ModelAndView recargarDocenteXMatricula(@RequestParam("codigo") Integer codigo) {

			System.out.println("codigo recargarDocenteXMatricula " + codigo);
			
			ModelAndView mav = new ModelAndView("academico/listado-detalle-matricula-Docente");
		
			cargarDocenteXMatricula(mav,codigo);
			
			return mav;
		}
		
		@RequestMapping(value = "/agregarDocenteXMatricula", method = RequestMethod.POST)
		@ResponseBody
		public String doAgregarDocenteXMatricula(@RequestParam("codMatri") Integer codMatri,@RequestParam("codDoc") Integer codDoc,@RequestParam("tipDoc") Integer tipDoc) {
			
			String cant="";
			System.out.println("-------------------------agregarAlumnoXMatricula-------------------------");
			System.out.println("codMatri " + codMatri);		
			System.out.println("codAlu " + codDoc);
			System.out.println("tipDoc " + tipDoc);
		

			MatriculaDocenteBean insLen = new MatriculaDocenteBean();
			insLen.getMatriculaBean().setCodigo(codMatri);
			insLen.getDocenteBean().setCodigo(codDoc);
			insLen.getTipoDocente().setCodigoRegistro(tipDoc);
			insLen.getSituacionMatriculaDocente().setCodigoRegistro(1);
			insLen.setCodigoUsuarioCreacion(1);
			insLen.setIpCreacion("1");
			
			boolean sw = false;
			try {
					System.out.println("insert agregarmatriculaDocente");
					sw =  (this.matriculaDocenteService.insertar(insLen)); 
					cant="1";


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
		
		@RequestMapping(value ="/eliminarDocenteXMatricula", method = RequestMethod.POST)
		@ResponseBody
		public String eliminarDocenteXMatricula(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
			boolean sw=false;
			MatriculaDocenteBean matriAlua= new MatriculaDocenteBean();
			matriAlua.setCodigo(codigo);
			System.out.println("codigocodigocodigo eliminar " + codigo);
			matriAlua.setCodigoUsuarioModificacion(1);
			matriAlua.setIpModificacion("1");
			try { 
			sw =  (this.matriculaDocenteService.eliminar(matriAlua));  
			
			} catch (Exception e) { 
				e.printStackTrace();
			} 		
			if (sw) {
				matriAlua.setCodigo(0);
				return "1";		
			}else {
				return "0";
			}
			
		}
		
	public MatriculaBean getMatriculaBeanG() {
		return matriculaBeanG;
	}

	public void setMatriculaBeanG(MatriculaBean matriculaBeanG) {
		this.matriculaBeanG = matriculaBeanG;
	}

	public List<MatriculaBean> getLstMatriculaBean() {
		return lstMatriculaBean;
	}

	public void setLstMatriculaBean(List<MatriculaBean> lstMatriculaBean) {
		this.lstMatriculaBean = lstMatriculaBean;
	}

	public MatriculaService getMatriculaService() {
		return matriculaService;
	}

	public void setMatriculaService(MatriculaService matriculaService) {
		this.matriculaService = matriculaService;
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

	public LenguaService getLenguaService() {
		return lenguaService;
	}

	public void setLenguaService(LenguaService lenguaService) {
		this.lenguaService = lenguaService;
	}

	public List<MaestraBean> getLstnivel() {
		return lstnivel;
	}

	public void setLstnivel(List<MaestraBean> lstnivel) {
		this.lstnivel = lstnivel;
	}

	public List<MaestraBean> getLstsubNivel() {
		return lstsubNivel;
	}

	public void setLstsubNivel(List<MaestraBean> lstsubNivel) {
		this.lstsubNivel = lstsubNivel;
	}

	public List<LenguaBean> getLstLenguaBean() {
		return lstLenguaBean;
	}

	public void setLstLenguaBean(List<LenguaBean> lstLenguaBean) {
		this.lstLenguaBean = lstLenguaBean;
	}

	public List<MaestraBean> getLstEstadoMatricula() {
		return lstEstadoMatricula;
	}

	public void setLstEstadoMatricula(List<MaestraBean> lstEstadoMatricula) {
		this.lstEstadoMatricula = lstEstadoMatricula;
	}

	public List<MaestraBean> getLstCiclo() {
		return lstCiclo;
	}

	public void setLstCiclo(List<MaestraBean> lstCiclo) {
		this.lstCiclo = lstCiclo;
	}

	public List<MaestraBean> getLstPeriodo() {
		return lstPeriodo;
	}

	public void setLstPeriodo(List<MaestraBean> lstPeriodo) {
		this.lstPeriodo = lstPeriodo;
	}

	public InscripcionBean getInscripcionBean() {
		return inscripcionBean;
	}

	public void setInscripcionBean(InscripcionBean inscripcionBean) {
		this.inscripcionBean = inscripcionBean;
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

	public List<MatriculaAlumnoBean> getLstmatriculaAlumno() {
		return lstmatriculaAlumno;
	}

	public void setLstmatriculaAlumno(List<MatriculaAlumnoBean> lstmatriculaAlumno) {
		this.lstmatriculaAlumno = lstmatriculaAlumno;
	}

	public MatriculaForm getMatriculaForm() {
		return matriculaForm;
	}

	public void setMatriculaForm(MatriculaForm matriculaForm) {
		this.matriculaForm = matriculaForm;
	}

	


}
*/