package pe.gob.procalidad.natigu.core.bean.bean.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaNacionalidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.utilitarios.EncryptHability;

@SuppressWarnings("serial")
public class AlumnoBean extends BaseBean{
	
	private String usuario;
	private MaestraBean tm2Programa;//String
	private MaestraBean tm2Nivel;//Integer
	private MaestraBean tm2Grado;//Integer
	private MaestraBean tm1Situacion;//Integer tm1SituacionAlumno

	private PersonaBean personaBean;
	private InstitucionBean institucionBean;
	private UbigeoBean ubigeoBean;
    private InscripcionLenguaBean inscripcionLenguaBean;
	private List<PersonaNacionalidadBean> lstPersonaNacionalidadBean;
	private List<PersonaLenguaBean> lstPersonaLenguaBean;
	private List<AlumnoInstitucionBean> lstAlumnoInstitucionBean;
		
	public AlumnoBean() {
		super();
	}
	
	public String transformDNI(String dni) {
		//encrypt front - back
		String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    EncryptHability aesUtil = new EncryptHability(128, 1000);
        String plaintextNDoc = aesUtil.decrypt(salt, iv, "numeroDocumento", dni);
        plaintextNDoc = plaintextNDoc.substring(0,4);
		return plaintextNDoc+"****";
	}
	
	public PersonaBean getPersonaBean() {
		if(personaBean == null){
			personaBean = new PersonaBean();
		}
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

	public MaestraBean getTm2Programa() {
		
		if(tm2Programa == null){
			tm2Programa = new MaestraBean();
		}
		return tm2Programa;
	}

	public void setTm2Programa(MaestraBean tm2Programa) {
		this.tm2Programa = tm2Programa;
	}

	public MaestraBean getTm2Nivel() {
		
		if(tm2Nivel == null){
			tm2Nivel = new MaestraBean();
		}
		return tm2Nivel;
	}

	public void setTm2Nivel(MaestraBean tm2Nivel) {
		this.tm2Nivel = tm2Nivel;
	}

	public MaestraBean getTm2Grado() {
		
		if(tm2Grado == null){
			tm2Grado = new MaestraBean();
		}
		return tm2Grado;
	}

	public void setTm2Grado(MaestraBean tm2Grado) {
		this.tm2Grado = tm2Grado;
	}

	public MaestraBean getTm1Situacion() {
		
		if(tm1Situacion == null){
			tm1Situacion = new MaestraBean();
		}
		return tm1Situacion;
	}

	public void setTm1Situacion(MaestraBean tm1Situacion) {
		this.tm1Situacion = tm1Situacion;
	}

	public InstitucionBean getInstitucionBean() {
		
		if(institucionBean == null){
			institucionBean = new InstitucionBean();
		}
		return institucionBean;
	}

	public void setInstitucionBean(InstitucionBean institucionBean) {
		this.institucionBean = institucionBean;
	}

	public UbigeoBean getUbigeoBean() {
		return ubigeoBean;
	}

	public void setUbigeoBean(UbigeoBean ubigeoBean) {
		this.ubigeoBean = ubigeoBean;
	}

	public List<PersonaNacionalidadBean> getLstPersonaNacionalidadBean() {
		return lstPersonaNacionalidadBean;
	}

	public void setLstPersonaNacionalidadBean(
			List<PersonaNacionalidadBean> lstPersonaNacionalidadBean) {
		this.lstPersonaNacionalidadBean = lstPersonaNacionalidadBean;
	}

	public List<PersonaLenguaBean> getLstPersonaLenguaBean() {
		return lstPersonaLenguaBean;
	}

	public void setLstPersonaLenguaBean(List<PersonaLenguaBean> lstPersonaLenguaBean) {
		this.lstPersonaLenguaBean = lstPersonaLenguaBean;
	}
	
	

	public InscripcionLenguaBean getInscripcionLenguaBean() {
		return inscripcionLenguaBean;
	}

	public void setInscripcionLenguaBean(InscripcionLenguaBean inscripcionLenguaBean) {
		this.inscripcionLenguaBean = inscripcionLenguaBean;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "AlumnoBean [tm2Programa=" + tm2Programa + ", tm2Nivel="
				+ tm2Nivel + ", tm2Grado=" + tm2Grado + ", tm1Situacion="
				+ tm1Situacion + ", personaBean=" + personaBean
				+ ", institucionBean=" + institucionBean + "]";
	}

	public List<AlumnoInstitucionBean> getLstAlumnoInstitucionBean() {
		return lstAlumnoInstitucionBean;
	}

	public void setLstAlumnoInstitucionBean(List<AlumnoInstitucionBean> lstAlumnoInstitucionBean) {
		this.lstAlumnoInstitucionBean = lstAlumnoInstitucionBean;
	}


	
	
}
