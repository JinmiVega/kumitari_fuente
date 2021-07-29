package pe.gob.procalidad.natigu.core.bean.bean.generico;

import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class LenguaLeccionBean extends BaseBean{
	
	private LenguaBean lenguaBean = new LenguaBean();
	private MaestraBean leccion    = new MaestraBean();
	private String  nombreImagen;
	private MultipartFile file;
	private MultipartFile fileImagen;
	private String nombreLeccion;
	private MultipartFile fileBloq;
	private MultipartFile fileImagenBloq;
	private String  nombreImagenBloq;
	private String inicialNombre;
	
	public LenguaLeccionBean() {
		super();
	}
	
	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}
	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}
	public String getNombreImagen() {
		return nombreImagen;
	}
	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public MultipartFile getFileImagen() {
		return fileImagen;
	}

	public void setFileImagen(MultipartFile fileImagen) {
		this.fileImagen = fileImagen;
	}

	public MaestraBean getLeccion() {
		return leccion;
	}

	public void setLeccion(MaestraBean leccion) {
		this.leccion = leccion;
	}

	public String getNombreLeccion() {
		return nombreLeccion;
	}

	public void setNombreLeccion(String nombreLeccion) {
		this.nombreLeccion = nombreLeccion;
	}

	public MultipartFile getFileBloq() {
		return fileBloq;
	}

	public void setFileBloq(MultipartFile fileBloq) {
		this.fileBloq = fileBloq;
	}

	public MultipartFile getFileImagenBloq() {
		return fileImagenBloq;
	}

	public void setFileImagenBloq(MultipartFile fileImagenBloq) {
		this.fileImagenBloq = fileImagenBloq;
	}

	public String getNombreImagenBloq() {
		return nombreImagenBloq;
	}

	public void setNombreImagenBloq(String nombreImagenBloq) {
		this.nombreImagenBloq = nombreImagenBloq;
	}

	public String getInicialNombre() {
		return inicialNombre;
	}

	public void setInicialNombre(String inicialNombre) {
		this.inicialNombre = inicialNombre;
	}
	
	
}
