package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class ArrastraOraDetBean extends BaseBean{

	private ArrastraOraciBean 	arrastraOraciBean ;
	private String			orden;
	private String			descripcion; 
	
	public ArrastraOraDetBean() {
		super();
	}

	public ArrastraOraciBean getArrastraOraciBean() {
		return arrastraOraciBean;
	}

	public void setArrastraOraciBean(ArrastraOraciBean arrastraOraciBean) {
		this.arrastraOraciBean = arrastraOraciBean;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "ArrastraOraDetBean [arrastraOraciBean=" + arrastraOraciBean
				+ ", orden=" + orden + ", descripcion=" + descripcion + "]";
	}

	 
	
	
}
