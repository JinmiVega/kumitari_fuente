package pe.gob.procalidad.natigu.core.bean.bean.academico;

import javax.persistence.Column;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;

public class MatriculaAlumnoBean extends BaseBean{


	

	private MatriculaBean matriculaBean;
	
				
	private AlumnoBean alumnoBean;
		
	private MaestraBean situacionMatriculaAlumno;
	
	private UsuarioMatriculaBean usuarioMatriculaBean;

	private float  		nota;
	private int      respuesta;
	
	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public MatriculaBean getMatriculaBean() {
		if(matriculaBean == null){
			matriculaBean = new MatriculaBean();
		}
		return matriculaBean;
	}

	public void setMatriculaBean(MatriculaBean matriculaBean) {
		this.matriculaBean = matriculaBean;
	}

	public AlumnoBean getAlumnoBean() {
		
		if(alumnoBean == null){
			alumnoBean = new AlumnoBean();
		}
		return alumnoBean;
	}

	public void setAlumnoBean(AlumnoBean alumnoBean) {
		this.alumnoBean = alumnoBean;
	}

	public MaestraBean getSituacionMatriculaAlumno() {
		if(situacionMatriculaAlumno == null){
			situacionMatriculaAlumno = new MaestraBean();
		}
		return situacionMatriculaAlumno;
	}

	public void setSituacionMatriculaAlumno(MaestraBean situacionMatriculaAlumno) {
		this.situacionMatriculaAlumno = situacionMatriculaAlumno;
	}
	

	public UsuarioMatriculaBean getUsuarioMatriculaBean() {
		return usuarioMatriculaBean;
	}

	public void setUsuarioMatriculaBean(UsuarioMatriculaBean usuarioMatriculaBean) {
		this.usuarioMatriculaBean = usuarioMatriculaBean;
	}

	@Override
	public String toString() {
		return "MatriculaAlumnoBean [matriculaBean=" + matriculaBean + ", alumnoBean=" + alumnoBean
				+ ", situacionMatriculaAlumno=" + situacionMatriculaAlumno + "]";
	}

	public int getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(int respuesta) {
		this.respuesta = respuesta;
	}

	
	
	
}
