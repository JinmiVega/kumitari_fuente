package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotmd_docenespeci.insertar", 
			procedureName = "acad.fun_leotmddocenespeci_insertar", 
			resultClasses = LeotmdDocenespeci.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_coddocesp", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numdocum", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_rutadocu", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "leotmd_docenespeci.eliminar", 
		procedureName = "acad.fun_leotmddocenespeci_eliminar", 
		resultClasses = LeotmdDocenespeci.class, parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = Integer.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Integer.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Integer.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) 
	}),
	@NamedStoredProcedureQuery(name = "leotmd_docenespeci.buscar_por_codigodocente",
		procedureName = "acad.fun_leotmddocenespeci_buscar_x_codigodocente", 
		resultClasses = LeotmdDocenespeci.class, parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = Integer.class) 
	})
})

@Entity
@Table(name="leotmd_docenespeci")
public class LeotmdDocenespeci implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_coddocen")
	private Integer nCoddocen;
	@Id
	@Column(name="n_coddocesp")
	private Integer nCoddocesp;

	@Column(name="n_codlengua")
	private Integer nCodlengua;

	@Column(name="n_codusumod")
	private Integer nCodusumod;

	@Column(name="n_codusureg")
	private Integer nCodusureg;

	@Column(name="n_tm2nivel")
	private Integer nTm2nivel;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_nombretm2nivel")
	private String vNombretm2nivel;

	@Column(name="v_nomlengua")
	private String vNomlengua;

	@Column(name="v_numdocum")
	private String vNumdocum;

	@Column(name="v_rutadocu")
	private String vRutadocu;

	public LeotmdDocenespeci() {
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

	public Integer getNCoddocen() {
		return this.nCoddocen;
	}

	public void setNCoddocen(Integer nCoddocen) {
		this.nCoddocen = nCoddocen;
	}

	public Integer getNCoddocesp() {
		return this.nCoddocesp;
	}

	public void setNCoddocesp(Integer nCoddocesp) {
		this.nCoddocesp = nCoddocesp;
	}

	public Integer getNCodlengua() {
		return this.nCodlengua;
	}

	public void setNCodlengua(Integer nCodlengua) {
		this.nCodlengua = nCodlengua;
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
	public String getVNombretm2nivel() {
		return this.vNombretm2nivel;
	}

	public void setVNombretm2nivel(String vNombretm2nivel) {
		this.vNombretm2nivel = vNombretm2nivel;
	}
	public String getVNomlengua() {
		return this.vNomlengua;
	}

	public void setVNomlengua(String vNomlengua) {
		this.vNomlengua = vNomlengua;
	}

	public String getvNumdocum() {
		return vNumdocum;
	}

	public void setvNumdocum(String vNumdocum) {
		this.vNumdocum = vNumdocum;
	}

	public String getvRutadocu() {
		return vRutadocu;
	}

	public void setvRutadocu(String vRutadocu) {
		this.vRutadocu = vRutadocu;
	}

	
	
}