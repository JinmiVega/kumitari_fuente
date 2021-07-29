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

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.MascotaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra2Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;

@Controller
@Scope(value = "session")
@RequestMapping(value = "tmaestraController")
public class TmaestraController extends BaseController {

	private MaestraBean maestraBean;
	private MaestraBean maestraBeanFiltro;
	private MaestraBean maestraBeanTmp;
	private List<MaestraBean> lstMaestraBean;
	private List<MaestraBean> lstGeneral;

	@Autowired
	private Maestra1Service maestra1Service;
	@Autowired
	private Maestra2Service maestra2Service;
	@Autowired
	private PeticionService peticionService;
	
	private String tmpUrlImagen;
	private String tmpUrlImagen1;
	private String tmpUrlImagen2;

	@PostConstruct
	public void init() {
		this.setMaestraBean(new MaestraBean());
		this.setLstMaestraBean(new ArrayList<MaestraBean>());
	}

	public TmaestraController() {
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("maestraBean") MaestraBean maestraBean) throws Exception {

		MaestraBean prmMaestraBean = new MaestraBean();
		prmMaestraBean.setNombreCorto("");
		prmMaestraBean.setCodigoTabla("");
		// return this.getLista(prmMaestraBean);
		ModelAndView mav = new ModelAndView("configuracion/listado-tabla-maestra", "command", maestraBean);

		mav.addObject("lstMaestraBean", new ArrayList<MaestraBean>());
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscar(@ModelAttribute("maestraBean") MaestraBean maestraBean) throws Exception {
//		System.out.println("buscar maestraBean " + maestraBean);
		return this.doBuscarListado(maestraBeanFiltro);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscarListado(@ModelAttribute("maestraBean") MaestraBean maestraBean) throws Exception {
//		System.out.println("buscar maestraBean " + maestraBean);
		maestraBeanFiltro = maestraBean;
		return this.getLista(maestraBean);
	}

//	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
//	public ModelAndView doBuscar1(@ModelAttribute("maestraBean") MaestraBean maestraBean) throws Exception {
//		System.out.println("buscar maestraBean " + maestraBean);
//		return doListado(maestraBean);
//	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		maestraBeanTmp = null;
		MaestraBean prmMaestraBean = new MaestraBean();
		prmMaestraBean.setCodigoRegistro(0);
		ModelAndView mav = new ModelAndView("configuracion/registro-tabla-maestra", "command", prmMaestraBean);
		mav.addObject("maestraBean", prmMaestraBean);
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("p_codtabla") String p_codtabla,
			@RequestParam("p_codregis") Integer p_codregis, HttpServletRequest request) {
		boolean sw = false;
		maestraBean = new MaestraBean();
		// this.setAuditoria(tmaestraBean, request, false);
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("TmaestraController/eliminar");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	
		        	maestraBean.setCodigoTabla(p_codtabla);
		        	maestraBean.setCodigoRegistro(p_codregis);
		        	sw = (this.getMaestra1Service().eliminar(maestraBean));
		        }
	
			} catch (Exception e) {
				e.printStackTrace();
			}
			maestraBean.setCodigoRegistro(0);
			maestraBean.setId(0);
			maestraBean.setCodigoTabla("");
			this.setValoresPredeterminados(maestraBean);
			ModelAndView mav = this.getLista(maestraBean);
			mav.addObject("swMensaje", sw ? "1" : "0");
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

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar() {
		
		if(maestraBeanTmp != null){

			MaestraBean prmMaestraBean = new MaestraBean();
			prmMaestraBean.setCodigoTabla(maestraBeanTmp.getCodigoTabla());
			prmMaestraBean.setCodigoRegistro(maestraBeanTmp.getCodigoRegistro());
			prmMaestraBean.setId(0);
			try {
				maestraBean = this.getMaestra1Service().getBuscarPorTablaYRegistro(prmMaestraBean);
				// maestraBean.getEstado()!='0';
				System.out.println("llego" + maestraBean.getFileimg());
			} catch (ServiceException e) {
				e.printStackTrace();
			}

			// ModelAndView mav = new
			// ModelAndView("configuracion/registro-tabla-maestra", "command",
			// maestraBean);
			// this.cargarCombos(mav);
			// mav.addObject("maestraBean", maestraBean);
			// return mav;
			if (maestraBean != null) {
				if ((maestraBean.getEstado() != null) && (maestraBean.getEditable() != null)) {
					if (maestraBean.getEstado().equals("1") && (maestraBean.getEditable().equals("1"))) {

						ModelAndView mav = new ModelAndView("configuracion/registro-tabla-maestra", "command", maestraBean);
						this.cargarCombos(mav);
						mav.addObject("maestraBean", maestraBean);
						return mav;
					} else {
						ModelAndView mav = this.getLista(new MaestraBean());
						mav.addObject("swMensaje", "0");
						mav.addObject("maestraBean", new MaestraBean());
						return mav;

					}
				} else {
					ModelAndView mav = this.getLista(new MaestraBean());
					mav.addObject("swMensaje", "0");
					mav.addObject("maestraBean", new MaestraBean());
					return mav;
				}

			} else {
				ModelAndView mav = this.getLista(new MaestraBean());
				mav.addObject("swMensaje", "0");
				mav.addObject("maestraBean", new MaestraBean());
				return mav;
			}
		}else{
			ModelAndView mav = this.getLista(new MaestraBean());
			mav.addObject("swMensaje", "0");
			mav.addObject("maestraBean", new MaestraBean());
			return mav;
		}
		
	}
	
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doModificar(@RequestParam("p_codtabla") String p_codtabla,
			@RequestParam("p_codregis") Integer p_codregis) {

		MaestraBean prmMaestraBean = new MaestraBean();
		prmMaestraBean.setCodigoTabla(p_codtabla);
		prmMaestraBean.setCodigoRegistro(p_codregis);
		prmMaestraBean.setId(0);
		maestraBeanTmp = prmMaestraBean;
		try {
			maestraBean = this.getMaestra1Service().getBuscarPorTablaYRegistro(prmMaestraBean);
			// maestraBean.getEstado()!='0';
			System.out.println("llego" + maestraBean.getFileimg());
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		// ModelAndView mav = new
		// ModelAndView("configuracion/registro-tabla-maestra", "command",
		// maestraBean);
		// this.cargarCombos(mav);
		// mav.addObject("maestraBean", maestraBean);
		// return mav;
		if (maestraBean != null) {
			if ((maestraBean.getEstado() != null) && (maestraBean.getEditable() != null)) {
				if (maestraBean.getEstado().equals("1") && (maestraBean.getEditable().equals("1"))) {

					ModelAndView mav = new ModelAndView("configuracion/registro-tabla-maestra", "command", maestraBean);
					this.cargarCombos(mav);
					mav.addObject("maestraBean", maestraBean);
					return mav;
				} else {
					ModelAndView mav = this.getLista(new MaestraBean());
					mav.addObject("swMensaje", "0");
					mav.addObject("maestraBean", new MaestraBean());
					return mav;

				}
			} else {
				ModelAndView mav = this.getLista(new MaestraBean());
				mav.addObject("swMensaje", "0");
				mav.addObject("maestraBean", new MaestraBean());
				return mav;
			}

		} else {
			ModelAndView mav = this.getLista(new MaestraBean());
			mav.addObject("swMensaje", "0");
			mav.addObject("maestraBean", new MaestraBean());
			return mav;
		}
	}
	

	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("maestraBean") MaestraBean maestraBean,
			@RequestParam("file") MultipartFile[] file,
			@RequestParam("file1") MultipartFile[] file1,
			@RequestParam("file2") MultipartFile[] file2, HttpServletRequest request) {

		System.out.println(" Bean Grabar" + maestraBean);
		System.out.println(" Bean Grabar" + maestraBean.getCodigoRegistro());
		System.out.println(" Bean Grabar" + maestraBean.getCodigoTabla());
		System.out.println("maestraBean.getFile().getName() " + maestraBean.getFile().getName());
		boolean sw = false;
		boolean swNuevaUrlImagen = false;
		boolean swNuevaUrlImagen1 = false;
		boolean swNuevaUrlImagen2 = false;

		if (file.length > 0 ) {
			swNuevaUrlImagen = (file[0] != null) && (file[0].getOriginalFilename() != null)
					&& (file[0].getOriginalFilename().trim().length() > 0);		
		}
		
		if (file1.length > 0) {
			swNuevaUrlImagen1 = (file1[0] != null) && (file1[0].getOriginalFilename() != null)
					&& (file1[0].getOriginalFilename().trim().length() > 0);
		}
		
		if (file2.length > 0) {
			swNuevaUrlImagen2 = (file2[0] != null) && (file2[0].getOriginalFilename() != null)
					&& (file2[0].getOriginalFilename().trim().length() > 0);
		}
 
			// maestraBean.setFileimg(maestraBean.getFile().getOriginalFilename());
			if (swNuevaUrlImagen && swNuevaUrlImagen1 && swNuevaUrlImagen2) {
				maestraBean.setFile(file[0]);
				maestraBean.setFile1(file1[0]);
				maestraBean.setFile2(file2[0]);
				if (file[0].getOriginalFilename() != null) {
					maestraBean.setFileimg(file[0].getOriginalFilename());

				}
				if (file1[0].getOriginalFilename() != null) {
					maestraBean.setValor1(file1[0].getOriginalFilename());

				}
				if (file2[0].getOriginalFilename() != null) {
					maestraBean.setValor2(file2[0].getOriginalFilename());

				}

			} else {
				maestraBean.setFileimg("");
//				maestraBean.setValor1("");
//				maestraBean.setValor2("");
			}

			//if (maestraBean.getFileimg() != "") {
				try {
					//ip
					boolean habilitadoIp = true;
					PeticionBean prmIntento = new PeticionBean();
					prmIntento.setIpConexion(request.getRemoteAddr());
					prmIntento.setUrlPeticion("TmaestraController/grabar");
					habilitadoIp = peticionService.existe(prmIntento);
			        if(habilitadoIp) {
			        	if(maestraBean.getNombreCorto()!=null&&maestraBean.getNombreCorto()!="") {
			        		if (maestraBean.getCodigoRegistro() == 0) {
			        			System.out.println("inserta con imagen ");
			        			sw = (this.getMaestra1Service().insertar(maestraBean));
			        		} else {
			        			sw = (this.getMaestra1Service().actualizar(maestraBean));
			        		}			        				        		
			        	}
			        }

				} catch (Exception e) {
					e.printStackTrace();
				}

			//}

			/*} else {
			try {
				if (maestraBean.getCodigoRegistro() == 0) {
					System.out.println("inserta sin imagen ");
					sw = (this.getMaestra1Service().insertar(maestraBean));

				} else {
					sw = (this.getMaestra1Service().actualizar(maestraBean));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
*/
		if (swNuevaUrlImagen) {
			super.cargarArchivo(this.getRootPath(), maestraBean.getFileimg(), maestraBean.getFile());
			tmpUrlImagen = maestraBean.getFileimg();
		}
		
		if (swNuevaUrlImagen1) {
			super.cargarArchivo(this.getRootPath(), maestraBean.getValor1(), maestraBean.getFile1());
			tmpUrlImagen1 = maestraBean.getValor1();
		}
		
		if (swNuevaUrlImagen2) {
			super.cargarArchivo(this.getRootPath(), maestraBean.getValor2(), maestraBean.getFile2());
			tmpUrlImagen2 = maestraBean.getValor2();
		}

		if (sw) {
			maestraBean = new MaestraBean();
			ModelAndView mav = this.getLista(maestraBean);
			mav.addObject("swMensaje", sw ? "1" : "0");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("configuracion/registro-tabla-maestra", "command", maestraBean);
			mav.addObject("swMensaje", sw ? "1" : "0");
			mav.addObject("maestraBean", maestraBean);
			this.cargarCombos(mav);
			return mav;
		}

	}

