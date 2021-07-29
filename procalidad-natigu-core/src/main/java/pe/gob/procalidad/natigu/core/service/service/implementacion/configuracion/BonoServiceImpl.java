package pe.gob.procalidad.natigu.core.service.service.implementacion.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.procalidad.natigu.core.bean.bean.configuracion.BonoBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.configuracion.BonoDAO;
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.configuracion.BonoService;
@Transactional
@Service("bonoService")
public class BonoServiceImpl  implements BonoService{
	
	@Autowired
	private BonoDAO bonoDAO;

	@Override
	public boolean insertar(BonoBean bonoBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw = this.getBonoDAO().insertar(bonoBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(BonoBean bonoBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw = this.getBonoDAO().actualizar(bonoBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

 
	@Override
	public boolean eliminar(BonoBean bonoBean) throws ServiceException {
		
		boolean sw =  false;
		
		try {
			
			sw = this.getBonoDAO().eliminar(bonoBean);
			
		} catch (Exception e) {
			
			sw =  false;
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public BonoBean getBuscarPorObjecto(BonoBean bonoBean) throws ServiceException {
		BonoBean oBonoBean = null;
		try {
			oBonoBean = this.getBonoDAO().getBuscarPorObjecto(bonoBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oBonoBean;
	}

	@Override
	public List<BonoBean> getBuscarPorFiltros(BonoBean bonoBean)
			throws ServiceException {
		List<BonoBean> lstBonoBean=null;
		try {
			System.out.println("en listado premio service imp");
			lstBonoBean=(List<BonoBean>) bonoDAO.getBuscarPorFiltros(bonoBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstBonoBean;
	}

	@Override
	public boolean existe(BonoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public BonoDAO getBonoDAO() {
		return bonoDAO;
	}

	public void setBonoDAO(BonoDAO bonoDAO) {
		this.bonoDAO = bonoDAO;
	}

	
}
