package pe.gob.procalidad.natigu.core.bean.bean.generico;

import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class RelacionVariadaBean extends BaseBean{

	private RelacionCabeceraBean relacionCabeceraBean = new RelacionCabeceraBean(); 
	private String 	imagen;
	private String 	texto;
	private String 	texto2;
	private Integer tipoRelacion; 
	private Integer orden;
	private MultipartFile file;
	private MultipartFile fileImagen; 
	 
	
	public RelacionVariadaBean() {
		super();
	}

	public RelacionCabeceraBean getRelacionCabeceraBean() {
		return relacionCabeceraBean;
	}

	public void setRelacionCabeceraBean(RelacionCabeceraBean relacionCabeceraBean) {
		this.relacionCabeceraBean = relacionCabeceraBean;
	}

	 

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTexto2() {
		return texto2;
	}

	public void setTexto2(String texto2) {
		this.texto2 = texto2;
	}

	public Integer getTipoRelacion() {
		return tipoRelacion;
	}

	public void setTipoRelacion(Integer tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	} 
	 

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public MultipartFile getFileImagen() {
		return fileImagen;
	}

	public void setFileImagen(MultipartFile fileImagen) {
		this.fileImagen = fileImagen;
	} 

	 
	@Override
	public String toString() {
		return "RelacionVariadaBean [relacionCabeceraBean="
				+ relacionCabeceraBean + ", imagen=" + imagen + ", texto="
				+ texto + ", texto2=" + texto2 + ", tipoRelacion="
				+ tipoRelacion + ", orden=" + orden + ", file=" + file
				+ ", fileImagen=" + fileImagen + "]";
	}


	
	
}
