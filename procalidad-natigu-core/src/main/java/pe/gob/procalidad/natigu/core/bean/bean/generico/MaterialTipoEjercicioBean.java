package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class MaterialTipoEjercicioBean extends BaseBean{
	
	//Atributo 
	private LeccionMaterialBean leccionMaterialBean =  new LeccionMaterialBean();
	private MaestraBean 	    tipoEjercicio 		= new MaestraBean();
	private MaestraBean 		situacionTipo 		= new MaestraBean();
	private String 				titulo;
	private Integer 			orden;
	private String     		 	subTitulo;
	private String				comprension;
	private String				expresionGramatical;
	private Integer				flgPregu;
	
	//Constructor
	public MaterialTipoEjercicioBean() {
		super();
	}

	//Getters and Setters
	public MaestraBean getTipoEjercicio() {
		return tipoEjercicio;
	}


	public void setTipoEjercicio(MaestraBean tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}


	public MaestraBean getSituacionTipo() {
		return situacionTipo;
	}


	public void setSituacionTipo(MaestraBean situacionTipo) {
		this.situacionTipo = situacionTipo;
	}
	
	public LeccionMaterialBean getLeccionMaterialBean() {
		return leccionMaterialBean;
	}

	public void setLeccionMaterialBean(LeccionMaterialBean leccionMaterialBean) {
		this.leccionMaterialBean = leccionMaterialBean;
	}
		
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public String getComprension() {
		return comprension;
	}

	public void setComprension(String comprension) {
		this.comprension = comprension;
	}

	public String getExpresionGramatical() {
		return expresionGramatical;
	}

	public void setExpresionGramatical(String expresionGramatical) {
		this.expresionGramatical = expresionGramatical;
	}

	public Integer getFlgPregu() {
		return flgPregu;
	}

	public void setFlgPregu(Integer flgPregu) {
		this.flgPregu = flgPregu;
	}

	@Override
	public String toString() {
		return "MaterialTipoEjercicioBean [leccionMaterialBean=" + leccionMaterialBean + ", tipoEjercicio="
				+ tipoEjercicio + ", situacionTipo=" + situacionTipo + ", titulo=" + titulo + ", orden=" + orden
				+ ", subTitulo=" + subTitulo + ", comprension=" + comprension + ", expresionGramatical="
				+ expresionGramatical + ", flgPregu=" + flgPregu + "]";
	}

}