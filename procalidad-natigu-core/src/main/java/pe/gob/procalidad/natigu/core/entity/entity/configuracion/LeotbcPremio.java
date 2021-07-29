package pe.gob.procalidad.natigu.core.entity.entity.configuracion;

import java.io.Serializable; 
import javax.persistence.*;  
import java.util.Date;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbc_premio.listar",
			procedureName = "conf.fun_leotbcpremio_buscar_x_filtros", 
			resultClasses = LeotbcPremio.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nompremio", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpprem", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitpre", type = Integer.class)}),

	@NamedStoredProcedureQuery(name = "leotbcPremio.insertar", procedureName = "conf.fun_leotbcpremio_insertar", 
			resultClasses = LeotbcPremio.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codpremio", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nompremio", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_despremio", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_puntos", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitpre", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpprem", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomimag", type = String.class)}),
//
			@NamedStoredProcedureQuery(name = "leotbcPremio.actualizar", procedureName = "conf.fun_leotbcpremio_actualizar", 
	 		resultClasses = LeotbcPremio.class, parameters = { 
				
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = Integer.class),
		 	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codpremio", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nompremio", type = String.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_despremio", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_puntos", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitpre", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpprem", type = int.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class),  
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomimag", type = String.class)}), 
	
	 @NamedStoredProcedureQuery(name = "leotbcPremio.eliminar", procedureName = "conf.fun_leotbcpremio_eliminar", 
 		resultClasses = LeotbcPremio.class, parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = Integer.class),
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codpremio", type = long.class),  
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) }), 
 		
 		@NamedStoredProcedureQuery(name = "leotbcPremio.buscar_por_codigo", procedureName = "conf.fun_leotbcpremio_buscar_x_codigo", 
 		resultClasses = LeotbcPremio.class, parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codpremio", type = long.class) }),
 		
//	 
	 @NamedStoredProcedureQuery(name = "leotbcPremio.buscar_por_alumnoxmedalla", procedureName = "conf.fun_leotbc_premio_buscar_x_alumnoxmedalla", 
 		resultClasses = LeotbcPremio.class, parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codaluxmeda", type = long.class) }), 
})

 
@Entity
@Table(name="leotbc_premio")
//@NamedQuery(name="LeotbcPremio.findAll", query="SELECT l FROM LeotbcPremio l")
public class LeotbcPremio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="i_puntos")
	private Integer iPuntos;

	@Id
	@Column(name="n_codpremio")
	private Integer nCodpremio;

	@Column(name="n_codregion")
	private Integer nCodregion;

	@Column(name="n_tm1sitpre")
	private Integer nTm1sitpre;

	@Column(name="n_tm1tpprem")
	private Integer nTm1tpprem;

	@Column(name="n_codusumod")
	private String vCodusumod;

	@Column(name="v_codusureg")
	private String vCodusureg;

	@Column(name="v_despremio")
	private String vDespremio;

	@Column(name="v_extimag")
	private String vExtimag;

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

	@Column(name="v_ubiimag")
	private String vUbiimag;
	
	private String v_nomcortoSituacion; 
	private String v_nomcortoRegion;
	private String v_nomcortoTipo;


	public LeotbcPremio() {
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

	public Integer getiPuntos() {
		return iPuntos;
	}

	public void setiPuntos(Integer iPuntos) {
		this.iPuntos = iPuntos;
	}

	public Integer getnCodpremio() {
		return nCodpremio;
	}

	public void setnCodpremio(Integer nCodpremio) {
		this.nCodpremio = nCodpremio;
	}

	public Integer getnCodregion() {
		return nCodregion;
	}

	public void setnCodregion(Integer nCodregion) {
		this.nCodregion = nCodregion;
	}

	public Integer getnTm1sitpre() {
		return nTm1sitpre;
	}

	public void setnTm1sitpre(Integer nTm1sitpre) {
		this.nTm1sitpre = nTm1sitpre;
	}

	public Integer getnTm1tpprem() {
		return nTm1tpprem;
	}

	public void setnTm1tpprem(Integer nTm1tpprem) {
		this.nTm1tpprem = nTm1tpprem;
	}

	public String getvCodusumod() {
		return vCodusumod;
	}

	public void setvCodusumod(String vCodusumod) {
		this.vCodusumod = vCodusumod;
	}

	public String getvCodusureg() {
		return vCodusureg;
	}

	public void setvCodusureg(String vCodusureg) {
		this.vCodusureg = vCodusureg;
	}

	public String getvDespremio() {
		return vDespremio;
	}

	public void setvDespremio(String vDespremio) {
		this.vDespremio = vDespremio;
	}

	public String getvExtimag() {
		return vExtimag;
	}

	public void setvExtimag(String vExtimag) {
		this.vExtimag = vExtimag;
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

	public String getvUbiimag() {
		return vUbiimag;
	}

	public void setvUbiimag(String vUbiimag) {
		this.vUbiimag = vUbiimag;
	}

	public String getV_nomcortoSituacion() {
		return v_nomcortoSituacion;
	}

	public void setV_nomcortoSituacion(String v_nomcortoSituacion) {
		this.v_nomcortoSituacion = v_nomcortoSituacion;
	}

	public String getV_nomcortoRegion() {
		return v_nomcortoRegion;
	}

	public void setV_nomcortoRegion(String v_nomcortoRegion) {
		this.v_nomcortoRegion = v_nomcortoRegion;
	}

	public String getV_nomcortoTipo() {
		return v_nomcortoTipo;
	}

	public void setV_nomcortoTipo(String v_nomcortoTipo) {
		this.v_nomcortoTipo = v_nomcortoTipo;
	}

	 

}