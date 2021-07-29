package pe.gob.procalidad.natigu.web.gestion.controller.configuracion;

import java.nio.charset.CodingErrorAction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.gob.procalidad.natigu.core.bean.bean.academico.AlumnoMonedaGBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.AdquisicionUsuarioBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.FondoBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioConfiguracionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;

@Controller
@RequestMapping(value = "adquisicion")
@SessionAttributes("usuarioEstudiante")
public class AdquisicionUsuarioController extends BaseController{
	
	@RequestMapping(value = "/comprar", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> refrescarListaTienda(@RequestParam("codigoAdquisicion") Long codigoAdqui, @RequestParam("tipoAdquisicion") Integer tipoAdqui,
			 @RequestParam("codUsuaMat") Long codUsuaMat,SessionStatus status,
			HttpServletRequest request){		
		Map<String,Object> data = new HashMap<String,Object>();
		UsuarioBean usuarioAlumno = this.getUsuarioSesion(request);
		Integer respuesta = -1;
		try {
			
			AdquisicionUsuarioBean adquisicionBean = new AdquisicionUsuarioBean();
			adquisicionBean.setAudCodigoUsuario(usuarioAlumno.getCodigoUsuario());
			adquisicionBean.setEstado("1");
			adquisicionBean.setUsuario(usuarioAlumno);
			adquisicionBean.setTipoAdquisicion(new MaestraBean());
			adquisicionBean.getTipoAdquisicion().setCodigoRegistro(tipoAdqui);
			adquisicionBean.setSiatuacion(new MaestraBean());
			adquisicionBean.getSiatuacion().setCodigoRegistro(1);
			adquisicionBean.getUsuarioMatricula().setCodigo(codUsuaMat);
			if(tipoAdqui==1){
				adquisicionBean.setMascota(new MascotaBean());
				adquisicionBean.getMascota().setCodigo(codigoAdqui);
			}else if(tipoAdqui==2){
				adquisicionBean.setFondo(new FondoBean());
				adquisicionBean.getFondo().setCodFond(codigoAdqui.intValue());
			} else if(tipoAdqui==3){
				adquisicionBean.getCombo().setCodigo(codigoAdqui.intValue());
			}
			adquisicionBean.setAudHostIP(request.getRemoteAddr());
			respuesta = this.fs.getAdquisicionUsuarioService().realizarCompra(adquisicionBean);
			
			data.put("tipo", tipoAdqui);
			data.put("codigoAdqui", codigoAdqui);
			data.put("result", respuesta);
			if(respuesta==1){
				data.put("msj", "Compra Realizada");
			}else if(respuesta==0){
				data.put("msj", "Usted no cuenta con monedas");
			}else if(respuesta==2 || respuesta==-2){
				data.put("msj", "Usted no cuenta con las monedas suficientes");
			}

		} catch (Exception e) { 
			e.printStackTrace();
			return null;
		}
		return data;
	}
	
	@RequestMapping(value = "/listarAdquisicion", method = RequestMethod.GET)
	public @ResponseBody List<?> refrescarLista(@RequestParam("valor") Integer valor,BindingResult result, SessionStatus status,
			HttpServletRequest request){		

		List<AdquisicionUsuarioBean> lista = null;
		UsuarioBean usuarioAlumno = this.getUsuarioSesion(request);
		try {
			AdquisicionUsuarioBean adquisicionBean = new AdquisicionUsuarioBean();
			adquisicionBean.setUsuario(usuarioAlumno);
			adquisicionBean.setTipoAdquisicion(new MaestraBean());
			adquisicionBean.getTipoAdquisicion().setCodigoRegistro(valor);
			if(valor==1){
				/** TAB MASCOTAS **/
				MascotaBean filtroMascota = new MascotaBean();
				lista = this.fs.getAdquisicionUsuarioService().getBuscarPorFiltros(adquisicionBean);
				
			}else if(valor.equals("2")){
				/** TAB FONDOS **/
				FondoBean filtroFondo = new FondoBean();
				filtroFondo.getSituacion().setCodigoRegistro(1);
				lista = this.fs.getAdquisicionUsuarioService().getBuscarPorFiltros(adquisicionBean);
				
			}else if(valor.equals("3")){
				/** TAB COMBOS **/
				return null;
			}else{
				/** TAB BONUS **/
				return null;
			}

		} catch (Exception e) { 
			e.printStackTrace();
			return null;
		}
		return lista;
	}
	
	@RequestMapping(value = "/actualizarmonedaxcompra", method = RequestMethod.POST)
	public @ResponseBody String doActualizarmonedaxcompra(@RequestParam("p_codusumat") Long p_codusumat,@RequestParam("p_cantmonedas") int p_cantmonedas,HttpServletRequest request){
		
		System.out.println("modificar p_codusumat: " + p_codusumat);
		System.out.println("modificar p_cantmonedas: " + p_cantmonedas);
		
		AlumnoMonedaGBean prmAlumnoMonedaGBean = new AlumnoMonedaGBean();
		prmAlumnoMonedaGBean.getUsuarioMatriculaBean().setCodigo(p_codusumat); 
		prmAlumnoMonedaGBean.setNumeroMonedas(p_cantmonedas);
		
		boolean sw = true;
		try {
			if (prmAlumnoMonedaGBean.getUsuarioMatriculaBean().getCodigo()!=0) { 
				sw = (this.fs.getAlumnoMonedaGService().actualizarmonedaxcompra(prmAlumnoMonedaGBean));
			}else{
					System.out.println("no ingreso a  actulizar ");		
				}
			
			

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			return "1";
		}else{
			return "0";
		}
	} 
	
	
	
	
}
