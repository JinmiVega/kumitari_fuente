package pe.gob.procalidad.natigu.web.gestion.controller.seguridad.view;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaAccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaBean;

public class AuditoriaForm {
	
	private AuditoriaBean auditoriaBean = new AuditoriaBean();
	private AuditoriaAccesoBean auditoriaAccesoBean = new AuditoriaAccesoBean();

	public AuditoriaBean getAuditoriaBean() {
		return auditoriaBean;
	}

	public void setAuditoriaBean(AuditoriaBean auditoriaBean) {
		this.auditoriaBean = auditoriaBean;
	}

	public AuditoriaAccesoBean getAuditoriaAccesoBean() {
		return auditoriaAccesoBean;
	}

	public void setAuditoriaAccesoBean(AuditoriaAccesoBean auditoriaAccesoBean) {
		this.auditoriaAccesoBean = auditoriaAccesoBean;
	}

}
