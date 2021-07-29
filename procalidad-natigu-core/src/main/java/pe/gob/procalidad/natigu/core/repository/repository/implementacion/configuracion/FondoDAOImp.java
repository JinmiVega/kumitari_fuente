package pe.gob.procalidad.natigu.core.repository.repository.implementacion.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.FondoBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcFondo;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcMascota;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.FondoDAO;



 

@Transactional
@Repository("fondoDAO")
public class FondoDAOImp implements FondoDAO{

	@PersistenceContext
	private EntityManager em; 
	
	
	public FondoBean getFondoBean(Object object){
		return (FondoBean)object;
	}
	
	private List<FondoBean> deListaFondoAListaFondoBean(List<LeotbcFondo> lstFondos) {
		
		List<FondoBean> lstFondoBeans = null;
		
		if (lstFondos != null && lstFondos.size() > 0) {
			
			lstFondoBeans = new ArrayList<FondoBean>();
			
			for (int i = 0; i < lstFondos.size(); i++) { 
				LeotbcFondo entity = lstFondos.get(i);
				FondoBean bean = deInscripcionAInscripcionBean(entity);
				
				lstFondoBeans.add(bean);
			}
		}
		
		return lstFondoBeans;
	}

	private FondoBean deInscripcionAInscripcionBean(LeotbcFondo entity) {
		
		FondoBean bean = null;
		
		if(entity !=null){
			 bean = new FondoBean();
			 
				bean.setEstado(entity.getvFlgest());
				bean.setCodigo(entity.getnCodfond()); 
				bean.setImagenNombre(entity.getvNomimagf());
				bean.setImagenNombreTienda(entity.getvNomimagfti());
				bean.setNombre(entity.getvNomfond());
				bean.setDescripcion(entity.getvDesfond());
				bean.getRegion().setCodigoRegistro(entity.getnCodregion());
				bean.setMonedas(entity.getiValfond());
				bean.setGemas(entity.getiValgem());
				bean.getRegion().setNombreCorto(entity.getV_nomcortoRegion()); 
				System.out.println("entity.getnTm1sitfond() "+ entity.getnTm1sitfond());
				bean.getSituacion().setCodigoRegistro(entity.getnTm1sitfond());
				bean.getSituacion().setNombreCorto(entity.getV_nomcortoSituacion()); 
				bean.getTipo().setCodigoRegistro(entity.getnTm1tpfond());
				bean.getTipo().setNombreCorto(entity.getV_nomcortoTipo()); 
				bean.setMonedas(entity.getiValfond());
				bean.setCantidadComprado(entity.getnCantCompra());
				bean.setnSwpredeterminado(entity.getnSwpredeterminado());
		 }
		return bean;
		
		 
	}
	
	

