package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class OracionAlterBean extends BaseBean{

	private OracionCompletarBean 	oracionCompletarBean ;
	private String			espacio;
	private String			descripcion;
	private String 			respuestaEstado;
	
	public OracionAlterBean() {
		super();
	}

	public OracionCompletarBean getOracionCompletarBean() {
		return oracionCompletarBean;
	}

	public void setOracionCompletarBean(OracionCompletarBean oracionCompletarBean) {
		this.oracionCompletarBean = oracionCompletarBean;
	}

	public String getEspacio() {
		return espacio;
	}

	public void setEspacio(String espacio) {
		this.espacio = espacio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRespuestaEstado() {
		return respuestaEstado;
	}

	public void setRespuestaEstado(String respuestaEstado) {
		this.respuestaEstado = respuestaEstado;
	}

	@Override
	public String toString() {
		return "OracionAlterBean [oracionCompletarBean=" + oracionCompletarBean
				+ ", espacio=" + espacio + ", descripcion=" + descripcion
				+ ", respuestaEstado=" + respuestaEstado + "]";
	} 

	
	
}
