package pe.gob.procalidad.natigu.web.gestion.controller.base;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.activation.MimetypesFileTypeMap;
import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.service.service.factory.interfaces.FactoryService;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.FileUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.NetUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;

@Controller
@SessionAttributes(value="usuarioSesion")
@Scope(value="session")
public class BaseController {
	
	@Autowired
	protected FactoryService fs;
	
	@Autowired
	private ServletContext servletContext;
	
	protected UsuarioBean usuarioBean;
		
	public BaseController() {
		super();
		
	}

	@PostConstruct
	private void init(){
		this.setUsuarioBean(new UsuarioBean());
	}
	
	protected void setAuditoria(BaseBean baseBean,HttpServletRequest request,boolean swInsert){
		UsuarioBean usuario= (UsuarioBean) request.getSession().getAttribute("usuarioSesion");
		long idUsuario= !VO.isNull(usuario) ? usuario.getCodigo() : 0;	
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
	
	protected UsuarioBean getUsuarioSesion(HttpServletRequest request){
		
		Object obj= request.getSession().getAttribute("usuarioSesion");
		
		if (obj!=null) {
			return (UsuarioBean)obj;
		} else {
			return new UsuarioBean(); 	
		}
		
	}
	
	/***********************************************************************************************************
	 * INICIO DE GESTION DE ARCHIVOS
	 * 
	 ***********************************************************************************************************/
	
	protected String getDiagonalFile(){
		return (this.getTipoSistemaOperativo().equals("1")) ? "\\" : "/";
	}
	
	protected String getTipoSistemaOperativo(){
		return ResourceUtil.getKey("sistemaOperativo");
	}
	
	protected void cargarArchivo(String rootPath, String urlArchivo, MultipartFile multipartFile ) {

        try {    			
    			byte[] bytes = multipartFile.getBytes();               
    			File dir=FileUtil.fileExists(rootPath);
                File serverFile = new File(dir.getAbsolutePath() + File.separator + urlArchivo);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
	
	protected String obtenerUrlArchivo(MultipartFile multipartFile) {
		
		String originalFilename="";
		
		if (VO.isNotNull(multipartFile)) {
						
			if (!VO.isEmpty(multipartFile.getName())) {
				originalFilename = multipartFile.getName().replace(" ", "");
			}
		}		
		
		return originalFilename;
	}
	
	protected  MultipartFile obtenerArchivo(String rootPath,String urlArchivo) {
		MultipartFile multipartFile =null; 
		try {
	        File dir = FileUtil.fileExists(rootPath);			        
	        if (!VO.isEmpty(urlArchivo)) {
	        	File file = new File(dir.getAbsolutePath() + File.separator + urlArchivo);
				FileItem fileItemDocumento = new DiskFileItem("fileDocumento", new MimetypesFileTypeMap().getContentType(file), false, file.getName(), (int) file.length() , file.getParentFile());
				fileItemDocumento.getOutputStream();						
				multipartFile = new CommonsMultipartFile(fileItemDocumento);						
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return multipartFile;
	}
	
	protected boolean eliminarArchivo(String rootPath,String fileName){

        try {

            File dir = FileUtil.fileExists(rootPath);
            File serverFile = new File(dir.getAbsolutePath() + File.separator +fileName);

            if (serverFile.delete()) {
    			return true;
    		}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	/*protected void descargarArchivo(String rootPath, String fileName,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			ServletContext context = request.getServletContext();

			String filePath = rootPath + File.separator + fileName;

			System.out.println("filePath IMARPE -> "+filePath);
			
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);

			String mimeType = context.getMimeType(filePath);
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}
			response.setContentType(mimeType);
			response.setContentLength((int) file.length());

			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"",
					file.getName());
			response.setHeader(headerKey, headerValue);

			OutputStream os = response.getOutputStream();

			byte[] buffer = new byte[102400];
			int bytesRead = -1;

			while ((bytesRead = fis.read(buffer)) != -1) {
				os.write(buffer, 0, bytesRead);
			}

			fis.close();
			os.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/***********************************************************************************************************
	 * FIN DE GESTION DE ARCHIVOS
	 * 
	 ***********************************************************************************************************/
	
	
	/***********************************************************************************************************
	 * INICIO DE GESTION DE EXCEL
	 * 
	 ***********************************************************************************************************/
	protected void exportarExcel(HSSFWorkbook workbook,String nombreArchivo,HttpServletResponse response) {

		try {			
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
				response.setHeader("Content-Disposition", "attachment; filename="+nombreArchivo);				
				OutputStream out = response.getOutputStream();
				workbook.write(out);
				out.close();
		} catch (Exception e) {
			
		}
	}
	
	protected void setStyleLisTitulo(HSSFWorkbook workbook, Cell cell) {
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 14);
        font.setFontName("Arial Black"); 
        font.setColor(IndexedColors.BLACK.getIndex());
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setUnderline((byte)1);
        font.setItalic(false);
        
        CellStyle newCellStyle = workbook.createCellStyle();
        newCellStyle.cloneStyleFrom(cell.getCellStyle());
        newCellStyle.setFont(font);
        cell.setCellStyle(newCellStyle);
    }
	
	protected void setStyleFormat(HSSFWorkbook workbook, Cell cell) {
		HSSFFont font= workbook.createFont();
	    font.setFontHeightInPoints((short)10);
	    font.setFontName("Arial");
	    font.setColor(IndexedColors.BLACK.getIndex());
	    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	    font.setItalic(false);

	    CellStyle newCellStyle = workbook.createCellStyle();
		newCellStyle.cloneStyleFrom(cell.getCellStyle());
		
//		newCellStyle.setFillBackgroundColor(IndexedColors.DARK_BLUE.getIndex());
//		newCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		newCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		newCellStyle.setFont(font);
	    
		cell.setCellStyle(newCellStyle);
	}
	
	
	protected void setStyleLisCabecera(HSSFWorkbook workbook, Cell cell) {
		HSSFFont font= workbook.createFont();
	    font.setFontHeightInPoints((short)10);
	    font.setFontName("Arial");
	    font.setColor(IndexedColors.WHITE.getIndex());
	    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	    font.setItalic(false);

	    CellStyle newCellStyle = workbook.createCellStyle();
		newCellStyle.cloneStyleFrom(cell.getCellStyle());
		
		newCellStyle.setFillForegroundColor(HSSFColor.BLUE.index);
		newCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		newCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		newCellStyle.setBorderTop((short) 1); // single line border
		newCellStyle.setBorderBottom((short) 1); // single line border
		newCellStyle.setBorderRight((short) 1);
		newCellStyle.setBorderLeft((short) 1);
		newCellStyle.setFont(font);
	    
		cell.setCellStyle(newCellStyle);
	}
	
	protected void setStyleCellAlign(HSSFWorkbook workbook, Cell cell, int tipo) {
        CellStyle newCellStyle = workbook.createCellStyle();
        newCellStyle.cloneStyleFrom(cell.getCellStyle());
        if (tipo==0) {
            newCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		} else if(tipo==1) {
	        newCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		} else if(tipo==2) {
	        newCellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		}
        
        cell.setCellStyle(newCellStyle);
    }
	
	protected void setStyleCellVerticalAlign(HSSFWorkbook workbook, Cell cell, int tipo) {
        CellStyle newCellStyle = workbook.createCellStyle();
        newCellStyle.cloneStyleFrom(cell.getCellStyle());
        if (tipo==0) {
            newCellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		} else if(tipo==1) {
	        newCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		} else if(tipo==2) {
	        newCellStyle.setVerticalAlignment(CellStyle.VERTICAL_BOTTOM);
		}
        
        cell.setCellStyle(newCellStyle);
    }
	
	protected void setStyleFontSize(HSSFWorkbook workbook, Cell cell, int size) {
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) size);
        CellStyle newCellStyle = workbook.createCellStyle();
        newCellStyle.cloneStyleFrom(cell.getCellStyle());
        newCellStyle.setFont(font);
        cell.setCellStyle(newCellStyle);
    }
	
	protected void setStyleWrapped(HSSFWorkbook workbook, Cell cell) {
        CellStyle newCellStyle = workbook.createCellStyle();
        newCellStyle.cloneStyleFrom(cell.getCellStyle());
        newCellStyle.setWrapText(true);
        cell.setCellStyle(newCellStyle);
    }

	/***********************************************************************************************************
	 * FIN DE GESTION DE EXCEL
	 * 
	 ***********************************************************************************************************/
	
	/***********************************************************************************************************
	 * INICIO DE GESTION DE ARCHIVOS COMPRIMIDOS
	 * 
	 ***********************************************************************************************************/
	protected  void unZipFiles(File zipfile, String descDir) {
		File file = new File(descDir);
		if (!file.exists()) {
			try {
				file.mkdirs();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			ZipFile zf = new ZipFile(zipfile);
			for (Enumeration entries = zf.entries(); entries.hasMoreElements();) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				String zipEntryName = entry.getName();
				InputStream in = zf.getInputStream(entry);
				OutputStream out = new FileOutputStream(descDir + File.separator +zipEntryName);
				byte[] buf1 = new byte[1024];
				int len;
				while ((len = in.read(buf1)) > 0) {
					out.write(buf1, 0, len);
				}
				in.close();
				out.close();
				//System.out.println("Descompresi�n completa.");
			}

			zf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public FactoryService getFs() {
		return fs;
	}

	public void setFs(FactoryService fs) {
		this.fs = fs;
	}
	
	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@ModelAttribute("usuarioSesion")
	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}
	
}