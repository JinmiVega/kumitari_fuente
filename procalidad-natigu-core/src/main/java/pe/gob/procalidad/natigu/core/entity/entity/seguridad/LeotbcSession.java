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
	@NamedStoredProcedureQuery(name = "leotbc_session.gestor", 
		procedureName = "segu.fun_leotbcsession_gestor", 
		resultClasses = LeotbcPeticion.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_reset", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_session_id", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_user_id", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_operacion", type = String.class)
		}),
	
	
		
})




@Entity
@Table(name="leotbc_session", schema="segu")
public class LeotbcSession implements Serializable{
private static final Long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private Long id;
	

	public LeotbcSession() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
