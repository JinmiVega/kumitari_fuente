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

	 @NamedStoredProcedureQuery(name = "leotbc_segaluejercicioDet.insertar", 
			procedureName = "acad.fun_leotbcsegaluejercicioDet_insertar", 
	 		resultClasses = LeotbdSeguimientoAlumnoEjerDet.class, 
	 		parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codsegaluejerdet", type = Integer.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nummonedas", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codpregun", type = Long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)

		}) 
})

@Entity
@Table(name = "leotbd_segaluejerdet",schema="acad")
public class LeotbdSeguimientoAlumnoEjerDet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "n_codsegaluejerdet")
	private Long nCodsegaluejerdet;
	
	@Column(name = "n_nummonedas")
	private int nNummonedas;
	
	@Column(name = "n_codusuari")
	private Long nCodusuari;
	
	@Column(name = "n_codlengua")
	private Long nCodlengua;
	
	@Column(name = "n_codmatpej")
	private Long nCodmatpej;
	
	@Column(name = "n_codpregun")
	private Long nCodpregun;
	
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
	
	public LeotbdSeguimientoAlumnoEjerDet() {
		super();
	}

	public Long getnCodsegaluejerdet() {
		return nCodsegaluejerdet;
	}

	public void setnCodsegaluejerdet(Long nCodsegaluejerdet) {
		this.nCodsegaluejerdet = nCodsegaluejerdet;
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

	public Long getnCodpregun() {
		return nCodpregun;
	}

	public void setnCodpregun(Long nCodpregun) {
		this.nCodpregun = nCodpregun;
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
		return "LeotbdSeguimientoAlumnoEjerDet [nCodsegaluejerdet="
				+ nCodsegaluejerdet + ", nNummonedas=" + nNummonedas
				+ ", nCodusuari=" + nCodusuari + ", nCodlengua=" + nCodlengua
				+ ", nCodmatpej=" + nCodmatpej + ", nCodpregun=" + nCodpregun
				+ ", vFlgEstado=" + vFlgEstado + ", nCodUsuRegistro="
				+ nCodUsuRegistro + ", dFecRegistro=" + dFecRegistro
				+ ", vHostRegistro=" + vHostRegistro + ", nCodUsuModificado="
				+ nCodUsuModificado + ", dfecModificado=" + dfecModificado
				+ ", vHostModificado=" + vHostModificado + "]";
	}
 
}