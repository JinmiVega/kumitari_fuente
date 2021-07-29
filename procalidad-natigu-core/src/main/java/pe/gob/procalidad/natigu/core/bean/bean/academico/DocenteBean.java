package pe.gob.procalidad.natigu.core.bean.bean.academico;

import java.util.List;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.utilitarios.EncryptHability;

@SuppressWarnings("serial")
public class DocenteBean extends BaseBean{

	//private Integer codDocente;
	private PersonaBean personaBean = new PersonaBean();//Integer codPersona
	private InstitucionBean institucionBean = new InstitucionBean();//Integer codInstitucion;
	private LenguaBean lenguaBean = new LenguaBean();//Integer codlenguaje;
	private MaestraBean gradoDocente = new MaestraBean();//int
	private MaestraBean carreraDocente= new MaestraBean();//int 
	private MaestraBean situacion= new MaestraBean();//int tm1SituacionDocente
	private EspecialidadBean especialidadBean = new EspecialidadBean();
	private UbigeoBean  ubigeoBean = new UbigeoBean();
	private InscripcionLenguaBean	inscripcionLenguaBean;
	
	private List<DocenteInstitucionBean> lstDocenteInstitucionBean;
	/* auditoria
	private String 	fechaCreacion;
	private String 	usuarioCreacion;
	private String 	ipCreacion;
	private String 	fechaModificacion;
	private String 	usuarioModificacion;
	private String 	ipModificacion; 
	*/

	public DocenteBean() {
		super();
	}
	
	public String transformDNI(String dni) {
		//encrypt front - back
		String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    EncryptHability aesUtil = new EncryptHability(128, 1000);
        String plaintextNDoc = aesUtil.decrypt(salt, iv, "numeroDocumentoPersona", dni);
        plaintextNDoc = plaintextNDoc.substring(0,4);
		return plaintextNDoc+"****";
	}

	public PersonaBean getPersonaBean() {
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

	public InstitucionBean getInstitucionBean() {
		return institucionBean;
	}

	public void setInstitucionBean(InstitucionBean institucionBean) {
		this.institucionBean = institucionBean;
	}

	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	

	public MaestraBean getGradoDocente() {
		return gradoDocente;
	}

	public void setGradoDocente(MaestraBean gradoDocente) {
		this.gradoDocente = gradoDocente;
	}

	public MaestraBean getCarreraDocente() {
		return carreraDocente;
	}

	public void setCarreraDocente(MaestraBean carreraDocente) {
		this.carreraDocente = carreraDocente;
	}

	public MaestraBean getSituacion() {
		return situacion;
	}

	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}

	public EspecialidadBean getEspecialidadBean() {
		return especialidadBean;
	}

	public void setEspecialidadBean(EspecialidadBean especialidadBean) {
		this.especialidadBean = especialidadBean;
	}

	
	
	public UbigeoBean getUbigeoBean() {
		return ubigeoBean;
	}

	public void setUbigeoBean(UbigeoBean ubigeoBean) {
		this.ubigeoBean = ubigeoBean;
	}

	@Override
	public String toString() {
		return "DocenteBean [personaBean=" + personaBean + ", institucionBean="
				+ institucionBean + ", lenguaBean=" + lenguaBean
				+ ", gradoDocente=" + gradoDocente + ", carreraDocente="
				+ carreraDocente + ", situacion=" + situacion + "]";
	}

	public InscripcionLenguaBean getInscripcionLenguaBean() {
	
		return inscripcionLenguaBean;
	}

	public void setInscripcionLenguaBean(InscripcionLenguaBean inscripcionLenguaBean) {
		this.inscripcionLenguaBean = inscripcionLenguaBean;
	}

	public List<DocenteInstitucionBean> getLstDocenteInstitucionBean() {
		return lstDocenteInstitucionBean;
	}

	public void setLstDocenteInstitucionBean(List<DocenteInstitucionBean> lstDocenteInstitucionBean) {
		this.lstDocenteInstitucionBean = lstDocenteInstitucionBean;
	}
 
}
