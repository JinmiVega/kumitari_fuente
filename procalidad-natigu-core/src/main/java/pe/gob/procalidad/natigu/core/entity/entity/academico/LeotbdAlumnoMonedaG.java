package pe.gob.procalidad.natigu.core.entity.entity.academico;

import java.io.Serializable;

import javax.persistence.*;

import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcMascota;

import java.util.Date;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbd_alumnoxmonedaG.actualizar", procedureName = "acad.fun_leotbdalumnoxmonegema_actualizar", 
	 		resultClasses = LeotbdAlumnoMonedaG.class, parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_existe", type = Integer.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codaluxmongem", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Integer.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = Integer.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cantmonedas", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cantgemas", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)}),
			
			@NamedStoredProcedureQuery(name = "leotbd_alumnoxmonedaG.insertar", procedureName = "acad.fun_leotbdalumnoxmonegema_insertar", 
			resultClasses = LeotbdAlumnoMonedaG.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codaluxmongem", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cantmonedas", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cantgemas", type = int.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)}),
	 		
	 		
	@NamedStoredProcedureQuery(name = "leotbd_alumnoxmonedaG.buscarPorAlumno", 
		procedureName = "acad.fun_leotbdalumnoxmonegema_listar_x_alumno", 
		resultClasses = LeotbdAlumnoMonedaG.class,
		parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class)
		
		}),
	@NamedStoredProcedureQuery(name = "leotbd_alumnoxmonedaG.actualizarmonedaxcompra", 
	procedureName = "acad.fun_leotbdalumnoxmonegema_actualizarmonedaxcompra", 
	resultClasses = LeotbdAlumnoMonedaG.class, 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cantmonedas", type = int.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
	})
})


@Entity
@Table(name="acad.leotbd_alumnoxmonegem")
public class LeotbdAlumnoMonedaG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codaluxmongem")
	private long nCodaluxmongem;
	
	@Column(name="n_codusumat")
	private long nCodusumat;

	@Column(name="n_cantmonedas")
	private Integer nCantmonedas;
	
	@Column(name="n_cantgemas")
	private Integer nCantgemas;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name = "n_codusureg")
	private int nCodUsuRegistro;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecRegistro;
	
	@Column(name = "v_hostreg")
	private String vHostRegistro;
	
	@Column(name = "n_codusumod")
	private int nCodUsuModificado;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dfecModificado;
	
	@Column(name = "v_hostmod")
	private String vHostModificado;	
 
	@Column(name="n_cantbono")
	private Integer nCantbono;

	public LeotbdAlumnoMonedaG() {
	}


	public long getnCodaluxmongem() {
		return nCodaluxmongem;
	}


	public void setnCodaluxmongem(long nCodaluxmongem) {
		this.nCodaluxmongem = nCodaluxmongem;
	}


	public long getnCodusumat() {
		return nCodusumat;
	}


	public void setnCodusumat(long nCodusumat) {
		this.nCodusumat = nCodusumat;
	}


	 

	public Integer getnCantmonedas() {
		return nCantmonedas;
	}


	public void setnCantmonedas(Integer nCantmonedas) {
		this.nCantmonedas = nCantmonedas;
	}


	public Integer getnCantgemas() {
		return nCantgemas;
	}


	public void setnCantgemas(Integer nCantgemas) {
		this.nCantgemas = nCantgemas;
	}


	public String getvFlgest() {
		return vFlgest;
	}


	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}


	public int getnCodUsuRegistro() {
		return nCodUsuRegistro;
	}


	public void setnCodUsuRegistro(int nCodUsuRegistro) {
		this.nCodUsuRegistro = nCodUsuRegistro;
	}


	public Date getdFecRegistro() {
		return dFecRegistro;
	}


	public void setdFecRegistro(Date dFecRegistro) {
		this.dFecRegistro = dFecRegistro;
	}


	public String getvHostRegistro() {
		return vHostRegistro;
	}


	public void setvHostRegistro(String vHostRegistro) {
		this.vHostRegistro = vHostRegistro;
	}


	public int getnCodUsuModificado() {
		return nCodUsuModificado;
	}


	public void setnCodUsuModificado(int nCodUsuModificado) {
		this.nCodUsuModificado = nCodUsuModificado;
	}


	public Date getDfecModificado() {
		return dfecModificado;
	}


	public void setDfecModificado(Date dfecModificado) {
		this.dfecModificado = dfecModificado;
	}


	public String getvHostModificado() {
		return vHostModificado;
	}


	public void setvHostModificado(String vHostModificado) {
		this.vHostModificado = vHostModificado;
	}


	public Integer getnCantbono() {
		return nCantbono;
	}


	public void setnCantbono(Integer nCantbono) {
		this.nCantbono = nCantbono;
	}


 
 

	

}