package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;



@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbdperlengua.insertar", 
			procedureName = "gene.fun_leotbdperlengua_insertar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codperlen", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tipolengua", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
			})
	,
	@NamedStoredProcedureQuery(name = "leotbdperlengua.eliminar", 
		procedureName = "gene.fun_leotbdperlengua_eliminar",
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Integer.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Integer.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tipolengua", type = Integer.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Integer.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		})
	,
	@NamedStoredProcedureQuery(name = "leotbdperlengua.buscarPorcodigoPersona", 
		procedureName = "gene.fun_leotbdperlengua_buscar_x_codigopersona", 
		resultClasses = LeotbdPerlengua.class,
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = long.class)
		})
})
@Entity
@Table(name="leotbd_perlengua")
public class LeotbdPerlengua implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codperlen")
	private long nCodperlen;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_codlengua")
	private Integer nCodlengua;
	
	@Column(name="v_nomlengua")
	private String vNomlengua;
	
	@Column(name="n_codperso")
	private Integer nCodperso;

	@Column(name="n_codusumod")
	private Integer nCodusumod;

	@Column(name="n_codusureg")
	private Integer nCodusureg;

	@Column(name="n_tm1tipolengua")
	private Integer nTm1tipolengua;
	
	@Column(name="v_tm1tipolengua")
	private String vTm1tipolengua;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	public LeotbdPerlengua() {
	}

	public long getNCodperlen() {
		return this.nCodperlen;
	}

	public void setNCodperlen(long nCodperlen) {
		this.nCodperlen = nCodperlen;
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

	public Integer getNCodlengua() {
		return this.nCodlengua;
	}

	public void setNCodlengua(Integer nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public Integer getNCodperso() {
		return this.nCodperso;
	}

	public void setNCodperso(Integer nCodperso) {
		this.nCodperso = nCodperso;
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

	public Integer getNTm1tipolengua() {
		return this.nTm1tipolengua;
	}

	public void setNTm1tipolengua(Integer nTm1tipolengua) {
		this.nTm1tipolengua = nTm1tipolengua;
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

	public String getVNomlengua() {
		return vNomlengua;
	}

	public void setVNomlengua(String vNomlengua) {
		this.vNomlengua = vNomlengua;
	}

	public String getVTm1tipolengua() {
		return vTm1tipolengua;
	}

	public void setVTm1tipolengua(String vTm1tipolengua) {
		this.vTm1tipolengua = vTm1tipolengua;
	}
	
	

}