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
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcTextopalabracorrecta;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException; 
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.TextoPalabraCorrectaDAO;

@Transactional
@Repository("textoPalabraCorrectaDAO")
public class TextoPalabraCorrectaDAOImpl implements TextoPalabraCorrectaDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(TextoPalabraCorrectaBean textoPalabraCorrectaBean) throws DAOException {
		Object idtextoPalaCorrec = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_textopalabracorrecta.insertar");
			spq.setParameter("p_codmatpej", textoPalabraCorrectaBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_titulo", textoPalabraCorrectaBean.getTitulo());
			spq.setParameter("p_comentario", textoPalabraCorrectaBean.getComentario());
			spq.setParameter("p_texto", textoPalabraCorrectaBean.getTexto()); 
			spq.setParameter("p_codusureg", textoPalabraCorrectaBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", textoPalabraCorrectaBean.getIpCreacion()); 
			
			spq.execute();
			
			idtextoPalaCorrec = spq.getOutputParameterValue(1);
			if(idtextoPalaCorrec != null)
			{
				textoPalabraCorrectaBean.setCodigo(Integer.valueOf(idtextoPalaCorrec.toString()));
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
	public boolean actualizar(TextoPalabraCorrectaBean textoPalabraCorrectaBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_textopalabracorrecta.actualizar");
			spq.setParameter("p_codtextopalabracorrec", textoPalabraCorrectaBean.getCodigo());
			spq.setParameter("p_codmatpej", textoPalabraCorrectaBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_titulo", textoPalabraCorrectaBean.getTitulo());
			spq.setParameter("p_comentario", textoPalabraCorrectaBean.getComentario());
			spq.setParameter("p_texto", textoPalabraCorrectaBean.getTexto()); 
			spq.setParameter("p_codusumod", textoPalabraCorrectaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", textoPalabraCorrectaBean.getIpModificacion()); 
			
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
	public boolean eliminar(TextoPalabraCorrectaBean textoPalabraCorrectaBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_textopalabracorrecta.eliminar");
			spq.setParameter("p_codtextopalabracorrec", textoPalabraCorrectaBean.getCodigo());
			spq.setParameter("p_codusumod", textoPalabraCorrectaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", textoPalabraCorrectaBean.getIpModificacion()); 
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
	public TextoPalabraCorrectaBean getBuscarPorObjecto(TextoPalabraCorrectaBean textoPalabraCorrectaBean) throws DAOException {
		List<LeotbcTextopalabracorrecta> 	lstLeotbcTextopalabracorrecta	= null;
		TextoPalabraCorrectaBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_textopalabracorrecta.buscar_por_codigo");
		spq.setParameter("p_codtextopalabracorrec", 	textoPalabraCorrectaBean.getCodigo());
		
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
	public List<TextoPalabraCorrectaBean> getBuscarPorFiltros(TextoPalabraCorrectaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(TextoPalabraCorrectaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TextoPalabraCorrectaBean> buscarPorMaterialEjercicio(MaterialEjercicioBean materialEjercicioBean)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TextoPalabraCorrectaBean getBuscarPorTEM(TextoPalabraCorrectaBean textoPalabraCorrectaBean) 	throws DAOException {
		List<LeotbcTextopalabracorrecta> 	lstLeotbcTextopalabracorrecta	= null;
		TextoPalabraCorrectaBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_textopalabracorrecta.buscar_por_Filtros");
		spq.setParameter("p_codmatpej", 	textoPalabraCorrectaBean.getMaterialTipoEjercicioBean().getCodigo());
		 
		
		if (spq.execute()) {
			lstLeotbcTextopalabracorrecta =  spq.getResultList(); 
		} 
		if (lstLeotbcTextopalabracorrecta != null && lstLeotbcTextopalabracorrecta.size() > 0) {			
			bean = deLeotbcTextopalabracorrectaATextoPalabraCorrectaBean(lstLeotbcTextopalabracorrecta.get(0));
		}
		
		return bean;
	}

	

	private List<TextoPalabraCorrectaBean> deListaLeotbcTextopalabracorrectaAListaTextoPalabraCorrectaBean(List<LeotbcTextopalabracorrecta> lstLeotbcTextopalabracorrecta) {
		
		List<TextoPalabraCorrectaBean> lstTextoPalabraCorrectaBean = null;
	
		if (lstLeotbcTextopalabracorrecta != null && lstLeotbcTextopalabracorrecta.size() > 0) {
			
			lstTextoPalabraCorrectaBean = new ArrayList<TextoPalabraCorrectaBean>();
			
			for (int i = 0; i < lstLeotbcTextopalabracorrecta.size(); i++) { 
				LeotbcTextopalabracorrecta entity = lstLeotbcTextopalabracorrecta.get(i);
				TextoPalabraCorrectaBean bean = deLeotbcTextopalabracorrectaATextoPalabraCorrectaBean(entity);
				
				lstTextoPalabraCorrectaBean.add(bean);
			}
		}
		
		return lstTextoPalabraCorrectaBean;
	}
	

	private TextoPalabraCorrectaBean deLeotbcTextopalabracorrectaATextoPalabraCorrectaBean(LeotbcTextopalabracorrecta entity) {
		
		TextoPalabraCorrectaBean bean = null;
		
		if (entity != null) {
			bean = new TextoPalabraCorrectaBean();
			bean.setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
			bean.setCodigo(entity.getnCodtextopalabracorrec());
			bean.getMaterialTipoEjercicioBean().setCodigo(entity.getnCodmatpej());
			bean.setTitulo(entity.getvTitulo());
			bean.setComentario(entity.getvComentario());
			bean.setTexto(entity.getvTexto()); 
 
		}
		return bean;
	} 
	 
	 
	
}