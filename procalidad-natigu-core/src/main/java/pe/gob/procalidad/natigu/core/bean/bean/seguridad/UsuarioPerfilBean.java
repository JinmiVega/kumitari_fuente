package pe.gob.procalidad.natigu.core.bean.bean.seguridad;

import java.util.Date;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class UsuarioPerfilBean extends BaseBean{
	private Long codigoUsuarioPerfil;

	
	//private Long nCodperfil;
	private PerfilBean perfil;

	//private Long nCodusuari;
	private UsuarioBean usuario;
	private Long codigoUsuario;


	
	public UsuarioPerfilBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getCodigoUsuarioPerfil() {
		return codigoUsuarioPerfil;
	}



	public void setCodigoUsuarioPerfil(Long codigoUsuarioPerfil) {
		this.codigoUsuarioPerfil = codigoUsuarioPerfil;
	}



	public PerfilBean getPerfil() {
		return perfil;
	}



	public void setPerfil(PerfilBean perfil) {
		this.perfil = perfil;
	}



	public UsuarioBean getUsuario() {
		return usuario;
	}



	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}



	public Long getCodigoUsuario() {
		return codigoUsuario;
	}



	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	
	
	
}
