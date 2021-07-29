package pe.gob.procalidad.natigu.web.gestion.controller.seguridad;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.ComponenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PerfilBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.AccesoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PerfilService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.NetUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;

@Controller
@Scope(value="session")
@RequestMapping(value = "accesoController")
public class AccesoController extends BaseController{
	
	@Autowired
	AccesoService accesoService;
	
	@Autowired
	private PerfilService perfilService;
	
	private AccesoBean accesoBean;
	private List<PerfilBean>	lstPerfil;
	
	@PostConstruct
	public void init(){
		this.setAccesoBean(new AccesoBean());
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("accesoBean") AccesoBean accesoBean,HttpServletRequest request)throws Exception {
		return this.getLista(accesoBean);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView buscar(@ModelAttribute("accesoBean") AccesoBean accesoBean, HttpServletRequest request) 
			                   throws Exception {	
	
		return this.getLista(accesoBean);
	}
	
	private ModelAndView getLista(AccesoBean accesoBean) {
		
		List<AccesoBean> lstAccesoBean =new ArrayList<AccesoBean>(); 
		try {
			
			if(	!VO.isNull(accesoBean.getPerfil()) 
				&& !VO.isNull(accesoBean.getPerfil().getCodigo()) 
				&& accesoBean.getPerfil().getCodigo()!=0){
				accesoBean.getComponente().setCodigoComponentePadre(new Long(0));
				lstAccesoBean =  accesoService.getBuscarPorFiltros(accesoBean);
			}
			
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("seguridad/acceso/acceso", "command",accesoBean);
		mav.addObject("accesoBean", accesoBean);
		mav.addObject("lstAccesoBean", lstAccesoBean);
		mav.addObject("totalMenus", !VO.isEmptyList(lstAccesoBean) ? lstAccesoBean.size() : 0);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/verSubMenu", method = RequestMethod.GET)
	public ModelAndView verSubMenu(	@RequestParam("codperfil") String codperfil,
									@RequestParam("codcompa") String codcompa,
									HttpServletRequest request) 
			                   throws Exception {	
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			List<AccesoBean> lstAccesoBean =new ArrayList<AccesoBean>(); 
			try {
					AccesoBean filtro = new AccesoBean();
					filtro.getPerfil().setCodigo(VO.toLong(codperfil));
					filtro.getComponente().setCodigoComponentePadre(VO.toLong(codcompa));
					lstAccesoBean =  accesoService.getBuscarPorFiltros(filtro);
				
			} catch (Exception e) {
				System.out.println("getLista " + e.getMessage());
			}
			
			ModelAndView mav = new ModelAndView("seguridad/acceso/ajax/submenu-tabla-ajax","command", accesoBean);
			mav.addObject("lstAccesoBeanDetalle",lstAccesoBean);
			mav.addObject("totalSubMenus", !VO.isEmptyList(lstAccesoBean) ? lstAccesoBean.size() : 0);
			return mav;
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesión no es valida, por favor inicie sesión nuevamente");
			return mav;
		}
	}
	
	@RequestMapping(value = "/asignarAcceso", method = RequestMethod.POST)
    public @ResponseBody List<AccesoBean> asignarAcceso(@RequestBody AccesoBean[] accesoArray, HttpServletRequest request) {
        
		List<AccesoBean> lstAccesoBean = new ArrayList<AccesoBean>();
		
        try {
        	
			if (	!VO.isNull(accesoArray)
					&& 	(	!VO.isNull(accesoArray[0]) 
						&& 	!VO.isNull(accesoArray[0].getPerfil())
						&& 	!VO.isNull(accesoArray[0].getPerfil().getCodigo())
						)
			   ) {
				
				long perfilId = accesoArray[0].getPerfil().getCodigo();
				
				if(guardarCambios(accesoArray,request)){
					/** RETORNAR MENUS PRINCIPALES **/
					AccesoBean filtroAccesoBean = new AccesoBean();
					filtroAccesoBean.setPerfil(new PerfilBean());
					filtroAccesoBean.getPerfil().setCodigo(perfilId);
					filtroAccesoBean.setComponente(new ComponenteBean());
					filtroAccesoBean.getComponente().setCodigoComponentePadre(new Long(0));
					lstAccesoBean =  accesoService.getBuscarPorFiltros(filtroAccesoBean);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return lstAccesoBean;
    }
	
	private boolean guardarCambios(AccesoBean[] listaAcceso, HttpServletRequest request){
		
		boolean swGuardado = true;
		
		try {
			
			//UsuarioBean usuarioSesion = this.getUsuarioSesion(request);
			
			for (int i = 0; i < listaAcceso.length; i++) {
				AccesoBean prmAcceso = listaAcceso[i];
				//prmAcceso.setCodigoUsuarioCreacion(usuarioSesion.getCodigoUsuario());
				//prmAcceso.setIpCreacion(NetUtil.getClientIpAddr(request));
				accesoService.asignar(prmAcceso);
			}
		} catch (Exception e) {
			e.printStackTrace();
			swGuardado = false;
		}
		
		return swGuardado;
	}
	
	private void cargarCombos(ModelAndView mav){
		lstPerfil=null;
		if (lstPerfil==null) {
			try {
				lstPerfil = perfilService.getBuscarPorFiltros(new PerfilBean());
			} catch (ServiceException e) {
				e.printStackTrace();
			}		
		}
  
		mav.addObject("lstPerfil",lstPerfil); 
	}  

	public AccesoBean getAccesoBean() {
		return accesoBean;
	}

	public void setAccesoBean(AccesoBean accesoBean) {
		this.accesoBean = accesoBean;
	}
	
}