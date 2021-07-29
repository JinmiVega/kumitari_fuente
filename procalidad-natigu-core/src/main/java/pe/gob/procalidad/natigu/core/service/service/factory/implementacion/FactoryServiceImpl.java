package pe.gob.procalidad.natigu.core.service.service.factory.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.EvaluacionDetalleBean;
import pe.gob.procalidad.natigu.core.service.service.factory.interfaces.FactoryService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoBonoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoInstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoMedallaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoMonedaGService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.AlumnoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.DocenteInstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.DocenteService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.EspecialidadService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.EvaluacionDetalleService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.EvaluacionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionDocenteService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionLenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.InscripcionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.MatriculaAlumnoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.MatriculaDocenteService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.MatriculaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.SeguimientoAlumIntentoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.SeguimientoAlumnoEjerDetService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.SeguimientoAlumnoEjercicioService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.SeguimientoAlumnoLenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.UsuarioMatriculaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.AdquisicionUsuarioService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.BonoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.ComboCabService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.ExamenConfiguracionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.FondoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.GlosarioService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.IntentoConfiguracionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.MascotaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.MensajesService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.ModalService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.PremioConfiguracionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.PremioService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.SliderDetalleService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.SliderService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.TraduccionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.AlterTextoPalabraCorrectaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.AlterTextoPalabraEncerradaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.AlternativaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.ArmarDocumentoCabService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.ArmarDocumentoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.ArrastraOraDetService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.CrucigramaDetService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.CrucigramaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionDirectorService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionLenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionOperadorService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionSedeService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LeccionMaterialService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaEstructuraService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.MaterialEjercicioService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.MaterialTipoEjercicioService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.OracionAlterService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.OracionCompletarService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.OrdenarParrafoCabeceraService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.OrdenarParrafoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaLenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaNacionalidadService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonalService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PreguntaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.RelacionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.RelacionVariadaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.RelacionCabeceraService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UbigeoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UnidadLeccionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UnidadService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.AccesoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.AuditoriaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PerfilService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.UsuarioPerfilService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.UsuarioService;

@Service("factoryService")
public class FactoryServiceImpl implements FactoryService {
	
	/** ACADEMICO **/
	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private DocenteService docenteService;
	@Autowired
	private EspecialidadService especialidadService;
	@Autowired
	private InscripcionDocenteService inscripcionDocenteService;
	@Autowired
	private InscripcionLenguaService inscripcionLenguaService;
	@Autowired
	private InscripcionService inscripcionService;
	@Autowired
	private MatriculaAlumnoService matriculaAlumnoService;
	@Autowired
	private MatriculaDocenteService matriculaDocenteService;
	@Autowired
	private MatriculaService matriculaService;
	@Autowired
	private UsuarioMatriculaService usuarioMatriculaService;
	@Autowired
	public SeguimientoAlumnoLenguaService  seguimientoAlumnoLenguaService;
	@Autowired
	public SeguimientoAlumnoEjerDetService  seguimientoAlumnoEjerDetService;
	@Autowired
	public EvaluacionService evaluacionService;
	@Autowired
	public EvaluacionDetalleService evaluacionDetalleService;
	@Autowired
	private AlumnoInstitucionService alumnoInstitucionService;
	@Autowired
	private DocenteInstitucionService docenteInstitucionService;
	
	/** CONFIGURACION **/
	@Autowired
	private ExamenConfiguracionService examenConfiguracionService;
	@Autowired
	private FondoService fondoService;
	@Autowired
	private MascotaService mascotaService;
	@Autowired
	private ComboCabService comboService;
	@Autowired
	private PremioConfiguracionService premioConfiguracionService;
	@Autowired
	private PremioService premioService;
	@Autowired
	private SliderService sliderService;
	@Autowired
	private SliderDetalleService sliderDetalleService;
	@Autowired
	private ModalService modalService;
	
	@Autowired
	private AdquisicionUsuarioService adquisicionUsuarioService;
	
