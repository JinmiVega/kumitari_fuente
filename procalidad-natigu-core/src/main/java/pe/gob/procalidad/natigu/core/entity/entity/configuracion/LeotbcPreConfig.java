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
	@NamedStoredProcedureQuery(name = "leotbd_preconfig.listar",
			procedureName = "conf.fun_leotbcpreconfig_buscar_todos", 
			resultClasses = LeotbcPreConfig.class, parameters = {}),
			
			@NamedStoredProcedureQuery(name = "leotbd_preconfig.buscar_por_categoria", procedureName = "conf.fun_leotbdpreconfig_buscar_x_categ", 
	 		resultClasses = LeotbcPreConfig.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2categ", type = Integer.class) }),
	 		

//
			@NamedStoredProcedureQuery(name = "leotbd_preconfig.actualizar",
			procedureName = "conf.fun_leotbcpreconfig_actualizar", 
	 		resultClasses = LeotbcPreConfig.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codconfp", type = long.class),  
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_flgbas", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_flghom", type = String.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_flgprem", type = String.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cntmone", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cntgema", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class),  
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)}), 
	
})

@Entity
@Table(name="leotbc_preconfig")
public class LeotbcPreConfig implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="n_codconfp")
	private Integer nCodconfp;
	
	@Column(name="n_tm2categ")
	private Integer nTm2categ;
	
	@Column(name="v_flgbas")
	private String vFlgbas;
	
	@Column(name="v_flghon")
	private String vFlghon;
	
	@Column(name="v_flgprem")
	private String vFlgprem;

	@Column(name="i_cntmone")
	private Integer iCntmone;
	
	@Column(name="i_cntgema")
	private Integer iCntgema;

	@Column(name="n_tm1sitcfg")
	private Integer nTm1sitcfg;
	
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
	
	@Column(name="v_nombreCategoria")
	private String vNombreCategoria;

	public Integer getnCodconfp() {
		return nCodconfp;
	}

	public void setnCodconfp(Integer nCodconfp) {
		this.nCodconfp = nCodconfp;
	}

	public Integer getnTm2categ() {
		return nTm2categ;
	}

	public void setnTm2categ(Integer nTm2categ) {
		this.nTm2categ = nTm2categ;
	}

	public String getvFlgbas() {
		return vFlgbas;
	}

	public void setvFlgbas(String vFlgbas) {
		this.vFlgbas = vFlgbas;
	}

	public String getvFlghon() {
		return vFlghon;
	}

	public void setvFlghon(String vFlghon) {
		this.vFlghon = vFlghon;
	}

	public String getvFlgprem() {
		return vFlgprem;
	}

	public void setvFlgprem(String vFlgprem) {
		this.vFlgprem = vFlgprem;
	}

	public Integer getiCntmone() {
		return iCntmone;
	}

	public void setiCntmone(Integer iCntmone) {
		this.iCntmone = iCntmone;
	}

	public Integer getiCntgema() {
		return iCntgema;
	}

	public void setiCntgema(Integer iCntgema) {
		this.iCntgema = iCntgema;
	}

	public Integer getnTm1sitcfg() {
		return nTm1sitcfg;
	}

	public void setnTm1sitcfg(Integer nTm1sitcfg) {
		this.nTm1sitcfg = nTm1sitcfg;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getvNombreCategoria()
	{
		return vNombreCategoria;
	}

	public void setvNombreCategoria(String vNombreCategoria)
	{
		this.vNombreCategoria = vNombreCategoria;
	}

	@Override
	public String toString()
	{
		return "LeotbcPreConfig [nCodconfp=" + nCodconfp + ", nTm2categ=" + nTm2categ + ", vFlgbas=" + vFlgbas
				+ ", vFlghon=" + vFlghon + ", vFlgprem=" + vFlgprem + ", iCntmone=" + iCntmone + ", iCntgema="
				+ iCntgema + ", nTm1sitcfg=" + nTm1sitcfg + ", vFlgest=" + vFlgest + ", nCodusureg=" + nCodusureg
				+ ", dFecreg=" + dFecreg + ", vHostreg=" + vHostreg + ", nCodusumod=" + nCodusumod + ", dFecmod="
				+ dFecmod + ", vHostmod=" + vHostmod + ", vNombreCategoria=" + vNombreCategoria + "]";
	}	

}
