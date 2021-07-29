package pe.gob.procalidad.natigu.core.bean.bean.academico;

import java.util.Date;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
 

public class InscripcionBean extends BaseBean {
	

	private InstitucionBean institucion;

	private LenguaBean 		lengua;

	private MaestraBean 	situacion;

	private String 			numCupos;
	
	private String 			numeroDocumento;
	
	private String 			nombreDocumento;
	
	private String 			rutaDocumento;
	
	private DocenteBean 	docenteBean;
	
	private MaestraBean 	periodo;
	
	private MaestraBean		ciclo;
	
	private Date 			fechaRegistro;
	
	private String 			fechavdRegistro;
	
	private String 			fechavdSincronizacion;
	
	private Integer 	 	retorno;
	
	private long			tipoAcceso;
	
	private String			nomtipoAcceso;
	
	public InscripcionBean() {
		super();
		institucion= new InstitucionBean();
		lengua= new LenguaBean();
		situacion= new MaestraBean();
		docenteBean= new DocenteBean();
	}


	public InstitucionBean getInstitucion() {
		if (institucion==null) {
			institucion= new InstitucionBean();
		}
		return institucion;
	}


	public void setInstitucion(InstitucionBean institucion) {
		this.institucion = institucion;
	}


	public LenguaBean getLengua() {
		if (lengua==null) {
			lengua= new LenguaBean();
		}
		return lengua;
	}


	public void setLengua(LenguaBean lengua) {
		this.lengua = lengua;
	}


	public MaestraBean getSituacion() {
		if (situacion==null) {
			situacion= new MaestraBean();
		}
		return situacion;
	}


	public void setSituacion(MaestraBean situacion) {
		this.situacion = situacion;
	}


	public String getNumCupos() {
		return numCupos;
	}


	public void setNumCupos(String numCupos) {
		this.numCupos = numCupos;
	}


	public DocenteBean getDocenteBean() {
		if (docenteBean==null) {
			docenteBean= new DocenteBean();
		}
		return docenteBean;
	}


	public void setDocenteBean(DocenteBean docenteBean) {
		this.docenteBean = docenteBean;
	}


	@Override
	public String toString() {
		return "InscripcionBean [institucion=" + institucion + ", lengua=" + lengua + ", situacion=" + situacion
				+ ", numCupos=" + numCupos + "]";
	}


	public String getNumeroDocumento() {
		return numeroDocumento;
	}


	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	public MaestraBean getPeriodo() {
		if (periodo==null) {
			periodo= new MaestraBean();
		}
		return periodo;
	}


	public void setPeriodo(MaestraBean periodo) {
		this.periodo = periodo;
	}


	public String getNombreDocumento() {
		return nombreDocumento;
	}


	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}


	public String getRutaDocumento() {
		return rutaDocumento;
	}


	public void setRutaDocumento(String rutaDocumento) {
		this.rutaDocumento = rutaDocumento;
	}


	public MaestraBean getCiclo() {
		if (ciclo==null) {
			ciclo= new MaestraBean();
		}
		return ciclo;
	}


	public void setCiclo(MaestraBean ciclo) {
		this.ciclo = ciclo;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public Integer getRetorno() {
		return retorno;
	}


	public void setRetorno(Integer retorno) {
		this.retorno = retorno;
	}


	public long getTipoAcceso() {
		return tipoAcceso;
	}


	public void setTipoAcceso(long tipoAcceso) {
		this.tipoAcceso = tipoAcceso;
	}


	public String getNomtipoAcceso() {
		return nomtipoAcceso;
	}


	public void setNomtipoAcceso(String nomtipoAcceso) {
		this.nomtipoAcceso = nomtipoAcceso;
	}


	public String getFechavdRegistro() {
		return fechavdRegistro;
	}


	public void setFechavdRegistro(String fechavdRegistro) {
		this.fechavdRegistro = fechavdRegistro;
	}


	public String getFechavdSincronizacion() {
		return fechavdSincronizacion;
	}


	public void setFechavdSincronizacion(String fechavdSincronizacion) {
		this.fechavdSincronizacion = fechavdSincronizacion;
	}

	
	

}
