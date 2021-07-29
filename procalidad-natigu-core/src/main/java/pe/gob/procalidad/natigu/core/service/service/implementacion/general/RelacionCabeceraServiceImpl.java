package pe.gob.procalidad.natigu.core.service.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.gob.procalidad.natigu.core.bean.bean.generico.ArrastraOraciBean;
//import pe.gob.procalidad.natigu.core.bean.bean.generico.EjercicioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.RelacionCabeceraBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.RelacionCabeceraDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.RelacionCabeceraService;

@Service("relacionCabeceraService")
@Transactional (readOnly = true)
public class RelacionCabeceraServiceImpl implements RelacionCabeceraService{

	@Autowired
	private RelacionCabeceraDAO relacionCabeceraDAO;
	
	@Override
	public boolean insertar(RelacionCabeceraBean relacionCabeceraBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = relacionCabeceraDAO.insertar(relacionCabeceraBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(RelacionCabeceraBean relacionCabeceraBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = relacionCabeceraDAO.actualizar(relacionCabeceraBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(RelacionCabeceraBean relacionCabeceraBean) throws ServiceException {
		boolean sw = false;
		try {
			sw = relacionCabeceraDAO.eliminar(relacionCabeceraBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public RelacionCabeceraBean getBuscarPorObjecto(RelacionCabeceraBean relacionCabeceraBean) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RelacionCabeceraBean> getBuscarPorFiltros(RelacionCabeceraBean relacionCabeceraBean) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(RelacionCabeceraBean relacionCabeceraBean) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RelacionCabeceraBean> buscarPorEjercicio(RelacionCabeceraBean relacionCabeceraBean) throws ServiceException {
		List<RelacionCabeceraBean> lstPreguntas = null;
		try 
		{
			lstPreguntas = relacionCabeceraDAO.buscarPorEjercicio(relacionCabeceraBean);
		} 
		catch (DAOException e) 
		{
			e.printStackTrace();
		}
		return lstPreguntas;
	}

	@Override
	public  RelacionCabeceraBean  getBuscarPorTEM(RelacionCabeceraBean beBean) throws ServiceException {
		RelacionCabeceraBean bean = null;
		try {
			bean = relacionCabeceraDAO.getBuscarPorTEM(beBean);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return bean;
	}
	@Override
	public List<RelacionCabeceraBean> busccarPorMatTEjerRelacionCab(RelacionCabeceraBean relacionCabeceraBean)
			throws ServiceException {
		List<RelacionCabeceraBean> lstRelacionCab = null;
		try 
		{
			lstRelacionCab = relacionCabeceraDAO.buscarPorMatTEjerRelacionCab(relacionCabeceraBean);
		} 
		catch (DAOException e) 
		{
			e.printStackTrace();
		}
		return lstRelacionCab;
	}
	
}
