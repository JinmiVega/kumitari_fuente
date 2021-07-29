package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.procalidad.natigu.core.bean.bean.generico.OrdenarParrafoCabeceraBean;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.OrdenarParrafoCabeceraDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.OrdenarParrafoCabeceraService;
@Service("ordenarParrafoCabeceraService")
@Transactional (readOnly = true)
public class OrdenarParrafoCabeceraServiceImpl implements OrdenarParrafoCabeceraService{

	@Autowired
	private OrdenarParrafoCabeceraDAO OrdenarParrafoCabeceraDAO;
	
	@Override
	public boolean insertar(OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean)
			throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getOrdenarParrafoCabeceraDAO().insertar(ordenarParrafoCabeceraBean);
		} catch (Exception e) {
			sw =  false;
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean)
			throws ServiceException {
		boolean sw =  false;
		try {
			sw =  this.getOrdenarParrafoCabeceraDAO().actualizar(ordenarParrafoCabeceraBean);
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean)
			throws ServiceException {
		boolean sw = false;
		try {
			sw = this.getOrdenarParrafoCabeceraDAO().eliminar(ordenarParrafoCabeceraBean);
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public OrdenarParrafoCabeceraBean getBuscarPorObjecto(
			OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean) throws ServiceException {
		OrdenarParrafoCabeceraBean oOrdenarParrafoCabeceraBean = null;
		try {
			oOrdenarParrafoCabeceraBean = this.getOrdenarParrafoCabeceraDAO().getBuscarPorObjecto(ordenarParrafoCabeceraBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oOrdenarParrafoCabeceraBean;
	}

	@Override
	public List<OrdenarParrafoCabeceraBean> getBuscarPorFiltros(
			OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean) throws ServiceException {
		List<OrdenarParrafoCabeceraBean> lstOrdenarParrafoCabeceraBeans = null;
//		try {
//			lstOrdenarParrafoCabeceraBeans = this.getOrdenarParrafoCabeceraDAO().getBuscarPorFiltros(ordenarParrafoCabeceraBean);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return lstOrdenarParrafoCabeceraBeans;
	}

	@Override
	public boolean existe(OrdenarParrafoCabeceraBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public OrdenarParrafoCabeceraDAO getOrdenarParrafoCabeceraDAO() {
		return OrdenarParrafoCabeceraDAO;
	}

	public void setOrdenarParrafoCabeceraDAO(
			OrdenarParrafoCabeceraDAO ordenarParrafoCabeceraDAO) {
		OrdenarParrafoCabeceraDAO = ordenarParrafoCabeceraDAO;
	}

	@Override
	public OrdenarParrafoCabeceraBean listarCodigoTipoEjercicio(
			OrdenarParrafoCabeceraBean ordenarParrafoCabeceraBean)
			throws ServiceException {
		OrdenarParrafoCabeceraBean oOrdenarParrafoCabeceraBean = null;
		try {
			oOrdenarParrafoCabeceraBean = this.getOrdenarParrafoCabeceraDAO().listarCodigoTipoEjercicio(ordenarParrafoCabeceraBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oOrdenarParrafoCabeceraBean;
	}
	
}
