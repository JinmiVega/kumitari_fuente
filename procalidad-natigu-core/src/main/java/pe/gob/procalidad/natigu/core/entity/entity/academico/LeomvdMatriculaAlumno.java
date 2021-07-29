package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@NamedStoredProcedureQueries({
	
	@NamedStoredProcedureQuery(name = "leomvd_matalumno.listar_alumnos", 
	procedureName = "acad.fun_leomvdmatalumno_listar_alumnos_x_filtro", 
	resultClasses = LeomvdMatriculaAlumno.class, 
	parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codalumno", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomalumn", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numdocum", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitalu", type = Integer.class)
			
	}),
	@NamedStoredProcedureQuery(name = "leomvd_matalumno.buscarMatriculaXAlumno", 
	procedureName = "acad.fun_leomvdmatalumno_listar_alumnos_x_matricula", 
	resultClasses = LeomvdMatriculaAlumno.class, 
	parameters = { 
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatri", type = Long.class) 
	}),
	
	@NamedStoredProcedureQuery(name = "leomvd_matalumno.validarMatriculaAlumnoXInscrLen", 
	procedureName = "acad.fun_leomvdmatalumno_validamatriculadosxinscrlengua", 
	resultClasses = LeomvdMatriculaAlumno.class, 
	parameters = { 
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_inscrlen", type = Long.class) 
	}),
	
	@NamedStoredProcedureQuery(name = "leomvd_matalumno.insertar", 
	procedureName = "acad.fun_leomvdmatalumno_insertar",
	resultClasses = LeomvdMatriculaAlumno.class, 
	parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codmatalu", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatri", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codalumno", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinst", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinscrlen", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
			}),
	 @NamedStoredProcedureQuery(name = "leomvd_matalumno.eliminar", 
	 procedureName = "acad.fun_leomvdmatalumno_eliminar",
	 resultClasses = LeomvdMatriculaAlumno.class, 
 	 parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatalu", type = long.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
 		}),
	@NamedStoredProcedureQuery(name = "leomvc_matricula.listarSeguimientoAlumno", 
	procedureName = "acad.fun_leomvcmatricula_seguimiento_alumno", 
		resultClasses = LeomvdMatriculaAlumno.class,
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_periodo", type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmat", type = int.class)
		
		}),
	@NamedStoredProcedureQuery(name = "leomvc_matricula.calcularPromedioNotaEva", 
	procedureName = "acad.fun_leomvdmatalumno_promedio_evaluacion", 
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_respuesta", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		
		})
	

})

