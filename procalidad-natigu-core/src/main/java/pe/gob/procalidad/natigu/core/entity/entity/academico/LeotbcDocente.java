package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcPersonal;

import java.math.BigDecimal;
import java.util.Date;



@NamedStoredProcedureQueries({
	
	
	@NamedStoredProcedureQuery(name = "leotbcDocente.buscar_por_codigo", procedureName = "acad.fun_leotbcdocente_buscar_x_codigo", 
			resultClasses = LeotbcDocente.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = Long.class)
			
			
	}),
	@NamedStoredProcedureQuery(name = "leotbcDocente.buscar_por_codigopersona", procedureName = "acad.fun_leotbcdocente_buscar_x_codigopersona", 
	resultClasses = LeotbcDocente.class, parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Long.class)
	
	
}),
	@NamedStoredProcedureQuery(name = "leotbcDocente.buscar_por_dni", procedureName = "acad.fun_leotbcdocente_buscar_x_dni", 
	resultClasses = LeotbcDocente.class, parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_dnidocente", type = String.class)
	
	
	}),

	@NamedStoredProcedureQuery(name = "leotbcDocente.buscar_por_filtros", procedureName = "acad.fun_leotbcdocente_buscar_x_filtros", 
	resultClasses = LeotbcDocente.class, parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombredoc", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_especdoc", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nominsti", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitdoc", type = Integer.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperfil", type = Integer.class)
	
	}),


	@NamedStoredProcedureQuery(name = "leotbcDocente.buscar_por_numerodocumento", procedureName = "acad.fun_leotbcdocente_buscar_x_numerodocumento", 
	resultClasses = LeotbcDocente.class, parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numdocum", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_especdoc", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Integer.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperfil", type = Integer.class)
	
	}),
	
	@NamedStoredProcedureQuery(name = "leotbcDocente.buscar_inst_docente_documento_tipodoc", procedureName = "acad.fun_leotbcdocente_buscar_x_inst_nomdocente_numdocu_tipodoc", 
	resultClasses = LeotbcDocente.class, parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinst", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombredoc", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numdoc", type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tipdoc", type = int.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsclen", type = Long.class)
	
	}),



	@NamedStoredProcedureQuery(name = "leotbcDocente.insertar", procedureName = "acad.fun_leotbcdocente_insertar", 
			resultClasses = LeotbcDocente.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name ="p_coddocen", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2grado", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2carrera", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitdoc", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
			
			}),
			
			
			
			@NamedStoredProcedureQuery(name = "leotbcDocente.actualizar", procedureName = "acad.fun_leotbcdocente_actualizar", 
			resultClasses = LeotbcDocente.class, parameters = {
				
			
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Long.class),
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
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telefono", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type = String.class),
				
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name ="p_coddocen", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2grado", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2carrera", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitdoc", type = Integer.class),
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			
			}),
			
			
			@NamedStoredProcedureQuery(name = "leotbcDocente.eliminar", procedureName = "acad.fun_leotbcdocente_eliminar", 
			resultClasses = LeotbcDocente.class, parameters = {
				
			
				
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name ="p_coddocen", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			
			}),
			/***R**/
			@NamedStoredProcedureQuery(name = "leotbcDocente.buscarXcodigoInstitucionYNomYnumD", 
			procedureName = "acad.fun_leotbcdocente_buscar_x_codigoinsclenynomynumd", 
			resultClasses = LeotbcDocente.class,
			parameters = {			
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsclen", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombreper", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numdocum", type = String.class)
			
			}),
			
			@NamedStoredProcedureQuery(name = "leotbcDocente.buscarXcodigoInstitucion", 
			procedureName = "acad.fun_leotbcdocente_buscar_x_codigoinsclen", //fun_leotbcdocente_buscar_x_codigoinstitucion
			resultClasses = LeotbcDocente.class,
			parameters = {			
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name ="p_codinsclen", type = Long.class)//p_codinsti
			
			}),

			@NamedStoredProcedureQuery(name = "leotbcDocente.listarPorCodigoInstitucionYCodigoLengua", 
			procedureName = "acad.fun_leotbcdocente_listarcombodocentexcodinstycodleng", 
			resultClasses = LeotbcDocente.class,
			parameters = {			
				@StoredProcedureParameter(mode = ParameterMode.IN, name ="p_codinsti", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name ="p_codlengua", type = Long.class)	
			})
	
			

})



