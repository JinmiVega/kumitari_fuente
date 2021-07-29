package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "leotbcLenguaEstruc.buscar_por_filtros", procedureName = "gene.fun_leotbclengua_buscar_x_filtros", 
				resultClasses = LeotbcLenguaEstruc.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomlengua", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitlen", type = int.class)}), 
				
				@NamedStoredProcedureQuery(name = "leotbcLenguaEstruc.buscarMayorSubnivel", procedureName = "gene.fun_leotbd_lenguaestruc_buscarMayorLenestXNivleng", 
				resultClasses = LeotbcLenguaEstruc.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = Integer.class)}),
		
		@NamedStoredProcedureQuery(name = "leotbcLenguaEstruc.listarPorCodigoNivelLengua", procedureName = "gene.fun_leotbdlenguaestruc_buscar_x_codigolenguaNivel", 
		resultClasses = LeotbcLenguaEstruc.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenniv", type = long.class) }),
		
		
		@NamedStoredProcedureQuery(name = "leotbcLenguaEstruc.insertar", procedureName = "gene.fun_leotbdlenguaestruc_insertar", 
				resultClasses = LeotbcLenguaEstruc.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codlenest", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenniv", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = int.class),
			//	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombnivel", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2subnivel", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitest", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_swactivo", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class) }),
		
		@NamedStoredProcedureQuery(name = "leotbcLenguaEstruc.insertarTemporal", procedureName = "gene.fun_leotbdtemplenguaes_insert", 
		parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class)}),
		 
		@NamedStoredProcedureQuery(name = "leotbcLenguaEstruc.actualizar", procedureName = "gene.fun_leotbdlenguaestruc_actualizar", 
		 		resultClasses = LeotbcLenguaEstruc.class, parameters = { 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenest", type = long.class), 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = Integer.class), 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2subnivel", type = Integer.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitest", type = Integer.class), 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombimag", type = String.class), 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_swactivo", type = String.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)}),
		
		 @NamedStoredProcedureQuery(name = "leotbcLenguaEstruc.eliminar", procedureName = "gene.fun_leotbdlenguaestruc_eliminar", 
	 		resultClasses = LeotbcLenguaEstruc.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)}), 
		 
		 @NamedStoredProcedureQuery(name = "leotbcLenguaEstruc.listarPorCodigoLengua", 
		 procedureName = "gene.fun_leotbdlenguaestruc_buscar_x_codigolengua", 
	 		resultClasses = LeotbcLenguaEstruc.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class) }),
		
		 @NamedStoredProcedureQuery(name = "leotbcLenguaEstruc.existe", 
		 procedureName = "gene.fun_leotbdlenguaestruc_existe", 
	 		resultClasses = LeotbcLenguaEstruc.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenest", type = long.class) ,
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenniv", type = long.class) ,
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2subnivel", type = Integer.class)
	 		
		 }),
		 
		 @NamedStoredProcedureQuery(name = "leotbcLenguaEstruc.buscar_por_codigo", 
		 procedureName = "gene.fun_leotbdlenguaestruc_buscar_x_codigo", 
	 		resultClasses = LeotbcLenguaEstruc.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenest", type = long.class) }),
		 
		 @NamedStoredProcedureQuery(name = "leotbcLenguaEstruc.listarNiveles", 
		 procedureName = "gene.fun_leotbdlenguaestruc_listarNiveles", 
	 		resultClasses = LeotbcLenguaEstruc.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class) }),
		 
		 @NamedStoredProcedureQuery(name = "leotbcLenguaEstruc.listarMateriales", 
		 procedureName = "gene.fun_leotbdlenguaestruc_material_buscar_x_filtros", 
	 		resultClasses = LeotbcLenguaEstruc.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitlen", type = int.class)}),
		 
		 @NamedStoredProcedureQuery(name = "leotbcLenguaEstruc.listarSubNiveles", 
		 procedureName = "gene.fun_leotbdlenguaestruc_listarSubNiveles", 
	 		resultClasses = LeotbcLenguaEstruc.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tgm2Nivel", type = int.class)}),
		 
		 @NamedStoredProcedureQuery(name = "leotbcLenguaEstruc.listarNivelesxlenguaall", 
		 procedureName = "gene.fun_leotbdlenguaestruc_listarnivelesxlenguaall", 
	 		resultClasses = LeotbcLenguaEstruc.class, 
	 		parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class)
	 		})
		
		
		})


