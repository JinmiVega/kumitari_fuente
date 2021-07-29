package pe.gob.procalidad.natigu.core.bean.bean.generico;

import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class UnidadBean extends BaseBean{
	
	private LenguaEstructuraBean lenguaEstructuraBean = new LenguaEstructuraBean();
	
	private LenguaUnidadBean lenguaUnidadBean;
	
	private MaestraBean unidad = new MaestraBean();
	
	private String nombre;
	
	private String traduccion;
	
	private String descripcion;
	
	private MaestraBean situacion = new MaestraBean();
	
	private String nombreLecciones;
	
	private String nombreImagen;
	
	
	
	private MultipartFile file;
	private MultipartFile fileImagen;
	
	private String codigoEncrypt;

	public LenguaEstructuraBean getLenguaEstructuraBean() {
		return lenguaEstructuraBean;
	}

	public void setLenguaEstructuraBean(LenguaEstructuraBean lenguaEstructuraBean) {
		this.lenguaEstructuraBean = lenguaEstructuraBean;
	}
	
	public MaestraBean getUnidad() {
		return unidad;
	}

	public void setUnidad(MaestraBean unidad) {
		this.unidad = unidad;
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

	public String getTraduccion() {
		return traduccion;
	}

	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}

	public String getNombreLecciones() {
		return nombreLecciones;
	}

	public void setNombreLecciones(String nombreLecciones) {
		this.nombreLecciones = nombreLecciones;
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

	public LenguaUnidadBean getLenguaUnidadBean() {
		return lenguaUnidadBean;
	}

	public void setLenguaUnidadBean(LenguaUnidadBean lenguaUnidadBean) {
		this.lenguaUnidadBean = lenguaUnidadBean;
	}

	public String getCodigoEncrypt() {
		return codigoEncrypt;
	}

	public void setCodigoEncrypt(String codigoEncrypt) {
		this.codigoEncrypt = codigoEncrypt;
	}

	@Override
	public String toString() {
		return "UnidadBean [lenguaEstructuraBean=" + lenguaEstructuraBean
				+ ", unidad=" + unidad + ", nombre=" + nombre + ", traduccion="
				+ traduccion + ", descripcion=" + descripcion + ", situacion="
				+ situacion + ", nombreLecciones=" + nombreLecciones
				+ ", nombreImagen=" + nombreImagen + "]";
	}




}
