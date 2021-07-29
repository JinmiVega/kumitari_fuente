package pe.gob.procalidad.natigu.core.bean.bean.generico;

import java.util.Date;

import org.codehaus.jackson.map.deser.ValueInstantiators.Base;
import org.springframework.web.multipart.MultipartFile;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.utilitarios.EncryptHability;

public class PersonaBean extends BaseBean{

	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombrePersona;
	private MaestraBean tipoDocumento = new MaestraBean();
	private String numeroDocumento;
	private MaestraBean tipoPersona = new MaestraBean();
	private String codigoUbigeo;
	private UbigeoBean ubigeoBean= new UbigeoBean();
	private String direccionPersona;
	private MaestraBean situacionPersona = new  MaestraBean();
	private Date fechaNac;
	
	private String strFechaNac;
	private MaestraBean nacionalidad = new MaestraBean();
	private MaestraBean estadoCivil = new MaestraBean();
	private MaestraBean sexo = new MaestraBean();
	private LenguaBean lenguaBean = new LenguaBean();
	private String telefono;
	private String correo;
	private String flgEstado;
	private String nombreCompleto;
	
	
	/**/
	private String nombrefotouser;
	private MultipartFile 	filefotouser;
	
	public PersonaBean(){
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

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public MaestraBean getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(MaestraBean tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public MaestraBean getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(MaestraBean tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getDireccionPersona() {
		return direccionPersona;
	}
	public void setDireccionPersona(String direccionPersona) {
		this.direccionPersona = direccionPersona;
	}
	public MaestraBean getSituacionPersona() {
		return situacionPersona;
	}
	public void setSituacionPersona(MaestraBean situacionPersona) {
		this.situacionPersona = situacionPersona;
	}
	
	public MaestraBean getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(MaestraBean nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public MaestraBean getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(MaestraBean estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public MaestraBean getSexo() {
		return sexo;
	}
	public void setSexo(MaestraBean sexo) {
		this.sexo = sexo;
	}

	public String getStrFechaNac() {
		return strFechaNac;
	}

	public void setStrFechaNac(String strFechaNac) {
		this.strFechaNac = strFechaNac;
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
	public String getFlgEstado() {
		return flgEstado;
	}
	public void setFlgEstado(String flgEstado) {
		this.flgEstado = flgEstado;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void textStrFechaNac(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getCodigoUbigeo() {
		return codigoUbigeo;
	}

	public void setCodigoUbigeo(String codigoUbigeo) {
		this.codigoUbigeo = codigoUbigeo;
	}
	
	
	public UbigeoBean getUbigeoBean() {
		return ubigeoBean;
	}

	public void setUbigeoBean(UbigeoBean ubigeoBean) {
		this.ubigeoBean = ubigeoBean;
	}

	public String getNombreCompleto() {
		if(this.nombreCompleto == null || this.nombreCompleto==""){
			nombreCompleto = (this.apellidoPaterno!=null ? this.apellidoPaterno +" " : "") + 
							 (this.apellidoMaterno!=null ? this.apellidoMaterno +" " : "") + 
							 (this.nombrePersona!=null ? this.nombrePersona : "");
		}
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	



	@Override
	public String toString() {
		return "PersonaBean [apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno
				+ ", nombrePersona=" + nombrePersona + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento="
				+ numeroDocumento + ", tipoPersona=" + tipoPersona + ", codigoUbigeo=" + codigoUbigeo + ", ubigeoBean="
				+ ubigeoBean + ", direccionPersona=" + direccionPersona + ", situacionPersona=" + situacionPersona
				+ ", fechaNac=" + fechaNac + ", strFechaNac=" + strFechaNac + ", nacionalidad=" + nacionalidad
				+ ", estadoCivil=" + estadoCivil + ", sexo=" + sexo + ", lenguaBean=" + lenguaBean + ", telefono="
				+ telefono + ", correo=" + correo + ", flgEstado=" + flgEstado + ", nombreCompleto=" + nombreCompleto
				+ ", nombrefotouser=" + nombrefotouser + ", filefotouser=" + filefotouser + "]";
	}

	public String getNombrefotouser() {
		return nombrefotouser;
	}

	public void setNombrefotouser(String nombrefotouser) {
		this.nombrefotouser = nombrefotouser;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public MultipartFile getFilefotouser() {
		return filefotouser;
	}

	public void setFilefotouser(MultipartFile filefotouser) {
		this.filefotouser = filefotouser;
	}



	
	
	
}
