package pe.gob.procalidad.natigu.core.bean.bean.generico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.utilitarios.EncryptHability;

public class InstitucionOperadorBean extends BaseBean{

	private int  codigoPersona;
	private int  codigoInstitucion;
	private int  situacionOperador;
	
	private PersonaBean personaBean =  new PersonaBean();
	
	private String nombreSituacion;
	private String strFecha;
	
	private MaestraBean cargo  = new MaestraBean();
	
	public InstitucionOperadorBean() {
		super();
	}

	public String transformDNI(String dni) {
		//encrypt front - back
		String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    EncryptHability aesUtil = new EncryptHability(128, 1000);
        String plaintextNDoc = aesUtil.decrypt(salt, iv, "numeroDocumentoInstOpe", dni);
        plaintextNDoc = plaintextNDoc.substring(0,4);
		return plaintextNDoc+"****";
	}

	
	public int getCodigoPersona() {
		return codigoPersona;
	}

	public void setCodigoPersona(int codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	public int getCodigoInstitucion() {
		return codigoInstitucion;
	}

	public void setCodigoInstitucion(int codigoInstitucion) {
		this.codigoInstitucion = codigoInstitucion;
	}

	public int getSituacionOperador() {
		return situacionOperador;
	}

	public void setSituacionOperador(int situacionOperador) {
		this.situacionOperador = situacionOperador;
	}

	public PersonaBean getPersonaBean() {
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

	public String getNombreSituacion() {
		return nombreSituacion;
	}

	public void setNombreSituacion(String nombreSituacion) {
		this.nombreSituacion = nombreSituacion;
	}

	public String getStrFecha() {
		return strFecha;
	}

	public void setStrFecha(String strFecha) {
		this.strFecha = strFecha;
	}

	public MaestraBean getCargo() {
		return cargo;
	}

	public void setCargo(MaestraBean cargo) {
		this.cargo = cargo;
	}
	
}
