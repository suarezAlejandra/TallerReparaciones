package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DBConnection;
import dao.interfaces.UsuarioDAO;
import entidades.Usuario;

public class UsuarioDAOMySQL implements UsuarioDAO {

	private Connection conexion;
	
	public UsuarioDAOMySQL() {
		conexion = DBConnection.getInstance().getConnection();
	}
	
	@Override
	public boolean login(String dni, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insert(Usuario u) {
		// TODO Auto-generated method stub
		int resul = 0;
		try {
			// PreparedStatement
			String sql = "INSERT INTO usuario (dni, nombre_usuario, password, rol) VALUES(?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			// Introducir datos
			pst.setString(1, u.getDni());
			pst.setString(2, u.getNombre_usuario());
			pst.setString(3, PasswordUtils.hashPassword(u.getPassword()));
			pst.setString(4, u.getRol());
			
			resul = pst.executeUpdate();
			System.out.println("> Resultado de la inserción: " + resul);
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return resul;
	}

	@Override
	public int update(Usuario u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Usuario u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario findByNombreUsuario(String nombre_usuario) {
		// TODO Auto-generated method stub
		return null;
	}
}
