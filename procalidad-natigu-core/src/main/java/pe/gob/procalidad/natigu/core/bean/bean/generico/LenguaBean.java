package pe.gob.procalidad.natigu.core.bean.bean.generico;

import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
 
 
public class LenguaBean extends BaseBean{
	
	private String 		nombre;
	private String 		descripcion;
	private MaestraBean situacion = new MaestraBean();
	private MatriculaBean matriculaBean;

	private String 		imagenExtension;
	private String 		imagenUbicacion;
	private String 		imagenNombre;
	private String 		imagenTamanio;
	private String 		imagenPeso;
	
	private MultipartFile 	file;
	private MultipartFile 	fileImagen;
	
	private String codigoEncrypt;
	
	public LenguaBean(){
		super();
	}
	
	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getNombre() {  
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public MaestraBean getSituacion() {
		return situacion;
	}
	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}

	public String getImagenExtension() {
		return imagenExtension;
	}

	public void setImagenExtension(String imagenExtension) {
		this.imagenExtension = imagenExtension;
	}

	public String getImagenUbicacion() {
		return imagenUbicacion;
	}

	public void setImagenUbicacion(String imagenUbicacion) {
		this.imagenUbicacion = imagenUbicacion;
	}

	public String getImagenNombre() {
		/*if (imagenNombre == null) {
			imagenNombre = "usar_imagen.jpg";
		}*/
		return imagenNombre;
	}

	public void setImagenNombre(String imagenNombre) {
		this.imagenNombre = imagenNombre;
	}

	public String getImagenTamanio() {
		return imagenTamanio;
	}

	public void setImagenTamanio(String imagenTamanio) {
		this.imagenTamanio = imagenTamanio;
	}

	public String getImagenPeso() {
		return imagenPeso;
	}

	public void setImagenPeso(String imagenPeso) {
		this.imagenPeso = imagenPeso;
	}
	
	public MatriculaBean getMatriculaBean() {
		return matriculaBean;
	}

	public void setMatriculaBean(MatriculaBean matriculaBean) {
		this.matriculaBean = matriculaBean;
	}

	@Override
	public String toString() {
		return "LenguaBean [nombre=" + nombre + ", descripcion=" + descripcion + ", situacion=" + situacion
				+ ", imagenExtension=" + imagenExtension + ", imagenUbicacion=" + imagenUbicacion + ", imagenNombre="
				+ imagenNombre + ", imagenTamanio=" + imagenTamanio + ", imagenPeso=" + imagenPeso + "]";
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

	public String getCodigoEncrypt() {
		return codigoEncrypt;
	}

	public void setCodigoEncrypt(String codigoEncrypt) {
		this.codigoEncrypt = codigoEncrypt;
	}
	 
}
