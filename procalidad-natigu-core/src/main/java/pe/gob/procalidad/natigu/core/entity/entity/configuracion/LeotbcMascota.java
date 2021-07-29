package pe.gob.procalidad.natigu.core.entity.entity.configuracion;

import java.io.Serializable;  

import javax.persistence.*;   

import java.util.Date;


@SuppressWarnings("serial")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbc_mascota.listar",
			procedureName = "conf.fun_leotbcmascota_buscar_x_filtros", 
			resultClasses = LeotbcMascota.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nommasco", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmas", type = Integer.class)}),

	@NamedStoredProcedureQuery(name = "leotbcMascota.insertar", procedureName = "conf.fun_leotbcmascota_insertar", 
			resultClasses = LeotbcMascota.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codmasco", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nommasco", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desmasco", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_valmoneda", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_premasco", type = int.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_imagale", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_imagtri", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_imagneu", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_imagsor", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_imagtienda", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_imagneuani", type = String.class)
			}),
//
			@NamedStoredProcedureQuery(name = "leotbcMascota.actualizar", procedureName = "conf.fun_leotbcmascota_actualizar", 
	 		resultClasses = LeotbcMascota.class, parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = Integer.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmasco", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nommasco", type = String.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desmasco", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmas", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_valmoneda", type = int.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = Integer.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_premasco", type = int.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_imagale", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_imagtri", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_imagneu", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_imagsor", type = String.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_imagtienda", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_imagneuani", type = String.class)
			}),
	
	 @NamedStoredProcedureQuery(name = "leotbcMascota.eliminar", procedureName = "conf.fun_leotbcmascota_eliminar", 
 		resultClasses = LeotbcMascota.class, parameters = { 
		 @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = Integer.class),
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmasco", type = long.class),  
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) }), 
//	 
	 @NamedStoredProcedureQuery(name = "leotbcMascota.buscar_por_codigo", procedureName = "conf.fun_leotbcmascota_buscar_x_codigo", 
 		resultClasses = LeotbcMascota.class, parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmasco", type = long.class) }), 
 	
 		@NamedStoredProcedureQuery(name = "leotbc_mascota.listarAlumno",
			procedureName = "conf.fun_leotbcmascota_buscar_x_filtros_alum", 
			resultClasses = LeotbcMascota.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nommasco", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmas", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusu", type = Long.class)}),
				
		@NamedStoredProcedureQuery(name = "leotbc_mascota.listarTiendaAlumno",
			procedureName = "conf.fun_leotbcmascota_buscar_x_tienda_alum", 
			resultClasses = LeotbcMascota.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nommasco", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmas", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusu", type = Long.class)}),
					
					
 		@NamedStoredProcedureQuery(name = "leotbc_mascota.listarMasctoSwPredetAlumno",
			procedureName = "conf.fun_leotbcmascota_buscar_x_filtros_alumswpredet", 
			resultClasses = LeotbcMascota.class, 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusu", type = Long.class)
				}),
 		@NamedStoredProcedureQuery(name = "leotbc_mascota.listarMasctoSwPredetSist",
			procedureName = "conf.fun_leotbcmascota_buscar_premascosist", 
			resultClasses = LeotbcMascota.class, 
			parameters = {
				
				})
})


/**
 * The persistent class for the leotbc_mascota database table.
 * 
 */
