package pe.gob.procalidad.natigu.core.bean.bean.generico;

import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class UnidadLeccionBean extends BaseBean{
 
	private UnidadBean unidadBean =new UnidadBean();
	
	private LenguaLeccionBean lenguaLeccionBean = new LenguaLeccionBean();
	
	private MaestraBean leccion = new MaestraBean();
	
	private String nombre ;
	  
	private String descripcion ;
	  
	private MaestraBean situacion = new MaestraBean();

	private String nombreImagen;
	
	private MultipartFile file;
	private MultipartFile fileImagen;	
	
	private String codigoEncrypt;
	
	public UnidadLeccionBean() {
		super(); 
	}

	public UnidadBean getUnidadBean() {
		return unidadBean;
	} 
	
	public void setUnidadBean(UnidadBean unidadBean) {
		this.unidadBean = unidadBean;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public MaestraBean getSituacion() {
		return situacion;
	}

	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	} 

	public MaestraBean getLeccion() {
		return leccion;
	}

	public void setLeccion(MaestraBean leccion) {
		this.leccion = leccion;
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

	public LenguaLeccionBean getLenguaLeccionBean() {
		return lenguaLeccionBean;
	}

	public void setLenguaLeccionBean(LenguaLeccionBean lenguaLeccionBean) {
		this.lenguaLeccionBean = lenguaLeccionBean;
	}

	public String getCodigoEncrypt() {
		return codigoEncrypt;
	}

	public void setCodigoEncrypt(String codigoEncrypt) {
		this.codigoEncrypt = codigoEncrypt;
	}

	@Override
	public String toString() {
		return "UnidadLeccionBean [unidadBean=" + unidadBean + ", leccion="
				+ leccion + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", situacion=" + situacion + ", nombreImagen="
				+ nombreImagen + ", file=" + file + ", fileImagen="
				+ fileImagen + "]";
	}


}
