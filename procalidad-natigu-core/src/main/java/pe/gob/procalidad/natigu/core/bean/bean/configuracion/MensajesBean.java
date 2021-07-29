package pe.gob.procalidad.natigu.core.bean.bean.configuracion;
import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;

public class MensajesBean extends BaseBean{
	
	//Atributos
	private LenguaBean lenguaBean = new LenguaBean();
	private String  mensajes;
	private MaestraBean tipoMensaje = new MaestraBean();
	
	//Constructor
	
	public MensajesBean() {
		super();
	}

	//Getters and Setters
	
	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	public String getMensajes() {
		return mensajes;
	}

	public void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}

	public MaestraBean getTipoMensaje() {
		return tipoMensaje;
	}

	public void setTipoMensaje(MaestraBean tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}	

}
