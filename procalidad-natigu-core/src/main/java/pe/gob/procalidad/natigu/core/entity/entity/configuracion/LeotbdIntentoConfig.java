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
	@NamedStoredProcedureQuery(name = "leotbd_intentoconfig.listar",
			procedureName = "conf.fun_leotbcintentconf_buscar_todos", 
			resultClasses = LeotbdIntentoConfig.class, parameters = {}),

//
			@NamedStoredProcedureQuery(name = "leotbd_intentoconfig.buscar_por_codigo", procedureName = "conf.fun_leotbdintento_buscar_x_codigo", 
	 		resultClasses = LeotbdIntentoConfig.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2ejercicio", type = long.class) }), 
	 		
			@NamedStoredProcedureQuery(name = "leotbd_intentoconfig.actualizar",
			procedureName = "conf.fun_leotbcintconf_actualizar", 
	 		resultClasses = LeotbdIntentoConfig.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codconf", type = long.class),  
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_int1", type = int.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_int2", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_int3", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class),  
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)}), 
	
})

@Entity
@Table(name="leotbd_intentconf")
public class LeotbdIntentoConfig implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="n_codconf")
	private Integer nCodconf;
	
	@Column(name="n_tm2ejercicio")
	private Integer nTm2ejercicio;
	
	 

	@Column(name="i_int1")
	private Integer iInt1;
	
	@Column(name="i_int2")
	private Integer iInt2;
	
	@Column(name="i_int3")
	private Integer iInt3;

	 
	
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
	
	@Column(name="v_nombreEjercicio")
	private String vNombreEjercicio;
	
	@Column(name="v_descripcion")
	private String vDescripcion;

	public Integer getnCodconf() {
		return nCodconf;
	}

	public void setnCodconf(Integer nCodconf) {
		this.nCodconf = nCodconf;
	}

	public Integer getnTm2ejercicio() {
		return nTm2ejercicio;
	}

	public void setnTm2ejercicio(Integer nTm2ejercicio) {
		this.nTm2ejercicio = nTm2ejercicio;
	}

	public Integer getiInt1() {
		return iInt1;
	}

	public void setiInt1(Integer iInt1) {
		this.iInt1 = iInt1;
	}

	public Integer getiInt2() {
		return iInt2;
	}

	public void setiInt2(Integer iInt2) {
		this.iInt2 = iInt2;
	}

	public Integer getiInt3() {
		return iInt3;
	}

	public void setiInt3(Integer iInt3) {
		this.iInt3 = iInt3;
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

 

	public String getvDescripcion() {
		return vDescripcion;
	}

	public void setvDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

	public String getvNombreEjercicio() {
		return vNombreEjercicio;
	}

	public void setvNombreEjercicio(String vNombreEjercicio) {
		this.vNombreEjercicio = vNombreEjercicio;
	}

	@Override
	public String toString() {
		return "LeotbdIntentoConfig [nCodconf=" + nCodconf + ", nTm2ejercicio="
				+ nTm2ejercicio + ", iInt1=" + iInt1 + ", iInt2=" + iInt2
				+ ", iInt3=" + iInt3 + ", vFlgest=" + vFlgest + ", nCodusureg="
				+ nCodusureg + ", dFecreg=" + dFecreg + ", vHostreg="
				+ vHostreg + ", nCodusumod=" + nCodusumod + ", dFecmod="
				+ dFecmod + ", vHostmod=" + vHostmod + ", vNombreEjercicio="
				+ vNombreEjercicio + ", vDescripcion=" + vDescripcion + "]";
	}

	 
	 

}
