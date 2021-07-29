package pe.gob.procalidad.natigu.core.entity.entity.general;

 

	import java.io.Serializable;
	import javax.persistence.*; 
	import java.util.Date;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "leotbcMaestra2.listarPorCodigoTabla", 
				procedureName = "gene.fun_leotbcmaestra2_listar_x_codtabla", 
				resultClasses = LeotbcMaestra2.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtabla", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tipo", type = long.class)
				}),
						
		@NamedStoredProcedureQuery(name = "leotbcMaestra2.listarPorValor1", 
				procedureName = "gene.fun_leotbcmaestra2_listar_x_valor01", 
				resultClasses = LeotbcMaestra2.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtabla", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_valor1", type = String.class)})
})

 
	@Entity
	@Table(name="leotbc_maestra2") 
	public class LeotbcMaestra2 implements Serializable {
		private static final Long serialVersionUID = 1L;

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
		private String vCodusureg;

		@Column(name="v_flgest")
		private String vFlgest;

		@Column(name="v_hostmod")
		private String vHostmod;

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

		public LeotbcMaestra2() {
			
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

		public Integer getNOrden() {
			return this.nOrden;
		}

		public void setNOrden(Integer nOrden) {
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

		public String getVCodusureg() {
			return this.vCodusureg;
		}

		public void setVCodusureg(String vCodusureg) {
			this.vCodusureg = vCodusureg;
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

	}