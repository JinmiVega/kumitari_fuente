package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
 
 
public class LenguaNivelBean extends BaseBean{
	 
	private LenguaBean lenguaBean = new LenguaBean(); 
	
	private MaestraBean nivel = new MaestraBean(); 

	private String nombreNivel;
	
	private String nombreImagen;
	
	private String subNiveles;
	
	private MaestraBean situacion = new MaestraBean(); 

	private String inicialNombre;
	 
	
	public LenguaNivelBean(){
		super();
	}

	public String getSubNiveles() {
		return subNiveles;
	}

	public void setSubNiveles(String subNiveles) {
		this.subNiveles = subNiveles;
	}

	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	public MaestraBean getNivel() {
		return nivel;
	}

	public void setNivel(MaestraBean nivel) {
		this.nivel = nivel;
	}


	public MaestraBean getSituacion() {
		return situacion;
	}

	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}

	 
	public String getNombreNivel() {
		return nombreNivel;
	}

	public void setNombreNivel(String nombreNivel) {
		this.nombreNivel = nombreNivel;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	@Override
	public String toString() {
		return "LenguaEstructuraBean [lenguaBean=" + lenguaBean + ", nivel=" + nivel 
				+ ", situacion=" + situacion  + "]";
	}

	public String getInicialNombre() {
		return inicialNombre;
	}

	public void setInicialNombre(String inicialNombre) {
		this.inicialNombre = inicialNombre;
	}
	
 
}
