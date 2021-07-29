package pe.gob.procalidad.natigu.core.bean.bean.academico;

import java.util.Date;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;


public class EvaluacionBean extends BaseBean{
	
	private UsuarioMatriculaBean usuarioMatriculaBean = new UsuarioMatriculaBean();
	private Date 		fechaHoraInicio = new Date();
	private Date 		fechaHoraTermino = new Date();
	private Date 		fechaHoraEvaluacion = new Date();
	private UnidadLeccionBean  UnidadLeccionBean;
	private MaestraBean situacionEvaluacion = new MaestraBean();
	private int 		totalEjercicio;
	private int 		correctos;
	private int 		erradas;
	private float  		nota;
	private PremioBean  medalla = new PremioBean();
	private InstitucionBean institucionBean ;
	 
	/*R*/
	private String		nomNivel;
	private String		nomSubnivel; 
	private String		nomAlumno; 
	
	
	private String		vfechaactual;
	private String		vfechaeve;
	private String		vfechaini;
	private String		vfechafin;
    private MaestraBean subNivel = new MaestraBean();
    private MaestraBean nivel = new MaestraBean();
    private int         respuesta;
    private MaestraBean tipoEvaluacion = new MaestraBean();  
	
    private String codigoEncrypt;
	
	public EvaluacionBean() {
		super();
	}

	public UsuarioMatriculaBean getUsuarioMatriculaBean() {
		return usuarioMatriculaBean;
	}

	public void setUsuarioMatriculaBean(UsuarioMatriculaBean usuarioMatriculaBean) {
		this.usuarioMatriculaBean = usuarioMatriculaBean;
	}

	public Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public Date getFechaHoraTermino() {
		return fechaHoraTermino;
	}

	public void setFechaHoraTermino(Date fechaHoraTermino) {
		this.fechaHoraTermino = fechaHoraTermino;
	}

	public MaestraBean getSituacionEvaluacion() {
		return situacionEvaluacion;
	}

	public void setSituacionEvaluacion(MaestraBean situacionEvaluacion) {
		this.situacionEvaluacion = situacionEvaluacion;
	}

	public int getTotalEjercicio() {
		return totalEjercicio;
	}

	public void setTotalEjercicio(int totalEjercicio) {
		this.totalEjercicio = totalEjercicio;
	}

	public int getCorrectos() {
		return correctos;
	}

	public void setCorrectos(int correctos) {
		this.correctos = correctos;
	}

	public int getErradas() {
		return erradas;
	}

	public void setErradas(int erradas) {
		this.erradas = erradas;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public PremioBean getMedalla() {
		return medalla;
	}

	public void setMedalla(PremioBean medalla) {
		this.medalla = medalla;
	}

	public String getVfechaactual() {
		return vfechaactual;
	}

	public void setVfechaactual(String vfechaactual) {
		this.vfechaactual = vfechaactual;
	}

	public String getVfechaini() {
		return vfechaini;
	}

	public void setVfechaini(String vfechaini) {
		this.vfechaini = vfechaini;
	}

	public String getVfechafin() {
		return vfechafin;
	}

	public void setVfechafin(String vfechafin) {
		this.vfechafin = vfechafin;
	}
	public UnidadLeccionBean getUnidadLeccionBean() {
		return UnidadLeccionBean;
	}

	public void setUnidadLeccionBean(UnidadLeccionBean unidadLeccionBean) {
		UnidadLeccionBean = unidadLeccionBean;
	}

	public MaestraBean getSubNivel() {
		return subNivel;
	}

	public void setSubNivel(MaestraBean subNivel) {
		this.subNivel = subNivel;
	}


	public MaestraBean getNivel() {
		return nivel;
	}

	public void setNivel(MaestraBean nivel) {
		this.nivel = nivel;
	}

	public int getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(int respuesta) {
		this.respuesta = respuesta;
	}

	 
	public MaestraBean getTipoEvaluacion() {
		return tipoEvaluacion;
	}

	public void setTipoEvaluacion(MaestraBean tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}

	public InstitucionBean getInstitucionBean() {
		return institucionBean;
	}

	public void setInstitucionBean(InstitucionBean institucionBean) {
		this.institucionBean = institucionBean;
	}

	 

	public String getNomNivel() {
		return nomNivel;
	}

	public void setNomNivel(String nomNivel) {
		this.nomNivel = nomNivel;
	}

	public String getNomSubnivel() {
		return nomSubnivel;
	}

	public void setNomSubnivel(String nomSubnivel) {
		this.nomSubnivel = nomSubnivel;
	}

	public String getNomAlumno() {
		return nomAlumno;
	}

	public void setNomAlumno(String nomAlumno) {
		this.nomAlumno = nomAlumno;
	}

	public String getCodigoEncrypt() {
		return codigoEncrypt;
	}

	public void setCodigoEncrypt(String codigoEncrypt) {
		this.codigoEncrypt = codigoEncrypt;
	}

	public Date getFechaHoraEvaluacion() {
		return fechaHoraEvaluacion;
	}

	public void setFechaHoraEvaluacion(Date fechaHoraEvaluacion) {
		this.fechaHoraEvaluacion = fechaHoraEvaluacion;
	}

	public String getVfechaeve() {
		return vfechaeve;
	}

	public void setVfechaeve(String vfechaeve) {
		this.vfechaeve = vfechaeve;
	}

	@Override
	public String toString() {
		return "EvaluacionBean [usuarioMatriculaBean=" + usuarioMatriculaBean
				+ ", fechaHoraInicio=" + fechaHoraInicio
				+ ", fechaHoraTermino=" + fechaHoraTermino
				+ ", UnidadLeccionBean=" + UnidadLeccionBean
				+ ", situacionEvaluacion=" + situacionEvaluacion
				+ ", totalEjercicio=" + totalEjercicio + ", correctos="
				+ correctos + ", erradas=" + erradas + ", nota=" + nota
				+ ", medalla=" + medalla + ", institucionBean="
				+ institucionBean +  
				  ", nomNivel=" + nomNivel + ", nomSubnivel=" + nomSubnivel
				+ ", nomAlumno=" + nomAlumno + ", vfechaactual=" + vfechaactual
				+ ", vfechaini=" + vfechaini + ", vfechafin=" + vfechafin
				+ ", subNivel=" + subNivel + ", nivel=" + nivel
				+ ", respuesta=" + respuesta + ", tipoEvaluacion="
				+ tipoEvaluacion + "]";
	}




	
}
