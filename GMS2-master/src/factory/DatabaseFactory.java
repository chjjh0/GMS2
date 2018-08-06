package factory;

import java.util.Map;

import enums.Vendor;
import pool.DBConstant;

public class DatabaseFactory {
	public static Database createDataBase(
			Vendor v, String id, String pass) {
		String driver = "",url="";
		Database db = null;
		switch(v) {
		case ORACLE :
			driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new Oracle(driver,url,id,pass);
			break;
		case MARIADB : 
			driver = DBConstant.MARIADB_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new Oracle(driver,url,id,pass);
			break;
		case MYSQL : 
			driver = DBConstant.MYSQL_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new Oracle(driver,url,id,pass);
			break;
		case MSSQL : 
			driver = DBConstant.MSSQL_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new Oracle(driver,url,id,pass);
			break;
		default : break;
		}
		return db;
	}
		public static Database createDataBase2(
				Map<String, ?> map) {
			Database db = null;
			String driver = "",url="";
			switch((Vendor) map.get("vendor")) {
			case ORACLE :
				driver = DBConstant.ORACLE_DRIVER;
				url = DBConstant.CONNECTION_URL;
				db = new Oracle(
						driver,
						url,
						(String) map.get("username"),
						(String) map.get("password"));
				break;
			case MARIADB : 
				db = new Oracle(
						driver,
						url,
						(String) map.get("username"),
						(String) map.get("password"));
				break;
			case MYSQL : 
				db = new Oracle(
						driver,
						url,
						(String) map.get("username"),
						(String) map.get("password"));
				break;
			case MSSQL : 
				db = new Oracle(
						driver,
						url,
						(String) map.get("username"),
						(String) map.get("password"));
				break;
			default : break;
			}
			return db;
			}
		
}