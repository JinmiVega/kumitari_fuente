package pe.gob.procalidad.natigu.core.entity.entity.configuracion;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@NamedStoredProcedureQueries({
			@NamedStoredProcedureQuery(name = "leotbc_slider.listar",
			procedureName = "conf.fun_leotbcslider_buscar_x_filtros", 
			resultClasses = LeotbcSlider.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomslide", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitsli", type = Integer.class)}),
			
			@NamedStoredProcedureQuery(name = "leotbcSlider.insertar", 
			procedureName = "conf.fun_leotbcslider_insertar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codslide", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomslide", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desslide", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitsli", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class) 
	 		
			}),
//
			@NamedStoredProcedureQuery(name = "leotbcSlider.actualizar", procedureName = "conf.fun_leotbcslider_actualizar", 
	 		resultClasses = LeotbcSlider.class, parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = Integer.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codslide", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomslide", type = String.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desslide", type = String.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitsli", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)}), 
	
			@NamedStoredProcedureQuery(name = "leotbcSlider.eliminar", procedureName = "conf.fun_leotbcslider_eliminar", 
	 		resultClasses = LeotbcSlider.class, parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = Integer.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codslide", type = long.class),  
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)}), 
//	 
			@NamedStoredProcedureQuery(name = "leotbcSlider.buscar_por_codigo", procedureName = "conf.fun_leotbcslider_buscar_x_codigo", 
			resultClasses = LeotbcSlider.class, parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codslide", type = long.class)}), 
	})

/**
 * The persistent class for the leotbc_slider database table.
 * 
 */
@Entity
@Table(name="leotbc_slider",schema="conf")
//@NamedQuery(name="LeotbcSlider.findAll", query="SELECT l FROM LeotbcSlider l")
public class LeotbcSlider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codslide")
	private Integer nCodslide;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	 
	@Column(name="n_codusumod")
	private Integer nCodusumod;

	@Column(name="n_codusureg")
	private Integer nCodusureg;
 
	@Column(name="n_tm1sitsli")
	private Integer nTm1sitsli;
	
	@Column(name="v_desslide")
	private String vDesslide;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;
	 
	@Column(name="v_nomslide")
	private String vNomslide;
	
	private String v_nomcortoSituacion;

	public LeotbcSlider() {
	//	super();
	}

	public Integer getnCodslide() {
		return nCodslide;
	}

	public void setnCodslide(Integer nCodslide) {
		this.nCodslide = nCodslide;
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

	public Integer getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(Integer nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public Integer getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(Integer nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public Integer getnTm1sitsli() {
		return nTm1sitsli;
	}

	public void setnTm1sitsli(Integer nTm1sitsli) {
		this.nTm1sitsli = nTm1sitsli;
	}

	public String getvDesslide() {
		return vDesslide;
	}

	public void setvDesslide(String vDesslide) {
		this.vDesslide = vDesslide;
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

	public String getvNomslide() {
		return vNomslide;
	}

	public void setvNomslide(String vNomslide) {
		this.vNomslide = vNomslide;
	}

	public String getV_nomcortoSituacion() {
		return v_nomcortoSituacion;
	}

	public void setV_nomcortoSituacion(String v_nomcortoSituacion) {
		this.v_nomcortoSituacion = v_nomcortoSituacion;
	}

}