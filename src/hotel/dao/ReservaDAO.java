package hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hotel.model.ReservaModel;

public class ReservaDAO {
	
private Connection connection;
	
	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void guardar(ReservaModel reserva) {
		try {
			String sql = "INSERT INTO reservas (FechaEntrada, FechaSalida, valor, FormaDePago) VALUES (?, ?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pstm.setDate(1, reserva.getfechaE());
				pstm.setDate(2, reserva.getfechaS());
				pstm.setString(3, reserva.getvalor());
				pstm.setString(4, reserva.getformaPago());

				pstm.executeUpdate();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						reserva.setId((long) rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public List<ReservaModel> buscar() {
		List<ReservaModel> reservas = new ArrayList<ReservaModel>();
		try {
			String sql = "SELECT id, FechaEntrada, FechaSalida, valor, FormaDePago FROM reservas";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				transformarResultSetEnReserva(reservas, pstm);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<ReservaModel> buscarId(String id) {
		List<ReservaModel> reservas = new ArrayList<ReservaModel>();
		try {

			String sql = "SELECT id, FechaEntrada, FechaSalida, valor, FormaDePago FROM reservas WHERE id = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, id);
				pstm.execute();

				transformarResultSetEnReserva(reservas, pstm);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public void Eliminar(Integer id) {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM reservas WHERE id = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void Actualizar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE reservas SET FechaEntrada = ?, FechaSalida = ?, valor = ?, FormaDePago = ? WHERE id = ?")) {
			stm.setDate(1, fechaE);
			System.out.println("TBReservas Actualizada: " + fechaE);
			stm.setDate(2, fechaS);
			System.out.println("TBReservas Actualizada: " + fechaS);
			stm.setString(3, valor);
			System.out.println("TBReservas Actualizada: " + valor);
			stm.setString(4, formaPago);
			System.out.println("TBReservas Actualizada: " + formaPago);
			stm.setInt(5, id);
			System.out.println("TBReservas Actualizada: " + id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
						
	private void transformarResultSetEnReserva(List<ReservaModel> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				ReservaModel produto = new ReservaModel((long) rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getString(4), rst.getString(5));

				reservas.add(produto);
			}
		}
	}

}