@Entity
@Table(name = "leotbd_lenguaestruc")
public class LeotbcLenguaEstruc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecreg;

	@Id
	@Column(name = "n_codlenest")
	private long ncodlenest;
	
	@Column(name = "n_codlengua")
	private long nCodlengua;

	@Column(name = "n_tm1sitest")
	private int nTm1sitest;

	@Column(name = "v_codusumod")
	private int nCodusumod;

	@Column(name = "n_tm2nivel")
	private int nTm2nivel;
	
	@Column(name = "n_tm2subnivel")
	private int nTm2subnivel;
	 
	@Column(name = "v_codusureg")
	private int nCodusureg;

	@Column(name = "v_swactivo")
	private String v_swactivo;
	
	@Column(name = "v_flgest")
	private String vFlgest;

	@Column(name = "v_hostmod")
	private String vHostmod;
	
	@Column(name = "v_nombnivel")
	private String vNombnivel;

	@Column(name = "v_hostreg")
	private String vHostreg;
 
	private String v_nomcortoSituacion;
	private String basico;
	private String intermedio;
	private String avanzado;
	private String v_nomlengua;
	private String v_nombimag;
	private String v_nomnivel;
	private String v_valor2;
	private String v_valor1;
	private String v_valor4;
	private String v_nomsubnivel;
	private int    n_cant_unidad;
	private int    n_cant_leccion;
	private String v_ininomb; 
	public LeotbcLenguaEstruc() {
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

	public long getNCodlengua() {
		return this.nCodlengua;
	}

	public void setNCodlengua(long nCodlengua) {
		this.nCodlengua = nCodlengua;
	}
 
	public long getNcodlenest() {
		return ncodlenest;
	}

	public void setNcodlenest(long ncodlenest) {
		this.ncodlenest = ncodlenest;
	}

	public long getnCodlengua() {
		return nCodlengua;
	}

	public void setnCodlengua(long nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public int getVCodusumod() {
		return this.nCodusumod;
	}

	public void setNCodusumod(int vCodusumod) {
		this.nCodusumod = vCodusumod;
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

	public String getV_nomcortoSituacion() {
		return v_nomcortoSituacion;
	}

	public void setV_nomcortoSituacion(String v_nomcortoSituacion) {
		this.v_nomcortoSituacion = v_nomcortoSituacion;
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
 
	public int getnTm1sitest() {
		return nTm1sitest;
	}

	public void setnTm1sitest(int nTm1sitest) {
		this.nTm1sitest = nTm1sitest;
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

	public String getV_swactivo() {
		return v_swactivo;
	}

	public void setV_swactivo(String v_swactivo) {
		this.v_swactivo = v_swactivo;
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

	public int getnTm2subnivel() {
		return nTm2subnivel;
	}

	public void setnTm2subnivel(int nTm2subnivel) {
		this.nTm2subnivel = nTm2subnivel;
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

	public int getN_cant_leccion() {
		return n_cant_leccion;
	}

	public void setN_cant_leccion(int n_cant_leccion) {
		this.n_cant_leccion = n_cant_leccion;
	}

	public int getN_cant_unidad() {
		return n_cant_unidad;
	}

	public void setN_cant_unidad(int n_cant_unidad) {
		this.n_cant_unidad = n_cant_unidad;
	}

	public String getV_nomlengua() {
		return v_nomlengua;
	}

	public void setV_nomlengua(String v_nomlengua) {
		this.v_nomlengua = v_nomlengua;
	}

	public String getV_nombimag() {
		return v_nombimag;
	}

	public void setV_nombimag(String v_nombimag) {
		this.v_nombimag = v_nombimag;
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

	public String getvNombnivel() {
		return vNombnivel;
	}

	public void setvNombnivel(String vNombnivel) {
		this.vNombnivel = vNombnivel;
	}

	public String getV_valor4() {
		return v_valor4;
	}

	public void setV_valor4(String v_valor4) {
		this.v_valor4 = v_valor4;
	}

	public String getV_ininomb() {
		return v_ininomb;
	}

	public void setV_ininomb(String v_ininomb) {
		this.v_ininomb = v_ininomb;
	}

	public String getV_valor1() {
		return v_valor1;
	}

	public void setV_valor1(String v_valor1) {
		this.v_valor1 = v_valor1;
	}

	public String getV_valor2() {
		return v_valor2;
	}

	public void setV_valor2(String v_valor2) {
		this.v_valor2 = v_valor2;
	} 

}