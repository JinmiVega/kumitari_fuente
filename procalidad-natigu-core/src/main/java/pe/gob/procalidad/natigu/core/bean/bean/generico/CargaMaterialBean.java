package pe.gob.procalidad.natigu.core.bean.bean.generico;

import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class CargaMaterialBean extends BaseBean {
	
	private MaestraBean 	subNivel 		= new MaestraBean();
	private LenguaBean 		lengua 			= new LenguaBean();
	private MaestraBean 	situacion  		= new MaestraBean();
	private MaestraBean 	nivel 			= new MaestraBean();
	private MaestraBean 	unidad 			= new MaestraBean();
	private MaestraBean 	tipoEjercicio 	= new MaestraBean();
//	private EjercicioBean 	ejercicio 		= new EjercicioBean();
	private RelacionBean	relacion		= new RelacionBean();
	private UnidadLeccionBean leccion		= new UnidadLeccionBean();
	private LeccionMaterialBean material 	= new LeccionMaterialBean();
	private PreguntaBean 	pregunta 		= new PreguntaBean();
//	private AlternativaBean 	respuestas 		= new AlternativaBean();
	
	private MultipartFile 	fileCarga;
	private MultipartFile 	fileCargaRar;
	
	public CargaMaterialBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MaestraBean getSubNivel() {
		return subNivel;
	}
	public void setSubNivel(MaestraBean subNivel) {
		this.subNivel = subNivel;
	}
	public LenguaBean getLengua() {
		return lengua;
	}
	public void setLengua(LenguaBean lengua) {
		this.lengua = lengua;
	}
	public MaestraBean getSituacion() {
		return situacion;
	}
	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}
	public MaestraBean getNivel() {
		return nivel;
	}
	public void setNivel(MaestraBean nivel) {
		this.nivel = nivel;
	}
	public MaestraBean getUnidad() {
		return unidad;
	}
	public void setUnidad(MaestraBean unidad) {
		this.unidad = unidad;
	}
	public MaestraBean getTipoEjercicio() {
		return tipoEjercicio;
	}
	public void setTipoEjercicio(MaestraBean tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}
//	public EjercicioBean getEjercicio() {
//		return ejercicio;
//	}
//	public void setEjercicio(EjercicioBean ejercicio) {
//		this.ejercicio = ejercicio;
//	}
	
//	@Override
//	public String toString() {
//		return "CargaMaterialBean [subNivel=" + subNivel + ", lengua=" + lengua + ", situacion=" + situacion
//				+ ", nivel=" + nivel + ", unidad=" + unidad + ", tipoEjercicio=" + tipoEjercicio + ", ejercicio="
//				+ ejercicio + ", leccion=" + leccion + "]";
//	}
	public MultipartFile getFileCarga() {
		return fileCarga;
	}
	public UnidadLeccionBean getLeccion() {
		return leccion;
	}
	public void setLeccion(UnidadLeccionBean leccion) {
		this.leccion = leccion;
	}
	public LeccionMaterialBean getMaterial() {
		return material;
	}
	public void setMaterial(LeccionMaterialBean material) {
		this.material = material;
	}
	public void setFileCarga(MultipartFile fileCarga) {
		this.fileCarga = fileCarga;
	}
	public PreguntaBean getPregunta() {
		return pregunta;
	}
	public void setPregunta(PreguntaBean pregunta) {
		this.pregunta = pregunta;
	}

	public MultipartFile getFileCargaRar() {
		return fileCargaRar;
	}
	public void setFileCargaRar(MultipartFile fileCargaRar) {
		this.fileCargaRar = fileCargaRar;
	}
	public RelacionBean getRelacion() {
		return relacion;
	}
	public void setRelacion(RelacionBean relacion) {
		this.relacion = relacion;
	}

//	public AlternativaBean getRespuestas() {
//		return respuestas;
//	}
//	public void setRespuestas(AlternativaBean respuestas) {
//		this.respuestas = respuestas;
//	}


	
}
