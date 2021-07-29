package pe.gob.procalidad.natigu.core.bean.bean.seguridad;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class AuditoriaTablaBean extends BaseBean{
			
	private String 			nomEsquema;
	private String 			nomTabla;
	private String 			nomCampo;
	
	private String 			descEsquema;
	private String 			descTabla;
	private String 			descCampo;
	
	private String 			flgauditar;
	private String 			flgprincipal;
	private String 			flgoffline;
	
	private String 			nomEsqTabConcat1;
	private String 			nomEsqTabConcat2;
	
	public AuditoriaTablaBean() {
		super();
	}

	public String getNomEsquema() {
		return nomEsquema;
	}

	public void setNomEsquema(String nomEsquema) {
		this.nomEsquema = nomEsquema;
	}

	public String getNomTabla() {
		return nomTabla;
	}

	public void setNomTabla(String nomTabla) {
		this.nomTabla = nomTabla;
	}

	public String getNomCampo() {
		return nomCampo;
	}

	public void setNomCampo(String nomCampo) {
		this.nomCampo = nomCampo;
	}

	public String getDescEsquema() {
		return descEsquema;
	}

	public void setDescEsquema(String descEsquema) {
		this.descEsquema = descEsquema;
	}

	public String getDescTabla() {
		return descTabla;
	}

	public void setDescTabla(String descTabla) {
		this.descTabla = descTabla;
	}

	public String getDescCampo() {
		return descCampo;
	}

	public void setDescCampo(String descCampo) {
		this.descCampo = descCampo;
	}

	public String getFlgauditar() {
		return flgauditar;
	}

	public void setFlgauditar(String flgauditar) {
		this.flgauditar = flgauditar;
	}

	public String getFlgprincipal() {
		return flgprincipal;
	}

	public void setFlgprincipal(String flgprincipal) {
		this.flgprincipal = flgprincipal;
	}

	public String getFlgoffline() {
		return flgoffline;
	}

	public void setFlgoffline(String flgoffline) {
		this.flgoffline = flgoffline;
	}

	public String getNomEsqTabConcat1() {
		return nomEsqTabConcat1;
	}

	public void setNomEsqTabConcat1(String nomEsqTabConcat1) {
		this.nomEsqTabConcat1 = nomEsqTabConcat1;
	}

	public String getNomEsqTabConcat2() {
		return nomEsqTabConcat2;
	}

	public void setNomEsqTabConcat2(String nomEsqTabConcat2) {
		this.nomEsqTabConcat2 = nomEsqTabConcat2;
	}

	@Override
	public String toString() {
		return "AuditoriaTablaBean [nomEsquema=" + nomEsquema + ", nomTabla=" + nomTabla + ", nomCampo=" + nomCampo
				+ ", descEsquema=" + descEsquema + ", descTabla=" + descTabla + ", descCampo=" + descCampo
				+ ", flgauditar=" + flgauditar + ", flgprincipal=" + flgprincipal + ", flgoffline=" + flgoffline
				+ ", nomEsqTabConcat1=" + nomEsqTabConcat1 + ", nomEsqTabConcat2=" + nomEsqTabConcat2 + "]";
	}
	
}