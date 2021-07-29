package pe.gob.procalidad.natigu.core.bean.bean.generico;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
 
 
public class LenguaEstructuraBean extends BaseBean{
	 
	private LenguaBean lenguaBean = new LenguaBean(); 
	
	private LenguaNivelBean lenguaNivelBean;
	
	private MaestraBean nivel = new MaestraBean(); 

	private String nombreNivel;
	
	private String nombreImagen;
	
	private MaestraBean subNivel = new MaestraBean(); 
	
	private MaestraBean situacion = new MaestraBean(); 
	
	private String swActivo;
	
	private MultipartFile 	fileImagen;
	
	/*** temporales ***/
	
	private String basico;
	private String intermedio;
	private String avanzado;
	private int    cantidadUnidad;
	private int    cantidadLeccion;
	
	private List<LenguaEstructuraBean> listaSubNivel;
	private List<MaestraBean> listaNivel;

	private String codigoEncrypt;
	
	public LenguaEstructuraBean(){
		super();
	}

	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	public MaestraBean getNivel() {
		return nivel;
	}

	public void setNivel(MaestraBean nivel) {
		this.nivel = nivel;
	}

	public MaestraBean getSubNivel() {
		return subNivel;
	}

	public void setSubNivel(MaestraBean subNivel) {
		this.subNivel = subNivel;
	}

	public MaestraBean getSituacion() {
		return situacion;
	}

	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}

	public String getSwActivo() {
		return swActivo;
	}

	public void setSwActivo(String swActivo) {
		this.swActivo = swActivo;
	}

	public String getBasico() {
		return basico;
	}

	public void setBasico(String basico) {
		this.basico = basico;
	}

	public String getIntermedio() {
		return intermedio;
	}

	public void setIntermedio(String intermedio) {
		this.intermedio = intermedio;
	}

	public String getAvanzado() {
		return avanzado;
	}

	public void setAvanzado(String avanzado) {
		this.avanzado = avanzado;
	}

	public int getCantidadUnidad() {
		return cantidadUnidad;
	}

	public void setCantidadUnidad(int cantidadUnidad) {
		this.cantidadUnidad = cantidadUnidad;
	}

	
	public int getCantidadLeccion() {
		return cantidadLeccion;
	}

	public void setCantidadLeccion(int cantidadLeccion) {
		this.cantidadLeccion = cantidadLeccion;
	}

	public String getNombreNivel() {
		return nombreNivel;
	}

	public void setNombreNivel(String nombreNivel) {
		this.nombreNivel = nombreNivel;
	}

	public LenguaNivelBean getLenguaNivelBean() {
		return lenguaNivelBean;
	}

	public void setLenguaNivelBean(LenguaNivelBean lenguaNivelBean) {
		this.lenguaNivelBean = lenguaNivelBean;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public MultipartFile getFileImagen() {
		return fileImagen;
	}

	public void setFileImagen(MultipartFile fileImagen) {
		this.fileImagen = fileImagen;
	}

	@Override
	public String toString() {
		return "LenguaEstructuraBean [lenguaBean=" + lenguaBean + ", lenguaNivelBean=" + lenguaNivelBean + ", nivel="
				+ nivel + ", nombreNivel=" + nombreNivel + ", subNivel=" + subNivel + ", situacion=" + situacion
				+ ", swActivo=" + swActivo + ", basico=" + basico + ", intermedio=" + intermedio + ", avanzado="
				+ avanzado + ", cantidadUnidad=" + cantidadUnidad + ", cantidadLeccion=" + cantidadLeccion + "]";
	}

	public List<LenguaEstructuraBean> getListaSubNivel() {
		return listaSubNivel;
	}

	public void setListaSubNivel(List<LenguaEstructuraBean> listaSubNivel) {
		this.listaSubNivel = listaSubNivel;
	}

	public List<MaestraBean> getListaNivel() {
		return listaNivel;
	}

	public void setListaNivel(List<MaestraBean> listaNivel) {
		this.listaNivel = listaNivel;
	}

	public String getCodigoEncrypt() {
		return codigoEncrypt;
	}

	public void setCodigoEncrypt(String codigoEncrypt) {
		this.codigoEncrypt = codigoEncrypt;
	}

	 
}
