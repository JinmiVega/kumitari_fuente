
package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "leotbcrelacion.buscar_por_codrelacion", 
		    procedureName = "gene.fun_leotbcrelacion_buscar_x_codrelacion", 
			resultClasses = LeotbcRelacion.class, 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelaci", type = long.class) 
		}),
		@NamedStoredProcedureQuery(name = "leotbcrelacion.buscar_por_codrelcab", procedureName = "gene.fun_leotbcrelacion_buscar_x_codrelcab", 
			resultClasses = LeotbcRelacion.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelcab", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tipo", type = int.class) 
				
		}),
		@NamedStoredProcedureQuery(name = "leotbcrelacion.insertar", procedureName = "gene.fun_leotbcrelacion_insertar", 
			resultClasses = LeotbcRelacion.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codrelaci", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelcab", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_palabra", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_texto1", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_texto2", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_orientacion", 	type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_orden", 		type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tiporelaci", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_texto3", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_parrafo", 		type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbcrelacion.eliminar", 
		procedureName = "gene.fun_leotbcrelacion_eliminar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelaci", 	type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbcrelacion.actualizar", 
		procedureName = "gene.fun_leotbcrelacion_actualizar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelaci", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelcab", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_palabra", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_texto1", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_texto2", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_orientacion",  type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_orden", 		type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tiporelaci",   type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_texto3", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_parrafo", 		type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbcrelacion.listarTextoTexto", 
		procedureName = "gene.fun_leotbcrelacion_listar_texto", 
		resultClasses = LeotbcRelacion.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tipo", 	 type = int.class)
	}),@NamedStoredProcedureQuery(name = "leotbcrelacion.listarTextoParrafo", 
	procedureName = "gene.fun_leotbcrelacion_listar_texto_parrafo", 
	resultClasses = LeotbcRelacion.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tipo", 	 type = int.class)
}),
		@NamedStoredProcedureQuery(name = "leotbcrelacion.listarCrucigrama", 
		procedureName = "gene.fun_leotbcrelacion_listar_crucig", 
		resultClasses = LeotbcRelacion.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class) 
	}),
	@NamedStoredProcedureQuery(name = "leotbcrelacion.listarRelacionTodo", 
	procedureName = "gene.fun_leotbcrelacion_buscar_listartodo", 
	resultClasses = LeotbcRelacion.class, 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class) 
})
})

@Entity
@Table(name = "leotbc_relacion")
public class LeotbcRelacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codrelaci")
	private long nCodrelaci;
	
	@Column(name="n_codrelcab")
	private long nCodrelcab;
	
	@Column(name="v_palabra")
	private String vPalabra;
	
	@Column(name="v_texto1")
	private String vTexto1;
	
	@Column(name="v_texto2")
	private String vTexto2;
	
	@Column(name="v_nombimag")
	private String vNombimag;
	
	@Column(name="n_orden")
	private Integer nOrden;

	@Column(name="n_orientacion")
	private Integer nOrientacion;
	
	@Column(name="n_tiporelaci")
	private int nTiporelaci;
	
	@Column(name="v_flgest")
	private String vFlgest;
	
	@Column(name="n_codusureg")
	private long nCodusureg;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecreg")
	private Date dFecreg;
	
	@Column(name="v_hostreg")
	private String vHostreg;
	
	@Column(name="n_codusumod")
	private long nCodusumod;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecmod")
	private Date dFecmod;
	
	@Column(name="v_hostmod")
	private String vHostmod;
	
	@Column(name="v_texto3")
	private String vtexto3;
	
	@Column(name="v_parrafo")
	private String vParrafo;

	private String v_titulo; 
	private String vtituloMatxTipoEje; 
	private int tipo;
	private  Integer n_cantletr;
	private String v_palabraSeparada; 
	
	public LeotbcRelacion() {
		super();
	}

	public String getVtituloMatxTipoEje() {
		return vtituloMatxTipoEje;
	}

	public void setVtituloMatxTipoEje(String vtituloMatxTipoEje) {
		this.vtituloMatxTipoEje = vtituloMatxTipoEje;
	}
	public long getnCodrelaci() {
		return nCodrelaci;
	}

	public void setnCodrelaci(long nCodrelaci) {
		this.nCodrelaci = nCodrelaci;
	}

	public long getnCodrelcab() {
		return nCodrelcab;
	}

	public void setnCodrelcab(long nCodrelcab) {
		this.nCodrelcab = nCodrelcab;
	}

	public String getvPalabra() {
		return vPalabra;
	}

	public void setvPalabra(String vPalabra) {
		this.vPalabra = vPalabra;
	}

	public String getvTexto1() {
		return vTexto1;
	}

	public void setvTexto1(String vTexto1) {
		this.vTexto1 = vTexto1;
	}

	public String getvTexto2() {
		return vTexto2;
	}

	public void setvTexto2(String vTexto2) {
		this.vTexto2 = vTexto2;
	}

	public String getvNombimag() {
		return vNombimag;
	}

	public void setvNombimag(String vNombimag) {
		this.vNombimag = vNombimag;
	}

	public Integer getnOrden() {
		return nOrden;
	}

	public void setnOrden(Integer nOrden) {
		this.nOrden = nOrden;
	}

	public Integer getnOrientacion() {
		return nOrientacion;
	}

	public void setnOrientacion(Integer nOrientacion) {
		this.nOrientacion = nOrientacion;
	}

	public int getnTiporelaci() {
		return nTiporelaci;
	}

	public void setnTiporelaci(int nTiporelaci) {
		this.nTiporelaci = nTiporelaci;
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

	public String getVtexto3() {
		return vtexto3;
	}

	public void setVtexto3(String vtexto3) {
		this.vtexto3 = vtexto3;
	}

	public String getvParrafo() {
		return vParrafo;
	}

	public void setvParrafo(String vParrafo) {
		this.vParrafo = vParrafo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getV_titulo() {
		return v_titulo;
	}

	public void setV_titulo(String v_titulo) {
		this.v_titulo = v_titulo;
	}

	public Integer getN_cantletr() {
		return n_cantletr;
	}

	public void setN_cantletr(Integer n_cantletr) {
		this.n_cantletr = n_cantletr;
	}

	public String getV_palabraSeparada() {
		return v_palabraSeparada;
	}

	public void setV_palabraSeparada(String v_palabraSeparada) {
		this.v_palabraSeparada = v_palabraSeparada;
	}
	
	
}