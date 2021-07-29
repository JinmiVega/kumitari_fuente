package pe.gob.procalidad.natigu.web.gestion.controller.general;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.gob.procalidad.natigu.core.bean.bean.generico.LeccionMaterialBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.LenguaEstructuraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.UnidadLeccionBean;
import pe.gob.procalidad.natigu.web.gestion.controller.base.BaseController;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.VO;
import pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt.Encrypt;

@Controller
@RequestMapping(value = "navegacion")
public class NavegacionController extends BaseController {
	
	@RequestMapping(value = "/cargarNiveles", method = RequestMethod.GET)
	@ResponseBody 
	public List<LenguaEstructuraBean> cargarNiveles(@RequestParam("codlengua") String codlengua)
	{
		List<LenguaEstructuraBean> lista = null;

		Encrypt.init("KEY_ENCRYPT_REL");
		
		try{
			if(codlengua.contains("#")){
				codlengua = codlengua.replace("#", "");
			}
			
			LenguaBean filtroNivel = new LenguaBean();
			filtroNivel.setCodigo(VO.toLong(Encrypt.decrypt(codlengua.replace("$", "/"))));
			lista = this.fs.getLenguaEstructuraService().listarNiveles(filtroNivel);

			for (LenguaEstructuraBean objNivel : lista) {
				LenguaEstructuraBean filtro = new LenguaEstructuraBean();
				filtro.getLenguaBean().setCodigo(VO.toLong(Encrypt.decrypt(codlengua.replace("$", "/"))));
				filtro.getNivel().setCodigoRegistro(objNivel.getNivel().getCodigoRegistro());
				List<LenguaEstructuraBean> listaSubNiveles = this.fs.getLenguaEstructuraService().listarSubNiveles(filtro);
				for (LenguaEstructuraBean lenguaEstructuraBean : listaSubNiveles) {
					lenguaEstructuraBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(lenguaEstructuraBean.getCodigo())).replace("/", "$"));
				}
				objNivel.setListaSubNivel(listaSubNiveles);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lista;
	}
	
	@RequestMapping(value = "/cargarUnidades", method = RequestMethod.GET)
	@ResponseBody 
	public List<UnidadBean> cargarUnidades(@RequestParam("codlenest") String codlenest)
	{
		List<UnidadBean> lista = null;
		
		try{
			UnidadBean filtro = new UnidadBean();
			filtro.getLenguaEstructuraBean().setCodigo(VO.toLong(codlenest));
//			filtro.getLenguaEstructuraBean().setCodigo(VO.toLong(Encrypt.decrypt(codlenest.replace("¥", "/"))));
			lista = this.fs.getUnidadService().getBuscarPorFiltros(filtro);
			for (UnidadBean unidadBean : lista) {
				unidadBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(unidadBean.getCodigo())).replace("/", "$"));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lista;
	}
	
	@RequestMapping(value = "/cargarLecciones", method = RequestMethod.GET)
	@ResponseBody 
	public List<UnidadLeccionBean> cargarLecciones(@RequestParam("codunidad") String codunidad)
	{
		List<UnidadLeccionBean> lista = null;
		
		try{
			UnidadBean filtro = new UnidadBean();
			filtro.setCodigo(VO.toLong(codunidad));
			lista = this.fs.getUnidadLeccionService().listarPorUnidad(filtro);
			for (UnidadLeccionBean unidadBean : lista) {
				unidadBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(unidadBean.getCodigo())).replace("/", "$"));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lista;
	}
	
	@RequestMapping(value = "/cargarMateriales", method = RequestMethod.GET)
	@ResponseBody 
	public List<LeccionMaterialBean> cargarMateriales(@RequestParam("codleccion") String codleccion)
	{
		List<LeccionMaterialBean> lista = null;
		
		try{
			LeccionMaterialBean filtro = new LeccionMaterialBean();
			filtro.getUnidadLeccionBean().setCodigo(VO.toLong(codleccion));
			lista = this.fs.getLeccionMaterialService().buscarPorLeccion(filtro);
			for (LeccionMaterialBean leccionMaterialBean : lista) {
				leccionMaterialBean.setCodigoEncrypt(Encrypt.encrypt(String.valueOf(leccionMaterialBean.getCodigo())).replace("/", "$"));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lista;
	}
	
	@RequestMapping(value = "/cargarEjercicios", method = RequestMethod.GET)
	@ResponseBody 
	public List<MaterialTipoEjercicioBean> cargarEjercicios(@RequestParam("codmaterial") String codmaterial)
	{
		List<MaterialTipoEjercicioBean> lista = null;
		
		try{
			MaterialTipoEjercicioBean filtro = new MaterialTipoEjercicioBean();
			filtro.getLeccionMaterialBean().setCodigo(VO.toLong(codmaterial));
			//filtro.getSituacionTipo().setCodigoRegistro(1);
			lista = this.fs.getMaterialTipoEjercicioService().getBuscarPorFiltros(filtro);	
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		return lista;
	}
	
}