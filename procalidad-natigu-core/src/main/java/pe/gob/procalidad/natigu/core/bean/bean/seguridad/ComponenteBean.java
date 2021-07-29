package pe.gob.procalidad.natigu.core.bean.bean.seguridad;



import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class ComponenteBean extends BaseBean{

	private Long codigoComponentePadre;

	private Long codigoComponente;

	private String descripcion;

	private String nombreComponente;
	
	
	private PerfilBean perfil;
	
	
	private boolean flgDelete;

	
	private boolean flgRead;

	
	private boolean flgWrite;


	public ComponenteBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getCodigoComponentePadre() {
		return codigoComponentePadre;
	}


	public void setCodigoComponentePadre(Long codigoComponentePadre) {
		this.codigoComponentePadre = codigoComponentePadre;
	}


	public Long getCodigoComponente() {
		return codigoComponente;
	}


	public void setCodigoComponente(Long codigoComponente) {
		this.codigoComponente = codigoComponente;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getNombreComponente() {
		return nombreComponente;
	}


	public void setNombreComponente(String nombreComponente) {
		this.nombreComponente = nombreComponente;
	}


	public PerfilBean getPerfil() {
		return perfil;
	}


	public void setPerfil(PerfilBean perfil) {
		this.perfil = perfil;
	}


	public boolean isFlgDelete() {
		return flgDelete;
	}


	public void setFlgDelete(boolean flgDelete) {
		this.flgDelete = flgDelete;
	}


	public boolean isFlgRead() {
		return flgRead;
	}


	public void setFlgRead(boolean flgRead) {
		this.flgRead = flgRead;
	}


	public boolean isFlgWrite() {
		return flgWrite;
	}


	public void setFlgWrite(boolean flgWrite) {
		this.flgWrite = flgWrite;
	}
	
	
}
