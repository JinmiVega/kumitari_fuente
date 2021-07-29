package pe.gob.procalidad.natigu.core.bean.bean.configuracion;

import org.springframework.web.multipart.MultipartFile;
import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;

@SuppressWarnings("serial")
public class SliderDetalleBean extends BaseBean{

	//Atributos
	 
	private SliderBean		sliderBean	= new SliderBean();
	private String  		nombreSlider;
	private String   		imagen;
	private Integer 	 	retorno;
	private MultipartFile 	file;
	private MultipartFile 	fileImagen;
	private MaestraBean		situacion = new MaestraBean();
	
	private Integer 		item;
	
	//constructor	
	public SliderDetalleBean() {
		super();
	}	
	//Getters and Setters

	public SliderBean getSliderBean() {
		return sliderBean;
	}

	public void setSliderBean(SliderBean sliderBean) {
		this.sliderBean = sliderBean;
	}

	public String getNombreSlider() {
		return nombreSlider;
	}

	public void setNombreSlider(String nombreSlider) {
		this.nombreSlider = nombreSlider;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Integer getRetorno() {
		return retorno;
	}

	public void setRetorno(Integer retorno) {
		this.retorno = retorno;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public MaestraBean getSituacion() {
		return situacion;
	}

	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}

	public MultipartFile getFileImagen() {
		return fileImagen;
	}

	public void setFileImagen(MultipartFile fileImagen) {
		this.fileImagen = fileImagen;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "SliderDetalleBean [sliderBean=" + sliderBean + ", nombreSlider=" + nombreSlider + ", imagen=" + imagen
				+ ", retorno=" + retorno + ", file=" + file + ", fileImagen=" + fileImagen + ", situacion=" + situacion
				+ ", item=" + item + "]";
	}
	
}