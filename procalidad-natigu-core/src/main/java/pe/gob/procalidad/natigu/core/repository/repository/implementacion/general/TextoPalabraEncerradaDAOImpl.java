package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraEncerradaBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcTextopalabracorrecta;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcTextopalabraencerrada;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException; 
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.TextoPalabraCorrectaDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.TextoPalabraEncerradaDAO;

@Transactional
@Repository("textoPalabraencerradaDAO")
public class TextoPalabraEncerradaDAOImpl implements TextoPalabraEncerradaDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(TextoPalabraEncerradaBean t) throws DAOException {
		Object idtextoPalaCorrec = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_textopalabraencerrada.insertar");
			spq.setParameter("p_codmatpej", t.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_titulo", t.getTitulo());
			spq.setParameter("p_comentario", t.getComentario());
			spq.setParameter("p_texto", t.getTexto()); 
			spq.setParameter("p_codusureg", t.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", t.getIpCreacion()); 
			
			spq.execute();
			
			idtextoPalaCorrec = spq.getOutputParameterValue(1);
			if(idtextoPalaCorrec != null)
			{
				t.setCodigo(Integer.valueOf(idtextoPalaCorrec.toString()));
				sw=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean actualizar(TextoPalabraEncerradaBean t) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_textopalabraencerrada.actualizar");
			spq.setParameter("p_codtextopalabraence", t.getCodigo());
			spq.setParameter("p_codmatpej", t.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_titulo", t.getTitulo());
			spq.setParameter("p_comentario", t.getComentario());
			spq.setParameter("p_texto", t.getTexto()); 
			spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", t.getIpModificacion()); 
			
			spq.execute();   
			sw=true;
			 
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(TextoPalabraEncerradaBean t) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_textopalabraencerrada.eliminar");
			spq.setParameter("p_codtextopalabraence", t.getCodigo());
			spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", t.getIpModificacion()); 
			spq.execute();
			sw = true;
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public TextoPalabraEncerradaBean getBuscarPorObjecto(TextoPalabraEncerradaBean t) throws DAOException {
		List<LeotbcTextopalabraencerrada> 	lstLeotbcTextopalabracorrecta	= null;
		TextoPalabraEncerradaBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_textopalabraencerrada.buscar_por_codigo");
		spq.setParameter("p_codtextopalabraence", 	t.getCodigo());
		
		if (spq.execute()) 
		{
			lstLeotbcTextopalabracorrecta =  spq.getResultList(); 
		} 
		if (lstLeotbcTextopalabracorrecta != null && lstLeotbcTextopalabracorrecta.size() > 0) 
		{
			bean = deLeotbcTextopalabracorrectaATextoPalabraCorrectaBean(lstLeotbcTextopalabracorrecta.get(0));
		}
		return bean;
	}

	@Override
	public List<TextoPalabraEncerradaBean> getBuscarPorFiltros(TextoPalabraEncerradaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(TextoPalabraEncerradaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TextoPalabraEncerradaBean> buscarPorMaterialEjercicio(MaterialEjercicioBean materialEjercicioBean)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TextoPalabraEncerradaBean getBuscarPorTEM(TextoPalabraEncerradaBean textoPalabraEncerradaBean) throws DAOException {
		List<LeotbcTextopalabraencerrada> 	lstLeotbcTextopalabracorrecta	= null;
		TextoPalabraEncerradaBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_textopalabraencerrada.buscar_por_Filtros");
		spq.setParameter("p_codmatpej", 	textoPalabraEncerradaBean.getMaterialTipoEjercicioBean().getCodigo());
		 
		
		if (spq.execute()) {
			lstLeotbcTextopalabracorrecta =  spq.getResultList(); 
		} 
		if (lstLeotbcTextopalabracorrecta != null && lstLeotbcTextopalabracorrecta.size() > 0) {			
			bean = deLeotbcTextopalabracorrectaATextoPalabraCorrectaBean(lstLeotbcTextopalabracorrecta.get(0));
		}
		
		return bean;
	}

	private List<TextoPalabraEncerradaBean> deListaLeotbcTextopalabracorrectaAListaTextoPalabraCorrectaBean(List<LeotbcTextopalabraencerrada> lstLeotbcTextopalabracorrecta) {
		
		List<TextoPalabraEncerradaBean> lstTextoPalabraCorrectaBean = null;
	
		if (lstLeotbcTextopalabracorrecta != null && lstLeotbcTextopalabracorrecta.size() > 0) {
			
			lstTextoPalabraCorrectaBean = new ArrayList<TextoPalabraEncerradaBean>();
			
			for (int i = 0; i < lstLeotbcTextopalabracorrecta.size(); i++) { 
				LeotbcTextopalabraencerrada entity = lstLeotbcTextopalabracorrecta.get(i);
				TextoPalabraEncerradaBean bean = deLeotbcTextopalabracorrectaATextoPalabraCorrectaBean(entity);
				
				lstTextoPalabraCorrectaBean.add(bean);
			}
		}
		
		return lstTextoPalabraCorrectaBean;
	}
	

	private TextoPalabraEncerradaBean deLeotbcTextopalabracorrectaATextoPalabraCorrectaBean(LeotbcTextopalabraencerrada entity) {
		
		TextoPalabraEncerradaBean bean = null;
		
		if (entity != null) {
			bean = new TextoPalabraEncerradaBean();
			bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
			bean.setCodigo(entity.getnCodtextopalabraence());
			bean.getMaterialTipoEjercicioBean().setCodigo(entity.getnCodmatpej());
			bean.setTitulo(entity.getvTitulo());
			bean.setComentario(entity.getvComentario());
			bean.setTexto(entity.getvTexto()); 
 
		}
		return bean;
	} 
	
}