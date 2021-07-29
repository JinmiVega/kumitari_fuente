package pe.gob.procalidad.natigu.core.bean.bean.academico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
public class SeguimientoAlumIntentoBean extends BaseBean{
 
	private  int   numeroIntento; 
	private  Integer   cantidadIntentos; 
	private MaterialTipoEjercicioBean materialTipoEjercicioBean;
	private PreguntaBean preguntaBean;
	private UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
	private  String   Nivel; 
	private  String   nombreAlumno; 
	private  InstitucionBean institucionBean; 
	private  LenguaBean lenguaBean; 
 
	public SeguimientoAlumIntentoBean() {
		super();
	}


 

	public int getNumeroIntento() {
		return numeroIntento;
	}




	public Integer getCantidadIntentos() {
		return cantidadIntentos;
	}




	public void setCantidadIntentos(Integer cantidadIntentos) {
		this.cantidadIntentos = cantidadIntentos;
	}




	public void setNumeroIntento(int numeroIntento) {
		this.numeroIntento = numeroIntento;
	}




	public String getNivel() {
		return Nivel;
	}




	public void setNivel(String nivel) {
		Nivel = nivel;
	}




	public MaterialTipoEjercicioBean getMaterialTipoEjercicioBean() {
		return materialTipoEjercicioBean;
	}


	public void setMaterialTipoEjercicioBean(
			MaterialTipoEjercicioBean materialTipoEjercicioBean) {
		this.materialTipoEjercicioBean = materialTipoEjercicioBean;
	}


	public UsuarioMatriculaBean getUsuarioMatriculaBean() {
		return usuarioMatriculaBean;
	}


	public void setUsuarioMatriculaBean(UsuarioMatriculaBean usuarioMatriculaBean) {
		this.usuarioMatriculaBean = usuarioMatriculaBean;
	}
 
	public PreguntaBean getPreguntaBean() {
		return preguntaBean;
	}




	public void setPreguntaBean(PreguntaBean preguntaBean) {
		this.preguntaBean = preguntaBean;
	}




	@Override
	public String toString() {
		return "SeguimientoAlumIntentoBean [numeroIntento=" + numeroIntento
				+ ", cantidadIntentos=" + cantidadIntentos
				+ ", materialTipoEjercicioBean=" + materialTipoEjercicioBean
				+ ", preguntaBean=" + preguntaBean + ", usuarioMatriculaBean="
				+ usuarioMatriculaBean + ", Nivel=" + Nivel + "]";
	}




	public String getNombreAlumno() {
		return nombreAlumno;
	}




	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}




	public InstitucionBean getInstitucionBean() {
		return institucionBean;
	}




	public void setInstitucionBean(InstitucionBean institucionBean) {
		this.institucionBean = institucionBean;
	}




	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}




	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}




	 
 
 
	
}
