package pe.gob.procalidad.natigu.core.entity.entity.configuracion;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbc_glosario.insertar",
	procedureName = "conf.fun_leotbcglosario_insertar", 
	resultClasses = LeotbcGlosario.class, 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codglosario", type = Number.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_detalle", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_mimetype", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_peso", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomarchivo", type = String.class)
	}),
	
	@NamedStoredProcedureQuery(name = "leotbc_glosario.listar",
	procedureName = "conf.fun_leotbcglosario_listar", 
	resultClasses = LeotbcGlosario.class, 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codglosario", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class)
	}),
	
	@NamedStoredProcedureQuery(name = "leotbc_glosario.actualizar",
	procedureName = "conf.fun_leotbcglosario_actualizar", 
	resultClasses = LeotbcGlosario.class, 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codglosario", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_detalle", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_mimetype", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_peso", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomarchivo", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_glosario.eliminar",
	procedureName = "conf.fun_leotbcglosario_eliminar", 
	resultClasses = LeotbcGlosario.class, 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codglosario", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
	}),

})

@Entity
@Table(name="leotbc_glosario")

public class LeotbcGlosario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="d_fecmod")
	private Timestamp dFecmod;

	@Column(name="d_fecreg")
	private Timestamp dFecreg;

	@Id
	@Column(name="n_codglosario")
	private Long nCodglosario;

	@Column(name="n_codlengua")
	private Long nCodlengua;

	@Column(name="n_codusumod")
	private Long nCodusumod;

	@Column(name="n_codusureg")
	private Long nCodusureg;

	@Column(name="v_detalle")
	private String vDetalle;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;
	
	@Column(name="v_nomlengua")
	private String vNomlengua;
	
	@Column(name="v_mimetype")
	private String vMimeType;
	
	@Column(name="n_peso")
	private Integer nPeso;
	
	@Column(name="v_nomarchivo")
	private String vNomarchivo;

	public LeotbcGlosario() {
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

	public Long getNCodglosario() {
		return this.nCodglosario;
	}

	public void setNCodglosario(Long nCodglosario) {
		this.nCodglosario = nCodglosario;
	}

	public Long getNCodlengua() {
		return this.nCodlengua;
	}

	public void setNCodlengua(Long nCodlengua) {
		this.nCodlengua = nCodlengua;
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

	public String getVDetalle() {
		return this.vDetalle;
	}

	public void setVDetalle(String vDetalle) {
		this.vDetalle = vDetalle;
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

	public String getvNomlengua() {
		return vNomlengua;
	}

	public void setvNomlengua(String vNomlengua) {
		this.vNomlengua = vNomlengua;
	}

	public String getvMimeType() {
		return vMimeType;
	}

	public void setvMimeType(String vMimeType) {
		this.vMimeType = vMimeType;
	}

	public Integer getnPeso() {
		return nPeso;
	}

	public void setnPeso(Integer nPeso) {
		this.nPeso = nPeso;
	}

	public String getvNomarchivo() {
		return vNomarchivo;
	}

	public void setvNomarchivo(String vNomarchivo) {
		this.vNomarchivo = vNomarchivo;
	}

}