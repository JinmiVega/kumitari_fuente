package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.ArmarDocumentoBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.ArmarDocumentoCabBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionCabeceraBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcArmadocu;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcArmadocuCabecera;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcRelacionCab;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.ArmarDocumentoCabDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.RelacionCabeceraDAO;

@Transactional
@Repository("armarDocumentoCabDAO")
public class ArmarDocumentoCabDAOImpl implements ArmarDocumentoCabDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(ArmarDocumentoCabBean armarDocumentoCabBean) throws DAOException {
		Object idArmarDocumentoCab = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarmadocucab.insertar");
			spq.setParameter("p_codmatpej", armarDocumentoCabBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_tm2tipdoc", armarDocumentoCabBean.getTipoDocumento());
			spq.setParameter("p_titulo", armarDocumentoCabBean.getTitulo());
			spq.setParameter("p_codusureg", armarDocumentoCabBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", armarDocumentoCabBean.getIpCreacion());
			
			spq.execute();
			
			idArmarDocumentoCab = spq.getOutputParameterValue(1);
			if(idArmarDocumentoCab != null)
			{
				armarDocumentoCabBean.setCodigo(Integer.valueOf(idArmarDocumentoCab.toString()));
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
	public boolean actualizar(ArmarDocumentoCabBean armarDocumentoCabBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarmadocucab.actualizar");
			spq.setParameter("p_codarmdoccab", armarDocumentoCabBean.getCodigo());
			spq.setParameter("p_tm2tipdoc", armarDocumentoCabBean.getTipoDocumento());
			spq.setParameter("p_titulo", armarDocumentoCabBean.getTitulo());
			spq.setParameter("p_codusumod", armarDocumentoCabBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", armarDocumentoCabBean.getIpModificacion());
			
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
	public boolean eliminar(ArmarDocumentoCabBean armarDocumentoCabBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarmadocucab.eliminar");
			spq.setParameter("p_codarmdoccab", armarDocumentoCabBean.getCodigo());
			spq.setParameter("p_codusumod", armarDocumentoCabBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", armarDocumentoCabBean.getIpModificacion());
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
	public ArmarDocumentoCabBean getBuscarPorObjecto(ArmarDocumentoCabBean armarDocumentoCabBean) throws DAOException {
		List<LeotbcArmadocuCabecera> 	lstPregunta 	= null;
		ArmarDocumentoCabBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarmadocucab.buscar_por_codigo");
		spq.setParameter("p_codarmdoccab", 	armarDocumentoCabBean.getCodigo());
		
		if (spq.execute()) 
		{
			lstPregunta =  spq.getResultList(); 
		} 
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{
			bean = deArmarDocCabeceraAArmarDocCabeceraBean(lstPregunta.get(0));
		}
		return bean;

	}

	@Override
	public List<ArmarDocumentoCabBean> getBuscarPorFiltros(ArmarDocumentoCabBean armarDocumentoCabBean) throws DAOException {
		List<LeotbcArmadocuCabecera> 	lstPregunta 	= null;
		List<ArmarDocumentoCabBean> 	lstPreguntaBean = null;
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcarmadocucab.buscar_por_ejercicio");
		spq.setParameter("p_codmatpej", armarDocumentoCabBean.getMaterialTipoEjercicioBean().getCodigo());
		if (spq.execute()) {
			lstPregunta =  spq.getResultList(); 
		} 
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{			
			lstPreguntaBean = deListaArmarDocCabeceraAListaArmarDocCabeceraBean(lstPregunta);
		}
		return lstPreguntaBean;
	}

	@Override
	public boolean existe(ArmarDocumentoCabBean armarDocumentoCabBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	private List<ArmarDocumentoCabBean> deListaArmarDocCabeceraAListaArmarDocCabeceraBean(List<LeotbcArmadocuCabecera> lstPregunta) 
	{
		List<ArmarDocumentoCabBean> lstPreguntaBean = null;
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{
			lstPreguntaBean = new ArrayList<ArmarDocumentoCabBean>();
			for (int i = 0; i < lstPregunta.size(); i++) 
			{ 
				LeotbcArmadocuCabecera entity = lstPregunta.get(i);
				ArmarDocumentoCabBean bean = deArmarDocCabeceraAArmarDocCabeceraBean(entity);
				lstPreguntaBean.add(bean);
			}
		}
		return lstPreguntaBean;
	}
	

	private ArmarDocumentoCabBean deArmarDocCabeceraAArmarDocCabeceraBean(LeotbcArmadocuCabecera entity) 
	{
		ArmarDocumentoCabBean bean = null;
		
		if (entity != null) {
			bean = new ArmarDocumentoCabBean();
			bean.setCodigo(entity.getnCodarmdoccab());
			bean.setTipoDocumento(entity.getnTm2tipdoc());
			bean.getMaestraTipoDoc().setNombreLargo(entity.getV_nomlargo());
			bean.setTitulo(entity.getvTitulo());
		}
		return bean;
	}

	

}
