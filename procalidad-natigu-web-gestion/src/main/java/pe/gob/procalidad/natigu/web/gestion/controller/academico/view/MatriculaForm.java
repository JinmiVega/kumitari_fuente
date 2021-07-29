package pe.gob.procalidad.natigu.web.gestion.controller.academico.view;


import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaDocenteBean;

public class MatriculaForm {

	private MatriculaBean matriculaBean = new MatriculaBean();
	
	private MatriculaAlumnoBean matriculaAlumnoBean = new MatriculaAlumnoBean();
	
	private MatriculaDocenteBean matriculaDocenteBean = new MatriculaDocenteBean();
	
	public MatriculaForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public MatriculaBean getMatriculaBean() {
		return matriculaBean;
	}

	public void setMatriculaBean(MatriculaBean matriculaBean) {
		this.matriculaBean = matriculaBean;
	}

	public MatriculaAlumnoBean getMatriculaAlumnoBean() {
		return matriculaAlumnoBean;
	}

	public void setMatriculaAlumnoBean(MatriculaAlumnoBean matriculaAlumnoBean) {
		this.matriculaAlumnoBean = matriculaAlumnoBean;
	}

	public MatriculaDocenteBean getMatriculaDocenteBean() {
		return matriculaDocenteBean;
	}

	public void setMatriculaDocenteBean(MatriculaDocenteBean matriculaDocenteBean) {
		this.matriculaDocenteBean = matriculaDocenteBean;
	}

	@Override
	public String toString() {
		return "MatriculaForm [matriculaBean=" + matriculaBean + ", matriculaAlumnoBean=" + matriculaAlumnoBean
				+ ", matriculaDocenteBean=" + matriculaDocenteBean + "]";
	}


	
	
}
