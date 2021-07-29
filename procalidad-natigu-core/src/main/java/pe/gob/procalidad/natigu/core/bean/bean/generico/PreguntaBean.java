package pe.gob.procalidad.natigu.core.bean.bean.generico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class PreguntaBean extends BaseBean{

	private String descripcion;
	private MaterialTipoEjercicioBean materialEjercicioBean = new MaterialTipoEjercicioBean();
	private Integer tipoPregunta;
	
	private List<AlternativaBean> listaAlternativa;
	
	public PreguntaBean() {
		super();
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTipoPregunta() {
		return tipoPregunta;
	}
	public void setTipoPregunta(Integer tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}
	public MaterialTipoEjercicioBean getMaterialEjercicioBean() {
		return materialEjercicioBean;
	}
	public void setMaterialEjercicioBean(MaterialTipoEjercicioBean materialEjercicioBean) {
		this.materialEjercicioBean = materialEjercicioBean;
	}
	public List<AlternativaBean> getListaAlternativa() {
		return listaAlternativa;
	}
	public void setListaAlternativa(List<AlternativaBean> listaAlternativa) {
		this.listaAlternativa = listaAlternativa;
	}
	 
	
	
	
	
}
