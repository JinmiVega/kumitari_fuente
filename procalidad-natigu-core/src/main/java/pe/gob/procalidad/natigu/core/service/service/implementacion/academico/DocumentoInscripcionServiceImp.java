package pe.gob.procalidad.natigu.core.service.service.implementacion.academico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.academico.DocumentoInscripcionBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.academico.DocumentoInscripcionDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.academico.DocumentoInscripcionService;


 
@Service("documentoinscripcionService")
@Transactional (readOnly = true)
public class DocumentoInscripcionServiceImp implements DocumentoInscripcionService {
	
	@Autowired
	private DocumentoInscripcionDAO documentoInscripcionDAO;

	@Override
	public boolean insertar(DocumentoInscripcionBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  documentoInscripcionDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(DocumentoInscripcionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(DocumentoInscripcionBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  documentoInscripcionDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public DocumentoInscripcionBean getBuscarPorObjecto(DocumentoInscripcionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocumentoInscripcionBean> getBuscarPorFiltros(DocumentoInscripcionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(DocumentoInscripcionBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DocumentoInscripcionBean> listarDocumentoInscripcionBeanxCodInsc(DocumentoInscripcionBean documentoInscripcionBean) throws ServiceException {
		List<DocumentoInscripcionBean> lstDocumentoInscripcionBean=null;
		try {
			System.out.println("en listado Institucion service imp");
			lstDocumentoInscripcionBean=documentoInscripcionDAO.listarDocumentoInscripcionBeanxCodInsc(documentoInscripcionBean);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		 
		return lstDocumentoInscripcionBean;
	} 
	


	
	 
	
}
	
	 
