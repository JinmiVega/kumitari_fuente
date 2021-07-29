package pe.gob.procalidad.natigu.core.bean.bean.configuracion;


import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;


public class EtiquetaBean extends BaseBean {

	private Long codigoEtiqueta;
	private MaestraBean  tipoEtiqueta;

	private String descripcion;

	private String urlImagen;

	//bi-directional many-to-one association to LeotbdTraduccion
//	@OneToMany(mappedBy="leotbcEtiqueta")
//	private List<LeotbdTraduccion> leotbdTraduccions;

	public EtiquetaBean() {
		super();
	}

	public Long getCodigoEtiqueta() {
		return codigoEtiqueta;
	}

	public void setCodigoEtiqueta(Long codigoEtiqueta) {
		this.codigoEtiqueta = codigoEtiqueta;
	}

	public MaestraBean getTipoEtiqueta() {
		return tipoEtiqueta;
	}

	public void setTipoEtiqueta(MaestraBean tipoEtiqueta) {
		this.tipoEtiqueta = tipoEtiqueta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	


}