package pe.gob.procalidad.natigu.core.bean.bean.generico;



import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class InstitucionDirectorBean extends BaseBean {

	// Atributos
	private InstitucionBean institucion = new InstitucionBean();
	private MaestraBean situacionDirector = new MaestraBean();
	private String urlWeb;
	private String telefono;
	private String correo;
	private String descripcion;

	private PersonaBean personaBean = new PersonaBean();
	
	

	// Constructor
	public InstitucionDirectorBean() {
		super();
	}

	// Getters and Setters

	public InstitucionBean getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InstitucionBean institucion) {
		this.institucion = institucion;
	}

	public MaestraBean getSituacionDirector() {
		return situacionDirector;
	}

	public void setSituacionDirector(MaestraBean situacionDirector) {
		this.situacionDirector = situacionDirector;
	}

	public String getUrlWeb() {
		return urlWeb;
	}

	public void setUrlWeb(String urlWeb) {
		this.urlWeb = urlWeb;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public PersonaBean getPersonaBean() {
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}


	@Override
	public String toString() {
		return "InstitucionDirectorBean [institucion=" + institucion
				+ ", situacionDirector=" + situacionDirector + ", urlWeb="
				+ urlWeb + ", telefono=" + telefono + ", correo=" + correo
				+ ", descripcion=" + descripcion + ", personaBean="
				+ personaBean + "]";
	}

}
