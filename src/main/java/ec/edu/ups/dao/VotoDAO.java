package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Cliente;
import ec.edu.ups.model.Producto;
import ec.edu.ups.model.Voto;
import ec.edu.ups.model.objetos.ClienteTmp;
import ec.edu.ups.model.objetos.VotoTmp;

@Stateless
public class VotoDAO {

	@Inject
	private EntityManager em;

	public void create(Voto voto) {
		em.persist(voto);
	}

	public Voto read(int codigo) {
		return em.find(Voto.class, codigo);
	}

	public void update(Voto voto) {
		em.merge(voto);
	}

	public void delete(int codigo) {
		em.remove(read(codigo));
	}

	public List<Voto> listar() {
		String jpql = "SELECT v FROM Voto v";
		Query q = em.createQuery(jpql, Voto.class);
		List<Voto> votos = q.getResultList();
		return votos;
	}

	public List<VotoTmp> listarWS() {
		String jpql = "SELECT v FROM Voto v";
		Query q = em.createQuery(jpql, Voto.class);
		List<Voto> aux = q.getResultList();
		List<VotoTmp> votos = new ArrayList<>();
		for (Voto voto : aux) {
			Cliente c = voto.getCliente();
			VotoTmp vt = new VotoTmp();
			vt.setCodigo(voto.getCodigo());
			vt.setEstado(voto.isEstado());
			vt.setCliente(new ClienteTmp(c.getCodigo()));
			vt.setProducto(new Producto(voto.getProducto().getCodigo()));
			votos.add(vt);
		}
		return votos;
	}

	public List<Voto> getVotosPorProducto(String nombre) {
		String jpql = "SELECT v FROM Voto v JOIN v.producto p WHERE UPPER(p.nombre) LIKE UPPER(:nombre)";
		Query q = em.createQuery(jpql, Voto.class);
		q.setParameter("nombre", "%" + nombre + "%");
		List<Voto> votos = q.getResultList();
		return votos;
	}
}