	@Autowired
	private IntentoConfiguracionService IntentoConfiguracionService;
	
	@Autowired
	private TraduccionService traduccionService;
	
	@Autowired
	private BonoService  bonoService;
	
	
	
	/** GENERAL **/
	@Autowired
	private CrucigramaDetService  crucigramaDetService;
	@Autowired
	private AlternativaService alternativaService;
	@Autowired
	private CrucigramaService crucigramaService;
	@Autowired
	private InstitucionDirectorService institucionDirectorService;
	@Autowired
	private InstitucionLenguaService institucionLenguaService;
	@Autowired
	private InstitucionOperadorService institucionOperadorService;
	@Autowired
	private InstitucionSedeService institucionSedeService;
	@Autowired
	private InstitucionService institucionService;
	@Autowired
	private LeccionMaterialService leccionMaterialService;
	@Autowired
	private LenguaEstructuraService lenguaEstructuraService;
	@Autowired
	private LenguaService lenguaService;
	@Autowired
	private Maestra1Service maestra1Service;
	@Autowired
	private Maestra2Service maestra2Service;
	@Autowired
	private MaterialEjercicioService materialEjercicioService;
	@Autowired
	private MaterialTipoEjercicioService materialTipoEjercicioService;
	@Autowired
	private OracionAlterService oracionAlterService;
	@Autowired
	private AlterTextoPalabraCorrectaService alterTextoPalabraCorrectaService;
	@Autowired
	private AlterTextoPalabraEncerradaService alterTextoPalabraEncerradaService;
	@Autowired
	private OracionCompletarService oracionCompletarService;
	@Autowired
	private OrdenarParrafoCabeceraService ordenarParrafoCabeceraService;
	@Autowired
	private OrdenarParrafoService ordenarParrafoService;
	@Autowired
	private PersonaLenguaService personaLenguaService;
	@Autowired
	private PersonalService personalService;
	@Autowired
	private PersonaNacionalidadService personaNacionalidadService;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private PreguntaService preguntaService;
	@Autowired
	private RelacionService relacionService;
	@Autowired
	private RelacionCabeceraService relacionCabeceraService;
	@Autowired
	private UbigeoService ubigeoService;
	@Autowired
	private UnidadLeccionService unidadLeccionService;
	@Autowired
	private UnidadService unidadService;	
	@Autowired
	private SeguimientoAlumnoEjercicioService seguimientoAlumnoEjercicioService;
	@Autowired
	private AlumnoMonedaGService alumnoMonedaGService;
	@Autowired
	private SeguimientoAlumIntentoService seguimientoAlumIntentoService; 
	@Autowired
	private ArrastraOraDetService arrastraOraDetService;
	@Autowired
	private RelacionVariadaService relacionVariadaService;
	@Autowired
	private ArmarDocumentoCabService armarDocumentoCabService;
	@Autowired
	private ArmarDocumentoService armarDocumentoService;

	/** SEGURIDAD **/
	@Autowired
	private AccesoService accesoService;
	@Autowired
	private PerfilService perfilService;
	@Autowired
	private UsuarioPerfilService usuarioPerfilService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private AuditoriaService auditoriaService;
	
	@Autowired
	private MensajesService mensajeService;
	
	@Autowired
	private AlumnoMedallaService alumnoMedallaService;
	
	@Autowired
	private AlumnoBonoService alumnoBonoService;
	
	@Autowired
	private GlosarioService glosarioService;
	
