package pe.gob.procalidad.natigu.core.entity.entity.seguridad;

import java.io.Serializable;

import javax.persistence.*;

@NamedStoredProcedureQueries({	
	
	@NamedStoredProcedureQuery(name = "leotbcaudtablas.listar_combo", 
		procedureName = "segu.fun_leotbcaudtablas_lista_combo", 
		resultClasses = LeotbcAuditoriaTabla.class,
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_flgoffline", type = String.class)
		}
	)

})

@Entity
@Table(name="leotbc_aud_tablas", schema="segu")
public class LeotbcAuditoriaTabla implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="n_codaudtab")
	private Long nCodaudtab;
	
	@Column(name="v_esquema")
	private String vEsquema;
	
	@Column(name="v_tabla")
	private String vTabla;
	
	@Column(name="v_campo")
	private String vCampo;
	
	@Column(name="v_flgaud")
	private String vFlgauditar;
	
	@Column(name="v_descesque")
	private String vDescesque;
	
	@Column(name="v_desctabla")
	private String vDesctabla;
	
	@Column(name="v_desccampo")
	private String vDesccampo;
	
	@Column(name="v_flgprinc")
	private String vFlgprincipal;
	
	@Column(name="v_flgofflin")
	private String vFlgoffline;
	
	private String nomEsqTabText_1;
	private String nomEsqTabText_2;
	
	public LeotbcAuditoriaTabla() {
	
	}

	public Long getnCodaudtab() {
		return nCodaudtab;
	}

	public void setnCodaudtab(Long nCodaudtab) {
		this.nCodaudtab = nCodaudtab;
	}

	public String getvEsquema() {
		return vEsquema;
	}

	public void setvEsquema(String vEsquema) {
		this.vEsquema = vEsquema;
	}

	public String getvTabla() {
		return vTabla;
	}

	public void setvTabla(String vTabla) {
		this.vTabla = vTabla;
	}

	public String getvCampo() {
		return vCampo;
	}

	public void setvCampo(String vCampo) {
		this.vCampo = vCampo;
	}

	public String getvFlgauditar() {
		return vFlgauditar;
	}

	public void setvFlgauditar(String vFlgauditar) {
		this.vFlgauditar = vFlgauditar;
	}

	public String getvDescesque() {
		return vDescesque;
	}

	public void setvDescesque(String vDescesque) {
		this.vDescesque = vDescesque;
	}

	public String getvDesctabla() {
		return vDesctabla;
	}

	public void setvDesctabla(String vDesctabla) {
		this.vDesctabla = vDesctabla;
	}

	public String getvDesccampo() {
		return vDesccampo;
	}

	public void setvDesccampo(String vDesccampo) {
		this.vDesccampo = vDesccampo;
	}

	public String getvFlgprincipal() {
		return vFlgprincipal;
	}

	public void setvFlgprincipal(String vFlgprincipal) {
		this.vFlgprincipal = vFlgprincipal;
	}

	public String getvFlgoffline() {
		return vFlgoffline;
	}

	public void setvFlgoffline(String vFlgoffline) {
		this.vFlgoffline = vFlgoffline;
	}

	public String getNomEsqTabText_1() {
		return nomEsqTabText_1;
	}

	public void setNomEsqTabText_1(String nomEsqTabText_1) {
		this.nomEsqTabText_1 = nomEsqTabText_1;
	}

	public String getNomEsqTabText_2() {
		return nomEsqTabText_2;
	}

	public void setNomEsqTabText_2(String nomEsqTabText_2) {
		this.nomEsqTabText_2 = nomEsqTabText_2;
	}

	@Override
	public String toString() {
		return "LeotbcAuditoriaTabla [nCodaudtab=" + nCodaudtab + ", vEsquema=" + vEsquema + ", vTabla=" + vTabla
				+ ", vCampo=" + vCampo + ", vFlgauditar=" + vFlgauditar + ", vDescesque=" + vDescesque + ", vDesctabla="
				+ vDesctabla + ", vDesccampo=" + vDesccampo + ", vFlgprincipal=" + vFlgprincipal + ", vFlgoffline="
				+ vFlgoffline + ", nomEsqTabText_1=" + nomEsqTabText_1 + ", nomEsqTabText_2=" + nomEsqTabText_2 + "]";
	}
	
}