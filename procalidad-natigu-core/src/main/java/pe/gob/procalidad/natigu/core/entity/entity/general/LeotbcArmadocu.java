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
		@NamedStoredProcedureQuery(name = "leotbcarmadocu.buscar_por_codigo", procedureName = "gene.fun_leotbcarmadocu_buscar_x_codigo", resultClasses = LeotbcArmadocu.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codarmdoc", type = long.class) 
		}),

		@NamedStoredProcedureQuery(name = "leotbcarmadocu.buscar_por_cabecera", procedureName = "gene.fun_leotbcarmadocu_buscar_x_cab", resultClasses = LeotbcArmadocu.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codarmdoccab", type = Long.class) 
		}),@NamedStoredProcedureQuery(name = "leotbcarmadocu.buscar_por_filtro", procedureName = "gene.fun_leotbcarmadocu_buscar_x_filtro", resultClasses = LeotbcArmadocu.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codarmdoccab", type = long.class) 
		}),
		@NamedStoredProcedureQuery(name = "leotbcarmadocu.insertar", procedureName = "gene.fun_leotbcarmadocu_insertar", resultClasses = LeotbcArmadocu.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codarmdoc", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codarmdoccab", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2pardoc", type = long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tradtm2pdoc", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_descripcion", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbcarmadocu.eliminar", procedureName = "gene.fun_leotbcarmadocu_eliminar", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codarmdoc", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbcarmadocu.actualizar", procedureName = "gene.fun_leotbcarmadocu_actualizar", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codarmdoc", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2pardoc", type = int.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tradtm2pdoc", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_descripcion", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbcarmadocu.listarArmarDocuCabDetTodo", 
			procedureName = "gene.fun_leotbcarmadocu_buscar_cab_det_todo", 
			resultClasses = LeotbcArmadocu.class, 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class) 
		})
})
@Entity
@Table(name="leotbc_armadocu")
public class LeotbcArmadocu  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	
	@Id
	@Column(name="n_codarmdoc")
	private Integer nCodarmdoc;

	@Column(name="n_codarmdoccab")
	private Integer nCodarmdoccab;
	
	@Column(name="n_tm2pardoc")
	private long nTm2pardoc;
	
	@Column(name="v_descripcion")
	private String vDescripcion;
	
	@Column(name="v_tradtm2pdoc")
	private String vTradtm2pdoc;

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

	public Integer getnCodarmdoc() {
		return nCodarmdoc;
	}

	public void setnCodarmdoc(Integer nCodarmdoc) {
		this.nCodarmdoc = nCodarmdoc;
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

	public long getnTm2pardoc() {
		return nTm2pardoc;
	}

	public void setnTm2pardoc(long nTm2pardoc) {
		this.nTm2pardoc = nTm2pardoc;
	}

	public Integer getnCodarmdoccab() {
		return nCodarmdoccab;
	}

	public void setnCodarmdoccab(Integer nCodarmdoccab) {
		this.nCodarmdoccab = nCodarmdoccab;
	}

	public String getvTradtm2pdoc() {
		return vTradtm2pdoc;
	}

	public void setvTradtm2pdoc(String vTradtm2pdoc) {
		this.vTradtm2pdoc = vTradtm2pdoc;
	}

	public String getvDescripcion() {
		return vDescripcion;
	}

	public void setvDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	} 

	private String v_titulo_cab;
	private Integer n_tm2tipdoc;
	private String v_nomlargo;
	private String v_nomcorto;

	public String getV_titulo_cab() {
		return v_titulo_cab;
	}
	public void setV_titulo_cab(String v_titulo_cab) {
		this.v_titulo_cab = v_titulo_cab;
	}
	
	public Integer getN_tm2tipdoc() {
		return n_tm2tipdoc;
	}

	public void setN_tm2tipdoc(Integer n_tm2tipdoc) {
		this.n_tm2tipdoc = n_tm2tipdoc;
	}

	public String getV_nomlargo() {
		return v_nomlargo;
	}

	public void setV_nomlargo(String v_nomlargo) {
		this.v_nomlargo = v_nomlargo;
	}

	public String getV_nomcorto() {
		return v_nomcorto;
	}

	public void setV_nomcorto(String v_nomcorto) {
		this.v_nomcorto = v_nomcorto;
	}
	
}