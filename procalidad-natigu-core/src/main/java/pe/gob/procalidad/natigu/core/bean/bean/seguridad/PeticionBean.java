package pe.gob.procalidad.natigu.core.bean.bean.seguridad;

public class PeticionBean {
	
	public void setIpConexion(String ipConexion) {
		this.ipConexion = ipConexion;
	}

	private Long codigoPeticion;
	
	private String ipConexion;
	
	private String urlPeticion;
		
	private Boolean bloqueo;
		
	private String fecha;
		
	public PeticionBean() {
		super();
	}

	public Long getCodigoPeticion() {
		return codigoPeticion;
	}

	public void setCodigoPeticion(Long codigoPeticion) {
		this.codigoPeticion = codigoPeticion;
	}

	public String getIpConexion() {
		return ipConexion;
	}

	public void textCorreo(String ipConexion) {
		this.ipConexion = ipConexion;
	}

	public String getUrlPeticion() {
		return urlPeticion;
	}

	public void setUrlPeticion(String urlPeticion) {
		this.urlPeticion = urlPeticion;
	}

	public Boolean getBloqueo() {
		return bloqueo;
	}

	public void setBloqueo(Boolean bloqueo) {
		this.bloqueo = bloqueo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
