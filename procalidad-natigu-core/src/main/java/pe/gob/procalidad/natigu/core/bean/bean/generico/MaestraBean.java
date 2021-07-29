package pe.gob.procalidad.natigu.core.bean.bean.generico;
import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class MaestraBean extends BaseBean {
	
	private Integer id;
	private String 	codigoTabla;
	private Integer codigoRegistro;
	private String 	nombreCorto;
	private String 	nombreLargo;
	private String 	valor1;
	private String 	valor2;
	private String 	valor3;
	private String 	valor4;
	private String fileimg;
	private Integer	orden;
	private String 	editable;
	private String 	swEliminar;
	private String 	descripcion;
	private MultipartFile 	file;
	private MultipartFile 	file1;
	private MultipartFile 	file2;



	//constructor	
	public MaestraBean() {
		super();
	}
	
	//Getters and Setters
	
	public MaestraBean(Integer codigoRegistro, String nombreCorto) {
		super();
		this.codigoRegistro = codigoRegistro;
		this.nombreCorto = nombreCorto;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoTabla() {
		return codigoTabla;
	}

	public void setCodigoTabla(String codigoTabla) {
		this.codigoTabla = codigoTabla;
	}

	public Integer getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(Integer codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public String getValor1() {
		return valor1;
	}

	public void setValor1(String valor1) {
		this.valor1 = valor1;
	}

	public String getValor2() {
		return valor2;
	}

	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}

	public String getValor3() {
		return valor3;
	}

	public void setValor3(String valor3) {
		this.valor3 = valor3;
	}

	public String getValor4() {
		return valor4;
	}

	public void setValor4(String valor4) {
		this.valor4 = valor4;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getIpCreacion() {
		return ipCreacion;
	}

	public void setIpCreacion(String ipCreacion) {
		this.ipCreacion = ipCreacion;
	}

	public String getIpModificacion() {
		return ipModificacion;
	}

	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}
	

	public String getEditable() {
		return editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	public String getSwEliminar() {
		return swEliminar;
	}

	public void setSwEliminar(String swEliminar) {
		this.swEliminar = swEliminar;
	}
	
	public String getFileimg() {
	return fileimg;
	}

	public void setFileimg(String fileimg) {
		this.fileimg = fileimg;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "MaestraBean [id=" + id + ", codigoTabla=" + codigoTabla + ", codigoRegistro=" + codigoRegistro
				+ ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo + ", valor1=" + valor1 + ", valor2="
				+ valor2 + ", valor3=" + valor3 + ", valor4=" + valor4 + ", fileimg="
						+ fileimg +", orden=" + orden + "]"+super.toString();
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	public MultipartFile getFile2() {
		return file2;
	}

	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}
 
	
}
