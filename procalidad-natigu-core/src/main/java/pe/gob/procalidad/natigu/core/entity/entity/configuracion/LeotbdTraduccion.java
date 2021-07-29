package pe.gob.procalidad.natigu.core.entity.entity.configuracion;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbd_traduccion.insertar",
	procedureName = "conf.fun_leotbdtraduccion_insertar", 
	resultClasses = LeotbdTraduccion.class, 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codtraduc", type = Number.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codetiqueta", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_traduccion", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
	}),
	
	@NamedStoredProcedureQuery(name = "leotbd_traduccion.listar",
	procedureName = "conf.fun_leotbdtraduccion_listar", 
	resultClasses = LeotbdTraduccion.class, 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtraduc", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codetiqueta", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_traduccion", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tipeti", type = Integer.class)
	}),
	
	@NamedStoredProcedureQuery(name = "leotbd_traduccion.actualizar",
	procedureName = "conf.fun_leotbdtraduccion_actualizar", 
	resultClasses = LeotbdTraduccion.class, 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtraduc", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codetiqueta", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_traduccion", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
	})

})

@Entity
@Table(name="leotbd_traduccion")
public class LeotbdTraduccion implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Column(name="n_codtraduc")
	private Long nCodtraduc;
	
	@Id
	@Column(name="n_codetiqueta")
	private Long nCodetiqueta;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_codlengua")
	private Long nCodlengua;

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

	@Column(name="v_traduccion")
	private String vTraduccion;

	@Column(name="n_tm1tipeti")
	private Integer nTm1tipeti;

	@Column(name="v_descripcion")
	private String vDescripcion;
	
	@Column(name="v_urlimagen")
	private String vUrlimagen;
	
	@Column(name="v_nomlengua")
	private String vNomlengua;
	
	@Column(name="v_nomtipeti")
	private String vNomtipeti;
	
	
	
	//bi-directional many-to-one association to LeotbcEtiqueta
//	@ManyToOne
//	@JoinColumn(name="n_codetiqueta")
//	private LeotbcEtiqueta leotbcEtiqueta;

	public LeotbdTraduccion() {
	}

	public Long getNCodtraduc() {
		return this.nCodtraduc;
	}

	public void setNCodtraduc(Long nCodtraduc) {
		this.nCodtraduc = nCodtraduc;
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

	public String getVTraduccion() {
		return this.vTraduccion;
	}

	public void setVTraduccion(String vTraduccion) {
		this.vTraduccion = vTraduccion;
	}

	public String getvNomlengua() {
		return vNomlengua;
	}

	public void setvNomlengua(String vNomlengua) {
		this.vNomlengua = vNomlengua;
	}

	public String getvNomtipeti() {
		return vNomtipeti;
	}

	public void setvNomtipeti(String vNomtipeti) {
		this.vNomtipeti = vNomtipeti;
	}

	public Long getnCodetiqueta() {
		return nCodetiqueta;
	}

	public void setnCodetiqueta(Long nCodetiqueta) {
		this.nCodetiqueta = nCodetiqueta;
	}

	public String getvDescripcion() {
		return vDescripcion;
	}

	public void setvDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

	public Integer getnTm1tipeti() {
		return nTm1tipeti;
	}

	public void setnTm1tipeti(Integer nTm1tipeti) {
		this.nTm1tipeti = nTm1tipeti;
	}

	public String getvUrlimagen() {
		return vUrlimagen;
	}

	public void setvUrlimagen(String vUrlimagen) {
		this.vUrlimagen = vUrlimagen;
	}

//	public LeotbcEtiqueta getLeotbcEtiqueta() {
//		return this.leotbcEtiqueta;
//	}
//
//	public void setLeotbcEtiqueta(LeotbcEtiqueta leotbcEtiqueta) {
//		this.leotbcEtiqueta = leotbcEtiqueta;
//	}

}