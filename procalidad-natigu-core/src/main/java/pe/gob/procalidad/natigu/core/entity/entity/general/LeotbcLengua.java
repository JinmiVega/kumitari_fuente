package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

@NamedStoredProcedureQueries({
	
		@NamedStoredProcedureQuery(name = "leotbcLengua.listarCombo", 
				procedureName = "gene.fun_leotbclengua_listarCombo", 
				resultClasses = LeotbcLengua.class, 
				parameters = {			
	
				}),
	
		@NamedStoredProcedureQuery(name = "leotbcLengua.buscar_por_filtros", procedureName = "gene.fun_leotbclengua_buscar_x_filtros", 
				resultClasses = LeotbcLengua.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomlengua", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitlen", type = int.class)}),
		
		@NamedStoredProcedureQuery(name = "leotbcLengua.existe", procedureName = "gene.fun_leotbclengua_existe", 
				resultClasses = LeotbcLengua.class, parameters = {

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomlengua", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class)}),
		

		@NamedStoredProcedureQuery(name = "leotbcLengua.insertar", procedureName = "gene.fun_leotbcLengua_insertar", 
				resultClasses = LeotbcLengua.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codlengua", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomlengua", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_deslengua", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitlen", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_exteimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ubicimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_pesoimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tamaimag", type = String.class)}),

		 @NamedStoredProcedureQuery(name = "leotbcLengua.actualizar", procedureName = "gene.fun_leotbcLengua_actualizar", 
		 		resultClasses = LeotbcLengua.class, parameters = { 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class), 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomlengua", type = String.class), 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_deslengua", type = String.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitlen", type = int.class), 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_exteimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ubicimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_pesoimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tamaimag", type = String.class)}),
		
		 @NamedStoredProcedureQuery(name = "leotbcLengua.eliminar", procedureName = "gene.fun_leotbcLengua_eliminar", 
	 		resultClasses = LeotbcLengua.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)}), 
		 
		 @NamedStoredProcedureQuery(name = "leotbcLengua.buscar_por_codigo", procedureName = "gene.fun_leotbclengua_buscar_x_codigo", 
	 		resultClasses = LeotbcLengua.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class) }), 

			 @NamedStoredProcedureQuery(name = "leotbcLengua.buscar_por_codigoInstitucion", 
			 procedureName = "gene.fun_leotbclengua_listarcomboxcodigoinsti", 
		 		resultClasses = LeotbcLengua.class, parameters = { 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = long.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_periodo", type = String.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2ciclo", type = int.class)
			 }),

			 @NamedStoredProcedureQuery(name = "leotbcLengua.listarPorCodigoInstitucion", 
			 procedureName = "gene.fun_leotbclengua_listarcomboinslenxcodigoisnti", 
		 		resultClasses = LeotbcLengua.class, parameters = { 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = long.class) }),
		 		
		 		
		 		
		 		@NamedStoredProcedureQuery(name = "leotbcLengua.validaLenguasPorMatricula", 
				procedureName = "gene.fun_leomvcmatricula_validalenguasxmatricula", 
				resultClasses = LeotbcLengua.class,
				parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = long.class)
				}),

		@NamedStoredProcedureQuery(name = "leotbcLengua.listarFaltantePorCodigoInstitucion", 
		 procedureName = "gene.fun_leotbclengua_listarcombofaltanteinslenxcodigoisnti", 
	 		resultClasses = LeotbcLengua.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = long.class) })

})

