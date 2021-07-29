package pe.gob.procalidad.natigu.web.gestion.controller.general;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.io.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.internal.libraries.asm.tree.IntInsnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionDirectorBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionLenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionOperadorBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.InstitucionSedeBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PersonaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UbigeoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token.leerToken;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionDirectorService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionLenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionOperadorService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionSedeService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.InstitucionService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.LenguaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.PersonaService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.UbigeoService;
import pe.gob.procalidad.natigu.core.service.service.interfaces.seguridad.PeticionService;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.controller.general.view.InstitucionForm;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.CodeUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ValidatorField;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.acceso.LoginVo;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.EncryptHability;

@Controller
@Scope(value = "session")
@RequestMapping(value = "institucionController")
public class InstitucionController extends BaseController {

	private InstitucionForm institucionForm;
	private InstitucionBean institucionBean;
	private InstitucionBean institucionBeanTmp;
	private List<MaestraBean> lstTipo;
	private List<MaestraBean> lstTipoActividad;
	private List<MaestraBean> lstSituacion;

	private InstitucionDirectorBean institucionDirectorBean;
	private InstitucionOperadorBean institucionOperadorBean;

	private List<MaestraBean> lstTipoDocumento;
	private List<InstitucionDirectorBean> lstInstitucionDirectorBean;
	private List<InstitucionOperadorBean> lstInstitucionOperadorBean;
	int codigo = 0;
	private UbigeoBean ubigeoBean;
	private List<UbigeoBean> lstRegion;
	private List<UbigeoBean> lstProvincia;
	private List<UbigeoBean> lstDistrito;

	private List<MaestraBean> lstAreaGeografica;

	private LenguaBean lenguaBean;
	private List<LenguaBean> lstLengua;
	
	private InstitucionLenguaBean institucionLenguaBean;
	
	private List<InstitucionLenguaBean> lstInstitucionLenguaBean;
	
	
	
	@Autowired
	private Maestra1Service maestra1Service;

	@Autowired
	private InstitucionService institucionService;

	@Autowired
	private UbigeoService ubigeoService;

	@Autowired
	private InstitucionDirectorService institucionDirectorService;
 
	@Autowired
	private InstitucionOperadorService institucionOperadorService;

	private InstitucionSedeBean institucionSedeBean;
	private List<InstitucionSedeBean> lstInstitucionSede;
	@Autowired
	private InstitucionSedeService institucionSedeService;
	
	@Autowired
	private LenguaService lenguaService;
	
	@Autowired
	private InstitucionLenguaService institucionLenguaService;
	

	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private PeticionService peticionService;

	@PostConstruct
	public void init() {
		this.setInstitucionBean(new InstitucionBean());
		this.setLenguaBean(new LenguaBean());
		this.setInstitucionForm(new InstitucionForm());
		this.setInstitucionSedeBean(new InstitucionSedeBean());
		this.setLstInstitucionSede(new ArrayList<InstitucionSedeBean>());
		this.setInstitucionLenguaBean(new InstitucionLenguaBean());
		this.setLstInstitucionDirectorBean(new ArrayList<InstitucionDirectorBean>());
		this.setLstInstitucionOperadorBean(new ArrayList<InstitucionOperadorBean>());
		this.setLstInstitucionLenguaBean(new ArrayList<InstitucionLenguaBean>());

	}

	public InstitucionController() {

	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("institucionBean") InstitucionBean institucionBean)throws Exception {
		System.out.println("----Ingreso al listado----");
		System.out.println("institucionBean"+institucionBean);
		ModelAndView mav = new ModelAndView("general/institucion/listado-institucion", "command",institucionBean);
		mav.addObject("lstInstitucionBean", new ArrayList<InstitucionBean>());
		mav.addObject("institucionBean", institucionBean);
		this.listarCombos(mav,1);
		return mav;
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("institucionBean") InstitucionBean institucionBean)
			throws Exception {
		
		System.out.println("-----Ingreso a  buscar-----");
		
		System.out.println("institucionBean.getNombreInstitucion()"+
				institucionBean.getNombreInstitucion());
		System.out.println("institucionBean.getUbigeoBean().getNombreUbigeo()"+
				institucionBean.getUbigeoBean().getCodigoRegion());
		System.out.println("institucionBean.getTipoInstitucion().getCodigoRegistro()"+
				institucionBean.getTipoInstitucion().getCodigoRegistro());
		System.out.println("institucionBean.getSituacion().getCodigoRegistro()"+
				institucionBean.getSituacion().getCodigoRegistro());
		
		return this.getLista(institucionBean);
	}
//	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
//	public ModelAndView doBuscarListado(@ModelAttribute("institucionBean") InstitucionBean institucionBean)
//			throws Exception {
//		return this.getLista(institucionBean);
//	}
	
