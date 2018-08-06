package factory;

import java.sql.*;

import pool.DBConstant;

public class MariaDB implements Database{

	@Override
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DBConstant.MARIADB_DRIVER);
			conn = DriverManager.getConnection(
					DBConstant.CONNECTION_URL,
					DBConstant.UID,
					DBConstant.PWD
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
