package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


@NamedStoredProcedureQueries({
	
	@NamedStoredProcedureQuery(name = "leotbd_lenguaunidad.insertar", 
			procedureName = "gene.fun_leotbdlenguaunidad_insertar", 
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codlenunidad",	type = Integer.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua",		type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2unidad",	    type = Integer.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag",	        type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg",	    type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg",	        type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomunidad",	        type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimagbloq",	        type = String.class)
			}
	),
	@NamedStoredProcedureQuery(name = "leotbd_lenguaunidad.actulizar", 
	procedureName = "gene.fun_leotbdlenguaunidad_actualizar", 
	parameters = 
	{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenunidad",	    type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua",		type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2unidad",	    type = Integer.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag",	        type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod",	    type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod",	        type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomunidad",	        type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimagbloq",	        type = String.class)
	}
			),	
	@NamedStoredProcedureQuery(name = "leotbd_lenguaunidad.eliminar", 
	procedureName = "gene.fun_leotbdlenguaunidad_eliminar", 
	parameters = 
	{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenunidad",	    type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod",	    type = long.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod",	        type = String.class)
	}
			),
	@NamedStoredProcedureQuery(name = "leotbd_lenguaunidad.buscarPorCodigo", 
	procedureName = "gene.fun_leotbdlenguaunidad_buscar_x_codigo", 
	resultClasses = LeotbdLenguaUnidad.class,
	parameters = 
	{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenunidad",	    type = long.class)
	}
			),
	@NamedStoredProcedureQuery(name = "leotbd_lenguaunidad.buscarPorFiltros", 
	procedureName = "gene.fun_leotbdlenguaunidad_buscar_x_filtros", 
	resultClasses = LeotbdLenguaUnidad.class,
	parameters = 
	{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua",	    type = long.class)
	}
	),
	
	 @NamedStoredProcedureQuery(name = "leotbd_lenguaunidad.existe", 
	 procedureName = "gene.fun_leotbdlenguaunidad_existe ", 
		resultClasses = LeotbdLenguaUnidad.class, parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenunidad", type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2unidad", type = Integer.class)
	}),
		@NamedStoredProcedureQuery(name = "leotbd_lenguaunidad.actulizarnombrefotoxcod", 
		procedureName = "gene.fun_leotbdlenguaunidad_actulizarnombrefotoxcod", 
		parameters = 
		{
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenunidad",	    type = long.class),
				    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag",	        type = String.class),
				    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimagbloq",	        type = String.class)
		}
				)
}) 


@Entity
@Table(name="gene.leotbd_lenguaunidad")
public class LeotbdLenguaUnidad implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="n_codlenunidad")
	private long nCodlenunidad;	
	
	@Column(name="n_codlengua")
	private long nCodlengua;
	
	@Column(name="n_tm2unidad")
	private Integer nTm2unidad;
	
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
	
	@Column(name="v_nomunidad")
	private String vNomunidad;
	
	@Column(name="v_nomcorto")
	private String vNomcorto;

	@Column(name="v_nombimagbloq")
	private String vNombimagbloq;
	
	public LeotbdLenguaUnidad() {
		super();
	}

	public long getnCodlenunidad() {
		return nCodlenunidad;
	}

	public void setnCodlenunidad(long nCodlenunidad) {
		this.nCodlenunidad = nCodlenunidad;
	}

	public long getnCodlengua() {
		return nCodlengua;
	}

	public void setnCodlengua(long nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public Integer getnTm2unidad() {
		return nTm2unidad;
	}

	public void setnTm2unidad(Integer nTm2unidad) {
		this.nTm2unidad = nTm2unidad;
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

	public String getvNomunidad() {
		return vNomunidad;
	}

	public void setvNomunidad(String vNomunidad) {
		this.vNomunidad = vNomunidad;
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