	private ModelAndView getLista(InstitucionBean institucionBean) {
		if(institucionBean.getNombreInstitucion()!=null){
			institucionBean.setNombreInstitucion(VO.convertirCaracteresEsp(institucionBean.getNombreInstitucion()));			
		}
		
		List<InstitucionBean> lstInstitucionBean = new ArrayList<InstitucionBean>();
		
		try {
			lstInstitucionBean = (List<InstitucionBean>) this.getInstitucionService().getBuscarPorFiltros(institucionBean);
			
			if (lstInstitucionBean != null && lstInstitucionBean.size()> 0 ) {
				System.out.println("lstInstitucionBean.size() : " + lstInstitucionBean.size());
			}else{
				lstInstitucionBean = new ArrayList<InstitucionBean>();
			}
 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("general/institucion/listado-institucion", "command",institucionBean);
		System.out.println("lstInstitucionBean"+lstInstitucionBean);
		mav.addObject("lstInstitucionBean", lstInstitucionBean);
		mav.addObject("institucionBean", institucionBean);
		this.listarCombos(mav,1);
        
		return mav;
	}

	@RequestMapping(value = "/modificarUbicacion", method = RequestMethod.POST)
	public @ResponseBody String actulizarUbicacion(@ModelAttribute("institucionForm") InstitucionForm institucionForm , HttpServletRequest request)throws Exception {		
		
		institucionForm.getInstitucionBean().getUbigeoBean().setCodigoUbigeo(institucionForm.getInstitucionBean().getUbigeoBean().getCodigoRegion()+
				institucionForm.getInstitucionBean().getUbigeoBean().getCodigoProvincia()+
				institucionForm.getInstitucionBean().getUbigeoBean().getCodigoDistrito());
		System.out.println("institucionBean.getUbigeoBean().getCodigoUbigeo() ::" +institucionBean.getUbigeoBean().getCodigoUbigeo());
		System.out.println("institucionForm.getInstitucionBean().getCodigo()"+institucionForm.getInstitucionBean().getCodigo());
		
		boolean sw = false;
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("InstitucionController/modificarUbicacion");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	if(institucionForm.getInstitucionBean().getDireccionInstitucion()!=null&&institucionForm.getInstitucionBean().getDireccionInstitucion()!="") {
	        		if (institucionForm.getInstitucionBean().getCodigo()>0) {
	        			
	        			this.setAuditoria(institucionForm.getInstitucionBean(), request, false);
	        			sw = (institucionService.actulizarUbicacion(institucionForm.getInstitucionBean()));			
	        			System.out.println("Paso  modificar ubicacion");			
	        		}else{
	        			System.out.println("no ingreso a  actulizar ubicacion");		
	        		}	        		
	        	}
	        	
	        }
		
			if (sw) {
				return "1";
			}else{
				return "0";
			}
			
		} catch (ServiceException e) { 
			e.printStackTrace();
			return "0";
		}
	}

	@RequestMapping(value = "/insertarDirector", method = RequestMethod.POST)
	public @ResponseBody String insertarDirector(@ModelAttribute("institucionForm") InstitucionForm institucionForm,HttpServletRequest request)throws Exception {	
		
		System.out.println("insertar instiucionDirector Grabar"+institucionForm.getInstitucionDirectorBean().getCodigo());
		System.out.println("codigo institucion :"+institucionForm.getInstitucionDirectorBean().getInstitucion().getCodigo());
		System.out.println("codigo persona :"+institucionForm.getInstitucionDirectorBean().getPersonaBean().getCodigo());

		System.out.println("institucionForm  ::: " + institucionForm);
		InstitucionDirectorBean oInstitucionDirectorBean = new InstitucionDirectorBean();
		oInstitucionDirectorBean = institucionForm.getInstitucionDirectorBean();
		
		boolean sw = false;
		String valor = "";
		
		try {
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("InstitucionController/insertarDirector");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	
		        	if(institucionForm.getInstitucionDirectorBean().getTelefono()!=null&&institucionForm.getInstitucionDirectorBean().getTelefono()!="" &&
		        	institucionForm.getInstitucionDirectorBean().getCorreo()!=null&&institucionForm.getInstitucionDirectorBean().getCorreo()!="") {
		        		if (institucionForm.getInstitucionDirectorBean().getPersonaBean().getCodigo() == 0) {
		        			valor = "3";
		        		}else{
		        			
		        			if (institucionForm.getInstitucionDirectorBean().getCodigo()==0) {
		        				
		        				//inserto a  un director
		        				this.setAuditoria(oInstitucionDirectorBean, request, true);
		        				System.out.println("inserta "+institucionForm.getInstitucionDirectorBean());
		        				sw =  (institucionDirectorService.insertar(oInstitucionDirectorBean)); 
		        				
		        			} else {
		        				//modificar director
		        				System.out.println("actualizar "+institucionForm.getInstitucionDirectorBean());
		        				this.setAuditoria(institucionForm.getInstitucionDirectorBean(), request, false);
		        				sw =  (institucionDirectorService.actualizar(institucionForm.getInstitucionDirectorBean())); 
		        			}
		        		}		        		
		        	}
		        	
		        }
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			System.out.println("sw"+ sw);
			if (sw) {	
				valor =  "1";
			}else{
				valor = "0";
			}

		} catch (Exception e) { 
			e.printStackTrace();
			valor = "0" ;
		}
		return valor;
	}
	
	@RequestMapping(value = "/refrescarListaInstDirector", method = RequestMethod.GET)
	public @ResponseBody List<InstitucionDirectorBean> refrescarListaInstDirector(@RequestParam("codigoInst") String codigoInst)throws Exception {		
		System.out.println("refrescarListaInstDirector " + codigoInst);
		List<InstitucionDirectorBean> listaInstitucionDirectorBean = new ArrayList<InstitucionDirectorBean>();
		try {
			InstitucionDirectorBean oInstitucionDirectorBean = new InstitucionDirectorBean();
			oInstitucionDirectorBean.getInstitucion().setCodigo(VO.toLong(codigoInst));
			listaInstitucionDirectorBean =  institucionDirectorService.getBuscarPorFiltros(oInstitucionDirectorBean);
			
			if (!VO.isEmptyList(listaInstitucionDirectorBean)) {
				System.out.println("listaInstitucionDirectorBean.size not null " + listaInstitucionDirectorBean.size());
				return listaInstitucionDirectorBean;
			}else{
				System.out.println("listaInstitucionDirectorBean no trae datos");
				return new ArrayList<InstitucionDirectorBean>();
			}

		} catch (Exception e) { 
			e.printStackTrace();
			return new ArrayList<InstitucionDirectorBean>();
		}
	}
	
	@RequestMapping(value = "/modificarDirector", method = RequestMethod.POST)
	public @ResponseBody InstitucionDirectorBean modificarDirector(@RequestParam("codigo") Integer codigo ,HttpServletRequest request) {

		System.out.println("modificar codigo director: " + codigo);

		InstitucionDirectorBean prmInstitucionDirectorBean = new InstitucionDirectorBean();
		prmInstitucionDirectorBean.setCodigo(codigo); 
		try {
			institucionDirectorBean =institucionDirectorService.getBuscarPorObjecto(prmInstitucionDirectorBean); 
			System.out.println("institucionDirectorBean situacion " + institucionDirectorBean.getSituacionDirector().getCodigoRegistro());
			institucionForm.setInstitucionDirectorBean(institucionDirectorBean);
			
			
		} catch (ServiceException e) { 
			e.printStackTrace();
		} 
		
		if (institucionDirectorBean!= null ) {
			System.out.println("institucionDirectorBean no es null " + institucionDirectorBean.getCodigo());
			return institucionDirectorBean;
		}else{
			System.out.println("institucionDirectorBean es null" );
			return null;
		} 
	}
	
	/***
	@RequestMapping(value = "/modificarDirector", method = RequestMethod.GET)
	public ModelAndView modificarDirector(@RequestParam("codigo") Integer codigo) {

		System.out.println("modificar codigo director: " + codigo);

		InstitucionDirectorBean prmInstitucionDirectorBean = new InstitucionDirectorBean();
		prmInstitucionDirectorBean.setCodigo(codigo); 
		try {
			//Busca  por  codigo director  para  tener  la  data de ese director
			
			institucionDirectorBean =institucionDirectorService.getBuscarPorObjecto(prmInstitucionDirectorBean);			
			//institucionForm.setInstitucionBean(institucionBean);
			System.out.println("institucionDirectorBean.getCodigo() codigo director :"+institucionDirectorBean.getCodigo());
			institucionForm.setInstitucionDirectorBean(institucionDirectorBean);
		  
			
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
//		try {
////			InstitucionBean oInstitucionBean= new InstitucionBean(); 
////			oInstitucionBean.set
//			//lista por codigo de  institucion
//			
//			lstInstitucionDirectorBean =  institucionDirectorService.getBuscarPorFiltros(prmInstitucionDirectorBean);
//		} catch (ServiceException e) { 
//			e.printStackTrace();
//		}	
			
		System.out.println("modificar institucionBean: " + institucionBean);
		ModelAndView mav = new ModelAndView("general/institucion/registro-institucion", "command", institucionForm);

		mav.addObject("institucionForm", institucionForm);
//		mav.addObject("lstInstitucionDirectorBean", lstInstitucionDirectorBean);
		mav.addObject("idUsuario",usuarioBean.getCodigo());	
		this.listarCombos(mav);	
		return mav;
	}
*/
	
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo ,HttpServletRequest request) {

		System.out.println("modificar codigo: " + codigo);

		InstitucionBean prmInstitucionBean = new InstitucionBean();
		prmInstitucionBean.setCodigo(codigo);
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("InstitucionController/modificar");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        	try {
						institucionBean = institucionService.getBuscarPorObjecto(prmInstitucionBean);
						institucionForm.setInstitucionBean(institucionBean);
						institucionForm.setInstitucionDirectorBean(new InstitucionDirectorBean());
					} catch (ServiceException e) {
						e.printStackTrace();
					}
					//lista los directores asignado a esa  institucion
					try {
						InstitucionDirectorBean oInstitucionDirectorBean = new InstitucionDirectorBean();
						oInstitucionDirectorBean.setInstitucion(prmInstitucionBean);
						lstInstitucionDirectorBean = institucionDirectorService.getBuscarPorFiltros(oInstitucionDirectorBean);
					} catch (ServiceException e) {
						e.printStackTrace();
					}
					//lista las lenguas asiganadas  a esa  institucion
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						InstitucionLenguaBean oInstitucionLenguaBean = new InstitucionLenguaBean();
						oInstitucionLenguaBean.setInstitucionBean(prmInstitucionBean);
						
						
						lstInstitucionLenguaBean = institucionLenguaService.getBuscarPorFiltros(oInstitucionLenguaBean);
						System.out.println("lstInstitucionLenguaBean"+lstInstitucionLenguaBean);
						
						
							if(lstInstitucionLenguaBean!=null){
							
								for(int i = 0; i<lstInstitucionLenguaBean.size();i++){
									
									String srtfecha = sdf.format(lstInstitucionLenguaBean.get(i).getFechaCreacion());
									lstInstitucionLenguaBean.get(i).setStrFechaRegistro(srtfecha);
									
								}
								
							}else{
								System.out.println("fecha null");
							}
			//		} catch (Exception e) {
							
					
						InstitucionOperadorBean oInstitucionOperadorBean = new InstitucionOperadorBean();
						oInstitucionOperadorBean.setCodigoInstitucion(codigo);
						lstInstitucionOperadorBean = institucionOperadorService.getBuscarPorFiltros(oInstitucionOperadorBean);
						if (lstInstitucionOperadorBean != null) {
							for (int i = 0; i < lstInstitucionOperadorBean.size(); i++) {
								String  strFecha = sdf.format(lstInstitucionOperadorBean.get(i).getFechaCreacion());
								lstInstitucionOperadorBean.get(i).setStrFecha(strFecha);
								
							}
						}else{
							System.out.println("la lista null");
						}
					} catch (ServiceException e) {
						e.printStackTrace();
					}
				
					try {
						InstitucionSedeBean oInstitucionSedeBean = new InstitucionSedeBean();
						oInstitucionSedeBean.setInstitucionBean(prmInstitucionBean);
						System.out.println("codigo de institucion sede " + oInstitucionSedeBean.getInstitucionBean().getCodigo());
						lstInstitucionSede = institucionSedeService.getBuscarPorFiltros(oInstitucionSedeBean);
						if (lstInstitucionSede != null) {
							System.out.println("lista ok.");
						}else{
							System.out.println("lista de  sede esta  vacia.");
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				


//				try {
//					InstitucionOperadorBean oInstitucionOperadorBean = new InstitucionOperadorBean(); 
//					oInstitucionOperadorBean.setCodigoInstitucion(codigo);
//					lstInstitucionOperadorBean =  institucionOperadorService.getBuscarPorFiltros(oInstitucionOperadorBean);
//				} catch (ServiceException e) { 
//					e.printStackTrace();
//				}
		        }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesión no es valida, por favor inicie sesión nuevamente");
			return mav;
		}
			
		if(lstInstitucionOperadorBean!=null) {
			//encrypted DNI
			String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
			String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
			EncryptHability aesUtil = new EncryptHability(128, 1000);
			
			
			for (InstitucionOperadorBean item : lstInstitucionOperadorBean) {
				String plaintextNDoc = aesUtil.encrypt(salt, iv, "numeroDocumentoInstOpe", item.getPersonaBean().getNumeroDocumento().toString());
				item.getPersonaBean().setNumeroDocumento(plaintextNDoc);
			}
			
		}

		System.out.println("modificar institucionBean: " + institucionBean);
		ModelAndView mav = new ModelAndView("general/institucion/registro-institucion", "command", institucionForm);
		mav.addObject("institucionForm", institucionForm);
		mav.addObject("lstInstitucionDirectorBean", lstInstitucionDirectorBean);
		mav.addObject("lstInstitucionOperadorBean", lstInstitucionOperadorBean);
		mav.addObject("lstInstitucionLenguaBean", lstInstitucionLenguaBean);
		mav.addObject("lstInstitucionSede", lstInstitucionSede);		
		mav.addObject("idUsuario",usuarioBean.getCodigo());	
