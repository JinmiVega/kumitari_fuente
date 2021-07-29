package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.generico.OrdenarParrafoBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OrdenarParrafoCabeceraBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcOrdenarParrafo;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcOrdenarParrafoCabecera;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.OrdenarParrafoCabeceraDAO;

@Repository("ordenarParrafoCabeceraDAO")
@Transactional(readOnly= true)
public class OrdenarParrafoCabeceraDAOImpl implements OrdenarParrafoCabeceraDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean) throws DAOException {
		
		System.out.println("---- Insertar ordenarParrafoCabeceraBean ----");
		System.out.println("ordenarParrafoCabeceraBean DAO "+ordenarParrafoCabeceraBean);
		Object codigoOrdenarParrafoCabecera= null; 
		boolean sw =  false;
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_ordenarparrafocabecera.insertar");
			
			spq.setParameter("p_codmatpej", ordenarParrafoCabeceraBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_titulo", ordenarParrafoCabeceraBean.getTitulo());

			spq.setParameter("p_codusureg", ordenarParrafoCabeceraBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", ordenarParrafoCabeceraBean.getIpCreacion()); 
			spq.setParameter("p_palabra", ordenarParrafoCabeceraBean.getPalabra());
			spq.setParameter("p_comentario", ordenarParrafoCabeceraBean.getComentario());

			
			spq.execute();
			
			codigoOrdenarParrafoCabecera = spq.getOutputParameterValue(1);
			
			if (codigoOrdenarParrafoCabecera != null ) {
				ordenarParrafoCabeceraBean.setCodigo(Long.valueOf(codigoOrdenarParrafoCabecera.toString()));
				System.out.println("ordenarParrafoBean.getCodigo() ::" +ordenarParrafoCabeceraBean.getCodigo());
				sw =  true;
			}else{
				System.out.println("codigo ordenarParrafo llego  null");
				sw =  false;
			}
				
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return sw;
	}

	@Override
	public boolean actualizar(OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean) throws DAOException {
		System.out.println("---- Actulizar ordenarParrafoCabeceraBean ----");
		System.out.println("ordenarParrafoCabeceraBean DAO "+ordenarParrafoCabeceraBean);
		
		boolean sw =  false;
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_ordenarparrafocabecera.actulizar");
			
			spq.setParameter("p_codordenarparrafocab", ordenarParrafoCabeceraBean.getCodigo());
			spq.setParameter("p_codmatpej", ordenarParrafoCabeceraBean.getMaterialTipoEjercicioBean().getCodigo());
			spq.setParameter("p_titulo", ordenarParrafoCabeceraBean.getTitulo());
			spq.setParameter("p_codusumod", ordenarParrafoCabeceraBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", ordenarParrafoCabeceraBean.getIpModificacion()); 
			spq.setParameter("p_palabra", ordenarParrafoCabeceraBean.getPalabra());
			spq.setParameter("p_comentario", ordenarParrafoCabeceraBean.getComentario());
			
			spq.execute();
			
			sw = true;
			
				
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return sw;
	}

	@Override
	public boolean eliminar(OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean) throws DAOException {
		System.out.println("---- Eliminar ordenarParrafoCabeceraBean ----");
		System.out.println("ordenarParrafoCabeceraBean DAO "+ordenarParrafoCabeceraBean);
		
		boolean sw =  false;
		try {
			
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_ordenarparrafocabecera.eliminar");
			
			spq.setParameter("p_codordenarparrafocab", ordenarParrafoCabeceraBean.getCodigo());
			spq.setParameter("p_codusumod", ordenarParrafoCabeceraBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", ordenarParrafoCabeceraBean.getIpModificacion());
			
			spq.execute();
			
			sw = true;
			
				
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return sw;
	}

	@Override
	public OrdenarParrafoCabeceraBean getBuscarPorObjecto(
			OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean) throws DAOException {
		System.out.println("----Ingreso a  listar buscarPorObjecto ----");
		OrdenarParrafoCabeceraBean oOrdenarParrafoCabeceraBean = null;
		List<LeotbcOrdenarParrafoCabecera> lstLeotbcOrdenarParrafoCabecera = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_ordenarparrafocabecera.buscarPorCodigo");
			spq.setParameter("p_codordenarparrafocab", ordenarParrafoCabeceraBean.getCodigo());
			
			if (spq.execute()) {
				lstLeotbcOrdenarParrafoCabecera = spq.getResultList();
				
			}
			if (lstLeotbcOrdenarParrafoCabecera != null && lstLeotbcOrdenarParrafoCabecera.size() > 0) {
				oOrdenarParrafoCabeceraBean = deOrdenarParrafoCabeceraAOrdenarParrafoCabeceraBean(lstLeotbcOrdenarParrafoCabecera.get(0));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oOrdenarParrafoCabeceraBean;
	}

	@Override
	public List<OrdenarParrafoCabeceraBean> getBuscarPorFiltros(
			OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean) throws DAOException {
		System.out.println("---- Listar por Filtros ordenarParrafoCabeceraBean ----");
		
		List<LeotbcOrdenarParrafoCabecera> lstLeotbcOrdenarParrafoCabecera = null;
		List<OrdenarParrafoCabeceraBean> lstOrdenarParrafoCabeceraBean = null;

//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_ordenarparrafocabecera.buscarPorFiltros");
//			spq.setParameter("p_codmatpej", ordenarParrafoCabeceraBean.getMaterialTipoEjercicioBean().getCodigo());
//			
//			if (spq.execute()) {				
//				lstLeotbcOrdenarParrafoCabecera = spq.getResultList();
//			}
//			if (lstLeotbcOrdenarParrafoCabecera != null && lstLeotbcOrdenarParrafoCabecera.size() > 0) {
//				
//				lstOrdenarParrafoCabeceraBean = deListaOrdenarParrafoCabeceraAListaOrdenarParrafoCabeceraBean(lstLeotbcOrdenarParrafoCabecera);
//				
//			}
		return lstOrdenarParrafoCabeceraBean;
	}
	
	private List<OrdenarParrafoCabeceraBean> deListaOrdenarParrafoCabeceraAListaOrdenarParrafoCabeceraBean(List<LeotbcOrdenarParrafoCabecera> lstLeotbcOrdenarParrafoCabecera) {
		
		List<OrdenarParrafoCabeceraBean> lstOrdenarParrafoCabeceraBean = null;
		
		if (lstLeotbcOrdenarParrafoCabecera != null && lstLeotbcOrdenarParrafoCabecera.size() > 0) {
			
			lstOrdenarParrafoCabeceraBean = new ArrayList<OrdenarParrafoCabeceraBean>();
			
			for (int i = 0; i < lstLeotbcOrdenarParrafoCabecera.size(); i++) { 
				LeotbcOrdenarParrafoCabecera entity = lstLeotbcOrdenarParrafoCabecera.get(i);
				OrdenarParrafoCabeceraBean bean = deOrdenarParrafoCabeceraAOrdenarParrafoCabeceraBean(entity);
				
				lstOrdenarParrafoCabeceraBean.add(bean);
			}
		}
		
		return lstOrdenarParrafoCabeceraBean;
	}
	
	private OrdenarParrafoCabeceraBean deOrdenarParrafoCabeceraAOrdenarParrafoCabeceraBean(LeotbcOrdenarParrafoCabecera entity) {
		
		OrdenarParrafoCabeceraBean bean = null;
		
		if (entity != null) {
			
			bean = new OrdenarParrafoCabeceraBean();
			bean.setCodigo(entity.getNcodordenarparrafocab());
			bean.setTitulo(entity.getvTitulo());
			bean.getMaterialTipoEjercicioBean().setCodigo(entity.getnCodmatpej());
			bean.setPalabra(entity.getVpalabra());
			bean.setComentario(entity.getVcomentario());
			
		}
		
		return bean;
	}
	@Override
	public boolean existe(OrdenarParrafoCabeceraBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrdenarParrafoCabeceraBean listarCodigoTipoEjercicio(
			OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean)
			throws DAOException {
		System.out.println("----Ingreso a  listar codigoTipoEjercicio ----");
		OrdenarParrafoCabeceraBean oOrdenarParrafoCabeceraBean = null;
		List<LeotbcOrdenarParrafoCabecera> lstLeotbcOrdenarParrafoCabecera = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_ordenarparrafocabecera.buscarPorFiltros");
			spq.setParameter("p_codmatpej", ordenarParrafoCabeceraBean.getMaterialTipoEjercicioBean().getCodigo());
			
			if (spq.execute()) {
				lstLeotbcOrdenarParrafoCabecera = spq.getResultList();
				
			}
			if (lstLeotbcOrdenarParrafoCabecera != null && lstLeotbcOrdenarParrafoCabecera.size() > 0) {
				oOrdenarParrafoCabeceraBean = deOrdenarParrafoCabeceraAOrdenarParrafoCabeceraBean(lstLeotbcOrdenarParrafoCabecera.get(0));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oOrdenarParrafoCabeceraBean;
	}

}
