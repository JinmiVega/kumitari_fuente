package pe.gob.procalidad.natigu.core.bean.bean.academico;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LeccionMaterialBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;

public class EvaluacionDetalleBean extends BaseBean{

	private EvaluacionBean evaluacionBean = new EvaluacionBean();
	private MaestraBean tipoEjercicio = new MaestraBean();
	private MaterialTipoEjercicioBean materialTipoEjercicioBean = new MaterialTipoEjercicioBean();
	private LeccionMaterialBean leccionMaterialBean = new LeccionMaterialBean();
	private String aprobado;
	private MaestraBean situacionEvaluacionDetalle = new MaestraBean();
	
	public EvaluacionDetalleBean() {
		super();
	}

	public EvaluacionBean getEvaluacionBean() {
		return evaluacionBean;
	}

	public void setEvaluacionBean(EvaluacionBean evaluacionBean) {
		this.evaluacionBean = evaluacionBean;
	}

	public MaestraBean getTipoEjercicio() {
		return tipoEjercicio;
	}

	public void setTipoEjercicio(MaestraBean tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}

	public MaterialTipoEjercicioBean getMaterialTipoEjercicioBean() {
		return materialTipoEjercicioBean;
	}

	public void setMaterialTipoEjercicioBean(
			MaterialTipoEjercicioBean materialTipoEjercicioBean) {
		this.materialTipoEjercicioBean = materialTipoEjercicioBean;
	}

	public LeccionMaterialBean getLeccionMaterialBean() {
		return leccionMaterialBean;
	}

	public void setLeccionMaterialBean(LeccionMaterialBean leccionMaterialBean) {
		this.leccionMaterialBean = leccionMaterialBean;
	}

	public String getAprobado() {
		return aprobado;
	}

	public void setAprobado(String aprobado) {
		this.aprobado = aprobado;
	}

	public MaestraBean getSituacionEvaluacionDetalle() {
		return situacionEvaluacionDetalle;
	}

	public void setSituacionEvaluacionDetalle(MaestraBean situacionEvaluacionDetalle) {
		this.situacionEvaluacionDetalle = situacionEvaluacionDetalle;
	}

	@Override
	public String toString() {
		return "EvaluacionDetalleBean [evaluacionBean=" + evaluacionBean + ", tipoEjercicio=" + tipoEjercicio
				+ ", materialTipoEjercicioBean=" + materialTipoEjercicioBean + ", leccionMaterialBean="
				+ leccionMaterialBean + ", aprobado=" + aprobado + ", situacionEvaluacionDetalle="
				+ situacionEvaluacionDetalle + "]";
	}
	
	
}
