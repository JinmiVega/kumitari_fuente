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

import pe.gob.procalidad.natigu.core.bean.bean.generico.OrdenarParrafoBean;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbc_ordenarparrafo.insertar", 
			procedureName = "gene.fun_leotbcordenarparrafo_insertar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codordenarparrafo", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", 	      type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", 			  type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_parrafo", 			  type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numorden", 		  type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg",		  type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", 		      type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafocab",type = long.class)
			}),
	@NamedStoredProcedureQuery(name = "leotbc_ordenarparrafo.insertarDoc", 
	procedureName = "gene.fun_leotbcordenarparrafo_insertarDoc", 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codordenarparrafo", type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", 	      type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", 			  type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_parrafo", 			  type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ordenar", 		  type = boolean.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg",		  type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", 		      type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafocab",type = long.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_ordenarparrafo.insertarArras", 
		procedureName = "gene.fun_leotbcordenarparrafo_insertarArras", 
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codordenarparrafo", type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", 	      type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", 			  type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_parrafo", 			  type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ordenar", 		  type = boolean.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_posini", 		  type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_posfin", 		  type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg",		  type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", 		      type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafocab",type = long.class)
	}),
	 @NamedStoredProcedureQuery(name = "leotbc_ordenarparrafo.actulizar", 
			procedureName = "gene.fun_leotbcordenarparrafo_actulizar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafo",  type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", 	      type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", 			  type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_parrafo", 			  type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numorden", 		  type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod",		  type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		      type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafocab",type = long.class)
			}),
	 @NamedStoredProcedureQuery(name = "leotbc_ordenarparrafo.actulizarDoc", 
		procedureName = "gene.fun_leotbcordenarparrafo_actulizarDoc", 
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafo",  type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", 	      type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", 			  type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_parrafo", 			  type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ordenar", 		  type = boolean.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod",		  type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		      type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafocab",type = long.class)
		}),
	 @NamedStoredProcedureQuery(name = "leotbc_ordenarparrafo.actulizarArras", 
		procedureName = "gene.fun_leotbcordenarparrafo_actulizararras", 
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafo",  type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", 	      type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", 			  type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_parrafo", 			  type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ordenar", 		  type = boolean.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_posini", 		  type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_posfin", 		  type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod",		  type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		      type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafocab",type = long.class)
		}),
	 @NamedStoredProcedureQuery(name = "leotbc_ordenarparrafo.actulizarOrden", 
		procedureName = "gene.fun_leotbcordenarparrafo_actulizarorden", 
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafo",  type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", 	      type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numorden", 		  type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod",		  type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		      type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafocab",type = long.class)
		}),
	  @NamedStoredProcedureQuery(name = "leotbc_ordenarparrafo.eliminar", 
			procedureName = "gene.fun_leotbcordenarparrafo_eliminar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafo",  type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod",		  type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		      type = String.class)
			}),
	  @NamedStoredProcedureQuery(name = "leotbc_ordenarparrafo.buscarPorCodigo", 
			procedureName = "gene.fun_leotbcordenarparrafo_buscar_x_codigo", 
			resultClasses = LeotbcOrdenarParrafo.class,
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafo",  type = long.class)
			}),
	  @NamedStoredProcedureQuery(name = "leotbc_ordenarparrafo.buscarPorFiltros", 
			procedureName = "gene.fun_leotbcordenarparrafo_buscar_x_filtros", 
			resultClasses = LeotbcOrdenarParrafo.class,
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafocab",  			  type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tipo",  			  				  type = int.class)
			
	  }),
	  @NamedStoredProcedureQuery(name = "leotbc_ordenarparrafo.buscarTodo", 
			procedureName = "gene.fun_leotbcordenarparrafo_listartodo", 
			resultClasses = LeotbcOrdenarParrafo.class,
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej",  			  type = long.class)
			
	  })
			
})
@Entity
@Table(name="leotbc_ordenarparrafo")
public class LeotbcOrdenarParrafo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="n_codordenarparrafo")
	private long nCodordenarparrafo;

	@Column(name="n_codmatpej")
	private long nCodmatpej;

	@Column(name="v_titulo")
	private String vTitulo;
	
	@Column(name="v_titulotipo")
	private String vTitulotipo;

	@Column(name="v_parrafo")
	private String vParrafo;

	@Column(name="n_numorden")
	private Integer nNumorden;
	
	@Column(name="v_ordenar")
	private boolean vOrdenar;
	
	@Column(name="v_posini")
	private int vPosini;
	
	@Column(name="v_posfin")
	private int vPosfin;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	
	@Column(name="n_codusumod")
	private long nCodusumod;

	@Column(name="n_codusureg")
	private long nCodusureg;
	
	@Column(name="n_codordenarparrafocab")
	private long nCodordenarparrafocab;
	
	@Column(name="p_tipo")
	private int pTipo;
	
	
	


	public int getvPosini() {
		return vPosini;
	}

	public void setvPosini(int vPosini) {
		this.vPosini = vPosini;
	}

	public int getvPosfin() {
		return vPosfin;
	}

	public void setvPosfin(int vPosfin) {
		this.vPosfin = vPosfin;
	}

	public LeotbcOrdenarParrafo() {
		super();
	}

	public long getnCodordenarparrafo() {
		return nCodordenarparrafo;
	}

	public void setnCodordenarparrafo(long nCodordenarparrafo) {
		this.nCodordenarparrafo = nCodordenarparrafo;
	}

	public long getnCodmatpej() {
		return nCodmatpej;
	}

	public void setnCodmatpej(long nCodmatpej) {
		this.nCodmatpej = nCodmatpej;
	}

	public String getvTitulo() {
		return vTitulo;
	}

	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}

	public String getvParrafo() {
		return vParrafo;
	}

	public void setvParrafo(String vParrafo) {
		this.vParrafo = vParrafo;
	}

	public Integer getnNumorden() {
		return nNumorden;
	}

	public void setnNumorden(Integer nNumorden) {
		this.nNumorden = nNumorden;
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

	
	public long getnCodordenarparrafocab() {
		return nCodordenarparrafocab;
	}

	public void setnCodordenarparrafocab(long nCodordenarparrafocab) {
		this.nCodordenarparrafocab = nCodordenarparrafocab;
	}
	
	public int getpTipo() {
		return pTipo;
	}

	public void setpTipo(int pTipo) {
		this.pTipo = pTipo;
	}
	
	public String getvTitulotipo() {
		return vTitulotipo;
	}

	public void setvTitulotipo(String vTitulotipo) {
		this.vTitulotipo = vTitulotipo;
	}

	@Override
	public String toString() {
		return "LeotbcOrdenarParrafo [nCodordenarparrafo=" + nCodordenarparrafo
				+ ", nCodmatpej=" + nCodmatpej + ", vTitulo=" + vTitulo
				+ ", vParrafo=" + vParrafo + ", nNumorden=" + nNumorden
				+ ", vHostmod=" + vHostmod + ", vHostreg=" + vHostreg
				+ ", dFecmod=" + dFecmod + ", dFecreg=" + dFecreg
				+ ", nCodusumod=" + nCodusumod + ", nCodusureg=" + nCodusureg
				+ "]";
	}

	public boolean isvOrdenar() {
		return vOrdenar;
	}

	public void setvOrdenar(boolean vOrdenar) {
		this.vOrdenar = vOrdenar;
	}


	
}
