package pe.gob.procalidad.natigu.web.gestion.controller.configuracion;

import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.io.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.servlet.ModelAndView; 

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.BonoBean; 
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.BonoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.CodeUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;
 
@Controller
@Scope(value="session")
@RequestMapping(value = "bonoController")
public class BonoController extends BaseController {

	private BonoBean 		bonoBean;
	private BonoBean 		bonoBeanFiltro;
	private BonoBean 		bonoBeanTmp; 
	private List<BonoBean> 	lstBonoBean;
	
	private List<MaestraBean>	lstSituacion; 
	private List<MaestraBean>	lstTipo;
	private List<MaestraBean>	lstTipoEjercicio;

	@Autowired
	private BonoService 		BonoService;
	@Autowired
	private Maestra1Service 	maestra1Service;
	@Autowired
	private Maestra2Service 	maestra2Service; 
	@Autowired
	private PeticionService peticionService;
	
	@PostConstruct
	public void init(){
		this.setBonoBean(new BonoBean());
		this.setLstBonoBean(new ArrayList<BonoBean>());
		this.setBonoBeanFiltro(new BonoBean());
	//	this.setLstSituacion(new ArrayList<MaestraBean>());
	} 
	
	public BonoController (){  
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("bonoBean") BonoBean bonoBean)throws Exception {
		
		BonoBean prmBonoBean = new BonoBean(); 
		prmBonoBean.setNombre("");  
		prmBonoBean.setSituacion(new MaestraBean());
		prmBonoBean.getSituacion().setCodigoRegistro(0);
		prmBonoBean.setTipo(new MaestraBean());
		prmBonoBean.getTipo().setCodigoRegistro(0);
		
//		return this.getLista(prmBonoBean);
		ModelAndView mav = new ModelAndView("configuracion/listado-bonos", "command",bonoBean);
	
//		mav.addObject("lstBonoBean", new ArrayList<BonoBeans>());
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscar(@ModelAttribute("bonoBean") BonoBean bonoBean)
			throws Exception {
//		System.out.println("buscar Bono " + bonoBean);
		return this.doBuscarListado(bonoBeanFiltro);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscarListado(@ModelAttribute("bonoBean") BonoBean bonoBean)
			throws Exception {
//		System.out.println("buscar Bono " + bonoBean);
//		return this.getLista(bonoBean);
		bonoBeanFiltro = bonoBean;
		List<BonoBean> lstBonoBean = new ArrayList<BonoBean>();
		try { 
			lstBonoBean = (List<BonoBean>) this.getBonoService().getBuscarPorFiltros(bonoBean); 
			 
		} catch (Exception e) {
			System.out.println("getLista fallo" + e.getMessage());
		}
		
		if(lstBonoBean != null){
			for(int i=0; i<lstBonoBean.size();i++){
				lstBonoBean.get(i).setDescripcion(VO.convertirCaracteresEsp(lstBonoBean.get(i).getDescripcion()));
			}
		}

		ModelAndView mav = new ModelAndView("configuracion/listado-bonos", "command",bonoBean);
		System.out.println("lstBonoBean "+lstBonoBean);
		mav.addObject("lstBonoBean", lstBonoBean);
		this.cargarCombos(mav);
		return mav;
	}
	
	
//	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
//	public ModelAndView doBuscar1(@ModelAttribute("bonoBean") BonoBean bonoBean)
//			throws Exception {
//		System.out.println("buscar Bono " + bonoBean);
//		return doListado(bonoBean);
//	}
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		bonoBean= new BonoBean();
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
	//	this.setAuditoria(lenguaBean, request, false);
		//leer token		
		if(u != null) {
			try { 
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("BonoController/eliminar");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	bonoBean.setCodigo(codigo);
		        	sw =  (this.getBonoService().eliminar(bonoBean)); 		        	
		        }
			} catch (Exception e) { 
				e.printStackTrace();
			} 		
			bonoBean.setCodigo(0);
			this.setValoresPredeterminados(bonoBean);
			ModelAndView mav = this.getLista(bonoBean);
			mav.addObject("swMensaje",sw?"1":"0");
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

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		bonoBeanTmp = null;
		ModelAndView mav = new ModelAndView("configuracion/registro-bono", "command",new BonoBean());
		mav.addObject("BonoBean", new BonoBean());
		this.cargarCombos(mav);
		return mav;
	} 

	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doModificar(@RequestParam("codigo") Long codigo, HttpServletRequest request ) {

		BonoBean prmMaestraBean = new BonoBean();
//		prmMaestraBean.setId(0);
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("BonoController/modificar");
			//habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	prmMaestraBean.setCodigo(codigo); 
	        	bonoBeanTmp = prmMaestraBean;
	        	// maestraBean.getEstado()!='0'; 		        	
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			bonoBean = this.getBonoService().getBuscarPorObjecto(prmMaestraBean);			
		} catch (ServiceException e) {
			e.printStackTrace();
		} 
		
		if (bonoBean != null) {
			if ((bonoBean.getEstado() != null) ) {
				if (bonoBean.getEstado().equals("1")) {

					ModelAndView mav = new ModelAndView("configuracion/registro-bono", "command", bonoBean);
					this.cargarCombos(mav);
					mav.addObject("bonoBean", bonoBean);
					return mav;
				} else {
					ModelAndView mav = this.getLista(new BonoBean());
					mav.addObject("swMensaje", "0");
					mav.addObject("bonoBean", new BonoBean());
					return mav;

				}
			} else {
				ModelAndView mav = this.getLista(new BonoBean());
				mav.addObject("swMensaje", "0");
				mav.addObject("bonoBean", new BonoBean());
				return mav;
			}

		} else {
			ModelAndView mav = this.getLista(new BonoBean());
			mav.addObject("swMensaje", "0");
			mav.addObject("bonoBean", new BonoBean());
			return mav;
		}
	}
	

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar() {

		if(bonoBeanTmp != null){
			BonoBean prmMaestraBean = new BonoBean();
			prmMaestraBean.setCodigo(bonoBeanTmp.getCodigo()); 
//			prmMaestraBean.setId(0);
			try {
				bonoBean = this.getBonoService().getBuscarPorObjecto(prmMaestraBean);
				// maestraBean.getEstado()!='0'; 
			} catch (ServiceException e) {
				e.printStackTrace();
			} 
			if (bonoBean != null) {
				if ((bonoBean.getEstado() != null) ) {
					if (bonoBean.getEstado().equals("1")) {

						ModelAndView mav = new ModelAndView("configuracion/registro-bono", "command", bonoBean);
						this.cargarCombos(mav);
						mav.addObject("bonoBean", bonoBean);
						return mav;
					} else {
						ModelAndView mav = this.getLista(new BonoBean());
						mav.addObject("swMensaje", "0");
						mav.addObject("bonoBean", new BonoBean());
						return mav;

					}
				} else {
					ModelAndView mav = this.getLista(new BonoBean());
					mav.addObject("swMensaje", "0");
					mav.addObject("bonoBean", new BonoBean());
					return mav;
				}
			} else {
				ModelAndView mav = this.getLista(new BonoBean());
				mav.addObject("swMensaje", "0");
				mav.addObject("bonoBean", new BonoBean());
				return mav;
			}
		}else{
			ModelAndView mav = this.getLista(new BonoBean());
			mav.addObject("swMensaje", "0");
			mav.addObject("bonoBean", new BonoBean());
			return mav;
		}
		
	}
	
//	
//	
//	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
//	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {
//
//		System.out.println("modificar codigo: " + codigo);
//
//		BonoBean prmBonoBean = new BonoBean();
//		prmBonoBean.setCodigo(codigo); 
//		try {
//			bonoBean = this.getBonoService().getBuscarPorObjecto(prmBonoBean);
////			tmpUrlImagen = bonoBean.getImagenNombre();
//		} catch (ServiceException e) { 
//			e.printStackTrace();
//		}
// 
//		if (bonoBean != null ) {
//			if ( bonoBean.getEstado() != null)   {  
//			if (bonoBean.getEstado().equals("1") ){
//				 
//				ModelAndView mav = new ModelAndView("configuracion/registro-bono", "command", bonoBean);  
//				this.cargarCombos(mav);
//				mav.addObject("bonoBean", bonoBean);
//				return mav;
//		}else{
//			ModelAndView mav = this.getLista(new BonoBean());
//			mav.addObject("swMensaje","0");
//			mav.addObject("bonoBean",new BonoBean());  
//			return mav;
//			
//		} }
//			else{
//				ModelAndView mav = this.getLista(new BonoBean());
//				mav.addObject("swMensaje","0");
//				mav.addObject("bonoBean",new BonoBean());  
//				return mav;
//		} 
//		
//		} 
//		else { 
//			ModelAndView mav = this.getLista(new BonoBean());
//			mav.addObject("swMensaje","0");
//			mav.addObject("bonoBean",new BonoBean());  
//			return mav;
//		} 
//	}  
		 

	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("bonoBean") BonoBean bonoBean,
		  HttpServletRequest request) {
			
		 System.out.println("bonoBean Grabar"+bonoBean);
		System.out.println("bonoBean Grabar"+bonoBean.getCodigo());
		
		boolean type = false;
		boolean sw = true; 
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
		
			if(bonoBean.getTipo().getCodigoRegistro()!=null && bonoBean.getTipo().getCodigoRegistro().equals(2)) {
				if(bonoBean.getTipoEjercicio().getCodigoRegistro()!=null && bonoBean.getSituacion().getCodigoRegistro()!=null) {
					type = true;
				} else {
					type = false;
				}
			} else {
				if(bonoBean.getSituacion().getCodigoRegistro()!=null && bonoBean.getTipo().getCodigoRegistro()!=null) {
					type = true;				
				} else {
					type = false;
				}
			}
			
			if(type) {
				try { 
					
					bonoBean.setNombre(VO.convertirCaracteresEsp(bonoBean.getNombre()));
					bonoBean.setDescripcion(VO.convertirCaracteresEsp(bonoBean.getDescripcion()));
					
					//ip
					boolean habilitadoIp = true;
					PeticionBean prmIntento = new PeticionBean();
					prmIntento.setIpConexion(request.getRemoteAddr());
					prmIntento.setUrlPeticion("BonoController/grabar");
					//habilitadoIp = peticionService.existe(prmIntento);
			        if(habilitadoIp) {
			        	if(bonoBean.getNombre()!=null&&bonoBean.getNombre()!="") {
			        		if (bonoBean.getCodigo()==0) {
			        			this.setAuditoria(bonoBean, request, true);
			        			sw =  (this.getBonoService().insertar(bonoBean)); 
			        		} else {
			        			
			        			this.setAuditoria(bonoBean, request, false);
			        			System.out.println("bono:"+bonoBean);
			        			sw = (this.getBonoService().actualizar(bonoBean));
			        		}			        		
			        	}
			        }
					
				} catch (Exception e) { 
					e.printStackTrace();
				}
				
				if (sw) { 
					bonoBean = new BonoBean() ;
					ModelAndView mav = this.getLista(bonoBean);
					mav.addObject("swMensaje",sw?"1":"0");
					return mav;
				} else {
					ModelAndView mav = new ModelAndView("configuracion/registro-bono", "command",bonoBean);
					mav.addObject("swMensaje",sw?"1":"0");
					mav.addObject("bonoBean",bonoBean);
					this.cargarCombos(mav);
					return mav;
				}
				
			} else {
				ModelAndView mav = new ModelAndView("configuracion/registro-bono", "command",bonoBean);
				mav.addObject("swMensaje","3");
				mav.addObject("bonoBean",bonoBean);
				this.cargarCombos(mav);
				return mav;
			}

		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesión no es valida, por favor inicie sesión nuevamente");
			return mav;
		}

	}

	private ModelAndView getLista(BonoBean bonoBean) {
		
		List<BonoBean> lstBonoBean = new ArrayList<BonoBean>();
		try { 
			lstBonoBean = (List<BonoBean>) this.getBonoService().getBuscarPorFiltros(bonoBean); 
			 
		} catch (Exception e) {
			System.out.println("getLista fallo" + e.getMessage());
		}
		
		if(lstBonoBean != null){
			for(int i=0; i<lstBonoBean.size();i++){
				lstBonoBean.get(i).setDescripcion(VO.convertirCaracteresEsp(lstBonoBean.get(i).getDescripcion()));
			}
		}
 
		ModelAndView mav = new ModelAndView("configuracion/listado-bonos", "command",bonoBean);
		System.out.println("lstBonoBean "+lstBonoBean);
		mav.addObject("lstBonoBean", lstBonoBean);
		this.cargarCombos(mav);
		return mav;
	}
		private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionBono",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
		 
		
		if (lstTipo==null) {
			try {
				lstTipo = maestra1Service.listarPorCodigoTabla("tipoBono",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
		if (lstTipoEjercicio==null) {
			try {
				lstTipoEjercicio = maestra2Service.listarPorCodigoTabla("ejercicio",0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
  
		mav.addObject("lstSituacion",lstSituacion);  
		mav.addObject("lstTipo",lstTipo);
		mav.addObject("lstTipoEjercicio",lstTipoEjercicio);
	}
          
	public BonoService getBonoService() {
		return BonoService;
	}

	public void setBonoService(BonoService BonoService) {
		this.BonoService = BonoService;
	}

	
	public BonoBean getBonoBean() {
		return bonoBean;
	}

	public void setBonoBean(BonoBean bonoBean) {
		this.bonoBean = bonoBean;
	}

	public List<BonoBean> getLstBonoBean() {
		return lstBonoBean;
	}

	public void setLstBonoBean(List<BonoBean> lstBonoBean) {
		this.lstBonoBean = lstBonoBean;
	} 

	public List<MaestraBean> getLstSituacion() {
		return lstSituacion;
	} 
	public void setLstSituacion(List<MaestraBean> lstSituacion) {
		this.lstSituacion = lstSituacion;
	}
	
	  
	public List<MaestraBean> getlstTipo() {
		return lstTipo;
	}

	public void setlstTipo(List<MaestraBean> lstlstTipo) {
		this.lstTipo = lstlstTipo;
	}

	public void setValoresPredeterminados(BonoBean bonoBean){
		 bonoBean.setNombre(""); 
		 bonoBean.getSituacion().setCodigoRegistro(0);
	    }

	public List<MaestraBean> getLstTipoEjercicio() {
		return lstTipoEjercicio;
	}

	public void setLstTipoEjercicio(List<MaestraBean> lstTipoEjercicio) {
		this.lstTipoEjercicio = lstTipoEjercicio;
	}

	public BonoBean getBonoBeanFiltro() {
		return bonoBeanFiltro;
	}

	public void setBonoBeanFiltro(BonoBean bonoBeanFiltro) {
		this.bonoBeanFiltro = bonoBeanFiltro;
	} 
	
	
}
