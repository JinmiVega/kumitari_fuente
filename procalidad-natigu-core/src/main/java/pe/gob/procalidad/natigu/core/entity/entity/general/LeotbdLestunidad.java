package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


@NamedStoredProcedureQueries({
	
	@NamedStoredProcedureQuery(name = "leotbdlestunidad.buscar_lengua", procedureName = "gene.fun_leotbdlestunidad_buscarlengua", 
			resultClasses = LeotbdLestunidad.class, parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua",	type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel",		type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2subnivel",	type = long.class)
			}
	),

		@NamedStoredProcedureQuery(name = "leotbdlestunidad.buscar_por_codigo", 
			procedureName = "gene.fun_leotbdlestunidad_buscar_x_codigo", 
			resultClasses = LeotbdLestunidad.class, 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesuni", type = long.class) 
			}),
		@NamedStoredProcedureQuery(name = "leotbdlestunidad.buscar_por_filtros", 
			procedureName = "gene.fun_leotbdlestunidad_buscar_x_filtros", 
			resultClasses = LeotbdLestunidad.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenest", type = long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2unidad", type = long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desunidad", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitund", type = Integer.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomunidad", type = String.class) 
			}),
		@NamedStoredProcedureQuery(name = "leotbdlestunidad.listar_por_codigolengua", 
		procedureName = "gene.fun_leotbdlestunidad_buscar_x_codigolengua", 
		resultClasses = LeotbdLestunidad.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class) 
		}),
		
		@NamedStoredProcedureQuery(name = "leotbdlestunidad.existe", 
		procedureName = "gene.fun_leotbdlestunidad_existe", 
		resultClasses = LeotbdLestunidad.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesuni", type = long.class ) ,
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenest", type = long.class ) ,
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2unidad", type = Integer.class ) ,
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomunidad", type = String.class ) 
		}),
		
		@NamedStoredProcedureQuery(name = "leotbdlestunidad.insertar", 
			procedureName = "gene.fun_leotbdlestunidad_insertar", 
			resultClasses = LeotbdLestunidad.class, 
			parameters = {
					@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codlesuni", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenest", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2unidad", type = Integer.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desunidad", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitund", type = Integer.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomunidad", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Integer.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag", type = String.class) 
			}),
		@NamedStoredProcedureQuery(name = "leotbdlestunidad.eliminar", 
			procedureName = "gene.fun_leotbdlestunidad_eliminar", 
			parameters = {
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesuni", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Integer.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) 
			}),
		@NamedStoredProcedureQuery(name = "leotbdlestunidad.actualizar", 
			procedureName = "gene.fun_leotbdlestunidad_actualizar", 
			parameters = {
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesuni", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenest", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2unidad", type = int.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desunidad", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitund", type = int.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomunidad", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag", type = String.class)
			})
}) 


