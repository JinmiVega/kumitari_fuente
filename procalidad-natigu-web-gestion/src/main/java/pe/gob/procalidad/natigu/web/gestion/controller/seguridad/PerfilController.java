package pe.gob.procalidad.natigu.web.gestion.controller.seguridad;

import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.io.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PerfilBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PerfilService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.SessionService;

@Controller
@RequestMapping(value = "perfilController")
public class PerfilController {
	@Autowired
	PerfilService perfilService;
	
	@Autowired
	private Maestra1Service 	maestra1Service;
	
	@Autowired
	private PeticionService peticionService;
	
	private PerfilBean perfilBean;
	private PerfilBean perfilBeanFiltro;
	private List<MaestraBean>	lstSituacion;
	@Autowired
	private SessionService sessionService;
	
	@PostConstruct
	public void init(){
		this.setPerfilBean(new PerfilBean());
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("perfilBean") PerfilBean bean)throws Exception {
				
		
		PerfilBean perfilBean = new PerfilBean(); 
	 
		
//		return this.getLista(prmMascotaBean);
	 
		
		ModelAndView mav = new ModelAndView("seguridad/perfil/listado-perfil", "command",perfilBean);
 
		mav.addObject("lstPerfilBean",  new ArrayList<PerfilBean>());
		this.cargarCombos(mav);
		return mav;
//		return this.getLista(bean);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscar(@ModelAttribute("perfilBean") PerfilBean perfilBean)
			throws Exception { 
		
		return this.getLista(perfilBean);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscarListado(@ModelAttribute("perfilBean") PerfilBean perfilBean)
			throws Exception { 
//		perfilBean = perfilBeanFiltro;
		System.out.println("============= buscar perfil ");
		return this.getLista(perfilBean);
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("seguridad/perfil/registro-perfil", "command",new PerfilBean());
		mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("perfilBean", new PerfilBean());
		return mav;
	}
	
	@RequestMapping(value = "/obtener", method = RequestMethod.POST)
	public ModelAndView doObtener(@ModelAttribute("perfilBean") PerfilBean bean) {
		
		
		if(bean.getCodigoPerfil()!=null && bean.getCodigoPerfil()>0){
			List<PerfilBean> lstPerfilBean =new ArrayList<PerfilBean>(); 
			try {
				lstPerfilBean = perfilService.getBuscarPorFiltros(bean);
								
				if(lstPerfilBean != null && lstPerfilBean.size()>0){
					
					perfilBean = (PerfilBean)lstPerfilBean.get(0);
					
				}
			} catch (ServiceException e) {
				
				e.printStackTrace();
			}
			
		}else{
			perfilBean = new PerfilBean();
		}
		
		ModelAndView mav = new ModelAndView("seguridad/perfil/registro-perfil", "command", perfilBean);
		mav.addObject("perfilBean", perfilBean);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/obtener", method = RequestMethod.GET)
	public ModelAndView doObtenerPost(@ModelAttribute("perfilBean") PerfilBean bean) {
		
		return this.doObtener(bean);
	 
	}
	
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("perfilBean") PerfilBean perfilBean,HttpServletRequest request) {
		
		//System.out.println("lenguaBean Grabar"+lenguaBean);
		boolean sw = false;
		try {
			//ip
			boolean habilitadoIp = true;
			//PeticionBean prmIntento = new PeticionBean();
			//prmIntento.setIpConexion(request.getRemoteAddr());
			//prmIntento.setUrlPeticion("PerfilController/grabar");
			//habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	if(perfilBean.getNombrePerfil()!=null&&perfilBean.getNombrePerfil()!="") {
	        		if (perfilBean.getCodigoPerfil()!=null && perfilBean.getCodigoPerfil()!=0) {
	        			sw = (perfilService.actualizar(perfilBean));
	        		} else {
	        			sw =  (perfilService.insertar(perfilBean)); 	
	        		}	        		        		
	        	}
	        }

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			System.out.println("sw: "+sw);
			perfilBean = new PerfilBean() ;
			ModelAndView mav = this.getLista(perfilBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("seguridad/perfil/registro-perfil", "command",perfilBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		}

	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public ModelAndView doEliminar(@ModelAttribute PerfilBean perfilBean,HttpServletRequest request) {
		
		//System.out.println("lenguaBean Grabar"+lenguaBean);
		boolean sw = true;
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("PerfilController/eliminar");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	if (perfilBean.getCodigoPerfil()!=null && perfilBean.getCodigoPerfil()!=0) {
	        		sw = (perfilService.eliminar(perfilBean));
	        	}	        	
	        } 
		} catch (Exception e) { 
			e.printStackTrace();
		}

		//if (sw) {
			perfilBean = new PerfilBean() ;
			return this.getLista(perfilBean);
		/*} else {
			ModelAndView mav = new ModelAndView("seguridad/perfil/registro-perfil", "command",perfilBean);
			return mav;
		}*/

	}
	
	private ModelAndView getLista(PerfilBean perfilBean) {
		
		
		
		List<PerfilBean> lstPerfilBean =new ArrayList<PerfilBean>(); 
		try {
			lstPerfilBean =  perfilService.getBuscarPorFiltros(perfilBean);
			
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("seguridad/perfil/listado-perfil", "command",perfilBean);
		mav.addObject("perfilBean", perfilBean);
		mav.addObject("lstPerfilBean", lstPerfilBean);
		this.cargarCombos(mav);
		return mav;
	}
	
	private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionPerfil",0);
			} catch (ServiceException e) {
				e.printStackTrace();
			}		
		}
  
		mav.addObject("lstSituacion",lstSituacion); 
	}  

	public PerfilBean getPerfilBean() {
		return perfilBean;
	}

	public void setPerfilBean(PerfilBean perfilBean) {
		this.perfilBean = perfilBean;
	}

	public PerfilBean getPerfilBeanFiltro() {
		return perfilBeanFiltro;
	}

	public void setPerfilBeanFiltro(PerfilBean perfilBeanFiltro) {
		this.perfilBeanFiltro = perfilBeanFiltro;
	}
	
	
}
