package pe.gob.procalidad.natigu.core.repository.repository.implementacion.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.AdquisicionUsuarioBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.FondoBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaestraBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import pe.gob.procalidad.natigu.core.entity.entity.configuracion.LeotbcAdquiusu;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.AdquisicionUsuarioDAO;



 

@Transactional
@Repository("adquisicionUsuarioDAO")
public class AdquisicionUsuarioDAOImp implements AdquisicionUsuarioDAO{

	@PersistenceContext
	private EntityManager em; 
	
	
	public AdquisicionUsuarioBean getAdquisicionUsuarioBean(Object object){
		return (AdquisicionUsuarioBean)object;
	}
	
	private List<AdquisicionUsuarioBean> deListaAdquisicionUsuarioAListaAdquisicionUsuarioBean(List<LeotbcAdquiusu> lstAdquisicionUsuarios) {
		
		List<AdquisicionUsuarioBean> lstAdquisicionUsuarioBeans = null;
		
		if (lstAdquisicionUsuarios != null && lstAdquisicionUsuarios.size() > 0) {
			
			lstAdquisicionUsuarioBeans = new ArrayList<AdquisicionUsuarioBean>();
			
			for (int i = 0; i < lstAdquisicionUsuarios.size(); i++) { 
				LeotbcAdquiusu entity = lstAdquisicionUsuarios.get(i);
				AdquisicionUsuarioBean bean = deAdquisicionUsuarioToAdquisicionUsuarioBean(entity);
				
				lstAdquisicionUsuarioBeans.add(bean);
			}
		}
		
		return lstAdquisicionUsuarioBeans;
	}

	private AdquisicionUsuarioBean deAdquisicionUsuarioToAdquisicionUsuarioBean(LeotbcAdquiusu entity) {
		
		AdquisicionUsuarioBean bean = null;
		
		if(entity !=null){
			 bean = new AdquisicionUsuarioBean();
			 bean.setCodigoAdquisicionUsuario(entity.getNCodadquiusu());
			 bean.setCodigoRegion(entity.getNCodregion());
			 bean.setUsuario(new UsuarioBean());
			 bean.getUsuario().setCodigoUsuario(entity.getNCodusuari());
			 bean.setEstado(entity.getVFlgest());
			 if(entity.getNCodfond()!=null && entity.getNCodfond()>0){
				 bean.setFondo(new FondoBean());
				 bean.getFondo().setCodFond(entity.getNCodfond().intValue());
				 bean.getFondo().setDescripcion(entity.getvDescripcionAd());
				 bean.getFondo().setNombre(entity.getvNombreAd());
				 bean.getFondo().setMonedas(entity.getnValor());
				 bean.getFondo().setTipo(new MaestraBean());
				 bean.getFondo().getTipo().setCodigoRegistro(entity.getnTipoAdqui());
				 bean.getFondo().setImagenNombre(entity.getvImagen());
			 }
			 
			 if(entity.getNCodmasco()!=null && entity.getNCodmasco()>0){
				 bean.setMascota(new MascotaBean());
				 bean.getMascota().setCodigo(entity.getNCodmasco());
				 bean.getMascota().setDescripcion(entity.getvDescripcionAd());
				 bean.getMascota().setNombre(entity.getvNombreAd());
				 bean.getMascota().setValormoneda(entity.getnValor());
				 bean.getMascota().setPredeterminado(entity.getnTipoAdqui());
				 bean.getMascota().setImagenAlegre(entity.getvImagen());
			 }
			 bean.setTipoAdquisicion(new MaestraBean());
			 bean.getTipoAdquisicion().setCodigoRegistro(entity.getNTm1tipadqui());
		 }
		return bean;
		
		 
	}
	
	

