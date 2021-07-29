package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class PersonaLenguaBean extends BaseBean{
	
	private PersonaBean personaBean;
	private LenguaBean lenguaBean;
	private MaestraBean tipoLengua; 
	public PersonaLenguaBean(){
		super();
	}
	
	public PersonaBean getPersonaBean() {
		return personaBean;
	}
	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}
	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}
	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	public MaestraBean getTipoLengua() {
		return tipoLengua;
	}

	public void setTipoLengua(MaestraBean tipoLengua) {
		this.tipoLengua = tipoLengua;
	}

	@Override
	public String toString() {
		return "PersonaLenguaBean [personaBean=" + personaBean
				+ ", lenguaBean=" + lenguaBean + ", tipoLengua=" + tipoLengua
				+ "]";
	}
	

	
	
	
}
