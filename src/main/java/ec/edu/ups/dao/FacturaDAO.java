package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Factura;

@Stateless
public class FacturaDAO {

	@Inject
	private EntityManager em;

	public void create(Factura fact) {
		em.persist(fact);

	}

	public Factura read(int codigo) {
		return em.find(Factura.class, codigo);

	}

	public Factura read3(int id) {

		String jpql = "SELECT fact " + "FROM FacturaEN fac " + " WHERE fact.codigo = :a";

		Query q = em.createQuery(jpql, Factura.class);
		q.setParameter("a", id);
		Factura fact = (Factura) q.getSingleResult();

		return fact;

	}

	public List<Factura> getFacturas() {
		String jpql = "SELECT fac FROM FacturaEN fac";

		Query q = em.createQuery(jpql, Factura.class);
		List<Factura> fac = q.getResultList();
		return fac;

	}

//	public void delete (int codigo) {
//		Factura fact = read(codigo);
//		em.remove(fact);
//	}

}
