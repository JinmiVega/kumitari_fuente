package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbd_alumnoxmedalla.buscarPorFiltros", 
			procedureName = "acad.fun_leotbdalumnoxmedalla_buscar_x_filtros", 
			resultClasses = LeotbdAlumnoMedalla.class,
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = long.class)
			
			}),
			
			@NamedStoredProcedureQuery(name = "leotbd_alumnoxmedalla.insertar", procedureName = "acad.fun_leotbdalumnoxmedalla_insertar", 
			resultClasses = LeotbdAlumnoMedalla.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codaluxmeda", type = Long.class),    
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codcateg", type = Integer.class),  
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codundlec", type = Long.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)}),
	 		
			
			
	@NamedStoredProcedureQuery(name = "leotbd_alumnoxmedalla.buscarPorAlumno", 
		procedureName = "acad.fun_leotbdalumnoxmedalla_listar_x_alumno", 
		resultClasses = LeotbdAlumnoMedalla.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class)
		
		})
})


@Entity
@Table(name="acad.leotbd_alumnoxmedalla")
public class LeotbdAlumnoMedalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codaluxmeda")
	private long nCodaluxmeda;
	
	@Column(name="n_codusumat")
	private long nCodusumat;

	@Column(name="n_codpremio")
	private long nCodpremio;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_nomimag")
	private String vNomimag;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;	
	
	@Column(name="n_tm1tpprem")
	private Integer nTm1tpprem;

	public LeotbdAlumnoMedalla() {
	}

	public long getnCodaluxmeda() {
		return nCodaluxmeda;
	}

	public void setnCodaluxmeda(long nCodaluxmeda) {
		this.nCodaluxmeda = nCodaluxmeda;
	}

	public long getnCodusumat() {
		return nCodusumat;
	}

	public void setnCodusumat(long nCodusumat) {
		this.nCodusumat = nCodusumat;
	}

	public long getnCodpremio() {
		return nCodpremio;
	}

	public void setnCodpremio(long nCodpremio) {
		this.nCodpremio = nCodpremio;
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
	
	public String getvNomimag() {
		return vNomimag;
	}

	public void setvNomimag(String vNomimag) {
		this.vNomimag = vNomimag;
	}

	public Integer getnTm1tpprem() {
		return nTm1tpprem;
	}

	public void setnTm1tpprem(Integer nTm1tpprem) {
		this.nTm1tpprem = nTm1tpprem;
	}

	@Override
	public String toString() {
		return "LeotbdAlumnoMedalla [nCodaluxmeda=" + nCodaluxmeda
				+ ", nCodusumat=" + nCodusumat + ", nCodpremio=" + nCodpremio
				+ ", vFlgest=" + vFlgest + ", vHostmod=" + vHostmod
				+ ", vHostreg=" + vHostreg + ", dFecmod=" + dFecmod
				+ ", dFecreg=" + dFecreg + "]";
	}

}