	// @RequestMapping(value = "/grabarImagen", method = RequestMethod.POST)
	// public ModelAndView doGrabarImagen(@ModelAttribute("maestraBean")
	// MaestraBean maestraBean,
	// @RequestParam("file") MultipartFile[] file)
	// {
	//
	// System.out.println(" Bean Grabar"+maestraBean);
	// System.out.println(" Bean Grabar"+maestraBean.getCodigoRegistro());
	// System.out.println(" Bean Grabar"+maestraBean.getCodigoTabla());
	// boolean sw = true;
	//
	//
	// try {
	//
	// if (file.length>0) {
	// swNuevaUrlImagen = (file[0]!=null) &&
	// (file[0].getOriginalFilename()!=null ) &&
	// (file[0].getOriginalFilename().trim().length()>0 );
	// }
	//
	//
	//
	// if (swNuevaUrlImagen) {
	// maestraBean.setFile(file[0]);
	// if (file[0].getOriginalFilename()!=null) {
	// maestraBean.setFileimg(file[0].getOriginalFilename());
	//
	//
	// }
	// }else {
	// maestraBean.setFileimg(tmpUrlImagen);
	// }
	//
	//
	// if (maestraBean.getCodigo()==0) {
	// System.out.println("insert ");
	// sw = (this.getMaestra1Service().insertar(maestraBean));
	// } else {
	// sw = (this.getMaestra1Service().actualizar(maestraBean));
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// if (sw) {
	//
	// if (swNuevaUrlImagen) {
	// super.cargarArchivo(this.getRootPath(), maestraBean.getFileimg(),
	// maestraBean.getFile());
	// tmpUrlImagen = maestraBean.getFileimg();
	// }
	//
	// maestraBean = new MaestraBean() ;
	// ModelAndView mav = this.getLista(maestraBean);
	// mav.addObject("swMensaje",sw?"1":"0");
	// return mav;
	// } else {
	// ModelAndView mav = new ModelAndView("configuracion/registro-fondo",
	// "command",maestraBean);
	// mav.addObject("swMensaje",sw?"1":"0");
	// mav.addObject("fondoBean",maestraBean);
	// this.cargarCombos(mav);
	// return mav;
	// }
	//
	//
	// }