	@Override
	public AlumnoService getAlumnoService() {
		return alumnoService;
	}
	@Override
	public DocenteService getDocenteService() {
		return docenteService;
	}
	@Override
	public EspecialidadService getEspecialidadService() {
		return especialidadService;
	}
	@Override
	public InscripcionDocenteService getInscripcionDocenteService() {
		return inscripcionDocenteService;
	}
	@Override
	public InscripcionLenguaService getInscripcionLenguaService() {
		return inscripcionLenguaService;
	}
	@Override
	public InscripcionService getInscripcionService() {
		return inscripcionService;
	}
	@Override
	public MatriculaAlumnoService getMatriculaAlumnoService() {
		return matriculaAlumnoService;
	}
	@Override
	public MatriculaDocenteService getMatriculaDocenteService() {
		return matriculaDocenteService;
	}
	@Override
	public MatriculaService getMatriculaService() {
		return matriculaService;
	}
	@Override
	public UsuarioMatriculaService getUsuarioMatriculaService() {
		return usuarioMatriculaService;
	}
	@Override
	public ExamenConfiguracionService getExamenConfiguracionService() {
		return examenConfiguracionService;
	}
	@Override
	public FondoService getFondoService() {
		return fondoService;
	}
	@Override
	public MascotaService getMascotaService() {
		return mascotaService;
	}
	@Override
	public PremioConfiguracionService getPremioConfiguracionService() {
		return premioConfiguracionService;
	}
	@Override
	public PremioService getPremioService() {
		return premioService;
	}
	@Override
	public SliderService getSliderService() {
		return sliderService;
	}
	@Override
	public SliderDetalleService getSliderDetalleService() {
		return sliderDetalleService;
	}
	@Override
	public ModalService getModalService() {
		return modalService;
	}
	@Override
	public AlternativaService getAlternativaService() {
		return alternativaService;
	}
	@Override
	public CrucigramaService getCrucigramaService() {
		return crucigramaService;
	}
	@Override
	public InstitucionDirectorService getInstitucionDirectorService() {
		return institucionDirectorService;
	}
	@Override
	public InstitucionLenguaService getInstitucionLenguaService() {
		return institucionLenguaService;
	}
	@Override
	public InstitucionOperadorService getInstitucionOperadorService() {
		return institucionOperadorService;
	}
	@Override
	public InstitucionSedeService getInstitucionSedeService() {
		return institucionSedeService;
	}
	@Override
	public InstitucionService getInstitucionService() {
		return institucionService;
	}
	@Override
	public LeccionMaterialService getLeccionMaterialService() {
		return leccionMaterialService;
	}
	@Override
	public LenguaEstructuraService getLenguaEstructuraService() {
		return lenguaEstructuraService;
	}
	@Override
	public LenguaService getLenguaService() {
		return lenguaService;
	}
	@Override
	public Maestra1Service getMaestra1Service() {
		return maestra1Service;
	}
	@Override
	public Maestra2Service getMaestra2Service() {
		return maestra2Service;
	}
	@Override
	public MaterialEjercicioService getMaterialEjercicioService() {
		return materialEjercicioService;
	}
	@Override
	public MaterialTipoEjercicioService getMaterialTipoEjercicioService() {
		return materialTipoEjercicioService;
	}
	@Override
	public OracionAlterService getOracionAlterService() {
		return oracionAlterService;
	}
	@Override
	public OracionCompletarService getOracionCompletarService() {
		return oracionCompletarService;
	}
	@Override
	public OrdenarParrafoCabeceraService getOrdenarParrafoCabeceraService() {
		return ordenarParrafoCabeceraService;
	}
	@Override
	public OrdenarParrafoService getOrdenarParrafoService() {
		return ordenarParrafoService;
	}
	@Override
	public PersonaLenguaService getPersonaLenguaService() {
		return personaLenguaService;
	}
	@Override
	public PersonalService getPersonalService() {
		return personalService;
	}
	@Override
	public PersonaNacionalidadService getPersonaNacionalidadService() {
		return personaNacionalidadService;
	}
	@Override
	public PersonaService getPersonaService() {
		return personaService;
	}
	@Override
	public PreguntaService getPreguntaService() {
		return preguntaService;
	}
	@Override
	public RelacionCabeceraService getRelacionCabeceraService() {
		return relacionCabeceraService;
	}
	@Override
	public RelacionService getRelacionService() {
		return relacionService;
	}
	@Override
	public UbigeoService getUbigeoService() {
		return ubigeoService;
	}
	@Override
	public UnidadLeccionService getUnidadLeccionService() {
		return unidadLeccionService;
	}
	@Override
	public UnidadService getUnidadService() {
		return unidadService;
	}
	@Override
	public AccesoService getAccesoService() {
		return accesoService;
	}
	@Override
	public PerfilService getPerfilService() {
		return perfilService;
	}
	@Override
	public UsuarioPerfilService getUsuarioPerfilService() {
		return usuarioPerfilService;
	}
	@Override
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	
	@Override
	public AdquisicionUsuarioService getAdquisicionUsuarioService(){
		return adquisicionUsuarioService;
	}
	
