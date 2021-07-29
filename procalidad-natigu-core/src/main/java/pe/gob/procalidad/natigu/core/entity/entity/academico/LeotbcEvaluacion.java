package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcMascota;

import java.util.Date;


@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbc_evaluacion.insertar", 
			procedureName = "acad.fun_leotbcevaluacion_insertar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codevalua", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2subnivel", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codundlec", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
	}),
		@NamedStoredProcedureQuery(name = "leotbc_evaluacion.buscarxcodEvaluacion", 
		procedureName = "acad.fun_leotbcevaluacion_buscar_x_codevaluacion", 
		resultClasses=LeotbcEvaluacion.class,
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codevalua", type = Long.class)
	}),
		@NamedStoredProcedureQuery(name = "leotbc_evaluacion.iniciarEvaluacion", 
		procedureName = "acad.fun_leotbcevaluacion_iniciar_evaluacion", 
		resultClasses=LeotbcEvaluacion.class,
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1siteva", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2subnivel", type = Long.class)
}),
		

		@NamedStoredProcedureQuery(name = "leotbc_evaluacion.reporte", 
		procedureName = "acad.fun_leotbd_evaluacionReporte", 
		resultClasses = LeotbcEvaluacion.class, 
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
		}),
		
		@NamedStoredProcedureQuery(name = "leotbc_evaluacion.listar_notas", 
		procedureName = "acad.fun_leotbcalumno_seguimiento_buscar_x_codusumat", 
		resultClasses = LeotbcEvaluacion.class, 
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
				
		}),
		
		@NamedStoredProcedureQuery(name = "leotbc_evaluacion.actulizar", 
		procedureName = "acad.fun_leotbcevaluacion_actulizar", 
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codevalua", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1siteva", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		
	}),
		@NamedStoredProcedureQuery(name = "leotbc_evaluacion.actulizarFechaEvaluacion", 
		procedureName = "acad.fun_leotbcevaluacion_actulizar_fecha_evaluacion", 
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codevalua", type = Long.class)
	}),
		@NamedStoredProcedureQuery(name = "leotbc_evaluacion.historico", 
		procedureName = "acad.fun_leotbc_evaluacion_historico", 
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_respuesta", type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codevalua", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2subnivel", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		
		}),
		@NamedStoredProcedureQuery(name = "leotbc_evaluacion.insertarEvaluacionFinal", 
		procedureName = "acad.fun_leotbcevaluacion_insertar_final", 
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codevalua", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codundlec", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
		
		})
		
})

@Entity
@Table(name="leotbc_evaluacion")
public class LeotbcEvaluacion implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	
	@Id
	@Column(name="n_codevalua")
	private Long nCodevalua;
	
	@Column(name="n_codusumat")
	private Long nCodusumat;

