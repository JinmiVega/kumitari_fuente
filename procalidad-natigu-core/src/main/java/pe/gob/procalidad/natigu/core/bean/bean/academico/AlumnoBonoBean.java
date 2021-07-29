package pe.gob.procalidad.natigu.core.bean.bean.academico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.BonoBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;

public class AlumnoBonoBean extends BaseBean{
	
	//Atributos
	
	private UsuarioMatriculaBean usuarioMatriculaBean ;
	private BonoBean bonoBean;
	private UnidadLeccionBean unidadLeccionBean; 
	
 
	//Constructor
	
	public AlumnoBonoBean() {
		super();
	}
	//Getters and Setters

	public UsuarioMatriculaBean getUsuarioMatriculaBean() {
		return usuarioMatriculaBean;
	}

	public void setUsuarioMatriculaBean(UsuarioMatriculaBean usuarioMatriculaBean) {
		this.usuarioMatriculaBean = usuarioMatriculaBean;
	}

	public BonoBean getBonoBean() {
		return bonoBean;
	}

	public void setBonoBean(BonoBean bonoBean) {
		this.bonoBean = bonoBean;
	}

	public UnidadLeccionBean getUnidadLeccionBean() {
		return unidadLeccionBean;
	}

	public void setUnidadLeccionBean(UnidadLeccionBean unidadLeccionBean) {
		this.unidadLeccionBean = unidadLeccionBean;
	}

	@Override
	public String toString() {
		return "AlumnoBonoBean [usuarioMatriculaBean=" + usuarioMatriculaBean
				+ ", bonoBean=" + bonoBean + ", unidadLeccionBean="
				+ unidadLeccionBean + "]";
	}
	
	 
 
	

}
