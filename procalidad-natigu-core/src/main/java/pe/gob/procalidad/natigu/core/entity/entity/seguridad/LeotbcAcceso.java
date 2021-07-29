package pe.gob.procalidad.natigu.core.entity.entity.seguridad;

import java.io.Serializable;

import javax.persistence.*;


import java.util.Date;

@NamedStoredProcedureQueries({	
	@NamedStoredProcedureQuery(name = "leotbc_acceso.insertar", 
		procedureName = "segu.fun_leotbcacceso_insertar", 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codacceso", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codperfil", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codcompo", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgasi", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusureg", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostreg", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgread", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgwrite", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgdelete", type = String.class)
		}),
		
	@NamedStoredProcedureQuery(name = "leotbc_acceso.actualizar", 
	procedureName = "segu.fun_leotbcacceso_actualizar", 
	resultClasses = LeotbcAcceso.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codacceso", type = Number.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgasi", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostmod", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgread", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgwrite", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgdelete", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_acceso.eliminar", 
	procedureName = "segu.fun_leotbcacceso_eliminar", 
	resultClasses = LeotbcAcceso.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codacceso", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostmod", type = String.class)
	}),
	/*@NamedStoredProcedureQuery(name = "leotbc_acceso.listar", 
	procedureName = "segu.fun_leotbcacceso_listar", 
	resultClasses = LeotbcAcceso.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomperfil", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codperfil", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_tm1sitprf", type = Integer.class)
	}),*/
	@NamedStoredProcedureQuery(name = "leotbc_acceso.listar", 
		procedureName = "segu.fun_leotbcacceso_listar", 
		resultClasses = LeotbcAcceso.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperfil", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codcompadre", type = int.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_acceso.asignar", 
		procedureName = "segu.fun_leotbcacceso_asignar", 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.INOUT, name = "p_codacceso", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgasi", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgread", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgwrite", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgdelete", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgexport", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codperfil", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codcompo", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusu", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_host", type = String.class)
	})
		
})

@Entity
@Table(name="leotbc_acceso", schema="segu")
public class LeotbcAcceso implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_item")
	private Integer nItem;
	
	@Column(name="n_codacceso")
	private Long nCodacceso;

	@Column(name="n_codcompo")
	private Long nCodcompo;

	@Column(name="n_codperfil")
	private Long nCodperfil;

	@Column(name="v_flgasi")
	private String vFlgasi;

	@Column(name="v_flgread")
	private String vFlgread;
	
	@Column(name="v_flgwrite")
	private String vFlgwrite;
	
	@Column(name="v_flgdelete")
	private String vFlgdelete;
	
	@Column(name="v_flgexport")
	private String vFlgexport;
	
	@Column(name="v_flgest")
	private String vFlgest;
	
	@Column(name="n_codusureg")
	private Long nCodusureg;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="v_hostreg")
	private String vHostreg;
	
	@Column(name="n_codusumod")
	private Long nCodusumod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Column(name="v_hostmod")
	private String vHostmod;

	
	@Column(name="v_nomcompo")
	private String vNomcompo;
	
	@Column(name="v_descompo")
	private String vDescompo;
	
	@Column(name="n_codcompa")
	private Long nCodcompa;
	
	public LeotbcAcceso() {
	
	}

	public Integer getnItem() {
		return nItem;
	}

	public void setnItem(Integer nItem) {
		this.nItem = nItem;
	}

	public Long getnCodacceso() {
		return nCodacceso;
	}

	public void setnCodacceso(Long nCodacceso) {
		this.nCodacceso = nCodacceso;
	}

	public Long getnCodcompo() {
		return nCodcompo;
	}

	public void setnCodcompo(Long nCodcompo) {
		this.nCodcompo = nCodcompo;
	}

	public Long getnCodperfil() {
		return nCodperfil;
	}

	public void setnCodperfil(Long nCodperfil) {
		this.nCodperfil = nCodperfil;
	}

	public String getvFlgasi() {
		return vFlgasi;
	}

	public void setvFlgasi(String vFlgasi) {
		this.vFlgasi = vFlgasi;
	}

	public String getvFlgread() {
		return vFlgread;
	}

	public void setvFlgread(String vFlgread) {
		this.vFlgread = vFlgread;
	}

	public String getvFlgwrite() {
		return vFlgwrite;
	}

	public void setvFlgwrite(String vFlgwrite) {
		this.vFlgwrite = vFlgwrite;
	}

	public String getvFlgdelete() {
		return vFlgdelete;
	}

	public void setvFlgdelete(String vFlgdelete) {
		this.vFlgdelete = vFlgdelete;
	}

	public String getvFlgexport() {
		return vFlgexport;
	}

	public void setvFlgexport(String vFlgexport) {
		this.vFlgexport = vFlgexport;
	}

	public String getvFlgest() {
		return vFlgest;
	}

	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}

	public Long getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(Long nCodusureg) {
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

	public Long getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(Long nCodusumod) {
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

	public String getvNomcompo() {
		return vNomcompo;
	}

	public void setvNomcompo(String vNomcompo) {
		this.vNomcompo = vNomcompo;
	}

	public String getvDescompo() {
		return vDescompo;
	}

	public void setvDescompo(String vDescompo) {
		this.vDescompo = vDescompo;
	}

	public Long getnCodcompa() {
		return nCodcompa;
	}

	public void setnCodcompa(Long nCodcompa) {
		this.nCodcompa = nCodcompa;
	}
	
}