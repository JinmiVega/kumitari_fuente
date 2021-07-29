package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leomvc_matricula.listar", 
			procedureName = "acad.fun_leomvcmatricula_buscar_x_filtros", 
			resultClasses = LeomvcMatricula.class,
			parameters = {
		//	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatri", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmat", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuario", type = long.class)
			//,@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2subniv", type = int.class)
			
			}),
			@NamedStoredProcedureQuery(name = "leomvc_matricula.listarxPerfil", 
				procedureName = "acad.fun_leomvcmatricula_buscar_x_filtrosxperfil", 
				resultClasses = LeomvcMatricula.class,
				parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmat", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuario", type = long.class)
				,@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperfil", type = int.class)
				
			}),
			
			@NamedStoredProcedureQuery(name = "leomvc_matricula.listarCuposXAsignar", 
			procedureName = "acad.fun_leomvcmatricula_listacupos_x_asignar", 
			resultClasses = LeomvcMatricula.class,
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatri", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmat", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2subniv", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusu", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombreusu", type = String.class)
			
			}),

	@NamedStoredProcedureQuery(name = "leomvc_matricula.insertar", 
	procedureName = "acad.fun_leomvcmatricula_insertar",
			resultClasses = LeomvcMatricula.class, 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codmatri", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2subniv", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_periodo", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2ciclo", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmat", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tipmat", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_observaci", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_flgmat", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_flgest", type = String.class),
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class),

			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsclen", type = long.class)
			}),

	 @NamedStoredProcedureQuery(name = "leomvc_matricula.actualizar", 
	 procedureName = "acad.fun_leomvcmatricula_actualizar", 
				resultClasses = LeomvcMatricula.class, 
	 		parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatri", type = Integer.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2subniv", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_periodo", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2ciclo", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmat", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tipmat", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_observaci", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_flgmat", type = long.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_flgest", type = String.class),
	 				
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 		
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class),

	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsclen", type = long.class)
	 		}), 
	
	 @NamedStoredProcedureQuery(name = "leomvc_matricula.eliminar", 
	 procedureName = "acad.fun_leomvcmatricula_eliminar",
				resultClasses = LeomvcMatricula.class, 
 		parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatri", type = long.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
 		}), 
	 
	 @NamedStoredProcedureQuery(name = "leomvc_matricula.buscar_por_codigo", 
	 procedureName = "acad.fun_leomvcmatricula_buscar_x_codigo", 
 		resultClasses = LeomvcMatricula.class, 
 		parameters = { 
 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatri", type = long.class) 
 		}),
 	@NamedStoredProcedureQuery(name = "leomvc_matricula.listarSeguimientoAlumnov2", 
	procedureName = "acad.fun_leomvcmatricula_seguimiento_alumno", 
		resultClasses = LeomvcMatricula.class,
		parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddocen", type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2nivel", type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_periodo", type = int.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmat", type = int.class)
		
		}), 
	
	 	@NamedStoredProcedureQuery(name = "leomvc_matricula.actualizarNumCuposRest", 
	 	procedureName = "acad.fun_leomvcmatricula_actualizar_numcuposrest",
		parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatri", type = long.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numcuposrest", type = String.class)
		})
})


