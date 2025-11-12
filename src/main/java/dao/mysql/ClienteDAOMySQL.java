package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		try {
			// PreparedStatement
			String sql = "INSERT INTO cliente (dni, nombre, telefono, email) VALUES(?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
		}
		return 0;
	}

	@Override
	public int update(Cliente c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Cliente c) {
		// TODO Auto-generated method stub
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
