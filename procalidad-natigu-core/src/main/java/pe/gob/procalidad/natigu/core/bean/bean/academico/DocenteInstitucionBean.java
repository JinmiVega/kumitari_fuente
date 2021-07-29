package pe.gob.procalidad.natigu.core.bean.bean.academico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
 

public class DocenteInstitucionBean extends BaseBean {
	

	private DocenteBean docenteBean;

	private InstitucionBean institucionBean;
	
	private MaestraBean 	situacion; 
	
	public DocenteInstitucionBean() {
		super();	
	}

 
	public DocenteBean getDocenteBean() {
		return docenteBean;
	}


	public void setDocenteBean(DocenteBean docenteBean) {
		this.docenteBean = docenteBean;
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
		return "DocumentoInstitucionBean [docente=" + docenteBean + ", institucion=" + institucionBean + ", situacion="
				+ situacion + "]";
	}

 
}
