package pe.gob.procalidad.natigu.core.entity.entity.configuracion;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbd_exaconfig.listar",
			procedureName = "conf.fun_leotbcexaconfig_buscar_todos", 
			resultClasses = LeotbcExaConfig.class, parameters = {}),
	
})
@Entity
@Table(name="leotbc_exaconfig")
public class LeotbcExaConfig implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codconfexa")
	private Integer nCodconfexa;
	
	@Column(name="n_tm2subniv")
	private Integer nTm2subniv;
	
	@Column(name="n_tm2unid")
	private Integer nTm2unid;
	
	@Column(name="n_tm2lecc")
	private Integer nTm2lecc;
	
	@Column(name="d_porcentaprob")
	private Integer dPorcentaprob;
	
	@Column(name="v_flgest")
	private String vFlgest;
	
	@Column(name="n_codusureg")
	private Integer nCodusureg;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	
	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="n_codusumod")
	private Integer nCodusumod;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;
	
	@Column(name="v_hostmod")
	private String vHostmod;
	
	private String v_nombreSubNivel;
	
	private String v_nombreUnidad;
	
	private String v_nombreLeccion;

	public Integer getnCodconfexa() {
		return nCodconfexa;
	}

	public void setnCodconfexa(Integer nCodconfexa) {
		this.nCodconfexa = nCodconfexa;
	}

	public Integer getnTm2subniv() {
		return nTm2subniv;
	}

	public void setnTm2subniv(Integer nTm2subniv) {
		this.nTm2subniv = nTm2subniv;
	}

	public Integer getnTm2unid() {
		return nTm2unid;
	}

	public void setnTm2unid(Integer nTm2unid) {
		this.nTm2unid = nTm2unid;
	}

	public Integer getnTm2lecc() {
		return nTm2lecc;
	}

	public void setnTm2lecc(Integer nTm2lecc) {
		this.nTm2lecc = nTm2lecc;
	}

	public Integer getdPorcentaprob() {
		return dPorcentaprob;
	}

	public void setdPorcentaprob(Integer dPorcentaprob) {
		this.dPorcentaprob = dPorcentaprob;
	}

	public String getvFlgest() {
		return vFlgest;
	}

	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}

	public Integer getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(Integer nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public Date getdFecreg() {
		return dFecreg;
	}

	public void setdFecreg(Date dFecreg) {
		this.dFecreg = dFecreg;
	}

	public String getvHostreg() {
		return vHostreg;
	}

	public void setvHostreg(String vHostreg) {
		this.vHostreg = vHostreg;
	}

	public Integer getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(Integer nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public Date getdFecmod() {
		return dFecmod;
	}

	public void setdFecmod(Date dFecmod) {
		this.dFecmod = dFecmod;
	}

	public String getvHostmod() {
		return vHostmod;
	}

	public void setvHostmod(String vHostmod) {
		this.vHostmod = vHostmod;
	}

	public String getV_nombreSubNivel() {
		return v_nombreSubNivel;
	}

	public void setV_nombreSubNivel(String v_nombreSubNivel) {
		this.v_nombreSubNivel = v_nombreSubNivel;
	}

	public String getV_nombreUnidad() {
		return v_nombreUnidad;
	}

	public void setV_nombreUnidad(String v_nombreUnidad) {
		this.v_nombreUnidad = v_nombreUnidad;
	}

	public String getV_nombreLeccion() {
		return v_nombreLeccion;
	}

	public void setV_nombreLeccion(String v_nombreLeccion) {
		this.v_nombreLeccion = v_nombreLeccion;
	}

	
}
