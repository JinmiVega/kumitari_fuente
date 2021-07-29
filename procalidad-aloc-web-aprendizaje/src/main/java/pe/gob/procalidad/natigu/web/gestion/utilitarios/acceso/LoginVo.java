package pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso;

public class LoginVo {
	
	private String	nombreUsuario;
	private String 	contrasena;
	
	public LoginVo() {
		super();
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}