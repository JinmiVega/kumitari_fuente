package pe.gob.procalidad.natigu.core.repository.repository.implementacion.academico;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaAlumnoBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.MatriculaDocenteBean;
import pe.gob.procalidad.natigu.core.bean.bean.academico.UsuarioMatriculaBean;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeomvcMatricula;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeomvdMatdocente;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeomvdMatriculaAlumno;
import pe.gob.procalidad.natigu.core.entity.entity.academico.LeotbdUsuMatricula;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.MatriculaAlumnoDAO;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.MatriculaDocenteDAO;

@Transactional
@Repository("matriculaDocenteDAO")
public class MatriculaDocenteDAOImp implements MatriculaDocenteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(MatriculaDocenteBean matriculaBean) throws DAOException {
		Object idMatriculaAlu= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvd_matdocente.insertar");
			

			spq.setParameter("p_codmatri", 		matriculaBean.getMatriculaBean().getCodigo());
			spq.setParameter("p_coddocen", 		matriculaBean.getDocenteBean().getCodigo());
			spq.setParameter("p_tm1tipdoc",	 	matriculaBean.getTipoDocente().getCodigoRegistro());
			spq.setParameter("p_tm1sitmdo",	 	matriculaBean.getSituacionMatriculaDocente().getCodigoRegistro());
			
			spq.setParameter("p_codusureg", 	matriculaBean.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", 		matriculaBean.getIpCreacion()); 
			
			spq.execute();
			
			idMatriculaAlu = spq.getOutputParameterValue(1);
			if (idMatriculaAlu != null) {
				matriculaBean.setCodigo(Integer.valueOf(idMatriculaAlu.toString()));
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
	public boolean actualizar(MatriculaDocenteBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(MatriculaDocenteBean matriculaBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvd_matdocente.eliminar");
			spq.setParameter("p_codmatdoc", 	matriculaBean.getCodigo()); 
			spq.setParameter("p_codusumod", matriculaBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod",	matriculaBean.getIpModificacion());
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
	public MatriculaDocenteBean getBuscarPorObjecto(MatriculaDocenteBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MatriculaDocenteBean> getBuscarPorFiltros(MatriculaDocenteBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(MatriculaDocenteBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MatriculaDocenteBean> listarDocentexMatricula(MatriculaDocenteBean matriculaDocenteBean)
			throws DAOException {
		List<LeomvdMatdocente> lstLeomvdMatdocente = null;	
		List<MatriculaDocenteBean> lstMatriculaDocenteBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvd_matdocente.buscarMatriculaXDocente");
			spq.setParameter("p_coddocen", matriculaDocenteBean.getMatriculaBean().getCodigo());   
			if (spq.execute()) {
				lstLeomvdMatdocente =  spq.getResultList(); 
			} 
			if (lstLeomvdMatdocente != null && lstLeomvdMatdocente.size() > 0) {
				
				lstMatriculaDocenteBean = deListaMatriculaAlumnoAListaMatriculaAlumnoBean(lstLeomvdMatdocente);
			}
		em.close();
			
		   
		return lstMatriculaDocenteBean;
	}
	
private List<MatriculaDocenteBean> deListaMatriculaAlumnoAListaMatriculaAlumnoBean(List<LeomvdMatdocente> lstHorarioExcepcion) {
		
		List<MatriculaDocenteBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<MatriculaDocenteBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				LeomvdMatdocente entity = lstHorarioExcepcion.get(i);
				MatriculaDocenteBean bean = deMatriculaAlumnoAMatriculaAlumnoBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}



private MatriculaDocenteBean deMatriculaAlumnoAMatriculaAlumnoBean(LeomvdMatdocente entity) {
	
		MatriculaDocenteBean bean = null;
	
	if (entity != null) {
		
		bean = new MatriculaDocenteBean();
		
		bean.setCodigo(entity.getnCodmatdoc()); 
		
		bean.getDocenteBean().setCodigo(entity.getnCoddocen());

		
		bean.getMatriculaBean().setCodigo(entity.getnCodmatri());
	
		
		bean.getDocenteBean().getPersonaBean().setNombrePersona(entity.getVnombreper());
		bean.getDocenteBean().getPersonaBean().setApellidoPaterno(entity.getVapepatper());
		bean.getDocenteBean().getPersonaBean().setApellidoMaterno(entity.getVapematper());
		bean.getDocenteBean().getPersonaBean().setNumeroDocumento(entity.getVnumdocum());
		System.out.println("entity.getdFecreg() " + entity.getdFecreg());
		bean.setFechaCreacion(entity.getdFecreg());
		bean.getSituacionMatriculaDocente().setNombreCorto(entity.getVnombretm1sitdoc());
		bean.getTipoDocente().setCodigoRegistro((int)entity.getnTm1tipdoc());
		bean.getTipoDocente().setNombreCorto(entity.getVnombretm1tipdoc());
	}
	
	return bean;
}

		@Override
		public MatriculaDocenteBean validarDocentexMatricula(MatriculaDocenteBean matriculaDocenteBean) throws DAOException {
			MatriculaDocenteBean oMatriculaDocenteBean = null;
			List<LeomvdMatdocente> lstLeomvdMatdocente = null;
				System.out.println("matriculaBean getBuscarPorObjecto " + matriculaDocenteBean.getCodigo() );
			try {
				StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leomvd_matdocente.validarMatriculaXDocente");
				spq.setParameter("p_coddocen", matriculaDocenteBean.getMatriculaBean().getCodigo()); 
				spq.setParameter("p_tm1sitmdo", matriculaDocenteBean.getTipoDocente().getCodigoRegistro());  
				if (spq.execute()) {
					lstLeomvdMatdocente =  spq.getResultList(); 
				} 
				if (lstLeomvdMatdocente != null && lstLeomvdMatdocente.size() > 0) {
					
					oMatriculaDocenteBean = deMatriculaAlumnoAMatriculaAlumnoBean(lstLeomvdMatdocente.get(0));
				}
		
			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException(e);
			}finally{
				em.close();
			}
			return oMatriculaDocenteBean;
		}

}
