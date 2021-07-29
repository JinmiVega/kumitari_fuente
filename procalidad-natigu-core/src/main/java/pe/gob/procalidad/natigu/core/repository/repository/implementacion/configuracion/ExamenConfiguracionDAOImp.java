package pe.gob.procalidad.natigu.core.repository.repository.implementacion.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.ExamenConfiguracionBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioConfiguracionBean;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcExaConfig;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcPreConfig;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.ExamenConfiguracionDAO;

@Transactional
@Repository("examenConfiguracionDAO")
public class ExamenConfiguracionDAOImp implements ExamenConfiguracionDAO{

	@PersistenceContext
	private EntityManager em;
	
	public ExamenConfiguracionBean getExamenConfigBean(Object object){
		return (ExamenConfiguracionBean)object;
	}
	
	@Override
	public boolean insertar(ExamenConfiguracionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(ExamenConfiguracionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(ExamenConfiguracionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ExamenConfiguracionBean getBuscarPorObjecto(ExamenConfiguracionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamenConfiguracionBean> getBuscarPorFiltros(ExamenConfiguracionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(ExamenConfiguracionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

    private ExamenConfiguracionBean deExaConfigAExamenConfiguracionBean(LeotbcExaConfig entity) {
		
    	ExamenConfiguracionBean bean = null;
		
		if (entity != null) {
			
			bean = new ExamenConfiguracionBean();
			bean.setCodigo(entity.getnCodconfexa());
			bean.getSubnivel().setCodigoRegistro(entity.getnTm2subniv());
			bean.getSubnivel().setNombreLargo(entity.getV_nombreSubNivel());
			bean.getUnidad().setCodigoRegistro(entity.getnTm2unid());
			bean.getUnidad().setNombreCorto(entity.getV_nombreUnidad());
			bean.getLeccion().setCodigoRegistro(entity.getnTm2lecc());
			bean.getLeccion().setNombreCorto(entity.getV_nombreLeccion());
			bean.setPuntajeaprobacion(entity.getdPorcentaprob()); 
			bean.setEstado(entity.getvFlgest());
			bean.setCodigoUsuarioCreacion(entity.getnCodusureg()==null? 0 : entity.getnCodusureg());
			bean.setCodigoUsuarioModificacion(entity.getnCodusumod()==null? 0 : entity.getnCodusumod());
			
		}
		
		return  bean;
	}

   private List<ExamenConfiguracionBean> deListaExaConfigAListaExamenConfiguracionBean(List<LeotbcExaConfig> lstLeotbcExaConfig) {
		
		List<ExamenConfiguracionBean> lstExamenConfiguracionBean = null;
		
		if (lstLeotbcExaConfig != null && lstLeotbcExaConfig.size() > 0) {
			
			lstExamenConfiguracionBean = new ArrayList<ExamenConfiguracionBean>();
			
			for (int i = 0; i < lstLeotbcExaConfig.size(); i++) { 
				LeotbcExaConfig entity = lstLeotbcExaConfig.get(i);
				ExamenConfiguracionBean bean = deExaConfigAExamenConfiguracionBean(entity);
				
				lstExamenConfiguracionBean.add(bean);
			}
		}
		
		return lstExamenConfiguracionBean;
	}
	@Override
	public List<ExamenConfiguracionBean> listarTodos() throws DAOException {
		List<LeotbcExaConfig> lstexamenConfig = null;	
		List<ExamenConfiguracionBean> lstexamenConfigBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_exaconfig.listar");			
			if (spq.execute()) {
				lstexamenConfig =  spq.getResultList(); 
			} 
			if (lstexamenConfig != null && lstexamenConfig.size() > 0) {
				
				lstexamenConfigBean = deListaExaConfigAListaExamenConfiguracionBean(lstexamenConfig);
			}
			//em.close();
		   
		return lstexamenConfigBean;
	}

}
