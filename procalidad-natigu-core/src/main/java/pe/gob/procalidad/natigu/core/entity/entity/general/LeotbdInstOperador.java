package pe.gob.procalidad.natigu.core.entity.entity.general;

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
	@NamedStoredProcedureQuery(name = "leotbdinstoperador.insertar", 
			procedureName = "gene.fun_leotbdinstoperador_insertar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codopera", type = Number.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitope", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
			}),
	@NamedStoredProcedureQuery(name = "leotbdinstoperador.actualizar", 
			procedureName = "gene.fun_leotbdinstoperador_actualizar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codopera", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitope", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			}),
	@NamedStoredProcedureQuery(name = "leotbdinstoperador.eliminar", 
			procedureName = "gene.fun_leotbdinstoperador_eliminar",
			parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codopera", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)		
			}),
	@NamedStoredProcedureQuery(name = "leotbdinstoperador.buscarPorCodigo", 
			procedureName = "gene.fun_leotbdinstoperador_buscar_x_codigo", 
			resultClasses = LeotbdInstOperador.class, 
			parameters = {			
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codopera", type = int.class)
			}),
	@NamedStoredProcedureQuery(name = "leotbdinstoperador.listar", 
			procedureName = "gene.fun_leotbdinstoperador_listar",
			resultClasses = LeotbdInstOperador.class,
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = long.class)
			})
})
@Entity
@Table(name = "leotbd_instoperador",schema="gene")
public class LeotbdInstOperador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "n_codopera")
	private int nCodopera;
	
	@Column(name = "n_codperso")
	private int nCodperso;
	
	@Column(name = "n_codisnti")
	private int nCodinsti;
	
	@Column(name = "n_tm1sitope")
	private int nTm1sitope;
	
	@Column(name = "n_codusureg")
	private int nCodusureg;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecreg;
	
	@Column(name = "v_hostreg")
	private String vHostreg;
	
	@Column(name = "n_codusumod")
	private int nCodusumod;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dFecmod;
	
	@Column(name = "v_hostmod")
	private String vHostmod;
	
	/** DATOS ADICIONALES LISTADO **/
	@Column(name = "v_nombre_situacion")
	private String vNomSituacion;
	
	@Column(name = "v_nombreper")
	private String vNombrePer;
	
	@Column(name = "v_apepatper")
	private String vApePatPer;
	
	@Column(name = "v_apematper")
	private String vApeMatPer;
	
	@Column(name = "n_tm1tpdope")
	private int nTm1TpDoPe;
	
	@Column(name = "v_numdocum")
	private String vNumDocum;
	
	@Column(name = "v_telefono")
	private String vTelefono;
	
	@Column(name = "v_correo")
	private String vCorreo;
	
	@Column(name = "nombrecargo")
	private String nombreCargo;

	public LeotbdInstOperador() {
		super();
	}

	public int getnCodopera() {
		return nCodopera;
	}

	public void setnCodopera(int nCodopera) {
		this.nCodopera = nCodopera;
	}

	public int getnCodperso() {
		return nCodperso;
	}

	public void setnCodperso(int nCodperso) {
		this.nCodperso = nCodperso;
	}

	public int getnCodinsti() {
		return nCodinsti;
	}

	public void setnCodinsti(int nCodinsti) {
		this.nCodinsti = nCodinsti;
	}

	public int getnTm1sitope() {
		return nTm1sitope;
	}

	public void setnTm1sitope(int nTm1sitope) {
		this.nTm1sitope = nTm1sitope;
	}

	public int getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(int nCodusureg) {
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

	public int getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(int nCodusumod) {
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

	public String getvNomSituacion() {
		return vNomSituacion;
	}

	public void setvNomSituacion(String vNomSituacion) {
		this.vNomSituacion = vNomSituacion;
	}

	public String getvNombrePer() {
		return vNombrePer;
	}

	public void setvNombrePer(String vNombrePer) {
		this.vNombrePer = vNombrePer;
	}

	public String getvApePatPer() {
		return vApePatPer;
	}

	public void setvApePatPer(String vApePatPer) {
		this.vApePatPer = vApePatPer;
	}

	public String getvApeMatPer() {
		return vApeMatPer;
	}

	public void setvApeMatPer(String vApeMatPer) {
		this.vApeMatPer = vApeMatPer;
	}

	public int getnTm1TpDoPe() {
		return nTm1TpDoPe;
	}

	public void setnTm1TpDoPe(int nTm1TpDoPe) {
		this.nTm1TpDoPe = nTm1TpDoPe;
	}

	public String getvNumDocum() {
		return vNumDocum;
	}

	public void setvNumDocum(String vNumDocum) {
		this.vNumDocum = vNumDocum;
	}

	public String getvTelefono() {
		return vTelefono;
	}

	public void setvTelefono(String vTelefono) {
		this.vTelefono = vTelefono;
	}

	public String getvCorreo() {
		return vCorreo;
	}

	public void setvCorreo(String vCorreo) {
		this.vCorreo = vCorreo;
	}

	public String getNombreCargo() {
		return nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}

	@Override
	public String toString() {
		return "LeotbdInstOperador [nCodopera=" + nCodopera + ", nCodperso="
				+ nCodperso + ", nCodinsti=" + nCodinsti + ", nTm1sitope="
				+ nTm1sitope + ", nCodusureg=" + nCodusureg + ", dFecreg="
				+ dFecreg + ", vHostreg=" + vHostreg + ", nCodusumod="
				+ nCodusumod + ", dFecmod=" + dFecmod + ", vHostmod="
				+ vHostmod + ", vNomSituacion=" + vNomSituacion
				+ ", vNombrePer=" + vNombrePer + ", vApePatPer=" + vApePatPer
				+ ", vApeMatPer=" + vApeMatPer + ", nTm1TpDoPe=" + nTm1TpDoPe
				+ ", vNumDocum=" + vNumDocum + ", vTelefono=" + vTelefono
				+ ", vCorreo=" + vCorreo + ", nombreCargo=" + nombreCargo + "]";
	}
	
	
	
}