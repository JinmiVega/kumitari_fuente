package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.AlterTextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.AlterTextoPalabraEncerradaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionAlterBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OracionCompletarBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraCorrectaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TextoPalabraEncerradaBean;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdAltxtextopalabracorrec;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdAltxtextopalabraence;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbdOracionAlter;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.AlterTextoPalabraCorrectaDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.AlterTextoPalabraEncerradaDAO;
import pe.gob.procalidad.natigu.core.service.service.implementacion.general.OracionCompletarServiceImpl;

@Transactional
@Repository("alterTextoPalabraEncerradaDAO")
public class AlterTextoPalabraEncerradaDAOImpl implements AlterTextoPalabraEncerradaDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(AlterTextoPalabraEncerradaBean Bean) throws DAOException {
		Object idAlter = null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabraence.insertar");
			spq.setParameter("p_nroorden", Bean.getNroOrden());
			spq.setParameter("p_codtextopalabraence", Bean.getTextoPalabraEncerradaBean().getCodigo());
			spq.setParameter("p_palabraencerrada", Bean.getPalabraEncerrada());
			spq.setParameter("p_codusureg", Bean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", Bean.getIpCreacion()); 
			spq.setParameter("p_palabrarpta", Bean.getPalabraRpta());
			
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
	public boolean actualizar(AlterTextoPalabraEncerradaBean Bean) throws DAOException {
		boolean sw = false;
		System.out.println("RespuestaBean actualizar " + Bean);
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabraence.actualizar");
			spq.setParameter("p_codaltern", Bean.getCodigo());
			spq.setParameter("p_nroorden", Bean.getNroOrden());
			spq.setParameter("p_palabraencerrada", Bean.getPalabraEncerrada());
			spq.setParameter("p_codusumod", Bean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", Bean.getIpModificacion());
			spq.setParameter("p_palabrarpta", Bean.getPalabraRpta());
			
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
	public boolean eliminar(AlterTextoPalabraEncerradaBean alternativaBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabraence.eliminar");
			spq.setParameter("p_codaltern", alternativaBean.getCodigo());
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
	public AlterTextoPalabraEncerradaBean getBuscarPorObjecto(AlterTextoPalabraEncerradaBean t) throws DAOException {
		List<LeotbdAltxtextopalabraence> 	lstAlternativa 	= null;
		AlterTextoPalabraEncerradaBean 	bean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabraence.buscar_x_textopalco");
		spq.setParameter("p_codtextopalabraence", 	t.getTextoPalabraEncerradaBean().getCodigo());
		
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
	public List<AlterTextoPalabraEncerradaBean> getBuscarPorFiltros(AlterTextoPalabraEncerradaBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(AlterTextoPalabraEncerradaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AlterTextoPalabraEncerradaBean> getBuscarPorTextoPalabraCorrecta(
			AlterTextoPalabraEncerradaBean Bean) throws DAOException {
		List<LeotbdAltxtextopalabraence> lstLeotbc = null;
		List<AlterTextoPalabraEncerradaBean> lstBean = null;
		
		System.out.println("---- getBuscarPorFiltros ---");
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabraence.buscar_x_textopalco");
		
		spq.setParameter("p_codtextopalabraence", 	Bean.getTextoPalabraEncerradaBean().getCodigo());
		 
		if (spq.execute()) {
			
			lstLeotbc = spq.getResultList();
		}
		if (lstLeotbc != null && lstLeotbc.size() > 0) {
			
			lstBean = deListaAlternativaAListaAlternativaBean(lstLeotbc);
		}
		
		return lstBean;
	}

	@Override
	public AlterTextoPalabraEncerradaBean buscarxPalabraxTexto(AlterTextoPalabraEncerradaBean alterTextoPalabraEncerradaBean) throws DAOException {
		AlterTextoPalabraEncerradaBean	lstBean = null;
		List<LeotbdAltxtextopalabraence> lstEntity = null;
		try 
		{																   
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabraence.buscar_x_codigo");
			spq.setParameter("p_codaltern", alterTextoPalabraEncerradaBean.getCodigo());
			if (spq.execute()) 
			{
				lstEntity = spq.getResultList();
			}
			if (lstEntity != null && lstEntity.size() > 0) 
			{
				System.out.println("listo bean daoimpl");
				lstBean = deAlternativaAAlternativaBean(lstEntity.get(0));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return lstBean;
	}
	
	@Override
	public List<AlterTextoPalabraEncerradaBean> buscarxCabeceraxDetalle(AlterTextoPalabraEncerradaBean alterTextoPalabraEncerradaBean) throws DAOException {
		List<AlterTextoPalabraEncerradaBean>	lstBean = null;
		List<LeotbdAltxtextopalabraence> lstEntity = null;
		// fun_leotbctextopalabraencerrada_cabeceraydetalle
		//leotbd_altxtextopalabraence.cabeceraydetalle
		try 
		{																   
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbd_altxtextopalabraence.cabeceraydetalle");
			spq.setParameter("p_codmatpej", alterTextoPalabraEncerradaBean.getTextoPalabraEncerradaBean().getMaterialTipoEjercicioBean().getCodigo());
			if (spq.execute()) 
			{
				lstEntity = spq.getResultList();
				
				if (lstEntity != null && lstEntity.size() > 0) 
				{
					System.out.println("listo bean daoimpl");
					lstBean = deListaAlternativaAListaAlternativaBean(lstEntity);
				} 
			}
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		return lstBean ;
	}
	private List<AlterTextoPalabraEncerradaBean> deListaAlternativaAListaAlternativaBean(List<LeotbdAltxtextopalabraence> lstAlternativa) {
		
		List<AlterTextoPalabraEncerradaBean> lstAlternativaBean = null; 
		if (lstAlternativa != null && lstAlternativa.size() > 0) 
		{
			lstAlternativaBean = new ArrayList<AlterTextoPalabraEncerradaBean>(); 
			for (int i = 0; i < lstAlternativa.size(); i++) 
			{ 
				LeotbdAltxtextopalabraence entity = lstAlternativa.get(i);
				AlterTextoPalabraEncerradaBean bean = deAlternativaAAlternativaBean(entity);
				
				lstAlternativaBean.add(bean);
			}
		}
		return lstAlternativaBean;
	}
	
	private AlterTextoPalabraEncerradaBean deAlternativaAAlternativaBean(LeotbdAltxtextopalabraence entity) 
	{
		AlterTextoPalabraEncerradaBean bean = null;
		
		if (entity != null) 
		{
			bean = new AlterTextoPalabraEncerradaBean();
			bean.setTextoPalabraEncerradaBean(new  TextoPalabraEncerradaBean()); 
			bean.getTextoPalabraEncerradaBean().setMaterialTipoEjercicioBean(new MaterialTipoEjercicioBean());
			bean.setCodigo(entity.getnCodaltern());
			bean.setEstado(entity.getvFlgest());
			bean.setPalabraEncerrada(entity.getvPalabraencerrada());
			bean.getTextoPalabraEncerradaBean().setCodigo(entity.getnCodtextopalabraence());			
			bean.getTextoPalabraEncerradaBean().setTexto(entity.getvTexto());
			bean.getTextoPalabraEncerradaBean().setTitulo(entity.getvTitulo());
			System.out.println("entity.getnNroOrden() "  + entity.getnNroOrden());
			bean.setNroOrden(entity.getnNroOrden());
			bean.getTextoPalabraEncerradaBean().getMaterialTipoEjercicioBean().setCodigo(entity.getnCodmatpej());
			bean.getTextoPalabraEncerradaBean().getMaterialTipoEjercicioBean().setTitulo(entity.getvTitulotipo());
			bean.getTextoPalabraEncerradaBean().setComentario(entity.getvComentario());
			bean.setPalabraRpta(entity.getvPalabrarpta());
		}
		return bean;
	}


	

}	
