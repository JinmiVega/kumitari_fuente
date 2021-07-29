package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class TextoPalabraCorrectaBean extends BaseBean{

	private MaterialTipoEjercicioBean materialTipoEjercicioBean;
	private String titulo;
	private String comentario;
	private String texto;
 
	
	public TextoPalabraCorrectaBean() {
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



	public String getTexto() {
		return texto;
	}



	public void setTexto(String texto) {
		this.texto = texto;
	}
	


	public String getComentario() {
		return comentario;
	}



	public void setComentario(String comentario) {
		this.comentario = comentario;
	}



	@Override
	public String toString() {
		return "TextoPalabraCorrectaBean [materialTipoEjercicioBean="
				+ materialTipoEjercicioBean + ", titulo=" + titulo
				+ ", comentario=" + comentario + ", texto=" + texto + "]";
	}



 

	 
	
}
