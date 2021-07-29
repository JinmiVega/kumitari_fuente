package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class AlternativaBean extends BaseBean{

	private PreguntaBean 	preguntaBean = new PreguntaBean();
	private String			descripcion;
	private String 			respuestaEstado = "0";
	
	public AlternativaBean() {
		super();
	}

 

	public PreguntaBean getPreguntaBean() {
		return preguntaBean;
	}



	public void setPreguntaBean(PreguntaBean preguntaBean) {
		this.preguntaBean = preguntaBean;
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
		return "AlternativaBean [preguntaBean=" + preguntaBean
				+ ", descripcion=" + descripcion + ", respuestaEstado="
				+ respuestaEstado + "]";
	}



 

	
	
}
