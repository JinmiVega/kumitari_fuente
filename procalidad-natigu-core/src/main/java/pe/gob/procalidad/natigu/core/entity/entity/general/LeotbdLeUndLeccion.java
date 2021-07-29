package pe.gob.procalidad.natigu.core.entity.entity.general;

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

	@NamedStoredProcedureQuery(name = "leotbdleundleccion.buscar_por_codigo", procedureName = "gene.fun_leotbdleundleccion_buscar_x_codigo", 
			resultClasses = LeotbdLeUndLeccion.class, 
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codundlec", 	type = long.class) 
			}),
	
	@NamedStoredProcedureQuery(name = "leotbdleundleccion.buscar_por_filtros", 
			procedureName = "gene.fun_leotbdleundleccion_buscar_x_filtros", 
			resultClasses = LeotbdLeUndLeccion.class, 
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesuni", 	type = long.class)/*,
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tgm2nivel", 	type = long.class)*/
			}),
			
	@NamedStoredProcedureQuery(name = "leotbdleundleccion.buscar_por_NivelLengua", 
			procedureName = "gene.fun_leotbdleundleccion_buscar_x_NivelLengua", 
			resultClasses = LeotbdLeUndLeccion.class, 
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", 	type = long.class), 				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2subnivel", 	type = long.class)
			}),
			
	@NamedStoredProcedureQuery(name = "leotbdleundleccion.buscar_ultLeccionXlenest",    
			procedureName = "gene.fun_leotbdleundleccion_ultimlecXcodlenest", 
			resultClasses = LeotbdLeUndLeccion.class, 
			parameters = 
			{  
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenest", 	type = long.class) 
			}), 
			
			
	@NamedStoredProcedureQuery(name = "leotbdleundleccion.buscar_ultLeccionXunidad",    
			procedureName = "gene.fun_leotbdleundleccion_ultimlecXcodlesuni", 
			resultClasses = LeotbdLeUndLeccion.class, 
			parameters = 
			{  
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesuni", 	type = long.class) 
			}),
			

	@NamedStoredProcedureQuery(name = "leotbdleundleccion.buscar_por_codigounidad", 
	procedureName = "gene.fun_leotbdleundleccion_buscar_x_codigounidad", 
	resultClasses = LeotbdLeUndLeccion.class, 
	parameters = 
	{
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesuni", 	type = long.class) 
	}),
	
	@NamedStoredProcedureQuery(name = "leotbdleundleccion.existe", 
	procedureName = "gene.fun_leotbdleundleccion_existe", 
	resultClasses = LeotbdLeUndLeccion.class, 
	parameters = 
	{
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codundlec", 	type = long.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomleccion", 	type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesuni", 	type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2leccion", 	type = Integer.class)
	}),
	
	
	@NamedStoredProcedureQuery(name = "leotbdleundleccion.buscar_por_codigolengua", 
			procedureName = "gene.fun_leotbdleundleccion_buscar_x_codigolengua", 
			resultClasses = LeotbdLeUndLeccion.class, 
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tgm2nivel", 	type = long.class)
			}),
	
	@NamedStoredProcedureQuery(name = "leotbdleundleccion.insertar", procedureName = "gene.fun_leotbdleundleccion_insertar", 
			resultClasses = LeotbdLeUndLeccion.class, 
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codleslec", 	type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesuni", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2leccion", 	type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomleccion", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desleccion", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitlec", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg",		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag",		type = String.class)
			})
		
		,
	@NamedStoredProcedureQuery(name = "leotbdleundleccion.eliminar", procedureName = "gene.fun_leotbdleundleccion_eliminar", 
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codleslec", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class) 
			}),
		 
	@NamedStoredProcedureQuery(name = "leotbdleundleccion.actualizar", procedureName = "gene.fun_leotbdleundleccion_actualizar", 
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codleslec", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesuni", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2leccion", 	type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomleccion", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_desleccion", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitlec", 	type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class) 
			})

})


