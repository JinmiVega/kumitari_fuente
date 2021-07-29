package pe.gob.procalidad.natigu.core.bean.bean.configuracion; 
import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBonoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMedallaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;

public class BonoBean extends BaseBean{
	
	//Atributos 
	private String  	 nombre;
	private String  	 descripcion;   
	private AlumnoBonoBean alumnoBonoBean;
	private MaestraBean  situacion  = new MaestraBean(); 
	private MaestraBean  tipo 		= new MaestraBean(); 
	private Integer 	 retorno;
	private String tiempo;
	private MaestraBean tipoEjercicio = new MaestraBean();
	private String nombreImg;
	
	//constructor	
	public BonoBean() {
		super();
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

	public AlumnoBonoBean getAlumnoBonoBean() {
		return alumnoBonoBean;
	}

	public void setAlumnoBonoBean(AlumnoBonoBean alumnoBonoBean) {
		this.alumnoBonoBean = alumnoBonoBean;
	}

	public MaestraBean getSituacion() {
		return situacion;
	}

	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}

	public MaestraBean getTipo() {
		return tipo;
	}

	public void setTipo(MaestraBean tipo) {
		this.tipo = tipo;
	}

	public Integer getRetorno() {
		return retorno;
	}

	public void setRetorno(Integer retorno) {
		this.retorno = retorno;
	}
	
	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	
	
	public String getNombreImg() {
		return nombreImg;
	}


	public void setNombreImg(String nombreImg) {
		this.nombreImg = nombreImg;
	}

	public MaestraBean getTipoEjercicio() {
		return tipoEjercicio;
	}


	public void setTipoEjercicio(MaestraBean tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}

	@Override
	public String toString() {
		return "BonoBean [nombre=" + nombre + ", descripcion=" + descripcion
				+ ", alumnoBonoBean=" + alumnoBonoBean + ", situacion="
				+ situacion + ", tipo=" + tipo + ", retorno=" + retorno + "]";
	}

}
