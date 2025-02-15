package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.VotoDAO;
import ec.edu.ups.model.Voto;
import ec.edu.ups.model.objetos.VotoTmp;

@Stateless
public class VotoON {

	@Inject
	private VotoDAO votoDAO;

	public void create(Voto voto) {
		votoDAO.create(voto);
	}

	public Voto read(int codigo) {
		return votoDAO.read(codigo);
	}

	public void update(Voto voto) {
		votoDAO.update(voto);
	}

	public void delete(int codigo) {
		votoDAO.delete(codigo);
	}

	public List<Voto> listar() {
		return votoDAO.listar();
	}

	public List<VotoTmp> listarWS() {
		return votoDAO.listarWS();
	}

	public List<Voto> getVotosPorProducto(String nombre) {
		return votoDAO.getVotosPorProducto(nombre);
	}
}
