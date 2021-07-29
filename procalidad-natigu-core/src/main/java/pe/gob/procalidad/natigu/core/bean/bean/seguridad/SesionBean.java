package pe.gob.procalidad.natigu.core.bean.bean.seguridad;

public class SesionBean {
	private Long id;
	private String session_id;
	private String active;
	private int  reset_session;
	private int user_id;
	private String date_register;
	
	
	public SesionBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public int getReset_session() {
		return reset_session;
	}
	public void setReset_session(int reset_session) {
		this.reset_session = reset_session;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getDate_register() {
		return date_register;
	}
	public void setDate_register(String date_register) {
		this.date_register = date_register;
	}
	
		

}
