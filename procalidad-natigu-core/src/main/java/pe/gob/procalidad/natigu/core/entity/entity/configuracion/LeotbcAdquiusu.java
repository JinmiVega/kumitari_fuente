package pe.gob.procalidad.natigu.core.entity.entity.configuracion;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbc_adquiusu.actualizar",
			procedureName = "conf.fun_leotbc_adquiusu_actualizar", 
			resultClasses = LeotbcAdquiusu.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codadquiusu", type = Long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codfond", type = Long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitfousuar", type = Integer.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = Long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class)
			}
	),

	@NamedStoredProcedureQuery(name = "leotbc_adquiusu.eliminar", 
			procedureName = "conf.fun_leotbc_adquiusu_eliminar", 
			resultClasses = LeotbcAdquiusu.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codadquiusu", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			}
	),
//
	@NamedStoredProcedureQuery(name = "leotbc_adquiusu.insertar", 
		procedureName = "conf.fun_leotbc_adquiusu_insertar", 
		resultClasses = LeotbcFondo.class, parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codadquiusu", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codfond", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmasco", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codcombo", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tipadqui", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitfousuar", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
		}
	),

	@NamedStoredProcedureQuery(name = "leotbc_adquiusu.listar", 
			procedureName = "conf.fun_leotbcadquiusu_buscar_x_filtros", 
			resultClasses = LeotbcAdquiusu.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomadqui", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tipadqui", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codfond", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmasco", type = Long.class)
			}
	),
	@NamedStoredProcedureQuery(name = "leotbc_adquiusu.actualizarSwPredeterminado",
	procedureName = "conf.fun_leotbc_adquiusu_actualizarswpredetMasc", 
	parameters = {
		//@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codadquiusu", type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmasco", 	type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", 	type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_swpredeterminado", type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = Long.class)
		}
	),
	@NamedStoredProcedureQuery(name = "leotbc_adquiusu.actualizarSwPredeterminadoMasc",
	procedureName = "conf.fun_leotbc_adquiusu_actualizarswpredetMasc", 
	parameters = {
		//@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codadquiusu", type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmasco", 	type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", 	type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_swpredeterminado", type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = Long.class)
		}
	),
	@NamedStoredProcedureQuery(name = "leotbc_adquiusu.actualizarSwPredeterminadoFond",
	procedureName = "conf.fun_leotbc_adquiusu_actualizarswpredetFond", 
	parameters = {
		//@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codadquiusu", type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codfond", 	type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", 	type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_swpredeterminado", type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = Long.class)
		}
	),
	@NamedStoredProcedureQuery(name = "leotbc_adquiusu.actualizarSwPredeterminadoComb",
	procedureName = "conf.fun_leotbc_adquiusu_actualizarswpredetcomb", 
	parameters = {
		//@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codadquiusu", type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codcombo", 	type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", 	type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_swpredeterminado", type = Long.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = Long.class)
		}
	)
	
	 																
})

