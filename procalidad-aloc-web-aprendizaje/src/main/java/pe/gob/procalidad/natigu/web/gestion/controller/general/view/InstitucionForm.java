package pe.gob.procalidad.natigu.web.gestion.controller.general.view;

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionDirectorBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionOperadorBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionSedeBean;

public class InstitucionForm {

	private InstitucionBean institucionBean = new InstitucionBean();
	
	private InstitucionDirectorBean institucionDirectorBean = new InstitucionDirectorBean();
	
	private InstitucionOperadorBean institucionOperadorBean = new InstitucionOperadorBean();
	
	private InstitucionSedeBean institucionSedeBean = new InstitucionSedeBean();

	private InstitucionLenguaBean institucionLenguaBean = new InstitucionLenguaBean();
	
	public InstitucionForm(){
		
	}
	
	public InstitucionBean getInstitucionBean() {
		return institucionBean;
	}

	public void setInstitucionBean(InstitucionBean institucionBean) {
		this.institucionBean = institucionBean;
	}

	public InstitucionDirectorBean getInstitucionDirectorBean() {
		return institucionDirectorBean;
	}

	public void setInstitucionDirectorBean(InstitucionDirectorBean institucionDirectorBean) {
		this.institucionDirectorBean = institucionDirectorBean;
	}
	
	public InstitucionOperadorBean getInstitucionOperadorBean() {
		return institucionOperadorBean;
	}

	public void setInstitucionOperadorBean(InstitucionOperadorBean institucionOperadorBean) {
		this.institucionOperadorBean = institucionOperadorBean;
	}

	public InstitucionLenguaBean getInstitucionLenguaBean() {
		return institucionLenguaBean;
	}

	public void setInstitucionLenguaBean(InstitucionLenguaBean institucionLenguaBean) {
		this.institucionLenguaBean = institucionLenguaBean;
	}

	public InstitucionSedeBean getInstitucionSedeBean() {
		return institucionSedeBean;
	}

	public void setInstitucionSedeBean(InstitucionSedeBean institucionSedeBean) {
		this.institucionSedeBean = institucionSedeBean;
	}

	@Override
	public String toString() {
		return "InstitucionForm [institucionBean=" + institucionBean + ", institucionDirectorBean="
				+ institucionDirectorBean + ", institucionOperadorBean=" + institucionOperadorBean
				+ ", institucionSedeBean=" + institucionSedeBean + ", institucionLenguaBean=" + institucionLenguaBean
				+ "]";
	}
	
	
}
