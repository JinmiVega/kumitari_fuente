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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.ModalBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;

@Controller
@Scope(value="session")
@RequestMapping(value = "modalController")
public class ModalController extends BaseController{

	private ModalBean 			modalBean;
	private ModalBean 			modalBeanFilter;
	private ModalBean 			modalBeanTmp;
	private List<ModalBean> 	lstModalBeans;
	private List<MaestraBean>	lstSituacion;
	@Autowired
	private Maestra1Service 	maestra1Service;
	@Autowired
	private PeticionService peticionService;
	
	private String				tmpUrlImagen;
	
	@PostConstruct
	public void init(){
		this.setModalBean(new ModalBean());
		this.setLstModalBeans(new ArrayList<ModalBean>());
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("modalBean") ModalBean modalBean)throws Exception {
		
		ModalBean prmModalBean = new ModalBean(); 
		prmModalBean.setNombre("");  
		prmModalBean.setSituacion(new MaestraBean());
		prmModalBean.getSituacion().setCodigoRegistro(0);
		
		ModelAndView mav = new ModelAndView("configuracion/listado-modal", "command",modalBean);
		mav.addObject("lstModalBeans", new ArrayList<ModalBean>());
		mav.addObject("modalBean", new ModalBean());
		
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscarlistado(@ModelAttribute("modalBean") ModalBean modalBean)
			throws Exception {
//		System.out.println("buscar modal " + modalBean);
		return this.doBuscar(modalBeanFilter);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("modalBean") ModalBean modalBean)
			throws Exception {
//		System.out.println("buscar modal " + modalBean);
		modalBeanFilter = modalBean;
		return this.getListado(modalBean);
	}

	private ModelAndView getListado(ModalBean modalBean) {
		modalBeanFilter = modalBean;
		List<ModalBean> lstModalBean = new ArrayList<ModalBean>();
		try {
			System.out.println("----Entro  lista  modal--");
			lstModalBean = (List<ModalBean>) this.fs.getModalService().getBuscarPorFiltros(modalBean);
			System.out.println("tama�o lst modal bean "+lstModalBean.size());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getLista " + e.getMessage());
		}
	
		ModelAndView mav = new ModelAndView("configuracion/listado-modal", "command",modalBean);
		mav.addObject("lstModalBean", lstModalBean);
		mav.addObject("modalBean", modalBean);
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		modalBean= new ModalBean();
	//	this.setAuditoria(lenguaBean, request, false);
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());

		if(u != null) {
			try { 
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("ModalController/eliminar");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	modalBean.setCodigo(codigo);
		        	sw =  (this.fs.getModalService().eliminar(modalBean));  		        	
		        }
			} catch (Exception e) { 
				e.printStackTrace();
			} 		
			modalBean.setCodigo(0);
			this.setValoresPredeterminados(modalBean);
			ModelAndView mav = this.getLista(modalBean);
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
		modalBeanTmp = null;
		ModelAndView mav = new ModelAndView("configuracion/registro-modal", "command",new ModalBean());
		mav.addObject("ModalBean", new ModalBean());
		this.cargarCombos(mav);
		return mav;
	} 
	
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {
		ModalBean prmModalBean = new ModalBean();
		prmModalBean.setCodigo(codigo); 
		modalBeanTmp = prmModalBean;
		try {
			modalBean = this.fs.getModalService().getBuscarPorObjecto(prmModalBean);
			tmpUrlImagen = modalBean.getImagenNombre();
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
 
		if (modalBean != null ) {
			if ( modalBean.getEstado() != null)   {  
				if (modalBean.getEstado().equals("1") ){
					 System.out.println("entro m");
					ModelAndView mav = new ModelAndView("configuracion/registro-modal", "command", modalBean);  
					this.cargarCombos(mav);
					mav.addObject("modalBean", modalBean);
					return mav;
				}else{
					ModelAndView mav = this.getLista(new ModalBean());
					mav.addObject("swMensaje","0");
					mav.addObject("modalBean",new ModalBean());  
					return mav;
			
				} 
			}else{
				ModelAndView mav = this.getLista(new ModalBean());
				mav.addObject("swMensaje","0");
				mav.addObject("modalBean",new ModalBean());  
				return mav;
			} 
		
		}else { 
			ModelAndView mav = this.getLista(new ModalBean());
			mav.addObject("swMensaje","0");
			mav.addObject("modalBean",new ModalBean());  
			return mav;
		} 
	} 
	

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar() {
		
		if(modalBeanTmp != null){

			ModalBean prmModalBean = new ModalBean();
			prmModalBean.setCodigo(modalBeanTmp.getCodigo()); 
			try {
				modalBean = this.fs.getModalService().getBuscarPorObjecto(prmModalBean);
				tmpUrlImagen = modalBean.getImagenNombre();
			} catch (ServiceException e) { 
				e.printStackTrace();
			}
	 
			if (modalBean != null ) {
				if ( modalBean.getEstado() != null)   {  
					if (modalBean.getEstado().equals("1") ){
						 System.out.println("entro m");
						ModelAndView mav = new ModelAndView("configuracion/registro-modal", "command", modalBean);  
						this.cargarCombos(mav);
						mav.addObject("modalBean", modalBean);
						return mav;
					}else{
						ModelAndView mav = this.getLista(new ModalBean());
						mav.addObject("swMensaje","0");
						mav.addObject("modalBean",new ModalBean());  
						return mav;
				
					} 
				}else{
					ModelAndView mav = this.getLista(new ModalBean());
					mav.addObject("swMensaje","0");
					mav.addObject("modalBean",new ModalBean());  
					return mav;
				} 
			
			}else { 
				ModelAndView mav = this.getLista(new ModalBean());
				mav.addObject("swMensaje","0");
				mav.addObject("modalBean",new ModalBean());  
				return mav;
			} 
		}else{
			ModelAndView mav = this.getLista(new ModalBean());
			mav.addObject("swMensaje","0");
			mav.addObject("modalBean",new ModalBean());  
			return mav;
		}
		
	} 
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("modalBean") ModalBean modalBean,
		@RequestParam("file") MultipartFile[] files,HttpServletRequest request) {
			
		System.out.println("modalBean Grabar"+modalBean);
		System.out.println("modalBean Grabar"+modalBean.getCodigo());
		boolean sw = true;
		boolean swNuevaUrlImagen = false;
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try {
				
				if (files.length>0) {
					swNuevaUrlImagen = (files[0]!=null) && (files[0].getOriginalFilename()!=null ) && (files[0].getOriginalFilename().trim().length()>0 );		
				}
				
				if (swNuevaUrlImagen) {
					modalBean.setFileImagen(files[0]);
			    	if (files[0].getOriginalFilename()!=null) {
			    		modalBean.setImagenNombre(files[0].getOriginalFilename());
			    	}	    					
				}else {				
					modalBean.setImagenNombre(tmpUrlImagen);
				}
				
				modalBean.getNombre().length();
				
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("ModalController/grabar");
				//habilitadoIp = peticionService.existe(prmIntento);
				
		        if(habilitadoIp) {
		        	if(modalBean.getNombre()!=null&&modalBean.getNombre()!="") {
		        		if (modalBean.getCodigo()==0) {
		        			System.out.println("insert ");
		        			sw = (this.fs.getModalService().insertar(modalBean));
		        		} else {
		        			sw = (this.fs.getModalService().actualizar(modalBean));
		        		}		        		
		        	}
		        }else {
		        	System.out.println("--------- IP NO VALIDO ----- ");
		        	
		        }
				
	
			} catch (Exception e) { 
				e.printStackTrace();
			}
	
			if (sw) {
				
				if (swNuevaUrlImagen) {
					super.cargarArchivo(this.getRootPath(), modalBean.getImagenNombre(), modalBean.getFileImagen());    			    	
					tmpUrlImagen = modalBean.getImagenNombre();
				}
				
				modalBean = new ModalBean() ;
				ModelAndView mav = this.getLista(modalBean);
				mav.addObject("swMensaje",sw?"1":"0");
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("configuracion/registro-modal", "command",modalBean);
				mav.addObject("swMensaje",sw?"1":"0");
				mav.addObject("modalBean",modalBean);
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
	
	private String getRootPath() {
		return ResourceUtil.getKey("ruta.natigu.archivos.configuracion.modal");
	}

	private ModelAndView getLista(ModalBean modalBean) {
		List<ModalBean> lstModalBean = new ArrayList<ModalBean>();
		try { 
			lstModalBean = (List<ModalBean>) this.fs.getModalService().getBuscarPorFiltros(modalBean); 
			System.out.println("tama�o lst modal bean "+lstModalBean.size());
		} catch (Exception e) {
			System.out.println("getLista fall�" + e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView("configuracion/listado-modal", "command",modalBean);
		System.out.println("lstModalBean "+lstModalBean);
		mav.addObject("lstModalBean", lstModalBean);
		this.cargarCombos(mav);
		return mav;
	}
	
	private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionModal",0);
				System.out.println("lstSituacion.size() "+ lstSituacion.size());
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		mav.addObject("lstSituacion",lstSituacion); 
	}

	private void setValoresPredeterminados(ModalBean modalBean2) {
	
	}

	public List<ModalBean> getLstModalBeans() {
		return lstModalBeans;
	}
	public void setLstModalBeans(List<ModalBean> lstModalBeans) {
		this.lstModalBeans = lstModalBeans;
	}
	
	public List<MaestraBean> getLstSituacion() {
		return lstSituacion;
	}
	public void setLstSituacion(List<MaestraBean> lstSituacion) {
		this.lstSituacion = lstSituacion;
	}
	
	public String getTmpUrlImagen() {
		return tmpUrlImagen;
	}
	public void setTmpUrlImagen(String tmpUrlImagen) {
		this.tmpUrlImagen = tmpUrlImagen;
	}

	public ModalBean getModalBean() {
		return modalBean;
	}
	public void setModalBean(ModalBean modalBean) {
		this.modalBean = modalBean;
	}

	public ModalBean getModalBeanFilter() {
		return modalBeanFilter;
	}

	public void setModalBeanFilter(ModalBean modalBeanFilter) {
		this.modalBeanFilter = modalBeanFilter;
	}

}