	@Override
	public boolean insertar(FondoBean fondoBean) throws DAOException {
		Object idFondo= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcFondo.insertar");
			spq.setParameter("p_nomfond", fondoBean.getNombre());
			spq.setParameter("p_desfond", fondoBean.getDescripcion());
			spq.setParameter("p_codregion", fondoBean.getRegion().getCodigoRegistro());
			System.out.println("fondoBean.getMonedas() " + fondoBean.getMonedas());
			spq.setParameter("p_valfond", fondoBean.getMonedas());
			spq.setParameter("p_valgem", fondoBean.getGemas());
			spq.setParameter("p_tm1tpfond", fondoBean.getSituacion().getCodigoRegistro());
			System.out.println("fondoBean.getSituacion().getCodigoRegistro() " + fondoBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_tm1sitfond", fondoBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_hostreg", "");
			spq.setParameter("p_codusureg", "1"); 
			spq.setParameter("p_nomimagf", fondoBean.getImagenNombre());
			spq.setParameter("p_nomimagfti", fondoBean.getImagenNombreTienda());
			
			spq.execute();
			
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			
			idFondo = spq.getOutputParameterValue(1);
			if (idFondo != null) {
				fondoBean.setCodigo(Integer.valueOf(idFondo.toString()));
				
				sw=true;
				
			}else{
				System.out.println("obj null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
			
		
			}
		return  sw;
		}


	@Override
	public boolean actualizar(FondoBean fondoBean) throws DAOException { 
		boolean sw=false;
		System.out.println("fondoBean actualizar " + fondoBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcFondo.actualizar");
//			spq.setParameter("p_return",  fondoBean.getRetorno()); 
			spq.setParameter("p_codfond", fondoBean.getCodigo()); 
			spq.setParameter("p_nomfond", fondoBean.getNombre());
			spq.setParameter("p_desfond", fondoBean.getDescripcion());
			spq.setParameter("p_tm1sitfond", fondoBean.getSituacion().getCodigoRegistro());
			spq.setParameter("p_codregion", fondoBean.getRegion().getCodigoRegistro());
			spq.setParameter("p_valfond", fondoBean.getMonedas());
			spq.setParameter("p_valgem", fondoBean.getGemas());
//			spq.setParameter("p_tm1tpfond", fondoBean.getTipo().getCodigoRegistro());
			spq.setParameter("p_codusumod", 12);
			spq.setParameter("p_hostmod", ""); 
			spq.setParameter("p_nomimagf", fondoBean.getImagenNombre());
			spq.setParameter("p_nomimagfti", fondoBean.getImagenNombreTienda());
			
			
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
	public boolean eliminar(FondoBean fondoBean) throws DAOException {
		Object idFondo= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcFondo.eliminar");
			spq.setParameter("p_codfond", fondoBean.getCodigo()); 
			spq.setParameter("p_codusumod", 12);
			spq.setParameter("p_hostmod", "");
			spq.execute();   
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idFondo = spq.getOutputParameterValue(1);
			if (idFondo != null) {
				fondoBean.setRetorno(Integer.valueOf(idFondo.toString()));
				if (fondoBean.getRetorno()==0) {
					sw=false;
				}
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
	public FondoBean getBuscarPorObjecto(FondoBean fondoBean) throws DAOException {
		FondoBean oFondoBean = null;
		List<LeotbcFondo> lstLeotbcFondos = null;
		System.out.println("fondoBean getBuscarPorObjecto " + fondoBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcFondo.buscar_por_codigo");
			spq.setParameter("p_codfond", fondoBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstLeotbcFondos = spq.getResultList();			
			}
			
			if (	lstLeotbcFondos != null
				&&	lstLeotbcFondos.size() > 0) {
				
				oFondoBean = deInscripcionAInscripcionBean(lstLeotbcFondos.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oFondoBean;
	}
	

	@SuppressWarnings({ "unchecked" })

	@Override
	public List<FondoBean> getBuscarPorFiltros(FondoBean fondoBean) throws DAOException {
		System.out.println("em " + em);
		List<LeotbcFondo> lstFondos = null;	
		List<FondoBean> lstFondoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_fondo.listar");
																			
			spq.setParameter("p_nomfond", fondoBean.getNombre());  
			spq.setParameter("p_codregion", fondoBean.getRegion().getCodigoRegistro()); 
			spq.setParameter("p_tm1tpfond", fondoBean.getTipo().getCodigoRegistro()); 
			spq.setParameter("p_tm1sitfond", fondoBean.getSituacion().getCodigoRegistro()); 
			
			 if (spq.execute()) {
				 lstFondos =  spq.getResultList(); 
			}
			if (lstFondos != null && lstFondos.size() > 0) {
				
				lstFondoBean = deListaFondoAListaFondoBean(lstFondos);
			}
//			em.close();
			
		   
		return lstFondoBean;
		
	}


	@Override
	public boolean existe(FondoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<FondoBean> getBuscarPorFiltrosAlumno(FondoBean fondoBean) throws DAOException {
		System.out.println("em " + em);
		List<LeotbcFondo> lstFondos = null;	
		List<FondoBean> lstFondoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_fondo.listarAlumno");
																			
			spq.setParameter("p_nomfond", fondoBean.getNombre());  
			spq.setParameter("p_codregion", fondoBean.getRegion().getCodigoRegistro()); 
			spq.setParameter("p_tm1tpfond", fondoBean.getTipo().getCodigoRegistro()); 
			spq.setParameter("p_tm1sitfond", fondoBean.getSituacion().getCodigoRegistro()); 
			spq.setParameter("p_codusu", fondoBean.getAudCodigoUsuario());
			 if (spq.execute()) {
				 lstFondos =  spq.getResultList(); 
			}
			if (lstFondos != null && lstFondos.size() > 0) {
				
				lstFondoBean = deListaFondoAListaFondoBean(lstFondos);
			}
//			em.close();
			
		   
		return lstFondoBean;
		
	}

	@Override
	public FondoBean getlistarFondoSwPredetAlumno(FondoBean fondoBean) throws DAOException {
		FondoBean oFondoBean = null;
		List<LeotbcFondo> lstLeotbcFondo = null;
		System.out.println("mascotaBean getlistarMasctoSwPredetAlumno " + fondoBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_fondo.listarFondoSwPredetAlumno");			
			spq.setParameter("p_codusu", fondoBean.getAudCodigoUsuario()); 
			
		
			if (spq.execute()) {
				lstLeotbcFondo = spq.getResultList();			
			}
			
			if (	lstLeotbcFondo != null
				&&	lstLeotbcFondo.size() > 0) {
				
				oFondoBean = deInscripcionAInscripcionBean(lstLeotbcFondo.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oFondoBean;
	}	
		
		
		
		
}