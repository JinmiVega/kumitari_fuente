package pe.gob.procalidad.natigu.core.bean.bean.configuracion;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;

import java.math.BigDecimal;
import java.util.Date;


public class TraduccionBean extends BaseBean{

	private Long codigoTraduccion;

	
	private String traduccion;

	EtiquetaBean etiqueta;
	LenguaBean lengua;
	
	private Integer tipoEtiqueta;
	private Integer codigoLengua;
	
	//bi-directional many-to-one association to LeotbcEtiqueta
//	@ManyToOne
//	@JoinColumn(name="n_codetiqueta")
//	private LeotbcEtiqueta leotbcEtiqueta;

	public TraduccionBean() {
	}


	public Long getCodigoTraduccion() {
		return codigoTraduccion;
	}


	public void setCodigoTraduccion(Long codigoTraduccion) {
		this.codigoTraduccion = codigoTraduccion;
	}


	public String getTraduccion() {
		return traduccion;
	}


	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}


	public EtiquetaBean getEtiqueta() {
		return etiqueta;
	}


	public void setEtiqueta(EtiquetaBean etiqueta) {
		this.etiqueta = etiqueta;
	}


	public LenguaBean getLengua() {
		return lengua;
	}


	public void setLengua(LenguaBean lengua) {
		this.lengua = lengua;
	}


	public Integer getTipoEtiqueta() {
		return tipoEtiqueta;
	}


	public void setTipoEtiqueta(Integer tipoEtiqueta) {
		this.tipoEtiqueta = tipoEtiqueta;
	}


	public Integer getCodigoLengua() {
		return codigoLengua;
	}


	public void setCodigoLengua(Integer codigoLengua) {
		this.codigoLengua = codigoLengua;
	}


	@Override
	public String toString() {
		return "TraduccionBean [codigoTraduccion=" + codigoTraduccion
				+ ", traduccion=" + traduccion + ", etiqueta=" + etiqueta
				+ ", lengua=" + lengua + "]";
	}

	

}