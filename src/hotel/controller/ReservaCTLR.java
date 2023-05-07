package hotel.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import hotel.model.ReservaModel;
import hotel.dao.ReservaDAO;
import hotel.factory.ConnectionFactory;

public class ReservaCTLR {
	private ReservaDAO ReservaDAO;

public ReservaCTLR() {
		Connection connection = new ConnectionFactory().recuperaConexion();
		this.ReservaDAO=new ReservaDAO(connection);
	}

	public void guardar(ReservaModel reserva) {
		this.ReservaDAO.guardar(reserva);
	}

	public List<ReservaModel> buscar() {
		return this.ReservaDAO.buscar();
	}

	public List<ReservaModel> buscarId(String id) {
		return this.ReservaDAO.buscarId(id);
	}

	public void actualizar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
		this.ReservaDAO.Actualizar(fechaE, fechaS, valor, formaPago, id);
	}

	public void Eliminar(Integer id) {
		this.ReservaDAO.Eliminar(id);
	}

}
