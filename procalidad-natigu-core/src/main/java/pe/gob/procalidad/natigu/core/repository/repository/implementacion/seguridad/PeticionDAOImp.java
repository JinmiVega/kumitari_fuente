package pe.gob.procalidad.natigu.core.repository.repository.implementacion.seguridad;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.seguridad.PeticionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.seguridad.PeticionDAO;

@Transactional
@Repository("peticionDAO")
public class PeticionDAOImp implements PeticionDAO  {
	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public boolean insertar(PeticionBean t) throws DAOException {
		// TODO Auto-generated method stub
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_peticion.insertar");
            spq.setParameter("p_ipconexion", t.getIpConexion());
            spq.setParameter("p_urlpeticion", t.getUrlPeticion());
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
	public boolean actualizar(PeticionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(PeticionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PeticionBean getBuscarPorObjecto(PeticionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeticionBean> getBuscarPorFiltros(PeticionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(PeticionBean t) throws DAOException {
		// TODO Auto-generated method stub
		int response= 0; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_peticion.listar");
            spq.setParameter("p_ipconexion", t.getIpConexion());
            spq.setParameter("p_urlpeticion", t.getUrlPeticion());
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