/*package pe.gob.procalidad.natigu.web.gestion.controller.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;

//import pe.gob.procalidad.natigu.core.service.service.interfaces.LenguaService;
  
//import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean; 
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.MascotaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service; 
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
 
@Controller
@Scope(value="session")
@RequestMapping(value = "mascotaController")
public class MascotaController extends BaseController {

	private MascotaBean 		mascotaBean;
	private List<MascotaBean> 	lstMascotaBean;
	
	private List<MaestraBean>	lstSituacion;
	private List<MaestraBean>	lstRegion;
	private List<MaestraBean>	lstPredeterminado;

	@Autowired
	private MascotaService 		mascotaService;
	@Autowired
	private Maestra1Service 	maestra1Service;
	@Autowired
	private Maestra2Service 	maestra2Service;
	
	private String				tmpUrlImagenAlegre;
	private String				tmpUrlImagenTriste;
	private String				tmpUrlImagenExclam;
	private String				tmpUrlImagenNormal;
	
	@PostConstruct
	public void init(){
		this.setMascotaBean(new MascotaBean());
		this.setLstMascotaBean(new ArrayList<MascotaBean>());
	//	this.setLstSituacion(new ArrayList<MaestraBean>());
	} 
	
	public MascotaController (){  
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("mascotaBean") MascotaBean mascotaBean)throws Exception {
		
		MascotaBean prmMascotaBean = new MascotaBean(); 
		prmMascotaBean.setNombre(""); 
		prmMascotaBean.setRegion(new MaestraBean());
		prmMascotaBean.getRegion().setCodigoRegistro(0);
		prmMascotaBean.setSituacion(new MaestraBean());
		prmMascotaBean.getSituacion().setCodigoRegistro(0);
		
		return this.getLista(prmMascotaBean);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("mascotaBean") MascotaBean mascotaBean)
			throws Exception {
		System.out.println("buscar lengua " + mascotaBean);
		return this.getLista(mascotaBean);
	}
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		mascotaBean= new MascotaBean();
		mascotaBean.setCodigo(codigo);
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
				sw =  (this.getMascotaService().eliminar(mascotaBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		
		mascotaBean.setCodigo(0);
		this.setValoresPredeterminados(mascotaBean);
		ModelAndView mav = this.getLista(mascotaBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("configuracion/registro-mascota", "command",new MascotaBean());
		mav.addObject("MascotaBean", new MascotaBean());
		this.cargarCombos(mav);
		return mav;
	} 
	
	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {

		System.out.println("modificar codigo: " + codigo);

		MascotaBean prmMascotaBean = new MascotaBean();
		prmMascotaBean.setCodigo(codigo); 
		try {
			mascotaBean = this.getMascotaService().getBuscarPorObjecto(prmMascotaBean);
			
			if(!VO.isNull(mascotaBean)){
				tmpUrlImagenAlegre = mascotaBean.getImagenAlegre();
				tmpUrlImagenTriste = mascotaBean.getImagenTriste();
				tmpUrlImagenExclam = mascotaBean.getImagenExclamativa();
				tmpUrlImagenNormal = mascotaBean.getImagenNormal();
			}
			
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		System.out.println("modificar mascotaBean: " + mascotaBean);
		ModelAndView mav = new ModelAndView("configuracion/registro-mascota", "command", mascotaBean);
		mav.addObject("mascotaBean", mascotaBean);
	//	mav.addObject("idUsuario",usuarioBean.getCodigo());	
		this.cargarCombos(mav);	
		return mav;
	}
	

	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("mascotaBean") MascotaBean mascotaBean,
								 @RequestParam("file") MultipartFile[] files,
								 HttpServletRequest request) {
		
		System.out.println("mascotaBean Grabar"+mascotaBean);
		System.out.println("mascotaBean Grabar"+mascotaBean.getCodigo());
		boolean sw = false;
		boolean swNuevaUrlImagen = false;
		try {
			if (files.length>0) {
				for (int i = 0; i < files.length; i++) {
					System.out.println("file"+(i+1)+" :"+files[i].getOriginalFilename());
					swNuevaUrlImagen = (files[i]!=null) && (files[i].getOriginalFilename()!=null ) && (files[i].getOriginalFilename().trim().length()>0 );
					String nombreImagen = null;
					MultipartFile fileImagen = null;
					if (swNuevaUrlImagen) {
						fileImagen = files[i];
				    	if (files[i].getOriginalFilename()!=null) {
				    		nombreImagen = files[i].getOriginalFilename();
				    	}	    					
					}
					
					switch (i) {
						case 0: mascotaBean.setImagenAlegre(nombreImagen!=null ? nombreImagen : tmpUrlImagenAlegre);
								break;
						case 1: mascotaBean.setImagenTriste(nombreImagen!=null ? nombreImagen : tmpUrlImagenTriste);
								break;
						case 2: mascotaBean.setImagenExclamativa(nombreImagen!=null ? nombreImagen : tmpUrlImagenExclam);
								break;
						case 3: mascotaBean.setImagenNormal(nombreImagen!=null ? nombreImagen : tmpUrlImagenNormal);
								break;
						default:
							break;
					}
				}
			}
			
			if (mascotaBean.getCodigo()==0) {
				sw =  (this.getMascotaService().insertar(mascotaBean)); 
			} else {
				sw = (this.getMascotaService().actualizar(mascotaBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			
			if (files.length>0) {
				for (int i = 0; i < files.length; i++) {
					swNuevaUrlImagen = (files[i]!=null) && (files[i].getOriginalFilename()!=null ) && (files[i].getOriginalFilename().trim().length()>0 );
					String nombreImagen = "";
					MultipartFile fileImagen = null;
					if (swNuevaUrlImagen) {
						fileImagen = files[i];
				    	if (files[i].getOriginalFilename()!=null) {
				    		nombreImagen = files[i].getOriginalFilename();
				    	}
				    	
				    	switch (i) {
							case 0: tmpUrlImagenAlegre = nombreImagen;
									break;
							case 1: tmpUrlImagenTriste = nombreImagen;
									break;
							case 2: tmpUrlImagenExclam = nombreImagen;
									break;
							case 3: tmpUrlImagenNormal = nombreImagen;
									break;
							default:
								break;
						}
				    	
				    	super.cargarArchivo(this.getRootPath(), mascotaBean.getCodigo()+"_"+nombreImagen, fileImagen);//, mascotaBean.getFileImagen());
					}
				}
			}
			
			mascotaBean = new MascotaBean() ;
			ModelAndView mav = this.getLista(mascotaBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("configuracion/listado-mascota", "command",mascotaBean);
			mav.addObject("swMensaje",sw?"1":"0");
			return mav;
		}

	}
	
	private String getRootPath() {    	
		return ResourceUtil.getKey("ruta.natigu.archivos.configuracion.mascota");
     }

	private ModelAndView getLista(MascotaBean mascotaBean) {
		
		List<MascotaBean> lstMascotaBean = new ArrayList<MascotaBean>();
		try { 
			lstMascotaBean = (List<MascotaBean>) this.getMascotaService().getBuscarPorFiltros(mascotaBean); 
			System.out.println("tamaño lst mascota bean "+lstMascotaBean.size());
		} catch (Exception e) {
			System.out.println("getLista falló" + e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView("configuracion/listado-mascota", "command",mascotaBean);
		System.out.println("lstMascotaBean "+lstMascotaBean);
		mav.addObject("lstMascotaBean", lstMascotaBean);
		this.cargarCombos(mav);
		return mav;
	}
		private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionMascota");
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
		if (lstRegion==null) {
			try {
				lstRegion = maestra2Service.listarPorCodigoTabla("region");
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
		
		if (lstPredeterminado==null) {
			try {
				lstPredeterminado = maestra2Service.listarPorCodigoTabla("predeterminado");
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
  
		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstRegion",lstRegion);
		mav.addObject("lstPredeterminado",lstPredeterminado);
	}
          
	public MascotaService getMascotaService() {
		return mascotaService;
	}

	public void setMascotaService(MascotaService mascotaService) {
		this.mascotaService = mascotaService;
	}

	
	public MascotaBean getMascotaBean() {
		return mascotaBean;
	}

	public void setMascotaBean(MascotaBean mascotaBean) {
		this.mascotaBean = mascotaBean;
	}

	public List<MascotaBean> getLstMascotaBean() {
		return lstMascotaBean;
	}

	public void setLstMascotaBean(List<MascotaBean> lstMascotaBean) {
		this.lstMascotaBean = lstMascotaBean;
	} 

	public List<MaestraBean> getLstSituacion() {
		return lstSituacion;
	} 
	public void setLstSituacion(List<MaestraBean> lstSituacion) {
		this.lstSituacion = lstSituacion;
	}
	
	 public List<MaestraBean> getLstRegion() {
		return lstRegion;
	}

	public void setLstRegion(List<MaestraBean> lstRegion) {
		this.lstRegion = lstRegion;
	} 

	public List<MaestraBean> getLstPredeterminado() {
		return lstPredeterminado;
	}

	public void setLstPredeterminado(List<MaestraBean> lstPredeterminado) {
		this.lstPredeterminado = lstPredeterminado;
	}

	public void setValoresPredeterminados(MascotaBean mascotaBean){
		 mascotaBean.setNombre(""); 
		 mascotaBean.getSituacion().setCodigoRegistro(0);
	    } 
}
*/