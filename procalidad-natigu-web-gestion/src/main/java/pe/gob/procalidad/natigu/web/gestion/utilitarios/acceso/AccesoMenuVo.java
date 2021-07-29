package pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso;

public class AccesoMenuVo {

	/** GENERAL **/
	
	// INDICADOR
	private boolean   aloc_indicador;
	// INSTITUCION
	private boolean   aloc_institucion;
	// LENGUA
	private boolean   aloc_lengua;
	// MATERIAL
	private boolean   aloc_material;
	private PermisoVo aloc_material_carga_directa;
	private PermisoVo aloc_material_carga_masiva;
	// GESTOR
	private boolean   aloc_personal;
	
	/** ACADEMICO **/
	
	// INSCRIPCION
	private boolean   aloc_inscripcion;
	// MATRICULA
	private boolean   aloc_matricula;
	private PermisoVo aloc_matricula_registro;
	private PermisoVo aloc_matricula_asignar_usuario;
	// DOCENTE
	private boolean   aloc_docente;
	// ESTUDIANTE
	private boolean   aloc_alumno;
	private PermisoVo aloc_alumno_registro;
	private PermisoVo aloc_alumno_seguimiento;
	
	/** OFFLINE **/
	
	// MODO OFFLINE
	private boolean   aloc_modo_offline;
	private PermisoVo aloc_modo_offline_genera_archivo;
	private PermisoVo aloc_modo_offline_sincronizar;
	
	/** OTROS **/
	
	// SEGURIDAD
	private boolean   aloc_seguridad;
	private PermisoVo aloc_seguridad_usuario;
	private PermisoVo aloc_seguridad_perfil;
	private PermisoVo aloc_seguridad_acceso;
	private PermisoVo aloc_seguridad_auditoria;
	// CONFIGURACION
	private boolean   aloc_configuracion;
	private PermisoVo aloc_configuracion_tabla_maestra;
	private PermisoVo aloc_configuracion_mascota;
	private PermisoVo aloc_configuracion_traduccion_general;
	private PermisoVo aloc_configuracion_fondo;
	private PermisoVo aloc_configuracion_modal;
	private PermisoVo aloc_configuracion_combo;
	private PermisoVo aloc_configuracion_premio;
	private PermisoVo aloc_configuracion_ficha_puntaje;
	private PermisoVo aloc_configuracion_slider;
	private PermisoVo aloc_configuracion_mensaje;
	private PermisoVo aloc_configuracion_glosario;
	private PermisoVo aloc_configuracion_traduccion;
	
	public boolean isAloc_indicador() {
		return aloc_indicador;
	}
	public void setAloc_indicador(boolean aloc_indicador) {
		this.aloc_indicador = aloc_indicador;
	}
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
	public boolean isAloc_modo_offline() {
		return aloc_modo_offline;
	}
	public void setAloc_modo_offline(boolean aloc_modo_offline) {
		this.aloc_modo_offline = aloc_modo_offline;
	}
	public PermisoVo getAloc_modo_offline_genera_archivo() {
		return aloc_modo_offline_genera_archivo;
	}
	public void setAloc_modo_offline_genera_archivo(PermisoVo aloc_modo_offline_genera_archivo) {
		this.aloc_modo_offline_genera_archivo = aloc_modo_offline_genera_archivo;
	}
	public PermisoVo getAloc_modo_offline_sincronizar() {
		return aloc_modo_offline_sincronizar;
	}
	public void setAloc_modo_offline_sincronizar(PermisoVo aloc_modo_offline_sincronizar) {
		this.aloc_modo_offline_sincronizar = aloc_modo_offline_sincronizar;
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
	public PermisoVo getAloc_seguridad_auditoria() {
		return aloc_seguridad_auditoria;
	}
	public void setAloc_seguridad_auditoria(PermisoVo aloc_seguridad_auditoria) {
		this.aloc_seguridad_auditoria = aloc_seguridad_auditoria;
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
	public PermisoVo getAloc_configuracion_fondo() {
		return aloc_configuracion_fondo;
	}
	public void setAloc_configuracion_fondo(PermisoVo aloc_configuracion_fondo) {
		this.aloc_configuracion_fondo = aloc_configuracion_fondo;
	}
	public PermisoVo getAloc_configuracion_modal() {
		return aloc_configuracion_modal;
	}
	public void setAloc_configuracion_modal(PermisoVo aloc_configuracion_modal) {
		this.aloc_configuracion_modal = aloc_configuracion_modal;
	}
	public PermisoVo getAloc_configuracion_combo() {
		return aloc_configuracion_combo;
	}
	public void setAloc_configuracion_combo(PermisoVo aloc_configuracion_combo) {
		this.aloc_configuracion_combo = aloc_configuracion_combo;
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
	public PermisoVo getAloc_configuracion_slider() {
		return aloc_configuracion_slider;
	}
	public void setAloc_configuracion_slider(PermisoVo aloc_configuracion_slider) {
		this.aloc_configuracion_slider = aloc_configuracion_slider;
	}
	public PermisoVo getAloc_configuracion_mensaje() {
		return aloc_configuracion_mensaje;
	}
	public void setAloc_configuracion_mensaje(PermisoVo aloc_configuracion_mensaje) {
		this.aloc_configuracion_mensaje = aloc_configuracion_mensaje;
	}
	public PermisoVo getAloc_configuracion_glosario() {
		return aloc_configuracion_glosario;
	}
	public void setAloc_configuracion_glosario(PermisoVo aloc_configuracion_glosario) {
		this.aloc_configuracion_glosario = aloc_configuracion_glosario;
	}
	public PermisoVo getAloc_configuracion_traduccion() {
		return aloc_configuracion_traduccion;
	}
	public void setAloc_configuracion_traduccion(
			PermisoVo aloc_configuracion_traduccion) {
		this.aloc_configuracion_traduccion = aloc_configuracion_traduccion;
	}
	
}
