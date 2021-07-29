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
	
	@NamedStoredProcedureQuery(name = "leotbcpersona.buscar_x_tipodocumento_numero_documento", procedureName = "gene.fun_leotbcpersona_buscar_x_documento_numero_documento", 
			resultClasses = LeotbcPersona.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpdope", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numdocum", type = String.class)}),

	@NamedStoredProcedureQuery(name = "leotbcpersona.insertar", procedureName = "gene.fun_leotbcpersona_insertar", 
			resultClasses = LeotbcPersona.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codperso", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_apepatper", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_apematper", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombreper", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpdope", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numdocum", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tipper", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codubigeo", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_direcpers", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitper", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fechnacim", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2pais", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2estciv", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2sexo", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telefono", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
			}),
	
	
	@NamedStoredProcedureQuery(name = "leotbcpersona.actualizar", procedureName = "gene.fun_leotbcpersona_actualizar", 
	resultClasses = LeotbcPersona.class, parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_apepatper", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_apematper", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombreper", type = String.class),
	
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpdope", type = int.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numdocum", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codubigeo", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_direcpers", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitper", type = int.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fechnacim", type = Date.class),
	
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2pais", type = int.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2estciv", type = int.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2sexo", type = int.class),
	
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telefono", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
	}),
	
	@NamedStoredProcedureQuery(name = "leotbcpersona.actualizaruser", 
	procedureName = "gene.fun_leotbcpersona_actualizar_datosuser",  
	parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telefono", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
	}),
	
	@NamedStoredProcedureQuery(name = "leotbcpersona.actualizarfotouser", 
	procedureName = "gene.fun_leotbcpersona_actualizar_datosfotouser", 
	parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombfotop", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
	})
	
	
	
	
	
	


	

})




@Entity
@Table(name = "leotbc_persona")
public class LeotbcPersona implements Serializable {

	
	@Id
	@Column(name = "n_codperso")
	private long nCodPerso;
	
	@Column(name = "v_apepatper")
	private String vApePatPer;
	
	@Column(name = "v_apematper")
	private String vApeMatPer;
	
	@Column(name = "v_nombreper")
	private String vNombrePer;
	
	@Column(name = "n_tm1tpdope")
	private int nTm1TpDoPe;
	
	@Column(name = "v_numdocum")
	private String vNumDocum;
 
	@Column(name = "n_tm1tipper")
	private int nTm1TipPer;
	
	@Column(name = "v_codubigeo")
	private String vCodUbigeo;
	
	@Column(name = "v_direcpers")
	private String vDirecPers;
	
	@Column(name = "n_tm1sitper")
	private int nTm1SitPer;
   
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fechnacim")
	private Date dFechNacim;
	
	@Column(name = "n_tm2pais")
	private int nTm2Pais;
	
	@Column(name = "n_tm2estciv")
	private int nTm2EstCiv;
	
	@Column(name = "n_tm2sexo")
	private int nTm2Sexo;
	
	@Column(name = "v_codlengua")
	private long vCodLengua;
	
	@Column(name = "v_telefono")
	private String vTelefono;
	
	@Column(name = "v_correo")
	private String vCorreo;
	
	@Column(name = "v_flgest")
	private String vFlgEst;
	
	@Column(name = "n_codusureg")
	private long nCodUsuReg;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecReg;
	
	@Column(name = "v_hostreg")
	private String vHostReg;
	
	
	@Column(name = "n_codusumod")
	private long nCodUsuMod;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dFecMod;
	
	@Column(name = "v_hostmod")
	private String vHostMod;

	public long getnCodPerso() {
		return nCodPerso;
	}

	public void setnCodPerso(long nCodPerso) {
		this.nCodPerso = nCodPerso;
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

	public String getvNombrePer() {
		return vNombrePer;
	}

	public void setvNombrePer(String vNombrePer) {
		this.vNombrePer = vNombrePer;
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

	public int getnTm1TipPer() {
		return nTm1TipPer;
	}

	public void setnTm1TipPer(int nTm1TipPer) {
		this.nTm1TipPer = nTm1TipPer;
	}

	

	public String getvCodUbigeo() {
		return vCodUbigeo;
	}

	public void setvCodUbigeo(String vCodUbigeo) {
		this.vCodUbigeo = vCodUbigeo;
	}

	public String getvDirecPers() {
		return vDirecPers;
	}

	public void setvDirecPers(String vDirecPers) {
		this.vDirecPers = vDirecPers;
	}

	public int getnTm1SitPer() {
		return nTm1SitPer;
	}

	public void setnTm1SitPer(int nTm1SitPer) {
		this.nTm1SitPer = nTm1SitPer;
	}

	public Date getdFechNacim() {
		return dFechNacim;
	}

	public void setdFechNacim(Date dFechNacim) {
		this.dFechNacim = dFechNacim;
	}

	public int getnTm2Pais() {
		return nTm2Pais;
	}

	public void setnTm2Pais(int nTm2Pais) {
		this.nTm2Pais = nTm2Pais;
	}

	public int getnTm2EstCiv() {
		return nTm2EstCiv;
	}

	public void setnTm2EstCiv(int nTm2EstCiv) {
		this.nTm2EstCiv = nTm2EstCiv;
	}

	public int getnTm2Sexo() {
		return nTm2Sexo;
	}

	public void setnTm2Sexo(int nTm2Sexo) {
		this.nTm2Sexo = nTm2Sexo;
	}

	public long getvCodLengua() {
		return vCodLengua;
	}

	public void setvCodLengua(long vCodLengua) {
		this.vCodLengua = vCodLengua;
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

	public String getvFlgEst() {
		return vFlgEst;
	}

	public void setvFlgEst(String vFlgEst) {
		this.vFlgEst = vFlgEst;
	}

	public long getnCodUsuReg() {
		return nCodUsuReg;
	}

	public void setnCodUsuReg(long nCodUsuReg) {
		this.nCodUsuReg = nCodUsuReg;
	}

	public Date getdFecReg() {
		return dFecReg;
	}

	public void setdFecReg(Date dFecReg) {
		this.dFecReg = dFecReg;
	}

	public String getvHostReg() {
		return vHostReg;
	}

	public void setvHostReg(String vHostReg) {
		this.vHostReg = vHostReg;
	}

	public long getnCodUsuMod() {
		return nCodUsuMod;
	}

	public void setnCodUsuMod(long nCodUsuMod) {
		this.nCodUsuMod = nCodUsuMod;
	}

	public Date getdFecMod() {
		return dFecMod;
	}

	public void setdFecMod(Date dFecMod) {
		this.dFecMod = dFecMod;
	}

	public String getvHostMod() {
		return vHostMod;
	}

	public void setvHostMod(String vHostMod) {
		this.vHostMod = vHostMod;
	}

	

	
	
}
