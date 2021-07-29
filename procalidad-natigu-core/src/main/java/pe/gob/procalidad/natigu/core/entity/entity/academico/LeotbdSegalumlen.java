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
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcLenguaEstruc;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcPersona;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdLeUndLeccion;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdLestunidad;

@NamedStoredProcedureQueries({
	
	@NamedStoredProcedureQuery(name = "leotbdSegalumlen.buscar_x_filtros", procedureName = "acad.fun_leotbdSegalumlen_buscar_x_filtros", 
			resultClasses = LeotbdSegalumlen.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinscr", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinst", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomalum", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitau", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinscrlen", type = Long.class)
			
	}),
	
	@NamedStoredProcedureQuery(name = "leotbdSegalumlen.listarSubNivel", 
	procedureName = " acad.leotbd_segalumlen_listar_subnivel ", 
	resultClasses = LeotbcLenguaEstruc.class, parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class)
	
	}),
	
	@NamedStoredProcedureQuery(name = "leotbdSegalumlen.listarUnidad", 
	procedureName = "acad.leotbd_segalumlen_listar_unidad", 
	resultClasses = LeotbdLestunidad.class, parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlenest", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class)
	
	}),

	@NamedStoredProcedureQuery(name = "leotbdSegalumlen.listarLeccion", 
	procedureName = "acad.leotbd_segalumlen_listar_leccion", 
	resultClasses = LeotbdLeUndLeccion.class, parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlesuni", type = Long.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class)
	
	}),
	
	@NamedStoredProcedureQuery(name = "leotbdSegalumlen.insertar", 
	procedureName = "acad.fun_leotbdsegalumlen_insertar", 
	parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codsegalu", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codalumno", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatri", type = Long.class),
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
			}),
			
			@NamedStoredProcedureQuery(name = "leotbdSegalumlen.insertar_SigLeccion", 
			procedureName = "acad.fun_leotbdsegalumlen_InsertarSigLeccion", 
			parameters = {
					@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codsegalu", type = Integer.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codundlec", type = Long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codundlecAct", type = Integer.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
					}),
			
		 
			@NamedStoredProcedureQuery(name = "leotbdSegalumlen.eliminar", procedureName = "acad.fun_leotbdSegalumlen_eliminar_usuario_alumno", 
			resultClasses = LeotbdSegalumlen.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumat", type = Long.class),
						
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			}),
			
			 

})


@Entity
@Table(name="acad.leotbd_usumatricula")
public class LeotbdSegalumlen implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Id
	@Column(name="n_codsegalu")
	private long nCodsegalu;
	
	@Column(name="n_codusumat")
	private long nCodusumat;
		
	@Column(name="n_tm1sitseg")
	private long nTm1sitseg;
	
	@Column(name="n_codundlec")
	private long nCodundlec;

	private long n_codlenest;
	private int n_tm2unidad;
	private int n_tm2subnivel;
	private int n_tm2nivel;
	private String v_swactivo;
	private String v_nombimag;
	private String v_nombimagbloq;
	
	
	public long getnCodsegalu() {
		return nCodsegalu;
	}

	public void setnCodsegalu(long nCodsegalu) {
		this.nCodsegalu = nCodsegalu;
	}

	public long getnCodusumat() {
		return nCodusumat;
	}

	public void setnCodusumat(long nCodusumat) {
		this.nCodusumat = nCodusumat;
	}

	public long getnTm1sitseg() {
		return nTm1sitseg;
	}

	public void setnTm1sitseg(long nTm1sitseg) {
		this.nTm1sitseg = nTm1sitseg;
	}

	public long getnCodundlec() {
		return nCodundlec;
	}

	public void setnCodundlec(long nCodundlec) {
		this.nCodundlec = nCodundlec;
	}

	public int getN_tm2subnivel() {
		return n_tm2subnivel;
	}

	public void setN_tm2subnivel(int n_tm2subnivel) {
		this.n_tm2subnivel = n_tm2subnivel;
	}

	public String getV_swactivo() {
		return v_swactivo;
	}

	public void setV_swactivo(String v_swactivo) {
		this.v_swactivo = v_swactivo;
	}

	public int getN_tm2nivel() {
		return n_tm2nivel;
	}

	public void setN_tm2nivel(int n_tm2nivel) {
		this.n_tm2nivel = n_tm2nivel;
	}

	public String getV_nombimag() {
		return v_nombimag;
	}

	public void setV_nombimag(String v_nombimag) {
		this.v_nombimag = v_nombimag;
	}

	public long getN_codlenest() {
		return n_codlenest;
	}

	public void setN_codlenest(long n_codlenest) {
		this.n_codlenest = n_codlenest;
	}

	public int getN_tm2unidad() {
		return n_tm2unidad;
	}

	public void setN_tm2unidad(int n_tm2unidad) {
		this.n_tm2unidad = n_tm2unidad;
	}

	public String getV_nombimagbloq() {
		return v_nombimagbloq;
	}

	public void setV_nombimagbloq(String v_nombimagbloq) {
		this.v_nombimagbloq = v_nombimagbloq;
	}			
		 
	
}
