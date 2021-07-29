package pe.gob.procalidad.natigu.web.gestion.controller.academico;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.net.*;
import java.io.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
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

import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionBean;
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
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
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
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.EvaluacionService;
import pe.gob.procalidad.natigu.web.gestion.controller.academico.view.MatriculaForm;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;

 
@Controller
@RequestMapping(value = "seguimientoController")
public class SeguimientoController extends BaseController {

	private MatriculaBean 			matriculaBeanG;
	
	private DocenteBean 			docenteBean;
	
	private AlumnoBean 				alumnoBean;
	//Listado
	private List<InstitucionBean>	lstInstitucionBean;
	private List<LenguaBean> 		lstLenguaBean; 
	private List<DocenteBean> 		lstDocenteBean;
	private List<MaestraBean>		lstSituacion;
	private List<MaestraBean>		lstnivel;
	//private List<MaestraBean>		lstsubNivel;
	private List<MaestraBean>		lstPeriodo;
	
	
	
	
	
	
	private MatriculaBean 			matriculaBeanA;
	
	private InscripcionBean 		inscripcionBean;
	
	
	
	private List<MatriculaBean> 	lstMatriculaBean;
	
	private List<MatriculaAlumnoBean> lstMatriculaAlumnoBeanGeneral;
	
	private List<MaestraBean>		lstEstadoMatricula;
	private List<MaestraBean>		lstCiclo;
	
	private List<MaestraBean>		lstTipoDocente;
	
	
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
	
	@Autowired
	private EvaluacionService 		evaluacionService;
	
	@Autowired
	private PeticionService peticionService;
	
	/****************/
	
	private MatriculaForm 			matriculaForm;
	
/*********************************************/

	UsuarioBean usuarioBean;
	
	
	@PostConstruct
	public void init(){
		
		//this.setUsuarioBean(new UsuarioBean());
		
		this.setLstInstitucionBean(new ArrayList<InstitucionBean>());
		this.setLstLenguaBean(new ArrayList<LenguaBean>());
		this.setLstDocenteBean(new ArrayList<DocenteBean>());
		
		
		this.setMatriculaBeanG(new MatriculaBean());
		this.setLstMatriculaBean(new ArrayList<MatriculaBean>());
		this.setInscripcionBean(new InscripcionBean());
		this.setMatriculaForm(new MatriculaForm());
	}
	
