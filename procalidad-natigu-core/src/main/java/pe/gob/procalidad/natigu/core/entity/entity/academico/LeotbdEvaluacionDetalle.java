package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcMascota;

import java.util.Date;


@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbd_evaldetalle.actulizar", 
			procedureName = "acad.fun_leotbdevaldetalle_actulizar", 			
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codevaldet", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_swaprobad", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitevdt", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class),

	}),
	@NamedStoredProcedureQuery(name = "leotbd_evaldetalle.buscarPorFiltros", 
	procedureName = "acad.fun_leotbdevaldetalle_buscar_x_filtros",
	resultClasses = LeotbdEvaluacionDetalle.class,
	parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codevalua", type = Long.class)

	}),
	@NamedStoredProcedureQuery(name = "leotbd_evaldetalle.evaluacionPorEjercicio", 
	procedureName = "acad.fun_leotbdevaldetalle_buscar_x_evaluacionejercicio",
	resultClasses = LeotbdEvaluacionDetalle.class,
	parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codevalua", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2tpejer", type = Long.class)

	}),
	@NamedStoredProcedureQuery(name = "leotbd_evaldetalle.obtenerNota", 
	procedureName = "acad.fun_leotbcevaluacion_obtener_nota",
	resultClasses = LeotbdEvaluacionDetalle.class,
	parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codevalua", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)

	}),
	@NamedStoredProcedureQuery(name = "leotbd_evaldetalle.insertarEjercicioAdional", 
	procedureName = "acad.fun_leotbdevaldetalle_insertar_ejercicio_Adicional",
	parameters = {
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codevaldet", type = Integer.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua",   type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2subnivel", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codevalua",   type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2tpejer",   type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg",   type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg",     type = String.class)

	}),
	@NamedStoredProcedureQuery(name = "leotbd_evaldetalle.buscarPorCodigo", 
	procedureName = "acad.fun_leotbdevaldetalle_buscar_x_codigo",
	resultClasses = LeotbdEvaluacionDetalle.class,
	parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codevaldet", type = Long.class)

	})
	
})

@Entity
@Table(name="leotbd_evaldetalle")
public class LeotbdEvaluacionDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	
	@Id
	@Column(name="n_codevaldet")
	private Long nCodevaldet;
	
	@Column(name="n_codevalua")
	private Long nCodevalua;

	@Column(name="n_tm2tpejer")
	private Long nTm2tpejer;

	@Column(name="n_codmatpej")
	private Long nCodmatpej;
	
	@Column(name="n_codlesmat")
	private Long nCodlesmat;
	
	@Column(name="n_tm1sitevdt")
	private Integer nTm1sitevdt;

	@Column(name="n_swaprobad")
	private String nSwaprobad;	

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
	
	@Column(name="n_tm2nivel")
	private Long nTm2nivel;
	
	public LeotbdEvaluacionDetalle() {
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


	public Long getnCodevaldet() {
		return nCodevaldet;
	}


	public void setnCodevaldet(Long nCodevaldet) {
		this.nCodevaldet = nCodevaldet;
	}


	public Long getnCodevalua() {
		return nCodevalua;
	}


	public void setnCodevalua(Long nCodevalua) {
		this.nCodevalua = nCodevalua;
	}


	public Long getnTm2tpejer() {
		return nTm2tpejer;
	}


	public void setnTm2tpejer(Long nTm2tpejer) {
		this.nTm2tpejer = nTm2tpejer;
	}


	public Long getnCodmatpej() {
		return nCodmatpej;
	}


	public void setnCodmatpej(Long nCodmatpej) {
		this.nCodmatpej = nCodmatpej;
	}


	public Long getnCodlesmat() {
		return nCodlesmat;
	}


	public void setnCodlesmat(Long nCodlesmat) {
		this.nCodlesmat = nCodlesmat;
	}


	public Integer getnTm1sitevdt() {
		return nTm1sitevdt;
	}


	public void setnTm1sitevdt(Integer nTm1sitevdt) {
		this.nTm1sitevdt = nTm1sitevdt;
	}


	public String getnSwaprobad() {
		return nSwaprobad;
	}


	public void setnSwaprobad(String nSwaprobad) {
		this.nSwaprobad = nSwaprobad;
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


	public Long getnTm2nivel() {
		return nTm2nivel;
	}


	public void setnTm2nivel(Long nTm2nivel) {
		this.nTm2nivel = nTm2nivel;
	}

	

}