/*package pe.gob.procalidad.natigu.web.gestion.controller.general;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.generico.CargaMaterialBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LeccionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.EjercicioService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LeccionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;

@Controller
@Scope(value="session")
@RequestMapping(value = "cargaMasivaController")
public class CargaMasivaController  extends BaseController{
	
	private CargaMaterialBean 	cargaMaterialBean;
	
//	private LeccionBean			leccion;
	private LenguaBean 			lenguaActividad;
	private List<EjercicioBean> lstEjercicio;
	private List<LeccionBean>	lstLeccion;
	private List<MaestraBean>	lstNivel;
	private List<MaestraBean>	lstSubNivel;
	private List<MaestraBean>	lstSituacion;
	private List<LenguaBean>	lstLengua;
	private List<MaestraBean> 	lstUnidad;
	private List<MaestraBean> 	lstTipoEjercicio;
	
	
	@Autowired
	private Maestra1Service 	maestra1Service;
	
	@Autowired
	private Maestra2Service 	maestra2Service;
	
	@Autowired
	private LenguaService 		lenguaService;
	
	@Autowired
	private EjercicioService 	ejercicioService;
	
	@Autowired
	private LeccionService 		leccionService;
	

	private static String findFileCeldaAudio() throws FileNotFoundException, IOException {
		
		 * NPOIFSFileSystem fsx = new NPOIFSFileSystem( new
		 * FileInputStream("C:\\Backup_Laptop\\Proyecto MINEDU - Docs\\TIPO_PREGUNTA_ALTERNATIVAS.xls"
		 * )); HSSFWorkbook wb = new HSSFWorkbook(fsx.getRoot(), true); for
		 * (HSSFObjectData obj : wb.getAllEmbeddedObjects()) { String oleName =
		 * obj.getOLE2ClassName(); DirectoryNode dn = (DirectoryNode)
		 * obj.getDirectory(); // if(oleName.contains("Acro") &&
		 * dn.hasEntry("CONTENTS")){ // InputStream is =
		 * dn.createDocumentInputStream("CONTENTS"); FileOutputStream fos = new
		 * FileOutputStream(obj.getDirectory().getName() + ".mp4");
		 * 
		 * File file = new File(
		 * "C:\\Backup_Laptop\\Proyecto MINEDU - Docs\\" + obj.getDirectory().getName() + "
		 * a.mp4"); try { FileOutputStream fop = new FileOutputStream(file); if
		 * (!file.exists()) { file.createNewFile(); } // fop.write(data);
		 * fop.flush(); fop.close();
		 * System.out.println("Llegó a leer la imagen"); } catch (IOException e)
		 * { e.printStackTrace(); } // fop.close(); // IOUtils.copy(is, fos);
		 * fos.close(); // is.close(); // } } fsx.close();
		 * 
		 * POIFSFileSystem fs = new POIFSFileSystem( new
		 * FileInputStream("C:\\Backup_Laptop\\Proyecto MINEDU - Docs\\TIPO_PREGUNTA_ALTERNATIVAS.xls"
		 * )); HSSFWorkbook workbook = new HSSFWorkbook(fs); for (HSSFObjectData
		 * obj : workbook.getAllEmbeddedObjects()) { // the OLE2 Class Name of
		 * the object String oleName = obj.getOLE2ClassName();
		 * System.out.println(oleName); if (obj.hasDirectoryEntry()) { // The
		 * DirectoryEntry is a DocumentNode. Examine its entries to // find out
		 * what it is DirectoryNode dn = (DirectoryNode) obj.getDirectory();
		 * System.out.println("nombre:" + dn.getName()); } else { // There is no
		 * DirectoryEntry // Recover the object's data from the HSSFObjectData
		 * instance. byte[] objectData = obj.getObjectData(); }
		 * 
		 * }
		 
		return "x";
	}

	private static String findFilaCeldaImage(HSSFSheet sheet, int fila, int celda) {
		HSSFPatriarch patriarch = sheet.getRow(fila).getSheet().getDrawingPatriarch();
		File file = null;
		if (patriarch != null) {
			HSSFShape shape = patriarch.getChildren().get(0);
			if (shape instanceof HSSFPicture) {
				HSSFPicture picture = (HSSFPicture) shape;
				if (picture.getShapeType() == HSSFSimpleShape.OBJECT_TYPE_PICTURE) {
					if (picture.getImageDimension() != null) {
						Row row = sheet.getRow(fila);
						if (row != null) {
							Cell cell = row.getCell(celda);
							HSSFPictureData pictureData = picture.getPictureData();
							byte[] data = pictureData.getData();
							// Acá deben de generar un código aleatorio para el
							// nombre de la imagen
							// Por alguna razón no me lee el nombre de la
							// imagen.
							file = new File("C:\\Backup_Laptop\\Proyecto MINEDU - Docs\\imagenEjercicio."
									+ pictureData.suggestFileExtension());
							try {
								FileOutputStream fop = new FileOutputStream(file);
								if (!file.exists()) {
									file.createNewFile();
								}
								fop.write(data);
								fop.flush();
								fop.close();
								// System.out.println("Llegó a leer la imagen");
							} catch (IOException e) {
								e.printStackTrace();
							}

						}
					}
				}
			}
			// }
		}
		return file.getName();
	}

	private static String findFilaCelda(HSSFSheet sheet, String codigoTPregunta) {
		String datoCelda = null;
		boolean finRow = false;
		for (Row row : sheet) {
			if (finRow == false) {
				for (Cell cell : row) {
					if (cell.getColumnIndex() == 0) {
						if (cell.getRichStringCellValue().getString().trim().equals(codigoTPregunta)) {
							HSSFRow fila = sheet.getRow(row.getRowNum());
							// obtenemos el valor de la fila en la celda 1
							HSSFCell celda = fila.getCell(1);
							if (celda != null) {
								if (codigoTPregunta.equals("{IMG_LECCION}")) {
									// Este el dato que insertaremos (ruta de
									// imagen)
									datoCelda = findFilaCeldaImage(sheet, row.getRowNum(), 1);
								} else {
									// Este el dato que insertaremos
									datoCelda = row.getRowNum() + ":" + celda.toString();
								}
								System.out.println("datoCabecera:" + datoCelda);
								finRow = true;
								break;
							} else {
								System.out.println("No se encontró dato.");
							}
						}
					}
				}
			} else{
				break;
			}
		}
		return datoCelda;
	}

	private static List<String> findFilaCeldaPreguntas(HSSFSheet sheet, String codigoTPregunta) {
		List<String> listaPreguntas = new ArrayList<String>();
		boolean encontroPregunta = false;
		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getColumnIndex() == 0) {
					// Buscamos la celda de codigoTPregunta
					if (cell.getRichStringCellValue().getString().trim().equals(codigoTPregunta)) {
						// Nos posicionamos en la fila
						HSSFRow rowTP = sheet.getRow(row.getRowNum());
						// obtenemos el valor de la fila en la celda 1
						HSSFCell cellNP = rowTP.getCell(1);
						// System.out.println(cellNP);
						if (cellNP != null) {
							// Este es el dato que insertaremos (PREGUNTA)
							System.out.println("Pregunta: "+ codigoTPregunta+"-" +cellNP.toString());
							listaPreguntas.add(codigoTPregunta + ":" + cellNP.toString());
							encontroPregunta = true;
							break;
						} else {
							System.out.println("No se encontró pregunta o la celda está vacía.");
							encontroPregunta = false; // sigo buscando
						}
					}
					// Si encontré pregunta, buscamos respuestas
					else if (cell.getRichStringCellValue().getString().trim().equals("{*RP}")
							|| cell.getRichStringCellValue().getString().trim().equals("{[RP]}")) {
						// Nos posicionamos en la fila
						HSSFRow rowRP = sheet.getRow(row.getRowNum());
						// obtenemos el valor de la fila en el celda 0
						HSSFCell cellTR = rowRP.getCell(0);
						if (cellTR == null) {
							System.out.println("No hay más respuestas, cellTR es null. Se cierran la pregunta ");
							encontroPregunta = false;
						} else {
							// obtenemos el valor de la fila en el celda 1
							HSSFCell cellRP = rowRP.getCell(1);
							// System.out.println(" ." + cellTR + ":" + cellRP);
							if (cellRP != null) {
								// Este es el dato que insertaremos (RESPUESTA)
								// {*RP} (incorrectas) - {[RP]} (correctas)
								System.out.println("Respuesta: " + cell.getRichStringCellValue().getString().trim()
										+ "-" + cellRP);
								listaPreguntas.add(cell.getRichStringCellValue().getString().trim() + ":" + cellRP);
								break;
							} else {
								System.out.println("No se encontró respuesta o la celda está vacía.");
							}
						}
					} else {
						System.out.println("No hay más respuestas. Se cierran la pregunta ");
						encontroPregunta = false;
					}

				}
			}
		}
		return listaPreguntas;
	}

	public CargaMasivaController() {
//		String lsArchivo = "C:\\Backup_Laptop\\Proyecto MINEDU - Docs\\TIPO_PREGUNTA_ALTERNATIVAS.xls";
//		InputStream lmArchivo = null;
//		try {
//			lmArchivo = new FileInputStream(lsArchivo);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		// Bucaremos todas las preguntas de tipo alternativas (para marcar)
//		String codigoTPregunta = "{TP_ALT}";
//		List<String> listaPreguntas = new ArrayList<String>();
//		HSSFWorkbook wb = null; // libro de trabajo
//		try {
//			wb = new HSSFWorkbook(lmArchivo);
//			HSSFSheet hoja = wb.getSheetAt(0);
//			// Cabecera
//			String nombreEjercicio = findFilaCelda(hoja, "{NOM_EJERCICIO}");
//			String desEjercicio = findFilaCelda(hoja, "{DES_EJERCICIO}");
//			String imgEjercicio = findFilaCelda(hoja, "{IMG_LECCION}");
//			// Detalle
//			listaPreguntas = findFilaCeldaPreguntas(hoja, codigoTPregunta);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}
	
	@PostConstruct
	public void init()
	{
		
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("cargaMaterialBean") CargaMaterialBean cargaMaterialBean)throws Exception {
		
		List<CargaMaterialBean> lstCargaMaterialBean= new ArrayList<CargaMaterialBean>();
		
		ModelAndView mav = new ModelAndView("carga-material-masivo", "command",cargaMaterialBean);
		mav.addObject("lstCargaMaterialBean", lstCargaMaterialBean);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() 
	{
		ModelAndView mav = new ModelAndView("general/registro-carga-material", "command",new CargaMaterialBean());
		mav.addObject("cargaMaterialBean", new CargaMaterialBean());
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/cargarContenido", method = RequestMethod.GET)
	public ModelAndView cargarContenido(@RequestParam("valor")String valor) {
		
		String url = "";
		
		switch (Integer.valueOf(valor)) {
		case 1:
			url = "/actividad/act-01";
			System.out.println("URL :: "+ url);
			break;
//		case 2:
//			url = "/actividad/act-02";
//			System.out.println("URL :: "+ url);
//			break;
		case 999:
			url = "/actividad/informes";
			System.out.println("URL :: "+ url);
			break;
		default:
			url = "/actividad/act-proceso";
			break;
		}
		
		ModelAndView mav = new ModelAndView(url, "command",new CargaMaterialBean());
		return mav;
	}
	
	private void cargarCombos(ModelAndView mav)
	{
		try 
		{
			lstNivel = maestra2Service.listarPorCodigoTabla("nivel");
			lstUnidad = maestra2Service.listarPorCodigoTabla("unidad");
			lstSubNivel = maestra2Service.listarPorCodigoTabla("subNivel");
			lstSituacion = maestra1Service.listarPorCodigoTabla("situacionLengua");
			lstLengua = lenguaService.cargarCombo();
		} 
		catch (ServiceException e) 
		{
			System.out.println("printStackTrace");
			e.printStackTrace();
		}	
		mav.addObject("lstNivel",lstNivel);
		mav.addObject("lstSubNivel", lstSubNivel);
		mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("lstLengua", lstLengua);
		mav.addObject("lstUnidad",lstUnidad);
	}
	

	private void cargarLengua(ModelAndView mav, int codigolengua, int codigonivel, int codigosubnivel)
	{
		CargaMaterialBean oMaterial = new CargaMaterialBean();
//		LenguaBean oLengua = new LenguaBean();
		oMaterial.getLeccion().getLengua().setCodigo(codigolengua);
		oMaterial.getLeccion().getTm2Nivel().setCodigoRegistro(codigonivel);
		oMaterial.getLeccion().getTm2SubNivel().setCodigoRegistro(codigosubnivel);
		try 
		{
			lenguaActividad = lenguaService.getBuscarPorObjecto(oMaterial.getLeccion().getLengua());
			lstLeccion = leccionService.getListarPorCriterios(oMaterial.getLeccion());
//			lstTipoEjercicio = maestra2Service.listarPorCodigoTabla("ejercicio");
		} 
		catch (ServiceException e) 
		{
			System.out.println("printStackTrace");
			e.printStackTrace();
		}	
		System.out.println("oLengua.getNombre() :: "+ lenguaActividad.getNombre());
		System.out.println("oLengua.getNombre() :: "+ lstLeccion);
		
		mav.addObject("lenguaActividad",lenguaActividad);
		mav.addObject("lstLeccion", lstLeccion);
		
	}
	
	private void cargarTipoEjercicios(ModelAndView mav)
	{
		try 
		{
			lstTipoEjercicio = maestra2Service.listarPorCodigoTabla("ejercicio");
		} 
		catch (ServiceException e) 
		{
			e.printStackTrace();
		}
		mav.addObject("lstTipoEjercicio", lstTipoEjercicio);
	}
	
	@RequestMapping(value = "/actividadCargarModal", method = RequestMethod.POST)
	public ModelAndView doActividadaCargarModal(@RequestParam("codigolengua") Integer codigolengua, @RequestParam("codigonivel") Integer codigonivel, @RequestParam("codigosubnivel") Integer codigosubnivel) {
		
		ModelAndView mav = new ModelAndView("../layout/actividad-modal-view", "command",new CargaMaterialBean());
		
		this.cargarCombos(mav);
		this.cargarTipoEjercicios(mav);
		this.cargarLengua(mav, codigolengua, codigonivel, codigosubnivel);
		return mav;
	}
	
	@RequestMapping(value = "/grabarleccion", method = RequestMethod.POST)
	public void doGrabarLeccion(@RequestParam("nombreleccion") String nombreleccion,
						@RequestParam("codigolengua") 	Integer codigolengua, 
						@RequestParam("codigonivel") 	Integer codigonivel, 
						@RequestParam("codigosubnivel") Integer codigosubnivel,
						@RequestParam("codigounidad") 	Integer codigounidad)
	{
		LeccionBean leccionBean = new LeccionBean();
		
		leccionBean.setNombreLeccion(nombreleccion);
		leccionBean.getLengua().setCodigo(codigolengua);
		leccionBean.getTm2Nivel().setCodigoRegistro(codigonivel);
		leccionBean.getTm2SubNivel().setCodigoRegistro(codigosubnivel);
		leccionBean.getTm2Unidad().setCodigoRegistro(codigounidad);
		
		try {
			if (leccionService.insertar(leccionBean)) {
				System.out.println("Se insertó el registro con éxito");
			}
			else {
				System.out.println("Falló el registro");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
	
	
	@RequestMapping(value = "/grabarejercicio", method = RequestMethod.POST)
	public void doGrabarEjercicio(@RequestParam("tituloejercicio") 		String tituloejercicio,
									@RequestParam("descripcion") 		String descripcion, 
									@RequestParam("codleccion") 		Integer codleccion, 
									@RequestParam("tm2tipoejercicio") 	Integer tm2tipoejercicio)
	{
		EjercicioBean ejercicioBean = new EjercicioBean();
		
		ejercicioBean.setTituloEjercicio(tituloejercicio);
		ejercicioBean.setDescripcionEjercicio(descripcion);
		ejercicioBean.getLeccion().setCodigo(codleccion);
		ejercicioBean.getTm2TipoEjercicio().setCodigoRegistro(tm2tipoejercicio);
		
		try {
			if (ejercicioService.insertar(ejercicioBean)) {
				System.out.println("Se insertó el registro con éxito");
			}
			else {
				System.out.println("Falló el registro");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	private void listarEjercicios()
	{
		EjercicioBean t = new EjercicioBean();
		t.getLengua().setCodigo(0);
		t.getLeccion().getTm2Nivel().setCodigoRegistro(0);
		t.getLeccion().getTm2SubNivel().setCodigoRegistro(0);
		t.getLeccion().getTm2Unidad().setCodigoRegistro(0);
		t.setCodigo(0);
		t.getLeccion().setCodigo(0);
		
		try {
			lstEjercicio = ejercicioService.getBuscarPorFiltros(t);
			long 	idLengua 	= 0;
			int 	idNivel 	= 0;
			int 	idSubNivel	= 0;
			int 	idUnidad 	= 0;
			long 	idTarea 	= 0;
			if (lstEjercicio != null && lstEjercicio.size() > 0) 
			{
				for (EjercicioBean ejercicioBean : lstEjercicio) 
				{
					if (idLengua !=  ejercicioBean.getLengua().getCodigo()) 
					{
						idLengua = ejercicioBean.getLengua().getCodigo();
						System.out.println(ejercicioBean.getLengua().getNombre());
						//HAY NUEVO NIVEL?
						if (idNivel != ejercicioBean.getLeccion().getTm2Nivel().getCodigoRegistro()) 
						{
							idNivel = ejercicioBean.getLeccion().getTm2Nivel().getCodigoRegistro();
							
							System.out.println("ejercicioBean.getLeccion().getTm2Nivel().getNombreCorto() :: " + ejercicioBean.getLeccion().getTm2Nivel().getNombreCorto());
							//HAY NUEVO SUBNIVEL?
							if (idSubNivel != ejercicioBean.getLeccion().getTm2SubNivel().getCodigoRegistro()) 
							{
								idSubNivel = ejercicioBean.getLeccion().getTm2SubNivel().getCodigoRegistro();
								
								System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto());
								
								//HAY NUEVA UNIDAD?
								if (idUnidad != ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro()) 
								{
									idUnidad = ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro();
									
									System.out.println("ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto() :: " + ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto());
									
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
								else 
								{
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
								
							}
							else 
							{
								//HAY NUEVA UNIDAD?
								if (idUnidad != ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro()) 
								{
									idUnidad = ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro();
									
									System.out.println("ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto() :: " + ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto());
									
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
								else 
								{
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
							}
						}
						else 
						{
							//HAY NUEVO SUBNIVEL?
							if (idSubNivel != ejercicioBean.getLeccion().getTm2SubNivel().getCodigoRegistro()) 
							{
								idSubNivel = ejercicioBean.getLeccion().getTm2SubNivel().getCodigoRegistro();
								
								System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto());
								
								//HAY NUEVA UNIDAD?
								if (idUnidad != ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro()) 
								{
									idUnidad = ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro();
									
									System.out.println("ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto() :: " + ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto());
									
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
								else 
								{
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
							}
							else 
							{
								//HAY NUEVA UNIDAD?
								if (idUnidad != ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro()) 
								{
									idUnidad = ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro();
									
									System.out.println("ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto() :: " + ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto());
									
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
								else 
								{
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
							}
						}
					}
					else
					{
						//HAY NUEVO NIVEL?
						if (idNivel != ejercicioBean.getLeccion().getTm2Nivel().getCodigoRegistro()) 
						{
							idNivel = ejercicioBean.getLeccion().getTm2Nivel().getCodigoRegistro();
							
							System.out.println("ejercicioBean.getLeccion().getTm2Nivel().getNombreCorto() :: " + ejercicioBean.getLeccion().getTm2Nivel().getNombreCorto());
							//HAY NUEVO SUBNIVEL?
							if (idSubNivel != ejercicioBean.getLeccion().getTm2SubNivel().getCodigoRegistro()) 
							{
								idSubNivel = ejercicioBean.getLeccion().getTm2SubNivel().getCodigoRegistro();
								
								System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto());
								
								//HAY NUEVA UNIDAD?
								if (idUnidad != ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro()) 
								{
									idUnidad = ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro();
									
									System.out.println("ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto() :: " + ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto());
									
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
								else 
								{
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
								
							}
							else 
							{
								//HAY NUEVA UNIDAD?
								if (idUnidad != ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro()) 
								{
									idUnidad = ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro();
									
									System.out.println("ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto() :: " + ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto());
									
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
								else 
								{
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
							}
						}
						else 
						{
							//HAY NUEVO SUBNIVEL?
							if (idSubNivel != ejercicioBean.getLeccion().getTm2SubNivel().getCodigoRegistro()) 
							{
								idSubNivel = ejercicioBean.getLeccion().getTm2SubNivel().getCodigoRegistro();
								
								System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto());
								
								//HAY NUEVA UNIDAD?
								if (idUnidad != ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro()) 
								{
									idUnidad = ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro();
									
									System.out.println("ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto() :: " + ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto());
									
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
								else 
								{
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
							}
							else 
							{
								//HAY NUEVA UNIDAD?
								if (idUnidad != ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro()) 
								{
									idUnidad = ejercicioBean.getLeccion().getTm2Unidad().getCodigoRegistro();
									
									System.out.println("ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto() :: " + ejercicioBean.getLeccion().getTm2Unidad().getNombreCorto());
									
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
								else 
								{
									//HAY NUEVA TAREA?
									if (idTarea != ejercicioBean.getCodigo()) 
									{
										idTarea = ejercicioBean.getCodigo();
										
										System.out.println("ejercicioBean.getLeccion().getTm2SubNivel().getNombreCorto() :: " + ejercicioBean.getTituloEjercicio());
										
									}
								}
							}
						}
					}
				}
			}
			else {
				System.out.println("La lista se encuentra vacia");
			}
			
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	public CargaMaterialBean getCargaMaterialBean() {
		return cargaMaterialBean;
	}

	public void setCargaMaterialBean(CargaMaterialBean cargaMaterialBean) {
		this.cargaMaterialBean = cargaMaterialBean;
	}

}
*/