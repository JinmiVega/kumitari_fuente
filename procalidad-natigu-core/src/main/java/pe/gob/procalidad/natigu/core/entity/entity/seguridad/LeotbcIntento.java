package pe.gob.procalidad.natigu.core.entity.entity.seguridad;

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

@NamedStoredProcedureQueries({	
	@NamedStoredProcedureQuery(name = "leotbc_intento.insertar", 
		procedureName = "segu.fun_leotbcintento_insertar", 
		resultClasses = LeotbcIntento.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_estado", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_ipconexion", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_plataforma", type = String.class)
		}),
	
		@NamedStoredProcedureQuery(name = "leotbc_intento.listar", 
		procedureName = "segu.fun_leotbcintento_listar", 
		resultClasses = LeotbcIntento.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_estado", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_ipconexion", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_plataforma", type = String.class)
		}),
		
		@NamedStoredProcedureQuery(name = "leotbc_intento.eliminar", 
		procedureName = "segu.fun_leotbcintento_eliminar", 
		resultClasses = LeotbcIntento.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_estado", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_ipconexion", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_plataforma", type = String.class)
		}),
		
})

@Entity
@Table(name="leotbc_intento", schema="segu")
public class LeotbcIntento implements Serializable {
	private static final Long serialVersionUID = 1L;
	
	@Id
	@Column(name="v_ipconexion")
	private String vIpConexion;
	
	public LeotbcIntento() {
		
	}
	
	public String getvIpConexion() {
		return vIpConexion;
	}

	public void setvIpConexion(String vIpConexion) {
		this.vIpConexion = vIpConexion;
	}
}