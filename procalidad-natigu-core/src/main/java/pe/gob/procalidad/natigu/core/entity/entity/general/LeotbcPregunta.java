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

		@NamedStoredProcedureQuery(name = "leotbcpregunta.buscar_por_codpregunta", procedureName = "gene.fun_leotbcpregunta_buscar_x_pregunta", 
				resultClasses = LeotbcPregunta.class, 
				parameters = 
				{
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codpregun", type = long.class) 
				}),
		@NamedStoredProcedureQuery(name = "leotbcpregunta.buscar_matxejer_pregunta_buscar_x_filtros", procedureName = "gene.fun_leotbc_pregunta_lematxtipoej_buscar_x_filtros", 
				resultClasses = LeotbcPregunta.class, 
				parameters = 
				{
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesmat", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2tpejer", type = long.class)
				}),
		@NamedStoredProcedureQuery(name = "leotbcpregunta.buscar_pregunta_buscar_x_filtros", procedureName = "gene.fun_leotbc_pregunta_buscar_x_filtros", 
		resultClasses = LeotbcPregunta.class, 
		parameters = 
		{
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbcpregunta.buscar_por_ejercicio", procedureName = "gene.fun_leotbcpregunta_buscar_x_codigoEjercicio", resultClasses = LeotbcPregunta.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codejerci", type = long.class) }),

		@NamedStoredProcedureQuery(name = "leotbcpregunta.insertar", procedureName = "gene.fun_leotbcpregunta_insertar", resultClasses = LeotbcPregunta.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codpregun", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_despregunta", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tippregunta", type = Integer.class) }),
		@NamedStoredProcedureQuery(name = "leotbcpregunta.eliminar", procedureName = "gene.fun_leotbcpregunta_eliminar", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codpregun", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) }),
		@NamedStoredProcedureQuery(name = "leotbcpregunta.actualizar", procedureName = "gene.fun_leotbcpregunta_actualizar", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codpregun", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_despregunta", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tippregunta", type = Integer.class)

		})

})

@Entity
@Table(name = "leotbc_pregunta")
public class LeotbcPregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "n_codpregun") 
	private Long nCodpregun;
	
	@Column(name = "n_codmatpej")
	private Long nCodmatpej;

	@Column(name = "v_despregunta")
	private String vDescpregunta; 

	@Column(name = "v_flgest")
	private String vFlgest;

	@Column(name = "n_codusureg")
	private Long nCodusureg;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecreg;

	@Column(name = "v_hostreg")
	private String vHostreg;

	@Column(name = "n_codusumod")
	private Long nCodusumod;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dFecmod;

	@Column(name = "v_hostmod")
	private String vHostmod;
	
	@Column(name = "n_tippregunta")
	private Integer nTippregunta;

	private String v_titulo;
	public LeotbcPregunta() {
		super();
	}

	public Long getnCodpregun() {
		return nCodpregun;
	}

	public void setnCodpregun(Long nCodpregun) {
		this.nCodpregun = nCodpregun;
	}

	

	public Long getnCodmatpej() {
		return nCodmatpej;
	}

	public void setnCodmatpej(Long nCodmatpej) {
		this.nCodmatpej = nCodmatpej;
	}

	public String getvDescpregunta() {
		return vDescpregunta;
	}

	public void setvDescpregunta(String vDescpregunta) {
		this.vDescpregunta = vDescpregunta;
	}

	public String getvFlgest() {
		return vFlgest;
	}

	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}

	public Long getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(Long nCodusureg) {
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

	public Long getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(Long nCodusumod) {
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

	public Integer getnTippregunta() {
		return nTippregunta;
	}

	public void setnTippregunta(Integer nTippregunta) {
		this.nTippregunta = nTippregunta;
	}

	public String getV_titulo() {
		return v_titulo;
	}

	public void setV_titulo(String v_titulo) {
		this.v_titulo = v_titulo;
	}

	 

}
