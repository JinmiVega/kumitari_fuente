package pe.gob.procalidad.natigu.core.bean.bean.configuracion;

import org.springframework.web.multipart.MultipartFile;
import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean2;

@SuppressWarnings("serial")
public class SliderBean extends BaseBean{

	//Atributos
	 
	private String   nombre;
	
	
	private String   descripcion;
 
 	private MaestraBean situacion = new MaestraBean();
 
 
	private Integer 	 retorno;
	//private MultipartFile 	file;
	
	
 
	
	  
	
	//constructor	
	public SliderBean() {
		super();
		// TODO Auto-generated constructor stub
	}	
	//Getters and Setters
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
	//toString 
	@Override
	public String toString() {
		return "SliderBean [nombre=" + nombre + ", descripcion=" + descripcion
				  
				+ ", situacion=" + situacion 
				+  "]" + super.toString();
	}

	public Integer getRetorno() {
		return retorno;
	}

	public void setRetorno(Integer retorno) {
		this.retorno = retorno;
	}

	

}





	
