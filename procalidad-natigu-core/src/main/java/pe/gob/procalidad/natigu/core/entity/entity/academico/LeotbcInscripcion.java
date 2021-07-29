package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;

import java.math.BigDecimal;
import java.util.Date;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbc_inscripcion.buscar_por_filtros", 
			procedureName = "acad.fun_leotbcinscripcion_buscar_x_filtros", 
			resultClasses = LeotbcInscripcion.class, 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2sitin", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuario", type = long.class)
			}),
	@NamedStoredProcedureQuery(name = "leotbc_inscripcion.buscar_por_filtrosxperfil", 
			procedureName = "acad.fun_leotbcinscripcion_buscar_x_filtrosxperfil", 
			resultClasses = LeotbcInscripcion.class, 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2sitin", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuario", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperfil", type = int.class)
	}),

	@NamedStoredProcedureQuery(name = "leotbc_inscripcion.insertar", 
	procedureName = "acad.fun_leotbcinscripcion_insertar",
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codinscri", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numcupos", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2sitin", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_periodo", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numdocum", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomdocum", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_rutadocu", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2ciclo", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fecharegistro", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tipoacceso", type = long.class)
			}),

	 @NamedStoredProcedureQuery(name = "leotbc_inscripcion.actualizar", 
	 procedureName = "acad.fun_leotbcinscripcion_actualizar", 
	 		parameters = { 
		    @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = Integer.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinscri", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_periodo", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numcupos", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2sitin", type = int.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2ciclo", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 		
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fecharegistro", type = Date.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tipoacceso", type = long.class)
	 		}), 
	
	 @NamedStoredProcedureQuery(name = "leotbc_inscripcion.eliminar", 
	 procedureName = "acad.fun_leotbcinscripcion_eliminar",
				resultClasses = LeotbcInscripcion.class, 
 		parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinscr", type = int.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
 		}), 
	 
	 @NamedStoredProcedureQuery(name = "leotbc_inscripcion.buscar_por_codigo", 
	 procedureName = "acad.fun_leotbcinscripcion_buscar_x_codigo", 
 		resultClasses = LeotbcInscripcion.class, 
 		parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinscr", type = int.class) 
 		}),
	 @NamedStoredProcedureQuery(name = "leotbc_inscripcion.getNumcuposXcodInsti_codLengua", 
	 procedureName = "acad.fun_leomvcmatricula_obtenernumcupos_x_codinsti_codlengua", 
 		resultClasses = LeotbcInscripcion.class, 
 		parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = long.class),
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class) 
 		})
})

@Entity
@Table(name="acad.leotbc_inscripcion")
public class LeotbcInscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codinscr")
	private long nCodinscr;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_codinsti")
	private int nCodinsti;

	@Column(name="n_codlengua")
	private int nCodlengua;

	@Column(name="n_codusumod")
	private int nCodusumod;

	@Column(name="n_codusureg")
	private int nCodusureg;

	@Column(name="n_tm2sitin")
	private int nTm2sitin;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_numcupos")
	private String vNumcupos;
	
	@Column(name="v_nominsti")
	private String vNominsti;
	
	@Column(name="v_nomlengua")
	private String vNomlengua;
	
	@Column(name="v_nomcorto")
	private String vnomcorto;
	
	
	
	@Column(name="v_periodo")
	private String vPeriodo;
	
	@Column(name="v_numdocum")
	private String vNumdocum;
	
	@Column(name="v_nomdocum")
	private String vNomdocum;
	
	@Column(name="v_rutadocu")
	private String vRutadocu;
	
	@Column(name="n_tm2ciclo")
	private long nTm2ciclo;
	
	@Column(name="v_nombreciclo")
	private String vnombreciclo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecharegistro")
	private Date dfecharegistro;
	
	@Column(name="vd_fecreg")
	private String vd_fecreg;
	
	@Column(name="vd_fecsincro")
	private String vd_fecsincro;
	
	@Column(name="n_tipoacceso")
	private long nTipoacceso;
	
	@Column(name="v_tipoacceso")
	private String vTipoacceso;
	

	public LeotbcInscripcion() {
	}

	public long getnCodinscr() {
		return nCodinscr;
	}

	public void setnCodinscr(long nCodinscr) {
		this.nCodinscr = nCodinscr;
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

	public int getnCodinsti() {
		return nCodinsti;
	}

	public void setnCodinsti(int nCodinsti) {
		this.nCodinsti = nCodinsti;
	}

	public int getnCodlengua() {
		return nCodlengua;
	}

	public void setnCodlengua(int nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public int getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(int nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public int getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(int nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public int getnTm2sitin() {
		return nTm2sitin;
	}

	public void setnTm2sitin(int nTm2sitin) {
		this.nTm2sitin = nTm2sitin;
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

	public String getvNumcupos() {
		return vNumcupos;
	}

	public void setvNumcupos(String vNumcupos) {
		this.vNumcupos = vNumcupos;
	}

	public String getvNominsti() {
		return vNominsti;
	}

	public void setvNominsti(String vNominsti) {
		this.vNominsti = vNominsti;
	}

	public String getvNomlengua() {
		return vNomlengua;
	}

	public void setvNomlengua(String vNomlengua) {
		this.vNomlengua = vNomlengua;
	}

	public String getVnomcorto() {
		return vnomcorto;
	}

	public void setVnomcorto(String vnomcorto) {
		this.vnomcorto = vnomcorto;
	}

	public String getvPeriodo() {
		return vPeriodo;
	}

	public void setvPeriodo(String vPeriodo) {
		this.vPeriodo = vPeriodo;
	}

	public String getvNumdocum() {
		return vNumdocum;
	}

	public void setvNumdocum(String vNumdocum) {
		this.vNumdocum = vNumdocum;
	}

	public String getvNomdocum() {
		return vNomdocum;
	}

	public void setvNomdocum(String vNomdocum) {
		this.vNomdocum = vNomdocum;
	}

	public String getvRutadocu() {
		return vRutadocu;
	}

	public void setvRutadocu(String vRutadocu) {
		this.vRutadocu = vRutadocu;
	}

	public long getnTm2ciclo() {
		return nTm2ciclo;
	}

	public void setnTm2ciclo(long nTm2ciclo) {
		this.nTm2ciclo = nTm2ciclo;
	}

	public String getVnombreciclo() {
		return vnombreciclo;
	}

	public void setVnombreciclo(String vnombreciclo) {
		this.vnombreciclo = vnombreciclo;
	}

	public Date getDfecharegistro() {
		return dfecharegistro;
	}

	public void setDfecharegistro(Date dfecharegistro) {
		this.dfecharegistro = dfecharegistro;
	}

	public long getnTipoacceso() {
		return nTipoacceso;
	}

	public void setnTipoacceso(long nTipoacceso) {
		this.nTipoacceso = nTipoacceso;
	}

	public String getvTipoacceso() {
		return vTipoacceso;
	}

	public void setvTipoacceso(String vTipoacceso) {
		this.vTipoacceso = vTipoacceso;
	}

	public String getVd_fecreg() {
		return vd_fecreg;
	}

	public void setVd_fecreg(String vd_fecreg) {
		this.vd_fecreg = vd_fecreg;
	}

	public String getVd_fecsincro() {
		return vd_fecsincro;
	}

	public void setVd_fecsincro(String vd_fecsincro) {
		this.vd_fecsincro = vd_fecsincro;
	}
	
	
	


}