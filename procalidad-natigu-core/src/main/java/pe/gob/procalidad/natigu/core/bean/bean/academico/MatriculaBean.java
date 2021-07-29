package pe.gob.procalidad.natigu.core.bean.bean.academico;



import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;


public class MatriculaBean extends BaseBean {
	
	private MaestraBean 	ciclo 			= new MaestraBean();
	
	private InstitucionBean insti 			= new InstitucionBean();

	private LenguaBean 		lengua			= new LenguaBean();

	private int 			flagMatricula;

	private MaestraBean 	periodo			= new MaestraBean();

	private MaestraBean 	situacion 		= new MaestraBean();

	private MaestraBean 	tipoMatricula 	= new MaestraBean();

	private MaestraBean 	nivel 			= new MaestraBean();

	private MaestraBean 	subNivel 		= new MaestraBean();

	private MaestraBean 	flagEstado 		= new MaestraBean();
	
	private String 			vObservaci;
	
	private InscripcionBean inscripcion 	= new InscripcionBean();
	
	/************************/

	private DocenteBean 	docenteBean		= new DocenteBean();
	
	private AlumnoBean 		alumnoBean		= new AlumnoBean();
	
	private int 			numeroAlumnosMatri;
	
	private InscripcionLenguaBean inscripcionLenguaBean = new InscripcionLenguaBean();
	
	private String 			vNumcuposrest;
	
	public MatriculaBean() {
		super();
	}

	public int getFlagMatricula() {
		return flagMatricula;
	}


	public void setFlagMatricula(int flagMatricula) {
		this.flagMatricula = flagMatricula;
	}

	public MaestraBean getSituacion() {
		
		return situacion;
	}



	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}



	public MaestraBean getTipoMatricula() {
		
		return tipoMatricula;
	}



	public void setTipoMatricula(MaestraBean tipoMatricula) {
		this.tipoMatricula = tipoMatricula;
	}



	public MaestraBean getNivel() {
		
		return nivel;
	}



	public void setNivel(MaestraBean nivel) {
		this.nivel = nivel;
	}



	public MaestraBean getSubNivel() {
		
		return subNivel;
	}



	public void setSubNivel(MaestraBean subNivel) {
		this.subNivel = subNivel;
	}

	public String getvObservaci() {
		return vObservaci;
	}



	public void setvObservaci(String vObservaci) {
		this.vObservaci = vObservaci;
	}

	public MaestraBean getCiclo() {
		return ciclo;
	}

	public InstitucionBean getInsti() {
		return insti;
	}

	public void setInsti(InstitucionBean insti) {
		this.insti = insti;
	}

	public LenguaBean getLengua() {
		return lengua;
	}

	public void setLengua(LenguaBean lengua) {
		this.lengua = lengua;
	}

	public void setCiclo(MaestraBean ciclo) {
		this.ciclo = ciclo;
	}

	public MaestraBean getPeriodo() {
		return periodo;
	}

	public void setPeriodo(MaestraBean periodo) {
		this.periodo = periodo;
	}

	public MaestraBean getFlagEstado() {
		return flagEstado;
	}

	public void setFlagEstado(MaestraBean flagEstado) {
		this.flagEstado = flagEstado;
	}

	public InscripcionBean getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(InscripcionBean inscripcion) {
		this.inscripcion = inscripcion;
	}

	@Override
	public String toString() {
		return "MatriculaBean [ciclo=" + ciclo + ", insti=" + insti + ", lengua=" + lengua + ", flagMatricula="
				+ flagMatricula + ", periodo=" + periodo + ", situacion=" + situacion + ", tipoMatricula="
				+ tipoMatricula + ", nivel=" + nivel + ", subNivel=" + subNivel + ", flagEstado=" + flagEstado
				+ ", vObservaci=" + vObservaci + ", inscripcion=" + inscripcion + "]";
	}

	public DocenteBean getDocenteBean() {
		return docenteBean;
	}

	public void setDocenteBean(DocenteBean docenteBean) {
		this.docenteBean = docenteBean;
	}

	public AlumnoBean getAlumnoBean() {
		return alumnoBean;
	}

	public void setAlumnoBean(AlumnoBean alumnoBean) {
		this.alumnoBean = alumnoBean;
	}

	public int getNumeroAlumnosMatri() {
		return numeroAlumnosMatri;
	}

	public void setNumeroAlumnosMatri(int numeroAlumnosMatri) {
		this.numeroAlumnosMatri = numeroAlumnosMatri;
	}

	public InscripcionLenguaBean getInscripcionLenguaBean() {
		return inscripcionLenguaBean;
	}

	public void setInscripcionLenguaBean(InscripcionLenguaBean inscripcionLenguaBean) {
		this.inscripcionLenguaBean = inscripcionLenguaBean;
	}

	public String getvNumcuposrest() {
		return vNumcuposrest;
	}

	public void setvNumcuposrest(String vNumcuposrest) {
		this.vNumcuposrest = vNumcuposrest;
	}
	
	





	

	
	

}
