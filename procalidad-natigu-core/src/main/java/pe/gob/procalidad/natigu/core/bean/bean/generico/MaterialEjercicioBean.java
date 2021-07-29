package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class MaterialEjercicioBean extends BaseBean{
	
	private MaterialTipoEjercicioBean materialTipoEjercicioBean;
	private String titulo;
	private String descripcion;
	private MaestraBean situacionEjercicio;
	
	public MaterialEjercicioBean() {
		super();
	}
	public MaterialTipoEjercicioBean getMaterialTipoEjercicioBean() {
		return materialTipoEjercicioBean;
	}

	public void setMaterialTipoEjercicioBean(
			MaterialTipoEjercicioBean materialTipoEjercicioBean) {
		this.materialTipoEjercicioBean = materialTipoEjercicioBean;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public MaestraBean getSituacionEjercicio() {
		return situacionEjercicio;
	}

	public void setSituacionEjercicio(MaestraBean situacionEjercicio) {
		this.situacionEjercicio = situacionEjercicio;
	}
	
	@Override
	public String toString() {
		return "MaterialEjercicioBean [materialTipoEjercicioBean="
				+ materialTipoEjercicioBean + ", titulo=" + titulo
				+ ", descripcion=" + descripcion + ", situacionEjercicio="
				+ situacionEjercicio + "]";
	}
	
}
