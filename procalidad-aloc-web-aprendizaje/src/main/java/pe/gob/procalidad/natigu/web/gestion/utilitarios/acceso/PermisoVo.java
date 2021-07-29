package pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso;

public class PermisoVo {

	private boolean lectura;
	private boolean escritura;
	private boolean eliminacion;
	private boolean exportacion;
	
	public PermisoVo() {
	}

	public boolean isLectura() {
		return lectura;
	}

	public void setLectura(boolean lectura) {
		this.lectura = lectura;
	}

	public boolean isEscritura() {
		return escritura;
	}

	public void setEscritura(boolean escritura) {
		this.escritura = escritura;
	}

	public boolean isEliminacion() {
		return eliminacion;
	}

	public void setEliminacion(boolean eliminacion) {
		this.eliminacion = eliminacion;
	}

	public boolean isExportacion() {
		return exportacion;
	}

	public void setExportacion(boolean exportacion) {
		this.exportacion = exportacion;
	}
	
}