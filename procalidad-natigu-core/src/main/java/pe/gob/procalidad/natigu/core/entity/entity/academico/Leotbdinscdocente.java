package pe.gob.procalidad.natigu.core.entity.entity.academico;

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
	
	@NamedStoredProcedureQuery(name = "leotbdinscdocente.insertar", 
	procedureName = "acad.fun_leotbdinscdocente_insertar",
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codinsdoc", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinslen", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitinsdoc", type = long.class),

			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
			}),

	 @NamedStoredProcedureQuery(name = "leotbdinscdocente.actualizar", 
	 procedureName = "acad.fun_leotbdinscdocente_actualizar", 
	 		parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsdoc", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinslen", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitinsdoc", type = int.class),
	 		
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 		
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) 
	 		}), 
	
	 		 @NamedStoredProcedureQuery(name = "leotbdinscdocente.dar_baja", 
	 		 procedureName = "acad.fun_leotbdinscdocente_dar_de_baja_docente", 
	 		 		parameters = { 
	 		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsdoc", type = long.class),

	 		 		
	 		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 		
	 		 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) 
	 		 		}), 
	
	 
	 @NamedStoredProcedureQuery(name = "leotbdinscdocente.buscar_por_filtros", 
	 procedureName = "acad.fun_leotbdinscdocente_buscar_x_filtros", 
 		resultClasses = Leotbdinscdocente.class, 
 		parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsdoc", type = long.class),
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = long.class),
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinslen", type = long.class),
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombredoc", type = String.class),
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_especdoc", type = String.class),
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinst", type = long.class),
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitinsdoc", type = long.class) 
 		})
})

@Entity
@Table(name="leotbd_inscdocente")
public class Leotbdinscdocente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "n_codinsdoc")
	private long nCodInsDoc;
	
	@Column(name = "n_codinslen")
	private long nCodInsLen;
	
	@Column(name = "n_coddocen")
	private long nCodDocen;
	
	@Column(name = "n_tm1sitinsdoc")
	private int nTm1SitInsDoc;
				
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecbaj")
	private Date dFecBaj;			
	
	@Column(name = "v_flgest")
	private String vFlgEst;
	
	@Column(name = "n_codusureg")
	private long nCodUsuReg;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecReg;
	
	@Column(name = "v_hostreg")
	private String vHostReg;
	
	
	@Column(name = "n_codusumod")
	private long nCodUsuMod;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dFecMod;
	
	@Column(name = "v_hostmod")
	private String vHostMod;
	
	
	
	@Column(name = "v_apepatper")
	private String vApePatPer;
	
	@Column(name = "v_apematper")
	private String vApeMatPer;
	
	@Column(name = "v_nombreper")
	private String vNombrePer;
	
	@Column(name = "n_tm1tpdope")
	private int nTm1TpDoPe;
	
	@Column(name = "v_numdocum")
	private String vNumDocum;
	

	public long getnCodInsDoc() {
		return nCodInsDoc;
	}

	public void setnCodInsDoc(long nCodInsDoc) {
		this.nCodInsDoc = nCodInsDoc;
	}

	public long getnCodInsLen() {
		return nCodInsLen;
	}

	public void setnCodInsLen(long nCodInsLen) {
		this.nCodInsLen = nCodInsLen;
	}

	public long getnCodDocen() {
		return nCodDocen;
	}

	public void setnCodDocen(long nCodDocen) {
		this.nCodDocen = nCodDocen;
	}

	public int getnTm1SitInsDoc() {
		return nTm1SitInsDoc;
	}

	public void setnTm1SitInsDoc(int nTm1SitInsDoc) {
		this.nTm1SitInsDoc = nTm1SitInsDoc;
	}

	public Date getdFecBaj() {
		return dFecBaj;
	}

	public void setdFecBaj(Date dFecBaj) {
		this.dFecBaj = dFecBaj;
	}

	public String getvFlgEst() {
		return vFlgEst;
	}

	public void setvFlgEst(String vFlgEst) {
		this.vFlgEst = vFlgEst;
	}

	public long getnCodUsuReg() {
		return nCodUsuReg;
	}

	public void setnCodUsuReg(long nCodUsuReg) {
		this.nCodUsuReg = nCodUsuReg;
	}

	public Date getdFecReg() {
		return dFecReg;
	}

	public void setdFecReg(Date dFecReg) {
		this.dFecReg = dFecReg;
	}

	public String getvHostReg() {
		return vHostReg;
	}

	public void setvHostReg(String vHostReg) {
		this.vHostReg = vHostReg;
	}

	public long getnCodUsuMod() {
		return nCodUsuMod;
	}

	public void setnCodUsuMod(long nCodUsuMod) {
		this.nCodUsuMod = nCodUsuMod;
	}

	public Date getdFecMod() {
		return dFecMod;
	}

	public void setdFecMod(Date dFecMod) {
		this.dFecMod = dFecMod;
	}

	public String getvHostMod() {
		return vHostMod;
	}

	public void setvHostMod(String vHostMod) {
		this.vHostMod = vHostMod;
	}

	public String getvApePatPer() {
		return vApePatPer;
	}

	public void setvApePatPer(String vApePatPer) {
		this.vApePatPer = vApePatPer;
	}

	public String getvApeMatPer() {
		return vApeMatPer;
	}

	public void setvApeMatPer(String vApeMatPer) {
		this.vApeMatPer = vApeMatPer;
	}

	public String getvNombrePer() {
		return vNombrePer;
	}

	public void setvNombrePer(String vNombrePer) {
		this.vNombrePer = vNombrePer;
	}

	public int getnTm1TpDoPe() {
		return nTm1TpDoPe;
	}

	public void setnTm1TpDoPe(int nTm1TpDoPe) {
		this.nTm1TpDoPe = nTm1TpDoPe;
	}

	public String getvNumDocum() {
		return vNumDocum;
	}

	public void setvNumDocum(String vNumDocum) {
		this.vNumDocum = vNumDocum;
	}

	

}
