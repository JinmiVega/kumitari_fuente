package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class UbigeoBean extends BaseBean{

	//Atributos
	private String nombreUbigeo;
	private String codigoRegion;
	private String codigoProvincia;
	private String codigoDistrito;
	private String codigoUbigeo;
	private int    codigoPais;
	
	//Constructor
	public UbigeoBean() {
		super();
	}
	
	//Getters and Setters
	public String getNombreUbigeo() {
		return nombreUbigeo;
	}

	public void setNombreUbigeo(String nombreUbigeo) {
		this.nombreUbigeo = nombreUbigeo;
	}

	public String getCodigoRegion() {
		return codigoRegion;
	}

	public void setCodigoRegion(String codigoRegion) {
		this.codigoRegion = codigoRegion;
	}

	public String getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public String getCodigoDistrito() {
		return codigoDistrito;
	}

	public void setCodigoDistrito(String codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}

	public String getCodigoUbigeo() {
		return codigoUbigeo;
	}

	public void setCodigoUbigeo(String codigoUbigeo) {
		this.codigoUbigeo = codigoUbigeo;
	}

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}
	
	//toString
	@Override
	public String toString() {
		return "UbigeoBean [nombreUbigeo=" + nombreUbigeo + ", codigoRegion="
				+ codigoRegion + ", codigoProvincia=" + codigoProvincia
				+ ", codigoDistrito=" + codigoDistrito + ", codigoUbigeo="
				+ codigoUbigeo + ", codigoPais=" + codigoPais + "]";
	}
	
	
	
}
