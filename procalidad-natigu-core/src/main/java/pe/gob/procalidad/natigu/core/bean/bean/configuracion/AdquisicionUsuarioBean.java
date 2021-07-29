package pe.gob.procalidad.natigu.core.bean.bean.configuracion;


import javax.persistence.*;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;

import java.util.Date;


public class AdquisicionUsuarioBean extends BaseBean {
	private static final long serialVersionUID = 1L;

	
	private Long codigoAdquisicionUsuario;

	
	private Date fechaModificacion;

	private Date fechaRegistro;

	private FondoBean fondo;

	private MascotaBean mascota;
	private CombosCabBean combo = new CombosCabBean();

	private Long codigoRegion;


	private MaestraBean siatuacion;

	private MaestraBean tipoAdquisicion;

	private String estado;

	private UsuarioBean usuario;
	
	private UsuarioMatriculaBean usuarioMatricula = new UsuarioMatriculaBean();

	public AdquisicionUsuarioBean() {
	}


	public Long getCodigoAdquisicionUsuario() {
		return codigoAdquisicionUsuario;
	}


	public void setCodigoAdquisicionUsuario(Long codigoAdquisicionUsuario) {
		this.codigoAdquisicionUsuario = codigoAdquisicionUsuario;
	}


	public Date getFechaModificacion() {
		return fechaModificacion;
	}


	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public FondoBean getFondo() {
		return fondo;
	}


	public void setFondo(FondoBean fondo) {
		this.fondo = fondo;
	}


	public MascotaBean getMascota() {
		return mascota;
	}


	public void setMascota(MascotaBean mascota) {
		this.mascota = mascota;
	}


	public CombosCabBean getCombo() {
		return combo;
	}


	public void setCombo(CombosCabBean combo) {
		this.combo = combo;
	}


	public Long getCodigoRegion() {
		return codigoRegion;
	}


	public void setCodigoRegion(Long codigoRegion) {
		this.codigoRegion = codigoRegion;
	}


	

	public MaestraBean getSiatuacion() {
		return siatuacion;
	}


	public void setSiatuacion(MaestraBean siatuacion) {
		this.siatuacion = siatuacion;
	}


	public MaestraBean getTipoAdquisicion() {
		return tipoAdquisicion;
	}


	public void setTipoAdquisicion(MaestraBean tipoAdquisicion) {
		this.tipoAdquisicion = tipoAdquisicion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public UsuarioBean getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}


	@Override
	public String toString() {
		return "AdquisicionUsuarioBean [codigoAdquisicionUsuario=" + codigoAdquisicionUsuario + ", fechaModificacion="
				+ fechaModificacion + ", fechaRegistro=" + fechaRegistro + ", fondo=" + fondo + ", mascota=" + mascota
				+ ", codigoRegion=" + codigoRegion + ", siatuacion=" + siatuacion + ", tipoAdquisicion="
				+ tipoAdquisicion + ", estado=" + estado + ", usuario=" + usuario + "]";
	}


	public UsuarioMatriculaBean getUsuarioMatricula() {
		return usuarioMatricula;
	}


	public void setUsuarioMatricula(UsuarioMatriculaBean usuarioMatricula) {
		this.usuarioMatricula = usuarioMatricula;
	}

	

}