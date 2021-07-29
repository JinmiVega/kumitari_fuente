package pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso;

public class AccesoMenuVo {

	private boolean   aloc_institucion;
	
	private boolean   aloc_lengua;
	
	private boolean   aloc_material;
	private PermisoVo aloc_material_carga_directa;
	private PermisoVo aloc_material_carga_masiva;
	
	private boolean   aloc_personal;
	
	private boolean   aloc_inscripcion;
	
	private boolean   aloc_matricula;
	private PermisoVo aloc_matricula_registro;
	private PermisoVo aloc_matricula_asignar_usuario;
	
	private boolean   aloc_docente;
	
	private boolean   aloc_alumno;
	private PermisoVo aloc_alumno_registro;
	private PermisoVo aloc_alumno_seguimiento;
	
	private boolean   aloc_seguridad;
	private PermisoVo aloc_seguridad_usuario;
	private PermisoVo aloc_seguridad_perfil;
	private PermisoVo aloc_seguridad_acceso;
	
	private boolean   aloc_configuracion;
	private PermisoVo aloc_configuracion_tabla_maestra;
	private PermisoVo aloc_configuracion_mascota;
	private PermisoVo aloc_configuracion_traduccion_general;
	private PermisoVo aloc_configuracion_premio;
	private PermisoVo aloc_configuracion_ficha_puntaje;
	
	public boolean isAloc_institucion() {
		return aloc_institucion;
	}
	public void setAloc_institucion(boolean aloc_institucion) {
		this.aloc_institucion = aloc_institucion;
	}
	public boolean isAloc_lengua() {
		return aloc_lengua;
	}
	public void setAloc_lengua(boolean aloc_lengua) {
		this.aloc_lengua = aloc_lengua;
	}
	public boolean isAloc_material() {
		return aloc_material;
	}
	public void setAloc_material(boolean aloc_material) {
		this.aloc_material = aloc_material;
	}
	public PermisoVo getAloc_material_carga_directa() {
		return aloc_material_carga_directa;
	}
	public void setAloc_material_carga_directa(PermisoVo aloc_material_carga_directa) {
		this.aloc_material_carga_directa = aloc_material_carga_directa;
	}
	public PermisoVo getAloc_material_carga_masiva() {
		return aloc_material_carga_masiva;
	}
	public void setAloc_material_carga_masiva(PermisoVo aloc_material_carga_masiva) {
		this.aloc_material_carga_masiva = aloc_material_carga_masiva;
	}
	public boolean isAloc_personal() {
		return aloc_personal;
	}
	public void setAloc_personal(boolean aloc_personal) {
		this.aloc_personal = aloc_personal;
	}
	public boolean isAloc_inscripcion() {
		return aloc_inscripcion;
	}
	public void setAloc_inscripcion(boolean aloc_inscripcion) {
		this.aloc_inscripcion = aloc_inscripcion;
	}
	public boolean isAloc_matricula() {
		return aloc_matricula;
	}
	public void setAloc_matricula(boolean aloc_matricula) {
		this.aloc_matricula = aloc_matricula;
	}
	public PermisoVo getAloc_matricula_registro() {
		return aloc_matricula_registro;
	}
	public void setAloc_matricula_registro(PermisoVo aloc_matricula_registro) {
		this.aloc_matricula_registro = aloc_matricula_registro;
	}
	public PermisoVo getAloc_matricula_asignar_usuario() {
		return aloc_matricula_asignar_usuario;
	}
	public void setAloc_matricula_asignar_usuario(PermisoVo aloc_matricula_asignar_usuario) {
		this.aloc_matricula_asignar_usuario = aloc_matricula_asignar_usuario;
	}
	public boolean isAloc_docente() {
		return aloc_docente;
	}
	public void setAloc_docente(boolean aloc_docente) {
		this.aloc_docente = aloc_docente;
	}
	public boolean isAloc_alumno() {
		return aloc_alumno;
	}
	public void setAloc_alumno(boolean aloc_alumno) {
		this.aloc_alumno = aloc_alumno;
	}
	public PermisoVo getAloc_alumno_registro() {
		return aloc_alumno_registro;
	}
	public void setAloc_alumno_registro(PermisoVo aloc_alumno_registro) {
		this.aloc_alumno_registro = aloc_alumno_registro;
	}
	public PermisoVo getAloc_alumno_seguimiento() {
		return aloc_alumno_seguimiento;
	}
	public void setAloc_alumno_seguimiento(PermisoVo aloc_alumno_seguimiento) {
		this.aloc_alumno_seguimiento = aloc_alumno_seguimiento;
	}
	public boolean isAloc_seguridad() {
		return aloc_seguridad;
	}
	public void setAloc_seguridad(boolean aloc_seguridad) {
		this.aloc_seguridad = aloc_seguridad;
	}
	public PermisoVo getAloc_seguridad_usuario() {
		return aloc_seguridad_usuario;
	}
	public void setAloc_seguridad_usuario(PermisoVo aloc_seguridad_usuario) {
		this.aloc_seguridad_usuario = aloc_seguridad_usuario;
	}
	public PermisoVo getAloc_seguridad_perfil() {
		return aloc_seguridad_perfil;
	}
	public void setAloc_seguridad_perfil(PermisoVo aloc_seguridad_perfil) {
		this.aloc_seguridad_perfil = aloc_seguridad_perfil;
	}
	public PermisoVo getAloc_seguridad_acceso() {
		return aloc_seguridad_acceso;
	}
	public void setAloc_seguridad_acceso(PermisoVo aloc_seguridad_acceso) {
		this.aloc_seguridad_acceso = aloc_seguridad_acceso;
	}
	public boolean isAloc_configuracion() {
		return aloc_configuracion;
	}
	public void setAloc_configuracion(boolean aloc_configuracion) {
		this.aloc_configuracion = aloc_configuracion;
	}
	public PermisoVo getAloc_configuracion_tabla_maestra() {
		return aloc_configuracion_tabla_maestra;
	}
	public void setAloc_configuracion_tabla_maestra(PermisoVo aloc_configuracion_tabla_maestra) {
		this.aloc_configuracion_tabla_maestra = aloc_configuracion_tabla_maestra;
	}
	public PermisoVo getAloc_configuracion_mascota() {
		return aloc_configuracion_mascota;
	}
	public void setAloc_configuracion_mascota(PermisoVo aloc_configuracion_mascota) {
		this.aloc_configuracion_mascota = aloc_configuracion_mascota;
	}
	public PermisoVo getAloc_configuracion_traduccion_general() {
		return aloc_configuracion_traduccion_general;
	}
	public void setAloc_configuracion_traduccion_general(PermisoVo aloc_configuracion_traduccion_general) {
		this.aloc_configuracion_traduccion_general = aloc_configuracion_traduccion_general;
	}
	public PermisoVo getAloc_configuracion_premio() {
		return aloc_configuracion_premio;
	}
	public void setAloc_configuracion_premio(PermisoVo aloc_configuracion_premio) {
		this.aloc_configuracion_premio = aloc_configuracion_premio;
	}
	public PermisoVo getAloc_configuracion_ficha_puntaje() {
		return aloc_configuracion_ficha_puntaje;
	}
	public void setAloc_configuracion_ficha_puntaje(PermisoVo aloc_configuracion_ficha_puntaje) {
		this.aloc_configuracion_ficha_puntaje = aloc_configuracion_ficha_puntaje;
	}
	
}
