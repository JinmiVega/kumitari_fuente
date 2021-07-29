package pe.gob.procalidad.natigu.web.gestion.controller.general;

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
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaTablaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.FileUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.Row;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.Encrypt;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.EncryptException;

@Controller
@RequestMapping(value = "offlineKumitsari")
public class OffLineKumitsari extends BaseController {
	public static final String SEPARATOR = ";";
	public static final String QUOTE = "\"";
	public static final String QUOTEA = "<<'";
	public static final String QUOTEB = "'>>";
	private List<String> resultado = new ArrayList<String>();
	private List<AuditoriaTablaBean> lstAuditoriaTabla;
	private List<MaestraBean>		lstPeriodo;
	private List<MaestraBean>		lstCiclo;
	private List<MaestraBean>		lstOpcionDescarga;
	private List<LenguaBean>		lstLenguaBean;
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
	
	// Conexión Externa
	String lsExteURL = "";
	String lsExteUSR = "";
	String lsExtePWD = "";
	List<String> lsCadena=new ArrayList<String>();
	UsuarioBean usuario;
	SimpleDateFormat simpleDateFormat =   new SimpleDateFormat("ddMMhhmmss");
	String dateAsString = simpleDateFormat.format(new Date());
	File lmDirFile = null;
	
	@Autowired
	private Maestra2Service 		maestra2Service;
	
	@Autowired
	private LenguaService 		lenguaService;
	
	public OffLineKumitsari() {
		leerProperties();
	}

