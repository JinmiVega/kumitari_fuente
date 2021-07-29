package pe.gob.procalidad.natigu.core.entity.entity.seguridad;

import java.io.Serializable;

import javax.persistence.*;


import java.util.Date;

@NamedStoredProcedureQueries({	
	
	@NamedStoredProcedureQuery(name = "leotbcauditoriaacceso.insertar", 
		procedureName = "segu.fun_leotbcauditacc_insertar", 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codaudacc", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_tm1accion", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_usuacc", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostacc", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_tm1sistem", type = Integer.class)
		}
	),
	@NamedStoredProcedureQuery(name = "leotbcauditoriaacceso.listar", 
		procedureName = "segu.fun_leotbcauditacc_listar", 
		resultClasses = LeotbcAuditoriaAcceso.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperfil", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codaccion", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomusuari", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fecinicio", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fecfin", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_limite", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codsistem", type = Integer.class)
		}
	)
		
})

@Entity
@Table(name="leotbc_audit_acceso", schema="segu")
public class LeotbcAuditoriaAcceso implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codaudacc")
	private Long nCodaudacc;
	  
	@Column(name="n_tm1accion")
	private Integer nTm1accion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecacc")
	private Date dFecacc;
	
	@Column(name="v_usuacc")
	private String vnomUsuacc;

	@Column(name="v_hostacc")
	private String vHostacc;
	
	@Column(name="n_tm1sistem")
	private Integer nTm1sistem;

	private String  v_tabla;
	private String  v_strfecacc;
	private String  v_nomaccion;
	private Integer n_codusuari;
	private String  v_nomperusu;
	private String  v_nomsistem;
	
	public LeotbcAuditoriaAcceso() {
	
	}

	public Long getnCodaudacc() {
		return nCodaudacc;
	}

	public void setnCodaudacc(Long nCodaudacc) {
		this.nCodaudacc = nCodaudacc;
	}

	public Integer getnTm1accion() {
		return nTm1accion;
	}

	public void setnTm1accion(Integer nTm1accion) {
		this.nTm1accion = nTm1accion;
	}

	public Date getdFecacc() {
		return dFecacc;
	}

	public void setdFecacc(Date dFecacc) {
		this.dFecacc = dFecacc;
	}

	public String getVnomUsuacc() {
		return vnomUsuacc;
	}

	public void setVnomUsuacc(String vnomUsuacc) {
		this.vnomUsuacc = vnomUsuacc;
	}

	public String getvHostacc() {
		return vHostacc;
	}

	public void setvHostacc(String vHostacc) {
		this.vHostacc = vHostacc;
	}

	public Integer getnTm1sistem() {
		return nTm1sistem;
	}

	public void setnTm1sistem(Integer nTm1sistem) {
		this.nTm1sistem = nTm1sistem;
	}

	public String getV_tabla() {
		return v_tabla;
	}

	public void setV_tabla(String v_tabla) {
		this.v_tabla = v_tabla;
	}

	public String getV_strfecacc() {
		return v_strfecacc;
	}

	public void setV_strfecacc(String v_strfecacc) {
		this.v_strfecacc = v_strfecacc;
	}

	public String getV_nomaccion() {
		return v_nomaccion;
	}

	public void setV_nomaccion(String v_nomaccion) {
		this.v_nomaccion = v_nomaccion;
	}

	public Integer getN_codusuari() {
		return n_codusuari;
	}

	public void setN_codusuari(Integer n_codusuari) {
		this.n_codusuari = n_codusuari;
	}

	public String getV_nomperusu() {
		return v_nomperusu;
	}

	public void setV_nomperusu(String v_nomperusu) {
		this.v_nomperusu = v_nomperusu;
	}

	public String getV_nomsistem() {
		return v_nomsistem;
	}

	public void setV_nomsistem(String v_nomsistem) {
		this.v_nomsistem = v_nomsistem;
	}

	@Override
	public String toString() {
		return "LeotbcAuditoriaAcceso [nCodaudacc=" + nCodaudacc + ", nTm1accion=" + nTm1accion + ", dFecacc=" + dFecacc
				+ ", vnomUsuacc=" + vnomUsuacc + ", vHostacc=" + vHostacc + ", nTm1sistem=" + nTm1sistem + ", v_tabla="
				+ v_tabla + ", v_strfecacc=" + v_strfecacc + ", v_nomaccion=" + v_nomaccion + ", n_codusuari="
				+ n_codusuari + ", v_nomperusu=" + v_nomperusu + ", v_nomsistem=" + v_nomsistem + "]";
	}

}