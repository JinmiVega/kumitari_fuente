package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

@NamedStoredProcedureQueries({
//	@NamedStoredProcedureQuery(name = "leotbd_alumnoxmedalla.buscarPorFiltros", 
//			procedureName = "acad.fun_leotbdalumnoxmedalla_buscar_x_filtros", 
//			resultClasses = LeotbdAlumnoBono.class,
//			parameters = {
//			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class)
//			
//			}),
//			
	@NamedStoredProcedureQuery(name = "leotbd_alumnoxBono.buscarPorAlumno", 
			procedureName = "acad.fun_leotbdalumnoxBono_listar_x_alumno", 
			resultClasses = LeotbdAlumnoBono.class,
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class)
			
			}),
			@NamedStoredProcedureQuery(name = "leotbd_alumnoxbono.insertar", procedureName = "acad.fun_leotbdalumnoxbono_insertar", 
			resultClasses = LeotbdAlumnoBono.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codaluxbono", type = Long.class),    
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),    
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codundlec", type = Long.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
			}),
			@NamedStoredProcedureQuery(name = "leotbd_alumnoxBono.eliminar", 
			procedureName = "acad.leotbdalumnoxbono_eliminar", 
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codaluxbono", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			
			})
			
	 		
			
			
//	@NamedStoredProcedureQuery(name = "leotbd_alumnoxmedalla.buscarPorAlumno", 
//		procedureName = "acad.fun_leotbdalumnoxmedalla_listar_x_alumno", 
//		resultClasses = LeotbdAlumnoBono.class,
//		parameters = {
//			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
//			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class)
//		
//		})
})


@Entity
@Table(name="acad.leotbd_alumnoxbono")
public class LeotbdAlumnoBono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codaluxbono")
	private long nCodaluxbono;
	
	@Column(name="n_codusumat")
	private long nCodusumat;

	@Column(name="n_codbono")
	private long nCodbono;
	
	@Column(name="n_codundlec")
	private long nCodundlec;
	
	@Column(name = "n_codusureg")
	private int nCodUsuRegistro;
	
	@Column(name="v_nombono")
	private String vNombono;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg; 
	
	@Column(name="v_tiempo")
	private String vTiempo; 
	
	@Column(name="n_tm1tpbono")
	private long nTm1tpbono;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;	
	 

	public LeotbdAlumnoBono() {
	}


	public long getnCodaluxbono() {
		return nCodaluxbono;
	}


	public void setnCodaluxbono(long nCodaluxbono) {
		this.nCodaluxbono = nCodaluxbono;
	}


	public long getnCodusumat() {
		return nCodusumat;
	}


	public void setnCodusumat(long nCodusumat) {
		this.nCodusumat = nCodusumat;
	}


	public long getnCodbono() {
		return nCodbono;
	}


	public void setnCodbono(long nCodbono) {
		this.nCodbono = nCodbono;
	}


	public long getnCodundlec() {
		return nCodundlec;
	}


	public void setnCodundlec(long nCodundlec) {
		this.nCodundlec = nCodundlec;
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


	public String getvNombono() {
		return vNombono;
	}


	public void setvNombono(String vNombono) {
		this.vNombono = vNombono;
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


	public int getnCodUsuRegistro() {
		return nCodUsuRegistro;
	}


	public void setnCodUsuRegistro(int nCodUsuRegistro) {
		this.nCodUsuRegistro = nCodUsuRegistro;
	}


	public String getvTiempo() {
		return vTiempo;
	}


	public void setvTiempo(String vTiempo) {
		this.vTiempo = vTiempo;
	}

	public long getnTm1tpbono() {
		return nTm1tpbono;
	}


	public void setnTm1tpbono(long nTm1tpbono) {
		this.nTm1tpbono = nTm1tpbono;
	}
	

	@Override
	public String toString() {
		return "LeotbdAlumnoBono [nCodaluxbono=" + nCodaluxbono
				+ ", nCodusumat=" + nCodusumat + ", nCodbono=" + nCodbono
				+ ", nCodundlec=" + nCodundlec + ", nCodUsuRegistro="
				+ nCodUsuRegistro + ", vNombono=" + vNombono + ", vFlgest="
				+ vFlgest + ", vHostmod=" + vHostmod + ", vHostreg=" + vHostreg
				+ ", dFecmod=" + dFecmod + ", dFecreg=" + dFecreg + "]";
	}


 

	 
	 
}