@Entity
@Table(name="leotbd_leundleccion")
public class LeotbdLeUndLeccion implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codundlec")
	private long nCodundlec;
	  
	@Column(name="n_codlesuni")
	private long nCodlesuni ;
	  
	@Column(name="v_nomleccion")
	private String vNomleccion ;
	  
	@Column(name="v_desleccion")
	private String vDesleccion ;
	  
	@Column(name="n_tm1sitlec")
	private int nTm1sitlec ;
	  
	@Column(name="v_flgest")
	private String vFlgest ;
	  
	@Column(name="n_codusureg")
	private long nCodusureg ;
	  
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecreg")
	private Date dFecreg;
	  
	@Column(name="v_hostreg")
	private String vHostreg ;
	  
	@Column(name="n_codusumod")
	private long nCodusumod ;
	  
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecmod")
	private Date dFecmod;
	  
	@Column(name="v_hostmod")
	private String vHostmod;
 
	@Column(name="n_tm2leccion")
	private int nTm2leccion ;
	
	private String v_nomnivel;
	private int    n_tm2nivel;
	private String v_nomsubnivel;
	private String v_nombrecortounidad;
	private String v_unidad;
	private String v_leccion;
	
	private String vNombimagLeccion;
	private String vNombimagBloqueadoLeccion;
	
	@Column(name="n_item")
	private Integer nItem;
	private String v_inicnombre;  
	@Column(name="v_nombimag")
	private String vNombimag;
	
	public LeotbdLeUndLeccion() {
		super();
	}


	public long getnCodundlec() {
		return nCodundlec;

	}


	public void setnCodundlec(long nCodundlec) {
		this.nCodundlec = nCodundlec;
	}


	public long getnCodlesuni() {
		return nCodlesuni;
	}

	public void setnCodlesuni(long nCodlesuni) {
		this.nCodlesuni = nCodlesuni;
	}

	public String getvNomleccion() {
		return vNomleccion;
	}

	public void setvNomleccion(String vNomleccion) {
		this.vNomleccion = vNomleccion;
	}

	public String getvDesleccion() {
		return vDesleccion;
	}

	public void setvDesleccion(String vDesleccion) {
		this.vDesleccion = vDesleccion;
	}

	public int getnTm1sitlec() {
		return nTm1sitlec;
	}

	public void setnTm1sitlec(int nTm1sitlec) {
		this.nTm1sitlec = nTm1sitlec;
	}

	public String getvFlgest() {
		return vFlgest;
	}

	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}

	public long getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(long nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public Date getdFecreg() {
		return dFecreg;
	}

	public void setdFecreg(Date dFecreg) {
		this.dFecreg = dFecreg;
	}

	public String getvHostreg() {
		return vHostreg;
	}

	public void setvHostreg(String vHostreg) {
		this.vHostreg = vHostreg;
	}

	public long getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public Date getdFecmod() {
		return dFecmod;
	}

	public void setdFecmod(Date dFecmod) {
		this.dFecmod = dFecmod;
	}

	public String getvHostmod() {
		return vHostmod;
	}

	public void setvHostmod(String vHostmod) {
		this.vHostmod = vHostmod;
	}

	public String getV_nomnivel() {
		return v_nomnivel;
	}

	public void setV_nomnivel(String v_nomnivel) {
		this.v_nomnivel = v_nomnivel;
	}

	public String getV_nomsubnivel() {
		return v_nomsubnivel;
	}

	public void setV_nomsubnivel(String v_nomsubnivel) {
		this.v_nomsubnivel = v_nomsubnivel;
	}

	public String getV_unidad() {
		return v_unidad;
	}

	public void setV_unidad(String v_unidad) {
		this.v_unidad = v_unidad;
	}

	public String getV_leccion() {
		return v_leccion;
	}

	public void setV_leccion(String v_leccion) {
		this.v_leccion = v_leccion;
	}


	public int getN_tm2nivel() {
		return n_tm2nivel;
	}


	public void setN_tm2nivel(int n_tm2nivel) {
		this.n_tm2nivel = n_tm2nivel;
	}


	public String getV_nombrecortounidad() {
		return v_nombrecortounidad;
	}


	public void setV_nombrecortounidad(String v_nombrecortounidad) {
		this.v_nombrecortounidad = v_nombrecortounidad;
	}


	public int getnTm2leccion() {
		return nTm2leccion;
	}


	public void setnTm2leccion(int nTm2leccion) {
		this.nTm2leccion = nTm2leccion;
	}


	public Integer getnItem() {
		return nItem;
	}


	public void setnItem(Integer nItem) {
		this.nItem = nItem;
	}


	public String getvNombimag() {
		return vNombimag;
	}


	public void setvNombimag(String vNombimag) {
		this.vNombimag = vNombimag;
	}


	public String getvNombimagLeccion() {
		return vNombimagLeccion;
	}


	public void setvNombimagLeccion(String vNombimagLeccion) {
		this.vNombimagLeccion = vNombimagLeccion;
	}


	public String getvNombimagBloqueadoLeccion() {
		return vNombimagBloqueadoLeccion;
	}


	public void setvNombimagBloqueadoLeccion(String vNombimagBloqueadoLeccion) {
		this.vNombimagBloqueadoLeccion = vNombimagBloqueadoLeccion;
	}


	public String getV_inicnombre() {
		return v_inicnombre;
	}


	public void setV_inicnombre(String v_inicnombre) {
		this.v_inicnombre = v_inicnombre;
	}
	
	
	
}
