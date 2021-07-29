package pe.gob.procalidad.natigu.web.gestion.controller.general.view;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaLeccionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaNivelBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaUnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;

public class LenguaForm {

	private LenguaBean lenguaBean = new LenguaBean();

	private LenguaNivelBean lenguaNivelBean = new LenguaNivelBean();

	private LenguaEstructuraBean lenguaEstructuraBean = new LenguaEstructuraBean();

	private UnidadBean unidadBean = new UnidadBean();

	private UnidadLeccionBean unidadLeccionBean = new UnidadLeccionBean();
	
	private LenguaUnidadBean lenguaUnidadBean = new LenguaUnidadBean();
	
	private LenguaLeccionBean lenLeccionBean = new LenguaLeccionBean();

	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	public LenguaEstructuraBean getLenguaEstructuraBean() {
		return lenguaEstructuraBean;
	}

	public void setLenguaEstructuraBean(LenguaEstructuraBean lenguaEstructuraBean) {
		this.lenguaEstructuraBean = lenguaEstructuraBean;
	}

	public UnidadBean getUnidadBean() {
		return unidadBean;
	}

	public void setUnidadBean(UnidadBean unidadBean) {
		this.unidadBean = unidadBean;
	}

	public UnidadLeccionBean getUnidadLeccionBean() {
		return unidadLeccionBean;
	}

	public void setUnidadLeccionBean(UnidadLeccionBean unidadLeccionBean) {
		this.unidadLeccionBean = unidadLeccionBean;
	}

	public LenguaNivelBean getLenguaNivelBean() {
		return lenguaNivelBean;
	}

	public void setLenguaNivelBean(LenguaNivelBean lenguaNivelBean) {
		this.lenguaNivelBean = lenguaNivelBean;
	}

	public LenguaUnidadBean getLenguaUnidadBean() {
		return lenguaUnidadBean;
	}

	public void setLenguaUnidadBean(LenguaUnidadBean lenguaUnidadBean) {
		this.lenguaUnidadBean = lenguaUnidadBean;
	}

	public LenguaLeccionBean getLenLeccionBean() {
		return lenLeccionBean;
	}

	public void setLenLeccionBean(LenguaLeccionBean lenLeccionBean) {
		this.lenLeccionBean = lenLeccionBean;
	}

	@Override
	public String toString() {
		return "LenguaForm [lenguaBean=" + lenguaBean + ", lenguaNivelBean="
				+ lenguaNivelBean + ", lenguaEstructuraBean="
				+ lenguaEstructuraBean + ", unidadBean=" + unidadBean
				+ ", unidadLeccionBean=" + unidadLeccionBean
				+ ", lenguaUnidadBean=" + lenguaUnidadBean
				+ ", lenLeccionBean=" + lenLeccionBean + "]";
	}

}
