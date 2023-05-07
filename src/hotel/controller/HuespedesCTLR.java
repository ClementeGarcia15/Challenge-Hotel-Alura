package hotel.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import hotel.dao.HuespedesDAO;
import hotel.factory.ConnectionFactory;
import hotel.model.HuespedesModel;
import hotel.model.ReservaModel;

public class HuespedesCTLR {
	 private HuespedesDAO huespedDAO;
	 
	 public HuespedesCTLR() {
			Connection connection = new ConnectionFactory().recuperaConexion();
			this.huespedDAO = new HuespedesDAO(connection);
		}
	 
		public void guardar(HuespedesModel huespedes) {
			this.huespedDAO.guardar(huespedes);
		}
		public List<HuespedesModel> listarHuespedes() {
			return this.huespedDAO.listarHuespedes();
		}
		
		public List<HuespedesModel> listarHuespedesId(String id) {
			return this.huespedDAO.buscarId(id);
		}
		public List<HuespedesModel> listarHuespedesApellido(String apellido) {
			return this.huespedDAO.buscarApellido(apellido);
		}
		
		public void actualizar(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono, Integer idReserva, Integer id) {
			this.huespedDAO.Actualizar(nombre, apellido, fechaN, nacionalidad, telefono, idReserva, id);
		}
		
		public void Eliminar(Integer id) {
			this.huespedDAO.Eliminar(id);
		}
}
