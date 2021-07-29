package pe.gob.procalidad.natigu.core.bean.bean.academico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
public class SeguimientoAlumnoEjerDetBean extends BaseBean{
	
	//Atributos
	private  int  		 	  numeroMonedas;
	private  LenguaBean       lenguaBean = new LenguaBean();
	private  PreguntaBean       preguntaBean ;
	private  MaterialTipoEjercicioBean materialTipoEjercicioBean = new MaterialTipoEjercicioBean();
	private  UsuarioBean usuarioBean = new UsuarioBean();

	
	//Constructor
	public SeguimientoAlumnoEjerDetBean() {
		super();
	}

	//Getters and Setters
	public int getNumeroMonedas() {
		return numeroMonedas;
	}


	public void setNumeroMonedas(int numeroMonedas) {
		this.numeroMonedas = numeroMonedas;
	}


	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}


	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}


	public MaterialTipoEjercicioBean getMaterialTipoEjercicioBean() {
		return materialTipoEjercicioBean;
	}


	public void setMaterialTipoEjercicioBean(
			MaterialTipoEjercicioBean materialTipoEjercicioBean) {
		this.materialTipoEjercicioBean = materialTipoEjercicioBean;
	}


	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}


	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}
 

	public PreguntaBean getPreguntaBean() {
		return preguntaBean;
	}

	public void setPreguntaBean(PreguntaBean preguntaBean) {
		this.preguntaBean = preguntaBean;
	}

	@Override
	public String toString() {
		return "SeguimientoAlumnoEjerDetBean [numeroMonedas=" + numeroMonedas
				+ ", lenguaBean=" + lenguaBean + ", preguntaBean="
				+ preguntaBean + ", materialTipoEjercicioBean="
				+ materialTipoEjercicioBean + ", usuarioBean=" + usuarioBean
				+ "]";
	}
		
	
	
}
