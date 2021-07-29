package pe.gob.procalidad.natigu.core.bean.bean.configuracion;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;

public class PremioConfiguracionBean extends BaseBean{
	
	private MaestraBean  categoria  = new MaestraBean();
	private MaestraBean  situacion  = new MaestraBean();
	private String flagBasico;
	private String flagHonorifico;
	private String flagPremium;
	private Integer monedas;
	private Integer gemas;
	public MaestraBean getCategoria() {
		return categoria;
	}
	public void setCategoria(MaestraBean categoria) {
		this.categoria = categoria;
	}
	public MaestraBean getSituacion() {
		return situacion;
	}
	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}
	public String getFlagBasico() {
		return flagBasico;
	}
	public void setFlagBasico(String flagBasico) {
		this.flagBasico = flagBasico;
	}
	public String getFlagHonorifico() {
		return flagHonorifico;
	}
	public void setFlagHonorifico(String flagHonorifico) {
		this.flagHonorifico = flagHonorifico;
	}
	public String getFlagPremium() {
		return flagPremium;
	}
	public void setFlagPremium(String flagPremium) {
		this.flagPremium = flagPremium;
	}
	public Integer getMonedas() {
		return monedas;
	}
	public void setMonedas(Integer monedas) {
		this.monedas = monedas;
	}
	public Integer getGemas() {
		return gemas;
	}
	public void setGemas(Integer gemas) {
		this.gemas = gemas;
	}
	@Override
	public String toString() {
		return "PremioConfiguracionBean [categoria=" + categoria + ", situacion=" + situacion + ", flagBasico="
				+ flagBasico + ", flagHonorifico=" + flagHonorifico + ", flagPremium=" + flagPremium + ", monedas="
				+ monedas + ", gemas=" + gemas + "]";
	}
	
	
}
