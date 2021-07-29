package pe.gob.procalidad.natigu.core.bean.bean.configuracion;

import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;


public class ModalBean extends BaseBean{
	
	
	private Integer codModa;
	private String nombre;
	private MaestraBean  situacion  = new MaestraBean();
	private String 		imagenUbicacion;
	private String 		imagenNombre;
	private MultipartFile 	file;
	private MultipartFile 	fileImagen; 
	private Integer 	 retorno;
	
	public ModalBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCodModa() {
		return codModa;
	}
	public void setCodModa(Integer codModa) {
		this.codModa = codModa;
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
	public String getImagenUbicacion() {
		return imagenUbicacion;
	}
	public void setImagenUbicacion(String imagenUbicacion) {
		this.imagenUbicacion = imagenUbicacion;
	}
	public String getImagenNombre() {
		return imagenNombre;
	}
	public void setImagenNombre(String imagenNombre) {
		this.imagenNombre = imagenNombre;
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
	public Integer getRetorno() {
		return retorno;
	}
	public void setRetorno(Integer retorno) {
		this.retorno = retorno;
	}
	
	
	@Override
	public String toString() {
		return "ModalBean [codModa=" + codModa + ", nombre=" + nombre
				+ ", situacion=" + situacion +  ", imagenUbicacion=" + imagenUbicacion
				+ ", imagenNombre=" + imagenNombre + ", file=" + file
				+ ", fileImagen=" + fileImagen + "]";
	
	
	}
}
