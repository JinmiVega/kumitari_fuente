package pe.gob.procalidad.natigu.core.entity.entity.seguridad;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

@NamedStoredProcedureQueries({	
	@NamedStoredProcedureQuery(name = "leotbc_perfil.insertar", 
		procedureName = "segu.fun_leotbcperfil_insertar", 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_estado", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperfil", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_nomperfil", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_tm1sitprf", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusureg", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostreg", type = String.class)
		}),
		
	@NamedStoredProcedureQuery(name = "leotbc_perfil.actualizar", 
	procedureName = "segu.fun_leotbcperfil_actualizar", 
	resultClasses = LeotbcPerfil.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_estado", type = Number.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperfil", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_nomperfil", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_tm1sitprf", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostmod", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_perfil.eliminar", 
	procedureName = "segu.fun_leotbcperfil_eliminar", 
	resultClasses = LeotbcPerfil.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperfil", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostmod", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_perfil.listar", 
	procedureName = "segu.fun_leotbcperfil_listar", 
	resultClasses = LeotbcPerfil.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomperfil", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codperfil", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_tm1sitprf", type = Integer.class)
	}),
		
})

@Entity
@Table(name="leotbc_perfil", schema="segu")
public class LeotbcPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Id
	@Column(name="n_codperfil")
	private Long nCodperfil;

	@Column(name="n_codusumod")
	private Long nCodusumod;

	@Column(name="n_codusureg")
	private Long nCodusureg;

	@Column(name="n_tm1sitprf")
	private Long nTm1sitprf;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_nomperfil")
	private String vNomperfil;
	
	@Column(name="v_nomsitprf")
	private String nombreSituacion;

	public LeotbcPerfil() {
	}

	public Date getdFecmod() {
		return dFecmod;
	}

	public void setdFecmod(Date dFecmod) {
		this.dFecmod = dFecmod;
	}

	public Date getdFecreg() {
		return dFecreg;
	}

	public void setdFecreg(Date dFecreg) {
		this.dFecreg = dFecreg;
	}

	public Long getnCodperfil() {
		return nCodperfil;
	}

	public void setnCodperfil(Long nCodperfil) {
		this.nCodperfil = nCodperfil;
	}

	public Long getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(Long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public Long getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(Long nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public Long getnTm1sitprf() {
		return nTm1sitprf;
	}

	public void setnTm1sitprf(Long nTm1sitprf) {
		this.nTm1sitprf = nTm1sitprf;
	}

	public String getvFlgest() {
		return vFlgest;
	}

	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}

	public String getvHostmod() {
		return vHostmod;
	}

	public void setvHostmod(String vHostmod) {
		this.vHostmod = vHostmod;
	}

	public String getvHostreg() {
		return vHostreg;
	}

	public void setvHostreg(String vHostreg) {
		this.vHostreg = vHostreg;
	}

	public String getvNomperfil() {
		return vNomperfil;
	}

	public void setvNomperfil(String vNomperfil) {
		this.vNomperfil = vNomperfil;
	}

	public String getNombreSituacion() {
		return nombreSituacion;
	}

	public void setNombreSituacion(String nombreSituacion) {
		this.nombreSituacion = nombreSituacion;
	}

	

	
}