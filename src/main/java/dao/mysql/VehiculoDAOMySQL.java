package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DBConnection;
import dao.interfaces.VehiculoDAO;
import entidades.Vehiculo;

public class VehiculoDAOMySQL implements VehiculoDAO {

	private Connection conexion;
	
	public VehiculoDAOMySQL() {
		conexion = DBConnection.getInstance().getConnection();
	}
	
	@Override
	public int insert(Vehiculo v) {
		// TODO Auto-generated method stub
		int resul = 0;
		try {
			// PreparedStatement
			String sql = "INSERT INTO vehiculo (matricula, marca, modelo) VALUES(?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			// Introducir datos
			pst.setString(1, v.getMatricula());
			pst.setString(2, v.getMarca());
			pst.setString(3, v.getModelo());
			
			resul = pst.executeUpdate();
			System.out.println("> Resultado de la inserción: " + resul);
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return resul;
	}

	@Override
	public int update(Vehiculo v) {
		// TODO Auto-generated method stub
		int resul = 0;
		try {
			// PreparedStatement
			String sql = "UPDATE vehiculo SET marca = ?, modelo = ? WHERE matricula = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			// Introducir datos
			pst.setString(1, v.getMarca());
			pst.setString(2, v.getModelo());
			pst.setString(3, v.getMatricula());
			
			resul = pst.executeUpdate();
			System.out.println("> Resultado de la inserción: " + resul);
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return resul;
	}

	@Override
	public int delete(Vehiculo v) {
		// TODO Auto-generated method stub
		int resul = 0;
		try {
			String sql = "DELETE FROM vehiculo WHERE matricula = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, v.getMatricula());
			
			resul = pst.executeUpdate();
			
			if (resul == 1) {
				System.out.println("> OK: Vehículo con matrícula " + v.getMatricula() + " eliminado correctamente.");
			} else {
				System.out.println("> NOK: Vehículo con matrícula " + v.getMatricula() + " no se encuentra en la base de datos");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public Vehiculo findByMatricula(String matricula) {
		// TODO Auto-generated method stub
		Vehiculo v = null;
		try {
			String sql = "SELECT * FROM vehiculo WHERE matricula = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, matricula);
			
			ResultSet resul = pst.executeQuery();
			
			if (resul.next()) {
				v = new Vehiculo(
						resul.getString("matricula"),
						resul.getString("marca"),
						resul.getString("modelo")
						);
			}
		} catch (SQLException e) {
			System.out.println(">NOK: " + e.getMessage());
		}
		return v;
	}

	@Override
	public ArrayList<Vehiculo> findall() {
		// TODO Auto-generated method stub
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		try {
			String sql = "SELECT * FROM vehiuclo ORDER BY id_vehiculo;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			ResultSet resul = pst.executeQuery();
			
			while (resul.next()) {
				Vehiculo v = new Vehiculo(
						resul.getString("matricula"),
						resul.getString("marca"),
						resul.getString("modelo")
						);
				vehiculos.add(v);
			}
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return vehiculos;
	}

}
