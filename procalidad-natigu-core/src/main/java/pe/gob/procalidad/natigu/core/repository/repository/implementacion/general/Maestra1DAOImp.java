package pe.gob.procalidad.natigu.core.repository.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcMascota;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcPremio;
import pe.gob.procalidad.natigu.core.entity.entity.general.LeotbcMaestra1;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException; 
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.Maestra1DAO;
 
@Transactional
@Repository("maestra1DAO")
public class Maestra1DAOImp implements Maestra1DAO {
	
	
	@PersistenceContext
	private EntityManager em; 
	
	public MaestraBean getMaestraBean(Object object){
		return (MaestraBean)object;
	} 
	
	@Override
	public boolean insertar(MaestraBean maestraBean) throws DAOException {   
		Object idMaestra= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra1.insertar");
			spq.setParameter("p_codtabla", maestraBean.getCodigoTabla());
		    spq.setParameter("p_codregis", maestraBean.getCodigoRegistro()); 
			spq.setParameter("p_nomcorto", maestraBean.getNombreCorto()); 
			spq.setParameter("p_nomlargo", maestraBean.getNombreLargo());
			spq.setParameter("p_valor1", maestraBean.getValor1());
			spq.setParameter("p_valor2", maestraBean.getValor2());
			spq.setParameter("p_valor3", maestraBean.getValor3());
			spq.setParameter("p_fileimg", maestraBean.getFileimg());
			spq.setParameter("p_orden", maestraBean.getOrden());
			spq.setParameter("p_codusureg", 1);
			spq.setParameter("p_hostreg", ""); 
			spq.execute();
			
			
			idMaestra = spq.getOutputParameterValue(1);
			if (idMaestra != null) {
				maestraBean.setCodigoRegistro(Integer.valueOf(idMaestra.toString()));
				System.out.println("maestraBean.getCodigoRegistro()"+maestraBean.getCodigoRegistro());
				if (maestraBean.getCodigoRegistro()!=0) {
					sw=true;
				}else{
					System.out.println("maestraBean.getCodigoRegistro() = 0");
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
	public boolean eliminar(MaestraBean maestraBean) throws DAOException { 
		Object idMaestra= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra.eliminar");
			spq.setParameter("p_return", maestraBean.getId()); 
			spq.setParameter("p_codtabla", maestraBean.getCodigoTabla()); 
			spq.setParameter("p_codregis", maestraBean.getCodigoRegistro()); 
			spq.execute();   
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idMaestra = spq.getOutputParameterValue(1);
			if (idMaestra != null) {
				maestraBean.setId(Integer.valueOf(idMaestra.toString()));
				if (maestraBean.getId()==0) {
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
	public boolean actualizar(MaestraBean maestraBean) throws DAOException {
		Object idMaestra= null;
		boolean sw=false;
		System.out.println("maestraBean actualizar " + maestraBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra1.actualizar");
			spq.setParameter("p_return", maestraBean.getId()); 
			spq.setParameter("p_codregis", maestraBean.getCodigoRegistro()); 
			spq.setParameter("p_codtabla", maestraBean.getCodigoTabla()); 
			spq.setParameter("p_nomcorto", maestraBean.getNombreCorto());  
			spq.setParameter("p_nomlargo", maestraBean.getNombreLargo()); 
			spq.setParameter("p_valor1", maestraBean.getValor1()); 
			spq.setParameter("p_valor2", maestraBean.getValor2()); 
			spq.setParameter("p_valor3", maestraBean.getValor3());
			spq.setParameter("p_fileimg", maestraBean.getFileimg());
			spq.setParameter("p_orden", maestraBean.getOrden());  
			System.out.println("p_return " +  maestraBean.getId()); 
			System.out.println(" p_codtabla" +  maestraBean.getCodigoTabla());   
			spq.execute();   
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idMaestra = spq.getOutputParameterValue(1);
			if (idMaestra != null) {
				maestraBean.setId(Integer.valueOf(idMaestra.toString()));
				if (maestraBean.getId()==0) {
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
	
	@SuppressWarnings("unchecked")
	@Override
	public MaestraBean getBuscarPorTablaYRegistro(MaestraBean maestraBean) throws DAOException {
		MaestraBean omaestraBean = null;
		List<LeotbcMaestra1> lstLeotbcMaestra = null;
		System.out.println("maestraBean getBuscarPorObjecto2 codreg" + maestraBean.getCodigoRegistro() );
		System.out.println("maestraBean getBuscarPorObjecto2 codtabl" + maestraBean.getCodigoTabla() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra1.buscarXcod_Tabla_Registro");			
			spq.setParameter("p_codtabla", maestraBean.getCodigoTabla()); 
			spq.setParameter("p_codregis", maestraBean.getCodigoRegistro());
		
			if (spq.execute()) {
				lstLeotbcMaestra = spq.getResultList();			
			}
			
			if (	lstLeotbcMaestra != null
				&&	lstLeotbcMaestra.size() > 0) {
				
				omaestraBean = deMaestraAMaestraBean(lstLeotbcMaestra.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return omaestraBean;
	}


//	@Override
//	public boolean eliminar(MaestraBean maestra1Bean) throws DAOException { 
//		boolean sw=false;
//		try {
//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra1.eliminar");
//			spq.setParameter("p_codmaestra1", maestra1Bean.getId()); 
//			
//			spq.execute();  
//			sw=true;
//			 
//		} catch (Exception e) {
//			e.printStackTrace();
//			sw=false; 
//		}finally{
//			em.close();
//		}
//		return sw;
//	}


	@SuppressWarnings("unchecked")
	@Override
	public MaestraBean getBuscarPorObjecto(MaestraBean maestra1Bean) throws DAOException {
		MaestraBean oMaestraBean = null;
		List<LeotbcMaestra1> lstLeotbcMaestra1 = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra1.buscar_por_codigo");
			
			spq.setParameter("p_codtabla", maestra1Bean.getId()); 
			
		
			if (spq.execute()) {
				lstLeotbcMaestra1 = spq.getResultList();			
			}
			
			if (	lstLeotbcMaestra1 != null
				&&	lstLeotbcMaestra1.size() > 0) {
				
				oMaestraBean = deMaestraAMaestraBean(lstLeotbcMaestra1.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oMaestraBean;
	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<MaestraBean> getBuscarPorFiltros(MaestraBean maestraBean) throws DAOException { 
		System.out.println("em " + em);
		List<LeotbcMaestra1> lstmaestra = null;	
		List<MaestraBean> lstMaestraBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra1.listar");
			spq.setParameter("p_codtabla", maestraBean.getCodigoTabla());   
			spq.setParameter("p_nomcorto", maestraBean.getNombreCorto()); 
			
			 
			lstmaestra =  spq.getResultList(); 
			 
			if (lstmaestra != null && lstmaestra.size() > 0) {
				
				lstMaestraBean = deListaMaestra1AListaMaestraBean(lstmaestra);
			}
//			em.close();
			
		   
		return lstMaestraBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MaestraBean> listarPorCodigoTabla(String codTabla,long tipo) throws DAOException {
		List<LeotbcMaestra1> lstMaestra1 = null;	
		List<MaestraBean> lstMaestraBean = null;
		System.out.println("listarPorCodigoTabla  "+ codTabla);
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra1.listarPorCodigoTabla");   
			spq.setParameter("p_codtabla", codTabla); 
			spq.setParameter("p_tipo", tipo);
			
			if (spq.execute()) {
				lstMaestra1 =  spq.getResultList(); 
			} 
			if (lstMaestra1 != null && lstMaestra1.size() > 0) {
				
				lstMaestraBean = deListaMaestra1AListaMaestraBean(lstMaestra1);
				System.out.println("lstMaestraBean dao :: " + lstMaestraBean.size());
			}
			em.close();
		return lstMaestraBean;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MaestraBean> listarComboGeneral(String codTabla) throws DAOException {
		List<LeotbcMaestra1> lstMaestra1 = null;	
		List<MaestraBean> lstMaestraBean = null;
//		System.out.println("listarPorCodigoTabla  "+ codTabla);
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra1.listarComboGeneral");   
			spq.setParameter("p_codregis", codTabla); 
			if (spq.execute()) {
				lstMaestra1 =  spq.getResultList(); 
			} 
			if (lstMaestra1 != null && lstMaestra1.size() > 0) {
				
				lstMaestraBean = deListaMaestra1AListaMaestraBean(lstMaestra1);
			}
			System.out.println("lstMaestraBean dao :: " + lstMaestraBean.size());
			em.close();
		return lstMaestraBean;
	}
	

	@Override
	public boolean existe(MaestraBean t) throws DAOException { 
		return false;
	}
	
	private List<MaestraBean> deListaMaestra1AListaMaestraBean(List<LeotbcMaestra1> lstHorarioExcepcion) {
		
		List<MaestraBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<MaestraBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				LeotbcMaestra1 entity = lstHorarioExcepcion.get(i);
				MaestraBean bean = deMaestraAMaestraBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private MaestraBean deMaestraAMaestraBean(LeotbcMaestra1 entity) {
		
		MaestraBean bean = null;
		
		if (entity != null) {
			
			bean = new MaestraBean();
			bean.setCodigoRegistro(entity.getNCodregis().intValue());  
			bean.setNombreCorto(entity.getVNomcorto()); 
			bean.setNombreLargo(entity.getVNomlargo()); 
			bean.setCodigoTabla(entity.getVCodtabla()); 
			bean.setValor1(entity.getVValor1());
			bean.setValor2(entity.getVValor2());
			bean.setValor3(entity.getVValor3());
			bean.setFileimg(entity.getvFileimg());
			bean.setOrden(entity.getNOrden());
//			bean.setCodigoUsuarioCreacion(entity.getvCodusureg()); 
			bean.setEstado(entity.getVFlgest());
			bean.setEditable(entity.getvSweditable());
			bean.setDescripcion(entity.getV_descripcion());
			bean.setSwEliminar(entity.getvSweliminar());
			 
		}
		
		return bean;
	}

}
