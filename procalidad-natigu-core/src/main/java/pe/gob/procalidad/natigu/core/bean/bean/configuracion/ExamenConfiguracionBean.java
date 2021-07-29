package pe.gob.procalidad.natigu.core.bean.bean.configuracion;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;

public class ExamenConfiguracionBean extends BaseBean{
	
	private MaestraBean  subnivel  = new MaestraBean();
	private MaestraBean  unidad  = new MaestraBean();
	private MaestraBean  leccion  = new MaestraBean();
	
	private Integer puntajeaprobacion;

	public MaestraBean getSubnivel() {
		return subnivel;
	}

	public void setSubnivel(MaestraBean subnivel) {
		this.subnivel = subnivel;
	}

	public MaestraBean getUnidad() {
		return unidad;
	}

	public void setUnidad(MaestraBean unidad) {
		this.unidad = unidad;
	}

	public MaestraBean getLeccion() {
		return leccion;
	}

	public void setLeccion(MaestraBean leccion) {
		this.leccion = leccion;
	}

	public Integer getPuntajeaprobacion() {
		return puntajeaprobacion;
	}

	public void setPuntajeaprobacion(Integer puntajeaprobacion) {
		this.puntajeaprobacion = puntajeaprobacion;
	}

	@Override
	public String toString() {
		return "ExamenConfiguracion [subnivel=" + subnivel + ", unidad=" + unidad + ", leccion=" + leccion
				+ ", puntajeaprobacion=" + puntajeaprobacion + "]";
	}

	
}
