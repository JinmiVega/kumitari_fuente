package pe.gob.procalidad.natigu.core.entity.entity.configuracion;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="leotbc_etiqueta")
public class LeotbcEtiqueta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codetiqueta")
	private Long nCodetiqueta;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_codusumod")
	private Long nCodusumod;

	@Column(name="n_codusureg")
	private Long nCodusureg;

	@Column(name="n_tm1tipeti")
	private Integer nTm1tipeti;

	@Column(name="v_descripcion")
	private String vDescripcion;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_urlimagen")
	private String vUrlimagen;

	//bi-directional many-to-one association to LeotbdTraduccion
//	@OneToMany(mappedBy="leotbcEtiqueta")
//	private List<LeotbdTraduccion> leotbdTraduccions;

	public LeotbcEtiqueta() {
	}

	public Long getNCodetiqueta() {
		return this.nCodetiqueta;
	}

	public void setNCodetiqueta(Long nCodetiqueta) {
		this.nCodetiqueta = nCodetiqueta;
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

	public Integer getNTm1tipeti() {
		return this.nTm1tipeti;
	}

	public void setNTm1tipeti(Integer nTm1tipeti) {
		this.nTm1tipeti = nTm1tipeti;
	}

	public String getVDescripcion() {
		return this.vDescripcion;
	}

	public void setVDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
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

	public String getVUrlimagen() {
		return this.vUrlimagen;
	}

	public void setVUrlimagen(String vUrlimagen) {
		this.vUrlimagen = vUrlimagen;
	}


}