	public SeguimientoController (){
				
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscarListado (@ModelAttribute("matriculaBean") MatriculaBean matriculaBean,HttpServletRequest request)throws Exception {
		matriculaBean.getAlumnoBean().getPersonaBean().getCodigo();
		return this.doListado(matriculaBean, request);
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado (@ModelAttribute("matriculaBean") MatriculaBean matriculaBean,HttpServletRequest request)throws Exception {
		

		HttpSession session = request.getSession();
		
		System.out.println("session : "+session);
		
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		
		System.out.println("usuarioBean : "+usuarioBean);
		if (usuarioBean != null) {

			if (usuarioBean.getPersona() != null) {
				//if (lstInstitucionBean == null || lstInstitucionBean.size()==0) {
				//Perfil de usuario (Administrador:1),(Supervisor:3),(Operador:5),(Operador Institucional:6)
				try {
					lstInstitucionBean = institucionService.listarInstitucionxTipoUsuario(usuarioBean);
				} catch (ServiceException e) {
						e.printStackTrace();
				}
			//}
			}
		}
		
		//this.matriculaBeanA = matriculaBean;
		//this.setValoresPredeterminados(matriculaBeanG);
		MatriculaBean prmMatriculaBean = new MatriculaBean();
		
		ModelAndView mav = this.getLista(prmMatriculaBean);
		mav.addObject("lstInstitucionBean",lstInstitucionBean);
		return mav;
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public @ResponseBody List<MatriculaAlumnoBean> doBuscar(@ModelAttribute("matriculaBean") MatriculaBean matriculaBean, HttpServletRequest request)	throws Exception {
		
		System.out.println("buscar...!");
		HttpSession session = request.getSession();
		
		System.out.println("session : "+session);
		
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		 
		System.out.println("usuarioBean : "+usuarioBean);
		if (usuarioBean != null) {
			//Datos del usuario
			System.out.println("Controller :v");
			System.out.println("usuarioBean.getCodigoUsuario():"+usuarioBean.getCodigoUsuario());
			System.out.println("usuarioBean.getPersona().getCodigo()"+usuarioBean.getPersona().getCodigo());
			System.out.println("usuarioBean.getPersona().getNombreCompleto()"+usuarioBean.getPersona().getNombreCompleto());
			System.out.println("usuarioBean.getCodPerfilUsuSelec():"+usuarioBean.getCodPerfilUsuSelec());
			System.out.println("matriculaBean.getInsti().getCodigo():"+matriculaBean.getInsti().getCodigo());
			System.out.println("matriculaBean.getLengua().getCodigo():"+matriculaBean.getLengua().getCodigo());
			System.out.println("matriculaBean.getDocenteBean().getCodigo():"+matriculaBean.getDocenteBean().getCodigo());
			
			//if (lstInstitucionBean == null || lstInstitucionBean.size()==0) {
				//Perfil de usuario (Administrador:1),(Supervisor:3),(Operador:5),(Operador Institucional:6)
				try {
					lstInstitucionBean = institucionService.listarInstitucionxTipoUsuario(usuarioBean);
					lstLenguaBean = getLenguaService().listarInstitucionxCodigoInstitucion(matriculaBean.getInsti());
					lstDocenteBean = getDocenteService().listarDocenteXCodigoInstitucionYCodigoLengua(matriculaBean);
				} catch (ServiceException e) {
						e.printStackTrace();
				}
			//}
		}
	    
		MatriculaAlumnoBean matriculaAlumnoBean = new MatriculaAlumnoBean();
		
		 matriculaAlumnoBean.getMatriculaBean().getInsti().setCodigo( matriculaBean.getInsti().getCodigo() );  
		 matriculaAlumnoBean.getMatriculaBean().getLengua().setCodigo(matriculaBean.getLengua().getCodigo());  
		 matriculaAlumnoBean.getMatriculaBean().getDocenteBean().setCodigo(matriculaBean.getDocenteBean().getCodigo());  
		 matriculaAlumnoBean.getMatriculaBean().getNivel().setCodigoRegistro(matriculaBean.getNivel().getCodigoRegistro()); 
		 matriculaAlumnoBean.getMatriculaBean().getPeriodo().setCodigoRegistro(matriculaBean.getPeriodo().getCodigoRegistro()); 
		 matriculaAlumnoBean.getMatriculaBean().getSituacion().setCodigoRegistro(matriculaBean.getSituacion().getCodigoRegistro()); 
		 
		
		this.matriculaBeanA = matriculaBean;
		//this.setValoresPredeterminados(matriculaBeanG);
		//MatriculaBean prmMatriculaBean = new MatriculaBean();
		List<MatriculaBean> lstMatriculaBean =new ArrayList<MatriculaBean>(); 
		List<MatriculaAlumnoBean> lstMatriculaAlumnoBean =new ArrayList<MatriculaAlumnoBean>(); 
		try {
			//lstMatriculaBean = (List<MatriculaBean>) this.getMatriculaService().listarSeguimientoAlumno(matriculaBean);
			lstMatriculaAlumnoBean = (List<MatriculaAlumnoBean>) this.getMatriculaAlumnoService().listarSeguimientoMatAlu(matriculaAlumnoBean);
			this.lstMatriculaAlumnoBeanGeneral = lstMatriculaAlumnoBean;//lstMatriculaBean;
			System.out.println("lstMatriculaBean "+lstMatriculaAlumnoBean.size());
		} catch (Exception e) {
			System.out.println("getLista lstMatriculaBean " + e.getMessage());
		}
		//return this.getLista(matriculaBean);
		//ModelAndView mav = this.getLista(matriculaBean);
		//mav.addObject("lstInstitucionBean",lstInstitucionBean);
		//return mav;
		return lstMatriculaAlumnoBean;
	}

	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		return null;
	}
	

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo ) {
		return null;
	}
	
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		return null;
	}

	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("matriculaForm") MatriculaForm matriculaForm) {
		return null;
	}
	
	@RequestMapping(value = "/buscarLengua", method = RequestMethod.GET)
	public @ResponseBody  List<LenguaBean> doBuscarLengua(@RequestParam("codigoinstitucion") String codigo)throws Exception {
		List<LenguaBean> prmLengua = new ArrayList<LenguaBean>();
		InstitucionBean institucionBean = new InstitucionBean();
		
		if (codigo!=null) {
			institucionBean.setCodigo(Long.parseLong(codigo));
			prmLengua = getLenguaService().listarInstitucionxCodigoInstitucion(institucionBean);//maestra2Service.listarPorCodigoTabla("gradoAlumno");
		}
		
		return prmLengua;
	}

	
	@RequestMapping(value = "/buscarDocente", method = RequestMethod.GET)
	public @ResponseBody  List<DocenteBean> doBuscarDocente(@RequestParam("codigoinstitucion") String codigoInstitucion,@RequestParam("codigolengua") String codigoLengua)throws Exception {
		List<DocenteBean> prmDocenteBean = new ArrayList<DocenteBean>();
		MatriculaBean matriculaBean = new MatriculaBean();
	 
		if (codigoInstitucion!=null && codigoLengua!=null) {
			
			matriculaBean.getInsti().setCodigo((long) Long.parseLong(codigoInstitucion));
			matriculaBean.getLengua().setCodigo((long) Long.parseLong(codigoLengua));
			prmDocenteBean = getDocenteService().listarDocenteXCodigoInstitucionYCodigoLengua(matriculaBean);
		}
		
		return prmDocenteBean;
	}
	

	private ModelAndView getLista(MatriculaBean matriculaBean) {
		
		ModelAndView mav = new ModelAndView("academico/seguimiento-alumno", "command",matriculaBean);
		//System.out.println("lstMatriculaBean "+lstMatriculaBean);
		mav.addObject("lstMatriculaBean", new ArrayList<MatriculaBean>());
		this.cargarCombos(mav);
		//this.cargarCombosInstitucion(mav,prmUsuario.getPe);
		mav.addObject("lstDocenteBean",  new ArrayList<DocenteBean>()); 
		mav.addObject("lstLenguaBean",new ArrayList<LenguaBean>()); 
		return mav;
	}
	
	
    @RequestMapping(value = "/descargarPDF", method = RequestMethod.GET, produces = "application/pdf")
    public @ResponseBody void descargarPDF(HttpServletResponse response,HttpServletRequest request) throws IOException {
    	
    	File file = new File("reporte.pdf");
        
        //InputStream in = new FileInputStream(file);

		try {
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("Seguimiento/descargarPDF");
			habilitadoIp = peticionService.existe(prmIntento);
			if(habilitadoIp) {
				HttpHeaders responseHeaders = new HttpHeaders();
		        Document documento = new Document(PageSize.A4.rotate(),36,36,10,20);
			
		        PdfWriter pdfw = PdfWriter.getInstance(documento, new FileOutputStream("reporte.pdf"));
		        MyFooter event = new MyFooter();
		        pdfw.setPageEvent(event);
				
				documento.open();
				//Fuentes
				Font fuente = new Font(Font.getFamily("ARIAL"),12, Font.BOLD);
				Font fuenteDatos = new Font(Font.getFamily("ARIAL"),7, Font.NORMAL);
				Font fuenteSubrayada = new Font(Font.getFamily("ARIAL"),8, Font.BOLD);
				fuenteSubrayada.setStyle(Font.UNDERLINE);
				Font fuenteListado = new Font(Font.getFamily("ARIAL"),8);
				Font fuenteItalic = new Font(Font.FontFamily.COURIER, 8, Font.ITALIC);
		
				//Cabecera // windows 
				
				//Image Imagen =  Image.getInstance("D://Reportes/Imagenes/logo_cabecera.png");
//				Image Imagen =  Image.getInstance(ResourceUtil.getKey("ruta.natigu.archivos.academico.seguimiento")+this.getDiagonalFile()+"logo_cabecera.png");
				
				//linux 
				//Image Imagen =  Image.getInstance("//opt//natigu//archivos//Reportes//Imagenes//logo_cabecera.png");
				Image Imagen =  Image.getInstance(getClass().getResource("img/logo_cabecera.png"));//Image.getInstance("logo_cabecera.png");
				//
	            Imagen.scaleAbsolute(820,70);
	            Imagen.setAlignment(Element.ALIGN_CENTER);
	            documento.add(Imagen);
			
				Paragraph titulo = new Paragraph("SEGUIMIENTO DE ESTUDIANTES", fuente);
				titulo.setAlignment(Element.ALIGN_CENTER);
				documento.add(titulo);
				
				Paragraph saltolinea = new Paragraph();
				saltolinea.add("\n");
				documento.add(saltolinea);
				//
				PdfPTable tabla = new PdfPTable(24);
				tabla.setWidthPercentage(100);
				
				// tabla cabecera
				PdfPCell celda1 =  new PdfPCell(new Paragraph("Nro.",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
	            PdfPCell celda2 =  new PdfPCell(new Paragraph("INSTITUCIÓN",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
	            PdfPCell celda3 =  new PdfPCell(new Paragraph("DOCENTE",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
	            PdfPCell celda4 =  new PdfPCell(new Paragraph("ESTUDIANTE",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
	            PdfPCell celda12 =  new PdfPCell(new Paragraph("USUARIO",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
	            PdfPCell celda5 =  new PdfPCell(new Paragraph("LENGUA - NIVEL - AÑO - SEMESTRE",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
//	            PdfPCell celda5 =  new PdfPCell(new Paragraph("LENGUA",FontFactory.getFont("Arial",9,Font.BOLD,BaseColor.WHITE)));
//	            PdfPCell celda6 =  new PdfPCell(new Paragraph("NIVEL",FontFactory.getFont("Arial",9,Font.BOLD,BaseColor.WHITE)));
//	            PdfPCell celda7 =  new PdfPCell(new Paragraph("SEMESTRE",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
//	            PdfPCell celda8 =  new PdfPCell(new Paragraph("Aï¿½O",FontFactory.getFont("Arial",9,Font.BOLD,BaseColor.WHITE)));
//	            PdfPCell celda9 =  new PdfPCell(new Paragraph("FECHA INICIO",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
//	            PdfPCell celda10 =  new PdfPCell(new Paragraph("FECHA TERMINO",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
	            PdfPCell celda11 =  new PdfPCell(new Paragraph("SITUACIÓN",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
	            
	            //Color Plomo de fondo
	            celda1.setBackgroundColor(BaseColor.LIGHT_GRAY);
	            celda2.setBackgroundColor(BaseColor.LIGHT_GRAY);
	            celda3.setBackgroundColor(BaseColor.LIGHT_GRAY);
	            celda4.setBackgroundColor(BaseColor.LIGHT_GRAY);
	            celda5.setBackgroundColor(BaseColor.LIGHT_GRAY);
//	            celda6.setBackgroundColor(BaseColor.LIGHT_GRAY);
//	            celda7.setBackgroundColor(BaseColor.LIGHT_GRAY);
//	            celda8.setBackgroundColor(BaseColor.LIGHT_GRAY);
//	            celda9.setBackgroundColor(BaseColor.LIGHT_GRAY);
//	            celda10.setBackgroundColor(BaseColor.LIGHT_GRAY);
	            celda11.setBackgroundColor(BaseColor.LIGHT_GRAY);
	            celda12.setBackgroundColor(BaseColor.LIGHT_GRAY);
	            //centar
	            celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
	            celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
	            celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
	            celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
	            celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
//	            celda6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	            celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
//	            celda8.setHorizontalAlignment(Element.ALIGN_CENTER);
//	            celda9.setHorizontalAlignment(Element.ALIGN_CENTER);
//	            celda10.setHorizontalAlignment(Element.ALIGN_CENTER);
	            celda11.setHorizontalAlignment(Element.ALIGN_CENTER);
	            celda12.setHorizontalAlignment(Element.ALIGN_CENTER);

	            //tamaï¿½o de la celda
	            celda1.setColspan(1);
	            celda2.setColspan(4);
	            celda3.setColspan(4);
	            celda4.setColspan(4);//13
	            celda12.setColspan(4);//13
	            celda5.setColspan(5);
//	            celda6.setColspan(2);
//	            celda7.setColspan(2);
//	            celda8.setColspan(1);//19
//	            celda9.setColspan(3);
//	            celda10.setColspan(3);
	            celda11.setColspan(2);

	            celda1.setPaddingTop(5);
	            celda2.setPaddingTop(5);
	            celda3.setPaddingTop(5);
	            celda4.setPaddingTop(5);
	            celda12.setPaddingTop(5);
	            celda5.setPaddingTop(5);
//	            celda6.setPaddingTop(5);
//	            celda7.setPaddingTop(5);
//	            celda8.setPaddingTop(5);
//	            celda9.setPaddingTop(5);
//	            celda10.setPaddingTop(5);
	            celda11.setPaddingTop(5);
	            

	            celda1.setPaddingBottom(5);
	            celda2.setPaddingBottom(5);
	            celda3.setPaddingBottom(5);
	            celda4.setPaddingBottom(5);
	            celda12.setPaddingBottom(5);
	            celda5.setPaddingBottom(5);
//	            celda6.setPaddingBottom(5);
//	            celda7.setPaddingBottom(5);
//	            celda8.setPaddingBottom(5);
//	            celda9.setPaddingBottom(5);
//	            celda10.setPaddingBottom(5);
	            celda11.setPaddingBottom(5);
	            
	            //agregar las celda
	            tabla.addCell(celda1);
	            tabla.addCell(celda2);
	            tabla.addCell(celda3);
	            tabla.addCell(celda4);
	            tabla.addCell(celda12);
	            tabla.addCell(celda5);
//	            tabla.addCell(celda6);
//	            tabla.addCell(celda7);
//	            tabla.addCell(celda8);
//	            tabla.addCell(celda9);
//	            tabla.addCell(celda10);
	            tabla.addCell(celda11);
	            
	    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	            
	            for (int i = 0; i < this.lstMatriculaAlumnoBeanGeneral.size(); i++) {
	            	
//	            	MatriculaBean matriculaBean = this.lstMatriculaBean.get(i);
	            	MatriculaAlumnoBean matriculaBean = this.lstMatriculaAlumnoBeanGeneral.get(i);
	            	
	            	//Datos detalle
	                PdfPCell celd1 =  new PdfPCell(new Paragraph(String.valueOf((i+1)),fuenteDatos));
	                PdfPCell celd2 =  new PdfPCell(new Paragraph(matriculaBean.getMatriculaBean().getInsti().getNombreInstitucion(),fuenteDatos));
	                PdfPCell celd3 =  new PdfPCell(new Paragraph(matriculaBean.getMatriculaBean().getDocenteBean().getPersonaBean().getNombreCompleto(),fuenteDatos));
	                PdfPCell celd4 =  new PdfPCell(new Paragraph(matriculaBean.getAlumnoBean().getPersonaBean().getNombreCompleto(),fuenteDatos));
	                PdfPCell celd12 =  new PdfPCell(new Paragraph(matriculaBean.getAlumnoBean().getUsuario(),fuenteDatos));
	                PdfPCell celd5 =  new PdfPCell(new Paragraph(matriculaBean.getMatriculaBean().getLengua().getNombre()+" - "+matriculaBean.getMatriculaBean().getNivel().getNombreCorto()+" - "+String.valueOf(matriculaBean.getMatriculaBean().getPeriodo().getCodigoRegistro())+" - "+matriculaBean.getMatriculaBean().getCiclo().getNombreCorto(),fuenteDatos));
//	                PdfPCell celd5 =  new PdfPCell(new Paragraph(matriculaBean.getLengua().getNombre(),fuenteDatos));
//	                PdfPCell celd6 =  new PdfPCell(new Paragraph(matriculaBean.getNivel().getNombreCorto(),fuenteDatos));
//	                PdfPCell celd7 =  new PdfPCell(new Paragraph(matriculaBean.getCiclo().getNombreCorto(),fuenteDatos));
//	                PdfPCell celd8 =  new PdfPCell(new Paragraph(String.valueOf(matriculaBean.getPeriodo().getCodigoRegistro()),fuenteDatos));
//	                PdfPCell celd9 =  new PdfPCell(new Paragraph(sdf.format(matriculaBean.getInscripcion().getFechaRegistro()),fuenteDatos));
//	                PdfPCell celd10 =  new PdfPCell(new Paragraph(sdf.format(matriculaBean.getInscripcion().getFechaModificacion()),fuenteDatos));
	                PdfPCell celd11 =  new PdfPCell(new Paragraph(matriculaBean.getMatriculaBean().getSituacion().getNombreLargo(),fuenteDatos));
	                
	                celd1.setHorizontalAlignment(Element.ALIGN_CENTER);
	                celd2.setHorizontalAlignment(Element.ALIGN_CENTER);
	                celd3.setHorizontalAlignment(Element.ALIGN_CENTER);
	                celd4.setHorizontalAlignment(Element.ALIGN_CENTER);
	                celd12.setHorizontalAlignment(Element.ALIGN_CENTER);
	                celd5.setHorizontalAlignment(Element.ALIGN_CENTER);
//	                celd6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	                celd7.setHorizontalAlignment(Element.ALIGN_CENTER);
//	                celd8.setHorizontalAlignment(Element.ALIGN_CENTER);
//	                celd9.setHorizontalAlignment(Element.ALIGN_CENTER);
//	                celd10.setHorizontalAlignment(Element.ALIGN_CENTER);
	                celd11.setHorizontalAlignment(Element.ALIGN_CENTER);
	                

	                //tamaï¿½o de la celda
	                celd1.setColspan(1);
	                celd2.setColspan(4);
	                celd3.setColspan(4);
	                celd4.setColspan(4);//13
	                celd12.setColspan(4);//13
	                celd5.setColspan(5);
//	                celd6.setColspan(2);
//	                celd7.setColspan(2);
//	                celd8.setColspan(1);//19
//	                celd9.setColspan(3);
//	                celd10.setColspan(3);
	                celd11.setColspan(2);
	               

	                
	                tabla.addCell(celd1);
	                tabla.addCell(celd2);
	                tabla.addCell(celd3);
	                tabla.addCell(celd4);
	                tabla.addCell(celd12);
	                tabla.addCell(celd5);
//	                tabla.addCell(celd6);
//	                tabla.addCell(celd7);
//	                tabla.addCell(celd8);
//	                tabla.addCell(celd9);
//	                tabla.addCell(celd10);
	                tabla.addCell(celd11);
	                
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
			}
			
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		
   }
    
    @RequestMapping(value = "/descargarExcel", method = RequestMethod.GET, produces = "application/vnd.ms-excel")
    public @ResponseBody void descargarExcel(HttpServletResponse response,HttpServletRequest request) throws IOException {
    	 try {
    		boolean habilitadoIp = true;
 			PeticionBean prmIntento = new PeticionBean();
 			prmIntento.setIpConexion(request.getRemoteAddr());
 			prmIntento.setUrlPeticion("Seguimiento/descargarExcel");
 			habilitadoIp = peticionService.existe(prmIntento);
 			if(habilitadoIp) {
 	    		 Workbook wb = generarExcel();
 	    		 response.setHeader("Content-disposition", "attachment; filename=reporte.xls");
 	    		 wb.write( response.getOutputStream() );
 			}
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
    
    public HSSFWorkbook generarExcel() {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            //Hoja
            HSSFSheet    sheet    = workbook.createSheet("SEGUIMIENTO DE ESTUDIANTES");
            /**** color ***/
            HSSFColor lightGray =  setColor(workbook,(byte) 0xE0, (byte)0xE0,(byte) 0xE0);
            /**estilos**/
            //estilo para el titulo
            HSSFFont headerFont = workbook.createFont();
            CellStyle titleStyle = workbook.createCellStyle();
            //titleStyle.setFillForegroundColor(lightGray.getIndex());
            titleStyle.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
            titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
            titleStyle.setFont(headerFont);
            //estilo para el cabecera
            HSSFCellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(lightGray.getIndex());
            headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
            headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            //estilo para el cuerpo
         	HSSFCellStyle bodyStyle = workbook.createCellStyle();
         	//bodyStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
         	bodyStyle.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
         	bodyStyle.setAlignment(CellStyle.ALIGN_CENTER);
         	bodyStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
         	bodyStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
         	bodyStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
         	bodyStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            /*** tamaï¿½o de la columnas ***/
            sheet.setColumnWidth(0, 2500); 
            sheet.setColumnWidth(1, 2500);
            sheet.setColumnWidth(2, 10000);
            sheet.setColumnWidth(3, 10000); 
            sheet.setColumnWidth(4, 10000);
            sheet.setColumnWidth(5, 8000);
            
            sheet.setColumnWidth(6, 8000);
//            sheet.setColumnWidth(7, 5000);
//            sheet.setColumnWidth(8, 3000);
//            sheet.setColumnWidth(9, 3000);
//            sheet.setColumnWidth(7, 5000);
//            sheet.setColumnWidth(8, 5000);
            sheet.setColumnWidth(7, 5000);
            /**** fuente ***/
            //titulo
            HSSFFont fontTitulo = workbook.createFont();
            fontTitulo.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            fontTitulo.setFontHeightInPoints((short) 14);
            
            titleStyle.setFont(fontTitulo);
            //cabecera
            HSSFFont fontCabecera = workbook.createFont();
            fontCabecera.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            fontCabecera.setFontHeightInPoints((short) 9);
            
            headerStyle.setFont(fontCabecera); 	
            
            /*** contenido del excel ***/
            int rowIndex  = 0;
            HSSFCell headerCell = null;
            sheet.createRow( rowIndex++ );
            sheet.createRow( rowIndex++ );
            HSSFRow   headerRow    = sheet.createRow( rowIndex++ );
            sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 7));
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("SEGUIMIENTO DE ESTUDIANTES");
            headerCell.setCellStyle(titleStyle);
            sheet.createRow( rowIndex++ );
            //Fila
            HSSFRow      bodyRow    = sheet.createRow( rowIndex++ );
            
            
           
            
            /************************* cabecera *****************************/
	            
            headerCell = bodyRow.createCell(1);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue("Nro.");
            headerCell = bodyRow.createCell(2);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue("INSTITUCIÓN");
            headerCell = bodyRow.createCell(3);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue("DOCENTE");
            headerCell = bodyRow.createCell(4);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue("ESTUDIANTE");
            headerCell = bodyRow.createCell(5);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue("USUARIO");
            headerCell = bodyRow.createCell(6);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue("LENGUA - NIVEL - AÑO - SEMESTRE");
//            headerCell = bodyRow.createCell(7);
//            headerCell.setCellStyle(headerStyle);
//            headerCell.setCellValue("NIVEL");
//            headerCell = bodyRow.createCell(8);
//            headerCell.setCellStyle(headerStyle);
//            headerCell.setCellValue("CICLO");
//            headerCell = bodyRow.createCell(9);
//            headerCell.setCellStyle(headerStyle);
//            headerCell.setCellValue("Aï¿½O");
//            headerCell = bodyRow.createCell(7);
//            headerCell.setCellStyle(headerStyle);
//            headerCell.setCellValue("FECHA INICIO");
//            headerCell = bodyRow.createCell(8);
//            headerCell.setCellStyle(headerStyle);
//            headerCell.setCellValue("FECHA TERMINO");
            headerCell = bodyRow.createCell(7);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue("SITUACIÓN");
            /******************* Contenido *************************/
    		HSSFRow  contentRow  = null;
    		HSSFCell contentCell = null;
    		
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
    	
            for (int i = 0; i < this.lstMatriculaAlumnoBeanGeneral.size(); i++) {
            	
//            	MatriculaBean matriculaBean = this.lstMatriculaBean.get(i);
            	MatriculaAlumnoBean matriculaBean = this.lstMatriculaAlumnoBeanGeneral.get(i);
            	contentRow = sheet.createRow( rowIndex++ );
            	contentCell = contentRow.createCell(1);
            	contentCell.setCellStyle(bodyStyle);
            	contentCell.setCellValue(String.valueOf((i+1)));
            	contentCell = contentRow.createCell(2);
            	contentCell.setCellStyle(bodyStyle);
            	contentCell.setCellValue(matriculaBean.getMatriculaBean().getInsti().getNombreInstitucion());
            	contentCell = contentRow.createCell(3);
            	contentCell.setCellStyle(bodyStyle);
            	contentCell.setCellValue(matriculaBean.getMatriculaBean().getDocenteBean().getPersonaBean().getNombreCompleto());
            	contentCell = contentRow.createCell(4);
            	contentCell.setCellStyle(bodyStyle);
            	contentCell.setCellValue(matriculaBean.getAlumnoBean().getPersonaBean().getNombreCompleto());
            	contentCell = contentRow.createCell(5);
            	contentCell.setCellStyle(bodyStyle);
            	contentCell.setCellValue(matriculaBean.getAlumnoBean().getUsuario());
            	contentCell = contentRow.createCell(6);
            	contentCell.setCellStyle(bodyStyle);
            	contentCell.setCellValue(matriculaBean.getMatriculaBean().getLengua().getNombre()+" - "+matriculaBean.getMatriculaBean().getNivel().getNombreCorto()+" - "+String.valueOf(matriculaBean.getMatriculaBean().getPeriodo().getCodigoRegistro())+" - "+matriculaBean.getMatriculaBean().getCiclo().getNombreCorto());
//            	contentCell = contentRow.createCell(7);
//            	contentCell.setCellStyle(bodyStyle);
//            	contentCell.setCellValue(matriculaBean.getNivel().getNombreCorto());
//            	contentCell = contentRow.createCell(8);
//            	contentCell.setCellStyle(bodyStyle);
//            	contentCell.setCellValue(matriculaBean.getCiclo().getNombreCorto());
//            	contentCell = contentRow.createCell(9);
//            	contentCell.setCellStyle(bodyStyle);
//            	contentCell.setCellValue(String.valueOf(matriculaBean.getPeriodo().getCodigoRegistro()));
            	
//            	contentCell = contentRow.createCell(7);
//            	contentCell.setCellStyle(bodyStyle);
//            	contentCell.setCellValue(sdf.format(matriculaBean.getInscripcion().getFechaRegistro()));
//            	contentCell = contentRow.createCell(8);
//            	contentCell.setCellStyle(bodyStyle);
//            	contentCell.setCellValue(sdf.format(matriculaBean.getInscripcion().getFechaModificacion()));
            	contentCell = contentRow.createCell(7);
            	contentCell.setCellStyle(bodyStyle);
            	contentCell.setCellValue(matriculaBean.getMatriculaBean().getSituacion().getNombreLargo());
            }
            workbook.write(new FileOutputStream("reporte.xls"));

            //return workbook.getBytes();
            return workbook;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
   

    public HSSFColor setColor(HSSFWorkbook workbook, byte r,byte g, byte b){
        HSSFPalette palette = workbook.getCustomPalette();
        HSSFColor hssfColor = null;
        try {
            hssfColor= palette.findColor(r, g, b); 
            if (hssfColor == null ){
                palette.setColorAtIndex(HSSFColor.LAVENDER.index, r, g,b);
                hssfColor = palette.getColor(HSSFColor.LAVENDER.index);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

        return hssfColor;
    }
	private byte[] getBytesFromFile(File file) throws IOException{
		InputStream is = new FileInputStream(file);
		// se obtiene el tamaï¿½o del archivo
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
		

	private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionMatricula",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
		if (lstnivel==null) {
			try {
				lstnivel = maestra2Service.listarPorCodigoTabla("nivel",1);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		/*
		if (lstsubNivel==null) {
			try {
				lstsubNivel = maestra2Service.listarPorCodigoTabla("subNivel");
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}
		}*/
		if (lstEstadoMatricula==null) {
				try {
					lstEstadoMatricula = maestra1Service.listarPorCodigoTabla("estadoMatricula",0);
					System.out.println("lstEstadoMatricula.size() " + lstEstadoMatricula.size());
				} catch (ServiceException e) {
					System.out.println("printStackTrace");
					e.printStackTrace();
				}	
		}
		if (lstPeriodo==null) {
			try {
				lstPeriodo = maestra2Service.listarPorCodigoTabla("periodo",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}	
		}
		if (lstCiclo==null) {
			try {
				lstCiclo = maestra2Service.listarPorCodigoTabla("ciclo",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}	
		}
		
		
		
		
		mav.addObject("lstSituacion",lstSituacion); 
		//mav.addObject("lstsubNivel",lstsubNivel); 
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
					lstTipoDocente = maestra2Service.listarPorCodigoTabla("TipoDocente",0);
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
		public String doAgregarAlumnoXMatricula(@RequestParam("codMatri") Integer codMatri,@RequestParam("codAlu") Integer codAlu,HttpServletRequest request) {
			
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
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("SeguimientoController/agregarAlumnoXMatricula");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	try {
//						if (inscripcionLenguaBean.getCodigo()==0) {
									System.out.println("insert agregarlengua");
							sw =  (this.matriculaAlumnoService.insertar(insLen)); 
							cant="1";
							
										
//						} else {
//							System.out.println("actualizasar agregarlengua");
//							System.out.println("insLen.getCodigo() "+ insLen.getCodigo());
//							insLen.setCodigo(inscripcionLenguaBean.getCodigo());
//							
//							sw = (this.inscripcionLenguaService.actualizar(insLen));
//							cant="2";
//						}

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
		
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("SeguimientoController/eliminarAlumnoXMatricula");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	matriAlua.setCodigo(codigo);
					System.out.println("codigocodigocodigo eliminar " + codigo);
		        	try { 
		    			sw =  (this.matriculaAlumnoService.eliminar(matriAlua));  
		    			
	    			} catch (Exception e) { 
	    				e.printStackTrace();
	    			} 	
		        }
			} catch (Exception e) {
				// TODO: handle exception
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
		public String doAgregarDocenteXMatricula(@RequestParam("codMatri") Integer codMatri,@RequestParam("codDoc") Integer codDoc,@RequestParam("tipDoc") Integer tipDoc, HttpServletRequest request) {
			
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
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("SeguimientoController/agregarDocenteXMatricula");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	try {
						System.out.println("insert agregarmatriculaDocente");
						sw =  (this.matriculaDocenteService.insertar(insLen)); 
						cant="1";


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
			
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("SeguimientoController/eliminarDocenteXMatricula");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	try { 
		        		matriAlua.setCodigo(codigo);
		    			System.out.println("codigocodigocodigo eliminar " + codigo);
		    			matriAlua.setCodigoUsuarioModificacion(1);
		    			matriAlua.setIpModificacion("1");
		    			sw =  (this.matriculaDocenteService.eliminar(matriAlua));  
		    			
	    			} catch (Exception e) { 
	    				e.printStackTrace();
	    			} 	
		        }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
				
			if (sw) {
				matriAlua.setCodigo(0);
				return "1";		
			}else {
				return "0";
			}
			
		}
		
	 
		@RequestMapping(value = "/listarNotas", method = RequestMethod.GET)
		@ResponseBody
		public ModelAndView doListarNotas(@RequestParam("CodUsuMat") Integer CodUsuMat) {
			System.out.println("codMatri listarNotas:: " + CodUsuMat);
			UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
			MatriculaAlumnoBean matriculaAlumnoBean = new MatriculaAlumnoBean();			
			List<EvaluacionBean> lstEvaluacionBean= new ArrayList<EvaluacionBean>();
			EvaluacionBean  EvaluacionBean = new EvaluacionBean();
			usuarioMatriculaBean.setCodigo(CodUsuMat);
//			EvaluacionBean.getSituacionEvaluacion().getNombreLargo();
			EvaluacionBean.getSubNivel().getNombreLargo();
			try {
				
				lstEvaluacionBean = (List<EvaluacionBean>) this.evaluacionService.listarNotas(usuarioMatriculaBean);
				
				System.out.println("lstEvaluacionBean.get(0).getSubNivel().getNombreLargo())"+lstEvaluacionBean.size());
			} catch (Exception e) {
				System.out.println("getLista " + e.getMessage());
			}
			ModelAndView mav = new ModelAndView("../layout/notas-modal-view");
			
			mav.addObject("lstEvaluacionBean", lstEvaluacionBean);
			 
		 
			return mav;
		}
		
//		@RequestMapping(value = "/listarNotas", method = RequestMethod.GET)
//		@ResponseBody
//		public List<EvaluacionBean> doListarNotas(@RequestParam("CodUsuMat") Integer CodUsuMat) {
//			System.out.println("codMatri " + CodUsuMat);
//			UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
//			MatriculaAlumnoBean matriculaAlumnoBean = new MatriculaAlumnoBean();			
//			List<EvaluacionBean> lstEvaluacionBean= new ArrayList<EvaluacionBean>();
//			EvaluacionBean  EvaluacionBean = new EvaluacionBean();
//			usuarioMatriculaBean.setCodigo(CodUsuMat);
////			EvaluacionBean.getSituacionEvaluacion().getNombreLargo();
//			EvaluacionBean.getSubNivel().getNombreLargo();
//			
//			
//			
//		 
//			try {
//				
//				lstEvaluacionBean = (List<EvaluacionBean>) this.evaluacionService.listarNotas(usuarioMatriculaBean);
//				if (lstEvaluacionBean != null) {
//					System.out.println("lstEvaluacionBean.get(0).getSubNivel().getNombreLargo())"+lstEvaluacionBean.get(0).getSubNivel().getNombreLargo());
//				}else{
//					System.out.println("null");
//				}
//				
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		 
//			return lstEvaluacionBean;
//		}
		
		
		
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
/*
	public List<MaestraBean> getLstsubNivel() {
		return lstsubNivel;
	}

	public void setLstsubNivel(List<MaestraBean> lstsubNivel) {
		this.lstsubNivel = lstsubNivel;
	}
*/
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

	public MatriculaAlumnoService getMatriculaAlumnoService() {
		return matriculaAlumnoService;
	}

	public void setMatriculaAlumnoService(MatriculaAlumnoService matriculaAlumnoService) {
		this.matriculaAlumnoService = matriculaAlumnoService;
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

	
	
	public DocenteService getDocenteService() {
		return docenteService;
	}

	public void setDocenteService(DocenteService docenteService) {
		this.docenteService = docenteService;
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}





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
            
            
            Phrase footer = new Phrase("FECHA Y HORA DE IMPRESIÓN:  "+fecha+" "+hora     
            		+ "                                                     "
            		+ "                                                     "
            		+ "                                                     "
            		+ "                                                     "
            		+ "                                                     "
            		+ "                              "
            		+ "Página "+String.valueOf(document.getPageNumber()), fuente);
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

	


}
