package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NamedStoredProcedureQueries({
	
	@NamedStoredProcedureQuery(name = "leotbc_textopalabraencerrada.buscar_por_codigo", 
			procedureName = "gene.fun_leotbctextopalabraencerrada_buscar_x_codigo", 
			resultClasses = LeotbcTextopalabraencerrada.class, 
			parameters = {
			   @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtextopalabraence", type = long.class) 
		})
	,
	@NamedStoredProcedureQuery(name = "leotbc_textopalabraencerrada.buscar_por_Matejercicio", 
			procedureName = "gene.fun_leotbctextopalabraencerrada_buscar_x_matejer", 
			resultClasses = LeotbcTextopalabraencerrada.class, 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class) 
		})
	,
	@NamedStoredProcedureQuery(name = "leotbc_textopalabraencerrada.buscar_por_Filtros", 
			procedureName = "gene.fun_leotbctextopalabraencerrada_buscar_x_filtro",
			resultClasses = LeotbcTextopalabraencerrada.class, 
			parameters = {
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class) 
		}),
	@NamedStoredProcedureQuery(name = "leotbc_textopalabraencerrada.insertar", 
			procedureName = "gene.fun_leotbctextopalabraencerrada_insertar", 		
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codtextopalabraence", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_comentario", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_texto", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
		}),
	@NamedStoredProcedureQuery(name = "leotbc_textopalabraencerrada.eliminar", 
			procedureName = "gene.fun_leotbctextopalabraencerrada_eliminar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtextopalabraence", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		}),
	@NamedStoredProcedureQuery(name = "leotbc_textopalabraencerrada.actualizar", 
			procedureName = "gene.fun_leotbctextopalabraencerrada_actualizar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtextopalabraence", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_comentario", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_texto", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		})
})

 
@Entity
@Table(name="leotbc_textopalabraencerrada")
public class LeotbcTextopalabraencerrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codtextopalabraence")
	private long nCodtextopalabraence;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_codmatpej")
	private long nCodmatpej;

	@Column(name="n_codusumod")
	private long nCodusumod;

	@Column(name="n_codusureg")
	private long nCodusureg;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_texto")
	private String vTexto;

	@Column(name="v_titulo")
	private String vTitulo;
	
	@Column(name="v_comentario")
	private String vComentario;

	public LeotbcTextopalabraencerrada() {
	}

	public long getnCodtextopalabraence() {
		return nCodtextopalabraence;
	}

	public void setnCodtextopalabraence(long nCodtextopalabraence) {
		this.nCodtextopalabraence = nCodtextopalabraence;
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

	public long getnCodmatpej() {
		return nCodmatpej;
	}

	public void setnCodmatpej(long nCodmatpej) {
		this.nCodmatpej = nCodmatpej;
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

	public String getvTexto() {
		return vTexto;
	}

	public void setvTexto(String vTexto) {
		this.vTexto = vTexto;
	}

	public String getvTitulo() {
		return vTitulo;
	}

	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}

	public String getvComentario() {
		return vComentario;
	}

	public void setvComentario(String vComentario) {
		this.vComentario = vComentario;
	}
	

	
}