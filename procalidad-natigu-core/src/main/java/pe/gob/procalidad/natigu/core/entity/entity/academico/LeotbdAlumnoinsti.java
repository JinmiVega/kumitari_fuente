package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;
import javax.persistence.*;

import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdPerlengua;

import java.math.BigDecimal;
import java.sql.Timestamp;




@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbd_alumnoinsti.insertar", 
			procedureName = "acad.fun_leotbd_alumnoinsti_insertar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codalumninsti", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codalumno", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitaluminsti", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
			})
	,
	@NamedStoredProcedureQuery(name = "leotbd_alumnoinsti.eliminar", 
		procedureName = "acad.fun_leotbdalumnoinsti_eliminar",
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codalumno", type = Long.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = Long.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		})
	,
	@NamedStoredProcedureQuery(name = "leotbd_alumnoinsti.buscarPorcodigoPersona", 
		procedureName = "acad.fun_leotbdalumnoinsti_buscar_x_codigoalumno", 
		resultClasses = LeotbdAlumnoinsti.class,
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codalumno", type = Long.class)
		})
})
@Entity
@Table(name="leotbd_alumnoinsti")
public class LeotbdAlumnoinsti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codalumninsti")
	private long nCodalumninsti;

	@Column(name="d_fecmod")
	private Timestamp dFecmod;

	@Column(name="d_fecreg")
	private Timestamp dFecreg;

	@Column(name="n_codalumno")
	private long nCodalumno;

	@Column(name="n_codinsti")
	private long nCodinsti;

	@Column(name="n_codusumod")
	private long nCodusumod;

	@Column(name="n_codusureg")
	private long nCodusureg;

	@Column(name="n_tm1sitaluminsti")
	private long nTm1sitaluminsti;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;
	
	@Column(name="v_nominsti")
	private String vNominsti;
	
	public LeotbdAlumnoinsti() {
	}

	public long getNCodalumninsti() {
		return this.nCodalumninsti;
	}

	public void setNCodalumninsti(long nCodalumninsti) {
		this.nCodalumninsti = nCodalumninsti;
	}

	public Timestamp getDFecmod() {
		return this.dFecmod;
	}

	public void setDFecmod(Timestamp dFecmod) {
		this.dFecmod = dFecmod;
	}

	public Timestamp getDFecreg() {
		return this.dFecreg;
	}

	public void setDFecreg(Timestamp dFecreg) {
		this.dFecreg = dFecreg;
	}

	public long getNCodalumno() {
		return this.nCodalumno;
	}

	public void setNCodalumno(long nCodalumno) {
		this.nCodalumno = nCodalumno;
	}

	public long getNCodinsti() {
		return this.nCodinsti;
	}

	public void setNCodinsti(long nCodinsti) {
		this.nCodinsti = nCodinsti;
	}

	public long getNCodusumod() {
		return this.nCodusumod;
	}

	public void setNCodusumod(long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public long getNCodusureg() {
		return this.nCodusureg;
	}

	public void setNCodusureg(long nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public long getNTm1sitaluminsti() {
		return this.nTm1sitaluminsti;
	}

	public void setNTm1sitaluminsti(long nTm1sitaluminsti) {
		this.nTm1sitaluminsti = nTm1sitaluminsti;
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

	public String getvNominsti() {
		return vNominsti;
	}

	public void setvNominsti(String vNominsti) {
		this.vNominsti = vNominsti;
	}


	
	
}