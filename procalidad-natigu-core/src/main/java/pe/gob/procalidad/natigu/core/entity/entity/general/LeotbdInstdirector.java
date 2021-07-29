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

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionDirectorBean;
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbdinstdirector.insertar", 
			procedureName = "gene.fun_leotbdinstdirector_insertar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_coddirec", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitdir", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_urlwebins", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telefono", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_descrip", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)

			}),
			@NamedStoredProcedureQuery(name = "leotbdinstdirector.listarPorCodigoInstitucion", 
			procedureName = "gene.fun_leotbdinstdirector_listar_por_codigo_institucion",
			resultClasses = LeotbdInstdirector.class,
			parameters = {

			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = long.class)


			}),
			@NamedStoredProcedureQuery(name = "leotbdinstdirector.eliminar", 
			procedureName = "gene.fun_leotbdinstdirector_eliminar",
			parameters = {

			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddirec", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)

			}),
			@NamedStoredProcedureQuery(name = "leotbdinstdirector.actulizar", 
			procedureName = "gene.fun_leotbdinstdirector_actualizar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddirec", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitdir", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_urlwebins", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telefono", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_descrip", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)

			}),
			@NamedStoredProcedureQuery(name = "leotbdinstdirector.buscarPorCodigoDirector", 
			procedureName = "gene.fun_leotbdinstdirector_buscar_x_codigo", 
			resultClasses = LeotbdInstdirector.class,
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddirec", type = long.class)

			})
	
	
})
@Entity
@Table(name = "leotbd_instdirector",schema="gene")
public class LeotbdInstdirector implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "n_coddirec")
	private int nCoddirec;
	
	@Column(name = "n_codperso")
	private int nCodperso;
	
	@Column(name = "n_codisnti")
	private int nCodisnti;
	
	@Column(name = "n_tm1sitdir")
	private int nTm1sitdir;
	
	@Column(name = "v_urlwebins")
	private String vUrlwebins;
	
	@Column(name = "v_telefono")
	private String vTelefono;
	
	@Column(name = "v_correo")
	private String vCorreo;
	
	@Column(name = "v_descrip")
	private String vDescrip;
	
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
	
	@Column(name = "v_apepatper")
	private String vApepatper;
	
	@Column(name = "v_apematper")
	private String vApematper;
  
	@Column(name = "v_nombreper")
	private String vNombreper;
  

	public LeotbdInstdirector() {
		super();
	}

	public int getnCoddirec() {
		return nCoddirec;
	}

	public void setnCoddirec(int nCoddirec) {
		this.nCoddirec = nCoddirec;
	}

	public int getnCodperso() {
		return nCodperso;
	}

	public void setnCodperso(int nCodperso) {
		this.nCodperso = nCodperso;
	}

	public int getnCodisnti() {
		return nCodisnti;
	}

	public void setnCodisnti(int nCodisnti) {
		this.nCodisnti = nCodisnti;
	}

	public int getnTm1sitdir() {
		return nTm1sitdir;
	}

	public void setnTm1sitdir(int nTm1sitdir) {
		this.nTm1sitdir = nTm1sitdir;
	}

	public String getvUrlwebins() {
		return vUrlwebins;
	}

	public void setvUrlwebins(String vUrlwebins) {
		this.vUrlwebins = vUrlwebins;
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

	public String getvDescrip() {
		return vDescrip;
	}

	public void setvDescrip(String vDescrip) {
		this.vDescrip = vDescrip;
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
	
	public String getvApepatper() {
		return vApepatper;
	}

	public void setvApepatper(String vApepatper) {
		this.vApepatper = vApepatper;
	}

	public String getvApematper() {
		return vApematper;
	}

	public void setvApematper(String vApematper) {
		this.vApematper = vApematper;
	}

	public String getvNombreper() {
		return vNombreper;
	}

	public void setvNombreper(String vNombreper) {
		this.vNombreper = vNombreper;
	}

	@Override
	public String toString() {
		return "LeotbdInstdirector [nCoddirec=" + nCoddirec + ", nCodperso="
				+ nCodperso + ", nCodisnti=" + nCodisnti + ", nTm1sitdir="
				+ nTm1sitdir + ", vUrlwebins=" + vUrlwebins + ", vTelefono="
				+ vTelefono + ", vCorreo=" + vCorreo + ", vDescrip=" + vDescrip
				+ ", nCodusureg=" + nCodusureg + ", dFecreg=" + dFecreg
				+ ", vHostreg=" + vHostreg + ", nCodusumod=" + nCodusumod
				+ ", dFecmod=" + dFecmod + ", vHostmod=" + vHostmod + "]";
	}

	
}
