package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class AlterTextoPalabraEncerradaBean extends BaseBean{

	private TextoPalabraEncerradaBean	textoPalabraEncerradaBean ;
	private String						palabraEncerrada;
	private long						nroOrden;
	private String 						comentario;
	private String						palabraRpta;
	
	public AlterTextoPalabraEncerradaBean() {
		super();
	}


	public TextoPalabraEncerradaBean getTextoPalabraEncerradaBean() {
		if (textoPalabraEncerradaBean == null) {
			textoPalabraEncerradaBean = 	new TextoPalabraEncerradaBean();
		}
		return textoPalabraEncerradaBean;
	}


	public void setTextoPalabraEncerradaBean(TextoPalabraEncerradaBean textoPalabraEncerradaBean) {
		this.textoPalabraEncerradaBean = textoPalabraEncerradaBean;
	}


	public String getPalabraEncerrada() {
		return palabraEncerrada;
	}


	public void setPalabraEncerrada(String palabraEncerrada) {
		this.palabraEncerrada = palabraEncerrada;
	}


	@Override
	public String toString() {
		return "AlterTextoPalabraEncerradaBean [textoPalabraEncerradaBean=" + textoPalabraEncerradaBean
				+ ", palabraEncerrada=" + palabraEncerrada + "]";
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public long getNroOrden() {
		return nroOrden;
	}


	public void setNroOrden(long nroOrden) {
		this.nroOrden = nroOrden;
	}


	public String getPalabraRpta() {
		return palabraRpta;
	}


	public void setPalabraRpta(String palabraRpta) {
		this.palabraRpta = palabraRpta;
	}



	
	
}
