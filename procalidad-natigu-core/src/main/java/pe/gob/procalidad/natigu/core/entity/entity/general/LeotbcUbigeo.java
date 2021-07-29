package pe.gob.procalidad.natigu.core.entity.entity.general;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbcUbigeo.listarComboRegion", 
			procedureName = "gene.fun_leotbcubigeo_listarcomboregion", 
			resultClasses = LeotbcUbigeo.class, 
			parameters = {			

		}),
		@NamedStoredProcedureQuery(name = "leotbcUbigeo.listarComboProvincia", 
		procedureName = "gene.fun_leotbcubigeo_listarcomboprovincia", 
		resultClasses = LeotbcUbigeo.class, 
		parameters = {
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = String.class)

		}),	
		
		@NamedStoredProcedureQuery(name = "leotbcUbigeo.buscarXNombreCodigoUbigeo", 
		procedureName = "gene.fun_leotbcubigeo_buscarxnombre", 
		resultClasses = LeotbcUbigeo.class, 
		parameters = {
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomdept", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomprov", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomdist", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codubigeo", type = String.class)

		}),
		@NamedStoredProcedureQuery(name = "leotbcUbigeo.listarComboDistrito", 
		procedureName = "gene.fun_leotbcubigeo_listarcombodistrito", 
		resultClasses = LeotbcUbigeo.class, 
		parameters = {
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codprovin", type = String.class)

		})		
	
 
})

@Entity
@Table(name = "leotbc_ubigeo",schema="gene")
public class LeotbcUbigeo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "n_codubigre")
	private int nCodubigre;
	
	@Column(name = "v_nombreubi")
	private String vNombreubi;
	
	@Column(name = "v_codregion")
	private String vCodregion;
	
	@Column(name = "v_codprovin")
	private String vCodprovin;
	
	@Column(name = "v_coddistrito")
	private String vCoddistrito;
	
	@Column(name = "v_codubigeo")
	private String vCodubigeo;
	
	@Column(name = "n_codpais")
	private int nCodpais;

	public LeotbcUbigeo() {
		super();
	}

	public int getnCodubigre() {
		return nCodubigre;
	}

	public void setnCodubigre(int nCodubigre) {
		this.nCodubigre = nCodubigre;
	}

	public String getvNombreubi() {
		return vNombreubi;
	}

	public void setvNombreubi(String vNombreubi) {
		this.vNombreubi = vNombreubi;
	}

	public String getvCodregion() {
		return vCodregion;
	}

	public void setvCodregion(String vCodregion) {
		this.vCodregion = vCodregion;
	}

	public String getvCodprovin() {
		return vCodprovin;
	}

	public void setvCodprovin(String vCodprovin) {
		this.vCodprovin = vCodprovin;
	}

	public String getvCoddistrito() {
		return vCoddistrito;
	}

	public void setvCoddistrito(String vCoddistrito) {
		this.vCoddistrito = vCoddistrito;
	}

	public String getvCodubigeo() {
		return vCodubigeo;
	}

	public void setvCodubigeo(String vCodubigeo) {
		this.vCodubigeo = vCodubigeo;
	}

	public int getnCodpais() {
		return nCodpais;
	}

	public void setnCodpais(int nCodpais) {
		this.nCodpais = nCodpais;
	}

	@Override
	public String toString() {
		return "LeotbcUbigeo [nCodubigre=" + nCodubigre + ", vNombreubi="
				+ vNombreubi + ", vCodregion=" + vCodregion + ", vCodprovin="
				+ vCodprovin + ", vCoddistrito=" + vCoddistrito
				+ ", vCodubigeo=" + vCodubigeo + ", nCodpais=" + nCodpais + "]";
	}

	
}
