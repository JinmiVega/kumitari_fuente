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

import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLengua;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcPersona;

@NamedStoredProcedureQueries({
	
	@NamedStoredProcedureQuery(name = "leotbdusumatricula.buscar_x_filtros", procedureName = "acad.fun_leotbdusumatricula_buscar_x_filtros", 
			resultClasses = LeotbdUsuMatricula.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinscr", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinst", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomalum", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitau", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinscrlen", type = Long.class)
			
	}),
	@NamedStoredProcedureQuery(name = "leotbdusumatricula.buscar_x_lengua_codusu", procedureName = "acad.fun_leotbdusumat_buscarXcodusu_lengua", 
	resultClasses = LeotbdUsuMatricula.class, parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class)
	
}),
	
	
	@NamedStoredProcedureQuery(name = "leotbdusumatricula.buscarxTipoCuposXInscrLengua", procedureName = "acad.fun_leotbdusumatricula_buscarxtipocuposxinscrlengua", 
	resultClasses = LeotbdUsuMatricula.class, parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsclen", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tipocupo", type = Integer.class)
	
}),

	@NamedStoredProcedureQuery(name = "leotbdusumatricula.insertar", procedureName = "acad.fun_leotbdusumatricula_insertar", 
			resultClasses = LeotbdUsuMatricula.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codusumat", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuper", type = Integer.class),
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsclen", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatri", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codalumno", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1situsu", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tipocupo", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_passusuar", type = String.class)
			}),
			
			
			
			@NamedStoredProcedureQuery(name = "leotbdusumatricula.asignar_usuario", procedureName = "acad.fun_leotbdusumatricula_asignar_usuario", 
			resultClasses = LeotbdUsuMatricula.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
	
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsclen", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatri", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codalumno", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1situsu", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = Long.class),
			
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
			}),
			
			@NamedStoredProcedureQuery(name = "leotbdusumatricula.eliminar", procedureName = "acad.fun_leotbdusumatricula_eliminar_usuario_alumno", 
			resultClasses = LeotbdUsuMatricula.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
						
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			}),
			
			@NamedStoredProcedureQuery(name = "leotbdusumatricula.darBajaAlumno", 
			procedureName = "acad.fun_leotbdusumatricula_dardebajaalumno", 
			resultClasses = LeotbdUsuMatricula.class, 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
						
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			}),
	
			@NamedStoredProcedureQuery(name = "leotbdusumatricula.eliminarusumat", procedureName = "acad.fun_leotbdusumatricula_eliminar", 
			resultClasses = LeotbdUsuMatricula.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
						
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			})
	
	

})


@Entity
@Table(name="acad.leotbd_usumatricula")
public class LeotbdUsuMatricula implements Serializable {

	public int getnTm1TipoCupo() {
		return nTm1TipoCupo;
	}

