package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ITipoPagoDao;
import pe.edu.upc.entities.TipoPago;
import pe.edu.upc.service.ITipoPagoService;

@Named
@RequestScoped
public class TipoPagoServiceimpl implements ITipoPagoService
{
	@Inject
	private ITipoPagoDao tpDao;
	@Override
	public void insert(TipoPago tpc) 
	{
		tpDao.insert(tpc);// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoPago> list() {
		// TODO Auto-generated method stub
		return tpDao.list();
	}
}
