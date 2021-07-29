package pe.gob.procalidad.natigu.core.bean.bean.academico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;

public class SeguimientoAlumnoLenguaBean extends BaseBean{

	private UsuarioMatriculaBean usuarioMatriculaBean;
	
	private UnidadLeccionBean unidadLeccionBean;
	
	private MaterialTipoEjercicioBean materialTipoEjercicioBean;
	
	private MaestraBean situacion;
	
	private Integer leccionActual;

	public UsuarioMatriculaBean getUsuarioMatriculaBean() {
		return usuarioMatriculaBean;
	}

	public void setUsuarioMatriculaBean(UsuarioMatriculaBean usuarioMatriculaBean) {
		this.usuarioMatriculaBean = usuarioMatriculaBean;
	}

	public UnidadLeccionBean getUnidadLeccionBean() {
		return unidadLeccionBean;
	}

	public void setUnidadLeccionBean(UnidadLeccionBean unidadLeccionBean) {
		this.unidadLeccionBean = unidadLeccionBean;
	}

	public MaestraBean getSituacion() {
		return situacion;
	}

	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}

	public MaterialTipoEjercicioBean getMaterialTipoEjercicioBean() {
		return materialTipoEjercicioBean;
	}

	public void setMaterialTipoEjercicioBean(MaterialTipoEjercicioBean materialTipoEjercicioBean) {
		this.materialTipoEjercicioBean = materialTipoEjercicioBean;
	}

	@Override
	public String toString() {
		return "SeguimientoAlumnoLenguaBean [usuarioMatriculaBean=" + usuarioMatriculaBean + ", unidadLeccionBean="
				+ unidadLeccionBean + ", situacion=" + situacion + "]";
	}

	public Integer getLeccionActual() {
		return leccionActual;
	}

	public void setLeccionActual(Integer leccionActual) {
		this.leccionActual = leccionActual;
	}

	
}
