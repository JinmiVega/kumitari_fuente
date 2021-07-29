package pe.gob.procalidad.natigu.base.bean.bean;


public class GenericBean {
	
	protected long codigo;

	protected String estado;
		
	protected String audTipo;
	
	protected long audCodigoUsuario;

	protected String audSession;

	protected String audFechaHora;

	protected String audHostIP;

	public GenericBean(){
		super();
	}
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAudTipo() {
		return audTipo;
	}

	public void setAudTipo(String audTipo) {
		this.audTipo = audTipo;
	}

	public long getAudCodigoUsuario() {
		return audCodigoUsuario;
	}

	public void setAudCodigoUsuario(long audCodigoUsuario) {
		this.audCodigoUsuario = audCodigoUsuario;
	}

	public String getAudSession() {
		return audSession;
	}

	public void setAudSession(String audSession) {
		this.audSession = audSession;
	}

	public String getAudFechaHora() {
		return audFechaHora;
	}

	public void setAudFechaHora(String audFechaHora) {
		this.audFechaHora = audFechaHora;
	}

	public String getAudHostIP() {
		return audHostIP;
	}

	public void setAudHostIP(String audHostIP) {
		this.audHostIP = audHostIP;
	}
	
}
