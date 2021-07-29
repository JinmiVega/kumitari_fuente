package pe.gob.procalidad.natigu.web.gestion.controller.indicador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.academico.InscripcionBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.SesionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.SessionService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;

@Controller
@Scope(value="session")
@RequestMapping(value = "indicadorController")
public class IndicadorController extends BaseController{
	
	private List<InstitucionBean>	lstInstitucionBean;
	private List<MaestraBean>		lstSituacion;
	private List<MaestraBean>		lstPeriodo;
	private List<MaestraBean>		lstCiclo;
	private List<MaestraBean>		lstnivel;
	@Autowired
	private SessionService sessionService;
	
	@PostConstruct
	public void init(){
		
	}
	
	@RequestMapping(value = "/indicador", method = RequestMethod.GET)
	public ModelAndView doIndicador(HttpServletRequest request)throws Exception {
		
		
		
		
		ModelAndView mav = new ModelAndView("indicador/indicadores-contenido", "command","");
		this.cargarCombos(mav);
		
		UsuarioBean usuario = this.getUsuarioSesion(request);
		long idInstitucion = 0;
		//------ validacion de cambio de contraseña
		HttpSession session = request.getSession();
		SesionBean _sesionBean=new SesionBean();		
		String session_id=request.getSession().getId();
		long user_id=usuario.getCodigo();
		_sesionBean.setUser_id((int)user_id);
		_sesionBean.setSession_id(session_id);
		
		try {
			boolean flag_v=sessionService.sessionGestor(_sesionBean, "VALIDAR");
			
			if(flag_v) {
					System.out.println("========= CERRAR CESSION : >1 >direccionar al login ");
					sessionService.sessionGestor(_sesionBean, "CERRAR_SESSION");
					session.removeAttribute("usuarioSesion");
					session.invalidate();
					
					ModelAndView mav_v = new ModelAndView("seguridad/login/login-admin", "command",new LoginVo());
					mav_v.addObject("msgErrorLogin", "Acceso no permitido");
					mav_v.addObject("usuarioBean", usuarioBean);
					return mav_v;
					
				}else{
				//---- flujo normal

					lstInstitucionBean = this.fs.getInstitucionService().listarInstitucionxTipoUsuario(usuario);
					
					/** Perfil de usuario 
					 * 1: Administrador
					 * 2: Docente
					 * 3: Supervisor,
					 * 5: Operador
					 * 6: Operador Institucional 
					**/
					if(	usuario.getCodPerfilUsuSelec() == 6        
						|| usuario.getCodPerfilUsuSelec() == 2 ){
						
						idInstitucion = !VO.isEmptyList(lstInstitucionBean) ? lstInstitucionBean.get(0).getCodigo() : 0; 
					}
					
					mav.addObject("lstInstitucionBean",lstInstitucionBean);
					mav.addObject("idInstitucion", idInstitucion);
					return mav;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return mav;
			}
		//------
		
	}
	
	@RequestMapping(value = "/reporteInscripciones", method = RequestMethod.GET)
	@ResponseBody
	public List<InscripcionBean> reporteInscripciones(@RequestParam("codinst") Long codinst,
													@RequestParam("codsit") Integer codsit,
													@RequestParam("codPerfilAct") Long codPerfilAct,
													HttpServletRequest request){
		System.out.println("--------reporteInscripciones----");
		List<InscripcionBean> lstInscripcionBean = new ArrayList<InscripcionBean>();
		
		try {
			InscripcionBean prmInscripcionBean = new InscripcionBean();
			prmInscripcionBean.getInstitucion().setCodigo(codinst);
			prmInscripcionBean.getSituacion().setCodigoRegistro(codsit);
			UsuarioBean usuario = this.getUsuarioSesion(request);
			System.out.println("getUsuarioSesion(request).getCodigoPerfil()) " + usuario.getCodigoPerfil());
			System.out.println("getUsuarioSesion(request).getCodPerfilUsuSelec()) " + usuario.getCodPerfilUsuSelec());
			System.out.println("usuario.getCodigoUsuario() " + usuario.getCodigoUsuario());
			System.out.println("codPerfilAct " + codPerfilAct);
			usuario.setCodigoPerfil(codPerfilAct);			
			prmInscripcionBean.setAudCodigoUsuario((usuario.getCodigoUsuario()));
			lstInscripcionBean = this.fs.getInscripcionService().getBuscarPorFiltrosxperfil(prmInscripcionBean,usuario);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return lstInscripcionBean;
	}
	
	@RequestMapping(value = "/reporteSeguimiento", method = RequestMethod.POST)
	@ResponseBody
	public List<MatriculaBean> reporteSeguimiento(	@RequestParam("codinstitucion") String codinstitucion,
													@RequestParam("codlengua") String codlengua,
													@RequestParam("coddocente") String coddocente,
													@RequestParam("codnivel") String codnivel,
													@RequestParam("codperiodo") String codperiodo,
													@RequestParam("codsituacion")  String codsituacion,
													HttpServletRequest request){
		
		List<MatriculaBean> lstMatriculaBean = new ArrayList<MatriculaBean>(); 
		
		try {
			
			MatriculaBean filtro = new MatriculaBean();
			filtro.getInsti().setCodigo(VO.toLong(codinstitucion));
			filtro.getLengua().setCodigo(VO.toLong(codlengua));
			filtro.getDocenteBean().setCodigo(VO.toLong(coddocente));
			filtro.getNivel().setCodigoRegistro(VO.toInteger(codnivel));
			filtro.getPeriodo().setCodigoRegistro(VO.toInteger(codperiodo));
			filtro.getSituacion().setCodigoRegistro(VO.toInteger(codsituacion));
			
			lstMatriculaBean = (List<MatriculaBean>) this.fs.getMatriculaService().listarSeguimientoAlumno(filtro);
			if (VO.isNotEmptyList(lstMatriculaBean)) {
				System.out.println("lstMatriculaBean.size()"+ lstMatriculaBean.size());
			}
			
		} catch (Exception e) {
			System.out.println("getLista lstMatriculaBean " + e.getMessage());
		}
		
		return lstMatriculaBean;
	}

	private void cargarCombos(ModelAndView mav){
		
		try {
			if (lstSituacion==null) {
				lstSituacion = this.fs.getMaestra2Service().listarPorCodigoTabla("situacionInscripcion",0);
			}
			if (lstPeriodo==null) {
				lstPeriodo = this.fs.getMaestra2Service().listarPorCodigoTabla("periodo",0);
			}
			if (lstCiclo==null) {
				lstCiclo = this.fs.getMaestra2Service().listarPorCodigoTabla("ciclo",0);
			}
			if (lstnivel==null) {
				lstnivel = this.fs.getMaestra2Service().listarPorCodigoTabla("nivel",1);		
			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}		
		
		mav.addObject("lstnivel",lstnivel); 
		mav.addObject("lstCiclo",lstCiclo);
		mav.addObject("lstPeriodo",lstPeriodo); 
		mav.addObject("lstSituacion",lstSituacion); 
	} 
	
}