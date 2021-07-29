package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "leotbcoracioncompletar.buscar_por_codigo", procedureName = "gene.fun_leotbcoraxcompletar_buscar_x_codigo", resultClasses = LeotbcOracionCompletar.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codcomporacion", type = long.class) 
		}),
		@NamedStoredProcedureQuery(name = "leotbcoracioncompletar.buscar_por_Matejercicio", procedureName = "gene.fun_leotbcoraxcompletar_buscar_x_MatEjer", resultClasses = LeotbcOracionCompletar.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class) 
		}),
		@NamedStoredProcedureQuery(name = "leotbcoracioncompletar.buscar_por_Filtros", procedureName = "gene.fun_leotbcoraxcompletar_buscar_x_filtro", resultClasses = LeotbcOracionCompletar.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class) 
	}),									    
		@NamedStoredProcedureQuery(name = "leotbcoracioncompletar.insertar", procedureName = "gene.fun_leotbcoraxcompletar_insertar", resultClasses = LeotbcOracionCompletar.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codcomporacion", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_oracion", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbcoracioncompletar.eliminar", procedureName = "gene.fun_leotbcoraxcompletar_eliminar", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codcomporacion", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbcoracioncompletar.actualizar", procedureName = "gene.fun_leotbcoraxcompletar_actualizar", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codcomporacion", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_oracion", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		})
})


@Entity
@Table(name="leotbc_oraxcompletar")
public class LeotbcOracionCompletar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	@Id
	@Column(name="n_codcomporacion")
	private Integer nCodcomporacion;

	@Column(name="n_codmatpej")
	private Integer nCodmatpej;

	@Column(name="n_codusumod")
	private Integer nCodusumod;

	@Column(name="n_codusureg")
	private Integer nCodusureg; 
	 
	@Column(name="v_oracion")
	private String vOracion;

	@Column(name="v_titulo")
	private String vTitulo;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg; 
	 

	public LeotbcOracionCompletar() {
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


	public Integer getnCodcomporacion() {
		return nCodcomporacion;
	}


	public void setnCodcomporacion(Integer nCodcomporacion) {
		this.nCodcomporacion = nCodcomporacion;
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


	public String getvHostmod() {
		return vHostmod;
	}


	public void setvHostmod(String vHostmod) {
		this.vHostmod = vHostmod;
	}

	
	public String getvOracion() {
		return vOracion;
	}


	public void setvOracion(String vOracion) {
		this.vOracion = vOracion;
	}


	public String getvHostreg() {
		return vHostreg;
	}


	public void setvHostreg(String vHostreg) {
		this.vHostreg = vHostreg;
	}

	 

}