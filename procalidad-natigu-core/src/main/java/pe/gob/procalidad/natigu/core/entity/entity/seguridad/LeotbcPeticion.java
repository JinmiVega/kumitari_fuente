package pe.gob.procalidad.natigu.core.entity.entity.seguridad;

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
	@NamedStoredProcedureQuery(name = "leotbc_peticion.insertar", 
		procedureName = "segu.fun_leotbcpeticion_insertar", 
		resultClasses = LeotbcPeticion.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_estado", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_ipconexion", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_urlpeticion", type = String.class)
		}),
	
		@NamedStoredProcedureQuery(name = "leotbc_peticion.listar", 
		procedureName = "segu.fun_leotbcpeticion_listar", 
		resultClasses = LeotbcPeticion.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_estado", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_ipconexion", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_urlpeticion", type = String.class)
		}),
		
})

@Entity
@Table(name="leotbc_peticion", schema="segu")
public class LeotbcPeticion implements Serializable {
	private static final Long serialVersionUID = 1L;
	
	@Id
	@Column(name="n_codpeticion")
	private Long nCodPeticion;
	
	public LeotbcPeticion() {
		
	}
	
	public Long getnCodPeticion() {
		return nCodPeticion;
	}

	public void setnCodPeticion(Long nCodPeticion) {
		this.nCodPeticion = nCodPeticion;
	}
}