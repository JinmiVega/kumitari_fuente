package pe.gob.procalidad.natigu.web.gestion.controller.general;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.procalidad.natigu.core.bean.bean.generico.AlterTextoPalabraEncerradaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.AlternativaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LeccionMaterialBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.ResourceUtil;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.Encrypt;

@Controller
@RequestMapping(value = "ejercicio")
public class EjercicioController extends BaseController {

	private int numero_intentos = 1;
	
	
	@RequestMapping(value = "/verificarAlternativa", method = RequestMethod.GET)
	@ResponseBody 
	public boolean doValidarAlternativa(@RequestParam("codalter") String codalter)
	{
		boolean result = false;
		
		try{
			AlternativaBean filtroAlt = new AlternativaBean();
			filtroAlt.setCodigo(VO.toLong(codalter));
			
			AlternativaBean prmAlternativaBean = this.fs.getAlternativaService().getBuscarPorObjecto(filtroAlt);
			
			if(!VO.isNull(prmAlternativaBean)){
				if(prmAlternativaBean.getRespuestaEstado().equals("1")){
					result = true;
					numero_intentos = 1;
				}else{
					numero_intentos++;
				}
			}else{
				numero_intentos++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return result;
	}
	
	@RequestMapping(value = "/cargarMaterialActual", method = RequestMethod.GET)
	public ModelAndView cargarMaterialActual(	@RequestParam("codmaterial") String codmaterial, 
												HttpServletRequest request,
												HttpServletResponse response) {
		
		LeccionMaterialBean materialBean_Actual = null;
		ModelAndView mav = null;
		
		try {
			/** CARGAR MATERIAL **/
			LeccionMaterialBean filtro = new LeccionMaterialBean();
			filtro.setCodigo(VO.toLong(codmaterial));
			materialBean_Actual = this.fs.getLeccionMaterialService().getBuscarPorObjecto(filtro);
			
			if(!VO.isNull(materialBean_Actual)){
				mav = new ModelAndView("ejercicios/ajax/material-dato", "command",materialBean_Actual);
				mav.addObject("material", materialBean_Actual);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value = "/verificarValor", method = RequestMethod.GET)
	@ResponseBody 
	public boolean doDesencriptar( @RequestParam("dato1") String preguEncrypt,
								   @RequestParam("dato2") String alterEncrypt,
								   @RequestParam("tipo") int tipo)
	{
		String preguDecrypt = "";
		String alterDecrypt = "";
		boolean sw = false;
		
		try{
			
			if(tipo == 1){ // RELACION DE 1 Y 2
				Encrypt.init("KEY_ENCRYPT_PREGU");
				preguDecrypt = Encrypt.decrypt(preguEncrypt);
				
				Encrypt.init("KEY_ENCRYPT_ALTER");
				alterDecrypt = Encrypt.decrypt(alterEncrypt);
			}else if(tipo == 2){  // RELACION DE 2 Y 3
				Encrypt.init("KEY_ENCRYPT_ALTER");
				preguDecrypt = Encrypt.decrypt(preguEncrypt);
				
				Encrypt.init("KEY_ENCRYPT_REL");
				alterDecrypt = Encrypt.decrypt(alterEncrypt);
			}else {  // RELACION DE 1 Y 0
				Encrypt.init("KEY_ENCRYPT_PREGU");
				preguDecrypt = Encrypt.decrypt(preguEncrypt);
				 
			}
			
			if(!VO.isEmpty(preguDecrypt) && !VO.isEmpty(alterDecrypt) && tipo == 1){
				if( preguDecrypt.equals(alterDecrypt) ){
					sw = true;
				}
			}else if(!VO.isEmpty(preguDecrypt) && !VO.isEmpty(alterDecrypt) && tipo == 2){
				if( preguDecrypt.equals(alterDecrypt) ){
					sw = true;
				}
			}else if( !VO.isEmpty(preguDecrypt) &&  tipo == 3){
				if( preguDecrypt.equals(alterEncrypt) ){
					sw = true;
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sw;
	}
	
	/** VALIDAR COMPLETAR PALABRAS **/
	@RequestMapping(value = "/validarCompletarPalabras", method = RequestMethod.POST)
	@ResponseBody 
	public AlterTextoPalabraEncerradaBean[] validarCompletarPalabras( @RequestBody AlterTextoPalabraEncerradaBean[] array)
	{
		
		try{
			Encrypt.init("KEY_ENCRYPT_PREGU");
			for (int i = 0; i < array.length; i++) {
				AlterTextoPalabraEncerradaBean bean = array[i];
				String input = bean.getPalabraRpta();
				if(!VO.isEmpty(input)){
					String respuesta = (!VO.isEmpty(bean.getValPreguEncrypt())) ? Encrypt.decrypt(bean.getValPreguEncrypt()) : "";
					if(!VO.isEmpty(respuesta)){
						if( input.toLowerCase().equals(respuesta.toLowerCase()) ){
							bean.setValValid(true);
						}else{
							bean.setValValid(false);
						}
					}else{
						bean.setValValid(false);
					}
				}else{
					bean.setValValid(false);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return array;
	}
	
}