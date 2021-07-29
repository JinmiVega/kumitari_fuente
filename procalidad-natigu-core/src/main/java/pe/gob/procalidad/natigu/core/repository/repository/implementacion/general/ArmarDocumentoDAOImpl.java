package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.ArmarDocumentoBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcArmadocu;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.ArmarDocumentoDAO;

@Transactional
@Repository("armarDocumentoDAO")
public class ArmarDocumentoDAOImpl implements ArmarDocumentoDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(ArmarDocumentoBean armarDocumentoBean) throws DAOException {
		Object idArmarDocumento = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarmadocu.insertar");
			spq.setParameter("p_codarmdoccab", armarDocumentoBean.getArmarDocumentoCabBean().getCodigo());
			spq.setParameter("p_tm2pardoc", armarDocumentoBean.getParteDocumento());
			spq.setParameter("p_tradtm2pdoc", armarDocumentoBean.getTraduccionParteDoc());
			spq.setParameter("p_descripcion", armarDocumentoBean.getDescripcion());
			spq.setParameter("p_codusureg", armarDocumentoBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", armarDocumentoBean.getIpCreacion());
			
			spq.execute();
			
			idArmarDocumento = spq.getOutputParameterValue(1);
			if(idArmarDocumento != null)
			{
				armarDocumentoBean.setCodigo(Integer.valueOf(idArmarDocumento.toString()));
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
	public boolean actualizar(ArmarDocumentoBean armarDocumentoBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarmadocu.actualizar");
			spq.setParameter("p_codarmdoc", armarDocumentoBean.getCodigo());
			spq.setParameter("p_tm2pardoc", armarDocumentoBean.getParteDocumento());
			spq.setParameter("p_tradtm2pdoc", armarDocumentoBean.getTraduccionParteDoc());
			spq.setParameter("p_descripcion", armarDocumentoBean.getDescripcion());
			spq.setParameter("p_codusumod", armarDocumentoBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", armarDocumentoBean.getIpModificacion());
			
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
	public boolean eliminar(ArmarDocumentoBean armarDocumentoBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarmadocu.eliminar");
			spq.setParameter("p_codarmdoc", armarDocumentoBean.getCodigo());
			spq.setParameter("p_codusumod", armarDocumentoBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", armarDocumentoBean.getIpModificacion());
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
	public ArmarDocumentoBean getBuscarPorObjecto(ArmarDocumentoBean armarDocumentoCabBean) throws DAOException {
		List<LeotbcArmadocu> 	lstPregunta 	= null;
		ArmarDocumentoBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarmadocu.buscar_por_codigo");
		spq.setParameter("p_codarmdoc", 	armarDocumentoCabBean.getCodigo());
		
		if (spq.execute()) 
		{
			lstPregunta =  spq.getResultList(); 
		} 
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{
			bean = deArmarDocAArmarDocBean(lstPregunta.get(0));
		}
		return bean;

	}

	@Override
	public List<ArmarDocumentoBean> getBuscarPorFiltros(ArmarDocumentoBean armarDocumentoCabBean) throws DAOException {
		List<LeotbcArmadocu> 	lstPregunta 	= null;
		List<ArmarDocumentoBean> 	lstPreguntaBean = null;
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarmadocu.buscar_por_filtro");
		spq.setParameter("p_codarmdoccab", armarDocumentoCabBean.getArmarDocumentoCabBean().getCodigo());
		if (spq.execute()) {
			lstPregunta =  spq.getResultList(); 
		} 
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{			
			lstPreguntaBean = deListaArmarDocAListaArmarDocBean(lstPregunta);
		}
		return lstPreguntaBean;
	}

	@Override
	public boolean existe(ArmarDocumentoBean armarDocumentoCabBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<ArmarDocumentoBean> listarArmarDocuCabDetTodo(ArmarDocumentoBean armarDocumentoBean)
			throws DAOException {
		List<LeotbcArmadocu> listaArmarDocumento = null;
		List<ArmarDocumentoBean> listaArmarDocumentoBean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarmadocu.listarArmarDocuCabDetTodo");
		spq.setParameter("p_codmatpej", armarDocumentoBean.getArmarDocumentoCabBean().getMaterialTipoEjercicioBean().getCodigo());
		if (spq.execute()) 
		{
			listaArmarDocumento =  spq.getResultList(); 
		} 
		if (listaArmarDocumento != null && listaArmarDocumento.size() > 0) 
		{			
			listaArmarDocumentoBean = deListaArmarDocAListaArmarDocBean(listaArmarDocumento);
		}
		return listaArmarDocumentoBean;
	}
	
	private List<ArmarDocumentoBean> deListaArmarDocAListaArmarDocBean(List<LeotbcArmadocu> lstPregunta) 
	{
		List<ArmarDocumentoBean> lstPreguntaBean = null;
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{
			lstPreguntaBean = new ArrayList<ArmarDocumentoBean>();
			for (int i = 0; i < lstPregunta.size(); i++) 
			{ 
				LeotbcArmadocu entity = lstPregunta.get(i);
				ArmarDocumentoBean bean = deArmarDocAArmarDocBean(entity);
				lstPreguntaBean.add(bean);
			}
		}
		return lstPreguntaBean;
	}
	

	private ArmarDocumentoBean deArmarDocAArmarDocBean(LeotbcArmadocu entity) 
	{
		ArmarDocumentoBean bean = null;
		
		if (entity != null) {
			bean = new ArmarDocumentoBean();
			bean.setCodigo(entity.getnCodarmdoc()); 
			bean.setParteDocumento(entity.getnTm2pardoc());
			bean.setDescripcion(entity.getvDescripcion());
			bean.setTraduccionParteDoc(entity.getvTradtm2pdoc());
			bean.getArmarDocumentoCabBean().setCodigo(entity.getnCodarmdoccab() != null ? entity.getnCodarmdoccab() : 0);
			bean.getArmarDocumentoCabBean().getMaestraTipoDoc().setCodigoRegistro(entity.getN_tm2tipdoc() != null ? entity.getN_tm2tipdoc() : 0);
			bean.getArmarDocumentoCabBean().getMaestraTipoDoc().setNombreCorto(entity.getV_nomcorto());
			bean.getArmarDocumentoCabBean().setTipoDocumento(entity.getN_tm2tipdoc());
			bean.getArmarDocumentoCabBean().setTitulo(entity.getV_titulo_cab());
		}
		return bean;
	}

}