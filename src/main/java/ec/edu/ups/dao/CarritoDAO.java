package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Carrito;
import ec.edu.ups.model.Tarjeta;

@Stateless
public class CarritoDAO {

	@Inject
	private EntityManager em;

	public void create(Carrito car) {
		em.persist(car);
	}

	public Carrito read(int codigo) {
		return em.find(Carrito.class, codigo);
	}

	public void update(Carrito car) {
		em.merge(car);
	}

	public void delete(int codigo) {
		em.remove(read(codigo));
	}

	public List<Carrito> listar() {
		String jpql = "SELECT car FROM Carrito car";
		Query q = em.createQuery(jpql, Tarjeta.class);
		List<Carrito> productos = q.getResultList();
		return productos;
	}

}