	@PostConstruct
	public void init() {
		//this.setLstOpcionDescarga(new ArrayList<MaestraBean>());
		//System.out.println("setLstOpcionDescarga " );
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
	
	@RequestMapping(value = "/listarInstitucionUsuario", method = RequestMethod.POST)
	@ResponseBody 
	public List<InstitucionBean> listarInstitucionUsuario(HttpServletRequest request){   
		HttpSession session = request.getSession();
		this.usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
		/* UsuarioBean */
		//docenteBean.setAudCodigoUsuario(usuarioBean.getPersona().getCodigo());
		//docenteBean.setAudTipo(String.valueOf(usuarioBean.getCodPerfilUsuSelec()));
		
		System.out.println("usuarioBean.getCodPerfilUsuSelec() " + usuarioBean.getCodPerfilUsuSelec());
		List<InstitucionBean> instBean = new ArrayList<InstitucionBean>();
	//	UsuarioBean usuarioBean= new UsuarioBean();
		//usuarioBean = usuario;
		//long codPerfil = 6;
		//usuarioBean.setCodPerfilUsuSelec(codPerfil);
		try{
			instBean = this.fs.getInstitucionService().listarInstitucionxTipoUsuario(usuarioBean);
			if (instBean != null && instBean.size() >0) {
				
				System.out.println("--------------------------->"+ instBean.size());
			}else{
				System.out.println("Lista vacia");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return instBean;
	}
	
	@RequestMapping(value = "/listarInstitucionLengua", method = RequestMethod.POST)
	@ResponseBody 
	public List<InstitucionLenguaBean> listarInstitucioLengua(@RequestParam("liInstitu") Integer  liInstitu){   
		List<InstitucionLenguaBean> lstInstLenguaBean = new ArrayList<InstitucionLenguaBean>();
		InstitucionLenguaBean institucionLenguaBean= new InstitucionLenguaBean();
		institucionLenguaBean.getInstitucionBean().setCodigo(liInstitu);
		try{
			lstInstLenguaBean = this.fs.getInstitucionLenguaService().getBuscarPorFiltros(institucionLenguaBean);
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

	@RequestMapping(value = "/descargarArchivoDatos", method = RequestMethod.POST)
	@ResponseBody
	public String descargarArchivoDatos(
			@RequestParam("liCodServ") int liCodServ,
			@RequestParam("liCodOpci") int liCodOpci,
			@RequestParam("liCodInst") int liCodInst,
			@RequestParam("liCodLeng") int liCodLeng,
			@RequestParam("liCodPeriodo") String liCodPeriodo,
			@RequestParam("liCodSemestre") int liCodSemestre) {
		 
		System.out.println("liCodServ " + liCodServ);
		System.out.println("liCodOpci " + liCodOpci);
		System.out.println("liCodInst " + liCodInst);
		System.out.println("liCodLeng " + liCodLeng);
		System.out.println("liCodPeriodo " + liCodPeriodo);
		System.out.println("liCodSemestre " + liCodSemestre);
		
		Connection con = null;
		BufferedReader br = null;
		BufferedWriter writer = null;
		String lsPrefijo = "";
		String lsTablSQL = "";
		String lsTblUIns = "";
		String lsTabl003 = "";
		String lsTabl004 = "";
		String lsTabl005 = "";
		String lsArchivo = "";
		String lsMimeTyp = "";
		String lsRpta501 = "";
		System.out.println("descargarArchivoDatos");
		System.out.println("lsServLoc " + lsServLoc);
		try {
			if(liCodServ==1){ 
				con = DriverManager.getConnection(lsLoclURL, lsLoclUSR, lsLoclPWD);
				lsPrefijo = "local-";
			} else if(liCodServ==2){
				con = DriverManager.getConnection(lsExteURL, lsExteUSR, lsExtePWD);
				lsPrefijo = "remoto-";
			} else{
				lsRpta501 = "No se encontró el tipo de conexión";
				return lsRpta501;
			}
			
			File dir = FileUtil.fileExists(this.getRootPathFile()); // CREAR CARPETA
			Encrypt.init("KEY_ENCRYPT_PASS");
			switch (liCodOpci) {
			case 6:
			//	lsArchivo = dir.getAbsolutePath()+this.getDiagonalFile()+lsPrefijo+liCodInst+liCodLeng+"matricula"+dateAsString+".txt";//"C:/natigu/"+lsPrefijo+"usuarios-inscritos.txt";
				lsArchivo = dir.getAbsolutePath()+this.getDiagonalFile()+lsPrefijo+liCodInst+"-"+liCodPeriodo+liCodSemestre+"matricula"+dateAsString+".txt";//"C:/natigu/"+lsPrefijo+"usuarios-inscritos.txt";
				lmDirFile = FileUtil.fileExists2(lsArchivo);
				try {
					lsConsult = "SELECT	MA.N_CODMATRI, MA.N_CODLENGUA, COALESCE(MA.N_TM2NIVEL,0) N_TM2NIVEL, COALESCE(MA.N_TM2SUBNIV,0) N_TM2SUBNIV, COALESCE(MA.N_PERIODO,'null') N_PERIODO, "+ 
								"	COALESCE(MA.N_TM2CICLO,0) N_TM2CICLO, COALESCE(MA.N_TM1SITMAT,0) N_TM1SITMAT, COALESCE(MA.N_TM1TIPMAT,0) N_TM1TIPMAT, "+ 
								"	COALESCE(MA.V_OBSERVACI,'') V_OBSERVACI,COALESCE(MA.N_FLGMAT,0) N_FLGMAT, COALESCE(MA.V_FLGEST,'0') V_FLGEST,"+
								"	COALESCE(MA.N_CODUSUREG,0) N_CODUSUREG, COALESCE(MA.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(MA.V_HOSTREG,'') V_HOSTREG, "+
								"	COALESCE(MA.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(MA.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(MA.V_HOSTMOD,'') V_HOSTMOD, "+
								"	COALESCE(MA.N_CODISNTI,0) N_CODISNTI, COALESCE(MA.N_CODINSCLEN,0)N_CODINSCLEN, COALESCE(MA.V_NUMCUPOSREST,'')V_NUMCUPOSREST "+
								"FROM	ACAD.LEOMVC_MATRICULA MA, "+
								"	ACAD.LEOTBD_INSCLENGUA IL, "+
								"	GENE.LEOTBC_LENGUA LE, "+
								"	ACAD.LEOTBC_INSCRIPCION IC "+
								"	INNER JOIN GENE.LEOTBC_INSTITUCION IT ON IT.N_CODISNTI = IC.N_CODINSTI	AND IC.N_CODINSTI = "+liCodInst +" "+
								"WHERE 	LE.N_CODLENGUA = IL.N_CODLENGUA AND IC.N_CODINSCR = IL.N_CODINSCR "+ //AND LE.N_CODLENGUA =  "+liCodLeng + " " +
								"	AND MA.N_CODINSCLEN = IL.N_CODINSCLEN AND MA.V_FLGEST = '1' AND IL.V_FLGEST = '1' AND LE.V_FLGEST = '1' AND IC.V_FLGEST = '1'"+
								" AND IC.V_PERIODO= '"+liCodPeriodo+"' AND IC.N_TM2CICLO="+liCodSemestre;
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
					System.out.println("Tabla>>ACAD.LEOMVC_MATRICULA" );
					pw.println("Tabla>>ACAD.LEOMVC_MATRICULA" );
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
					
					lsConsult = "SELECT	PE.N_CODPERSO, PE.V_APEPATPER, PE.V_APEMATPER, PE.V_NOMBREPER, PE.N_TM1TPDOPE, PE.V_NUMDOCUM, COALESCE(PE.N_TM1TIPPER,0) N_TM1TIPPER, "+ 
								"	COALESCE(PE.V_CODUBIGEO,'000000') V_CODUBIGEO, COALESCE(PE.V_DIRECPERS,'') V_DIRECPERS, COALESCE(PE.N_TM1SITPER,0) N_TM1SITPER,  "+
								"	PE.D_FECHNACIM, COALESCE(PE.N_TM2PAIS,0) N_TM2PAIS, COALESCE(PE.N_TM2ESTCIV,0) N_TM2ESTCIV, PE.N_TM2SEXO, COALESCE(PE.V_CODLENGUA,0) V_CODLENGUA, "+
								"	COALESCE(PE.V_TELEFONO,'') V_TELEFONO, COALESCE(PE.V_CORREO,'') V_CORREO, PE.V_FLGEST,  "+
								"	COALESCE(PE.N_CODUSUREG,0) N_CODUSUREG, COALESCE(PE.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(PE.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(PE.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(PE.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(PE.V_HOSTMOD,'') V_HOSTMOD, COALESCE(PE.V_NOMBFOTOP,'') V_NOMBFOTOP "+
								"FROM	GENE.LEOTBC_PERSONA PE, "+
								"	ACAD.LEOTBC_ALUMNO AL, "+
								"	ACAD.leotbd_alumnoinsti ALI " +
								"WHERE   PE.V_FLGEST = '1' AND AL.V_FLGEST = '1' AND ALI.V_FLGEST = '1'  AND AL.N_CODPERSO = PE.N_CODPERSO AND AL.n_codalumno = ALI.n_codalumno AND ALI.N_CODINSTI = "+liCodInst;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>GENE.LEOTBC_PERSONA" );
					pw.println("Tabla>>GENE.LEOTBC_PERSONA" );
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
					
					lsConsult = "SELECT  NA.N_CODPERNAC, NA.N_CODPERSO, COALESCE(NA.N_TM2PAIS,0) N_TM2PAIS, NA.V_FLGEST,  "+
								"	COALESCE(NA.N_CODUSUREG,0) N_CODUSUREG, COALESCE(NA.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(NA.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(NA.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(NA.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(NA.V_HOSTMOD,'') V_HOSTMOD  "+
								"FROM	GENE.LEOTBD_PERNACIO NA, "+
								"	GENE.LEOTBC_PERSONA PE, "+
								"	(SELECT	AL.N_CODPERSO "+
								"	FROM	ACAD.LEOTBC_ALUMNO AL, "+
								"			ACAD.leotbd_alumnoinsti ALI " +
								" WHERE AL.V_FLGEST = '1' AND ALI.V_FLGEST = '1'  AND AL.n_codalumno = ALI.n_codalumno AND ALI.N_CODINSTI = "+liCodInst+ ") Z0 "+
								"WHERE	Z0.N_CODPERSO = PE.N_CODPERSO AND NA.N_CODPERSO = PE.N_CODPERSO AND NA.V_FLGEST = '1' AND PE.V_FLGEST = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>GENE.LEOTBD_PERNACIO" );
					pw.println("Tabla>>GENE.LEOTBD_PERNACIO" );
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
					
					lsConsult = "SELECT	PL.N_CODPERLEN, PL.N_CODPERSO, PL.N_CODLENGUA, PL.N_TM1TIPOLENGUA, PL.V_FLGEST, "+
								"	COALESCE(PL.N_CODUSUREG,0) N_CODUSUREG, COALESCE(PL.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(PL.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(PL.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(PL.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(PL.V_HOSTMOD,'') V_HOSTMOD  "+
								"FROM	GENE.LEOTBD_PERLENGUA PL, "+
								"	GENE.LEOTBC_PERSONA PE, "+
								"	(SELECT	AL.N_CODPERSO "+
								"	FROM	ACAD.LEOTBC_ALUMNO AL, "+
								"			ACAD.leotbd_alumnoinsti ALI " +
								" WHERE AL.n_codalumno = ALI.n_codalumno AND ALI.V_FLGEST = '1' AND AL.V_FLGEST = '1' AND ALI.N_CODINSTI = "+liCodInst+ " ) Z0 "+
								"WHERE	Z0.N_CODPERSO = PE.N_CODPERSO AND PE.V_FLGEST = '1' AND PL.V_FLGEST = '1' AND PL.N_CODPERSO = PE.N_CODPERSO";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>GENE.LEOTBD_PERLENGUA" );
					pw.println("Tabla>>GENE.LEOTBD_PERLENGUA" );
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
					
					lsConsult = "SELECT	AL.N_CODALUMNO, AL.N_CODPERSO, AL.N_CODINSTI, COALESCE(AL.V_CODUBINST,'') V_CODUBINST, COALESCE(AL.N_TM2PROGR,0) N_TM2PROGR,  "+
								"	COALESCE(AL.N_TM2NIVEL,0) N_TM2NIVEL, COALESCE(AL.N_TM2GRADO,0) N_TM2GRADO, COALESCE(AL.N_TM1SITALU,0) N_TM1SITALU, AL.V_FLGEST, "+
								"	COALESCE(AL.N_CODUSUREG,0) N_CODUSUREG, COALESCE(AL.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(AL.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(AL.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(AL.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(AL.V_HOSTMOD,'') V_HOSTMOD, "+
								"	COALESCE(AL.N_MONEDAS,0) N_MONEDAS, COALESCE(AL.N_GEMAS,0) N_GEMAS "+ 
								"FROM	ACAD.LEOTBC_ALUMNO AL, "+
								"		ACAD.leotbd_alumnoinsti ALI " +
								"WHERE  AL.V_FLGEST = '1' AND ALI.V_FLGEST = '1' AND  AL.n_codalumno = ALI.n_codalumno AND ALI.N_CODINSTI = "+liCodInst;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>ACAD.LEOTBC_ALUMNO" );
					pw.println("Tabla>>ACAD.LEOTBC_ALUMNO" );
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
					
					
				lsConsult = "SELECT	 ALI.N_CODALUMNINSTI , ALI.N_CODALUMNO, ALI.N_CODINSTI, ALI.n_tm1sitaluminsti ,"+
							" ALI.v_flgest, COALESCE(ALI.N_CODUSUREG,0) N_CODUSUREG, COALESCE(ALI.D_FECREG,CURRENT_DATE) D_FECREG,  "+
							" COALESCE(ALI.V_HOSTREG,'') V_HOSTREG, COALESCE(ALI.N_CODUSUMOD,0) N_CODUSUMOD,  "+
						 	" COALESCE(ALI.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(ALI.V_HOSTMOD,'') V_HOSTMOD "+ 
							" FROM	ACAD.LEOTBD_ALUMNOINSTI ALI " +
							" WHERE  ALI.V_FLGEST = '1' AND ALI.N_CODINSTI = "+liCodInst;
				ps = con.prepareStatement(lsConsult);
				resultSet = ps.executeQuery();
				metadata = resultSet.getMetaData();
				columnCount = metadata.getColumnCount();
				lsColName = obtenerColumnas(metadata,columnCount);
				table = new ArrayList<Row>();
				Row.formTable(resultSet, table);
				System.out.println("Tabla>>ACAD.LEOTBD_ALUMNOINSTI" );
				pw.println("Tabla>>ACAD.LEOTBD_ALUMNOINSTI" );
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
					 
				
				lsConsult = "SELECT	US.N_CODUSUARI, US.V_NOMUSUARI, US.V_PASSUSUAR, COALESCE(US.N_CODPERFIL,0) N_CODPERFIL, COALESCE(US.N_CODPERSO,0) N_CODPERSO, "+ 
							"	COALESCE(US.N_TM1SITUSU,0) N_TM1SITUSU, US.V_FLGEST,  "+
							"	COALESCE(US.N_CODUSUREG,0) N_CODUSUREG, COALESCE(US.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(US.V_HOSTREG,'') V_HOSTREG,   "+
							"	COALESCE(US.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(US.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(US.V_HOSTMOD,'') V_HOSTMOD,  "+ 
							"	US.V_FLGRESTPAS  "+
							"FROM	SEGU.LEOTBC_USUARIO US, "+
							"	ACAD.LEOTBD_USUMATRICULA UM, "+
							"	 ACAD.LEOTBD_INSCLENGUA IL, "+
							"	 ACAD.LEOTBC_INSCRIPCION IC  "+
							"WHERE	UM.n_codusuari = US.n_codusuari AND IL.N_CODINSCLEN = UM.N_CODINSCLEN  AND IL.N_CODLENGUA = "+liCodLeng+" "+
							" AND US.V_FLGEST = '1' AND UM.V_FLGEST = '1' AND IL.V_FLGEST = '1'"+
							" AND IC.V_FLGEST = '1' AND IL.N_CODINSCR = IC.N_CODINSCR AND IC.N_CODINSTI = "+liCodInst+
							" AND IC.V_PERIODO= '"+liCodPeriodo+"' AND IC.N_TM2CICLO="+liCodSemestre;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>SEGU.LEOTBC_USUARIO" );
					pw.println("Tabla>>SEGU.LEOTBC_USUARIO" );
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
					
					lsConsult = "SELECT	UM.N_CODUSUMAT, UM.N_CODINSCLEN, UM.N_CODMATRI, UM.N_CODUSUARI, UM.N_CODALUMNO, UM.N_TM1SITUSU, UM.V_FLGEST, "+
								"	COALESCE(UM.N_CODUSUREG,0) N_CODUSUREG, COALESCE(UM.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(UM.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(UM.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(UM.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(UM.V_HOSTMOD,'') V_HOSTMOD, "+
								"	COALESCE(UM.N_TM1TIPOCUPO,0) N_TM1TIPOCUPO, COALESCE(UM.N_CODUSUARIACT,0) N_CODUSUARIACT "+ 
								"FROM	ACAD.LEOTBD_USUMATRICULA UM, "+
								"	    ACAD.LEOTBD_INSCLENGUA IL,"+
								"		ACAD.LEOTBC_INSCRIPCION IC "+
								"WHERE	IL.N_CODINSCLEN = UM.N_CODINSCLEN AND IL.N_CODINSCR = IC.N_CODINSCR AND IC.N_CODINSTI = "+liCodInst+
								" AND IC.V_FLGEST = '1' AND UM.V_FLGEST = '1' AND IL.V_FLGEST = '1'"+
								" AND IC.V_PERIODO= '"+liCodPeriodo+"' AND IC.N_TM2CICLO="+liCodSemestre;
								//"WHERE	IL.N_CODINSCLEN = UM.N_CODINSCLEN AND IL.N_CODLENGUA = "+liCodLeng+" AND IL.N_CODINSCR = IC.N_CODINSCR AND IC.N_CODINSTI = "+liCodInst;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>ACAD.LEOTBD_USUMATRICULA" );
					pw.println("Tabla>>ACAD.LEOTBD_USUMATRICULA" );
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
					
					lsConsult = "SELECT	UP.N_CODUSUPER, UP.N_CODUSUARI, UP.N_CODPERFIL, UP.V_FLGEST, "+
								"	COALESCE(UP.V_HOSTREG,'') V_HOSTREG, COALESCE(UP.V_HOSTMOD,'') V_HOSTMOD, COALESCE(UP.D_FECMOD,CURRENT_DATE) D_FECMOD, "+
								"	COALESCE(UP.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(UP.N_CODUSUREG,0) N_CODUSUREG, COALESCE(UP.N_CODUSUMOD,0) N_CODUSUMOD "+
								"FROM	SEGU.LEOTBD_USUPERFIL UP, "+
								"	SEGU.LEOTBC_USUARIO US, "+
								"	(SELECT PE.N_CODPERSO "+
								"	FROM GENE.LEOTBC_PERSONA PE, "+
								"		 ACAD.LEOTBC_ALUMNO AL, "+
								"		 ACAD.leotbd_alumnoinsti ALI " +
								"	WHERE  AL.V_FLGEST = '1' AND PE.V_FLGEST = '1' AND  AL.n_codalumno = ALI.n_codalumno AND AL.N_CODPERSO = PE.N_CODPERSO AND  ALI.N_CODINSTI = "+liCodInst+") Z0 "+
								"WHERE	UP.N_CODUSUARI= US.N_CODUSUARI AND US.N_CODPERSO = Z0.N_CODPERSO AND UP.V_FLGEST = '1' AND US.V_FLGEST = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>SEGU.LEOTBD_USUPERFIL" );
					pw.println("Tabla>>SEGU.LEOTBD_USUPERFIL" );
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
					
					lsConsult = "SELECT DISTINCT MA.N_CODMATALU, MA.N_CODMATRI, MA.N_CODALUMNO,COALESCE(MA.n_tm1sitmal,0) n_tm1sitmal, MA.V_FLGEST,  "+
								"	COALESCE(MA.N_CODUSUREG,0) N_CODUSUREG, COALESCE(MA.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(MA.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(MA.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(MA.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(MA.V_HOSTMOD,'') V_HOSTMOD, COALESCE(MA.n_tm2cond,0) n_tm2cond, COALESCE(MA.n_nota,0) n_nota "+
								"FROM	ACAD.LEOMVD_MATALUMNO MA, "+
								"	SEGU.LEOTBC_USUARIO US,  "+
								"	(SELECT PE.N_CODPERSO  "+
								"	 FROM	GENE.LEOTBC_PERSONA PE,  "+
								"		    ACAD.LEOTBC_ALUMNO AL,  "+
								"			ACAD.leotbd_alumnoinsti ALI " +
								"	WHERE AL.N_CODPERSO = PE.N_CODPERSO AND  AL.n_codalumno = ALI.n_codalumno AND ALI.N_CODINSTI = "+liCodInst +
								" 		AND  PE.V_FLGEST = '1' AND AL.V_FLGEST = '1' AND ALI.V_FLGEST = '1') Z0,  "+
								"	(SELECT	MA.N_CODMATRI  "+
								"	FROM	ACAD.LEOMVC_MATRICULA MA,  "+
								"		ACAD.LEOTBD_INSCLENGUA IL,  "+
								"		GENE.LEOTBC_LENGUA LE, "+
								"		ACAD.LEOTBC_INSCRIPCION IC  "+
								"		INNER JOIN GENE.LEOTBC_INSTITUCION IT ON IT.N_CODISNTI = IC.N_CODINSTI	AND IC.N_CODINSTI = "+liCodInst +" " +
								"	WHERE 	LE.N_CODLENGUA = IL.N_CODLENGUA AND IC.N_CODINSCR = IL.N_CODINSCR "+// AND LE.N_CODLENGUA = "+liCodLeng +" "+
								"	AND MA.N_CODINSCLEN = IL.N_CODINSCLEN AND MA.V_FLGEST = '1' AND IL.V_FLGEST = '1'"+
								"   AND LE.V_FLGEST = '1' AND IC.V_FLGEST = '1'"+
								"   AND IC.V_PERIODO= '"+liCodPeriodo+"' AND IC.N_TM2CICLO="+liCodSemestre+
								"	) Z1  "+
								"WHERE	 US.N_CODPERSO = Z0.N_CODPERSO "+ 
								"	AND Z1.N_CODMATRI = MA.N_CODMATRI AND MA.V_FLGEST = '1' AND US.V_FLGEST = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>ACAD.LEOMVD_MATALUMNO" );
					pw.println("Tabla>>ACAD.LEOMVD_MATALUMNO" );
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
					 lsConsult = "SELECT	MD.N_CODMATDOC, MD.N_CODMATRI, MD.N_CODDOCEN, COALESCE(MD.N_TM1TIPDOC,0) N_TM1TIPDOC, MD.N_TM1SITMDO,COALESCE(MD.V_FLGEST,'0') V_FLGEST, "+
								"	COALESCE(MD.N_CODUSUREG,0) N_CODUSUREG, COALESCE(MD.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(MD.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(MD.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(MD.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(MD.V_HOSTMOD,'') V_HOSTMOD "+
								"FROM	ACAD.LEOMVD_MATDOCENTE MD, "+
								"	(SELECT	DOC.N_CODDOCEN  "+
								"	FROM	ACAD.LEOTBC_DOCENTE DOC  INNER JOIN ACAD.leotbd_docenteinsti DOI ON DOC.n_coddocen = DOI.n_coddocen "+
								"	WHERE DOC.V_FLGEST = '1' AND DOI.V_FLGEST = '1' AND DOI.N_CODINSTI =   "+liCodInst+ " "+ 
								"	) Z0, "+
								"	(SELECT	MA.N_CODMATRI  "+
								"	FROM	ACAD.LEOMVC_MATRICULA MA, "+
								"		ACAD.LEOTBD_INSCLENGUA IL, "+
								"		GENE.LEOTBC_LENGUA LE,  "+
								"		ACAD.LEOTBC_INSCRIPCION IC "+
								"		INNER JOIN GENE.LEOTBC_INSTITUCION IT ON IT.N_CODISNTI = IC.N_CODINSTI	AND IC.N_CODINSTI =  "+liCodInst + " "+ 
								"	WHERE LE.N_CODLENGUA = IL.N_CODLENGUA AND IC.N_CODINSCR = IL.N_CODINSCR "+// AND LE.N_CODLENGUA = "+liCodLeng + " "+
								"		AND MA.N_CODINSCLEN = IL.N_CODINSCLEN "+
								"   AND MA.V_FLGEST = '1' AND IL.V_FLGEST = '1' AND LE.V_FLGEST = '1' AND IC.V_FLGEST = '1' "+
								"   AND IC.V_PERIODO= '"+liCodPeriodo+"' AND IC.N_TM2CICLO="+liCodSemestre+
								"	) Z1 "+
								"WHERE	Z0.N_CODDOCEN = MD.N_CODDOCEN AND Z1.N_CODMATRI = MD.N_CODMATRI  AND MD.V_FLGEST = '1' ";
								 
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>ACAD.LEOMVD_MATDOCENTE" );
					pw.println("Tabla>>ACAD.LEOMVD_MATDOCENTE" );
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
					
					
					
					pw.close();
					
				} catch (IOException e){
					lsRpta501 ="Error 01.1:"+e.getMessage();
					return lsRpta501;
				} catch(NullPointerException e) {
					lsRpta501 ="Error 01.2:"+e.getMessage();
					return lsRpta501;
				} finally {
					if (null != ps)
						ps.close();
					if (null != con)
						con.close();
				}
				
				break;
			case 5:
				lsArchivo = dir.getAbsolutePath()+this.getDiagonalFile()+lsPrefijo+liCodInst+"-"+liCodPeriodo+liCodSemestre+"inscripcion"+dateAsString+".txt";//"C:/natigu/"+lsPrefijo+"usuarios-inscritos.txt";
				lmDirFile = FileUtil.fileExists2(lsArchivo);
				try {
					lsConsult = "SELECT	IC.N_CODINSCR, IC.N_CODINSTI, COALESCE(IC.V_NUMCUPOS,'') V_NUMCUPOS, COALESCE(IC.N_CODLENGUA,0) N_CODLENGUA, COALESCE(IC.N_TM2SITIN,0) N_TM2SITIN, "+ 
								"	COALESCE(IC.N_CODUSUREG,0) N_CODUSUREG, COALESCE(IC.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(IC.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(IC.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(IC.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(IC.V_HOSTMOD,'') V_HOSTMOD, "+
								"   COALESCE(IC.V_PERIODO,'') V_PERIODO, COALESCE(IC.V_NUMDOCUM,'') V_NUMDOCUM, COALESCE(IC.V_NOMDOCUM,'') V_NOMDOCUM, COALESCE('','') V_RUTADOCU, " + 
								"   COALESCE(IC.N_TM2CICLO,0) N_TM2CICLO, COALESCE(IC.D_FECHAREGISTRO,CURRENT_DATE) D_FECHAREGISTRO, COALESCE(IC.N_TIPOACCESO,0) N_TIPOACCESO, COALESCE(IC.V_FLGEST,'0') V_FLGEST " +
								" FROM	ACAD.LEOTBC_INSCRIPCION IC, "+
								"	GENE.LEOTBC_INSTITUCION IT "+
								"WHERE IC.V_FLGEST = '1'  and IT.V_FLGEST = '1' and	IT.N_CODISNTI = IC.N_CODINSTI 	AND IC.N_CODINSTI = "+liCodInst+
								" AND IC.V_PERIODO= '"+liCodPeriodo+"' AND IC.N_TM2CICLO="+liCodSemestre;
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
					System.out.println("Tabla>>ACAD.LEOTBC_INSCRIPCION" );
					pw.println("Tabla>>ACAD.LEOTBC_INSCRIPCION" );
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
					lsConsult = "SELECT	DI.N_CODDOCINSCRI, DI.N_CODINSCR, COALESCE(DI.V_RUTADOCU,'') V_RUTADOCU, DI.V_FLGEST,  "+
								"	COALESCE(DI.N_CODUSUREG,0) N_CODUSUREG, COALESCE(DI.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(DI.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(DI.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(DI.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(DI.V_HOSTMOD,'') V_HOSTMOD,  "+
								" 	COALESCE(DI.V_NUMEDOCU,'') V_NUMEDOCU, COALESCE(DI.V_NOMBDOCU,'') V_NOMBDOCU, COALESCE(DI.N_SITDOCINSCRI,0) N_SITDOCINSCRI "+
								" FROM	ACAD.LEOTBC_DOCINSCRIPCION DI,  "+
								"	ACAD.LEOTBC_INSCRIPCION IC  "+
								"	INNER JOIN GENE.LEOTBC_INSTITUCION IT ON IT.N_CODISNTI = IC.N_CODINSTI	AND IC.N_CODINSTI =  "+ liCodInst+
								" WHERE	IC.N_CODINSCR = DI.N_CODINSCR AND DI.V_FLGEST = '1' and  IC.V_FLGEST = '1'"+
								" AND IC.V_PERIODO='"+liCodPeriodo+"' AND IC.N_TM2CICLO="+liCodSemestre;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>ACAD.LEOTBC_DOCINSCRIPCION" );
					pw.println("Tabla>>ACAD.LEOTBC_DOCINSCRIPCION" );
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
					lsConsult = "SELECT	distinct IL.N_CODINSCLEN, IL.N_CODINSCR, IL.N_CODLENGUA, COALESCE(IL.V_NUMCUPOS,'') V_NUMCUPOS, IL.N_TM1SITINSCLEN, COALESCE(IL.V_FLGEST,'0') V_FLGEST, "+
								"	COALESCE(IL.N_CODUSUREG,0) N_CODUSUREG, COALESCE(IL.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(IL.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(IL.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(IL.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(IL.V_HOSTMOD,'') V_HOSTMOD,  "+
								"   COALESCE(IL.V_NUMCUPOSDISP,'') V_NUMCUPOSDISP, COALESCE(IL.N_TM2NIVEL,0) N_TM2NIVEL "+
								" FROM	ACAD.LEOTBD_INSCLENGUA IL inner join ACAD.LEOTBC_INSCRIPCION IC  ON IL.N_CODINSCR = IC.N_CODINSCR"+ 
								" AND IC.N_CODINSTI = "+liCodInst+
								" where IL.V_FLGEST = '1' and  IC.V_FLGEST = '1'"+
								" AND IC.V_PERIODO='"+liCodPeriodo+"' AND IC.N_TM2CICLO="+liCodSemestre;
							//	"	ACAD.LEOTBC_INSCRIPCION IC  "+
							//	"	INNER JOIN GENE.LEOTBC_INSTITUCION IT ON IT.N_CODISNTI = IC.N_CODINSTI	AND IC.N_CODINSTI =  "+ liCodInst +
							//	" WHERE 	LE.N_CODLENGUA = IL.N_CODLENGUA AND IC.N_CODINSCR = IL.N_CODINSCR AND LE.N_CODLENGUA = " + liCodLeng;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>ACAD.LEOTBD_INSCLENGUA" );
					pw.println("Tabla>>ACAD.LEOTBD_INSCLENGUA" );
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
					lsConsult = "SELECT	IT.N_CODISNTI, COALESCE(IT.V_NOMINSTI,'') V_NOMINSTI, COALESCE(IT.V_DESCRIPC,'') V_DESCRIPC, COALESCE(IT.N_CODDIREC,0) N_CODDIREC, "+
								"	COALESCE(IT.N_CODSITINS,0) N_CODSITINS,COALESCE(IT.N_TM1TPINST,0) N_TM1TPINST, COALESCE(IT.N_TM1TPACT,0) N_TM1TPACT,  "+
								"	COALESCE(IT.V_NUMUGEL,'0') V_NUMUGEL, COALESCE(IT.V_CODMODUL,'0') V_CODMODUL, COALESCE(IT.V_CODLOCAL,'0') V_CODLOCAL,  "+
								"	COALESCE(IT.V_CODUBIGEO,'000000') V_CODUBIGEO, COALESCE(IT.V_DIRINSTIT,'') V_DIRINSTIT, COALESCE(IT.N_TM1TPARGE,0) N_TM1TPARGE,  "+
								"	COALESCE(IT.V_LATITUD,'0') V_LATITUD, COALESCE(IT.V_LONGITUD,'0') V_LONGITUD, COALESCE(IT.V_URLPAGWEB,'') V_URLPAGWEB,  "+
								"	COALESCE(IT.V_TELEFONO,'') V_TELEFONO, COALESCE(IT.V_CORREO,'') V_CORREO, IT.V_FLGEST,  "+
								"	COALESCE(IT.N_CODUSUREG,0) N_CODUSUREG, COALESCE(IT.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(IT.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(IT.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(IT.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(IT.V_HOSTMOD,'') V_HOSTMOD, "+
								"	COALESCE(IT.N_TM1SITINST,0) N_TM1SITINST, COALESCE(IT.V_NOMCORTO,'') V_NOMCORTO "+
								"FROM	GENE.LEOTBC_INSTITUCION IT   "+
								"WHERE V_FLGEST = '1' AND 	IT.N_CODISNTI = " + liCodInst;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>GENE.LEOTBC_INSTITUCION" );
					pw.println("Tabla>>GENE.LEOTBC_INSTITUCION");
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
					lsConsult = "SELECT	IL.N_CODINLENG, IL.N_CODLENGUA, IL.N_CODISNTI, IL.V_FLGEST, "+
								"	COALESCE(IL.N_CODUSUREG,0) N_CODUSUREG, COALESCE(IL.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(IL.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(IL.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(IL.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(IL.V_HOSTMOD,'') V_HOSTMOD "+
								"FROM	GENE.LEOTBD_INSTLENGUA IL, "+
								"	GENE.LEOTBC_INSTITUCION IT "+
								"WHERE IL.V_FLGEST = '1' AND IT.V_FLGEST = '1' AND IL.N_CODISNTI = IT.N_CODISNTI AND  IT.N_CODISNTI = "+liCodInst;//" AND IL.N_CODLENGUA = "+liCodLeng;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>GENE.LEOTBD_INSTLENGUA" );
					pw.println("Tabla>>GENE.LEOTBD_INSTLENGUA");
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
					
					lsConsult = "SELECT	IO.N_CODOPERA, IO.N_CODPERSO, IO.N_CODISNTI, COALESCE(IO.N_TM1SITOPE,0) N_TM1SITOPE, IO.V_FLGEST, "+
							"	COALESCE(IO.N_CODUSUREG,0) N_CODUSUREG, COALESCE(IO.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(IO.V_HOSTREG,'') V_HOSTREG,  "+
							"	COALESCE(IO.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(IO.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(IO.V_HOSTMOD,'') V_HOSTMOD "+
							"FROM	GENE.LEOTBD_INSTOPERADOR IO "+
							"WHERE IO.V_FLGEST = '1' AND	IO.N_CODISNTI = "+liCodInst;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>GENE.LEOTBD_INSTOPERADOR" );
					pw.println("Tabla>>GENE.LEOTBD_INSTOPERADOR" );
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

					lsConsult = "SELECT	PE.N_CODPERSO, PE.V_APEPATPER, PE.V_APEMATPER, PE.V_NOMBREPER, PE.N_TM1TPDOPE, PE.V_NUMDOCUM, COALESCE(PE.N_TM1TIPPER,0) N_TM1TIPPER, "+ 
								"	COALESCE(PE.V_CODUBIGEO,'000000') V_CODUBIGEO, COALESCE(PE.V_DIRECPERS,'') V_DIRECPERS, COALESCE(PE.N_TM1SITPER,0) N_TM1SITPER,  "+
								"	PE.D_FECHNACIM, COALESCE(PE.N_TM2PAIS,0) N_TM2PAIS, COALESCE(PE.N_TM2ESTCIV,0) N_TM2ESTCIV, PE.N_TM2SEXO, COALESCE(PE.V_CODLENGUA,0) V_CODLENGUA, "+
								"	COALESCE(PE.V_TELEFONO,'') V_TELEFONO, COALESCE(PE.V_CORREO,'') V_CORREO, PE.V_FLGEST,  "+
								"	COALESCE(PE.N_CODUSUREG,0) N_CODUSUREG, COALESCE(PE.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(PE.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(PE.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(PE.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(PE.V_HOSTMOD,'') V_HOSTMOD, COALESCE(PE.V_NOMBFOTOP,'') V_NOMBFOTOP "+
								"FROM	GENE.LEOTBC_PERSONA PE, "+
								"	ACAD.LEOTBC_DOCENTE DC, "+
								"   ACAD.leotbd_docenteinsti DOI "+
								"WHERE DC.n_coddocen = DOI.n_coddocen  AND PE.V_FLGEST = '1' AND DC.V_FLGEST = '1' AND DOI.V_FLGEST = '1'  AND 	DC.N_CODPERSO = PE.N_CODPERSO AND  DOI.N_CODINSTI =   "+liCodInst + " "+
								"UNION	 "+
								"SELECT	PE.N_CODPERSO, PE.V_APEPATPER, PE.V_APEMATPER, PE.V_NOMBREPER, PE.N_TM1TPDOPE, PE.V_NUMDOCUM, COALESCE(PE.N_TM1TIPPER,0) N_TM1TIPPER, "+ 
								"	COALESCE(PE.V_CODUBIGEO,'000000') V_CODUBIGEO, COALESCE(PE.V_DIRECPERS,'') V_DIRECPERS, COALESCE(PE.N_TM1SITPER,0) N_TM1SITPER,  "+ 
								"	PE.D_FECHNACIM, COALESCE(PE.N_TM2PAIS,0) N_TM2PAIS, COALESCE(PE.N_TM2ESTCIV,0) N_TM2ESTCIV, PE.N_TM2SEXO, COALESCE(PE.V_CODLENGUA,0) V_CODLENGUA,  "+
								"	COALESCE(PE.V_TELEFONO,'') V_TELEFONO, COALESCE(PE.V_CORREO,'') V_CORREO, PE.V_FLGEST,  "+
								"	COALESCE(PE.N_CODUSUREG,0) N_CODUSUREG, COALESCE(PE.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(PE.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(PE.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(PE.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(PE.V_HOSTMOD,'') V_HOSTMOD, COALESCE(PE.V_NOMBFOTOP,'') V_NOMBFOTOP "+
								"FROM	GENE.LEOTBC_PERSONA PE, "+
								"	GENE.LEOTBD_INSTOPERADOR IO "+
								"WHERE IO.V_FLGEST = '1' AND PE.V_FLGEST = '1' AND IO.N_CODPERSO = PE.N_CODPERSO AND IO.N_CODISNTI = "+liCodInst;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>GENE.LEOTBC_PERSONA" );
					pw.println("Tabla>>GENE.LEOTBC_PERSONA" );
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
					lsConsult = "SELECT  NA.N_CODPERNAC, NA.N_CODPERSO, COALESCE(NA.N_TM2PAIS,0) N_TM2PAIS, NA.V_FLGEST,  "+
								"	COALESCE(NA.N_CODUSUREG,0) N_CODUSUREG, COALESCE(NA.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(NA.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(NA.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(NA.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(NA.V_HOSTMOD,'') V_HOSTMOD "+
								"FROM	GENE.LEOTBD_PERNACIO NA, "+
								"	(SELECT PE.N_CODPERSO "+
								"	FROM	GENE.LEOTBC_PERSONA PE, "+
								"		ACAD.LEOTBC_DOCENTE DC,  "+
								" 		ACAD.leotbd_docenteinsti DOI " +
								"	WHERE PE.V_FLGEST = '1' AND  DC.n_coddocen = DOI.n_coddocen AND DC.N_CODPERSO = PE.N_CODPERSO AND  DOI.N_CODINSTI = "+liCodInst+" " +
								"	UNION  "+
								"	SELECT PE.N_CODPERSO "+
								"	FROM	GENE.LEOTBC_PERSONA PE, "+
								"	GENE.LEOTBD_INSTOPERADOR IO "+
								"	WHERE	IO.V_FLGEST = '1' AND PE.V_FLGEST = '1' AND   IO.N_CODPERSO = PE.N_CODPERSO AND IO.N_CODISNTI =  "+liCodInst+") Z0 "+
								"WHERE NA.V_FLGEST = '1' AND Z0.N_CODPERSO =  NA.N_CODPERSO ";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>GENE.LEOTBD_PERNACIO" );
					pw.println("Tabla>>GENE.LEOTBD_PERNACIO" );
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
					lsConsult = "SELECT	PL.N_CODPERLEN, PL.N_CODPERSO, PL.N_CODLENGUA, PL.N_TM1TIPOLENGUA, PL.V_FLGEST, "+
								"	COALESCE(PL.N_CODUSUREG,0) N_CODUSUREG, COALESCE(PL.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(PL.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(PL.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(PL.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(PL.V_HOSTMOD,'') V_HOSTMOD "+
								"FROM	GENE.LEOTBD_PERLENGUA PL, "+
								"	(SELECT PE.N_CODPERSO "+
								"	FROM	GENE.LEOTBC_PERSONA PE, "+
								"		ACAD.LEOTBC_DOCENTE DC, "+
								"		ACAD.leotbd_docenteinsti DOI "+
								"	WHERE PE.V_FLGEST = '1' AND	DC.N_CODPERSO = PE.N_CODPERSO AND DC.n_coddocen = DOI.n_coddocen AND  DOI.N_CODINSTI = "+liCodInst+ " " +
								"	UNION  "+
								"	SELECT PE.N_CODPERSO "+
								"	FROM	GENE.LEOTBC_PERSONA PE, "+
								"	GENE.LEOTBD_INSTOPERADOR IO  "+
								"	WHERE IO.V_FLGEST = '1' AND PE.V_FLGEST = '1' AND IO.N_CODPERSO = PE.N_CODPERSO AND IO.N_CODISNTI = "+liCodInst+ ") Z0 "+
								"WHERE PL.V_FLGEST = '1' AND Z0.N_CODPERSO =  PL.N_CODPERSO ";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>GENE.LEOTBD_PERLENGUA" );
					pw.println("Tabla>>GENE.LEOTBD_PERLENGUA" );
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
					lsConsult = "SELECT DE.N_CODDOCESP, DE.N_CODDOCEN, DE.N_CODLENGUA, COALESCE(DE.N_TM2NIVEL,0) N_TM2NIVEL, COALESCE(DE.V_FLGEST,'0') V_FLGEST, "+
							"	COALESCE(DE.N_CODUSUREG,0) N_CODUSUREG, COALESCE(DE.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(DE.V_HOSTREG,'') V_HOSTREG,  "+
							"	COALESCE(DE.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(DE.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(DE.V_HOSTMOD,'') V_HOSTMOD, "+
							"    COALESCE(DE.V_RUTADOCU,'') V_RUTADOCU, COALESCE(DE.V_NUMDOCUM,'') V_NUMDOCUM "+
							"FROM	ACAD.LEOTMD_DOCENESPECI DE, "+
							"	(SELECT	DOC.N_CODDOCEN "+ 
							"	FROM	ACAD.LEOTBC_DOCENTE DOC INNER JOIN ACAD.leotbd_docenteinsti DOI ON DOC.n_coddocen = DOI.n_coddocen"+
							" WHERE DOC.V_FLGEST = '1' AND DOI.V_FLGEST = '1' AND DOC.V_FLGEST = '1' AND  DOI.N_CODINSTI = "+liCodInst+") Z0 "+
							"WHERE DE.V_FLGEST = '1' AND 	Z0.N_CODDOCEN = DE.N_CODDOCEN	";
					
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>ACAD.LEOTMD_DOCENESPECI" );
					pw.println("Tabla>>ACAD.LEOTMD_DOCENESPECI" );
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
					lsConsult = "SELECT	ID.N_CODINSDOC, ID.N_CODINSLEN, ID.N_CODDOCEN, COALESCE(ID.N_TM1SITINSDOC,0) N_TM1SITINSCDOC, "+
								"	COALESCE(DC.N_CODUSUREG,0) N_CODUSUREG, COALESCE(DC.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(DC.V_HOSTREG,'') V_HOSTREG, "+ 
								"	COALESCE(DC.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(DC.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(DC.V_HOSTMOD,'') V_HOSTMOD, "+
								"	COALESCE(ID.D_FECBAJ,CURRENT_DATE) D_FECBAJ, COALESCE(ID.V_FLGEST,'') V_FLGEST  "+
								"FROM	ACAD.LEOTBD_INSCDOCENTE ID, "+
								"	ACAD.LEOTBC_DOCENTE DC, "+
								"   ACAD.leotbd_docenteinsti DOI " +
								"WHERE ID.V_FLGEST = '1' AND DOI.V_FLGEST = '1'  AND DC.n_coddocen = DOI.n_coddocen AND DC.V_FLGEST = '1' AND ID.N_CODDOCEN = DC.N_CODDOCEN AND DOI.N_CODINSTI = "+liCodInst;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>ACAD.LEOTBD_INSCDOCENTE" );
					pw.println("Tabla>>ACAD.LEOTBD_INSCDOCENTE" );
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
					lsConsult = "SELECT	DI.N_CODDOCENINST, DI.N_CODDOCEN, DI.N_CODINSTI, DI.N_TM1SITDOCINS, DI.V_FLGEST, "+
								"	COALESCE(DI.N_CODUSUREG,0) N_CODUSUREG, COALESCE(DI.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(DI.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(DI.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(DI.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(DI.V_HOSTMOD,'') V_HOSTMOD "+
								"FROM	ACAD.LEOTBD_DOCENTEINSTI DI, "+
								"	(SELECT	DOI.N_CODDOCEN "+
								"	FROM	ACAD.LEOTBC_DOCENTE DOC INNER JOIN ACAD.leotbd_docenteinsti DOI ON DOC.n_coddocen = DOI.n_coddocen WHERE DOI.V_FLGEST = '1' AND	DOC.V_FLGEST = '1' AND	  DOI.N_CODINSTI = "+liCodInst+") Z0 "+
								"WHERE DI.V_FLGEST = '1' AND	Z0.N_CODDOCEN = DI.N_CODDOCEN	";
					
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>ACAD.LEOTBD_DOCENTEINSTI" );
					pw.println("Tabla>>ACAD.LEOTBD_DOCENTEINSTI" );
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
					
					lsConsult = "SELECT	US.N_CODUSUARI, US.V_NOMUSUARI, US.V_PASSUSUAR, COALESCE(US.N_CODPERFIL,0) N_CODPERFIL, COALESCE(US.N_CODPERSO,0) N_CODPERSO, "+ 
							"	COALESCE(US.N_TM1SITUSU,0) N_TM1SITUSU, US.V_FLGEST, "+
							"	COALESCE(US.N_CODUSUREG,0) N_CODUSUREG, COALESCE(US.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(US.V_HOSTREG,'') V_HOSTREG,  "+
							"	COALESCE(US.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(US.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(US.V_HOSTMOD,'') V_HOSTMOD, "+
							"	US.V_FLGRESTPAS "+
							"FROM	SEGU.LEOTBC_USUARIO US, "+
							"	(SELECT PE.N_CODPERSO "+
							"	FROM	GENE.LEOTBC_PERSONA PE, "+
							"		ACAD.LEOTBC_DOCENTE DC, "+
							" 		ACAD.leotbd_docenteinsti DOI" +
							"	WHERE DC.n_coddocen = DOI.n_coddocen AND PE.V_FLGEST = '1' and DC.V_FLGEST = '1' and DOI.V_FLGEST = '1' and	DC.N_CODPERSO = PE.N_CODPERSO AND  DOI.N_CODINSTI =  "+liCodInst + " "+
							
							"	UNION  "+
							"	SELECT PE.N_CODPERSO "+
							"	FROM	GENE.LEOTBC_PERSONA PE, "+
							"	GENE.LEOTBD_INSTOPERADOR IO "+
							"	WHERE PE.V_FLGEST = '1' and	IO.V_FLGEST = '1' and IO.N_CODPERSO = PE.N_CODPERSO AND IO.N_CODISNTI = "+liCodInst +") Z0 "+
							"WHERE US.V_FLGEST = '1' and US.N_CODPERSO = Z0.N_CODPERSO 	"+
							" UNION "+ 
							"SELECT	US.N_CODUSUARI, US.V_NOMUSUARI, US.V_PASSUSUAR, COALESCE(US.N_CODPERFIL,0) N_CODPERFIL, COALESCE(US.N_CODPERSO,0) N_CODPERSO, "+ 
							"	COALESCE(US.N_TM1SITUSU,0) N_TM1SITUSU, US.V_FLGEST, "+
							"	COALESCE(US.N_CODUSUREG,0) N_CODUSUREG, COALESCE(US.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(US.V_HOSTREG,'') V_HOSTREG,  "+
							"	COALESCE(US.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(US.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(US.V_HOSTMOD,'') V_HOSTMOD, "+
							"	US.V_FLGRESTPAS "+
							" FROM	SEGU.LEOTBC_USUARIO US INNER JOIN ACAD.LEOTBD_USUMATRICULA UM"+
							" ON US.N_CODUSUARI = UM.N_CODUSUARI INNER JOIN ACAD.LEOTBD_INSCLENGUA IL ON "+
							" IL.N_CODINSCLEN = UM.N_CODINSCLEN "+
							" INNER JOIN ACAD.LEOTBC_INSCRIPCION IC ON IL.N_CODINSCR = IC.N_CODINSCR "+
							" WHERE  IL.V_FLGEST = '1'  and IC.V_FLGEST = '1' and UM.V_FLGEST = '1' AND IC.N_CODINSTI =  "+liCodInst+
							" AND IC.V_PERIODO='"+liCodPeriodo+"' AND IC.N_TM2CICLO="+liCodSemestre;
					
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>SEGU.LEOTBC_USUARIO" );
					pw.println("Tabla>>SEGU.LEOTBC_USUARIO" );
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
					lsConsult = "SELECT	UP.N_CODUSUPER, UP.N_CODUSUARI, UP.N_CODPERFIL,COALESCE(UP.V_FLGEST,'0') V_FLGEST, "+
								"	COALESCE(UP.V_HOSTREG,'') V_HOSTREG, COALESCE(UP.V_HOSTMOD,'') V_HOSTMOD, COALESCE(UP.D_FECMOD,CURRENT_DATE) D_FECMOD, "+
								"	COALESCE(UP.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(UP.N_CODUSUREG,0) N_CODUSUREG, COALESCE(UP.N_CODUSUMOD,0) N_CODUSUMOD "+
								"FROM	SEGU.LEOTBD_USUPERFIL UP, "+
								"	SEGU.LEOTBC_USUARIO US, "+
								"	(SELECT PE.N_CODPERSO "+
								"	FROM	GENE.LEOTBC_PERSONA PE, "+
								"		ACAD.LEOTBC_DOCENTE DC, "+
								"		ACAD.leotbd_docenteinsti DOI "+
								"	WHERE  DC.n_coddocen = DOI.n_coddocen AND PE.V_FLGEST = '1' AND DC.V_FLGEST = '1' AND DOI.V_FLGEST = '1' AND DC.N_CODPERSO = PE.N_CODPERSO AND  DOI.N_CODINSTI = "+liCodInst +" "+
								"	UNION  "+
								"	SELECT PE.N_CODPERSO "+
								"	FROM	GENE.LEOTBC_PERSONA PE, "+
								"	GENE.LEOTBD_INSTOPERADOR IO "+
								"	WHERE  PE.V_FLGEST = '1' AND IO.V_FLGEST = '1' AND  IO.N_CODPERSO = PE.N_CODPERSO AND IO.N_CODISNTI =  "+liCodInst +") Z0 "+
								"WHERE  UP.V_FLGEST = '1' and	UP.N_CODUSUARI= US.N_CODUSUARI AND US.N_CODPERSO = Z0.N_CODPERSO	"+
								" UNION "+
								"SELECT	UP.N_CODUSUPER, UP.N_CODUSUARI, UP.N_CODPERFIL,COALESCE(UP.V_FLGEST,'0') V_FLGEST, "+
								"	COALESCE(UP.V_HOSTREG,'') V_HOSTREG, COALESCE(UP.V_HOSTMOD,'') V_HOSTMOD, COALESCE(UP.D_FECMOD,CURRENT_DATE) D_FECMOD, "+
								"	COALESCE(UP.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(UP.N_CODUSUREG,0) N_CODUSUREG, COALESCE(UP.N_CODUSUMOD,0) N_CODUSUMOD "+
								" FROM	SEGU.LEOTBD_USUPERFIL UP INNER JOIN SEGU.LEOTBC_USUARIO US ON UP.N_CODUSUARI = US.N_CODUSUARI"+
								" INNER JOIN ACAD.LEOTBD_USUMATRICULA UM ON US.N_CODUSUARI = UM.N_CODUSUARI INNER JOIN ACAD.LEOTBD_INSCLENGUA "+ 
								" IL ON IL.N_CODINSCLEN = UM.N_CODINSCLEN INNER JOIN ACAD.LEOTBC_INSCRIPCION IC ON IL.N_CODINSCR = IC.N_CODINSCR "+
								"WHERE  IL.V_FLGEST = '1'  and IC.V_FLGEST = '1' and UM.V_FLGEST = '1' AND UP.V_FLGEST = '1' AND IC.N_CODINSTI = "+liCodInst+
								" AND IC.V_PERIODO='"+liCodPeriodo+"' AND IC.N_TM2CICLO="+liCodSemestre;
				
					
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>SEGU.LEOTBD_USUPERFIL" );
					pw.println("Tabla>>SEGU.LEOTBD_USUPERFIL" );
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
					lsConsult = "SELECT	UM.N_CODUSUMAT, UM.N_CODINSCLEN, UM.N_CODMATRI, UM.N_CODUSUARI, UM.N_CODALUMNO, UM.N_TM1SITUSU, UM.V_FLGEST, "+
								"	COALESCE(UM.N_CODUSUREG,0) N_CODUSUREG, COALESCE(UM.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(UM.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(UM.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(UM.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(UM.V_HOSTMOD,'') V_HOSTMOD, "+
								"	COALESCE(UM.N_TM1TIPOCUPO,0) N_TM1TIPOCUPO, COALESCE(UM.N_CODUSUARIACT,0) N_CODUSUARIACT  "+
								"FROM	ACAD.LEOTBD_USUMATRICULA UM, "+
								"	    ACAD.LEOTBD_INSCLENGUA IL,"+
								"		ACAD.LEOTBC_INSCRIPCION IC "+
								"WHERE	IL.N_CODINSCLEN = UM.N_CODINSCLEN  AND IL.N_CODINSCR = IC.N_CODINSCR AND IC.N_CODINSTI = "+liCodInst+
								" and IL.V_FLGEST = '1'  and IC.V_FLGEST = '1' and UM.V_FLGEST = '1'"+
								" AND IC.V_PERIODO='"+liCodPeriodo+"' AND IC.N_TM2CICLO="+liCodSemestre;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>ACAD.LEOTBD_USUMATRICULA" );
					pw.println("Tabla>>ACAD.LEOTBD_USUMATRICULA" );
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
					pw.close();
					
				} catch (IOException e){
					lsRpta501 ="Error 01:"+e.getMessage();
					return lsRpta501;
				} catch(NullPointerException e) {
					lsRpta501 ="Error 02:"+e.getMessage();
					return lsRpta501;
				} finally {
					if (null != ps)
						ps.close();
					if (null != con)
						con.close();
				}
				
				break;
			case 4:
				lsArchivo = dir.getAbsolutePath()+this.getDiagonalFile()+lsPrefijo+liCodInst+liCodLeng+"docentes"+dateAsString+".txt";//"C:/natigu/"+lsPrefijo+"usuarios-inscritos.txt";
				lmDirFile = FileUtil.fileExists2(lsArchivo);
				try {
					lsConsult = "SELECT	PE.N_CODPERSO, PE.V_APEPATPER, PE.V_APEMATPER, PE.V_NOMBREPER, PE.N_TM1TPDOPE, PE.V_NUMDOCUM, COALESCE(PE.N_TM1TIPPER,0) N_TM1TIPPER, "+
								"	COALESCE(PE.V_CODUBIGEO,'000000') V_CODUBIGEO, COALESCE(PE.V_DIRECPERS,'') V_DIRECPERS, COALESCE(PE.N_TM1SITPER,0) N_TM1SITPER, "+
								"	PE.D_FECHNACIM, COALESCE(PE.N_TM2PAIS,0) N_TM2PAIS, COALESCE(PE.N_TM2ESTCIV,0) N_TM2ESTCIV, PE.N_TM2SEXO, COALESCE(PE.V_CODLENGUA,0) V_CODLENGUA, "+
								"	COALESCE(PE.V_TELEFONO,'') V_TELEFONO, COALESCE(PE.V_CORREO,'') V_CORREO, PE.V_FLGEST, "+
								"	COALESCE(PE.N_CODUSUREG,0) N_CODUSUREG, COALESCE(PE.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(PE.V_HOSTREG,'') V_HOSTREG, "+
								"	COALESCE(PE.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(PE.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(PE.V_HOSTMOD,'') V_HOSTMOD, COALESCE(PE.V_NOMBFOTOP,'') V_NOMBFOTOP "+
								" FROM	GENE.LEOTBC_PERSONA PE INNER JOIN ACAD.LEOTBC_DOCENTE DOC ON PE.N_CODPERSO = DOC.N_CODPERSO AND PE.v_flgest = '1' AND DOC.v_flgest = '1' "+
								" INNER JOIN ACAD.LEOTBD_DOCENTEINSTI DOI ON DOC.N_CODDOCEN = DOI.N_CODDOCEN AND DOI.v_flgest = '1'  AND DOI.N_CODINSTI =" +liCodInst;
					 
							
							
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
					System.out.println("Tabla>>GENE.LEOTBC_PERSONA" );
					pw.println("Tabla>>GENE.LEOTBC_PERSONA" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
							System.out.println("lsCadena " + lsCadena);						
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
					lsConsult = "SELECT  NA.N_CODPERNAC, NA.N_CODPERSO, COALESCE(NA.N_TM2PAIS,0) N_TM2PAIS, NA.V_FLGEST,  "+
								"	COALESCE(NA.N_CODUSUREG,0) N_CODUSUREG, COALESCE(NA.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(NA.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(NA.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(NA.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(NA.V_HOSTMOD,'') V_HOSTMOD  "+
								" FROM	GENE.LEOTBD_PERNACIO NA INNER JOIN GENE.LEOTBC_PERSONA PE ON NA.N_CODPERSO = PE.N_CODPERSO AND  NA.v_flgest = '1'  "+
								" INNER JOIN ACAD.LEOTBC_DOCENTE DOC ON PE.N_CODPERSO = DOC.N_CODPERSO AND PE.v_flgest = '1' AND DOC.v_flgest = '1' "+
								" INNER JOIN ACAD.LEOTBD_DOCENTEINSTI DOI ON DOC.N_CODDOCEN = DOI.N_CODDOCEN AND DOI.v_flgest = '1'  AND DOI.N_CODINSTI ="+liCodInst;
							/*	"	FROM	ACAD.LEOTBC_DOCENTE WHERE N_CODINSTI = "+liCodInst+") Z0 "+
								"WHERE	Z0.N_CODPERSO = PE.N_CODPERSO AND NA.N_CODPERSO = PE.N_CODPERSO";
								*/
					
					  
							 
							 
							 
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>GENE.LEOTBD_PERNACIO" );
					pw.println("Tabla>>GENE.LEOTBD_PERNACIO" );
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
					lsConsult = "SELECT	PL.N_CODPERLEN, PL.N_CODPERSO, PL.N_CODLENGUA, PL.N_TM1TIPOLENGUA, PL.V_FLGEST,  "+
								"	COALESCE(PL.N_CODUSUREG,0) N_CODUSUREG, COALESCE(PL.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(PL.V_HOSTREG,'') V_HOSTREG,  "+ 
								"	COALESCE(PL.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(PL.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(PL.V_HOSTMOD,'') V_HOSTMOD  "+
								" FROM	GENE.LEOTBD_PERLENGUA PL   INNER JOIN ACAD.LEOTBC_DOCENTE DOC ON PL.N_CODPERSO = DOC.N_CODPERSO AND PL.v_flgest = '1' AND DOC.v_flgest = '1'"+ 
								" INNER JOIN ACAD.LEOTBD_DOCENTEINSTI DOI ON DOC.N_CODDOCEN = DOI.N_CODDOCEN AND DOI.v_flgest = '1'  AND DOI.N_CODINSTI ="+liCodInst;
							 
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>GENE.LEOTBD_PERLENGUA" );
					pw.println("Tabla>>GENE.LEOTBD_PERLENGUA" );
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
					lsConsult = "SELECT	DC.N_CODDOCEN, DC.N_CODPERSO, DC.N_CODINSTI, DC.N_CODLENGUA, COALESCE(DC.N_TM2GRADO,0) N_TM2GRADO, COALESCE(DC.N_TM2CARRERA,0) N_TM2CARRERA,  "+ 
								"	COALESCE(DC.N_TM1SITDOC,0) N_TM1SITDOC, DC.V_FLGEST,  "+
								"	COALESCE(DC.N_CODUSUREG,0) N_CODUSUREG, COALESCE(DC.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(DC.V_HOSTREG,'') V_HOSTREG, "+  
								"	COALESCE(DC.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(DC.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(DC.V_HOSTMOD,'') V_HOSTMOD "+
								" FROM 	ACAD.LEOTBC_DOCENTE DC INNER JOIN"+
								" ACAD.LEOTBD_DOCENTEINSTI DOI ON DC.N_CODDOCEN = DOI.N_CODDOCEN AND DOI.v_flgest = '1' AND  DC.v_flgest = '1'  AND DOI.N_CODINSTI= "+liCodInst;
					 
					   
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>ACAD.LEOTBC_DOCENTE" );
					pw.println("Tabla>>ACAD.LEOTBC_DOCENTE");
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
					lsConsult = "SELECT DE.N_CODDOCESP, DE.N_CODDOCEN, DE.N_CODLENGUA, COALESCE(DE.N_TM2NIVEL,0) N_TM2NIVEL, COALESCE(DE.V_FLGEST,'0') V_FLGEST, "+
								"	COALESCE(DE.N_CODUSUREG,0) N_CODUSUREG, COALESCE(DE.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(DE.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(DE.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(DE.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(DE.V_HOSTMOD,'') V_HOSTMOD, "+
								"  COALESCE(DE.V_RUTADOCU,'') V_RUTADOCU, COALESCE(DE.V_NUMDOCUM,'') V_NUMDOCUM "+
								" FROM	ACAD.LEOTMD_DOCENESPECI DE INNER JOIN ACAD.LEOTBC_DOCENTE DC ON DC.N_CODDOCEN = DE.N_CODDOCEN AND DE.v_flgest = '1'  "+ 
								" INNER JOIN ACAD.LEOTBD_DOCENTEINSTI DOI ON DC.N_CODDOCEN = DOI.N_CODDOCEN AND DOI.v_flgest = '1' AND  DC.v_flgest = '1'  AND DOI.N_CODINSTI ="+ liCodInst;
								 
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>ACAD.LEOTMD_DOCENESPECI" );
					pw.println("Tabla>>ACAD.LEOTMD_DOCENESPECI");
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
					lsConsult = "SELECT	DI.N_CODDOCENINST, DI.N_CODDOCEN, DI.N_CODINSTI, DI.N_TM1SITDOCINS, DI.V_FLGEST, "+
								"	COALESCE(DI.N_CODUSUREG,0) N_CODUSUREG, COALESCE(DI.D_FECREG,CURRENT_DATE) D_FECREG, COALESCE(DI.V_HOSTREG,'') V_HOSTREG,  "+
								"	COALESCE(DI.N_CODUSUMOD,0) N_CODUSUMOD, COALESCE(DI.D_FECMOD,CURRENT_DATE) D_FECMOD, COALESCE(DI.V_HOSTMOD,'') V_HOSTMOD "+
								" FROM ACAD.LEOTBC_DOCENTE DC "+
								" INNER JOIN ACAD.LEOTBD_DOCENTEINSTI DI ON DC.N_CODDOCEN = DI.N_CODDOCEN AND DI.v_flgest = '1' AND  DC.v_flgest = '1'  AND DI.N_CODINSTI ="+liCodInst;  
					
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>ACAD.LEOTBD_DOCENTEINSTI" );
					pw.println("Tabla>>ACAD.LEOTBD_DOCENTEINSTI" );
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
					
					pw.close();
					
				} catch (IOException e){
					lsRpta501 ="Error 03:"+e.getMessage();
					return lsRpta501;
				} catch(NullPointerException e) {
					lsRpta501 ="Error 04:"+e.getMessage();
					return lsRpta501;
				} finally {
					if (null != ps)
						ps.close();
					if (null != con)
						con.close();
				}
				
				break;
			/*case 1:
				lsTablSQL = "segu.leotbc_usuario";
				lsTabl003 = "acad.leotbc_alumno";
				lsTblUIns = "acad.leotbd_usumatricula";
				lsTabl004 = "acad.leomvc_matricula";
				lsTabl005 = "acad.leomvd_matalumno";
				lsArchivo = dir.getAbsolutePath()+this.getDiagonalFile()+lsPrefijo+liCodInst+liCodLeng+"usuarios-inscritos"+dateAsString+".txt";//"C:/natigu/"+lsPrefijo+"usuarios-inscritos.txt";
				
				lmDirFile = FileUtil.fileExists2(lsArchivo);
				// --Obtenemos todos los usuario con estado 1 y que no estén sincronizados
				//lsConsult = "SELECT 	n_codusuari, coalesce(v_nomusuari, '') v_nomusuari ,coalesce(v_passusuar, '') v_passusuar, coalesce(n_codperfil, 0) n_codperfil, coalesce(n_codperso, 0) n_codperso, n_tm1situsu, v_flgest, coalesce(n_codusureg, 0) n_codusureg, d_fecreg,coalesce(v_hostreg, '') v_hostreg, coalesce(n_codusumod, 0) n_codusumod, coalesce(d_fecmod,current_date) d_fecmod, coalesce(v_hostmod, '') v_hostmod, v_flgrestpas FROM 	segu.leotbc_usuario WHERE 	v_flgoffline = 0 AND v_flgest = '1';";
				
				try {
					lsConsult = "SELECT per.n_codperso, coalesce(per.v_apepatper,''), coalesce(per.v_apematper,'') v_apematper, coalesce(per.v_nombreper,'') v_nombreper, coalesce(per.n_tm1tpdope,0) n_tm1tpdope, "+
					       "coalesce(per.v_numdocum,'') v_numdocum, coalesce(per.n_tm1tipper,0) n_tm1tipper, coalesce(per.v_codubigeo,'000000') v_codubigeo, coalesce(per.v_direcpers,'') v_direcpers, coalesce(per.n_tm1sitper,0) n_tm1sitper, "+ 
					       "coalesce(per.d_fechnacim,current_date) d_fechnacim, coalesce(per.n_tm2pais,0) n_tm2pais, coalesce(per.n_tm2estciv,0) n_tm2estciv, coalesce(per.n_tm2sexo,0) n_tm2sexo, "+
					       "coalesce(per.v_codlengua,0) v_codlengua,  coalesce(per.v_telefono,'') v_telefono, coalesce(per.v_correo,'') v_correo, coalesce(per.v_flgest,'0') v_flgest, "+
					       "coalesce(per.n_codusureg, 0) n_codusureg, coalesce(per.d_fecreg,current_date) d_fecreg, coalesce(per.v_hostreg, '') v_hostreg, "+
					       "coalesce(per.n_codusumod, 0) n_codusumod, coalesce(per.d_fecmod,current_date) d_fecmod, coalesce(per.v_hostmod, '') v_hostmod, coalesce(per.v_nombfotop,'') v_nombfotop "+
					"FROM gene.leotbc_persona per,"
					+ " acad.leotbc_alumno alu "+
					"WHERE per.v_flgest='1'  AND alu.v_flgest='1' AND alu.n_codperso=per.n_codperso AND alu.n_codinsti = " +liCodInst;
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
					pw.println("Tabla>>gene.leotbc_persona" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					///////////////////////////////////////////////////////////
					///////////////////////////////////////////////////////////
					lsConsult = "SELECT 	n_codpernac, n_codperso, coalesce(n_tm2pais,0) n_tm2pais, coalesce(v_flgest,'0') v_flgest, "+
								"	coalesce(n_codusureg, 0) n_codusureg, coalesce(d_fecreg,current_date) d_fecreg, coalesce(v_hostreg, '') v_hostreg,  "+
								"	coalesce(n_codusumod, 0) n_codusumod, coalesce(d_fecmod,current_date) d_fecmod, coalesce(v_hostmod, '') v_hostmod "+
								"FROM  	gene.leotbd_pernacio "+
								"WHERE	v_flgest = '1' AND  n_codperso IN	(SELECT	per.n_codperso FROM  gene.leotbc_persona per,"
					+ " acad.leotbc_alumno alu "+
					"WHERE per.v_flgest='1'  AND alu.v_flgest='1' AND alu.n_codperso=per.n_codperso AND alu.n_codinsti = " +liCodInst+")";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbc_persona" );
					pw.println("Tabla>>gene.leotbd_pernacio" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}    
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					///////////////////////////////////////////////////////////
					///////////////////////////////////////////////////////////
					lsConsult = "SELECT	n_codperlen, n_codperso, coalesce(n_codlengua,0) n_codlengua, coalesce(n_tm1tipolengua,0) n_tm1tipolengua, coalesce(v_flgest,'0') v_flgest, "+ 
								"		coalesce(n_codusureg, 0) n_codusureg, coalesce(d_fecreg,current_date) d_fecreg, coalesce(v_hostreg, '') v_hostreg, "+
								"        coalesce(n_codusumod, 0) n_codusumod, coalesce(d_fecmod,current_date) d_fecmod, coalesce(v_hostmod, '') v_hostmod "+
								"FROM	gene.leotbd_perlengua "+ 
								"WHERE	v_flgest = '1' AND  n_codperso  IN	(SELECT	per.n_codperso FROM  gene.leotbc_persona per,"
					+ " acad.leotbc_alumno alu "+
					"WHERE per.v_flgest='1'  AND alu.v_flgest='1' AND alu.n_codperso=per.n_codperso AND alu.n_codinsti = " +liCodInst+")";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>leotbd_perlengua" );
					pw.println("Tabla>>gene.leotbd_perlengua" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					
					///////////////////////////////////////////////////////////
					///////////////////////////////////////////////////////////
					lsConsult = "SELECT	n_codalumno, n_codperso,n_codinsti,  coalesce(v_codubinst,'') v_codubinst, n_tm2progr, "+
								"coalesce(n_tm2nivel,0) n_tm2nivel, n_tm2grado, n_tm1sitalu, v_flgest, coalesce(n_codusureg, 0) n_codusureg, "+
								"coalesce(d_fecreg,current_date), coalesce(d_fecreg,current_date) d_fecreg, coalesce(v_hostreg, '') v_hostreg,coalesce(n_codusumod, 0) n_codusumod, coalesce(d_fecmod,current_date) d_fecmod, coalesce(v_hostmod, '') v_hostmod , "+
								"coalesce(n_monedas,0) n_monedas, coalesce(n_gemas,0) n_gemas "+
								"FROM	acad.leotbc_alumno where v_flgest='1' AND n_codinsti = " +liCodInst;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>leotbc_alumno" );
					pw.println("Tabla>>acad.leotbc_alumno");
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					//
					//
					lsConsult = "SELECT	n_codinscr, coalesce(n_codinsti,0) n_codinsti, coalesce(v_numcupos,'') v_numcupos, coalesce(n_codlengua,0) n_codlengua, coalesce(n_tm2sitin,0) n_tm2sitin, "+ 
										"coalesce(n_codusureg, 0) n_codusureg, coalesce(d_fecreg,current_date) d_fecreg, coalesce(v_hostreg, '') v_hostreg, "+
									    "coalesce(n_codusumod, 0) n_codusumod, coalesce(d_fecmod,current_date) d_fecmod, coalesce(v_hostmod, '') v_hostmod, "+
										"coalesce(v_periodo,'') v_periodo, coalesce(v_numdocum,'') v_numdocum, coalesce(v_nomdocum,'') v_nomdocum, coalesce(v_rutadocu,'') v_rutadocu, "+ 
										"coalesce(n_tm2ciclo,0) n_tm2ciclo, coalesce(d_fecharegistro,current_date) d_fecharegistro "+
								"FROM	acad.leotbc_inscripcion "+
								"WHERE	n_codinsti =  " +liCodInst;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>leotbc_inscripcion" );
					pw.println("Tabla>>acad.leotbc_inscripcion");
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					
					
					///////////////////////////////////////////////////////////
					///////////////////////////////////////////////////////////
					lsConsult = "SELECT	n_codinsclen, n_codinscr, n_codlengua, coalesce(v_numcupos,'') v_numcupos, coalesce(n_tm1sitinsclen,0) n_tm1sitinsclen,  "+
								"coalesce(v_flgest,'0') v_flgest,coalesce(n_codusureg, 0) n_codusureg, coalesce(d_fecreg,current_date) d_fecreg, coalesce(v_hostreg, '') v_hostreg, coalesce(n_codusumod, 0) n_codusumod, coalesce(d_fecmod,current_date) d_fecmod, coalesce(v_hostmod,'') v_hostmod, "+
								"v_numcuposdisp, n_tm2nivel "+
								"FROM	acad.leotbd_insclengua  "+
								"WHERE	v_flgest = '1' AND n_codinscr IN 	(SELECT n_codinscr FROM	acad.leotbc_inscripcion WHERE	n_codinsti = "+liCodInst+ ") "+
								"	AND n_codlengua = "+liCodLeng;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>leotbd_insclengua" );
					pw.println("Tabla>>acad.leotbd_insclengua" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					///
					///
					lsConsult = "SELECT	n_codmatri, coalesce(n_codlengua,0) n_codlengua, coalesce(n_tm2nivel,0) n_tm2nivel, coalesce(n_tm2subniv,0) n_tm2subniv, "+
								"coalesce(n_periodo,'') n_periodo,    coalesce(n_tm2ciclo,0) n_tm2ciclo, coalesce(n_tm1sitmat,0) n_tm1sitmat, coalesce(n_tm1tipmat,0) n_tm1tipmat,  "+
								"coalesce(v_observaci,'') v_observaci, n_flgmat,     v_flgest, coalesce(n_codusureg,0) n_codusureg, coalesce(d_fecreg,current_timestamp) d_fecreg,  "+
								"coalesce(v_hostreg, '') v_hostreg, coalesce(n_codusumod, 0) n_codusumod,     coalesce(d_fecmod,current_date) d_fecmod,  "+
								"coalesce(v_hostmod,'') v_hostmod, coalesce(n_codisnti,0) n_codisnti, coalesce(n_codinsclen,0) n_codinsclen, coalesce(v_numcuposrest,'') v_numcuposrest  "+
								"FROM	acad.leomvc_matricula  "+
								"WHERE	n_codinsclen IN (SELECT	n_codinsclen FROM	acad.leotbd_insclengua  WHERE	v_flgest = '1' AND n_codinscr IN (SELECT n_codinscr FROM	acad.leotbc_inscripcion WHERE	n_codinsti = "+liCodInst+ ") AND n_codlengua = "+liCodLeng+")";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leomvc_matricula");
					pw.println("Tabla>>acad.leomvc_matricula");
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					//
					//
					lsConsult = "SELECT 	n_coddocen, coalesce(n_codperso,0) n_codperso, coalesce(n_codinsti,0) n_codinsti, coalesce(n_codlengua,0) n_codlengua, coalesce(n_tm2grado,0) n_tm2grado, "+ 
								"	coalesce(n_tm2carrera,0) n_tm2carrera, coalesce(n_tm1sitdoc,0) n_tm1sitdoc, coalesce(v_flgest,'0') v_flgest, "+
								"	coalesce(n_codusureg, 0) n_codusureg, coalesce(d_fecreg,current_date) d_fecreg, coalesce(v_hostreg, '') v_hostreg, " +
							    "   coalesce(n_codusumod, 0) n_codusumod,     coalesce(d_fecmod,current_date) d_fecmod, "+ 
								"	coalesce(v_hostmod,'') v_hostmod "+
								"FROM 	acad.leotbc_docente "+
								"WHERE	v_flgest = '1' AND n_codinsti = "+liCodInst+ " AND n_codlengua = "+liCodLeng+";";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leotbc_docente" );
					pw.println("Tabla>>acad.leotbc_docente" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					//
					//
					lsConsult = "SELECT	n_codmatalu, n_codmatri, n_codalumno, coalesce(n_tm1sitmal,0) n_tm1sitmal, v_flgest, "+
							"coalesce(n_codusureg, 0) n_codusureg,  coalesce(d_fecreg,current_date) d_fecreg, coalesce(v_hostreg, '') v_hostreg,  "+
							"coalesce(n_codusumod, 0) n_codusumod,  coalesce(d_fecmod,current_date) d_fecmod, coalesce(v_hostmod, '') v_hostmod "+
							"FROM	acad.leomvd_matalumno "+
							"WHERE	n_codmatri IN (SELECT	n_codmatri "+
							"FROM	acad.leomvc_matricula where n_codinsclen IN (SELECT	n_codinsclen FROM	acad.leotbd_insclengua  WHERE 	n_codlengua="+liCodLeng+" AND n_tm1sitinsclen = '1'  "+
							"and n_codinscr IN (SELECT	n_codinscr FROM	acad.leotbc_inscripcion WHERE	n_codinsti =  " +liCodInst+ ")))";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leomvd_matalumno" );
					pw.println("Tabla>>acad.leomvd_matalumno" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					//
					//
					lsConsult = "SELECT	n_codmatdoc, n_codmatri, n_coddocen, coalesce(n_tm1tipdoc,0) n_tm1tipdoc, coalesce(n_tm1sitmdo,0) n_tm1sitmdo, coalesce(v_flgest,'0') v_flgest, "+
								"coalesce(n_codusureg, 0) n_codusureg, d_fecreg, coalesce(v_hostreg, '') v_hostreg, "+
								"coalesce(n_codusumod, 0) n_codusumod,     coalesce(d_fecmod,current_date) d_fecmod,  "+
								"coalesce(v_hostmod,'') v_hostmod "+
								"FROM	acad.leomvd_matdocente "+
								"WHERE	n_codmatri IN 	(SELECT	n_codmatri "+
								"		FROM	acad.leomvc_matricula where n_codinsclen IN (SELECT	n_codinsclen FROM	acad.leotbd_insclengua  WHERE 	n_codlengua="+liCodLeng+" AND n_tm1sitinsclen = '1' "+
								"		and n_codinscr IN (SELECT	n_codinscr FROM	acad.leotbc_inscripcion WHERE	n_codinsti=  " +liCodInst+ ")))";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leomvd_matdocente");
					pw.println("Tabla>>acad.leomvd_matdocente");
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					//
					//
					lsConsult = "SELECT	n_coddocinscri, n_codinscr, coalesce(v_rutadocu,'') v_rutadocu, v_flgest, "+
								"coalesce(n_codusureg, 0) n_codusureg, coalesce(d_fecreg,current_date) d_fecreg, coalesce(v_hostreg, '') v_hostreg,  "+
								"coalesce(n_codusumod, 0) n_codusumod,  coalesce(d_fecmod,current_date) d_fecmod, coalesce(v_hostmod, '') v_hostmod, "+
								"coalesce(v_numedocu,'') v_numedocu, coalesce(v_nombdocu,'') v_nombdocu, coalesce(n_sitdocinscri,0) n_sitdocinscri "+
								"FROM	acad.leotbc_docinscripcion "+
								"WHERE	n_codinscr IN (SELECT n_codinscr FROM acad.leotbc_inscripcion WHERE	v_flgest = '1' AND  n_codinsti = " +liCodInst+")";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leotbc_docinscripcion");
					pw.println("Tabla>>acad.leotbc_docinscripcion");
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					
					//
					//
					lsConsult = "SELECT 	n_coddoceninst, n_coddocen, n_codinsti, coalesce(n_tm1sitdocins,0) n_tm1sitdocins, v_flgest, "+
								"		coalesce(n_codusureg, 0) n_codusureg, coalesce(d_fecreg,current_date) d_fecreg, coalesce(v_hostreg, '') v_hostreg,  "+
								"		coalesce(n_codusumod, 0) n_codusumod,  coalesce(d_fecmod,current_date) d_fecmod, coalesce(v_hostmod, '') v_hostmod "+
								"FROM 	acad.leotbd_docenteinsti "+
								"WHERE	n_codinsti = "+liCodInst;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leotbd_docenteinsti" );
					pw.println("Tabla>>acad.leotbd_docenteinsti" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					//
					//
					lsConsult = "SELECT 	n_codalumninsti, coalesce(n_codalumno,0) n_codalumno, coalesce(n_codinsti,0) n_codinsti, coalesce(n_tm1sitaluminsti,0) n_tm1sitaluminsti, "+ 
								"v_flgest, coalesce(n_codusureg,0) n_codusureg, coalesce(d_fecreg, current_timestamp) d_fecreg, coalesce(v_hostreg,'') v_hostreg, coalesce(n_codusumod, 0) n_codusumod,  "+
								"coalesce(d_fecmod,current_timestamp) d_fecmod, coalesce(v_hostmod,'') v_hostmod "+
								"FROM 	acad.leotbd_alumnoinsti "+
								"WHERE	n_codinsti = " +liCodInst;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leotbd_alumnoinsti" );
					pw.println("Tabla>>acad.leotbd_alumnoinsti");
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}

					lsConsult = "SELECT 	usu.n_codusuari, coalesce(usu.v_nomusuari, '') v_nomusuari ,coalesce(usu.v_passusuar, '') v_passusuar, coalesce(usu.n_codperfil, 0) n_codperfil, "+
							"coalesce(usu.n_codperso, 0) n_codperso, usu.n_tm1situsu, usu.v_flgest, coalesce(usu.n_codusureg, 0) n_codusureg, coalesce(usu.d_fecreg,current_date) d_fecreg, "+
							"coalesce(usu.v_hostreg, '') v_hostreg, coalesce(usu.n_codusumod, 0) n_codusumod, coalesce(usu.d_fecmod,current_date) d_fecmod, coalesce(usu.v_hostmod, '') v_hostmod, "+ 
							"usu.v_flgrestpas, insl.n_codinsclen ,mat.n_codinsclen, insl.n_codinscr "+
							"FROM 	segu.leotbc_usuario usu, "+
							"acad.leotbd_usumatricula usm, "+
							"acad.leomvc_matricula mat, "+
							"acad.leotbd_insclengua insl, "+
							"acad.leotbc_inscripcion insc "+
							"WHERE	usm.n_codusuari = usu.n_codusuari AND usm.v_flgest = '1'  AND "+ 
							"mat.n_codmatri = usm.n_codmatri and mat.v_flgest = '1'  AND "+
							"insc.n_codinsti = " +liCodInst+ " AND insc.v_flgest = '1' AND insc.n_codinscr = insl.n_codinscr AND  "+
							"insl.n_codinsclen = mat.n_codinsclen AND insl.n_codlengua = "+liCodLeng+"  AND insl.n_tm1sitinsclen = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>segu.leotbc_usuario");
					pw.println("Tabla>>segu.leotbc_usuario");
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
				
					
					
					lsConsult = "SELECT  usm.n_codusumat, usm.n_codinsclen, coalesce(usm.n_codmatri,0) n_codmatri, usm.n_codusuari, coalesce(usm.n_codalumno,0) n_codalumno, usm.n_tm1situsu,  "+ 
							"usm.v_flgest, coalesce(usm.n_codusureg, 0) n_codusureg, usm.d_fecreg, coalesce(usm.v_hostreg, '') v_hostreg, coalesce(usm.n_codusumod, 0) n_codusumod,  "+  
							"coalesce(usm.d_fecmod,current_date) d_fecmod, coalesce(usm.v_hostmod, '') v_hostmod,	usm.n_tm1tipocupo  "+ 
							"FROM 	acad.leotbd_usumatricula usm, "+
							"acad.leomvc_matricula mat, "+
							"acad.leotbd_insclengua  insl,	 "+
							"acad.leotbc_inscripcion insc "+
							"WHERE	usm.v_flgest = '1'  AND  "+
							"mat.n_codmatri = usm.n_codmatri and mat.v_flgest = '1'  AND "+
							"insc.n_codinsti = " +liCodInst+ " AND insc.v_flgest = '1' AND insc.n_codinscr = insl.n_codinscr AND "+  
							"insl.n_codinsclen = mat.n_codinsclen AND insl.n_codlengua = "+liCodLeng+" AND insl.n_tm1sitinsclen = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>acad.leotbd_usumatricula" );
					pw.println("Tabla>>acad.leotbd_usumatricula" );
					for (Row row : table) {
						String lsCadena = "";
						for (Entry<Object, Class> col : row.row) {
							lsCadena = lsCadena.concat("<<'" + ((col.getValue()).cast(col.getKey())) + "'>>");
						}
						//System.out.println("Cadena" + lsCadena);
						pw.println(lsCadena.replace("\n", "").replace("\r", ""));
					}
					pw.close();
					
				} catch (IOException e){
					lsRpta501 =e.getMessage();
					return lsRpta501;
				} catch(NullPointerException e) {
					lsRpta501 =e.getMessage();
					return lsRpta501;
				} finally {
					if (null != ps)
						ps.close();
					if (null != con)
						con.close();
				}
				
				break;*/
			case 2:
				lsArchivo = dir.getAbsolutePath()+this.getDiagonalFile()+lsPrefijo+liCodInst+liCodLeng+"seguimiento-usuarios"+dateAsString+".txt"; //"C:/natigu/"+lsPrefijo+"seguimiento-usuarios.txt";
				lmDirFile = FileUtil.fileExists2(lsArchivo);
				try{
					lsConsult = "SELECT AM.n_codaluxmeda, AM.n_codusumat, AM.n_codpremio, AM.v_flgest,  "+
								"		coalesce(AM.n_codusureg,0) n_codusureg, coalesce(AM.d_fecreg, current_date) d_fecreg, coalesce(AM.v_hostreg,'') v_hostreg,  "+
								"		coalesce(AM.n_codusumod,0) n_codusumod, coalesce(AM.d_fecmod, current_date) d_fecmod ,coalesce(AM.v_hostmod,'') v_hostmod, "+ 
								"		coalesce(AM.n_codundlec,0) n_codundlec "+ 
								"FROM 	acad.leotbd_alumnoxmedalla AM,  "+ 
								"	ACAD.LEOTBD_USUMATRICULA UM,  "+ 
								"	ACAD.LEOTBD_INSCLENGUA IL, "+ 
								"	ACAD.LEOTBC_INSCRIPCION IC  "+ 
								"WHERE	IL.N_CODINSCLEN = UM.N_CODINSCLEN AND AM.N_CODUSUMAT = UM.N_CODUSUMAT "+ 
								"	AND IL.N_CODLENGUA = "+liCodLeng+" AND IL.N_CODINSCR = IC.N_CODINSCR AND IC.N_CODINSTI = " + liCodInst;
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
								"FROM	acad.leotbd_alumnoxmonegem  AM,  "+ 
								"	ACAD.LEOTBD_USUMATRICULA UM,  "+ 
								"	ACAD.LEOTBD_INSCLENGUA IL, "+ 
								"	ACAD.LEOTBC_INSCRIPCION IC  "+ 
								"WHERE	IL.N_CODINSCLEN = UM.N_CODINSCLEN AND AM.N_CODUSUMAT = UM.N_CODUSUMAT "+ 
								"	AND IL.N_CODLENGUA = "+liCodLeng+" AND IL.N_CODINSCR = IC.N_CODINSCR AND IC.N_CODINSTI = " + liCodInst;
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
								"FROM	acad.leotbc_segaluejercicio   AM,  "+ 
								"	ACAD.LEOTBD_USUMATRICULA UM,  "+ 
								"	ACAD.LEOTBD_INSCLENGUA IL, "+ 
								"	ACAD.LEOTBC_INSCRIPCION IC  "+ 
								"WHERE	IL.N_CODINSCLEN = UM.N_CODINSCLEN AND AM.N_CODUSUMAT = UM.N_CODUSUMAT "+ 
								"	AND IL.N_CODLENGUA = "+liCodLeng+" AND IL.N_CODINSCR = IC.N_CODINSCR AND IC.N_CODINSTI = " + liCodInst;
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
								"FROM	acad.leotbd_segaluejerdet    AM,  "+ 
								"	ACAD.LEOTBD_USUMATRICULA UM,  "+ 
								"	ACAD.LEOTBD_INSCLENGUA IL, "+ 
								"	ACAD.LEOTBC_INSCRIPCION IC  "+ 
								"WHERE	IL.N_CODINSCLEN = UM.N_CODINSCLEN AND AM.N_CODUSUMAT = UM.N_CODUSUMAT "+ 
								"	AND IL.N_CODLENGUA = "+liCodLeng+" AND IL.N_CODINSCR = IC.N_CODINSCR AND IC.N_CODINSTI = " + liCodInst;
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
								"FROM	acad.leotbd_segaluintentos  AM,  "+ 
								"	ACAD.LEOTBD_USUMATRICULA UM,  "+ 
								"	ACAD.LEOTBD_INSCLENGUA IL, "+ 
								"	ACAD.LEOTBC_INSCRIPCION IC  "+ 
								"WHERE	IL.N_CODINSCLEN = UM.N_CODINSCLEN AND AM.N_CODUSUMAT = UM.N_CODUSUMAT "+ 
								"	AND IL.N_CODLENGUA = "+liCodLeng+" AND IL.N_CODINSCR = IC.N_CODINSCR AND IC.N_CODINSTI = " + liCodInst;
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
					lsConsult = "SELECT	AM.n_codsegalu, AM.n_codusumat, AM.n_tm1sitseg, coalesce(AM.n_codundlec,0) n_codundlec, AM.v_flgest, "+
								"		coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg, coalesce(AM.v_hostreg, '') v_hostreg,   "+
								"		coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod, "+ 
								"		coalesce(AM.n_codmatpej, 0) n_codmatpej, coalesce(AM.n_codlesmat,0) n_codlesmat  "+  
								"FROM	acad.leotbd_segalumlen   AM,  "+ 
								"	ACAD.LEOTBD_USUMATRICULA UM,  "+ 
								"	ACAD.LEOTBD_INSCLENGUA IL, "+ 
								"	ACAD.LEOTBC_INSCRIPCION IC  "+ 
								"WHERE	IL.N_CODINSCLEN = UM.N_CODINSCLEN AND AM.N_CODUSUMAT = UM.N_CODUSUMAT "+ 
								"	AND IL.N_CODLENGUA = "+liCodLeng+" AND IL.N_CODINSCR = IC.N_CODINSCR AND IC.N_CODINSTI = " + liCodInst;
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
								"FROM	conf.leotbc_adquiusu AM,  "+ 
								"	ACAD.LEOTBD_USUMATRICULA UM,  "+ 
								"	ACAD.LEOTBD_INSCLENGUA IL, "+ 
								"	ACAD.LEOTBC_INSCRIPCION IC  "+ 
								"WHERE	IL.N_CODINSCLEN = UM.N_CODINSCLEN AND AM.N_CODUSUARI = UM.N_CODUSUARI "+ 
								"	AND IL.N_CODLENGUA = "+liCodLeng+" AND IL.N_CODINSCR = IC.N_CODINSCR AND IC.N_CODINSTI = " + liCodInst;
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
								"FROM	acad.leotbc_evaluacion  AM,  "+ 
								"	ACAD.LEOTBD_USUMATRICULA UM,  "+ 
								"	ACAD.LEOTBD_INSCLENGUA IL, "+ 
								"	ACAD.LEOTBC_INSCRIPCION IC  "+ 
								"WHERE	IL.N_CODINSCLEN = UM.N_CODINSCLEN AND AM.N_CODUSUMAT = UM.N_CODUSUMAT "+ 
								"	AND IL.N_CODLENGUA = "+liCodLeng+" AND IL.N_CODINSCR = IC.N_CODINSCR AND IC.N_CODINSTI = " + liCodInst;
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
								"FROM	acad.leotbd_evaldetalle  AM, "+
								"	acad.leotbc_evaluacion EV,  "+ 
								"	ACAD.LEOTBD_USUMATRICULA UM,  "+ 
								"	ACAD.LEOTBD_INSCLENGUA IL, "+ 
								"	ACAD.LEOTBC_INSCRIPCION IC  "+ 
								"WHERE	IL.N_CODINSCLEN = UM.N_CODINSCLEN AND EV.N_CODUSUMAT = UM.N_CODUSUMAT "+ 
								"	AND EV.n_codevalua = AM.n_codevalua AND IL.N_CODLENGUA = "+liCodLeng+" AND IL.N_CODINSCR = IC.N_CODINSCR AND IC.N_CODINSTI = " + liCodInst;
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
					
					pw.println(lsCadena.replace("\n", "").replace("\r", ""));
				}
				
				lsConsult = "SELECT	AM.n_codaluxbono, AM.n_codusumat, AM.n_codbono, AM.v_flgest, "+
							"	coalesce(AM.n_codusureg, 0) n_codusureg, coalesce(AM.d_fecreg,current_date) d_fecreg, coalesce(AM.v_hostreg, '') v_hostreg, "+ 
							"	coalesce(AM.n_codusumod, 0) n_codusumod, coalesce(AM.d_fecmod,current_date) d_fecmod, coalesce(AM.v_hostmod, '') v_hostmod, "+
							"	COALESCE(AM.n_codundlec,0) n_codundlec "+
							"FROM	acad.leotbd_alumnoxbono AM, "+
							"	ACAD.LEOTBD_USUMATRICULA UM,  "+ 
							"	ACAD.LEOTBD_INSCLENGUA IL, "+ 
							"	ACAD.LEOTBC_INSCRIPCION IC  "+ 
							"WHERE	IL.N_CODINSCLEN = UM.N_CODINSCLEN AND AM.N_CODUSUMAT = UM.N_CODUSUMAT "+ 
							"	AND IL.N_CODLENGUA = "+liCodLeng+" AND IL.N_CODINSCR = IC.N_CODINSCR AND IC.N_CODINSTI = " + liCodInst;
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
					}
					
					pw.println(lsCadena.replace("\n", "").replace("\r", ""));
				}
					
					pw.close();
				} catch (IOException e){
					lsRpta501 ="Error 05:"+ e.getMessage();
					return lsRpta501;
				} catch(NullPointerException e) {
					lsRpta501 = "Error 06:"+e.getMessage();
					return lsRpta501;
				} finally {
					if (null != ps)
						ps.close();
					if (null != con)
						con.close();
				}
				break;
			case 3:
				lsTablSQL = "gene.leotbd_lecmaterial";
				//lsTblUIns = "acad.leotbc_segaluejercicio";
				lsArchivo = dir.getAbsolutePath()+this.getDiagonalFile()+lsPrefijo+liCodInst+liCodLeng+"material"+dateAsString+".txt"; //"C:/natigu/"+lsPrefijo+"material-full.txt";
				lmDirFile = FileUtil.fileExists2(lsArchivo);
				
				try {
					lsConsult = "SELECT	n_codlengua, v_nomlengua, coalesce(v_deslengua,'') v_deslengua, coalesce(v_exteimag,'') v_exteimag, coalesce(v_ubicimag,'') v_ubicimag, "+ 
								"		coalesce(v_nombimag,'') v_nombimag, coalesce(v_pesoimag,'') v_pesoimag, coalesce(v_tamaimag,'') v_tamaimag, coalesce(n_tm1sitlen,0) n_tm1sitlen, v_flgest, "+ 
								"		coalesce(n_codusureg, 0) n_codusureg, coalesce(d_fecreg,current_timestamp) d_fecreg, coalesce(v_hostreg, '') v_hostreg,  "+
								"		coalesce(n_codusumod, 0) n_codusumod, coalesce(d_fecmod,current_timestamp) d_fecmod, coalesce(v_hostmod, '') v_hostmod "+
								"FROM	gene.leotbc_lengua WHERE v_flgest = '1' and N_CODLENGUA =" + liCodLeng;
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
					System.out.println("Tabla>>gene.leotbc_lengua" );
					pw.println("Tabla>>gene.leotbc_lengua" );
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
					lsConsult = "SELECT 	ls.n_codlenest, ls.n_codlengua, ls.n_tm2nivel, coalesce(ls.n_tm2subnivel,0) n_tm2subnivel, coalesce(ls.n_tm1sitest,0) n_tm1sitest, "+
								"		ls.v_swactivo, ls.v_flgest,  "+
								"		coalesce(ls.n_codusureg, 0) n_codusureg, coalesce(ls.d_fecreg,current_timestamp) d_fecreg, coalesce(ls.v_hostreg, '') v_hostreg,  "+ 
								"		coalesce(ls.n_codusumod, 0) n_codusumod, coalesce(ls.d_fecmod,current_timestamp) d_fecmod, coalesce(ls.v_hostmod, '') v_hostmod,   "+
								"		coalesce(ls.v_nombnivel,'') v_nombnivel, coalesce(ls.n_codlenniv,0) n_codlenniv, coalesce(ls.v_nombimag,'') v_nombimag  "+
								"FROM 	gene.leotbd_lenguaestruc ls  "+
								"		INNER JOIN gene.leotbc_lengua le  "+
								"		ON le.n_codlengua = ls.n_codlengua AND LE.N_CODLENGUA = "+liCodLeng;
								//"WHERE	ls.v_flgest='1'	";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_lenguaestruc" );
					pw.println("Tabla>>gene.leotbd_lenguaestruc" );
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
					lsConsult = "SELECT 	ls.n_codlenleccion, ls.n_codlengua, coalesce(ls.n_tm2leccion,0) n_tm2leccion, coalesce(ls.v_nombimag,'') v_nombimag, "+
								"	coalesce(ls.v_nomleccion,'') v_nomleccion, ls.v_flgest, "+
								"	coalesce(ls.n_codusureg, 0) n_codusureg, coalesce(ls.d_fecreg,current_timestamp) d_fecreg, coalesce(ls.v_hostreg, '') v_hostreg,  "+ 
								"	coalesce(ls.n_codusumod, 0) n_codusumod, coalesce(ls.d_fecmod,current_timestamp) d_fecmod, coalesce(ls.v_hostmod, '') v_hostmod,  "+
								"	coalesce(ls.v_nombimagbloq,'') v_nombimagbloq  "+
								"FROM 	gene.leotbd_lengualeccion ls  "+
								"	INNER JOIN gene.leotbc_lengua le  "+
								"		ON le.n_codlengua = ls.n_codlengua AND LE.N_CODLENGUA = "+liCodLeng;
								//"WHERE	ls.v_flgest='1'	";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_lengualeccion" );
					pw.println("Tabla>>gene.leotbd_lengualeccion" );
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
					lsConsult = "SELECT 	ls.n_codlenniv, ls.n_codlengua, coalesce(ls.n_tm2nivel,0) n_tm2nivel, coalesce(ls.v_nombnivel,'') v_nombnivel, coalesce(ls.v_nombimag,'') v_nombimag, "+ 
								"	coalesce(ls.n_tm1sitleniv,0) n_tm1sitleniv, ls.v_flgest, "+
								"	coalesce(ls.n_codusureg, 0) n_codusureg, coalesce(ls.d_fecreg,current_timestamp) d_fecreg, coalesce(ls.v_hostreg, '') v_hostreg, "+ 
								"	coalesce(ls.n_codusumod, 0) n_codusumod, coalesce(ls.d_fecmod,current_timestamp) d_fecmod, coalesce(ls.v_hostmod, '') v_hostmod,  "+
								"	coalesce(ls.v_nomunidad,'') v_nomunidad "+
								"FROM 	gene.leotbd_lenguanivel ls "+
								"	INNER JOIN gene.leotbc_lengua le "+
								"		ON le.n_codlengua = ls.n_codlengua AND LE.N_CODLENGUA = "+liCodLeng;
								//"WHERE	ls.v_flgest='1'	";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_lenguanivel" );
					pw.println("Tabla>>gene.leotbd_lenguanivel" );
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
					lsConsult = "SELECT 	ls.n_codlenunidad, ls.n_codlengua, coalesce(ls.n_tm2unidad,0) n_tm2unidad, coalesce(ls.v_nombimag,'') v_nombimag, ls.v_flgest, "+ 
								"	coalesce(ls.n_codusureg, 0) n_codusureg, coalesce(ls.d_fecreg,current_timestamp) d_fecreg, coalesce(ls.v_hostreg, '') v_hostreg,  "+
								"	coalesce(ls.n_codusumod, 0) n_codusumod, coalesce(ls.d_fecmod,current_timestamp) d_fecmod, coalesce(ls.v_hostmod, '') v_hostmod,   "+
								"	coalesce(ls.v_nomunidad,'') v_nomunidad, coalesce(ls.v_nombimagbloq,'') v_nombimagbloq "+
								"FROM 	gene.leotbd_lenguaunidad ls "+
								"	INNER JOIN gene.leotbc_lengua le "+
								"		ON le.n_codlengua = ls.n_codlengua AND LE.N_CODLENGUA = "+liCodLeng;
								//"WHERE	ls.v_flgest='1'	";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_lenguaunidad" );
					pw.println("Tabla>>gene.leotbd_lenguaunidad" );
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
					lsConsult = "SELECT 	ls.n_codlesuni, ls.n_codlenest, coalesce(ls.n_tm2unidad,0) n_tm2unidad, coalesce(ls.v_desunidad,'') v_desunidad, coalesce(ls.n_tm1sitund,0) n_tm1sitund, ls.v_flgest, "+
								"	coalesce(ls.n_codusureg, 0) n_codusureg, coalesce(ls.d_fecreg,current_timestamp) d_fecreg, coalesce(ls.v_hostreg, '') v_hostreg,   "+
								"	coalesce(ls.n_codusumod, 0) n_codusumod, coalesce(ls.d_fecmod,current_timestamp) d_fecmod, coalesce(ls.v_hostmod, '') v_hostmod,   "+
								"	coalesce(ls.v_nomunidad,'') v_nomunidad, coalesce(ls.v_nombimag,'') v_nombimag  "+
								"FROM 	gene.leotbd_lestunidad ls  "+
								"	INNER JOIN gene.leotbd_lenguaestruc es  "+
								"		ON es.n_codlenest = ls.n_codlenest  "+
								"		INNER JOIN gene.leotbc_lengua le  "+
								"			ON le.n_codlengua = es.n_codlengua  AND LE.N_CODLENGUA = "+liCodLeng;
								//"WHERE	ls.v_flgest='1'	";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_lestunidad" );
					pw.println("Tabla>>gene.leotbd_lestunidad" );
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
					lsConsult = "SELECT 	ls.n_codundlec, ls.n_codlesuni, coalesce(ls.v_nomleccion,'') v_nomleccion, coalesce(ls.v_desleccion,'') v_desleccion, coalesce(ls.n_tm1sitlec,0) n_tm1sitlec, "+ 
								"	ls.v_flgest,   "+
								"	coalesce(ls.n_codusureg, 0) n_codusureg, coalesce(ls.d_fecreg,current_timestamp) d_fecreg, coalesce(ls.v_hostreg, '') v_hostreg,  "+ 
								"	coalesce(ls.n_codusumod, 0) n_codusumod, coalesce(ls.d_fecmod,current_timestamp) d_fecmod, coalesce(ls.v_hostmod, '') v_hostmod,   "+
								"	coalesce(ls.n_tm2leccion,0) n_tm2leccion, coalesce(ls.v_nombimag,'') v_nombimag  "+
								"FROM 	gene.leotbd_leundleccion ls "+
								"	INNER JOIN gene.leotbd_lestunidad lu  "+
								"		ON lu.n_codlesuni = ls.n_codlesuni "+
								"		INNER JOIN gene.leotbd_lenguaestruc es  "+
								"			ON es.n_codlenest = lu.n_codlenest   "+
								"			INNER JOIN gene.leotbc_lengua le  "+
								"				ON le.n_codlengua = es.n_codlengua AND LE.N_CODLENGUA = "+liCodLeng;
								//"WHERE	ls.v_flgest='1'	";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_leundleccion" );
					pw.println("Tabla>>gene.leotbd_leundleccion" );
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
					lsConsult = "SELECT 	ls.n_codlengua, coalesce(ls.v_intermedio,'') v_intermedio, coalesce(ls.v_avanzado,'') v_avanzado, coalesce(ls.v_basico,'') v_basico, "+ 
								"	coalesce(ls.n_codusureg, 0) n_codusureg, coalesce(ls.d_fecreg,current_timestamp) d_fecreg  "+
								"FROM 	gene.leotbd_templenguaes ls "+
								"	INNER JOIN gene.leotbc_lengua le "+
								"		ON le.n_codlengua = ls.n_codlengua  AND LE.N_CODLENGUA = "+liCodLeng;
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_templenguaes" );
					pw.println("Tabla>>gene.leotbd_templenguaes" );
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
					lsConsult = "SELECT 	ls.n_codlesmat, ls.n_codleslec, coalesce(ls.v_descmater,'') v_descmater, coalesce(ls.v_contexto,'') v_contexto, coalesce(ls.v_sweditable,'1') v_sweditable,  "+ 
								"	coalesce(ls.v_rutaaudio,'') v_rutaaudio, coalesce(ls.v_ubiimag,'') v_ubiimag, coalesce(ls.v_nomimag,'') v_nomimag, coalesce(ls.v_extimag,'') v_extimag,  "+
								"	coalesce(ls.n_tm1sitmat,0) n_tm1sitmat, ls.v_flgest,  "+
								"	coalesce(ls.n_codusureg, 0) n_codusureg, coalesce(ls.d_fecreg,current_timestamp) d_fecreg, coalesce(ls.v_hostreg, '') v_hostreg,  "+
								"	coalesce(ls.n_codusumod, 0) n_codusumod, coalesce(ls.d_fecmod,current_timestamp) d_fecmod, coalesce(ls.v_hostmod, '') v_hostmod,  "+
								"	coalesce(ls.n_tm1tpmat,0) n_tm1tpmat, coalesce(ls.v_comentario,'') v_comentario, coalesce(ls.n_orden,0) n_orden,  "+
								"	coalesce(ls.v_indicacion,'') v_indicacion, coalesce(ls.n_tiptramdoc,0) n_tiptramdoc, coalesce(ls.v_comprension,'') v_comprension  "+
								"FROM 	gene.leotbd_lecmaterial ls  "+
								"	INNER JOIN gene.leotbd_leundleccion lec "+
								"		ON lec.n_codundlec =  ls.n_codleslec "+
								"			INNER JOIN gene.leotbd_lestunidad leu "+
								"				ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"				INNER JOIN gene.leotbd_lenguaestruc len "+
								"					ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"					INNER JOIN gene.leotbc_lengua lengua  "+
								"						ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								//" WHERE	ls.v_flgest = '1' ";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_lecmaterial" );
					pw.println("Tabla>>gene.leotbd_lecmaterial" );
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
					lsConsult = "SELECT 	mt.n_codmatpej, mt.n_codlesmat, coalesce(mt.n_tm2tpejer,0) n_tm2tpejer, coalesce(mt.n_tm1sittip,0) n_tm1sittip, mt.v_flgest, "+
								"	coalesce(mt.n_codusureg, 0) n_codusureg, coalesce(mt.d_fecreg,current_timestamp) d_fecreg, coalesce(mt.v_hostreg, '') v_hostreg,  "+
								"	coalesce(mt.n_codusumod, 0) n_codusumod, coalesce(mt.d_fecmod,current_timestamp) d_fecmod, coalesce(mt.v_hostmod, '') v_hostmod, "+
								"	coalesce(mt.v_titulo,'') v_titulo, coalesce(mt.n_orden,0) n_orden, coalesce(mt.v_subtitulo,'') v_subtitulo, coalesce(mt.n_codlesmat_ant,0) n_codlesmat_ant,  "+ 
								"	coalesce(mt.v_comprension,'') v_comprension, coalesce(mt.v_expgram,'') v_expgram, coalesce(mt.n_flgpregu,0) n_flgpregu  "+
								"FROM 	gene.leotbd_lematxtipoej mt  "+
								"			INNER JOIN gene.leotbd_lecmaterial lma  "+
								"				ON lma.n_codlesmat = mt.n_codlesmat   "+
								"					INNER JOIN gene.leotbd_leundleccion lec  "+
								"						ON lec.n_codundlec =  lma.n_codleslec   "+
								"						INNER JOIN gene.leotbd_lestunidad leu "+
								"								ON leu.n_codlesuni = lec.n_codlesuni "+ 
								"								INNER JOIN gene.leotbd_lenguaestruc len "+
								"									ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"									INNER JOIN gene.leotbc_lengua lengua  "+
								"										ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								//"WHERE	mt.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_lematxtipoej" );
					pw.println("Tabla>>gene.leotbd_lematxtipoej" );
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
					lsConsult = "SELECT 	ar.n_codarmdoccab, ar.n_codmatpej, coalesce(ar.n_tm2tipdoc,0) n_tm2tipdoc, ar.v_flgest, "+
								"	coalesce(ar.n_codusureg, 0) n_codusureg, coalesce(ar.d_fecreg,current_timestamp) d_fecreg, coalesce(ar.v_hostreg, '') v_hostreg,  "+
								"	coalesce(ar.n_codusumod, 0) n_codusumod, coalesce(ar.d_fecmod,current_timestamp) d_fecmod, coalesce(ar.v_hostmod, '') v_hostmod,  "+
								"	coalesce(ar.v_titulo,'') v_titulo  "+
								"FROM 	gene.leotbc_armadocucab ar  "+
								"			INNER JOIN gene.leotbd_lematxtipoej ma  "+
								"				ON ma.n_codmatpej = ar.n_codmatpej  "+
								"						INNER JOIN gene.leotbd_lecmaterial lma  "+
								"							ON lma.n_codlesmat = ma.n_codlesmat   "+
								"								INNER JOIN gene.leotbd_leundleccion lec  "+
								"									ON lec.n_codundlec =  lma.n_codleslec   "+
								"						INNER JOIN gene.leotbd_lestunidad leu "+
								"								ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"								INNER JOIN gene.leotbd_lenguaestruc len "+
								"									ON len.n_codlenest =  leu.n_codlenest AND len.n_codlengua = "+liCodLeng+
								"									INNER JOIN gene.leotbc_lengua lengua  "+
								"										ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								////"WHERE	ar.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbc_armadocucab" );
					pw.println("Tabla>>gene.leotbc_armadocucab" );
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
					lsConsult = "SELECT 	ar.n_codarmdoc, ar.n_codarmdoccab, coalesce(n_tm2pardoc,0) n_tm2pardoc, coalesce(v_descripcion,'') v_descripcion, ar.v_flgest, "+ 
								"	coalesce(ar.n_codusureg,0) n_codusureg, coalesce(ar.d_fecreg,current_timestamp) d_fecreg, coalesce(ar.v_hostreg,'') v_hostreg,  "+
								"	coalesce(ar.n_codusumod,0) n_codusumod, coalesce(ar.d_fecmod,current_timestamp) d_fecmod, coalesce(ar.v_hostmod,'') v_hostmod,  "+
								"	coalesce(ar.n_tradtm2pdoc,'') n_tradtm2pdoc "+
								"FROM 	gene.leotbc_armadocu ar "+
								"	INNER JOIN gene.leotbc_armadocucab ac  "+
								"			ON ac.n_codarmdoccab = ar.n_codarmdoccab  "+
								"			INNER JOIN gene.leotbd_lematxtipoej ma  "+
								"				ON ma.n_codmatpej = ac.n_codmatpej   "+
								"						INNER JOIN gene.leotbd_lecmaterial lma  "+
								"							ON lma.n_codlesmat = ma.n_codlesmat   "+
								"								INNER JOIN gene.leotbd_leundleccion lec  "+
								"									ON lec.n_codundlec =  lma.n_codleslec  "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								////"WHERE	ar.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbc_armadocu" );
					pw.println("Tabla>>gene.leotbc_armadocu" );
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
					lsConsult = "SELECT 	ar.n_codarrastraora, ar.n_codmatpej, coalesce(ar.v_titulo,'') v_titulo, coalesce(ar.v_oracion,'') v_oracion, ar.v_flgest, "+ 
								"	coalesce(ar.n_codusureg,0) n_codusureg, coalesce(ar.d_fecreg,current_timestamp) d_fecreg, coalesce(ar.v_hostreg,'') v_hostreg,  "+
								"	coalesce(ar.n_codusumod,0) n_codusumod, coalesce(ar.d_fecmod,current_timestamp) d_fecmod, coalesce(ar.v_hostmod,'') v_hostmod  "+
								"FROM 	gene.leotbc_arrastraoraciones ar  "+
								"			INNER JOIN gene.leotbd_lematxtipoej ma  "+
								"				ON ma.n_codmatpej = ar.n_codmatpej  "+
								"						INNER JOIN gene.leotbd_lecmaterial lma  "+
								"							ON lma.n_codlesmat = ma.n_codlesmat   "+
								"								INNER JOIN gene.leotbd_leundleccion lec  "+
								"									ON lec.n_codundlec =  lma.n_codleslec   "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								////"WHERE	ar.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbc_arrastraoraciones" );
					pw.println("Tabla>>gene.leotbc_arrastraoraciones" );
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
					lsConsult = "SELECT 	ar.n_codcomporacion, ar.n_codmatpej, coalesce(ar.v_titulo,'') v_titulo, coalesce(ar.v_oracion,'') v_oracion, ar.v_flgest, "+
								"	coalesce(ar.n_codusureg,0) n_codusureg, coalesce(ar.d_fecreg,current_timestamp) d_fecreg, coalesce(ar.v_hostreg,'') v_hostreg,  "+
								"	coalesce(ar.n_codusumod,0) n_codusumod, coalesce(ar.d_fecmod,current_timestamp) d_fecmod, coalesce(ar.v_hostmod,'') v_hostmod "+
								"FROM 	gene.leotbc_oraxcompletar ar "+
								"			INNER JOIN gene.leotbd_lematxtipoej ma  "+
								"				ON ma.n_codmatpej = ar.n_codmatpej  "+
								"						INNER JOIN gene.leotbd_lecmaterial lma  "+
								"							ON lma.n_codlesmat = ma.n_codlesmat   "+
								"								INNER JOIN gene.leotbd_leundleccion lec  "+
								"									ON lec.n_codundlec =  lma.n_codleslec  "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								////"WHERE	ar.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbc_oraxcompletar" );
					pw.println("Tabla>>gene.leotbc_oraxcompletar" );
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
					lsConsult = "SELECT  ar.n_codordenarparrafocab, ar.n_codmatpej, coalesce(ar.v_titulo,'') v_titulo, ar.v_flgest, "+
								"	coalesce(ar.n_codusureg,0) n_codusureg, coalesce(ar.d_fecreg,current_timestamp) d_fecreg, coalesce(ar.v_hostreg,'') v_hostreg, "+ 
								"	coalesce(ar.n_codusumod,0) n_codusumod, coalesce(ar.d_fecmod,current_timestamp) d_fecmod, coalesce(ar.v_hostmod,'') v_hostmod, "+
								"	coalesce(ar.v_palabra,'') v_palabra,  coalesce(ar.v_comentario,'') v_comentario "+
								"FROM 	gene.leotbc_ordenarparrafocabecera ar "+
								"			INNER JOIN gene.leotbd_lematxtipoej ma "+
								"				ON ma.n_codmatpej = ar.n_codmatpej    "+
								"						INNER JOIN gene.leotbd_lecmaterial lma "+
								"							ON lma.n_codlesmat = ma.n_codlesmat  "+
								"								INNER JOIN gene.leotbd_leundleccion lec "+
								"									ON lec.n_codundlec =  lma.n_codleslec  "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								////"WHERE	ar.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbc_ordenarparrafocabecera" );
					pw.println("Tabla>>gene.leotbc_ordenarparrafocabecera" );
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
					lsConsult = "SELECT 	coalesce(ar.n_codordenarparrafo,0) n_codordenarparrafo, coalesce(ar.n_codmatpej,0) n_codmatpej, coalesce(ar.v_titulo,'') v_titulo, coalesce(ar.v_parrafo,'') v_parrafo, "+
								"	coalesce(ar.n_numorden,0) n_numorden, ar.v_flgest, "+
								"	coalesce(ar.n_codusureg,0) n_codusureg, coalesce(ar.d_fecreg,current_timestamp) d_fecreg, coalesce(ar.v_hostreg,'') v_hostreg, "+ 
								"	coalesce(ar.n_codusumod,0) n_codusumod, coalesce(ar.d_fecmod,current_timestamp) d_fecmod, coalesce(ar.v_hostmod,'') v_hostmod, "+
								"	coalesce(ar.n_codordenarparrafocab,0) n_codordenarparrafocab, coalesce(v_ordenar,false) v_ordenar,  "+
								"	coalesce(v_posini,0) v_posini, coalesce(v_posfin,0) v_posfin "+
								"FROM 	gene.leotbc_ordenarparrafo ar "+
								"	INNER JOIN gene.leotbc_ordenarparrafocabecera pa  "+
								"		ON ar.n_codordenarparrafocab = pa.n_codordenarparrafocab "+
								"		INNER JOIN gene.leotbd_lematxtipoej ma "+
								"			ON ma.n_codmatpej = pa.n_codmatpej   "+
								"					INNER JOIN gene.leotbd_lecmaterial lma "+
								"						ON lma.n_codlesmat = ma.n_codlesmat  "+
								"							INNER JOIN gene.leotbd_leundleccion lec "+
								"								ON lec.n_codundlec =  lma.n_codleslec  "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								//"WHERE	ar.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbc_ordenarparrafo" );
					pw.println("Tabla>>gene.leotbc_ordenarparrafo " );
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
					lsConsult = "SELECT 	ar.n_codrelcab, ar.n_codmatpej, coalesce(ar.v_titulo,'') v_titulo, ar.v_flgest, "+
								"	coalesce(ar.n_codusureg,0) n_codusureg, coalesce(ar.d_fecreg,current_timestamp) d_fecreg, coalesce(ar.v_hostreg,'') v_hostreg, "+ 
								"	coalesce(ar.n_codusumod,0) n_codusumod, coalesce(ar.d_fecmod,current_timestamp) d_fecmod, coalesce(ar.v_hostmod,'') v_hostmod "+
								"  FROM gene.leotbc_relacioncab  ar  "+
								"			INNER JOIN gene.leotbd_lematxtipoej ma "+
								"				ON ma.n_codmatpej = ar.n_codmatpej   "+
								"						INNER JOIN gene.leotbd_lecmaterial lma "+
								"							ON lma.n_codlesmat = ma.n_codlesmat  "+
								"								INNER JOIN gene.leotbd_leundleccion lec "+
								"									ON lec.n_codundlec =  lma.n_codleslec  "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								//"WHERE	ar.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbc_relacioncab" );
					pw.println("Tabla>>gene.leotbc_relacioncab" );
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
					lsConsult = "SELECT 	ar.n_codrelaci, ar.n_codrelcab, coalesce(ar.v_palabra,'') v_palabra, coalesce(ar.v_texto1,'') v_texto1, "+
								"	coalesce(ar.v_texto2,'') v_texto2, coalesce(ar.v_nombimag,'') v_nombimag, coalesce(ar.n_orientacion,0) n_orientacion,  "+ 
								"	coalesce(ar.n_orden,0) n_orden, coalesce(ar.n_tiporelaci,0) n_tiporelaci, ar.v_flgest,  "+
								"	coalesce(ar.n_codusureg,0) n_codusureg, coalesce(ar.d_fecreg,current_timestamp) d_fecreg, coalesce(ar.v_hostreg,'') v_hostreg, "+ 
								"	coalesce(ar.n_codusumod,0) n_codusumod, coalesce(ar.d_fecmod,current_timestamp) d_fecmod, coalesce(ar.v_hostmod,'') v_hostmod, "+
								"	coalesce(ar.v_texto3,'') v_texto3, coalesce(ar.v_parrafo,'') v_parrafo "+
								"FROM 	gene.leotbc_relacion ar "+
								"		INNER JOIN gene.leotbc_relacioncab ca  "+
								"			ON ca.n_codrelcab = ar.n_codrelcab "+
								"				INNER JOIN gene.leotbd_lematxtipoej ma "+
								"					ON ma.n_codmatpej = ca.n_codmatpej   "+
								"							INNER JOIN gene.leotbd_lecmaterial lma "+
								"								ON lma.n_codlesmat = ma.n_codlesmat  "+
								"								INNER JOIN gene.leotbd_leundleccion lec "+
								"									ON lec.n_codundlec =  lma.n_codleslec  "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								//"WHERE	ar.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbc_relacion" );
					pw.println("Tabla>>gene.leotbc_relacion" );
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
					lsConsult = "SELECT 	ls.n_codtextopalabracorrec, ls.n_codmatpej, coalesce(ls.v_titulo,'') v_titulo, coalesce(ls.v_texto,'') v_texto, ls.v_flgest, "+ 
								"	coalesce(ls.n_codusureg,0) n_codusureg, coalesce(ls.d_fecreg,current_timestamp) d_fecreg, coalesce(ls.v_hostreg,'') v_hostreg,  "+
								"	coalesce(ls.n_codusumod,0) n_codusumod, coalesce(ls.d_fecmod,current_timestamp) d_fecmod, coalesce(ls.v_hostmod,'') v_hostmod, "+
								"	ls.v_comentario "+
								"FROM 	gene.leotbc_textopalabracorrecta ls  "+
								"	INNER JOIN gene.leotbd_lematxtipoej ma "+
								"		ON ma.n_codmatpej = ls.n_codmatpej   "+
								"				INNER JOIN gene.leotbd_lecmaterial lma "+
								"					ON lma.n_codlesmat = ma.n_codlesmat  "+
								"						INNER JOIN gene.leotbd_leundleccion lec "+
								"							ON lec.n_codundlec =  lma.n_codleslec  "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								//"WHERE	ls.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbc_textopalabracorrecta" );
					pw.println("Tabla>>gene.leotbc_textopalabracorrecta" );
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
					lsConsult = "SELECT 	ls.n_codtextopalabraence, ls.n_codmatpej, coalesce(ls.v_titulo,'') v_titulo, coalesce(ls.v_texto,'') v_texto, ls.v_flgest, "+ 
								"	coalesce(ls.n_codusureg,0) n_codusureg, coalesce(ls.d_fecreg,current_timestamp) d_fecreg, coalesce(ls.v_hostreg,'') v_hostreg,  "+
								"	coalesce(ls.n_codusumod,0) n_codusumod, coalesce(ls.d_fecmod,current_timestamp) d_fecmod, coalesce(ls.v_hostmod,'') v_hostmod, "+
								"	ls.v_comentario "+
								"FROM 	gene.leotbc_textopalabraencerrada ls "+
								"	INNER JOIN gene.leotbd_lematxtipoej ma "+
								"		ON ma.n_codmatpej = ls.n_codmatpej   "+
								"				INNER JOIN gene.leotbd_lecmaterial lma "+
								"					ON lma.n_codlesmat = ma.n_codlesmat  "+
								"						INNER JOIN gene.leotbd_leundleccion lec "+
								"							ON lec.n_codundlec =  lma.n_codleslec  "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								//"WHERE	ls.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbc_textopalabraencerrada" );
					pw.println("Tabla>>gene.leotbc_textopalabraencerrada" );
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
					lsConsult = "SELECT 	ls.n_codpregun, ls.n_codmatpej, coalesce(ls.v_despregunta,'') v_despregunta, ls.v_flgest, "+
								"	coalesce(ls.n_codusureg,0) n_codusureg, coalesce(ls.d_fecreg,current_timestamp) d_fecreg, coalesce(ls.v_hostreg,'') v_hostreg,  "+ 
								"	coalesce(ls.n_codusumod,0) n_codusumod, coalesce(ls.d_fecmod,current_timestamp) d_fecmod, coalesce(ls.v_hostmod,'') v_hostmod, coalesce(ls.n_tippregunta,0) n_tippregunta  "+
								"FROM 	gene.leotbc_pregunta ls  "+
								"	INNER JOIN gene.leotbd_lematxtipoej ma  "+
								"		ON ma.n_codmatpej = ls.n_codmatpej   "+
								"				INNER JOIN gene.leotbd_lecmaterial lma "+
								"					ON lma.n_codlesmat = ma.n_codlesmat  "+
								"						INNER JOIN gene.leotbd_leundleccion lec "+
								"							ON lec.n_codundlec =  lma.n_codleslec  "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								//"WHERE	ls.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbc_pregunta" );
					pw.println("Tabla>>gene.leotbc_pregunta" );
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
					lsConsult = "SELECT 	ap.n_codaltern, ap.n_codpregun, coalesce(ap.v_alternativa,'') v_alternativa,coalesce( ap.v_rptaestado,'0')  v_rptaestado, ap.v_flgest, "+
								"	coalesce(ap.n_codusureg,0) n_codusureg, coalesce(ap.d_fecreg,current_timestamp) d_fecreg, coalesce(ap.v_hostreg,'') v_hostreg,  "+
								"	coalesce(ap.n_codusumod,0) n_codusumod, coalesce(ap.d_fecmod,current_timestamp) d_fecmod, coalesce(ap.v_hostmod,'') v_hostmod "+
								"FROM 	gene.leotbd_alternxpreg ap "+
								"	INNER JOIN gene.leotbc_pregunta ls  "+
								"		ON ls.n_codpregun = ap.n_codpregun   "+
								"		INNER JOIN gene.leotbd_lematxtipoej ma "+
								"		ON ma.n_codmatpej = ls.n_codmatpej   "+
								"				INNER JOIN gene.leotbd_lecmaterial lma "+
								"					ON lma.n_codlesmat = ma.n_codlesmat  "+
								"						INNER JOIN gene.leotbd_leundleccion lec "+
								"							ON lec.n_codundlec =  lma.n_codleslec  "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								//"WHERE	ap.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_alternxpreg" );
					pw.println("Tabla>>gene.leotbd_alternxpreg" );
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
					lsConsult = "SELECT 	al.n_codaltern, al.n_codcomporacion, coalesce(al.v_numespacio,'') v_numespacio, coalesce(al.v_alternativa,'') v_alternativa, "+ 
								"	coalesce(al.v_rptaestado,'0') v_rptaestado, al.v_flgest, "+
								"	coalesce(al.n_codusureg,0) n_codusureg, coalesce(al.d_fecreg,current_timestamp) d_fecreg, coalesce(al.v_hostreg,'') v_hostreg, "+ 
								"	coalesce(al.n_codusumod,0) n_codusumod, coalesce(al.d_fecmod,current_timestamp) d_fecmod, coalesce(al.v_hostmod,'') v_hostmod "+
								"FROM 	gene.leotbd_altxcomporaci al "+
								"	INNER JOIN gene.leotbd_alternxpreg ap "+
								"		ON al.n_codaltern = ap.n_codaltern "+
								"		INNER JOIN gene.leotbc_pregunta ls "+
								"			ON ls.n_codpregun = ap.n_codpregun  "+
								"			INNER JOIN gene.leotbd_lematxtipoej ma "+
								"			ON ma.n_codmatpej = ls.n_codmatpej   "+
								"					INNER JOIN gene.leotbd_lecmaterial lma "+
								"						ON lma.n_codlesmat = ma.n_codlesmat  "+
								"							INNER JOIN gene.leotbd_leundleccion lec "+
								"								ON lec.n_codundlec =  lma.n_codleslec  "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								//"							 "+
								//"WHERE	al.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_altxcomporaci" );
					pw.println("Tabla>>gene.leotbd_altxcomporaci" );
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
					lsConsult = "SELECT 	al.n_codaltern, al.n_codtextopalabracorrec, coalesce(al.v_palabracorrecta,'') v_palabracorrecta,coalesce( al.v_alternativa,'') v_alternativa, "+ 
								"	coalesce(al.v_rptaestado,'0') v_rptaestado, al.v_flgest,  "+
								"	coalesce(al.n_codusureg,0) n_codusureg, coalesce(al.d_fecreg,current_timestamp) d_fecreg, coalesce(al.v_hostreg,'') v_hostreg, "+ 
								"	coalesce(al.n_codusumod,0) n_codusumod, coalesce(al.d_fecmod,current_timestamp) d_fecmod, coalesce(al.v_hostmod,'') v_hostmod "+
								"FROM 	gene.leotbd_altxtextopalabracorrec al "+
								"	INNER JOIN gene.leotbd_alternxpreg ap "+
								"		ON al.n_codaltern = ap.n_codaltern "+
								"		INNER JOIN gene.leotbc_pregunta ls "+
								"			ON ls.n_codpregun = ap.n_codpregun  "+
								"			INNER JOIN gene.leotbd_lematxtipoej ma "+
								"			ON ma.n_codmatpej = ls.n_codmatpej   "+
								"					INNER JOIN gene.leotbd_lecmaterial lma "+
								"						ON lma.n_codlesmat = ma.n_codlesmat  "+
								"							INNER JOIN gene.leotbd_leundleccion lec "+
								"								ON lec.n_codundlec =  lma.n_codleslec  "+		
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								//"WHERE	al.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_altxtextopalabracorrec" );
					pw.println("Tabla>>gene.leotbd_altxtextopalabracorrec" );
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
					lsConsult = "SELECT  al.n_codaltern, al.n_codtextopalabraence, coalesce(al.v_palabraencerrada,'') v_palabraencerrada, coalesce(al.n_tm1sitaltxtexto,0) n_tm1sitaltxtexto, al.v_flgest, "+
								"	coalesce(al.n_codusureg,0) n_codusureg, coalesce(al.d_fecreg,current_timestamp) d_fecreg, coalesce(al.v_hostreg,'') v_hostreg,  "+
								"	coalesce(al.n_codusumod,0) n_codusumod, coalesce(al.d_fecmod,current_timestamp) d_fecmod, coalesce(al.v_hostmod,'') v_hostmod, "+
								"	coalesce(al.n_nroorden,0) n_nroorden, coalesce(al.v_palabrarpta,'') v_palabrarpta "+
								"FROM 	gene.leotbd_altxtextopalabraence al "+
								"	INNER JOIN gene.leotbd_alternxpreg ap "+
								"		ON al.n_codaltern = ap.n_codaltern  "+
								"		INNER JOIN gene.leotbc_pregunta ls "+
								"			ON ls.n_codpregun = ap.n_codpregun   "+
								"			INNER JOIN gene.leotbd_lematxtipoej ma "+
								"			ON ma.n_codmatpej = ls.n_codmatpej   "+
								"					INNER JOIN gene.leotbd_lecmaterial lma "+
								"						ON lma.n_codlesmat = ma.n_codlesmat  "+
								"							INNER JOIN gene.leotbd_leundleccion lec "+
								"								ON lec.n_codundlec =  lma.n_codleslec  "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								//"WHERE	al.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_altxtextopalabraence" );
					pw.println("Tabla>>gene.leotbd_altxtextopalabraence" );
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
					lsConsult = "SELECT 	al.n_codoraxarrastrar, al.n_codarrastraora, coalesce(al.v_numorden,'0') v_numorden, coalesce(al.v_oraciondet,'') v_oraciondet, al.v_flgest, "+ 
								"	coalesce(al.n_codusureg,0) n_codusureg, coalesce(al.d_fecreg,current_timestamp) d_fecreg, coalesce(al.v_hostreg,'') v_hostreg,  "+
								"	coalesce(al.n_codusumod,0) n_codusumod, coalesce(al.d_fecmod,current_timestamp) d_fecmod, coalesce(al.v_hostmod,'') v_hostmod "+
								"FROM 	gene.leotbd_detoraxarrastrar al "+
								"	INNER JOIN gene.leotbc_arrastraoraciones ar "+
								"		ON ar.n_codarrastraora = al.n_codarrastraora "+
								"			INNER JOIN gene.leotbd_lematxtipoej ma "+
								"				ON ma.n_codmatpej = ar.n_codmatpej   "+
								"						INNER JOIN gene.leotbd_lecmaterial lma "+
								"							ON lma.n_codlesmat = ma.n_codlesmat  "+
								"								INNER JOIN gene.leotbd_leundleccion lec "+
								"									ON lec.n_codundlec =  lma.n_codleslec  "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								//"WHERE 	al.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_detoraxarrastrar" );
					pw.println("Tabla>>gene.leotbd_detoraxarrastrar" );
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
					lsConsult = "SELECT 	al.n_codrelaci, al.n_codrelcab, coalesce(al.v_texto1,'') v_texto1, coalesce(al.v_texto2,'') v_texto2, coalesce(al.v_nombimag,'') v_nombimag, "+ 
								"	coalesce(al.n_orden,0) n_orden,  coalesce(al.n_tiporelaci,0) n_tiporelaci, al.v_flgest, "+
								"	coalesce(al.n_codusureg,0) n_codusureg, coalesce(al.d_fecreg,current_timestamp) d_fecreg, coalesce(al.v_hostreg,'') v_hostreg, "+ 
								"	coalesce(al.n_codusumod,0) n_codusumod, coalesce(al.d_fecmod,current_timestamp) d_fecmod, coalesce(al.v_hostmod,'') v_hostmod "+
								"FROM 	gene.leotbd_relacionvariada al "+
								"	INNER JOIN gene.leotbc_relacioncab  ar "+
								"		ON ar.n_codrelcab = al.n_codrelcab "+
								"			INNER JOIN gene.leotbd_lematxtipoej ma "+
								"				ON ma.n_codmatpej = ar.n_codmatpej   "+
								"						INNER JOIN gene.leotbd_lecmaterial lma "+
								"							ON lma.n_codlesmat = ma.n_codlesmat  "+
								"								INNER JOIN gene.leotbd_leundleccion lec "+
								"									ON lec.n_codundlec =  lma.n_codleslec  "+
								"									INNER JOIN gene.leotbd_lestunidad leu "+
								"											ON leu.n_codlesuni = lec.n_codlesuni  "+ 
								"											INNER JOIN gene.leotbd_lenguaestruc len "+
								"													ON len.n_codlenest =  leu.n_codlenest  AND len.n_codlengua = "+liCodLeng+
								"													INNER JOIN gene.leotbc_lengua lengua  "+
								"															ON lengua.n_codlengua = len.n_codlengua  AND lengua.n_codlengua ="+liCodLeng;
								//"WHERE	al.v_flgest = '1'";
					ps = con.prepareStatement(lsConsult);
					resultSet = ps.executeQuery();
					metadata = resultSet.getMetaData();
					columnCount = metadata.getColumnCount();
					lsColName = obtenerColumnas(metadata,columnCount);
					table = new ArrayList<Row>();
					Row.formTable(resultSet, table);
					System.out.println("Tabla>>gene.leotbd_relacionvariada" );
					pw.println("Tabla>>gene.leotbd_relacionvariada" );
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
					pw.close();
				} catch (IOException e){
					lsRpta501 = "Error 07"+e.getMessage();
					return lsRpta501;
				} catch(NullPointerException e) {
					lsRpta501 ="Error 08"+ e.getMessage();
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
			lsRpta501 = "Error 09:"+e.getMessage();
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
	public void descargarArchivoUpdate(@PathVariable("liCodServ") int liCodServ, @PathVariable("lsCadena") String lsCadena, HttpServletResponse response) {
		Connection con = null;
		BufferedReader br = null;
		BufferedWriter writer = null;
		String lsPrefijo = "";
		String lsTablSQL = "";
		String lsTblUIns = "";
		String lsArchivo = "";
		String lsMimeTyp = "";
		try {
			if(liCodServ==1){
				con = DriverManager.getConnection(lsLoclURL, lsLoclUSR, lsLoclPWD);
				lsPrefijo = "local-";
			} else if(liCodServ==2){
				con = DriverManager.getConnection(lsExteURL, lsExteUSR, lsExtePWD);
				lsPrefijo = "remoto-";
			} else{
				return;
			}
			
			File dir = FileUtil.fileExists(this.getRootPathFile()); // CREAR CARPETA
			lsArchivo = dir.getAbsolutePath()+this.getDiagonalFile()+lsPrefijo+"update.txt";//"C:/natigu/"+lsPrefijo+"usuarios-inscritos.txt";
			
			File lmDirFile = FileUtil.fileExists2(lsArchivo);
			fichero = null;
			pw = null;
			Row.formTable(resultSet, table);
			writer = new BufferedWriter(new FileWriter(lmDirFile));
			fichero = new FileWriter(lmDirFile);
			pw = new PrintWriter(fichero);
			pw.println(lsCadena.replace("\n", "").replace("\r", ""));
			// ----
			lsMimeTyp = URLConnection.guessContentTypeFromName(lmDirFile.getName());
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

			} catch (IOException ex) {
				System.out.println("Error writing file to output stream. Filename was '{}'");
				throw new RuntimeException("IOError writing file to output stream");
			} finally {
				if (null != ps)
					ps.close();
				if (null != con)
					con.close();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
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
		String resultado ="";
		String lsPrefijo="";
		System.out.println("liCodServ "+ liCodServ);
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
				resultado = "No se escogió el tipo de conexión al servidor.";
				return  resultado;
			}
			File convFile = FileUtil.fileExists2(fileOffline[0].getOriginalFilename());
			String lsMimeTyp = URLConnection.guessContentTypeFromName(convFile.getName());
			System.out.println("mime+ " + lsMimeTyp);
			if(lsMimeTyp==null || !lsMimeTyp.equals("text/plain")){
				return "El formato del archivo no es texto plano.";
			}
			System.out.println("fileOffline[0].getOriginalFilename()" + fileOffline[0].getOriginalFilename());
			if (convFile.exists()){
				convFile.delete();
				System.out.println("Archivo eliminado");
			}
			fileOffline[0].transferTo(convFile);	
			FileReader fileReader = new FileReader(convFile);
			br = new BufferedReader(fileReader);
			String line = br.readLine();
			int i = 0;
			String lsNomTabl = "";
			//String rslt = "";
			Encrypt.init("KEY_ENCRYPT_PASS");
			if(liAccions == 1){
				while (null != line) {
					
					if (line.contains("Tabla>>")) {
						//Agrego el 2 para la inserción de la tabla en el servidor en la nube que creé como prueba, ejm: leotbc_material2
						//String idTabla = liCodServ==1 ? "": "2";
						lsNomTabl = line.split(">>")[1];//+idTabla ;
						st2 = con.prepareStatement("SELECT * FROM "+lsNomTabl+" limit 1");
						System.out.println("lsNomTabl " + lsNomTabl);
						resultSet = st2.executeQuery();
						metadata = resultSet.getMetaData();
						columnCount = metadata.getColumnCount();
						System.out.println(lsNomTabl);//resultado.add("Ejecutando en tabla:" + lsNomTabl);
					}else{
						try {
							line = Encrypt.decrypt(line);
						} catch (EncryptException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//line = line.replaceAll(">>", "\";").replaceAll("<<", "\"").concat(SEPARATOR);
						//line = line.concat(SEPARATOR);
						//System.out.println(lsNomTabl);
						System.out.println("LINE" + line);
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
							System.out.println("Se insertó con éxito: "  + query );//String newNomTbl = liCodServ==2 ? lsNomTabl.substring(0,lsNomTabl.length()-1): lsNomTabl;
							//lsCadena.add("UPDATE " + lsNomTabl + " SET v_flgoffline = 1 WHERE " + lsColName + "="+ fields[0].replace("[", "").replace("]", ""));
							//rslt = "Consulta de inserción ejecutada con éxito";
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
								System.out.println("Se actualizó con éxito: "  + queryUpdate );//String newNomTbl = liCodServ==2 ? lsNomTabl.substring(0,lsNomTabl.length()-1): lsNomTabl;
								//lsCadena.add("UPDATE " +   lsNomTabl + " SET v_flgoffline = 1 WHERE "+ lsColName.split(",")[0] + "="+ fields[0].replace("[", "").replace("]", ""));
								//rslt = "Consulta de actualización ejecutada con éxito";
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
							//resultado = "Registro actualizado con éxito.";
						} catch (SQLException e) {
							//resultado= e.getMessage();
							System.out.println("resultado offline"+ e.getMessage());
							resultado = "Comuníquese con el administrador del sistema, error en Base de datos.";
						}
					}
					
					resultado = "1";
					
				}
				
			}
			//st.executeBatch(); // insert remaining records
			//con.commit();
			br.close();
		} catch (IOException e) {
			//con.rollback();
			resultado = e.getMessage();
			e.printStackTrace();
		} catch (SQLException e) {
			//con.rollback();
//			resultado = e.getMessage();
			System.out.println("resultado offline"+ e.getMessage());
			resultado = "Error de conexión al servidor";
			e.printStackTrace();
		}  catch (NullPointerException e) {
			//con.rollback();
			resultado = e.getMessage();
			e.printStackTrace();
		} finally {
			if (null != ps)
				ps.close();
			if (null != con)
				con.close();
		}
		return resultado;
	}

	//Lee archivo antes descargado y generar un archivo de lo que se registró para luego actualizarlo en el servidor donde se descargo el primer archivo
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
			String lsArchivo = dir.getAbsolutePath()+this.getDiagonalFile()+lsPrefijo+"update.txt";//"C:/natigu/"+lsPrefijo+"usuarios-inscritos.txt";
			
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
	
	@RequestMapping(value = "/descarga-offline", method = RequestMethod.GET)
	public ModelAndView descargaOffline(HttpServletRequest request) throws Exception {
		System.out.println("-- ingreso a  listado --");
		usuario = this.getUsuarioSesion(request);
		AccesoBean accesoBean = new AccesoBean();
		accesoBean.setFlgServer(lsServLoc);
		lstOpcionDescarga = new ArrayList<MaestraBean>();
		System.out.println("lsServLoce "  + lsServLoc);
		setLstPeriodo(maestra2Service.listarPorCodigoTabla("periodo",0));
		lstCiclo = maestra2Service.listarPorCodigoTabla("ciclo",0);
		lstOpcionDescarga = maestra2Service.listarPorCodigoTabla("opcionDescarga",0);
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try {
				lstLenguaBean = (List<LenguaBean>) lenguaService.getBuscarPorFiltros(new LenguaBean());
				System.out.println("lstLenguaBean actual :: "+lstLenguaBean.size());
			} catch (Exception e) {
				System.out.println("getLista " + e.getMessage());
			} 
			ModelAndView mav = new ModelAndView("general/descargar-archivo-offline", "command", accesoBean);
	
			if (lsServLoc.equals("1")) { // Servidor Offline
				System.out.println("lstOpcionDescarga.size " + lstOpcionDescarga.size());
				MaestraBean opcion = new MaestraBean();
				for (int i = 0; i < lstOpcionDescarga.size(); i++) {
					opcion = lstOpcionDescarga.get(i);
					System.out.println("opcion " + opcion.getCodigoRegistro());
					
					if (opcion.getCodigoRegistro() == 3) {
						lstOpcionDescarga.remove(opcion);
					}  
				}
				for (int i = 0; i < lstOpcionDescarga.size(); i++) {
					opcion = lstOpcionDescarga.get(i);
					System.out.println("opcion " + opcion.getCodigoRegistro());
					 	if (opcion.getCodigoRegistro() == 5) {
						lstOpcionDescarga.remove(opcion);
					}
				}
			/**	for(MaestraBean opcionDescarga : lstOpcionDescarga){
					if (opcionDescarga.getCodigoRegistro() == 5 || opcionDescarga.getCodigoRegistro() == 3) {
						lstOpcionDescarga.remove(opcionDescarga);
					}
				}*/
			}
			mav.addObject("accesoBean",accesoBean);
			mav.addObject("lstCiclo",lstCiclo);
			mav.addObject("lstPeriodo",lstPeriodo); 
			mav.addObject("lstOpcionDescarga",lstOpcionDescarga);
			mav.addObject("lstLenguaBean",lstLenguaBean); 
			return mav;
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesión no es valida, por favor inicie sesión nuevamente");
			return mav;
		}
	} 

	@RequestMapping(value = "/subida-offline", method = RequestMethod.GET)
	public ModelAndView subidaOffline(HttpServletRequest request) throws Exception {
		usuario = this.getUsuarioSesion(request);
		AccesoBean accesoBean = new AccesoBean();
		accesoBean.setFlgServer(lsServLoc);
		System.out.println("-- ingreso a  listado --");
		ModelAndView mav = new ModelAndView("general/subir-archivo-offline", "command", accesoBean);
		mav.addObject("accesoBean",accesoBean);
		return mav;
	}

	private static String[] removeTrailingQuotes(String[] fields) {
		String result[] = new String[fields.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = fields[i].replaceAll("^" + QUOTEA, "").replaceAll(QUOTEB + "$", "");
			//System.out.println("length:" + result[i].length());
			if ((!result[i].startsWith("0") && result[i].length()>1  ) && isNumeric(result[i])) {
				result[i] = result[i];
			} else {
				result[i] = "'" + result[i] + "'";
			}
		}
		return result;
	}

	public static boolean isInteger(String s) {
	    return isInteger(s,10);
	}

	public static boolean isInteger(String s, int radix) {
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),radix) < 0) return false;
	    }
	    return true;
	}
	public static boolean isNumeric(String s) {
		boolean rp = isInteger(s);
		//System.out.println(rp);
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}

	private void cargarCombos(ModelAndView mav) {

		if (lstAuditoriaTabla == null) {
			try {
				AuditoriaTablaBean filtroOff = new AuditoriaTablaBean();
				filtroOff.setFlgoffline("1");
				lstAuditoriaTabla = this.fs.getAuditoriaService().listarTablas(filtroOff);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		mav.addObject("lstAuditoriaTabla", lstAuditoriaTabla);
	}
	
	private String getRootPathFile(){
		return ResourceUtil.getKey("ruta.natigu.archivos.offline");
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

	public List<LenguaBean> getLstLenguaBean() {
		return lstLenguaBean;
	}

	public void setLstLenguaBean(List<LenguaBean> lstLenguaBean) {
		this.lstLenguaBean = lstLenguaBean;
	}

	public List<MaestraBean> getLstOpcionDescarga() {
		return lstOpcionDescarga;
	}

	public void setLstOpcionDescarga(List<MaestraBean> lstOpcionDescarga) {
		this.lstOpcionDescarga = lstOpcionDescarga;
	}

}