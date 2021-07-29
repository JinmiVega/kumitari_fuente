package pe.gob.procalidad.natigu.core.bean.bean.generico;

import org.codehaus.jackson.map.deser.ValueInstantiators.Base;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.utilitarios.EncryptHability;

public class PersonalBean extends BaseBean {

	private PersonaBean personaBean = new PersonaBean();
	
	private MaestraBean  situacionPersonal = new MaestraBean();
	
	private MaestraBean cargoPersonal = new MaestraBean();
	
	private MaestraBean gradoPersonal = new MaestraBean();
	
	private String flgEstado;

	public PersonalBean(){
		super();
	}
	
	public String transformDNI(String dni) {
		//encrypt front - back
		String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    EncryptHability aesUtil = new EncryptHability(128, 1000);
        String plaintextNDoc = aesUtil.decrypt(salt, iv, "numeroDocumentoPersonal", dni);
        plaintextNDoc = plaintextNDoc.substring(0,4);
		return plaintextNDoc+"****";
	}
	
	public MaestraBean getSituacionPersonal() {
		return situacionPersonal;
	}

	public void setSituacionPersonal(MaestraBean situacionPersonal) {
		this.situacionPersonal = situacionPersonal;
	}

	public MaestraBean getCargoPersonal() {
		return cargoPersonal;
	}

	public void setCargoPersonal(MaestraBean cargoPersonal) {
		this.cargoPersonal = cargoPersonal;
	}

	public MaestraBean getGradoPersonal() {
		return gradoPersonal;
	}

	public void setGradoPersonal(MaestraBean gradoPersonal) {
		this.gradoPersonal = gradoPersonal;
	}

	public String getFlgEstado() {
		return flgEstado;
	}

	public void setFlgEstado(String flgEstado) {
		this.flgEstado = flgEstado;
	}

	

	public PersonaBean getPersonaBean() {
		return personaBean;
	}


	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}


	@Override
	public String toString() {
		return "PersonalBean [situacionPersonal=" + situacionPersonal
				+ ", cargoPersonal=" + cargoPersonal + ", gradoPersonal="
				+ gradoPersonal + ", flgEstado=" + flgEstado + "]";
	}
	
	

	
}
