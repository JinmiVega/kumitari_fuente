package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
	
@NamedStoredProcedureQueries({
	
	@NamedStoredProcedureQuery(name = "leotbd_insclengua.insertar", 
	procedureName = "acad.fun_leotbdinsclengua_insertar",
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codinsclen", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinscr", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numcupos", type = String.class),
			
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = int.class)
			}),

	 @NamedStoredProcedureQuery(name = "leotbd_insclengua.actualizar", 
	 procedureName = "acad.fun_leotbdinsclengua_actualizar", 
	 		parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsclen", type = Integer.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numcupos", type = String.class),
	 		
	 				
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 		
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) ,
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = int.class)
	 		}), 
	
	 @NamedStoredProcedureQuery(name = "leotbd_insclengua.eliminar", 
	 procedureName = "acad.fun_leotbdinsclengua_eliminar",
 		parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsclen", type = long.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
 		}), 
	 
	 @NamedStoredProcedureQuery(name = "leotbd_insclengua.buscar_por_codigo", 
	 procedureName = "acad.fun_leotbdinsclengua_buscar_x_codigo", 
 		resultClasses = LeotbdInsclengua.class, 
 		parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsclen", type = long.class) 
 		}),
	 @NamedStoredProcedureQuery(name = "leotbd_insclengua.buscar_por_codigoInscripcion", 
	 procedureName = "acad.fun_leotbdinsclengua_buscar_x_codigoinscr", 
 		resultClasses = LeotbdInsclengua.class, 
 		parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinscr", type = long.class) 
 		}),
	 @NamedStoredProcedureQuery(name = "leotbd_insclengua.listadoDetalle", 
	 procedureName = "acad.fun_leotbdinsclengua_listadodetalle", 
 		resultClasses = LeotbdInsclengua.class, 
 		parameters = { 
 				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuario", type = long.class)
 		}), 
	 @NamedStoredProcedureQuery(name = "leotbd_insclengua.listadoDetalleBuscarCriterios", 
	 procedureName = "acad.fun_leotbdinsclengua_listadodetalle_BuscarCriterios", 
 		resultClasses = LeotbdInsclengua.class,
 		parameters = { 
 				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nominsti", type = String.class)
 		}),
	 
	 @NamedStoredProcedureQuery(name = "leotbd_insclengua.matriculBuscarXCodigoDetalle", 
	 procedureName = "acad.fun_leotbdinsclenguamatri_buscar_x_codigo", 
 		resultClasses = LeotbdInsclengua.class, 
 		parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsclen", type = long.class) 
 		}), 
	
	 @NamedStoredProcedureQuery(name = "leotbd_insclengua.actualizarNumCuposDisp", 
	 procedureName = "acad.fun_leotbdinsclengua_actualizar_numcuposdisp",
 		parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsclen", type = long.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numcuposdisp", type = String.class)
 
 		}),
	 @NamedStoredProcedureQuery(name = "leotbd_insclengua.listarNivelesHechos", 
	 	procedureName = "acad.fun_matasigxalumno_buscar_x_codalu",
	 	resultClasses = LeotbdInsclengua.class, 
		parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codalumno", type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class)
		}),
	
  
	
	 @NamedStoredProcedureQuery(name = "leotbd_insclengua.actualizarNumCuposxInslen", 
	 procedureName = "acad.fun_leotbdinsclengua_actualizar_numcuposxinsclen",
 		parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsclen", type = long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numcupos", type = String.class),
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
 		})
 
	
	
})
	
