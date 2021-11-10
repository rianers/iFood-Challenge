package br.com.ifood.util;

import java.sql.*;

public class DBManager {

	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	public static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

	public static final String USER = "RM87890";

	public static final String PASSWORD = "Dtnasc#030503";

	public static Connection getConnection() {

		Connection conn = null;

		try {

			Class.forName(DRIVER);

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}