@Entity
@Table(name = "leotbc_lengua")
public class LeotbcLengua implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecreg;

	@Id
	@Column(name = "n_codlengua")
	private int nCodlengua;

	@Column(name = "n_tm1sitlen")
	private int nCodsitlen;

	@Column(name = "v_codusumod")
	private int nCodusumod;

	@Column(name = "v_codusureg")
	private int nCodusureg;

	@Column(name = "v_flgest")
	private String vFlgest;

	@Column(name = "v_hostmod")
	private String vHostmod;

	@Column(name = "v_hostreg")
	private String vHostreg;

	@Column(name = "v_nomlengua")
	private String vNomlengua;

	@Column(name = "v_deslengua")
	private String vDeslengua;
	
	@Column(name = "v_exteimag")
	private String vExteimag;
	
	@Column(name = "v_ubicimag")
	private String vUbicimag;
	
	@Column(name = "v_nombimag")
	private String vNombimag;
	
	public String getvExteimag() {
		return vExteimag;
	}

	public void setvExteimag(String vExteimag) {
		this.vExteimag = vExteimag;
	}

	@Column(name = "v_pesoimag")
	private String vPesoimag;
	
	@Column(name = "v_tamaimag")
	private String vTamaimag;
	
	@Column(name = "n_codmatri")
	private long n_codmatri;
	
	

	private String v_nomcortoSituacion;
	
	public LeotbcLengua() {
	}

	public Date getDFecmod() {
		return this.dFecmod;
	}

	public void setDFecmod(Date dFecmod) {
		this.dFecmod = dFecmod;
	}

	public Date getDFecreg() {
		return this.dFecreg;
	}

	public void setDFecreg(Date dFecreg) {
		this.dFecreg = dFecreg;
	}

	public int getNCodlengua() {
		return this.nCodlengua;
	}

	public void setNCodlengua(int nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public int getNCodsitlen() {
		return this.nCodsitlen;
	}

	public void setNCodsitlen(int nCodsitlen) {
		this.nCodsitlen = nCodsitlen;
	}

	public int getVCodusumod() {
		return this.nCodusumod;
	}

	public void setNCodusumod(int vCodusumod) {
		this.nCodusumod = vCodusumod;
	}
	public long getN_codmatri() {
		return n_codmatri;
	}

	public void setN_codmatri(long n_codmatri) {
		this.n_codmatri = n_codmatri;
	}
	public int getNCodusureg() {
		return this.nCodusureg;
	}

	public void setNCodusureg(int vCodusureg) {
		this.nCodusureg = vCodusureg;
	}

	public String getVFlgest() {
		return this.vFlgest;
	}

	public void setVFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}

	public String getVHostmod() {
		return this.vHostmod;
	}

	public void setVHostmod(String vHostmod) {
		this.vHostmod = vHostmod;
	}

	public String getVHostreg() {
		return this.vHostreg;
	}

	public void setVHostreg(String vHostreg) {
		this.vHostreg = vHostreg;
	}

	public String getVNomlengua() {
		return this.vNomlengua;
	}

	public void setVNomlengua(String vNomlengua) {
		this.vNomlengua = vNomlengua;
	}

	public String getvDeslengua() {
		return vDeslengua;
	}

	public void setvDeslengua(String vDeslengua) {
		this.vDeslengua = vDeslengua;
	}

	public String getV_nomcortoSituacion() {
		return v_nomcortoSituacion;
	}

	public void setV_nomcortoSituacion(String v_nomcortoSituacion) {
		this.v_nomcortoSituacion = v_nomcortoSituacion;
	}

	public String getvNomlengua() {
		return vNomlengua;
	}

	public void setvNomlengua(String vNomlengua) {
		this.vNomlengua = vNomlengua;
	}

	public String getvUbicimag() {
		return vUbicimag;
	}

	public void setvUbicimag(String vUbicimag) {
		this.vUbicimag = vUbicimag;
	}

	public String getvNombimag() {
		return vNombimag;
	}

	public void setvNombimag(String vNombimag) {
		this.vNombimag = vNombimag;
	}

	public String getvPesoimag() {
		return vPesoimag;
	}

	public void setvPesoimag(String vPesoimag) {
		this.vPesoimag = vPesoimag;
	}

	public String getvTamaimag() {
		return vTamaimag;
	}

	public void setvTamaimag(String vTamaimag) {
		this.vTamaimag = vTamaimag;
	}

}