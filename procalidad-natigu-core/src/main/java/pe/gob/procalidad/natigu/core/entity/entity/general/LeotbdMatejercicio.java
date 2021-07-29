package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


@NamedStoredProcedureQueries({

		@NamedStoredProcedureQuery(name = "leotbdmatejercicio.buscar_por_codigo", 
			procedureName = "gene.fun_leotbdmatejercicio_buscar_x_codigo", 
			resultClasses = LeotbdMatejercicio.class, 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codejerci", type = long.class) 
			}),
		@NamedStoredProcedureQuery(name = "leotbdmatejercicio.buscar_por_filtros", 
			procedureName = "gene.fun_leotbdmatejercicio_buscar_x_filtros", 
			resultClasses = LeotbdMatejercicio.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tituloeje", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desejerci", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1siteje", type = long.class) 
			}),
		@NamedStoredProcedureQuery(name = "leotbdmatejercicio.insertar", 
			procedureName = "gene.fun_leotbdmatejercicio_insertar", 
			resultClasses = LeotbdMatejercicio.class, 
			parameters = {
					@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codejerci", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tituloeje", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desejerci", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1siteje", type = Integer.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class) 
			}),
		@NamedStoredProcedureQuery(name = "leotbdmatejercicio.eliminar", 
			procedureName = "gene.fun_leotbdmatejercicio_eliminar", 
			parameters = {
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codejerci", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) 
			}),
		@NamedStoredProcedureQuery(name = "leotbdmatejercicio.actualizar", 
			procedureName = "gene.fun_leotbdmatejercicio_actualizar", 
			parameters = {
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codejerci", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tituloeje", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desejerci", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1siteje", type = Integer.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			})
}) 

@Entity
@Table(name="leotbd_matejercicio")
public class LeotbdMatejercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="d_fecmod")
	private Timestamp dFecmod;

	@Column(name="d_fecreg")
	private Timestamp dFecreg;
	@Id
	@Column(name="n_codejerci")
	private long nCodejerci;

	@Column(name="n_codmatpej")
	private long nCodmatpej;

	@Column(name="n_codusumod")
	private Integer nCodusumod;

	@Column(name="n_codusureg")
	private Integer nCodusureg;

	@Column(name="n_tm1siteje")
	private Integer nTm1siteje;

	@Column(name="v_desejerci")
	private String vDesejerci;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_tituloeje")
	private String vTituloeje;

	public LeotbdMatejercicio() {
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

	public long getNCodejerci() {
		return this.nCodejerci;
	}

	public void setNCodejerci(long nCodejerci) {
		this.nCodejerci = nCodejerci;
	}

	public long getNCodmatpej() {
		return this.nCodmatpej;
	}

	public void setNCodmatpej(long nCodmatpej) {
		this.nCodmatpej = nCodmatpej;
	}

	public Integer getNCodusumod() {
		return this.nCodusumod;
	}

	public void setNCodusumod(Integer nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public Integer getNCodusureg() {
		return this.nCodusureg;
	}

	public void setNCodusureg(Integer nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public Integer getNTm1siteje() {
		return this.nTm1siteje;
	}

	public void setNTm1siteje(Integer nTm1siteje) {
		this.nTm1siteje = nTm1siteje;
	}

	public String getVDesejerci() {
		return this.vDesejerci;
	}

	public void setVDesejerci(String vDesejerci) {
		this.vDesejerci = vDesejerci;
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

	public String getVTituloeje() {
		return this.vTituloeje;
	}

	public void setVTituloeje(String vTituloeje) {
		this.vTituloeje = vTituloeje;
	}

}