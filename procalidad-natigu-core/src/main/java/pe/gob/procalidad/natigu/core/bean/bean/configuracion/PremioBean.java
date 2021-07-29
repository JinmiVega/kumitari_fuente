package pe.gob.procalidad.natigu.core.bean.bean.configuracion;

import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMedallaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;

public class PremioBean extends BaseBean{
	
	//Atributos
	private Integer 	 codPremio;
	private String  	 nombre;
	private String  	 descripcion; 
	private Integer  	 puntos;
	private AlumnoMedallaBean alumnoMedallaBean;
	private MaestraBean  situacion  = new MaestraBean();
	private MaestraBean  region 	= new MaestraBean();
	private MaestraBean  tipo 		= new MaestraBean();
	private String 		imagenUbicacion;
	private String 		imagenNombre;  
	private MultipartFile 	file;
	private MultipartFile 	fileImagen; 
	private Integer 	 retorno;
	
	//constructor	
	public PremioBean() {
		super();
	}

	
	//Getters and Setters
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
	public Integer getCodPremio() {
		return codPremio;
	}


	public void setCodPremio(Integer codPremio) {
		this.codPremio = codPremio;
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
	 


	public Integer getPuntos() {
		return puntos;
	}


	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}


	public MaestraBean getSituacion() {
		return situacion;
	}


	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}


	public MaestraBean getRegion() {
		return region;
	}


	public void setRegion(MaestraBean region) {
		this.region = region;
	}

	public MaestraBean getTipo() {
		return tipo;
	}



	public void setTipo(MaestraBean tipo) {
		this.tipo = tipo;
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
	
	//toString 
 
	public Integer getRetorno() {
		return retorno;
	}


	public void setRetorno(Integer retorno) {
		this.retorno = retorno;
	}
 

	public AlumnoMedallaBean getAlumnoMedallaBean() {
		return alumnoMedallaBean;
	}


	public void setAlumnoMedallaBean(AlumnoMedallaBean alumnoMedallaBean) {
		this.alumnoMedallaBean = alumnoMedallaBean;
	}


	@Override
	public String toString() {
		return "PremioBean [codPremio=" + codPremio + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", puntos=" + puntos
				+ ", alumnoMedallaBean=" + alumnoMedallaBean + ", situacion="
				+ situacion + ", region=" + region + ", tipo=" + tipo
				+ ", imagenUbicacion=" + imagenUbicacion + ", imagenNombre="
				+ imagenNombre + ", file=" + file + ", fileImagen="
				+ fileImagen + ", retorno=" + retorno + "]";
	}

	

}
