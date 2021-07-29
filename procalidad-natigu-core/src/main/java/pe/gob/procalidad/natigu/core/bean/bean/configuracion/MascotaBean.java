package pe.gob.procalidad.natigu.core.bean.bean.configuracion;

import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean2;

@SuppressWarnings("serial")
public class MascotaBean extends BaseBean{
	
	//Atributos
	 
	private String   nombre;
	private String   descripcion;
	private String   imagen; 
	private Integer   valormoneda;
	private MaestraBean situacion = new MaestraBean();
	private MaestraBean nivel = new MaestraBean(); 
	private MaestraBean region = new MaestraBean();
	private Integer   predeterminado;
	private UsuarioMatriculaBean   usuarioMatriculaBean;
	

	private String imagenAlegre;
	private String imagenTriste;
	private String imagenExclamativa;
	private String imagenNormal;
	private String imagenTienda;
	private Integer nSwpredeterminado;
	private Integer 	 retorno;
	private Integer 	 nivelAlumno;
	private MultipartFile 	file;
	
	private Integer cantidadComprado;
	
	private String imagenNormalAlter;
	
	//constructor	
	public MascotaBean() {
		super();
	}

	//Getters and Setters
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	 

	public MaestraBean getRegion() {
		return region;
	}

	public void setRegion(MaestraBean region) {
		this.region = region;
	}

 
	public MaestraBean getSituacion() {
		return situacion;
	}




	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}
	
	
 
	public Integer getNivelAlumno() {
		return nivelAlumno;
	}

	public void setNivelAlumno(Integer nivelAlumno) {
		this.nivelAlumno = nivelAlumno;
	}

	public Integer getValormoneda() {
		return valormoneda;
	}


	public void setValormoneda(Integer valormoneda) {
		this.valormoneda = valormoneda;
	}



	public Integer getPredeterminado() {
		return predeterminado;
	}

	

	public Integer getRetorno() {
		return retorno;
	}

	public void setRetorno(Integer retorno) {
		this.retorno = retorno;
	}

	public void setPredeterminado(Integer predeterminado) {
		this.predeterminado = predeterminado;
	}



	public String getImagenAlegre() {
		return imagenAlegre;
	}

	public void setImagenAlegre(String imagenAlegre) {
		this.imagenAlegre = imagenAlegre;
	}

	public String getImagenTriste() {
		return imagenTriste;
	}

	public void setImagenTriste(String imagenTriste) {
		this.imagenTriste = imagenTriste;
	}

	public String getImagenExclamativa() {
		return imagenExclamativa;
	}

	public void setImagenExclamativa(String imagenExclamativa) {
		this.imagenExclamativa = imagenExclamativa;
	}

	public String getImagenNormal() {
		return imagenNormal;
	}

	public void setImagenNormal(String imagenNormal) {
		this.imagenNormal = imagenNormal;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Integer getCantidadComprado() {
		return cantidadComprado;
	}

	public void setCantidadComprado(Integer cantidadComprado) {
		this.cantidadComprado = cantidadComprado;
	}
	
	public String getImagenTienda() {
		return imagenTienda;
	}

	public void setImagenTienda(String imagenTienda) {
		this.imagenTienda = imagenTienda;
	}

	public Integer getnSwpredeterminado() {
		return nSwpredeterminado;
	}

	public void setnSwpredeterminado(Integer nSwpredeterminado) {
		this.nSwpredeterminado = nSwpredeterminado;
	}

	public String getImagenNormalAlter() {
		return imagenNormalAlter;
	}

	public void setImagenNormalAlter(String imagenNormalAlter) {
		this.imagenNormalAlter = imagenNormalAlter;
	}
	public MaestraBean getNivel() {
		return nivel;
	}

	public void setNivel(MaestraBean nivel) {
		this.nivel = nivel;
	}
	
	public UsuarioMatriculaBean getUsuarioMatriculaBean() {
		return usuarioMatriculaBean;
	}

	public void setUsuarioMatriculaBean(UsuarioMatriculaBean usuarioMatriculaBean) {
		this.usuarioMatriculaBean = usuarioMatriculaBean;
	}

	@Override
	public String toString() {
		return "MascotaBean [nombre=" + nombre + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", valormoneda=" + valormoneda
				+ ", situacion=" + situacion + ", nivel=" + nivel + ", region="
				+ region + ", predeterminado=" + predeterminado
				+ ", usuarioMatriculaBean=" + usuarioMatriculaBean
				+ ", imagenAlegre=" + imagenAlegre + ", imagenTriste="
				+ imagenTriste + ", imagenExclamativa=" + imagenExclamativa
				+ ", imagenNormal=" + imagenNormal + ", imagenTienda="
				+ imagenTienda + ", nSwpredeterminado=" + nSwpredeterminado
				+ ", retorno=" + retorno + ", file=" + file
				+ ", cantidadComprado=" + cantidadComprado
				+ ", imagenNormalAlter=" + imagenNormalAlter + "]";
	}

	 
	 
	
}