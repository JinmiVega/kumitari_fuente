package pe.gob.procalidad.natigu.core.bean.bean.academico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
public class AlumnoMonedaGBean extends BaseBean{
	
	//Atributos
	private  int  		 	  numeroMonedas;
	private  int  		 	  numeroGemas;
	private Integer 		  numeroBono;
	private  int              existe;
	private MaterialTipoEjercicioBean materialTipoEjercicioBean;
	private UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();

	
	//Constructor
	public AlumnoMonedaGBean() {
		super();
	}

	//Getters and Setters
	 
	public int getNumeroMonedas() {
		return numeroMonedas;
	}


	public void setNumeroMonedas(int numeroMonedas) {
		this.numeroMonedas = numeroMonedas;
	}


	public int getNumeroGemas() {
		return numeroGemas;
	}


	public void setNumeroGemas(int numeroGemas) {
		this.numeroGemas = numeroGemas;
	}

	public UsuarioMatriculaBean getUsuarioMatriculaBean() {
		return usuarioMatriculaBean;
	}

	public void setUsuarioMatriculaBean(UsuarioMatriculaBean usuarioMatriculaBean) {
		this.usuarioMatriculaBean = usuarioMatriculaBean;
	}

	public int getExiste() {
		return existe;
	}

	public void setExiste(int existe) {
		this.existe = existe;
	}

	public MaterialTipoEjercicioBean getMaterialTipoEjercicioBean() {
		return materialTipoEjercicioBean;
	}

	public void setMaterialTipoEjercicioBean(MaterialTipoEjercicioBean materialTipoEjercicioBean) {
		this.materialTipoEjercicioBean = materialTipoEjercicioBean;
	}

	public Integer getNumeroBono() {
		return numeroBono;
	}

	public void setNumeroBono(Integer numeroBono) {
		this.numeroBono = numeroBono;
	}

	@Override
	public String toString() {
		return "AlumnoMonedaGBean [numeroMonedas=" + numeroMonedas
				+ ", numeroGemas=" + numeroGemas + ", numeroBono=" + numeroBono
				+ ", existe=" + existe + ", materialTipoEjercicioBean="
				+ materialTipoEjercicioBean + ", usuarioMatriculaBean="
				+ usuarioMatriculaBean + "]";
	}
	
}