//		mav.addObject("idUsuario", usuarioBean.getCodigo());
		this.cargarUbigeo(mav, institucionBean);
		this.listarCombos(mav,2);

		return mav;
	}
	

	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar() {

		ModelAndView mav = new ModelAndView();
		
		if(institucionBeanTmp != null){

			InstitucionBean prmInstitucionBean = new InstitucionBean();
			prmInstitucionBean.setCodigo(institucionBeanTmp.getCodigo());
			
			try {
				institucionBean = institucionService.getBuscarPorObjecto(prmInstitucionBean);
				institucionForm.setInstitucionBean(institucionBean);
				institucionForm.setInstitucionDirectorBean(new InstitucionDirectorBean());
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			//lista los directores asignado a esa  institucion
			try {
				InstitucionDirectorBean oInstitucionDirectorBean = new InstitucionDirectorBean();
				oInstitucionDirectorBean.setInstitucion(prmInstitucionBean);
				lstInstitucionDirectorBean = institucionDirectorService.getBuscarPorFiltros(oInstitucionDirectorBean);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
				//lista las lenguas asiganadas  a esa  institucion
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				InstitucionLenguaBean oInstitucionLenguaBean = new InstitucionLenguaBean();
				oInstitucionLenguaBean.setInstitucionBean(prmInstitucionBean);
				
				
				lstInstitucionLenguaBean = institucionLenguaService.getBuscarPorFiltros(oInstitucionLenguaBean);
				System.out.println("lstInstitucionLenguaBean"+lstInstitucionLenguaBean);
				
				
					if(lstInstitucionLenguaBean!=null){
					
						for(int i = 0; i<lstInstitucionLenguaBean.size();i++){
							
							String srtfecha = sdf.format(lstInstitucionLenguaBean.get(i).getFechaCreacion());
							lstInstitucionLenguaBean.get(i).setStrFechaRegistro(srtfecha);
							
						}
						
					}else{
						System.out.println("fecha null");
					}
//			} catch (Exception e) {
					
			
				InstitucionOperadorBean oInstitucionOperadorBean = new InstitucionOperadorBean();
				oInstitucionOperadorBean.setCodigoInstitucion(codigo);
				lstInstitucionOperadorBean = institucionOperadorService.getBuscarPorFiltros(oInstitucionOperadorBean);
				if (lstInstitucionOperadorBean != null) {
					for (int i = 0; i < lstInstitucionOperadorBean.size(); i++) {
						String  strFecha = sdf.format(lstInstitucionOperadorBean.get(i).getFechaCreacion());
						lstInstitucionOperadorBean.get(i).setStrFecha(strFecha);
						
					}
				}else{
					System.out.println("la lista null");
				}
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			
			try {
				InstitucionSedeBean oInstitucionSedeBean = new InstitucionSedeBean();
				oInstitucionSedeBean.setInstitucionBean(prmInstitucionBean);
				System.out.println("codigo de institucion sede " + oInstitucionSedeBean.getInstitucionBean().getCodigo());
				lstInstitucionSede = institucionSedeService.getBuscarPorFiltros(oInstitucionSedeBean);
				if (lstInstitucionSede != null) {
					System.out.println("lista ok.");
				}else{
					System.out.println("lista de  sede esta  vacia.");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			


//			try {
//				InstitucionOperadorBean oInstitucionOperadorBean = new InstitucionOperadorBean(); 
//				oInstitucionOperadorBean.setCodigoInstitucion(codigo);
//				lstInstitucionOperadorBean =  institucionOperadorService.getBuscarPorFiltros(oInstitucionOperadorBean);
//			} catch (ServiceException e) { 
//				e.printStackTrace();
//			}
			
			//lstLengua = lenguaService.cargarCombo();

			System.out.println("modificar institucionBean: " + institucionBean);
			 mav = new ModelAndView("general/institucion/registro-institucion", "command", institucionForm);
			mav.addObject("institucionForm", institucionForm);
			mav.addObject("lstInstitucionDirectorBean", lstInstitucionDirectorBean);
			mav.addObject("lstInstitucionOperadorBean", lstInstitucionOperadorBean);
			mav.addObject("lstInstitucionLenguaBean", lstInstitucionLenguaBean);
			mav.addObject("lstInstitucionSede", lstInstitucionSede);		
			mav.addObject("idUsuario",usuarioBean.getCodigo());	
//			mav.addObject("idUsuario", usuarioBean.getCodigo());
			this.cargarUbigeo(mav, institucionBean);
			this.listarCombos(mav,2);

		}else{
			mav = new ModelAndView("general/institucion/listado-institucion", "command",institucionBean);
			mav.addObject("lstInstitucionBean", new ArrayList<InstitucionBean>());
			mav.addObject("institucionBean", institucionBean);
			this.listarCombos(mav,1);
		}
		return mav;
	}
	
	private void cargarUbigeo(ModelAndView mav,InstitucionBean institucionBean){

	
		if(institucionBean == null){
			System.out.println("institucion null");

		}
		System.out.println("institucionBean"+institucionBean);
		System.out.println("institucionBean.getUbigeoBean().getCodigoRegion()"+
		institucionBean.getUbigeoBean().getCodigoRegion());
		System.out.println("institucionBean.getUbigeoBean().getCodigoProvincia()"+
		institucionBean.getUbigeoBean().getCodigoProvincia());
		System.out.println("institucionBean.getUbigeoBean().getCodigoDistrito()"+
		institucionBean.getUbigeoBean().getCodigoDistrito());
		try {
			lstRegion 	 = this.getUbigeoService().listarRegion();
			lstProvincia = this.getUbigeoService().listarProvincia(institucionBean.getUbigeoBean());
			lstDistrito  = this.getUbigeoService().listarDistrito(institucionBean.getUbigeoBean());
			
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}		
	
		
		mav.addObject("lstRegion",lstRegion); 
		mav.addObject("lstProvincia",lstProvincia);
		mav.addObject("lstDistrito",lstDistrito); 
	}


	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView nuevo() throws Exception {
		institucionBeanTmp = null;
		institucionBean = new InstitucionBean();
		ubigeoBean = new UbigeoBean();
		lenguaBean =  new LenguaBean();
		institucionDirectorBean =  new InstitucionDirectorBean();


//		institucionDirectorBean = new InstitucionDirectorBean();

		ModelAndView mav = new ModelAndView("general/institucion/registro-institucion", "command", new InstitucionForm());
		mav.addObject("lstSituacion", lstSituacion);
		mav.addObject("lstTipo", lstTipo);
		mav.addObject("lstTipoActividad", lstTipoActividad);

		mav.addObject("lstRegion", lstRegion);
//		mav.addObject("lstProvincia", lstProvincia);
//		mav.addObject("lstDistrito", lstDistrito);

		mav.addObject("lstAreaGeografica", lstAreaGeografica);

		mav.addObject("lstTipoDocumento", lstTipoDocumento);

		
		mav.addObject("lstLengua", lstLengua);
		
		
		
//		mav.addObject("ubigeoBean", new UbigeoBean());


		// mav.addObject("ubigeoBean", new UbigeoBean());

		mav.addObject("institucionDirectorBean", new InstitucionDirectorBean());
		mav.addObject("institucionBean", new InstitucionBean());
		// this.listarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	@ResponseBody
	public String eliminar(@RequestParam("codigo") Integer codigo, HttpServletRequest request) {
		boolean sw = false;
		InstitucionForm institucionForm = new InstitucionForm();

		institucionBean = new InstitucionBean();
		String valor = "";
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("InstitucionController/eliminar");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	institucionBean.setCodigo(codigo);
	    		institucionForm.setInstitucionBean(institucionBean);
	    		try {			
	    			this.setAuditoria(institucionBean, request, false);
	    			sw = (institucionService.eliminar(institucionBean));

	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("sw "+ sw);
		if (sw) {
			valor = "1";
		}else{
			valor = "0";
		}
		return valor;
	}
	
	@RequestMapping(value = "/listarInstituciones", method = RequestMethod.GET)
	public ModelAndView listarLenguas()
			throws Exception {
		System.out.println("/::: listarInstituciones");
		ModelAndView mav = new ModelAndView("general/institucion/ajax/listado-tabla-institucion");
		List<InstitucionBean> lstInstitucionBean =new ArrayList<InstitucionBean>(); 

		try {
			lstInstitucionBean = (List<InstitucionBean>) institucionService.getBuscarPorFiltros(new InstitucionBean());
			if (lstInstitucionBean != null && lstInstitucionBean.size() > 0) {
				System.out.println("lstInstitucionBean.size() "+ lstInstitucionBean.size());
			}else{
				lstInstitucionBean = new ArrayList<InstitucionBean>();
			}
			
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}  
		mav.addObject("lstInstitucionBean", lstInstitucionBean); 
		return mav;
	}
	 

	/**
	 //@RequestMapping(value = "/eliminarDirector2", method = RequestMethod.GET)
	public ModelAndView eliminarDirector(@RequestParam("codigo") Integer codigo, HttpServletRequest request) {
		boolean sw = false;
		System.out.println("eliminar codigoDirector :" + codigo);

		InstitucionForm institucionForm = new InstitucionForm();
		
		institucionDirectorBean= new InstitucionDirectorBean(); 
		institucionDirectorBean.setCodigo(codigo);
		institucionForm.setInstitucionDirectorBean(institucionDirectorBean); 
		try {
			sw = (institucionDirectorService.eliminar(institucionDirectorBean));

		} catch (Exception e) {
			e.printStackTrace();
		}
		institucionDirectorBean.setCodigo(0);
		this.setValoresPredeterminados(institucionBean);
		ModelAndView mav = this.getLista(institucionForm.getInstitucionBean());
		mav.addObject("swMensaje", sw ? "1" : "0");
		return mav;
	}
*/
	@RequestMapping(value = "/eliminarDirector", method = RequestMethod.GET)
	@ResponseBody
	public void eliminarDirector(@RequestParam("codigo") Integer codigo, HttpServletRequest request) {
		boolean sw = false;
		System.out.println("eliminar codigoDirector :" + codigo);
		InstitucionForm institucionForm = new InstitucionForm(); 
		institucionDirectorBean= new InstitucionDirectorBean(); 

		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("InstitucionController/eliminarDirector");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	institucionDirectorBean.setCodigo(codigo);
	    		institucionForm.setInstitucionDirectorBean(institucionDirectorBean); 
	    		try {
	    			this.setAuditoria(institucionDirectorBean, request, false);
	    			sw = (institucionDirectorService.eliminar(institucionDirectorBean));

	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/listarDirector", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView listarDirector(@RequestParam("codigo") Integer codigo)
			throws Exception {
		System.out.println("/listarDirector " + codigo);
		ModelAndView mav = new ModelAndView("general/institucion/listado-director");
		List<InstitucionDirectorBean> lstInstitucionDirectorBean = new ArrayList<InstitucionDirectorBean>();
		InstitucionBean prmInstitucionBean = new InstitucionBean();
		prmInstitucionBean.setCodigo(codigo);
		try {
			InstitucionDirectorBean oInstitucionDirectorBean = new InstitucionDirectorBean();
			oInstitucionDirectorBean.setInstitucion(prmInstitucionBean);
			lstInstitucionDirectorBean = institucionDirectorService.getBuscarPorFiltros(oInstitucionDirectorBean); 
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		mav.addObject("lstInstitucionDirectorBean", lstInstitucionDirectorBean);
		return mav;
	}
	
	@RequestMapping(value = "/listarInstOperador", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView listarInstOperador(@RequestParam("codigo") Integer codigo)
			throws Exception {
		System.out.println("/listarInstOperador " + codigo);
		ModelAndView mav = new ModelAndView("general/institucion/listado-operador");
		List<InstitucionOperadorBean> lstInstitucionOperadorBean = new ArrayList<InstitucionOperadorBean>();
		
		InstitucionOperadorBean prmInstitucionOperadorBean = new InstitucionOperadorBean();
		prmInstitucionOperadorBean.setCodigoInstitucion(codigo);
		 
		try { 
			lstInstitucionOperadorBean = institucionOperadorService.getBuscarPorFiltros(prmInstitucionOperadorBean);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
				
		mav.addObject("lstInstitucionOperadorBean", lstInstitucionOperadorBean);
		return mav;
	}
	
	@RequestMapping(value ="/eliminarLengua", method = RequestMethod.GET)
	public ModelAndView eliminarLengua(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		System.out.println("eliminar codigoInstitucionLengua :" + codigo);
		InstitucionForm institucionForm = new InstitucionForm();
		institucionLenguaBean= new InstitucionLenguaBean();
		
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("InstitucionController/eliminarLengua");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	institucionLenguaBean.setCodigo(codigo);
	    		institucionForm.setInstitucionLenguaBean(institucionLenguaBean);
	    		System.out.println("institucionForm.getInstitucionLenguaBean()"+institucionForm.getInstitucionLenguaBean());
	    	//	this.setAuditoria(lenguaBean, request, false);
	    		try { 
	    				this.setAuditoria(institucionForm.getInstitucionLenguaBean(), request, false);
	    				sw = (institucionLenguaService.eliminar(institucionForm.getInstitucionLenguaBean()));  

	    		} catch (Exception e) { 
	    			e.printStackTrace();
	    		} 		
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		institucionLenguaBean.setCodigo(0);
		this.setValoresPredeterminados(institucionBean);
		ModelAndView mav = this.getLista(institucionForm.getInstitucionBean());
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}
	
	
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView registrar(@ModelAttribute("institucionForm") InstitucionForm institucionForm , HttpServletRequest request) throws Exception {
		System.out.println("institucionBean Grabar" + institucionForm.getInstitucionBean());
		System.out.println("institucionBean Grabar" + institucionForm.getInstitucionBean().getCodigo());
		
		//institucionForm.getInstitucionBean().setNombreInstitucion(VO.convertirCaracteresEsp(institucionForm.getInstitucionBean().getNombreInstitucion()));
		boolean sw = false;
		//leer token		
		HttpSession sessionToken = request.getSession();
		String u = (String) leerToken.parseUserJWT(sessionToken.getAttribute("token").toString());
		if(u != null) {
			try {
				//ip
				boolean habilitadoIp = true;
				PeticionBean prmIntento = new PeticionBean();
				prmIntento.setIpConexion(request.getRemoteAddr());
				prmIntento.setUrlPeticion("InstitucionController/grabar");
				habilitadoIp = peticionService.existe(prmIntento);
		        if(habilitadoIp) {
		        			        	
		        	if(institucionForm.getInstitucionBean().getNombreInstitucion()!=null&&institucionForm.getInstitucionBean().getNombreCorto()!=null&&
		        	institucionForm.getInstitucionBean().getNombreInstitucion()!=""&&institucionForm.getInstitucionBean().getNombreCorto()!=""&&
		        	institucionForm.getInstitucionBean().getCodigoModular()!=""&&institucionForm.getInstitucionBean().getCodigoModular()!=null&&
		        	institucionForm.getInstitucionBean().getCodigoLocal()!=""&&institucionForm.getInstitucionBean().getCodigoLocal()!=null&&
		        	ValidatorField.validarLetras(institucionForm.getInstitucionBean().getNombreInstitucion())) {
		        		if (institucionForm.getInstitucionBean().getCodigo() == 0) {
		        			
		        			this.setAuditoria(institucionForm.getInstitucionBean(), request, true);				
		        			System.out.println("Insertar " + institucionForm.getInstitucionBean());
		        			
		        			sw = (this.getInstitucionService().insertar(institucionForm.getInstitucionBean()));
		        			
		        			System.out.println("institucionBean.getCodigo() ::" + institucionForm.getInstitucionBean().getCodigo());
		        			InstitucionBean oInstitucionBean = new InstitucionBean();
		        			oInstitucionBean.setCodigo(institucionForm.getInstitucionBean().getCodigo());
		        			
		        			
		        			try {
		        				institucionBean = institucionService.getBuscarPorObjecto(oInstitucionBean);
		        				
		        				System.out.println("institucionBean ::" + institucionBean);
		        			} catch (Exception e) {
		        				e.printStackTrace();
		        			}
		        			
		        		} else {
		        			System.out.println("institucion  modificar");
		        			System.out.println("codigo a  modificar " + institucionBean.getCodigo());
		        			
		        			this.setAuditoria(institucionForm.getInstitucionBean(), request, false);				
		        			sw = (this.getInstitucionService().actualizar(institucionForm.getInstitucionBean()));
		        			
		        			//listando las demas  listas.
		        			
		        			try {
		        				//lista datos de  una  institucion
		        				
		        				institucionBean = institucionService.getBuscarPorObjecto(institucionForm.getInstitucionBean());
		        				institucionForm.setInstitucionBean(institucionBean);
		        				institucionForm.setInstitucionDirectorBean(new InstitucionDirectorBean());
		        			} catch (ServiceException e) {
		        				e.printStackTrace();
		        			}
		        			//lista los directores asignado a esa  institucion
		        			try {
		        				InstitucionDirectorBean oInstitucionDirectorBean = new  InstitucionDirectorBean();
		        				oInstitucionDirectorBean.getInstitucion().setCodigo(institucionForm.getInstitucionBean().getCodigo());
		        				
		        				lstInstitucionDirectorBean = institucionDirectorService.getBuscarPorFiltros(oInstitucionDirectorBean);
		        			} catch (ServiceException e) {
		        				e.printStackTrace();
		        			}
		        			//lista las lenguas asiganadas  a esa  institucion
		        			try {										
		        				
		        				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		        				InstitucionLenguaBean oInstitucionLenguaBean =  new InstitucionLenguaBean();
		        				oInstitucionLenguaBean.getInstitucionBean().setCodigo(institucionForm.getInstitucionBean().getCodigo());
		        				
		        				
		        				lstInstitucionLenguaBean = institucionLenguaService.getBuscarPorFiltros(oInstitucionLenguaBean);
		        				System.out.println("lstInstitucionLenguaBean"+lstInstitucionLenguaBean);
		        				
		        				
		        				if(lstInstitucionLenguaBean!=null){
		        					
		        					for(int i = 0; i<lstInstitucionLenguaBean.size();i++){
		        						
		        						String srtfecha = sdf.format(lstInstitucionLenguaBean.get(i).getFechaCreacion());
		        						lstInstitucionLenguaBean.get(i).setStrFechaRegistro(srtfecha);
		        						
		        					}
		        					
		        				}else{
		        					System.out.println("fecha null");
		        				}
//						} catch (Exception e) {
		        				
		        				
		        				InstitucionOperadorBean oInstitucionOperadorBean = new InstitucionOperadorBean();
		        				oInstitucionOperadorBean.setCodigoInstitucion((int) institucionForm.getInstitucionBean().getCodigo());
		        				lstInstitucionOperadorBean = institucionOperadorService.getBuscarPorFiltros(oInstitucionOperadorBean);
		        			} catch (ServiceException e) {
		        				e.printStackTrace();
		        			}
		        			try {
		        				InstitucionSedeBean oInstitucionSedeBean = new InstitucionSedeBean();
		        				oInstitucionSedeBean.setCodigo(institucionForm.getInstitucionBean().getCodigo());
		        				System.out.println("institucionForm.getInstitucionBean().getCodigo()"+ institucionForm.getInstitucionBean().getCodigo());
		        				lstInstitucionSede = institucionSedeService.getBuscarPorFiltros(oInstitucionSedeBean);
		        				if (lstInstitucionSede != null) {
		        					System.out.println("lista ok.");
		        				}else{
		        					System.out.println("lista de  sede esta  vacia.");
		        				}
		        				
		        			} catch (Exception e) {
		        				e.printStackTrace();
		        			}
		        			
		        			
		        		}
		        		
		        	}
		        }
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			sessionToken.removeAttribute("usuarioSesion");
			sessionToken.invalidate();
			LoginVo prmLogin = new LoginVo();
			ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command",prmLogin);
			mav.addObject("msgErrorLogin","Su sesión no es valida, por favor inicie sesión nuevamente");
			return mav;
		}
		
		System.out.println("sw" + sw);
		if (sw) {
			ModelAndView mav = new ModelAndView("general/institucion/registro-institucion", "command", institucionForm);
			this.listarCombos(mav,1);
			mav.addObject("institucionBean", institucionBean);
			mav.addObject("lstInstitucionDirectorBean", lstInstitucionDirectorBean);
			mav.addObject("lstInstitucionLenguaBean", lstInstitucionLenguaBean);
			mav.addObject("lstInstitucionOperadorBean", lstInstitucionOperadorBean);
			mav.addObject("lstInstitucionSede", lstInstitucionSede);
			mav.addObject("swMensaje","1"); 
			return mav;

		} else {
			ModelAndView mav = new ModelAndView("general/institucion/registro-institucion", "command", institucionForm);
			mav.addObject("institucionBean", institucionBean);
			mav.addObject("lstInstitucionDirectorBean", lstInstitucionDirectorBean);
			mav.addObject("lstInstitucionLenguaBean", lstInstitucionLenguaBean);
			mav.addObject("lstInstitucionOperadorBean", lstInstitucionOperadorBean);
			mav.addObject("lstInstitucionSede", lstInstitucionSede);
			mav.addObject("swMensaje","0");
			return mav;

		}

		// ModelAndView mav = new
		// ModelAndView("general/institucion/registro-institucion",
		// "command",institucionBean);
		// this.listarCombos(mav);
		// return mav;
	}
	
	@RequestMapping(value = "/insertarLengua", method = RequestMethod.POST)
	public @ResponseBody String insertarLengua(@ModelAttribute("institucionForm") InstitucionForm institucionForm,HttpServletRequest request)throws Exception {		
		institucionForm.getInstitucionLenguaBean().setInstitucionBean(institucionForm.getInstitucionBean());
		System.out.println("institucionForm.getInstitucionLenguaBean().getCodigo()"+ 
		institucionForm.getInstitucionLenguaBean().getCodigo());
		System.out.println(institucionForm.getInstitucionLenguaBean().getLenguaBean().getCodigo());
		
		boolean sw =  false;
		String valor = "";

		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("InstitucionController/insertarLengua");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	if (institucionForm.getInstitucionLenguaBean().getLenguaBean().getCodigo() != 0) {
	        		if (institucionForm.getInstitucionLenguaBean().getCodigo() == 0) {
	        			
	        			this.setAuditoria(institucionForm.getInstitucionLenguaBean(), request, true);					
	        			sw = this.getInstitucionLenguaService().insertar(institucionForm.getInstitucionLenguaBean());
	        			
	        			if (institucionForm.getInstitucionLenguaBean().getCodigo() == 0) {
	        				System.out.println("--- ya existe esa  lengua");
	        				valor = "5";
	        			}else{
	        				valor = "1";
	        			}
	        			
	        		}else{
	        			System.out.println("modificar");
	        			
	        		}
	        		
	        	}else{
	        		valor = "4";
	        	}
	        } else{
        		valor = "4";
        	}
		} catch (Exception e) {
			e.printStackTrace();
			valor = "4";
		}
		return valor;
	}
	
//	@RequestMapping(value = "/refrescarListaInstLengua", method = RequestMethod.GET)
//	public @ResponseBody List<InstitucionLenguaBean> refrescarListaInstLengua(@RequestParam("codigoInst") String codigoInst)throws Exception {		
//
//		List<InstitucionLenguaBean> listaInstitucionLenguaBean = new ArrayList<InstitucionLenguaBean>();
//		try {
//			InstitucionLenguaBean oInstitucionLenguaBean = new InstitucionLenguaBean();
//			oInstitucionLenguaBean.getInstitucionBean().setCodigo(VO.toLong(codigoInst));
//			listaInstitucionLenguaBean =  institucionLenguaService.getBuscarPorFiltros(oInstitucionLenguaBean);
//			
//			if (!VO.isEmptyList(listaInstitucionLenguaBean)) {	
//				return listaInstitucionLenguaBean;
//			}else{
//				return new ArrayList<InstitucionLenguaBean>();
//			}
//
//		} catch (Exception e) { 
//			e.printStackTrace();
//			return new ArrayList<InstitucionLenguaBean>();
//		}
//	}
	
	@RequestMapping(value = "/listarLengua", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView listarLengua(@RequestParam("codigo") Integer codigo)
			throws Exception {
		System.out.println("/listarLengua " + codigo);
		ModelAndView mav = new ModelAndView("general/institucion/listado-lengua");
		List<InstitucionLenguaBean> lstInstitucionLenguaBean = new ArrayList<InstitucionLenguaBean>();
		InstitucionBean prmInstitucionBean = new InstitucionBean();
		prmInstitucionBean.setCodigo(codigo);
		try {
			InstitucionLenguaBean oInstitucionLenguaBean = new InstitucionLenguaBean();
			oInstitucionLenguaBean.setInstitucionBean(prmInstitucionBean);
			lstInstitucionLenguaBean = institucionLenguaService.getBuscarPorFiltros(oInstitucionLenguaBean); 
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		mav.addObject("lstInstitucionLenguaBean", lstInstitucionLenguaBean);
		return mav;
	}
	
	@RequestMapping(value = "/listarLenguaCombo", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView listarLenguaCombo(@RequestParam("codigo") Integer codigo)
			throws Exception {
		System.out.println("/listarLengua " + codigo);
		ModelAndView mav = new ModelAndView("general/institucion/listado-lengua-combo");
		InstitucionBean prmInstitucionBean = new InstitucionBean();
		prmInstitucionBean.setCodigo(codigo);
		try {
			
			lstLengua = lenguaService.listarLenguaFaltantexCodigoInstitucion(prmInstitucionBean);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		InstitucionLenguaBean oinstitucionLenguaBean= new InstitucionLenguaBean();
		oinstitucionLenguaBean = this.getInstitucionLenguaBean();
		oinstitucionLenguaBean.setInstitucionBean(prmInstitucionBean);
		mav.addObject("institucionLenguaBean", oinstitucionLenguaBean );
		mav.addObject("lstLengua", lstLengua);
		return mav;
	}
	
	//** Asignar Director  **//
	@RequestMapping(value = "/nuevoInstDirector", method = RequestMethod.GET)
	public ModelAndView nuevoInstDirector()throws Exception {

		ModelAndView mav = new ModelAndView("general/institucion/ajax/asignar-director-institucional-modal-ajax", "command",new PersonaBean());
		mav.addObject("personaBean",new PersonaBean());
		this.listarCombos(mav,1);
		return mav;
	}
	

	private void listarCombos(ModelAndView mav, Integer indicador) {

		if (lstTipo == null) {
			try {
				lstTipo = maestra1Service.listarPorCodigoTabla("TipoInstitucion",0);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (lstSituacion == null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("SituacionInstitucion",0);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (lstTipoActividad == null) {
			try {
				lstTipoActividad = maestra1Service.listarPorCodigoTabla("TipoActividad",0);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (lstRegion == null) {
			try {
				lstRegion = this.getUbigeoService().listarRegion();
				System.out.println("lstRegion" + lstRegion.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		if (lstAreaGeografica == null) {
			try {
				lstAreaGeografica = maestra1Service.listarPorCodigoTabla("areaGeografica",0);
				System.out.println("lstAreaGeografica " + lstAreaGeografica.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (lstTipoDocumento == null) {
			try {
				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento",1);
				System.out.println("lstTipoDocumento " + lstTipoDocumento.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (lstLengua == null) {
			try {
				if(indicador!=1) {
					lstLengua = lenguaService.cargarCombo();
					System.out.println("paso  lista  combo");					
				} else {
					lstLengua = lenguaService.listarLenguaFaltantexCodigoInstitucion(institucionBean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		try {
			if(indicador==2) {
				lstLengua = lenguaService.listarLenguaFaltantexCodigoInstitucion(institucionBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("lstTipo", lstTipo);
		mav.addObject("lstSituacion", lstSituacion);
		mav.addObject("lstTipoActividad", lstTipoActividad);
		mav.addObject("lstLengua", lstLengua);
		mav.addObject("lstRegion", lstRegion);
//		mav.addObject("lstProvincia", lstProvincia);
//		mav.addObject("lstDistrito", lstDistrito);

		mav.addObject("lstAreaGeografica", lstAreaGeografica);

		mav.addObject("lstTipoDocumento", lstTipoDocumento);

	}

	public void setValoresPredeterminadosSede(InstitucionSedeBean institucionSedeBean) {
		institucionSedeBean.setNombreSede("");
		institucionSedeBean.setTelefono("");
		institucionSedeBean = new InstitucionSedeBean();
	}

//	@RequestMapping(value = "/nuevoSede", method = RequestMethod.GET)
//	public ModelAndView nuevoSede(@RequestParam("codigo") Integer codigo, HttpServletRequest request) throws Exception {
//		ubigeoBean = new UbigeoBean();
//		institucionSedeBean = new InstitucionSedeBean();
//		institucionSedeBean.setCodigoInstitucion(codigo);
//		System.out.println("codigoIns " + codigo);
//		ModelAndView mav = new ModelAndView("general/institucion/registro-sede", "command", institucionSedeBean);
//		mav.addObject("lstRegion", lstRegion);
//		ubigeoBean.setCodigoRegion("00");
//		ubigeoBean.setCodigoProvincia("00");
//		ubigeoBean.setCodigoDistrito("00");
//		lstProvincia = new ArrayList<UbigeoBean>();
//		lstDistrito = new ArrayList<UbigeoBean>();
//		//mav.addObject("lstProvincia", lstProvincia);
//		//mav.addObject("lstDistrito", lstDistrito);
//		mav.addObject("ubigeoBean", ubigeoBean);
//		mav.addObject("institucionSedeBean", institucionSedeBean);
//		this.listarCombos(mav);
//		return mav;
//	}
//
//	@RequestMapping(value = "/listarSedes", method = RequestMethod.GET)
//	public ModelAndView listarSedes(@RequestParam("codigo") Integer codigo, HttpServletRequest request)
//			throws Exception {
//		ubigeoBean = new UbigeoBean();
//		institucionSedeBean = new InstitucionSedeBean();
//		institucionSedeBean.setCodigoInstitucion(codigo);
//		System.out.println("codigoIns " + codigo);
//		ModelAndView mav = new ModelAndView("general/institucion/listado-sede", "command", institucionSedeBean);
//		try {
//			lstInstitucionSede = institucionSedeService.getBuscarPorFiltros(institucionSedeBean);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//		mav.addObject("ubigeoBean", new UbigeoBean());
//		mav.addObject("lstInstitucionSede", lstInstitucionSede);
//		this.listarCombos(mav);
//		return mav;
//	}
//
//	@RequestMapping(value = "/modificarSede", method = RequestMethod.GET)
//	public ModelAndView modificarSede(@RequestParam("codigoInst") Integer codigoInst,
//			@RequestParam("codigoSede") Integer codigoSede) {
//		ubigeoBean = new UbigeoBean();
//		InstitucionSedeBean modInstitucionSedeBean = new InstitucionSedeBean();
//		modInstitucionSedeBean.setCodigoInstitucion(codigoInst);
//		modInstitucionSedeBean.setCodigo(codigoSede);
//		try {
//			institucionSedeBean = institucionSedeService.getBuscarPorObjecto(modInstitucionSedeBean);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//		System.out.println("modificar institucionSedeBean: " + institucionSedeBean);
//		ModelAndView mav = new ModelAndView("general/institucion/registro-sede", "command", institucionSedeBean);
//	
//		mav.addObject("lstRegion", lstRegion);
//		ubigeoBean.setCodigoRegion(institucionSedeBean.getCodigoRegion());
//		ubigeoBean.setCodigoProvincia(institucionSedeBean.getCodigoProvincia());
//		try {
//			lstProvincia = new ArrayList<UbigeoBean>();
//			lstDistrito = new ArrayList<UbigeoBean>();
//			lstProvincia = this.getUbigeoService().listarProvincia(ubigeoBean);
//			lstDistrito = this.getUbigeoService().listarDistrito(ubigeoBean);
//			System.out.println("listaProvincia" + lstProvincia.size());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		mav.addObject("lstProvincia", lstProvincia);
//		mav.addObject("lstDistrito", lstDistrito);
//		mav.addObject("ubigeoBean",ubigeoBean);
//		mav.addObject("institucionSedeBean", institucionSedeBean);
//		this.listarCombos(mav);
//		return mav;
//	}
//
//	@RequestMapping(value = "/eliminarSede", method = RequestMethod.GET)
//	public ModelAndView eliminarSede(@RequestParam("codigoSede") Integer codigoSede,
//			@RequestParam("codigoInst") Integer codigoInst, HttpServletRequest request) {
//		boolean sw = false;
//		institucionSedeBean = new InstitucionSedeBean();
//		institucionSedeBean.setCodigo(codigoSede);
//		institucionSedeBean.setCodigoInstitucion(codigoInst);
//		try {
//			sw = (institucionSedeService.eliminar(institucionSedeBean));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		institucionSedeBean.setCodigo(0);
//		this.setValoresPredeterminadosSede(institucionSedeBean);
//		ModelAndView mav = new ModelAndView("general/institucion/registro-sede", "command", institucionSedeBean);
//		try {
//			lstInstitucionSede = institucionSedeService.getBuscarPorFiltros(institucionSedeBean);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//		mav.addObject("ubigeoBean", new UbigeoBean());
//		mav.addObject("lstInstitucionSede", lstInstitucionSede);
//		mav.addObject("institucionSedeBean", institucionSedeBean);
//		this.listarCombos(mav);
//		mav.addObject("swMensaje", sw ? "1" : "0");
//		return mav;
//	}
//
//	@RequestMapping(value = "/actualizarSede", method = RequestMethod.GET)
//	public ModelAndView actualizarSede(@RequestParam("codigoSede") Integer codigoSede,
//			@RequestParam("codigoInst") Integer codigoInst, @RequestParam("nombreSede") String nombreSede,
//			@RequestParam("telefono") String telefono, @RequestParam("correo") String correo,
//			@RequestParam("direccion") String direccion, @RequestParam("contacto") String contacto,
//			@RequestParam("codigoRegion") String codigoRegion,  @RequestParam("codigoProvincia") String codigoProvincia,
//			@RequestParam("codigoDistrito") String codigoDistrito,
//			HttpServletRequest request) throws Exception {
//		boolean sw = false;
//		institucionSedeBean = new InstitucionSedeBean();
//		institucionSedeBean.setCodigo(codigoSede);
//		institucionSedeBean.setCodigoInstitucion(codigoInst);
//		institucionSedeBean.setTelefono(telefono);
//		institucionSedeBean.setContacto(contacto);
//		institucionSedeBean.setDireccionInstitucion(direccion);
//		institucionSedeBean.setNombreSede(nombreSede);
//		institucionSedeBean.setCorreo(correo);
//		institucionSedeBean.setCodigoRegion(codigoRegion);
//		institucionSedeBean.setCodigoProvincia(codigoProvincia);
//		institucionSedeBean.setCodigoDistrito(codigoDistrito);
//		try {
//			if (institucionSedeBean.getCodigo() > 0) {
//				sw = (institucionSedeService.actualizar(institucionSedeBean));
//				System.out.println("Se actualiz� sede.");
//			} else {
//				sw = false;
//				System.out.println("no existe sede.");
//			}
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//		institucionSedeBean.setCodigo(0);
//		this.setValoresPredeterminadosSede(institucionSedeBean);
//		ModelAndView mav = new ModelAndView("general/institucion/registro-sede", "command", institucionSedeBean);
//		try {
//			lstInstitucionSede = institucionSedeService.getBuscarPorFiltros(institucionSedeBean);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//		mav.addObject("ubigeoBean", new UbigeoBean());
//		mav.addObject("lstInstitucionSede", lstInstitucionSede);
//		mav.addObject("institucionSedeBean", institucionSedeBean);
//		this.listarCombos(mav);
//		mav.addObject("swMensaje", sw ? "1" : "0");
//		return mav;
//	}
//	
//	@RequestMapping(value = "/grabarSede", method = RequestMethod.GET)
//	public ModelAndView registrarSede(@RequestParam("codigoSede") Integer codigoSede,
//			@RequestParam("codigoInst") Integer codigoInst, @RequestParam("nombreSede") String nombreSede,
//			@RequestParam("telefono") String telefono, @RequestParam("correo") String correo,
//			@RequestParam("direccion") String direccion, @RequestParam("contacto") String contacto,
//			@RequestParam("codigoRegion") String codigoRegion,  @RequestParam("codigoProvincia") String codigoProvincia,
//			 @RequestParam("codigoDistrito") String codigoDistrito,
//			HttpServletRequest request) throws Exception {
//
//		boolean sw = false;
//		institucionSedeBean = new InstitucionSedeBean();
//		institucionSedeBean.setCodigo(codigoSede);
//		institucionSedeBean.setCodigoInstitucion(codigoInst);
//		institucionSedeBean.setTelefono(telefono);
//		institucionSedeBean.setContacto(contacto);
//		institucionSedeBean.setDireccionInstitucion(direccion);
//		institucionSedeBean.setNombreSede(nombreSede);
//		institucionSedeBean.setCorreo(correo);
//		institucionSedeBean.setCodigoRegion(codigoRegion);
//		institucionSedeBean.setCodigoProvincia(codigoProvincia);
//		institucionSedeBean.setCodigoDistrito(codigoDistrito);
//		try {
//			if (institucionSedeBean.getCodigo() > 0) {
//				sw = (institucionSedeService.insertar(institucionSedeBean));
//				System.out.println("Se registr� sede.");
//			} else {
//				sw = false;
//				System.out.println("no existe sede.");
//			}
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//		institucionSedeBean.setCodigo(0);
//		this.setValoresPredeterminadosSede(institucionSedeBean);
//		ModelAndView mav = new ModelAndView("general/institucion/registro-sede", "command", institucionSedeBean);
//		try {
//			lstInstitucionSede = institucionSedeService.getBuscarPorFiltros(institucionSedeBean);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//		mav.addObject("ubigeoBean", new UbigeoBean());
//		mav.addObject("lstInstitucionSede", lstInstitucionSede);
//		mav.addObject("institucionSedeBean", institucionSedeBean);
//		mav.addObject("swMensaje", sw ? "1" : "0");
//		return mav;
//	}
	/** MANTENIMIENTO INSTITUCION - SEDE **/
	@RequestMapping(value = "/nuevoInstSede", method = RequestMethod.GET)
	public ModelAndView nuevoInstSede()throws Exception {
		institucionSedeBean = new InstitucionSedeBean();
		ubigeoBean = new UbigeoBean();
		
		ModelAndView mav = new ModelAndView("general/institucion/ajax/registro-sede", "command",institucionSedeBean);
		
		mav.addObject("institucionSedeBean",new InstitucionSedeBean());		
		mav.addObject("lstRegion", lstRegion);
		this.listarCombos(mav,1);
		return mav;
	}
	@RequestMapping(value = "/guardarInstSede", method = RequestMethod.POST)
	public @ResponseBody String guardarInstSede(@ModelAttribute("institucionSedeBean") InstitucionSedeBean institucionSedeBean, HttpServletRequest request)throws Exception {
		System.out.println("institucionSedeBean.getCodigo() ::"+institucionSedeBean.getCodigo());
		boolean sw =  false;
		String  valor = "";
		
		try {	
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("InstitucionController/guardarInstSede");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	
	        	if(ValidatorField.validarCorreo(institucionSedeBean.getCorreo()) && ValidatorField.validarMascaraTelefono(institucionSedeBean.getTelefono())) {
	        		if (institucionSedeBean.getCodigo() == 0) {
						this.setAuditoria(institucionSedeBean, request, true);	
						sw = (this.getInstitucionSedeService().insertar(institucionSedeBean));
						if (institucionSedeBean.getCodigo() == 0) {
							valor = "0";
						}else{
							valor = "1";
						}				
						
					}else{
						
						this.setAuditoria(institucionSedeBean, request, false);	
						sw = (this.getInstitucionSedeService().actualizar(institucionSedeBean));	
						System.out.println("se modifico sede.");
						valor = "1";
					}	
	        	} else {
	        		valor = "4";
	        	}
	        }
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
				
		System.out.println("sw" + sw);
//		if (sw) {
//			valor = "1";
//		}else{
//			valor =  "0";
//		}
		return valor;
	}
	@RequestMapping(value = "/modificarInstSede", method = RequestMethod.GET)
	public ModelAndView modificarInstSede(@RequestParam("codigo") Integer codigo ,HttpServletRequest request)throws Exception {
		InstitucionSedeBean prmInstitucionSedeBean = new InstitucionSedeBean();
		prmInstitucionSedeBean.setCodigo(codigo);
		System.out.println("ingreso a  modificarInstSede");
		institucionSedeBean = this.getInstitucionSedeService().getBuscarPorObjecto(prmInstitucionSedeBean);
		
		ModelAndView mav = new ModelAndView("general/institucion/ajax/registro-sede", "command",institucionSedeBean);
		mav.addObject("institucionSedeBean",institucionSedeBean);
		this.cargarUbigeoSede(mav, institucionSedeBean);
		this.listarCombos(mav,1);
		return mav;
	}
	private void cargarUbigeoSede(ModelAndView mav,InstitucionSedeBean institucionSedeBean){

		
		if(institucionSedeBean == null){
			System.out.println("institucion null");

		}
		System.out.println("---- cargarUbigeoSede ----");
		System.out.println("institucionSedeBean"+institucionSedeBean);
		System.out.println("institucionSedeBean.getCodigoRegion()"+
		institucionSedeBean.getCodigoRegion());
		System.out.println("institucionSedeBean.getCodigoProvincia()"+
		institucionSedeBean.getCodigoProvincia());
		System.out.println("institucionSedeBean.getCodigoDistrito()"+
		institucionSedeBean.getCodigoDistrito());
		UbigeoBean ubigeoBean = new UbigeoBean();
		ubigeoBean.setCodigoRegion(institucionSedeBean.getCodigoRegion());
		ubigeoBean.setCodigoProvincia(institucionSedeBean.getCodigoProvincia());
		ubigeoBean.setCodigoDistrito(institucionSedeBean.getCodigoDistrito());
		try {
			lstRegion 	 = this.getUbigeoService().listarRegion();
			lstProvincia = this.getUbigeoService().listarProvincia(ubigeoBean);
			lstDistrito  = this.getUbigeoService().listarDistrito(ubigeoBean);
			
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}		
	
		
		mav.addObject("lstRegion",lstRegion); 
		mav.addObject("lstProvincia",lstProvincia);
		mav.addObject("lstDistrito",lstDistrito); 
	}
	
	@RequestMapping(value = "/eliminarSede", method = RequestMethod.GET)
	public @ResponseBody String eliminarSede(@RequestParam("codigo") Integer codigo, HttpServletRequest request) {
		boolean sw = false;
		System.out.println("ingreso a  eliminar sede");
		InstitucionSedeBean oInstitucionSedeBean = new InstitucionSedeBean(); 
		System.out.println("codigo eliminar sede :: " + codigo );
		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("InstitucionController/eliminarSede");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	oInstitucionSedeBean.setCodigo(codigo);
	        	this.setAuditoria(oInstitucionSedeBean, request, false);	
	        	sw = (this.getInstitucionSedeService().eliminar(oInstitucionSedeBean));	        	
	        }

		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
		}
		System.out.println("sw"+ sw);
		if (sw) {
			return "1"; 
		}else{
			return "0";
		}	
		
	}
	@RequestMapping(value = "/refrescarListaInstSede", method = RequestMethod.GET)
	public @ResponseBody List<InstitucionSedeBean> refrescarListaInstSede(@RequestParam("codigoInst") int codigoInst)throws Exception {
		List<InstitucionSedeBean> lstInstitucionSedeBean = new ArrayList<InstitucionSedeBean>();
		
		InstitucionSedeBean prmInstitucionSedeBean = new InstitucionSedeBean();
		prmInstitucionSedeBean.getInstitucionBean().setCodigo(codigoInst);
		
		lstInstitucionSedeBean =  this.getInstitucionSedeService().getBuscarPorFiltros(prmInstitucionSedeBean); 
				//institucionOperadorService.getBuscarPorFiltros(prmInstitucionOperadorBean);
		
		return lstInstitucionSedeBean;
	}
	@RequestMapping(value = "/listarInstSede", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView listarInstSede(@RequestParam("codigo") Integer codigo)
			throws Exception {
		System.out.println("---------listarInstSede " + codigo);
		ModelAndView mav = new ModelAndView("general/institucion/listado-sede");
		List<InstitucionSedeBean> lstInstitucionSedeBean = new ArrayList<InstitucionSedeBean>();
		
		InstitucionSedeBean prmInstitucionSedeBean = new InstitucionSedeBean();
		prmInstitucionSedeBean.getInstitucionBean().setCodigo(codigo);
		 
		try { 
			lstInstitucionSede = this.getInstitucionSedeService().getBuscarPorFiltros(prmInstitucionSedeBean); 
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		mav.addObject("lstInstitucionSede", lstInstitucionSede);
		return mav;
	}
	
	/** MANTENIMIENTO INSTITUCION - OPERADOR **/
	
	@RequestMapping(value = "/nuevoInstOperador", method = RequestMethod.GET)
	public ModelAndView nuevoInstOperador()throws Exception {
		institucionOperadorBean = new InstitucionOperadorBean();

		ModelAndView mav = new ModelAndView("general/institucion/ajax/asignar-operador-institucional-modal-ajax", "command",institucionOperadorBean);
		mav.addObject("institucionOperadorBean",new InstitucionOperadorBean());
		this.listarCombos(mav,1);
		return mav;
	}
	
	@RequestMapping(value = "/modificarInstOperador", method = RequestMethod.GET)
	public ModelAndView modificarInstOperador(@RequestParam("codigo") Integer codigo ,HttpServletRequest request)throws Exception {
		InstitucionOperadorBean prmInstitucionOperadorBean = new InstitucionOperadorBean();
		prmInstitucionOperadorBean.setCodigo(codigo);
		
		
		institucionOperadorBean = this.getInstitucionOperadorService().getBuscarPorObjecto(prmInstitucionOperadorBean);
		
		ModelAndView mav = new ModelAndView("general/institucion/ajax/asignar-operador-institucional-modal-ajax", "command",institucionOperadorBean);
		mav.addObject("institucionOperadorBean",institucionOperadorBean);
		this.listarCombos(mav,1);
		return mav;
	}
	
	@RequestMapping(value = "/eliminarInstOperador", method = RequestMethod.GET)
	@ResponseBody
	public void eliminarInstOperador(@RequestParam("codigo") Integer codigo, HttpServletRequest request) {
		boolean sw = false;
		System.out.println("eliminar codigoDirector :" + codigo);
		InstitucionForm institucionForm = new InstitucionForm(); 
		institucionOperadorBean= new InstitucionOperadorBean(); 

		try {
			//ip
			boolean habilitadoIp = true;
			PeticionBean prmIntento = new PeticionBean();
			prmIntento.setIpConexion(request.getRemoteAddr());
			prmIntento.setUrlPeticion("InstitucionController/eliminarInstOperador");
			habilitadoIp = peticionService.existe(prmIntento);
	        if(habilitadoIp) {
	        	institucionOperadorBean.setCodigo(codigo);
	    		institucionForm.setInstitucionOperadorBean(institucionOperadorBean);
	        	this.setAuditoria(institucionOperadorBean, request, false);
	        	sw = (this.getInstitucionOperadorService().eliminar(institucionOperadorBean));	        	
	        }

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/guardarInstOperador", method = RequestMethod.POST)
	public @ResponseBody String guardarInstOperador(@ModelAttribute("institucionOperadorBean") InstitucionOperadorBean institucionOperadorBean, HttpServletRequest request)throws Exception {
		System.out.println("institucionOperadorBean.getCodigoPersona() " + institucionOperadorBean.getCodigoPersona());
		boolean sw =  false;
		String valor = "";
		
		//ip
		boolean habilitadoIp = true;
		PeticionBean prmIntento = new PeticionBean();
		prmIntento.setIpConexion(request.getRemoteAddr());
		prmIntento.setUrlPeticion("InstitucionController/guardarInstOperador");
		habilitadoIp = peticionService.existe(prmIntento);
        if(habilitadoIp) {
        	if (institucionOperadorBean.getCodigoPersona() == 0) {
    			valor ="3";
    		} else{
    			try {
    				
    	        	if (institucionOperadorBean.getCodigo() == 0) {
    					//this.setAuditoria(institucionOperadorBean, request, true);
    					this.setAuditoria(institucionOperadorBean, request, true);
    					sw = (this.getInstitucionOperadorService().insertar(institucionOperadorBean));
    					//ahora vamos a validar cuando ya existe este oprador
    					if (institucionOperadorBean.getCodigo()!= 0) {
    						System.out.println("inserto operador");
    						sw = true;
    					}else{
    						System.out.println("ya existe ese operador");
    						sw = false;
    					}
    				}else{
    					//this.setAuditoria(institucionOperadorBean, request, false);
    					this.setAuditoria(institucionOperadorBean, request, false);
    					sw = (this.getInstitucionOperadorService().actualizar(institucionOperadorBean));	
    				}
    				
    			} catch (Exception e) {
    				e.printStackTrace();
    			}  
    			System.out.println("sw" + sw); 
    			if (sw) {
    				valor = "1";
    			}else{
    				valor = "0";
    			}
    		} 
        } else {
        	valor = "0";
        }
		
		return valor;
	}
	
	@RequestMapping(value = "/consultarPorDocumentoPersona", method = RequestMethod.GET)
	public @ResponseBody PersonaBean consultarPorDocumentoPersona(@RequestParam("tipo") String tipo,@RequestParam("numero") String numero)throws Exception {
		
		PersonaBean personaBean = new PersonaBean();
		personaBean.getTipoDocumento().setCodigoRegistro(VO.toInteger(tipo));
		personaBean.setNumeroDocumento(numero);
		
		PersonaBean opersonaBean = null;
		opersonaBean = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(personaBean);
		
		if (opersonaBean!= null ) {
			System.out.println("personaBean no es null " + opersonaBean.getCodigo());
			return opersonaBean;
		}else{
			System.out.println("personaBean es null" );
			return null;
		}
	}
	
	@RequestMapping(value = "/refrescarListaInstOperador", method = RequestMethod.GET)
	public @ResponseBody List<InstitucionOperadorBean> refrescarListaInstOperador(@RequestParam("codigoInst") int codigoInst)throws Exception {
		List<InstitucionOperadorBean> lstInstitucionOperadorBean = new ArrayList<InstitucionOperadorBean>();
		
		InstitucionOperadorBean prmInstitucionOperadorBean = new InstitucionOperadorBean();
		prmInstitucionOperadorBean.setCodigoInstitucion(codigoInst);
		
		lstInstitucionOperadorBean = institucionOperadorService.getBuscarPorFiltros(prmInstitucionOperadorBean);
		
		return lstInstitucionOperadorBean;
	}
	
	/** FIN MANTENIMIENTO INSTITUCION - OPERADOR **/

	/** Validar si existe nombre corto una institucion  **/
	@RequestMapping(value = "/existe", method = RequestMethod.GET)
	public @ResponseBody String existe(@RequestParam("nombre") String nombre,
									   @RequestParam("codigoInstitucion") String codigoInstitucion,
									   HttpServletRequest request) {
		boolean sw = false;
		InstitucionBean institucionBean =  new InstitucionBean();
		institucionBean.setNombreCorto(nombre);		
		if (codigoInstitucion == "") {
			institucionBean.setCodigo(0);
		}else{
			institucionBean.setCodigo(Long.valueOf(codigoInstitucion.toString()));
		}

		try {
			sw = (this.getInstitucionService().existe(institucionBean));

		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
		}
		System.out.println("sw"+ sw);
		if (sw) {
			return "1"; 
		}else{
			return "0";
		}	
		
	}
	@RequestMapping(value = "/existeInst", method = RequestMethod.GET)
	public @ResponseBody String existeInst(	@RequestParam("nombre") String nombre,											 
											 HttpServletRequest request) {
		boolean sw = false;
		System.out.println("ingreso a validar si existe");
		InstitucionBean institucionBean =  new InstitucionBean();
		institucionBean.setNombreCorto("");
		institucionBean.setNombreInstitucion(nombre);
		try {
			sw = (this.getInstitucionService().existe(institucionBean));

		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
		}
		System.out.println("sw"+ sw);
		if (sw) {
			return "1"; 
		}else{
			return "0";
		}	
		
	}

	public void setValoresPredeterminados(InstitucionBean institucionBean) {
		institucionBean.setNombreInstitucion("");
		institucionBean.getSituacion().setCodigoRegistro(0);
	}

	public InstitucionBean getInstitucionBean() {
		return institucionBean;
	}

	public void setInstitucionBean(InstitucionBean institucionBean) {
		this.institucionBean = institucionBean;
	}

	public List<MaestraBean> getLstTipo() {
		return lstTipo;
	}

	public void setLstTipo(List<MaestraBean> lstTipo) {
		this.lstTipo = lstTipo;
	}

	public List<MaestraBean> getLstSituacion() {
		return lstSituacion;
	}

	public void setLstSituacion(List<MaestraBean> lstSituacion) {
		this.lstSituacion = lstSituacion;
	}

	public InstitucionService getInstitucionService() {
		return institucionService;
	}

	public void setInstitucionService(InstitucionService institucionService) {
		this.institucionService = institucionService;
	}

	public List<MaestraBean> getLstTipoActividad() {
		return lstTipoActividad;
	}

	public void setLstTipoActividad(List<MaestraBean> lstTipoActividad) {
		this.lstTipoActividad = lstTipoActividad;
	}

	public List<UbigeoBean> getLstRegion() {
		return lstRegion;
	}

	public void setLstRegion(List<UbigeoBean> lstRegion) {
		this.lstRegion = lstRegion;
	}

	public List<UbigeoBean> getLstProvincia() {
		return lstProvincia;
	}

	public void setLstProvincia(List<UbigeoBean> lstProvincia) {
		this.lstProvincia = lstProvincia;
	}

	public List<UbigeoBean> getLstDistrito() {
		return lstDistrito;
	}

	public void setLstDistrito(List<UbigeoBean> lstDistrito) {
		this.lstDistrito = lstDistrito;
	}

	public UbigeoService getUbigeoService() {
		return ubigeoService;
	}

	public void setUbigeoService(UbigeoService ubigeoService) {
		this.ubigeoService = ubigeoService;
	}

	public UbigeoBean getUbigeoBean() {
		return ubigeoBean;
	}

	public void setUbigeoBean(UbigeoBean ubigeoBean) {
		this.ubigeoBean = ubigeoBean;
	}

	public List<MaestraBean> getLstAreaGeografica() {
		return lstAreaGeografica;
	}

	public void setLstAreaGeografica(List<MaestraBean> lstAreaGeografica) {
		this.lstAreaGeografica = lstAreaGeografica;
	}

	public List<MaestraBean> getLstTipoDocumento() {
		return lstTipoDocumento;
	}

	public void setLstTipoDocumento(List<MaestraBean> lstTipoDocumento) {
		this.lstTipoDocumento = lstTipoDocumento;
	}

	public InstitucionDirectorBean getInstitucionDirectorBean() {
		return institucionDirectorBean;
	}

	public void setInstitucionDirectorBean(InstitucionDirectorBean institucionDirectorBean) {
		this.institucionDirectorBean = institucionDirectorBean;
	}

	public Maestra1Service getMaestra1Service() {
		return maestra1Service;
	}

	public void setMaestra1Service(Maestra1Service maestra1Service) {
		this.maestra1Service = maestra1Service;
	}

	public InstitucionDirectorService getInstitucionDirectorService() {
		return institucionDirectorService;
	}

	public void setInstitucionDirectorService(InstitucionDirectorService institucionDirectorService) {
		this.institucionDirectorService = institucionDirectorService;
	}

	public InstitucionForm getInstitucionForm() {
		return institucionForm;
	}

	public void setInstitucionForm(InstitucionForm institucionForm) {
		this.institucionForm = institucionForm;
	}

	public List<InstitucionDirectorBean> getLstInstitucionDirectorBean() {
		return lstInstitucionDirectorBean;
	}

	public void setLstInstitucionDirectorBean(List<InstitucionDirectorBean> lstInstitucionDirectorBean) {
		this.lstInstitucionDirectorBean = lstInstitucionDirectorBean;
	}

	public InstitucionOperadorBean getInstitucionOperadorBean() {
		return institucionOperadorBean;
	}

	public void setInstitucionOperadorBean(InstitucionOperadorBean institucionOperadorBean) {
		this.institucionOperadorBean = institucionOperadorBean;
	}

	public List<InstitucionOperadorBean> getLstInstitucionOperadorBean() {
		return lstInstitucionOperadorBean;
	}

	public void setLstInstitucionOperadorBean(List<InstitucionOperadorBean> lstInstitucionOperadorBean) {
		this.lstInstitucionOperadorBean = lstInstitucionOperadorBean;
	}

	public InstitucionOperadorService getInstitucionOperadorService() {
		return institucionOperadorService;
	}

	public void setInstitucionOperadorService(InstitucionOperadorService institucionOperadorService) {
		this.institucionOperadorService = institucionOperadorService;
	}

	public List<LenguaBean> getLstLengua() {
		return lstLengua;
	}
	public void setLstLengua(List<LenguaBean> lstLengua) {
		this.lstLengua = lstLengua;
	}
	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}
	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}
	public LenguaService getLenguaService() {
		return lenguaService;
	}
	public void setLenguaService(LenguaService lenguaService) {
		this.lenguaService = lenguaService;
	}
	public InstitucionLenguaBean getInstitucionLenguaBean() {
		return institucionLenguaBean;
	}
	public void setInstitucionLenguaBean(InstitucionLenguaBean institucionLenguaBean) {
		this.institucionLenguaBean = institucionLenguaBean;
	}
	public InstitucionLenguaService getInstitucionLenguaService() {
		return institucionLenguaService;
	}
	public void setInstitucionLenguaService(
			InstitucionLenguaService institucionLenguaService) {
		this.institucionLenguaService = institucionLenguaService;
	}
	public List<InstitucionLenguaBean> getLstInstitucionLenguaBean() {
		return lstInstitucionLenguaBean;
	}
	public void setLstInstitucionLenguaBean(
			List<InstitucionLenguaBean> lstInstitucionLenguaBean) {
		this.lstInstitucionLenguaBean = lstInstitucionLenguaBean;
	}

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	public InstitucionSedeBean getInstitucionSedeBean() {
		return institucionSedeBean;
	}

	public void setInstitucionSedeBean(InstitucionSedeBean institucionSedeBean) {
		this.institucionSedeBean = institucionSedeBean;
	}

	public InstitucionSedeService getInstitucionSedeService() {
		return institucionSedeService;
	}

	public void setInstitucionSedeService(
			InstitucionSedeService institucionSedeService) {
		this.institucionSedeService = institucionSedeService;
	}

	public List<InstitucionSedeBean> getLstInstitucionSede() {
		return lstInstitucionSede;
	}

	public void setLstInstitucionSede(List<InstitucionSedeBean> lstInstitucionSede) {
		this.lstInstitucionSede = lstInstitucionSede;
	}
	
	
}