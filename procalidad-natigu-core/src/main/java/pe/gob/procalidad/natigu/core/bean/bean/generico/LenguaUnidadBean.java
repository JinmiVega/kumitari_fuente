package pe.gob.procalidad.natigu.core.bean.bean.generico;

import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class LenguaUnidadBean extends BaseBean{
	
	private LenguaBean lenguaBean = new LenguaBean();
	private MaestraBean unidad    = new MaestraBean();
	private String  nombreImagen;
	private String  nombreImagenBloqueado;
	private MultipartFile file;
	private MultipartFile fileImagen;
	private String nombreUnidad;
	private String inicialNombre;
	private MultipartFile fileBloq;
	private MultipartFile fileImagenBloq;
	public LenguaUnidadBean() {
		super();
	}
	
	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}
	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}
	public MaestraBean getUnidad() {
		return unidad;
	}
	public void setUnidad(MaestraBean unidad) {
		this.unidad = unidad;
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

	public String getNombreUnidad() {
		return nombreUnidad;
	}

	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}

	public String getNombreImagenBloqueado() {
		return nombreImagenBloqueado;
	}

	public void setNombreImagenBloqueado(String nombreImagenBloqueado) {
		this.nombreImagenBloqueado = nombreImagenBloqueado;
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

	public String getInicialNombre() {
		return inicialNombre;
	}

	public void setInicialNombre(String inicialNombre) {
		this.inicialNombre = inicialNombre;
	} 
}
