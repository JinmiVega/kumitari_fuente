package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcMascota;

import java.util.Date;

			@NamedStoredProcedureQueries({
				
				@NamedStoredProcedureQuery(name = "leotbd_seguimientoAluIntentoDet.actualizar", procedureName = "acad.fun_leotbdsegaluintentosDet_actualizar", 
				 		resultClasses = LeotbdSeguimientoAluIntento.class, parameters = {  
				 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codsegaluinten", type = Long.class), 
				 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class), 
				 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class),  
				 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codpregun", type = Long.class),
				 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Integer.class), 
				 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)}),
						
						@NamedStoredProcedureQuery(name = "leotbd_seguimientoAluIntentoDet.insertar", procedureName = "acad.fun_leotbdsegaluintentosDet_insertar", 
						resultClasses = LeotbdSeguimientoAluIntento.class, parameters = {
						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codsegaluinten", type = Long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class), 
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codpregun", type = Long.class), 
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Integer.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)}),
				 		
						@NamedStoredProcedureQuery(name = "leotbd_seguimientoAluIntentoDet.intentosXsubnivel", 
						procedureName = "acad.fun_leotbd_segaluintento_buscar_x_filtros", 
						resultClasses = LeotbdSeguimientoAluIntento.class,
						parameters = { 
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),  
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class)
					
					}),
					
						@NamedStoredProcedureQuery(name = "leotbd_seguimientoAluIntentoDet.buscarXAlumEjer", 
						procedureName = "acad.fun_leotbdsegaluintentosDet_listar_x_alumeje", 
						resultClasses = LeotbdSeguimientoAluIntento.class,
						parameters = { 
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),  
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codpregun", type = Long.class)
					
					}),
				
				
			@NamedStoredProcedureQuery(name = "leotbd_seguimientoAluIntento.actualizar", procedureName = "acad.fun_leotbdsegaluintentos_actualizar", 
	 		resultClasses = LeotbdSeguimientoAluIntento.class, parameters = {  
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codsegaluinten", type = Long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class),  
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Integer.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)}),
			
			@NamedStoredProcedureQuery(name = "leotbd_seguimientoAluIntento.insertar", procedureName = "acad.fun_leotbdsegaluintentos_insertar", 
			resultClasses = LeotbdSeguimientoAluIntento.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codsegaluinten", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)}),
	 		
	 		
			@NamedStoredProcedureQuery(name = "leotbd_seguimientoAluIntento.buscarXAlumEjer", 
			procedureName = "acad.fun_leotbdsegaluintentos_listar_x_alumEje", 
			resultClasses = LeotbdSeguimientoAluIntento.class,
			parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Long.class)
		
		}) 
	 
})


@Entity
@Table(name="acad.leotbd_segaluintentos")
public class LeotbdSeguimientoAluIntento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codsegaluinten")
	private long nCodsegaluinten;
	
	@Column(name="n_codusumat")
	private long nCodusumat;

	@Column(name="n_codmatpej")
	private long nCodmatpej;
	
	@Column(name="n_numIntento")
	private Integer nNumIntento;

	@Column(name="v_flgest")
	private String vFlgest;

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
 
	private Integer n_cantinten;
	private String v_nomcorto;
	private String v_nominsti;
	private String v_nomlengua;
	private String v_nomalumno;

	public LeotbdSeguimientoAluIntento() {
	}


	public long getnCodsegaluinten() {
		return nCodsegaluinten;
	}


	public void setnCodsegaluinten(long nCodsegaluinten) {
		this.nCodsegaluinten = nCodsegaluinten;
	}


	public long getnCodusumat() {
		return nCodusumat;
	}


	public void setnCodusumat(long nCodusumat) {
		this.nCodusumat = nCodusumat;
	}


	public long getnCodmatpej() {
		return nCodmatpej;
	}


	public void setnCodmatpej(long nCodmatpej) {
		this.nCodmatpej = nCodmatpej;
	}


	public Integer getnNumIntento() {
		return nNumIntento;
	}


	public void setnNumIntento(Integer nNumIntento) {
		this.nNumIntento = nNumIntento;
	}


	public String getvFlgest() {
		return vFlgest;
	}


	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
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

	public Integer getN_cantinten() {
		return n_cantinten;
	}


	public void setN_cantinten(Integer n_cantinten) {
		this.n_cantinten = n_cantinten;
	}


	 


	@Override
	public String toString() {
		return "LeotbdSeguimientoAluIntento [nCodsegaluinten="
				+ nCodsegaluinten + ", nCodusumat=" + nCodusumat
				+ ", nCodmatpej=" + nCodmatpej + ", nNumIntento=" + nNumIntento
				+ ", vFlgest=" + vFlgest + ", nCodUsuRegistro="
				+ nCodUsuRegistro + ", dFecRegistro=" + dFecRegistro
				+ ", vHostRegistro=" + vHostRegistro + ", nCodUsuModificado="
				+ nCodUsuModificado + ", dfecModificado=" + dfecModificado
				+ ", vHostModificado=" + vHostModificado + ", n_cantinten="
				+ n_cantinten + ", v_nomcorto=" + v_nomcorto + "]";
	}


	public String getV_nomcorto() {
		return v_nomcorto;
	}


	public void setV_nomcorto(String v_nomcorto) {
		this.v_nomcorto = v_nomcorto;
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


	public String getV_nomalumno() {
		return v_nomalumno;
	}


	public void setV_nomalumno(String v_nomalumno) {
		this.v_nomalumno = v_nomalumno;
	}


	 

	

}