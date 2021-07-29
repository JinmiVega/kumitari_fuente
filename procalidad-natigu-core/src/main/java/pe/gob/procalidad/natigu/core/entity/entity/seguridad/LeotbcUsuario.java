package pe.gob.procalidad.natigu.core.entity.entity.seguridad;

import java.io.Serializable;

import javax.persistence.*;


import java.util.Date;

@NamedStoredProcedureQueries({	
	@NamedStoredProcedureQuery(name = "leotbc_usuario.insertar", 
		procedureName = "segu.fun_leotbcusuario_insertar", 
		resultClasses = LeotbcUsuario.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codusuari", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_nomusuari", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_passusuar", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codperso", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_tm1situsu", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusureg", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostreg", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusumod", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_fecmod", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostmod", type = String.class)
		}),
		
	@NamedStoredProcedureQuery(name = "leotbc_usuario.actualizar", 
	procedureName = "segu.fun_leotbcusuario_actualizar", 
	resultClasses = LeotbcUsuario.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_nomusuari", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_passusuar", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_tm1situsu", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusureg", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostreg", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_fecmod", type = Date.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostmod", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_usuario.eliminar", 
	procedureName = "segu.fun_leotbcusuario_eliminar", 
	resultClasses = LeotbcUsuario.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostmod", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_usuario.listar", 
	procedureName = "segu.fun_leotbcusuario_listar", 
	resultClasses = LeotbcUsuario.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_nomusuari", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codperso", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codperfil", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_tm1situsu", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusuacc", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codperusu", type = Integer.class)
		
	}),
	@NamedStoredProcedureQuery(name = "leotbc_usuario.autenticar", 
		procedureName = "segu.fun_leotbcusuario_autenticar", 
		resultClasses = LeotbcUsuario.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_nomusuari", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_passusuar", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_usuario.resetpass", 
	procedureName = "segu.fun_leotbcusuario_resetpass", 
	resultClasses = Number.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_result", type = Number.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_passusuar", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_newpass", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgrestpas", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostmod", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_usuario.buscarxcodigousua", 
	procedureName = "segu.fun_leotbcusuario_buscarxcodigousua", 
	resultClasses = LeotbcUsuario.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusuari", type = Long.class)
}),
	@NamedStoredProcedureQuery(name = "leotbc_usuario.buscarxcodperso", 
	procedureName = "segu.fun_leotbcusuario_buscarxcodperso", 
	resultClasses = LeotbcUsuario.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codperso", type = Long.class)
	})
	
})


@Entity
@Table(name="leotbc_usuario", schema="segu")
public class LeotbcUsuario implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@Column(name="n_codusuari")
	private Long nCodusuari;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_codperfil")
	private Long nCodperfil;

	@Column(name="n_codperso")
	private Long nCodperso;

	@Column(name="n_codusumod")
	private Long nCodusumod;

	@Column(name="n_codusureg")
	private Long nCodusureg;

	@Column(name="n_tm1situsu")
	private Long nTm1situsu;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_nomusuari")
	private String vNomusuari;

	@Column(name="v_passusuar")
	private String vPassusuar;
	
	@Column(name="v_nomperfil")
	private String vNomperfil;
	
	@Column(name="v_nomperson")
	private String vNomperson;
	
	@Column(name="v_numdocum")
	private String vNumdocum;
	
	@Column(name="v_nomsitusu")
	private String vNomsitusu;
	
	@Column(name="n_tm1tpdope")
	private Long nTm1tpdope;
	
	@Column(name="v_flgrespas")
	private String vFlgrestpas;
	
	@Column(name="n_monedas")
	private Long nMonedas;
	
	@Column(name="n_gemas")
	private Long nGemas;
	
	@Column(name="v_nombfotop")
	private String vNombfotop;

	public LeotbcUsuario() {
	}

	public Long getNCodusuari() {
		return this.nCodusuari;
	}

	public void setNCodusuari(Long nCodusuari) {
		this.nCodusuari = nCodusuari;
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

	public Long getNCodperfil() {
		return this.nCodperfil;
	}

	public void setNCodperfil(Long nCodperfil) {
		this.nCodperfil = nCodperfil;
	}

	public Long getNCodperso() {
		return this.nCodperso;
	}

	public void setNCodperso(Long nCodperso) {
		this.nCodperso = nCodperso;
	}

	public Long getNCodusumod() {
		return this.nCodusumod;
	}

	public void setNCodusumod(Long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public Long getNCodusureg() {
		return this.nCodusureg;
	}

	public void setNCodusureg(Long nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public Long getNTm1situsu() {
		return this.nTm1situsu;
	}

	public void setNTm1situsu(Long nTm1situsu) {
		this.nTm1situsu = nTm1situsu;
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

	public String getVNomusuari() {
		return this.vNomusuari;
	}

	public void setVNomusuari(String vNomusuari) {
		this.vNomusuari = vNomusuari;
	}

	public String getVPassusuar() {
		return this.vPassusuar;
	}

	public void setVPassusuar(String vPassusuar) {
		this.vPassusuar = vPassusuar;
	}

	public String getvNomperfil() {
		return vNomperfil;
	}

	public void setvNomperfil(String vNomperfil) {
		this.vNomperfil = vNomperfil;
	}

	public String getvNomperson() {
		return vNomperson;
	}

	public void setvNomperson(String vNomperson) {
		this.vNomperson = vNomperson;
	}

	public String getvNumdocum() {
		return vNumdocum;
	}

	public void setvNumdocum(String vNumdocum) {
		this.vNumdocum = vNumdocum;
	}

	public String getvNomsitusu() {
		return vNomsitusu;
	}

	public void setvNomsitusu(String vNomsitusu) {
		this.vNomsitusu = vNomsitusu;
	}

	public Long getnTm1tpdope() {
		return nTm1tpdope;
	}

	public void setnTm1tpdope(Long nTm1tpdope) {
		this.nTm1tpdope = nTm1tpdope;
	}

	public String getvFlgrestpas() {
		return vFlgrestpas;
	}

	public void setvFlgrestpas(String vFlgrestpas) {
		this.vFlgrestpas = vFlgrestpas;
	}

	public Long getnMonedas() {
		return nMonedas;
	}

	public void setnMonedas(Long nMonedas) {
		this.nMonedas = nMonedas;
	}

	public Long getnGemas() {
		return nGemas;
	}

	public void setnGemas(Long nGemas) {
		this.nGemas = nGemas;
	}

	public String getvNombfotop() {
		return vNombfotop;
	}

	public void setvNombfotop(String vNombfotop) {
		this.vNombfotop = vNombfotop;
	}
	
	
}