//	@Column(name="v_horainicio")
//	private String vHorainicio;
//
	@Column(name="n_tm2tipoevalucion")
	private Long nTm2tipoevalucion;
	
	@Column(name="n_tm1siteva")
	private Long nTm1siteva;
	
	@Column(name="n_totejercio")
	private Integer nTotejercio;

	@Column(name="n_correctos")
	private Integer nCorrectos;
	
	@Column(name="n_errados")
	private Integer nErrados;	
	
	@Column(name="n_nota")
	private Float n_nota;	
	
	@Column(name="n_codmedalla")
	private Long nCodmedalla;		

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
	
	@Column(name="v_nomimag")
	private String vNomimag;
	
	@Column(name="v_nompremio")
	private String vNompremio;
	 
	@Column(name="n_tm2nivel")
	private Integer nTm2nivel;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fechahoraini")
	private Date dFechahoraini;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fechahorafin")
	private Date dFechahorafin;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fechahoraeve")
	private Date dFechahoraeve;
	
	@Column(name="v_fechahoraeve")
	private String vFechahoraeve;
	
	@Column(name="v_fechahoraini")
	private String vFechahoraini;
	
	
	@Column(name="v_fechahorafin")
	private String vFechahorafin;
	
	
	@Column(name="v_fechaactual")
	private String vFechaactual;
	
	@Column(name="v_nomlargo")
	private String vNomlargo;
	 
	@Column(name="n_codlengua")
	private Long nCodlengua;
	
	@Column(name="n_tm2subnivel")
	private Integer nTm2subnivel;

	private String v_nomnivel;
	private String v_nomsubnivel;
	private String v_nominsti;
	private String v_nomlengua;
	private String v_nombreper;

	public Date getdFecmod() {
		return dFecmod;
	}
	
	public String getvNomlargo() {
		return vNomlargo;
	}

	

	public Long getnCodlengua() {
		return nCodlengua;
	}

	public void setnCodlengua(Long nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public void setvNomlargo(String vNomlargo) {
		this.vNomlargo = vNomlargo;
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


	public Long getnCodevalua() {
		return nCodevalua;
	}


	public void setnCodevalua(Long nCodevalua) {
		this.nCodevalua = nCodevalua;
	}


	public Long getnCodusumat() {
		return nCodusumat;
	}


	public void setnCodusumat(Long nCodusumat) {
		this.nCodusumat = nCodusumat;
	}

	public Long getnTm1siteva() {
		return nTm1siteva;
	}


	public void setnTm1siteva(Long nTm1siteva) {
		this.nTm1siteva = nTm1siteva;
	}


	public Integer getnTotejercio() {
		return nTotejercio;
	}


	public void setnTotejercio(Integer nTotejercio) {
		this.nTotejercio = nTotejercio;
	}


	public Integer getnCorrectos() {
		return nCorrectos;
	}


	public void setnCorrectos(Integer nCorrectos) {
		this.nCorrectos = nCorrectos;
	}


	public Integer getnErrados() {
		return nErrados;
	}


	public void setnErrados(Integer nErrados) {
		this.nErrados = nErrados;
	}


	public Float getN_nota() {
		return n_nota;
	}


	public void setN_nota(Float n_nota) {
		this.n_nota = n_nota;
	}


	public Long getnCodmedalla() {
		return nCodmedalla;
	}


	public void setnCodmedalla(Long nCodmedalla) {
		this.nCodmedalla = nCodmedalla;
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


	public String getvNomimag() {
		return vNomimag;
	}


	public void setvNomimag(String vNomimag) {
		this.vNomimag = vNomimag;
	}


	public String getvNompremio() {
		return vNompremio;
	}


	public void setvNompremio(String vNompremio) {
		this.vNompremio = vNompremio;
	}


	 


	public Integer getnTm2nivel() {
		return nTm2nivel;
	}

	public void setnTm2nivel(Integer nTm2nivel) {
		this.nTm2nivel = nTm2nivel;
	}

	public Date getdFechahoraini() {
		return dFechahoraini;
	}


	public void setdFechahoraini(Date dFechahoraini) {
		this.dFechahoraini = dFechahoraini;
	}


	public Date getdFechahorafin() {
		return dFechahorafin;
	}


	public void setdFechahorafin(Date dFechahorafin) {
		this.dFechahorafin = dFechahorafin;
	}


	public String getvFechahoraini() {
		return vFechahoraini;
	}


	public void setvFechahoraini(String vFechahoraini) {
		this.vFechahoraini = vFechahoraini;
	}


	public String getvFechahorafin() {
		return vFechahorafin;
	}


	public void setvFechahorafin(String vFechahorafin) {
		this.vFechahorafin = vFechahorafin;
	}


	public String getvFechaactual() {
		return vFechaactual;
	}


	public void setvFechaactual(String vFechaactual) {
		this.vFechaactual = vFechaactual;
	}

	public Long getnTm2tipoevalucion() {
		return nTm2tipoevalucion;
	}

	public void setnTm2tipoevalucion(Long nTm2tipoevalucion) {
		this.nTm2tipoevalucion = nTm2tipoevalucion;
	}

	public Integer getnTm2subnivel() {
		return nTm2subnivel;
	}

	public void setnTm2subnivel(Integer nTm2subnivel) {
		this.nTm2subnivel = nTm2subnivel;
	}

	public String getV_nomnivel() {
		return v_nomnivel;
	}

	public void setV_nomnivel(String v_nomnivel) {
		this.v_nomnivel = v_nomnivel;
	}

	public String getV_nomsubnivel() {
		return v_nomsubnivel;
	}

	public void setV_nomsubnivel(String v_nomsubnivel) {
		this.v_nomsubnivel = v_nomsubnivel;
	}

	public String getV_nominsti() {
		return v_nominsti;
	}

	public void setV_nominsti(String v_nominsti) {
		this.v_nominsti = v_nominsti;
	}

	public String getV_nomlengua() {
		return v_nomlengua;
	}

	public void setV_nomlengua(String v_nomlengua) {
		this.v_nomlengua = v_nomlengua;
	}

	public String getV_nombreper() {
		return v_nombreper;
	}

	public void setV_nombreper(String v_nombreper) {
		this.v_nombreper = v_nombreper;
	}

	public Date getdFechahoraeve() {
		return dFechahoraeve;
	}

	public void setdFechahoraeve(Date dFechahoraeve) {
		this.dFechahoraeve = dFechahoraeve;
	}

	public String getvFechahoraeve() {
		return vFechahoraeve;
	}

	public void setvFechahoraeve(String vFechahoraeve) {
		this.vFechahoraeve = vFechahoraeve;
	}

}