	@Override
	public AlumnoMedallaService getAlumnoMedallaService() {
		return alumnoMedallaService;
	}
	
	@Override
	public IntentoConfiguracionService getIntentoConfiguracionService() {
		return IntentoConfiguracionService;
	} 
	@Override
	public SeguimientoAlumnoLenguaService getSeguimientoAlumnoLenguaService() {
		return seguimientoAlumnoLenguaService;
	}
	 
	@Override
	public SeguimientoAlumnoEjercicioService getSeguimientoAlumnoEjercicioService() {
		return seguimientoAlumnoEjercicioService;
	} 
	@Override
	public ComboCabService getComboService() {
		return comboService;
	}

	@Override
	public AlterTextoPalabraCorrectaService getalterTextoPalabraCorrectaService() {
		return alterTextoPalabraCorrectaService;
	}

	@Override
	public AlumnoMonedaGService getAlumnoMonedaGService() {
		return alumnoMonedaGService;
	}
	
	@Override
	public AlterTextoPalabraEncerradaService getAlterTextoPalabraEncerradaService() {
		return alterTextoPalabraEncerradaService;
	}
	
	@Override
	public ArrastraOraDetService getArrastraOraDetService() {
		return arrastraOraDetService;
	}
	@Override
	public SeguimientoAlumIntentoService getSeguimientoAlumIntentoService() {
		return seguimientoAlumIntentoService;
	}
	
	@Override
	public SeguimientoAlumnoEjerDetService  getSeguimientoAlumnoEjerDetService() {
		return seguimientoAlumnoEjerDetService;
	}
	
	@Override
	public RelacionVariadaService getRelacionVariadaService() {
		return relacionVariadaService;
	}
	@Override
	public ArmarDocumentoCabService getArmarDocumentoCabService() {
		return armarDocumentoCabService;
	}
	@Override
	public ArmarDocumentoService getArmarDocumentoService() {
		return armarDocumentoService;
	}
	@Override
	public AuditoriaService getAuditoriaService() {
		return auditoriaService;
	}
	@Override
	public EvaluacionService getEvaluacionService() {
		return evaluacionService;
	}
	@Override
	public EvaluacionDetalleService getEvaluacionDetalleService() {
		return evaluacionDetalleService;
	}
	@Override
	public MensajesService getMensajeService(){
		return mensajeService;
	}	
	@Override
	public GlosarioService getGlosarioService(){
		return glosarioService;
	}
	
	@Override
	public AlumnoBonoService getAlumnoBonoService(){
		return alumnoBonoService;
	}

	public AlumnoInstitucionService getAlumnoInstitucionService() {
		return alumnoInstitucionService;
	}
	@Override
	public TraduccionService getTraduccionService() {
		return traduccionService;
	}
	@Override
	public BonoService getBonoService() {
		return bonoService;
	}
	@Override
	public CrucigramaDetService getCrucigramaDetService() {
		// TODO Auto-generated method stub
		return crucigramaDetService;
	}
	@Override
	public DocenteInstitucionService getDocenteInstitucionService() {
		// TODO Auto-generated method stub
		return docenteInstitucionService;
	}


}