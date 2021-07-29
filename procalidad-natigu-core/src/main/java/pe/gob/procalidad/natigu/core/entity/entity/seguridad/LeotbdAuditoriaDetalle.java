package pe.gob.procalidad.natigu.core.entity.entity.seguridad;

import java.io.Serializable;

import javax.persistence.*;

@NamedStoredProcedureQueries({	
	
	@NamedStoredProcedureQuery(name = "leotbd_auditoria_detalle.listar", 
		procedureName = "segu.fun_leotbdaud_det_listar", 
		resultClasses = LeotbdAuditoriaDetalle.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codaud", type = long.class)
	})
		
})

@Entity
@Table(name="leotbd_auditoria_detalle", schema="segu")
public class LeotbdAuditoriaDetalle implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codauddet")
	private Long nCodauddet;
	
	@Column(name="n_codaudit")
	private Long nCodaudit;
	
	@Column(name="v_campo")
	private String vCampo;
	
	@Column(name="v_valorant")
	private String vValorant;
	
	@Column(name="v_valornue")
	private String vValornue;
	
	@Column(name="v_tabla")
	private String vTabla;
	
	@Column(name="v_esquema")
	private String vEsquema;
	
	public LeotbdAuditoriaDetalle() {
	
	}

	public Long getnCodauddet() {
		return nCodauddet;
	}

	public void setnCodauddet(Long nCodauddet) {
		this.nCodauddet = nCodauddet;
	}

	public Long getnCodaudit() {
		return nCodaudit;
	}

	public void setnCodaudit(Long nCodaudit) {
		this.nCodaudit = nCodaudit;
	}

	public String getvCampo() {
		return vCampo;
	}

	public void setvCampo(String vCampo) {
		this.vCampo = vCampo;
	}

	public String getvValorant() {
		return vValorant;
	}

	public void setvValorant(String vValorant) {
		this.vValorant = vValorant;
	}

	public String getvValornue() {
		return vValornue;
	}

	public void setvValornue(String vValornue) {
		this.vValornue = vValornue;
	}

	public String getvTabla() {
		return vTabla;
	}

	public void setvTabla(String vTabla) {
		this.vTabla = vTabla;
	}

	public String getvEsquema() {
		return vEsquema;
	}

	public void setvEsquema(String vEsquema) {
		this.vEsquema = vEsquema;
	}

	@Override
	public String toString() {
		return "LeotbdAuditoriaDetalle [nCodauddet=" + nCodauddet + ", nCodaudit=" + nCodaudit + ", vCampo=" + vCampo
				+ ", vValorant=" + vValorant + ", vValornue=" + vValornue + ", vTabla=" + vTabla + ", vEsquema="
				+ vEsquema + "]";
	}

}