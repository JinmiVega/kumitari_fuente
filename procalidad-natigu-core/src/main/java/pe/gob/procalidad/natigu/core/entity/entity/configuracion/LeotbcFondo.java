package pe.gob.procalidad.natigu.core.entity.entity.configuracion;

import java.io.Serializable; 

import javax.persistence.*;  

import java.util.Date;


@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbc_fondo.listar",
			procedureName = "conf.fun_leotbcfondo_buscar_x_filtros", 
			resultClasses = LeotbcFondo.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomfond", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpfond", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitfond", type = Integer.class)}),

	@NamedStoredProcedureQuery(name = "leotbcFondo.insertar", procedureName = "conf.fun_leotbcfondo_insertar", 
			resultClasses = LeotbcFondo.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codfond", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomfond", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desfond", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_valfond", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_valgem", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitfond", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpfond", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomimagf", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomimagfti", type = String.class)
			}),
	
//
			@NamedStoredProcedureQuery(name = "leotbcFondo.actualizar", procedureName = "conf.fun_leotbcfondos_actualizar", 
	 		resultClasses = LeotbcFondo.class, parameters = { 
				
//			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = Integer.class),
		 	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codfond", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomfond", type = String.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desfond", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_valfond", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_valgem", type = int.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitfond", type = int.class), 
//	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpfond", type = int.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class),  
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomimagf", type = String.class),
		 	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomimagfti", type = String.class)}), 
	 																
	
	 @NamedStoredProcedureQuery(name = "leotbcFondo.eliminar", procedureName = "conf.fun_leotbcfondo_eliminar", 
 		resultClasses = LeotbcFondo.class, parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = Integer.class),
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codfond", type = long.class),  
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) }), 
//	 
	 @NamedStoredProcedureQuery(name = "leotbcFondo.buscar_por_codigo", 
	 procedureName = "conf.fun_leotbcfondo_buscar_x_codigo", 
 		resultClasses = LeotbcFondo.class, parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codfond", type = long.class) }), 
 	
 		@NamedStoredProcedureQuery(name = "leotbc_fondo.listarAlumno",
			procedureName = "conf.fun_leotbcfondo_buscar_x_filtros_alum", 
			resultClasses = LeotbcFondo.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomfond", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpfond", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitfond", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusu", type = Long.class)
 			}
 		),
 		@NamedStoredProcedureQuery(name = "leotbc_fondo.listarFondoSwPredetAlumno",
		procedureName = "conf.fun_leotbcfondo_buscar_x_filtros_alumswpredet", 
		resultClasses = LeotbcFondo.class, 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusu", type = Long.class)
			})
})

@Entity
@Table(name="leotbc_fondos")
public class LeotbcFondo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="i_valfond")
	private Integer iValfond;
	
	@Column(name="i_valgem")
	private Integer iValgem;
	@Id
	@Column(name="n_codfond")
	private Integer nCodfond;

	@Column(name="n_codregion")
	private Integer nCodregion;

	@Column(name="n_tm1sitfond")
	private Integer nTm1sitfond;

	@Column(name="n_tm1tpfond")
	private Integer nTm1tpfond;

	@Column(name="n_codusumod")
	private String vCodusumod;

	@Column(name="v_codusureg")
	private String vCodusureg;

	@Column(name="v_desfond")
	private String vDesfond;

	@Column(name="v_extimag")
	private String vExtimag;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_nomimagf")
	private String vNomimagf;
	
	@Column(name="v_nomimagfti")
	private String vNomimagfti;

	@Column(name="v_nomfond")
	private String vNomfond;

	@Column(name="v_ubiimagf")
	private String vUbiimagf;
	
	private String v_nomcortoSituacion; 
	private String v_nomcortoRegion;
	private String v_nomcortoTipo;
	
	@Column(name="v_imagtienda")
	private String vImagtienda;
	
	
	@Column(name="n_cantCompra")
	private Integer nCantCompra;
	
	@Column(name="n_swpredeterminado")
	private Integer nSwpredeterminado;
	
	
	public LeotbcFondo() {
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


	public Integer getiValfond() {
		return iValfond;
	}


	public void setiValfond(Integer iValfond) {
		this.iValfond = iValfond;
	}
	
	public Integer getiValgem() {
		return iValgem;
	}


	public void setiValgem(Integer iValgem) {
		this.iValgem = iValgem;
	}


	public Integer getnCodfond() {
		return nCodfond;
	}


	public void setnCodfond(Integer nCodfond) {
		this.nCodfond = nCodfond;
	}


	public Integer getnCodregion() {
		return nCodregion;
	}


	public void setnCodregion(Integer nCodregion) {
		this.nCodregion = nCodregion;
	}


	public Integer getnTm1sitfond() {
		return nTm1sitfond;
	}


	public void setnTm1sitfond(Integer nTm1sitfond) {
		this.nTm1sitfond = nTm1sitfond;
	}


	public Integer getnTm1tpfond() {
		return nTm1tpfond;
	}


	public void setnTm1tpfond(Integer nTm1tpfond) {
		this.nTm1tpfond = nTm1tpfond;
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


	public String getvDesfond() {
		return vDesfond;
	}


	public void setvDesfond(String vDesfond) {
		this.vDesfond = vDesfond;
	}


	public String getvExtimag() {
		return vExtimag;
	}


	public void setvExtimag(String vExtimag) {
		this.vExtimag = vExtimag;
	}

	public String getvNomimagfti() {
		return vNomimagfti;
	}


	public void setvNomimagfti(String vNomimagfti) {
		this.vNomimagfti = vNomimagfti;
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


	public String getvNomimagf() {
		return vNomimagf;
	}


	public void setvNomimagf(String vNomimagf) {
		this.vNomimagf = vNomimagf;
	}


	public String getvNomfond() {
		return vNomfond;
	}


	public void setvNomfond(String vNomfond) {
		this.vNomfond = vNomfond;
	}


	public String getvUbiimagf() {
		return vUbiimagf;
	}


	public void setvUbiimagf(String vUbiimagf) {
		this.vUbiimagf = vUbiimagf;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
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
	
	
	
}
