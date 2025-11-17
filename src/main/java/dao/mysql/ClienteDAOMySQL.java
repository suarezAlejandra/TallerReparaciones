package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		int resul = 0;
		try {
			String sql = "UPDATE cliente SET nombre = ?, telefono = ?, email = ? WHERE dni = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(3, c.getNombre());
			pst.setString(4, c.getTelefono());
			pst.setString(5,  c.getEmail());
			
			resul = pst.executeUpdate();
			System.out.println("> Resultado de la actualización: " + resul);
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return resul;
	}

	@Override
	public int delete(Cliente c) {
		// TODO Auto-generated method stub
		int resul = 0;
		try {
			String sql = "DELETE FROM cliente WHERE dni = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, c.getDni());
			
			resul = pst.executeUpdate();
			System.out.println("> Resultado del borrado: " + resul);
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return resul;
	}

	@Override
	public Cliente findByDni(String dni) {
		// TODO Auto-generated method stub
		Cliente c = null;
		try {
			String sql = "SELECT * FROM cliente WHERE dni = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, dni);
			
			ResultSet resul = pst.executeQuery();
			
			if (resul.next()) {
				c = new Cliente(
						resul.getString("dni"),
						resul.getString("nombre"),
						resul.getString("telefono"),
						resul.getString("email")
						);
			}
		} catch (SQLException e) {
			System.out.println(">NOK: " + e.getMessage());
		}
		return c;
	}

	@Override
	public ArrayList<Cliente> findall() {
		// TODO Auto-generated method stub
		ArrayList<Cliente> clientes = new ArrayList<>();
		try {
			String sql = "SELECT * FROM cliente ORDER BY id_cliente;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			ResultSet resul = pst.executeQuery();
			
			while (resul.next()) {
				Cliente c = new Cliente(
						resul.getString("dni"),
						resul.getString("nombre"),
						resul.getString("telefono"),
						resul.getString("email")
						);
				clientes.add(c);
			}
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return clientes;
	}
}