	private ModelAndView getLista(MaestraBean maestraBean) {

		List<MaestraBean> lstMaestraBean = new ArrayList<MaestraBean>();
		try {
			lstMaestraBean = (List<MaestraBean>) this.getMaestra1Service().getBuscarPorFiltros(maestraBean);
			System.out.println("tama�o lst mascota bean " + lstMaestraBean.size());
		} catch (Exception e) {
			System.out.println("getLista fall�" + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("configuracion/listado-tabla-maestra", "command", maestraBean);
		System.out.println("lstMaestraBean " + lstMaestraBean);
		mav.addObject("lstMaestraBean", lstMaestraBean);
		this.cargarCombos(mav);
		return mav;
	}

	private String getRootPath() {
		return ResourceUtil.getKey("ruta.natigu.archivos.configuracion.maestra");
	}

	public Maestra1Service getMaestra1Service() {
		return maestra1Service;
	}

	public void setMaestra1Service(Maestra1Service maestra1Service) {
		this.maestra1Service = maestra1Service;
	}

	private void cargarCombos(ModelAndView mav) {

		if (lstGeneral == null) {
			try {
				lstGeneral = maestra1Service.listarComboGeneral("7");
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}
		}
		mav.addObject("lstGeneral", lstGeneral);
	}

	public MaestraBean getMaestraBean() {
		return maestraBean;
	}

	public void setMaestraBean(MaestraBean maestraBean) {
		this.maestraBean = maestraBean;
	}

	public List<MaestraBean> getLstMaestraBean() {
		return lstMaestraBean;
	}

	public void setLstMaestraBean(List<MaestraBean> lstMaestraBean) {
		this.lstMaestraBean = lstMaestraBean;
	}

	public Maestra2Service getMaestra2Service() {
		return maestra2Service;
	}

	public void setMaestra2Service(Maestra2Service maestra2Service) {
		this.maestra2Service = maestra2Service;
	}

	public String getTmpUrlImagen() {
		return tmpUrlImagen;
	}

	public void setTmpUrlImagen(String tmpUrlImagen) {
		this.tmpUrlImagen = tmpUrlImagen;
	}

	public List<MaestraBean> getLstGeneral() {
		return lstGeneral;
	}

	public void setLstGeneral(List<MaestraBean> lstGeneral) {
		this.lstGeneral = lstGeneral;
	}

	public void setValoresPredeterminados(MaestraBean maestraBean) {
		maestraBean.setCodigoTabla("");
		maestraBean.setCodigoRegistro(0);
	}

	public MaestraBean getMaestraBeanFiltro() {
		return maestraBeanFiltro;
	}

	public void setMaestraBeanFiltro(MaestraBean maestraBeanFiltro) {
		this.maestraBeanFiltro = maestraBeanFiltro;
	}

}
