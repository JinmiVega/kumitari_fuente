package pe.gob.procalidad.natigu.core.bean.bean.generico;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class LeccionMaterialBean extends BaseBean{
	

/*********** jorge ************/
	private UnidadLeccionBean unidadLeccionBean  = new UnidadLeccionBean();

	private MaestraBean situacionLeccionMaterial = new MaestraBean();

	private String contexto;

	private String descripcionMaterial;

	private String extencionImagen;

	private String nombreImagen;

	private String rutaAudio;

	private String swEditable;

	private String ubicacionImagen;
	
	private String comentario;

	private Integer orden;
	
	private String indicacion;
	
	private long tipoTramDoc;
	
	private String nomImgTipoTramDoc;
	
	private String comprension;

	private String valor1;
	
	private String valor2;
	
	private String indicacionExtra;
	
	private String codigoEncrypt;
	
	public MaestraBean getSituacionLeccionMaterial() {
		return situacionLeccionMaterial;
	}

	public void setSituacionLeccionMaterial(MaestraBean situacionLeccionMaterial) {
		this.situacionLeccionMaterial = situacionLeccionMaterial;
	}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	public String getDescripcionMaterial() {
		return descripcionMaterial;
	}

	public void setDescripcionMaterial(String descripcionMaterial) {
		this.descripcionMaterial = descripcionMaterial;
	}

	public String getExtencionImagen() {
		return extencionImagen;
	}

	public void setExtencionImagen(String extencionImagen) {
		this.extencionImagen = extencionImagen;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public String getRutaAudio() {
		return rutaAudio;
	}

	public void setRutaAudio(String rutaAudio) {
		this.rutaAudio = rutaAudio;
	}

	public String getSwEditable() {
		return swEditable;
	}

	public void setSwEditable(String swEditable) {
		this.swEditable = swEditable;
	}

	public String getUbicacionImagen() {
		return ubicacionImagen;
	}

	public void setUbicacionImagen(String ubicacionImagen) {
		this.ubicacionImagen = ubicacionImagen;
	}

	public UnidadLeccionBean getUnidadLeccionBean() {
		return unidadLeccionBean;
	}

	public void setUnidadLeccionBean(UnidadLeccionBean unidadLeccionBean) {
		this.unidadLeccionBean = unidadLeccionBean;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getIndicacion() {
		return indicacion;
	}

	public void setIndicacion(String indicacion) {
		this.indicacion = indicacion;
	}

	public long getTipoTramDoc() {
		return tipoTramDoc;
	}

	public void setTipoTramDoc(long tipoTramDoc) {
		this.tipoTramDoc = tipoTramDoc;
	}

	public String getNomImgTipoTramDoc() {
		return nomImgTipoTramDoc;
	}

	public void setNomImgTipoTramDoc(String nomImgTipoTramDoc) {
		this.nomImgTipoTramDoc = nomImgTipoTramDoc;
	}

	public String getComprension() {
		return comprension;
	}

	public void setComprension(String comprension) {
		this.comprension = comprension;
	}

	
	
	public String getValor1() {
		return valor1;
	}

	public void setValor1(String valor1) {
		this.valor1 = valor1;
	}

	public String getValor2() {
		return valor2;
	}

	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}

	@Override
	public String toString() {
		return "LeccionMaterialBean [unidadLeccionBean=" + unidadLeccionBean + ", situacionLeccionMaterial="
				+ situacionLeccionMaterial + ", contexto=" + contexto + ", descripcionMaterial=" + descripcionMaterial
				+ ", extencionImagen=" + extencionImagen + ", nombreImagen=" + nombreImagen + ", rutaAudio=" + rutaAudio
				+ ", swEditable=" + swEditable + ", ubicacionImagen=" + ubicacionImagen + ", comentario=" + comentario
				+ ", orden=" + orden + ", indicacion=" + indicacion + ", tipoTramDoc=" + tipoTramDoc
				+ ", nomImgTipoTramDoc=" + nomImgTipoTramDoc + ", comprension=" + comprension + "]";
	}

	public String getIndicacionExtra() {
		return indicacionExtra;
	}

	public void setIndicacionExtra(String indicacionExtra) {
		this.indicacionExtra = indicacionExtra;
	}

	public String getCodigoEncrypt() {
		return codigoEncrypt;
	}

	public void setCodigoEncrypt(String codigoEncrypt) {
		this.codigoEncrypt = codigoEncrypt;
	}

}