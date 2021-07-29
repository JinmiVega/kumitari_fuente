package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.AlterTextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionAlterBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionCompletarBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdAltxtextopalabracorrec;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdOracionAlter;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.AlterTextoPalabraCorrectaDAO;

@Transactional
@Repository("alterTextoPalabraCorrectaDAO")
public class AlterTextoPalabraCorrectaDAOImpl implements AlterTextoPalabraCorrectaDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(AlterTextoPalabraCorrectaBean Bean) throws DAOException {
		Object idAlter = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabracorrec.insertar");
			spq.setParameter("p_codtextopalabracorrec", Bean.getTextoPalabraCorrectaBean().getCodigo());
			spq.setParameter("p_nroorden", Bean.getNroOrden());
			System.out.println("Bean.getNroOrden() " + Bean.getNroOrden());
			spq.setParameter("p_palabracorrecta", Bean.getPalabraCorrecta());
			spq.setParameter("p_alternativa", Bean.getDescripcion());
			spq.setParameter("p_rptaestado", Bean.getRespuestaEstado());
			spq.setParameter("p_codusureg", Bean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", Bean.getIpCreacion()); 
			
			spq.execute();
			
			idAlter = spq.getOutputParameterValue(1);
			if(idAlter != null)
			{
				Bean.setCodigo(Integer.valueOf(idAlter.toString()));
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
	public boolean actualizar(AlterTextoPalabraCorrectaBean Bean) throws DAOException {
		boolean sw = false;
		System.out.println("RespuestaBean actualizar " + Bean);
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabracorrec.actualizar");
			spq.setParameter("p_codaltern", Bean.getCodigo());
			spq.setParameter("p_nroorden", Bean.getNroOrden());
			System.out.println("Bean.getNroOrden() " + Bean.getNroOrden());
			spq.setParameter("p_palabracorrecta", Bean.getPalabraCorrecta());
			spq.setParameter("p_alternativa", Bean.getDescripcion());
			spq.setParameter("p_rptaestado", Bean.getRespuestaEstado()); 
			spq.setParameter("p_codusumod", Bean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", Bean.getIpModificacion()); 
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
	public boolean eliminar(AlterTextoPalabraCorrectaBean alternativaBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabracorrec.eliminar");
			spq.setParameter("p_codtextopalabracorrec", alternativaBean.getTextoPalabraCorrectaBean().getCodigo());
			spq.setParameter("p_palabracorrecta", alternativaBean.getPalabraCorrecta());
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

	@Override
	public AlterTextoPalabraCorrectaBean getBuscarPorObjecto(AlterTextoPalabraCorrectaBean alternativaBean) throws DAOException {
		List<LeotbdAltxtextopalabracorrec> 	lstAlternativa 	= null;
		AlterTextoPalabraCorrectaBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabracorrec.buscar_x_textopalco");
		spq.setParameter("p_codtextopalabracorrec", 	alternativaBean.getTextoPalabraCorrectaBean().getCodigo());
		
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
	public List<AlterTextoPalabraCorrectaBean> getBuscarPorFiltros(AlterTextoPalabraCorrectaBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(AlterTextoPalabraCorrectaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AlterTextoPalabraCorrectaBean> getBuscarPorTextoPalabraCorrecta(AlterTextoPalabraCorrectaBean Bean) throws DAOException {
		List<LeotbdAltxtextopalabracorrec> lstLeotbc = null;
		List<AlterTextoPalabraCorrectaBean> lstBean = null;
		
		System.out.println("---- getBuscarPorFiltros ---");
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabracorrec.buscar_x_textopalco");
		
		spq.setParameter("p_codtextopalabracorrec", 	Bean.getTextoPalabraCorrectaBean().getCodigo());
		 
		if (spq.execute()) {
			
			lstLeotbc = spq.getResultList();
		}
		if (lstLeotbc != null && lstLeotbc.size() > 0) {
			
			lstBean = deListaAlternativaAListaAlternativaBean(lstLeotbc);
		}
		
		return lstBean;
	}

	@Override
	public List<AlterTextoPalabraCorrectaBean> buscarxPalabraxTexto(AlterTextoPalabraCorrectaBean alterTextoPalabraCorrectaBean) throws DAOException {
		List<AlterTextoPalabraCorrectaBean> 	lstBean = null;
		List<LeotbdAltxtextopalabracorrec> lstEntity = null;
		try 
		{																   
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabracorrec.buscar_x_texto_palbcorrec");
			spq.setParameter("p_codtextopalabracorrec", alterTextoPalabraCorrectaBean.getTextoPalabraCorrectaBean().getCodigo());
			spq.setParameter("p_palabracorrecta", alterTextoPalabraCorrectaBean.getNroOrden());
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

	private List<AlterTextoPalabraCorrectaBean> deListaAlternativaAListaAlternativaBean(List<LeotbdAltxtextopalabracorrec> lstAlternativa) {
		
		List<AlterTextoPalabraCorrectaBean> lstAlternativaBean = null; 
		if (lstAlternativa != null && lstAlternativa.size() > 0) 
		{
			lstAlternativaBean = new ArrayList<AlterTextoPalabraCorrectaBean>(); 
			for (int i = 0; i < lstAlternativa.size(); i++) 
			{ 
				LeotbdAltxtextopalabracorrec entity = lstAlternativa.get(i);
				AlterTextoPalabraCorrectaBean bean = deAlternativaAAlternativaBean(entity);
				
				lstAlternativaBean.add(bean);
			}
		}
		return lstAlternativaBean;
	}
	
	private AlterTextoPalabraCorrectaBean deAlternativaAAlternativaBean(LeotbdAltxtextopalabracorrec entity) 
	{
		AlterTextoPalabraCorrectaBean bean = null;
		
		if (entity != null) 
		{
			bean = new AlterTextoPalabraCorrectaBean();
			bean.setTextoPalabraCorrectaBean(new  TextoPalabraCorrectaBean()); 
			bean.getTextoPalabraCorrectaBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
			bean.setCodigo(entity.getnCodaltern());
			bean.setEstado(entity.getvFlgest());
			bean.setPalabraCorrecta(entity.getvPalabracorrecta());
			bean.setDescripcion(entity.getvAlternativa()); 
			bean.getTextoPalabraCorrectaBean().setCodigo(entity.getnCodtextopalabracorrec());
			bean.getTextoPalabraCorrectaBean().setTexto(entity.getvTexto());
			bean.getTextoPalabraCorrectaBean().setTitulo(entity.getvTituloora());			
			bean.getTextoPalabraCorrectaBean().getMaterialTipoEjercicioBean().setTitulo(entity.getvTitulotipo());
			bean.getTextoPalabraCorrectaBean().getMaterialTipoEjercicioBean().setCodigo(entity.getnCodmatpej());
			bean.getTextoPalabraCorrectaBean().setComentario(entity.getvComentario());
			bean.setRespuestaEstado(entity.getvRptaestado());
			bean.setNroOrden(entity.getnNroOrden());	
			System.out.println("entity.getnNroOrden() "  + entity.getnNroOrden());
		}
		return bean;
	}

	
	@Override
	public List<AlterTextoPalabraCorrectaBean> getBuscarTodoxMTE(AlterTextoPalabraCorrectaBean Bean) throws DAOException {
	
		List<LeotbdAltxtextopalabracorrec> lstLeotbc = null;
		List<AlterTextoPalabraCorrectaBean> lstBean = null; 
		System.out.println("---- getBuscarPorFiltros --- AlterTextoPalabraCorrectaBean getBuscarTodoxMTE");
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabracorrec.listar_todoAprendizaje");
		
		spq.setParameter("p_codmatpej", 	Bean.getTextoPalabraCorrectaBean().getMaterialTipoEjercicioBean().getCodigo());
		 
		if (spq.execute()) {
			
			lstLeotbc = spq.getResultList();
		}
		if (lstLeotbc != null && lstLeotbc.size() > 0) {
			
			lstBean = deListaAlternativaAListaAlternativaBean(lstLeotbc);
		}
		
		return lstBean;	
		
	}

	@Override
	public List<AlterTextoPalabraCorrectaBean> getlistarNombrePalabraCorrectaYcodigoCab(AlterTextoPalabraCorrectaBean Bean) throws DAOException {
		 
		List<LeotbdAltxtextopalabracorrec> lstLeotbc = null;
		List<AlterTextoPalabraCorrectaBean> lstBean = null; 
		System.out.println("---- getBuscarPorFiltros --- AlterTextoPalabraCorrectaBean getlistarNombrePalabraCorrectaYcodigoCab");
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabracorrec.listarNombrePalabraCorrecta_codigoCab");
		
		spq.setParameter("p_nroorden", 			Bean.getNroOrden());
		spq.setParameter("p_codtextopalabracorrec", 	Bean.getTextoPalabraCorrectaBean().getCodigo());
		 
		if (spq.execute()) {
			
			lstLeotbc = spq.getResultList();
		}
		if (lstLeotbc != null && lstLeotbc.size() > 0) {
			
			lstBean = deListaAlternativaAListaAlternativaBean(lstLeotbc);
		}
		
		return lstBean;	
	}

}
