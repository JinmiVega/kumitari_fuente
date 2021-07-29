package pe.gob.procalidad.natigu.core.bean.bean.academico;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;

public class InscripcionDocenteBean extends BaseBean {
	
	
	
	private InscripcionLenguaBean inscripcionLenguaBean = new InscripcionLenguaBean();

	private DocenteBean docenteBean  = new DocenteBean();

	private MaestraBean situacionInscripcionDocente = new MaestraBean();
				
	private Date fechaBaja;

	public InscripcionLenguaBean getInscripcionLenguaBean() {
		return inscripcionLenguaBean;
	}

	public void setInscripcionLenguaBean(InscripcionLenguaBean inscripcionLenguaBean) {
		this.inscripcionLenguaBean = inscripcionLenguaBean;
	}

	public DocenteBean getDocenteBean() {
		return docenteBean;
	}

	public void setDocenteBean(DocenteBean docenteBean) {
		this.docenteBean = docenteBean;
	}

	public MaestraBean getSituacionInscripcionDocente() {
		return situacionInscripcionDocente;
	}

	public void setSituacionInscripcionDocente(
			MaestraBean situacionInscripcionDocente) {
		this.situacionInscripcionDocente = situacionInscripcionDocente;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}




}
