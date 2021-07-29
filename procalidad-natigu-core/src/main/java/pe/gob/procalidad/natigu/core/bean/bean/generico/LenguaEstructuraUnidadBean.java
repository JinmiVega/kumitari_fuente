package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class LenguaEstructuraUnidadBean extends BaseBean{
	
	private LenguaEstructuraBean lenguaEstructuraBean;
	
	private MaestraBean unidad = new MaestraBean();
	
	private String nombre;
	
	private String descripcion;
	
	private MaestraBean situacion = new MaestraBean();

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

	
} 
