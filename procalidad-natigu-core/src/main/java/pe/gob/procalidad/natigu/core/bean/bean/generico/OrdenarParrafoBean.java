package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class OrdenarParrafoBean extends BaseBean{

	//Atributos
	private MaterialTipoEjercicioBean materialTipoEjercicioBean = new MaterialTipoEjercicioBean();
	private String titulo;
	private String parrafo;
	private int    numeroOrden;
	private boolean ordenar;
	private int posini;
	private int posfin;
	private OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean = new OrdenarParrafoCabeceraBean();
	private int  tipo;
	
	//Constructor
	
	public OrdenarParrafoBean() {
		super();
	}
	
	//Getters and Setters
	
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

	public String getParrafo() {
		return parrafo;
	}

	public void setParrafo(String parrafo) {
		this.parrafo = parrafo;
	}

	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
	public OrdenarParrafoCabeceraBean getOrdenarParrafoCabeceraBean() {
		return ordenarParrafoCabeceraBean;
	}

	public void setOrdenarParrafoCabeceraBean(OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean) {
		this.ordenarParrafoCabeceraBean = ordenarParrafoCabeceraBean;
	}
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	
	//toString
	
	public int getPosini() {
		return posini;
	}

	public void setPosini(int posini) {
		this.posini = posini;
	}

	public int getPosfin() {
		return posfin;
	}

	public void setPosfin(int posfin) {
		this.posfin = posfin;
	}

	public boolean isOrdenar() {
		return ordenar;
	}

	public void setOrdenar(boolean ordenar) {
		this.ordenar = ordenar;
	}

	@Override
	public String toString() {
		return "OrdenarParrafoBean [materialTipoEjercicioBean="
				+ materialTipoEjercicioBean + ", titulo=" + titulo
				+ ", parrafo=" + parrafo + ", numeroOrden=" + numeroOrden + "]";
	}

}