	@Override
	public boolean insertar(AdquisicionUsuarioBean prmObject) throws DAOException {
		Object idAdquisicionUsuario= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_adquiusu.insertar");
			//spq.setParameter("p_codadquiusu", type = Long.class);
			spq.setParameter("p_codfond", prmObject.getFondo()!=null?prmObject.getFondo().getCodFond():null);
			spq.setParameter("p_codmasco", prmObject.getMascota()!=null? prmObject.getMascota().getCodigo():null);
			spq.setParameter("p_tm1tipadqui", prmObject.getTipoAdquisicion().getCodigoRegistro());
			spq.setParameter("p_codusuari", prmObject.getUsuario().getCodigoUsuario());
			spq.setParameter("p_tm1sitfousuar", "1");
			spq.setParameter("p_codusureg", prmObject.getAudCodigoUsuario());
			spq.setParameter("p_codregion", prmObject.getCodigoRegion());
			spq.setParameter("p_hostreg", prmObject.getAudHostIP());
			
			spq.execute();
			sw=true;
			
			idAdquisicionUsuario = spq.getOutputParameterValue(1);
			if (idAdquisicionUsuario != null) {
				prmObject.setCodigo(Integer.valueOf(idAdquisicionUsuario.toString()));
				if (prmObject.getCodigo()==0) {
					sw=false;
				}
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
	public boolean actualizar(AdquisicionUsuarioBean prmObject) throws DAOException { 
		boolean sw=false;
		System.out.println("prmObject actualizar " + prmObject );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_adquiusu.actualizar");
			spq.setParameter("p_codadquiusu", prmObject.getCodigoAdquisicionUsuario());
			spq.setParameter("p_codfond", prmObject.getFondo()!=null?prmObject.getFondo().getCodFond():null);
			spq.setParameter("p_codusuari", prmObject.getUsuario().getCodigoUsuario());
			spq.setParameter("p_tm1sitfousuar", "1");
			spq.setParameter("p_codregion", prmObject.getCodigoRegion());
			spq.setParameter("p_hostmod", prmObject.getAudHostIP());
			spq.setParameter("p_codusumod", prmObject.getAudCodigoUsuario());

			
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
	public boolean eliminar(AdquisicionUsuarioBean prmObject) throws DAOException {
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_adquiusu.eliminar");
			spq.setParameter("p_codadquiusu", prmObject.getCodigoAdquisicionUsuario()); 
			spq.setParameter("p_codusumod", prmObject.getAudCodigoUsuario());
			spq.setParameter("p_hostmod", prmObject.getAudHostIP());
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
	public AdquisicionUsuarioBean getBuscarPorObjecto(AdquisicionUsuarioBean prmObject) throws DAOException {
		AdquisicionUsuarioBean oAdquisicionUsuarioBean = null;
	
		return oAdquisicionUsuarioBean;
	}
	

	@SuppressWarnings({ "unchecked" })

	@Override
	public List<AdquisicionUsuarioBean> getBuscarPorFiltros(AdquisicionUsuarioBean prmObject) throws DAOException {
		System.out.println("em " + em);
		
		List<AdquisicionUsuarioBean> lstAdquisicionUsuarioBean = null;
		List<LeotbcAdquiusu> lstAdquisicionUsuario = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_adquiusu.eliminar");
			spq.setParameter("p_nomadqui", null);
			spq.setParameter("p_codregion", prmObject.getCodigoRegion());
			spq.setParameter("p_tm1tipadqui", prmObject.getTipoAdquisicion().getCodigoRegistro());
			spq.setParameter("p_codusuari", prmObject.getUsuario().getCodigoUsuario());
			spq.setParameter("p_codfond", prmObject.getFondo()!=null?prmObject.getFondo().getCodFond().longValue():null);
			spq.setParameter("p_codmasco", prmObject.getMascota()!=null?prmObject.getMascota().getCodigo():null);
			if (spq.execute()) {
				lstAdquisicionUsuario =  spq.getResultList(); 
			}
			if (lstAdquisicionUsuario != null && lstAdquisicionUsuario.size() > 0) {
				
				lstAdquisicionUsuarioBean = deListaAdquisicionUsuarioAListaAdquisicionUsuarioBean(lstAdquisicionUsuario);
			} 
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			em.close();
		}
		   
		return lstAdquisicionUsuarioBean;
		
	}


	@Override
	public boolean existe(AdquisicionUsuarioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer realizarCompra(AdquisicionUsuarioBean prmObject)
			throws DAOException {
		Object idAdquisicionUsuario= null; 
		Object resultado= null; 
		Integer sw=-1;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_adquiusu.insertar");
			//spq.setParameter("p_codadquiusu", type = Long.class);
			spq.setParameter("p_codfond", prmObject.getFondo()!=null?prmObject.getFondo().getCodFond():null);
			spq.setParameter("p_codmasco", prmObject.getMascota()!=null? prmObject.getMascota().getCodigo():null);
			spq.setParameter("p_codcombo", prmObject.getCombo()!=null? prmObject.getCombo().getCodigo():null);
			spq.setParameter("p_tm1tipadqui", prmObject.getTipoAdquisicion().getCodigoRegistro());
			spq.setParameter("p_codusuari", prmObject.getUsuario().getCodigoUsuario());
			spq.setParameter("p_codusumat", prmObject.getUsuarioMatricula().getCodigo());
			spq.setParameter("p_tm1sitfousuar", 1);
			spq.setParameter("p_codusureg", prmObject.getAudCodigoUsuario());
			spq.setParameter("p_codregion", prmObject.getCodigoRegion());
			spq.setParameter("p_hostreg", prmObject.getAudHostIP());
			
			spq.execute();
			
			
			idAdquisicionUsuario = spq.getOutputParameterValue(1);
			resultado = spq.getOutputParameterValue(1);
			if(resultado!=null){
				sw = Integer.valueOf(resultado.toString());
				
				if (sw>0 && idAdquisicionUsuario != null) {
					sw=1;
					prmObject.setCodigoAdquisicionUsuario(Long.valueOf(idAdquisicionUsuario.toString()));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			sw=-1; 
		}finally{
			em.close();
			
		
			}
		return  sw;
	}

	@Override
	public boolean actualizarSwPredeterminadoMasc(AdquisicionUsuarioBean prmObject) throws DAOException {
		boolean sw=false;
		System.out.println("prmObject actualizarSwPredeterminado " + prmObject );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_adquiusu.actualizarSwPredeterminadoMasc");
			System.out.println("prmObject.getMascota().getCodigo() "+ prmObject.getMascota().getCodigo());
			System.out.println("prmObject.getUsuario().getCodigoUsuario() "+ prmObject.getUsuario().getCodigoUsuario());
			spq.setParameter("p_codmasco", prmObject.getMascota()!=null?prmObject.getMascota().getCodigo():null);
			spq.setParameter("p_codusuari", prmObject.getUsuario().getCodigoUsuario());
			spq.setParameter("p_swpredeterminado", 1);
			spq.setParameter("p_hostmod", prmObject.getUsuario().getAudHostIP());
			spq.setParameter("p_codusumod", prmObject.getUsuario().getIpModificacion());

			
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
	public boolean actualizarSwPredeterminadoFond(AdquisicionUsuarioBean prmObject) throws DAOException {
		boolean sw=false;
		System.out.println("prmObject actualizarSwPredeterminado " + prmObject );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_adquiusu.actualizarSwPredeterminadoFond");
			System.out.println("prmObject.getFondo().getCodigo() "+ prmObject.getFondo().getCodigo());
			System.out.println("prmObject.getUsuario().getCodigoUsuario() "+ prmObject.getUsuario().getCodigoUsuario());
			spq.setParameter("p_codfond", prmObject.getFondo()!=null?prmObject.getFondo().getCodigo():null);
			spq.setParameter("p_codusuari", prmObject.getUsuario().getCodigoUsuario());
			spq.setParameter("p_swpredeterminado", 1);
			spq.setParameter("p_hostmod", prmObject.getUsuario().getAudHostIP());
			spq.setParameter("p_codusumod", prmObject.getUsuario().getIpModificacion());

			
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
	public boolean actualizarSwPredeterminadoCombo(AdquisicionUsuarioBean prmObject) throws DAOException {
		boolean sw=false;
		System.out.println("prmObject actualizarSwPredeterminado " + prmObject );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_adquiusu.actualizarSwPredeterminadoComb");
			spq.setParameter("p_combo", prmObject.getCombo()!=null?prmObject.getCombo().getCodigo():null);
			spq.setParameter("p_codusuari", prmObject.getUsuario().getCodigoUsuario());
			spq.setParameter("p_swpredeterminado", 1);
			spq.setParameter("p_hostmod", prmObject.getUsuario().getAudHostIP());
			spq.setParameter("p_codusumod", prmObject.getUsuario().getIpModificacion());

			
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
	
		
				
				
				
		
		
		
		
		
		
		
		
}