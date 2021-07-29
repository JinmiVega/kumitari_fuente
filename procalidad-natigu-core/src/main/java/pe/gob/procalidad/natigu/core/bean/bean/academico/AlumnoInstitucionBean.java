package pe.gob.procalidad.natigu.core.bean.bean.academico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;

public class AlumnoInstitucionBean extends BaseBean{
	
	private AlumnoBean alumnoBean 			= new AlumnoBean();
	private InstitucionBean institucionBean = new InstitucionBean();
	private MaestraBean situacion			= new MaestraBean(); 
	
	public AlumnoInstitucionBean(){
		super();
	}

	public AlumnoBean getAlumnoBean() {
		return alumnoBean;
	}

	public void setAlumnoBean(AlumnoBean alumnoBean) {
		this.alumnoBean = alumnoBean;
	}

	public InstitucionBean getInstitucionBean() {
		return institucionBean;
	}

	public void setInstitucionBean(InstitucionBean institucionBean) {
		this.institucionBean = institucionBean;
	}

	public MaestraBean getSituacion() {
		return situacion;
	}

	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}

	
	@Override
	public String toString() {
		return "AlumnoInstitucionBean [alumnoBean=" + alumnoBean + ", institucionBean=" + institucionBean
				+ ", situacion=" + situacion + "]";
	}
	
	

	
	
	
}
