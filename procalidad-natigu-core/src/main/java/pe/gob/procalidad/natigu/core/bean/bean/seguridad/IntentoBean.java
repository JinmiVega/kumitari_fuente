package pe.gob.procalidad.natigu.core.bean.bean.seguridad;

public class IntentoBean {
		
	private String ipConexion;
		
	private Integer intentos;
	
	private String plataforma;
		
	private Boolean bloqueo;
		
	private String fecha;
		
	public IntentoBean() {
		super();
	}
		
	public String getIpConexion() {
		return ipConexion;
	}

	public void setIpConexion(String ipConexion) {
		this.ipConexion = ipConexion;
	}
		
	public Integer getIntentos() {
		return intentos;
	}

	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}
	
	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
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