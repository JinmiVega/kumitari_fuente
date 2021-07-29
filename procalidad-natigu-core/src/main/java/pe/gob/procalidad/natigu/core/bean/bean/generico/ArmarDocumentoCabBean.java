package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class ArmarDocumentoCabBean extends BaseBean{

	private MaterialTipoEjercicioBean materialTipoEjercicioBean = new MaterialTipoEjercicioBean();
	private Integer tipoDocumento;
	private MaestraBean maestraTipoDoc= new MaestraBean();
	private String titulo;
	public MaterialTipoEjercicioBean getMaterialTipoEjercicioBean() {
		return materialTipoEjercicioBean;
	}
	public void setMaterialTipoEjercicioBean(MaterialTipoEjercicioBean materialTipoEjercicioBean) {
		this.materialTipoEjercicioBean = materialTipoEjercicioBean;
	}
	public Integer getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public MaestraBean getMaestraTipoDoc() {
		return maestraTipoDoc;
	}
	public void setMaestraTipoDoc(MaestraBean maestraTipoDoc) {
		this.maestraTipoDoc = maestraTipoDoc;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
