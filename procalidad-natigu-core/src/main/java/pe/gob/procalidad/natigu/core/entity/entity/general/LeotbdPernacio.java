package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbdpernacio.insertar", 
			procedureName = "gene.fun_leotbdpernacio_insertar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codpernac", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2pais", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
			})
	,
	@NamedStoredProcedureQuery(name = "leotbdpernacio.eliminar", 
			procedureName = "gene.fun_leotbdpernacio_eliminar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2pais", type = Integer.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Integer.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			})
	,
	@NamedStoredProcedureQuery(name = "leotbdpernacio.buscarPorcodigoPersona", 
			procedureName = "gene.fun_leotbdpernacio_buscar_x_codigopersona", 
			resultClasses = LeotbdPernacio.class,
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = long.class)
			})
})

@Entity
@Table(name="leotbd_pernacio")
public class LeotbdPernacio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codpernac")
	private long nCodpernac;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_codperso")
	private Integer nCodperso;

	@Column(name="n_codusumod")
	private Integer nCodusumod;

	@Column(name="n_codusureg")
	private Integer nCodusureg;

	@Column(name="n_tm2pais")
	private Integer nTm2pais;

	@Column(name="v_tm2pais")
	private String vTm2pais;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	public LeotbdPernacio() {
	}

	public long getNCodpernac() {
		return this.nCodpernac;
	}

	public void setNCodpernac(long nCodpernac) {
		this.nCodpernac = nCodpernac;
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

	public Integer getNTm2pais() {
		return this.nTm2pais;
	}

	public void setNTm2pais(Integer nTm2pais) {
		this.nTm2pais = nTm2pais;
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

	public String getVTm2pais() {
		return vTm2pais;
	}

	public void setVTm2pais(String vTm2pais) {
		this.vTm2pais = vTm2pais;
	}

	
	
}