package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NamedStoredProcedureQueries({
	

	@NamedStoredProcedureQuery(name = "leomvd_matdocente.buscarMatriculaXDocente", 
	procedureName = "acad.fun_leomvdmatdocente_listar_docente_x_matricula", 
	resultClasses = LeomvdMatdocente.class, 
	parameters = { 
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = Long.class) 
	}),
	
	@NamedStoredProcedureQuery(
			name  = "leomvd_matdocente.validarMatriculaXDocente", 
	procedureName = "acad.fun_leomvdmatdocente_validar_docente_x_matricula", 
	resultClasses = LeomvdMatdocente.class, 
	parameters 	  = { 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = Long.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmdo", type = int.class) 
			}),
	
	@NamedStoredProcedureQuery(name = "leomvd_matdocente.insertar", 
	procedureName = "acad.fun_leomvdmatdocente_insertar",	
	parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codmatdoc", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatri", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tipdoc", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmdo", type = long.class),
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
			}),
	 @NamedStoredProcedureQuery(name = "leomvd_matdocente.eliminar", 
	 procedureName = "acad.fun_leomvdmatdocente_eliminar",
	
 	 parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatdoc", type = long.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
 		})

	

})

@Entity
@Table(name="leomvd_matdocente")
public class LeomvdMatdocente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codmatdoc")
	private long nCodmatdoc;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_coddocen")
	private long nCoddocen;

	@Column(name="n_codmatri")
	private long nCodmatri;

	@Column(name="n_codusumod")
	private long nCodusumod;

	@Column(name="n_codusureg")
	private long nCodusureg;

	@Column(name="n_tm1sitmdo")
	private long nTm1sitmdo;

	@Column(name="n_tm1tipdoc")
	private long nTm1tipdoc;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;
	
	@Column(name="v_nombretm1tipdoc")
	private String vnombretm1tipdoc;
	
	@Column(name="v_nombretm1sitdoc")
	private String vnombretm1sitdoc;
	
	@Column(name="v_apepatper")
	private String vapepatper;
	
	@Column(name="v_apematper")
	private String vapematper;
	
	@Column(name="v_nombreper")
	private String vnombreper;
	
	@Column(name="v_numdocum")
	private String vnumdocum;
	
	
	
	
	
	public LeomvdMatdocente() {
	}





	public long getnCodmatdoc() {
		return nCodmatdoc;
	}





	public void setnCodmatdoc(long nCodmatdoc) {
		this.nCodmatdoc = nCodmatdoc;
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





	public long getnCoddocen() {
		return nCoddocen;
	}





	public void setnCoddocen(long nCoddocen) {
		this.nCoddocen = nCoddocen;
	}





	public long getnCodmatri() {
		return nCodmatri;
	}





	public void setnCodmatri(long nCodmatri) {
		this.nCodmatri = nCodmatri;
	}





	public long getnCodusumod() {
		return nCodusumod;
	}





	public void setnCodusumod(long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}





	public long getnCodusureg() {
		return nCodusureg;
	}





	public void setnCodusureg(long nCodusureg) {
		this.nCodusureg = nCodusureg;
	}





	public long getnTm1sitmdo() {
		return nTm1sitmdo;
	}





	public void setnTm1sitmdo(long nTm1sitmdo) {
		this.nTm1sitmdo = nTm1sitmdo;
	}





	public long getnTm1tipdoc() {
		return nTm1tipdoc;
	}





	public void setnTm1tipdoc(long nTm1tipdoc) {
		this.nTm1tipdoc = nTm1tipdoc;
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





	public String getVnombretm1tipdoc() {
		return vnombretm1tipdoc;
	}





	public void setVnombretm1tipdoc(String vnombretm1tipdoc) {
		this.vnombretm1tipdoc = vnombretm1tipdoc;
	}





	public String getVnombretm1sitdoc() {
		return vnombretm1sitdoc;
	}





	public void setVnombretm1sitdoc(String vnombretm1sitdoc) {
		this.vnombretm1sitdoc = vnombretm1sitdoc;
	}





	public String getVapepatper() {
		return vapepatper;
	}





	public void setVapepatper(String vapepatper) {
		this.vapepatper = vapepatper;
	}





	public String getVapematper() {
		return vapematper;
	}





	public void setVapematper(String vapematper) {
		this.vapematper = vapematper;
	}





	public String getVnombreper() {
		return vnombreper;
	}





	public void setVnombreper(String vnombreper) {
		this.vnombreper = vnombreper;
	}





	public String getVnumdocum() {
		return vnumdocum;
	}





	public void setVnumdocum(String vnumdocum) {
		this.vnumdocum = vnumdocum;
	}

	
	

}