package pe.gob.procalidad.natigu.core.bean.bean.academico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;

public class AlumnoMedallaBean extends BaseBean{
	
	//Atributos
	
	private UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
	private PremioBean premioBean = new PremioBean();
	private UnidadLeccionBean unidadLeccionBean;
	private Integer 		  codcateg;
 
	//Constructor
	
	public AlumnoMedallaBean() {
		super();
	}
	//Getters and Setters
	
	public UsuarioMatriculaBean getUsuarioMatriculaBean() {
		return usuarioMatriculaBean;
	}
	public void setUsuarioMatriculaBean(UsuarioMatriculaBean usuarioMatriculaBean) {
		this.usuarioMatriculaBean = usuarioMatriculaBean;
	}
	public PremioBean getPremioBean() {
		return premioBean;
	}
	public void setPremioBean(PremioBean premioBean) {
		this.premioBean = premioBean;
	}

	public Integer getCodcateg() {
		return codcateg;
	}

	public void setCodcateg(Integer codcateg) {
		this.codcateg = codcateg;
	}

	public UnidadLeccionBean getUnidadLeccionBean() {
		return unidadLeccionBean;
	}

	public void setUnidadLeccionBean(UnidadLeccionBean unidadLeccionBean) {
		this.unidadLeccionBean = unidadLeccionBean;
	}

 
 
	

}
