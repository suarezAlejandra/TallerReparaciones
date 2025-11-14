package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DBConnection;
import dao.interfaces.ClienteDAO;
import entidades.Cliente;

public class ClienteDAOMySQL implements ClienteDAO {

	private Connection conexion;
	
	public ClienteDAOMySQL() {
		conexion = DBConnection.getInstance().getConnection();
	}
	
	
	@Override
	public int insert(Cliente c) {
		// TODO Auto-generated method stub
		int resul = 0;
		try {
			// PreparedStatement
			String sql = "INSERT INTO cliente (dni, nombre, telefono, email) VALUES(?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			// Introducir datos
			pst.setString(1, c.getDni());
			pst.setString(2, c.getNombre());
			pst.setString(3, c.getTelefono());
			pst.setString(4, c.getEmail());
			
			resul = pst.executeUpdate();
			System.out.println("> Resultado de la inserción: " + resul);
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return resul;
	}

	@Override
	public int update(Cliente c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Cliente c) {
		// TODO Auto-generated method stub
		String sqlDelete = "DELETE FROM cliente WHERE dni = ?;";
		try {
			PreparedStatement pst = conexion.prepareStatement(sqlDelete);
			
			// Borrar cliente
			pst.setString(1, c.getDni());
		} catch (SQLException e) {
			System.out.println("> NOK: Cliente con DNI " + c.getDni() + " no se encuentra en la base de datos.");
		}
		return 0;
	}

	@Override
	public Cliente findByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cliente> findall() {
		// TODO Auto-generated method stub
		return null;
	}
}
