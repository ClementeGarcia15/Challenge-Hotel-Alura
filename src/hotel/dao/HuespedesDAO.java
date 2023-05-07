package hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import hotel.model.HuespedesModel;


public class HuespedesDAO {
private Connection connection;
	
	public HuespedesDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void guardar(HuespedesModel huesped) {
		try {
			String sql = "INSERT INTO huespedes (nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva) VALUES (?, ?, ?, ?,?,?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pstm.setString(1, huesped.getNombre());
				pstm.setString(2, huesped.getApellido());
				pstm.setDate(3, huesped.getFechaNacimiento());
				pstm.setString(4, huesped.getNacionalidad());
				pstm.setString(5, huesped.getTelefono());
				pstm.setInt(6, huesped.getIdReserva());

				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						huesped.setId(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<HuespedesModel> listarHuespedes() {
		List<HuespedesModel> huespedes = new ArrayList<HuespedesModel>();
		try {
			String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva FROM huespedes";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				transformarResultSetEnHuesped(huespedes, pstm);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<HuespedesModel> buscarId(String id) {
		List<HuespedesModel> huespedes = new ArrayList<HuespedesModel>();
		try {

			String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva FROM huespedes WHERE id_reserva = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, id);
				pstm.execute();

				transformarResultSetEnHuesped(huespedes, pstm);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<HuespedesModel> buscarApellido(String apellido) {
		List<HuespedesModel> huesped = new ArrayList<HuespedesModel>();
		try {

			String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva FROM huespedes WHERE apellido = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, apellido);
				pstm.execute();

				transformarResultSetEnHuesped(huesped, pstm);
			}
			return huesped;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void Actualizar(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono, Integer idReserva, Integer id) {
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE huespedes SET nombre = ?, apellido = ?, fecha_nacimiento = ?, nacionalidad = ?, telefono = ?, id_reserva = ? WHERE id = ?")) {
			stm.setString(1, nombre);
			System.out.println("TBHuespedes Actualizada: " + nombre);
			stm.setString(2, apellido);
			System.out.println("TBHuespedes Actualizada: " + apellido);
			stm.setDate(3, fechaN);
			System.out.println("TBHuespedes Actualizada: " + fechaN);
			stm.setString(4, nacionalidad);
			System.out.println("TBHuespedes Actualizada: " + nacionalidad);
			stm.setString(5, telefono);
			System.out.println("TBHuespedes Actualizada: " + telefono);
			stm.setInt(6, idReserva);
			System.out.println("TBHuespedes Actualizada IdReservas: " + idReserva);
			stm.setInt(7, id);
			System.out.println("TBHuespedes Actualizada: " + id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void Eliminar(Integer id) {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM huespedes WHERE id = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void transformarResultSetEnHuesped(List<HuespedesModel> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				HuespedesModel huespedes = new HuespedesModel(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getString(5), rst.getString(6), rst.getInt(7));
				reservas.add(huespedes);
			}
		}				
	}
	
	
		
}

