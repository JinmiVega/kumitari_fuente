package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "leotbcLenguaNivel.buscar_por_filtros", procedureName = "gene.fun_leotbclengua_buscar_x_filtros", 
				resultClasses = LeotbcLenguaNivel.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomlengua", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitlen", type = int.class)}),

		@NamedStoredProcedureQuery(name = "leotbcLenguaNivel.insertar", procedureName = "gene.fun_leotbdlenguanivel_insertar", 
				resultClasses = LeotbcLenguaNivel.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codlenniv", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombnivel", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitleniv", type = Integer.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class) }),
		
		@NamedStoredProcedureQuery(name = "leotbcLenguaNivel.insertarTemporal", procedureName = "gene.fun_leotbdtemplenguaes_insert", 
		parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class)}),
		 
		@NamedStoredProcedureQuery(name = "leotbcLenguaNivel.actualizar", procedureName = "gene.fun_leotbdlenguanivel_actualizar", 
		 		resultClasses = LeotbcLenguaNivel.class, parameters = { 
		 				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenniv", type = long.class),
		 				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class), 
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = Integer.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombnivel", type = String.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag", type = String.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitleniv", type = Integer.class), 
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)}),
		
		 @NamedStoredProcedureQuery(name = "leotbcLenguaNivel.eliminar", procedureName = "gene.fun_leotbdlenguanivel_eliminar", 
	 		resultClasses = LeotbcLenguaNivel.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)}), 
		 
		 @NamedStoredProcedureQuery(name = "leotbcLenguaNivel.listarPorCodigoLengua", 
		 procedureName = "gene.fun_leotbdlenguanivel_listar_x_codigolengua", 
	 		resultClasses = LeotbcLenguaNivel.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class) }),
		 
		 @NamedStoredProcedureQuery(name = "leotbcLenguaNivel.existe", 
		 procedureName = "gene.fun_leotbdlenguanivel_existe", 
	 		resultClasses = LeotbcLenguaNivel.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenniv", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = Integer.class)}),
		 
		
		 @NamedStoredProcedureQuery(name = "leotbcLenguaNivel.buscar_por_codigo", 
		 procedureName = "gene.fun_leotbdlenguanivel_buscar_x_codigo", 
	 		resultClasses = LeotbcLenguaNivel.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenniv", type = long.class) }),
		 
		 @NamedStoredProcedureQuery(name = "leotbcLenguaNivel.listarNiveles", 
		 procedureName = "gene.fun_leotbdlenguanivel_listarNiveles", 
	 		resultClasses = LeotbcLenguaNivel.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class) }),
		 
		 @NamedStoredProcedureQuery(name = "leotbcLenguaNivel.listarMateriales", 
		 procedureName = "gene.fun_leotbdlenguanivel_material_buscar_x_filtros", 
	 		resultClasses = LeotbcLenguaNivel.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitlen", type = int.class)}),
		 
		 @NamedStoredProcedureQuery(name = "leotbcLenguaNivel.listarSubNiveles", 
		 procedureName = "gene.fun_leotbdlenguanivel_listarSubNiveles", 
	 		resultClasses = LeotbcLenguaNivel.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tgm2Nivel", type = int.class)}),
		 
		 @NamedStoredProcedureQuery(name = "leotbcLenguaNivel.listarNivelesxlenguaall", 
		 procedureName = "gene.fun_leotbdlenguanivel_listarnivelesxlenguaall", 
	 		resultClasses = LeotbcLenguaNivel.class, 
	 		parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class)
	 		})
		
		
		})


@Entity
@Table(name = "leotbd_lenguaestruc")
public class LeotbcLenguaNivel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecreg;

	@Id
	@Column(name = "n_codlenniv")
	private long nCodlenniv;
	
	@Column(name = "n_codlengua")
	private long nCodlengua;

	@Column(name = "n_tm1sitleniv")
	private int nTm1sitleniv;
  
	@Column(name = "v_nombimag")
	private String vNombimag;
	
	@Column(name = "v_codusumod")
	private int nCodusumod;

	@Column(name = "n_tm2nivel")
	private int nTm2nivel;
	 
	@Column(name = "v_codusureg")
	private int nCodusureg;
 
	@Column(name = "v_flgest")
	private String vFlgest;

	@Column(name = "v_hostmod")
	private String vHostmod;
	
	@Column(name = "v_nombnivel")
	private String vNombnivel;

	@Column(name = "v_hostreg")
	private String vHostreg;
 
	private String v_nomcortoSituacion;
	private String v_nomcortonivel;
	private String basico;
	private String intermedio;
	private String avanzado;
	private String v_nomlengua;  
	private String v_valor4;
	private String v_nomsubnivel; 
	
	public LeotbcLenguaNivel() {
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

	public long getnCodlenniv() {
		return nCodlenniv;
	}

	public void setnCodlenniv(long nCodlenniv) {
		this.nCodlenniv = nCodlenniv;
	}

	public long getnCodlengua() {
		return nCodlengua;
	}

	public void setnCodlengua(long nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public int getnTm1sitleniv() {
		return nTm1sitleniv;
	}

	public void setnTm1sitleniv(int nTm1sitleniv) {
		this.nTm1sitleniv = nTm1sitleniv;
	}

	public String getvNombimag() {
		return vNombimag;
	}

	public void setvNombimag(String vNombimag) {
		this.vNombimag = vNombimag;
	}

	public int getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(int nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public int getnTm2nivel() {
		return nTm2nivel;
	}

	public void setnTm2nivel(int nTm2nivel) {
		this.nTm2nivel = nTm2nivel;
	}

	public int getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(int nCodusureg) {
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

	public String getvNombnivel() {
		return vNombnivel;
	}

	public void setvNombnivel(String vNombnivel) {
		this.vNombnivel = vNombnivel;
	}

	public String getvHostreg() {
		return vHostreg;
	}

	public void setvHostreg(String vHostreg) {
		this.vHostreg = vHostreg;
	}

	public String getV_nomcortoSituacion() {
		return v_nomcortoSituacion;
	}

	public void setV_nomcortoSituacion(String v_nomcortoSituacion) {
		this.v_nomcortoSituacion = v_nomcortoSituacion;
	}

	public String getBasico() {
		return basico;
	}

	public void setBasico(String basico) {
		this.basico = basico;
	}

	public String getIntermedio() {
		return intermedio;
	}

	public void setIntermedio(String intermedio) {
		this.intermedio = intermedio;
	}

	public String getAvanzado() {
		return avanzado;
	}

	public void setAvanzado(String avanzado) {
		this.avanzado = avanzado;
	}

	public String getV_nomlengua() {
		return v_nomlengua;
	}

	public void setV_nomlengua(String v_nomlengua) {
		this.v_nomlengua = v_nomlengua;
	}
  
	public String getV_valor4() {
		return v_valor4;
	}

	public void setV_valor4(String v_valor4) {
		this.v_valor4 = v_valor4;
	}

	public String getV_nomsubnivel() {
		return v_nomsubnivel;
	}

	public void setV_nomsubnivel(String v_nomsubnivel) {
		this.v_nomsubnivel = v_nomsubnivel;
	}

	public String getV_nomcortonivel() {
		return v_nomcortonivel;
	}

	public void setV_nomcortonivel(String v_nomcortonivel) {
		this.v_nomcortonivel = v_nomcortonivel;
	}

	 
}