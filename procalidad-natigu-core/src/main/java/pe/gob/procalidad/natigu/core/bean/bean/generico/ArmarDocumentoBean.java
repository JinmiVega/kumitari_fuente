package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class ArmarDocumentoBean extends BaseBean{

	private ArmarDocumentoCabBean armarDocumentoCabBean = new ArmarDocumentoCabBean();
	private long parteDocumento;
	private String traduccionParteDoc;
	private String descripcion;
	

	public ArmarDocumentoCabBean getArmarDocumentoCabBean() {
		return armarDocumentoCabBean;
	}
	public void setArmarDocumentoCabBean(ArmarDocumentoCabBean armarDocumentoCabBean) {
		this.armarDocumentoCabBean = armarDocumentoCabBean;
	}
	public long getParteDocumento() {
		return parteDocumento;
	}
	public void setParteDocumento(long parteDocumento) {
		this.parteDocumento = parteDocumento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTraduccionParteDoc() {
		return traduccionParteDoc;
	}
	public void setTraduccionParteDoc(String traduccionParteDoc) {
		this.traduccionParteDoc = traduccionParteDoc;
	}
	
	
}
