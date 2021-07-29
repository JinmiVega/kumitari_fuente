package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "leotbd_docenteinsti.insertar", procedureName = "acad.fun_leotbddocenteinsti_insertar",

				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_coddoceninst", type = long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class) }),
		@NamedStoredProcedureQuery(name = "leotbd_docenteinsti.actualizar", procedureName = "acad.fun_leotbddocenteinsti_actualizar",

				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddoceninst", type = long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitdocins", type = Integer.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) }),

		@NamedStoredProcedureQuery(name = "leotbd_docenteinsti.eliminar", procedureName = "acad.fun_leotbddocenteinsti_eliminar", 
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) }),
		
		@NamedStoredProcedureQuery(name = "leotbd_docenteinsti.buscar_por_codigo", procedureName = "acad.fun_leotbddocenteinsti_buscar_x_codigo", resultClasses = LeotbcDocenteinsti.class, 
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddoceninst", type = long.class) }),
		
		@NamedStoredProcedureQuery(name = "leotbd_docenteinsti.listar_por_filtro", procedureName = "acad.fun_leotbddocenteinsti_buscar_x_filtros", resultClasses = LeotbcDocenteinsti.class, 
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = long.class) }),
		
		@NamedStoredProcedureQuery(name = "leotbd_docenteinsti.existe", procedureName = "acad.fun_leotbddocenteinsti_existe", resultClasses = LeotbcDocenteinsti.class, 
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddoceninst", type = long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = long.class) }) })

@Entity
@Table(name = "leotbd_docenteinsti")
public class LeotbcDocenteinsti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "n_coddoceninst")
	private long nCoddocenins;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecreg;

	@Column(name = "n_coddocen")
	private int nCoddocen;

	@Column(name = "n_codinsti")
	private int n_codinsti;

	@Column(name = "n_codusumod")
	private int nCodusumod;

	@Column(name = "n_codusureg")
	private int nCodusureg;

	@Column(name = "v_flgest")
	private String vFlgest;

	@Column(name = "v_hostmod")
	private String vHostmod;

	@Column(name = "v_hostreg")
	private String vHostreg;

	@Column(name = "n_tm1sitdocins")
	private int nTm1sitdocins;

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

	private String v_nominsti;

	public LeotbcDocenteinsti() {

	}

	public long getnCoddocenins() {
		return nCoddocenins;
	}

	public void setnCoddocenins(long nCoddocenins) {
		this.nCoddocenins = nCoddocenins;
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

	public int getnCoddocen() {
		return nCoddocen;
	}

	public void setnCoddocen(int nCoddocen) {
		this.nCoddocen = nCoddocen;
	}

	public int getN_codinsti() {
		return n_codinsti;
	}

	public void setN_codinsti(int n_codinsti) {
		this.n_codinsti = n_codinsti;
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

	public int getnTm1sitdocins() {
		return nTm1sitdocins;
	}

	public void setnTm1sitdocins(int nTm1sitdocins) {
		this.nTm1sitdocins = nTm1sitdocins;
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

	public String getV_nominsti() {
		return v_nominsti;
	}

	public void setV_nominsti(String v_nominsti) {
		this.v_nominsti = v_nominsti;
	}

}