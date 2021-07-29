package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.MaterialTipoEjercicioBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.MaterialTipoEjercicioDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.MaterialTipoEjercicioService;
@Service("lenguaMaterialTipoEjercicioService")
@Transactional (readOnly = true)
public class MaterialTipoEjercicioServiceImpl implements MaterialTipoEjercicioService{

	@Autowired
	private MaterialTipoEjercicioDAO  materialTipoEjercicioDAO;
	
	@Override
	public boolean insertar(MaterialTipoEjercicioBean materialTipoEjercicioBean)
			throws ServiceException {
		boolean sw =  false;
		try {
			sw = (this.getMaterialTipoEjercicioDAO().insertar(materialTipoEjercicioBean));
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(MaterialTipoEjercicioBean materialTipoEjercicioBean)
			throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getMaterialTipoEjercicioDAO().actualizar(materialTipoEjercicioBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
			throw new ServiceException(e);
			
		}
		return sw;
	}

	@Override
	public boolean eliminar(MaterialTipoEjercicioBean materialTipoEjercicioBean)
			throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getMaterialTipoEjercicioDAO().eliminar(materialTipoEjercicioBean);
			
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}
	
	public boolean actualizarOrden(MaterialTipoEjercicioBean materialTipoEjercicioBean)
			throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getMaterialTipoEjercicioDAO().actualizarOrden(materialTipoEjercicioBean);
			
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public MaterialTipoEjercicioBean getBuscarPorObjecto(
			MaterialTipoEjercicioBean materialTipoEjercicioBean) throws ServiceException {
			MaterialTipoEjercicioBean oMaterialTipoEjercicioBean = null;
			try {
				oMaterialTipoEjercicioBean = this.getMaterialTipoEjercicioDAO().getBuscarPorObjecto(materialTipoEjercicioBean);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServiceException(e);
			}
		return oMaterialTipoEjercicioBean;
	}

	@Override
	public List<MaterialTipoEjercicioBean> getBuscarPorFiltros(
			MaterialTipoEjercicioBean materialTipoEjercicioBean) throws ServiceException {
		List<MaterialTipoEjercicioBean> lstMaterialTipoEjercicioBeans = null;
		try {
			lstMaterialTipoEjercicioBeans = this.getMaterialTipoEjercicioDAO().getBuscarPorFiltros(materialTipoEjercicioBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstMaterialTipoEjercicioBeans;
	}

	@Override
	public boolean existe(MaterialTipoEjercicioBean materialTipoEjercicioBean)
			throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public MaterialTipoEjercicioDAO getMaterialTipoEjercicioDAO() {
		return materialTipoEjercicioDAO;
	}

	public void setMaterialTipoEjercicioDAO(
			MaterialTipoEjercicioDAO materialTipoEjercicioDAO) {
		this.materialTipoEjercicioDAO = materialTipoEjercicioDAO;
	}

	
	

}
