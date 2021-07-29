package pe.gob.procalidad.natigu.core.bean.bean.academico;


import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
 

public class DocumentoInscripcionBean extends BaseBean {
	

	private InscripcionBean inscripcion = new InscripcionBean();

	private MaestraBean 	situacion;

	private String 			numedocu;
	
	private String 			rutadocu;
	
	private String 			nombdocu;
	
	private MultipartFile 	file;
	
	
	public DocumentoInscripcionBean() {
		super();
	
		
	}



	public InscripcionBean getInscripcion() {
		return inscripcion;
	}



	public void setInscripcion(InscripcionBean inscripcion) {
		this.inscripcion = inscripcion;
	}



	public MaestraBean getSituacion() {
		if (situacion == null) {
			situacion = new MaestraBean();
		}
		return situacion;
	}



	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}



	public String getNumedocu() {
		return numedocu;
	}



	public void setNumedocu(String numedocu) {
		this.numedocu = numedocu;
	}



	public String getRutadocu() {
		return rutadocu;
	}



	public void setRutadocu(String rutadocu) {
		this.rutadocu = rutadocu;
	}



	public String getNombdocu() {
		return nombdocu;
	}



	public void setNombdocu(String nombdocu) {
		this.nombdocu = nombdocu;
	}



	public MultipartFile getFile() {
		return file;
	}



	public void setFile(MultipartFile file) {
		this.file = file;
	}



	
	

}
