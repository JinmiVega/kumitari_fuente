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

import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionSedeBean;
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbdinstsede.insertar", 
			procedureName = "gene.fun_leotbdinstsede_insertar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codsede", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomsede", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telefono", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_dirinstit", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_contacto", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codubigeo", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)

			}),
			@NamedStoredProcedureQuery(name = "leotbdinstsede.listar", 
			procedureName = "gene.fun_leotbdinstsede_listar",
			resultClasses = LeotbdInstSede.class,
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = int.class)
			}),
			@NamedStoredProcedureQuery(name = "leotbdinstsede.listar_x_codigo", 
			procedureName = "gene.fun_leotbdinstsede_listar_x_codigo",
			resultClasses = LeotbdInstSede.class,
			parameters = {	
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codsede", type = long.class)
			}),
			@NamedStoredProcedureQuery(name = "leotbdinstsede.eliminar", 
			procedureName = "gene.fun_leotbdinstsede_eliminar",
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codsede", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			}),
			@NamedStoredProcedureQuery(name = "leotbdinstsede.actualizar", 
			procedureName = "gene.fun_leotbdinstsede_actualizar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codsede", type = long.class),		
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomsede", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telefono", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_dirinstit", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_contacto", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codubigeo", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)

			})
})
@Entity
@Table(name = "leotbd_instsede",schema="gene")
public class LeotbdInstSede implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "n_codsede")
	private int nCodsede;
	
	@Column(name = "n_codisnti")
	private int nCodisnti;
	
	@Column(name = "v_nomsede")
	private String vNomsede;
	
	@Column(name = "n_codregion")
	private String nCodregion;
	
	@Column(name = "n_codprovin")
	private String nCodprovin;
	
	@Column(name = "n_coddistri")
	private String nCoddistri;
	
	@Column(name = "v_dirinstit")
	private String vDirinstit;
	
	@Column(name = "n_tm1sitsed")
	private int nTm1sitsed;
	
	@Column(name = "v_contacto")
	private String vContacto;
	
	@Column(name = "v_telefono")
	private String vTelefono;
	
	@Column(name = "v_correo")
	private String vCorreo;
	
	@Column(name = "v_flgest")
	private String vFlgest;
	
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
  
	@Column(name = "n_codubigeo")
	private String nCodubigeo;
	
	@Column(name = "n_desregion")
	private String nDesregion;
	@Column(name = "n_desprovin")
	private String nDesprovin;
	@Column(name = "n_desdistri")
	private String nDesdistri;
	
	public LeotbdInstSede() {
		super();
	}


	public int getnCodsede() {
		return nCodsede;
	}


	public void setnCodsede(int nCodsede) {
		this.nCodsede = nCodsede;
	}


	public int getnCodisnti() {
		return nCodisnti;
	}


	public void setnCodisnti(int nCodisnti) {
		this.nCodisnti = nCodisnti;
	}


	public String getvNomsede() {
		return vNomsede;
	}


	public void setvNomsede(String vNomsede) {
		this.vNomsede = vNomsede;
	}


	public String getnCodregion() {
		return nCodregion;
	}


	public void setnCodregion(String nCodregion) {
		this.nCodregion = nCodregion;
	}


	public String getnCodprovin() {
		return nCodprovin;
	}


	public void setnCodprovin(String nCodprovin) {
		this.nCodprovin = nCodprovin;
	}


	public String getnCoddistri() {
		return nCoddistri;
	}


	public void setnCoddistri(String nCoddistri) {
		this.nCoddistri = nCoddistri;
	}


	public String getvDirinstit() {
		return vDirinstit;
	}


	public void setvDirinstit(String vDirinstit) {
		this.vDirinstit = vDirinstit;
	}


	public int getnTm1sitsed() {
		return nTm1sitsed;
	}


	public void setnTm1sitsed(int nTm1sitsed) {
		this.nTm1sitsed = nTm1sitsed;
	}


	public String getvContacto() {
		return vContacto;
	}


	public void setvContacto(String vContacto) {
		this.vContacto = vContacto;
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


	public String getvFlgest() {
		return vFlgest;
	}


	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
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


	public String getnCodubigeo() {
		return nCodubigeo;
	}


	public void setnCodubigeo(String nCodubigeo) {
		this.nCodubigeo = nCodubigeo;
	}


	public String getnDesregion() {
		return nDesregion;
	}


	public void setnDesregion(String nDesregion) {
		this.nDesregion = nDesregion;
	}


	public String getnDesprovin() {
		return nDesprovin;
	}


	public void setnDesprovin(String nDesprovin) {
		this.nDesprovin = nDesprovin;
	}


	public String getnDesdistri() {
		return nDesdistri;
	}


	public void setnDesdistri(String nDesdistri) {
		this.nDesdistri = nDesdistri;
	}


	@Override
	public String toString() {
		return "LeotbdInstSede [nCodsede=" + nCodsede + ", nCodisnti=" + nCodisnti + ", vNomsede=" + vNomsede
				+ ", nCodregion=" + nCodregion + ", nCodprovin=" + nCodprovin + ", nCoddistri=" + nCoddistri
				+ ", vDirinstit=" + vDirinstit + ", nTm1sitsed=" + nTm1sitsed + ", vContacto=" + vContacto
				+ ", vTelefono=" + vTelefono + ", vCorreo=" + vCorreo + ", vFlgest=" + vFlgest + ", nCodusureg="
				+ nCodusureg + ", dFecreg=" + dFecreg + ", vHostreg=" + vHostreg + ", nCodusumod=" + nCodusumod
				+ ", dFecmod=" + dFecmod + ", vHostmod=" + vHostmod + ", nCodubigeo=" + nCodubigeo + ", nDesregion="
				+ nDesregion + ", nDesprovin=" + nDesprovin + ", nDesdistri=" + nDesdistri + "]";
	}


}
