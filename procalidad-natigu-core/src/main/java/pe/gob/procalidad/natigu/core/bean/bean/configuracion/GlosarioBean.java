package pe.gob.procalidad.natigu.core.bean.bean.configuracion;
import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;

public class GlosarioBean extends BaseBean{
	
	//Atributos
	private Long codigoGlosario;
	private LenguaBean lenguaBean = new LenguaBean();
	private String  detalle;
	private String mimmeType;
	private String fileName;
	private Integer peso;
	private MultipartFile 	file;
	//Constructor
	
	public GlosarioBean() {
		super();
	}

	//Getters and Setters
	
	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	
	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Long getCodigoGlosario() {
		return codigoGlosario;
	}

	public void setCodigoGlosario(Long codigoGlosario) {
		this.codigoGlosario = codigoGlosario;
	}

	public String getMimmeType() {
		return mimmeType;
	}

	public void setMimmeType(String mimmeType) {
		this.mimmeType = mimmeType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "GlosarioBean [codigoGlosario=" + codigoGlosario
				+ ", lenguaBean=" + lenguaBean + ", detalle=" + detalle
				+ ", mimmeType=" + mimmeType + ", fileName=" + fileName
				+ ", peso=" + peso + "]";
	}
	

}
