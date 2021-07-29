package pe.gob.procalidad.natigu.core.entity.entity.general;
 
	import java.io.Serializable;

import javax.persistence.*;  

import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcMascota;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcPremio;

import java.util.Date;

@SuppressWarnings("serial")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "leotbcMaestra1.listarPorCodigoTabla", procedureName = "gene.fun_leotbcmaestra1_listar_x_codtabla", 
				resultClasses = LeotbcMaestra1.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtabla", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tipo", type = long.class)
		}),
				
		@NamedStoredProcedureQuery(name = "leotbcMaestra1.listar",
				procedureName = "gene.fun_leotbcmaestra_buscar_x_filtros", 
				resultClasses = LeotbcMaestra1.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtabla", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomcorto", type = String.class)}),
				
		@NamedStoredProcedureQuery(name = "leotbcMaestra1.listarComboGeneral",
				procedureName = "gene.fun_leotbcmaestra_listarCombos_codigotabla", 
				resultClasses = LeotbcMaestra1.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregis", type = String.class)
		}),

		@NamedStoredProcedureQuery(name = "leotbcMaestra1.actualizar", procedureName = "gene.fun_leotbcmaestras_actualizar", 
		 		resultClasses = LeotbcMaestra1.class, parameters = { 

	 			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregis", type = int.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtabla", type = String.class),  
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomcorto", type = String.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomlargo", type = String.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_valor1", type = String.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_valor2", type = String.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_valor3", type = String.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fileimg", type = String.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_orden", type = int.class),
		}), 

		 @NamedStoredProcedureQuery(name = "leotbcMaestra1.insertar", procedureName = "gene.fun_leotbcmaestras2_insertar", 
				resultClasses = LeotbcMaestra1.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codregis", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtabla", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomcorto", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomlargo", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_valor1", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_valor2", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_valor3", type = String.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fileimg", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_orden", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class),
		 
		 
		 }),
				
		@NamedStoredProcedureQuery(name = "leotbcMaestra.eliminar", procedureName = "gene.fun_leotbcmaestras_eliminar", 
		 		resultClasses = LeotbcMaestra1.class, parameters = {   
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = int.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtabla", type = String.class), 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregis", type = Integer.class) }), 
//				 
		 @NamedStoredProcedureQuery(name = "leotbcMaestra1.buscarXcod_Tabla_Registro", procedureName = "gene.fun_leotbcmaestra_buscar_x_codRegistro_codTabla", 
		 		resultClasses = LeotbcMaestra1.class, parameters = { 
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtabla", type = String.class),
		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregis", type = Integer.class) }),  
		 		
	//
})

 
	@Entity
	@Table(name="leotbc_maestra1") 
	public class LeotbcMaestra1 implements Serializable {
		private static final long serialVersionUID = 1L;

		@Temporal(TemporalType.DATE)
		@Column(name="d_fecmod")
		private Date dFecmod;

		@Temporal(TemporalType.DATE)
		@Column(name="d_fecreg")
		private Date dFecreg;
		
		@Column(name="n_codmae")
		private int nCodmae;

		@Id
		@Column(name="n_codregis")
		private Long nCodregis;

		@Column(name="n_orden")
		private int nOrden;

		@Column(name="v_codtabla")
		private String vCodtabla;

		@Column(name="v_codusumod")
		private String vCodusumod;

		@Column(name="v_codusureg")
		private Long vCodusureg;

		@Column(name="v_flgest")
		private String vFlgest;

		@Column(name="v_hostmod")
		private String vHostmod;
		
		@Column(name="v_sweditable")
		private String vSweditable;
		
		@Column(name="v_sweliminar")
		private String vSweliminar;

		@Column(name="v_hostreg")
		private String vHostreg;

		@Column(name="v_nomcorto")
		private String vNomcorto;

		@Column(name="v_nomlargo")
		private String vNomlargo;

		@Column(name="v_valor1")
		private String vValor1;

		@Column(name="v_valor2")
		private String vValor2;

		@Column(name="v_valor3")
		private String vValor3;
		 
		private String v_descripcion;
		
		@Column(name="v_fileimg")
		private String vFileimg;

		public LeotbcMaestra1() {
			
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

		public int getNCodmae() {
			return this.nCodmae;
		}

		public void setNCodmae(int nCodmae) {
			this.nCodmae = nCodmae;
		}

		public Long getNCodregis() {
			return this.nCodregis;
		}

		public void setNCodregis(Long nCodregis) {
			this.nCodregis = nCodregis;
		}

		public int getNOrden() {
			return this.nOrden;
		}

		public void setNOrden(int nOrden) {
			this.nOrden = nOrden;
		}

		public String getVCodtabla() {
			return this.vCodtabla;
		}

		public void setVCodtabla(String vCodtabla) {
			this.vCodtabla = vCodtabla;
		}

		public String getVCodusumod() {
			return this.vCodusumod;
		}

		public void setVCodusumod(String vCodusumod) {
			this.vCodusumod = vCodusumod;
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

		public String getVNomcorto() {
			return this.vNomcorto;
		}

		public void setVNomcorto(String vNomcorto) {
			this.vNomcorto = vNomcorto;
		}

		public String getVNomlargo() {
			return this.vNomlargo;
		}

		public void setVNomlargo(String vNomlargo) {
			this.vNomlargo = vNomlargo;
		}

		public String getVValor1() {
			return this.vValor1;
		}

		public void setVValor1(String vValor1) {
			this.vValor1 = vValor1;
		}

		public String getVValor2() {
			return this.vValor2;
		}

		public void setVValor2(String vValor2) {
			this.vValor2 = vValor2;
		}

		public String getVValor3() {
			return this.vValor3;
		}

		public void setVValor3(String vValor3) {
			this.vValor3 = vValor3;
		}

		public Long getvCodusureg() {
			return vCodusureg;
		}

		public void setvCodusureg(Long vCodusureg) {
			this.vCodusureg = vCodusureg;
		}

		public String getvSweditable() {
			return vSweditable;
		}

		public void setvSweditable(String vSweditable) {
			this.vSweditable = vSweditable;
		}

		public String getvSweliminar() {
			return vSweliminar;
		}

		public void setvSweliminar(String vSweliminar) {
			this.vSweliminar = vSweliminar;
		}

		public String getvFileimg() {
			return vFileimg;
		}

		public void setvFileimg(String vFileimg) {
			this.vFileimg = vFileimg;
		}

		public String getV_descripcion() {
			return v_descripcion;
		}

		public void setV_descripcion(String v_descripcion) {
			this.v_descripcion = v_descripcion;
		}

		 
	}