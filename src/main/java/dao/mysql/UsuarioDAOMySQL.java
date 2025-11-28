package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		boolean usuarioRegistrado = false;

		try {
			String sql = "SELECT nombre_usuario, password, rol FROM usuario WHERE dni = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, dni);
			
			try (ResultSet resul = pst.executeQuery()) {
				if (resul.next()) {
					// Rellenar usuario con datos del SELECT
					String passHash = resul.getString("password");
					
					// Comprobar contraseña recibida
					usuarioRegistrado = PasswordUtils.verifyPassword(password, passHash);
				}
			}
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return usuarioRegistrado;
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
		int resul = 0;
		try {
			// PreparedStatement
			String sql = "UPDATE usuario SET nombre_usuario = ?, password = ?, rol = ? WHERE dni = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			// Introducir datos
			pst.setString(1, u.getNombre_usuario());
			pst.setString(2, PasswordUtils.hashPassword(u.getPassword()));
			pst.setString(3, u.getRol());
			pst.setString(4, u.getDni());
			
			resul = pst.executeUpdate();
			System.out.println("> Resultado de la inserción: " + resul);
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return resul;
	}

	@Override
	public int delete(Usuario u) {
		// TODO Auto-generated method stub
		int resul = 0;
		try {
			String sql = "DELETE FROM usuario WHERE dni = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, u.getDni());
			
			resul = pst.executeUpdate();
			
			if (resul == 1) {
				System.out.println("> OK: Usuario con DNI " + u.getDni() + " eliminado correctamente.");
			} else {
				System.out.println("> NOK: Usuario con DNI " + u.getDni() + " no se encuentra en la base de datos");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public Usuario findByNombreUsuario(String nombre_usuario) {
		// TODO Auto-generated method stub
		Usuario u = null;
		try {
			String sql = "SELECT * FROM usuario WHERE nombre_usuario = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, nombre_usuario);
			
			ResultSet resul = pst.executeQuery();
			
			if (resul.next()) {
				u = new Usuario(
						resul.getString("dni"),
						resul.getString("nombre_usuario"),
						resul.getString("password"),
						resul.getString("rol")
						);
			}
		} catch (SQLException e) {
			System.out.println(">NOK: " + e.getMessage());
		}
		return u;
	}
}
