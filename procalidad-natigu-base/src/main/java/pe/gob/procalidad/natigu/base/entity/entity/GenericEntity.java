package pe.gob.procalidad.natigu.base.entity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOTBC_ENTIDAD")
public class GenericEntity {
	
	@Id
	@Column(name="N_CODENT")
	protected long codigo;

	@Column(name="C_ESTADO")	
	protected String estado;
		
	@Column(name="C_AUD_TIPO")		
	protected String audTipo;
	
	@Column(name="N_AUD_CODUSUARIO")	
	protected long audCodigoUsuario;

	@Column(name="V_AUD_SESSION")	
	protected String audSession;

	@Column(name="D_AUD_FECHA_HORA")	
	protected String audFechaHora;

	@Column(name="V_AUD_HOST_IP")	
	protected String audHostIP;
	
	

}
