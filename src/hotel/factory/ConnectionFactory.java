package hotel.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSRC;
	
	public ConnectionFactory () {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("Cgtm1298-6.onion");
		
		this.dataSRC = comboPooledDataSource;
	}
	
	public Connection recuperaConexion() {
		try {
			return this.dataSRC.getConnection();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
