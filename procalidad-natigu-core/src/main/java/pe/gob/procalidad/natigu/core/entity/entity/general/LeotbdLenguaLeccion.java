package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


@NamedStoredProcedureQueries({
	
	@NamedStoredProcedureQuery(name = "leotbd_lengualeccion.insertar", 
			procedureName = "gene.fun_leotbdlengualeccion_insertar", 
			parameters = 
			{
						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codlenleccion",	type = Integer.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua",		type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2leccion",	    type = Integer.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag",	        type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomleccion",	    type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg",	    type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg",	        type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimagbloq",	    type = String.class)
				
			}
	),
	@NamedStoredProcedureQuery(name = "leotbd_lengualeccion.actulizar", 
	procedureName = "gene.fun_leotbdlengualeccion_actualizar", 
	parameters = 
	{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenleccion",	    type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua",		type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2leccion",	    type = Integer.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomleccion",	    type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag",	        type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod",	    type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod",	        type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimagbloq",	    type = String.class)
	}
			),	
	@NamedStoredProcedureQuery(name = "leotbd_lengualeccion.eliminar", 
	procedureName = "gene.fun_leotbdlengualeccion_eliminar", 
	parameters = 
	{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenleccion",	    type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod",	    type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod",	        type = String.class)
	}
			),
	@NamedStoredProcedureQuery(name = "leotbd_lengualeccion.buscarPorCodigo", 
	procedureName = "gene.fun_leotbdlengualeccion_buscar_x_codigo", 
	resultClasses = LeotbdLenguaLeccion.class,
	parameters = 
	{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenleccion",	    type = long.class)
	}
			),
	@NamedStoredProcedureQuery(name = "leotbd_lengualeccion.buscarPorFiltros", 
	procedureName = "gene.fun_leotbdlengualeccion_buscar_x_filtros", 
	resultClasses = LeotbdLenguaLeccion.class,
	parameters = 
	{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua",	    type = long.class)
	}
	),
	
	 @NamedStoredProcedureQuery(name = "leotbd_lengualeccion.existe", 
	 procedureName = " gene.fun_leotbdlengualeccion_existe", 
		resultClasses = LeotbdLenguaLeccion.class, parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenleccion", type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2leccion", type = Integer.class)
	})
	,
	@NamedStoredProcedureQuery(name = "leotbd_lengualeccion.actulizarnombxcod", 
	procedureName = "gene.fun_leotbdlengualeccion_actulizarnombxcod", 
	parameters = 
	{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenleccion",	    type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag",	        type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimagbloq",	    type = String.class)
	}
			)	
}) 
@Entity
@Table(name="gene.leotbd_lengualeccion")
public class LeotbdLenguaLeccion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="n_codlenleccion")
	private long nCodlenleccion;	
	
	@Column(name="n_codlengua")
	private long nCodlengua;
	
	@Column(name="n_tm2leccion")
	private Integer nTm2leccion;
	
	@Column(name="v_nombimag")
	private String vNombimag;
	
	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="n_codusumod")
	private long nCodusumod;

	@Column(name="n_codusureg")
	private long nCodusureg;
	
	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;	
	
	@Column(name="d_fecmod")
	private Timestamp dFecmod;

	@Column(name="d_fecreg")
	private Timestamp dFecreg;
	
	@Column(name="v_nomleccion")
	private String vNomleccion;
	
	@Column(name="v_nomcorto")
	private String vNomcorto;
	
	@Column(name="v_nombimagbloq")
	private String vNombimagbloq;

	public LeotbdLenguaLeccion() {
		super();
	}

	public long getnCodlenleccion() {
		return nCodlenleccion;
	}

	public void setnCodlenleccion(long nCodlenleccion) {
		this.nCodlenleccion = nCodlenleccion;
	}

	public long getnCodlengua() {
		return nCodlengua;
	}

	public void setnCodlengua(long nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public Integer getnTm2leccion() {
		return nTm2leccion;
	}

	public void setnTm2leccion(Integer nTm2leccion) {
		this.nTm2leccion = nTm2leccion;
	}

	public String getvNombimag() {
		return vNombimag;
	}

	public void setvNombimag(String vNombimag) {
		this.vNombimag = vNombimag;
	}

	public String getvFlgest() {
		return vFlgest;
	}

	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}

	public long getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public long getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(long nCodusureg) {
		this.nCodusureg = nCodusureg;
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

	public String getvNomleccion() {
		return vNomleccion;
	}

	public void setvNomleccion(String vNomleccion) {
		this.vNomleccion = vNomleccion;
	}

	public String getvNomcorto() {
		return vNomcorto;
	}

	public void setvNomcorto(String vNomcorto) {
		this.vNomcorto = vNomcorto;
	}

	public String getvNombimagbloq() {
		return vNombimagbloq;
	}

	public void setvNombimagbloq(String vNombimagbloq) {
		this.vNombimagbloq = vNombimagbloq;
	}

	
	
}