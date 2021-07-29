package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbc_docinscripcion.insertar", 
			procedureName = "acad.fun_leotbcdocinscripcion_insertar", 
			
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_coddocinscri", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinscr", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_rutadocu", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numedocu", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombdocu", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_docinscripcion.eliminar", 
			procedureName = "acad.fun_leotbcdocinscripcion_eliminar", 
		
			parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocinscri", type = long.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) 
	}),
	@NamedStoredProcedureQuery(name = "leotbc_docinscripcion.listar_por_codigoisncrip",
			procedureName = "acad.fun_leotbcdocinscripcion_listar_x_codigoinscrip", 
			resultClasses = LeotbcDocinscripcion.class, 
			parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinscr", type = long.class) 
	})
})

@Entity
@Table(name="leotbc_docinscripcion")
public class LeotbcDocinscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_coddocinscri")
	private long nCoddocinscri;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_codinscr")
	private int nCodinscr;

	@Column(name="n_codusumod")
	private int nCodusumod;

	@Column(name="n_codusureg")
	private int nCodusureg;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_numedocu")
	private String vNumedocu;

	@Column(name="v_rutadocu")
	private String vRutadocu;
	
	@Column(name="v_nombdocu")
	private String vNombdocu;
		
	@Column(name="n_sitdocinscri")
	private int nSitdocinscri;

	public LeotbcDocinscripcion() {
	}

	public long getnCoddocinscri() {
		return nCoddocinscri;
	}

	public void setnCoddocinscri(long nCoddocinscri) {
		this.nCoddocinscri = nCoddocinscri;
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

	public int getnCodinscr() {
		return nCodinscr;
	}

	public void setnCodinscr(int nCodinscr) {
		this.nCodinscr = nCodinscr;
	}

	public int getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(int nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public int getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(int nCodusureg) {
		this.nCodusureg = nCodusureg;
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

	public String getvNumedocu() {
		return vNumedocu;
	}

	public void setvNumedocu(String vNumedocu) {
		this.vNumedocu = vNumedocu;
	}

	public String getvRutadocu() {
		return vRutadocu;
	}

	public void setvRutadocu(String vRutadocu) {
		this.vRutadocu = vRutadocu;
	}

	public String getvNombdocu() {
		return vNombdocu;
	}

	public void setvNombdocu(String vNombdocu) {
		this.vNombdocu = vNombdocu;
	}

	public int getnSitdocinscri() {
		return nSitdocinscri;
	}

	public void setnSitdocinscri(int nSitdocinscri) {
		this.nSitdocinscri = nSitdocinscri;
	}

	

}