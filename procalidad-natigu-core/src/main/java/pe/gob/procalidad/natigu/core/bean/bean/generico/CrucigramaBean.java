package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class CrucigramaBean extends BaseBean{

//	private EjercicioBean ejercicioBean;
	
	private String palabra;
	private String definicion;
	private Integer orientacion;
	private Integer orden;
	
	public CrucigramaBean() {
		super();
	}

//	public EjercicioBean getEjercicioBean() {
//		return ejercicioBean;
//	}
//
//	public void setEjercicioBean(EjercicioBean ejercicioBean) {
//		this.ejercicioBean = ejercicioBean;
//	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public String getDefinicion() {
		return definicion;
	}

	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}

	public Integer getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(Integer orientacion) {
		this.orientacion = orientacion;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

//	@Override
//	public String toString() {
//		return "CrucigramaBean [ejercicioBean=" + ejercicioBean + ", palabra="
//				+ palabra + ", definicion=" + definicion + ", orientacion="
//				+ orientacion + ", orden=" + orden + "]";
//	}
		
	
}
