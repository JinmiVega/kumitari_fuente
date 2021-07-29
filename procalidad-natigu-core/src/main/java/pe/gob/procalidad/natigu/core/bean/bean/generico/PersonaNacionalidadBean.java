package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class PersonaNacionalidadBean extends BaseBean{
	
	private PersonaBean personaBean;
	private MaestraBean nacionalidad;
	
	public PersonaNacionalidadBean(){
		super();
	}

	public PersonaBean getPersonaBean() {
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

	public MaestraBean getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(MaestraBean nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "PersonaNacionalidadBean [personaBean=" + personaBean
				+ ", nacionalidad=" + nacionalidad + "]";
	}
	
	
}
