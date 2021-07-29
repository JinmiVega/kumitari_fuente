package pe.gob.procalidad.natigu.core.bean.bean.academico;

import javax.persistence.Column;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;

public class MatriculaDocenteBean extends BaseBean{


	

	private MatriculaBean 	matriculaBean 	= new MatriculaBean();
				
	private DocenteBean 	docenteBean 	= new DocenteBean();
		
	private MaestraBean 	situacionMatriculaDocente = new MaestraBean();

	private MaestraBean		tipoDocente = new MaestraBean();

	public MatriculaBean getMatriculaBean() {
		return matriculaBean;
	}

	public void setMatriculaBean(MatriculaBean matriculaBean) {
		this.matriculaBean = matriculaBean;
	}

	public DocenteBean getDocenteBean() {
		return docenteBean;
	}

	public void setDocenteBean(DocenteBean docenteBean) {
		this.docenteBean = docenteBean;
	}

	public MaestraBean getSituacionMatriculaDocente() {
		return situacionMatriculaDocente;
	}

	public void setSituacionMatriculaDocente(MaestraBean situacionMatriculaDocente) {
		this.situacionMatriculaDocente = situacionMatriculaDocente;
	}

	public MaestraBean getTipoDocente() {
		return tipoDocente;
	}

	public void setTipoDocente(MaestraBean tipoDocente) {
		this.tipoDocente = tipoDocente;
	}

	@Override
	public String toString() {
		return "MatriculaDocenteBean [matriculaBean=" + matriculaBean + ", docenteBean=" + docenteBean
				+ ", situacionMatriculaDocente=" + situacionMatriculaDocente + ", tipoDocente=" + tipoDocente + "]";
	}

	
	
	
}
