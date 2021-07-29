package pe.gob.procalidad.natigu.core.bean.bean.academico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
 

public class InscripcionLenguaBean extends BaseBean {
	

	private InstitucionBean institucion;

	private LenguaBean 		lenguainscr;

	private MaestraBean 	situacion;

	private String 			numeroCuposInsc;
	
	private InscripcionBean inscripcionBean;
	
	private String 			numeroCuposDisp;
	
	private MaestraBean 	nivel;
	
	private MaestraBean		ciclo;
	
	private MaestraBean		periodo;
	
	private Long			codusumat;		
	
	private Long 			n_tm2cond;
	
	private	float			n_nota;
	
	
	
	
	public InscripcionLenguaBean() {
		
		super();
		this.setNumeroCuposInsc("0");
	}



	public InstitucionBean getInstitucion() {
		if (institucion==null) {
			institucion = new InstitucionBean();
		}
		
		return institucion;
	}



	public void setInstitucion(InstitucionBean institucion) {
		this.institucion = institucion;
	}



	


	public MaestraBean getSituacion() {
		if (situacion==null) {
			situacion= new MaestraBean();
		}
		return situacion;
	}



	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}



	public String getNumeroCuposInsc() {
		return numeroCuposInsc;
	}



	public void setNumeroCuposInsc(String numeroCuposInsc) {
		this.numeroCuposInsc = numeroCuposInsc;
	}



	public InscripcionBean getInscripcionBean() {
		if (inscripcionBean==null) {
			inscripcionBean=  new InscripcionBean();
		}
		return inscripcionBean;
	}



	public void setInscripcionBean(InscripcionBean inscripcionBean) {
		this.inscripcionBean = inscripcionBean;
	}



	public LenguaBean getLenguainscr() {
		if (lenguainscr==null) {
			lenguainscr=  new LenguaBean();
		}
		return lenguainscr;
	}



	public void setLenguainscr(LenguaBean lenguainscr) {
		this.lenguainscr = lenguainscr;
	}



	public String getNumeroCuposDisp() {
		return numeroCuposDisp;
	}



	public void setNumeroCuposDisp(String numeroCuposDisp) {
		this.numeroCuposDisp = numeroCuposDisp;
	}



	public MaestraBean getNivel() {
		if (nivel==null) {
			nivel= new MaestraBean();
		}
		return nivel;
	}



	public void setNivel(MaestraBean nivel) {
		this.nivel = nivel;
	}



	public MaestraBean getCiclo() {
		if (ciclo==null) {
			ciclo= new MaestraBean();
		}
		return ciclo;
	}



	public void setCiclo(MaestraBean ciclo) {
		this.ciclo = ciclo;
	}



	public MaestraBean getPeriodo() {
		if (periodo==null) {
			periodo= new MaestraBean();
		}
		return periodo;
	}



	public void setPeriodo(MaestraBean periodo) {
		this.periodo = periodo;
	}



	@Override
	public String toString() {
		return "InscripcionLenguaBean [institucion=" + institucion + ", lenguainscr=" + lenguainscr + ", situacion="
				+ situacion + ", numeroCuposInsc=" + numeroCuposInsc + ", inscripcionBean=" + inscripcionBean
				+ ", numeroCuposDisp=" + numeroCuposDisp + ", nivel=" + nivel + ", ciclo=" + ciclo + ", periodo="
				+ periodo + "]";
	}



	public Long getCodusumat() {
		return codusumat;
	}



	public void setCodusumat(Long codusumat) {
		this.codusumat = codusumat;
	}



	public Long getN_tm2cond() {
		return n_tm2cond;
	}



	public void setN_tm2cond(Long n_tm2cond) {
		this.n_tm2cond = n_tm2cond;
	}



	public float getN_nota() {
		return n_nota;
	}



	public void setN_nota(float n_nota) {
		this.n_nota = n_nota;
	}


	


}