@Entity
@Table(name="leotbd_lestunidad")
public class LeotbdLestunidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="d_fecmod")
	private Timestamp dFecmod;

	@Column(name="d_fecreg")
	private Timestamp dFecreg;
	
	@Column(name="n_codlenest")
	private long nCodlenest;
	@Id
	@Column(name="n_codlesuni")
	private long nCodlesuni;

	@Column(name="n_codusumod")
	private Integer nCodusumod;

	@Column(name="n_codusureg")
	private Integer nCodusureg;

	@Column(name="n_tm1sitund")
	private Integer nTm1sitund;

	@Column(name="n_tm2unidad")
	private Integer nTm2unidad;

	@Column(name="v_desunidad")
	private String vDesunidad;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_nomunidad")
	private String vNomunidad;
	
	//PARA BUSCAR LA LENGUA
	@Column(name="n_codlengua")
	private long nCodlengua;
	
	@Column(name="v_nomlengua")
	private String vNomlengua;

	private String v_nomsubnivel;
	private String v_nomnivel;
	private String v_nomleccion;
	private String v_nomcortounidad;
	private int n_tm2nivel;
	
	@Column(name="v_nombimag")
	private String vNombimag;
	private String v_inicnombre;  
	private String vNombimagUnidad;
	private String vNombimagBloqueadoUnidad;
	
	public LeotbdLestunidad() {
	}

	public Timestamp getdFecmod() {
		return dFecmod;
	}

	public void setdFecmod(Timestamp dFecmod) {
		this.dFecmod = dFecmod;
	}

	public Timestamp getdFecreg() {
		return dFecreg;
	}

	public void setdFecreg(Timestamp dFecreg) {
		this.dFecreg = dFecreg;
	}

	public long getnCodlenest() {
		return nCodlenest;
	}

	public void setnCodlenest(long nCodlenest) {
		this.nCodlenest = nCodlenest;
	}

	public long getnCodlesuni() {
		return nCodlesuni;
	}

	public void setnCodlesuni(long nCodlesuni) {
		this.nCodlesuni = nCodlesuni;
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

	public Integer getnTm1sitund() {
		return nTm1sitund;
	}

	public void setnTm1sitund(Integer nTm1sitund) {
		this.nTm1sitund = nTm1sitund;
	}

	public Integer getnTm2unidad() {
		return nTm2unidad;
	}

	public void setnTm2unidad(Integer nTm2unidad) {
		this.nTm2unidad = nTm2unidad;
	}

	public String getvDesunidad() {
		return vDesunidad;
	}

	public void setvDesunidad(String vDesunidad) {
		this.vDesunidad = vDesunidad;
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

	public String getvNomunidad() {
		return vNomunidad;
	}

	public void setvNomunidad(String vNomunidad) {
		this.vNomunidad = vNomunidad;
	}

	public long getnCodlengua() {
		return nCodlengua;
	}

	public void setnCodlengua(long nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public String getvNomlengua() {
		return vNomlengua;
	}

	public void setvNomlengua(String vNomlengua) {
		this.vNomlengua = vNomlengua;
	}

	public String getV_nomsubnivel() {
		return v_nomsubnivel;
	}

	public void setV_nomsubnivel(String v_nomsubnivel) {
		this.v_nomsubnivel = v_nomsubnivel;
	}

	public String getV_nomnivel() {
		return v_nomnivel;
	}

	public void setV_nomnivel(String v_nomnivel) {
		this.v_nomnivel = v_nomnivel;
	}

	public String getV_nomcortounidad() {
		return v_nomcortounidad;
	}

	public void setV_nomcortounidad(String v_nomcortounidad) {
		this.v_nomcortounidad = v_nomcortounidad;
	}

	public int getN_tm2nivel() {
		return n_tm2nivel;
	}

	public void setN_tm2nivel(int n_tm2nivel) {
		this.n_tm2nivel = n_tm2nivel;
	}

	public String getV_nomleccion() {
		return v_nomleccion;
	}

	public void setV_nomleccion(String v_nomleccion) {
		this.v_nomleccion = v_nomleccion;
	}

	public String getvNombimag() {
		return vNombimag;
	}

	public void setvNombimag(String vNombimag) {
		this.vNombimag = vNombimag;
	}

	public String getvNombimagUnidad() {
		return vNombimagUnidad;
	}

	public void setvNombimagUnidad(String vNombimagUnidad) {
		this.vNombimagUnidad = vNombimagUnidad;
	}

	public String getvNombimagBloqueadoUnidad() {
		return vNombimagBloqueadoUnidad;
	}

	public void setvNombimagBloqueadoUnidad(String vNombimagBloqueadoUnidad) {
		this.vNombimagBloqueadoUnidad = vNombimagBloqueadoUnidad;
	}

	public String getV_inicnombre() {
		return v_inicnombre;
	}

	public void setV_inicnombre(String v_inicnombre) {
		this.v_inicnombre = v_inicnombre;
	}

	
}