package br.com.ifood.util;

import java.sql.*;

public class DBConnection {

	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	  public static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

	  public static final String USER = "";

	  public static final String PASSWORD = "";

	protected Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD); //TODO insert credentials
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