@Entity
@Table(name="acad.leomvc_matricula")
public class LeomvcMatricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codmatri")
	private long nCodmatri;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_tm2ciclo")
	private int nTm2ciclo;

	@Column(name="n_codisnti")
	private int nCodisnti;

	@Column(name="n_codlengua")
	private int nCodlengua;

	@Column(name="n_codusumod")
	private int nCodusumod;

	@Column(name="n_codusureg")
	private int nCodusureg;

	@Column(name="n_flgmat")
	private int nFlgmat;

	@Column(name="n_periodo")
	private String nPeriodo;

	@Column(name="n_tm1sitmat")
	private int nTm1sitmat;

	@Column(name="n_tm1tipmat")
	private int nTm1tipmat;

	@Column(name="n_tm2nivel")
	private int nTm2nivel;

	@Column(name="n_tm2subniv")
	private int nTm2subniv;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_observaci")
	private String vObservaci;
	
	@Column(name="v_nominsti")
	private String vNominsti;
	
	@Column(name="v_nomlengua")
	private String vNomlengua;
	
	@Column(name="v_nomcorto")
	private String vnomcorto;

	@Column(name="v_numcupos")
	private String vnumcupos;

	
	@Column(name="v_nomdocente")
	private String vnomdocente;

	@Column(name="v_nomalumno")
	private String vnomalumno;

	@Column(name="v_tm2nivel")
	private String vtm2nivel;

	@Column(name="v_tm2subniv")
	private String vtm2subniv;

	@Column(name="v_tm2ciclo")
	private String vtm2ciclo;

	@Column(name="v_tm1sitmat")
	private String vtm1sitmat;

	@Column(name="v_numalum")
	private int vnumalum;
	
	@Column(name="n_codinsclen")
	private int nCodinsclen;
	
	@Column(name="v_numcuposrest")
	private String vNumcuposrest;
	
	@Column(name="v_numcuposdisp")
	private String vNumcuposdisp;

	@Column(name="v_nomusuari")
	private String vNomusuari;
	
	@Column(name="v_nomtm2nivel")
	private String vNomtm2nivel;
	
	

	public LeomvcMatricula() {
	}
	
	

	public String getVnumcupos() {
		return vnumcupos;
	}



	public String getVnomcorto() {
		return vnomcorto;
	}



	public void setVnomcorto(String vnomcorto) {
		this.vnomcorto = vnomcorto;
	}



	public void setVnumcupos(String vnumcupos) {
		this.vnumcupos = vnumcupos;
	}



	public long getNCodmatri() {
		return this.nCodmatri;
	}

	public void setNCodmatri(long nCodmatri) {
		this.nCodmatri = nCodmatri;
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

	

	public int getnTm2ciclo() {
		return nTm2ciclo;
	}

	public void setnTm2ciclo(int nTm2ciclo) {
		this.nTm2ciclo = nTm2ciclo;
	}

	public int getNCodisnti() {
		return this.nCodisnti;
	}

	public void setNCodisnti(int nCodisnti) {
		this.nCodisnti = nCodisnti;
	}

	public int getNCodlengua() {
		return this.nCodlengua;
	}

	public void setNCodlengua(int nCodlengua) {
		this.nCodlengua = nCodlengua;
	}

	public int getNCodusumod() {
		return this.nCodusumod;
	}

	public void setNCodusumod(int nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public int getNCodusureg() {
		return this.nCodusureg;
	}

	public void setNCodusureg(int nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public int getNFlgmat() {
		return this.nFlgmat;
	}

	public void setNFlgmat(int nFlgmat) {
		this.nFlgmat = nFlgmat;
	}

	public String getNPeriodo() {
		return this.nPeriodo;
	}

	public void setNPeriodo(String nPeriodo) {
		this.nPeriodo = nPeriodo;
	}

	public int getNTm1sitmat() {
		return this.nTm1sitmat;
	}

	public void setNTm1sitmat(int nTm1sitmat) {
		this.nTm1sitmat = nTm1sitmat;
	}

	public int getNTm1tipmat() {
		return this.nTm1tipmat;
	}

	public void setNTm1tipmat(int nTm1tipmat) {
		this.nTm1tipmat = nTm1tipmat;
	}

	public int getNTm2nivel() {
		return this.nTm2nivel;
	}

	public void setNTm2nivel(int nTm2nivel) {
		this.nTm2nivel = nTm2nivel;
	}

	public int getNTm2subniv() {
		return this.nTm2subniv;
	}

	public void setNTm2subniv(int nTm2subniv) {
		this.nTm2subniv = nTm2subniv;
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

	public String getVObservaci() {
		return this.vObservaci;
	}

	public void setVObservaci(String vObservaci) {
		this.vObservaci = vObservaci;
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





	public String getVnomdocente() {
		return vnomdocente;
	}

	public void setVnomdocente(String vnomdocente) {
		this.vnomdocente = vnomdocente;
	}



	public String getVnomalumno() {
		return vnomalumno;
	}



	public void setVnomalumno(String vnomalumno) {
		this.vnomalumno = vnomalumno;
	}



	public String getVtm2nivel() {
		return vtm2nivel;
	}



	public void setVtm2nivel(String vtm2nivel) {
		this.vtm2nivel = vtm2nivel;
	}

	public String getVtm2subniv() {
		return vtm2subniv;
	}



	public void setVtm2subniv(String vtm2subniv) {
		this.vtm2subniv = vtm2subniv;
	}



	public String getVtm2ciclo() {
		return vtm2ciclo;
	}



	public void setVtm2ciclo(String vtm2ciclo) {
		this.vtm2ciclo = vtm2ciclo;
	}



	public String getVtm1sitmat() {
		return vtm1sitmat;
	}



	public void setVtm1sitmat(String vtm1sitmat) {
		this.vtm1sitmat = vtm1sitmat;
	}



	public int getVnumalum() {
		return vnumalum;
	}



	public void setVnumalum(int vnumalum) {
		this.vnumalum = vnumalum;
	}



	public int getnCodinsclen() {
		return nCodinsclen;
	}



	public void setnCodinsclen(int nCodinsclen) {
		this.nCodinsclen = nCodinsclen;
	}



	public String getvNumcuposrest() {
		return vNumcuposrest;
	}



	public void setvNumcuposrest(String vNumcuposrest) {
		this.vNumcuposrest = vNumcuposrest;
	}



	public String getvNumcuposdisp() {
		return vNumcuposdisp;
	}



	public void setvNumcuposdisp(String vNumcuposdisp) {
		this.vNumcuposdisp = vNumcuposdisp;
	}



	public String getvNomusuari() {
		return vNomusuari;
	}



	public void setvNomusuari(String vNomusuari) {
		this.vNomusuari = vNomusuari;
	}



	public String getvNomtm2nivel() {
		return vNomtm2nivel;
	}



	public void setvNomtm2nivel(String vNomtm2nivel) {
		this.vNomtm2nivel = vNomtm2nivel;
	}


	
}