@Entity
@Table(name="acad.leomvd_matalumno")
public class LeomvdMatriculaAlumno implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "n_codmatalu")
	private long nCodMatAlu;
	
	@Column(name = "n_codmatri")
	private long nCodMatri;
				
	@Column(name = "n_codalumno")
	private long nCodAlumno;
		
	@Column(name = "n_tm1sitmal")
	private int nTm1SitMal;

	@Column(name = "v_flgest")
	private String vFlgEst;
	
	@Column(name = "n_codusureg")
	private long nCodUsuReg;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecReg;
	
	@Column(name = "v_hostreg")
	private String vHostReg;
	
	
	@Column(name = "n_codusumod")
	private long nCodUsuMod;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dFecMod;
	
	@Column(name = "v_hostmod")
	private String vHostMod;
	
	@Column(name = "n_codperso")
	private long nCodPerso;
	
	@Column(name = "n_codinsti")
	private long nCodInsti;
	
	@Column(name = "n_codubinst")
	private long nCodUbInst;
	
	
	@Column(name = "n_tm2grado")
	private int nTm2Grado;	
	
	@Column(name = "n_tm1sitalu")
	private int nTm1SitAlu;
	
	@Column(name = "n_codlengua")
	private int nCodLengua;
	

	@Column(name = "n_tm2nivel")
	private int nTm2Nivel;
	
	@Column(name = "n_tm2subniv")
	private int nTm2Subniv;
	
	@Column(name = "n_periodo")
	private int nPeriodo;
	
	@Column(name = "n_tm2ciclo")
	private int nTm2Ciclo;
	
	@Column(name = "n_tm1sitmat")
	private int nTm1SitMat;
	
	@Column(name = "n_tm1tipmat")
	private int nTm1TipmaT;
	
	@Column(name = "v_observaci")
	private String vObservaci;
	
	@Column(name = "v_nomlengua")
	private String vNomLengua;
	
	@Column(name = "v_nombreper")
	private String vNombreper;
	
	@Column(name = "v_apepatper")
	private String vApepatper;
	
	@Column(name = "v_apematper")
	private String vApematper;
	
	@Column(name = "v_numdocum")
	private String vNumdocum;

	@Column(name = "v_nombrenivel")
	private String vNombreNivel;

	@Column(name="n_nota")
	private float nNota;
	
	@Column(name = "v_nominsti")
	private String vNominsti;
	
	@Column(name = "v_nomdocente")
	private String vNomdocente;
	 
	@Column(name = "v_nomalumno")
	private String vNomalumno;
	
	@Column(name = "v_nomtm2nivel")
	private String vNomtm2nivel;
	
	@Column(name = "v_tm2subniv")
	private String vTm2subniv;
	
	 
	@Column(name = "v_tm2ciclo")
	private String vTm2ciclo;
	
	@Column(name = "v_tm1sitmat")
	private String vTm1sitmat;
	
	@Column(name = "v_nomusuari")
	private String vNomusuari;
	
	@Column(name = "n_coddocen")
	private long nCoddocen;
	
	 
	 

	 
	public String getvNomusuari() {
		return vNomusuari;
	}

	public void setvNomusuari(String vNomusuari) {
		this.vNomusuari = vNomusuari;
	}

	public long getnCoddocen() {
		return nCoddocen;
	}

	public void setnCoddocen(long nCoddocen) {
		this.nCoddocen = nCoddocen;
	}

	public String getvTm1sitmat() {
		return vTm1sitmat;
	}

	public void setvTm1sitmat(String vTm1sitmat) {
		this.vTm1sitmat = vTm1sitmat;
	}

	public String getvTm2ciclo() {
		return vTm2ciclo;
	}

	public void setvTm2ciclo(String vTm2ciclo) {
		this.vTm2ciclo = vTm2ciclo;
	}

	public String getvTm2subniv() {
		return vTm2subniv;
	}

	public void setvTm2subniv(String vTm2subniv) {
		this.vTm2subniv = vTm2subniv;
	}

	public String getvNomtm2nivel() {
		return vNomtm2nivel;
	}

	public void setvNomtm2nivel(String vNomtm2nivel) {
		this.vNomtm2nivel = vNomtm2nivel;
	}

	public String getvNomalumno() {
		return vNomalumno;
	}

	public void setvNomalumno(String vNomalumno) {
		this.vNomalumno = vNomalumno;
	}

	public String getvNomdocente() {
		return vNomdocente;
	}

	public void setvNomdocente(String vNomdocente) {
		this.vNomdocente = vNomdocente;
	}

	public String getvNominsti() {
		return vNominsti;
	}

	public void setvNominsti(String vNominsti) {
		this.vNominsti = vNominsti;
	}

	public float getnNota() {
		return nNota;
	}

	public void setnNota(float nNota) {
		this.nNota = nNota;
	}

	public long getnCodMatAlu() {
		return nCodMatAlu;
	}

	public void setnCodMatAlu(long nCodMatAlu) {
		this.nCodMatAlu = nCodMatAlu;
	}

	public long getnCodMatri() {
		return nCodMatri;
	}

	public void setnCodMatri(long nCodMatri) {
		this.nCodMatri = nCodMatri;
	}

	public long getnCodAlumno() {
		return nCodAlumno;
	}

	public void setnCodAlumno(long nCodAlumno) {
		this.nCodAlumno = nCodAlumno;
	}

	public int getnTm1SitMal() {
		return nTm1SitMal;
	}

	public void setnTm1SitMal(int nTm1SitMal) {
		this.nTm1SitMal = nTm1SitMal;
	}

	public String getvFlgEst() {
		return vFlgEst;
	}

	public void setvFlgEst(String vFlgEst) {
		this.vFlgEst = vFlgEst;
	}

	public long getnCodUsuReg() {
		return nCodUsuReg;
	}

	public void setnCodUsuReg(long nCodUsuReg) {
		this.nCodUsuReg = nCodUsuReg;
	}

	public Date getdFecReg() {
		return dFecReg;
	}

	public void setdFecReg(Date dFecReg) {
		this.dFecReg = dFecReg;
	}

	public String getvHostReg() {
		return vHostReg;
	}

	public void setvHostReg(String vHostReg) {
		this.vHostReg = vHostReg;
	}

	public long getnCodUsuMod() {
		return nCodUsuMod;
	}

	public void setnCodUsuMod(long nCodUsuMod) {
		this.nCodUsuMod = nCodUsuMod;
	}

	public Date getdFecMod() {
		return dFecMod;
	}

	public void setdFecMod(Date dFecMod) {
		this.dFecMod = dFecMod;
	}

	public String getvHostMod() {
		return vHostMod;
	}

	public void setvHostMod(String vHostMod) {
		this.vHostMod = vHostMod;
	}

	public long getnCodPerso() {
		return nCodPerso;
	}

	public void setnCodPerso(long nCodPerso) {
		this.nCodPerso = nCodPerso;
	}

	public long getnCodInsti() {
		return nCodInsti;
	}

	public void setnCodInsti(long nCodInsti) {
		this.nCodInsti = nCodInsti;
	}

	public long getnCodUbInst() {
		return nCodUbInst;
	}

	public void setnCodUbInst(long nCodUbInst) {
		this.nCodUbInst = nCodUbInst;
	}

	public int getnTm2Grado() {
		return nTm2Grado;
	}

	public void setnTm2Grado(int nTm2Grado) {
		this.nTm2Grado = nTm2Grado;
	}

	public int getnTm1SitAlu() {
		return nTm1SitAlu;
	}

	public void setnTm1SitAlu(int nTm1SitAlu) {
		this.nTm1SitAlu = nTm1SitAlu;
	}

	public int getnCodLengua() {
		return nCodLengua;
	}

	public void setnCodLengua(int nCodLengua) {
		this.nCodLengua = nCodLengua;
	}

	public int getnTm2Nivel() {
		return nTm2Nivel;
	}

	public void setnTm2Nivel(int nTm2Nivel) {
		this.nTm2Nivel = nTm2Nivel;
	}

	public int getnTm2Subniv() {
		return nTm2Subniv;
	}

	public void setnTm2Subniv(int nTm2Subniv) {
		this.nTm2Subniv = nTm2Subniv;
	}

	

	public int getnTm2Ciclo() {
		return nTm2Ciclo;
	}

	public void setnTm2Ciclo(int nTm2Ciclo) {
		this.nTm2Ciclo = nTm2Ciclo;
	}

	public int getnTm1SitMat() {
		return nTm1SitMat;
	}

	public void setnTm1SitMat(int nTm1SitMat) {
		this.nTm1SitMat = nTm1SitMat;
	}

	public int getnTm1TipmaT() {
		return nTm1TipmaT;
	}

	public void setnTm1TipmaT(int nTm1TipmaT) {
		this.nTm1TipmaT = nTm1TipmaT;
	}

	 

	public int getnPeriodo() {
		return nPeriodo;
	}

	public void setnPeriodo(int nPeriodo) {
		this.nPeriodo = nPeriodo;
	}

	public String getvObservaci() {
		return vObservaci;
	}

	public void setvObservaci(String vObservaci) {
		this.vObservaci = vObservaci;
	}

	public String getvNomLengua() {
		return vNomLengua;
	}

	public void setvNomLengua(String vNomLengua) {
		this.vNomLengua = vNomLengua;
	}

	public String getvNombreper() {
		return vNombreper;
	}

	public void setvNombreper(String vNombreper) {
		this.vNombreper = vNombreper;
	}

	public String getvApepatper() {
		return vApepatper;
	}

	public void setvApepatper(String vApepatper) {
		this.vApepatper = vApepatper;
	}

	public String getvApematper() {
		return vApematper;
	}

	public void setvApematper(String vApematper) {
		this.vApematper = vApematper;
	}

	public String getvNumdocum() {
		return vNumdocum;
	}

	public void setvNumdocum(String vNumdocum) {
		this.vNumdocum = vNumdocum;
	}

	public String getvNombreNivel() {
		return vNombreNivel;
	}

	public void setvNombreNivel(String vNombreNivel) {
		this.vNombreNivel = vNombreNivel;
	}

	
	
	
	
}
