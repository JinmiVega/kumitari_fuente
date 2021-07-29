package pe.gob.procalidad.natigu.core.bean.bean.generico;

import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class CrucigramaDetBean extends BaseBean{

	private RelacionCabeceraBean relacionCabeceraBean = new RelacionCabeceraBean(); 
	private String 	palabra; 
	private String 	palabraEncrypt; 
	private Integer 	orden; 
	
	public CrucigramaDetBean() {
		super();
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public RelacionCabeceraBean getRelacionCabeceraBean() {
		return relacionCabeceraBean;
	}

	public void setRelacionCabeceraBean(RelacionCabeceraBean relacionCabeceraBean) {
		this.relacionCabeceraBean = relacionCabeceraBean;
	}

	public String getPalabraEncrypt() {
		return palabraEncrypt;
	}

	public void setPalabraEncrypt(String palabraEncrypt) {
		this.palabraEncrypt = palabraEncrypt;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "CrucigramaDetBean [relacionCabeceraBean="
				+ relacionCabeceraBean + ", palabra=" + palabra + ", orden="
				+ orden + "]";
	}
	
 

 
	 
	 


	
}
