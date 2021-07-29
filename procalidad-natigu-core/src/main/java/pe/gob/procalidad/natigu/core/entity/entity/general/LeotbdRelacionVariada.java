
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
		@NamedStoredProcedureQuery(name = "leotbdrelacion.buscar_por_codrelacion", 
		    procedureName = "gene.fun_leotbdrelacionvari_buscar_x_codrelacion", 
			resultClasses = LeotbdRelacionVariada.class, 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelaci", type = long.class) 
		}),
		@NamedStoredProcedureQuery(name = "leotbdrelacion.buscar_TodoxTEM", procedureName = "gene.fun_leotbdrelacionVariada_listartodo", 
		resultClasses = LeotbdRelacionVariada.class,  						  
		parameters = 
		{
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class) 
		}),
		@NamedStoredProcedureQuery(name = "leotbdrelacion.buscar_por_codrelcab", procedureName = "gene.fun_leotbdrelacionVari_buscar_x_codrelcab", 
			resultClasses = LeotbdRelacionVariada.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelcab", type = long.class) 
		}),
		@NamedStoredProcedureQuery(name = "leotbdrelacion.insertar", procedureName = "gene.fun_leotbdrelacionVari_insertar", 
			resultClasses = LeotbdRelacionVariada.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codrelaci", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelcab", 	type = long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_texto1", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_texto2", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag", 	type = String.class),  
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tiporelaci", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", 		type = String.class) 
		}),
		@NamedStoredProcedureQuery(name = "leotbdrelacion.eliminar", 
		procedureName = "gene.fun_leotbdrelacionVari_eliminar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelaci", 	type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbdrelacion.actualizar", 
		procedureName = "gene.fun_leotbdrelacionVariada_actualizar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelaci", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codrelcab", 	type = long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_texto1", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_texto2", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag", 	type = String.class),  
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tiporelaci",   type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class) 
		}),
		@NamedStoredProcedureQuery(name = "leotbdrelacion.listarTextoTexto", 
		procedureName = "gene.fun_leotbcrelacion_listar_texto", 
		resultClasses = LeotbdRelacionVariada.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tipo", 	 type = int.class)
	}),
		@NamedStoredProcedureQuery(name = "leotbdrelacion.listarCrucigrama", 
		procedureName = "gene.fun_leotbcrelacion_listar_crucigrama", 
		resultClasses = LeotbdRelacionVariada.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class) 
	})
})

@Entity
@Table(name = "leotbd_relacionVariada")
public class LeotbdRelacionVariada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codrelaci")
	private long nCodrelaci;
	
	@Column(name="n_codrelcab")
	private long nCodrelcab; 
	
	@Column(name="v_texto1")
	private String vTexto1;
	
	@Column(name="v_texto2")
	private String vTexto2;
	
	@Column(name="v_nombimag")
	private String vNombimag;
	
	@Column(name="n_orden")
	private Integer nOrden; 
	
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
	 
	private String v_tituloTipo;
	private String v_titulocab;
	private Long n_codmatpej; 
	 

	public LeotbdRelacionVariada() {
		super();
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

	public String getV_tituloTipo() {
		return v_tituloTipo;
	}

	public void setV_tituloTipo(String v_tituloTipo) {
		this.v_tituloTipo = v_tituloTipo;
	}

	public String getV_titulocab() {
		return v_titulocab;
	}

	public void setV_titulocab(String v_titulocab) {
		this.v_titulocab = v_titulocab;
	}

	public Long getN_codmatpej() {
		return n_codmatpej;
	}

	public void setN_codmatpej(Long n_codmatpej) {
		this.n_codmatpej = n_codmatpej;
	}

	 
	
 
	
}