@Entity
@Table(name="leotbd_insclengua")
public class LeotbdInsclengua implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codinsclen")
	private long nCodinsclen;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_codinscr")
	private long nCodinscr;

	@Column(name="n_codlengua")
	private long nCodlengua;

	@Column(name="n_codusumod")
	private long nCodusumod;

	@Column(name="n_codusureg")
	private long nCodusureg;

	@Column(name="n_tm1sitinsclen")
	private long nTm1sitinsclen;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_numcupos")
	private String vNumcupos;
	
	@Column(name="n_codisnti")
	private long nCodisnti;
	
	@Column(name="v_nominsti")
	private String vNominsti;
	
	@Column(name="v_nomlengua")
	private String vNomlengua;
	
	@Column(name="v_periodo")
	private String vPeriodo;
	
	@Column(name="n_tm2ciclo")
	private int nTm2ciclo;

	@Column(name="v_numcuposdisp")
	private String vNumcuposdisp;
	
	@Column(name="n_tm2nivel")
	private int nTm2nivel; 
	
	@Column(name="v_nomcortonivel")
	private String vNomcortonivel;
	
	@Column(name="v_nomcortoCiclo")
	private String vNomcortoCiclo;
	@Column(name="n_codalumno")
	private long nCodalumno;
	 
	@Column(name="n_codusumat")
	private long nCodusumat;
	
	@Column(name="n_nota")
	private float nNota;
	
	@Column(name="n_tm2cond")
	private long nTm2cond;
	
	
	
	public long getnCodalumno() {
		return nCodalumno;
	}

	public void setnCodalumno(long nCodalumno) {
		this.nCodalumno = nCodalumno;
	}

	public LeotbdInsclengua() {
		
	}

	public String getvNumcuposdisp() {
		return vNumcuposdisp;
	}

	public void setvNumcuposdisp(String vNumcuposdisp) {
		this.vNumcuposdisp = vNumcuposdisp;
	}



	public long getNCodinsclen() {
		return this.nCodinsclen;
	}

	public void setNCodinsclen(long nCodinsclen) {
		this.nCodinsclen = nCodinsclen;
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

	public long getNCodinscr() {
		return this.nCodinscr;
	}

	public void setNCodinscr(long nCodinscr) {
		this.nCodinscr = nCodinscr;
	}

	public long getNCodlengua() {
		return this.nCodlengua;
	}

	public void setNCodlengua(long nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public long getNCodusumod() {
		return this.nCodusumod;
	}

	public void setNCodusumod(long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public long getNCodusureg() {
		return this.nCodusureg;
	}

	public void setNCodusureg(long nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public long getNTm1sitinsclen() {
		return this.nTm1sitinsclen;
	}

	public void setNTm1sitinsclen(long nTm1sitinsclen) {
		this.nTm1sitinsclen = nTm1sitinsclen;
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

	public String getVNumcupos() {
		return this.vNumcupos;
	}

	public void setVNumcupos(String vNumcupos) {
		this.vNumcupos = vNumcupos;
	}

	public long getnCodisnti() {
		return nCodisnti;
	}

	public void setnCodisnti(long nCodisnti) {
		this.nCodisnti = nCodisnti;
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

	public String getvPeriodo() {
		return vPeriodo;
	}

	public void setvPeriodo(String vPeriodo) {
		this.vPeriodo = vPeriodo;
	}

	public int getnTm2ciclo() {
		return nTm2ciclo;
	}

	public void setnTm2ciclo(int nTm2ciclo) {
		this.nTm2ciclo = nTm2ciclo;
	}

	public int getnTm2nivel() {
		return nTm2nivel;
	}

	public void setnTm2nivel(int nTm2nivel) {
		this.nTm2nivel = nTm2nivel;
	}

	public String getvNomcortonivel() {
		return vNomcortonivel;
	}

	public void setvNomcortonivel(String vNomcortonivel) {
		this.vNomcortonivel = vNomcortonivel;
	}

	public String getvNomcortoCiclo() {
		return vNomcortoCiclo;
	}

	public void setvNomcortoCiclo(String vNomcortoCiclo) {
		this.vNomcortoCiclo = vNomcortoCiclo;
	}

	public long getnCodusumat() {
		return nCodusumat;
	}

	public void setnCodusumat(long nCodusumat) {
		this.nCodusumat = nCodusumat;
	}

	public float getnNota() {
		return nNota;
	}

	public void setnNota(float nNota) {
		this.nNota = nNota;
	}

	public long getnTm2cond() {
		return nTm2cond;
	}

	public void setnTm2cond(long nTm2cond) {
		this.nTm2cond = nTm2cond;
	}
	
	
	

}