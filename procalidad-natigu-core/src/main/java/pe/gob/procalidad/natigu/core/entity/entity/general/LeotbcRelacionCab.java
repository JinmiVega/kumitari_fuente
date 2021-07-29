
package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedStoredProcedureQueries({
//		@NamedStoredProcedureQuery(name = "leotbcrelacion.buscar_por_codrelacion", procedureName = "gene.fun_leotbcrelacion_buscar_x_codrelacion", 
//			resultClasses = LeotbcRelacion.class, parameters = {
//				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelaci", type = long.class) 
//		}),
		@NamedStoredProcedureQuery(name = "leotbcrelacioncab.buscar_por_ejercicio", procedureName = "gene.fun_leotbcrelacioncab_buscar_x_ejercicio", 
			resultClasses = LeotbcRelacionCab.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class) 
		}),
		@NamedStoredProcedureQuery(name = "leotbcrelacioncab.buscar_matxejer_relacioncab_buscar", procedureName = "gene.fun_leotbc_relacioncab_lematxtipoej_buscar", 
		resultClasses = LeotbcRelacionCab.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesmat", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2tpejer", type = long.class)
	}),
		@NamedStoredProcedureQuery(name = "leotbcrelacioncab.insertar", procedureName = "gene.fun_leotbcrelacioncab_insertar", 
			resultClasses = LeotbcRelacionCab.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codrelaci", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", 		type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbcrelacioncab.eliminar", procedureName = "gene.fun_leotbcrelacioncab_eliminar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelcab", 	type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbcrelacioncab.actualizar", procedureName = "gene.fun_leotbcrelacioncab_actualizar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelcab", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class)
		})
})

@Entity
@Table(name = "leotbc_relacioncab")
public class LeotbcRelacionCab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codrelaci")
	private long nCodrelaci;
	
	@Column(name="n_codmatpej")
	private long nCodmatpej;
	
	@Column(name="v_titulo")
	private String vTitulo;
	
	@Column(name="v_flgest")
	private String vFlgest;
	
	@Column(name="n_codusureg")
	private long nCodusureg;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecreg")
	private Date dFecreg;
	
	@Column(name="v_hostreg")
	private String vHostreg;
	
	@Column(name="n_codusumod")
	private long nCodusumod;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecmod")
	private Date dFecmod;
	
	@Column(name="v_hostmod")
	private String vHostmod;

	private String v_destmat;
	public LeotbcRelacionCab() {
		super();
	}

	public long getnCodrelaci() {
		return nCodrelaci;
	}

	public void setnCodrelaci(long nCodrelaci) {
		this.nCodrelaci = nCodrelaci;
	}

	public long getnCodmatpej() {
		return nCodmatpej;
	}

	public void setnCodmatpej(long nCodmatpej) {
		this.nCodmatpej = nCodmatpej;
	}

	public String getvTitulo() {
		return vTitulo;
	}

	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}

	public String getvFlgest() {
		return vFlgest;
	}

	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}

	public long getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(long nCodusureg) {
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

	public long getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(long nCodusumod) {
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

	public String getV_destmat() {
		return v_destmat;
	}

	public void setV_destmat(String v_destmat) {
		this.v_destmat = v_destmat;
	}



}