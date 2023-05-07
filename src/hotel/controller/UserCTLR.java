package hotel.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hotel.factory.ConnectionFactory;

public class UserCTLR {
	
	public boolean IniciaSesion(String user, String pass) throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexion();
		PreparedStatement statement = con.prepareStatement("SELECT USER, PASS FROM USERS = ? AND PASS = ?");
		statement.setString(1, user);
		statement.setString(1, pass);
		
		statement.execute();
		
		ResultSet rs = statement.getResultSet();
		
		boolean isLogged;
		
		if(rs.next()) {
			isLogged = true;
		}else {
			isLogged = false;
		}
		
		return isLogged;
		
	}

}
