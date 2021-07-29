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

	@NamedStoredProcedureQuery(name = "leotbdalternativa.buscar_x_pregunta", procedureName = "gene.fun_leotbdalternxpreg_buscar_x_pregunta", 
			resultClasses = LeotbdAlternativa.class, 
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codpregun", type = long.class) 
			}),
			
	@NamedStoredProcedureQuery(name = "leotbdalternativa.buscar_x_alternativa", procedureName = "gene.fun_leotbdalternxpreg_buscar_x_alternativa", 
			resultClasses = LeotbdAlternativa.class, 
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codaltern", type = long.class) 
			}),
	
	
	@NamedStoredProcedureQuery(name = "leotbdalternativa.insertar", procedureName = "gene.fun_leotbdalterxpreg_insertar", 
			resultClasses = LeotbdAlternativa.class, 
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codaltern", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codpregun", 		type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_alternativa", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_rptaestado", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", 		type = Long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", 			type = String.class) 
			})
		
		,
		@NamedStoredProcedureQuery(name = "leotbdalternativa.eliminar", procedureName = "gene.fun_leotbdalterxpreg_eliminar", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codaltern", type = Long.class),
//				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codpregunta", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) }),
		@NamedStoredProcedureQuery(name = "leotbdalternativa.actualizar", procedureName = "gene.fun_leotbdalterxpreg_actualizar", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codaltern", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_alternativa", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_rptaestado", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)

		})

})

@Entity
@Table(name = "gene.leotbd_alternxpreg")
public class LeotbdAlternativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "n_codaltern")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nCodaltern;

	@Column(name = "n_codpregun")
	private Long nCodpregun;

	@Column(name = "v_alternativa")
	private String vAlternativa;

	@Column(name = "v_rptaestado")
	private String vRptaestado;

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

	public LeotbdAlternativa() {
		super();
	}

	public Long getnCodaltern() {
		return nCodaltern;
	}

	public void setnCodaltern(Long nCodaltern) {
		this.nCodaltern = nCodaltern;
	}

	public Long getnCodpregun() {
		return nCodpregun;
	}

	public void setnCodpregun(Long nCodpregun) {
		this.nCodpregun = nCodpregun;
	}

	public String getvAlternativa() {
		return vAlternativa;
	}

	public void setvAlternativa(String vAlternativa) {
		this.vAlternativa = vAlternativa;
	}

	public String getvRptaestado() {
		return vRptaestado;
	}

	public void setvRptaestado(String vRptaestado) {
		this.vRptaestado = vRptaestado;
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

	

}
