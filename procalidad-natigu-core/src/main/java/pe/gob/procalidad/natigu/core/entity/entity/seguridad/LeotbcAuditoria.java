package pe.gob.procalidad.natigu.core.entity.entity.seguridad;

import java.io.Serializable;

import javax.persistence.*;


import java.util.Date;

@NamedStoredProcedureQueries({	
	
	@NamedStoredProcedureQuery(name = "leotbc_auditoria.listar", 
		procedureName = "segu.fun_leotbcauditoria_listar", 
		resultClasses = LeotbcAuditoria.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusuari", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tabla", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomusuari", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperfil", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codaccion", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fecinicio", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fecfin", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_limite", type = Integer.class)
	})
		
})

@Entity
@Table(name="leotbc_auditoria", schema="segu")
public class LeotbcAuditoria implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codaudit")
	private Long nCodaudit;
	
	@Column(name="v_tabla")
	private String vTabla;
	  
	@Column(name="n_tm1accion")
	private Integer nTm1accion;
	
	@Column(name="n_codregaud")
	private Long nCodregaud;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecaud")
	private Date dFecaud;
	
	@Column(name="n_codusuaud")
	private Long nCodusuaud;

	@Column(name="v_hostaud")
	private String vHostaud;
	
	private String v_strfecaud;
	private String v_nomacc_aud;
	private String v_nomusu_aud;
	private String v_nompers_aud;
	
	public LeotbcAuditoria() {
	
	}

	public Long getnCodaudit() {
		return nCodaudit;
	}

	public void setnCodaudit(Long nCodaudit) {
		this.nCodaudit = nCodaudit;
	}

	public String getvTabla() {
		return vTabla;
	}

	public void setvTabla(String vTabla) {
		this.vTabla = vTabla;
	}

	public Integer getnTm1accion() {
		return nTm1accion;
	}

	public void setnTm1accion(Integer nTm1accion) {
		this.nTm1accion = nTm1accion;
	}

	public Long getnCodregaud() {
		return nCodregaud;
	}

	public void setnCodregaud(Long nCodregaud) {
		this.nCodregaud = nCodregaud;
	}

	public Date getdFecaud() {
		return dFecaud;
	}

	public void setdFecaud(Date dFecaud) {
		this.dFecaud = dFecaud;
	}

	public Long getnCodusuaud() {
		return nCodusuaud;
	}

	public void setnCodusuaud(Long nCodusuaud) {
		this.nCodusuaud = nCodusuaud;
	}

	public String getvHostaud() {
		return vHostaud;
	}

	public void setvHostaud(String vHostaud) {
		this.vHostaud = vHostaud;
	}

	public String getV_strfecaud() {
		return v_strfecaud;
	}

	public void setV_strfecaud(String v_strfecaud) {
		this.v_strfecaud = v_strfecaud;
	}

	public String getV_nomacc_aud() {
		return v_nomacc_aud;
	}

	public void setV_nomacc_aud(String v_nomacc_aud) {
		this.v_nomacc_aud = v_nomacc_aud;
	}

	public String getV_nomusu_aud() {
		return v_nomusu_aud;
	}

	public void setV_nomusu_aud(String v_nomusu_aud) {
		this.v_nomusu_aud = v_nomusu_aud;
	}

	public String getV_nompers_aud() {
		return v_nompers_aud;
	}

	public void setV_nompers_aud(String v_nompers_aud) {
		this.v_nompers_aud = v_nompers_aud;
	}

	@Override
	public String toString() {
		return "LeotbcAuditoria [nCodaudit=" + nCodaudit + ", vTabla=" + vTabla + ", nTm1accion=" + nTm1accion
				+ ", nCodregaud=" + nCodregaud + ", dFecaud=" + dFecaud + ", nCodusuaud=" + nCodusuaud + ", vHostaud="
				+ vHostaud + ", v_strfecaud=" + v_strfecaud + ", v_nomacc_aud=" + v_nomacc_aud + ", v_nomusu_aud="
				+ v_nomusu_aud + ", v_nompers_aud=" + v_nompers_aud + "]";
	}

}