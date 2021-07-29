package pe.gob.procalidad.natigu.core.bean.bean.seguridad;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class AuditoriaDetalleBean extends BaseBean{
			
	private AuditoriaBean   auditoriaBean = new AuditoriaBean();
	private String 			nomCampo;
	private String 			valorAnterior;
	private String 			valorNuevo;
	private String 			nomTabla;
	private String			nomEsquema;
	
	public AuditoriaDetalleBean() {
		super();
	}

	public AuditoriaBean getAuditoriaBean() {
		return auditoriaBean;
	}

	public void setAuditoriaBean(AuditoriaBean auditoriaBean) {
		this.auditoriaBean = auditoriaBean;
	}

	public String getNomCampo() {
		return nomCampo;
	}

	public void setNomCampo(String nomCampo) {
		this.nomCampo = nomCampo;
	}

	public String getValorAnterior() {
		return valorAnterior;
	}

	public void setValorAnterior(String valorAnterior) {
		this.valorAnterior = valorAnterior;
	}

	public String getValorNuevo() {
		return valorNuevo;
	}

	public void setValorNuevo(String valorNuevo) {
		this.valorNuevo = valorNuevo;
	}

	public String getNomTabla() {
		return nomTabla;
	}

	public void setNomTabla(String nomTabla) {
		this.nomTabla = nomTabla;
	}

	public String getNomEsquema() {
		return nomEsquema;
	}

	public void setNomEsquema(String nomEsquema) {
		this.nomEsquema = nomEsquema;
	}

	@Override
	public String toString() {
		return "AuditoriaDetalleBean [auditoriaBean=" + auditoriaBean + ", nomCampo=" + nomCampo + ", valorAnterior="
				+ valorAnterior + ", valorNuevo=" + valorNuevo + ", nomTabla=" + nomTabla + ", nomEsquema=" + nomEsquema
				+ "]";
	}
	
}