@Entity
@Table(name="leotbc_adquiusu")
public class LeotbcAdquiusu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codadquiusu")
	private long nCodadquiusu;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_codfond")
	private Long nCodfond;

	@Column(name="n_codmasco")
	private Long nCodmasco;
	
	@Column(name="n_codcombo")
	private Long nCodcombo;

	@Column(name="n_codregion")
	private Long nCodregion;

	@Column(name="n_codusuari")
	private Long nCodusuari;

	@Column(name="n_codusumod")
	private Long nCodusumod;

	@Column(name="n_codusureg")
	private Long nCodusureg;

	@Column(name="n_tm1sitfousuar")
	private Integer nTm1sitfousuar;

	@Column(name="n_tm1tipadqui")
	private Integer nTm1tipadqui;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;
	
	@Column(name="v_nombreAd")
	private String vNombreAd;
	
	@Column(name="v_descripcionAd")
	private String vDescripcionAd;
	
	@Column(name="v_estado")
	private String vEstado;
	
	@Column(name="v_nomreg")
	private String vNomreg;
	
	@Column(name="n_tipoAdqui")
	private Integer nTipoAdqui;
	
	@Column(name="n_valor")
	private Integer nValor;
	
	@Column(name="v_imagen")
	private String vImagen;
	

	public LeotbcAdquiusu() {
	}

	public long getNCodadquiusu() {
		return this.nCodadquiusu;
	}

	public void setNCodadquiusu(long nCodadquiusu) {
		this.nCodadquiusu = nCodadquiusu;
	}

	public Date getDFecmod() {
		return this.dFecmod;
	}

	public void setDFecmod(Date dFecmod) {
		this.dFecmod = dFecmod;
	}

	public Date getDFecreg() {
		return this.dFecreg;
	}

	public void setDFecreg(Date dFecreg) {
		this.dFecreg = dFecreg;
	}

	public Long getNCodfond() {
		return this.nCodfond;
	}

	public void setNCodfond(Long nCodfond) {
		this.nCodfond = nCodfond;
	}

	public Long getNCodmasco() {
		return this.nCodmasco;
	}

	public void setNCodmasco(Long nCodmasco) {
		this.nCodmasco = nCodmasco;
	}

	
	public Long getnCodcombo() {
		return nCodcombo;
	}

	public void setnCodcombo(Long nCodcombo) {
		this.nCodcombo = nCodcombo;
	}

	public Long getNCodregion() {
		return this.nCodregion;
	}

	public void setNCodregion(Long nCodregion) {
		this.nCodregion = nCodregion;
	}

	public Long getNCodusuari() {
		return this.nCodusuari;
	}

	public void setNCodusuari(Long nCodusuari) {
		this.nCodusuari = nCodusuari;
	}

	public Long getNCodusumod() {
		return this.nCodusumod;
	}

	public void setNCodusumod(Long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public Long getNCodusureg() {
		return this.nCodusureg;
	}

	public void setNCodusureg(Long nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public Integer getNTm1sitfousuar() {
		return this.nTm1sitfousuar;
	}

	public void setNTm1sitfousuar(Integer nTm1sitfousuar) {
		this.nTm1sitfousuar = nTm1sitfousuar;
	}

	public Integer getNTm1tipadqui() {
		return this.nTm1tipadqui;
	}

	public void setNTm1tipadqui(Integer nTm1tipadqui) {
		this.nTm1tipadqui = nTm1tipadqui;
	}

	public String getVFlgest() {
		return this.vFlgest;
	}

	public void setVFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}

	public String getVHostmod() {
		return this.vHostmod;
	}

	public void setVHostmod(String vHostmod) {
		this.vHostmod = vHostmod;
	}

	public String getVHostreg() {
		return this.vHostreg;
	}

	public void setVHostreg(String vHostreg) {
		this.vHostreg = vHostreg;
	}

	public String getvNombreAd() {
		return vNombreAd;
	}

	public void setvNombreAd(String vNombreAd) {
		this.vNombreAd = vNombreAd;
	}

	public String getvDescripcionAd() {
		return vDescripcionAd;
	}

	public void setvDescripcionAd(String vDescripcionAd) {
		this.vDescripcionAd = vDescripcionAd;
	}

	public String getvEstado() {
		return vEstado;
	}

	public void setvEstado(String vEstado) {
		this.vEstado = vEstado;
	}

	public String getvNomreg() {
		return vNomreg;
	}

	public void setvNomreg(String vNomreg) {
		this.vNomreg = vNomreg;
	}

	public Integer getnTipoAdqui() {
		return nTipoAdqui;
	}

	public void setnTipoAdqui(Integer nTipoAdqui) {
		this.nTipoAdqui = nTipoAdqui;
	}

	public Integer getnValor() {
		return nValor;
	}

	public void setnValor(Integer nValor) {
		this.nValor = nValor;
	}

	public String getvImagen() {
		return vImagen;
	}

	public void setvImagen(String vImagen) {
		this.vImagen = vImagen;
	}

}