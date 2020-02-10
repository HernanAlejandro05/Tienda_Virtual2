package ec.edu.ups.business;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.dao.ClienteDAO;
import ec.edu.ups.dao.DetalleFacturaDAO;
import ec.edu.ups.dao.FacturaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.model.Factura;

@Stateless
public class FacturaON {

	@Inject
	private FacturaDAO factDAO;

	@Inject
	private DetalleFacturaDAO detDAO;

	@Inject
	private ProductoDAO pDAO;
	@Inject
	private ClienteDAO cDAO;
	@Inject
	private EntityManager em;

	public void guardar(Factura fac) {
		factDAO.create(fac);
	}

}
