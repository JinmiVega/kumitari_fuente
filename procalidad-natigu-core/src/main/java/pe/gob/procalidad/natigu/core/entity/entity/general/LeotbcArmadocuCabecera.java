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
	@NamedStoredProcedureQuery(name = "leotbcarmadocucab.buscar_por_ejercicio", procedureName = "gene.fun_leotbarmadocucab_buscar_x_ejercicio", 
			resultClasses = LeotbcArmadocuCabecera.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class) 
		}),
	@NamedStoredProcedureQuery(name = "leotbcarmadocucab.buscar_por_codigo", procedureName = "gene.fun_leotbarmadocucab_buscar_x_codigo", 
	resultClasses = LeotbcArmadocuCabecera.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codarmdoccab", type = long.class) 
}),
		@NamedStoredProcedureQuery(name = "leotbcarmadocucab.insertar", procedureName = "gene.fun_leotbarmadocucab_insertar", 
			resultClasses = LeotbcArmadocuCabecera.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codarmdoccab", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2tipdoc", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", 		type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbcarmadocucab.eliminar", procedureName = "gene.fun_leotbarmadocucab_eliminar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codarmdoccab", 	type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbcarmadocucab.actualizar", procedureName = "gene.fun_leotbarmadocucab_actualizar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codarmdoccab", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2tipdoc", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class)
		})
})
@Entity
@Table(name="leotbc_armadocucab")
public class LeotbcArmadocuCabecera  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	
	@Id
	@Column(name="n_codarmdoccab")
	private Integer nCodarmdoccab;

	@Column(name="n_codmatpej")
	private Integer nCodmatpej;
	
	@Column(name="n_tm2tipdoc")
	private Integer nTm2tipdoc;
	

	@Column(name="n_codusumod")
	private Integer nCodusumod;

	@Column(name="n_codusureg")
	private Integer nCodusureg; 

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_titulo")
	private String vTitulo;
	
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

	public Integer getnCodmatpej() {
		return nCodmatpej;
	}

	public void setnCodmatpej(Integer nCodmatpej) {
		this.nCodmatpej = nCodmatpej;
	}

	public Integer getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(Integer nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public Integer getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(Integer nCodusureg) {
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

	public Integer getnTm2tipdoc() {
		return nTm2tipdoc;
	}

	public void setnTm2tipdoc(Integer nTm2tipdoc) {
		this.nTm2tipdoc = nTm2tipdoc;
	}

	public Integer getnCodarmdoccab() {
		return nCodarmdoccab;
	}

	public void setnCodarmdoccab(Integer nCodarmdoccab) {
		this.nCodarmdoccab = nCodarmdoccab;
	}

	private String v_nomlargo;

	

	public String getV_nomlargo() {
		return v_nomlargo;
	}

	public void setV_nomlargo(String v_nomlargo) {
		this.v_nomlargo = v_nomlargo;
	}

	public String getvTitulo() {
		return vTitulo;
	}

	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}
	
	
}
