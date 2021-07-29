package pe.gob.procalidad.natigu.web.gestion.controller.seguridad;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaAccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaDetalleBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaTablaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PerfilBean;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.controller.seguridad.view.AuditoriaForm;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;

@Controller
@Scope(value="session")
@RequestMapping(value = "auditoriaController")
public class AuditoriaController extends BaseController{
	
	private AuditoriaForm auditoriaForm;
	
	private List<AuditoriaTablaBean> lstAuditoriaTabla;
	private List<PerfilBean> lstPerfiles;
	
	@PostConstruct
	public void init(){
		this.setAuditoriaForm(new AuditoriaForm());
	}
	
	@RequestMapping(value = "/consulta", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("auditoriaForm") AuditoriaForm bean)throws Exception {
		ModelAndView mav = new ModelAndView("seguridad/auditoria/auditoria-consulta", "command",bean);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/listarAuditoria", method = RequestMethod.GET)
	@ResponseBody
	public List<AuditoriaBean> doListadoAuditoria(@ModelAttribute("auditoriaForm") AuditoriaForm bean)throws Exception {
		
		List<AuditoriaBean> lista = new ArrayList<AuditoriaBean>();
		
		try {
			
			lista = this.fs.getAuditoriaService().getBuscarPorFiltros(bean.getAuditoriaBean());
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return lista;
	}
	
	@RequestMapping(value = "/listarAuditoriaDetalle", method = RequestMethod.GET)
	@ResponseBody
	public List<AuditoriaDetalleBean> doListadoAuditoriaDetalle(@RequestParam("codauditoria") String codauditoria, HttpServletRequest request)throws Exception {
		
		List<AuditoriaDetalleBean> lista = null;
		AuditoriaDetalleBean filtro = new AuditoriaDetalleBean();
		filtro.getAuditoriaBean().setCodigo(VO.toLong(codauditoria));
		
		try {
			
			lista = this.fs.getAuditoriaService().listarAuditoriaDetalle(filtro);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return lista;
	}
	
	@RequestMapping(value = "/listarAuditoriaAcceso", method = RequestMethod.GET)
	@ResponseBody
	public List<AuditoriaAccesoBean> doListadoAuditoriaAcceso(@ModelAttribute("auditoriaForm") AuditoriaForm bean)throws Exception {
		
		List<AuditoriaAccesoBean> lista = new ArrayList<AuditoriaAccesoBean>();
		
		try {
			
			lista = this.fs.getAuditoriaService().listarAuditoriaAcceso(bean.getAuditoriaAccesoBean());
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return lista;
	}
	
	/*private ModelAndView getLista(AccesoBean accesoBean) {
		
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

		ModelAndView mav = new ModelAndView("seguridad/auditoria/auditoria-consulta", "command",new AuditoriaBean());
		mav.addObject("accesoBean", accesoBean);
		mav.addObject("lstAccesoBean", lstAccesoBean);
		mav.addObject("totalMenus", !VO.isEmptyList(lstAccesoBean) ? lstAccesoBean.size() : 0);
		this.cargarCombos(mav);
		return mav;
	}*/

	private void cargarCombos(ModelAndView mav){
		lstPerfiles=null;
		lstAuditoriaTabla=null;
		try {
			if (lstAuditoriaTabla==null) {
				lstAuditoriaTabla = this.fs.getAuditoriaService().listarTablas(new AuditoriaTablaBean());
			}
			if (lstPerfiles==null) {
				lstPerfiles = this.fs.getPerfilService().getBuscarPorFiltros(new PerfilBean());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	
		mav.addObject("lstAuditoriaTabla",lstAuditoriaTabla);
		mav.addObject("lstPerfiles",lstPerfiles); 
	}
	
	public AuditoriaForm getAuditoriaForm() {
		return auditoriaForm;
	}

	public void setAuditoriaForm(AuditoriaForm auditoriaForm) {
		this.auditoriaForm = auditoriaForm;
	}
	
}