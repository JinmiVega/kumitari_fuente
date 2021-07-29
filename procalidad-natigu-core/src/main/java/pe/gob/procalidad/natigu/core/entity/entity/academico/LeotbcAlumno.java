package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcMascota;

import java.util.Date;


@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbc_alumno.listar", 
			procedureName = "acad.fun_leotbcalumno_buscar_x_filtros", 
			resultClasses = LeotbcAlumno.class,
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codalumno", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomalumn", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numdocum", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nominsti", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitalu", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperfil", type = Integer.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_alumno.insertar", 
	procedureName = "acad.fun_leotbcalumno_insertar", 
			resultClasses = LeotbcAlumno.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codalumno", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codubinst", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2progr", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2grado", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitalu", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_alumno.eliminar", procedureName = "acad.fun_leotbcalumno_eliminar", 
		resultClasses = LeotbcAlumno.class, parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codalumno", type = Integer.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Integer.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) 
	}),
	@NamedStoredProcedureQuery(name = "leotbc_alumno.buscar_por_codigo", procedureName = "acad.fun_leotbcalumno_buscar_x_codigo", 
		resultClasses = LeotbcAlumno.class, parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codalumno", type = Integer.class) 
	}),
	@NamedStoredProcedureQuery(name = "leotbc_alumno.actualizar", procedureName = "acad.fun_leotbcalumno_actualizar", 
		resultClasses = LeotbcAlumno.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codalumno", type = Integer.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Integer.class), 
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_apepatper", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_apematper", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombreper", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpdope", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numdocum", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tipper", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codubigeo", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_direcpers", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitper", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fechnacim", type = Date.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2pais", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2estciv", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2sexo", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telefono", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type = String.class),
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codubinst", type = String.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2progr", type = Integer.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = Integer.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2grado", type = Integer.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitalu", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
	}),
	/****Raul****/
	@NamedStoredProcedureQuery(name = "leotbc_alumno.buscarXcodigoInstitucion", 
	procedureName = "acad.fun_leotbcalumno_buscar_x_codigoinstitucion", 
	resultClasses = LeotbcAlumno.class, 
	parameters = { 
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsclen", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tiponivel", type = Integer.class), 
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombredoc", type = String.class)
	})
	
	
})

