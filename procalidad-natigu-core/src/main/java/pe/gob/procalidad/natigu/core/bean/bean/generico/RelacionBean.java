package pe.gob.procalidad.natigu.core.bean.bean.generico;

import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class RelacionBean extends BaseBean{

	private RelacionCabeceraBean relacionCabeceraBean = new RelacionCabeceraBean();
	private String 	palabra;
	private String 	imagen;
	private String 	texto;
	private String 	texto2;
	private Integer tipoRelacion;
	private Integer cantletras;
	private Integer orientacion;
	private Integer orden;
	private MultipartFile file;
	private MultipartFile fileImagen;
	private String  texto3;
	private String parrafo;
	private int  tipo;
	private String palabraSeparada; 
	
	public RelacionBean() {
		super();
	}

	public RelacionCabeceraBean getRelacionCabeceraBean() {
		return relacionCabeceraBean;
	}

	public void setRelacionCabeceraBean(RelacionCabeceraBean relacionCabeceraBean) {
		this.relacionCabeceraBean = relacionCabeceraBean;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
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

	public Integer getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(Integer orientacion) {
		this.orientacion = orientacion;
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
	public String getTexto3() {
		return texto3;
	}

	public void setTexto3(String texto3) {
		this.texto3 = texto3;
	}

	
	
	public String getParrafo() {
		return parrafo;
	}

	public void setParrafo(String parrafo) {
		this.parrafo = parrafo;
	}

	 

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Integer getCantletras() {
		return cantletras;
	}

	public void setCantletras(Integer cantletras) {
		this.cantletras = cantletras;
	}

	public String getPalabraSeparada() {
		return palabraSeparada;
	}

	public void setPalabraSeparada(String v_palabraSeparada) {
		this.palabraSeparada = v_palabraSeparada;
	}

	@Override
	public String toString() {
		return "RelacionBean [relacionCabeceraBean=" + relacionCabeceraBean
				+ ", palabra=" + palabra + ", imagen=" + imagen + ", texto="
				+ texto + ", texto2=" + texto2 + ", tipoRelacion="
				+ tipoRelacion + ", cantletras=" + cantletras
				+ ", orientacion=" + orientacion + ", orden=" + orden
				+ ", file=" + file + ", fileImagen=" + fileImagen + ", texto3="
				+ texto3 + ", parrafo=" + parrafo + ", tipo=" + tipo + "]";
	}



	
}
