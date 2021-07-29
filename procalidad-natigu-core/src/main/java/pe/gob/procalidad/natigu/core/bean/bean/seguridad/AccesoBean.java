package pe.gob.procalidad.natigu.core.bean.bean.seguridad;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class AccesoBean extends BaseBean{

	private ComponenteBean 	componente 	= new ComponenteBean();
	private PerfilBean 		perfil 		= new PerfilBean();

	private Integer 		item;			
	private String 			flgAsignado;
	private boolean 		flgDelete;
	private boolean 		flgRead;
	private boolean 		flgWrite;
	private boolean			flgExport;
	private String			flgServer;
	public AccesoBean() {
		super();
	}

	public ComponenteBean getComponente() {
		return componente;
	}

	public void setComponente(ComponenteBean componente) {
		this.componente = componente;
	}

	public PerfilBean getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilBean perfil) {
		this.perfil = perfil;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public String getFlgAsignado() {
		return flgAsignado;
	}

	public void setFlgAsignado(String flgAsignado) {
		this.flgAsignado = flgAsignado;
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

	public boolean isFlgExport() {
		return flgExport;
	}

	public void setFlgExport(boolean flgExport) {
		this.flgExport = flgExport;
	}

	public String getFlgServer() {
		return flgServer;
	}

	public void setFlgServer(String flgServer) {
		this.flgServer = flgServer;
	}
	
	
}