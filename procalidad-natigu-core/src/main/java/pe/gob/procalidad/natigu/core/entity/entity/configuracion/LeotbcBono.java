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

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbc_bono.buscarPorCodigo",
	procedureName = "conf.fun_leotbcbono_buscar_x_codigo", 
	resultClasses = LeotbcBono.class, 
	parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codbono", type = Long.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_bono.listar",
	procedureName = "conf.fun_leotbc_bono_buscar_filtros", 
	resultClasses = LeotbcBono.class, parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombono", type = String.class), 
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpbono", type = Integer.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitbono", type = Integer.class)}),
	
	@NamedStoredProcedureQuery(name = "leotbc_bono.insertar", procedureName = "conf.fun_leotbc_bono_insertar", 
	resultClasses = LeotbcBono.class, parameters = {
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codbono", type = Integer.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombono", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desbono", type = String.class), 
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpbono", type = Integer.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitbono", type = Integer.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Integer.class),  
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2tpejer", type = Integer.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tiempo", type = String.class)}),
	
	@NamedStoredProcedureQuery(name = "leotbc_bono.actualizar", procedureName = "conf.fun_leotbc_bono_actualizar", 
		resultClasses = LeotbcBono.class, parameters = { 
		
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = Integer.class), 
	 	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codbono", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombono", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desbono", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitbono", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tiempo", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2tpejer", type = Integer.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Integer.class)}),
	
	@NamedStoredProcedureQuery(name = "leotbc_bono.eliminar",
	procedureName = "conf.fun_leotbcbono_eliminar", 
	parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codbono", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
	})
})

@Entity
@Table(name="leotbc_bono")
public class LeotbcBono implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="n_codbono")
	private Long nCodbono;
	
	@Column(name="v_nombono")
	private String vNombono;

	@Column(name="v_desbono")
	private String vDesbono;

	@Column(name="n_tm1tpbono")
	private Integer nTm1tpbono;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="n_tm1sitbono")
	private Integer nTm1sitbono;
	
	@Column(name="v_tiempo")
	private String vTiempo;
	
	@Column(name="n_tm2tpejer")
	private Integer nTm2tpejer;
		
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;
		
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	
	@Column(name="v_codusureg")
	private Long vCodusureg;
	
	@Column(name="n_codusumod")
	private Long ncodusumod;
	
	@Column(name="v_hostreg")
	private String vHostreg;
	
	private String v_nomcortoTipo; 
	private String v_nomcortoSitu; 

	public LeotbcBono() {
		super();
	}

	public Long getnCodbono() {
		return nCodbono;
	}

	public void setnCodbono(Long nCodbono) {
		this.nCodbono = nCodbono;
	}

	public String getvNombono() {
		return vNombono;
	}

	public void setvNombono(String vNombono) {
		this.vNombono = vNombono;
	}

	public String getvDesbono() {
		return vDesbono;
	}

	public void setvDesbono(String vDesbono) {
		this.vDesbono = vDesbono;
	}

 

	public Integer getnTm1tpbono() {
		return nTm1tpbono;
	}

	public void setnTm1tpbono(Integer nTm1tpbono) {
		this.nTm1tpbono = nTm1tpbono;
	}

	public Integer getnTm1sitbono() {
		return nTm1sitbono;
	}

	public void setnTm1sitbono(Integer nTm1sitbono) {
		this.nTm1sitbono = nTm1sitbono;
	}

	public Integer getnTm2tpejer() {
		return nTm2tpejer;
	}

	public void setnTm2tpejer(Integer nTm2tpejer) {
		this.nTm2tpejer = nTm2tpejer;
	}

	public String getvFlgest() {
		return vFlgest;
	}

	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}

 

	public String getvTiempo() {
		return vTiempo;
	}

	public void setvTiempo(String vTiempo) {
		this.vTiempo = vTiempo;
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

	public Long getvCodusureg() {
		return vCodusureg;
	}

	public void setvCodusureg(Long vCodusureg) {
		this.vCodusureg = vCodusureg;
	}

	public Long getNcodusumod() {
		return ncodusumod;
	}

	public void setNcodusumod(Long ncodusumod) {
		this.ncodusumod = ncodusumod;
	}

	public String getvHostreg() {
		return vHostreg;
	}

	public void setvHostreg(String vHostreg) {
		this.vHostreg = vHostreg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getV_nomcortoTipo() {
		return v_nomcortoTipo;
	}

	public void setV_nomcortoTipo(String v_nomcortoTipo) {
		this.v_nomcortoTipo = v_nomcortoTipo;
	}

	public String getV_nomcortoSitu() {
		return v_nomcortoSitu;
	}

	public void setV_nomcortoSitu(String v_nomcortoSitu) {
		this.v_nomcortoSitu = v_nomcortoSitu;
	}

}
