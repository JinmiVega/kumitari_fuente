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
	@NamedStoredProcedureQuery(name = "leotbc_ordenarparrafocabecera.insertar", 
			procedureName = "gene.fun_leotbcordenarparrafocabecera_insertar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codordenarparrafocab", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", 	      type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", 			  type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg",		  type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", 		      type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_palabra", 		      type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_comentario", 		  type = String.class)
			}),
	 @NamedStoredProcedureQuery(name = "leotbc_ordenarparrafocabecera.actulizar", 
			procedureName = "gene.fun_leotbcordenarparrafocabecera_actulizar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafocab",  type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", 	      type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", 			  type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod",		  type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		      type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_palabra", 		      type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_comentario", 		  type = String.class)
			}),
	  @NamedStoredProcedureQuery(name = "leotbc_ordenarparrafocabecera.eliminar", 
			procedureName = "gene.fun_leotbcordenarparrafocabecera_eliminar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafocab",  type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod",		  type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		      type = String.class)
			}),
	  @NamedStoredProcedureQuery(name = "leotbc_ordenarparrafocabecera.buscarPorCodigo", 
			procedureName = "gene.fun_leotbcordenarparrafocabecera_buscar_x_codigo", 
			resultClasses = LeotbcOrdenarParrafoCabecera.class,
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codordenarparrafocab",  type = long.class)
			}),
	  @NamedStoredProcedureQuery(name = "leotbc_ordenarparrafocabecera.buscarPorFiltros", 
			procedureName = "gene.fun_leotbcordenarparrafocabecera_buscar_x_filtros", 
			resultClasses = LeotbcOrdenarParrafoCabecera.class,
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej",  			  type = long.class)
			})
			
})
@Entity
@Table(name="leotbc_ordenarparrafocabecera")
public class LeotbcOrdenarParrafoCabecera implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="n_codordenarparrafocab")
	private long ncodordenarparrafocab;

	@Column(name="n_codmatpej")
	private long nCodmatpej;

	@Column(name="v_titulo")
	private String vTitulo;


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
	
	@Column(name="v_palabra")
	private String vpalabra;
	
	@Column(name="v_comentario")
	private String vcomentario;

	public LeotbcOrdenarParrafoCabecera() {
		super();
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


	public long getNcodordenarparrafocab() {
		return ncodordenarparrafocab;
	}


	public void setNcodordenarparrafocab(long ncodordenarparrafocab) {
		this.ncodordenarparrafocab = ncodordenarparrafocab;
	}
	

	public String getVpalabra() {
		return vpalabra;
	}


	public void setVpalabra(String vpalabra) {
		this.vpalabra = vpalabra;
	}

	
	public String getVcomentario() {
		return vcomentario;
	}


	public void setVcomentario(String vcomentario) {
		this.vcomentario = vcomentario;
	}


	@Override
	public String toString() {
		return "LeotbcOrdenarParrafoCabecera [ncodordenarparrafocab="
				+ ncodordenarparrafocab + ", nCodmatpej=" + nCodmatpej
				+ ", vTitulo=" + vTitulo + ", vHostmod=" + vHostmod
				+ ", vHostreg=" + vHostreg + ", dFecmod=" + dFecmod
				+ ", dFecreg=" + dFecreg + ", nCodusumod=" + nCodusumod
				+ ", nCodusureg=" + nCodusureg + ", vpalabra=" + vpalabra
				+ ", vcomentario=" + vcomentario + "]";
	}

}
