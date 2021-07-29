package pe.gob.procalidad.natigu.core.bean.bean.generico;

import java.util.Date;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;

public class InstitucionSedeBean extends BaseBean {

	//private int codigoSede;
	//private int codigoInstitucion;
	private InstitucionBean institucionBean = new InstitucionBean();
	private String nombreSede;
	private String codigoRegion;
	private String codigoProvincia;
	private String codigoDistrito;
	private String direccionInstitucion;
	//private String tm1sitsed;
	private MaestraBean situacionSede =  new MaestraBean();
	private String contacto;
	private String telefono;
	private String correo;
	private UbigeoBean ubigeoRegionBean = new UbigeoBean();
	private UbigeoBean ubigeoProvinBean = new UbigeoBean();
	private UbigeoBean ubigeoDistriBean = new UbigeoBean();
	
	
	public InstitucionSedeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public int getCodigoSede() {
//		return codigoSede;
//	}
//	public void setCodigoSede(int codigoSede) {
//		this.codigoSede = codigoSede;
//	}
//	public int getCodigoInstitucion() {
//		return codigoInstitucion;
//	}
//	public void setCodigoInstitucion(int codigoInstitucion) {
//		this.codigoInstitucion = codigoInstitucion;
//	}
	public String getNombreSede() {
		return nombreSede;
	}
	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
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
	public String getDireccionInstitucion() {
		return direccionInstitucion;
	}
	public void setDireccionInstitucion(String direccionInstitucion) {
		this.direccionInstitucion = direccionInstitucion;
	}
//	public String getTm1sitsed() {
//		return tm1sitsed;
//	}
//	public void setTm1sitsed(String tm1sitsed) {
//		this.tm1sitsed = tm1sitsed;
//	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
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
//	public String getFlagEstado() {
//		return flagEstado;
//	}
//	public void setFlagEstado(String flagEstado) {
//		this.flagEstado = flagEstado;
//	}

	public UbigeoBean getUbigeoRegionBean() {
		return ubigeoRegionBean;
	}
	public void setUbigeoRegionBean(UbigeoBean ubigeoRegionBean) {
		this.ubigeoRegionBean = ubigeoRegionBean;
	}
	public UbigeoBean getUbigeoProvinBean() {
		return ubigeoProvinBean;
	}
	public void setUbigeoProvinBean(UbigeoBean ubigeoProvinBean) {
		this.ubigeoProvinBean = ubigeoProvinBean;
	}
	public UbigeoBean getUbigeoDistriBean() {
		return ubigeoDistriBean;
	}
	public void setUbigeoDistriBean(UbigeoBean ubigeoDistriBean) {
		this.ubigeoDistriBean = ubigeoDistriBean;
	}

	public InstitucionBean getInstitucionBean() {
		return institucionBean;
	}
	public void setInstitucionBean(InstitucionBean institucionBean) {
		this.institucionBean = institucionBean;
	}
	public MaestraBean getSituacionSede() {
		return situacionSede;
	}
	public void setSituacionSede(MaestraBean situacionSede) {
		this.situacionSede = situacionSede;
	}
	@Override
	public String toString() {
		return "InstitucionSedeBean [institucionBean=" + institucionBean
				+ ", nombreSede=" + nombreSede + ", codigoRegion="
				+ codigoRegion + ", codigoProvincia=" + codigoProvincia
				+ ", codigoDistrito=" + codigoDistrito
				+ ", direccionInstitucion=" + direccionInstitucion
				+ ", situacionSede=" + situacionSede + ", contacto=" + contacto
				+ ", telefono=" + telefono + ", correo=" + correo
				+ ", flagEstado="  + ", ubigeoRegionBean="
				+ ubigeoRegionBean + ", ubigeoProvinBean=" + ubigeoProvinBean
				+ ", ubigeoDistriBean=" + ubigeoDistriBean + "]";
	}

	
}