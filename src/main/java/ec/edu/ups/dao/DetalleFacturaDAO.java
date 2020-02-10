package ec.edu.ups.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.model.DetalleFactura;

@Stateless
public class DetalleFacturaDAO {

	@Inject
	private EntityManager em;

	public void create(DetalleFactura det) {
		em.persist(det);

	}

	public DetalleFactura leer(int codigo) {
		return em.find(DetalleFactura.class, codigo);

	}

	public DetalleFactura leer2(int codigo) {
		DetalleFactura det = em.find(DetalleFactura.class, codigo);
		return det;

	}

	public void delete(int codigo) {

		em.remove(leer(codigo));
	}

	public void update(DetalleFactura det) {
		em.merge(det);

	}
}
