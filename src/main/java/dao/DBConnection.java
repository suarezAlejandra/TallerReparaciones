package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DBConnection {
	public static DBConnection instance;
	
	Connection conexionMySQL = null;
	
	private DBConnection() {
		try {
			// Instanciar un datasource para que nos devuelva una conexión
			MysqlDataSource datasource = new MysqlDataSource();
			
			datasource.setServerName("localhost");
			datasource.setPortNumber(3306);
			datasource.setDatabaseName("taller");
			datasource.setUser("root");
			datasource.setPassword("root");
			
			// Pasar propiedades con FileInputStream
			Properties propiedades = new Properties();
			FileInputStream file;
			file = new FileInputStream("src\\main\\resources\\conexion.properties");
			
			try {
				propiedades.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			datasource.setUrl(propiedades.getProperty("url"));
			datasource.setUser(propiedades.getProperty("user"));
			datasource.setPassword(propiedades.getProperty("password"));
			
			// MAIN
			conexionMySQL = datasource.getConnection();
			System.out.println("> Conexión establecida correctamente");
			
		} catch (SQLException | IOException e) {
			System.err.println("> Error al conectar con MySQL: " + e.getMessage());
		}
	}
	
	public static DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return conexionMySQL;
	}
}
