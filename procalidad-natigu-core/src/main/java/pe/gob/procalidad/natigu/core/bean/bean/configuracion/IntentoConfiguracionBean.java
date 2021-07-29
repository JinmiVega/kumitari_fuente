package pe.gob.procalidad.natigu.core.bean.bean.configuracion;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;

public class IntentoConfiguracionBean extends BaseBean{
	
	private MaestraBean  ejercicio  = new MaestraBean();  
	private Integer intento1;
	private Integer intento2;
	private Integer intento3;
	public MaestraBean getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(MaestraBean ejercicio) {
		this.ejercicio = ejercicio;
	}
	public Integer getIntento1() {
		return intento1;
	}
	public void setIntento1(Integer intento1) {
		this.intento1 = intento1;
	}
	public Integer getIntento2() {
		return intento2;
	}
	public void setIntento2(Integer intento2) {
		this.intento2 = intento2;
	}
	public Integer getIntento3() {
		return intento3;
	}
	public void setIntento3(Integer intento3) {
		this.intento3 = intento3;
	}
	 
	
	
	
}
