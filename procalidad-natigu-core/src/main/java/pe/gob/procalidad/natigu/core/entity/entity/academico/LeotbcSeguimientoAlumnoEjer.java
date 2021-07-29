package pe.gob.procalidad.natigu.core.entity.entity.academico;

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

	 @NamedStoredProcedureQuery(name = "leotbc_segaluejercicio.insertar", 
			procedureName = "acad.fun_leotbcsegaluejercicio_insertar", 
	 		resultClasses = LeotbcSeguimientoAlumnoEjer.class, 
	 		parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codsegaluejer", type = Integer.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nummonedas", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)

		}),
//	@NamedStoredProcedureQuery(name = "leotbc_segaluejercicio.actulizar", 
//			procedureName = "acad.fun_leotbcsegaluejercicio_actulizar", 
//	 		resultClasses = LeotbcSeguimientoAlumnoEjer.class, 
//	 		parameters = { 
//	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codsegaluejer", type = Long.class), 
//	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nummonedas", type = int.class), 
//	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class), 
//	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class), 
//	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class),
//	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
//	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
//
//		}),
	@NamedStoredProcedureQuery(name = "leotbc_segaluejercicio.eliminar", 
		procedureName = "acad.fun_leotbcsegaluejercicio_eliminar", 
 		resultClasses = LeotbcSeguimientoAlumnoEjer.class, 
 		parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codsegaluejer", type = Long.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)

	}),
	@NamedStoredProcedureQuery(name = "leotbc_segaluejercicio.buscarPorCodigo", 
	    procedureName = "acad.fun_leotbcsegaluejercicio_buscar_x_codigo", 
		resultClasses = LeotbcSeguimientoAlumnoEjer.class, 
		parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codsegaluejer", type = Long.class)

}),
	@NamedStoredProcedureQuery(name = "leotbc_segaluejercicio.buscarPorFiltros", 
		procedureName = "acad.fun_leotbcsegaluejercicio_buscar_x_filtros", 
		resultClasses = LeotbcSeguimientoAlumnoEjer.class, 
		parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class)

})
})

@Entity
@Table(name = "leotbc_segaluejercicio",schema="acad")
public class LeotbcSeguimientoAlumnoEjer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "n_codsegaluejer")
	private Long nCodsegaluejer;
	
	@Column(name = "n_nummonedas")
	private int nNummonedas;
	
	@Column(name = "n_codusuari")
	private Long nCodusuari;
	
	@Column(name = "n_codlengua")
	private Long nCodlengua;
	
	@Column(name = "n_codmatpej")
	private Long nCodmatpej;
	
	@Column(name = "v_flgest")
	private String vFlgEstado;
	
	@Column(name = "n_codusureg")
	private int nCodUsuRegistro;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecRegistro;
	
	@Column(name = "v_hostreg")
	private String vHostRegistro;
	
	@Column(name = "n_codusumod")
	private int nCodUsuModificado;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dfecModificado;
	
	@Column(name = "v_hostmod")
	private String vHostModificado;
	
	public LeotbcSeguimientoAlumnoEjer() {
		super();
	}

	public Long getnCodsegaluejer() {
		return nCodsegaluejer;
	}

	public void setnCodsegaluejer(Long nCodsegaluejer) {
		this.nCodsegaluejer = nCodsegaluejer;
	}

	public int getnNummonedas() {
		return nNummonedas;
	}

	public void setnNummonedas(int nNummonedas) {
		this.nNummonedas = nNummonedas;
	}

	public Long getnCodusuari() {
		return nCodusuari;
	}

	public void setnCodusuari(Long nCodusuari) {
		this.nCodusuari = nCodusuari;
	}

	public Long getnCodlengua() {
		return nCodlengua;
	}

	public void setnCodlengua(Long nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public Long getnCodmatpej() {
		return nCodmatpej;
	}

	public void setnCodmatpej(Long nCodmatpej) {
		this.nCodmatpej = nCodmatpej;
	}

	public String getvFlgEstado() {
		return vFlgEstado;
	}

	public void setvFlgEstado(String vFlgEstado) {
		this.vFlgEstado = vFlgEstado;
	}

	public int getnCodUsuRegistro() {
		return nCodUsuRegistro;
	}

	public void setnCodUsuRegistro(int nCodUsuRegistro) {
		this.nCodUsuRegistro = nCodUsuRegistro;
	}

	public Date getdFecRegistro() {
		return dFecRegistro;
	}

	public void setdFecRegistro(Date dFecRegistro) {
		this.dFecRegistro = dFecRegistro;
	}

	public String getvHostRegistro() {
		return vHostRegistro;
	}

	public void setvHostRegistro(String vHostRegistro) {
		this.vHostRegistro = vHostRegistro;
	}

	public int getnCodUsuModificado() {
		return nCodUsuModificado;
	}

	public void setnCodUsuModificado(int nCodUsuModificado) {
		this.nCodUsuModificado = nCodUsuModificado;
	}

	public Date getDfecModificado() {
		return dfecModificado;
	}

	public void setDfecModificado(Date dfecModificado) {
		this.dfecModificado = dfecModificado;
	}

	public String getvHostModificado() {
		return vHostModificado;
	}

	public void setvHostModificado(String vHostModificado) {
		this.vHostModificado = vHostModificado;
	}

	@Override
	public String toString() {
		return "LeotbcSeguimientoAlumnoEjer [nCodsegaluejer=" + nCodsegaluejer
				+ ", nNummonedas=" + nNummonedas + ", nCodusuari=" + nCodusuari
				+ ", nCodlengua=" + nCodlengua + ", nCodmatpej=" + nCodmatpej
				+ ", vFlgEstado=" + vFlgEstado + ", nCodUsuRegistro="
				+ nCodUsuRegistro + ", dFecRegistro=" + dFecRegistro
				+ ", vHostRegistro=" + vHostRegistro + ", nCodUsuModificado="
				+ nCodUsuModificado + ", dfecModificado=" + dfecModificado
				+ ", vHostModificado=" + vHostModificado + "]";
	}

}