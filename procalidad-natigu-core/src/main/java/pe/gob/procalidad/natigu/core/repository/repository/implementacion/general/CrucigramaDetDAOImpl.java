package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.CrucigramaDetBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.PreguntaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionCabeceraBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcPregunta;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcRelacion;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdCrucigramaDet;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.CrucigramaDetDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.RelacionDAO;

@Transactional
@Repository("crucigramaDetDAO")
public class CrucigramaDetDAOImpl implements CrucigramaDetDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(CrucigramaDetBean relacionBean) throws DAOException {
		Object idRelacion = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdcrucigramadet.insertar");
			spq.setParameter("p_codcrucidet", 	relacionBean.getCodigo());
			spq.setParameter("p_codrelcab", 	relacionBean.getRelacionCabeceraBean().getCodigo());
			spq.setParameter("p_palabra", 		relacionBean.getPalabra()); 
			spq.setParameter("p_orden", 		relacionBean.getOrden()); 
			spq.setParameter("p_codusureg", relacionBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", relacionBean.getIpCreacion());  
			spq.execute();
			
			idRelacion = spq.getOutputParameterValue(1);
			if(idRelacion != null)
			{
				relacionBean.setCodigo(Integer.valueOf(idRelacion.toString()));
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
 
	
	private List<CrucigramaDetBean> deListaRelacionAListaRelacionBean(List<LeotbdCrucigramaDet> lstPregunta) 
	{
		List<CrucigramaDetBean> lstPreguntaBean = null;
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{
			lstPreguntaBean = new ArrayList<CrucigramaDetBean>();
			for (int i = 0; i < lstPregunta.size(); i++) 
			{ 
				LeotbdCrucigramaDet entity = lstPregunta.get(i);
				CrucigramaDetBean bean = deRelacionARelacionBean(entity);
				lstPreguntaBean.add(bean);
			}
		}
		return lstPreguntaBean;
	}
	

	private CrucigramaDetBean deRelacionARelacionBean(LeotbdCrucigramaDet entity) {
		
		CrucigramaDetBean bean = null;
		
		if (entity != null) {
			bean = new CrucigramaDetBean();
			
			bean.setCodigo(entity.getnCodcrucidet());
			bean.setRelacionCabeceraBean(new RelacionCabeceraBean());
			bean.getRelacionCabeceraBean().setCodigo(entity.getnCodrelcab()); 
			bean.setPalabra(entity.getvPalabra());   
			bean.setOrden(entity.getnOrden());  
		}
		return bean;
	}
 

	@Override
	public boolean actualizar(CrucigramaDetBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(CrucigramaDetBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CrucigramaDetBean getBuscarPorObjecto(CrucigramaDetBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CrucigramaDetBean> getBuscarPorFiltros(CrucigramaDetBean relacionBean)
			throws DAOException {
		List<LeotbdCrucigramaDet> 	lstPregunta 	= null;
		List<CrucigramaDetBean> 	lstPreguntaBean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbdcrucigramadet.listar");
		spq.setParameter("p_codrelcab", relacionBean.getRelacionCabeceraBean().getCodigo()); 
		
		if (spq.execute()) 
		{
			lstPregunta =  spq.getResultList(); 
		} 
		if (lstPregunta != null && lstPregunta.size() > 0) 
		{			
			lstPreguntaBean = deListaRelacionAListaRelacionBean(lstPregunta);
		}
		return lstPreguntaBean;
	}

	@Override
	public boolean existe(CrucigramaDetBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
}