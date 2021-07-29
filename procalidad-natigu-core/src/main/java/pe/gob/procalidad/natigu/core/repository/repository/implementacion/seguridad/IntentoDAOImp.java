package pe.gob.procalidad.natigu.core.repository.repository.implementacion.seguridad;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.IntentoBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.seguridad.IntentoDAO;

@Transactional
@Repository("intentoDAO")
public class IntentoDAOImp implements IntentoDAO  {
	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public boolean insertar(IntentoBean t) throws DAOException {
		// TODO Auto-generated method stub
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_intento.insertar");
            spq.setParameter("p_ipconexion", t.getIpConexion());
            spq.setParameter("p_plataforma", t.getPlataforma());
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
	public boolean actualizar(IntentoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(IntentoBean t) throws DAOException {
		// TODO Auto-generated method stub
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_intento.eliminar");
            spq.setParameter("p_ipconexion", t.getIpConexion());
            spq.setParameter("p_plataforma", t.getPlataforma());
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
	public IntentoBean getBuscarPorObjecto(IntentoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IntentoBean> getBuscarPorFiltros(IntentoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(IntentoBean t) throws DAOException {
		// TODO Auto-generated method stub
		int response= 0; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_intento.listar");
            spq.setParameter("p_ipconexion", t.getIpConexion());
            spq.setParameter("p_plataforma", t.getPlataforma());
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