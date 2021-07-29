package pe.gob.procalidad.natigu.core.entity.entity.seguridad;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


@NamedStoredProcedureQueries({	
	
	@NamedStoredProcedureQuery(name = "leotbd_usuperfil.listar", 
	procedureName = "segu.fun_leotbdusuperfil_listar", 
	resultClasses = LeotbdUsuperfil.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codperfil", type = Long.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbd_usuperfil.insertar", 
	procedureName = "segu.fun_leotbdusuperfil_insertar", 
	resultClasses = LeotbdUsuperfil.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.OUT,  name = "p_codusuper", type = Number.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codperfil", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbd_usuperfil.eliminar", 
	procedureName = "segu.fun_leotbdusuperfil_eliminar", 
	resultClasses = LeotbdUsuperfil.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusuper", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbd_usuperfil.buscarxcodigo", 
	procedureName = "segu.fun_leotbcusuario_buscar_x_codigousuario", 
	resultClasses = LeotbdUsuperfil.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class)
	})
})

@Entity
@Table(name="leotbd_usuperfil", schema="segu")
public class LeotbdUsuperfil implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@Column(name="n_codusuper")
	private Long nCodusuper;

	@Column(name="d_fecmod")
	private Timestamp dFecmod;

	@Column(name="d_fecreg")
	private Timestamp dFecreg;

	@Column(name="n_codperfil")
	private Long nCodperfil;

	@Column(name="n_codusuari")
	private Long nCodusuari;

	@Column(name="n_codusumod")
	private Long nCodusumod;

	@Column(name="n_codusureg")
	private Long nCodusureg;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;
	
	@Column(name="v_nomperfil")
	private String vNomperfil;
	
	@Column(name="v_nomusuari")
	private String vNomusuari;
	
	/**************************/
	@Column(name="v_nomperson")
	private String vNomperson;
	
	@Column(name="v_nominsti")
	private String vNominsti;

	@Column(name="v_telefono")
	private String vTelefono;
	
	@Column(name="v_correo")
	private String vCorreo;
	
	@Column(name="v_passusuar")
	private String vPassusuar;
	
	@Column(name="n_codperso")
	private Long nCodperso;
		
	@Column(name="v_nombfotop")
	private String vNombfotop;
	
	@Column(name="v_fecacc")
	private String vFecacc;
	
	@Column(name="n_codalumno")
	private Long nCodalumno;
	
	@Column(name="n_coddocen")
	private Long nCoddocen;
	
	public LeotbdUsuperfil() {
	}

	public Long getNCodusuper() {
		return this.nCodusuper;
	}

	public void setNCodusuper(Long nCodusuper) {
		this.nCodusuper = nCodusuper;
	}

	public Timestamp getDFecmod() {
		return this.dFecmod;
	}

	public void setDFecmod(Timestamp dFecmod) {
		this.dFecmod = dFecmod;
	}

	public Timestamp getDFecreg() {
		return this.dFecreg;
	}

	public void setDFecreg(Timestamp dFecreg) {
		this.dFecreg = dFecreg;
	}

	public Long getNCodperfil() {
		return this.nCodperfil;
	}

	public void setNCodperfil(Long nCodperfil) {
		this.nCodperfil = nCodperfil;
	}

	public Long getNCodusuari() {
		return this.nCodusuari;
	}

	public void setNCodusuari(Long nCodusuari) {
		this.nCodusuari = nCodusuari;
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

	public String getvNomperfil() {
		return vNomperfil;
	}

	public void setvNomperfil(String vNomperfil) {
		this.vNomperfil = vNomperfil;
	}

	public String getvNomusuari() {
		return vNomusuari;
	}

	public void setvNomusuari(String vNomusuari) {
		this.vNomusuari = vNomusuari;
	}

	public String getvNomperson() {
		return vNomperson;
	}

	public void setvNomperson(String vNomperson) {
		this.vNomperson = vNomperson;
	}

	public String getvNominsti() {
		return vNominsti;
	}

	public void setvNominsti(String vNominsti) {
		this.vNominsti = vNominsti;
	}

	public String getvTelefono() {
		return vTelefono;
	}

	public void setvTelefono(String vTelefono) {
		this.vTelefono = vTelefono;
	}

	public String getvCorreo() {
		return vCorreo;
	}

	public void setvCorreo(String vCorreo) {
		this.vCorreo = vCorreo;
	}

	public String getvPassusuar() {
		return vPassusuar;
	}

	public void setvPassusuar(String vPassusuar) {
		this.vPassusuar = vPassusuar;
	}

	public Long getnCodperso() {
		return nCodperso;
	}

	public void setnCodperso(Long nCodperso) {
		this.nCodperso = nCodperso;
	}

	public String getvNombfotop() {
		return vNombfotop;
	}

	public void setvNombfotop(String vNombfotop) {
		this.vNombfotop = vNombfotop;
	}

	public String getvFecacc() {
		return vFecacc;
	}

	public void setvFecacc(String vFecacc) {
		this.vFecacc = vFecacc;
	}

	public Long getnCodalumno() {
		return nCodalumno;
	}

	public void setnCodalumno(Long nCodalumno) {
		this.nCodalumno = nCodalumno;
	}

	public Long getnCoddocen() {
		return nCoddocen;
	}

	public void setnCoddocen(Long nCoddocen) {
		this.nCoddocen = nCoddocen;
	}
	
	

}