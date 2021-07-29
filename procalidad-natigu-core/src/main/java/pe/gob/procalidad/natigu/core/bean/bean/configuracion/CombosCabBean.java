package pe.gob.procalidad.natigu.core.bean.bean.configuracion;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;

public class CombosCabBean extends BaseBean {

	private String titulo;
	private String descripcion;
	private long monto;
	private Integer monedas;
	private boolean fondo;
	private boolean mascota;
	private boolean moneda;
	private boolean gema;
	private Integer gemas;
	private String nombreImagen;
	private Integer cantidadComprado = 0;
	private MaestraBean  situacion  = new MaestraBean();
	private MascotaBean mascotaBean = new MascotaBean();
	private FondoBean fondoBean = new FondoBean();
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public long getMonto() {
		return monto;
	}
	public void setMonto(long monto) {
		this.monto = monto;
	}
	public String getNombreImagen() {
		return nombreImagen;
	}
	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}
	public Integer getCantidadComprado() {
		return cantidadComprado;
	}
	public void setCantidadComprado(Integer cantidadComprado) {
		this.cantidadComprado = cantidadComprado;
	}
	public MaestraBean getSituacion() {
		return situacion;
	}
	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}
	public MascotaBean getMascotaBean() {
		return mascotaBean;
	}
	public void setMascotaBean(MascotaBean mascotaBean) {
		this.mascotaBean = mascotaBean;
	}
	public FondoBean getFondoBean() {
		return fondoBean;
	}
	public void setFondoBean(FondoBean fondoBean) {
		this.fondoBean = fondoBean;
	}
	public Integer getMonedas() {
		return monedas;
	}
	public void setMonedas(Integer monedas) {
		this.monedas = monedas;
	}

	public boolean isFondo() {
		return fondo;
	}
	public void setFondo(boolean fondo) {
		this.fondo = fondo;
	}
	public boolean isMascota() {
		return mascota;
	}
	public void setMascota(boolean mascota) {
		this.mascota = mascota;
	}
	public boolean isMoneda() {
		return moneda;
	}
	public void setMoneda(boolean moneda) {
		this.moneda = moneda;
	}
	public boolean isGema() {
		return gema;
	}
	public void setGema(boolean gema) {
		this.gema = gema;
	}
	public Integer getGemas() {
		return gemas;
	}
	public void setGemas(Integer gemas) {
		this.gemas = gemas;
	}
	
	
}
