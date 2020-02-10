package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.CarritoDAO;
import ec.edu.ups.model.Carrito;

@Stateless
public class CarritoON {

	@Inject
	private CarritoDAO carritoDAO;

	public void create(Carrito car) {
		carritoDAO.create(car);
	}

	public Carrito read(int codigo) {
		return carritoDAO.read(codigo);
	}

	public void update(Carrito car) {
		carritoDAO.update(car);
	}

	public void delete(int codigo) {
		carritoDAO.delete(codigo);
	}

	public List<Carrito> listar() {
		return carritoDAO.listar();

	}

}