@Entity
@Table(name="leotbc_mascota")
//@NamedQuery(name="LeotbcMascota.findAll", query="SELECT l FROM LeotbcMascota l")
public class LeotbcMascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codmasco")
	private Integer nCodmasco;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	
	
	@Column(name="i_valmoneda")
	private Integer iValmoneda;
	

	@Column(name="n_codregion")
	private Integer nCodregion;

	@Column(name="n_codusumod")
	private Integer nCodusumod;

	@Column(name="n_codusureg")
	private Integer nCodusureg;
	
	@Column(name="n_tm2nivel")
	private Integer nTm2nivel;  

	@Column(name="n_tm1sitmas")
	private Integer nTm1sitmas;

	@Column(name="v_desmasco")
	private String vDesmasco;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;
	
	@Column(name="n_premasco")
	private Integer nPremasco;

	@Column(name="v_nommasco")
	private String vNommasco;
	
	private String v_nomcortoSituacion;
	private Integer n_nivelAlumno;
	private String v_nomcortoNivel; 
	private String v_nomcortoRegion;
	
	@Column(name="v_imagale")
	private String vImagale;
	
	@Column(name="v_imagtri")
	private String vImagtri;
	
	@Column(name="v_imagneu")
	private String vImagneu;
	
	@Column(name="v_imagsor")
	private String vImagsor;
	
	@Column(name="v_imagtienda")
	private String vImagtienda;
	
	@Column(name="n_cantCompra")
	private Integer nCantCompra;
	
	@Column(name="n_swpredeterminado")
	private Integer nSwpredeterminado;
	
	@Column(name="v_imagneuani")
	private String vImagneualt;
	
	public LeotbcMascota() {
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

//	public Integer getIValmoneda() {
//		return this.iValmoneda;
//	}

//	public void setIValmoneda(Integer iValmoneda) {
//		this.iValmoneda = iValmoneda;
//	}

	public Date getdFecmod() {
		return dFecmod;
	}

	public Integer getN_nivelAlumno() {
		return n_nivelAlumno;
	}

	public void setN_nivelAlumno(Integer n_nivelAlumno) {
		this.n_nivelAlumno = n_nivelAlumno;
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

	public Integer getiValmoneda() {
		return iValmoneda;
	}

	public void setiValmoneda(Integer iValmoneda) {
		this.iValmoneda = iValmoneda;
	}

	public Integer getnCodmasco() {
		return nCodmasco;
	}

	public void setnCodmasco(Integer nCodmasco) {
		this.nCodmasco = nCodmasco;
	}

	public Integer getnCodregion() {
		return nCodregion;
	}

	public void setnCodregion(Integer nCodregion) {
		this.nCodregion = nCodregion;
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

	public Integer getnTm1sitmas() {
		return nTm1sitmas;
	}

	public void setnTm1sitmas(Integer nTm1sitmas) {
		this.nTm1sitmas = nTm1sitmas;
	}

	public String getvDesmasco() {
		return vDesmasco;
	}

	public void setvDesmasco(String vDesmasco) {
		this.vDesmasco = vDesmasco;
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

	public String getvNommasco() {
		return vNommasco;
	}

	public void setvNommasco(String vNommasco) {
		this.vNommasco = vNommasco;
	}

	public Integer getnPremasco() {
		return nPremasco;
	}

	public void setnPremasco(Integer nPremasco) {
		this.nPremasco = nPremasco;
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

	public String getvImagale() {
		return vImagale;
	}

	public void setvImagale(String vImagale) {
		this.vImagale = vImagale;
	}

	public String getvImagtri() {
		return vImagtri;
	}

	public void setvImagtri(String vImagtri) {
		this.vImagtri = vImagtri;
	}

	public String getvImagneu() {
		return vImagneu;
	}

	public void setvImagneu(String vImagneu) {
		this.vImagneu = vImagneu;
	}

	public String getvImagsor() {
		return vImagsor;
	}

	public void setvImagsor(String vImagsor) {
		this.vImagsor = vImagsor;
	}

	public Integer getnCantCompra() {
		return nCantCompra;
	}

	public void setnCantCompra(Integer nCantCompra) {
		this.nCantCompra = nCantCompra;
	}

	public String getvImagtienda() {
		return vImagtienda;
	}

	public void setvImagtienda(String vImagtienda) {
		this.vImagtienda = vImagtienda;
	}

	public Integer getnSwpredeterminado() {
		return nSwpredeterminado;
	}

	public void setnSwpredeterminado(Integer nSwpredeterminado) {
		this.nSwpredeterminado = nSwpredeterminado;
	}

	public String getvImagneualt() {
		return vImagneualt;
	}

	public void setvImagneualt(String vImagneualt) {
		this.vImagneualt = vImagneualt;
	}
	
	public Integer getnTm2nivel() {
		return nTm2nivel;
	}

	public void setnTm2nivel(Integer nTm2nivel) {
		this.nTm2nivel = nTm2nivel;
	}
	public String getV_nomcortoNivel() {
		return v_nomcortoNivel;
	}

	public void setV_nomcortoNivel(String v_nomcortoNivel) {
		this.v_nomcortoNivel = v_nomcortoNivel;
	}
}