@Entity
@Table(name="leotbc_alumno")
public class LeotbcAlumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	@Id
	@Column(name="n_codalumno")
	private Integer nCodalumno;

	@Column(name="n_codinsti")
	private Integer nCodinsti;

	@Column(name="n_codperso")
	private Integer nCodperso;

	@Column(name="v_codubinst")
	private String vCodubinst;

	@Column(name="n_codusumod")
	private Integer nCodusumod;

	@Column(name="n_codusureg")
	private Integer nCodusureg;

	@Column(name="n_tm1sitalu")
	private Integer nTm1sitalu;

	@Column(name="n_tm2grado")
	private Integer nTm2grado;

	@Column(name="n_tm2nivel")
	private Integer nTm2nivel;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="n_tm2progr")
	private Integer nTm2progr;
	
	@Column(name="v_nombreper")
	private String vNombreper;
	
	@Column(name="v_apepatper")
	private String vApepatper;

	@Column(name="v_apematper")
	private String vApematper;
	
	@Column(name="v_numdocum")
	private String vNumdocum;
	
	@Column(name="v_nominsti")
	private String vNominsti;
	
	@Column(name="v_nomsitalu")
	private String vNomsitalu;

	@Column(name="v_direcpers")
	private String vDirecpers;

	@Column(name="v_telefono")
	private String vTelefono;

	@Column(name="v_correo")
	private String vCorreo;

	@Column(name="n_tm2sexo")
	private Integer nTm2sexo;

	@Column(name="n_tm1tpdope")
	private Integer nTm1tpdope;
	
	@Column(name="n_tm2pais")
	private Integer nTm2pais;
	
	@Column(name="n_codlengua")
	private Integer nCodlengua;
	//n_tm2estciv
	@Column(name="v_codubigeo")
	private String vCodubigeo;
	
	@Column(name="n_tm2estciv")
	private Integer nTm2estciv;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fechnacim")
	private Date dFechnacim;
	
	public LeotbcAlumno() {
	}

	public String getVTelefono() {
		return vTelefono;
	}

	public void setVTelefono(String vTelefono) {
		this.vTelefono = vTelefono;
	}

	public String getVCorreo() {
		return vCorreo;
	}

	public void setVCorreo(String vCorreo) {
		this.vCorreo = vCorreo;
	}

	public Integer getNTm2sexo() {
		return nTm2sexo;
	}

	public void setNTm2sexo(Integer nTm2sexo) {
		this.nTm2sexo = nTm2sexo;
	}

	public Date getDFechnacim() {
		return this.dFechnacim;
	}

	public void setDFechnacim(Date dFechnacim) {
		this.dFechnacim = dFechnacim;
	}

	public Date getDFecmod() {
		return this.dFecmod;
	}

	public void setDFecmod(Date dFecmod) {
		this.dFecmod = dFecmod;
	}

	public Date getDFecreg() {
		return this.dFecreg;
	}

	public void setDFecreg(Date dFecreg) {
		this.dFecreg = dFecreg;
	}

	public Integer getNCodalumno() {
		return this.nCodalumno;
	}

	public void setNCodalumno(Integer nCodalumno) {
		this.nCodalumno = nCodalumno;
	}

	public Integer getNCodinsti() {
		return this.nCodinsti;
	}

	public void setNCodinsti(Integer nCodinsti) {
		this.nCodinsti = nCodinsti;
	}

	public Integer getNCodperso() {
		return this.nCodperso;
	}

	public void setNCodperso(Integer nCodperso) {
		this.nCodperso = nCodperso;
	}

	public String getVCodubinst() {
		return this.vCodubinst;
	}

	public void setVCodubinst(String vCodubinst) {
		this.vCodubinst = vCodubinst;
	}

	public Integer getNCodusumod() {
		return this.nCodusumod;
	}

	public void setNCodusumod(Integer nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public Integer getNCodusureg() {
		return this.nCodusureg;
	}

	public void setNCodusureg(Integer nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public Integer getNTm1sitalu() {
		return this.nTm1sitalu;
	}

	public void setNTm1sitalu(Integer nTm1sitalu) {
		this.nTm1sitalu = nTm1sitalu;
	}

	public Integer getNTm2grado() {
		return this.nTm2grado;
	}

	public void setNTm2grado(Integer nTm2grado) {
		this.nTm2grado = nTm2grado;
	}

	public Integer getNTm2nivel() {
		return this.nTm2nivel;
	}

	public void setNTm2nivel(Integer nTm2nivel) {
		this.nTm2nivel = nTm2nivel;
	}

	public String getVFlgest() {
		return this.vFlgest;
	}

	public void setVFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}

	public String getVHostmod() {
		return this.vHostmod;
	}

	public void setVHostmod(String vHostmod) {
		this.vHostmod = vHostmod;
	}

	public String getVHostreg() {
		return this.vHostreg;
	}

	public void setVHostreg(String vHostreg) {
		this.vHostreg = vHostreg;
	}

	public Integer getNTm2progr() {
		return this.nTm2progr;
	}

	public void setNTm2progr(Integer nTm2progr) {
		this.nTm2progr = nTm2progr;
	}

	public String getVNombreper() {
		return vNombreper;
	}

	public void setVNombreper(String vNombreper) {
		this.vNombreper = vNombreper;
	}

	public String getVApepatper() {
		return vApepatper;
	}

	public void setVApepatper(String vApepatper) {
		this.vApepatper = vApepatper;
	}

	public String getVApematper() {
		return vApematper;
	}

	public void setVApematper(String vApematper) {
		this.vApematper = vApematper;
	}

	public String getVNumdocum() {
		return vNumdocum;
	}

	public void setVNumdocum(String vNumdocum) {
		this.vNumdocum = vNumdocum;
	}

	public String getVNominsti() {
		return vNominsti;
	}

	public void setVNominsti(String vNominsti) {
		this.vNominsti = vNominsti;
	}

	public String getVNomsitalu() {
		return vNomsitalu;
	}

	public void setVNomsitalu(String vNomsitalu) {
		this.vNomsitalu = vNomsitalu;
	}

	public String getVDirecpers() {
		return vDirecpers;
	}

	public void setVDirecpers(String vDirecpers) {
		this.vDirecpers = vDirecpers;
	}

	public Integer getNTm1tpdope() {
		return this.nTm1tpdope;
	}

	public void setNTm1tpdope(Integer nTm1tpdope) {
		this.nTm1tpdope = nTm1tpdope;
	}

	public Integer getNTm2pais() {
		return this.nTm2pais;
	}

	public void setNTm2pais(Integer nTm2pais) {
		this.nTm2pais = nTm2pais;
	}

	public String getVCodubigeo() {
		return this.vCodubigeo;
	}

	public void setVCodubigeo(String vCodubigeo) {
		this.vCodubigeo = vCodubigeo;
	}

	public Integer getNCodlengua() {
		return nCodlengua;
	}

	public void setNCodlengua(Integer nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public Integer getnTm2estciv() {
		return nTm2estciv;
	}

	public void setnTm2estciv(Integer nTm2estciv) {
		this.nTm2estciv = nTm2estciv;
	}
	
	
	
		
}