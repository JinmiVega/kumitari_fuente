package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;


public class InstitucionBean extends BaseBean{
	
	//Atributos
	private String   nombreInstitucion;
	private String   descripcion;
	private int  	 codigoDirector;
	private int  	 codsitins;
	private MaestraBean  	 tipoActividad =  new MaestraBean();
	private String   numeroUgel;
	private String   codigoModular;
	private String   codigoLocal;
	//private int      codigoUbigeo;
	private String	 nombreUbigeo;
	private String   direccionInstitucion;
	private MaestraBean		 tipoAreaGeografica =  new MaestraBean();
	private String 	 latitud;
	private String 	 longitud;
	private String   urlPaginaWeb;
	private String   telefono;
	private String   correo;
	//private String 	 estado;
	private String 	 codigoRegion;
	
	private MaestraBean tipoInstitucion = new MaestraBean();
	private MaestraBean situacion = new MaestraBean();
	private PersonaBean personaBean =  new PersonaBean();

//	private InstitucionDirectorBean institucionDirectorBean = new InstitucionDirectorBean();	
	private UbigeoBean ubigeoBean =  new UbigeoBean();
	private String nombreCorto;
	
	
	//constructor	
	
	public InstitucionBean() {
		super();
	}

	//Getters and Setters
	

	public String getNombreInstitucion() {
		return nombreInstitucion;
	}


	public void setNombreInstitucion(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCodsitins() {
		return codsitins;
	}


	public void setCodsitins(int codsitins) {
		this.codsitins = codsitins;
	}

	public String getNumeroUgel() {
		return numeroUgel;
	}


	public void setNumeroUgel(String numeroUgel) {
		this.numeroUgel = numeroUgel;
	}


	public String getCodigoModular() {
		return codigoModular;
	}


	public void setCodigoModular(String codigoModular) {
		this.codigoModular = codigoModular;
	}


	public String getCodigoLocal() {
		return codigoLocal;
	}


	public void setCodigoLocal(String codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

	public String getLatitud() {
		return latitud;
	}


	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}


	public String getLongitud() {
		return longitud;
	}


	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}


	public String getUrlPaginaWeb() {
		return urlPaginaWeb;
	}


	public void setUrlPaginaWeb(String urlPaginaWeb) {
		this.urlPaginaWeb = urlPaginaWeb;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


/*	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
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
	}*/



	public MaestraBean getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(MaestraBean tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public MaestraBean getTipoAreaGeografica() {
		return tipoAreaGeografica;
	}

	public void setTipoAreaGeografica(MaestraBean tipoAreaGeografica) {
		this.tipoAreaGeografica = tipoAreaGeografica;
	}

	public MaestraBean getSituacion() {
		return situacion;
	}

	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}

	public MaestraBean getTipoInstitucion() {
		return tipoInstitucion;
	}

	public void setTipoInstitucion(MaestraBean tipoInstitucion) {
		this.tipoInstitucion = tipoInstitucion;
	}

	public String getCodigoRegion() {
		return codigoRegion;
	}

	public void setCodigoRegion(String codigoRegion) {
		this.codigoRegion = codigoRegion;
	}
	public String getNombreUbigeo() {
		return nombreUbigeo;
	}

	public void setNombreUbigeo(String nombreUbigeo) {
		this.nombreUbigeo = nombreUbigeo;
	}

	public UbigeoBean getUbigeoBean() {
		return ubigeoBean;
	}

	public void setUbigeoBean(UbigeoBean ubigeoBean) {
		this.ubigeoBean = ubigeoBean;
	}

	public String getDireccionInstitucion() {
		return direccionInstitucion;
	}

	public void setDireccionInstitucion(String direccionInstitucion) {
		this.direccionInstitucion = direccionInstitucion;
	}

	public PersonaBean getPersonaBean() {
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

	public int getCodigoDirector() {
		return codigoDirector;
	}

	public void setCodigoDirector(int codigoDirector) {
		this.codigoDirector = codigoDirector;
	}
	
	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	//toString
	
	@Override
	public String toString() {
		return "InstitucionBean [nombreInstitucion=" + nombreInstitucion
				+ ", descripcion=" + descripcion + ", codigoDirector="
				+ codigoDirector + ", codsitins=" + codsitins
				+ ", tipoActividad=" + tipoActividad + ", numeroUgel="
				+ numeroUgel + ", codigoModular=" + codigoModular
				+ ", codigoLocal=" + codigoLocal + ", nombreUbigeo="
				+ nombreUbigeo + ", direccionInstitucion="
				+ direccionInstitucion + ", tipoAreaGeografica="
				+ tipoAreaGeografica + ", latitud=" + latitud + ", longitud="
				+ longitud + ", urlPaginaWeb=" + urlPaginaWeb + ", telefono="
				+ telefono + ", correo=" + correo + ", estado=" + estado
				+ ", codigoRegion=" + codigoRegion + ", tipoInstitucion="
				+ tipoInstitucion + ", situacion=" + situacion
				+ ", personaBean=" + personaBean + ", ubigeoBean=" + ubigeoBean
				+ ", nombreCorto=" + nombreCorto + "]";
	}


	
	
	
}
