package pe.gob.procalidad.natigu.core.repository.repository.implementacion.seguridad;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.SesionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.seguridad.SessionDao;

@Transactional
@Repository("sessionDAO")
public class SessionDaoImp implements SessionDao {
	@PersistenceContext
	private EntityManager em; 

	@Override
	public boolean insertar(SesionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(SesionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(SesionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SesionBean getBuscarPorObjecto(SesionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SesionBean> getBuscarPorFiltros(SesionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(SesionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sessionGestor(SesionBean s,String operacion) throws DAOException {
		// TODO Auto-generated method stub
		int response= 0; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_session.gestor");
            spq.setParameter("p_reset", s.getReset_session());
            spq.setParameter("p_session_id", s.getSession_id());
            spq.setParameter("p_user_id",s.getUser_id());
            spq.setParameter("p_operacion", operacion);
	        spq.execute();
	        response = Integer.valueOf(spq.getOutputParameterValue(1).toString());
	        if(response == 1) {
		        sw=true;
	        }else {
		        sw=false;
	        }
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	
		
	}

}