@Entity
@Table(name="leotbc_docente")
public class LeotbcDocente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	@Id
	@Column(name="n_coddocen")
	private Long nCoddocen;

	@Column(name="n_codinsti")
	private Long nCodinsti;

	@Column(name="n_codlengua")
	private Long nCodlengua;

	@Column(name="n_codperso")
	private Long nCodperso;

	@Column(name="n_codusumod")
	private Long nCodusumod;

	@Column(name="n_codusureg")
	private Long nCodusureg;

	@Column(name="n_tm1sitdoc")
	private Integer nTm1sitdoc;

	@Column(name="n_tm2carrera")
	private Integer nTm2carrera;

	@Column(name="n_tm2grado")
	private Integer nTm2grado;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;
	
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
	
	@Column(name = "n_tm1sitpersona")
	private int nTm1SitPersona;
   
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fechnacim")
	private Date dFechNacim;
	
	@Column(name = "n_tm2pais")
	private int nTm2Pais;
	
	@Column(name = "n_tm2estciv")
	private int nTm2EstCiv;
	
	@Column(name = "n_tm2sexo")
	private int nTm2Sexo;
	
	@Column(name = "v_codlenguaper")
	private long vCodLenguaper;
	
	@Column(name = "v_telefono")
	private String vTelefono;
	
	@Column(name = "v_correo")
	private String vCorreo;
	
	@Column(name = "v_nombretm1sitdoc")
	private String vNombreTm1SitDoc;

	@Column(name = "v_nombreinsti")
	private String vNombreinsti;

	@Column(name = "v_nombreespe")
	private String vNombreespe;
	
	@Column(name = "n_codinslen")
	private int nCodinslen;

	public LeotbcDocente() {
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

	public Long getnCoddocen() {
		return nCoddocen;
	}

	public void setnCoddocen(Long nCoddocen) {
		this.nCoddocen = nCoddocen;
	}

	public Long getnCodinsti() {
		return nCodinsti;
	}

	public void setnCodinsti(Long nCodinsti) {
		this.nCodinsti = nCodinsti;
	}

	public Long getnCodlengua() {
		return nCodlengua;
	}

	public void setnCodlengua(Long nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public Long getnCodperso() {
		return nCodperso;
	}

	public void setnCodperso(Long nCodperso) {
		this.nCodperso = nCodperso;
	}

	public Long getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(Long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public Long getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(Long nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public Integer getnTm1sitdoc() {
		return nTm1sitdoc;
	}

	public void setnTm1sitdoc(Integer nTm1sitdoc) {
		this.nTm1sitdoc = nTm1sitdoc;
	}

	public Integer getnTm2carrera() {
		return nTm2carrera;
	}

	public void setnTm2carrera(Integer nTm2carrera) {
		this.nTm2carrera = nTm2carrera;
	}

	public Integer getnTm2grado() {
		return nTm2grado;
	}

	public void setnTm2grado(Integer nTm2grado) {
		this.nTm2grado = nTm2grado;
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

	public int getnTm1SitPersona() {
		return nTm1SitPersona;
	}

	public void setnTm1SitPersona(int nTm1SitPersona) {
		this.nTm1SitPersona = nTm1SitPersona;
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

	

	public long getvCodLenguaper() {
		return vCodLenguaper;
	}

	public void setvCodLenguaper(long vCodLenguaper) {
		this.vCodLenguaper = vCodLenguaper;
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

	public String getvNombreTm1SitDoc() {
		return vNombreTm1SitDoc;
	}

	public void setvNombreTm1SitDoc(String vNombreTm1SitDoc) {
		this.vNombreTm1SitDoc = vNombreTm1SitDoc;
	}

	public String getvNombreinsti() {
		return vNombreinsti;
	}

	public void setvNombreinsti(String vNombreinsti) {
		this.vNombreinsti = vNombreinsti;
	}

	public String getvNombreespe() {
		return vNombreespe;
	}

	public void setvNombreespe(String vNombreespe) {
		this.vNombreespe = vNombreespe;
	}

	public int getnCodinslen() {
		return nCodinslen;
	}

	public void setnCodinslen(int nCodinslen) {
		this.nCodinslen = nCodinslen;
	}

	
	

}