	public void setnTm1TipoCupo(int nTm1TipoCupo) {
		this.nTm1TipoCupo = nTm1TipoCupo;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Id
	@Column(name="n_codusumat")
	private long nCodUsuMat;
	
	@Column(name="n_codinsclen")
	private long nCodInscLen;
		
	@Column(name="n_codmatri")
	private long nCodMatri;
	
	@Column(name="n_codusuari")
	private long nCodUsuari;			
				
	@Column(name="n_codalumno")
	private long nCodAlumno;	
	
	@Column(name="n_tm1tipocupo")
	private int nTm1TipoCupo;	
	
	@Column(name="n_tm1situsu")
	private int nTm1SitUsu;	
	
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
	
	
	
	@Column(name = "n_codlengua")
	private long nCodLengua;
	
	@Column(name = "v_nomlengua")
	private String vNomLengua;
	
	@Column(name = "n_codinsti")
	private long nCodInsti;
	
	@Column(name = "v_nominsti")
	private String vNomInsti; 
	
	@Column(name = "v_nombretm1situsu")
	private String vNombreTm1SitUsu; 
	   
	@Column(name = "n_codperso")
	private long nCodPerso;
	
	@Column(name = "v_nombreper")
	private String vNombrePer; 
	    
	@Column(name = "v_apepatper")
	private String vApePatPer; 
	
	@Column(name = "v_apematper")
	private String v_ApeMatPer; 
	
	@Column(name = "v_nomusuari")
	private String vNomUsuari; 
	  
	@Column(name = "n_codinscr")
	private int nCodInscr; 
	   
	@Column(name = "n_codmatalu")
	private Long nCodMatAlu; 
	
	@Column(name="n_nota")
	private float nNota;
	
	@Column(name = "v_condicion")
	private String vCondicion; 

	public long getnCodUsuMat() {
		return nCodUsuMat;
	}

	public void setnCodUsuMat(long nCodUsuMat) {
		this.nCodUsuMat = nCodUsuMat;
	}

	

	public long getnCodInscLen() {
		return nCodInscLen;
	}

	public void setnCodInscLen(long nCodInscLen) {
		this.nCodInscLen = nCodInscLen;
	}

	public long getnCodMatri() {
		return nCodMatri;
	}

	public void setnCodMatri(long nCodMatri) {
		this.nCodMatri = nCodMatri;
	}

	public long getnCodUsuari() {
		return nCodUsuari;
	}

	public void setnCodUsuari(long nCodUsuari) {
		this.nCodUsuari = nCodUsuari;
	}

	public long getnCodAlumno() {
		return nCodAlumno;
	}

	public void setnCodAlumno(long nCodAlumno) {
		this.nCodAlumno = nCodAlumno;
	}

	public int getnTm1SitUsu() {
		return nTm1SitUsu;
	}

	public void setnTm1SitUsu(int nTm1SitUsu) {
		this.nTm1SitUsu = nTm1SitUsu;
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

	public long getnCodLengua() {
		return nCodLengua;
	}

	public void setnCodLengua(long nCodLengua) {
		this.nCodLengua = nCodLengua;
	}

	public String getvNomLengua() {
		return vNomLengua;
	}

	public void setvNomLengua(String vNomLengua) {
		this.vNomLengua = vNomLengua;
	}

	public long getnCodInsti() {
		return nCodInsti;
	}

	public void setnCodInsti(long nCodInsti) {
		this.nCodInsti = nCodInsti;
	}

	public String getvNomInsti() {
		return vNomInsti;
	}

	public void setvNomInsti(String vNomInsti) {
		this.vNomInsti = vNomInsti;
	}

	public String getvNombreTm1SitUsu() {
		return vNombreTm1SitUsu;
	}

	public void setvNombreTm1SitUsu(String vNombreTm1SitUsu) {
		this.vNombreTm1SitUsu = vNombreTm1SitUsu;
	}

	public long getnCodPerso() {
		return nCodPerso;
	}

	public void setnCodPerso(long nCodPerso) {
		this.nCodPerso = nCodPerso;
	}

	public String getvNombrePer() {
		return vNombrePer;
	}

	public void setvNombrePer(String vNombrePer) {
		this.vNombrePer = vNombrePer;
	}

	public String getvApePatPer() {
		return vApePatPer;
	}

	public void setvApePatPer(String vApePatPer) {
		this.vApePatPer = vApePatPer;
	}

	public String getV_ApeMatPer() {
		return v_ApeMatPer;
	}

	public void setV_ApeMatPer(String v_ApeMatPer) {
		this.v_ApeMatPer = v_ApeMatPer;
	}

	public String getvNomUsuari() {
		return vNomUsuari;
	}

	public void setvNomUsuari(String vNomUsuari) {
		this.vNomUsuari = vNomUsuari;
	}

	public int getnCodInscr() {
		return nCodInscr;
	}

	public void setnCodInscr(int nCodInscr) {
		this.nCodInscr = nCodInscr;
	}

	public Long getnCodMatAlu() {
		return nCodMatAlu;
	}

	public void setnCodMatAlu(Long nCodMatAlu) {
		this.nCodMatAlu = nCodMatAlu;
	}

	public float getnNota() {
		return nNota;
	}

	public void setnNota(float nNota) {
		this.nNota = nNota;
	}

	public String getvCondicion() {
		return vCondicion;
	}

	public void setvCondicion(String vCondicion) {
		this.vCondicion = vCondicion;
	}
	
	
	
	
	
}
