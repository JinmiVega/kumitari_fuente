package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.AlternativaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcPregunta;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdAlternativa;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.AlternativaDAO;

@Transactional
@Repository("alternativaDAO")
public class AlternativaDAOImpl implements AlternativaDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(AlternativaBean alternativaBean) throws DAOException 
	{
		Object idRespuesta = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdalternativa.insertar");
			spq.setParameter("p_codpregun", alternativaBean.getPreguntaBean().getCodigo());
			spq.setParameter("p_alternativa", alternativaBean.getDescripcion());
			spq.setParameter("p_rptaestado", alternativaBean.getRespuestaEstado());
			spq.setParameter("p_codusureg", alternativaBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", alternativaBean.getIpCreacion()); 
			
			spq.execute();
			
			idRespuesta = spq.getOutputParameterValue(1);
			if(idRespuesta != null)
			{
				alternativaBean.setCodigo(Integer.valueOf(idRespuesta.toString()));
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
	public boolean actualizar(AlternativaBean alternativaBean) throws DAOException {
		boolean sw = false;
		System.out.println("RespuestaBean actualizar " + alternativaBean);
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdalternativa.actualizar");
			spq.setParameter("p_codaltern", alternativaBean.getCodigo());
			spq.setParameter("p_alternativa", alternativaBean.getDescripcion());
			spq.setParameter("p_rptaestado", alternativaBean.getRespuestaEstado()); 
			spq.setParameter("p_codusumod", alternativaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", alternativaBean.getIpModificacion());

			spq.execute();
			sw = true;

		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		} finally {
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(AlternativaBean alternativaBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdalternativa.eliminar");
			spq.setParameter("p_codaltern", alternativaBean.getCodigo());
//			spq.setParameter("p_codpregunta", alternativaBean.getPreguntaBean().getCodigo());
			spq.setParameter("p_codusumod", alternativaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", alternativaBean.getIpModificacion());
			spq.execute();
			sw = true;
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}
	@SuppressWarnings("unchecked")
	@Override
	public AlternativaBean getBuscarPorObjecto(AlternativaBean alternativaBean) throws DAOException {
		List<LeotbdAlternativa> 	lstAlternativa 	= null;
		AlternativaBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdalternativa.buscar_x_alternativa");
		spq.setParameter("p_codaltern", 	alternativaBean.getCodigo());
		
		if (spq.execute()) 
		{
			lstAlternativa =  spq.getResultList(); 
		} 
		if (lstAlternativa != null && lstAlternativa.size() > 0) 
		{
			bean = deAlternativaAAlternativaBean(lstAlternativa.get(0));
		}
		return bean;
	}

	@Override
	public List<AlternativaBean> getBuscarPorFiltros(AlternativaBean alternativaBean) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(AlternativaBean alternativaBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AlternativaBean> buscarPorCodigoPregunta(PreguntaBean preguntaBean) throws DAOException {
		List<AlternativaBean> 	lstBean = null;
		List<LeotbdAlternativa> lstEntity = null;
		try 
		{
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdalternativa.buscar_x_pregunta");
			spq.setParameter("p_codpregun", preguntaBean.getCodigo());
			if (spq.execute()) 
			{
				lstEntity = spq.getResultList();
			}
			if (lstEntity != null && lstEntity.size() > 0) 
			{
				lstBean = deListaAlternativaAListaAlternativaBean(lstEntity);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return lstBean;
	}
	
	private List<AlternativaBean> deListaAlternativaAListaAlternativaBean(List<LeotbdAlternativa> lstAlternativa) {
		
		List<AlternativaBean> lstAlternativaBean = null;
	
		if (lstAlternativa != null && lstAlternativa.size() > 0) 
		{
			lstAlternativaBean = new ArrayList<AlternativaBean>();
			
			for (int i = 0; i < lstAlternativa.size(); i++) 
			{ 
				LeotbdAlternativa entity = lstAlternativa.get(i);
				AlternativaBean bean = deAlternativaAAlternativaBean(entity);
				
				lstAlternativaBean.add(bean);
			}
		}
		return lstAlternativaBean;
	}
	
	private AlternativaBean deAlternativaAAlternativaBean(LeotbdAlternativa entity) 
	{
		AlternativaBean bean = null;
		
		if (entity != null) 
		{
			bean = new AlternativaBean();
			
			bean.setCodigo(entity.getnCodaltern());
			bean.setDescripcion(entity.getvAlternativa());
			bean.getPreguntaBean().setCodigo(entity.getnCodpregun());
			bean.setRespuestaEstado(entity.getvRptaestado());
			
		}
		return bean;
	}
	
//	private MaestraBean deTablaATablaBean(int codigoRegistro, String nombreCorto)
//	{
//		MaestraBean bean = new MaestraBean();
//		
//		bean.setCodigoRegistro(codigoRegistro);
//		
//		if (!nombreCorto.equals(null)) {
//			bean.setNombreCorto(nombreCorto);
//		}
//		
//		return bean;
//	}

}
