package pe.gob.procalidad.natigu.core.entity.entity.configuracion;

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
	@NamedStoredProcedureQuery(name = "leotbccombocab.buscar_todos", procedureName = "conf.fun_leotbcombocab_buscar_todos", 
			resultClasses = LeotbcComboCab.class, parameters = {
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = long.class) 
			}),
	@NamedStoredProcedureQuery(name = "leotbccombocab.buscar_por_codigo", procedureName = "conf.fun_leotbcombocab_buscar_x_codigo", 
	resultClasses = LeotbcComboCab.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_combocab", type = long.class) 
	}),@NamedStoredProcedureQuery(name = "leotbccombocab.buscar_x_filtros", procedureName = "conf.fun_leotbcombocab_buscar_x_filtros", 
		resultClasses = LeotbcComboCab.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitcombo", type = String.class)
		}),
	@NamedStoredProcedureQuery(name = "leotbccombocab.buscar_x_alummno", procedureName = "conf.fun_leotbcombocab_buscar_x_alumno", 
	resultClasses = LeotbcComboCab.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Integer.class)
	}),
		@NamedStoredProcedureQuery(name = "leotbccombocab.insertar", procedureName = "conf.fun_leotbcombocab_insertar", 
			resultClasses = LeotbcComboCab.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_combocab", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_descripcion", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomimg", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_monto", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmasco", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codfond", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_monedas", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_gemas", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitcombo", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", 		type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbccombocab.eliminar", procedureName = "conf.fun_leotbcombocab_eliminar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_combocab", 	type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbccombocab.actualizar", procedureName = "conf.fun_leotbcombocab_actualizar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_combocab", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_titulo", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_descripcion", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomimg", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_monto", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmasco", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codfond", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_monedas", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_gemas", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitcombo", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 		type = String.class)
		})
})
@Entity
@Table(name="leotbc_combocab")
public class LeotbcComboCab  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	
	@Id
	@Column(name="n_combocab")
	private Integer nCmbocab;

	@Column(name="n_codmatpej")
	private String nCodmatpej;
	
	@Column(name="v_titulo")
	private String vTitulo;
	
	@Column(name="v_descripcion")
	private String vDescripcion;

	@Column(name="v_nomimg")
	private String vNomimg;
	
	@Column(name="v_monto")
	private long vMonto;
	
	@Column(name="n_codmasco")
	private Integer nCodmasco;
	
	@Column(name="n_codfond")
	private Integer nCodfond;
	
	@Column(name="n_monedas")
	private Integer nMonedas;
	
	@Column(name="n_gemas")
	private Integer nGemas;
	
	@Column(name="n_tm1sitcombo")
	private Integer nTm1sitcombo;
	
	@Column(name="n_codusumod")
	private Integer nCodusumod;

	@Column(name="n_codusureg")
	private Integer nCodusureg; 

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	private String v_nomcorto;
	private String v_nommasco;
	private String v_nomfond;
	private Integer v_cantcomprada;
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

	public Integer getnCmbocab() {
		return nCmbocab;
	}

	public void setnCmbocab(Integer nCmbocab) {
		this.nCmbocab = nCmbocab;
	}

	public String getnCodmatpej() {
		return nCodmatpej;
	}

	public void setnCodmatpej(String nCodmatpej) {
		this.nCodmatpej = nCodmatpej;
	}

	public String getvTitulo() {
		return vTitulo;
	}

	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}

	public String getvDescripcion() {
		return vDescripcion;
	}

	public void setvDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

	public String getvNomimg() {
		return vNomimg;
	}

	public void setvNomimg(String vNomimg) {
		this.vNomimg = vNomimg;
	}

	public long getvMonto() {
		return vMonto;
	}

	public void setvMonto(long vMonto) {
		this.vMonto = vMonto;
	}

	public Integer getnTm1sitcombo() {
		return nTm1sitcombo;
	}

	public void setnTm1sitcombo(Integer nTm1sitcombo) {
		this.nTm1sitcombo = nTm1sitcombo;
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

	public Integer getnMonedas() {
		return nMonedas;
	}

	public void setnMonedas(Integer nMonedas) {
		this.nMonedas = nMonedas;
	}

	public Integer getnGemas() {
		return nGemas;
	}

	public void setnGemas(Integer nGemas) {
		this.nGemas = nGemas;
	}

	public Integer getnCodmasco() {
		return nCodmasco;
	}

	public void setnCodmasco(Integer nCodmasco) {
		this.nCodmasco = nCodmasco;
	}

	public Integer getnCodfond() {
		return nCodfond;
	}

	public void setnCodfond(Integer nCodfond) {
		this.nCodfond = nCodfond;
	}

	public String getV_nomcorto() {
		return v_nomcorto;
	}

	public void setV_nomcorto(String v_nomcorto) {
		this.v_nomcorto = v_nomcorto;
	}

	public String getV_nommasco() {
		return v_nommasco;
	}

	public void setV_nommasco(String v_nommasco) {
		this.v_nommasco = v_nommasco;
	}

	public String getV_nomfond() {
		return v_nomfond;
	}

	public void setV_nomfond(String v_nomfond) {
		this.v_nomfond = v_nomfond;
	}

	public Integer getV_cantcomprada() {
		return v_cantcomprada;
	}

	public void setV_cantcomprada(Integer v_cantcomprada) {
		this.v_cantcomprada = v_cantcomprada;
	}

	
	

	
}
